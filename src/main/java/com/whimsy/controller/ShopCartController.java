package com.whimsy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
import com.whimsy.dao.TShopCartMapper;
import com.whimsy.entity.TBasicSort;
import com.whimsy.entity.TDeliveryAddress;
import com.whimsy.entity.TDepartment;
import com.whimsy.entity.TGoods;
import com.whimsy.entity.TMemberCard;
import com.whimsy.entity.TShopCart;
import com.whimsy.service.TBasicSortService;
import com.whimsy.service.TDeliveryAddressService;
import com.whimsy.service.TShopCartService;

@Controller
public class ShopCartController {
	
	@Autowired
	private TBasicSortService tbService;
	
	@Autowired
	private TShopCartService tscService;
	
	@Autowired
	private TDeliveryAddressService tdaService;
	
	//加入购物车   购物车物品加减
	@RequestMapping("freshshop/updateShopCart")
	public void setShopCart(HttpServletRequest request, HttpServletResponse response,TBasicSort tBasicSort,TShopCart tShopCart,TGoods tGoods,TDepartment tDepartment,TMemberCard tMemberCard) {
		PrintWriter pw = null;
		String jid = request.getParameter("jid");
		String jgoodsid = request.getParameter("jgoodsid");
		String jdepartmentid = request.getParameter("jdepartmentid");
		String jmembercardid = request.getParameter("jmembercardid");
		String number = request.getParameter("number");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		if(!StringUtils.isEmpty(jid)){
			tShopCart.setjId(Integer.parseInt(jid));
		}
		tShopCart.setjGoodsId(Integer.parseInt(jgoodsid));
		tShopCart.setjDepartmentId(Integer.parseInt(jdepartmentid));
		tShopCart.setjMembercardId(Integer.parseInt(jmembercardid));
		tShopCart.setjNumber(Integer.parseInt(number));
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jmembercardid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入购买人ID！");
				resultList.add(resultMap);
			} else if(StringUtils.isEmpty(jdepartmentid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入所属店铺ID！");
				resultList.add(resultMap);
			} else if(StringUtils.isEmpty(jgoodsid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入商品ID！");
				resultList.add(resultMap);
			} else {
				TShopCart goods = this.tscService.selectGoodsNumber(tShopCart);
				
				if(goods != null){
					int goodsnumber = goods.getjNumber();
					if(number.equals("1")){
						goodsnumber = goodsnumber + 1;
						tShopCart.setjNumber(goodsnumber);
						int goodsup = this.tscService.updateShopCart(tShopCart);
						if(goodsup == 1){
							resultMap.put("data", goodsnumber);
							resultMap.put("code", "100000");
							resultMap.put("message", "success");
							resultList.add(resultMap);
						}else{
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "商品增加失败！");
							resultList.add(resultMap);
						}
					}else{
						goodsnumber = goodsnumber - 1;
						if(goodsnumber > 0){
							tShopCart.setjNumber(goodsnumber);
							int goodsup = this.tscService.updateShopCart(tShopCart);
							if(goodsup == 1){
								resultMap.put("data", goodsnumber);
								resultMap.put("code", "100000");
								resultMap.put("message", "success");
								resultList.add(resultMap);
							}else{
								resultMap.put("data", "");
								resultMap.put("code", "100002");
								resultMap.put("message", "商品增加失败！");
								resultList.add(resultMap);
							}
						}else{
							tShopCart.setjNumber(goodsnumber);
							int goodsup = this.tscService.deleteShopCart(tShopCart);
							if(goodsup == 1){
								/*resultMap.put("data", goodsnumber);*/
								resultMap.put("data", "");
								resultMap.put("code", "100000");
								resultMap.put("message", "success");
								resultList.add(resultMap);
							}else{
								resultMap.put("data", "");
								resultMap.put("code", "100002");
								resultMap.put("message", "商品删除失败！");
								resultList.add(resultMap);
							}
						}
					}
				}else{
					int goodsadd = this.tscService.setShopCart(tShopCart);
					if(goodsadd == 1){
						resultMap.put("data", goodsadd);
						resultMap.put("code", "100000");
						resultMap.put("message", "success");
						resultList.add(resultMap);
					}else{
						resultMap.put("data", "");
						resultMap.put("code", "100002");
						resultMap.put("message", "商品添加购物车失败！");
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
	//购物车物品删除
	@RequestMapping("freshshop/deleteShopCart")
	public void updateShopCart(HttpServletRequest request, HttpServletResponse response,TShopCart tShopCart) {
		PrintWriter pw = null;
		String jid = request.getParameter("jid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请选择要删除的商品！");
				resultList.add(resultMap);
			} else {
				String[] j_id= jid.split(",");
				if(j_id.length > 0){
					for(int i=0;i<j_id.length;i++){
						tShopCart.setjId(Integer.parseInt(j_id[i]));
						int del = this.tscService.deleteShopCart(tShopCart);
						/*if(del == 1){
							resultMap.put("data", "");
							resultMap.put("code", "100000");
							resultMap.put("message", "success");
							resultList.add(resultMap);
						}else{
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "商品删除失败！");
							resultList.add(resultMap);
						}*/
					}
					resultMap.put("data", "");
					resultMap.put("code", "100000");
					resultMap.put("message", "success");
					resultList.add(resultMap);
				}else{
					resultMap.put("data", "");
					resultMap.put("code", "100002");
					resultMap.put("message", "请选择要删除的商品！");
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
	//购物车查询
	@RequestMapping("freshshop/selectShopCart")
	public void selectShopCart(HttpServletRequest request, HttpServletResponse response,TBasicSort tBasicSort,TShopCart tShopCart,TGoods tGoods,TDepartment tDepartment,TMemberCard tMemberCard) {
		PrintWriter pw = null;
		String jdepartmentid = request.getParameter("jdepartmentid");
		String jmembercardid = request.getParameter("jmembercardid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		tShopCart.setjDepartmentId(Integer.parseInt(jdepartmentid));
		tShopCart.setjMembercardId(Integer.parseInt(jmembercardid));
		
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jmembercardid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入客户ID！");
				resultList.add(resultMap);
			} else if(StringUtils.isEmpty(jdepartmentid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入所属店铺ID！");
				resultList.add(resultMap);
			}  else {
				List<TShopCart> goodslist = this.tscService.selectShopCart(Integer.parseInt(jdepartmentid),Integer.parseInt(jmembercardid));
				if(goodslist.size() == 0){
					resultMap.put("data", goodslist);
					resultMap.put("code", "100000");
					resultMap.put("message", "success");
					resultList.add(resultMap);
				}else{
					resultMap.put("data", goodslist);
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
	//收货地址列表
	@RequestMapping("freshshop/getAddress")
	public void getAddress(HttpServletRequest request, HttpServletResponse response,TDeliveryAddress tDeliveryAddress) {
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
				List<TDeliveryAddress> address = this.tdaService.getAddress(Integer.parseInt(jmembercardid));
				resultMap.put("data", address);
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
	//新增收货地址
	@RequestMapping("freshshop/addAddress")
	public void addAddress(HttpServletRequest request, HttpServletResponse response,TDeliveryAddress tDeliveryAddress) throws UnsupportedEncodingException {
		PrintWriter pw = null;
		String jmembercardid = request.getParameter("jmembercardid");
		String jdeliveryman = request.getParameter("jdeliveryman");
		String jdeliveryphone = request.getParameter("jdeliveryphone");
		/*String jaddress = request.getParameter("jaddress");*/
		String jaddressdetailed = request.getParameter("jaddressdetailed");
		String jlable = request.getParameter("jlable");
		String jdefault = request.getParameter("jdefault");
		String jlongitude = request.getParameter("jlongitude");
		String jlatitude = request.getParameter("jlatitude");
		if(request.getParameter("jaddress")!=null){
			String jaddress=URLDecoder.decode(request.getParameter("jaddress"),"utf-8");
			tDeliveryAddress.setjAddress(jaddress);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (!StringUtils.isEmpty(jmembercardid)) {
				tDeliveryAddress.setjMembercardId(Integer.parseInt(jmembercardid));
			}
			if(!StringUtils.isEmpty(jdeliveryman)) {
				tDeliveryAddress.setjDeliveryMan(jdeliveryman);
			}
			if(!StringUtils.isEmpty(jdeliveryphone)) {
				tDeliveryAddress.setjDeliveryPhone(jdeliveryphone);
			}
			/*if(!StringUtils.isEmpty(jaddress)) {
				tDeliveryAddress.setjAddress(jaddress);
			}*/
			if(!StringUtils.isEmpty(jaddressdetailed)) {
				tDeliveryAddress.setjAddressDetailed(jaddressdetailed);
			}
			if(!StringUtils.isEmpty(jlable)) {
				tDeliveryAddress.setjLable(jlable);
			}
			if(!StringUtils.isEmpty(jdefault)) {
				if(jdefault.equals("是")){
					int efault = this.tdaService.updateDefault(Integer.parseInt(jmembercardid));
				}
				tDeliveryAddress.setjDefault(jdefault);
			}
			if(!StringUtils.isEmpty(jlongitude)) {
				tDeliveryAddress.setjLongitude(jlongitude);
			}
			if(!StringUtils.isEmpty(jlatitude)) {
				tDeliveryAddress.setjLatitude(jlatitude);
			}
			int addaddress = this.tdaService.addAddress(tDeliveryAddress);
			if(addaddress == 0){
				resultMap.put("data", addaddress);
				resultMap.put("code", "100002");
				resultMap.put("message", "添加收货地址失败！");
				resultList.add(resultMap);
			}else{
				resultMap.put("data", addaddress);
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
	//修改收货地址
	@RequestMapping("freshshop/updateAddress")
	public void updateAddress(HttpServletRequest request, HttpServletResponse response,TDeliveryAddress tDeliveryAddress) {
		PrintWriter pw = null;
		String jid = request.getParameter("jid");
		String jdeliveryman = request.getParameter("jdeliveryman");
		String jdeliveryphone = request.getParameter("jdeliveryphone");
		String jaddress = request.getParameter("jaddress");
		String jaddressdetailed = request.getParameter("jaddressdetailed");
		String jmembercardid = request.getParameter("jmembercardid");
		String jlable = request.getParameter("jlable");
		String jdefault = request.getParameter("jdefault");
		String jlongitude = request.getParameter("jlongitude");
		String jlatitude = request.getParameter("jlatitude");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (!StringUtils.isEmpty(jid)) {
				tDeliveryAddress.setjId(Integer.parseInt(jid));
			}
			if(!StringUtils.isEmpty(jdeliveryman)) {
				tDeliveryAddress.setjDeliveryMan(jdeliveryman);
			}
			if(!StringUtils.isEmpty(jdeliveryphone)) {
				tDeliveryAddress.setjDeliveryPhone(jdeliveryphone);
			}
			if(!StringUtils.isEmpty(jaddress)) {
				tDeliveryAddress.setjAddress(jaddress);
			}
			if(!StringUtils.isEmpty(jaddressdetailed)) {
				tDeliveryAddress.setjAddressDetailed(jaddressdetailed);
			}
			if(!StringUtils.isEmpty(jlable)) {
				tDeliveryAddress.setjLable(jlable);
			}
			if(!StringUtils.isEmpty(jdefault)) {
				if(jdefault.equals("是")){
					int efault = this.tdaService.updateDefault(Integer.parseInt(jmembercardid));
				}
				tDeliveryAddress.setjDefault(jdefault);
			}
			if(!StringUtils.isEmpty(jlongitude)) {
				tDeliveryAddress.setjLongitude(jlongitude);
			}
			if(!StringUtils.isEmpty(jlatitude)) {
				tDeliveryAddress.setjLatitude(jlatitude);
			}
			int upaddress = this.tdaService.updateAddress(tDeliveryAddress);
			if(upaddress == 0){
				resultMap.put("data", upaddress);
				resultMap.put("code", "100002");
				resultMap.put("message", "修改收货地址失败！");
				resultList.add(resultMap);
			}else{
				resultMap.put("data", upaddress);
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
	//删除收货地址
	@RequestMapping("freshshop/deleteAddress")
	public void deleteAddress(HttpServletRequest request, HttpServletResponse response,TBasicSort tBasicSort) {
		PrintWriter pw = null;
		String jid = request.getParameter("jid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请选择要删除的收货地址！");
				resultList.add(resultMap);
			}  else {
				String[] j_id= jid.split(",");
				if(j_id.length > 0){
					for(int i=0;i<j_id.length;i++){
						int deladdress = this.tdaService.deleteAddress(Integer.parseInt(j_id[i]));
						/*if(deladdress == 1){
							resultMap.put("data", deladdress);
							resultMap.put("code", "100000");
							resultMap.put("message", "success");
							resultList.add(resultMap);
						}else{
							resultMap.put("data", deladdress);
							resultMap.put("code", "100002");
							resultMap.put("message", "商品删除失败！");
							resultList.add(resultMap);
						}*/
					}
					resultMap.put("data", "");
					resultMap.put("code", "100000");
					resultMap.put("message", "success");
					resultList.add(resultMap);
				}else{
					resultMap.put("data", "");
					resultMap.put("code", "100002");
					resultMap.put("message", "请选择要删除的商品！");
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
