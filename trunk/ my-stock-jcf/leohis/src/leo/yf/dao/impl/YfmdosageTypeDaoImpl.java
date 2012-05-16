package leo.yf.dao.impl;

import org.hibernate.Query;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.common.dao.DaoSupport;
import leo.entity.YfmdosageType;
import leo.yf.dao.iface.YfmdosageTypeDao;

public class YfmdosageTypeDaoImpl extends DaoSupport<YfmdosageType> implements YfmdosageTypeDao {

	public List<YfmdosageType> getYfmdosageType() {
		List<YfmdosageType> list = this.getHibernateTemplate().find("from YfmdosageType");
		return list;
	}

    public Boolean addYfmdosageType(YfmdosageType yfmdosagetype){
		this.getHibernateTemplate().save(yfmdosagetype);
		return true;
    }
    
	public Boolean delYfmdosageType(String yfmdosagetype){
		Query query = null;
		if (yfmdosagetype != null && !yfmdosagetype.equals("")){
			query = this.getSession().createSQLQuery("delete from YFMDosageType where DosageType = ?");
			query.setParameter(0, yfmdosagetype);
		}
		else
			query = this.getSession().createSQLQuery("delete from YFMDosageType");
		query.executeUpdate();
		return true;
	}
	
	
}
