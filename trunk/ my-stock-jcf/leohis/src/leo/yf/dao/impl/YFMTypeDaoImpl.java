package leo.yf.dao.impl;

import java.util.List;
import org.hibernate.Query;
import leo.common.dao.DaoSupport;
import leo.entity.Yfmtype;
import leo.yf.dao.iface.YFMTypeDao;

public class YFMTypeDaoImpl extends DaoSupport<Yfmtype> implements YFMTypeDao {

	public List<Yfmtype> getYFMType() {
		List<Yfmtype> list = this.getHibernateTemplate().find("from Yfmtype");
		return list;
	}
	
	public Boolean addYFMType(Yfmtype yfmtype){
		this.getHibernateTemplate().save(yfmtype);
		return true;
	}
	
	public Boolean delTFMType(String mtype){
		Query query = null;
		if (mtype != null && !mtype.equals("")){
			query = this.getSession().createSQLQuery("delete from YFMType where MType = ?");
			query.setParameter(0, mtype);
		}
		else
			query = this.getSession().createSQLQuery("delete from YFMType");
		query.executeUpdate();
   		return true;
	}
	
	

}
