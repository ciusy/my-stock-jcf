package leo.yf.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import leo.common.dao.DaoSupport;
import leo.entity.YfcheckRecordItem;
import leo.entity.YfexbankAitem;
import leo.yf.dao.iface.YfcheckRecordItemDao;

public class YfcheckRecordItemDaoImpl extends DaoSupport<YfcheckRecordItem> implements YfcheckRecordItemDao {
	
	public boolean addYfcheckRecordItem(List<YfcheckRecordItem> yfcheckRecordItem) {
		for (int i=0; i<yfcheckRecordItem.size(); i++){
			this.getHibernateTemplate().save(yfcheckRecordItem.get(i));
		}
		return true;
	}

	public List<YfcheckRecordItem> getYfcheckRecordItem(String DanHao){
		List<YfcheckRecordItem> list = this.getHibernateTemplate().find("from YfcheckRecordItem where checkRecordId = ?",DanHao);
		return list;
	}
	
	public boolean delYfcheckRecordItem(String DanHao){
		Query query = null;
		query = this.getSession().createSQLQuery("delete from YfcheckRecordItem where checkRecordId = ?");
		query.setParameter(0, DanHao);
		query.executeUpdate();
		return true;
	}
	/**
	 * 根据盘点记录Id查询盘点记录项
	 */
	public List<YfcheckRecordItem> getYfcheckRecordItemBycheckRecordId(
			String checkRecordId) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Query query = session.createQuery("from YfcheckRecordItem where checkRecordId=?");
		query.setString(0, checkRecordId);
		if(query.list().size() > 0){
			return query.list();
		}
		return null;
	}
}
