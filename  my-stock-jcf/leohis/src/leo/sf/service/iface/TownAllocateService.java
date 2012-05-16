package leo.sf.service.iface;

import java.util.List;

import leo.entity.SfaccountDetail;
import leo.entity.SftownAllocate;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Sep 7, 2011 3:03:31 PM
 * 
 *          ������˵���service
 */
public interface TownAllocateService {

	public List<SftownAllocate> getSftownAllocate(Integer TownID,
			Integer MedicalInstitution);

	/**
	 * ����ҽ�ƻ�����id��ѯ������������ļ�¼
	 * 
	 * @param orgId
	 * @return
	 */
	public List<SftownAllocate> getAllSfTownAllocateByOrgId(Integer orgId);

	/**
	 * ��������ID��ѯ������������������¼
	 * 
	 * @param townId
	 * @return
	 */
	public List<SfaccountDetail> getSfaccountDetailByTownId(Integer townId);

	/**
	 * ��������ID�����ڲ�ѯ������������������¼
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
	 * ����������������¼
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
