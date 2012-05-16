package leo.cf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Cfprovince;

public interface CfprovinceDao extends Dao<Cfprovince>{
	/**
	 * 提取省
	 * @param ProvID 省ID
	 * @return
	 */
	public List<Cfprovince> getCfprovince(Integer ProvID);	
	/**
	 * 查询所有省
	 * @return
	 */
	public List<Cfprovince> getCfprovinceAll();
	/**
	 * 根据省id查询省名
	 * @param provID
	 * @return
	 */
	public String getProvinceName(Integer provID);
}
