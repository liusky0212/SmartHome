package com.briup.environment.util;
/**
 * Simple to Introduction
 * @ProjectName:  ���ܼҾ�֮�������ϵͳ
 * @Package: com.briup.environment.util
 * @InterfaceName:  Log
 * @Description:  �ýӿ��ṩ����־ģ��Ĺ淶�� ��־ģ�齫��־��Ϣ����Ϊ���ּ���<br/>
 * 			 ���岻ͬ�������־�ļ�¼�ĸ�ʽ����¼��ʽ�������о���ʵ������������
 * @CreateDate:   2018-1-25 14:28:30
 * @author briup
 * @Version: 1.0
 */
public interface Log extends WossModuleInit{
	/**
	 * ��¼Debug�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void debug(String message);
	/**
	 * ��¼Info�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void info(String message);
	/**
	 * ��¼Warn�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void warn(String message);
	/**
	 * ��¼Error�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void error(String message);
	/**
	 * ��¼Fatal�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void fatal(String message);
}
