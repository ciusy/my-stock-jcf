package leo.cf.dao.iface;

import java.util.List;

import leo.entity.CfacontentFramework;

public interface CfacontentFrameworkDao {
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
	 * @param Affiliation
	 * @return
	 */
	public List<CfacontentFramework> getCfacontentFrameworkByAffiliation(Integer affiliation,Integer itemTypeID);
}
