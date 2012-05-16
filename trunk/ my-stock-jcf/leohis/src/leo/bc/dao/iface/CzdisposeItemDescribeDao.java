package leo.bc.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.CzdisposeItemDescribe;

public interface CzdisposeItemDescribeDao extends Dao<CzdisposeItemDescribe> {
	public boolean addCZDisposeItem(CzdisposeItemDescribe czdisposeItemDescribe);// 添加处置项目描述

	public boolean updateCZDisposeItem(
			CzdisposeItemDescribe czdisposeItemDescribe);// 更新处置项目描述

	/**
	 * add by xu
	 * 
	 * @param ids
	 * @return
	 */
	public List<CzdisposeItemDescribe> getByIDs(List<Integer> ids);

	/**
	 * add by xu 根据医疗机构的查找 处置项目描述表
	 * 
	 * @param medicalOrgaId
	 * @return
	 */
	public List<CzdisposeItemDescribe> getByMedicalOrgId(Integer medicalOrgaId);
	/**
	 * 根据处置项目名称或处置项目拼音简写查询处置项目
	 * @param itemName
	 * @param spell
	 * @return
	 */
	public List<CzdisposeItemDescribe> getCzdisposeItemDescribeByNameOrSpell(
			String itemName, String spell);
	/**
	 * 根据主键查询处置项目类型
	 * @param itemTypeId
	 * @return
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByItemTypID(Integer itemTypeId);
}
