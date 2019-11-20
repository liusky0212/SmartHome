package com.briup.smarthome.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.server.DBStore;
import com.briup.environment.server.Server;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.Log;
import com.briup.environment.util.WossModuleInit;

public class ConfigurationImpl implements Configuration {
	// 只能放其他模块对象,即所有模块类型的父类
	private Map<String, WossModuleInit> map = new HashMap<>();
	Properties pro = new Properties();

	public ConfigurationImpl() {
		this("src/main/resources/config.xml");
	}

	public ConfigurationImpl(String path) {
		// DOM4J解析
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(path);
			// System.out.println(document);
			// 根标签
			Element root = document.getRootElement();
			// 子节点
			List<Element> list = root.elements();
			// 遍历集合
			for (Element temp : list) {
				String clsname = temp.attributeValue("class");// 拿到属性的值
				// System.out.println(clsname);
				// 使用反射创建对象
				WossModuleInit obj = (WossModuleInit) Class.forName(clsname).newInstance();
				map.put(temp.getName(), obj);
				List<Element> list2 = temp.elements();
				for(Element temp2: list2) {
					pro.put(temp2.getName(), temp2.getText());
				}
				obj.init(pro);
			}
			//将自身引用this注入给其他模块
							//注入给其他模块Map集合
			for(WossModuleInit woss:map.values()) {
				if(woss instanceof ConfigurationAware) {
					((ConfigurationAware)woss).setConfiguration(this);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Log getLogger() throws Exception {

		return (Log) map.get("logger");
	}

	@Override
	public Server getServer() throws Exception {
		// TODO 自动生成的方法存根
		return (Server) map.get("server");
	}

	@Override
	public Client getClient() throws Exception {
		// TODO 自动生成的方法存根
		return (Client) map.get("client");
	}

	@Override
	public DBStore getDbStore() throws Exception {
		// TODO 自动生成的方法存根
		return (DBStore) map.get("dbstore");
	}

	@Override
	public Gather getGather() throws Exception {
		// TODO 自动生成的方法存根
		return (Gather) map.get("gather");
	}

	public static void main(String[] args) throws Exception {
		
		System.out.println(new ConfigurationImpl().getClient());
	}
}