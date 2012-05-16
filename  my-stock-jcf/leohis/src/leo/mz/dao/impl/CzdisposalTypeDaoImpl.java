package leo.mz.dao.impl;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.CzdisposalType;
import leo.entity.Yfaitem;
import leo.mz.dao.iface.CzdisposalTypeDao;

public class CzdisposalTypeDaoImpl extends DaoSupport<CzdisposalType> implements CzdisposalTypeDao {

	public boolean addCzdisposalType(CzdisposalType czdisposalType) {
		this.getHibernateTemplate().save(czdisposalType);
		return true;
	}

	public boolean delCzdisposalType(String disposeItemType){
		Query query = null;
		if (disposeItemType != null && !disposeItemType.equals("")){
			query = this.getSession().createSQLQuery("delete from CzdisposalType where disposeItemType = ?");
			query.setParameter(0, disposeItemType);
		}
		else{
			query = this.getSession().createSQLQuery("delete from CzdisposalType");
		}
		query.executeUpdate();
		return true;
	}
	
	public List<CzdisposalType> getCzdisposalType(){
		List<CzdisposalType> list = this.getHibernateTemplate().find("from CzdisposalType");
		return list;
	}
	
}
