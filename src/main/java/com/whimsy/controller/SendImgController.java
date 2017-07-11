package com.whimsy.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller
public class SendImgController {
	@RequestMapping(value = "upLoad")
	public String upLoad(@RequestParam("file")CommonsMultipartFile[] files,HttpServletRequest request,HttpSession session) {
		String savePath = request.getSession().getServletContext().getRealPath("upload");
		String[] filePaths = (String[]) session.getAttribute("fList");
		if (filePaths==null) {
			filePaths = new String[9];
		}
		if(files[0].getSize()>0){
			filePaths = uploadFile(savePath,files);
		}
		session.setAttribute("fList", filePaths);
			return "main";
	}

	private String[] uploadFile(String savePath, CommonsMultipartFile[] files) {
		String[] filePaths = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getOriginalFilename();
			File targetFile = new File(savePath,fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			//保存
			try {
				files[i].transferTo(targetFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			filePaths[i] ="upload/"+fileName;
		}
		return filePaths;
	}

}
