package leo.cf.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import leo.cf.dao.iface.CfacontentFrameworkDao;
import leo.entity.CfacontentFramework;

import org.hibernate.Query;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CfacontentFrameworkDaoImpl extends HibernateDaoSupport implements
		CfacontentFrameworkDao {

	/**
	 * 
	 * 根据ID查询出一条数据
	 * 
	 * @param id主见
	 * 
	 * @return CfacontentFramework对象
	 */
	public CfacontentFramework getCfacontentFrameworkByID(Integer id) {
		try {
			String hql = "from CfacontentFramework where formworkId=?";
			Query query = this.getSession().createQuery(hql)
					.setParameter(0, id);
			if (query.list().size() > 0) {
				CfacontentFramework c = (CfacontentFramework) query.list().get(
						0);
				return c;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 删除一条数据
	 * 
	 * @param id主见
	 * 
	 * @return 成功（true）失败(false)
	 */
	public Boolean deleteCfacontentFramework(Integer id) {
		try {
			String hql = "from CfacontentFramework where formworkId=?";
			Query query = this.getSession().createQuery(hql)
					.setParameter(0, id);
			if (query.list().size() > 0) {
				CfacontentFramework c = (CfacontentFramework) query.list().get(
						0);
				super.getHibernateTemplate().delete(c);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * 修改一条数据
	 * 
	 * @param CfacontentFramework
	 * 
	 * @return 成功（true）失败(false)
	 */
	public Boolean updateCfacontentFrameworkById(CfacontentFramework c) {
		if (c != null) {
			super.getHibernateTemplate().update(c);
			return true;
		}
		return false;
	}

	public Boolean addCfacontentFramework(CfacontentFramework c) {
		if (c != null) {
			super.getHibernateTemplate().save(c);
			return true;
		}
		return false;
	}
	/**
	 * 根据所属单位和项目类型Id查询内容模板
	 */
	public List<CfacontentFramework> getCfacontentFrameworkByAffiliation(
			Integer affiliation) {
		try {
			Session session = super.getSession();
			Query query = session.createQuery("from CfacontentFramework where affiliation=?");
			query.setInteger(0, affiliation);
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
	 * 重载根据所属单位和项目类型Id查询内容模板
	 */
	public List<CfacontentFramework> getCfacontentFrameworkByAffiliation(
			Integer affiliation, Integer itemTypeID) {
		// TODO Auto-generated method stub
		try {
			Session session = super.getSession();
			Query query = session.createQuery("from CfacontentFramework where affiliation=? and itemTypeId=?");
			query.setParameter(0, affiliation);
			query.setParameter(1, itemTypeID);
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

	

}
