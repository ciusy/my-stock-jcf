package leo.yf.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import leo.common.dao.DaoSupport;
import leo.common.util.DateUtil;
import leo.entity.YfminbankA;
import leo.yf.dao.iface.YfminbankADao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessResourceFailureException;

public class YfminbankADaoImpl extends DaoSupport<YfminbankA> implements
		YfminbankADao {

	public String getAFormID() {
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery(
				"select a.aformId from YfminbankA a order by a.aformId desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "no";
		else
			return list.get(0);
	}

	public boolean addYfminbankA(YfminbankA yfminbankA) {
		this.getHibernateTemplate().save(yfminbankA);
		return true;
	}

	public List<YfminbankA> getYfminbankA(String AFormID, Integer InbankTypeID,
			String AObject, String ATime_B, String ATime_E,
			String InbankStatus, String InbankTime_B, String InbankTime_E,
			Integer PharmacyID, String BeiZhu) {
		/*
		 * AFormID, 申请单ID InbankTypeID, 入库类型ID AObject, 申请对象 ATime_B, 申请时间(开始)
		 * ATime_E, 申请时间(结束) InbankStatus, 入库状态 InbankTime_B,入库时间(开始)
		 * InbankTime_E,入库时间(结束) PharmacyID药房ID BeiZhu备注
		 */
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (AFormID != null && !AFormID.equals("")) {
			tj = tj + " aformId = ?"; // AFormID, 申请单ID
			cs.add(AFormID);
		}
		if (AObject != null && !AObject.equals("")) { // AObject, 申请对象
			if (tj.equals(""))
				tj = " aobject = ?";
			else
				tj = tj + " and aobject = ?";
			cs.add(AObject);
		}
		if (ATime_B != null && !ATime_B.equals("")) { // ATime, 申请时间
			if (tj.equals(""))
				tj = " atime >= ? and atime <= ?";
			else
				tj = tj + " and atime >= ? and atime <= ?";
			cs.add(DateUtil.stringToDateTime(ATime_B));
			cs.add(DateUtil.stringToDateTime(ATime_E));
		}
		if (InbankStatus != null && !InbankStatus.equals("")) { // InbankStatus,
																// 入库状态
			if (tj.equals(""))
				tj = " inbankStatus = ?";
			else
				tj = tj + " and inbankStatus = ?";
			cs.add(InbankStatus);
		}
		if (InbankTime_B != null && !InbankTime_B.equals("")) { // InbankTime,入库时间
			if (tj.equals(""))
				tj = " inbankTime >= ? and inbankTime <= ?";
			else
				tj = tj + " and inbankTime >= ? and inbankTime <= ?";
			cs.add(InbankTime_B);
			cs.add(InbankTime_E);
		}
		if (PharmacyID != -2) {
			if (tj.equals(""))
				tj = " pharmacyId = ?";
			else
				tj = tj + " and pharmacyId = ?";
			cs.add(PharmacyID);
		}

		if (InbankTypeID != -2) { // InbankTypeID, 入库类型ID
			if (tj.equals(""))
				tj = " inbankTypeId = ?";
			else
				tj = tj + " and inbankTypeId = ?";
			cs.add(InbankTypeID);
		}

		if (BeiZhu != null && !BeiZhu.equals("")) { // 备注
			if (tj.equals(""))
				tj = " note = ?";
			else
				tj = tj + " and note = ?";
			cs.add(BeiZhu);
		}

		List<YfminbankA> list = null;

		if (tj != null && !tj.equals("")) {
			list = this.getHibernateTemplate().find(
					"from YfminbankA where" + tj, cs.toArray());
		} else {
			list = this.getHibernateTemplate().find("from YfminbankA");
		}
		return list;
	};

	public boolean delYfminbankA(String ID) {
		this.delete(ID);
		return true;
	}

	public boolean updateYfminbankA(YfminbankA yfminbankA) {
		try {
			this.update(yfminbankA);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean updateStatus(String AFormID, String Status,
			String ApproveTime) {// 修改入库申请单状态和审批时间
		Query query = null; // 生明一个查询对象
		try {
			query = this
					.getSession()
					.createSQLQuery(
							"update YFMInbankA set InbankStatus = ?,ApproveTime = ? where AFormID = ?");
			query.setParameter(0, Status);
			query.setParameter(1, ApproveTime);
			query.setParameter(2, AFormID);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean updateInStatus(String AFormID, String Status,
			String InbankTime, Long RKRYID) {// 修改入库申请单状态和完成时间
		Query query = null; // 生明一个查询对象
		try {
			query = this
					.getSession()
					.createSQLQuery(
							"update YFMInbankA set InbankStatus = ?,InbankTime = ?, istaffId = ? where AFormID = ?");
			query.setParameter(0, Status);
			query.setParameter(1, InbankTime);
			query.setParameter(2, RKRYID);
			query.setParameter(3, AFormID);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * 按条件查询入库申请单
	 */
	public YfminbankA getYfminbankAByAformId(String aformId, String startDate,
			String endDate, String inbankStatus, String validityPeriod) {
		try {
			String hql = "from YfminbankA where aformId='" + aformId
					+ "' and atime<'" + validityPeriod + "' ";

			if (!"".equals(startDate) && !"".equals(endDate)) {
				hql += "and (atime between '" + startDate + "' and '" + endDate
						+ "') ";
			}
			if (!"".equals(inbankStatus)) {
				hql += "and inbankStatus='" + inbankStatus + "' ";
			}

			Session session = this.getSession();
			Query query = session.createQuery(hql);
			if (query.list().size() > 0) {
				return (YfminbankA) query.list().get(0);
			}
			return null;
		} catch (DataAccessResourceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据主键查询入库申请单
	 */
	public YfminbankA getYfminbankAByAformId(String aformId) {
		// TODO Auto-generated method stub
		try {
			return (YfminbankA) super.getHibernateTemplate().get(
					YfminbankA.class, aformId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 入库统计
	 * 
	 * @param rkdlx
	 *            入库类型
	 * @param lxid
	 *            类型ID
	 * @param rkzt
	 *            入库状态
	 * @param k_date
	 *            入库开始日期
	 * @param j_date
	 *            入库结束日期
	 * @param xm
	 *            姓名
	 * @param xmsx
	 *            姓名缩写
	 * @param yfid
	 *            药房ID
	 * @param rkryid
	 *            入库人员ID
	 * @param rkdx
	 *            入库对象ID
	 * @return
	 */
	public String[][] getRuKuTongJi(String rkdlx, Integer lxid, String rkzt,
			String k_date, String j_date, String xm, String xmsx, Integer yfid,
			Long rkryid, String rkdx) {
		String tj;
		String bm;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		bm = "";
		Query query = null;

		if (rkdlx.equals("门诊") || rkdlx.equals("住院")) {
			bm = " YFInbankAItem, YFMInbankA, YFMInfo, CSConsumer ";
			tj = "  YFMInbankA.AFormID = YFInbankAItem.ApproveFormID and "
					+ "  YFMInfo.MInfoID = YFInbankAItem.MID and "
					+ "  CSConsumer.CsID = YFMInbankA.AObject ";
		}

		if (rkdlx.equals("采购") || rkdlx.equals("员工") || rkdlx.equals("科室")
				|| rkdlx.equals("乡镇") || rkdlx.equals("药房")
				|| rkdlx.equals("盘点") || rkdlx.equals("所有")) {
			bm = " YFInbankAItem," + "YFMInbankA," + "YFMInfo ";
			tj = " YFMInbankA.AFormID = YFInbankAItem.ApproveFormID and "
					+ " YFMInfo.MInfoID = YFInbankAItem.MID";
		}

		if (lxid != -2) {
			tj = tj + " and YFMInbankA.InbankTypeID = ?"; // 入库类型ID
			cs.add(lxid);
		}
		if (rkzt != null && !rkzt.equals("")) { // 入库状态
			tj = tj + " and YFMInbankA.InbankStatus = ?";
			cs.add(rkzt);
		}
		if (k_date != null && !k_date.equals("")) { // 时间
			tj = tj
					+ " and YFMInbankA.InbankTime >= ? and YFMInbankA.InbankTime <= ?";
			cs.add(DateUtil.stringToDateTime(k_date));
			cs.add(DateUtil.stringToDateTime(j_date));
		}
		if (xm != null && !xm.equals("")) { // 姓名
			tj = tj + " and CSConsumer.CSName like ?";
			cs.add("%" + xm + "%");
		}
		if (xmsx != null && !xmsx.equals("")) { // 姓名缩写
			tj = tj + " and CSConsumer.NameForShort = ?";
			cs.add(xmsx);
		}
		if (yfid != -2) { // 药房ID
			tj = tj + " and YFMInbankA.PharmacyID = ?";
			cs.add(yfid);
		}
		if (rkdx != null && !rkdx.equals("")) {// 入库对象
			tj = tj + " and YFMInbankA.AObject = ?";
			cs.add(rkdx);
		}
		if (tj != null && !tj.equals("")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "  YFMInfo.MName, "
									+ "  YFMInfo.MSpec, "
									+ "  YFMInfo.Manufacturer, "
									+ "  YFInbankAItem.Unit, "
									+ "  YFInbankAItem.InbankP, "
									+ "  sum(YFInbankAItem.Num) as sl, "
									+ "  sum(YFInbankAItem.InbankP * YFInbankAItem.Num) as xj "
									+ "from " + bm + "where " + tj
									+ " group by " + " YFMInfo.MName, "
									+ "YFMInfo.MSpec, "
									+ "YFMInfo.Manufacturer, "
									+ "YFInbankAItem.InbankP, "
									+ "YFInbankAItem.Unit");
			for (int i = 0; i < cs.size(); i++) {
				query.setParameter(i, cs.get(i));
			}
		}
		query.list();
		return listObject2StringString(query.list());
	}

	public List<Double> getRuKuJiaGe(Integer YaoPinID) {
		Query query = null;
		query = this
				.getSession()
				.createSQLQuery(
						"select inbankp from YFInbankAItem where mid = ? group by inbankp");
		query.setParameter(0, YaoPinID);
		query.list();
		return query.list();

	}

	public String[][] getYFMInbankATuiYao(String ZhuYuanHao, String ZhuangTai) {
		List<Object> list = new ArrayList<Object>();
		Query query = null; // 生明一个查询对象
		query = this
				.getSession()
				.createSQLQuery(
						"select "
								+ "   YFMInfo.MName, "
								+ // 0药品名称
								"   YFMInfo.MSpec, "
								+ // 1药品规格
								"   YFInbankAItem.Num, "
								+ // 2退量
								"   YFInbankAItem.Unit, "
								+ // 3单位
								"   YFMInbankA.Establish, "
								+ // 4建单人
								"   YFInbankAItem.ApproveFormID, "
								+ // 5申请单ID
								"   YFMInbankA.InbankStatus, "
								+ // 6状态
								"   YFInbankAItem.MID, "
								+ // 7药品ID
								"   YFInbankAItem.DAID, "
								+ // 8医嘱ID
								"   ZYIPMedicine.Cost "
								+ // 9单价
								"from "
								+ "   YFInbankAItem,YFMInbankA,YFMInfo,ZYIPMedicine "
								+ "where "
								+ "   ZYIPMedicine.DAID = YFInbankAItem.DAID and "
								+ "   ZYIPMedicine.MInfoID = YFInbankAItem.MID and "
								+ "   YFInbankAItem.ApproveFormID = YFMInbankA.AFormID and "
								+ "   YFInbankAItem.MID = YFMInfo.MInfoID and "
								+ "  YFMInbankA.OPNum = ? and "
								+ "YFMInbankA.InbankStatus = ?");
		query.setParameter(0, ZhuYuanHao);
		query.setParameter(1, ZhuangTai);
		query.list();
		return listObject2StringString(query.list()); // 执行SQL语句(将返回结果query.list()强制转换为List<Object[]>类型)
	}

	public boolean updateZhuangTai(String AFormID, String ZhuangTai,
			String ApproveTime) {
		Query query = null; // 生明一个查询对象
		query = this
				.getSession()
				.createSQLQuery(
						"update YFMInbankA set ApproveTime = ?,InbankStatus = ? where AFormID = ?");
		query.setParameter(0, ApproveTime);
		query.setParameter(1, ZhuangTai);
		query.setParameter(2, AFormID);
		query.executeUpdate();
		return true;
	}

	public String[][] getTuiYaoRuKu(String XingMing, String XingMingSuoXie,
			String MeiZhiZhuYuanHao, String ShenQingRiQi_B,
			String ShenQingRiQi_E, Integer YaoFangID, String RuKuLeiXing) {
		String tj;
		String bm;
		List<Object> cs = new ArrayList<Object>();
		Query query = null;

		tj = " YFInbankTypeSetting.TypeName = ? and "
				+ " YFMInbankA.PharmacyID = ? and "
				+ " YFInbankTypeSetting.PharmacyID = ? ";
		cs.add(RuKuLeiXing);
		cs.add(YaoFangID);
		cs.add(YaoFangID);

		if (XingMing != null && !XingMing.equals("")) { // 姓名
			tj = tj + " and CSConsumer.CSName like ?";
			cs.add("%" + XingMing + "%");
		}
		if (XingMingSuoXie != null && !XingMingSuoXie.equals("")) { // 姓名缩写
			tj = tj + " and CSConsumer.NameForShort = ?";
			cs.add(XingMingSuoXie);
		}
		if (MeiZhiZhuYuanHao != null && !MeiZhiZhuYuanHao.equals("")) { // 门诊号或住院号
			tj = tj + " and YFMInbankA.OPNum = ?";
			cs.add(MeiZhiZhuYuanHao);
		}

		if (ShenQingRiQi_B != null && !ShenQingRiQi_B.equals("")) { // 申请时间
			tj = tj + " and YFMInbankA.ATime >= ? and YFMInbankA.ATime <= ?";
			cs.add(ShenQingRiQi_B);
			cs.add(ShenQingRiQi_E);
		}

		query = this
				.getSession()
				.createSQLQuery(
						"select "
								+ "   YFMInbankA.AFormID, "
								+ // 0申请单号
								"   YFMInbankA.OPNum, "
								+ // 1门诊号
								"   YFMInbankA.AObject, "
								+ // 2服务对象ID
								"   CSConsumer.CSName, "
								+ // 3姓名
								"   CSConsumer.IDCardNum, "
								+ // 4身份证
								"   CSConsumer.Address "
								+ // 5住址
								"from "
								+ "   YFMInbankA,YFInbankTypeSetting,CSConsumer "
								+ "where "
								+ "   YFMInbankA.InbankTypeID = YFInbankTypeSetting.InbankTypeID and "
								+ "   YFMInbankA.AObject = CSConsumer.CsID and "
								+ "   YFMInbankA.InbankStatus = '批准' and " + tj);
		for (int i = 0; i < cs.size(); i++) {
			query.setParameter(i, cs.get(i));
		}
		query.list();
		return listObject2StringString(query.list());

	}

	public List<List<String>> getTownAllocateApplicationBill(Integer townId,
			String status, String applicationBillNO, String startTime,
			String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateStorageApplicationFormStatus(
			Set<String> storageApplicationFormIds, String string) {
		StringBuilder sb = new StringBuilder();
		sb.append("update YfminbankA s set inbankStatus=? ");

		if (null != storageApplicationFormIds
				&& storageApplicationFormIds.size() > 0) {
			sb.append(" where s.aformId in (:itemId)");
		}
		Query query = getSession().createQuery(sb.toString());
		query.setParameter(0, string);
		if (null != storageApplicationFormIds
				&& storageApplicationFormIds.size() > 0) {
			query.setParameterList("itemId", storageApplicationFormIds);
		}
		query.executeUpdate();
	}

	public int getCFReturnCount(String opnum, String... status) {

		Object obj = getSession()
				.createSQLQuery(
						"select count(a.OPNum) as b from YfminbankA a where a.OPNum=? and a.InbankStatus in (:status)")
				.setParameter(0, opnum).setParameterList("status", status)
				.uniqueResult();
		return (Integer) obj;
	}

}
