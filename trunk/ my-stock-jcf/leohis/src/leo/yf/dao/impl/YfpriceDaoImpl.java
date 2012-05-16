package leo.yf.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.Yfprice;
import leo.yf.dao.iface.YfpriceDao;

import org.hibernate.Query;

public class YfpriceDaoImpl extends DaoSupport<Yfprice> implements YfpriceDao {

	public List<Yfprice> getYfprice(String ExbankType, Integer MInfoID,
			Integer MedicalInstID) {

		List<Yfprice> list;
		list = null;
		if (ExbankType.equals("") || ExbankType == null){
			list = this.getHibernateTemplate().find("from Yfprice where minfoId = ? and medicalInstId = ?",new Object[]{MInfoID,MedicalInstID});
		}
		else{
			list = this.getHibernateTemplate().find("from Yfprice where exbankType = ? and minfoId = ? and medicalInstId = ?",new Object[]{ExbankType,MInfoID,MedicalInstID});
		}
		return list;
	}
	
	public boolean addYfprice(Yfprice yfprice){
		this.getHibernateTemplate().save(yfprice);
		return true;
	}
	
	public Long getmaxID(){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery(
				"select a.pid from Yfprice a order by a.pid desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Long> list = (List<Long>) query.list();
		if (list.size() < 1)
			return -1L;
		else
			return list.get(0);
	}
	
	public Long getCuiZai(String cklx, Integer ypID, Integer yljgID){
		Query query = null; // 生明一个查询对象
		List<Long> list;
		query = this.getSession().createQuery("select pid from Yfprice where exbankType = ? and minfoId = ? and medicalInstId = ?");
		query.setParameter(0, cklx);
		query.setParameter(1, ypID);
		query.setParameter(2, yljgID);
		list = query.list();
		if (list.size() > 0)
			return list.get(0);
		else
			return -1L;
	}
	
	public boolean updateJiaGe(String cklx, Integer ypID, Integer yljgID, Double je){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("update YFPrice set ExbankP = ? where ExbankType = ? and MInfoID = ? and MedicalInstID = ?");
		query.setParameter(0, je);
		query.setParameter(1, cklx);
		query.setParameter(2, ypID);
		query.setParameter(3, yljgID);
		query.executeUpdate();
		return true;
	}
}
