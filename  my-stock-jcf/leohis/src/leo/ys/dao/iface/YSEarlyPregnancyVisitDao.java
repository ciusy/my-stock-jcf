package leo.ys.dao.iface;

import leo.common.dao.Dao;
import leo.entity.EarlyPregnancyVisit;
import leo.entity.PregnancyResult;

/**
 * ������ü�¼Dao�ӿ�
 * @author abc
 *
 */
public interface YSEarlyPregnancyVisitDao extends Dao<EarlyPregnancyVisit>{
	/**
	 * �����ü�¼
	 * @param early
	 * @return
	 */
	public boolean addEarlyPregnancyVisit(EarlyPregnancyVisit early);
	/**
	 * �޸���ü�¼
	 * @param early
	 * @return
	 */
	public boolean updateEarlyPregnancyVisit(EarlyPregnancyVisit early);
	/**
	 * ����������ѯ��ü�¼����
	 * @param recordId
	 * @return
	 */
	public EarlyPregnancyVisit getEarlyPregnancyVisitByrecordId(String recordId);
	/**
	 * ��ȡʵ�ʻ��ж�����Ա
	 * @param TianShu ǰ������
	 */
	public String[][] getHuaiYunDuanXinRenYuan(Integer TianShu);
}
