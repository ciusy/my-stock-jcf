package leo.sf.service.iface;

import java.util.List;

import leo.entity.SfmzinvoiceHead;

/**
 * 
 * @author xuxiangpan<br>
 *         �����շ�ʹ�õ�service
 * 
 */
public interface MZChargeService {

	/**
	 * add by xu �õ�������շѵĲ��ˣ����ڵ�¼�˿��ҵģ����ݵ�ǰ��¼ϵͳ�ģ�
	 * 
	 * @param officeId
	 * @param isCharge
	 *            //�Ƿ����˷�true �������շ� false �������˷�
	 * @return
	 */
	List<List<String>> getCosumer(int officeId, boolean isCharge);

	/**
	 * add by xu
	 * 
	 * ���ݣ��������������������ڣ����֤�ţ�ҽ�ƿ��Ž��в�ѯ
	 * 
	 * @param consumerName
	 * @param idCard
	 * @param medicalCard
	 * @param startTime
	 * @param endTime
	 * @param flag
	 * @param officeId
	 * @param isCharge
	 *            //�Ƿ����˷�true �������շ� false �������˷�
	 * @return
	 */
	public List<List<String>> getCosumer(String consumerName, String idCard,
			String medicalCard, String startTime, String endTime, int flag,
			int officeId, boolean isCharge, Integer medOrgId);

	/**
	 * ���ݷ���������Ϻź��Ƿ��Ǽ����ѯ�����Ĵ���
	 * 
	 * @param oPDiagnoseID
	 * @param isReduce
	 * @return
	 */
	public List<List<String>> getProject(String oPDiagnoseID);

	// public List<List<String>> getProject(String oPDiagnoseID, Integer
	// isReduce);

	/**
	 * ����������շѵĲ���
	 * 
	 * @param consumerId
	 * @param diagnoseID���ID
	 * @param costTypeId��������ID
	 * @param officesNumber����ID
	 * @param list
	 * @param personnelNumber
	 * @param realMoeny
	 * @param cashPay
	 * @param medicalCardPay
	 * @param medicalInsurancePay
	 * @param bankPay
	 * @param reduceMoney
	 * @return
	 */
	public Boolean addCharge(String consumerId, String diagnoseID,
			String costTypeId, String officesNumber, List<List<String>> list,
			String personnelNumber, String realMoeny, String cashPay,
			String medicalCardPay, String medicalInsurancePay, String bankPay,
			String reduceMoney, Integer orgId, Long invoiceNO,
			String upperRealMoney, String outpatientId,
			List<List<String>> projectDetails);

	public List<String> getWillDeletedMethod(String OpDnID);

	public List<List<String>> getDisposeByStatus(String kindType,
			String kindId, String status);

	/**
	 * �õ��Ѿ��˳�������Ŀ
	 * 
	 * @return
	 */
	public List<List<String>> getReturnPrescription(String outPatientId,
			String status);

	public SfmzinvoiceHead getByMedOrgId(Integer medOrgId, Long invoiceNO);

	public List<List<String>> getReturnInvoiceProjects(List<List<String>> list);

	public List<List<String>> updateCharge(List<List<String>> list,
			Double realMoeny, String upperRealMoney);

	public void updateMZstatus(String oPDiagnoseID);

	public List<List<String>> getIsCharedNotTakeDrugsCosumer(int officeId);

	public List<List<String>> getIsCharedNotTakeDrugsCosumer(
			String consumerName, String idCard, String medicalCard,
			String startTime, String endTime, int flag, int officeId,
			Integer medOrgId);

	public List<List<String>> updateIsCharedNotTakeDrugsCharge(
			List<List<String>> list, Double realMoeny, String upperRealMoney);

}
