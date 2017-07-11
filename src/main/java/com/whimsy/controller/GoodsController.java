package com.whimsy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
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
import com.whimsy.entity.TFootprint;
import com.whimsy.entity.TGoods;
import com.whimsy.entity.TTwoKind;
import com.whimsy.entity.VAuxGoodsStock;
import com.whimsy.service.TActivityService;
import com.whimsy.service.TBasicSortService;
import com.whimsy.service.TFootprintService;
import com.whimsy.service.TGoodsService;
import com.whimsy.service.TTwoKindService;
import com.whimsy.service.VAuxGoodsStockService;

@Controller
public class GoodsController {
	@Autowired
	private TBasicSortService tbService;
	
	@Autowired
	private TTwoKindService ttkService;
	
	@Autowired
	private VAuxGoodsStockService vgsService;
	
	@Autowired
	private TGoodsService tgsService;
	
	@Autowired
	private TActivityService tActService;
	
	@Autowired
	private TFootprintService tfpService;
	
	// 获取一级分类
	@RequestMapping("freshshop/getOnekind")
	public void getOnekind(HttpServletRequest request, HttpServletResponse response,TBasicSort tBasicSort) {
		PrintWriter pw = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			List<TBasicSort> onekind = this.tbService.selectOne(0);
			if(onekind.size() == 0){
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "数据库中没有分类！");
				resultList.add(resultMap);
			}else{
				resultMap.put("data", onekind);
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
	// 获取二级分类
	@RequestMapping("freshshop/getTwokind")
	public void getTwokind(HttpServletRequest request, HttpServletResponse response,TBasicSort tBasicSort,TTwoKind tTwoKind) {
		PrintWriter pw = null;
		String jparentid = request.getParameter("jparentid");
		String jdepartmentid = request.getParameter("jdepartmentid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		tTwoKind.setjParentId(Integer.parseInt(jparentid));
		tTwoKind.setjDepartmentId(Integer.parseInt(jdepartmentid));
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jparentid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入一级分类ID！");
				resultList.add(resultMap);
			} else if (StringUtils.isEmpty(jdepartmentid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入所属店铺ID！");
				resultList.add(resultMap);
			} else{
				List<TTwoKind> twokind = this.ttkService.selectTwo(tTwoKind);
				if(twokind.size() == 0){
					resultMap.put("data", twokind);
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
	//获取商品列表
	@RequestMapping("freshshop/getGoods")
	public void getGoods(HttpServletRequest request, HttpServletResponse response,TBasicSort tBasicSort,VAuxGoodsStock vAuxGoodsStock,TGoods tGoods) {
		PrintWriter pw = null;
		String jparentid = request.getParameter("jparentid");
		String jdepartmentid = request.getParameter("jdepartmentid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jparentid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入所属分类ID！");
				resultList.add(resultMap);
			} else if(StringUtils.isEmpty(jdepartmentid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入所属店铺ID！");
				resultList.add(resultMap);
			}else {
				/*List<TGoods> goods = this.tgsService.getGoods(Integer.parseInt(jparentid), Integer.parseInt(jdepartmentid));*/
				List<VAuxGoodsStock> goods = this.vgsService.getGoods(Integer.parseInt(jparentid), Integer.parseInt(jdepartmentid));
				if(goods.size() == 0){
					resultMap.put("data", goods);
					resultMap.put("code", "100002");
					resultMap.put("message", "此分类下没有商品！");
					resultList.add(resultMap);
				}else{
					resultMap.put("data", goods);
					resultMap.put("code", "100000");
					resultMap.put("message", "success");
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
	//获取商品详情
	@RequestMapping("freshshop/getGoodsDetails")
	public void getGoodsDetails(HttpServletRequest request, HttpServletResponse response,TGoods tGoods,TActivity tActivity,TFootprint tFootprint) {
		PrintWriter pw = null;
		String jid = request.getParameter("jid");
		String jdepartmentid = request.getParameter("jdepartmentid");
		String jmembercardid = request.getParameter("jmembercardid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> goodsMap = new HashMap<String, Object>();
		Map<String, Object> actMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入一级分类ID！");
				resultList.add(resultMap);
			} else {
				TGoods goods = this.tgsService.getGoodsDetails(Integer.parseInt(jid));
				if(goods == null){
					resultMap.put("data", goods);
					resultMap.put("code", "100002");
					resultMap.put("message", "查询错误！");
					resultList.add(resultMap);
				}else{
					//插入足迹
					tFootprint.setjGoodsId(Integer.parseInt(jid));
					tFootprint.setjDeptId(Integer.parseInt(jdepartmentid));
					tFootprint.setjMembercardId(Integer.parseInt(jmembercardid));
					TFootprint foot = this.tfpService.selectf(tFootprint);
					if(foot == null){
						tFootprint.setjNumber((long)1);
						this.tfpService.insertf(tFootprint);
					}else{
						tFootprint.setjId(foot.getjId());
						tFootprint.setjNumber(foot.getjNumber()+1);
						this.tfpService.updatef(tFootprint);
					}
					
					goodsMap.put("goods", goods);
					TActivity ifact = this.tActService.getifGoods(Integer.parseInt(jid), Integer.parseInt(jdepartmentid));
					if(ifact == null){
						actMap.put("ifact", 0);//没有在活动中
						actMap.put("jdiscount", "");
						actMap.put("jactprice", "");
					}else if(ifact.getJactprice().equals(BigDecimal.ZERO)){
						actMap.put("ifact", 1);//打折
						actMap.put("jdiscount", ifact.getJdiscount());
						actMap.put("jactprice", goods.getJpointsaleprice().multiply(ifact.getJdiscount()).doubleValue());
					}else {
						actMap.put("ifact", 2);//特价
						actMap.put("jdiscount", ifact.getJdiscount());
						actMap.put("jactprice", ifact.getJactprice());
					}
					goodsMap.put("goodsact", actMap);
					resultMap.put("data", goodsMap);
					resultMap.put("code", "100000");
					resultMap.put("message", "success");
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
	//查询关键字
	@RequestMapping("freshshop/searchGoods")
	public void searchGoods(HttpServletRequest request, HttpServletResponse response,TGoods tGoods,TBasicSort tBasicSort,VAuxGoodsStock vAuxGoodsStock) throws UnsupportedEncodingException {
		PrintWriter pw = null;
		String jdepartmentid = request.getParameter("jdepartmentid");
		/*String keyword = request.getParameter("keyword");*/
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		if(request.getParameter("keyword")!=null){
			String keyword=URLDecoder.decode(request.getParameter("keyword"),"utf-8");
			tGoods.setJgoodsname(keyword);
		}else{
			resultMap.put("data", "");
			resultMap.put("code", "100002");
			resultMap.put("message", "请输入所属店铺ID！");
			resultList.add(resultMap);
		}
		vAuxGoodsStock.setJdeptid(Integer.parseInt(jdepartmentid));
		vAuxGoodsStock.settGoods(tGoods);
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jdepartmentid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入一级分类ID！");
				resultList.add(resultMap);
			} else {
				List<VAuxGoodsStock> goods = this.vgsService.searchGoods(vAuxGoodsStock);
				if(goods.size() == 0){
					resultMap.put("data", goods);
					resultMap.put("code", "100002");
					resultMap.put("message", "没有查到相关的商品！");
					resultList.add(resultMap);
				}else{
					resultMap.put("data", goods);
					resultMap.put("code", "100000");
					resultMap.put("message", "success");
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
}
