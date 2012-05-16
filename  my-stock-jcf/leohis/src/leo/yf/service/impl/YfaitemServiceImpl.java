package leo.yf.service.impl;

import java.util.List;

import leo.entity.Yfaitem;
import leo.yf.dao.iface.YfaitemDao;
import leo.yf.service.iface.YfaitemService;

public class YfaitemServiceImpl implements YfaitemService {
    private YfaitemDao yfaitemDao;
    
	public boolean addYfaitem(Yfaitem yfaitem) {
		return yfaitemDao.addYfaitem(yfaitem);
	}
	public void setYfaitemDao(YfaitemDao yfaitemDao) {
		this.yfaitemDao = yfaitemDao;
	}
	
	public String[][] getCaiGouBiaoTao(String aformid, String date_b, String date_e,Integer pid,String InbankStatus){
		return yfaitemDao.getCaiGouBiaoTao(aformid, date_b, date_e, pid, InbankStatus);
	}
	
	public List<Yfaitem> getYfaitem(String AFormID){
		return yfaitemDao.getYfaitem(AFormID);
	}
	
	public boolean delYfaitem(String AFormID){
		return yfaitemDao.delYfaitem(AFormID);
	}
}
