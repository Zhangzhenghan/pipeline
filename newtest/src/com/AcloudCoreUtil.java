package com;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.jxpath.JXPathContext;

import com.thunisoft.artery.util.file.ArteryFileUtil;

public class AcloudCoreUtil {
	
	/**
	 * 获取属性
	 * @param data
	 * @param xpath
	 * @return
	 */
	public static Object getDatabyXpath(Object data,String xpath){
		return getDatabyXpath(data,xpath,false);
	}
	
	/**
	 * 获取数据
	 * @param data
	 * @param xpath
	 * @param allmatch 是否包含所有匹配，如果为true，则返回list
	 * @return
	 */
	public static Object getDatabyXpath(Object data,String xpath,Boolean allmatch){
		List<Object> results= new ArrayList<Object>();
		if (data == null) {
			return null;
		}
		JXPathContext context = JXPathContext.newContext(data);
		context.setLenient(true);
		if (!allmatch) {
			return context.getValue(xpath);
		}
		Iterator iter = context.iterate(xpath);
		while(iter.hasNext()){
			results.add(iter.next());
		}
		return results;
	}
	
//	/**
//	 * 获取版本
//	 * @return
//	 */
//	public static String getVersion(){
//		File version = new File("/version");
//		if (version.exists()) {
//			String ver = ArteryFileUtil.readFileToString(version, "UTF-8");
//			if (StringUtils.isNotBlank(ver)) {
//				return replaceBlank(ver);
//			}
//		}
//		return "latest";
//	}
//	
//	/**
//	 * 获取ip
//	 * @return
//	 */
//	public static String getIp(){
//		File ipFile = new File("/ip");
//		if (ipFile.exists()) {
//			String ip = ArteryFileUtil.readFileToString(ipFile, "UTF-8");
//			if (StringUtils.isNotBlank(ip)) {
//				return replaceBlank(ip);
//			}
//		}
//		return "";
//	}
//	
//	/**
//	 * 替换成空
//	 * @param str
//	 * @return
//	 */
//	private static String replaceBlank(String str){
//		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
//		Matcher m = p.matcher(str);
//		return m.replaceAll("");
//	}
//	
//	/**
//	 * 获取易读的文件大小
//	 * @param file
//	 * @return
//	 */
//	public static String getFileSize(File file) {
//		String size = "";
//		if (file.exists() && file.isFile()) {
//			long fileS = file.length();
//			DecimalFormat df = new DecimalFormat("#.00");
//			if (fileS < 1024) {
//				size = df.format((double) fileS) + "B";
//			} else if (fileS < 1048576) {
//				size = df.format((double) fileS / 1024) + "KB";
//			} else if (fileS < 1073741824) {
//				size = df.format((double) fileS / 1048576) + "MB";
//			} else {
//				size = df.format((double) fileS / 1073741824) + "GB";
//			}
//		} else if (file.exists() && file.isDirectory()) {
//			size = "";
//		} else {
//			size = "0B";
//		}
//		return size;
//	}
//	
//	/**
//	 * 获取镜像名称及版本
//	 * 
//	 * @param image
//	 * @return
//	 */
//	public static String[] getImageInfo(String image) {
//		if (StringUtils.isBlank(image)) {
//			return null;
//		}
//		image = image.replaceFirst(CoreConstant.REGISTRY, "");
//		String[] tmp = image.split(":");
//		String name = tmp[0];
//		String version = tmp.length == 2 ? tmp[1] : "latest";
//		return new String[] { name, version };
//	}
}
