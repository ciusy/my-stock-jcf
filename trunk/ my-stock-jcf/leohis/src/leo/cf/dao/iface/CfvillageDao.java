package leo.cf.dao.iface;

import java.util.List;

import leo.entity.Cftown;
import leo.entity.Cfvillage;

public interface CfvillageDao {
	public List<Cfvillage> getAllVilleagesByTownId(long townId);//输入所在的乡镇id，返回所有的村
	public List<Cfvillage> getVillageIdByVillageName(String  villageName);//输入村的名称,返回该村的id;
	public Cfvillage getVillageByVillageId(long  villageId);
	/**
	 * 根据村id查询村名
	 * @param villageId
	 * @return
	 */
	public String getVillageNameByvillageId(Long villageId);
	/**
	 * 返回最大村ID
	 * @param TownID 乡ID
	 * @return
	 */
	public String getMaxID(long TownID);
	/**
	 * 增加村
	 * @param VillageID 村ID
	 * @param TownID 乡ID
	 * @param VillageName 村名
	 * @return
	 */
	public boolean addVillage(long VillageID, long TownID, String VillageName);
	/**
	 * 删除村
	 * @param TownID 乡ID
	 * @return
	 */
	public boolean delVillage(long TownID);
	/**
	 * 根据村ID删除村
	 * @param VillageID 村ID
	 * @return
	 */
	public boolean delVillageByVillageID(long VillageID);
	/**
	 * 修改村名
	 * @param VillageID 村ID
	 * @param name 村名
	 * @return
	 */
	public boolean updateVillage(long VillageID, String name);
}
