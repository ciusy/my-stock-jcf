package leo.yf.service.impl;

import java.util.List;


import leo.entity.Yfmsupplier;
import leo.yf.dao.iface.YfmsupplierDao;
import leo.yf.service.iface.YfmsupplierService;

public class YfmsupplierServiceImpl implements YfmsupplierService {
    private YfmsupplierDao yfmsupplierDao;
    
	public List<Yfmsupplier> getYfmsupplier(Integer SupplierID,
			String SupplierName) {
		return yfmsupplierDao.getYfmsupplier(SupplierID, SupplierName);
	}

	public void setYfmsupplierDao(YfmsupplierDao yfmsupplierDao) {
		this.yfmsupplierDao = yfmsupplierDao;
	}

    public Boolean addYfmsupplier(Yfmsupplier yfmsupplier){
    	return yfmsupplierDao.addYfmsupplier(yfmsupplier);
    }
    
	public Boolean delYfmsupplier(Integer Supplierid){
		return yfmsupplierDao.delYfmsupplier(Supplierid);
	}

    public Boolean updateYfmsupplier(Yfmsupplier yfmsupplier){
    	return yfmsupplierDao.updateYfmsupplier(yfmsupplier);
    }
	
}
