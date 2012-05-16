package leo.yf.service.impl;

import java.util.List;

import leo.entity.Yfmmanufacturer;
import leo.yf.service.iface.YfmmanufacturerService;
import leo.yf.dao.iface.YfmmanufacturerDao;


public class YfmmanufacturerServiceImpl implements YfmmanufacturerService {
    private YfmmanufacturerDao yfmmanufacturerDao;
	public List<Yfmmanufacturer> getYfmmanufacturer(String name) {
		return yfmmanufacturerDao.getYfmmanufacturer(name);
	}
	public void setYfmmanufacturerDao(YfmmanufacturerDao yfmmanufacturerDao) {
		this.yfmmanufacturerDao = yfmmanufacturerDao;
	}
	
	public Boolean addYfmmanufacturer(Yfmmanufacturer yfmmanufacturer){
		return yfmmanufacturerDao.addYfmmanufacturer(yfmmanufacturer);
		
	}

    public Boolean delYfmmanufacturer(String manufacturer){
    	return yfmmanufacturerDao.delYfmmanufacturer(manufacturer);
    }
	

}
