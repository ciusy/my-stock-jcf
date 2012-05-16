package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SmsModuleTerm;

public interface YSSmsModuleTermDao extends Dao<SmsModuleTerm>{
	/**
	 * 增加短信模板项
	 * @param smsModuleTerm 短信模板项内容
	 * @return
	 */
	public Long addSmsModuleTerm(SmsModuleTerm smsModuleTerm);
	/**
	 * 根据短信模板ID提取短信模板项
	 * @param ModuleID 短信模板ID
	 * @return
	 */
	public List<SmsModuleTerm> getsmsModuleTerm(Long ModuleID);
	/**
	 * 修改短信模板项
	 * @param smsModuleTerm 短信模板项内容
	 * @return
	 */
	public boolean updateSmsModuleTerm(SmsModuleTerm smsModuleTerm);
	/**
	 * 根据模板项ID或模板ID删除模板项
	 * @param STTID 模板项id
	 * @param ModuleID 模板id
	 * @return
	 */
	public boolean delSmsModuleTerm(Long STTID, Long ModuleID);
	/**
	 * 提取模板项内容
	 * @param ModuleID 模板ID
	 * @return 0:模板项ID  1:前后天数  2:模板类型
	 */
	public String[][] getXiangNeiRong(Long ModuleID);
	/**
	 * 提取所有模板项内容
	 * @return
	 */
	public String[][] getAllXiangNeiRong();
}
