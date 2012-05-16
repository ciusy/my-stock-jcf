package leo.sf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.common.util.DateUtil;
import leo.entity.SfmzinvoiceContent;
import leo.sf.dao.iface.SfMzInvoiceContentDao;

public class SfMzInvoiceContentDaoImpl extends DaoSupport<SfmzinvoiceContent>
		implements SfMzInvoiceContentDao {

	public List<List<String>> getOutPatientStatistics(String startTime,
			String endTime, String costType) {

		StringBuilder sb = new StringBuilder();
		List<Object> paramList = new ArrayList<Object>();

		sb.append("insert into SfStatistics(statisticType,projectType,projectMoney,reducalMoney,factMoney) ");
		sb.append("select '收费员:'+t2.SName as c,t.projectName,sum(t.projectMoney) as c3,"
				+ "sum(t.projectReduceMoney) as c4,sum(t.projectMoney-t.projectReduceMoney) as c5"
				+ " from SFMZInvoiceContent t,SFMZInvoiceHead t1,OSStuff t2 ");

		if (!"0".equals(costType)) {
			sb.append(" ,GHCostType t3");
		}
		// sb.append(" where t.invoiceNO=t1.invoiceNO and t1.cashierID=t2.SID and t1.iscancel='false' and t1.invoiceType='门诊交费发票' ");
		sb.append(" where t.invoiceNO=t1.invoiceNO and t1.cashierID=t2.SID  and t1.invoiceType='门诊交费发票' ");

		if (!"0".equals(costType)) {
			sb.append(" and t3.ID=t1.costtype and t3.ID=?");
			paramList.add(costType);
		}

		if (null != startTime && !"".equals(startTime)) {
			sb.append(" and t1.invoiceTime>=?");
			paramList.add(DateUtil.get000000DateTime(startTime));
		}

		if (null != endTime && !"".equals(endTime)) {
			sb.append(" and t1.invoiceTime<=?");
			paramList.add(DateUtil.get235959DateTime(endTime));
		}

		sb.append(" group by '收费员:'+t2.SName,t.projectName");
		Query query = getSession().createSQLQuery(sb.toString());

		for (int i = 0; i < paramList.size(); i++)
			query.setParameter(i, paramList.get(i));
		query.executeUpdate();
		// return listObject2ListString(query.list());
		return null;
	}

	public List<List<String>> gettMedicineStatistics(String startTime,
			String endTime) {

		StringBuilder sb = new StringBuilder();
		List<Object> paramList = new ArrayList<Object>();
		sb.append("insert into SfStatistics(statisticType,projectType,projectMoney,reducalMoney,factMoney) ");
		sb.append("select '收费员:'+t2.SName as c,t.projectType,sum(t.projectMoney) as c3,"
				+ "sum(t.projectReduceMoney) as c4,sum(t.projectMoney-t.projectReduceMoney) as c5"
				+ " from SFMZInvoiceContent t,SFMZInvoiceHead t1,OSStuff t2 ");

		// sb.append(" where t.invoiceNO=t1.invoiceNO and t1.cashierID=t2.SID and t1.iscancel='false' and t1.invoiceType='乡镇领药交费发票' ");
		sb.append(" where t.invoiceNO=t1.invoiceNO and t1.cashierID=t2.SID and t1.invoiceType='乡镇领药交费发票' ");

		if (null != startTime && !"".equals(startTime)) {
			sb.append(" and t1.invoiceTime>=?");
			paramList.add(DateUtil.get000000DateTime(startTime));
		}

		if (null != endTime && !"".equals(endTime)) {
			sb.append(" and t1.invoiceTime<=?");
			paramList.add(DateUtil.get235959DateTime(endTime));
		}
		sb.append(" group by '收费员:'+t2.SName,t.projectType");
		Query query = getSession().createSQLQuery(sb.toString());

		for (int i = 0; i < paramList.size(); i++)
			query.setParameter(i, paramList.get(i));
		// return listObject2ListString(query.list());
		query.executeUpdate();
		return null;
	}

	public List<List<String>> getStatistics() {
		Query query = getSession()
				.createSQLQuery(
						"select statisticType,projectType,sum(projectMoney) as c1"
								+ ",sum(reducalMoney) as c2,sum(factMoney) as c3 from sfstatistics "
								+ " group by statisticType,projectType");

		return listObject2ListString(query.list());
	}

	public void deleteStatistics() {
		getSession().createSQLQuery("delete from sfstatistics").executeUpdate();

	}

	public void getOutPatientStatisticsByOffice(String startTime,
			String endTime, String costType) {

		StringBuilder sb = new StringBuilder();
		List<Object> paramList = new ArrayList<Object>();

		sb.append("insert into SfStatistics(statisticType,projectType,projectMoney,reducalMoney,factMoney) ");
		sb.append("select '开出科室:'+t2.UName as c,t.projectName,sum(t.projectMoney) as c3,"
				+ "sum(t.projectReduceMoney) as c4,sum(t.projectMoney-t.projectReduceMoney) as c5"
				+ " from SFMZInvoiceContent t,SFMZInvoiceHead t1,OSUForm t2,YFMExbankA t5,YFExbankAItem t6 ");

		if (!"0".equals(costType)) {
			sb.append(" ,GHCostType t3");
		}
		sb.append(" where t2.uid=t5.AU and t5.AFormID=t6.AFormID "
				+ " and t6.ItemID=billNO and  t.invoiceNO=t1.invoiceNO and t1.invoiceType='门诊交费发票' ");

		if (!"0".equals(costType)) {
			sb.append(" and t3.ID=t1.costtype and t3.ID=?");
			paramList.add(costType);
		}

		if (null != startTime && !"".equals(startTime)) {
			sb.append(" and t1.invoiceTime>=?");
			paramList.add(DateUtil.get000000DateTime(startTime));
		}

		if (null != endTime && !"".equals(endTime)) {
			sb.append(" and t1.invoiceTime<=?");
			paramList.add(DateUtil.get235959DateTime(endTime));
		}

		sb.append(" group by  '开出科室:'+t2.UName,t.projectName");
		Query query = getSession().createSQLQuery(sb.toString());

		for (int i = 0; i < paramList.size(); i++)
			query.setParameter(i, paramList.get(i));
		query.executeUpdate();

		setOfficeDispose(startTime, endTime, costType);

	}

	private void setOfficeDispose(String startTime, String endTime,
			String costType) {
		StringBuilder sb = new StringBuilder();
		List<Object> paramList = new ArrayList<Object>();

		sb.append("insert into SfStatistics(statisticType,projectType,projectMoney,reducalMoney,factMoney) ");
		sb.append("select '开出科室:'+t2.UName as c,t.projectName,sum(t.projectMoney) as c3,"
				+ "sum(t.projectReduceMoney) as c4,sum(t.projectMoney-t.projectReduceMoney) as c5"
				+ " from SFMZInvoiceContent t,SFMZInvoiceHead t1,OSUForm t2,CZDispose t5 ");

		if (!"0".equals(costType)) {
			sb.append(" ,GHCostType t3");
		}
		sb.append(" where t2.uid=t5.AU "
				+ " and t5.ItemID=billNO and  t.invoiceNO=t1.invoiceNO  and t1.invoiceType='门诊交费发票' ");

		if (!"0".equals(costType)) {
			sb.append(" and t3.ID=t1.costtype and t3.ID=?");
			paramList.add(costType);
		}

		if (null != startTime && !"".equals(startTime)) {
			sb.append(" and t1.invoiceTime>=?");
			paramList.add(DateUtil.get000000DateTime(startTime));
		}

		if (null != endTime && !"".equals(endTime)) {
			sb.append(" and t1.invoiceTime<=?");
			paramList.add(DateUtil.get235959DateTime(endTime));
		}

		sb.append(" group by  '开出科室:'+t2.UName,t.projectName");
		Query query = getSession().createSQLQuery(sb.toString());

		for (int i = 0; i < paramList.size(); i++)
			query.setParameter(i, paramList.get(i));
		query.executeUpdate();
	}

	public void getOutPatientStatisticsByDoctor(String startTime,
			String endTime, String costType) {

		StringBuilder sb = new StringBuilder();
		List<Object> paramList = new ArrayList<Object>();

		sb.append("insert into SfStatistics(statisticType,projectType,projectMoney,reducalMoney,factMoney) ");
		sb.append("select '开出医生:'+t4.SName as c,t.projectName,sum(t.projectMoney) as c3,"
				+ "sum(t.projectReduceMoney) as c4,sum(t.projectMoney-t.projectReduceMoney) as c5"
				+ " from SFMZInvoiceContent t,SFMZInvoiceHead t1,OSStuff t4,YFMExbankA t5,YFExbankAItem t6 ");

		if (!"0".equals(costType)) {
			sb.append(" ,GHCostType t3");
		}
		sb.append(" where t4.SID=t5.Establish and t5.AFormID=t6.AFormID "
				+ " and t6.ItemID=billNO and  t.invoiceNO=t1.invoiceNO  and t1.invoiceType='门诊交费发票' ");

		if (!"0".equals(costType)) {
			sb.append(" and t3.ID=t1.costtype and t3.ID=?");
			paramList.add(costType);
		}

		if (null != startTime && !"".equals(startTime)) {
			sb.append(" and t1.invoiceTime>=?");
			paramList.add(DateUtil.get000000DateTime(startTime));
		}

		if (null != endTime && !"".equals(endTime)) {
			sb.append(" and t1.invoiceTime<=?");
			paramList.add(DateUtil.get235959DateTime(endTime));
		}

		sb.append(" group by '开出医生:'+t4.SName,t.projectName");
		Query query = getSession().createSQLQuery(sb.toString());

		for (int i = 0; i < paramList.size(); i++)
			query.setParameter(i, paramList.get(i));
		query.executeUpdate();

		setDoctorDispose(startTime, endTime, costType);

	}

	private void setDoctorDispose(String startTime, String endTime,
			String costType) {
		StringBuilder sb = new StringBuilder();
		List<Object> paramList = new ArrayList<Object>();

		sb.append("insert into SfStatistics(statisticType,projectType,projectMoney,reducalMoney,factMoney) ");
		sb.append("select '开出医生:'+t4.SName as c,t.projectName,sum(t.projectMoney) as c3,"
				+ "sum(t.projectReduceMoney) as c4,sum(t.projectMoney-t.projectReduceMoney) as c5"
				+ " from SFMZInvoiceContent t,SFMZInvoiceHead t1,OSStuff t4,CZDispose t5 ");

		if (!"0".equals(costType)) {
			sb.append(" ,GHCostType t3");
		}
		sb.append(" where t4.SID=t5.AProposer "
				+ " and t5.ItemID=billNO and  t.invoiceNO=t1.invoiceNO and t1.invoiceType='门诊交费发票' ");

		if (!"0".equals(costType)) {
			sb.append(" and t3.ID=t1.costtype and t3.ID=?");
			paramList.add(costType);
		}

		if (null != startTime && !"".equals(startTime)) {
			sb.append(" and t1.invoiceTime>=?");
			paramList.add(DateUtil.get000000DateTime(startTime));
		}

		if (null != endTime && !"".equals(endTime)) {
			sb.append(" and t1.invoiceTime<=?");
			paramList.add(DateUtil.get235959DateTime(endTime));
		}

		sb.append(" group by  '开出医生:'+t4.SName,t.projectName");
		Query query = getSession().createSQLQuery(sb.toString());

		for (int i = 0; i < paramList.size(); i++)
			query.setParameter(i, paramList.get(i));
		query.executeUpdate();
	}
}
