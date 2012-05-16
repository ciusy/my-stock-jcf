package leo.ys.dao.impl;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.Notify;
import leo.ys.dao.iface.YSNotifyDao;

public class YSNotifyDaoImpl extends DaoSupport<Notify> implements YSNotifyDao {

	public String[][] getGaoZhiDuanXinRenYuan(Integer TianShu) {
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
				                                 "    FamiliRecord,FamiliRecordBasicInfo,Notify " +
				                                 "where " +
				                                 "    FamiliRecord.RecordID = FamiliRecordBasicInfo.RecordID and " +
				                                 "    FamiliRecord.RecordID = Notify.RecordID and " +
				                                 "    Notify.Ddate >= CONVERT(varchar(100), GETDATE() - ?, 23) + ' 00:00:00' and " +
				                                 "    Notify.Ddate <= CONVERT(varchar(100), GETDATE() - ?, 23) + ' 23:59:59'");
		query.setParameter(0, TianShu);
		query.setParameter(1, TianShu);
		query.list();
		return listObject2StringString(query.list());
	}
	
	public String getGaoZhiNeiRong(String DangAnHao){
		Query query = null;
		//query = this.getSession().createSQLQuery("select told from Notify where recordID = ?");
		query = this.getSession().createQuery("select a.told from Notify a where recordId = ?");
		query.setParameter(0, DangAnHao);
		query.list();
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "";
		else
			return list.get(0);
	}
	
}
