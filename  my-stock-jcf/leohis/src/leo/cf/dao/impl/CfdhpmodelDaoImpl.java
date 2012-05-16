package leo.cf.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cf.dao.iface.CfdhpmodelDao;
import leo.entity.Cfdhpmodel;

/**
 * 诊断、处置、处方模板DAO实现
 * 
 * @author Administrator
 * 
 */
public class CfdhpmodelDaoImpl extends HibernateDaoSupport implements
		CfdhpmodelDao {
	/**
	 * 添加模板
	 */
	public boolean addCfdhpmodel(Cfdhpmodel cfp) {
		// TODO Auto-generated method stub
		try {
			super.getHibernateTemplate().save(cfp);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询最新添加模板的ID
	 */
	public long getNewAddModelId() {
		// TODO Auto-generated method stub
		try {
			String hql = "select modelId from Cfdhpmodel order by modelId desc";
			Session session = super.getSession();
			Query query = session.createQuery(hql);
			query.setMaxResults(1);
			return Long.parseLong(query.list().get(0).toString());
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
		return 0;
	}

	/**
	 * 修改父节点ID
	 */
	public boolean updateFactherID(Cfdhpmodel cfp) {
		// TODO Auto-generated method stub
		try {
			super.getHibernateTemplate().update(cfp);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据模板ID查询模板
	 */
	public Cfdhpmodel getCfdhpmodelByModelId(Long modelId) {
		// TODO Auto-generated method stub
		try {
			Cfdhpmodel cfp = (Cfdhpmodel) super.getHibernateTemplate().get(
					Cfdhpmodel.class, modelId);
			return cfp;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询父节点ID和模板ID一样的父节点
	 */
	public List<Long> getFactherModelIdEqFactherID() {
		// TODO Auto-generated method stub
		String hql = "select fatherId from Cfdhpmodel where modelId=fatherId";
		Session session = super.getSession();
		Query query = session.createQuery(hql);
		if (query.list().size() > 0) {
			return query.list();
		} else {
			return null;
		}
	}

	/**
	 * 重载查询父节点ID和模板ID一样的父节点
	 */
	public List<Cfdhpmodel> getFactherModelIdEqFactherID(Integer factherId) {
		try {
			String hql = "from Cfdhpmodel where modelId=?";
			Session session = super.getSession();
			Query query = session.createQuery(hql);
			query.setInteger(0, factherId);
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
	 * 公有模板设置 根据父节点ID查询所有模板
	 */
	public List<Cfdhpmodel> getCfdhpmodelByFactherId(Long factherId) {
		// TODO Auto-generated method stub
		try {
			String hql = "from Cfdhpmodel where fatherId=? and modelId!=fatherId";
			Session session = super.getSession();
			Query query = session.createQuery(hql);
			query.setLong(0, factherId);
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
	 * 私有模板设置 重载根据父节点ID查询所有模板
	 */
	public List<Cfdhpmodel> getCfdhpmodelByFactherId(Long factherId, Long ower) {
		// TODO Auto-generated method stub
		try {
			if (ower != null && ower != -1) {
				String hql = "from Cfdhpmodel where fatherId=? and ower=?";
				Session session = super.getSession();
				Query query = session.createQuery(hql);
				query.setLong(0, factherId);
				query.setLong(1, ower);
				return query.list();
			}
			return null;
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
	 * 删除模板
	 */
	public boolean delCfdhpmodelByModelId(Long modelId) {
		// TODO Auto-generated method stub
		try {
			Cfdhpmodel cfd = (Cfdhpmodel) super.getHibernateTemplate().get(
					Cfdhpmodel.class, modelId);
			super.getHibernateTemplate().delete(cfd);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 以模板Id作为父节点Id查询模板记录数
	 */
	public int getCountByModelId(Long modelId) {
		// TODO Auto-generated method stub
		try {
			String hql = "from Cfdhpmodel where fatherId=?";
			Session session = super.getSession();
			Query query = session.createQuery(hql);
			query.setLong(0, modelId);
			List<Cfdhpmodel> list = query.list();
			return list.size();
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
		return 0;
	}

	/**
	 * 查询模板类型
	 */
	public List<Cfdhpmodel> getCfdhpmodelType(String ower) {
		// TODO Auto-generated method stub
		String hql = "from Cfdhpmodel where modelId=fatherId and ower=?";

		Session session = super.getSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, Integer.parseInt(ower));
		if (query.list().size() > 0) {
			return query.list();
		}
		return null;
	}
	/**
	 * 删除模板类型
	 */
	public boolean delCfdhpmodelType(Long factherId) {
		// hql
		String hql = "delete from Cfdhpmodel where fatherId=?";
		Query query = super.getSession().createQuery(hql);
		query.setLong(0, factherId);
		if (query.executeUpdate() > 0)
			return true;
		else
			return false;
	}
	/**
	 * 查询模板是否存在
	 */
	public boolean getCfdhpmodelByName(String modelName) {
		// TODO Auto-generated method stub		
		Query query = super.getSession().createQuery("from Cfdhpmodel where modelName=? and modelID!=fatherID");
		query.setString(0, modelName);		
		if(query.list().size() > 0){
			return true;
		}
		return false;
	}
	/**
	 * 查询模板类型是否存在
	 */
	public boolean getCfdhpmodelTypeByName(String modelName, String ower) {
		// TODO Auto-generated method stub
		Query query = super.getSession().createQuery("from Cfdhpmodel where modelName=? and ower=? and modelID=fatherID");
		query.setString(0, modelName);
		query.setLong(1, Long.parseLong(ower));
		if(query.list().size() > 0){
			return true;
		}
		return false;
	}
	

}
