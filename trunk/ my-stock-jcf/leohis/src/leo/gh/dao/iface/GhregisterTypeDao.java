package leo.gh.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.GhregisterType;


public interface GhregisterTypeDao extends Dao<GhregisterType>{
	public List<GhregisterType> getAllGhregisterType(int uid);
	/**
	 * 保存挂号类型
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
	 * 根据名称和医疗机构判断是否存在
	 * @param RPName 挂号类型名称
	 * @param MedicalInstID 医疗机构
	 * @return
	 */
	public Integer getGhregisterTypeCunZai(String RPName, Integer MedicalInstID);
	/**
	 * 根据名称或拼音查询挂号类别
	 * @param RPName 名称
	 * @param Spell 拼音
	 * @param MedicalInstID 医疗机构
	 * @return
	 */
	public List<GhregisterType> getgetGhregisterTypeByNameAndSpell(String RPName, String Spell, Integer MedicalInstID);
	/**
	 * 按照挂号类型ID删除挂号类型
	 * @param RTID挂号类型ID
	 * @return
	 */
	public boolean delGhregisterTypeByID(Integer RTID);
	/**
	 * 得到该科室的挂号类型
	 * @param uid
	 * @return
	 */
	public List<GhregisterType> getGhregisterTypebyghuid(int uid);
	public String[][] getrnameandrtidbyuid(int uid);
}
