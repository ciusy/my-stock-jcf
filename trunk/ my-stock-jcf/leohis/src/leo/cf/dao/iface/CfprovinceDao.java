package leo.cf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Cfprovince;

public interface CfprovinceDao extends Dao<Cfprovince>{
	/**
	 * ��ȡʡ
	 * @param ProvID ʡID
	 * @return
	 */
	public List<Cfprovince> getCfprovince(Integer ProvID);	
	/**
	 * ��ѯ����ʡ
	 * @return
	 */
	public List<Cfprovince> getCfprovinceAll();
	/**
	 * ����ʡid��ѯʡ��
	 * @param provID
	 * @return
	 */
	public String getProvinceName(Integer provID);
}
