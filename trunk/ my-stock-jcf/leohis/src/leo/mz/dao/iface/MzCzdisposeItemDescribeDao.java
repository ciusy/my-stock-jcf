package leo.mz.dao.iface;


import java.util.List;

import leo.entity.CzdisposeItemDescribe;


public interface MzCzdisposeItemDescribeDao {
	
	/**
	 * 
	 * 根据ID查询处置项目对象
	 * 
	 * @param ID
	 *            
	 * @return CzdisposeDivaricateU
	 */
	public List<CzdisposeItemDescribe> getCzdById(Long id);
	
	/**
	 * 
	 * 添加CzdisposeItemDescribe
	 * 
	 * @param CzdisposeItemDescribe 对象
	 *            
	 * @return
	 */
	public void addCzdisposeItemDescribe(CzdisposeItemDescribe c);
	
	/**
	 * 
	 * 删除CzdisposeItemDescribe
	 * 
	 * @param ID
	 *            
	 * @return
	 */
	public void deleCzdisposeItemDescribe(Integer id);
	
	/**
	 * 
	 * 更新CzdisposeItemDescribe
	 * 
	 * @param CzdisposeItemDescribe 对象
	 *            
	 * @return
	 */
	public void updateCzdisposeItemDescribe(CzdisposeItemDescribe c);
	
	/**
	 * 根据主键查询出一个处置项目描述
	 * @param id
	 * @return
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(Integer id);
	
	/**
	 * 
	 * 级联删除
	 * 
	 * @param 主见ID
	 *            
	 * @return
	 */
	public void deleCzdisposeItemDescribebyItemTypeId(Integer id);
	
	/**
	 * 
	 * 通过名称查询
	 * 
	 * @param name 名称
	 *            
	 * @return CzdisposeItemDescribe对象
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemName(String name);
	public List<CzdisposeItemDescribe> getCzdisposeItemDescribeBySepll(String Sepll,int Mid);
	/**
	 * 按照名称或拼音缩写提取处置项目
	 * @param ItemName 名称
	 * @param Spell 拼音缩写
	 * @return
	 */
	public List<CzdisposeItemDescribe> getCZDisposeItemDescribe(String ItemName, String Spell);
	/**
	 * 根据项目类型ID查找项目名称
	 * @param ItemTypeID 项目类型ID
	 * @return
	 */
	public String getCZDisposeItemDescribeName(Integer ItemTypeID);
	/**
	 * 根据名称、拼音、类别提取项目
	 * @param ItemName 名称
	 * @param Spell 拼音
	 * @param DisposeItemType 类别
	 * @param MedicalInstID 医疗机构
	 * @return
	 */
	public List<CzdisposeItemDescribe> getCZDisposeItemDescribeByNameAndType(String ItemName, String Spell, String DisposeItemType, Integer MedicalInstID);
	/**
	 * 根据医疗机构和项目名称判断是否存在
	 * @param ItemName 项目名称
	 * @param MedicalInstID 医疗机构
	 * @return
	 */
	public Integer getCZDisposeItemDescribeCunZi(String ItemName, Integer MedicalInstID);
	/**
	 * 提取所需报告单
	 * @param ItemTypeID 类型ID
	 * @param MedicalInstID 医疗机构ID
	 * @return
	 */
	public String getReport(Integer ItemTypeID, Integer MedicalInstID);
	/**
	 * 根据处置类型ID提取执行科室
	 * @param ItemTypeID 处置类型ID
	 * @return
	 */
	public Integer getZhiXingKeShi(Integer ItemTypeID);
}

