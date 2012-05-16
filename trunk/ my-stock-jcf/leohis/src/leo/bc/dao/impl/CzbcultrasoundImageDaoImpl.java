package leo.bc.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.bc.dao.iface.CzbcultrasoundImageDao;
import leo.entity.CzbcultrasoundImage;
import leo.entity.CzbcultrasoundIs;
import leo.entity.Czdispose;
public class CzbcultrasoundImageDaoImpl extends HibernateDaoSupport implements CzbcultrasoundImageDao {

	public Boolean addCzbcultrasoundImage(String reID, String PicturePath) {
		// TODO Auto-generated method stub
		long test=5;
		CzbcultrasoundImage c = new CzbcultrasoundImage();
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

	public List<CzbcultrasoundImage> GetPicturePathByReID(String reID) {
		// TODO Auto-generated method stub
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from CzbcultrasoundImage path where path.reid=:reID order by path.bid asc");
			query.setParameter("reID", reID);
		

			// query.setInteger("fnBlockID", fnBlockID);
			// query.setTimestamp("t", t);

			List<CzbcultrasoundImage> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
