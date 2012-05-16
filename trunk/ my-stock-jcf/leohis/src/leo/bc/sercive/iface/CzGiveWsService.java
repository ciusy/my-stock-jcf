package leo.bc.sercive.iface;

import java.util.List;

import leo.entity.Czacontent;
import leo.entity.CzdisposeItemDescribe;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 12, 2011 3:33:45 PM
 */
public interface CzGiveWsService {

	/**
	 * ����ids�õ����������Ŀ������
	 * 
	 * @param ids
	 * @return
	 */

	public List<CzdisposeItemDescribe> getByIDs(List<Integer> ids);

	/**
	 * �õ����еĴ��õ���Ŀ����
	 * 
	 * @return
	 */
	public List<CzdisposeItemDescribe> getAllCzdisposeItemDescribe();

	/**
	 * ���ݴ��õ���Ŀ����id��ѯ������Ŀ������
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
	 * ���ݴ��ã���Ŀ����id���Ҷ�Ӧ����������
	 * 
	 * @param itemId
	 * @return
	 */
	public Czacontent getCzacontentById(String itemId);

	/**
	 * ����ҽ�ƻ����Ĳ��� ������Ŀ������
	 * 
	 * @param medicalOrgaId
	 * @return
	 */
	public List<CzdisposeItemDescribe> getByMedicalOrgId(Integer medicalOrgaId);

}
