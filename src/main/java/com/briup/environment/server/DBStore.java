package com.briup.environment.server;

import java.util.Collection;
import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModuleInit;
/**
 * Simple to Introduction
 * @ProjectName:  ���ܼҾ�֮�������ϵͳ
 * @Package: com.briup.environment.server
 * @InterfaceName:  DBStore
 * @Description:  DBStore�ṩ�����ģ��Ĺ淶��<br/>
 * 				 �ýӿڵ�ʵ���ཫEnvironment���ϳ־û���
 * @CreateDate:   2018-1-25 14:28:30
 * @author briup
 * @Version: 1.0
 */
public interface DBStore extends WossModuleInit{
	/**
	 * ��BIDR���Ͻ��г־û� ��
	 * @param coll ��Ҫ�����Environment����
	 * @throws Exception
	 */
	public void saveDb(Collection<Environment> coll)throws Exception;
}
