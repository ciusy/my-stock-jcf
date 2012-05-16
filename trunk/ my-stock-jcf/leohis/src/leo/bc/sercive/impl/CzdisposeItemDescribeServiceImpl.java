package leo.bc.sercive.impl;

import java.util.List;

import leo.bc.dao.iface.CzdisposeItemDescribeDao;
import leo.bc.sercive.iface.CzdisposeItemDescribeService;
import leo.entity.CzdisposeItemDescribe;

public class CzdisposeItemDescribeServiceImpl implements
		CzdisposeItemDescribeService {
	CzdisposeItemDescribeDao czdisposeItemDescribeDao;

	public void setCzdisposeItemDescribeDao(
			CzdisposeItemDescribeDao czdisposeItemDescribeDao) {
		this.czdisposeItemDescribeDao = czdisposeItemDescribeDao;
	}

	public boolean addCZDisposeItem(CzdisposeItemDescribe czdisposeItemDescribe) {

		return czdisposeItemDescribeDao.addCZDisposeItem(czdisposeItemDescribe);

	}

	public boolean updateCZDisposeItem(
			CzdisposeItemDescribe czdisposeItemDescribe) {

		return czdisposeItemDescribeDao
				.updateCZDisposeItem(czdisposeItemDescribe);

	}

	public List<CzdisposeItemDescribe> getCzdisposeItemDescribeByNameOrSpell(
			String itemName, String spell) {
		// TODO Auto-generated method stub
		return czdisposeItemDescribeDao.getCzdisposeItemDescribeByNameOrSpell(
				itemName, spell);
	}
	/**
	 * 根据主键查询处置项目类型
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByItemTypID(
			Integer itemTypeId) {
		// TODO Auto-generated method stub
		return czdisposeItemDescribeDao.getCzdisposeItemDescribeByItemTypID(itemTypeId);
	}

}
