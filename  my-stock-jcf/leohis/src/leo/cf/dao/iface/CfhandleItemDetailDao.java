package leo.cf.dao.iface;

import java.util.List;

import leo.entity.CfhandleItemDetail;
import leo.entity.CzdisposeItemDescribe;

/**
 * ����ϸ��DAO
 * @author Administrator
 *
 */
public interface CfhandleItemDetailDao {
	/**
	 * ��Ӵ���ϸ��
	 * @param cfh
	 * @return
	 */
	public boolean addCfhandleItemDetail(CfhandleItemDetail cfh);
	/**
	 * ����ģ��IDɾ������ϸ��
	 * @param modelId
	 * @return
	 */
	public boolean delCfhandleItemDetailByModelId(Long modelId);
	/**
	 * ����ģ��Id��ѯ����ϸ��
	 * @return
	 */
	public List<CfhandleItemDetail> getCfhandleItemDetailByModelId(Long modelId);
	/**
	 * ������Ŀ����Id��ѯ������Ŀ
	 * @param modelId
	 * @return
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(Integer itemId);
	/**
	 * ���ݴ���ϸ��Idɾ������ϸ��
	 * @param itemId
	 * @return
	 */
	public boolean delCfhandleItemDetailByItemId(Long itemId);
	/**
	 * ��ȡ�����ϸ��Id
	 * @return
	 */
	public Long getMaxItemId();
}
