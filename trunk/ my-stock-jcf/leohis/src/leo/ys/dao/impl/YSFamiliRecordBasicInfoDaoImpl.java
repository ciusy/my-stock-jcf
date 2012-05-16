package leo.ys.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.FamiliRecordBasicInfo;
import leo.entity.Yfaitem;
import leo.ys.dao.iface.YSFamiliRecordBasicInfoDao;
import org.hibernate.Query;

public class YSFamiliRecordBasicInfoDaoImpl extends DaoSupport<FamiliRecordBasicInfo> implements
		YSFamiliRecordBasicInfoDao {

	public String[][] getDuanXinRenYuan(Integer TianShu) {
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
				                                 "   FamiliRecord,FamiliRecordBasicInfo " +
				                                 "where " +
				                                 "   FamiliRecord.RecordID = FamiliRecordBasicInfo.RecordID and " +
				                                 "   FamiliRecordBasicInfo.PregnantTimeExpected >= CONVERT(varchar(100), GETDATE() - ?, 23) + ' 00:00:00' and " +
				                                 "   FamiliRecordBasicInfo.PregnantTimeExpected <= CONVERT(varchar(100), GETDATE() - ?, 23) + ' 23:59:59'");
		query.setParameter(0, TianShu);
		query.setParameter(1, TianShu);
		query.list();
		return listObject2StringString(query.list());
	}
	
	public List<FamiliRecordBasicInfo> getFamiliRecordBasicInfo(String RecordID){
		List<FamiliRecordBasicInfo> list = this.getHibernateTemplate().find("from FamiliRecordBasicInfo where recordId = ?",RecordID);
		return list;
	}
	
}
