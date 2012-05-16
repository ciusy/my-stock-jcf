package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfcheckRecord;
import leo.entity.YfcheckRecordItem;

/**
 * �̵��¼service
 * @author abc
 *
 */
public interface YfcheckRecordService {
	/**
	 * ��������ѯ�̵��¼
	 * @param aformId �̵��¼ID
	 * @param startDate ��ʼ����
	 * @param endDate ��������
	 * @param inbankStatus ״̬
	 * @param validityPeriod ��Ч��
	 * @return
	 */
	public YfcheckRecord getYfcheckRecordByTiaojian(String checkRecordId, String startDate,
			String endDate, String checkStatus,
			String validityPeriod);
	
	/**
	 * �����̵��¼Id��ѯ�̵��¼��
	 * @return
	 */
	public List<YfcheckRecordItem> getYfcheckRecordItemBycheckRecordId(String checkRecordId);
}
