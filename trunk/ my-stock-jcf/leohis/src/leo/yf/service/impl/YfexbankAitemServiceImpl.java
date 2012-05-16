package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfexbankAitem;
import leo.yf.service.iface.YfexbankAitemService;
import leo.yf.dao.iface.YfExbankAItemDao;

public class YfexbankAitemServiceImpl implements YfexbankAitemService {
	private YfExbankAItemDao yfExbankAItemDao;
	
	
	public boolean addYfexbankAitem(List<YfexbankAitem> yfexbankAitem) {
		return yfExbankAItemDao.addYfexbankAitem(yfexbankAitem);
	}


	public void setYfExbankAItemDao(YfExbankAItemDao yfExbankAItemDao) {
		this.yfExbankAItemDao = yfExbankAItemDao;
	}

	public List<YfexbankAitem> getYfexbankAitem(String AFormID){
		return yfExbankAItemDao.getYfexbankAitem(AFormID);
	}


	public List<YfexbankAitem> getYfexbankAitemByAFormID(String aformID, int mid) {
	
		return yfExbankAItemDao.getYfexbankAitemByAFormID(aformID, mid);
	}


	public boolean updateYfexbankAitem(YfexbankAitem yfexbankAitem) {
	
		return yfExbankAItemDao.updateYfexbankAitem(yfexbankAitem);
	}


	public boolean updateYFExbankAItemTuiYao(String AFormID, Integer MID,
			Integer NumReturned, Double PReturned) {
		
		return yfExbankAItemDao.updateYFExbankAItemTuiYao(AFormID, MID, NumReturned, PReturned);
	}
}
