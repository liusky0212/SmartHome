package com.briup.test;

import java.util.Collection;

import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.util.Configuration;
import com.briup.smarthome.clientimpl.ClientImpl;
import com.briup.smarthome.clientimpl.GatherImpl;
import com.briup.smarthome.util.ConfigurationImpl;

//�ͻ��˲�����
public class ClientTest {
	public static void main(String[] args) {
/*		//�����ɼ�ģ�����
		Gather g = new GatherImpl();
		//��������ģ�����
		Client c = new ClientImpl();
		//�޸�
			  c.send(g.gather());*/
		ConfigurationImpl conf = new ConfigurationImpl();
		try {
			Gather g = conf.getGather();
			Client c = conf.getClient();
			c.send(g.gather());
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	
			
		
		
	}
}
