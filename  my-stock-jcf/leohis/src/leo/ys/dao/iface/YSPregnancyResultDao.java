package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.PregnancyResult;

public interface YSPregnancyResultDao extends Dao<PregnancyResult>{
	/**
	 * ��ȡ��Ҫ�������͵Ķ�����Ա
	 * @param TianShu ǰ������
	 * @return
	 */
	public String[][] getChuShengDuanXinRenYuan(Integer TianShu);
	/**
	 * ��ȡ�����ּ�¼���ID��ҽ��
	 * @param RecordID
	 * @return
	 */
	public String[][] getIDandYS(String RecordID);
	/**
	 * ���������ּ�¼��
	 * @param pregnancyResult �����ּ�¼����
	 * @return
	 */
	public boolean addPregnancyResult(PregnancyResult pregnancyResult);
	/**
	 * �޸������ּ�¼��
	 * @param pregnancyResult�����ּ�¼��
	 * @return
	 */
	public boolean updatePregnancyResult(PregnancyResult pregnancyResult);
	/**
	 * ��ȡ�����ּ�¼��
	 * @param RecordID ������
	 * @param ID ID��
	 * @return
	 */
	public List<PregnancyResult> getPregnancyResult(String RecordID, Integer ID);

}
