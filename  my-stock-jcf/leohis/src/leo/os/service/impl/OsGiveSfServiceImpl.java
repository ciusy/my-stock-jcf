package leo.os.service.impl;

import java.util.ArrayList;
import java.util.List;

import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;
import leo.os.dao.iface.OsmedicalInstInfoDao;
import leo.os.dao.iface.OsstuffDao;
import leo.os.dao.iface.OsuformDao;
import leo.os.service.iface.OsGiveSfService;

/**
 * 
 * @author xuxiangpan
 * 
 */
public class OsGiveSfServiceImpl implements OsGiveSfService {

	private OsstuffDao osstuffDao;
	private OsuformDao osuformDao;
	private OsmedicalInstInfoDao osmedicalInstInfoDao;



	/**
	 * add by xu 根据ids集合查找所有的医护人员
	 * 
	 * @param ids
	 * @return
	 */
	public List<Osstuff> getByIds(List<Long> ids) {

		return osstuffDao.getByIds(ids);
	}

	/**
	 * add by xu
	 * 
	 * @param osstuffDao
	 */
	public void setOsstuffDao(OsstuffDao osstuffDao) {
		this.osstuffDao = osstuffDao;
	}

	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal) {

		return osstuffDao.getAllOsstuff(medicalOrgnizal);
	}

	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal, String name, Boolean isSpell) {
		if (name.trim().equals("")) {
			return osstuffDao.getAllOsstuff(medicalOrgnizal);
		}
		return osstuffDao.getAllOsstuff(medicalOrgnizal, name, isSpell);
	}

	public void updateOsstuffCharageBalance(String sid, String cash) {
		Osstuff osstuff = osstuffDao.find(Long.parseLong(sid));
		osstuff.setChargeBalance(osstuff.getChargeBalance() + Double.parseDouble(cash));
		osstuffDao.update(osstuff);
	}

	public List<Osuform> getInpatientDept(Integer medicalOrgnizal, String type) {
		List<Object> list = new ArrayList<Object>();
		list.add(medicalOrgnizal);
		list.add(type);
		return osuformDao.getScrollData("o.meiid=? and o.otype=?", list.toArray());
	}

	public List<Osuform> getOsuformsByIds(List<Integer> osUFormIds) {

		return osuformDao.getOsuformsByIds(osUFormIds);
	}

	public List<Osuform> getUFormByMid(Integer mid) {

		return osuformDao.getUFormByMid(mid);
	}

	public Osuform getUFormById(Integer id) {
		return osuformDao.find(id);
	}

	public void setOsuformDao(OsuformDao osuformDao) {
		this.osuformDao = osuformDao;
	}
	public void setOsmedicalInstInfoDao(OsmedicalInstInfoDao osmedicalInstInfoDao) {
		this.osmedicalInstInfoDao = osmedicalInstInfoDao;
	}

	public OsmedicalInstInfo getMediacalInstInfoById(Integer id) {

		return osmedicalInstInfoDao.getOsmedicalInstInfoById(id);
	}

}
