package leo.sf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SfipdepositRecord;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 5, 2011 2:42:17 PM
 */
public interface SfipdepositRecordDao extends Dao<SfipdepositRecord> {

	/**
	 * 根据多个住院id查找对应的住院押金的所交过的总额
	 * 
	 * @param ipIDS
	 * @return
	 */
	List<Object[]> getTotalByIpIDS(List<String> ipIDS);
	/**
	 * 提取押金记录
	 * @param IPID 住院号
	 * @return
	 */
	public List<SfipdepositRecord> getSfipdepositRecord(String IPID);

	void getIpDesopitRescordStatistics(String startTime, String endTime);

}
