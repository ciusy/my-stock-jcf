package leo.os.service.impl;

import java.util.List;

import leo.entity.OsfnAuthorityForm;
import leo.entity.Osstuff;
import leo.os.dao.iface.OsstuffDao;
import leo.os.dao.iface.OsunitHasSDao;
import leo.os.service.iface.OsstuffService;
import leo.os.dao.iface.OsfnAuthorityFormDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 3, 2011 5:04:46 PM
 */
public class OsstuffServiceImpl implements OsstuffService {

	private OsstuffDao osstuffDao;
	private OsunitHasSDao osunitHasSDao;
	private OsfnAuthorityFormDao osfnAuthorityFormDao;
	

	public void setOsfnAuthorityFormDao(OsfnAuthorityFormDao osfnAuthorityFormDao) {
		this.osfnAuthorityFormDao = osfnAuthorityFormDao;
	}

	public void setOsunitHasSDao(OsunitHasSDao osunitHasSDao) {
		this.osunitHasSDao = osunitHasSDao;
	}

	public void setOsstuffDao(OsstuffDao osstuffDao) {
		this.osstuffDao = osstuffDao;
	}

	public List<Osstuff> getOsstuff(Integer meiid) {
		return osstuffDao.getOsstuff(meiid);
	}

	public Osstuff getStuffBySid(Long sid) {
		
		return osstuffDao.getStuffBySid(sid);
	}

	public String getSNameBySid(long sid){
		return osstuffDao.getSNameBySid(sid);
	}
	
	public Double getYuE(Long SID){
		return osstuffDao.getYuE(SID);
	}
	public String[][] getNameAndID(Integer ksid, String ZhiCheng){
		return osstuffDao.getNameAndID(ksid,ZhiCheng);
	}

	public List<Osstuff> getOsstuffBycondition(String sname,String spell, String zige,
			String zhiwu, String bianzhi, int uid, int mid) {
		return osstuffDao.getOsstuffBycondition(sname,spell, zige, zhiwu, bianzhi, uid, mid);
	}

	public boolean addOsstuff(Osstuff osstuff, Integer KeShiID) {
		Long ygid;
		osstuffDao.addOsstuff(osstuff); //加入员工
		ygid = osstuff.getSid(); //新员工ID
		if (KeShiID != -2){
			osunitHasSDao.addOsunitHasSSQL(KeShiID, ygid);
		}
		return true;
	}

	public boolean deleteOsstuff(Osstuff osstuff) {
		
		return osstuffDao.deleteOsstuff(osstuff);
	}

	public boolean updateOsstuff(Osstuff osstuff, Long YongGongID, Integer MoRenKeShi_Y, Integer MoRenKeShi_X) {
		osstuffDao.updateOsstuff(osstuff); //修改员工
		osunitHasSDao.delOsunitHasSByUnitIDAndSID(MoRenKeShi_Y, YongGongID); //删除原科室
		if (MoRenKeShi_X != -2){
			osunitHasSDao.addOsunitHasSSQL(MoRenKeShi_X, YongGongID); //分配新科室
		}
		return true;
	}

	public boolean loginname(String lgname,int mid,Long SID) {
		// TODO Auto-generated method stub
		return osstuffDao.loginname(lgname, mid, SID);
	}

	public Osstuff getOsstuffByLoginname(String lgname, int mid) {
		// TODO Auto-generated method stub
		return osstuffDao.getOsstuffByLoginname(lgname, mid);
	}
	
	public boolean delOsstuffById(Long SID){
		osstuffDao.delOsstuffById(SID);
		osunitHasSDao.deleteOsunitHasSBySid(SID);
		return true;
	}

	public String[][] getsnamesidbyuid(int uid) {
		// TODO Auto-generated method stub
		return osstuffDao.getsnamesidbyuid(uid);
	}
	
}
