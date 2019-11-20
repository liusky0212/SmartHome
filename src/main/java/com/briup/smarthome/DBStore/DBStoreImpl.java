package com.briup.smarthome.DBStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.environment.bean.Environment;
import com.briup.environment.server.DBStore;
import com.briup.environment.util.Configuration;
import com.briup.smarthome.serverimpl.TCPServerImpl;
import com.briup.smarthome.util.ConfigurationAware;
import com.briup.smarthome.util.LogImpl;

public class DBStoreImpl implements DBStore ,ConfigurationAware{
	private String driver;
	private String url;
	private String username;
	private String password;
	private Integer batchSize;
	LogImpl log = new LogImpl(Logger.getLogger(DBStoreImpl.class));
	private Configuration conf;

	@Override
	public void init(Properties prop) throws Exception {
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		batchSize = Integer.valueOf(prop.getProperty("batch-size"));
		//System.out.println(driver+url+user+password+batchSize);

	}

	@Override
	public void saveDb(Collection<Environment> coll) throws Exception {
		int count = 0;
		int mday = -1;// ��¼��һ�����ݵ���

		// ע��
		Class.forName(driver);
		System.out.println(driver);
		// ��ȡ���ݿ�����
		Connection conn = DriverManager.getConnection(url, username, password);
		log.info("���������ݿ�");;
		// ��ȡpreparedstatement����
		PreparedStatement pst = null;
		// �ر��Զ��ύ
		Calendar c = Calendar.getInstance();
		conn.setAutoCommit(false);
		int size = coll.size();
		log.info("����Ϊ" + size);
		// System.out.println(coll.size());
		try {
			for (Environment temp : coll) {
				count++;
				// ��ȡday
				c.setTime(new Date(temp.getGather_date().getTime()));
				int day = c.get(Calendar.DAY_OF_MONTH);

				if (mday != day) {
					if (pst != null) {// �޸�����ǰ�����ύ������ǰһ��δ�����������
						pst.executeBatch();
						pst.clearBatch();// ���
						pst.close();
					}
					String sql = "insert into e_detail_" + day + " values(?,?,?,?,?,?,?,?,?)";
					// System.out.println(sql);
					pst = conn.prepareStatement(sql);
					mday = day;
				}
				// System.out.println(day);

				pst.setString(1, temp.getName());
				pst.setString(2, temp.getSrcId());
				pst.setString(3, temp.getDstId());
				pst.setString(4, temp.getSersorAddress());
				pst.setLong(5, temp.getCount());
				pst.setString(6, temp.getCmd());
				pst.setInt(7, temp.getStatus());
				pst.setFloat(8, temp.getData());
				pst.setTimestamp(9, temp.getGather_date());
				pst.addBatch();

				if (count%batchSize == 0) {
					System.out.println(count);
					pst.executeBatch();
					pst.clearBatch();
				}
			}
			pst.executeBatch();
			conn.commit();
		} catch (Exception e) {
			log.error("���ʧ��");
			conn.rollback();
		}

	}

	@Override
	public void setConfiguration(Configuration conf) {
		this.conf = conf;
		
	}
}
