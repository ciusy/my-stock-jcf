package leo.bc.sercive.iface;

import java.util.List;

import leo.entity.Czacontent;
import leo.entity.CzdisposeItemDescribe;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 12, 2011 3:33:45 PM
 */
public interface CzGiveWsService {

	/**
	 * 根据ids得到多个处置项目描述表
	 * 
	 * @param ids
	 * @return
	 */

	public List<CzdisposeItemDescribe> getByIDs(List<Integer> ids);

	/**
	 * 得到所有的处置的项目类型
	 * 
	 * @return
	 */
	public List<CzdisposeItemDescribe> getAllCzdisposeItemDescribe();

	/**
	 * 根据处置的项目类型id查询处置项目描述表
	 * 
	 * @param itemTypeId
	 * @return
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeById(int itemTypeId);

	/**
	 * 
	 * @param statusList
	 * @param expiryStartDateTime
	 * @param expiryEndDateTime
	 * @param officeId
	 * @return
	 */
	public List<Object[]> getCzdisposeByStatusAndTime(List<String> statusList, String expiryStartDateTime,
			String expiryEndDateTime, String officeId);

	/**
	 * 根据处置（项目）的id查找对应的手术申请
	 * 
	 * @param itemId
	 * @return
	 */
	public Czacontent getCzacontentById(String itemId);

	/**
	 * 根据医疗机构的查找 处置项目描述表
	 * 
	 * @param medicalOrgaId
	 * @return
	 */
	public List<CzdisposeItemDescribe> getByMedicalOrgId(Integer medicalOrgaId);

}
