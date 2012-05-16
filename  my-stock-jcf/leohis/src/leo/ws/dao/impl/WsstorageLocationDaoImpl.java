package leo.ws.dao.impl;

import leo.common.dao.DaoSupport;
import leo.entity.WsstorageLocation;
import leo.ws.dao.WsstorageLocationDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Sep 5, 2011 5:22:14 PM
 */
public class WsstorageLocationDaoImpl extends DaoSupport<WsstorageLocation>
		implements WsstorageLocationDao {

	public WsstorageLocation getByCondition(String locationName,
			Integer medicalInstId) {

		return (WsstorageLocation) getSession()
				.createQuery(
						"from WsstorageLocation w where w.locationName=? and w.medicalInstId=?")
				.setParameter(0, locationName).setParameter(1, medicalInstId)
				.uniqueResult();

	}

	public WsstorageLocation getByConditionExceptId(Long id, String value,
			Integer medicalOrgId) {

		return (WsstorageLocation) getSession()
				.createQuery(
						"from WsstorageLocation w where w.locationName=? and w.medicalInstId=? and w.slid<>?")
				.setParameter(0, value).setParameter(1, medicalOrgId)
				.setParameter(2, id).uniqueResult();
	}

}
