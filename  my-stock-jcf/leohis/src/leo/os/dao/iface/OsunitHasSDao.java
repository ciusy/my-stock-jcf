package leo.os.dao.iface;

import java.util.List;

import leo.entity.OsunitHasS;

public interface OsunitHasSDao {
	public List<OsunitHasS> getOsunitHasSByUid(int uid);
	public List<OsunitHasS> getOsunitHasSBySid(long sid);
	public boolean addOsunitHasS(OsunitHasS osunitHasS);
	public boolean updateOsunitHasS(OsunitHasS osunitHasS);
	public boolean deleteOsunitHasS(OsunitHasS osunitHasS);
	/**
	 * 删除科室拥有成员表中的此人员所有科室
	 * @param sid 员工ID
	 * @return
	 */
	public boolean deleteOsunitHasSBySid(long sid);
	public boolean addOsunitHasSBySidandUid(long sid, int[] uidlist);
	/**
	 * 按照科室ID删除成员
	 * @param UnitID 科室ID
	 * @return
	 */
	public boolean delOsunitHasSByUnitID(Integer UnitID);
	/**
	 * SQL语句增加分配科室
	 * @param KeShiID
	 * @param YuanGongID
	 * @return
	 */
	public boolean addOsunitHasSSQL(Integer KeShiID, Long YuanGongID);
	/**
	 * 按照科室ID和员工ID删除已分配科室
	 * @param UnitID 科室ID
	 * @param SID 员工ID
	 * @return
	 */
	public boolean delOsunitHasSByUnitIDAndSID(Integer UnitID, Long SID);
	
}
