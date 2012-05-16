package leo.cf.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cf.dao.iface.CfprefectureDao;
import leo.entity.Cfcity;
import leo.entity.Cfprefecture;

public class CfprefectureDaoImpl extends HibernateDaoSupport implements
		CfprefectureDao {

	public Cfprefecture getPrefectureIdByPrefectureName(String prefectureName) {
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from Cfprefecture p where p.prefectureName=:prefectureName");
			query.setParameter("prefectureName", prefectureName);
			List<Cfprefecture> list = query.list();
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Cfprefecture> getPrefectureByCityID(long cityId) {
		Query query = this.getSession().createQuery(
				"from Cfprefecture c where c.cityId =:cityId");
		query.setLong("cityId", cityId);
		List<Cfprefecture> list = query.list();

		return list;
	}

	public List<Cfprefecture> getPrefectureIdByCityID(long cityId) {
		try {
			Query query = this.getSession().createQuery(
					"from Cfprefecture p where p.cityId=：cityId");
			query.setLong("cityId", cityId);
			List<Cfprefecture> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	public Cfprefecture getPrefectureByPrefectureID(long prefectureId) {
		Query query = this.getSession().createQuery(
				"from Cfprefecture p where p.prefectureId=:prefectureId");
		query.setParameter("prefectureId", prefectureId);
		List<Cfprefecture> list = query.list();
		return list.get(0);

	}

	/**
	  * 根据县id查询县名
	  */
	public String getPrefectureByprefectureId(Long prefectureId) {
		// TODO Auto-generated method stub
		try {
			Cfprefecture prefecture = (Cfprefecture)super.getHibernateTemplate().get(Cfprefecture.class, prefectureId);
			//刘孟丽 2012-2-15 添加
			if("".equals(prefecture.getPrefectureName()) || prefecture.getPrefectureName()==null)
			{
				return "";
			}
			return prefecture.getPrefectureName();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
