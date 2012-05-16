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
	 * ��ѯ����������
	 */
	public List<YfapproveTable> getYfapproveTableAll() {
		// TODO Auto-generated method stub
		return yFApproveTableDao.getYfapproveTableAll();
	}

	/**
	 * ���ݼ�¼ID��ѯ������
	 */
	public List<YfapproveTable> getYfapproveTableByRecordId(String recordId) {
		// TODO Auto-generated method stub
		return yFApproveTableDao.getYfapproveTableByRecordId(recordId);
	}

	/**
	 * �޸�����״̬
	 * 
	 * @param yfaTable
	 * @param statu
	 */
	private void updatestatu(YfapproveTable yfaTable, String statu) {
		yfaTable.setStatus(statu);
		yFApproveTableDao.update(yfaTable);
		// �޸�״̬Ϊͬ��
		if ("YFMInbankA".equals(yfaTable.getFormBelongTo())) {
			// �޸�������뵥״̬
			YfminbankA yfminbankA = yfminbankADao
					.getYfminbankAByAformId(yfaTable.getRecordId());
			if (statu.equals("ͬ��")) {
				yfminbankA.setInbankStatus("��׼");
				yfminbankADao.update(yfminbankA);
			}
			if (statu.equals("�ܾ�")) {
				yfminbankA.setInbankStatus(statu);
				yfminbankADao.update(yfminbankA);
			}

		}
		if ("YFMExbankA".equals(yfaTable.getFormBelongTo())) {
			// �޸ĳ������뵥״̬
			YfmexbankA yfmexbankA = yfmexbankADao
					.getYfmexbankAByAformId(yfaTable.getRecordId());
			if (statu.equals("ͬ��")) {
				yfmexbankA.setExbankStatus("����׼");
				yfmexbankADao.update(yfmexbankA);
			}
			if (statu.equals("�Ѿܾ�")) {
				yfmexbankA.setExbankStatus(statu);
				yfmexbankADao.update(yfmexbankA);
			}
		}
		if ("YFCheckRecord".equals(yfaTable.getFormBelongTo())) {
			// �޸��̵��¼״̬
			yfcheckRecordDao.updateZhuangTai(yfaTable.getRecordId(), statu);
		}
	}

	/**
	 * �޸�����״̬
	 */
	public String updateStatus(Long approveFormId, String status, Long approve,
			String note) {
		// TODO Auto-generated method stub
		YfapproveItem yfapproveItem = yFApproveItemDao
				.getYfapproveItemByApproveFormIDandApprover(approveFormId,
						approve);
		if (yfapproveItem.getAgreeOrNot()) {
			return "�Բ������������ظ�����ͬһ���룡";
		} else {
			// ����������ID��ѯ������
			List<YfapproveItem> yfaItems = yFApproveItemDao
					.getYfapproveItemByApproveFormId(approveFormId);
			YfapproveTable yfaTable = new YfapproveTable();
			YfapproveItem item = null;
			if (yfaItems != null) {
				for (int i = 0; i < yfaItems.size(); i++) {
					item = yfaItems.get(i);
					// ����������ID��ѯ��������
					yfaTable = yFApproveTableDao
							.getYFApproveTableByApproveFormId(item
									.getApproveFormId());
				}
				if(yfaItems.size() == 1){
					updatestatu(yfaTable,"ͬ��");
				}
				if ("�ܾ�".equals(status)) {
					updatestatu(yfaTable, "�ܾ�");
					return "";
				}
				if ("δ��".equals(yfaTable.getStatus())) {
					updatestatu(yfaTable, "ͬ��");
				}
				if ("����".equals(yfaTable.getStatus())) {
					updatestatu(yfaTable, "δ��");
				}
			}
			yfapproveItem.setAgreeOrNot(true);
			yfapproveItem.setNote(note);
			yFApproveItemDao.update(yfapproveItem);
			return "";
		}
	}
}
