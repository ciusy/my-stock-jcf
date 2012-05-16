package leo.sf.service.iface;

import java.util.List;

import leo.entity.GhcostType;
import leo.entity.SfzyinvoiceHead;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 5, 2011 10:04:35 AM
 */
public interface ZyDepositService {

	/**
	 * add by xu <br>
	 * 住院押金界面初始化时候调用的方法
	 * 
	 * @param medicalOrgnizal
	 * @return
	 */
	public List<List<String>> getCurrentDayInPatient(Integer medicalOrgnizal,
			String inPatientStatus);

	/**
	 * 住院押金界面“查询”按钮的操作调用的方法
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
	 * 续交押金的操作
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
	 * add by xu 查看住院的所有的项目
	 * 
	 * @param isderate
	 * @param inpatientId
	 * @return
	 */
	public List<List<String>> getInpatientPoject(Boolean isderate,
			String inpatientId, String typeDispose, String typeRecipe);

	/**
	 * add by xu 查看住院的项目明细
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
	 * 得到住院或者门诊病人的减免金额 add by xu
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
