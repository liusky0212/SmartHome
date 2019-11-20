package com.briup.test;

import java.util.Collection;

import com.briup.environment.bean.Environment;
import com.briup.environment.client.Gather;
import com.briup.environment.server.Server;
import com.briup.environment.util.Configuration;
import com.briup.smarthome.serverimpl.TCPServerImpl;
import com.briup.smarthome.util.ConfigurationImpl;

public class ServerTest {
	public static void main(String[] args) throws Exception {
		
	Configuration conf = new ConfigurationImpl();
	Server s = conf.getServer();
	s.reciver();
	
	}
	
}
