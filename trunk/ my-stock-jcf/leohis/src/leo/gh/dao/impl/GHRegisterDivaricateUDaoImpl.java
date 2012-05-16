package leo.gh.dao.impl;

import java.util.List;
import java.util.ArrayList;

import leo.entity.GhregisterDivaricateU;
import leo.gh.dao.iface.GHRegisterDivaricateUDao;
import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class GHRegisterDivaricateUDaoImpl extends HibernateDaoSupport implements GHRegisterDivaricateUDao {

	public List<GhregisterDivaricateU> getAllGhregisterDivaricateUByRTID(int rtid)
	{
		try{
			Query query = this.getSession().createQuery("from GhregisterDivaricateU gct where gct.rtid=:rtid");
			query.setInteger("rtid", rtid);
			List<GhregisterDivaricateU> list = query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean addGhregisterDivaricateU(GhregisterDivaricateU ghregisterDivaricateU) {
		try{
			this.getHibernateTemplate().save(ghregisterDivaricateU);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteGhregisterDivaricateU(
			GhregisterDivaricateU ghregisterDivaricateU) {
		try{
			this.getHibernateTemplate().delete(ghregisterDivaricateU);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateGhregisterDivaricateU(
			GhregisterDivaricateU ghregisterDivaricateU) {
		try{
			this.getHibernateTemplate().update(ghregisterDivaricateU);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

	


}
