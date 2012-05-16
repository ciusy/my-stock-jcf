package leo.ys.service.iface;

import leo.entity.EarlyPregnancyVisit;

/**
 * ������ü�¼Service�ӿ�
 * @author abc
 *
 */
public interface YSEarlyPregnancyVisitService {
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
	 * �ָ��ַ���
	 * @param str Ҫ�ָ���ַ���
	 * @param charStr �ָ��
	 * @return
	 */
	public String[] splitStr(String str, String charStr);
}
