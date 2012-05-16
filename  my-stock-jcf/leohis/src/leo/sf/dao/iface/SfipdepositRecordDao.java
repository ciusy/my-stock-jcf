package leo.sf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SfipdepositRecord;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 5, 2011 2:42:17 PM
 */
public interface SfipdepositRecordDao extends Dao<SfipdepositRecord> {

	/**
	 * ���ݶ��סԺid���Ҷ�Ӧ��סԺѺ������������ܶ�
	 * 
	 * @param ipIDS
	 * @return
	 */
	List<Object[]> getTotalByIpIDS(List<String> ipIDS);
	/**
	 * ��ȡѺ���¼
	 * @param IPID סԺ��
	 * @return
	 */
	public List<SfipdepositRecord> getSfipdepositRecord(String IPID);

	void getIpDesopitRescordStatistics(String startTime, String endTime);

}
