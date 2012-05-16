package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfmdosageUnit;

public interface YfmdosageUnitService {
	public List<YfmdosageUnit> getYfmdosageUnit();
    public Boolean addYfmdosageUnit(YfmdosageUnit yfmdosageUnit);
	public Boolean delYfmdosageUnit(String yfmdosageUnit);

}
