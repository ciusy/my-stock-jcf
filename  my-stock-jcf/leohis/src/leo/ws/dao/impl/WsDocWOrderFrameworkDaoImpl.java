package leo.ws.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.WsdocWorderFramework;
import leo.ws.dao.WsDocWOrderFrameworkDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 12, 2011 2:48:14 PM
 */
public class WsDocWOrderFrameworkDaoImpl extends DaoSupport<WsdocWorderFramework> implements WsDocWOrderFrameworkDao {

	public List<List<String>> getWsDocOfTemplate(Long templateId) {

		return listObject2ListString(getSession()
				.createSQLQuery(
						"select w2.DocName,w1.step,w2.DocID from WSOrderItem w1 ,WSDocument w2 where w1.DocID=w2.DocID and w1.FrameworkID=? order by w1.Step")
				.setParameter(0, templateId).list());
	}

	public List<List<String>> getWsDocOfTemplateByItemTypeId(Long itemTypeId) {

		return listObject2ListString(getSession().createSQLQuery(
				"select w2.DocName,w1.step,w2.DocID from WSOrderItem w1 ,WSDocument w2,WSDocWOrderFramework w3"
						+ " where w1.DocID=w2.DocID and w3.FrameworkID=w1.FrameworkID and  w3.itemTypeId=? order by w1.Step")
				.setParameter(0, itemTypeId).list());
	}
}
