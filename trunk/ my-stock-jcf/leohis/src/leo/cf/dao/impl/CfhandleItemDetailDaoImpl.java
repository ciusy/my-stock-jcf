package leo.cf.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cf.dao.iface.CfhandleItemDetailDao;
import leo.entity.CfhandleItemDetail;
import leo.entity.CzdisposeItemDescribe;
/**
 * ����ϸ��DAOʵ��
 * @author Administrator
 *
 */
public class CfhandleItemDetailDaoImpl extends HibernateDaoSupport implements CfhandleItemDetailDao {
	/**
	 * ��Ӵ���ϸ��
	 */
	public boolean addCfhandleItemDetail(CfhandleItemDetail cfh) {
		// TODO Auto-generated method stub
		try {
			super.getHibernateTemplate().save(cfh);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ����ģ��IDɾ������ϸ��
	 */
	public boolean delCfhandleItemDetailByModelId(Long modelId) {
		// TODO Auto-generated method stub
		try {
			String hql = "delete from CfhandleItemDetail where modelId=?";
			Session session = super.getSession();
			Query query = session.createQuery(hql);
			query.setLong(0, modelId);
			query.executeUpdate();
			return true;
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
		return false;
	}
	/**
	 * ����ģ��ID��ѯ����ϸ��
	 */
	public List<CfhandleItemDetail> getCfhandleItemDetailByModelId(Long modelId) {
		// TODO Auto-generated method stub
		try {
			String hql = "from CfhandleItemDetail where modelId=?";
			Session session = super.getSession();
			Query query = session.createQuery(hql);
			query.setLong(0, modelId);
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
	 * ������Ŀ����Id��ѯ������Ŀ
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(
			Integer itemId) {
		// TODO Auto-generated method stub
		try {
			return (CzdisposeItemDescribe)super.getHibernateTemplate().get(CzdisposeItemDescribe.class, itemId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ���ݴ���ϸ��Idɾ������ϸ��
	 */
	public boolean delCfhandleItemDetailByItemId(Long itemId) {
		// TODO Auto-generated method stub
		try {
			CfhandleItemDetail cfh = (CfhandleItemDetail)super.getHibernateTemplate().get(CfhandleItemDetail.class, itemId);
			super.getHibernateTemplate().delete(cfh);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ��ȡ�����ϸ��Id
	 */
	public Long getMaxItemId() {
		// TODO Auto-generated method stub
		try {
			Session session = super.getSession();
			Query query = session.createQuery("from CfhandleItemDetail order by itemId desc");
			query.setMaxResults(1);
			CfhandleItemDetail cfh = (CfhandleItemDetail)query.list().get(0);
			return cfh.getItemId();
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

}
