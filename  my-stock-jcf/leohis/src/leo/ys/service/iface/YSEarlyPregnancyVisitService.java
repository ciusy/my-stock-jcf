package leo.ys.service.iface;

import leo.entity.EarlyPregnancyVisit;

/**
 * 早孕随访记录Service接口
 * @author abc
 *
 */
public interface YSEarlyPregnancyVisitService {
	/**
	 * 添加随访记录
	 * @param early
	 * @return
	 */
	public boolean addEarlyPregnancyVisit(EarlyPregnancyVisit early);
	/**
	 * 修改随访记录
	 * @param early
	 * @return
	 */
	public boolean updateEarlyPregnancyVisit(EarlyPregnancyVisit early);
	/**
	 * 根据主键查询随访记录对象
	 * @param recordId
	 * @return
	 */
	public EarlyPregnancyVisit getEarlyPregnancyVisitByrecordId(String recordId);
	/**
	 * 分割字符串
	 * @param str 要分割的字符串
	 * @param charStr 分割符
	 * @return
	 */
	public String[] splitStr(String str, String charStr);
}
