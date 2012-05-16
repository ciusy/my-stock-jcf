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
	 * ����ʡ��ѯ��
	 */
	public List<Cfcity> getCfcityByprovID(Integer provId) {
		// TODO Auto-generated method stub
		return cfcityDao.getCfcityByProvNameID(provId);
	}

	/**
	 * �����в�ѯ��
	 */
	public List<Cfprefecture> getCfprefectureBycityId(Integer cityId) {
		// TODO Auto-generated method stub
		return cfprefecDao.getPrefectureByCityID(cityId);
	}

	/**
	 * ��ѯ����ʡ
	 */
	public List<Cfprovince> getCfprovinceAll() {
		// TODO Auto-generated method stub
		return cfprovDao.getCfprovinceAll();
	}

	/**
	 * �����ز�ѯ��
	 */
	public List<Cftown> getCftownByprefectureId(Long prefectureId) {
		// TODO Auto-generated method stub
		return cftownDao.getAllTownByPrefectureId(prefectureId);
	}

	/**
	 * �������ѯ��
	 */
	public List<Cfvillage> getCfvillageBytownId(Long townId) {
		// TODO Auto-generated method stub
		return cfvillageDao.getAllVilleagesByTownId(townId);
	}

	/**
	 * ���ݴ��ѯ��
	 */
	public List<Cfgroup> getCfgroupByvillageId(Long villageId) {
		// TODO Auto-generated method stub
		return cfgroupDao.getAllCfgroupsByVilleageId(villageId);
	}

	/**
	 * ������id��ѯ����
	 */
	public String getPrefectureByprefectureId(Long prefectureId) {
		// TODO Auto-generated method stub
		return cfprefecDao.getPrefectureByprefectureId(prefectureId);
	}

	/**
	 * ����ʡid��ѯʡ��
	 */
	public String getProvinceName(Integer provID) {
		// TODO Auto-generated method stub
		return cfprovDao.getProvinceName(provID);
	}

	/**
	 * ��������id��ѯ��������
	 */
	public String getTownNameBytownId(Long townId) {
		// TODO Auto-generated method stub
		return cftownDao.getTownNameBytownId(townId);
	}

	/**
	 * ���ݴ�id��ѯ����
	 */
	public String getVillageNameByvillageId(Long villageId) {
		// TODO Auto-generated method stub
		return cfvillageDao.getVillageNameByvillageId(villageId);
	}

}
