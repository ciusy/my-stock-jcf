package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.BirthDefects;

public interface YSBirthDefectsDao extends Dao<BirthDefects>{
	/**
	 * 提取出生缺陷儿登记表
	 * @param RecordID 档案号
	 * @return
	 */
	public List<BirthDefects> getBirthDefects(String RecordID);
	/**
	 * 保存出生缺陷儿登记表
	 * @param birthDefects 内容
	 * @return
	 */
	public boolean addBirthDefects(BirthDefects birthDefects);
	/**
	 * 修改出生缺陷儿登记表
	 * @param birthDefects 内容
	 * @return
	 */
	public boolean updateBirthDefects(BirthDefects birthDefects);
	
}
