package com.reactx.selection.models.base.util;
/*package com.hzluyi.base.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hzluyi.base.model.pojo.NoticeSmsRequestBean;
import com.hzluyi.base.model.pojo.VerifiCode;

*//**
 * 短信验证码工具类
 * 
 * @author Administrator
 *
 *//*
public class VerifiCodeUtil {
	private static Logger logger = LoggerFactory.getLogger(VerifiCodeUtil.class);

	private static final int HTTP_STATUS_200 = 200;
	private static final int HTTP_STATUS_201 = 201;
	
	public static boolean sendSms(String mobile, String massage) {
		System.err.println(mobile+"-----------------------------,"+massage);
		logger.info("【1.发送验证码,手机号码:{},massage:{}】", mobile,massage);
		NoticeSmsRequestBean bean = new NoticeSmsRequestBean();
		bean.setTo(mobile);
		bean.setContent("【嘀嘀送水】您的短信验证码为" + massage + "，请注意查收!");
		bean.setReport_url("www.baidu.com");
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> headMap = new HashMap<String, String>();
		headMap.put("Token", "5923976bc25310000712944c844be28f");
		try {                                                    
			String result = VerifiCodeUtil.httpPostHeadWithJSON("http://www.iamyun.net:8080/api/notice/sms",
					objectMapper.writeValueAsString(bean), headMap);
			// result:{"status":"0","desc":"success","msg_id":"149761762295417659337628"}
			logger.info("【2.发送验证码,返回值消息:{}】", result);
			if (result != null) {
				VerifiCode verifiCode = new Gson().fromJson(result, VerifiCode.class);
				if ("0".equals(verifiCode.getStatus())) {
					logger.info("【3.发送验证码,成功】");
					return true;
				}
				logger.info("【3.发送验证码,失败】");
				return false;
			}
		} catch (Exception e) {
			logger.error("【3.发送验证码失败,手机号码:{},ex:{}】", mobile, e.getMessage());
		}
		return false;
	}

	public static String httpPostHeadWithJSON(String url, String json, Map<String, String> headMap) throws Exception {
		 创建HttpClient实例 
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
		StringEntity se = new StringEntity(json, "UTF-8");
		httpPost.setEntity(se);
		if (headMap != null) {
			for (Iterator<String> it = headMap.keySet().iterator(); it.hasNext();) {
				String key = it.next();
				String value = headMap.get(key);

				httpPost.addHeader(key, value);
			}
		}
		String result = null;
		try {
			HttpResponse response = httpClient.execute(httpPost);
			boolean success = response.getStatusLine().getStatusCode() == HTTP_STATUS_200
					|| response.getStatusLine().getStatusCode() == HTTP_STATUS_201;
			if (success) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instreams = entity.getContent();
					result = convertStreamToString(instreams);
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			httpPost.releaseConnection();
		}
		return result;
	}

	public static String convertStreamToString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while ((line = reader.readLine()) != null) {
				if (sb.length() == 0) {
					sb.append(line);
				} else {
					sb.append("\n" + line);
				}
			}
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				throw e;
			}
		}
		return sb.toString();
	}

	*//**
	 * 产生6位随机数验证码
	 * 
	 * @return
	 *//*
	public static String getCode() {
		Random rad = new Random();
		String result = rad.nextInt(1000000) + "";
		if (result.length() != 6) {
			return getCode();
		}
		return result;
	}
}
*/