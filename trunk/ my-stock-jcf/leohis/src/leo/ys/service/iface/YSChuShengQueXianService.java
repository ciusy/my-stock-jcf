package leo.ys.service.iface;

import java.util.List;

import leo.entity.BirthDefects;

public interface YSChuShengQueXianService {
	/**
	 * 提取出生缺陷儿登记表
	 * @param RecordID 档案号
	 * @return
	 */
	public List<BirthDefects> getChuShengQueXian(String RecordID);
	/**
	 * 保存出生缺陷儿登记表
	 * @param birthDefects 内容
	 * @return
	 */
	public boolean addChuShengQueXian(BirthDefects birthDefects);
	/**
	 * 修改出生缺陷儿登记表
	 * @param birthDefects 内容
	 * @return
	 */
	public boolean updateChuShengQueXian(BirthDefects birthDefects);
	
}
