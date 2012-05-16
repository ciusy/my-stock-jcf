package leo.cf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Cfcity;
import leo.entity.Yfaitem;

//public interface CfcityDao {
public interface CfcityDao extends Dao<Cfcity>{

	public Cfcity getcityBycityID(long cityId);
/**
 * ����ʡ��ȡ��
 * @param ProvNameID ʡID
 * @return
 */
	public List<Cfcity> getCfcityByProvNameID(Integer ProvNameID);
	/**
	 * ������ID��ȡ����
	 * @param CityID ��ID
	 * @return
	 */
	public String getcityName(Integer CityID);
	
}
