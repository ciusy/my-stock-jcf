package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfmwayTo;

public interface YfmwayToService {
	public List<YfmwayTo> getYfmwayTo();
    public Boolean addYfmwayTo(YfmwayTo yfmwayto);
	public Boolean delYfmwayTo(String yfmwayto);
}
