package com.whimsy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.whimsy.entity.TActivity;
import com.whimsy.entity.TBasicSort;
import com.whimsy.entity.TCouponDetailed;
import com.whimsy.entity.TDeliveryAddress;
import com.whimsy.entity.TDepartment;
import com.whimsy.entity.TGoods;
import com.whimsy.entity.TMemberCard;
import com.whimsy.entity.TOrderDetailed;
import com.whimsy.service.TActivityService;
import com.whimsy.service.TBasicSortService;
import com.whimsy.service.TCouponDetailedService;
import com.whimsy.service.TDeliveryAddressService;
import com.whimsy.service.TDepartmentService;
import com.whimsy.service.TGoodsService;
import com.whimsy.service.TMemberCardService;
import com.whimsy.service.TOrderDetailedService;
import com.whimsy.service.TShopCartService;
import com.whimsy.util.BigdecimalUtil;
import com.whimsy.util.PayCommonUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class OrderController {
	
	@Autowired
	private TBasicSortService tbService;
	
	@Autowired
	private TActivityService tActService;
	
	@Autowired
	private TGoodsService tgsService;
	
	@Autowired
	private TMemberCardService tmService;
	
	@Autowired
	private TDepartmentService tdService;
	
	@Autowired
	private TCouponDetailedService tcdService;
	
	@Autowired
	private TDeliveryAddressService tdaService;
	
	@Autowired
	private TOrderDetailedService orderService;
	
	@Autowired
	private TShopCartService tscService;
	
	//���ɶ���
	@RequestMapping("freshshop/setOrder")
	public void setOrder(HttpServletRequest request, HttpServletResponse response,TOrderDetailed tOrderDetailed,TCouponDetailed tCouponDetailed) throws ParseException {
		PrintWriter pw = null;
		String jgoods = request.getParameter("jgoods");
		System.out.println(jgoods);
		String jdepartmentid = request.getParameter("jdepartmentid");
		String jmembercardid = request.getParameter("jmembercardid");
		String jaddressid = request.getParameter("jaddressid");
		String iffreight = request.getParameter("iffreight");
		String coupon = request.getParameter("coupon");
		String ifscore = request.getParameter("ifscore");
		String ifmembercard = request.getParameter("ifmembercard");
		String jpayment = request.getParameter("jpayment");
		String jtime = request.getParameter("jtime");
		BigDecimal jmoney = new BigDecimal(0);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		//����json��ʽ����Ʒ
		JSONArray jgood = JSONArray.fromObject(jgoods);
		String userId = jdepartmentid + request.getParameter("jmembercardid")+System.currentTimeMillis()+10000;
        String jordercode = userId.substring(0,16);
		try {
			pw = response.getWriter();
			if(!StringUtils.isEmpty(jtime)){
				tOrderDetailed.setjTime(jtime);
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String data = df.format(new Date());
			Date dates = df.parse(data); 
			tOrderDetailed.setjBegintime(dates);
			//������Ʒ�ܼ�
			if(jgood.size() > 0){
				for(int i=0;i<jgood.size();i++){
					TActivity goods = this.tActService.getifGoods(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")),Integer.parseInt(jdepartmentid));
					if(goods == null){
						TMemberCard ifmember = this.tmService.getInte(Integer.parseInt(jmembercardid));
						if(ifmember.getJnouse().booleanValue()){
							TGoods good = this.tgsService.getGoodsDetails(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
							BigDecimal goodmoney = new BigDecimal(BigdecimalUtil.mul(good.getJpointsaleprice().doubleValue(), Double.parseDouble(jgood.getJSONObject(i).optString("jgoodsnumber").toString())));
							jmoney = new BigDecimal(BigdecimalUtil.add(jmoney.doubleValue(), goodmoney.doubleValue()));
						}else{
							TGoods good = this.tgsService.getGoodsDetails(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
							BigDecimal goodmoney = new BigDecimal(BigdecimalUtil.mul(good.getJsale3price().doubleValue(), Double.parseDouble(jgood.getJSONObject(i).optString("jgoodsnumber").toString())));
							jmoney = new BigDecimal(BigdecimalUtil.add(jmoney.doubleValue(), goodmoney.doubleValue()));
						}
					}else if(goods.getJdiscount().equals(BigDecimal.ZERO)){
						BigDecimal goodmoney = new BigDecimal(BigdecimalUtil.mul(goods.getJactprice().doubleValue(), Double.parseDouble(jgood.getJSONObject(i).optString("jgoodsnumber").toString())));
						jmoney = new BigDecimal(BigdecimalUtil.add(jmoney.doubleValue(), goodmoney.doubleValue()));
					}else{
						TGoods good = this.tgsService.getGoodsDetails(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
						BigDecimal goodmoney = new BigDecimal(BigdecimalUtil.mul(good.getJpointsaleprice().multiply(goods.getJdiscount()).doubleValue(), Double.parseDouble(jgood.getJSONObject(i).optString("jgoodsnumber").toString())));
						jmoney = new BigDecimal(BigdecimalUtil.add(jmoney.doubleValue(), goodmoney.doubleValue()));
					}
					
				}
			}
			System.out.println(jmoney);
			tOrderDetailed.setjAllmoney(jmoney.setScale(2,BigDecimal.ROUND_HALF_UP));
			//�����Ƿ������ͷ�
			TDepartment peisong = this.tdService.selectPeisong(Integer.parseInt(jdepartmentid));
			if(peisong != null){
				BigDecimal aa = new BigDecimal(BigdecimalUtil.sub(jmoney.doubleValue(),peisong.getJfullrmb().doubleValue()));
				if(aa.compareTo(BigDecimal.ZERO)==-1){
					if(iffreight.equals("1")){
						resultMap.put("data", "");
			        	resultMap.put("code", "100002");
						resultMap.put("message", "�ﲻ�������ͷѵ�Ҫ��");
					}else{
						jmoney = new BigDecimal(BigdecimalUtil.add(jmoney.doubleValue(), peisong.getJreduce().doubleValue()));
						tOrderDetailed.setjIffreight(peisong.getJreduce());
						//�����Ƿ�ʹ���Ż�ȯ
						if(!coupon.equals("0")){
							TCouponDetailed coup = this.tcdService.getorderCoupon(Integer.parseInt(coupon));
							if(coup != null){
								if(jmoney.compareTo(coup.getjFulln()) == 1){
									jmoney = new BigDecimal(BigdecimalUtil.sub(jmoney.doubleValue(),coup.getjQuota().doubleValue()));
									tOrderDetailed.setjIfcoupon(coup.getjQuota());
									tOrderDetailed.setjCopId(Integer.parseInt(coupon));
									//�޸��Ż�ȯ״̬
									tCouponDetailed.setjId(Integer.parseInt(coupon));
									tCouponDetailed.setjState("0");
									this.tcdService.upcoup(tCouponDetailed);
									//�����Ƿ�ʹ�û���
									if(ifscore.equals("1")){
						        		//��ѯʣ�������
										TMemberCard num = this.tmService.getInte(Integer.parseInt(jmembercardid));
										//��ѯ�������һ�RMB��
										TDepartment getScore = this.tdService.selectScore(Integer.parseInt(jdepartmentid));
										if(getScore.getJscoreforrmb().compareTo(new BigDecimal(0))==0){
											BigDecimal usescore = new BigDecimal(0);
											tOrderDetailed.setjIfscore(new BigDecimal(0));
										}else{
											BigDecimal aaa = new BigDecimal(BigdecimalUtil.div(num.getJendqty().doubleValue(),getScore.getJscoreforrmb().doubleValue(),2));
											if(aaa.compareTo(jmoney)!=-1){
												BigDecimal usescore = new BigDecimal(BigdecimalUtil.mul(jmoney.doubleValue(),getScore.getJscoreforrmb().doubleValue()));
												/*BigDecimal yuscore = num.getJendqty().subtract(usescore);*/
												tOrderDetailed.setjIfscore(jmoney.setScale(2,BigDecimal.ROUND_HALF_UP));
												jmoney = new BigDecimal(0);
											}else{
												BigDecimal usescore = num.getJendqty();
												/*BigDecimal yuscore = new BigDecimal(0);*/
												jmoney = new BigDecimal(BigdecimalUtil.sub(jmoney.doubleValue(),aaa.doubleValue()));
												tOrderDetailed.setjIfscore(aaa.setScale(2,BigDecimal.ROUND_HALF_UP));
											}
										}
						        	}else{
						        		tOrderDetailed.setjIfscore(new BigDecimal(0));
						        	}
									//����ʹ�û�Ա�����
									if(jmoney.compareTo(BigDecimal.ZERO)==1){
										if(ifmembercard.equals("1")){
											//��ѯʣ���Ա�����
											TMemberCard fillamt = this.tmService.getInte(Integer.parseInt(jmembercardid));
											if(fillamt.getJendfillamt().compareTo(jmoney)==-1){
												BigDecimal useamt = fillamt.getJendfillamt();
												/*BigDecimal yuamt = new BigDecimal(0);*/
												jmoney = new BigDecimal(BigdecimalUtil.sub(jmoney.doubleValue(),fillamt.getJendfillamt().doubleValue()));
												tOrderDetailed.setjIfmembercard(useamt.setScale(2,BigDecimal.ROUND_HALF_UP));
											}else{
												BigDecimal useamt = jmoney;
												/*BigDecimal yuamt = fillamt.getJendfillamt().subtract(jmoney);*/
												jmoney = new BigDecimal(0);
												tOrderDetailed.setjIfmembercard(useamt.setScale(2,BigDecimal.ROUND_HALF_UP));
											}
										}else{
											tOrderDetailed.setjIfmembercard(new BigDecimal(0));
										}
									}else{
										tOrderDetailed.setjIfmembercard(new BigDecimal(0));
									}
									if(!StringUtils.isEmpty(jordercode)){
							        	tOrderDetailed.setjOrdercode(jordercode);
							        }
							        if(!StringUtils.isEmpty(jdepartmentid)){
							        	tOrderDetailed.setjDeptId(Integer.parseInt(jdepartmentid));
							        }
							        if(!StringUtils.isEmpty(jmembercardid)){
							        	tOrderDetailed.setjMembercardId(Integer.parseInt(jmembercardid));
							        }
							        //��ѯ�ͻ���ַ
							        TDeliveryAddress address = this.tdaService.getorderAddress(Integer.parseInt(jaddressid));
							        if(address != null){
							        	tOrderDetailed.setjAddress(address.getjAddress()+address.getjAddressDetailed());
							        	tOrderDetailed.setjState("0");
								        tOrderDetailed.setjPayment(jpayment);
								        tOrderDetailed.setjMoney(jmoney.setScale(2,BigDecimal.ROUND_HALF_UP));
								        //���ɶ���
								        int ord = this.orderService.setOrder(tOrderDetailed);
								        if(ord == 1){
								        	//�µ��ɹ���ɾ�����ﳵ��Ʒ
								        	if(jgood.size() > 0){
												for(int i=0;i<jgood.size();i++){
													this.tscService.ordelShop(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")),Integer.parseInt(jmembercardid),Integer.parseInt(jdepartmentid));
												}
								        	}
								        	TOrderDetailed order = this.orderService.getOrderID(jordercode);
								        	tOrderDetailed.setjOrderid(order.getjId());
								        	if(jgood.size() > 0){
												for(int i=0;i<jgood.size();i++){
													tOrderDetailed.setjGoodsid(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
													tOrderDetailed.setjNumber(new BigDecimal(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsnumber"))));
													TActivity goods = this.tActService.getifGoods(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")),Integer.parseInt(jdepartmentid));
													if(goods == null){
														TGoods good = this.tgsService.getGoodsDetails(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
														tOrderDetailed.setjGoodsmoney(good.getJpointsaleprice());
													}else if(goods.getJdiscount().equals(BigDecimal.ZERO)){
														tOrderDetailed.setjGoodsmoney(goods.getJactprice());
													}else{
														TGoods good = this.tgsService.getGoodsDetails(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
														tOrderDetailed.setjGoodsmoney(good.getJpointsaleprice().multiply(goods.getJdiscount()));
													}
													this.orderService.setOrderdatiled(tOrderDetailed);
												}
											}
								        	TOrderDetailed OrderDetailed = this.orderService.getOrder(jordercode);
								        	if(OrderDetailed==null){
								        		resultMap.put("data", "");
									        	resultMap.put("code", "100002");
												resultMap.put("message", "�µ�ʧ�ܣ�");
								        	}else{
									        	resultMap.put("data", OrderDetailed);
									        	resultMap.put("code", "100000");
												resultMap.put("message", "seccess");
								        	}
								        }else{
								        	resultMap.put("data", "");
								        	resultMap.put("code", "100002");
											resultMap.put("message", "�µ�ʧ�ܣ�");
								        }
							        }else{
							        	resultMap.put("data", "");
							        	resultMap.put("code", "100002");
										resultMap.put("message", "����ѡ���ջ���ַ��");
							        }
							        
								}else{
									tOrderDetailed.setjIfcoupon(new BigDecimal(0));
									resultMap.put("data", "");
						        	resultMap.put("code", "100002");
									resultMap.put("message", "�ﲻ��ʹ�ô��Ż�ȯ��Ҫ��");
								}
							}else{
								resultMap.put("data", "");
					        	resultMap.put("code", "100002");
								resultMap.put("message", "û���Ż�ȯ����ʹ�ã�");
							}
				        }else{
				        	tOrderDetailed.setjIfcoupon(new BigDecimal(0));
				        	tOrderDetailed.setjCopId(Integer.parseInt(coupon));
							//�����Ƿ�ʹ�û���
							if(ifscore.equals("1")){
				        		//��ѯʣ�������
								TMemberCard num = this.tmService.getInte(Integer.parseInt(jmembercardid));
								//��ѯ�������һ�RMB��
								TDepartment getScore = this.tdService.selectScore(Integer.parseInt(jdepartmentid));
								if(getScore.getJscoreforrmb().compareTo(new BigDecimal(0))==0){
									BigDecimal usescore = new BigDecimal(0);
									tOrderDetailed.setjIfscore(new BigDecimal(0));
								}else{
									BigDecimal aaa = new BigDecimal(BigdecimalUtil.div(num.getJendqty().doubleValue(),getScore.getJscoreforrmb().doubleValue(),2));
									if(aaa.compareTo(jmoney)!=-1){
										BigDecimal usescore = new BigDecimal(BigdecimalUtil.mul(jmoney.doubleValue(),getScore.getJscoreforrmb().doubleValue()));
										/*BigDecimal yuscore = num.getJendqty().subtract(usescore);*/
										tOrderDetailed.setjIfscore(jmoney.setScale(2,BigDecimal.ROUND_HALF_UP));
										jmoney = new BigDecimal(0);
									}else{
										BigDecimal usescore = num.getJendqty();
										/*BigDecimal yuscore = new BigDecimal(0);*/
										jmoney = new BigDecimal(BigdecimalUtil.sub(jmoney.doubleValue(),aaa.doubleValue()));
										tOrderDetailed.setjIfscore(aaa.setScale(2,BigDecimal.ROUND_HALF_UP));
									}
								}
				        	}else{
				        		tOrderDetailed.setjIfscore(new BigDecimal(0));
				        	}
							//����ʹ�û�Ա�����
							if(jmoney.compareTo(BigDecimal.ZERO)==1){
								if(ifmembercard.equals("1")){
									//��ѯʣ���Ա�����
									TMemberCard fillamt = this.tmService.getInte(Integer.parseInt(jmembercardid));
									if(fillamt.getJendfillamt().compareTo(jmoney)==-1){
										BigDecimal useamt = fillamt.getJendfillamt();
										/*BigDecimal yuamt = new BigDecimal(0);*/
										jmoney = new BigDecimal(BigdecimalUtil.sub(jmoney.doubleValue(),fillamt.getJendfillamt().doubleValue()));
										tOrderDetailed.setjIfmembercard(useamt.setScale(2,BigDecimal.ROUND_HALF_UP));
									}else{
										BigDecimal useamt = jmoney;
										/*BigDecimal yuamt = fillamt.getJendfillamt().subtract(jmoney);*/
										jmoney = new BigDecimal(0);
										tOrderDetailed.setjIfmembercard(useamt.setScale(2,BigDecimal.ROUND_HALF_UP));
									}
								}else{
									tOrderDetailed.setjIfmembercard(new BigDecimal(0));
								}
							}else{
								tOrderDetailed.setjIfmembercard(new BigDecimal(0));
							}
							if(!StringUtils.isEmpty(jordercode)){
					        	tOrderDetailed.setjOrdercode(jordercode);
					        }
					        if(!StringUtils.isEmpty(jdepartmentid)){
					        	tOrderDetailed.setjDeptId(Integer.parseInt(jdepartmentid));
					        }
					        if(!StringUtils.isEmpty(jmembercardid)){
					        	tOrderDetailed.setjMembercardId(Integer.parseInt(jmembercardid));
					        }
					        //��ѯ�ͻ���ַ
					        TDeliveryAddress address = this.tdaService.getorderAddress(Integer.parseInt(jaddressid));
					        if(address != null){
					        	tOrderDetailed.setjAddress(address.getjAddress()+address.getjAddressDetailed());
					        	tOrderDetailed.setjState("0");
						        tOrderDetailed.setjPayment(jpayment);
						        jmoney = jmoney.setScale(2,BigDecimal.ROUND_HALF_UP);
						        tOrderDetailed.setjMoney(jmoney);
						        System.out.println(tOrderDetailed);
						        //���ɶ���
						        int ord = this.orderService.setOrder(tOrderDetailed);
						        if(ord == 1){
						        	//�µ��ɹ���ɾ�����ﳵ��Ʒ
						        	if(jgood.size() > 0){
										for(int i=0;i<jgood.size();i++){
											this.tscService.ordelShop(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")),Integer.parseInt(jmembercardid),Integer.parseInt(jdepartmentid));
										}
						        	}
						        	
						        	TOrderDetailed order = this.orderService.getOrderID(jordercode);
						        	tOrderDetailed.setjOrderid(order.getjId());
						        	if(jgood.size() > 0){
										for(int i=0;i<jgood.size();i++){
											tOrderDetailed.setjGoodsid(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
											tOrderDetailed.setjNumber(new BigDecimal(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsnumber"))));
											TActivity goods = this.tActService.getifGoods(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")),Integer.parseInt(jdepartmentid));
											if(goods == null){
												TGoods good = this.tgsService.getGoodsDetails(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
												tOrderDetailed.setjGoodsmoney(good.getJpointsaleprice());
											}else if(goods.getJdiscount().equals(BigDecimal.ZERO)){
												tOrderDetailed.setjGoodsmoney(goods.getJactprice());
											}else{
												TGoods good = this.tgsService.getGoodsDetails(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
												tOrderDetailed.setjGoodsmoney(good.getJpointsaleprice().multiply(goods.getJdiscount()));
											}
											this.orderService.setOrderdatiled(tOrderDetailed);
										}
									}
						        	TOrderDetailed OrderDetailed = this.orderService.getOrder(jordercode);
						        	if(OrderDetailed==null){
						        		resultMap.put("data", "");
							        	resultMap.put("code", "100002");
										resultMap.put("message", "�µ�ʧ�ܣ�");
						        	}else{
							        	resultMap.put("data", OrderDetailed);
							        	resultMap.put("code", "100000");
										resultMap.put("message", "seccess");
						        	}
						        }else{
						        	resultMap.put("data", "");
						        	resultMap.put("code", "100002");
									resultMap.put("message", "�µ�ʧ�ܣ�");
						        }
					        }else{
					        	resultMap.put("data", "");
					        	resultMap.put("code", "100002");
								resultMap.put("message", "����ѡ���ջ���ַ��");
					        }
				        }
					}
				}else{
					if(iffreight.equals("1")){
						tOrderDetailed.setjIffreight(new BigDecimal(0));
						System.out.println(jmoney);
						//�����Ƿ�ʹ���Ż�ȯ
						if(!coupon.equals("0")){
							TCouponDetailed coup = this.tcdService.getorderCoupon(Integer.parseInt(coupon));
							if(coup != null){
								if(jmoney.compareTo(coup.getjFulln()) == 1){
									jmoney = new BigDecimal(BigdecimalUtil.sub(jmoney.doubleValue(),coup.getjQuota().doubleValue()));
									tOrderDetailed.setjIfcoupon(coup.getjQuota());
									tOrderDetailed.setjCopId(Integer.parseInt(coupon));
									//�޸��Ż�ȯ״̬
									tCouponDetailed.setjId(Integer.parseInt(coupon));
									tCouponDetailed.setjState("0");
									this.tcdService.upcoup(tCouponDetailed);
									//�����Ƿ�ʹ�û���
									if(ifscore.equals("1")){
						        		//��ѯʣ�������
										TMemberCard num = this.tmService.getInte(Integer.parseInt(jmembercardid));
										//��ѯ�������һ�RMB��
										TDepartment getScore = this.tdService.selectScore(Integer.parseInt(jdepartmentid));
										if(getScore.getJscoreforrmb().compareTo(new BigDecimal(0))==0){
											BigDecimal usescore = new BigDecimal(0);
											tOrderDetailed.setjIfscore(new BigDecimal(0));
										}else{
											BigDecimal aaa = new BigDecimal(BigdecimalUtil.div(num.getJendqty().doubleValue(),getScore.getJscoreforrmb().doubleValue(),2));
											if(aaa.compareTo(jmoney)!=-1){
												BigDecimal usescore = new BigDecimal(BigdecimalUtil.mul(jmoney.doubleValue(),getScore.getJscoreforrmb().doubleValue()));
												/*BigDecimal yuscore = num.getJendqty().subtract(usescore);*/
												tOrderDetailed.setjIfscore(jmoney.setScale(2,BigDecimal.ROUND_HALF_UP));
												jmoney = new BigDecimal(0);
											}else{
												BigDecimal usescore = num.getJendqty();
												/*BigDecimal yuscore = new BigDecimal(0);*/
												jmoney = new BigDecimal(BigdecimalUtil.sub(jmoney.doubleValue(),aaa.doubleValue()));
												tOrderDetailed.setjIfscore(aaa.setScale(2,BigDecimal.ROUND_HALF_UP));
											}
										}
						        	}else{
						        		tOrderDetailed.setjIfscore(new BigDecimal(0));
						        	}
									//����ʹ�û�Ա�����
									if(jmoney.compareTo(BigDecimal.ZERO)==1){
										if(ifmembercard.equals("1")){
											//��ѯʣ���Ա�����
											TMemberCard fillamt = this.tmService.getInte(Integer.parseInt(jmembercardid));
											if(fillamt.getJendfillamt().compareTo(jmoney)==-1){
												BigDecimal useamt = fillamt.getJendfillamt();
												/*BigDecimal yuamt = new BigDecimal(0);*/
												jmoney = new BigDecimal(BigdecimalUtil.sub(jmoney.doubleValue(),fillamt.getJendfillamt().doubleValue()));
												tOrderDetailed.setjIfmembercard(useamt.setScale(2,BigDecimal.ROUND_HALF_UP));
											}else{
												BigDecimal useamt = jmoney;
												/*BigDecimal yuamt = fillamt.getJendfillamt().subtract(jmoney);*/
												jmoney = new BigDecimal(0);
												tOrderDetailed.setjIfmembercard(useamt.setScale(2,BigDecimal.ROUND_HALF_UP));
											}
										}else{
											tOrderDetailed.setjIfmembercard(new BigDecimal(0));
										}
									}else{
										tOrderDetailed.setjIfmembercard(new BigDecimal(0));
									}
									if(!StringUtils.isEmpty(jordercode)){
							        	tOrderDetailed.setjOrdercode(jordercode);
							        }
							        if(!StringUtils.isEmpty(jdepartmentid)){
							        	tOrderDetailed.setjDeptId(Integer.parseInt(jdepartmentid));
							        }
							        if(!StringUtils.isEmpty(jmembercardid)){
							        	tOrderDetailed.setjMembercardId(Integer.parseInt(jmembercardid));
							        }
							        //��ѯ�ͻ���ַ
							        TDeliveryAddress address = this.tdaService.getorderAddress(Integer.parseInt(jaddressid));
							        if(address != null){
							        	tOrderDetailed.setjAddress(address.getjAddress()+address.getjAddressDetailed());
							        	tOrderDetailed.setjState("0");
								        tOrderDetailed.setjPayment(jpayment);
								        jmoney = jmoney.setScale(2,BigDecimal.ROUND_HALF_UP);
								        tOrderDetailed.setjMoney(jmoney);
								        //���ɶ���
								        int ord = this.orderService.setOrder(tOrderDetailed);
								        if(ord == 1){
								        	//�µ��ɹ���ɾ�����ﳵ��Ʒ
								        	if(jgood.size() > 0){
												for(int i=0;i<jgood.size();i++){
													this.tscService.ordelShop(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")),Integer.parseInt(jmembercardid),Integer.parseInt(jdepartmentid));
												}
								        	}
								        	TOrderDetailed order = this.orderService.getOrderID(jordercode);
								        	tOrderDetailed.setjOrderid(order.getjId());
								        	if(jgood.size() > 0){
												for(int i=0;i<jgood.size();i++){
													tOrderDetailed.setjGoodsid(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
													tOrderDetailed.setjNumber(new BigDecimal(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsnumber"))));
													TActivity goods = this.tActService.getifGoods(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")),Integer.parseInt(jdepartmentid));
													if(goods == null){
														TGoods good = this.tgsService.getGoodsDetails(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
														tOrderDetailed.setjGoodsmoney(good.getJpointsaleprice());
													}else if(goods.getJdiscount().equals(BigDecimal.ZERO)){
														tOrderDetailed.setjGoodsmoney(goods.getJactprice());
													}else{
														TGoods good = this.tgsService.getGoodsDetails(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
														tOrderDetailed.setjGoodsmoney(good.getJpointsaleprice().multiply(goods.getJdiscount()));
													}
													this.orderService.setOrderdatiled(tOrderDetailed);
												}
											}
								        	TOrderDetailed OrderDetailed = this.orderService.getOrder(jordercode);
								        	if(OrderDetailed==null){
								        		resultMap.put("data", "");
									        	resultMap.put("code", "100002");
												resultMap.put("message", "�µ�ʧ�ܣ�");
								        	}else{
									        	resultMap.put("data", OrderDetailed);
									        	resultMap.put("code", "100000");
												resultMap.put("message", "seccess");
								        	}
								        }else{
								        	resultMap.put("data", "");
								        	resultMap.put("code", "100002");
											resultMap.put("message", "�µ�ʧ�ܣ�");
								        }
							        }else{
							        	resultMap.put("data", "");
							        	resultMap.put("code", "100002");
										resultMap.put("message", "����ѡ���ջ���ַ��");
							        }
							        
								}else{
									tOrderDetailed.setjIfcoupon(new BigDecimal(0));
									resultMap.put("data", "");
						        	resultMap.put("code", "100002");
									resultMap.put("message", "�ﲻ��ʹ�ô��Ż�ȯ��Ҫ��");
								}
							}else{
								resultMap.put("data", "");
					        	resultMap.put("code", "100002");
								resultMap.put("message", "û���Ż�ȯ����ʹ�ã�");
							}
				        }else{
				        	tOrderDetailed.setjIfcoupon(new BigDecimal(0));
				        	tOrderDetailed.setjCopId(Integer.parseInt(coupon));
							//�����Ƿ�ʹ�û���
							if(ifscore.equals("1")){
				        		//��ѯʣ�������
								TMemberCard num = this.tmService.getInte(Integer.parseInt(jmembercardid));
								//��ѯ�������һ�RMB��
								TDepartment getScore = this.tdService.selectScore(Integer.parseInt(jdepartmentid));
								if(getScore.getJscoreforrmb().compareTo(new BigDecimal(0))==0){
									BigDecimal usescore = new BigDecimal(0);
									tOrderDetailed.setjIfscore(new BigDecimal(0));
								}else{
									BigDecimal aaa = new BigDecimal(BigdecimalUtil.div(num.getJendqty().doubleValue(),getScore.getJscoreforrmb().doubleValue(),2));
									if(aaa.compareTo(jmoney)!=-1){
										BigDecimal usescore = new BigDecimal(BigdecimalUtil.mul(jmoney.doubleValue(),getScore.getJscoreforrmb().doubleValue()));
										/*BigDecimal yuscore = num.getJendqty().subtract(usescore);*/
										tOrderDetailed.setjIfscore(jmoney.setScale(2,BigDecimal.ROUND_HALF_UP));
										jmoney = new BigDecimal(0);
									}else{
										BigDecimal usescore = num.getJendqty();
										/*BigDecimal yuscore = new BigDecimal(0);*/
										jmoney = new BigDecimal(BigdecimalUtil.sub(jmoney.doubleValue(),aaa.doubleValue()));
										tOrderDetailed.setjIfscore(aaa.setScale(2,BigDecimal.ROUND_HALF_UP));
									}
								}
				        	}else{
				        		tOrderDetailed.setjIfscore(new BigDecimal(0));
				        	}
							//����ʹ�û�Ա�����
							if(jmoney.compareTo(BigDecimal.ZERO)==1){
								if(ifmembercard.equals("1")){
									//��ѯʣ���Ա�����
									TMemberCard fillamt = this.tmService.getInte(Integer.parseInt(jmembercardid));
									if(fillamt.getJendfillamt().compareTo(jmoney)==-1){
										BigDecimal useamt = fillamt.getJendfillamt();
										/*BigDecimal yuamt = new BigDecimal(0);*/
										jmoney = new BigDecimal(BigdecimalUtil.sub(jmoney.doubleValue(),fillamt.getJendfillamt().doubleValue()));
										tOrderDetailed.setjIfmembercard(useamt.setScale(2,BigDecimal.ROUND_HALF_UP));
									}else{
										BigDecimal useamt = jmoney;
										/*BigDecimal yuamt = fillamt.getJendfillamt().subtract(jmoney);*/
										jmoney = new BigDecimal(0);
										tOrderDetailed.setjIfmembercard(useamt.setScale(2,BigDecimal.ROUND_HALF_UP));
									}
								}else{
									tOrderDetailed.setjIfmembercard(new BigDecimal(0));
								}
							}else{
								tOrderDetailed.setjIfmembercard(new BigDecimal(0));
							}
							if(!StringUtils.isEmpty(jordercode)){
					        	tOrderDetailed.setjOrdercode(jordercode);
					        }
					        if(!StringUtils.isEmpty(jdepartmentid)){
					        	tOrderDetailed.setjDeptId(Integer.parseInt(jdepartmentid));
					        }
					        if(!StringUtils.isEmpty(jmembercardid)){
					        	tOrderDetailed.setjMembercardId(Integer.parseInt(jmembercardid));
					        }
					        //��ѯ�ͻ���ַ
					        TDeliveryAddress address = this.tdaService.getorderAddress(Integer.parseInt(jaddressid));
					        if(address != null){
					        	tOrderDetailed.setjAddress(address.getjAddress()+address.getjAddressDetailed());
					        	tOrderDetailed.setjState("0");
						        tOrderDetailed.setjPayment(jpayment);
						        jmoney = jmoney.setScale(2,BigDecimal.ROUND_HALF_UP);
						        tOrderDetailed.setjMoney(jmoney);
						        //���ɶ���
						        int ord = this.orderService.setOrder(tOrderDetailed);
						        if(ord == 1){
						        	//�µ��ɹ���ɾ�����ﳵ��Ʒ
						        	if(jgood.size() > 0){
										for(int i=0;i<jgood.size();i++){
											this.tscService.ordelShop(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")),Integer.parseInt(jmembercardid),Integer.parseInt(jdepartmentid));
										}
						        	}
						        	
						        	TOrderDetailed order = this.orderService.getOrderID(jordercode);
						        	tOrderDetailed.setjOrderid(order.getjId());
						        	if(jgood.size() > 0){
										for(int i=0;i<jgood.size();i++){
											tOrderDetailed.setjGoodsid(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
											tOrderDetailed.setjNumber(new BigDecimal(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsnumber"))));
											TActivity goods = this.tActService.getifGoods(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")),Integer.parseInt(jdepartmentid));
											if(goods == null){
												TGoods good = this.tgsService.getGoodsDetails(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
												tOrderDetailed.setjGoodsmoney(good.getJpointsaleprice());
											}else if(goods.getJdiscount().equals(BigDecimal.ZERO)){
												tOrderDetailed.setjGoodsmoney(goods.getJactprice());
											}else{
												TGoods good = this.tgsService.getGoodsDetails(Integer.parseInt((String) jgood.getJSONObject(i).optString("jgoodsid")));
												tOrderDetailed.setjGoodsmoney(good.getJpointsaleprice().multiply(goods.getJdiscount()));
											}
											this.orderService.setOrderdatiled(tOrderDetailed);
										}
									}
						        	TOrderDetailed OrderDetailed = this.orderService.getOrder(jordercode);
						        	if(OrderDetailed==null){
						        		resultMap.put("data", "");
							        	resultMap.put("code", "100002");
										resultMap.put("message", "�µ�ʧ�ܣ�");
						        	}else{
							        	resultMap.put("data", OrderDetailed);
							        	resultMap.put("code", "100000");
										resultMap.put("message", "seccess");
						        	}
						        }else{
						        	resultMap.put("data", "");
						        	resultMap.put("code", "100002");
									resultMap.put("message", "�µ�ʧ�ܣ�");
						        }
					        }else{
					        	resultMap.put("data", "");
					        	resultMap.put("code", "100002");
								resultMap.put("message", "����ѡ���ջ���ַ��");
					        }
				        }
					}else{
						resultMap.put("data", "");
			        	resultMap.put("code", "100002");
						resultMap.put("message", "�ﵽ�������ͷѵ�Ҫ��");
					}
				}
			}
			
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "�������쳣�����Ժ����ԣ�");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
	//ȡ������
	@RequestMapping("freshshop/cancelOrder")
	public void cancelOrder(HttpServletRequest request, HttpServletResponse response,TBasicSort tBasicSort,TOrderDetailed tOrderDetailed) {
		PrintWriter pw = null;
		String jordercode = request.getParameter("jordercode");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			TOrderDetailed order = this.orderService.getOrderID(jordercode);
			if(order.getjId() != null){
				tOrderDetailed.setjOrdercode(jordercode);
				tOrderDetailed.setjState("1");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				String data = df.format(new Date()).toString();
				Date uptime = df.parse(data);
				tOrderDetailed.setjUptime(uptime);
				int ord = this.orderService.uporderstate(tOrderDetailed);
				if(ord == 1){
						resultMap.put("data", "");
			        	resultMap.put("code", "100000");
						resultMap.put("message","seccess");
				}else{
					resultMap.put("data", "");
		        	resultMap.put("code", "100002");
					resultMap.put("message", "����ȡ��ʧ�ܣ�");
				}
			}else{
				resultMap.put("data", "");
	        	resultMap.put("code", "100002");
				resultMap.put("message", "û�д˶�����");
			}
		} catch (IOException | ParseException e) {
			resultMap.put("code", "100001");
			resultMap.put("message", "�������쳣�����Ժ����ԣ�");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
	//����֧��
	@RequestMapping(value="freshshop/payment")
	public String payment(HttpServletRequest request, HttpServletResponse response,RedirectAttributes attr,TOrderDetailed tOrderDetailed){
		PrintWriter pw = null;
		String jordercode = request.getParameter("jordercode");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try{
			pw = response.getWriter();
			if(!StringUtils.isEmpty(jordercode)){
				TOrderDetailed getorder = this.orderService.getOrder(jordercode);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				String data = df.format(new Date()).toString();
				Date b = df.parse(data);
				Date a =getorder.getjBegintime();
				if(b.getTime() - a.getTime() < 1800000){
					if(getorder.getjPayment().equals("1")){
						attr.addAttribute("jmoney", getorder.getjMoney());
						attr.addAttribute("jordercode", jordercode);
						return "redirect:/api/weixin/weixinPay";
					}else if(getorder.getjPayment().equals("2")){
						attr.addAttribute("jmoney", getorder.getjMoney());
						attr.addAttribute("jordercode", jordercode);
						return "redirect:/zhifubao/alipay";
					}else if(getorder.getjPayment().equals("3")){
						
						return null;
					}
				}else{
					tOrderDetailed.setjOrdercode(jordercode);
					tOrderDetailed.setjState("2");
					tOrderDetailed.setjUptime(b);
					this.orderService.uporderstate(tOrderDetailed);
					resultMap.put("data", "");
					resultMap.put("code", "100002");
					resultMap.put("message", "�˶�����ʧЧ��");
					pw.write(new Gson().toJson(resultMap));
					pw.close();
				}
			}
		}catch(Throwable e){
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "�������쳣�����Ժ����ԣ�");
			e.printStackTrace();
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
		return null;
	}
	//�����˿�
	@RequestMapping(value="freshshop/refund")
	public String refund(HttpServletRequest request, HttpServletResponse response,RedirectAttributes attr,TOrderDetailed tOrderDetailed){
		PrintWriter pw = null;
		String jordercode = request.getParameter("jordercode");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try{
			pw = response.getWriter();
			if(!StringUtils.isEmpty(jordercode)){
				TOrderDetailed getorder = this.orderService.getOrder(jordercode);
				if(getorder.getjState().equals("3")){
					if(getorder.getjPayment().equals("1")){
						attr.addAttribute("jmoney", getorder.getjMoney());
						attr.addAttribute("jordercode", jordercode);
						return "redirect:/api/weixin/wxRefund";
					}else if(getorder.getjPayment().equals("2")){
						attr.addAttribute("jmoney", getorder.getjMoney());
						attr.addAttribute("jordercode", jordercode);
						return "redirect:/zhifubao/alipay";
					}else if(getorder.getjPayment().equals("3")){
						
						return null;
					}
				}else{
					resultMap.put("data", "");
					resultMap.put("code", "100002");
					resultMap.put("message", "ֻ�д������������������˿");
					pw.write(new Gson().toJson(resultMap));
					pw.close();
				}
			}
		}catch(Throwable e){
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "�������쳣�����Ժ����ԣ�");
			e.printStackTrace();
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
		return null;
	}
	//�鿴���ж���
	@RequestMapping("freshshop/getOrderAll")
	public void getOrderAll(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter pw = null;
		String jdepartmentid = request.getParameter("jdepartmentid");
		String jmembercardid = request.getParameter("jmembercardid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if(!jmembercardid.equals("")){
				List<TOrderDetailed> order = this.orderService.getOrderAll(Integer.parseInt(jmembercardid));
				if(order.size()>0){
					for(int i=0;i<order.size();i++){
						List<TGoods> good = this.tgsService.getorderGoods(order.get(i).getjId());
						result = new HashMap<String, Object>();
						result.put("good", good);
						result.put("order", order.get(i));
						resultList.add(result);
					}
				}
				resultMap.put("data", resultList);
	        	resultMap.put("code", "100000");
				resultMap.put("message","seccess");
			}
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "�������쳣�����Ժ����ԣ�");
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
}
