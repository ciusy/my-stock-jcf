package leo.rx.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.rx.dao.iface.CzmilkGlandImageDao;
import leo.entity.CzmilkGlandImage;
import leo.entity.CzmilkGlandIs;
import leo.entity.Czdispose;
public class CzmilkGlandImageDaoImpl extends HibernateDaoSupport implements CzmilkGlandImageDao {

	public Boolean addCzmilkGlandImage(String reID, String PicturePath) {
		// TODO Auto-generated method stub
		long test=5;
		CzmilkGlandImage c = new CzmilkGlandImage();
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

	public List<CzmilkGlandImage> GetPicturePathByReID(String reID) {
		// TODO Auto-generated method stub
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from CzmilkGlandImage path where path.reid=:reID order by path.mgid asc");
			query.setParameter("reID", reID);
		

			// query.setInteger("fnBlockID", fnBlockID);
			// query.setTimestamp("t", t);

			List<CzmilkGlandImage> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
