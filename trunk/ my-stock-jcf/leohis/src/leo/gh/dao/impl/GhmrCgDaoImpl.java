package leo.gh.dao.impl;

import leo.entity.GhmrCg;
import leo.gh.dao.iface.GhmrCgDao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GhmrCgDaoImpl extends HibernateDaoSupport implements GhmrCgDao {

	public boolean addGhmrCg(GhmrCg ghmrCg) {
		try{
			this.getHibernateTemplate().save(ghmrCg);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean delGhmrCg(GhmrCg ghmrCg) {
		try{
			this.getHibernateTemplate().delete(ghmrCg);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateGhmrCg(GhmrCg ghmrCg) {
		try{
			this.getHibernateTemplate().update(ghmrCg);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
