package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfcheckRecord;
import leo.entity.YfcheckRecordItem;
import leo.yf.dao.iface.YfcheckRecordDao;
import leo.yf.dao.iface.YfcheckRecordItemDao;
import leo.yf.service.iface.YfcheckRecordService;

public class YfcheckRecordServiceImpl implements YfcheckRecordService {
	YfcheckRecordDao yfcDao;
	public void setYfcDao(YfcheckRecordDao yfcDao) {
		this.yfcDao = yfcDao;
	}
	YfcheckRecordItemDao yfcItemDao;	
	public void setYfcItemDao(YfcheckRecordItemDao yfcItemDao) {
		this.yfcItemDao = yfcItemDao;
	}

	/**
	 * 按条件查询盘点记录
	 */
	public YfcheckRecord getYfcheckRecordByTiaojian(String checkRecordId,
			String startDate, String endDate, String checkStatus,
			String validityPeriod) {
		// TODO Auto-generated method stub
		return yfcDao.getYfcheckRecordByTiaojian(checkRecordId, startDate, endDate, checkStatus, validityPeriod);
	}
	/**
	 * 根据盘点记录ID查询盘点记录项
	 */
	public List<YfcheckRecordItem> getYfcheckRecordItemBycheckRecordId(
			String checkRecordId) {
		// TODO Auto-generated method stub
		return yfcItemDao.getYfcheckRecordItemBycheckRecordId(checkRecordId);
	}

}
