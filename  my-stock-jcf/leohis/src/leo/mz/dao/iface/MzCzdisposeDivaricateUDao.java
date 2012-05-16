package leo.mz.dao.iface;

import java.util.List;

import leo.entity.CzdisposeDivaricateU;

public interface MzCzdisposeDivaricateUDao {
	/**
	 * 
	 * 根据项目ID查询开出科室对象
	 * 
	 * @param ID
	 *            
	 * @return CzdisposeDivaricateU
	 */
	public CzdisposeDivaricateU getCzdById(Long id);
	
	/**
	 * 
	 * 添加
	 * 
	 * @param CzdisposeDivaricateU 对象
	 *            
	 * @return 
	 */
	public void addCzdisposeDivaricateU(CzdisposeDivaricateU c);
	
	/**
	 * 
	 * 删除
	 * 
	 * @param ID
	 *            
	 * @return 
	 */
	public void deleCzdisposeDivaricateU(Long id);
	
	/**
	 * 
	 * 更新CzdisposeDivaricateU
	 * 
	 * @param CzdisposeDivaricateU 对象
	 *            
	 * @return 
	 */
	
	public void updateCzdisposeDivaricateU(CzdisposeDivaricateU c);
	
	/**
	 * 
	 * 根据ItemTypeID查询
	 * 
	 * @param ItemTypeID
	 *            
	 * @return updateCzdisposeDivaricateU集合
	 */
	public List<CzdisposeDivaricateU> getCzdisposeDivaricateUList(Integer id);
	
	/**
	 * 
	 * 根据ID删除updateCzdisposeDivaricateU对象
	 * 
	 * @param itemTypeId
	 *            
	 * @return 
	 */
	public void deleCzdisposeDivaricateUByitemTypeId(Integer id);
}
