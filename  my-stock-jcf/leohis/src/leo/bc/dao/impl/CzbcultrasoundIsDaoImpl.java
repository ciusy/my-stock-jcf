package leo.bc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.bc.dao.iface.CzbcultrasoundIsDao;
import leo.entity.CzbcultrasoundIs;

public class CzbcultrasoundIsDaoImpl extends HibernateDaoSupport implements
		CzbcultrasoundIsDao {

	public Boolean addCzbcultrasoundIs(CzbcultrasoundIs czbcultrasoundIs) {
		try {
			super.getHibernateTemplate().save(czbcultrasoundIs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	
	public String getMaxID(){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery(
				"select a.reid from CzbcultrasoundIs a order by a.reid desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "empty";
		else
		    return String.valueOf(list.get(0));
		
	}
	
	public List<CzbcultrasoundIs>getRecordByItemID(String ItemID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery(
				" from CzbcultrasoundIs  where itemId=:ItemID and reid in (select max(reid) from CzbcultrasoundIs  group by itemid)");
		query.setParameter("ItemID", ItemID);
		 List<CzbcultrasoundIs> list =  query.list();
		return list;
	}
	
	public CzbcultrasoundIs getCzbcultrasoundIs(String itemId) {
		try {
			Query query = this.getSession().createQuery(
					"from CzbcultrasoundIs where itemId= ?");
			query.setString(0, itemId);
			// query.setParameter("itemId", itemId);
			if (query.list().size() > 0) {
				return (CzbcultrasoundIs) query.list().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
