package leo.zy.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.Zymadministration;
import leo.zy.dao.iface.ZymadministrationDao;

public class ZymadministrationDaoImpl extends DaoSupport<Zymadministration> implements ZymadministrationDao {

	public List<Zymadministration> getZymadministration() {
		List<Zymadministration> list = this.getHibernateTemplate().find("from Zymadministration");
		return list;
	}
}
