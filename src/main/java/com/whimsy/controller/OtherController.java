package com.whimsy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.whimsy.entity.TActivity;
import com.whimsy.entity.TBasicSort;
import com.whimsy.entity.TCouponDetailed;
import com.whimsy.entity.TFootprint;
import com.whimsy.entity.TGoods;
import com.whimsy.entity.TIntegration;
import com.whimsy.service.TActivityService;
import com.whimsy.service.TBasicSortService;
import com.whimsy.service.TCouponDetailedService;
import com.whimsy.service.TFootprintService;
import com.whimsy.service.TIntegrationService;

@Controller
public class OtherController {
	
	@Autowired
	private TCouponDetailedService tcdService;
	
	@Autowired
	private TFootprintService tfpService;
	
	@Autowired
	private TActivityService tActService;
	
	@Autowired
	private TIntegrationService tiService;
	
	//查看活动
	@RequestMapping("freshshop/getActGoods")
	public void getActGoods(HttpServletRequest request, HttpServletResponse response,TGoods tGoods,TActivity tActivity,TFootprint tFootprint) {
		PrintWriter pw = null;
		String jpid = request.getParameter("jpid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> reMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jpid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入一级分类ID！");
				resultList.add(resultMap);
			} else {
				TActivity act = this.tActService.getAct(Integer.parseInt(jpid));
				reMap.put("activity", act);
				if(act.getjType().equals("1")){
					List<TActivity> goods = this.tActService.getzGoodsList(act.getjId());
					reMap.put("goods", goods);
				}else if(act.getjType().equals("2")){
					List<TActivity> goods = this.tActService.gettGoodsList(act.getjId());
					reMap.put("goods", goods);
				}
				resultMap.put("data", reMap);
				resultMap.put("code", "100000");
				resultMap.put("message", "seccess");
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
	
	//查看优惠券
	@RequestMapping("freshshop/getCoupon")
	public void getCoupon(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter pw = null;
		String jmembercardid = request.getParameter("jmembercardid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jmembercardid)) {
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入一级分类ID！");
				resultList.add(resultMap);
			} else {
				List<TCouponDetailed> yhq = this.tcdService.getCoupon(Integer.parseInt(jmembercardid));
				resultMap.put("data", yhq);
				resultMap.put("code", "100000");
				resultMap.put("message", "success");
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
	//查看足迹
	@RequestMapping("freshshop/getHistory")
	public void getHistory(HttpServletRequest request, HttpServletResponse response,TFootprint tFootprint) {
		PrintWriter pw = null;
		String jdepartmentid = request.getParameter("jdepartmentid");
		String jmembercardid = request.getParameter("jmembercardid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jmembercardid)) {
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入一级分类ID！");
				resultList.add(resultMap);
			} else if(StringUtils.isEmpty(jdepartmentid)) {
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入所属店铺ID！");
				resultList.add(resultMap);
			} else {
				List<TFootprint> foot = this.tfpService.selectFootprint(Integer.parseInt(jmembercardid), Integer.parseInt(jdepartmentid));
				resultMap.put("data", foot);
				resultMap.put("code", "100000");
				resultMap.put("message", "success");
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
	//查看积分明细
	@RequestMapping("freshshop/getIntegration")
	public void getIntegration(HttpServletRequest request, HttpServletResponse response,TFootprint tFootprint) {
		PrintWriter pw = null;
		String jmembercardid = request.getParameter("jmembercardid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jmembercardid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入一级分类ID！");
				resultList.add(resultMap);
			} else {
				List<TIntegration> integration = this.tiService.selectIntegration(Integer.parseInt(jmembercardid));
				resultMap.put("data", integration);
				resultMap.put("code", "100000");
				resultMap.put("message", "success");
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
	//设置密码
	@RequestMapping("freshshop/setPWD")
	public void setPWD(HttpServletRequest request, HttpServletResponse response,TBasicSort tBasicSort) {
		PrintWriter pw = null;
		String jmembercardid = request.getParameter("jmembercardid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jmembercardid)) {
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入一级分类ID！");
				resultList.add(resultMap);
			} else {
				List<TBasicSort> twokind = this.tbService.selectTwo(Integer.parseInt(jmembercardid));
				if(twokind.size() == 0){
					resultMap.put("code", "100002");
					resultMap.put("message", "此分类下没有二级分类！");
					resultList.add(resultMap);
				}else{
					resultMap.put("data", twokind);
					resultMap.put("code", "100000");
					resultMap.put("message", "success");
					resultList.add(resultMap);
				}
			}
		} catch (IOException e) {
			resultMap.put("code", "100001");
			resultMap.put("message", "服务器异常，请稍后重试！");
			resultList.add(resultMap);
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
	//修改密码
	@RequestMapping("freshshop/updatePWD")
	public void updatePWD(HttpServletRequest request, HttpServletResponse response,TBasicSort tBasicSort) {
		PrintWriter pw = null;
		String jmembercardid = request.getParameter("jmembercardid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jmembercardid)) {
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入一级分类ID！");
				resultList.add(resultMap);
			} else if(StringUtils.isEmpty(jdepartmentid)) {
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入所属店铺ID！");
				resultList.add(resultMap);
			} else if(StringUtils.isEmpty(jgoodsid)) {
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入所属店铺ID！");
				resultList.add(resultMap);
			} else {
				List<TBasicSort> twokind = this.tbService.selectTwo(Integer.parseInt(jmembercardid));
				if(twokind.size() == 0){
					resultMap.put("code", "100002");
					resultMap.put("message", "此分类下没有二级分类！");
					resultList.add(resultMap);
				}else{
					resultMap.put("data", twokind);
					resultMap.put("code", "100000");
					resultMap.put("message", "success");
					resultList.add(resultMap);
				}
			}
		} catch (IOException e) {
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
