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
	 * ɾ������ӵ�г�Ա���еĴ���Ա���п���
	 * @param sid Ա��ID
	 * @return
	 */
	public boolean deleteOsunitHasSBySid(long sid);
	public boolean addOsunitHasSBySidandUid(long sid, int[] uidlist);
	/**
	 * ���տ���IDɾ����Ա
	 * @param UnitID ����ID
	 * @return
	 */
	public boolean delOsunitHasSByUnitID(Integer UnitID);
	/**
	 * SQL������ӷ������
	 * @param KeShiID
	 * @param YuanGongID
	 * @return
	 */
	public boolean addOsunitHasSSQL(Integer KeShiID, Long YuanGongID);
	/**
	 * ���տ���ID��Ա��IDɾ���ѷ������
	 * @param UnitID ����ID
	 * @param SID Ա��ID
	 * @return
	 */
	public boolean delOsunitHasSByUnitIDAndSID(Integer UnitID, Long SID);
	
}
