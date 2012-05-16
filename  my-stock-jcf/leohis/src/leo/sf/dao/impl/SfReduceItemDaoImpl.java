package leo.sf.dao.impl;

import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.SfreduceItem;
import leo.sf.dao.iface.SfReduceItemDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 27, 2011 11:43:28 AM
 */
public class SfReduceItemDaoImpl extends DaoSupport<SfreduceItem> implements SfReduceItemDao {

	public List<SfreduceItem> getByItemTypeID(HashSet<Integer> itemTypeIDList) {
		Query query = getSession().createQuery("from SfreduceItem s where s.costTypeId in (:itemTypeIDList)");
		query.setParameterList("itemTypeIDList", itemTypeIDList);

		return query.list();
	}

	public SfreduceItem getSfreduceItemByItemTypeIDandcosttypeID(int itemtypeID, int costtypeID) {
		Query query = this.getSession().createQuery(
				"from SfreduceItem u where u.costTypeId=:itemtypeID and u.costType=:costtypeID");
		query.setInteger("itemtypeID", itemtypeID);
		query.setInteger("costtypeID", costtypeID);
		List<SfreduceItem> list = query.list();
		return list.get(0);

	}

	public SfreduceItem getBySingle(Integer costTypeId, String projectName) {

		return (SfreduceItem) getSession()
				.createQuery(
						"from SfreduceItem s,CzdisposeItemDescribe c" + " where s.costTypeId=c.itemTypeId and id=? "
								+ " and c.itemName=? ").setParameter(0, costTypeId).setParameter(1, projectName).uniqueResult();

	}

}
