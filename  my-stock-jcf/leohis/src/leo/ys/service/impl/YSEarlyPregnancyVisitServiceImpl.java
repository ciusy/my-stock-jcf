package leo.ys.service.impl;

import leo.entity.EarlyPregnancyVisit;
import leo.ys.dao.iface.YSEarlyPregnancyVisitDao;
import leo.ys.service.iface.YSEarlyPregnancyVisitService;
/**
 * 早孕随访记录Service接口实现
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
	 * 添加早孕随访记录
	 */
	public boolean addEarlyPregnancyVisit(EarlyPregnancyVisit early) {
		// TODO Auto-generated method stub
		return ysearlyDao.addEarlyPregnancyVisit(early);
	}
	/**
	 * 根据主键查询随访记录
	 */
	public EarlyPregnancyVisit getEarlyPregnancyVisitByrecordId(String recordId) {
		// TODO Auto-generated method stub
		return ysearlyDao.getEarlyPregnancyVisitByrecordId(recordId);
	}
	/**
	 * 修改随访记录
	 */
	public boolean updateEarlyPregnancyVisit(EarlyPregnancyVisit early) {
		// TODO Auto-generated method stub
		return ysearlyDao.updateEarlyPregnancyVisit(early);
	}
	/**
	 * 分割字符串
	 * parameter str 要分割的字符串
	 * parameter charStr 分割符
	 */
	public String[] splitStr(String str, String charStr) {
		// TODO Auto-generated method stub
		String[] strs = str.split(charStr);
		return strs;
	}

}
