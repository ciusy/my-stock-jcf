package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfmalertInventory;
import leo.yf.dao.iface.YfmalertInventoryDao;
import leo.yf.service.iface.YfmalertInventoryService;

public class YfmalertInventoryServiceImpl implements YfmalertInventoryService {
    private YfmalertInventoryDao yfmalertInventoryDao;

	public List<YfmalertInventory> getYfmalertInventory(Integer MInfoID,
			Integer MUID, Integer ID) {
		return yfmalertInventoryDao.getYfmalertInventory(MInfoID, MUID, ID);
	}

	public void setYfmalertInventoryDao(YfmalertInventoryDao yfmalertInventoryDao) {
		this.yfmalertInventoryDao = yfmalertInventoryDao;
	}

	public boolean addYfmalertInventory(YfmalertInventory yfmalertInventory){
		return yfmalertInventoryDao.addYfmalertInventory(yfmalertInventory);
	}

	public boolean updateYfmalertInventory(YfmalertInventory yfmalertInventory){
		return yfmalertInventoryDao.updateYfmalertInventory(yfmalertInventory);
		
	}

	public boolean delYfmalertInventory(Integer ID, Integer MInfoId, Integer MUID){
		return yfmalertInventoryDao.delYfmalertInventory(ID, MInfoId, MUID);
	}
}
