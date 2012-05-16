package leo.bc.dao.impl;

import leo.bc.dao.iface.CzshbioIstermDao;
import leo.common.dao.DaoSupport;
import leo.entity.CzshbioIsterm;

public class CzshbioIstermDaoImpl extends DaoSupport<CzshbioIsterm> implements CzshbioIstermDao {

	public boolean addCzshbioIsterm(CzshbioIsterm czshbioIsterm) {
		try{
			this.getHibernateTemplate().save(czshbioIsterm);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCzshbioIsterm(CzshbioIsterm czshbioIsterm) {
		try{
			this.getHibernateTemplate().update(czshbioIsterm);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
