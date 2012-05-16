package leo.cs.dao.impl;

import leo.cs.dao.iface.CsheadShowDao;
import leo.entity.CsheadShow;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CsheadShowDaoImpl extends HibernateDaoSupport implements
		CsheadShowDao {

	public boolean addCsheadShow(CsheadShow csheadShow) {
		this.getHibernateTemplate().save(csheadShow);
		return true;
	}

	public boolean delCsheadShow(CsheadShow csheadShow) {
		try{
			this.getHibernateTemplate().delete(csheadShow);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public String getCsheadShowById(long id) {
		try{
			CsheadShow csheadShow = (CsheadShow)this.getHibernateTemplate().get(CsheadShow.class, id);
			if(csheadShow != null){
				return csheadShow.getHeadShow();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public boolean updateCsheadShow(CsheadShow csheadShow) {
		try{
			this.getHibernateTemplate().update(csheadShow);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
