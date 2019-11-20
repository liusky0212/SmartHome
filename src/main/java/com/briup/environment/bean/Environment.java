package com.briup.environment.bean;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * Simple to Introduction
 * @ProjectName:  ���ܼҾ�֮�������ϵͳ
 * @Package: com.briup.environment.bean
 * @ClassName:  Environment
 * @Description:  �����洢ʵ����,����������������,���Ͷ�id,��ݮ��ϵͳid<br/>
 * 		ʵ����ģ��id,��������ַ,����������,ָ����,״̬,����ֵ,�ɼ�ʱ��
 * @CreateDate:   2018-1-25 14:28:30
 * @author briup
 * @Version: 1.0
 */
public class Environment implements Serializable{
	//������������
	private String name;
	//���Ͷ�id
	private String srcId;
	//��ݮ��ϵͳid
	private String dstId;
	//ʵ��������ģ��id(1-8)
	private String devId;
	//ģ���ϴ�������ַ
	private String sersorAddress;
	//����������
	private int count;
	//����ָ���� 3:��������;16:��������
	private String cmd;
	//״̬ Ĭ��Ϊ1��ʾ�ɹ�
	private int status;
	//����ֵ
	private float data;
	//�ɼ�ʱ��
	private Timestamp gather_date;
	public Environment() {}
	public Environment(String name, String srcId, String dstId, String devId,
			String sersorAddress, int count, String cmd, int status,
			float data, Timestamp gather_date) {
		super();
		this.name = name;
		this.srcId = srcId;
		this.dstId = dstId;
		this.devId = devId;
		this.sersorAddress = sersorAddress;
		this.count = count;
		this.cmd = cmd;
		this.status = status;
		this.data = data;
		this.gather_date = gather_date;
	}
	public Environment(Environment enviroment) {
		this.name = enviroment.getName();
		this.srcId = enviroment.getSrcId();
		this.dstId = enviroment.getDstId();
		this.devId = enviroment.getDevId();
		this.sersorAddress = enviroment.getSersorAddress();
		this.count = enviroment.getCount();
		this.cmd = enviroment.getCmd();
		this.status = enviroment.getStatus();
		this.data = enviroment.getData();
		this.gather_date = enviroment.getGather_date();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSrcId() {
		return srcId;
	}
	public void setSrcId(String srcId) {
		this.srcId = srcId;
	}
	public String getDstId() {
		return dstId;
	}
	public void setDstId(String dstId) {
		this.dstId = dstId;
	}
	public String getDevId() {
		return devId;
	}
	public void setDevId(String devId) {
		this.devId = devId;
	}
	public String getSersorAddress() {
		return sersorAddress;
	}
	public void setSersorAddress(String sersorAddress) {
		this.sersorAddress = sersorAddress;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public float getData() {
		return data;
	}
	public void setData(float data) {
		this.data = data;
	}
	public Timestamp getGather_date() {
		return gather_date;
	}
	public void setGather_date(Timestamp gather_date) {
		this.gather_date = gather_date;
	}
	@Override
	public String toString() {
		return "Environment [name=" + name + ", srcId=" + srcId + ", dstId="
				+ dstId + ", devId=" + devId + ", sersorAddress="
				+ sersorAddress + ", count=" + count + ", cmd=" + cmd
				+ ", status=" + status + ", data=" + data + ", gather_date="
				+ gather_date + "]";
	}
}
