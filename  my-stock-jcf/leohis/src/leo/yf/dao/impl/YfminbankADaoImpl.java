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
		Query query = null; // ����һ����ѯ����
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
		 * AFormID, ���뵥ID InbankTypeID, �������ID AObject, ������� ATime_B, ����ʱ��(��ʼ)
		 * ATime_E, ����ʱ��(����) InbankStatus, ���״̬ InbankTime_B,���ʱ��(��ʼ)
		 * InbankTime_E,���ʱ��(����) PharmacyIDҩ��ID BeiZhu��ע
		 */
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (AFormID != null && !AFormID.equals("")) {
			tj = tj + " aformId = ?"; // AFormID, ���뵥ID
			cs.add(AFormID);
		}
		if (AObject != null && !AObject.equals("")) { // AObject, �������
			if (tj.equals(""))
				tj = " aobject = ?";
			else
				tj = tj + " and aobject = ?";
			cs.add(AObject);
		}
		if (ATime_B != null && !ATime_B.equals("")) { // ATime, ����ʱ��
			if (tj.equals(""))
				tj = " atime >= ? and atime <= ?";
			else
				tj = tj + " and atime >= ? and atime <= ?";
			cs.add(DateUtil.stringToDateTime(ATime_B));
			cs.add(DateUtil.stringToDateTime(ATime_E));
		}
		if (InbankStatus != null && !InbankStatus.equals("")) { // InbankStatus,
																// ���״̬
			if (tj.equals(""))
				tj = " inbankStatus = ?";
			else
				tj = tj + " and inbankStatus = ?";
			cs.add(InbankStatus);
		}
		if (InbankTime_B != null && !InbankTime_B.equals("")) { // InbankTime,���ʱ��
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

		if (InbankTypeID != -2) { // InbankTypeID, �������ID
			if (tj.equals(""))
				tj = " inbankTypeId = ?";
			else
				tj = tj + " and inbankTypeId = ?";
			cs.add(InbankTypeID);
		}

		if (BeiZhu != null && !BeiZhu.equals("")) { // ��ע
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
			String ApproveTime) {// �޸�������뵥״̬������ʱ��
		Query query = null; // ����һ����ѯ����
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
			String InbankTime, Long RKRYID) {// �޸�������뵥״̬�����ʱ��
		Query query = null; // ����һ����ѯ����
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
	 * ��������ѯ������뵥
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
	 * ����������ѯ������뵥
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
	 * ���ͳ��
	 * 
	 * @param rkdlx
	 *            �������
	 * @param lxid
	 *            ����ID
	 * @param rkzt
	 *            ���״̬
	 * @param k_date
	 *            ��⿪ʼ����
	 * @param j_date
	 *            ����������
	 * @param xm
	 *            ����
	 * @param xmsx
	 *            ������д
	 * @param yfid
	 *            ҩ��ID
	 * @param rkryid
	 *            �����ԱID
	 * @param rkdx
	 *            ������ID
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

		if (rkdlx.equals("����") || rkdlx.equals("סԺ")) {
			bm = " YFInbankAItem, YFMInbankA, YFMInfo, CSConsumer ";
			tj = "  YFMInbankA.AFormID = YFInbankAItem.ApproveFormID and "
					+ "  YFMInfo.MInfoID = YFInbankAItem.MID and "
					+ "  CSConsumer.CsID = YFMInbankA.AObject ";
		}

		if (rkdlx.equals("�ɹ�") || rkdlx.equals("Ա��") || rkdlx.equals("����")
				|| rkdlx.equals("����") || rkdlx.equals("ҩ��")
				|| rkdlx.equals("�̵�") || rkdlx.equals("����")) {
			bm = " YFInbankAItem," + "YFMInbankA," + "YFMInfo ";
			tj = " YFMInbankA.AFormID = YFInbankAItem.ApproveFormID and "
					+ " YFMInfo.MInfoID = YFInbankAItem.MID";
		}

		if (lxid != -2) {
			tj = tj + " and YFMInbankA.InbankTypeID = ?"; // �������ID
			cs.add(lxid);
		}
		if (rkzt != null && !rkzt.equals("")) { // ���״̬
			tj = tj + " and YFMInbankA.InbankStatus = ?";
			cs.add(rkzt);
		}
		if (k_date != null && !k_date.equals("")) { // ʱ��
			tj = tj
					+ " and YFMInbankA.InbankTime >= ? and YFMInbankA.InbankTime <= ?";
			cs.add(DateUtil.stringToDateTime(k_date));
			cs.add(DateUtil.stringToDateTime(j_date));
		}
		if (xm != null && !xm.equals("")) { // ����
			tj = tj + " and CSConsumer.CSName like ?";
			cs.add("%" + xm + "%");
		}
		if (xmsx != null && !xmsx.equals("")) { // ������д
			tj = tj + " and CSConsumer.NameForShort = ?";
			cs.add(xmsx);
		}
		if (yfid != -2) { // ҩ��ID
			tj = tj + " and YFMInbankA.PharmacyID = ?";
			cs.add(yfid);
		}
		if (rkdx != null && !rkdx.equals("")) {// ������
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
		Query query = null; // ����һ����ѯ����
		query = this
				.getSession()
				.createSQLQuery(
						"select "
								+ "   YFMInfo.MName, "
								+ // 0ҩƷ����
								"   YFMInfo.MSpec, "
								+ // 1ҩƷ���
								"   YFInbankAItem.Num, "
								+ // 2����
								"   YFInbankAItem.Unit, "
								+ // 3��λ
								"   YFMInbankA.Establish, "
								+ // 4������
								"   YFInbankAItem.ApproveFormID, "
								+ // 5���뵥ID
								"   YFMInbankA.InbankStatus, "
								+ // 6״̬
								"   YFInbankAItem.MID, "
								+ // 7ҩƷID
								"   YFInbankAItem.DAID, "
								+ // 8ҽ��ID
								"   ZYIPMedicine.Cost "
								+ // 9����
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
		return listObject2StringString(query.list()); // ִ��SQL���(�����ؽ��query.list()ǿ��ת��ΪList<Object[]>����)
	}

	public boolean updateZhuangTai(String AFormID, String ZhuangTai,
			String ApproveTime) {
		Query query = null; // ����һ����ѯ����
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

		if (XingMing != null && !XingMing.equals("")) { // ����
			tj = tj + " and CSConsumer.CSName like ?";
			cs.add("%" + XingMing + "%");
		}
		if (XingMingSuoXie != null && !XingMingSuoXie.equals("")) { // ������д
			tj = tj + " and CSConsumer.NameForShort = ?";
			cs.add(XingMingSuoXie);
		}
		if (MeiZhiZhuYuanHao != null && !MeiZhiZhuYuanHao.equals("")) { // ����Ż�סԺ��
			tj = tj + " and YFMInbankA.OPNum = ?";
			cs.add(MeiZhiZhuYuanHao);
		}

		if (ShenQingRiQi_B != null && !ShenQingRiQi_B.equals("")) { // ����ʱ��
			tj = tj + " and YFMInbankA.ATime >= ? and YFMInbankA.ATime <= ?";
			cs.add(ShenQingRiQi_B);
			cs.add(ShenQingRiQi_E);
		}

		query = this
				.getSession()
				.createSQLQuery(
						"select "
								+ "   YFMInbankA.AFormID, "
								+ // 0���뵥��
								"   YFMInbankA.OPNum, "
								+ // 1�����
								"   YFMInbankA.AObject, "
								+ // 2�������ID
								"   CSConsumer.CSName, "
								+ // 3����
								"   CSConsumer.IDCardNum, "
								+ // 4���֤
								"   CSConsumer.Address "
								+ // 5סַ
								"from "
								+ "   YFMInbankA,YFInbankTypeSetting,CSConsumer "
								+ "where "
								+ "   YFMInbankA.InbankTypeID = YFInbankTypeSetting.InbankTypeID and "
								+ "   YFMInbankA.AObject = CSConsumer.CsID and "
								+ "   YFMInbankA.InbankStatus = '��׼' and " + tj);
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
