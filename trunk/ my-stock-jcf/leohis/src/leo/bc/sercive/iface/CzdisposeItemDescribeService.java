package leo.bc.sercive.iface;

import java.util.List;

import leo.entity.CzdisposeItemDescribe;

public interface CzdisposeItemDescribeService {
	public boolean addCZDisposeItem( CzdisposeItemDescribe czdisposeItemDescribe);//��Ӵ�����Ŀ����
	public boolean updateCZDisposeItem(CzdisposeItemDescribe czdisposeItemDescribe);//���´�����Ŀ����
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
