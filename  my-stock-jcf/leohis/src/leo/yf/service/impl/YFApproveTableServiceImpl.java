package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.entity.YfcheckRecord;
import leo.entity.YfmexbankA;
import leo.entity.YfminbankA;
import leo.yf.service.iface.YFApproveTableService;
import leo.yf.dao.iface.YFApproveItemDao;
import leo.yf.dao.iface.YFApproveTableDao;
import leo.yf.dao.iface.YfcheckRecordDao;
import leo.yf.dao.iface.YfmexbankADao;
import leo.yf.dao.iface.YfminbankADao;

public class YFApproveTableServiceImpl implements YFApproveTableService {
	private YFApproveTableDao yFApproveTableDao;
	private YFApproveItemDao yFApproveItemDao;
	private YfminbankADao yfminbankADao;
	private YfmexbankADao yfmexbankADao;
	private YfcheckRecordDao yfcheckRecordDao;

	public void setYfminbankADao(YfminbankADao yfminbankADao) {
		this.yfminbankADao = yfminbankADao;
	}

	public void setYfmexbankADao(YfmexbankADao yfmexbankADao) {
		this.yfmexbankADao = yfmexbankADao;
	}

	public void setYfcheckRecordDao(YfcheckRecordDao yfcheckRecordDao) {
		this.yfcheckRecordDao = yfcheckRecordDao;
	}

	public void setyFApproveItemDao(YFApproveItemDao yFApproveItemDao) {
		this.yFApproveItemDao = yFApproveItemDao;
	}

	public void setyFApproveTableDao(YFApproveTableDao yFApproveTableDao) {
		this.yFApproveTableDao = yFApproveTableDao;
	}

	public Long getMaxID() {
		return yFApproveTableDao.getMaxID();
	}

	/**
	 * 查询所有审批表
	 */
	public List<YfapproveTable> getYfapproveTableAll() {
		// TODO Auto-generated method stub
		return yFApproveTableDao.getYfapproveTableAll();
	}

	/**
	 * 根据记录ID查询审批表
	 */
	public List<YfapproveTable> getYfapproveTableByRecordId(String recordId) {
		// TODO Auto-generated method stub
		return yFApproveTableDao.getYfapproveTableByRecordId(recordId);
	}

	/**
	 * 修改审批状态
	 * 
	 * @param yfaTable
	 * @param statu
	 */
	private void updatestatu(YfapproveTable yfaTable, String statu) {
		yfaTable.setStatus(statu);
		yFApproveTableDao.update(yfaTable);
		// 修改状态为同意
		if ("YFMInbankA".equals(yfaTable.getFormBelongTo())) {
			// 修改入库申请单状态
			YfminbankA yfminbankA = yfminbankADao
					.getYfminbankAByAformId(yfaTable.getRecordId());
			if (statu.equals("同意")) {
				yfminbankA.setInbankStatus("批准");
				yfminbankADao.update(yfminbankA);
			}
			if (statu.equals("拒绝")) {
				yfminbankA.setInbankStatus(statu);
				yfminbankADao.update(yfminbankA);
			}

		}
		if ("YFMExbankA".equals(yfaTable.getFormBelongTo())) {
			// 修改出库申请单状态
			YfmexbankA yfmexbankA = yfmexbankADao
					.getYfmexbankAByAformId(yfaTable.getRecordId());
			if (statu.equals("同意")) {
				yfmexbankA.setExbankStatus("已批准");
				yfmexbankADao.update(yfmexbankA);
			}
			if (statu.equals("已拒绝")) {
				yfmexbankA.setExbankStatus(statu);
				yfmexbankADao.update(yfmexbankA);
			}
		}
		if ("YFCheckRecord".equals(yfaTable.getFormBelongTo())) {
			// 修改盘点记录状态
			yfcheckRecordDao.updateZhuangTai(yfaTable.getRecordId(), statu);
		}
	}

	/**
	 * 修改审批状态
	 */
	public String updateStatus(Long approveFormId, String status, Long approve,
			String note) {
		// TODO Auto-generated method stub
		YfapproveItem yfapproveItem = yFApproveItemDao
				.getYfapproveItemByApproveFormIDandApprover(approveFormId,
						approve);
		if (yfapproveItem.getAgreeOrNot()) {
			return "对不起，您不可以重复审批同一申请！";
		} else {
			// 根据审批表ID查询审批项
			List<YfapproveItem> yfaItems = yFApproveItemDao
					.getYfapproveItemByApproveFormId(approveFormId);
			YfapproveTable yfaTable = new YfapproveTable();
			YfapproveItem item = null;
			if (yfaItems != null) {
				for (int i = 0; i < yfaItems.size(); i++) {
					item = yfaItems.get(i);
					// 根据审批表ID查询出审批表
					yfaTable = yFApproveTableDao
							.getYFApproveTableByApproveFormId(item
									.getApproveFormId());
				}
				if(yfaItems.size() == 1){
					updatestatu(yfaTable,"同意");
				}
				if ("拒绝".equals(status)) {
					updatestatu(yfaTable, "拒绝");
					return "";
				}
				if ("未定".equals(yfaTable.getStatus())) {
					updatestatu(yfaTable, "同意");
				}
				if ("申请".equals(yfaTable.getStatus())) {
					updatestatu(yfaTable, "未定");
				}
			}
			yfapproveItem.setAgreeOrNot(true);
			yfapproveItem.setNote(note);
			yFApproveItemDao.update(yfapproveItem);
			return "";
		}
	}
}
