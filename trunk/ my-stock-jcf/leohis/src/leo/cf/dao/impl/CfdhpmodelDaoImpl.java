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
 * ��ϡ����á�����ģ��DAOʵ��
 * 
 * @author Administrator
 * 
 */
public class CfdhpmodelDaoImpl extends HibernateDaoSupport implements
		CfdhpmodelDao {
	/**
	 * ���ģ��
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
	 * ��ѯ�������ģ���ID
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
	 * �޸ĸ��ڵ�ID
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
	 * ����ģ��ID��ѯģ��
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
	 * ��ѯ���ڵ�ID��ģ��IDһ���ĸ��ڵ�
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
	 * ���ز�ѯ���ڵ�ID��ģ��IDһ���ĸ��ڵ�
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
	 * ����ģ������ ���ݸ��ڵ�ID��ѯ����ģ��
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
	 * ˽��ģ������ ���ظ��ݸ��ڵ�ID��ѯ����ģ��
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
	 * ɾ��ģ��
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
	 * ��ģ��Id��Ϊ���ڵ�Id��ѯģ���¼��
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
	 * ��ѯģ������
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
	 * ɾ��ģ������
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
	 * ��ѯģ���Ƿ����
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
	 * ��ѯģ�������Ƿ����
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
