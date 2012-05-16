package leo.cs.dao.impl;

import java.util.List;

import leo.cs.dao.iface.CsmedicalCardDao;
import leo.entity.CsmedicalCard;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CsmedicalCardDaoImpl extends HibernateDaoSupport implements CsmedicalCardDao {

	public CsmedicalCard getCsmedicalCardByCsid(long csId) {
		try {
			Query query = this.getSession().createQuery("from CsmedicalCard c  where c.csId=:csId and c.startUsingOrNot=true");
			query.setLong("csId", csId);
			List<CsmedicalCard> list = query.list();
			if (list.size() != 0) {
				return list.get(0);
			}
			return null;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean addCsmedicalCard(CsmedicalCard csmedicalCard) {
		try {
			this.getHibernateTemplate().save(csmedicalCard);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean updateCsmedicalCard(CsmedicalCard csmedicalCard) {
		try {
			this.getHibernateTemplate().update(csmedicalCard);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public CsmedicalCard getCsmedicalCardOnlyByCsid(long csid) {
		try {
			Query query = this.getSession().createQuery("from CsmedicalCard c  where c.csId=:csId ");
			query.setLong("csId", csid);
			List<CsmedicalCard> list = query.list();
			if (list.size() != 0) {
				return list.get(0);
			}
			return null;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public long getCsIDByMedicalCardNum(String medicalCardNum) {
		try {
			Query query = this.getSession().createQuery("select cc.csId from CsmedicalCard cc where cc.medicalCardNum=?");
			query.setParameter(0, medicalCardNum);
			List<Object[]> list = query.list();
			if(list.size()!=0){
			Object hel = list.get(0);
			return (Long) hel;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public List<CsmedicalCard> getCsmedicalCardByCsids(List<Long> csIds) {

		Query query = this.getSession().createQuery("from CsmedicalCard c  where c.csId in (:csIds) and c.startUsingOrNot=true");
		query.setParameterList("csIds", csIds);
		List<CsmedicalCard> list = query.list();
		return list;
	}

}
