package leo.ydj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.ydj.dao.iface.CzcolposcopeIsDao;
import leo.entity.CzcolposcopeIs;

public class CzcolposcopeIsDaoImpl extends HibernateDaoSupport implements
		CzcolposcopeIsDao {

	public Boolean addCzcolposcopeIs(CzcolposcopeIs czcolposcopeIs) {
		try {
			super.getHibernateTemplate().save(czcolposcopeIs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}	
	
	public String getMaxID(){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery(
				"select a.reid from CzcolposcopeIs a order by a.reid desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "empty";
		else
		    return String.valueOf(list.get(0));
		
	}
	
	public List<CzcolposcopeIs>getRecordByItemID(String ItemID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery(
				" from CzcolposcopeIs  where itemId=:ItemID and reid in (select max(reid) from CzcolposcopeIs  group by itemid)");
		query.setParameter("ItemID", ItemID);
		 List<CzcolposcopeIs> list =  query.list();
		return list;
	}
	
	public CzcolposcopeIs getCzcolposcopeIs(String itemId) {
		try {
			Query query = this.getSession().createQuery(
					"from CzcolposcopeIs where itemId= ?");
			query.setString(0, itemId);
			// query.setParameter("itemId", itemId);
			if (query.list().size() > 0) {
				return (CzcolposcopeIs) query.list().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
