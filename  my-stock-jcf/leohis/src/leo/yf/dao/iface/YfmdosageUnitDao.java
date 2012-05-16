package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfmdosageType;
import leo.entity.YfmdosageUnit;

public interface YfmdosageUnitDao extends Dao<YfmdosageUnit>{
	  public List<YfmdosageUnit> getYfmdosageUnit();
	  public Boolean addYfmdosageUnit(YfmdosageUnit yfmdosageUnit);
	  public Boolean delYfmdosageUnit(String yfmdosageUnit);
}
