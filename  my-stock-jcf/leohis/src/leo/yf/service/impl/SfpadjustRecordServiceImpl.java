package leo.yf.service.impl;

import java.util.List;

import leo.entity.SfpadjustRecord;
import leo.yf.dao.iface.SfpadjustRecordDao;
import leo.yf.service.iface.SfpadjustRecordService;

public class SfpadjustRecordServiceImpl implements SfpadjustRecordService {
	private SfpadjustRecordDao sfpadjustRecordDao;

	public boolean addSfpadjustRecordDao(SfpadjustRecord sfpadjustRecord) {
		return sfpadjustRecordDao.addSfpadjustRecordDao(sfpadjustRecord);
	}

	public void setSfpadjustRecordDao(SfpadjustRecordDao sfpadjustRecordDao) {
		this.sfpadjustRecordDao = sfpadjustRecordDao;
	}

	public List<SfpadjustRecord> getSfpadjustRecord(Long PID) {
		return sfpadjustRecordDao.getSfpadjustRecord(PID);
	}

}
