package leo.cf.dao.impl;

import java.util.List;

import leo.cf.dao.iface.CfgroupDao;
import leo.entity.Cfgroup;
import leo.entity.Cfvillage;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CfgroupDaoImpl extends HibernateDaoSupport implements CfgroupDao {
	public List<Cfgroup> getAllCfgroupsByVilleageId(long villageId) {
		try{
			Query query=this.getSession().createQuery("from Cfgroup c where c.villageId=:villageId");
			query.setParameter("villageId", villageId);
			List<Cfgroup> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Cfgroup getCfgroupByCfgroupId(long groupId) {
		try{
			Query query=this.getSession().createQuery("from Cfgroup c where c.groupId=:groupId");
			query.setParameter("groupId", groupId);
			List<Cfgroup> list=query.list();
			return list.get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delCFGroup(long VillageID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("delete CFGroup where VillageID = ?");
		query.setParameter(0, VillageID);
		query.executeUpdate();
		return true;
		
	}
	
}
