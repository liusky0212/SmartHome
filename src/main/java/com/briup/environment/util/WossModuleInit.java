package com.briup.environment.util;

import java.util.Properties;
/**
 * Simple to Introduction
 * @ProjectName:  ���ܼҾ�֮�������ϵͳ
 * @Package: com.briup.environment.util
 * @InterfaceName:  WossModuleInit
 * @Description:  �ýӿ��ǳ�����ģ�����������ģ��ĸ��ӿڡ�<br/>
 * 			����ģ����ճ�ʼ��������Ϣ��ע������ģ�顣
 * @CreateDate:   2018-1-25 14:28:30
 * @author briup
 * @Version: 1.0
 */
public interface WossModuleInit {
	/**
	 * ������Ҫ��������Ϣ���ݽ����࣬����õ�������Ϣ����г�ʼ����<br/>
	 * ������ִ�и�����������֮ǰ����ִ���������
	 * @param properties һ��Propertiesʵ����װ�˳�ʼ������ĸ���������Ϣ
	 * @throws Exception
	 */
	public void init(Properties properties)throws Exception;
}
