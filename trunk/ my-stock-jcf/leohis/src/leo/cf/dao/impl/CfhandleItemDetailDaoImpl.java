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
 * 处置细节DAO实现
 * @author Administrator
 *
 */
public class CfhandleItemDetailDaoImpl extends HibernateDaoSupport implements CfhandleItemDetailDao {
	/**
	 * 添加处置细节
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
	 * 根据模板ID删除处置细节
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
	 * 根据模板ID查询处置细节
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
	 * 根据项目类型Id查询处置项目
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
	 * 根据处置细节Id删除处置细节
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
	 * 获取最大处置细节Id
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
