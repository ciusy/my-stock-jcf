package leo.yf.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.yf.dao.iface.YFApproveTableDao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * ������DAOʵ��
 * @author abc
 *
 */
public class YFApproveTableDaoImpl extends DaoSupport<YfapproveTable> implements YFApproveTableDao {
	/**
	 * ����������ѯ����������
	 */
	public YfapproveTable getYFApproveTableByApproveFormId(Long approveFormId) {
		// TODO Auto-generated method stub
		try {
			return (YfapproveTable)super.getHibernateTemplate().get(YfapproveTable.class, approveFormId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean addYFApproveTable(YfapproveTable yfapproveTable){
		this.getHibernateTemplate().save(yfapproveTable);
		return true;
	}
	
	public Long getMaxID(){
		Query query = null; // ����һ����ѯ����
		query = this.getSession().createQuery(
				"select a.approveFormId from YfapproveTable a order by a.approveFormId desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Long> list = (List<Long>) query.list();
		if (list.size() < 1)
			return -1l;
		else
			return list.get(0);
		
	}
	/**
	 * ��ѯ����������
	 */
	public List<YfapproveTable> getYfapproveTableAll() {
		// TODO Auto-generated method stub
		try {
			return super.getSession().createQuery("from YfapproveTable").list();
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
	 * ���ݼ�¼ID��ѯ������
	 */
	public List<YfapproveTable> getYfapproveTableByRecordId(String recordId) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Query query = session.createQuery("from YfapproveTable where recordId=?");
		query.setString(0, recordId);
		return query.list();
	}
}
