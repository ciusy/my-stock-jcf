package leo.sf.dao.iface;

import leo.common.dao.Dao;
import leo.entity.SfaccountDetail;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Sep 7, 2011 4:08:03 PM
 */
public interface SfAccountDetailDao extends Dao<SfaccountDetail> {
	/**
	 * �Ӻͼ����굥
	 * @param sfaccountDetail �����굥
	 * @return
	 */
	public boolean addSfAccountDetail(SfaccountDetail sfaccountDetail);

}
