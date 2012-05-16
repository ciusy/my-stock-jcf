package leo.ys.service.impl;

import java.util.List;

import leo.entity.FamiliRecordBasicInfo;
import leo.entity.PregnancyResult;
import leo.ys.service.iface.YSPregnancyResultService;
import leo.ys.dao.iface.YSPregnancyResultDao;
import leo.ys.dao.iface.YSFamiliRecordBasicInfoDao;

public class YSPregnancyResultServiceImpl implements YSPregnancyResultService {
	private YSPregnancyResultDao ySPregnancyResultDao;
	private YSFamiliRecordBasicInfoDao ySFamiliRecordBasicInfoDao;

	
	public void setySFamiliRecordBasicInfoDao(
			YSFamiliRecordBasicInfoDao ySFamiliRecordBasicInfoDao) {
		this.ySFamiliRecordBasicInfoDao = ySFamiliRecordBasicInfoDao;
	}

	public void setySPregnancyResultDao(YSPregnancyResultDao ySPregnancyResultDao) {
		this.ySPregnancyResultDao = ySPregnancyResultDao;
	}

	public String[][] getIDandYS(String RecordID){
		return ySPregnancyResultDao.getIDandYS(RecordID);
	}

	public List<FamiliRecordBasicInfo> getDangAnJiChuInfo(String RecordID){
		return ySFamiliRecordBasicInfoDao.getFamiliRecordBasicInfo(RecordID);
	}

	public boolean addRenChengJieJu(PregnancyResult pregnancyResult){
		return ySPregnancyResultDao.addPregnancyResult(pregnancyResult);
	}

	public boolean updateRenChengJieJu(PregnancyResult pregnancyResult){
		return ySPregnancyResultDao.updatePregnancyResult(pregnancyResult);
	}

	public List<PregnancyResult> getRenChengJieJu(String RecordID, Integer ID){
		return ySPregnancyResultDao.getPregnancyResult(RecordID, ID);
	}
	
}
