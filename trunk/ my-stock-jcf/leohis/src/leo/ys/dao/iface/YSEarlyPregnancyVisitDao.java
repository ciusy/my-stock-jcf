package leo.ys.dao.iface;

import leo.common.dao.Dao;
import leo.entity.EarlyPregnancyVisit;
import leo.entity.PregnancyResult;

/**
 * 早孕随访记录Dao接口
 * @author abc
 *
 */
public interface YSEarlyPregnancyVisitDao extends Dao<EarlyPregnancyVisit>{
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
	 * 提取实际怀孕短信人员
	 * @param TianShu 前后天数
	 */
	public String[][] getHuaiYunDuanXinRenYuan(Integer TianShu);
}
