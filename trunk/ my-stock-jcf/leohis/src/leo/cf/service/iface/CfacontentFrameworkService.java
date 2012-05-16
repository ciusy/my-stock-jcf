package leo.cf.service.iface;

import java.util.List;

import leo.entity.CfacontentFramework;

public interface CfacontentFrameworkService {
	/**
	 * 
	 * 根据ID查询出一条数据
	 * 
	 * @param id主见
	 * 
	 * @return CfacontentFramework对象
	 */
	public CfacontentFramework getCfacontentFrameworkByID(Integer id);

	/**
	 * 
	 * 修改一条数据
	 * 
	 * @param id主见
	 * 
	 * @return 成功（true）失败(false)
	 */
	public Boolean updateCfacontentFrameworkById(CfacontentFramework c);

	/**
	 * 重载修改数据方法
	 * @param formworkId 内容模板
	 * @param medicalRecords 病历摘要
	 * @param clinicalPhenomenon 临床现象
	 * @param isobjectiveRequest 检查目的及要求
	 * @param elseState 其他说明
	 * @return
	 */
	public Boolean updateCfacontentFrameworkById(Integer formworkId,
			String medicalRecords, String clinicalPhenomenon,
			String isobjectiveRequest, String elseState);

	/**
	 * 
	 * 删除一条数据
	 * 
	 * @param id主见
	 * 
	 * @return 成功（true）失败(false)
	 */

	public Boolean deleteCfacontentFramework(Integer id);

	/**
	 * 
	 * 保存一条数据
	 * 
	 * @param
	 * 
	 * @return 成功（true）失败(false)
	 */
	public Boolean addCfacontentFramework(CfacontentFramework c);

	/**
	 * 根据所属单位和项目类型Id查询内容模板（单位ID为医疗机构ID）
	 * @param Affiliation
	 * @return
	 */
	public List<CfacontentFramework> getCfacontentFrameworkByAffiliation(Integer affiliation);
	/**
	 * 重载根据所属单位和项目类型Id查询内容模板（单位ID为医疗机构ID）
	 * 
	 * @param Affiliation
	 * @return
	 */
	public List<CfacontentFramework> getCfacontentFrameworkByAffiliation(
			Integer affiliation,Integer ItemTypeID);
}
