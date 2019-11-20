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
	// ֻ�ܷ�����ģ�����,������ģ�����͵ĸ���
	private Map<String, WossModuleInit> map = new HashMap<>();
	Properties pro = new Properties();

	public ConfigurationImpl() {
		this("src/main/resources/config.xml");
	}

	public ConfigurationImpl(String path) {
		// DOM4J����
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(path);
			// System.out.println(document);
			// ����ǩ
			Element root = document.getRootElement();
			// �ӽڵ�
			List<Element> list = root.elements();
			// ��������
			for (Element temp : list) {
				String clsname = temp.attributeValue("class");// �õ����Ե�ֵ
				// System.out.println(clsname);
				// ʹ�÷��䴴������
				WossModuleInit obj = (WossModuleInit) Class.forName(clsname).newInstance();
				map.put(temp.getName(), obj);
				List<Element> list2 = temp.elements();
				for(Element temp2: list2) {
					pro.put(temp2.getName(), temp2.getText());
				}
				obj.init(pro);
			}
			//����������thisע�������ģ��
							//ע�������ģ��Map����
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
		// TODO �Զ����ɵķ������
		return (Server) map.get("server");
	}

	@Override
	public Client getClient() throws Exception {
		// TODO �Զ����ɵķ������
		return (Client) map.get("client");
	}

	@Override
	public DBStore getDbStore() throws Exception {
		// TODO �Զ����ɵķ������
		return (DBStore) map.get("dbstore");
	}

	@Override
	public Gather getGather() throws Exception {
		// TODO �Զ����ɵķ������
		return (Gather) map.get("gather");
	}

	public static void main(String[] args) throws Exception {
		
		System.out.println(new ConfigurationImpl().getClient());
	}
}