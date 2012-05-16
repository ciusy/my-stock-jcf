package leo.bc.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.bc.dao.iface.CznkendIsDao;
import leo.entity.CznkendIs;

public class CznkendIsDaoImpl extends HibernateDaoSupport implements CznkendIsDao {

	public boolean addCznkendIs(CznkendIs cznkendIs) {
		try{
			this.getHibernateTemplate().save(cznkendIs);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
