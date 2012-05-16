package leo.yf.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.Yfmmanufacturer;
import leo.yf.dao.iface.YfmmanufacturerDao;

import org.hibernate.Query;

public class YfmmanufacturerDaoImpl extends DaoSupport<Yfmmanufacturer>
		implements YfmmanufacturerDao {

	public List<Yfmmanufacturer> getYfmmanufacturer(String name) {
		List<Yfmmanufacturer> list;
		list = null;

		if ((name == null) || (name == ""))
			list = this.getHibernateTemplate().find("from Yfmmanufacturer");
		else {
			list = this.getHibernateTemplate().find(
					"from Yfmmanufacturer where manufacturer=?", name);
		}
		return list;
	}

	public Boolean addYfmmanufacturer(Yfmmanufacturer yfmmanufacturer) {
		this.getHibernateTemplate().save(yfmmanufacturer);
		return true;
	}

	public Boolean delYfmmanufacturer(String manufacturer) {
		Query query = null;
		if (manufacturer != null && !manufacturer.equals("")){
			query = this.getSession().createSQLQuery("delete from YFMManufacturer where Manufacturer = ?");
			query.setParameter(0, manufacturer);
		}
		else
			query = this.getSession().createSQLQuery("delete from YFMManufacturer");
		query.executeUpdate();
		return true;
	}

}
