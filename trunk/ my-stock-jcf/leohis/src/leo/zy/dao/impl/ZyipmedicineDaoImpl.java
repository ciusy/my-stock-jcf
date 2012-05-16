package leo.zy.dao.impl;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.Zyipmedicine;
import leo.zy.dao.iface.ZyipmedicineDao;

public class ZyipmedicineDaoImpl extends DaoSupport<Zyipmedicine> implements ZyipmedicineDao {

	public boolean addZyipmedicine(List<Zyipmedicine> zyipmedicine) {
		for (int i = 0; i < zyipmedicine.size(); i++) {
			this.getHibernateTemplate().save(zyipmedicine.get(i));
		}
		return true;
	}

	public boolean updateZyipmedicine(Zyipmedicine zyipmedicine){
		this.update(zyipmedicine);
		return true;
	}

	public boolean deleteZyipmedicine(Long DAItemID){
		Query query = null;
		query = this.getSession().createSQLQuery(
				"delete from ZYIPMedicine where DAItemID = ?");
		query.setParameter(0, DAItemID);
		query.executeUpdate();
		return true;
	}

	public boolean updateZyipmedicineNum(Long DAItemID, Integer Num){
		Query query = null;
		query = this.getSession().createSQLQuery(
				"update ZYIPMedicine set num = num + ? where DAItemID = ?");
		query.setParameter(0, Num);
		query.setParameter(1, DAItemID);
		query.executeUpdate();
		return true;
	}
	
	public String getYiZhuXiangID(String DAID, Integer MInfoID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("select DAItemID from ZYIPMedicine where DAID = ? and MInfoID = ?");
		query.setParameter(0, DAID);
		query.setParameter(1, MInfoID);
		if (query.list().size() < 1)
			return "-1";
		else
			return query.list().get(0).toString();
		
	}

}
