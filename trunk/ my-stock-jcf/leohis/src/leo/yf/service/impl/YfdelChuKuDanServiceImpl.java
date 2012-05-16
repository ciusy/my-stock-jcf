package leo.yf.service.impl;

import leo.yf.service.iface.YfdelChuKuDanService;
import leo.yf.dao.iface.YfExbankAItemDao;
import leo.yf.dao.iface.YfmexbankADao;

public class YfdelChuKuDanServiceImpl implements YfdelChuKuDanService {
	private YfExbankAItemDao yfExbankAItemDao;
	private YfmexbankADao yfmexbankADao;
	
	public boolean delChuKuDan(String AFormID){
		yfExbankAItemDao.delYFExbankAItem(AFormID);
		yfmexbankADao.delYFMExbankA(AFormID);
		return true;
	}

	public void setYfExbankAItemDao(YfExbankAItemDao yfExbankAItemDao) {
		this.yfExbankAItemDao = yfExbankAItemDao;
	}

	public void setYfmexbankADao(YfmexbankADao yfmexbankADao) {
		this.yfmexbankADao = yfmexbankADao;
	}
	
	

}
