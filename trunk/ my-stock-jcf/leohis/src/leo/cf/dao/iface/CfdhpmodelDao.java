package leo.cf.dao.iface;

import java.util.List;

import leo.entity.Cfdhpmodel;

/**
 * 诊断、处置、处方模板DAO
 * @author Administrator
 *
 */
public interface CfdhpmodelDao {
	/**
	 * 添加诊断、处置、处方模板
	 * @param cfp
	 * @return
	 */
	public boolean addCfdhpmodel(Cfdhpmodel cfp);
	/**
	 * 查询最新添加的模板ID
	 * @return
	 */
	public long getNewAddModelId();
	/**
	 * 修改父节点ID
	 * @param cfp
	 * @return
	 */
	public boolean updateFactherID(Cfdhpmodel cfp);
	/**
	 * 根据模板ID查询模板
	 * @return
	 */
	public Cfdhpmodel getCfdhpmodelByModelId(Long modelId);
	/**
	 * 查询父节点ID和模板ID一样的父节点
	 * @return
	 */
	public List<Long> getFactherModelIdEqFactherID();
	/**
	 * 重载查询所有父节点ID和模板ID一样的父节点
	 * @return
	 */
	public List<Cfdhpmodel> getFactherModelIdEqFactherID(Integer factherId);
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
	 * 删除模板
	 * @param modelId
	 * @return
	 */
	public boolean delCfdhpmodelByModelId(Long modelId);
	/**
	 * 以模板Id作为父节点Id查询模板记录数
	 * @param modelId
	 * @return
	 */
	public int getCountByModelId(Long modelId);
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
