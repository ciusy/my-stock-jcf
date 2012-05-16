package leo.cf.service.impl;

import java.util.List;

import leo.cf.dao.iface.CfcityDao;
import leo.cf.dao.iface.CfgroupDao;
import leo.cf.dao.iface.CfprefectureDao;
import leo.cf.dao.iface.CfprovinceDao;
import leo.cf.dao.iface.CftownDao;
import leo.cf.dao.iface.CfvillageDao;
import leo.cf.service.iface.CFGiveYSService;
import leo.entity.Cfcity;
import leo.entity.Cfgroup;
import leo.entity.Cfprefecture;
import leo.entity.Cfprovince;
import leo.entity.Cftown;
import leo.entity.Cfvillage;

public class CFGiveYSServiceImpl implements CFGiveYSService {
	CfprovinceDao cfprovDao = null;
	CfgroupDao cfgroupDao = null;

	public void setCfgroupDao(CfgroupDao cfgroupDao) {
		this.cfgroupDao = cfgroupDao;
	}

	public void setCfprovDao(CfprovinceDao cfprovDao) {
		this.cfprovDao = cfprovDao;
	}

	public void setCfcityDao(CfcityDao cfcityDao) {
		this.cfcityDao = cfcityDao;
	}

	public void setCfprefecDao(CfprefectureDao cfprefecDao) {
		this.cfprefecDao = cfprefecDao;
	}

	public void setCftownDao(CftownDao cftownDao) {
		this.cftownDao = cftownDao;
	}

	public void setCfvillageDao(CfvillageDao cfvillageDao) {
		this.cfvillageDao = cfvillageDao;
	}

	CfcityDao cfcityDao = null;
	CfprefectureDao cfprefecDao = null;
	CftownDao cftownDao = null;
	CfvillageDao cfvillageDao = null;

	/**
	 * 根据省查询市
	 */
	public List<Cfcity> getCfcityByprovID(Integer provId) {
		// TODO Auto-generated method stub
		return cfcityDao.getCfcityByProvNameID(provId);
	}

	/**
	 * 根据市查询县
	 */
	public List<Cfprefecture> getCfprefectureBycityId(Integer cityId) {
		// TODO Auto-generated method stub
		return cfprefecDao.getPrefectureByCityID(cityId);
	}

	/**
	 * 查询所有省
	 */
	public List<Cfprovince> getCfprovinceAll() {
		// TODO Auto-generated method stub
		return cfprovDao.getCfprovinceAll();
	}

	/**
	 * 根据县查询乡
	 */
	public List<Cftown> getCftownByprefectureId(Long prefectureId) {
		// TODO Auto-generated method stub
		return cftownDao.getAllTownByPrefectureId(prefectureId);
	}

	/**
	 * 根据乡查询村
	 */
	public List<Cfvillage> getCfvillageBytownId(Long townId) {
		// TODO Auto-generated method stub
		return cfvillageDao.getAllVilleagesByTownId(townId);
	}

	/**
	 * 根据村查询组
	 */
	public List<Cfgroup> getCfgroupByvillageId(Long villageId) {
		// TODO Auto-generated method stub
		return cfgroupDao.getAllCfgroupsByVilleageId(villageId);
	}

	/**
	 * 根据县id查询县名
	 */
	public String getPrefectureByprefectureId(Long prefectureId) {
		// TODO Auto-generated method stub
		return cfprefecDao.getPrefectureByprefectureId(prefectureId);
	}

	/**
	 * 根据省id查询省名
	 */
	public String getProvinceName(Integer provID) {
		// TODO Auto-generated method stub
		return cfprovDao.getProvinceName(provID);
	}

	/**
	 * 根据乡镇id查询乡镇名称
	 */
	public String getTownNameBytownId(Long townId) {
		// TODO Auto-generated method stub
		return cftownDao.getTownNameBytownId(townId);
	}

	/**
	 * 根据村id查询村名
	 */
	public String getVillageNameByvillageId(Long villageId) {
		// TODO Auto-generated method stub
		return cfvillageDao.getVillageNameByvillageId(villageId);
	}

}
