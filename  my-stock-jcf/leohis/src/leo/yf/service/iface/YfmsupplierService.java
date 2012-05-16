package leo.yf.service.iface;

import java.util.List;

import leo.entity.Yfmsupplier;

public interface YfmsupplierService {
	  public List<Yfmsupplier> getYfmsupplier(Integer SupplierID, String SupplierName);
	  public Boolean addYfmsupplier(Yfmsupplier yfmsupplier);
	  public Boolean delYfmsupplier(Integer Supplierid);
	  public Boolean updateYfmsupplier(Yfmsupplier yfmsupplier);
}
