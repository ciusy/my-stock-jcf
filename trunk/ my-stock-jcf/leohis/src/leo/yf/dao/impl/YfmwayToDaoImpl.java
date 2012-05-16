package leo.yf.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.YfmwayTo;
import leo.yf.dao.iface.YfmwayToDao;
import org.hibernate.Query;


public class YfmwayToDaoImpl extends DaoSupport<YfmwayTo> implements YfmwayToDao {

	public List<YfmwayTo> getYfmwayTo() {
		List<YfmwayTo> list = this.getHibernateTemplate().find("from YfmwayTo");
		return list;
	}

    public Boolean addYfmwayTo(YfmwayTo yfmwayto){
		this.getHibernateTemplate().save(yfmwayto);
		return true;
    }
    
	public Boolean delYfmwayTo(String yfmwayto){
		Query query = null;
		if (yfmwayto != null && !yfmwayto.equals("")){
			query = this.getSession().createSQLQuery("delete from YFMWayTo where WayTo = ?");
			query.setParameter(0, yfmwayto);
		}
		else
			query = this.getSession().createSQLQuery("delete from YFMWayTo");
		query.executeUpdate();		
		return true;
	}
	
}
