package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.entity.YfexbankAitem;
import leo.entity.YfmexbankA;
import leo.entity.Yfminfo;

/**
 * 审批项Service
 * @author abc
 *
 */
public interface YFApproveItemService {
	/**
	 * 查询所有审批项
	 * @return
	 */
	public List<YfapproveItem> getYfapproveItemAll();
	/**
	 * 根据主键查询审批表数据
	 * @param approveFormId
	 * @return
	 */
	public YfapproveTable getYFApproveTableByApproveFormId(Long approveFormId);
	/**
	 * 根据主键查询出库申请项
	 * @param itemId
	 * @return
	 */
	public YfexbankAitem getYfexbankAitemByitemId(Long itemId);
	/**
	 * 根据主键查询出库申请单
	 * @param aformId
	 * @return
	 */
	public YfmexbankA getYfmexbankAByAformId(String aformId);
	/**
	 * 按照出库类型ID提取出库类型名称
	 * @param ExbankID //出库类型ID
	 * @return
	 */
	public String getChuKuLeiXingName(Integer ExbankID);
	/**
	 * 根据药品信息ID查询药品
	 * @param minfoId
	 * @return
	 */
	public Yfminfo getYfminfoByminfoId(Integer minfoId);
	/**
	 * 根据主键查询审批项
	 * @param approveItemId
	 * @return
	 */
	public YfapproveItem getYfapproveItemByapproveItemId(Long approveItemId);
	/**
	 * 根据审批表Id查询审批项
	 * @param approveFormId
	 * @return
	 */
	public List<YfapproveItem> getYfapproveItemByApproveFormId(Long approveFormId);
}
