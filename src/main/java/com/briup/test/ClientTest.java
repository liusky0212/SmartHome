package com.briup.test;

import java.util.Collection;

import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.util.Configuration;
import com.briup.smarthome.clientimpl.ClientImpl;
import com.briup.smarthome.clientimpl.GatherImpl;
import com.briup.smarthome.util.ConfigurationImpl;

//客户端测试类
public class ClientTest {
	public static void main(String[] args) {
/*		//创建采集模块对象
		Gather g = new GatherImpl();
		//创建网络模块对象
		Client c = new ClientImpl();
		//修改
			  c.send(g.gather());*/
		ConfigurationImpl conf = new ConfigurationImpl();
		try {
			Gather g = conf.getGather();
			Client c = conf.getClient();
			c.send(g.gather());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	
			
		
		
	}
}
