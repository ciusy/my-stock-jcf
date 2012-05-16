package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Yfminfo;
import leo.entity.Yfmsupplier;

public interface YfmsupplierDao extends Dao<Yfmsupplier>{
	  public List<Yfmsupplier> getYfmsupplier(Integer SupplierID, String SupplierName);
	  public Boolean addYfmsupplier(Yfmsupplier yfmsupplier);
	  public Boolean delYfmsupplier(Integer Supplierid);
	  public Boolean updateYfmsupplier(Yfmsupplier yfmsupplier);
}
