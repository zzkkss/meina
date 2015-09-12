package com.gw.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gw.model.Images;
import com.gw.services.ImagesSer;
import com.gw.tools.ImageUtils;

@Controller
public class UnitsController {
	@Autowired
	private ImagesSer imagesSer;

	@RequestMapping({ "imgUpload", "background/imgUpload", "shop/imgUpload", "android/imgUpload" })
	@ResponseBody
	public String imgUpload(@RequestParam("file") MultipartFile[] file, HttpServletRequest request) {
		// MultipartFile是对当前上传的文件的封装，当要同时上传多个文件时，可以给定多个MultipartFile参数
		List<String> fileinname = new ArrayList<String>();
		for (int i = 0; i < file.length; i++) {
			if (!file[i].isEmpty()) {
				try {
					byte[] bytes = file[i].getBytes();
					System.out.println("开始" + i);
					String path = request.getSession().getServletContext().getRealPath("uploadimg");
					String fileName = file[i].getOriginalFilename();
					// String fileName = new Date().getTime()+".jpg";
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");// 设置日期格式
					System.out.println(df.format(new Date()));// new
																// Date()为获取当前系统时间
					// System.out.println(Initweb.imgPath);
					System.out.println(path);
					String n = df.format(new Date()) + "." + file[i].getOriginalFilename().split("\\.")[file[i].getOriginalFilename().split("\\.").length - 1];
					fileinname.add(n);
					// File targetFile = new File(Initweb.imgPath, n);
					File targetFile2 = new File(path, n);
					// if(!targetFile.exists()){
					// targetFile.mkdirs();
					// }
					if (!targetFile2.exists()) {
						targetFile2.mkdirs();
					}
					// 保存 修改文件大小
					try {
						file[i].transferTo(targetFile2);
						insertIntoImages(n, bytes);
						// copyFile(targetFile,targetFile2);
						// ImageUtils.resize(Initweb.imgPath,n, 0.2);
						// ImageUtils.resize(path,n, 0.2);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// model.addAttribute("fileUrl",
					// request.getContextPath()+"/upload/"+fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("文件为空" + i);
			}
		}
		return fileinname.toString();
	}
	@RequestMapping({ "BaiduImgUpload", "background/BaiduImgUpload", "shop/BaiduImgUpload", "android/BaiduImgUpload" })
	@ResponseBody
	public String BaiduImgUpload(@RequestParam("upfile") MultipartFile upfile, HttpServletRequest request) {
		// MultipartFile是对当前上传的文件的封装，当要同时上传多个文件时，可以给定多个MultipartFile参数
		String fileinname = "";
		String originalName="";
		long size=0;
			if (!upfile.isEmpty()) {
				try {
					byte[] bytes = upfile.getBytes();
					System.out.println("开始");
					String path = request.getSession().getServletContext().getRealPath("uploadimg");
					String fileName = upfile.getOriginalFilename();
					originalName=fileName;
					// String fileName = new Date().getTime()+".jpg";
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");// 设置日期格式
					System.out.println(df.format(new Date()));// new
																// Date()为获取当前系统时间
					// System.out.println(Initweb.imgPath);
					System.out.println(path);
					String n = df.format(new Date()) + "." + upfile.getOriginalFilename().split("\\.")[upfile.getOriginalFilename().split("\\.").length - 1];
					size = upfile.getSize();
					fileinname=(n);
					// File targetFile = new File(Initweb.imgPath, n);
					File targetFile2 = new File(path, n);
					// if(!targetFile.exists()){
					// targetFile.mkdirs();
					// }
					if (!targetFile2.exists()) {
						targetFile2.mkdirs();
					}
					// 保存 修改文件大小
					try {
						upfile.transferTo(targetFile2);
						insertIntoImages(n, bytes);
						// copyFile(targetFile,targetFile2);
						// ImageUtils.resize(Initweb.imgPath,n, 0.2);
						// ImageUtils.resize(path,n, 0.2);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// model.addAttribute("fileUrl",
					// request.getContextPath()+"/upload/"+fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("文件为空" );
			}
//		return fileinname.toString();
		 //{"name":"20150901015003003.jpg", "originalName": "china.jpg", "size": 43086, "state": "SUCCESS", "type": ".jpg", "url": "upload/20140616/10571402926855858.jpg"} 
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("name", fileinname);
		m.put("originalName", originalName);
		m.put("size", size);
		m.put("state", "SUCCESS");
		m.put("type", "."+originalName.split("\\.")[originalName.split("\\.").length-1]);
		m.put("url", "/"+fileinname);
		return "{\"name\":\""+fileinname+"\", \"originalName\": \""+originalName+"\",\"size\":"+size+", \"state\": \"SUCCESS\", \"type\": \"."+originalName.split("\\.")[originalName.split("\\.").length-1]+"\", \"url\": \""+fileinname+"\"} ";
		//{"originalName":"6873641_102016646123_2.jpg","size":42419,"name":"20150901025129397.jpg","state":"SUCCESS","type":".jpg","url":"/20150901025129397.jpg"}
		//return m;
	}
	private void insertIntoImages(String n, byte[] bytes) {
		// TODO Auto-generated method stub
		Images images = new Images();
		images.setName(n);
		Blob blob = Hibernate.createBlob(bytes);
		images.setImg(blob);

		imagesSer.save(images);
	}

	// 复制文件
	private void copyFile(File sourceFile, File targetFile) throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			// 新建文件输入流并对它进行缓冲
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

			// 新建文件输出流并对它进行缓冲
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();
		} finally {
			// 关闭流
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}
}
