package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfcheckRecord;
import leo.entity.YfcheckRecordItem;

/**
 * 盘点记录service
 * @author abc
 *
 */
public interface YfcheckRecordService {
	/**
	 * 按条件查询盘点记录
	 * @param aformId 盘点记录ID
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @param inbankStatus 状态
	 * @param validityPeriod 有效期
	 * @return
	 */
	public YfcheckRecord getYfcheckRecordByTiaojian(String checkRecordId, String startDate,
			String endDate, String checkStatus,
			String validityPeriod);
	
	/**
	 * 根据盘点记录Id查询盘点记录项
	 * @return
	 */
	public List<YfcheckRecordItem> getYfcheckRecordItemBycheckRecordId(String checkRecordId);
}
