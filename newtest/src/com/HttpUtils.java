package com;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.apache.commons.httpclient.auth.AuthScope;  
import org.apache.commons.httpclient.UsernamePasswordCredentials;


public class HttpUtils {
	private static final Log logger = LogFactory.getLog(HttpUtils.class);
	
	public static String post(String url, String content) throws Exception {
		System.out.println(url);
		PostMethod post = new PostMethod(url);
		if (content != null) {
			RequestEntity entity = new StringRequestEntity(content,
					"application/json", "UTF-8");
			post.setRequestEntity(entity);
			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");  
		}
		HttpClient httpclient = new HttpClient();
		httpclient.getState().setCredentials(AuthScope.ANY,   new UsernamePasswordCredentials("admin", "hyyd"));
		try {
			int result = httpclient.executeMethod(post);
			String res = post.getResponseBodyAsString();
			logger.info("Response status code: " + result);
			logger.info("Response body: ");
			if (StringUtils.isNotBlank(res) && res.length() > 500) {
				logger.info(res.substring(0, 500) + "...");
			}
			if (result > 299) {
				throw new RuntimeException(res);
			}
			return res;
		} finally {
			post.releaseConnection();
		}
	}
}
