package leo.cf.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import leo.cf.dao.iface.CfprovinceDao;
import leo.common.dao.DaoSupport;
import leo.entity.Cfprovince;

public class CfprovinceDaoImpl extends DaoSupport<Cfprovince> implements CfprovinceDao {

	public List<Cfprovince> getCfprovince(Integer ProvID) {
		List<Cfprovince> list;
		if (ProvID != -2){
			list = this.getHibernateTemplate().find("from Cfprovince where provId = ?", ProvID);
		}
		else{
			list = this.getHibernateTemplate().find("from Cfprovince");
		}
		return list;
	}
	/**
	 * 查询所有省
	 */
	public List<Cfprovince> getCfprovinceAll() {
		Session session = super.getSession();
		Query query = session.createQuery("from Cfprovince");
		List<Cfprovince> list = null;
		try {
			list = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			throw e;
		}		
		return list;
	}
	/**
	 * 根据省id查询省名
	 */
	public String getProvinceName(Integer provID) {
		// TODO Auto-generated method stub
		try {
			Cfprovince prov = (Cfprovince)super.getHibernateTemplate().get(Cfprovince.class, provID);
			return prov.getProvName();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}


}
