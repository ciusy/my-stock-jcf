package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfmalertInventory;

public interface YfmalertInventoryDao extends Dao<YfmalertInventory> {
	public List<YfmalertInventory> getYfmalertInventory(Integer MInfoID,Integer MUID,Integer ID);
	public boolean addYfmalertInventory(YfmalertInventory yfmalertInventory);
	public boolean updateYfmalertInventory(YfmalertInventory yfmalertInventory);
	public boolean delYfmalertInventory(Integer ID, Integer MInfoId, Integer MUID);
}
