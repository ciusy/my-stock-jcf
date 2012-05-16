package leo.mz.dao.iface;

import leo.entity.Czacontent;

/**
 * 门诊申请内容Dao
 * @author abc
 *
 */
public interface MzCZAContentDao {
	/**
	 * 添加门诊申请内容
	 * @param cza
	 * @return
	 */
	public boolean addCZAContent(Czacontent cza);
	/**
	 * 删除门诊申请内容
	 * @param cza
	 * @return
	 */
	public boolean delCZAContent(Czacontent cza);
	/**
	 * 根据主键查询门诊申请内容
	 * @param itemId
	 * @return
	 */
	public Czacontent getCZAContentByItemId(String itemId);
	/**
	 * 按照项目ID删除申请单
	 * @param ItemID 项目ID
	 * @return
	 */
	public boolean delCZAContentByItemID(String ItemID);
}
