package leo.mz.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.CzdisposalType;

public interface CzdisposalTypeDao extends Dao<CzdisposalType>{
	/**
	 * 保存处置类别
	 * @param czdisposalType 处置类别
	 * @return
	 */
	public boolean addCzdisposalType(CzdisposalType czdisposalType);
	/**
	 * 删除处置类别
	 * @param disposeItemType 类别名称
	 * @return
	 */
	public boolean delCzdisposalType(String disposeItemType);
	/**
	 * 提取类别
	 * @return
	 */
	public List<CzdisposalType> getCzdisposalType();

}
