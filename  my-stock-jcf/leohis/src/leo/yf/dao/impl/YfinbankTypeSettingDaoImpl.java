package leo.yf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import leo.common.dao.DaoSupport;
import leo.entity.YfinbankTypeSetting;
import leo.yf.dao.iface.YfinbankTypeSettingDao;

public class YfinbankTypeSettingDaoImpl extends DaoSupport<YfinbankTypeSetting> implements YfinbankTypeSettingDao {

	public List<YfinbankTypeSetting> getYfinbankTypeSetting(Integer id, Integer PharmacyID, String TypeName) {
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (id != -2){
			tj = tj + " inbankTypeId = ?";
			cs.add(id);
		}
		if (PharmacyID != -2){
			if (tj.equals("")) 
				tj = " pharmacyId = ?";
			else
				tj = tj + " and pharmacyId = ?"; 
			cs.add(PharmacyID);
		}
		if (TypeName != null && !TypeName.equals("")){
			if (tj.equals("")) 
				tj = " typeName = ?";
			else
				tj = tj + " and typeName = ?"; 
			cs.add(TypeName);
		}
		
		List<YfinbankTypeSetting> list = null;
		
		if (tj != null && !tj.equals("")){
			list = this.getHibernateTemplate().find("from YfinbankTypeSetting where" + tj,cs.toArray());
		}
		else{	
			list = this.getHibernateTemplate().find("from YfinbankTypeSetting");
		}
		return list;

		
//		List<YfinbankTypeSetting> list;
//		list = null;
//		if (id == -2 && PharmacyID == -2)
//			list = this.getHibernateTemplate().find("from YfinbankTypeSetting");
//		else
//			if (id != -2)
//				list = this.getHibernateTemplate().find("from YfinbankTypeSetting where inbankTypeId = ?",id);
//			else
//				list = this.getHibernateTemplate().find("from YfinbankTypeSetting where pharmacyId = ?",PharmacyID);
//		return list;
		
	}

	public boolean addYfinbankTypeSetting(YfinbankTypeSetting yfinbankTypeSetting){
		this.getHibernateTemplate().save(yfinbankTypeSetting);
		return true;
	}
	
	public boolean delYfinbankTypeSetting(Integer id){
   		this.delete(id);
		return true;
	}
	
	public boolean updateYfinbankTypeSetting(YfinbankTypeSetting yfinbankTypeSetting){
   		this.update(yfinbankTypeSetting);
   		return true;
	}
	/**
	 * 根据主键查询入库类型
	 */
	public YfinbankTypeSetting getYfinbankTypeSettingByinbankTypeId(
			Integer inbankTypeId) {
		// TODO Auto-generated method stub
		return (YfinbankTypeSetting)super.getHibernateTemplate().get(YfinbankTypeSetting.class, inbankTypeId);
	}
	/**
	 * 查询所有入库类型
	 */
	public List<YfinbankTypeSetting> getYfinbankTypeSettingAll() {
		// TODO Auto-generated method stub
		try {
			return super.getHibernateTemplate().find("from YfinbankTypeSetting");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
