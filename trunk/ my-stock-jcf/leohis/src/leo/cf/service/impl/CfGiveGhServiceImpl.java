package leo.cf.service.impl;

import java.util.List;

import leo.cf.dao.iface.CfcityDao;
import leo.cf.dao.iface.CfgroupDao;
import leo.cf.dao.iface.CfprefectureDao;
import leo.cf.dao.iface.CfstuffDao;
import leo.cf.dao.iface.CftownDao;
import leo.cf.dao.iface.CfvillageDao;
import leo.cf.service.iface.CfGiveGhService;
import leo.entity.Cfcity;
import leo.entity.Cfgroup;
import leo.entity.Cfprefecture;
import leo.entity.Cfstuff;
import leo.entity.Cftown;
import leo.entity.Cfvillage;

public class CfGiveGhServiceImpl implements CfGiveGhService {
	private CfprefectureDao cfprefectureDao ;
	private CfstuffDao cfstuffDao;
	private CftownDao cftownDao;
	private CfvillageDao cfvillageDao;
	private CfgroupDao cfgroupDao;
	private CfcityDao cfcityDao;
	public void setCfcityDao(CfcityDao cfcityDao){
	this.cfcityDao=cfcityDao;	
	}
	public void setCfprefectureDao(CfprefectureDao cfprefectureDao) {
		this.cfprefectureDao = cfprefectureDao;
	}
	public void setCfstuffDao(CfstuffDao cfstuffDao) {
		this.cfstuffDao = cfstuffDao;
	}
	public void setCftownDao(CftownDao cftownDao) {
		this.cftownDao = cftownDao;
	}
	public void setCfvillageDao(CfvillageDao cfvillageDao) {
		this.cfvillageDao = cfvillageDao;
	}

	
	public void setCfgroupDao(CfgroupDao cfgroupDao) {
		this.cfgroupDao = cfgroupDao;
	}
	
	
	public List<Cfprefecture> getPrefectureIdByCityID(long  cityId){
		return cfprefectureDao.getPrefectureIdByCityID(cityId);
	}
	
	public Cfprefecture getPrefectureByPrefectureID(long   prefectureId){
		return cfprefectureDao.getPrefectureByPrefectureID(prefectureId);
	}
	public List<Cftown> getAllTownByPrefectureId(long prefectureId) {
		return cftownDao.getAllTownByPrefectureId(prefectureId);
	}
	
	public Cftown getTownByTownId(long townId){
		return cftownDao.getTownByTownId(townId);
	}

	public List<Cftown> getAllTownByPrefectureName(String prefectureName) {
		long prefectureId=cfprefectureDao.getPrefectureIdByPrefectureName(prefectureName).getPrefectureId();
		List<Cftown> list=cftownDao.getAllTownByPrefectureId(prefectureId);
		return list;
	}

	public List<Cfvillage> getAllVilleagesByTownId(long townId) {
		return cfvillageDao.getAllVilleagesByTownId(townId);
	}

	public List<Cfvillage> getAllVilleagesByTownName(String townName) {
		if(cftownDao.getTownIdByTownName(townName).size()!=0){
			long townId =cftownDao.getTownIdByTownName(townName).get(0).getTownId();
			List<Cfvillage> list=cfvillageDao.getAllVilleagesByTownId(townId);
			return list;
		}
		return null;
	}

	public String getPersonalConfiguration(String dname, long sid) {
		return cfstuffDao.getPersonalConfiguration(dname, sid);
	}

	public Cfprefecture getPrefectureIdByPrefectureName(String prefectureName) {
		return cfprefectureDao.getPrefectureIdByPrefectureName(prefectureName);
	}
	public List<Cfgroup> getAllCfgroupsByVilleageId(long villeageId) {
		return cfgroupDao.getAllCfgroupsByVilleageId(villeageId);
	}
	public List<Cfgroup> getAllCfgroupsByVilleageName(String villeageName) {
		if(cfvillageDao.getVillageIdByVillageName(villeageName).size()!=0){
			long villeageId =cfvillageDao.getVillageIdByVillageName(villeageName).get(0).getVillageId();
			return cfgroupDao.getAllCfgroupsByVilleageId(villeageId);
		}
		return null;
	}
	public Cfvillage getVillageByVillageId(long villageId) {
		
		return cfvillageDao.getVillageByVillageId(villageId);
	}
	public Cfgroup getCfgroupByCfgroupId(long groupId) {

		return cfgroupDao.getCfgroupByCfgroupId(groupId);
	}
	public Cfcity getcityBycityID(long cityId) {
		
		return cfcityDao.getcityBycityID(cityId);
	}
	public List<Cfprefecture> getPrefectureByCityID(long cityId) {
		
		return cfprefectureDao.getPrefectureByCityID(cityId);
	}
	public String[][] getinfobydisposename(String dname) {
		
		return cfstuffDao.getinfobydisposename(dname);
	}
	public boolean addcfstuff(Cfstuff cfstuff) {
		// TODO Auto-generated method stub
		return cfstuffDao.addcfstuff(cfstuff);
	}
	public boolean deletecfstuff(int id) {
		// TODO Auto-generated method stub
		return cfstuffDao.deletecfstuff(id);
	}
	public boolean updatecfstuff(int id, String value, int sid) {
		// TODO Auto-generated method stub
		return cfstuffDao.updatecfstuff(id, value, sid);
	}

}
