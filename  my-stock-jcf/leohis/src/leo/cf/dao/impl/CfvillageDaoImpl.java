package leo.cf.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cf.dao.iface.CfvillageDao;
import leo.entity.Cftown;
import leo.entity.Cfvillage;

public class CfvillageDaoImpl extends HibernateDaoSupport implements CfvillageDao {

	public List<Cfvillage> getAllVilleagesByTownId(long townId) {
		try{
			Query query=this.getSession().createQuery("from Cfvillage c where c.townId=:townId");
			query.setParameter("townId", townId);
			List<Cfvillage>  list=query.list();
			return list;
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	public List<Cfvillage> getVillageIdByVillageName(String villageName) {
		try{
			Query query =this.getSession().createQuery("from Cfvillage c where c.villageName=:villageName");
			query.setParameter("villageName", villageName);
			List<Cfvillage> list=query.list();
			return list;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Cfvillage getVillageByVillageId(long villageId) {
		try{
			Query query=this.getSession().createQuery("from Cfvillage c where c.villageId=:villageId");
			query.setParameter("villageId", villageId);
			List<Cfvillage>  list=query.list();
			return list.get(0);
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	/**
	 * 根据村id查询村名
	 */
	public String getVillageNameByvillageId(Long villageId) {
		// TODO Auto-generated method stub
		try {
			Cfvillage village = (Cfvillage)super.getHibernateTemplate().get(Cfvillage.class, villageId);
			//刘孟丽 2012-2-15 添加
			if("".equals(village.getVillageName()) || village.getVillageName()==null)
			{
				return "";
			}
			return village.getVillageName();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String getMaxID(long TownID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("select max(VillageID) from CFVillage where TownID = ?");
		query.setParameter(0, TownID);
		if (query.uniqueResult() == null)
			return "";
		else
			return query.uniqueResult().toString();
	}
	
	public boolean addVillage(long VillageID, long TownID, String VillageName){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("insert into CFVillage(VillageID,TownID,VillageName) values(?,?,?)");
		query.setParameter(0, VillageID);
		query.setParameter(1, TownID);
		query.setParameter(2, VillageName);
		query.executeUpdate();
		return true;
	}
	
	public boolean delVillage(long TownID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("delete CFVillage where TownID = ?");
		query.setParameter(0, TownID);
		query.executeUpdate();
		return true;
	}

	public boolean delVillageByVillageID(long VillageID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("delete CFVillage where VillageID = ?");
		query.setParameter(0, VillageID);
		query.executeUpdate();
		return true;
	}

	public boolean updateVillage(long VillageID, String name){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("update CFVillage set VillageName = ? where VillageID = ?");
		query.setParameter(0, name);
		query.setParameter(1, VillageID);
		query.executeUpdate();
		return true;
	}
	
}
