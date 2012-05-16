package leo.zy.dao.impl;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.Zyipteatment;
import leo.zy.dao.iface.ZyipteatmentDao;

public class ZyipteatmentDaoImpl extends DaoSupport<Zyipteatment> implements ZyipteatmentDao {
	private ZyipteatmentDao zyipteatmentDao;
	
	
	public void setZyipteatmentDao(ZyipteatmentDao zyipteatmentDao) {
		this.zyipteatmentDao = zyipteatmentDao;
	}

	public boolean addZyipteatment(List<Zyipteatment> zyipteatment) {
		for (int i = 0; i < zyipteatment.size(); i++) {
			this.getHibernateTemplate().save(zyipteatment.get(i));
		}
		return true;
	}

	public boolean updateZyipteatmentItemID(String[][] IDS){
		Query query = null;
		for (int i=0; i<IDS.length; i++){
			query = this.getSession().createSQLQuery("update ZYIPTeatment set ItemID = ? where DAItemID = ?");
			query.setParameter(0, IDS[i][1]);
			query.setParameter(1, IDS[i][0]);
			query.executeUpdate();
		}
		return true;
	}

	public boolean getChuZhiBuFenZhiXing(String YiZhuHao){
		Query query = null;
		query = this.getSession().createSQLQuery("select " +
				                                 "   CZDispose.ItemID " +
				                                 "from " +
				                                 "   ZYIPTeatment,CZDispose " +
				                                 "where " +
				                                 "   ZYIPTeatment.ItemID = CZDispose.ItemID and " +
				                                 "   ZYIPTeatment.DAID = ? and " +
				                                 "   CZDispose.Status = 'ÒÑÖ´ÐÐ'");
		query.setParameter(0, YiZhuHao);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return false;
		else
			return true;
	}

	public boolean updateZyipteatmentAContent(String ShenQingNeiRong, Long DAItemID){
		Query query = null;
		query = this.getSession().createSQLQuery("update ZYIPTeatment set AContent = ? where DAItemID = ?");
		query.setParameter(0, ShenQingNeiRong);
		query.setParameter(1, DAItemID);
		query.executeUpdate();
		return true;
	}

	public boolean updateZyipteatmentXiangMu(Integer ItemTypeID, Integer ExecuteU, Long DAItemID){
		Query query = null;
		query = this.getSession().createSQLQuery("update ZYIPTeatment set ItemTypeID = ?, ExecuteU = ? where DAItemID = ?");
		query.setParameter(0, ItemTypeID);
		query.setParameter(1, ExecuteU);
		query.setParameter(2, DAItemID);
		query.executeUpdate();
		return true;
	}
	
	public boolean delZYIPTeatment(Long DAItemID){
		Query query = null;
		query = this.getSession().createSQLQuery(
				"delete from ZYIPTeatment where DAItemID = ?");
		query.setParameter(0, DAItemID);
		query.executeUpdate();
		return true;
	}
}
