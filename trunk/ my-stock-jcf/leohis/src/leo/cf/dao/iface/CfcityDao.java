package leo.cf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Cfcity;
import leo.entity.Yfaitem;

//public interface CfcityDao {
public interface CfcityDao extends Dao<Cfcity>{

	public Cfcity getcityBycityID(long cityId);
/**
 * 根据省提取高
 * @param ProvNameID 省ID
 * @return
 */
	public List<Cfcity> getCfcityByProvNameID(Integer ProvNameID);
	/**
	 * 根据市ID提取市名
	 * @param CityID 市ID
	 * @return
	 */
	public String getcityName(Integer CityID);
	
}
