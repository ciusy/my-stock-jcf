package leo.sf.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.SfmzinvoiceHead;
import leo.sf.dao.iface.SfMzInvoiceHeadDao;

public class SfMzInvoiceHeadDaoImpl extends DaoSupport<SfmzinvoiceHead>
		implements SfMzInvoiceHeadDao {

	public SfmzinvoiceHead getByMedOrgId(Integer medOrgId, Long invoiceNO) {

		return getSingleData("o.medOrgId=? and o.invoiceNo=?", new Object[] {
				medOrgId, invoiceNO });
	}

	public void updateStatus(Set<Long> invoiceNOs, boolean b) {
		StringBuilder sb = new StringBuilder();
		sb.append("update SfmzinvoiceHead s set s.isCancel=? ");

		if (null != invoiceNOs && invoiceNOs.size() > 0) {
			sb.append(" where s.invoiceNo in (:invoiceNos)");
		}
		Query query = getSession().createQuery(sb.toString());
		query.setParameter(0, b);
		if (null != invoiceNOs && invoiceNOs.size() > 0) {
			query.setParameterList("invoiceNos", invoiceNOs);
		}
		query.executeUpdate();
	}

	public List<List<String>> getPrescriptions(Set<Long> invoiceNOs, boolean b) {

		StringBuilder sb = new StringBuilder();
		sb.append("select t1.MName,t1.PharmacyUnit,t4.price,t4.num-t4.NumReturned as temp1,t4.PReceivable-t4.PReturned as temp2"
				+ ",'药房' as '药房',t4.ReduceMoney "
				+ ",t1.MSpec,1 as '处方',t4.ItemID,t1.MType from YFMInfo t1 ,YFExbankAItem t4 ,SFMZInvoiceHead t2,SFMZInvoiceContent t3"
				+ " where  t4.MID= t1.MInfoID and t2.invoiceNO=t3.invoiceNO and t3.billNO=t4.itemid and t2.iscancel=? "
				+ "and t4.num-t4.NumReturned >0 and  t2.invoiceNO in(:invoiceNOs)");

		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter(0, b);
		query.setParameterList("invoiceNOs", invoiceNOs);
		return listObject2ListString(query.list());

	}

	public List<List<String>> getDisposes(Set<Long> invoiceNOs, boolean b) {

		String sql = "select c2.ItemName,'次' as a ,c1.ReceivableP,'1' as b ,"
				+ "c1.realp,o.UName as c,c1.ReceivableP-c1.realp as temp1,'' as d,0 as '处置', c1.ItemID,c2.DisposeItemType"
				+ " from czdispose c1,CZDisposeItemDescribe c2 ,OSUForm o,SFMZInvoiceHead t2,SFMZInvoiceContent t3 where o.UID=c1.ExecuteU and "
				+ " c1.ItemTypeID= c2.ItemTypeID and t2.invoiceNO=t3.invoiceNO and "
				+ "c1.itemid=t3.billNO and t2.iscancel=? and  t2.invoiceNO in(:invoiceNOs)";
		Query query = getSession().createSQLQuery(sql);
		query.setParameter(0, b);
		query.setParameterList("invoiceNOs", invoiceNOs);
		return listObject2ListString(query.list());

	}

	public SfmzinvoiceHead getById(Long firstInvoiceNo) {
		return find(firstInvoiceNo);
	}

	public List<List<String>> getPrescriptionsExcept(Set<Long> invoiceNOs,
			boolean b, Set<String> storageItemIds) {

		StringBuilder sb = new StringBuilder();
		sb.append("select t1.MName,t1.PharmacyUnit,t4.price,t4.num-t4.NumReturned as temp1,t4.PReceivable-t4.PReturned as temp2"
				+ ",'药房' as '药房',t4.ReduceMoney "
				+ ",t1.MSpec,1 as '处方',t4.ItemID,t1.MType from YFMInfo t1 ,YFExbankAItem t4 ,SFMZInvoiceHead t2,SFMZInvoiceContent t3"
				+ " where  t4.MID= t1.MInfoID and t2.invoiceNO=t3.invoiceNO and t3.billNO=t4.itemid and t2.iscancel=? "
				+ " and  t2.invoiceNO in(:invoiceNOs) and t4.itemid not in (:storageItemIds)");

		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter(0, b);
		query.setParameterList("invoiceNOs", invoiceNOs);
		query.setParameterList("storageItemIds",
				storageItemIds);
		return listObject2ListString(query.list());

	}
}
