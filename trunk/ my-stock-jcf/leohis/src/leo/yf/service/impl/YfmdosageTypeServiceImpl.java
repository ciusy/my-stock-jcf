package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfmdosageType;
import leo.yf.dao.iface.YfmdosageTypeDao;
import leo.yf.service.iface.YfmdosageTypeService;

public class YfmdosageTypeServiceImpl implements YfmdosageTypeService {
	private YfmdosageTypeDao yfmdosageTypeDao; 
	public void setYfmdosageTypeDao(YfmdosageTypeDao yfmdosageTypeDao) {
		this.yfmdosageTypeDao = yfmdosageTypeDao;
	}
	
	public List<YfmdosageType> getYfmdosageType() {
		return yfmdosageTypeDao.getYfmdosageType();
	}
    public Boolean addYfmdosageType(YfmdosageType yfmdosagetype){
        return yfmdosageTypeDao.addYfmdosageType(yfmdosagetype);	
    }
	public Boolean delYfmdosageType(String yfmdosagetype){
		return yfmdosageTypeDao.delYfmdosageType(yfmdosagetype);
		
	}

}
