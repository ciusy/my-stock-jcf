package leo.cs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cs.dao.iface.CsmarriageHistoryDao;
import leo.entity.CsmarriageHistory;

public class CsmarriageHistoryDaoImpl extends HibernateDaoSupport implements CsmarriageHistoryDao {

	public List<CsmarriageHistory> getCsmarriageHistoryByCsID(Long csID) {
		Query query = this.getSession().createQuery("from CsmarriageHistory where csId=? ");
		query.setParameter(0, csID);
		List<CsmarriageHistory> list=query.list();
		return list;
	}
	
	public CsmarriageHistory getCsmarriageHistoryByID(long id){
		try{
			
			CsmarriageHistory csmarriageHistory= (CsmarriageHistory)this.getHibernateTemplate().get(CsmarriageHistory.class, id);
			if(csmarriageHistory!=null){
				return csmarriageHistory;
				
			}return null;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	
   public boolean addCsmarriageHistory(CsmarriageHistory csmarriageHistory){
	    this.getHibernateTemplate().save(csmarriageHistory);
	    return true;
   }
public boolean updateCsmarriageHistory(CsmarriageHistory csmarriageHistory) {
	this.getHibernateTemplate().update(csmarriageHistory);
	return true;
}
public boolean deleteCsmarriageHistory(CsmarriageHistory csmarriageHistory) {
	this.getHibernateTemplate().delete(csmarriageHistory);
	return true;
}
}
