package leo.gy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.GysupplyDisinfectPackInfo;

;

public interface GYSupplyDisinfectPackInfoDAO extends Dao<GysupplyDisinfectPackInfo>{

	public List<GysupplyDisinfectPackInfo> getAllPackKindInfo(int gyuid);
	public List<GysupplyDisinfectPackInfo> getAllPackKindInfo();
	
	//���޾������ͱ������һ������
	/*public void insertPackKindInfo(
			GysupplyDisinfectPackInfo gysupplyDisinfectPackInfo);*/
	public boolean addPackKindInfo(GysupplyDisinfectPackInfo disinfectPackInfo);
	public boolean modifyPackKindInfo(GysupplyDisinfectPackInfo g);
	
	//ͨ��GY001��õ��޾�������ID��ȡ��������
	public GysupplyDisinfectPackInfo FindGysupplyDisinfectPackInfoByID(int id);	
	
	//У���޾��������Ƿ��ظ�������ظ�����������
	public boolean FindGysupplyDisinfectPackInfoByName(String name);
	//�����޾���ID�����޾�������
	public String GetGyDisinfectPackNameById(int id);
	
	//�����޾���ID�����޾�������
	public String GetGyDisinfectPackContentDiscById(int id);

	
	//�����޾���ID�����޾�����ע��Ϣ
	public String GetGyDisinfectPackNoteById(int id);
	
	/**
	 * ���޾������Ʒ����޾���ID added by sun
	 * @param Sting dpn :�޾�������
	 */
	public int GetDIDByDPN(String dpn);
}
