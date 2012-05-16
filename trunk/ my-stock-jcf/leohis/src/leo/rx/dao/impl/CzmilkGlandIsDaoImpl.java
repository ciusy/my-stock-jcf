package leo.rx.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.rx.dao.iface.CzmilkGlandIsDao;
import leo.entity.CzmilkGlandIs;

public class CzmilkGlandIsDaoImpl extends HibernateDaoSupport implements
		CzmilkGlandIsDao {

	public Boolean addCzmilkGlandIs(CzmilkGlandIs czmilkGlandIs) {
		try {
			super.getHibernateTemplate().save(czmilkGlandIs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	
	public String getMaxID(){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery(
				"select a.reid from CzmilkGlandIs a order by a.reid desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "empty";
		else
		    return String.valueOf(list.get(0));
		
	}
	
	public List<CzmilkGlandIs>getRecordByItemID(String ItemID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery(
				" from CzmilkGlandIs  where itemId=:ItemID and reid in (select max(reid) from CzmilkGlandIs  group by itemid)");
		query.setParameter("ItemID", ItemID);
		 List<CzmilkGlandIs> list =  query.list();
		return list;
	}
	
	public CzmilkGlandIs getCzmilkGlandIs(String itemId) {
		try {
			Query query = this.getSession().createQuery(
					"from CzmilkGlandIs where itemId= ?");
			query.setString(0, itemId);
			// query.setParameter("itemId", itemId);
			if (query.list().size() > 0) {
				return (CzmilkGlandIs) query.list().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
