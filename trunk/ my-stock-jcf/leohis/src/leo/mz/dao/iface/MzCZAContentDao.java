package leo.mz.dao.iface;

import leo.entity.Czacontent;

/**
 * ������������Dao
 * @author abc
 *
 */
public interface MzCZAContentDao {
	/**
	 * ���������������
	 * @param cza
	 * @return
	 */
	public boolean addCZAContent(Czacontent cza);
	/**
	 * ɾ��������������
	 * @param cza
	 * @return
	 */
	public boolean delCZAContent(Czacontent cza);
	/**
	 * ����������ѯ������������
	 * @param itemId
	 * @return
	 */
	public Czacontent getCZAContentByItemId(String itemId);
	/**
	 * ������ĿIDɾ�����뵥
	 * @param ItemID ��ĿID
	 * @return
	 */
	public boolean delCZAContentByItemID(String ItemID);
}
