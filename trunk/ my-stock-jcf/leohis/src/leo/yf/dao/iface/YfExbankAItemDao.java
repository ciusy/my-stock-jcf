package leo.yf.dao.iface;

import java.util.List;
import java.util.Set;

import leo.common.dao.Dao;
import leo.entity.YfexbankAitem;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Jul 23, 2011 11:34:32 AM
 */
public interface YfExbankAItemDao extends Dao<YfexbankAitem> {

	/**
	 * ����һ�����߶���������뵥�Ų�ѯ��Ӧ�Ĵ�����Ϣ
	 * 
	 * @param aFormIDs
	 * @return
	 */
	public List<Object[]> getCF(List<String> aformIDs);

	/**
	 * ������Ŀ��ID�����޸Ķ�Ӧ �ļ�����
	 * 
	 * @param itemIDList
	 * @param itemReduce
	 */
	public void updateReduce(List<Long> itemIDList, List<Double> itemReduce);

	public boolean addYfexbankAitem(List<YfexbankAitem> yfexbankAitem); // ���ӳ��ⵥ��Ŀ

	public boolean delYFExbankAItem(String AFormID); // �������뵥IDɾ����Ŀ

	/**
	 * �������뵥����ȡ��������
	 * 
	 * @param AFormID
	 * @return
	 */
	public List<YfexbankAitem> getYfexbankAitem(String AFormID);

	/**
	 * ����������ѯ����������
	 * 
	 * @param itemId
	 * @return
	 */
	public YfexbankAitem getYfexbankAitemByitemId(Long itemId);

	public List<YfexbankAitem> getYfexbankAitemByAFormID(String aformID, int mid);

	public boolean updateYfexbankAitem(YfexbankAitem yfexbankAitem);

	/**
	 * add by xu
	 * 
	 * @param applicationIds
	 * @return
	 */
	public List<Object[]> getInpatientProject(List<String> applicationIds);

	/**
	 * add by xu
	 * 
	 * @param applicationIds
	 * @return
	 */
	public List<Object[]> getDerateInpatientProject(List<String> applicationIds);

	/**
	 * add by xu
	 * 
	 * @param isderate
	 * 
	 * @param inpatientId
	 * @param projectName
	 * @param paramList2
	 * @return
	 */
	public List<List<String>> getInpatientProjectDetail(Boolean isderate,
			String inpatientId, String projectName, String type,
			List<String> paramList2);

	/**
	 * add by xu
	 * 
	 * @param isderate
	 * @param inpatientId
	 * @param string
	 * @return
	 */
	public Double getReduceMoney(Boolean isderate, String inpatientId,
			String string);

	/**
	 * add by xu
	 * 
	 * @param inpatientId
	 * @param paramList2
	 * @return
	 */
	public List<List<String>> getReducePojectDetail(String inpatientId,
			String typeStr, List<String> paramList2);

	/**
	 * add by xu
	 * 
	 * @param oPDiagnoseID
	 * @param type
	 * @return
	 */
	public List<List<String>> getCF(String outPatientId, String status);

	/**
	 * �޸ĳ��ⵥ����ҩ��Ϣ
	 * 
	 * @param AFormID
	 *            ���ⵥ��
	 * @param MID
	 *            ҩƷID
	 * @param NumReturned
	 *            ��������
	 * @param PReturned
	 *            ���˼۸�
	 * @return
	 */
	public boolean updateYFExbankAItemTuiYao(String AFormID, Integer MID,
			Integer NumReturned, Double PReturned);

	/**
	 * add by xu
	 * 
	 * @param applicationFormId
	 * @return
	 */
	public List<List<String>> getYfexbankAitemDetail(String applicationFormId);

	/**
	 * ���ݳ��ⵥID��ҩƷIDɾ��һ����¼
	 * 
	 * @param AFormID
	 *            ���ⵥID
	 * @param MID
	 *            ҩƷID
	 * @return
	 */
	public boolean delYFExbankAItemByAFormIDMID(String AFormID, Integer MID);

	/**
	 * add by xu
	 * 
	 * @param aFormIds
	 * @return
	 */
	public List<Object[]> getInvoiceCF(Set<String> aFormIds);

}
