package com.reactx.selection.models.base.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * base64 文件
 * 
 * @author Mr.han
 *
 */
public class FileData {
	private String uuid;
	private String base64String;
	private String mine;// 信息
	private String suffix;// 文件后缀
	private String data;// Base64原始码
	private boolean isError;// 判断是否参数有误
	private String fileName;

	public boolean isError() {
		return isError;
	}

	public FileData() {
		super();
	}

	/**
	 * 源字符串 直接解析
	 * 
	 * @param original
	 */
	public FileData(String original) {
		super();
		String[] temps = original.split(",");
		try {
			this.mine = temps[0];
			this.data = temps[1];
			this.uuid = UUID.randomUUID().toString();
			this.suffix = handleSuffix(mine);
			this.fileName = uuid + "." + this.suffix;
			this.setError(false);
		} catch (Exception e) {
			this.setError(true);
		}
	}

	public String getMine() {
		return mine;
	}

	public void setMine(String mine) {
		this.mine = mine;
		this.suffix = handleSuffix(mine);
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * 用于解析两个匹配字符中间的数据。
	 * 
	 * @param mine
	 * @return
	 */
	private String handleSuffix(String mine) {
		String regext = "(?<=(data:image/))(.?)*(?=(;base64))";
		Pattern pattern = Pattern.compile(regext);
		Matcher matcher = pattern.matcher(mine);
		while (matcher.find()) {
			return matcher.group();
		}
		return "";

	}

	public String getBase64String() {
		return base64String;
	}

	public void setBase64String(String base64String) {
		this.base64String = base64String;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}