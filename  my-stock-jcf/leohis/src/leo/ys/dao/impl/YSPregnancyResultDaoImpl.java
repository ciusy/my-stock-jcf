package leo.ys.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import leo.common.dao.DaoSupport;
import leo.entity.PregnancyResult;
import leo.ys.dao.iface.YSPregnancyResultDao;

public class YSPregnancyResultDaoImpl extends DaoSupport<PregnancyResult> implements YSPregnancyResultDao {

	public String[][] getChuShengDuanXinRenYuan(Integer TianShu) {
		Query query = null;
		query = this.getSession().createSQLQuery("select " +
				                                 "   FamiliRecordBasicInfo.Mname, " + //0丈夫姓名
				                                 "   FamiliRecordBasicInfo.Wname, " + //1妻子姓名
				                                 "   FamiliRecordBasicInfo.Mage, " + //2丈夫年龄
				                                 "   FamiliRecordBasicInfo.Wage, " + //3妻子年龄
				                                 "   FamiliRecord.MCsID, " + //4丈夫服务对象ID
				                                 "   FamiliRecord.WCsID, " + //5妻子服务对象ID
				                                 "   (select Cellphone from CSConsumer where csid = FamiliRecord.MCsID) as zfsj, " + //6丈夫手机号 
				                                 "   (select Cellphone from CSConsumer where csid = FamiliRecord.WCsID) as qzsj, " + //7妻子手机号
				                                 "   FamiliRecord.RecordID " +//8档案号
				                                 "from " +
				                                 "   FamiliRecord,FamiliRecordBasicInfo,PregnancyResult " +
				                                 "where " +
				                                 "   FamiliRecord.RecordID = FamiliRecordBasicInfo.RecordID and " +
				                                 "   FamiliRecord.RecordID = PregnancyResult.RecordID and " +
				                                 "   PregnancyResult.DeliveryDate >= CONVERT(varchar(100), GETDATE() - ?, 23) and " +
				                                 "   PregnancyResult.DeliveryDate <= CONVERT(varchar(100), GETDATE() - ?, 23)");
		query.setParameter(0, TianShu);
		query.setParameter(1, TianShu);
		query.list();
		return listObject2StringString(query.list());
	}

	public String[][] getIDandYS(String RecordID){
		Query query = null;
		query = this.getSession().createSQLQuery("select id, Personnel, Date from PregnancyResult where RecordID = ? order by id");
		query.setParameter(0, RecordID);
		query.list();
		return listObject2StringString(query.list());
	}

	public boolean addPregnancyResult(PregnancyResult pregnancyResult){
		this.getHibernateTemplate().save(pregnancyResult);
		return true;
	}

	public boolean updatePregnancyResult(PregnancyResult pregnancyResult){
		this.update(pregnancyResult);
   		return true;
	}

	public List<PregnancyResult> getPregnancyResult(String RecordID, Integer ID){
		Session session = this.getSession();
		Query query = session.createQuery("from PregnancyResult where recordId=? and id = ?");
		query.setString(0, RecordID);
		query.setInteger(1, ID);
		return query.list();
	}
	
}
