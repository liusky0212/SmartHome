package com.briup.environment.client;

import java.util.Collection;
import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModuleInit;
/**
 * Simple to Introduction
 * @ProjectName:  ���ܼҾ�֮�������ϵͳ
 * @Package: com.briup.environment.client
 * @InterfaceName:  Gather
 * @Description:  Gather�ӿڹ涨�˲ɼ�ģ����Ӧ�еķ���.��Gatherִ��gather()����ʱ<br>
 * 		��ʼ�����ܼҾӻ�����Ϣ���вɼ�.���ɼ������ݷ�װ��Ϊһ��Environment�ļ��Ϸ��ء�
 * @CreateDate:   2018-1-25 14:28:30
 * @author briup
 * @Version: 1.0
 */
public interface Gather extends WossModuleInit{
	/**
	 * �ɼ����ܼҾӵĻ�����Ϣ�������ݷ�װΪEnvironment���Ϸ��ء�
	 * @return �ɼ���װEnvironment���ݵļ���
	 * @throws Exception
	 */
	public Collection<Environment> gather()throws Exception;
}
