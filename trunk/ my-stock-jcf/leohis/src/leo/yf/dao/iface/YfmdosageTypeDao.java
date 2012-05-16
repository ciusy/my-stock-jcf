package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Yfmalias;
import leo.entity.YfmdosageType;

public interface YfmdosageTypeDao extends Dao<YfmdosageType>{
  public List<YfmdosageType> getYfmdosageType();
  public Boolean addYfmdosageType(YfmdosageType yfmdosagetype);
  public Boolean delYfmdosageType(String yfmdosagetype);
  
}
