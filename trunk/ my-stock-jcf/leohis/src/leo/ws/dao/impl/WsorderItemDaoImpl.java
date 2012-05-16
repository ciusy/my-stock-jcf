package leo.ws.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.WsorderItem;
import leo.ws.dao.WsorderItemDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 16, 2011 9:53:18 AM
 */
public class WsorderItemDaoImpl extends DaoSupport<WsorderItem> implements WsorderItemDao {

	@SuppressWarnings("unchecked")
	public List<List<String>> getWsorderItemByTemplateId(Long templateId) {
		return listObject2ListString(getSession().createQuery(
				"select w1.docId, w2.docName from WsorderItem w1 ,Wsdocument w2 where w2.docId=w1.docId and w1.frameworkId=?")
				.setParameter(0, templateId).list());
	}

	public void deleteByTemplateID(Long templateId) {

		getSession().createQuery("delete from WsorderItem w where w.frameworkId=?").setParameter(0, templateId).executeUpdate();

	}
}
