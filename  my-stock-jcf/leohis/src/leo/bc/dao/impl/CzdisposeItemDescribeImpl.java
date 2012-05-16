package leo.bc.dao.impl;

import java.util.List;

import leo.bc.dao.iface.CzdisposeItemDescribeDao;
import leo.common.dao.DaoSupport;
import leo.entity.CzdisposeItemDescribe;

@SuppressWarnings("unchecked")
public class CzdisposeItemDescribeImpl extends
		DaoSupport<CzdisposeItemDescribe> implements CzdisposeItemDescribeDao {

	public boolean addCZDisposeItem(CzdisposeItemDescribe czdisposeItemDescribe) {
		try {
			this.getHibernateTemplate().save(czdisposeItemDescribe);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCZDisposeItem(
			CzdisposeItemDescribe czdisposeItemDescribe) {
		try {
			this.getHibernateTemplate().update(czdisposeItemDescribe);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<CzdisposeItemDescribe> getByIDs(List<Integer> ids) {
		return getSession()
				.createQuery(
						"from CzdisposeItemDescribe c where c.itemTypeId in (:itemTypeIds)")
				.setParameterList("itemTypeIds", ids).list();
	}

	public List<CzdisposeItemDescribe> getByMedicalOrgId(Integer medicalOrgaId) {
		return getSession().createQuery(
				"from CzdisposeItemDescribe c where c.medicalInstId=?")
				.setParameter(0, medicalOrgaId).list();
	}

	public List<CzdisposeItemDescribe> getCzdisposeItemDescribeByNameOrSpell(
			String itemName, String spell) {
		// TODO Auto-generated method stub
		String hql = "from CzdisposeItemDescribe";
		if (!"".equals(itemName)) {
			hql += " where itemName='" + itemName + "'";
		} else if (!"".equals(spell)) {
			if (!"".equals(itemName)) {
				hql += " and spell like '%" + spell + "%'";
			} else {
				hql += " where spell like '%" + spell + "%'";
			}
		}
		return this.getSession().createQuery(hql).list();
	}
	/**
	 * 根据主键查询处置项目类型
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByItemTypID(
			Integer itemTypeId) {
		// TODO Auto-generated method stub
		return (CzdisposeItemDescribe)super.getHibernateTemplate().get(CzdisposeItemDescribe.class, itemTypeId);
	}
}