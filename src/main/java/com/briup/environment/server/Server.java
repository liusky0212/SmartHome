package com.briup.environment.server;

import java.util.Collection;

import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModuleInit;
/**
 * Simple to Introduction
 * @ProjectName:  ���ܼҾ�֮�������ϵͳ
 * @Package: com.briup.environment.server
 * @InterfaceName:  Server
 * @Description:  Server�ӿ��ṩ�˲ɼ�ϵͳ����ģ��������˵ı�׼�� Server��ʵ����<br/>
 * 		��Ҫʵ����ɼ����Ϳͻ��˽��н�����������DBStore�����յ����ݳ־û���<br/>
 *     ��Server��ʵ����ִ��revicer()����ʱ��Server��ʼ�����˿ڡ�
 * @CreateDate:   2018-1-25 14:28:30
 * @author briup
 * @Version: 1.0
 */
public interface Server extends WossModuleInit{
	/**
	 * �÷��������������Server���񣬿�ʼ���տͻ��˴��ݵ���Ϣ��<br/>
	 * ���ҵ���DBStore�����յ����ݳ־û�
	 * @return ���ܵ�Environment���ݵļ���
	 * @throws Exception
	 */
	public Collection<Environment> reciver()throws Exception;
	/**
	 * �÷�������ʹServer��ȫ��ֹͣ���С�
	 */
	public void shutdown();
}
