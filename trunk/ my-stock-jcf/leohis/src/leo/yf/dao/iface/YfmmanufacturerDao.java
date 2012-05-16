package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Yfmmanufacturer;

public interface YfmmanufacturerDao extends Dao<Yfmmanufacturer> {
  public List<Yfmmanufacturer> getYfmmanufacturer(String name);
  public Boolean addYfmmanufacturer(Yfmmanufacturer yfmmanufacturer);
  public Boolean delYfmmanufacturer(String manufacturer);
}
