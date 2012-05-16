package leo.yf.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.Yfmsupplier;
import leo.yf.dao.iface.YfmsupplierDao;

public class YfmsupplierDaoImpl extends DaoSupport<Yfmsupplier> implements YfmsupplierDao {

	public List<Yfmsupplier> getYfmsupplier(Integer SupplierID, String SupplierName) {
		List<Yfmsupplier> list;
		list = null;
		if ((SupplierID == -2) && (SupplierName == null || SupplierName.equals("")))
        	list = this.getHibernateTemplate().find("from Yfmsupplier");
        else
        	if (SupplierID != -2){
            	list = this.getHibernateTemplate().find("from Yfmsupplier where SupplierID = ?",SupplierID);
        	}
        	else{
            	list = this.getHibernateTemplate().find("from Yfmsupplier where SupplierName like ?","%" + SupplierName + "%");
        	}
		return list;
	}

	  public Boolean addYfmsupplier(Yfmsupplier yfmsupplier){
			try{
				this.getHibernateTemplate().save(yfmsupplier);
				return true;
			}catch(Exception e){
				e.printStackTrace();
			}
			return false;
	  }
	  
	  public Boolean delYfmsupplier(Integer Supplierid){
	        try {
	    		this.delete(Supplierid);
	    		return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		  
	  }

	  public Boolean updateYfmsupplier(Yfmsupplier yfmsupplier){
		    try {
	    		this.update(yfmsupplier);
	    		return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
	  }
	  
	
}
