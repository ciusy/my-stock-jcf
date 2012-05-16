package leo.yf.service.impl;

import java.util.List;

import leo.entity.Yfminfo;
import leo.yf.service.iface.YFMInFoService;

import leo.yf.dao.iface.YFMInfoDao; //导入leo.yf.dao.iface 里的YFMInfoDao接口

public class YFMInFoServiceImpl implements YFMInFoService { //类的实现
   
	private YFMInfoDao yfmInfoDao; //生明一个类变量
	
	//Source菜单Generate Geters and Setters菜单项 创建类变量
	public void setYfmInfoDao(YFMInfoDao yfmInfoDao) {
		this.yfmInfoDao = yfmInfoDao;
	}
	
	public List<Yfminfo> getYFMInfo(String MName, String spell, Integer MInfoID,Integer MedicalInstitutionID) {
		return yfmInfoDao.getYFMInfo(MName, spell, MInfoID, MedicalInstitutionID);
	}

	public boolean addYFInsertMInfoDao(Yfminfo yfminfo){
		return yfmInfoDao.addYFInsertMInfoDao(yfminfo);
	}

	public boolean delYFMInfo(Integer minfoid){
		return yfmInfoDao.delYFMInfo(minfoid);
	}

	public boolean updateYFMInfo(Yfminfo yfminfo){
		return yfmInfoDao.updateYFMInfo(yfminfo);
	}
	
	public Integer getYFMinfoID(){
		return yfmInfoDao.getYFMinfoID();
	}
	
	public String[][] getYFMInfo_Alias(String MName, String spell){
		return yfmInfoDao.getYFMInfo_Alias(MName, spell);
	}
	
	public String[][] getUnit(Integer minfoid){
		return yfmInfoDao.getUnit(minfoid);
	}

	public String[][] getYFMInfo_Stock(String MName, String spell, Integer MedicalInstitutionID, Integer PharmacyID){
		return yfmInfoDao.getYFMInfo_Stock(MName, spell, MedicalInstitutionID, PharmacyID);
	}
	
	public List<Yfminfo> getYFMInfoByStyle(String type){
		return yfmInfoDao.getYFMInfoByStyle(type);
	}

	public Yfminfo getYfminfoByminfoId(Integer minfoId) {
		// TODO Auto-generated method stub
		return yfmInfoDao.getYfminfoByminfoId(minfoId);
	}
	/**
	 * 根据拼音缩写模糊查询药品信息
	 */
	public List<Yfminfo> getYfminfoBySpell(String spell) {		
		return yfmInfoDao.getYfminfoBySpell(spell);
	}
	
	public String[][] getYaoPinXinXibyLeiXingYaoFang(Integer YaoFanID, String LeiXing){
		return yfmInfoDao.getYaoPinXinXibyLeiXingYaoFang(YaoFanID, LeiXing);
	}

	public List<Yfminfo> getYFMinfoAll() {
		// TODO Auto-generated method stub
		return yfmInfoDao.getYFMinfoAll();
	}

	public List<Yfminfo> getYFMInfoAlias(String MName, String spell) {
		// TODO Auto-generated method stub
		return yfmInfoDao.getYFMInfoAlias(MName, spell);
	}
}
