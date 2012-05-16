package leo.bc.dao.impl;

import leo.bc.dao.iface.CzacontentDao;
import leo.entity.Czacontent;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CzacontentDaoImpl extends HibernateDaoSupport implements CzacontentDao {
	public Czacontent  getCzacontentByItemId(String itemid){
		try{
			return (Czacontent)getHibernateTemplate().get(Czacontent.class , itemid);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
