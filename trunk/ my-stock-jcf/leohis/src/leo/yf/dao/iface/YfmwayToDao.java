package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfmwayTo;

public interface YfmwayToDao extends Dao<YfmwayTo>{
  public List<YfmwayTo> getYfmwayTo();
  public Boolean addYfmwayTo(YfmwayTo yfmwayto);
  public Boolean delYfmwayTo(String yfmwayto);
}
