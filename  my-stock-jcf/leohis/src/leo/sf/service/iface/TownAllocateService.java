package leo.sf.service.iface;

import java.util.List;

import leo.entity.SfaccountDetail;
import leo.entity.SftownAllocate;

/**
 * @author xuxiangpan
 * @version 创建时间：Sep 7, 2011 3:03:31 PM
 * 
 *          乡镇记账单的service
 */
public interface TownAllocateService {

	public List<SftownAllocate> getSftownAllocate(Integer TownID,
			Integer MedicalInstitution);

	/**
	 * 根据医疗机构的id查询所有乡镇调拨的记录
	 * 
	 * @param orgId
	 * @return
	 */
	public List<SftownAllocate> getAllSfTownAllocateByOrgId(Integer orgId);

	/**
	 * 根据乡镇ID查询下面的所有乡镇调拨记录
	 * 
	 * @param townId
	 * @return
	 */
	public List<SfaccountDetail> getSfaccountDetailByTownId(Integer townId);

	/**
	 * 根据乡镇ID和日期查询下面的所有乡镇调拨记录
	 * 
	 * @param townId
	 * @param startTime
	 * @param endTime
	 * @param type
	 * @return
	 */
	public List<SfaccountDetail> getSfaccountDetailByTownIdAndTime(
			Integer townId, String startTime, String endTime, String type);

	/**
	 * 添加所有乡镇调拨记录
	 * 
	 * @param sfaccountDetail
	 */
	public void addSfaccountDetail(SfaccountDetail sfaccountDetail);

	public SftownAllocate getById(Integer id);

	public void addCharge(String applicationFormId, Double realMoney,
			Integer cashOfficeNO, Long casher, boolean isCash,
			Integer medicalOrgId, Integer townId, Long invoiceNO,
			String upperRealMoney, List<List<String>> projectDetails);
}
