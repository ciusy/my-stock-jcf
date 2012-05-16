package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfcheckRecord;

public interface YfcheckRecordDao extends Dao<YfcheckRecord>{
	public boolean addYfcheckRecord(YfcheckRecord yfcheckRecord); //增加盘点表对
	public String getMaxID(); //返回最大盘点号
	public List<YfcheckRecord> getYfcheckRecord(String DanHao, String KaiShiRiQi, String JieSuRiQi, String ZhuangTai, Integer YaoFang);
	public boolean delYfcheckRecord(String DanHao);
	public boolean updateZhuangTai(String DanHao, String ZhuangTai); //修改盘点单状态
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
}
