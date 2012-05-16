package leo.ys.service.iface;

import java.util.List;

import leo.entity.FamiliRecordBasicInfo;
import leo.entity.PregnancyResult;

public interface YSPregnancyResultService {
	/**
	 * ��ȡ�����ּ�¼���ID��ҽ��
	 * @param RecordID
	 * @return
	 */
	public String[][] getIDandYS(String RecordID);
	/**
	 * ��ȡ��ͥ����������Ϣ
	 * @param RecordID ������
	 * @return
	 */
	public List<FamiliRecordBasicInfo> getDangAnJiChuInfo(String RecordID);
	/**
	 * ���������ּ�¼��
	 * @param pregnancyResult �����ּ�¼����
	 * @return
	 */
	public boolean addRenChengJieJu(PregnancyResult pregnancyResult);
	/**
	 * �޸������ּ�¼��
	 * @param pregnancyResult�����ּ�¼��
	 * @return
	 */
	public boolean updateRenChengJieJu(PregnancyResult pregnancyResult);
	/**
	 * ��ȡ�����ּ�¼��
	 * @param RecordID ������
	 * @param ID ID��
	 * @return
	 */
	public List<PregnancyResult> getRenChengJieJu(String RecordID, Integer ID);
}
