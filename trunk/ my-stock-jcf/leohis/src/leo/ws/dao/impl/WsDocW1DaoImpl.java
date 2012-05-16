package leo.ws.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.WsdocW1;
import leo.ws.dao.WsDocW1Dao;

/**
 * @author xuxiangpan
 * @version 创建时间：2011-9-21 下午03:47:45
 */
@SuppressWarnings("unchecked")
public class WsDocW1DaoImpl extends DaoSupport<WsdocW1> implements WsDocW1Dao {

	
	public List<WsdocW1> getWsDocW1ByDocWid(Long docWid) {

		return (List<WsdocW1>) getSession().createQuery("from WsdocW1 w where w.docWID=? order by w.wid").setParameter(0, docWid)
				.list();
	}

}
