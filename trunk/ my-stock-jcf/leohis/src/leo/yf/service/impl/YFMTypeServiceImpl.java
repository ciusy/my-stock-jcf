package leo.yf.service.impl;

import java.util.List;

import leo.entity.Yfmtype;
import leo.yf.service.iface.YFMTypeService;
import leo.yf.dao.iface.YFMTypeDao;

public class YFMTypeServiceImpl implements YFMTypeService {
    private YFMTypeDao yFMTypeDao;
    
	public void setyFMTypeDao(YFMTypeDao yFMTypeDao) {
		this.yFMTypeDao = yFMTypeDao;
	}

	public List<Yfmtype> getYFMType() {
		// TODO Auto-generated method stub
		return yFMTypeDao.getYFMType();
	}
	
	public Boolean addYFMType(Yfmtype yfmtype){
		return yFMTypeDao.addYFMType(yfmtype);
		
	}
	
	public Boolean delTFMType(String mtype){
		return yFMTypeDao.delTFMType(mtype);
	}
	

}
