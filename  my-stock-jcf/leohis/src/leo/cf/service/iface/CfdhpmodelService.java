package leo.cf.service.iface;

import java.util.List;

import leo.entity.Cfdhpmodel;
import leo.entity.CfhandleItemDetail;
import leo.entity.Cfmdetail;
import leo.entity.CzdisposeItemDescribe;

/**
 * 门诊、处置、处方模板Service
 * @author Administrator
 *
 */
public interface CfdhpmodelService {
	/**
	 * 添加诊断、处置、处方模板
	 * 功能详述：
	 * 此方法是先添加模板，然后查询新添加模板的ID。
	 * 用查处的模板ID分别添加药品细节和处置细节。
	 * @param cfd 模板
	 * @param mid 药品ID
	 * @param unit 单位
	 * @param quantity 药品数量
	 * @param handleItemID 处置项目ID
	 * @return
	 */
	public boolean addCfdhpmodel(Cfdhpmodel cfd,List<Cfmdetail> cfmList, List<CfhandleItemDetail> cfhList);
	
	/**
	 * 查询父节点ID和模板ID一样的父节点
	 * @return
	 */
	public List<Long> getFactherModelIdEqFactherID();
	/**
	 * 重载查询父节点ID和模板ID一样的父节点
	 * @return
	 */
	public boolean getFactherModelIdEqFactherID(Integer factherId);
	/**
	 * 公有模板设置
	 * 根据父节点ID查询所有模板
	 * @param factherId
	 * @return
	 */
	public List<Cfdhpmodel> getCfdhpmodelByFactherId(Long factherId);
	/**
	 * 私有模板设置
	 * 重载根据父节点ID查询所有模板
	 * @param factherId
	 * @return
	 */
	public List<Cfdhpmodel> getCfdhpmodelByFactherId(Long factherId,Long ower);
	/**
	 * 根据模板ID删除模板
	 * @param modelId
	 * @return
	 */
	public boolean delCfdhpmodelByModelId(Long modelId);
	/**
	 * 以模板Id作为父节点Id查询模板记录数
	 * @param modelId
	 * @return
	 */
	public boolean getCountByModelId(Long modelId);
	
	/**
	 * 根据模板ID查询药品细节
	 * @param modelId
	 * @return
	 */
	public List<Cfmdetail> getCfmdetailByModelId(Long modelId);
	/**
	 * 根据模板Id查询处置细节
	 * @return
	 */
	public List<CfhandleItemDetail> getCfhandleItemDetailByModelId(Long modelId);
	/**
	 * 根据模板ID查询模板
	 * @return
	 */
	public Cfdhpmodel getCfdhpmodelByModelId(Long modelId);
	/**
	 * 根据项目类型Id查询处置项目
	 * @param modelId
	 * @return
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(Integer itemId);
	/**
	 * 添加处置细节
	 * @param cfh
	 * @return
	 */
	public boolean addCfhandleItemDetail(CfhandleItemDetail cfh);
	/**
	 * 添加药品细节
	 * @param cfm
	 * @return
	 */
	public boolean addCfmdetail(Cfmdetail cfm);
	/**
	 * 删除处置细节
	 * @param itemId 药品细节Id
	 * @return
	 */
	public boolean delCfhandleItemDetail(Long itemId);
	/**
	 * 删除药品细节
	 * @param iid
	 * @return
	 */
	public boolean delCfmdetail(Long iid);
	/**
	 * 获取药品细节最大Id
	 * @return
	 */
	public Long getMaxIid();
	/**
	 * 获取最大处置细节Id
	 * @return
	 */
	public Long getMaxItemId();
	/**
	 * 增加模板类型
	 * @return
	 */
	public boolean addCfdhpmodelType(Cfdhpmodel cfd);
	/**
	 * 查询模板类型
	 * @param ower
	 * @return
	 */
	public List<Cfdhpmodel> getCfdhpmodelType(String ower);
	/**
	 * 删除模板类型
	 * @param modelId
	 * @return
	 */
	public boolean delCfdhpmodelType(Long factherId);
	/**
	 * 查询模板是否存在
	 * @param modelName
	 * @return
	 */
	public boolean getCfdhpmodelByName(String modelName);
	/**
	 * 查询模板类型是否存在
	 * @param modelName
	 * @return
	 */
	public boolean getCfdhpmodelTypeByName(String modelName, String ower);
}
