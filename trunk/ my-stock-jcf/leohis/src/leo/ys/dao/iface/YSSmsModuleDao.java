package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SmsModule;

public interface YSSmsModuleDao extends Dao<SmsModule>{
	/**
	 * 增加短信模板头
	 * @param smsModule 模板头内容
	 * @return
	 */
	public Long addSmsModule(SmsModule smsModule);
	/**
	 * 根据模板类型和所属单位ID查找模板头
	 * @param PointName 模板类型
	 * @param AffiliationID 所属单位ID
	 * @return
	 */
	public List<SmsModule> getSmsModule(String PointName, Long AffiliationID);
	/**
	 * 修改模板头
	 * @param smsModule 模板头内容
	 * @return
	 */
	public boolean updateSmsModule(SmsModule smsModule);
	/**
	 * 删除模板头
	 * @param ModuleID 模板ID
	 * @return
	 */
	public boolean delSmsModule(Long ModuleID);
	/**
	 * 根据单位ID提取模板名称
	 * @param AffiliationID 单位ID
	 * @return 0:模板名称  1:模板ID
	 */
	public String[][] getMoBanMingCheng(Long AffiliationID); 
}
