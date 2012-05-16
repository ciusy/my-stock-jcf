package leo.cf.dao.iface;

import java.util.List;

import leo.entity.CfhandleItemDetail;
import leo.entity.CzdisposeItemDescribe;

/**
 * 处置细节DAO
 * @author Administrator
 *
 */
public interface CfhandleItemDetailDao {
	/**
	 * 添加处置细节
	 * @param cfh
	 * @return
	 */
	public boolean addCfhandleItemDetail(CfhandleItemDetail cfh);
	/**
	 * 根据模板ID删除处置细节
	 * @param modelId
	 * @return
	 */
	public boolean delCfhandleItemDetailByModelId(Long modelId);
	/**
	 * 根据模板Id查询处置细节
	 * @return
	 */
	public List<CfhandleItemDetail> getCfhandleItemDetailByModelId(Long modelId);
	/**
	 * 根据项目类型Id查询处置项目
	 * @param modelId
	 * @return
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(Integer itemId);
	/**
	 * 根据处置细节Id删除处置细节
	 * @param itemId
	 * @return
	 */
	public boolean delCfhandleItemDetailByItemId(Long itemId);
	/**
	 * 获取最大处置细节Id
	 * @return
	 */
	public Long getMaxItemId();
}
