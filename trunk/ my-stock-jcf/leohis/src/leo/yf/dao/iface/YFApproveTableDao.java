package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Yfaitem;
import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;

/**
 * 审批表DAO
 * @author abc
 *
 */
public interface YFApproveTableDao extends Dao<YfapproveTable>{
	/**
	 * 根据主键查询审批表数据
	 * @param approveFormId
	 * @return
	 */
	public YfapproveTable getYFApproveTableByApproveFormId(Long approveFormId);
	/**
	 * 加入审批表头
	 * @param yfapproveTable
	 * @return
	 */
	public boolean addYFApproveTable(YfapproveTable yfapproveTable);
	/**
	 * 提取最大审批表ID号
	 * @return
	 */
	public Long getMaxID();
	/**
	 * 查询所有审批表
	 * @return
	 */
	public List<YfapproveTable> getYfapproveTableAll();
	/**
	 * 根据记录ID查询审批表
	 * @param recordId
	 * @return
	 */
	public List<YfapproveTable> getYfapproveTableByRecordId(String recordId);
}
