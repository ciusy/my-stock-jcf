package leo.yf.dao.impl;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.Yfmstock;
import leo.yf.dao.iface.YfmstockDao;

public class YfmstockDaoImpl extends DaoSupport<Yfmstock> implements YfmstockDao {

	public List<Yfmstock> getYfmstock(Integer MID, Integer MInfoID,
			Integer PharmacyID) {
		
		List<Yfmstock> list;
		list = null;
		if ((MID == -2) && (MInfoID == -2) && (PharmacyID == -2))
        	list = this.getHibernateTemplate().find("from Yfmstock");
        else
        	if (MID != -2)
            	list = this.getHibernateTemplate().find("from Yfmstock where mid; = ?",MID);
        	else
        		if ((MInfoID != -2) && (PharmacyID != -2))
        			list = this.getHibernateTemplate().find("from Yfmstock where minfoId = ? and pharmacyId = ?",new Object[]{MInfoID,PharmacyID});
        		else
        			if ((PharmacyID != -2) && (MInfoID == -2))
            			list = this.getHibernateTemplate().find("from Yfmstock where pharmacyId = ?",PharmacyID);
		return list;
	}

	public boolean addYfmstock(Yfmstock yfmstock){
		try{
			this.getHibernateTemplate().save(yfmstock);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
	
	public Integer getMInfo(Integer MInfoID, Integer PharmacyID){
		List z;
		Query query = null; // 生明一个查询对象
		if (PharmacyID == -2){
			query = this.getSession().createSQLQuery("select Stock from Yfmstock where minfoId = ?");
			query.setParameter(0, MInfoID);
		}
		else{
			query = this.getSession().createSQLQuery("select Stock from Yfmstock where minfoId = ? and pharmacyId = ?");
			query.setParameter(0, MInfoID);
			query.setParameter(1, PharmacyID);
		}
			
		z = query.list();
		if (z.size() == 0){
			return -1;
		}
		else{
			return Integer.parseInt(z.get(0).toString());
		}
	}

	public boolean updateStock(Integer MInfoID, Integer Stock, Integer PharmacyID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("update Yfmstock set stock = stock + ? where minfoId = ? and pharmacyId = ?");
		query.setParameter(0, Stock);
		query.setParameter(1, MInfoID);
		query.setParameter(2, PharmacyID);
		query.executeUpdate();
		return true;
	}
}
