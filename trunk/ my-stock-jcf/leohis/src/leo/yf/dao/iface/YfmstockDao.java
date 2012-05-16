package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Yfmstock;

public interface YfmstockDao extends Dao<Yfmstock>{
	public List<Yfmstock> getYfmstock(Integer MID,Integer MInfoID, Integer PharmacyID);
	public boolean addYfmstock(Yfmstock yfmstock);
	public Integer getMInfo(Integer MInfoID, Integer PharmacyID); //判断某一药品信息ID是否存在,返回库存量(-1，不存在)
	/**
	 * 根据药品信息ID和药房ID修改库存
	 * @param MInfoID
	 * @param Stock
	 * @param PharmacyID
	 * @return
	 */
	public boolean updateStock(Integer MInfoID, Integer Stock, Integer PharmacyID); //根据药品信息ID修改对应库库存
	
	
}
