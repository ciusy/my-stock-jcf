package leo.yf.service.impl;

import java.util.List;

import leo.entity.Yfmstock;
import leo.yf.dao.iface.YfmstockDao;
import leo.yf.service.iface.YfmstockService;

public class YfmstockServiceImpl implements YfmstockService {

	private YfmstockDao yfmstockDao;
	
	public List<Yfmstock> getYfmstock(Integer MID, Integer MInfoID,
			Integer PharmacyID) {
		return yfmstockDao.getYfmstock(MID, MInfoID, PharmacyID);
	}

	public void setYfmstockDao(YfmstockDao yfmstockDao) {
		this.yfmstockDao = yfmstockDao;
	}
	
	public boolean addYfmstock(Yfmstock yfmstock){
		return yfmstockDao.addYfmstock(yfmstock);
	}
	
	public Integer getMInfo(Integer MInfoID, Integer PharmacyID){
		return yfmstockDao.getMInfo(MInfoID, PharmacyID);
	}
	
	public boolean updateStock(Integer MInfoID, Integer Stock, Integer PharmacyID){
		return yfmstockDao.updateStock(MInfoID, Stock, PharmacyID);
	}

}
