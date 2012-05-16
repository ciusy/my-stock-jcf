package leo.cf.dao.iface;

import java.util.List;

import leo.entity.Cftown;
import leo.entity.Cfvillage;

public interface CfvillageDao {
	public List<Cfvillage> getAllVilleagesByTownId(long townId);//�������ڵ�����id���������еĴ�
	public List<Cfvillage> getVillageIdByVillageName(String  villageName);//����������,���ظô��id;
	public Cfvillage getVillageByVillageId(long  villageId);
	/**
	 * ���ݴ�id��ѯ����
	 * @param villageId
	 * @return
	 */
	public String getVillageNameByvillageId(Long villageId);
	/**
	 * ��������ID
	 * @param TownID ��ID
	 * @return
	 */
	public String getMaxID(long TownID);
	/**
	 * ���Ӵ�
	 * @param VillageID ��ID
	 * @param TownID ��ID
	 * @param VillageName ����
	 * @return
	 */
	public boolean addVillage(long VillageID, long TownID, String VillageName);
	/**
	 * ɾ����
	 * @param TownID ��ID
	 * @return
	 */
	public boolean delVillage(long TownID);
	/**
	 * ���ݴ�IDɾ����
	 * @param VillageID ��ID
	 * @return
	 */
	public boolean delVillageByVillageID(long VillageID);
	/**
	 * �޸Ĵ���
	 * @param VillageID ��ID
	 * @param name ����
	 * @return
	 */
	public boolean updateVillage(long VillageID, String name);
}
