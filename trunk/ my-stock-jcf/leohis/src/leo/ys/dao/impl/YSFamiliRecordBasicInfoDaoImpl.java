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
