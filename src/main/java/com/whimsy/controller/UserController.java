package com.whimsy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.whimsy.entity.TDepartment;
import com.whimsy.entity.TMemberCard;
import com.whimsy.entity.TMsgCode;
import com.whimsy.entity.TUserGroup;
import com.whimsy.entity.TUsers;
import com.whimsy.service.TDepartmentService;
import com.whimsy.service.TUserGroupService;
import com.whimsy.service.TUsersService;
import com.whimsy.util.tokenSign;

@Controller
public class UserController {
	@Autowired
	private TUsersService userService;
	
	@Autowired
	private TUserGroupService groupService;
	
	@Autowired
	private TDepartmentService tdService;

	// ��̨�û���¼
	@RequestMapping("backshop/userLogin")
	public void getMsgCode(HttpServletRequest request, HttpServletResponse response,TMemberCard tMemberCard,TMsgCode tMsgCode) throws Exception {
		PrintWriter pw = null;
		String jusercode = request.getParameter("jusercode");
		String jpassword = request.getParameter("jpassword");
		String callback = request.getParameter("callback");
		String tokens = request.getParameter("token");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		try {
			pw = response.getWriter();
			HttpSession session = request.getSession();
			if(!StringUtils.isEmpty(tokens)){
				if(session.getAttribute("token").equals(tokens)){
					resultMap.put("user", session.getAttribute("user"));
					resultMap.put("dept", session.getAttribute("dept"));
					resultMap.put("code", "100000");
					resultMap.put("message", "seccess");
				}else{
					resultMap.put("dept", "");
					resultMap.put("code", "100002");
					resultMap.put("message", "token��֤ʧ�ܣ������µ�¼��");
				}
			}else{
				if (StringUtils.isEmpty(jusercode)) {
					resultMap.put("data", "");
					resultMap.put("code", "100002");
					resultMap.put("message", "��¼�˺Ų���Ϊ�գ�");
					resultList.add(resultMap);
				} else if (StringUtils.isEmpty(jpassword)) {
					resultMap.put("data", "");
					resultMap.put("code", "100002");
					resultMap.put("message", "��¼���벻��Ϊ�գ�");
					resultList.add(resultMap);
				} else {
					TUsers user = this.userService.selectUser(jusercode, jpassword);
					if(user == null){
						resultMap.put("data", "");
						resultMap.put("code", "100002");
						resultMap.put("message", "��������ȷ���˺����룡");
					}else{
						TUserGroup group = this.groupService.selectGroup(user.getJusergroupid());
						if(group == null){
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "����½���˺��޷��飡");
						}else if (group.getJgroupname().equals("����Ա��")){
							List<TDepartment> userone = this.tdService.selectOne(user.getJid());
							if(userone.size() == 1){
								//����token
								Map<String, String> tdataMap = new HashMap<String, String>();
								long t1 = System.currentTimeMillis();
								String sR=Long.toString(t1) + jusercode + jpassword;
								tdataMap.put("data", sR);
								String token = tokenSign.createSign(tdataMap, true);
								
								session.setAttribute("token", token);
								session.setAttribute("dept", userone);
								session.setAttribute("user", user);
								resultMap.put("user", user);
								resultMap.put("token", token);
								resultMap.put("dept", userone);
								resultMap.put("code", "100000");
								resultMap.put("message", "seccess");
								Cookie c = new Cookie(new Gson().toJson(resultMap).toString(), token);     
								response.addCookie(c);
							}else{
								resultMap.put("data", "");
								resultMap.put("code", "100002");
								resultMap.put("message", "����½���˺Ŵ���");
							}
						}else if (group.getJgroupname().equals("�곤��")){
							List<TDepartment> usertwo = this.tdService.selectTwo(user.getJid());
							if(usertwo.size() == 1){
								//����token
								Map<String, String> tdataMap = new HashMap<String, String>();
								long t1 = System.currentTimeMillis();
								String sR=Long.toString(t1) + jusercode + jpassword;
								tdataMap.put("data", sR);
								String token = tokenSign.createSign(tdataMap, true);
								
								session.setAttribute("token", token);
								session.setAttribute("dept", usertwo);
								session.setAttribute("user", user);
								resultMap.put("user", user);
								resultMap.put("token", token);
								resultMap.put("dept", usertwo);
								resultMap.put("token", token);
								resultMap.put("data", usertwo);
								resultMap.put("code", "100000");
								resultMap.put("message", "seccess");
								Cookie c = new Cookie(new Gson().toJson(resultMap).toString(), token);     
								response.addCookie(c);
							}else{
								resultMap.put("data", "");
								resultMap.put("code", "100002");
								resultMap.put("message", "����½���˺Ŷ�Ӧ������̣�");
							}
						}else{
							resultMap.put("data", "");
							resultMap.put("code", "100002");
							resultMap.put("message", "����½���˺�û��Ȩ�޽��룡");
						}
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
			pw.write(callback+"("+new Gson().toJson(resultMap).toString()+")");
			pw.close();
			
		}
	}
}
