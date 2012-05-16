package leo.yf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.common.util.DateUtil;
import leo.entity.YfcheckRecord;
import leo.yf.dao.iface.YfcheckRecordDao;

import org.hibernate.Query;
import org.hibernate.Session;

public class YfcheckRecordDaoImpl extends DaoSupport<YfcheckRecord> implements
		YfcheckRecordDao {

	public boolean addYfcheckRecord(YfcheckRecord yfcheckRecord) {
		this.getHibernateTemplate().save(yfcheckRecord);
		return true;
	}

	public String getMaxID() {
		Query query = null; // 生明一个查询对象
		query = this
				.getSession()
				.createQuery(
						"select a.checkRecordId from YfcheckRecord a order by a.checkRecordId desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "no";
		else
			return list.get(0);

	}

	public List<YfcheckRecord> getYfcheckRecord(String DanHao,
			String KaiShiRiQi, String JieSuRiQi, String ZhuangTai,
			Integer YaoFang) {
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (DanHao != null && !DanHao.equals("")) {
			tj = " checkRecordId = ?";
			cs.add(DanHao);
		}

		if (KaiShiRiQi != null && !KaiShiRiQi.equals("")) {
			if (tj.equals(""))
				tj = " startTime >= ? and startTime <= ?";
			else
				tj = tj + " and startTime >= ? and startTime <= ?";
			cs.add(DateUtil.stringToDateTime(KaiShiRiQi));
			cs.add(DateUtil.stringToDateTime(JieSuRiQi));
		}

		if (ZhuangTai != null && !ZhuangTai.equals("")) {
			if (tj.equals(""))
				tj = " checkStatus = ?";
			else
				tj = tj + " and checkStatus = ?";
			cs.add(ZhuangTai);
		}

		if (YaoFang != -2) {
			if (tj.equals(""))
				tj = " checkU = ?";
			else
				tj = tj + " and checkU = ?";
			cs.add(YaoFang);
		}

		List<YfcheckRecord> list = null;

		if (tj != null && !tj.equals("")) {
			list = this.getHibernateTemplate().find(
					"from YfcheckRecord where" + tj, cs.toArray());
		} else {
			list = this.getHibernateTemplate().find("from YfcheckRecord");
		}
		return list;
	}

	public boolean delYfcheckRecord(String DanHao) {
		Query query = null;
		query = this.getSession().createSQLQuery(
				"delete from YfcheckRecord where checkRecordId = ?");
		query.setParameter(0, DanHao);
		query.executeUpdate();
		return true;
	}

	public boolean updateZhuangTai(String DanHao, String ZhuangTai) {
		Query query = null;
		query = this
				.getSession()
				.createSQLQuery(
						"update YFCheckRecord set CheckStatus = ? where CheckRecordID = ?");
		query.setParameter(0, ZhuangTai);
		query.setParameter(1, DanHao);
		query.executeUpdate();
		return true;
	}

	/**
	 * 按条件查询盘点记录
	 */
	public YfcheckRecord getYfcheckRecordByTiaojian(String checkRecordId,
			String startDate, String endDate, String checkStatus,
			String validityPeriod) {
		// TODO Auto-generated method stub
		String hql = "from YfcheckRecord where checkRecordId='" + checkRecordId
				+ "' and startTime<'" + validityPeriod + "' ";

		if (!"".equals(startDate) && !"".equals(endDate)) {
			hql += "and (startTime between '" + startDate + "' and '" + endDate
					+ "') ";
		}
		if (!"".equals(checkStatus)) {
			hql += "and checkStatus='" + checkStatus + "' ";
		}
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		if (query.list().size() > 0){
			return (YfcheckRecord)query.list().get(0);
		}
		return null;
	}

}
