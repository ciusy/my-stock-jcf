package leo.ys.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import leo.common.dao.DaoSupport;
import leo.entity.BirthDefects;
import leo.ys.dao.iface.YSBirthDefectsDao;

public class YSBirthDefectsDaoImpl extends DaoSupport<BirthDefects> implements YSBirthDefectsDao {

	public List<BirthDefects> getBirthDefects(String RecordID) {
		Session session = this.getSession();
		Query query = session.createQuery("from BirthDefects where recordId=?");
		query.setString(0, RecordID);
		return query.list();
	}
	
	public boolean addBirthDefects(BirthDefects birthDefects){
		this.getHibernateTemplate().save(birthDefects);
		return true;
	}

	public boolean updateBirthDefects(BirthDefects birthDefects){
		this.update(birthDefects);
   		return true;
	}
	
}
