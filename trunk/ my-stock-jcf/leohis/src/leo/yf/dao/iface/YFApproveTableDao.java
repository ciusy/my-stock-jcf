package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Yfaitem;
import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;

/**
 * ������DAO
 * @author abc
 *
 */
public interface YFApproveTableDao extends Dao<YfapproveTable>{
	/**
	 * ����������ѯ����������
	 * @param approveFormId
	 * @return
	 */
	public YfapproveTable getYFApproveTableByApproveFormId(Long approveFormId);
	/**
	 * ����������ͷ
	 * @param yfapproveTable
	 * @return
	 */
	public boolean addYFApproveTable(YfapproveTable yfapproveTable);
	/**
	 * ��ȡ���������ID��
	 * @return
	 */
	public Long getMaxID();
	/**
	 * ��ѯ����������
	 * @return
	 */
	public List<YfapproveTable> getYfapproveTableAll();
	/**
	 * ���ݼ�¼ID��ѯ������
	 * @param recordId
	 * @return
	 */
	public List<YfapproveTable> getYfapproveTableByRecordId(String recordId);
}
