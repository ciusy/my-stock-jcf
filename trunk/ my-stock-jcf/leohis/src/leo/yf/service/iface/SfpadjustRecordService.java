package leo.yf.service.iface;

import java.util.List;

import leo.entity.SfpadjustRecord;

public interface SfpadjustRecordService {
	public boolean addSfpadjustRecordDao(SfpadjustRecord sfpadjustRecord);
	public List<SfpadjustRecord> getSfpadjustRecord(Long PID);
}
