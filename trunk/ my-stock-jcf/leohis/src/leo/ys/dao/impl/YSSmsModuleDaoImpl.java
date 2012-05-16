package leo.ys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.SmsModule;
import leo.ys.dao.iface.YSSmsModuleDao;

public class YSSmsModuleDaoImpl extends DaoSupport<SmsModule> implements YSSmsModuleDao {

	public Long addSmsModule(SmsModule smsModule) {
		this.getHibernateTemplate().save(smsModule);
		return smsModule.getModuleId();
	}

	public List<SmsModule> getSmsModule(String PointName, Long AffiliationID){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (PointName != null && !PointName.equals("")) {
			tj = " pointName = ?";
			cs.add(PointName);
		}

		if (AffiliationID != -2) {
			if (tj.equals(""))
				tj = " affiliationId = ?";
			else
				tj = tj + " and affiliationId = ?";
			cs.add(AffiliationID);
		}

		List<SmsModule> list = null;

		if (tj != null && !tj.equals("")) {
			list = this.getHibernateTemplate().find(
					"from SmsModule where" + tj, cs.toArray());
		} else {
			list = this.getHibernateTemplate().find("from SmsModule");
		}
		return list;
	}

	public boolean updateSmsModule(SmsModule smsModule){
		this.getHibernateTemplate().update(smsModule);		
		return true;
	}
	
	public boolean delSmsModule(Long ModuleID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("delete from SmsModule where ModuleID = ?");
		query.setParameter(0, ModuleID);
		query.executeUpdate();
		return true;
	}

	public String[][] getMoBanMingCheng(Long AffiliationID){
		Query query = null;
		query = this.getSession().createSQLQuery("select ModuleName, ModuleID from SmsModule where AffiliationID = ?");
		query.setParameter(0, AffiliationID);
		query.list();
		return listObject2StringString(query.list());
	}
	
}
