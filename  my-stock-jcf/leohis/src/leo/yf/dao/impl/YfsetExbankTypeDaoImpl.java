package leo.yf.dao.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;

import leo.common.dao.DaoSupport;
import leo.entity.Yfmtype;
import leo.entity.YfmwayTo;
import leo.entity.YfsetExbankType;
import leo.yf.dao.iface.YfsetExbankTypeDao;

public class YfsetExbankTypeDaoImpl extends DaoSupport<YfsetExbankType> implements YfsetExbankTypeDao {

	public boolean addYfsetExbankType(YfsetExbankType yfsetExbankType) {
		try{
			this.getHibernateTemplate().save(yfsetExbankType);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public List<YfsetExbankType> getYfsetExbankType(Integer ExbankID, Integer PharmacyID, String ETypeName){
		List<YfsetExbankType> list;
		list = null;
		if (ExbankID == -2){ //出库类型ID
			list = this.getHibernateTemplate().find("from YfsetExbankType where ETypeName = ? and pharmacyId = ?",new Object[]{ETypeName,PharmacyID});
		}
		else{
			list = this.getHibernateTemplate().find("from YfsetExbankType where exbankId = ? and pharmacyId = ?",new Object[]{ExbankID,PharmacyID});
		}
		return list;
	}
	
	public String getChuKuLeiXingName(Integer ExbankID){
		Query query = null; // 生明一个查询对象
		List<String> list;
		query = this.getSession().createSQLQuery("select ETypeName from YFSetExbankType where ExbankID = ?");
		query.setInteger(0, ExbankID);
		list = query.list();
		return list.get(0);		
	}
	
	public Double getRuChuJiaGeBi(String LeiXing, Integer YaoFangID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery("select inExbankP from YfsetExbankType where etypeName = ? and pharmacyId = ?");
		query.setParameter(0, LeiXing);
		query.setParameter(1, YaoFangID);
		List<Double> list = query.list(); //(List<Double>) 
		if (list.size() < 1)
			return -1d;
		else
			return list.get(0);
	}
	public boolean updateYFSetExbankType(YfsetExbankType yfsetExbankType){
   		this.update(yfsetExbankType);
   		return true;
	}
	/**
	 * 查询所有出库类型
	 */
	public List<YfsetExbankType> getYfsetExbankTypeAll() {
		// TODO Auto-generated method stub
		try {
			return super.getHibernateTemplate().find("from YfsetExbankType");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
