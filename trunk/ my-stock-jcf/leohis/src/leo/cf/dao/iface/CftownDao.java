package leo.cf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Cftown;

public interface CftownDao extends Dao<Cftown> {
	public  List<Cftown> getAllTownByPrefectureId(long  prefectureId);//����������id,���ظ���������������
	public  List<Cftown> getTownIdByTownName(String  townName);//�������������,���ظ������id;
	public Cftown getTownByTownId(long townId);//��������ID������������
	/**
	 * ��������id��ѯ��������
	 * @param townId
	 * @return
	 */
	public String getTownNameBytownId(Long townId);
	/**
	 * �õ������ID
	 * @param PrefectureID ��ID
	 * @return
	 */
	public String getMaxTownID(long PrefectureID);
	/**
	 * ������
	 * @param TownID ��ID
	 * @param PrefectureID ��ID
	 * @param TownName ����
	 * @return
	 */
	public boolean addTown(long TownID, long PrefectureID, String TownName);
	/**
	 * ɾ����
	 * @param TownID ��ID
	 * @return
	 */
	public boolean delTown(long TownID);
	/**
	 * �޸�������
	 * @param TownID ��ID
	 * @param Name ����
	 * @return
	 */
	public boolean updateTown(long TownID, String Name);
}
