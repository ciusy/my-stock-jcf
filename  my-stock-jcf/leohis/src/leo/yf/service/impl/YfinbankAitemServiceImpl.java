package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfinbankAitem;
import leo.yf.service.iface.YfinbankAitemService;
import leo.yf.dao.iface.YfinbankAitemDao;

public class YfinbankAitemServiceImpl implements YfinbankAitemService {
	private YfinbankAitemDao yfinbankAitemDao;
	
	public boolean addYfinbankAitem(List<YfinbankAitem> yfinbankAitem) {
		return yfinbankAitemDao.addYfinbankAitem(yfinbankAitem);
	}

	public void setYfinbankAitemDao(YfinbankAitemDao yfinbankAitemDao) {
		this.yfinbankAitemDao = yfinbankAitemDao;
	}
	
	public boolean delYfinbankAitem(String ApproveFormID){
		return yfinbankAitemDao.delYfinbankAitem(ApproveFormID);
	}

	public List<YfinbankAitem> getYfinbankAitem(String approveFormId){
		return yfinbankAitemDao.getYfinbankAitem(approveFormId);
	}
	
	public String[] getRuKuJiaGe(Integer YFID, Integer YPID){
		return yfinbankAitemDao.getRuKuJiaGe(YFID, YPID);
	}
	
	public String[][] getTuiYao(String DanHao, String LeiXing){
		return yfinbankAitemDao.getTuiYao(DanHao, LeiXing);
	}
	
	public Double getZongJieE(String ApproveFormID){
		return yfinbankAitemDao.getZongJieE(ApproveFormID);
	}

}
