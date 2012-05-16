package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfmdosageUnit;
import leo.yf.service.iface.YfmdosageUnitService;
import leo.yf.dao.iface.YfmdosageUnitDao;


public class YfmdosageUnitServiceImpl implements YfmdosageUnitService {
    private YfmdosageUnitDao yfmdosageUnitDao;
    
	public List<YfmdosageUnit> getYfmdosageUnit() {
		return yfmdosageUnitDao.getYfmdosageUnit();
	}

	public void setYfmdosageUnitDao(YfmdosageUnitDao yfmdosageUnitDao) {
		this.yfmdosageUnitDao = yfmdosageUnitDao;
	}

    public Boolean addYfmdosageUnit(YfmdosageUnit yfmdosageUnit){
    	return yfmdosageUnitDao.addYfmdosageUnit(yfmdosageUnit);
    }
	public Boolean delYfmdosageUnit(String yfmdosageUnit){
		return yfmdosageUnitDao.delYfmdosageUnit(yfmdosageUnit);
	}
}
