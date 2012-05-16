package leo.yf.dao.impl;

import java.util.List;
import leo.common.dao.DaoSupport;
import leo.entity.YfmdosageUnit;
import leo.yf.dao.iface.YfmdosageUnitDao;
import org.hibernate.Query;

public class YfmdosageUnitDaoImpl extends DaoSupport<YfmdosageUnit> implements YfmdosageUnitDao {

	public List<YfmdosageUnit> getYfmdosageUnit() {
		List<YfmdosageUnit> list = this.getHibernateTemplate().find("from YfmdosageUnit");
		return list;
	}

    public Boolean addYfmdosageUnit(YfmdosageUnit yfmdosageUnit){
		this.getHibernateTemplate().save(yfmdosageUnit);
		return true;
    }
    
	public Boolean delYfmdosageUnit(String yfmdosageUnit){
		Query query = null;
		if (yfmdosageUnit != null && !yfmdosageUnit.equals("")){
			query = this.getSession().createSQLQuery("delete from YFMDosageUnit where DosageUnit = ?");
			query.setParameter(0, yfmdosageUnit);
		}
		else
			query = this.getSession().createSQLQuery("delete from YFMDosageUnit");
		query.executeUpdate();		
 		return true;
	}
	
	
}
