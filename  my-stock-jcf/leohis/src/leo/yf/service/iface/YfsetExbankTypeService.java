package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfsetExbankType;

public interface YfsetExbankTypeService {
	public boolean addYfsetExbankType(YfsetExbankType yfsetExbankType);
	public List<YfsetExbankType> getYfsetExbankType(Integer ExbankID, Integer PharmacyID, String ETypeName);
	public String getChuKuLeiXingName(Integer ExbankID);
	public Double getRuChuJiaGeBi(String LeiXing, Integer YaoFangID);
	public boolean updateYFSetExbankType(YfsetExbankType yfsetExbankType);
	//public Double getRuChuJiaGeBi(String LeiXing, Integer YaoFangID);
	/**
	 * 查询所有出库类型
	 * @return
	 */
	public List<YfsetExbankType> getyfsetExbankTypeAll();
}
