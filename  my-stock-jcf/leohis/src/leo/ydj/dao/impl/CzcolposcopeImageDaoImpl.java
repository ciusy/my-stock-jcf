package leo.ydj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.ydj.dao.iface.CzcolposcopeImageDao;
import leo.entity.CzcolposcopeImage;
import leo.entity.CzcolposcopeIs;
import leo.entity.Czdispose;
public class CzcolposcopeImageDaoImpl extends HibernateDaoSupport implements CzcolposcopeImageDao {

	public Boolean addCzcolposcopeImage(String reID, String PicturePath) {
		// TODO Auto-generated method stub
		long test=5;
		CzcolposcopeImage c = new CzcolposcopeImage();
		c.setReid(reID);
		c.setPictureWay(PicturePath);
		try {
			super.getHibernateTemplate().save(c);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<CzcolposcopeImage> GetPicturePathByReID(String reID) {
		// TODO Auto-generated method stub
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from CzcolposcopeImage path where path.reid=:reID order by path.mgid asc");
			query.setParameter("reID", reID);
		

			// query.setInteger("fnBlockID", fnBlockID);
			// query.setTimestamp("t", t);

			List<CzcolposcopeImage> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
