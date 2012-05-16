package leo.gh.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.GhregisterType;


public interface GhregisterTypeDao extends Dao<GhregisterType>{
	public List<GhregisterType> getAllGhregisterType(int uid);
	/**
	 * ����Һ�����
	 * @param ghregisterType
	 * @return
	 */
	public boolean addGhregisterType(GhregisterType ghregisterType);
	public boolean deleteGhregisterType(GhregisterType ghregisterType);
	public boolean updateGhregisterType(GhregisterType ghregisterType);
	public GhregisterType getGhregisterTypeById(int id);
	public List<GhregisterType> getGhregisterTypeByUid(int uId1,int uId2);
	public GhregisterType getGhregisterTypeByRPname(String rpname);
	public List<GhregisterType> getAllGhregisterTypeByMid(int mid);
	public int getRtidByUName(int mid , String rpname);
	/**
	 * �������ƺ�ҽ�ƻ����ж��Ƿ����
	 * @param RPName �Һ���������
	 * @param MedicalInstID ҽ�ƻ���
	 * @return
	 */
	public Integer getGhregisterTypeCunZai(String RPName, Integer MedicalInstID);
	/**
	 * �������ƻ�ƴ����ѯ�Һ����
	 * @param RPName ����
	 * @param Spell ƴ��
	 * @param MedicalInstID ҽ�ƻ���
	 * @return
	 */
	public List<GhregisterType> getgetGhregisterTypeByNameAndSpell(String RPName, String Spell, Integer MedicalInstID);
	/**
	 * ���չҺ�����IDɾ���Һ�����
	 * @param RTID�Һ�����ID
	 * @return
	 */
	public boolean delGhregisterTypeByID(Integer RTID);
	/**
	 * �õ��ÿ��ҵĹҺ�����
	 * @param uid
	 * @return
	 */
	public List<GhregisterType> getGhregisterTypebyghuid(int uid);
	public String[][] getrnameandrtidbyuid(int uid);
}
