package leo.cf.dao.iface;

import java.util.List;

import leo.entity.Cfmdetail;

/**
 * 药品细节DAO
 * @author Administrator
 *
 */
public interface CfmdetailDao {
	/**
	 * 添加药品细节
	 * @param cfm
	 * @return
	 */
	public boolean addCfmdetail(Cfmdetail cfm);
	/**
	 * 根据模板ID删除药品细节
	 * @param modelID
	 * @return
	 */
	public boolean delCfmdetailByModelID(Long modelID);
	/**
	 * 根据药品细节项ID删除药品细节
	 * @param iid
	 * @return
	 */
	public boolean delCfmdetailByiid(Long iid);
	/**
	 * 根据模板ID查询药品细节
	 * @param modelId
	 * @return
	 */
	public List<Cfmdetail> getCfmdetailByModelId(Long modelId);
	/**
	 * 获取最大药品细节Id
	 * @return
	 */
	public Long getMaxIid();
}
