package leo.ws.dao;

import leo.common.dao.Dao;
import leo.entity.WsstorageLocation;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Sep 5, 2011 5:21:58 PM
 */
public interface WsstorageLocationDao extends Dao<WsstorageLocation> {

	WsstorageLocation getByCondition(String locationName, Integer medicalInstId);

	WsstorageLocation getByConditionExceptId(Long id, String value, Integer medicalOrgId);

}

