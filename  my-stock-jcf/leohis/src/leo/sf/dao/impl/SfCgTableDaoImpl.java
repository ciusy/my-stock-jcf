package leo.sf.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.common.util.CommonUtil;
import leo.common.util.DateUtil;
import leo.entity.SfcgTable;
import leo.sf.dao.iface.SfCgTableDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 29, 2011 5:08:54 PM
 */
@SuppressWarnings("unchecked")
public class SfCgTableDaoImpl extends DaoSupport<SfcgTable> implements
		SfCgTableDao {

	public String getMaxCSID() {
		List<String> list = (ArrayList<String>) getHibernateTemplate().find(
				"select Max(s.cgId) from SfcgTable s");
		return list.size() > 0 ? list.get(0) : null;
	}

	public SfcgTable saveSfCgTable(String cashPay, String personnelNumber,
			String realMoeny, String officesNumber, Timestamp nowTimeStamp,
			String idofTableLocateIn, String cgType, String tableLocateIn) {
		SfcgTable sfcgTable = new SfcgTable();
		sfcgTable.setCash(cashPay.trim().equals("") ? (long) 0 : Double
				.parseDouble(cashPay));
		sfcgTable.setCashier(Long.parseLong(personnelNumber));
		sfcgTable.setCgAmount(Double.parseDouble(realMoeny));

		String maxCSID = getMaxCSID();
		if (null == maxCSID) {
			String now = DateUtil.getCurrentDateString();
			now = now.replace("-", "");
			sfcgTable.setCgId("CHA" + now + "00001");
		} else
			sfcgTable.setCgId(CommonUtil.GetNewFlowNum(maxCSID));

		sfcgTable.setCgRoomId(Integer.parseInt(officesNumber));
		sfcgTable.setCgTime(nowTimeStamp);
		sfcgTable.setCgType(cgType);
		sfcgTable.setIdofTableLocateIn(idofTableLocateIn);
		sfcgTable.setTableLocateIn(tableLocateIn);
		save(sfcgTable);
		return sfcgTable;
	}

	public void getStatistics(String startTime, String endTime, String type) {

		StringBuilder sb = new StringBuilder();
		List<Object> paramList = new ArrayList<Object>();
		sb.append("insert into SfStatistics(statisticType,projectType,projectMoney,reducalMoney,factMoney) ");
		sb.append("select '收费员:'+t2.SName as c,'员工充值' as c1,sum(t.CgAmount) as c3,"
				+ "'0' as c4,sum(t.CgAmount) as c5"
				+ " from SFCgTable t,OSStuff t2 ");

		sb.append(" where t.Cashier=t2.SID ");

		if (null != startTime && !"".equals(startTime)) {
			sb.append(" and t.CgTime>=?");
			paramList.add(DateUtil.get000000DateTime(startTime));
		}

		if (null != endTime && !"".equals(endTime)) {
			sb.append(" and t.CgTime<=?");
			paramList.add(DateUtil.get235959DateTime(endTime));
		}
		sb.append(" and t.CgType=?");
		paramList.add(type);
		sb.append(" group by '收费员:'+t2.SName");
		Query query = getSession().createSQLQuery(sb.toString());

		for (int i = 0; i < paramList.size(); i++)
			query.setParameter(i, paramList.get(i));
		// return listObject2ListString(query.list());
		query.executeUpdate();

	}
}
