package leo.ws.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.xml.registry.infomodel.EmailAddress;

import org.hibernate.HibernateException;

import leo.common.dao.DaoSupport;
import leo.entity.WsdocW;
import leo.entity.WsdocW1;
import leo.ws.dao.WsdocWDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Sep 15, 2011 2:40:18 PM
 */
public class WsdocWDaoImpl extends DaoSupport<WsdocW> implements WsdocWDao {

	public List<WsdocW> getWsdocWByDocWriteId(Long docWriteId) {

		return getScrollData(" o.itemDocWid=?", docWriteId);
	}

	public void deleteByItemDocWIdAndWsOrder(Long itemDocWID, Integer wsOrder, String wstatus) {
		getSession().createQuery("delete from WsdocW w where w.itemDocWid=? and w.wsorder>=? and w.wstatus=?")
				.setParameter(0, itemDocWID).setParameter(1, wsOrder).setParameter(2, wstatus).executeUpdate();
	}

	public WsdocW getByWsdocIdAndItemDocWID(Long docId, Long itemDocWid) {

		return (WsdocW) getSession().createQuery("from WsdocW w where w.docId=? and  w.itemDocWid=?").setParameter(0, docId)
				.setParameter(1, itemDocWid).uniqueResult();
	}

	public void deleteObject(WsdocW wsdoW) {

		getHibernateTemplate().delete(wsdoW);
	}

	public Integer getMaxOrderNO(Long itemDocWid) {

		try {

			return (Integer) getSession().createQuery("select max(w.wsorder) from WsdocW w where w.itemDocWid=?")
					.setParameter(0, itemDocWid).uniqueResult();
		} catch (HibernateException e) {
			return 0;
		}

	}
}
