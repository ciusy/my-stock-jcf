package leo.zy.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.ZyredudancyConsume;
import leo.zy.dao.iface.ZyRedudancyConsumeDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 5, 2011 11:46:17 AM
 */
@SuppressWarnings("unchecked")
public class ZyRedudancyConsumeDaoImpl extends DaoSupport<ZyredudancyConsume> implements ZyRedudancyConsumeDao {

	public List<Object[]> getZyredudancyConsume(List<String> ipIDS) {

		return getSession()
				.createQuery("select z.ipid, sum(charge) from ZyredudancyConsume z where z.ipid in (:ipIDS) group by z.ipid ")
				.setParameterList("ipIDS", ipIDS).list();
	}

}
