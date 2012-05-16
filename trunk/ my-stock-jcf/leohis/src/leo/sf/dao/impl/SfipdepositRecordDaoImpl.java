package leo.sf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.common.util.DateUtil;
import leo.entity.SfipdepositRecord;
import leo.sf.dao.iface.SfipdepositRecordDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 5, 2011 2:42:43 PM
 */
public class SfipdepositRecordDaoImpl extends DaoSupport<SfipdepositRecord>
		implements SfipdepositRecordDao {

	public List<Object[]> getTotalByIpIDS(List<String> ipIDS) {

		return getSession()
				.createQuery(
						"select s.ipid , sum(s.depositAmountPaid) from SfipdepositRecord s where s.ipid in (:ipIDS) group by s.ipid ")
				.setParameterList("ipIDS", ipIDS).list();
	}

	public List<SfipdepositRecord> getSfipdepositRecord(String IPID) {
		List<SfipdepositRecord> list = null;
		list = this.getHibernateTemplate().find(
				"from SfipdepositRecord where ipid = ?", IPID);
		return list;

	}

	public void getIpDesopitRescordStatistics(String startTime, String endTime) {

		StringBuilder sb = new StringBuilder();
		List<Object> paramList = new ArrayList<Object>();
		sb.append("insert into SfStatistics(statisticType,projectType,projectMoney,reducalMoney,factMoney) ");
		sb.append("select '收费员:'+t2.SName as c,'住院押金' as c1,sum(t.DepositAmountPaid) as c3,"
				+ "'0' as c4,sum(t.DepositAmountPaid) as c5"
				+ " from SFIPDepositRecord t,OSStuff t2 ");

		sb.append(" where t.Casher=t2.SID  ");

		if (null != startTime && !"".equals(startTime)) {
			sb.append(" and t.SFTime>=?");
			paramList.add(DateUtil.get000000DateTime(startTime));
		}

		if (null != endTime && !"".equals(endTime)) {
			sb.append(" and t.SFTime<=?");
			paramList.add(DateUtil.get235959DateTime(endTime));
		}
		sb.append(" group by '收费员:'+t2.SName");
		Query query = getSession().createSQLQuery(sb.toString());

		for (int i = 0; i < paramList.size(); i++)
			query.setParameter(i, paramList.get(i));
		// return listObject2ListString(query.list());
		query.executeUpdate();

	}
}
