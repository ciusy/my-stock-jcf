package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfapproveItem;
import leo.entity.YfcheckRecord;

/**
 * ������DAO
 * @author abc
 *
 */
public interface YFApproveItemDao extends Dao<YfapproveItem>{
	/**
	 * ��ѯ����������
	 * @return
	 */
	public List<YfapproveItem> getYfapproveItemAll();
	/**
	 * ����������ѯ������
	 * @param approveItemId
	 * @return
	 */
	public YfapproveItem getYfapproveItemByapproveItemId(Long approveItemId);
	/**
	 * ����������
	 * @param yfapproveItem
	 * @return
	 */
	public boolean addYfapproveItem(List<YfapproveItem> yfapproveItem);
	/**
	 * ����������Id��ѯ������
	 * @param approveFormId
	 * @return
	 */
	public List<YfapproveItem> getYfapproveItemByApproveFormId(Long approveFormId);
	/**
	 * ����������ID��������Id��ѯ������
	 * @param approveFormId
	 * @param approver
	 * @return
	 */
	public YfapproveItem getYfapproveItemByApproveFormIDandApprover(Long approveFormId,Long approver);
}
