package leo.zy.dao.impl;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.Zydischarge;
import leo.zy.dao.iface.ZydischargeDao;

public class ZydischargeDaoImpl extends DaoSupport<Zydischarge> implements ZydischargeDao {

	public boolean addZydischarge(Zydischarge zydischarge) {
		this.getHibernateTemplate().save(zydischarge);
		return true;
	}
	
	public List<Zydischarge> getZydischarge(String IPID){
		List<Zydischarge> list = this.getHibernateTemplate().find("from Zydischarge where ipid = ?",IPID);
		return list;
	}
	public boolean delZydischarge(String IPID){
		Query query = null;
		query = this.getSession().createSQLQuery("delete Zydischarge where IPID = ?");
		query.setParameter(0,IPID);
		query.executeUpdate();
		return true;
	}
	
	public boolean updatezydischarge(Zydischarge zydischarge){
		this.getHibernateTemplate().update(zydischarge);
		return true;
	}

}
