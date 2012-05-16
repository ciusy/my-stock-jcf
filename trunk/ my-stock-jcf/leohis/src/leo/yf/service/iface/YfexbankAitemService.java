package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfexbankAitem;

public interface YfexbankAitemService {
	public boolean addYfexbankAitem(List<YfexbankAitem> yfexbankAitem);
	public List<YfexbankAitem> getYfexbankAitem(String AFormID);
	public List<YfexbankAitem> getYfexbankAitemByAFormID(String aformID, int mid);
	public boolean updateYfexbankAitem(YfexbankAitem yfexbankAitem);
	public boolean updateYFExbankAItemTuiYao(String AFormID, Integer MID,
			Integer NumReturned, Double PReturned);
}
