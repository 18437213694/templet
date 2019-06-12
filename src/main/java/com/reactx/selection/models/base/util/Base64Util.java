package com.reactx.selection.models.base.util;

import java.io.File;

@SuppressWarnings("all")
public class Base64Util {

	public static String base64StrToImage(String imgStr, String path) {
		try {
			FileData fileData = new FileData(imgStr);
			if (fileData.isError()) {
				return "文件类型错误！";
			}
			String filePath = path + "images" + File.separator + fileData.getFileName();
			Base64ImageUtil.convertByteToImage(fileData.getData(), filePath, fileData.getSuffix());
			String outUrl = "images/" + fileData.getFileName();
			return outUrl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
