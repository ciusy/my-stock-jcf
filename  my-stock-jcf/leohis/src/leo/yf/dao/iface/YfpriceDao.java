package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfmwayTo;
import leo.entity.Yfprice;

public interface YfpriceDao extends Dao<Yfprice>{
	/**
	 * 提取出库价格
	 * @param ExbankType 出库类型
	 * @param MInfoID 药品信息ID
	 * @param MedicalInstID 医疗机构ID
	 * @return
	 */
	public List<Yfprice> getYfprice(String ExbankType, Integer MInfoID, Integer MedicalInstID);
	/**
	 * 保存入库价格
	 * @param yfprice
	 * @return
	 */
	public boolean addYfprice(Yfprice yfprice);
	public Long getmaxID(); //得到最大价格表ID
	/**
	 * 判断一种药品一种出库类型是否存在
	 * @param cklx 出库类型
	 * @param ypID 药品信息ID
	 * @param yljgID 医疗机构ID
	 * @return
	 */
	public Long getCuiZai(String cklx, Integer ypID, Integer yljgID);
	/**
	 * 修改药品出库价格
	 * @param cklx 出库类型
	 * @param ypID 药品信息ID
	 * @param yljgID 医疗机构ID
	 * @return je 价格
	 */
	public boolean updateJiaGe(String cklx, Integer ypID, Integer yljgID, Double je);
	
}
