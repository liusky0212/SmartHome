package com.briup.environment.util;

import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.server.DBStore;
import com.briup.environment.server.Server;
/**
 * Simple to Introduction
 * @ProjectName:  ���ܼҾ�֮�������ϵͳ
 * @Package: com.briup.environment.util
 * @InterfaceName:  Configuration
 * @Description:  Configuration�ӿ��ṩ������ģ��Ĺ淶�� ����ģ��ͨ��ĳ�����÷�ʽ��Logger��Login��<br/>
 * 							 Gather��Client��Server��DBStore��ģ���ʵ�������ʵ������ ���ҽ�������Ҫ������Ϣ����<br/>
 * 							���ݡ�ͨ������ģ����Ի�ø���ģ���ʵ����
 * @CreateDate:   2018-1-25 14:28:30
 * @author briup
 * @Version: 1.0
 */
public interface Configuration {
	/**
	 * ��ȡ��־ģ���ʵ��
	 * @return ��־����
	 * @throws Exception
	 */
	public Log getLogger()throws Exception;
	/**
	 * ��ȡ�������˵�ʵ��
	 * @return ����������
	 * @throws Exception
	 */
	public Server getServer()throws Exception;
	/**
	 * ��ȡ�ͻ��˵�ʵ��
	 * @return  �ͻ��˶���
	 * @throws Exception
	 */
	public Client getClient()throws Exception;
	/**
	 * ��ȡ���ģ���ʵ��
	 * @return  ������
	 * @throws Exception
	 */
	public DBStore getDbStore()throws Exception;
	/**
	 * ��ȡ�ɼ�ģ���ʵ��
	 * @return  �ɼ�����
	 * @throws Exception
	 */
	public Gather getGather()throws Exception;
}
