package leo.ys.service.impl;

import leo.entity.EarlyPregnancyVisit;
import leo.ys.dao.iface.YSEarlyPregnancyVisitDao;
import leo.ys.service.iface.YSEarlyPregnancyVisitService;
/**
 * ������ü�¼Service�ӿ�ʵ��
 * @author abc
 *
 */
public class YSEarlyPregnancyVisitServiceImpl implements
		YSEarlyPregnancyVisitService {
	
	YSEarlyPregnancyVisitDao ysearlyDao = null;
	public void setYsearlyDao(YSEarlyPregnancyVisitDao ysearlyDao) {
		this.ysearlyDao = ysearlyDao;
	}
	/**
	 * ���������ü�¼
	 */
	public boolean addEarlyPregnancyVisit(EarlyPregnancyVisit early) {
		// TODO Auto-generated method stub
		return ysearlyDao.addEarlyPregnancyVisit(early);
	}
	/**
	 * ����������ѯ��ü�¼
	 */
	public EarlyPregnancyVisit getEarlyPregnancyVisitByrecordId(String recordId) {
		// TODO Auto-generated method stub
		return ysearlyDao.getEarlyPregnancyVisitByrecordId(recordId);
	}
	/**
	 * �޸���ü�¼
	 */
	public boolean updateEarlyPregnancyVisit(EarlyPregnancyVisit early) {
		// TODO Auto-generated method stub
		return ysearlyDao.updateEarlyPregnancyVisit(early);
	}
	/**
	 * �ָ��ַ���
	 * parameter str Ҫ�ָ���ַ���
	 * parameter charStr �ָ��
	 */
	public String[] splitStr(String str, String charStr) {
		// TODO Auto-generated method stub
		String[] strs = str.split(charStr);
		return strs;
	}

}
