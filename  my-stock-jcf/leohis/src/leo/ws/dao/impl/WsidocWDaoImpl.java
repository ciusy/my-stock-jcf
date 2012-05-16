package leo.ws.dao.impl;

import leo.common.dao.DaoSupport;
import leo.entity.WsidocW;
import leo.ws.dao.WsidocWDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Sep 15, 2011 12:00:53 PM
 */
public class WsidocWDaoImpl extends DaoSupport<WsidocW> implements WsidocWDao {

	public WsidocW findByKindId(String kindId) {
		try {
			return (WsidocW) getSession().createQuery("from WsidocW o where kindId=?").setParameter(0, kindId).uniqueResult();
		} catch (Exception e) {
			return null;
		}

	}
}
