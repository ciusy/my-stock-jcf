package leo.cf.dao.iface;

import java.util.List;

import leo.entity.Cfmdetail;

/**
 * ҩƷϸ��DAO
 * @author Administrator
 *
 */
public interface CfmdetailDao {
	/**
	 * ���ҩƷϸ��
	 * @param cfm
	 * @return
	 */
	public boolean addCfmdetail(Cfmdetail cfm);
	/**
	 * ����ģ��IDɾ��ҩƷϸ��
	 * @param modelID
	 * @return
	 */
	public boolean delCfmdetailByModelID(Long modelID);
	/**
	 * ����ҩƷϸ����IDɾ��ҩƷϸ��
	 * @param iid
	 * @return
	 */
	public boolean delCfmdetailByiid(Long iid);
	/**
	 * ����ģ��ID��ѯҩƷϸ��
	 * @param modelId
	 * @return
	 */
	public List<Cfmdetail> getCfmdetailByModelId(Long modelId);
	/**
	 * ��ȡ���ҩƷϸ��Id
	 * @return
	 */
	public Long getMaxIid();
}
