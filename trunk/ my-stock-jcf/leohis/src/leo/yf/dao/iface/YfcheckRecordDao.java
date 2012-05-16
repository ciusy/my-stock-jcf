package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfcheckRecord;

public interface YfcheckRecordDao extends Dao<YfcheckRecord>{
	public boolean addYfcheckRecord(YfcheckRecord yfcheckRecord); //�����̵���
	public String getMaxID(); //��������̵��
	public List<YfcheckRecord> getYfcheckRecord(String DanHao, String KaiShiRiQi, String JieSuRiQi, String ZhuangTai, Integer YaoFang);
	public boolean delYfcheckRecord(String DanHao);
	public boolean updateZhuangTai(String DanHao, String ZhuangTai); //�޸��̵㵥״̬
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
}
