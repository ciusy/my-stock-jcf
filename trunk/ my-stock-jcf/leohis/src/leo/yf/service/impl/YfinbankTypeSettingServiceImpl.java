package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfinbankTypeSetting;
import leo.yf.service.iface.YfinbankTypeSettingService;
import leo.yf.dao.iface.YfinbankTypeSettingDao;

public class YfinbankTypeSettingServiceImpl implements
		YfinbankTypeSettingService {
	
	private YfinbankTypeSettingDao yfinbankTypeSettingDao;
	
	public List<YfinbankTypeSetting> getYfinbankTypeSetting(Integer id, Integer PharmacyID, String TypeName) {
		return yfinbankTypeSettingDao.getYfinbankTypeSetting(id, PharmacyID, TypeName);
	}

	public void setYfinbankTypeSettingDao(
			YfinbankTypeSettingDao yfinbankTypeSettingDao) {
		this.yfinbankTypeSettingDao = yfinbankTypeSettingDao;
	}

	public boolean addYfinbankTypeSetting(YfinbankTypeSetting yfinbankTypeSetting){
		return yfinbankTypeSettingDao.addYfinbankTypeSetting(yfinbankTypeSetting);
	}
	
	public boolean delYfinbankTypeSetting(Integer id){
		return yfinbankTypeSettingDao.delYfinbankTypeSetting(id);
	}
	
	public boolean updateYfinbankTypeSetting(YfinbankTypeSetting yfinbankTypeSetting){
		return yfinbankTypeSettingDao.updateYfinbankTypeSetting(yfinbankTypeSetting);
	}
	/**
	 * 根据主键查询入库类型
	 */
	public YfinbankTypeSetting getYfinbankTypeSettingByinbankTypeId(
			Integer inbankTypeId) {
		// TODO Auto-generated method stub
		return yfinbankTypeSettingDao.getYfinbankTypeSettingByinbankTypeId(inbankTypeId);
	}
	/**
	 * 查询所有入库类型
	 */
	public List<YfinbankTypeSetting> getYfinbankTypeSettingAll() {
		// TODO Auto-generated method stub
		return yfinbankTypeSettingDao.getYfinbankTypeSettingAll();
	}
}
