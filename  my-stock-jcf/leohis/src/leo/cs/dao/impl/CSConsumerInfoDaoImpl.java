package leo.cs.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cs.dao.iface.CSConsumerInfoDao;
import leo.entity.CsconsumerInfo;

public class CSConsumerInfoDaoImpl extends HibernateDaoSupport implements
		CSConsumerInfoDao {
	/**
	 * ��ӷ�����󸽼���Ϣ
	 */
	public boolean addCsconsumerInfo(CsconsumerInfo csconsumerinfo) {
		try {
			super.getHibernateTemplate().save(csconsumerinfo);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw e;
		}		
	}

	/**
	 * ɾ��������󸽼���Ϣ
	 */
	public boolean delCsconsumerInfo(Long csId) {
		// TODO Auto-generated method stub
		Session session = super.getSession();
		Query query = session
				.createSQLQuery("delete from CsconsumerInfo where csId=?");
		query.setLong(0, csId);
		int count = query.executeUpdate();
		// �ر�session
		session.close();
		if (count >= 1)
			return true;
		return false;
	}

	/**
	 * ���ݷ������id��ѯ������󸽼���Ϣ
	 */
	public CsconsumerInfo getCsconsumerInfoBycsId(Long csId) {
		// TODO Auto-generated method stub
		try {
			return (CsconsumerInfo) super.getHibernateTemplate().get(
					CsconsumerInfo.class, csId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �޸ķ�����󸽼���Ϣ
	 */
	public boolean updateCsconsumerInfo(CsconsumerInfo csconsumerinfo) {
		// TODO Auto-generated method stub
		try {
			super.getHibernateTemplate().update(csconsumerinfo);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

}
