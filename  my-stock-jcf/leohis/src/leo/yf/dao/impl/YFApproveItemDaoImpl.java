package leo.yf.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.common.dao.DaoSupport;
import leo.entity.Yfaitem;
import leo.entity.YfapproveItem;
import leo.yf.dao.iface.YFApproveItemDao;

/**
 * ������Daoʵ��
 * 
 * @author abc
 * 
 */
public class YFApproveItemDaoImpl extends DaoSupport<YfapproveItem> implements
		YFApproveItemDao {
	/**
	 * ��ѯ����������
	 */
	public List<YfapproveItem> getYfapproveItemAll() {
		// TODO Auto-generated method stub
		try {
			Session session = super.getSession();
			Query query = session.createQuery("from YfapproveItem");
			return query.list();
		} catch (DataAccessResourceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����������ѯ������
	 */
	public YfapproveItem getYfapproveItemByapproveItemId(Long approveItemId) {
		// TODO Auto-generated method stub
		return (YfapproveItem) super.getHibernateTemplate().get(
				YfapproveItem.class, approveItemId);
	}

	public boolean addYfapproveItem(List<YfapproveItem> yfapproveItem) {
		for (int i = 0; i < yfapproveItem.size(); i++) {
			this.getHibernateTemplate().save(yfapproveItem.get(i));
		}
		return true;
	}

	/**
	 * ����������Id��ѯ������
	 */
	public List<YfapproveItem> getYfapproveItemByApproveFormId(
			Long approveFormId) {
		// TODO Auto-generated method stub
		try {
			Session session = super.getSession();
			Query query = session
					.createQuery("from YfapproveItem where approveFormId=?");
			query.setLong(0, approveFormId);
			return query.list();
		} catch (DataAccessResourceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����������id��������id��ѯ������
	 */
	public YfapproveItem getYfapproveItemByApproveFormIDandApprover(
			Long approveFormId, Long approver) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Query query = session
				.createQuery("from YfapproveItem where approveFormId=? and approver=?");
		query.setLong(0, approveFormId);
		query.setLong(1, approver);
		if(query.list().size() > 0){
			return (YfapproveItem)query.list().get(0);
		}
		return null;
	}
}
