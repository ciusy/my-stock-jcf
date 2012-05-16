package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfapproveTable;

public interface YFApproveTableService {
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
	/**
	 * 修改审批状态
	 * @param aformId 审批表ID
	 * @param status 状态
	 * @param approve 审批人ID
	 * @param note 拒绝原因
	 * @return
	 */
	public String updateStatus(Long approveFormId,String status,Long approve,String note);
}
