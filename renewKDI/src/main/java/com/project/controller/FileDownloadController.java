package com.project.controller;

import java.io.File;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadController {
	
	private static String CURR_IMAGE_REPO_PATH = "C:\\Users\\big1-02\\git\\renewkdi2\\renewKDI\\images";
	@RequestMapping("/eco_download/")
	protected void download(@RequestParam("imageName")String imageName, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String imagePath = CURR_IMAGE_REPO_PATH + "\\" + imageName;
		File image = new File(imagePath);
		int lastIndex = imageName.lastIndexOf(".");
		String fileName = imageName.substring(0, lastIndex);
		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".png");
		if(image.exists()) {
			Thumbnails.of(image).size(50, 50).outputFormat("png").toOutputStream(out);
		} else {
			return;
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
	}
}
