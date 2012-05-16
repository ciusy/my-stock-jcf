package leo.os.service.impl;

import java.util.List;

import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;
import leo.os.dao.iface.OsmedicalInstInfoDao;
import leo.os.dao.iface.OsstuffDao;
import leo.os.dao.iface.OsuformDao;
import leo.os.service.iface.GiveGhService;

public class GiveGhServiceImpl implements GiveGhService {
	/**
	 * set方法，供Spring调用
	 */
	private OsuformDao osuformDao;
	private OsstuffDao osstuffDao;
	private OsmedicalInstInfoDao osmedicalInstInfoDao;
	public void setOsuformDao(OsuformDao osuformDao) {
		this.osuformDao = osuformDao;
	}
	public void setOsstuffDao(OsstuffDao osstuffDao) {
		this.osstuffDao = osstuffDao;
	}
	public void setOsmedicalInstInfoDao(OsmedicalInstInfoDao osmedicalInstInfoDao) {
		this.osmedicalInstInfoDao = osmedicalInstInfoDao;
	}
	
	
	public List<Osuform> getRegestUFormByMid(int mid) {
		return osuformDao.getRegestUFormByMid(mid);
	}
	public String[] getUformByRidAndMid(int rtId,int mid) {
		return osuformDao.getUformByRidAndMid(rtId,mid);
	}

	public List<Osstuff> getExpertStuffByUid(int uid) {
		return osstuffDao.getExpertStuffByUid(uid);
	}
	public OsmedicalInstInfo getOsmedicalInstInfoById(int mid) {
		return osmedicalInstInfoDao.getOsmedicalInstInfoById(mid);
	}
	public List<Osuform> getRegisterDivaricateUByMid(int mid) {
		
		return osuformDao.getRegisterDivaricateUByMid(mid);
	}
	
	public int getUidByUName(int mid , String uname) {
		return osuformDao.getUidByUName(mid,uname);
	}
	public String getSNameBySid(long sid) {
		return osstuffDao.getSNameBySid(sid);
	}
	
}
