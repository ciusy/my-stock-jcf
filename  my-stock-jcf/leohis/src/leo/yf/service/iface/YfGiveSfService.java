package leo.yf.service.iface;

import java.util.List;
import java.util.Set;

import leo.entity.YfexbankAitem;
import leo.entity.YfmexbankA;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 23, 2011 11:56:05 AM
 */
public interface YfGiveSfService {

	/**
	 * 根据一个或者多个出库申请单号查询对应的处方信息
	 * 
	 * @param aFormIDs
	 * @return
	 */
	public List<Object[]> getCF(List<String> aformIDs);

	/**
	 * add by xu<br>
	 * 收费的时候，根据所有的申领单的IDS修改申领单状态和申请项的减免金额
	 * 
	 * @param aFormIDs
	 * @param itemReduce
	 * @param itemIDList
	 * @param costTypeId
	 */
	public void updateStatusAndReduce(Set<String> aFormIDs,
			List<Long> itemIDList, List<Double> itemReduce, String costTypeId);

	/**
	 * 根据主键查询
	 * 
	 * @param aformId
	 */
	public YfmexbankA getYFMExbankA(String aformId);

	/**
	 * add by xu 住院结算 时候得到病人的所的处方项目信息
	 * 
	 * @param paramList2
	 * 
	 * @return
	 */
	public List<Object[]> getInpatientProject(boolean flag, String inpatientId,
			String type, List<String> paramList2);

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
	 * @param typeStr
	 * @param paramList2
	 * @return
	 */
	public List<List<String>> getReducePojectDetail(String inpatientId,
			String typeStr, List<String> paramList2);

	/**
	 * add by xu
	 * 
	 * @param outPatientId
	 * @param status
	 * @return
	 */
	public List<List<String>> getReturnPrescription(String outPatientId,
			String status);

	/**
	 * add by xu
	 * 
	 * @param oPDiagnoseID
	 * @param string
	 * @return
	 */
	public List<List<String>> getCF(String outPatientId, String status) ;

	public List<List<String>> getTownAllocateApplicationBill(Integer townId,
			String status, String applicationBillNO, String startTime,
			String endTime);

	public List<List<String>> getYfexbankAitemDetail(String applicationFormId);

	public List<Object[]> getInvoiceCF(Set<String> aFormIds);

	public void updateStorageApplicationFormStatus(
			Set<String> storageApplicationFormIds, String string);

	public int getCFCount(String opnum, String... status);

	public int getCFReturnCount(String opnum, String... status);

	public void updateYFmbankStatus(Set<String> storageApplicationFormIds,
			String status);

}
