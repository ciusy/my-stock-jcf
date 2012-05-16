package leo.os.service.impl;

import java.util.List;

import leo.entity.OsfnBlocks;
import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;
import leo.entity.OsunitHasS;
import leo.os.dao.iface.OsmedicalInstInfoDao;
import leo.os.dao.iface.OsstuffDao;
import leo.os.dao.iface.OsudefaultfnDao;
import leo.os.dao.iface.OsuformDao;
import leo.os.dao.iface.OsunitHasSDao;
import leo.os.service.iface.OsuformService;

public class OsuformServiceImpl implements OsuformService {
	private OsuformDao osuformDao;
	private OsunitHasSDao osunitHasSDao;
	private OsmedicalInstInfoDao osmedicalInstInfoDao;
	OsudefaultfnDao osf = null;
	public void setOsmedicalInstInfoDao(OsmedicalInstInfoDao osmedicalInstInfoDao){
		this.osmedicalInstInfoDao=osmedicalInstInfoDao;
	}
	public void setOsunitHasSDao(OsunitHasSDao osunitHasSDao){
		this.osunitHasSDao=osunitHasSDao;
	}
	public void setOsf(OsudefaultfnDao osf) {
		this.osf = osf;
	}

	public Osuform getOsuformByUid(int uid) {
		return osuformDao.getOsuformByUid(uid);
	}

	public String getUNameByUid(int uid) {
		return osuformDao.getUNameByUid(uid);
	}
	
	public void setOsuformDao(OsuformDao osuformDao) {
		this.osuformDao = osuformDao;
	}

	public String[][] getUformByOTypeAndMid(String oType, int mid) {
		return osuformDao.getUformByOTypeAndMid(oType, mid);
	}

	public String[][] getUidBySidAndOType(int sid,String[] otypename) {
		return osuformDao.getUidBySidAndOType(sid,otypename);
	}
	public String[][] getUidBySidAndOTypeForBchao(int sid, String otypename) {
		// TODO Auto-generated method stub
		//String arrtypeName []=new String[16];
		String []arrtypeName=otypename.split(",");
		return osuformDao.getUidBySidAndOType(sid,arrtypeName);
	}
	public int getUidByUName(int mid , String uname)
	{
		return osuformDao.getUidByUName(mid, uname);
	}
	
	public List<Osuform> getOsuformByMEIIDandOType(int meiId, String oType) {
		// TODO Auto-generated method stub
		return osuformDao.getOsuformByMEIIDandOType(meiId, oType);
	}
	/**
	 * 根据科室ID查询科室对应的功能
	 */
	public List<OsfnBlocks> getFnBlocksByUID(Integer uid) {
		// TODO Auto-generated method stub
		return osf.getFnBlocksByUID(uid);
	}
	
	public String[][] getUformNotType(String oType , int mid){
		return osuformDao.getUformNotType(oType, mid);
	}

	public List<Osuform> getUFormByMid(Integer mid) {
		// TODO Auto-generated method stub
		return osuformDao.getUFormByMid(mid);
	}

	public boolean addUForm(Osuform osuform) {
		// TODO Auto-generated method stub
		return osuformDao.addUForm(osuform);
	}

	public boolean deleteUForm(Osuform osuform) {
		// TODO Auto-generated method stub
		return osuformDao.deleteUForm(osuform);
	}

	public boolean updateUForm(Osuform osuform) {
		// TODO Auto-generated method stub
		return osuformDao.updateUForm(osuform);
	}

	public List<OsunitHasS> getOsunitHasSByUid(int uid) {
		// TODO Auto-generated method stub
		return osunitHasSDao.getOsunitHasSByUid(uid);
	}
	public List<OsmedicalInstInfo> getAllOsmedicalInstInfo() {
		// TODO Auto-generated method stub
		return osmedicalInstInfoDao.getAllOsmedicalInstInfo();
	}
	public boolean addOsunitHasS(OsunitHasS osunitHasS) {
		// TODO Auto-generated method stub
		return osunitHasSDao.addOsunitHasS(osunitHasS);
	}
	public boolean deleteOsunitHasS(OsunitHasS osunitHasS) {
		// TODO Auto-generated method stub
		return osunitHasSDao.deleteOsunitHasS(osunitHasS);
	}
	public boolean updateOsunitHasS(OsunitHasS osunitHasS) {
		// TODO Auto-generated method stub
		return osunitHasSDao.updateOsunitHasS(osunitHasS);
	}
	public List<OsunitHasS> getOsunitHasSBySid(long sid) {
		// TODO Auto-generated method stub
		return osunitHasSDao.getOsunitHasSBySid(sid);
	}
	public boolean deleteOsunitHasSBySid(long sid) {
		// TODO Auto-generated method stub
		return osunitHasSDao.deleteOsunitHasSBySid(sid);
	}
	public boolean addOsunitHasSBySidandUid(long sid, int[] uidlist) {
		// TODO Auto-generated method stub
		return osunitHasSDao.addOsunitHasSBySidandUid(sid, uidlist);
	}

}
