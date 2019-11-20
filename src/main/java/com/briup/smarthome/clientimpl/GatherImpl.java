package com.briup.smarthome.clientimpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;

import com.briup.environment.bean.Environment;
import com.briup.environment.client.Gather;
import com.briup.environment.util.Configuration;
import com.briup.smarthome.util.ConfigurationAware;
import com.briup.smarthome.util.LogImpl;

//Gatherʵ����
public class GatherImpl implements Gather, ConfigurationAware{
	Collection<Environment> coll = new ArrayList<Environment>();
	private String path;
	private String record;
	private int temAndHum;
	private int sunNum;
	private int carbonNum;
	private Configuration conf;

	public int getTemAndHum() {
		return temAndHum;
	}

	public int getSunNum() {
		return sunNum;
	}

	public int getCarbonNum() {
		return carbonNum;
	}

	@Override
	public void init(Properties prop) throws Exception {
		path = prop.getProperty("src-file");
		record = prop.getProperty("record-file");
	}

	//
	@Override
	public Collection<Environment> gather() throws Exception {
		// �ɼ��ļ����ݽ�����ת���ɶ��������������
		// ��ȡ�����ļ�
		String line;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		System.out.println("��ȡ�����ļ��ɹ�");
		//br.skip(n)
		while ((line = br.readLine()) != null) {
			// ������������
			Environment en = new Environment();
			String[] split = line.split("[|]");
			// ��������
			en.setSrcId(split[0]);
			en.setDstId(split[1]);
			en.setDevId(split[2]);
			en.setSersorAddress(split[3]);
			en.setCount(Integer.parseInt(split[4]));
			en.setCmd(split[5]);
			en.setStatus(Integer.parseInt(split[7]));
			en.setGather_date(new Timestamp(Long.parseLong(split[8])));
			// ����new Timestamp(new Long(split[8]));

			// System.out.println("1");

			// �ж���������
			if (split[3].equals("16")) {
				// ����¶�
				// �¶�:((float)value��0.00268127)-46.85
				String temp = split[6].substring(0, 4);
				float tempValue = (float) (Long.parseLong(temp, 16) * 0.00268127 - 46.85);
				// �����¶�����
				en.setName("temperature");
				en.setData(tempValue);
				//��Ӽ��ϲ�����
				coll.add(en);
				temAndHum++;

				// ����ʪ�ȶ���
				// ʪ��:((float)value*0.00190735)-6
				Environment env = new Environment(en);
				String hum = split[6].substring(4, 8);
				float humValue = (float) (Long.parseLong(hum, 16) * 0.00190735 - 6);
				env.setName("humidity");
				env.setData(humValue);
				//��Ӽ��ϲ�����
				coll.add(env);
				temAndHum++;

			} else if (split[3].equals("256")) {
				// ����
				String sun = split[6].substring(0, 4);
				float sunValue = Long.parseLong(sun, 16);
				en.setName("sum");
				en.setData(sunValue);
				//��Ӽ��ϲ�����
				coll.add(en);
				sunNum++;
			} else {
				// ������̼
				String carbon = split[6].substring(0, 4);
				float carValue = Long.parseLong(carbon, 16);
				en.setName("carbon");
				en.setData(carValue);
				//��Ӽ��ϲ�����
				coll.add(en);
				carbonNum++;
			}
		}
		return coll;
	}

	@Override
	public void setConfiguration(Configuration conf) {
		this.conf = conf;;
		
	}

	/*// ������
	public static void main(String[] args) throws Exception {
		GatherImpl g = new GatherImpl();
		Collection<Environment> coll = g.gather();

		System.out.println(g.getCarbonNum() + " " + g.getSunNum() + " " + g.getTemAndHum() + " " + coll.size());
		int i = 0;
		for (Environment temp : coll) {
			if (i >= 10)
				break;
			System.out.println(temp);
			i++;
		}
	}*/

}
