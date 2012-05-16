package leo.sf.service.iface;

import java.util.List;

import leo.entity.GhcostType;
import leo.entity.SfzyinvoiceHead;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 5, 2011 10:04:35 AM
 */
public interface ZyDepositService {

	/**
	 * add by xu <br>
	 * סԺѺ������ʼ��ʱ����õķ���
	 * 
	 * @param medicalOrgnizal
	 * @return
	 */
	public List<List<String>> getCurrentDayInPatient(Integer medicalOrgnizal,
			String inPatientStatus);

	/**
	 * סԺѺ����桰��ѯ����ť�Ĳ������õķ���
	 * 
	 * @param medicalOrgnizal
	 * @param consumerName
	 * @param idCard
	 * @param startTime
	 * @param endTime
	 * @param ipId
	 * @param flag
	 * @return
	 */
	public List<List<String>> getInpatientCosumer(Integer medicalOrgnizal,
			String consumerName, String idCard, String startTime,
			String endTime, String ipId, Boolean flag, String inPatientStatus,
			Integer inPatientDepId, String bedNo);

	/**
	 * ����Ѻ��Ĳ���
	 * 
	 * @param ipid
	 * @param csID
	 * @param depositAmout
	 * @param chargeMan
	 * @param officeName
	 * @param ipDeptId
	 */
	public void addDepositAmout(String ipid, String csID, String depositAmout,
			String chargeMan, String officeName, String ipDeptId);

	/**
	 * add by xu �鿴סԺ�����е���Ŀ
	 * 
	 * @param isderate
	 * @param inpatientId
	 * @return
	 */
	public List<List<String>> getInpatientPoject(Boolean isderate,
			String inpatientId, String typeDispose, String typeRecipe);

	/**
	 * add by xu �鿴סԺ����Ŀ��ϸ
	 * 
	 * @param isderate
	 * @param inpatientId
	 * @param type
	 * @param projectName
	 * @return
	 */
	public List<List<String>> getInpatientPojectDetail(Boolean isderate,
			String inpatientId, String type, String projectName,
			String typeDispose, String typeRecipe);

	/**
	 * �õ�סԺ�������ﲡ�˵ļ����� add by xu
	 * 
	 * @param isderate
	 * @param inpatientId
	 * @return
	 */
	public Double getZyReduceMoney(Boolean isderate, String inpatientId,
			String typeDispose, String typeRecipe);

	public List<List<String>> getReducePojectDetail(String inpatientId,
			String typeDispose, String typeRecipe);

	public Boolean addCharge(String inpatientId, String consumerId,
			String officesNumber, List<List<String>> list,
			String personnelNumber, String realMoeny,
			String consumerTotalMoney, String depositAmount, String cashPay,
			String medicalCardPay, String medicalInsurancePay, String bankPay,
			boolean printBillOrNot, double returnAmount, Integer orgId,
			Long invoiceNO, String upperRealMoney,
			List<List<String>> projectDetails);

	public List<GhcostType> getGhcostTypeByOrgId(Integer medicalOrgnizal);

	public Double getReduceMoneyByTemplate(String projectName,
			String projectType, String originalMoney, Integer costTypeId);

	public List<List<String>> getInvoiceProject(Boolean isderate,
			String inpatientId, String typeDispose, String typeRecipe);

	public SfzyinvoiceHead getByMedOrgId(Integer medOrgId, Long invoiceNO);
}
