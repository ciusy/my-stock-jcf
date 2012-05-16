package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Yfaitem;

public interface YfaitemDao extends Dao<Yfaitem>{
	public boolean addYfaitem(Yfaitem yfaitem); //���Ӳɹ�����Ŀ
	public String[][] getCaiGouBiaoTao(String aformid, String date_b, String date_e,Integer pid,String InbankStatus);
	/*
       aformid ���뵥��
       date_b, ���뿪ʼ����
       date_e, �����������
       pid, ҩ������id
       InbankStatus ״̬
	 */
	
	/**
	 * �������뵥�Ų�ѯ������
	 */
	public List<Yfaitem> getYfaitem(String AFormID); 
	public boolean delYfaitem(String AFormID); //����������뵥IDɾ��
	
}
