package com.whimsy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.whimsy.entity.TCouponDetailed;
import com.whimsy.entity.TIntegration;
import com.whimsy.entity.TMemberCard;
import com.whimsy.entity.TMsgCode;
import com.whimsy.service.TCouponDetailedService;
import com.whimsy.service.TDepartmentService;
import com.whimsy.service.TIntegrationService;
import com.whimsy.service.TMemberCardService;
import com.whimsy.service.TMsgCodeService;
import com.whimsy.util.ParametersUtil;
import com.whimsy.util.SMSinterface;
import com.whimsy.util.WechatUtil;
import com.whimsy.util.tokenSign;

@Controller
public class UsersController {
	@Autowired
	private TMemberCardService tmService;
	
	@Autowired
	private TMsgCodeService tmcService;
	
	@Autowired
	private TCouponDetailedService tcdService;
	
	@Autowired
	private TDepartmentService tdService;
	
	@Autowired
	private TIntegrationService tiService;
	
	// 获取验证码
	@RequestMapping("freshshop/getMsgCode")
	public void getMsgCode(HttpServletRequest request, HttpServletResponse response,TMemberCard tMemberCard,TMsgCode tMsgCode) throws Exception {
		PrintWriter pw = null;
		String jmobilenumber = request.getParameter("jmobilenumber");
		String jwechat = request.getParameter("jwechat");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		tMemberCard.setJmobilenumber(jmobilenumber);
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jmobilenumber)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "手机号不能为空！");
				resultList.add(resultMap);
			} else {
				if(jmobilenumber.length() != 11){
					resultMap.put("data", "");
					resultMap.put("code", "100002");
					resultMap.put("message", "请输入正确的11位手机号码！");
					resultList.add(resultMap);
				}else{
					String msgCode = "";
					for(int i = 0;i<=3;i++){
						Random rand = new Random();
						msgCode = msgCode + rand.nextInt(9);
					}
					String result = SMSinterface.send(jmobilenumber, msgCode);
					if (result.equals("0")) {
						tMsgCode.setjPhone(jmobilenumber);
						tMsgCode.setjCode(msgCode);
						SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
						tMsgCode.setjData(df.format(new Date()).toString());
						int inCode = this.tmcService.insertCode(tMsgCode);
						if(inCode == 1){
							TMemberCard phoneresult = this.tmService.verRigester(tMemberCard);
							Map<String, String> dataMap = new HashMap<String, String>();
							if(phoneresult != null){
								if (!StringUtils.isEmpty(jwechat)) {
									resultMap.put("data", dataMap);
									resultMap.put("code", "100002");
									resultMap.put("message", "此手机号已经注册过账号！");
									resultList.add(resultMap);
								}else {
									dataMap.put("msgCode", msgCode);
									dataMap.put("state", "00");
									resultMap.put("data", dataMap);
									resultMap.put("code", "100000");
									resultMap.put("message", "success");//登录
									resultList.add(resultMap);
								}
							}else{
								dataMap.put("msgCode", msgCode);
								dataMap.put("state", "11");
								resultMap.put("data", dataMap);
								resultMap.put("code", "100000");
								resultMap.put("message", "success");//注册
								resultList.add(resultMap);
							}
						}else{
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "插入数据库失败！");
							resultList.add(resultMap);
						}
					} else {
						Map<String, Object> dataMap = new HashMap<String, Object>();
						dataMap.put("data", result);
						resultMap.put("data", dataMap);
						resultMap.put("code", "100002");
						resultMap.put("message", "发送失败！");
						resultList.add(resultMap);
					}
				}
			}
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "服务器异常，请稍后重试！");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
	//手机号 注册 and 登录
	@RequestMapping("freshshop/phoneRigester")
	public void rigester(HttpServletRequest request, HttpServletResponse response,TMemberCard tMemberCard,TMsgCode tMsgCode,TCouponDetailed tCouponDetailed) {
		PrintWriter pw = null;
		String jmobilenumber = request.getParameter("jmobilenumber");
		String jempname = request.getParameter("jempname");
		String msgCode = request.getParameter("msgCode");
		String rol = request.getParameter("rol");
		String jtoken = request.getParameter("jtoken");
		String jwechat = request.getParameter("jwechat");
		Map<String, Object> params = ParametersUtil.getParameters(request.getParameterMap());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		tMemberCard.setJmobilenumber(jmobilenumber);
		tMemberCard.setJwechat(jwechat);
		SimpleDateFormat dfc = new SimpleDateFormat("yyyyMMdd");
		String data = dfc.format(new Date()).toString();
		try {
			pw = response.getWriter();
			if (!StringUtils.isEmpty(jtoken)) {
				tMemberCard.setJtoken(jtoken);
				TMemberCard gToken = this.tmService.getToken(tMemberCard);
				if(gToken != null){
					if(!gToken.getJsigndata().equals("")){
						if(Integer.parseInt(data)>Integer.parseInt(gToken.getJsigndata())){
							gToken.setJifsign("false");
						}
					}
					TCouponDetailed num = this.tcdService.CouponNumber(gToken.getJid());
					if(num == null){
						gToken.setJcouponcount(new BigDecimal(0));
					}else{
						gToken.setJcouponcount(num.getJnumber());
					}
					resultMap.put("data", gToken);
					resultMap.put("code", "100000");
					resultMap.put("message", "success");
					resultList.add(resultMap);
				}else{
					resultMap.put("data", gToken);
					resultMap.put("code", "100002");
					resultMap.put("message", "Token验证失败，重新登陆！");
					resultList.add(resultMap);
				}
			} else{
				/*if (!StringUtils.isEmpty(jwechat)) {
					TMemberCard sewechat = this.tmService.verRigester(tMemberCard).selectWechat(tMemberCard);
					if(sewechat != null){
						resultMap.put("code", "100002");
						resultMap.put("message", "此手机号已经注册过！");
						resultList.add(resultMap);
					}else{
						
					}
				}else{*/
					//查询验证码
					tMsgCode.setjPhone(jmobilenumber);
					tMsgCode.setjCode(msgCode);
					TMsgCode msgCodes = this.tmcService.selectCode(tMsgCode);
					String mCode = msgCodes.getjCode();
					long mData = Long.parseLong(msgCodes.getjData());
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					long nowData = Long.parseLong(df.format(new Date()).toString());
					//删除验证码
					this.tmcService.deleteCode(tMsgCode);
					if (rol.equals("00")) {
						if (StringUtils.isEmpty(jmobilenumber)) {
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "手机号不能为空！");
							resultList.add(resultMap);
						} else if (!mCode.equals(msgCode)) {
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "验证码错误！");
							resultList.add(resultMap);
						} else if (StringUtils.isEmpty(mCode)) {
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "请重新发送验证码！");
							resultList.add(resultMap);
						} else if (nowData-mData >= 60) {
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "验证码已过期！");
							resultList.add(resultMap);
						} else{
							//重新生成token
							tMemberCard.setJmobilenumber(jmobilenumber);
							Map<String, String> tdataMap = new HashMap<String, String>();
							long t1 = System.currentTimeMillis();
							String sR=Long.toString(t1) + jmobilenumber;
							tdataMap.put("data", sR);
							String tokenSigns = tokenSign.createSign(tdataMap, true);
							tMemberCard.setJtoken(tokenSigns);
							//token插入数据库
							int upToken = this.tmService.updataToken(tMemberCard);
							if(upToken == 1){
								TMemberCard gToken = this.tmService.getToken(tMemberCard);
								if(gToken != null){
									if(!gToken.getJsigndata().equals("")){
										if(Integer.parseInt(data)>Integer.parseInt(gToken.getJsigndata())){
											gToken.setJifsign("false");
										}
									}
									TCouponDetailed num = this.tcdService.CouponNumber(gToken.getJid());
									if(num == null){
										gToken.setJcouponcount(new BigDecimal(0));
									}else{
										gToken.setJcouponcount(num.getJnumber());
									}
									resultMap.put("data", gToken);
									resultMap.put("code", "100000");
									resultMap.put("message", "success");
									resultList.add(resultMap);
								}else{
									resultMap.put("data", gToken);
									resultMap.put("code", "100002");
									resultMap.put("message", "登陆失败，重新登陆！");
									resultList.add(resultMap);
								}
							}else{
								resultMap.put("data", "");
								resultMap.put("code", "100002");
								resultMap.put("message", "登陆失败，重新登陆！");
								resultList.add(resultMap);
							}
						}
					} else{
						tMemberCard.setJempcode(jmobilenumber);
						tMemberCard.setJempname(jempname);
						if (!mCode.equals(msgCode)) {
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "验证码错误！");
							resultList.add(resultMap);
						} else if (StringUtils.isEmpty(mCode)) {
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "请重新发送验证码！");
							resultList.add(resultMap);
						} else if (nowData-mData >= 60) {
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "验证码已过期！");
							resultList.add(resultMap);
						} else{
							//重新生成token
							tMemberCard.setJmobilenumber(jmobilenumber);
							Map<String, String> tdataMap = new HashMap<String, String>();
							long t1 = System.currentTimeMillis();
							String sR=Long.toString(t1) + jmobilenumber;
							tdataMap.put("data", sR);
							String tokenSigns = tokenSign.createSign(tdataMap, true);
							tMemberCard.setJtoken(tokenSigns);
							tMemberCard.setJstateid(0);
							tMemberCard.setJnouse(true);
							//用户信息插入数据库
							int upToken = this.tmService.rigester(tMemberCard);
							if(upToken == 1){
								TMemberCard gToken = this.tmService.getToken(tMemberCard);
								if(gToken != null){
									if(!gToken.getJsigndata().equals("")){
										if(Integer.parseInt(data)>Integer.parseInt(gToken.getJsigndata())){
											gToken.setJifsign("false");
										}
									}
									TCouponDetailed num = this.tcdService.CouponNumber(gToken.getJid());
									if(num == null){
										gToken.setJcouponcount(new BigDecimal(0));
									}else{
										gToken.setJcouponcount(num.getJnumber());
									}
									resultMap.put("data", gToken);
									resultMap.put("code", "100000");
									resultMap.put("message", "success");
									resultList.add(resultMap);
								}else{
									resultMap.put("data", gToken);
									resultMap.put("code", "100002");
									resultMap.put("message", "登陆失败，重新登陆！");
									resultList.add(resultMap);
								}
							}else{
								resultMap.put("data", "");
								resultMap.put("code", "100002");
								resultMap.put("message", "登陆失败，重新登陆！");
								resultList.add(resultMap);
							}
						}
					}
				
				
			}
			
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "服务器异常，请稍后重试！");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
	//微信 注册 and 登录
	@RequestMapping("freshshop/wechat")
	public void wechat(HttpServletRequest request, HttpServletResponse response,TMemberCard tMemberCard,TMsgCode tMsgCode) {
		PrintWriter pw = null;
		String code = request.getParameter("code");
		Map<String, Object> params = ParametersUtil.getParameters(request.getParameterMap());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> reMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
			String param = "appid=wx7b584c96a6581681&secret=43d6a8b810d883c1009b5ca17ca2f659&code="+code+"&grant_type=authorization_code";
			String aa = WechatUtil.sendPost(url, param);
			JSONObject jsStr = JSONObject.parseObject(aa);
			if(jsStr.get("openid") != null){
				tMemberCard.setJwechat((String)jsStr.get("openid"));
				TMemberCard sewechat = this.tmService.selectWechat(tMemberCard);
				if(sewechat == null){
					reMap.put("iszhuce", 1);
					reMap.put("openid", jsStr.get("openid"));
					resultMap.put("data", reMap);
					resultMap.put("code", "100000");
					resultMap.put("message", "注册！");
					resultList.add(resultMap);
				}else{
					reMap.put("iszhuce", 0);
					reMap.put("jtoken",sewechat.getJtoken());
					resultMap.put("data", reMap);
					resultMap.put("code", "100000");
					resultMap.put("message", "登录！");
					resultList.add(resultMap);
				}
			}else{
				resultMap.put("data", aa);
				resultMap.put("code", "100002");
				resultMap.put("message", "打开微信失败");
			}
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "服务器异常，请稍后重试！");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
	//小程序微信 注册 and 登录
	@RequestMapping("freshshop/libwechat")
	public void libwechat(HttpServletRequest request, HttpServletResponse response,TMemberCard tMemberCard,TMsgCode tMsgCode) {
		PrintWriter pw = null;
		String openid = request.getParameter("openid");
		Map<String, Object> params = ParametersUtil.getParameters(request.getParameterMap());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> reMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			tMemberCard.setJwechat(openid);
			TMemberCard sewechat = this.tmService.selectWechat(tMemberCard);
			if(sewechat == null){
				reMap.put("iszhuce", 1);
				reMap.put("openid","" );
				resultMap.put("data", reMap);
				resultMap.put("code", "100000");
				resultMap.put("message", "注册！");
				resultList.add(resultMap);
			}else{
				reMap.put("iszhuce", 0);
				reMap.put("jtoken",sewechat.getJtoken());
				resultMap.put("data", reMap);
				resultMap.put("code", "100000");
				resultMap.put("message", "登录！");
				resultList.add(resultMap);
			}
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "服务器异常，请稍后重试！");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
	//打开个人信息
	@RequestMapping("freshshop/personal")
	public void personal(HttpServletRequest request, HttpServletResponse response,TMemberCard tMemberCard,TMsgCode tMsgCode) {
		PrintWriter pw = null;
		String jtoken = request.getParameter("jtoken");
		Map<String, Object> params = ParametersUtil.getParameters(request.getParameterMap());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		SimpleDateFormat dfc = new SimpleDateFormat("yyyyMMdd");
		String data = dfc.format(new Date()).toString();
		try {
			pw = response.getWriter();
			if (!StringUtils.isEmpty(jtoken)) {
				tMemberCard.setJtoken(jtoken);
				TMemberCard gToken = this.tmService.getToken(tMemberCard);
				if(gToken != null){
					if(!gToken.getJsigndata().equals("")){
						if(Integer.parseInt(data)>Integer.parseInt(gToken.getJsigndata())){
							gToken.setJifsign("false");
						}
					}
					TCouponDetailed num = this.tcdService.CouponNumber(gToken.getJid());
					if(num == null){
						gToken.setJcouponcount(new BigDecimal(0));
					}else{
						gToken.setJcouponcount(num.getJnumber());
					}
					resultMap.put("data", gToken);
					resultMap.put("code", "100000");
					resultMap.put("message", "success");
					resultList.add(resultMap);
				}else{
					resultMap.put("data", gToken);
					resultMap.put("code", "100002");
					resultMap.put("message", "Token验证失败，重新登陆！");
					resultList.add(resultMap);
				}
			}
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "服务器异常，请稍后重试！");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
	//绑定微信
	@RequestMapping("freshshop/bindWechat")
	public void bindWechat(HttpServletRequest request, HttpServletResponse response,TMemberCard tMemberCard,TMsgCode tMsgCode) {
		PrintWriter pw = null;
		String code = request.getParameter("openid");
		String jmobilenumber = request.getParameter("jmobilenumber");
		Map<String, Object> params = ParametersUtil.getParameters(request.getParameterMap());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> reMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		tMemberCard.setJmobilenumber(jmobilenumber);
		try {
			pw = response.getWriter();
			TMemberCard phoneSer = this.tmService.phoneSer(tMemberCard);
			if(!phoneSer.getJwechat().equals("")){
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "此手机号已经与微信号绑定！");
				resultList.add(resultMap);
			}else{
				String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
				String param = "appid=wx7b584c96a6581681&secret=43d6a8b810d883c1009b5ca17ca2f659&code="+code+"&grant_type=authorization_code";
				String aa = WechatUtil.sendPost(url, param);
				JSONObject jsStr = JSONObject.parseObject(aa);
				if(jsStr.get("openid") != null){
					tMemberCard.setJwechat((String)jsStr.get("openid"));
					//微信更新入数据库
					int upToken = this.tmService.updataToken(tMemberCard);
					if(upToken == 1){
						resultMap.put("data", "");
						resultMap.put("code", "100000");
						resultMap.put("message", "success");
						resultList.add(resultMap);
						
					}else{
						resultMap.put("data", "");
						resultMap.put("code", "100002");
						resultMap.put("message", "绑定失败，重新绑定！");
						resultList.add(resultMap);
					}
				}else{
					resultMap.put("data", aa);
					resultMap.put("code", "100002");
					resultMap.put("message", "打开微信失败");
				}
			}
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "服务器异常，请稍后重试！");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}	
	// 签到
	@RequestMapping("freshshop/Sign")
	public void Sign(HttpServletRequest request, HttpServletResponse response,TMemberCard tMemberCard,TMsgCode tMsgCode,TIntegration tIntegration) throws Exception {
		PrintWriter pw = null;
		String jid = request.getParameter("jid");
		/*String jdepartmentid = request.getParameter("jdepartmentid");*/
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "手机号不能为空！");
				resultList.add(resultMap);
			} else {
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
				String data = df.format(new Date()).toString();
				tMemberCard.setJid(Integer.parseInt(jid));
				tMemberCard.setJsigndata(data);
				int sign = this.tmService.Sign(tMemberCard);
				if(sign == 1){
					//查询剩余积分数
					TMemberCard num = this.tmService.getInte(Integer.parseInt(jid));
					//查询店铺签到获得积分数
					/*TDepartment getsign = this.tdService.selectSign(Integer.parseInt(jdepartmentid));*/
					
					tMemberCard.setJendqty(num.getJendqty().add(new BigDecimal("5")));
					
					//插入积分明细表
					SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String data1 = df1.format(new Date()).toString();
					tIntegration.setjData(data1);
					tIntegration.setjMembercardId(Integer.parseInt(jid));
					tIntegration.setjType("签到");
					tIntegration.setjUpcoupon((long) 5);
					this.tiService.insertIn(tIntegration);
					
					this.tmService.updateIn(tMemberCard);
					
					resultMap.put("data", sign);
					resultMap.put("code", "100000");
					resultMap.put("message", "seccess");
				}else{
					resultMap.put("data", sign);
					resultMap.put("code", "100002");
					resultMap.put("message", "签到失败！");
				}
			}
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "服务器异常，请稍后重试！");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
	// 微信登录
	/*@RequestMapping("freshshop/wechat")
	public void wechat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter pw = null;
		String code = request.getParameter("code");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
			String param = "appid=wx7b584c96a6581681&secret=43d6a8b810d883c1009b5ca17ca2f659&code="+code+"&grant_type=authorization_code";
			String aa = WechatUtil.sendPost(url, param);
			JSONObject jsStr = JSONObject.parseObject(aa);
			if((boolean)jsStr.get("openid")){
				
			}else{
				
			}
			resultMap.put("data", aa);
			resultMap.put("code", "100000");
			resultMap.put("message", "seccess");
			resultList.add(resultMap);
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "服务器异常，请稍后重试！");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}*/
	//查看积分明细
	@RequestMapping("freshshop/getIntegral")
	public void getIntegral(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter pw = null;
		String code = request.getParameter("code");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
			String param = "appid=wx7b584c96a6581681&secret=43d6a8b810d883c1009b5ca17ca2f659&code="+code+"&grant_type=authorization_code";
			String aa = WechatUtil.sendPost(url, param);
			resultMap.put("data", aa);
			resultMap.put("code", "100000");
			resultMap.put("message", "seccess");
			resultList.add(resultMap);
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "服务器异常，请稍后重试！");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
}
