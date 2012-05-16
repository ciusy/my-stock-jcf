package leo.cs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.HibernateException;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cs.dao.iface.CsefileInfoDao;
import leo.entity.CsefileInfo;

public class CsefileInfoDaoImpl extends HibernateDaoSupport implements
		CsefileInfoDao {
	/**
	 * ���ݷ������id��ѯ������󸽼���Ϣ
	 */
	public CsefileInfo getCsefileInfoByCsID(long csID) {
		Query query = this.getSession().createQuery(
				"from CsefileInfo   where csId=? ");
		query.setParameter(0, csID);
		List<CsefileInfo> list = query.list();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}
	/**
	 * ��ӷ�����󸽼���Ϣ
	 */
	public boolean addCsefileInfo(CsefileInfo csefileInfo) {
		this.getHibernateTemplate().save(csefileInfo);
		return true;
	}
	/**
	 * �޸ķ�����󸽼���Ϣ
	 */
	public boolean updateCsefileInfo(CsefileInfo csefileInfo) {
		this.getHibernateTemplate().update(csefileInfo);
		return true;
	}
	/**
	 * ɾ��������󸽼���Ϣ
	 */
	public boolean deleteCsefileInfo(CsefileInfo csefileInfo) {
		this.getHibernateTemplate().delete(csefileInfo);
		return true;
	}

}
