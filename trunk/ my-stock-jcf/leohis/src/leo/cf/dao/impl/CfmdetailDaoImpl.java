package leo.cf.dao.impl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cf.dao.iface.CfmdetailDao;
import leo.entity.Cfmdetail;

/**
 * 药品细节Dao实现
 * @author Administrator
 *
 */
public class CfmdetailDaoImpl extends HibernateDaoSupport implements CfmdetailDao {
	/**
	 * 添加药品细节
	 */
	public boolean addCfmdetail(Cfmdetail cfm) {
		// TODO Auto-generated method stub
		try {
			super.getHibernateTemplate().save(cfm);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除药品细节
	 */
	public boolean delCfmdetailByModelID(Long modelID) {
		// TODO Auto-generated method stub
		try {
			String hql = "delete from Cfmdetail where modelId=?";
			org.hibernate.Session session = super.getSession();
			Query query = session.createQuery(hql);
			query.setLong(0, modelID);
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
	 * 根据模板ID查询药品细节
	 */
	public List<Cfmdetail> getCfmdetailByModelId(Long modelId) {
		// TODO Auto-generated method stub
		try {
			String hql = "from Cfmdetail where modelId=?";
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
	 * 根据药品细节项Id删除药品细节
	 */
	public boolean delCfmdetailByiid(Long iid) {
		// TODO Auto-generated method stub
		try {
			Cfmdetail cfm = (Cfmdetail)super.getHibernateTemplate().get(Cfmdetail.class, iid);
			super.getHibernateTemplate().delete(cfm);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 获取最大药品Id
	 */
	public Long getMaxIid() {
		// TODO Auto-generated method stub
		try {
			Session session = super.getSession();
			Query query = session.createQuery("from Cfmdetail order by iid desc");
			query.setMaxResults(1);
			Cfmdetail cfm = (Cfmdetail)query.list().get(0);
			return cfm.getIid();
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
