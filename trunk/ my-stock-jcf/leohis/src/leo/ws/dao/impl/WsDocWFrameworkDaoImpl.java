package leo.ws.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.WsdocWframework;
import leo.ws.dao.WsDocWFrameworkDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 31, 2011 9:45:37 AM
 */
public class WsDocWFrameworkDaoImpl extends DaoSupport<WsdocWframework> implements WsDocWFrameworkDao {

	@SuppressWarnings("unchecked")
	public List<WsdocWframework> getWsdocWframeworkByWsDocName(String wsDocName, String componentName) {

		return getSession()
				.createQuery(
						"select w from WsdocWframework w,Wsdocument w1  "
								+ "where w1.docId= w.docId and w.witem=? and w1.docName=?").setParameter(0, componentName)
				.setParameter(1, wsDocName).list();
	}

	public List<WsdocWframework> getWsdocWframeworkByWsDocId(Long wsDocId, String componentName) {

		return getSession().createQuery("select w from WsdocWframework w where w.docId= ? and w.witem=? ")
				.setParameter(0, wsDocId).setParameter(1, componentName).list();
	}
}
