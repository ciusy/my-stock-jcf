package leo.ws.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.Wsdocument;
import leo.ws.dao.WsDocumentDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 11, 2011 3:17:44 PM
 */
public class WsDocumentDaoImpl extends DaoSupport<Wsdocument> implements WsDocumentDao {

	public Wsdocument getByWsDocName(String wsDocName) {
		List<Wsdocument> list = getHibernateTemplate().find("from Wsdocument w where w.docName=?", wsDocName);
		return list.size() > 0 ? list.get(0) : null;
	}

	public List<List<String>> getWsdocByDocWriteId(Long docWriteId) {
		return listObject2ListString(getSession()
				.createSQLQuery(
						"select w.DocID,w.DocName,w1.DocWID,w1.WStatus from Wsdocument w,WsdocW w1 where w1.docId=w.docId and w1.itemDocWid=? order by w1.WSOrder asc")
				.setParameter(0, docWriteId).list());
	}
}
