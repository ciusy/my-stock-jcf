package leo.sf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.common.util.DateUtil;
import leo.entity.SfaccountDetail;
import leo.sf.dao.iface.SfAccountDetailDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Sep 7, 2011 4:08:28 PM
 */
public class SfAccountDetailDaoImpl extends DaoSupport<SfaccountDetail>
		implements SfAccountDetailDao {
	public boolean addSfAccountDetail(SfaccountDetail sfaccountDetail) {
		this.getHibernateTemplate().save(sfaccountDetail);
		return true;
	}

	

}
