package leo.cf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Cftown;

public interface CftownDao extends Dao<Cftown> {
	public  List<Cftown> getAllTownByPrefectureId(long  prefectureId);//输入县区的id,返回该县区的所有乡镇
	public  List<Cftown> getTownIdByTownName(String  townName);//输入乡镇的名称,返回该乡镇的id;
	public Cftown getTownByTownId(long townId);//根据乡镇ID返回乡镇名称
	/**
	 * 根据乡镇id查询乡镇名称
	 * @param townId
	 * @return
	 */
	public String getTownNameBytownId(Long townId);
	/**
	 * 得到最大乡ID
	 * @param PrefectureID 县ID
	 * @return
	 */
	public String getMaxTownID(long PrefectureID);
	/**
	 * 加入乡
	 * @param TownID 乡ID
	 * @param PrefectureID 县ID
	 * @param TownName 乡名
	 * @return
	 */
	public boolean addTown(long TownID, long PrefectureID, String TownName);
	/**
	 * 删除乡
	 * @param TownID 乡ID
	 * @return
	 */
	public boolean delTown(long TownID);
	/**
	 * 修改乡名称
	 * @param TownID 乡ID
	 * @param Name 乡名
	 * @return
	 */
	public boolean updateTown(long TownID, String Name);
}
