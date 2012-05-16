package leo.sf.dao.iface;

import leo.common.dao.Dao;
import leo.entity.SfaccountDetail;

/**
 * @author xuxiangpan
 * @version 创建时间：Sep 7, 2011 4:08:03 PM
 */
public interface SfAccountDetailDao extends Dao<SfaccountDetail> {
	/**
	 * 加和记账详单
	 * @param sfaccountDetail 记账详单
	 * @return
	 */
	public boolean addSfAccountDetail(SfaccountDetail sfaccountDetail);

}
