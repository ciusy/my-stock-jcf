package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfmdosageType;

public interface YfmdosageTypeService {
	  public List<YfmdosageType> getYfmdosageType();
	  public Boolean addYfmdosageType(YfmdosageType yfmdosagetype);
	  public Boolean delYfmdosageType(String yfmdosagetype);

}
