package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfsetExbankType;

public interface YfsetExbankTypeDao extends Dao<YfsetExbankType>{
	public boolean addYfsetExbankType(YfsetExbankType yfsetExbankType);
	/**
	 * 提取出库类型
	 * @param ExbankID //出库类型ID
	 * @param PharmacyID //药房ID
	 * @param ETypeName //出库类型名称
	 * @return
	 */
	public List<YfsetExbankType> getYfsetExbankType(Integer ExbankID, Integer PharmacyID, String ETypeName);
	/**
	 * 按照出库类型ID提取出库类型名称
	 * @param ExbankID //出库类型ID
	 * @return
	 */
	public String getChuKuLeiXingName(Integer ExbankID);
	/**
	 * 根据入库类型和药房ID得到入出价格比
	 * @param LeiXing 出库类型(中文)
	 * @param YaoFangID 药房ID
	 * @return
	 */
	public Double getRuChuJiaGeBi(String LeiXing, Integer YaoFangID);
	/**
	 * 修改出库类型
	 * @param yfsetExbankType
	 * @return
	 */
	public boolean updateYFSetExbankType(YfsetExbankType yfsetExbankType);
	
	/**
	 * 查询所有出库类型
	 * @return
	 */
	public List<YfsetExbankType> getYfsetExbankTypeAll();
}
