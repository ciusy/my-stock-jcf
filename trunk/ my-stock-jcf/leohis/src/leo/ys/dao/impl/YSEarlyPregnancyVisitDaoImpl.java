package leo.ys.dao.impl;

import leo.common.dao.DaoSupport;
import leo.entity.EarlyPregnancyVisit;
import leo.ys.dao.iface.YSEarlyPregnancyVisitDao;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
/**
 * ������ü�¼Dao�ӿ�ʵ��
 * @author abc
 *
 */
public class YSEarlyPregnancyVisitDaoImpl extends DaoSupport<EarlyPregnancyVisit> implements YSEarlyPregnancyVisitDao {
	/**
	 * �����ü�¼
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
	 * ����������ѯ��ü�¼
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
	 * �޸���ü�¼
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
				                                 "   FamiliRecordBasicInfo.Mname, " + //0�ɷ�����
				                                 "   FamiliRecordBasicInfo.Wname, " + //1��������
				                                 "   FamiliRecordBasicInfo.Mage, " + //2�ɷ�����
				                                 "   FamiliRecordBasicInfo.Wage, " + //3��������
				                                 "   FamiliRecord.MCsID, " + //4�ɷ�������ID
				                                 "   FamiliRecord.WCsID, " + //5���ӷ������ID
				                                 "   (select Cellphone from CSConsumer where csid = FamiliRecord.MCsID) as zfsj, " + //6�ɷ��ֻ��� 
				                                 "   (select Cellphone from CSConsumer where csid = FamiliRecord.WCsID) as qzsj, " + //7�����ֻ���
				                                 "   FamiliRecord.RecordID " +//8������
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
