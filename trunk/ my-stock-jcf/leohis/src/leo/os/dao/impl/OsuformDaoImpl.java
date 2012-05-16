package leo.os.dao.impl;

import java.util.Iterator;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.MzopDn;
import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;
import leo.os.dao.iface.OsuformDao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OsuformDaoImpl extends DaoSupport<Osuform> implements OsuformDao {

	public Osuform getUformByUid(int uid) {
		try {
			Query query = this.getSession().createQuery("from Osuform u where u.uid=:uid");
			query.setLong("uid", uid);
			List<Osuform> list = query.list();
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Osuform> getRegestUFormByMid(int mid) {
		try {
			Query query = this.getSession().createQuery("from Osuform u where u.meiid=:mid and u.registerableUnitOrNot=true");
			query.setLong("mid", mid);
			List<Osuform> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String[] getUformByRidAndMid(int rtId, int mid) {
		try {
			Query query = this
					.getSession()
					.createQuery(
							"select ou.uid,ou.uname from Osuform ou,GhregisterType gt where ou.uid=gt.uid and gt.rtid=:rtid and ou.meiid=:mid");
			query.setInteger("rtid", rtId);
			query.setInteger("mid", mid);
			List<Object[]> list = query.list();
			Iterator<Object[]> it = list.iterator();
			String[] str = new String[2];
			Object[] results = null;
			while (it.hasNext()) {
				results = (Object[]) it.next();
				str[0] = results[0].toString();
				str[1] = (String) results[1];
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getUNameByUid(int uid) {
		try {
			Osuform osuform = (Osuform) this.getHibernateTemplate().get(Osuform.class, uid);
			if (osuform != null)
				return osuform.getUname();
			return "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public Osuform getOsuformByUid(int uid) {
		try {
			Osuform osuform = (Osuform) this.getHibernateTemplate().get(Osuform.class, uid);
			if (osuform != null)
				return osuform;
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Osuform> getRegisterDivaricateUByMid(int mid) {
		try {
			Query query = this.getSession().createQuery("from Osuform u where u.meiid=:mid and u.otype='挂号'");
			query.setLong("mid", mid);
			List<Osuform> list = query.list();
			if (list.size() != 0)
				return list;
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String[][] getUformByOTypeAndMid(String oType, int mid) {
		try {
			Query query = null;
			if (oType == null || oType.equals("")) {
				query = this.getSession().createQuery("select ou.uid,ou.uname from Osuform ou where ou.meiid=?");
				query.setParameter(0, mid);
			} else {
				query = this.getSession().createQuery("select ou.uid,ou.uname from Osuform ou where ou.otype =? and ou.meiid=?");
				query.setParameter(0, oType);
				query.setParameter(1, mid);
			}
			return listObject2StringString(query.list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getUidByUName(int mid, String uname) {
		try {
			Query query = this.getSession().createQuery("select ou.uid from Osuform ou where ou.uname=? and ou.meiid =?");
			query.setParameter(0, uname);
			query.setParameter(1, mid);
			List<Object[]> list = query.list();
			if (list.size() != 0) {
				Object hel = list.get(0);
				return (Integer) hel;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public String[][] getUidBySidAndOType(int sid, String[] otypename) {

		String[][] uinfo = new String[otypename.length][2];
		int i;
		for (i = 0; i < otypename.length; i++) {
			uinfo[i][0] = "-1";
			uinfo[i][1] = "";
		}
		try {
			for (i = 0; i < otypename.length; i++) {
				String sql = "select ou.uid,ou.uname" + " from Osuform ou,OsunitHasS oh" + " where ou.uid=oh.unitId"
						+ " and oh.sid=" + sid + " and ou.otype='" + otypename[i] + "'";
				Query query = this.getSession().createSQLQuery(sql);
				Object[] result = null;
				if (query.list().size() != 0) {
					result = (Object[]) query.list().get(0);
					uinfo[i][0] = result[0].toString();
					uinfo[i][1] = result[1].toString();
				}
			}
			return uinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uinfo;
	}

	/**
	 * 根据医疗机构和科室类型查询科室
	 */
	public List<Osuform> getOsuformByMEIIDandOType(int meiId, String oType) {
		List<Osuform> list;
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery("from Osuform where meiid=? and otype=?");
		query.setParameter(0, meiId);
		query.setParameter(1, oType);
		list = query.list();
		return list;
	}

	public List<Osuform> getOsuformsByIds(List<Integer> osUFormIds) {

		return getSession().createQuery("from Osuform o where o.uid in (:osUFormIds)").setParameterList("osUFormIds", osUFormIds)
				.list();
	}

	public String[][] getUformNotType(String oType, int mid) {
		try {
			Query query = null;
			query = this.getSession().createQuery("select ou.uid,ou.uname from Osuform ou where ou.meiid=? and ou.otype <>?");
			query.setParameter(0, mid);
			query.setParameter(1, oType);
			return listObject2StringString(query.list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Osuform> getUFormByMid(Integer mid) {
		Query query = this.getSession().createQuery("from Osuform u where u.meiid=:mid");
		query.setLong("mid", mid);
		if(query.list().size()>0)
		{
		return query.list();
	    }else{
	    return null;	
	    }
	}
	
	public boolean addUForm(Osuform osuform){
		try{
		this.getHibernateTemplate().save(osuform);
		return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateUForm(Osuform osuform){
		this.getHibernateTemplate().update(osuform);
		return true;
	}
	public boolean deleteUForm(Osuform osuform){
		try{
		this.getHibernateTemplate().delete(osuform);
		return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delUformByID(Integer ID){
		Query query = null;
		query = this.getSession().createSQLQuery("delete from OSUForm where UID = ?");
		query.setParameter(0, ID);
		query.executeUpdate();
		return true;
	}
	public boolean updateUformByID(Integer ID){
		
		return true;
	}
	
}
