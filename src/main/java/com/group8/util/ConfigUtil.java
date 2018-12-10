package com.group8.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class ConfigUtil {

	public static Map getConfigMap() {
		//ConfigUtil.class获取运行时对象ConfigUtil的class类    getResourceAsStream 查找给定名称的资源
		InputStream inputStream = ConfigUtil.class.getResourceAsStream("/application.properties");

		//map接口的一个子类
		Properties properties = new Properties();
		                                 
		try {
			//加载上面方法读取到输入流的内容
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties;
	}
}
