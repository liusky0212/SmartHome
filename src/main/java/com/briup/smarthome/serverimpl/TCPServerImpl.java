package com.briup.smarthome.serverimpl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.environment.bean.Environment;
import com.briup.environment.server.DBStore;
import com.briup.environment.server.Server;
import com.briup.environment.util.Configuration;
import com.briup.smarthome.DBStore.DBStoreImpl;
import com.briup.smarthome.util.ConfigurationAware;
import com.briup.smarthome.util.ConfigurationImpl;
import com.briup.smarthome.util.LogImpl;

public class TCPServerImpl implements Server,ConfigurationAware {
	ServerSocket ss = null;
	Socket socket = null;
	ObjectInputStream ois = null;
	PrintWriter pw = null;
	LogImpl log = new LogImpl(Logger.getLogger(TCPServerImpl.class)) ;
	Collection<Environment> coll = new ArrayList<Environment>();
	private Integer port;
	private Configuration conf ;
	

	@Override
	public void init(Properties prop) throws Exception {
		port = Integer.valueOf(prop.getProperty("port"));
	}

	@Override
	public Collection<Environment> reciver() throws Exception {

		try {
			ss = new ServerSocket(port);
			log.info("服务器9999已启动");
			//System.out.println("服务器9999已启动");
			while (true) {
				// 等待客户端连接
				socket = ss.accept();
				log.info("客户端已连接，开始接收数据");
				//System.out.println("客户端已连接，开始接收数据");
				// 接收客户端发送的数据
				InputStream is = socket.getInputStream();
				ois = new ObjectInputStream(is);
				coll = (Collection<Environment>) ois.readObject();
				log.info("接收成功");

				// 测试
				/*
				 * System.out.println(coll.size()); int i = 0; for (Environment temp : coll) {
				 * if (i >= 10) break; System.out.println(temp); i++; }
				 */
				pw = new PrintWriter(socket.getOutputStream());
				pw.println("传输成功,开始入库");
				pw.flush();
				
				// 调用入库模块的方法将数据入库
				log.info("准备入库");
				//System.out.println("准备入库");
				DBStore db = conf.getDbStore();
				db.saveDb(coll);
				log.info("入库成功");
				//System.out.println("入库成功");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			shutdown();

		}
		return coll;

	}

	@Override
	public void shutdown() {
		try {
			if (pw != null)
				pw.close();
			if (ois != null)
				ois.close();
			if (socket != null)
				socket.close();
			if (ss != null)
				ss.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void setConfiguration(Configuration conf) {
		this.conf = conf;
		
	}

}
