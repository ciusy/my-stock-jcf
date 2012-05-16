package leo.mz.dao.impl;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.entity.Czacontent;
import leo.mz.dao.iface.MzCZAContentDao;
/**
 * ������������Daoʵ��
 * @author abc
 *
 */
public class MzCZAContentDaoImpl extends HibernateDaoSupport implements MzCZAContentDao {
	/**
	 * ���������������
	 */
	public boolean addCZAContent(Czacontent cza) {
		// TODO Auto-generated method stub
		try {
			super.getHibernateTemplate().save(cza);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ɾ��������������
	 */
	public boolean delCZAContent(Czacontent cza) {
		// TODO Auto-generated method stub
		try {
			super.getHibernateTemplate().delete(cza);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ����������ѯ��������
	 */
	public Czacontent getCZAContentByItemId(String itemId) {
		// TODO Auto-generated method stub
		try {
			return (Czacontent)super.getHibernateTemplate().get(Czacontent.class, itemId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean delCZAContentByItemID(String ItemID){
		Query query = null;
		query = this.getSession().createSQLQuery(
				"delete from CZAContent where ItemID = ?");
		query.setParameter(0, ItemID);
		query.executeUpdate();
		return true;
	}

}
