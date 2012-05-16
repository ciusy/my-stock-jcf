package leo.yf.service.iface;

import java.util.List;

import leo.entity.Yfmstock;

public interface YfmstockService {
	public List<Yfmstock> getYfmstock(Integer MID, Integer MInfoID,Integer PharmacyID);
	public boolean addYfmstock(Yfmstock yfmstock);
	public Integer getMInfo(Integer MInfoID, Integer PharmacyID);
	public boolean updateStock(Integer MInfoID, Integer Stock, Integer PharmacyID);
}
