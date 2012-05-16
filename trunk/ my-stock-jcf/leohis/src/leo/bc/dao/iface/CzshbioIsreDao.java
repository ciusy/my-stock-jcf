package leo.bc.dao.iface;

import leo.common.dao.Dao;
import leo.entity.CzshbioIsre;

public interface CzshbioIsreDao extends Dao<CzshbioIsre>{
	public boolean  addCzshbioIsre(CzshbioIsre czshbioIsre);//填写生化检验报告；
	/**
	 * 根据诊断ID提取化验数据(优生使用)
	 * @param OpDnID 诊断ID
	 * @param ItemName 项目名称(空：返回一个诊断号的所有化验项目)
	 * @return 0检查项目  1子项中文名称  2子项英文名称  3子项结果  4参考范围  5单位  6提示
	 */
	public String[][] getCzshbioIsreByOpDnID(String OpDnID, String ItemName);
	/**
	 * 根据项目ID和项目名称提取化验数据(站内使用)
	 * @param ItemID 项目ID
	 * @param ItemName 项目名称
	 * @return
	 */
	public String[][] getCzshbioIsreByItemID(String ItemID, String ItemName);

}
