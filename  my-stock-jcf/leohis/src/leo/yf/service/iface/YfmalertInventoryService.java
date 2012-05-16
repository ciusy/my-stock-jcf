package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfmalertInventory;

public interface YfmalertInventoryService {
	public List<YfmalertInventory> getYfmalertInventory(Integer MInfoID,Integer MUID,Integer ID);
	public boolean addYfmalertInventory(YfmalertInventory yfmalertInventory);
	public boolean updateYfmalertInventory(YfmalertInventory yfmalertInventory);
	public boolean delYfmalertInventory(Integer ID, Integer MInfoId, Integer MUID);
}
