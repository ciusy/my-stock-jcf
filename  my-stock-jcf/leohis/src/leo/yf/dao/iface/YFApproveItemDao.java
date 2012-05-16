package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfapproveItem;
import leo.entity.YfcheckRecord;

/**
 * 审批项DAO
 * @author abc
 *
 */
public interface YFApproveItemDao extends Dao<YfapproveItem>{
	/**
	 * 查询所有审批项
	 * @return
	 */
	public List<YfapproveItem> getYfapproveItemAll();
	/**
	 * 根据主键查询审批项
	 * @param approveItemId
	 * @return
	 */
	public YfapproveItem getYfapproveItemByapproveItemId(Long approveItemId);
	/**
	 * 加入审批项
	 * @param yfapproveItem
	 * @return
	 */
	public boolean addYfapproveItem(List<YfapproveItem> yfapproveItem);
	/**
	 * 根据审批表Id查询审批项
	 * @param approveFormId
	 * @return
	 */
	public List<YfapproveItem> getYfapproveItemByApproveFormId(Long approveFormId);
	/**
	 * 根据审批表ID和审批人Id查询审批项
	 * @param approveFormId
	 * @param approver
	 * @return
	 */
	public YfapproveItem getYfapproveItemByApproveFormIDandApprover(Long approveFormId,Long approver);
}
