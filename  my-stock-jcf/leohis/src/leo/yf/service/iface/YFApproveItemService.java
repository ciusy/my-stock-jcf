package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.entity.YfexbankAitem;
import leo.entity.YfmexbankA;
import leo.entity.Yfminfo;

/**
 * ������Service
 * @author abc
 *
 */
public interface YFApproveItemService {
	/**
	 * ��ѯ����������
	 * @return
	 */
	public List<YfapproveItem> getYfapproveItemAll();
	/**
	 * ����������ѯ����������
	 * @param approveFormId
	 * @return
	 */
	public YfapproveTable getYFApproveTableByApproveFormId(Long approveFormId);
	/**
	 * ����������ѯ����������
	 * @param itemId
	 * @return
	 */
	public YfexbankAitem getYfexbankAitemByitemId(Long itemId);
	/**
	 * ����������ѯ�������뵥
	 * @param aformId
	 * @return
	 */
	public YfmexbankA getYfmexbankAByAformId(String aformId);
	/**
	 * ���ճ�������ID��ȡ������������
	 * @param ExbankID //��������ID
	 * @return
	 */
	public String getChuKuLeiXingName(Integer ExbankID);
	/**
	 * ����ҩƷ��ϢID��ѯҩƷ
	 * @param minfoId
	 * @return
	 */
	public Yfminfo getYfminfoByminfoId(Integer minfoId);
	/**
	 * ����������ѯ������
	 * @param approveItemId
	 * @return
	 */
	public YfapproveItem getYfapproveItemByapproveItemId(Long approveItemId);
	/**
	 * ����������Id��ѯ������
	 * @param approveFormId
	 * @return
	 */
	public List<YfapproveItem> getYfapproveItemByApproveFormId(Long approveFormId);
}
