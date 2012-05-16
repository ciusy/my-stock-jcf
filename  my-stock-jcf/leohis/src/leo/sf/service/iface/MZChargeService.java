package leo.sf.service.iface;

import java.util.List;

import leo.entity.SfmzinvoiceHead;

/**
 * 
 * @author xuxiangpan<br>
 *         门诊收费使用的service
 * 
 */
public interface MZChargeService {

	/**
	 * add by xu 得到当天待收费的病人，属于登录人科室的（根据当前登录系统的）
	 * 
	 * @param officeId
	 * @param isCharge
	 *            //是否是退费true 是门诊收费 false 是门诊退费
	 * @return
	 */
	List<List<String>> getCosumer(int officeId, boolean isCharge);

	/**
	 * add by xu
	 * 
	 * 根据，服务对象姓名，诊断日期，身份证号，医疗卡号进行查询
	 * 
	 * @param consumerName
	 * @param idCard
	 * @param medicalCard
	 * @param startTime
	 * @param endTime
	 * @param flag
	 * @param officeId
	 * @param isCharge
	 *            //是否是退费true 是门诊收费 false 是门诊退费
	 * @return
	 */
	public List<List<String>> getCosumer(String consumerName, String idCard,
			String medicalCard, String startTime, String endTime, int flag,
			int officeId, boolean isCharge, Integer medOrgId);

	/**
	 * 根据服务对象的诊断号和是否是减免查询开出的处方
	 * 
	 * @param oPDiagnoseID
	 * @param isReduce
	 * @return
	 */
	public List<List<String>> getProject(String oPDiagnoseID);

	// public List<List<String>> getProject(String oPDiagnoseID, Integer
	// isReduce);

	/**
	 * 进行门诊的收费的操作
	 * 
	 * @param consumerId
	 * @param diagnoseID诊断ID
	 * @param costTypeId费用类型ID
	 * @param officesNumber科室ID
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
	 * 得到已经退出处方项目
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
