package com.briup.smarthome.clientimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.dom4j.io.SAXReader;

import com.briup.environment.bean.Environment;
import com.briup.environment.client.Client;
import com.briup.environment.util.Configuration;
import com.briup.smarthome.serverimpl.TCPServerImpl;
import com.briup.smarthome.util.ConfigurationAware;
import com.briup.smarthome.util.ConfigurationImpl;
import com.briup.smarthome.util.LogImpl;

//客户端的网络模块实现类
public class ClientImpl implements Client, ConfigurationAware{
	Socket socket = null;
	ObjectOutputStream oos = null;
	BufferedReader br = null;
	private String ip;
	private Integer port;
	LogImpl log = new LogImpl(Logger.getLogger(ClientImpl.class)) ;
	private Configuration conf;
	@Override
	public void init(Properties prop) throws Exception {
		ip = prop.getProperty("ip");
		port = Integer.valueOf(prop.getProperty("port"));
		
	}

	@Override
	public void send(Collection<Environment> coll) throws Exception {

		try {
			//创建socket对象，连接服务器端
			socket = new Socket(ip, port);
			//System.out.println("连接数据库成功，开始发送数据");
			log.info("连接服务器成功，开始发送数据");
			//客户端发送数据给服务器端
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(coll);
			oos.flush();
			//读取服务器端发送过来的数据
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String msg = br.readLine();
			System.out.println("=================");
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (br != null)br.close();
				if (oos != null)oos.close();
				if (socket != null)socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void setConfiguration(Configuration conf) {
		this.conf = conf;
		
	}

}
