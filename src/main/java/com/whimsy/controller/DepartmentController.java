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
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.whimsy.entity.TDepartment;
import com.whimsy.entity.TDeptScope;
import com.whimsy.service.TDepartmentService;
import com.whimsy.service.TDeptScopeService;

@Controller
public class DepartmentController {
	
	@Autowired
	private TDepartmentService tdService;
	
	@Autowired
	private TDeptScopeService tdspService;
	
	// 获取店铺信息
	@RequestMapping("freshshop/getAllDepartment")
	public void getAllDepartment(HttpServletRequest request, HttpServletResponse response,TDepartment tDepartment) {
		PrintWriter pw = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			List<TDepartment> deptresult = this.tdService.selectAll(tDepartment);
			if(deptresult.size() == 0){
				resultMap.put("data", deptresult);
				resultMap.put("code", "100002");
				resultMap.put("message", "暂时没有店铺信息！");
			}else{
				for(int i = 0 ; i < deptresult.size() ; i ++){
					List<TDeptScope> scope = this.tdspService.selectScope(deptresult.get(i).getJid());
					Map<String, Object> result = new HashMap<String, Object>();
					result.put("scope", scope);
					result.put("dept", deptresult.get(i));
					resultList.add(result);
				}
				resultMap.put("data", resultList);
				resultMap.put("code", "100000");
				resultMap.put("message", "success");
			}
		} catch (IOException e) {
			resultMap.put("data", "");
			resultMap.put("code", "100001");
			resultMap.put("message", "服务器异常，请稍后重试！");
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
	}
}
