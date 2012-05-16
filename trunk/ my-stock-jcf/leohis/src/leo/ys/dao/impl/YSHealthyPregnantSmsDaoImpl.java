package leo.ys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.HealthyPregnantSms;
import leo.ys.dao.iface.YSHealthyPregnantSmsDao;

public class YSHealthyPregnantSmsDaoImpl extends DaoSupport<HealthyPregnantSms> implements YSHealthyPregnantSmsDao {

	public List<HealthyPregnantSms> getHealthyPregnantSms(String SendState, Integer UnitID) {
		List<Object> cs = new ArrayList<Object>();
    	List<HealthyPregnantSms> list = null;
		cs.add(SendState);
		cs.add(UnitID);
    	list = this.getHibernateTemplate().find(
					"from HealthyPregnantSms where sendState = ? and unitId = ?", cs.toArray());
		return list;
	}
	
	public boolean updateHealthyPregnantSms(Long SendID, String SendTime, String SendState){
		Query query = null;
		query = this.getSession().createSQLQuery(
				"update HealthyPregnantSms set SendTime = ?, SendState = ? where SendID = ?");
		query.setParameter(0, SendTime);
		query.setParameter(1, SendState);
		query.setParameter(2, SendID);
		query.executeUpdate();
		return true;
	}

	public boolean addHealthyPregnantSms(HealthyPregnantSms healthyPregnantSms){
		this.getHibernateTemplate().save(healthyPregnantSms);		
		return true;
	}
	
}
