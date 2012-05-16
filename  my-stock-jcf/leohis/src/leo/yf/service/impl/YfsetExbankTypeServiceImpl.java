package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfsetExbankType;
import leo.yf.service.iface.YfsetExbankTypeService;
import leo.yf.dao.iface.YfsetExbankTypeDao;

public class YfsetExbankTypeServiceImpl implements YfsetExbankTypeService {
	private YfsetExbankTypeDao yfsetExbankTypeDao;
	
	public boolean addYfsetExbankType(YfsetExbankType yfsetExbankType){
		return yfsetExbankTypeDao.addYfsetExbankType(yfsetExbankType);
	}

	public void setYfsetExbankTypeDao(YfsetExbankTypeDao yfsetExbankTypeDao) {
		this.yfsetExbankTypeDao = yfsetExbankTypeDao;
	}
	public List<YfsetExbankType> getYfsetExbankType(Integer ExbankID, Integer PharmacyID, String ETypeName){
		return yfsetExbankTypeDao.getYfsetExbankType(ExbankID, PharmacyID, ETypeName);
	}
	
	public String getChuKuLeiXingName(Integer ExbankID){
		return yfsetExbankTypeDao.getChuKuLeiXingName(ExbankID);
	}
	
	public Double getRuChuJiaGeBi(String LeiXing, Integer YaoFangID){
		return yfsetExbankTypeDao.getRuChuJiaGeBi(LeiXing, YaoFangID);
	}
	
	public boolean updateYFSetExbankType(YfsetExbankType yfsetExbankType){
		return yfsetExbankTypeDao.updateYFSetExbankType(yfsetExbankType);
	}

	public List<YfsetExbankType> getyfsetExbankTypeAll() {
		// TODO Auto-generated method stub
		return yfsetExbankTypeDao.getYfsetExbankTypeAll();
	}
}
