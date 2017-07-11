package com.whimsy.filter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.whimsy.entity.TMemberCard;
import com.whimsy.service.TMemberCardService;



public class LoginFilter implements Filter {
	private String loginPage;
	private List<String> notCheckURLList = new ArrayList<String>();

	@Autowired
	private TMemberCardService tmService;
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		
		String uri = httpRequest.getServletPath();
		
		//Ãﬁ≥˝≤ªπ˝¬À¬∑
		if(checkRequestURIInNotFilterList(httpRequest, httpResponse, null)){
			chain.doFilter(request,response);
			return;
		}
		
		TMemberCard token = (TMemberCard) session.getAttribute("token");
		if(token==null){
			request.setAttribute("LoginMsg", "…–Œ¥µ«¬º");
			/*request.getRequestDispatcher("").forward(request,response);*/
			//String url = httpRequest.getContextPath();
			//httpResponse.sendRedirect(url+"/login.jsp");
		}
		
		/*chain.doFilter(request, response);*/
		
	}

	public void init(FilterConfig config) throws ServletException {
		//ÁôªÂΩïÈ°µÈù¢
		loginPage = config.getInitParameter("loginPage");
		//‰∏çËøáÊª§Ë∑Ø
		String ls_URLExclued = config.getInitParameter("excludedCheckURLList");
		if (ls_URLExclued != null) {
			StringTokenizer lstrtk_URLExcluded = new StringTokenizer(
					ls_URLExclued, ";");
			notCheckURLList.clear();
			for (; lstrtk_URLExcluded.hasMoreTokens(); 
			notCheckURLList.add(lstrtk_URLExcluded.nextToken()));
		}
	}
	
	private boolean checkRequestURIInNotFilterList(HttpServletRequest request,HttpServletResponse response,TMemberCard tMemberCard)
	{
		String uri = request.getServletPath();
		Map<String, Object> resultMap = new HashMap<String, Object>();
   		List<Object> resultList = new ArrayList<Object>();
   		
   		if (request.getPathInfo() != null){
			uri = (new StringBuilder(String.valueOf(uri))).append(request.getPathInfo()).toString();
   		}
   		if(uri.contains("freshshop")){
			if(uri.contains("/freshshop/getMsgCode") || uri.contains("/freshshop/phoneRigester") || uri.contains("/freshshop/wechat") || uri.contains("/freshshop/libwechat") || uri.contains("/resources/") ){
				return true;
			}else{
				try {
					String jtoken = request.getParameter("jtoken");
					if(jtoken == null){	
						PrintWriter pw = null;
						pw = response.getWriter();
						resultMap.put("data", "");
						resultMap.put("code", "100003");
						resultMap.put("message", "not logged");
						resultList.add(resultMap);
						pw.write(new Gson().toJson(resultMap));
						pw.close();
						return false;
					}else{
						return true;
					}
				
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else if(uri.contains("backshop")){
			return true;
		}
		return notCheckURLList.contains(uri);
	}
}
