package leo.cf.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cf.dao.iface.CfcityDao;
import leo.common.dao.DaoSupport;
import leo.entity.Cfcity;
import leo.entity.Cfprovince;
import leo.entity.Yfaitem;
import leo.entity.YfinbankAitem;
import leo.entity.Yfminfo;

//public class CfcityDaoImpl extends HibernateDaoSupport implements CfcityDao {
public class CfcityDaoImpl extends DaoSupport<Cfcity> implements CfcityDao {
		
	public Cfcity getcityBycityID(long cityId) {
		Query query=this.getSession().createQuery("from Cfcity c where c.cityId =:cityId");
		query.setLong("cityId", cityId);
		List<Cfcity>  list =query.list();
		return list.get(0);
	}
	
	public List<Cfcity> getCfcityByProvNameID(Integer ProvNameID){
		List<Cfcity> list = this.getHibernateTemplate().find(
				"from Cfcity where provNameId = ?", ProvNameID);
		return list;
	}
	
	public String getcityName(Integer CityID){
		try {
			Cfcity city = (Cfcity)super.getHibernateTemplate().get(Cfcity.class, CityID);
			return city.getCityName();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
}
