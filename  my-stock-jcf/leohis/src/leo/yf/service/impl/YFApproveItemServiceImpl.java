package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.entity.YfexbankAitem;
import leo.entity.YfmexbankA;
import leo.entity.Yfminfo;
import leo.yf.dao.iface.YFApproveItemDao;
import leo.yf.dao.iface.YFApproveTableDao;
import leo.yf.dao.iface.YFMInfoDao;
import leo.yf.dao.iface.YfExbankAItemDao;
import leo.yf.dao.iface.YfmexbankADao;
import leo.yf.dao.iface.YfsetExbankTypeDao;
import leo.yf.service.iface.YFApproveItemService;

public class YFApproveItemServiceImpl implements YFApproveItemService {
	private YFApproveTableDao yfaTableDao;
	private YfExbankAItemDao yfExbankAItemDao;
	public void setYfExbankAItemDao(YfExbankAItemDao yfExbankAItemDao) {
		this.yfExbankAItemDao = yfExbankAItemDao;
	}
	public void setYfmexbankADao(YfmexbankADao yfmexbankADao) {
		this.yfmexbankADao = yfmexbankADao;
	}
	public void setYfSetExbankTypeDao(YfsetExbankTypeDao yfSetExbankTypeDao) {
		this.yfSetExbankTypeDao = yfSetExbankTypeDao;
	}
	public void setYfMinfoDao(YFMInfoDao yfMinfoDao) {
		this.yfMinfoDao = yfMinfoDao;
	}
	private YfmexbankADao yfmexbankADao;
	private YfsetExbankTypeDao yfSetExbankTypeDao;
	private YFMInfoDao yfMinfoDao;
	public void setYfaTableDao(YFApproveTableDao yfaTableDao) {
		this.yfaTableDao = yfaTableDao;
	}
	public void setYfaItemDao(YFApproveItemDao yfaItemDao) {
		this.yfaItemDao = yfaItemDao;
	}
	private YFApproveItemDao yfaItemDao;
	/**
	 * ����������ѯ����������
	 */
	public YfapproveTable getYFApproveTableByApproveFormId(Long approveFormId) {
		// TODO Auto-generated method stub
		return yfaTableDao.getYFApproveTableByApproveFormId(approveFormId);
	}
	/**
	 * ��ѯ����������
	 */
	public List<YfapproveItem> getYfapproveItemAll() {
		// TODO Auto-generated method stub
		return yfaItemDao.getYfapproveItemAll();
	}
	/**
	 * ���ݳ�������Id��ѯ��������
	 */
	public String getChuKuLeiXingName(Integer ExbankID) {
		// TODO Auto-generated method stub		
		return yfSetExbankTypeDao.getChuKuLeiXingName(ExbankID);
	}
	/**
	 * ����������ѯ����������
	 */
	public YfexbankAitem getYfexbankAitemByitemId(Long itemId) {
		// TODO Auto-generated method stub
		return yfExbankAItemDao.getYfexbankAitemByitemId(itemId);
	}
	/**
	 * ����������ѯ�������뵥
	 */
	public YfmexbankA getYfmexbankAByAformId(String aformId) {
		// TODO Auto-generated method stub
		return yfmexbankADao.getYfmexbankAByAformId(aformId);
	}
	/**
	 * ����ҩƷId��ѯҩƷ��Ϣ
	 */
	public Yfminfo getYfminfoByminfoId(Integer minfoId) {
		// TODO Auto-generated method stub
		return yfMinfoDao.getYfminfoByminfoId(minfoId);
	}
	/**
	 * ����������ѯ������
	 */
	public YfapproveItem getYfapproveItemByapproveItemId(Long approveItemId) {
		// TODO Auto-generated method stub
		return yfaItemDao.getYfapproveItemByapproveItemId(approveItemId);
	}
	/**
	 * ����������ID��ѯ������
	 */
	public List<YfapproveItem> getYfapproveItemByApproveFormId(
			Long approveFormId) {
		// TODO Auto-generated method stub
		return yfaItemDao.getYfapproveItemByApproveFormId(approveFormId);
	}

}
