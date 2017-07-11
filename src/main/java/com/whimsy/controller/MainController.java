package com.whimsy.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.whimsy.entity.TBasicSort;
import com.whimsy.entity.TMain;
import com.whimsy.service.TMainService;

@Controller
public class MainController {

	@Autowired
	private TMainService tMainService;
	
	//查看首页
	@RequestMapping("freshshop/getMain")
	public void getActivity(HttpServletRequest request, HttpServletResponse response,TMain tMain) {
		PrintWriter pw = null;
		String jdepartmentid = request.getParameter("jdepartmentid");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		tMain.setjDeptId(Integer.parseInt(jdepartmentid));
		try {
			pw = response.getWriter();
			if (StringUtils.isEmpty(jdepartmentid)) {
				resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "请输入店铺ID！");
				resultList.add(resultMap);
			} else {
				Map<String, Object> AllList = new HashMap<String, Object>();
				List<TMain> keyword = this.tMainService.selectKeyword(tMain);
				AllList.put("Keyword", keyword);
				
				List<TMain> banner = this.tMainService.selectBanner(tMain);
				AllList.put("Banner", banner);
				
				List<TMain> xbanner = this.tMainService.selectxBanner(tMain);
				AllList.put("Xbanner", xbanner);
				
				List<TMain> kind = this.tMainService.selectMainKind(tMain);
				AllList.put("Mainkind", kind);
				
				List<TMain> activity = this.tMainService.selectActivity(tMain);
				AllList.put("Activity", activity);
				
				List<TMain> tgoods = this.tMainService.selectTGoods(tMain);
				AllList.put("Tgoods", tgoods);
				
				resultMap.put("data", AllList);
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
}
