package leo.yf.dao.impl;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.YfmalertInventory;
import leo.yf.dao.iface.YfmalertInventoryDao;

public class YfmalertInventoryDaoImpl extends DaoSupport<YfmalertInventory>
		implements YfmalertInventoryDao {

	public List<YfmalertInventory> getYfmalertInventory(Integer MInfoID,
			Integer MUID, Integer ID) {
		List<YfmalertInventory> list;
		list = null;
		
		if ((MInfoID == -2) && (MUID == -2) && (ID == -2))
			list = this.getHibernateTemplate().find("from YfmalertInventory");
		else
			if (MInfoID != -2)
				list = this.getHibernateTemplate().find("from YfmalertInventory where MInfoID = ?",MInfoID);
			else
				if (MUID != -2)
					list = this.getHibernateTemplate().find("from YfmalertInventory where MUID = ?",MUID);
				else
					if ((MInfoID != -2) && (MUID != -2))
						list = this.getHibernateTemplate().find("from YfmalertInventory where MInfoID = ? and MUID = ?",new Object[]{MInfoID,MUID});
					else	
						list = this.getHibernateTemplate().find("from YfmalertInventory where ID = ?",ID);
		return list;
	}
	
	public boolean addYfmalertInventory(YfmalertInventory yfmalertInventory){
		try{
			this.getHibernateTemplate().save(yfmalertInventory);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateYfmalertInventory(YfmalertInventory yfmalertInventory){
	    try {
    		this.update(yfmalertInventory);
    		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	};
	
	public boolean delYfmalertInventory(Integer ID, Integer MInfoId, Integer MUID){
		Query query = null;
        try {
        	if ((ID == -2) && (MInfoId == -2) && (MUID == -2)){
        		query = this.getSession().createSQLQuery("delete from YfmalertInventory");
        		query.executeUpdate();
        	}
        	else
        		if (ID != -2)
        			this.delete(ID);
        		else
        			if ((MInfoId != -2) &&(MUID != -2))
        			{
        				query = this.getSession().createSQLQuery("delete from YfmalertInventory where MInfoID = ? and MUID = ?");
        				query.setParameter(0, MInfoId);
        				query.setParameter(1, MUID);
        				query.executeUpdate();
        			}
        			else
        			{
        				query = this.getSession().createSQLQuery("delete from YfmalertInventory where MInfoID = ?");
        				query.setParameter(0, MInfoId);
        				query.executeUpdate();
        			}
    		
    		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
