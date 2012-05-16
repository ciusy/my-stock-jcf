package leo.bc.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.CzdisposeItemDescribe;

public interface CzdisposeItemDescribeDao extends Dao<CzdisposeItemDescribe> {
	public boolean addCZDisposeItem(CzdisposeItemDescribe czdisposeItemDescribe);// ��Ӵ�����Ŀ����

	public boolean updateCZDisposeItem(
			CzdisposeItemDescribe czdisposeItemDescribe);// ���´�����Ŀ����

	/**
	 * add by xu
	 * 
	 * @param ids
	 * @return
	 */
	public List<CzdisposeItemDescribe> getByIDs(List<Integer> ids);

	/**
	 * add by xu ����ҽ�ƻ����Ĳ��� ������Ŀ������
	 * 
	 * @param medicalOrgaId
	 * @return
	 */
	public List<CzdisposeItemDescribe> getByMedicalOrgId(Integer medicalOrgaId);
	/**
	 * ���ݴ�����Ŀ���ƻ�����Ŀƴ����д��ѯ������Ŀ
	 * @param itemName
	 * @param spell
	 * @return
	 */
	public List<CzdisposeItemDescribe> getCzdisposeItemDescribeByNameOrSpell(
			String itemName, String spell);
	/**
	 * ����������ѯ������Ŀ����
	 * @param itemTypeId
	 * @return
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByItemTypID(Integer itemTypeId);
}
