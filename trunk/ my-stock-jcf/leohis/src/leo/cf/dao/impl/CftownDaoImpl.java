package leo.cf.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cf.dao.iface.CftownDao;
import leo.common.dao.DaoSupport;
import leo.entity.Cftown;

public class CftownDaoImpl extends DaoSupport<Cftown> implements CftownDao {

	public List<Cftown> getAllTownByPrefectureId(long prefectureId) {
		try{
			Query query = this.getSession().createQuery(
					"from Cftown c where c.prefectureId=:prefectureId");
			query.setParameter("prefectureId", prefectureId);
			List<Cftown> list = query.list();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Cftown> getTownIdByTownName(String townName) {
		try {
			Query query = this.getSession().createQuery(
					"from Cftown c where c.townName=:townName");
			query.setParameter("townName", townName);
			List<Cftown> list = query.list();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public Cftown getTownByTownId(long townId) {// 根据乡镇ID返回乡镇名称
		Query query = this.getSession().createQuery(
				"from Cftown c where c.townId =:townId");
		query.setParameter("townId", townId);
		List<Cftown> list = query.list();
		return list.get(0);

	}
	/**
	 * 根据乡镇id查询乡镇名称
	 */
	public String getTownNameBytownId(Long townId) {
		// TODO Auto-generated method stub
		try {
			Cftown town = (Cftown)super.getHibernateTemplate().get(Cftown.class, townId);
			//刘孟丽 2012-2-15 添加
			if("".equals(town.getTownName()) || town.getTownName()==null)
			{
				return "";
			}
			return town.getTownName();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String getMaxTownID(long PrefectureID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("select max(TownID) as TownID from CFTown where PrefectureID = ?");
		query.setParameter(0, PrefectureID);
		
		if (query.uniqueResult() == null)
			return "";
		else
			return query.uniqueResult().toString();
	}

	public boolean addTown(long TownID, long PrefectureID, String TownName){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("insert into CFTown(TownID,PrefectureID,TownName) values(?,?,?)");
		query.setParameter(0, TownID);
		query.setParameter(1, PrefectureID);
		query.setParameter(2, TownName);
		query.executeUpdate();
		return true;
	}
	
	public boolean delTown(long TownID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("delete from CFTown where TownID = ?");
		query.setParameter(0, TownID);
		query.executeUpdate();
		return true;
	}
	
	public boolean updateTown(long TownID, String Name){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("update CFTown set TownName = ? where TownID = ?");
		query.setParameter(0, Name);
		query.setParameter(1, TownID);
		query.executeUpdate();
		return true;
	}
	
	
}
