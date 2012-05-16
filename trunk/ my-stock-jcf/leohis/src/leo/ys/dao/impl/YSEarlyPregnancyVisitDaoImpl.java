package leo.ys.dao.impl;

import leo.common.dao.DaoSupport;
import leo.entity.EarlyPregnancyVisit;
import leo.ys.dao.iface.YSEarlyPregnancyVisitDao;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
/**
 * 早孕随访记录Dao接口实现
 * @author abc
 *
 */
public class YSEarlyPregnancyVisitDaoImpl extends DaoSupport<EarlyPregnancyVisit> implements YSEarlyPregnancyVisitDao {
	/**
	 * 添加随访记录
	 */
	public boolean addEarlyPregnancyVisit(EarlyPregnancyVisit early) {
		// TODO Auto-generated method stub
		try {
			super.getHibernateTemplate().save(early);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw e;
		}		
	}
	/**
	 * 根据主键查询随访记录
	 */
	public EarlyPregnancyVisit getEarlyPregnancyVisitByrecordId(String recordId) {
		// TODO Auto-generated method stub
		EarlyPregnancyVisit early = null;
		
		try {
			early = (EarlyPregnancyVisit)super.getHibernateTemplate().get(EarlyPregnancyVisit.class, recordId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			super.getSession().close();
			throw e;
		}		
		return early;
	}
	/**
	 * 修改随访记录
	 */
	public boolean updateEarlyPregnancyVisit(EarlyPregnancyVisit early) {
		try {
			super.getHibernateTemplate().update(early);
			return true;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public String[][] getHuaiYunDuanXinRenYuan(Integer TianShu){
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
				                                 "   FamiliRecord,FamiliRecordBasicInfo,EarlyPregnancyVisit " +
				                                 "where " +
				                                 "   FamiliRecord.RecordID = FamiliRecordBasicInfo.RecordID and " +
				                                 "   FamiliRecord.RecordID = EarlyPregnancyVisit.RecordID and " +
				                                 "   EarlyPregnancyVisit.Menstrualdate >= CONVERT(varchar(100), GETDATE() - ?, 23) and " +
				                                 "   EarlyPregnancyVisit.Menstrualdate <= CONVERT(varchar(100), GETDATE() - ?, 23)");
		query.setParameter(0, TianShu);
		query.setParameter(1, TianShu);
		query.list();
		return listObject2StringString(query.list());
		
	}
	
}
