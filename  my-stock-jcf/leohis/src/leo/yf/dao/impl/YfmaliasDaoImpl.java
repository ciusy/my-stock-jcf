package leo.yf.dao.impl;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.Yfmalias;
import leo.yf.dao.iface.YfmaliasDao;

public class YfmaliasDaoImpl extends DaoSupport<Yfmalias> implements YfmaliasDao {

	public List<Yfmalias> getYfmalias(int MInfoID, String AliasName,
			String SpellCode, int id) {
		
		List<Yfmalias> list;
		list = null;
		if ((MInfoID == -2) && (AliasName == null || AliasName.equals("")) && (SpellCode == null || SpellCode.equals("")) && (id == -2))
        	list = this.getHibernateTemplate().find("from Yfmalias");
        else
        	if (MInfoID != -2){
            	list = this.getHibernateTemplate().find("from Yfmalias where MInfoID = ?",MInfoID);
        	}
        	else
        		if (AliasName != null && !AliasName.equals("")){
        			list = this.getHibernateTemplate().find("from Yfmalias where AliasName like ?","%" + AliasName + "%");
        		}
        		else
        			if (SpellCode != null && !SpellCode.equals("")){
            			list = this.getHibernateTemplate().find("from Yfmalias where SpellCode like ?","%" + SpellCode + "%");
        			}
        			else
            			list = this.getHibernateTemplate().find("from Yfmalias where id = ?",id);
		return list;
	}

	public boolean addYfmalias(Yfmalias yfmalias){
		try{
			this.getHibernateTemplate().save(yfmalias);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	};
	
	public boolean updateYfmalias(Yfmalias yfmalias){
	    try {
    		this.update(yfmalias);
    		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	};
	
	public boolean delYfmalias(Long id, int MInfoID){
		Query query = null;
        try {
        	if ((id == -2) && (MInfoID == -2)){
        		query = this.getSession().createSQLQuery("delete from YFMAlias");
        		query.executeUpdate();
        	}
        	else
        		if (id != -2)
        			this.delete(id);
        		else{
            		query = this.getSession().createSQLQuery("delete from YFMAlias where MInfoID = ?");
        			query.setParameter(0, MInfoID);
        			query.executeUpdate();
        		}
    		
    		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	};
	
	
}
