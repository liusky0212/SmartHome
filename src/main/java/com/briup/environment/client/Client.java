package com.briup.environment.client;

import java.util.Collection;

import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModuleInit;
/**
 * Simple to Introduction
 * @ProjectName:  ���ܼҾ�֮�������ϵͳ
 * @Package: com.briup.environment.client
 * @InterfaceName:  Client
 * @Description:  Client�ӿ��ǲɼ�ϵͳ����ģ��ͻ��˵Ĺ淶.<br/>
 * 				Client�����þ�����������˽���ͨ��,��������
 * @CreateDate:   2018-1-25 14:28:30
 * @author briup
 * @Version: 1.0
 */
public interface Client extends WossModuleInit{
	/**
	 * send����������������˽��н���������Environment�������������ˡ�
	 * @param coll
	 * @throws Exception
	 */
	public void send(Collection<Environment> coll)throws Exception;
}
