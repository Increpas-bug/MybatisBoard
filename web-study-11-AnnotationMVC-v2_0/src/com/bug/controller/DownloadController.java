package com.bug.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownloadController {

	@RequestMapping(value = "/file_download.do", method = RequestMethod.GET)
	public void download(@RequestParam String filename, HttpServletRequest request, HttpServletResponse response) {
		{
			OutputStream outputStream = null;

			String upath = request.getServletContext().getRealPath("/upload");

			try {
				File file = new File(upath + filename);
				System.out.println(file.getName());
				String filetype = filename.substring(filename.indexOf(".") + 1, filename.length());

				if (filetype.trim().equalsIgnoreCase("txt")) {
					response.setContentType("text/plain");
				} else {
					response.setContentType("application/octet-stream");
				}

				response.setContentLength((int) file.length());

				boolean ie = request.getHeader("User-Agent").indexOf("MSIE") != -1;
				if (ie) {
					filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", " ");
				} else {
					filename = new String(filename.getBytes("UTF-8"), "8859_1");
				}

				response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

				outputStream = response.getOutputStream();
				FileInputStream fis = null;

				try {
					fis = new FileInputStream(file);
					FileCopyUtils.copy(fis, outputStream);
				} finally {
					if (fis != null) {
						fis.close();
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					outputStream.close();
					response.flushBuffer();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}