package leo.yf.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import leo.common.dao.DaoSupport;
import leo.common.util.DateUtil;
import leo.entity.YfmexbankA;
import leo.yf.dao.iface.YfmexbankADao;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.util.StringUtils;

public class YfmexbankADaoImpl extends DaoSupport<YfmexbankA> implements
		YfmexbankADao {

	public void updateStatus(Set<String> formIDs, String costTypeId) {
		for (String temp : formIDs) {
			YfmexbankA yfmexbankA = find(temp);
			if (null != costTypeId && !"".equals(costTypeId.trim()))
				yfmexbankA.setCostTypeId(Integer.parseInt(costTypeId));

			// �����״̬
			if (yfmexbankA.getExbankStatus().equals("������"))
				yfmexbankA.setExbankStatus("�Ѹ���δ��ҩ");
			if (yfmexbankA.getExbankStatus().equals("����ҩδ����"))
				yfmexbankA.setExbankStatus("�Ѹ�������ҩ");
			// סԺ��״̬
			if (yfmexbankA.getExbankStatus().equals("����ҩ"))
				yfmexbankA.setExbankStatus("�Ѹ�������ҩ");

		}

	}

	public boolean addYfmexbankA(YfmexbankA yfmexbankA) {
		this.getHibernateTemplate().save(yfmexbankA);
		return true;
	}

	public String getMaxID() {
		Query query = null; // ����һ����ѯ����
		query = this.getSession().createQuery(
				"select a.aformId from YfmexbankA a order by a.aformId desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "no";
		else
			return list.get(0);
	}

	public boolean delYFMExbankA(String AFormID) {
		this.delete(AFormID);
		return true;
	}

	public List<YfmexbankA> getYaofangChuKu(String AFormID,
			Integer ExbankTypeID, String ATime_B, String ATime_e,
			Integer PharmacyID, String ExbankStatus, Integer AU,
			Long PersonToGetM) {
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (AFormID != null && !AFormID.equals("")) {
			tj = tj + " aformId = ?"; // AFormID, ���뵥ID
			cs.add(AFormID);
		}
		if (ExbankTypeID != -2) { // ExbankTypeID, ���뵥����ID
			if (tj.equals(""))
				tj = " exbankTypeId = ?";
			else
				tj = tj + " and exbankTypeId = ?";
			cs.add(ExbankTypeID);
		}
		if (ATime_B != null && !ATime_B.equals("")) { // ATime, ����ʱ��
			if (tj.equals(""))
				tj = " atime >= ? and atime <= ?";
			else
				tj = tj + " and atime >= ? and atime <= ?";
			cs.add(DateUtil.stringToDateTime(ATime_B));
			cs.add(DateUtil.stringToDateTime(ATime_e));
		}
		if (PharmacyID != -2) {
			if (tj.equals(""))
				tj = " pharmacyId = ?";
			else
				tj = tj + " and pharmacyId = ?";
			cs.add(PharmacyID);
		}
		if (ExbankStatus != null && !ExbankStatus.equals("")) {
			if (tj.equals(""))
				tj = " exbankStatus = ?";
			else
				tj = tj + " and exbankStatus = ?";
			cs.add(ExbankStatus);
		}
		if (AU != -2) {
			if (tj.equals(""))
				tj = " au = ?";
			else
				tj = tj + " and au = ?";
			cs.add(AU);
		}
		if (PersonToGetM != -2) {
			if (tj.equals(""))
				tj = " personToGetM = ?";
			else
				tj = tj + " and personToGetM = ?";
			cs.add(PersonToGetM);
		}

		List<YfmexbankA> list = null;

		if (tj != null && !tj.equals("")) {
			list = this.getHibernateTemplate().find(
					"from YfmexbankA where" + tj, cs.toArray());
		} else {
			list = this.getHibernateTemplate().find("from YfmexbankA");
		}
		return list;
	}

	public boolean updatePiZun(String AFormID, String approveTime,
			String ExbankStatus, Long ckryid) {
		Query query = null; // ����һ����ѯ����
		query = this
				.getSession()
				.createSQLQuery(
						"update YfmexbankA set exbankStatus = ?,approveTime = ?, estaffId = ? where aformId = ?");
		query.setParameter(0, ExbankStatus);
		query.setParameter(1, approveTime);
		query.setParameter(2, ckryid);
		query.setParameter(3, AFormID);
		query.executeUpdate();
		return true;
	}

	public boolean updateChuKu(String AFormID, String ExbankTime,
			String ExbankStatus) {
		Query query = null; // ����һ����ѯ����
		query = this
				.getSession()
				.createSQLQuery(
						"update YfmexbankA set exbankStatus = ?,exbankTime = ? where aformId = ?");
		query.setParameter(0, ExbankStatus);
		query.setParameter(1, ExbankTime);
		query.setParameter(2, AFormID);
		query.executeUpdate();
		return true;
	}

	public boolean updateYaofangChuKu(String RuKuDanhao, Integer RuKuRenID,
			String RuKuShiJian, String ZhuangKuang) {
		Query query = null; // ����һ����ѯ����
		query = this
				.getSession()
				.createSQLQuery(
						"update YfmexbankA set personToGetM = ?,exbankTime = ?,exbankStatus = ? where inAformId = ?");
		query.setParameter(0, RuKuRenID);
		query.setParameter(1, RuKuShiJian);
		query.setParameter(2, ZhuangKuang);
		query.setParameter(3, RuKuDanhao);
		query.executeUpdate();
		return true;
	}

	public boolean updateQuYaoRen(String AFormID, Long QYRID, String CKSJ,
			String ZT, Long FYRID) {
		Query query = null; // ����һ����ѯ����
		query = this
				.getSession()
				.createSQLQuery(
						"update YfmexbankA set personToGetM = ?,exbankTime = ?,exbankStatus = ?, estaffId = ?  where aformId = ?");
		query.setParameter(0, QYRID);
		query.setParameter(1, CKSJ);
		query.setParameter(2, ZT);
		query.setParameter(3, FYRID);
		query.setParameter(4, AFormID);
		query.executeUpdate();
		return true;
	}

	public String[][] getMenZhenChuKuDan(String XingMing, String SuoXie,
			String MenZhenHao, String KaiShiShiJian, String JieSuShiJian,
			String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID) {
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;

		if (XingMing != null && !XingMing.equals("")) {
			tj = "CSConsumer.CSName like ?"; // ����
			cs.add("%" + XingMing + "%");
		}
		if (SuoXie != null && !SuoXie.equals("")) { // ������д
			if (tj.equals(""))
				tj = " CSConsumer.NameForShort = ?";
			else
				tj = tj + " and CSConsumer.NameForShort = ?";
			cs.add(SuoXie);
		}
		if (MenZhenHao != null && !MenZhenHao.equals("")) { // �����
			if (tj.equals(""))
				tj = " YFMExbankA.OPNum = ?";
			else
				tj = tj + " and  YFMExbankA.OPNum = ?";
			cs.add(MenZhenHao);
		}
		if (KaiShiShiJian != null && !KaiShiShiJian.equals("")) { // ����ʱ��
			if (tj.equals(""))
				tj = " YFMExbankA.ATime >= ? and YFMExbankA.ATime <= ?";
			else
				tj = tj
						+ " and YFMExbankA.ATime >= ? and YFMExbankA.ATime <= ?";
			cs.add(DateUtil.stringToDateTime(KaiShiShiJian));
			cs.add(DateUtil.stringToDateTime(JieSuShiJian));
		}
		if (ZhuangTai != null && !ZhuangTai.equals("")) {
			if (tj.equals(""))
				tj = " YFMExbankA.ExbankStatus = ?";
			else
				tj = tj + " and YFMExbankA.ExbankStatus = ?";
			cs.add(ZhuangTai);
		}
		if (ChuKuLeiXingID != -2) {
			if (tj.equals(""))
				tj = " YFMExbankA.ExbankTypeID = ?";
			else
				tj = tj + " and YFMExbankA.ExbankTypeID = ?";
			cs.add(ChuKuLeiXingID);
		}
		if (YaoFangID != -2) {
			if (tj.equals(""))
				tj = " YFMExbankA.PharmacyID = ?";
			else
				tj = tj + " and YFMExbankA.PharmacyID = ?";
			cs.add(YaoFangID);
		}

		// List<YfmexbankA> list = null;

		if (tj != null && !tj.equals("")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "   YFMExbankA.AformId,YFMExbankA.PersonToGetM,YFMExbankA.Opnum, YFMExbankA.OpDnID, CSConsumer.CSName, CSConsumer.IDCardNum, CSConsumer.Address "
									+ "from "
									+ "   MZOpDn,CSConsumer,YFMExbankA "
									+ "where "
									+ "   mzopdn.CsID = CSConsumer.csid and "
									+ "   MZopDn.OpDnID = YFMExbankA.OpDnID and"
									+ tj);
			for (int i = 0; i < cs.size(); i++) {
				query.setParameter(i, cs.get(i));
			}
		} else {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "   YFMExbankA.AformId,YFMExbankA.PersonToGetM,YFMExbankA.Opnum, YFMExbankA.OpDnID, CSConsumer.CSName, CSConsumer.IDCardNum, CSConsumer.Address "
									+ "from "
									+ "   MZOpDn,CSConsumer,YFMExbankA "
									+ "where "
									+ "   mzopdn.CsID = CSConsumer.csid and "
									+ "   MZopDn.OpDnID = YFMExbankA.OpDnID");
		}

		query.list();
		return listObject2StringString(query.list()); // ִ��SQL���(�����ؽ��query.list()ǿ��ת��ΪList<Object[]>����)
	}

	public String[][] getZhuYuanChuKuDan(String XingMing, String SuoXie,
			String ZhuYuanHao, String KaiShiShiJian, String JieSuShiJian,
			String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID) {
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;

		if (XingMing != null && !XingMing.equals("")) {
			tj = "CSConsumer.CSName like ?"; // ����
			cs.add("%" + XingMing + "%");
		}
		if (SuoXie != null && !SuoXie.equals("")) { // ������д
			if (tj.equals(""))
				tj = " CSConsumer.NameForShort = ?";
			else
				tj = tj + " and CSConsumer.NameForShort = ?";
			cs.add(SuoXie);
		}
		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")) { // סԺ��
			if (tj.equals(""))
				tj = " YFMExbankA.OPNum = ?";
			else
				tj = tj + " and  YFMExbankA.OPNum = ?";
			cs.add(ZhuYuanHao);
		}
		if (KaiShiShiJian != null && !KaiShiShiJian.equals("")) { // ����ʱ��
			if (tj.equals(""))
				tj = " YFMExbankA.ATime >= ? and YFMExbankA.ATime <= ?";
			else
				tj = tj
						+ " and YFMExbankA.ATime >= ? and YFMExbankA.ATime <= ?";
			cs.add(DateUtil.stringToDateTime(KaiShiShiJian));
			cs.add(DateUtil.stringToDateTime(JieSuShiJian));
		}
		if (ZhuangTai != null && !ZhuangTai.equals("")) {
			if (tj.equals(""))
				tj = " YFMExbankA.ExbankStatus = ?";
			else
				tj = tj + " and YFMExbankA.ExbankStatus = ?";
			cs.add(ZhuangTai);
		}
		if (ChuKuLeiXingID != -2) {
			if (tj.equals(""))
				tj = " YFMExbankA.ExbankTypeID = ?";
			else
				tj = tj + " and YFMExbankA.ExbankTypeID = ?";
			cs.add(ChuKuLeiXingID);
		}
		if (YaoFangID != -2) {
			if (tj.equals(""))
				tj = " YFMExbankA.PharmacyID = ?";
			else
				tj = tj + " and YFMExbankA.PharmacyID = ?";
			cs.add(YaoFangID);
		}

		// List<YfmexbankA> list = null;

		if (tj != null && !tj.equals("")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "   YFMExbankA.AformId,"
									+ // 0���뵥ID
									"   YFMExbankA.PersonToGetM,"
									+ // 1�������ID
									"   YFMExbankA.Opnum,"
									+ // 2סԺ��
									"   ZYDoctorAdvice.DAID,"
									+ // 3ҽ��ID
									"   CSConsumer.CSName,"
									+ // 4����
									"   CSConsumer.IDCardNum,"
									+ // 5���֤��
									"   CSConsumer.Address "
									+ // 6סַ
									"from "
									+ "   CSConsumer,YFMExbankA,ZYDoctorAdvice "
									+ "where "
									+ "   YFMExbankA.PersonToGetM  = CSConsumer.CsID and "
									+ "   ZYDoctorAdvice.AFormID = YFMExbankA.AFormID and "
									+ tj);
			for (int i = 0; i < cs.size(); i++) {
				query.setParameter(i, cs.get(i));
			}
		} else {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "   YFMExbankA.AformId,"
									+ "   YFMExbankA.PersonToGetM,"
									+ "   YFMExbankA.Opnum,"
									+ "   ZYDoctorAdvice.DAID,"
									+ "   CSConsumer.CSName,"
									+ "   CSConsumer.IDCardNum,"
									+ "   CSConsumer.Address "
									+ "from "
									+ "   CSConsumer,YFMExbankA,ZYDoctorAdvice "
									+ "where "
									+ "   YFMExbankA.PersonToGetM  = CSConsumer.CsID and "
									+ "   ZYDoctorAdvice.AFormID = YFMExbankA.AFormID");
		}

		query.list();
		return listObject2StringString(query.list()); // ִ��SQL���(�����ؽ��query.list()ǿ��ת��ΪList<Object[]>����)
	}

	/**
	 * ����������ѯ�������뵥
	 */
	public YfmexbankA getYfmexbankAByAformId(String aformId) {
		try {
			return (YfmexbankA) super.getHibernateTemplate().get(
					YfmexbankA.class, aformId);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��������ѯ�������뵥
	 */
	public YfmexbankA getYfmexbankAByTiaojian(String aformId, String startDate,
			String endDate, String exbankStatus, String validityPeriod) {
		String hql = "from YfmexbankA where aformId='" + aformId
				+ "' and atime<'" + validityPeriod + "' ";
		if (!"".equals(startDate) && !"".equals(endDate)) {
			hql += "and (atime between '" + startDate + "' and '" + endDate
					+ "') ";
		}
		if (!"".equals(exbankStatus)) {
			hql += "and exbankStatus='" + exbankStatus + "' ";
		}
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		if (query.list().size() > 0) {
			return (YfmexbankA) query.list().get(0);
		}
		return null;
	};

	/**
	 * ҩƷ����ͳ��
	 * 
	 * @param lxid
	 *            ��������ID
	 * @param ckzt
	 *            ����״̬
	 * @param k_date
	 *            ��ʼʱ��
	 * @param j_date
	 *            ����ʱ��
	 * @param xm
	 *            ����
	 * @param xmsx
	 *            ������д
	 * @param yfid
	 *            ҩ��ID
	 * @param qyid
	 *            ȡҩ��ԱID
	 * @param qyks
	 *            ȡҩ����ID
	 * @param ckdlx
	 *            ���ⵥ����
	 * @return
	 */
	public String[][] getChuKuTongJi(String ckdlx, Integer lxid, String ckzt,
			String k_date, String j_date, String xm, String xmsx, Integer yfid,
			Long qyid, Integer qyks) {
		String tj;
		String bm;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		bm = "";
		Query query = null;

		if (ckdlx.equals("����")) {
			bm = "  yfexbankaitem, yfmexbanka, YFMInfo, MZOpDn, CSConsumer ";
			tj = "  yfexbankaitem.aformid = yfmexbanka.aformid and "
					+ "  yfexbankaitem.mid = YFMInfo.MInfoID and "
					+ "  MZopDn.OpDnID = YFMExbankA.OpDnID and "
					+ "  mzopdn.CsID = CSConsumer.csid";
		}
		if (ckdlx.equals("סԺ")) {
			bm = " YFMExbankA, YFExbankAItem, YFMInfo, ZYInpatient, CSConsumer ";
			tj = " YFMExbankA.AFormID = YFExbankAItem.AFormID and "
					+ "yfexbankaitem.mid = YFMInfo.MInfoID and "
					+ "ZYInpatient.CsID = YFMExbankA.PersonToGetM and "
					+ "ZYInpatient.CsID = CSConsumer.CsID";
		}

		if (ckdlx.equals("Ա��") || ckdlx.equals("����") || ckdlx.equals("����")
				|| ckdlx.equals("ҩ��") || ckdlx.equals("����")
				|| ckdlx.equals("�̵�")) {
			bm = " YFMExbankA, " + " YFExbankAItem, " + " YFMInfo ";
			tj = "  YFMExbankA.AFormID = YFExbankAItem.AFormID and"
					+ " yfexbankaitem.mid = YFMInfo.MInfoID";
		}

		if (lxid != -2) {
			tj = tj + " and yfmexbanka.exbanktypeid = ?"; // ��������ID
			cs.add(lxid);
		}
		if (ckzt != null && !ckzt.equals("")) { // ����״̬
			tj = tj + " and yfmexbanka.exbankstatus = ?";
			cs.add(ckzt);
		}
		if (k_date != null && !k_date.equals("")) { // ʱ��
			tj = tj + " and YFMExbankA.ATime >= ? and YFMExbankA.ATime <= ?";
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
			tj = tj + " and YFMExbankA.PharmacyID = ?";
			cs.add(yfid);
		}
		if (qyid != -2) {// ȡҩ��ԱID
			tj = tj + " and YFMExbankA.PersonToGetM = ?";
			cs.add(qyid);
		}
		if (qyks != -2) {// ȡҩ����ID
			tj = tj + " and YFMExbankA.AU = ?";
			cs.add(qyks);
		}

		if (tj != null && !tj.equals("")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "  YFMInfo.MName, "
									+ "  YFMInfo.MSpec, "
									+ "  YFMInfo.Manufacturer, "
									+ "  yfexbankaitem.Unit as dw, "
									+ "  yfexbankaitem.Price as dj, "
									+ "  sum(yfexbankaitem.Num) as sl, "
									+ "  sum(yfexbankaitem.Num * yfexbankaitem.Price) as xj "
									+ "from " + bm + "where " + tj
									+ " group by " + "  YFMInfo.MName, "
									+ "  YFMInfo.MSpec, "
									+ "  YFMInfo.Manufacturer, "
									+ "  yfexbankaitem.Unit, "
									+ "  yfexbankaitem.Price");
			for (int i = 0; i < cs.size(); i++) {
				query.setParameter(i, cs.get(i));
			}
		}
		query.list();
		return listObject2StringString(query.list()); // ִ��SQL���(�����ؽ��query.list()ǿ��ת��ΪList<Object[]>����)

	}

	public YfmexbankA getYfmexbankAByOPNum(String opNum) {
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from YfmexbankA g where g.opnum=?  order by g.opDnId desc");
			query.setParameter(0, opNum);
			if (query.list().size() > 0) {
				return (YfmexbankA) query.list().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public YfmexbankA getYfmexbankAByOPDnID(String OPDnID) {
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from YfmexbankA g where g.opDnId=?  order by g.opDnId desc");
			query.setParameter(0, OPDnID);
			if (query.list().size() > 0) {
				return (YfmexbankA) query.list().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public List<String> getIds(String inpatientId, String type,
			List<String> paramList2) {
		String sql = "select t1.AFormID from YfmexbankA t1,YFSetExbankType t2 "
				+ "where t1.ExbankTypeID=t2.ExbankID and t1.OPNum=? and t2.ETypeName=?";
		if (null != paramList2 && paramList2.size() > 0)
			sql += " and t1.ExbankStatus in (:status)";

		// ���ֻ��ѯ����ĵ���
		// if (type.indexOf("����") > -1) {
		// sql += " and DATEDIFF(DAY,t1.atime,GETDATE())=0 ";
		// }

		Query query = getSession().createSQLQuery(sql);
		query.setParameter(0, inpatientId).setParameter(1, type);
		if (null != paramList2 && paramList2.size() > 0)
			query.setParameterList("status", paramList2);

		return (List<String>) query.list();

	}

	public String[][] getZhuYuanYaoPingQingDan(String ZhuYuanHao,
			String ShenQingShiJian_B, String ShenQingShiJian_E, String ZhuangTai) {
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;

		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")) {
			tj = " YFMExbankA.OPNum = ?"; // סԺ��
			cs.add(ZhuYuanHao);
		}
		if (ShenQingShiJian_B != null && !ShenQingShiJian_B.equals("")) { // ����ʱ��
			if (tj.equals(""))
				tj = " YFMExbankA.ATime >= ? and YFMExbankA.ATime <= ?";
			else
				tj = tj
						+ " and YFMExbankA.ATime >= ? and YFMExbankA.ATime <= ?";
			cs.add(ShenQingShiJian_B);
			cs.add(ShenQingShiJian_E);
		}
		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")) { // סԺ��
			if (tj.equals(""))
				tj = " YFMExbankA.OPNum = ?";
			else
				tj = tj + " and  YFMExbankA.OPNum = ?";
			cs.add(ZhuYuanHao);
		}
		if (ZhuangTai != null && !ZhuangTai.equals("")) { // ״̬
			if (tj.equals(""))
				tj = " YFMExbankA.ExbankStatus = ?";
			else
				tj = tj + " and YFMExbankA.ExbankStatus = ?";
			cs.add(ZhuangTai);
		}
		if (tj != null && !tj.equals("")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select YFExbankAItem.MID,"
									+ // 0ҩƷID
									"   YFMInfo.MName,"
									+ // 1ҩƷ����
									"   YFMInfo.MSpec,"
									+ // 2ҩƷ���
									"   YFExbankAItem.Num,"
									+ // 3����
									"   YFExbankAItem.Unit,"
									+ // 4��λ
									"   YFExbankAItem.Price,"
									+ // 5����
									"   YFExbankAItem.PReceivable,"
									+ // 6Ӧ��
									"   YFExbankAItem.ReduceMoney,"
									+ // 7����
									"   YFExbankAItem.PReturned,"
									+ // 8���˼۸�
									"   YFExbankAItem.NumReturned,"
									+ // 9������
									"   (PReceivable - ReduceMoney -PReturned) as ShiShou "
									+ // 10ʵ��
									"from "
									+ "   YFExbankAItem,YFMExbankA,YFMInfo "
									+ "where "
									+ "   YFExbankAItem.MID = YFMInfo.MInfoID and "
									+ "   YFExbankAItem.AFormID = YFMExbankA.AFormID and "
									+ tj);
			for (int i = 0; i < cs.size(); i++) {
				query.setParameter(i, cs.get(i));
			}
		} else {
			query = this
					.getSession()
					.createSQLQuery(
							"select YFExbankAItem.MID,"
									+ "   YFMInfo.MName,"
									+ "   YFMInfo.MSpec,"
									+ "   YFExbankAItem.Num,"
									+ "   YFExbankAItem.Unit,"
									+ "   YFExbankAItem.Price,"
									+ "   YFExbankAItem.PReceivable,"
									+ "   YFExbankAItem.ReduceMoney,"
									+ "   YFExbankAItem.PReturned,"
									+ "   YFExbankAItem.NumReturned,"
									+ "   (PReceivable - ReduceMoney -PReturned) as ShiShou "
									+ "from "
									+ "   YFExbankAItem,YFMExbankA,YFMInfo "
									+ "where "
									+ "   YFExbankAItem.MID = YFMInfo.MInfoID and "
									+ "   YFExbankAItem.AFormID = YFMExbankA.AFormID");
		}

		query.list();
		return listObject2StringString(query.list()); // ִ��SQL���(�����ؽ��query.list()ǿ��ת��ΪList<Object[]>����)
	}

	public Double getChuFangZhuYuanZongJinE(String ZhuYuanHao) {
		Query query = null; // ����һ����ѯ����
		query = this
				.getSession()
				.createSQLQuery(
						"select "
								+ "   ISNULL(sum (YFExbankAItem.PReceivable - YFExbankAItem.PReturned - YFExbankAItem.ReduceMoney),0) as je "
								+ "from "
								+ "   YFMExbankA,YFExbankAItem "
								+ "where "
								+ "   YFMExbankA.AFormID = YFExbankAItem.AFormID and "
								+ "   ExbankStatus = '����ҩ' and "
								+ "   OPNum = ?");
		query.setParameter(0, ZhuYuanHao);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Double> list = (List<Double>) query.list();
		if (list.size() < 1)
			return 0d;
		else
			return list.get(0);
	}

	public List<List<String>> getTownAllocateApplicationBill(Integer townId,
			String status, String applicationBillNO, String startTime,
			String endTime) {

		StringBuilder sb = new StringBuilder();
		sb.append("select t1.AFormID,t3.TownName,t1.ATime,t1.au"
				+ " from YFMExbankA t1,YFSetExbankType t2,SFTownAllocate t3 "
				+ "where t1.ExbankTypeID=t2.ExbankID" + " and t1.au=t3.TownID");
		List<Object> paramList = new ArrayList<Object>();
		if (null != townId && 0 != townId.intValue()) {
			sb.append(" and t1.au=?");
			paramList.add(townId);
		}

		if (null != status && !"".equals(status)) {
			sb.append(" and t1.ExbankStatus=?");
			paramList.add(status);
		}

		if (null != applicationBillNO && !"".equals(applicationBillNO)) {
			sb.append(" and t1.AFormID=?");
			paramList.add(applicationBillNO);
		}

		if (null != startTime && !"".equals(startTime)) {
			sb.append(" and t1.ATime >=?");
			paramList.add(DateUtil.get000000DateTime(startTime));
		}
		if (null != endTime && !"".equals(endTime)) {
			sb.append(" and t1.ATime<=?");
			paramList.add(DateUtil.get235959DateTime(endTime));
		}
		Query query = getSession().createSQLQuery(sb.toString());
		for (int i = 0; i < paramList.size(); i++) {
			query.setParameter(i, paramList.get(i));
		}

		return listObject2ListString(query.list());
	}

	public String[][] getYfmexbanka(String XingMing, String SuoXie,
			String Idcardnum, String MenZhenHao, String KaiShiShiJian,
			String JieSuShiJian, String ZhuangTai, Integer ChuKuLeiXingID,
			Integer YaoFangID) {
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;

		if (XingMing != null && !XingMing.equals("")) {
			tj = " CSConsumer.CSName like ?"; // ����
			cs.add("%" + XingMing + "%");
		}
		if (SuoXie != null && !SuoXie.equals("")) { // ������д
			if (tj.equals(""))
				tj = " CSConsumer.NameForShort = ?";
			else
				tj = tj + " and CSConsumer.NameForShort = ?";
			cs.add(SuoXie);
		}

		if (Idcardnum != null && !Idcardnum.equals("")) {
			if (tj.equals(""))
				tj = " CSConsumer.idcardNum =?"; // ���֤
			else
				tj = tj + " and  CSConsumer.idcardNum = ?";
			cs.add(Idcardnum);
		}

		if (MenZhenHao != null && !MenZhenHao.equals("")) { // �����
			if (tj.equals(""))
				tj = " YFMExbankA.OPNum = ?";
			else
				tj = tj + " and  YFMExbankA.OPNum = ?";
			cs.add(MenZhenHao);
		}
		if (KaiShiShiJian != null && !KaiShiShiJian.equals("")) { // ����ʱ��
			if (tj.equals(""))
				tj = " YFMExbankA.ATime >= ? and YFMExbankA.ATime <= ?";
			else
				tj = tj
						+ " and YFMExbankA.ATime >= ? and YFMExbankA.ATime <= ?";
			cs.add(DateUtil.stringToDate(KaiShiShiJian));
			cs.add(DateUtil.stringToDate(JieSuShiJian));
		}
		if (ZhuangTai != null && !ZhuangTai.equals("")) {
			if (tj.equals(""))
				tj = " YFMExbankA.ExbankStatus = ?";
			else
				tj = tj + " and YFMExbankA.ExbankStatus = ?";
			cs.add(ZhuangTai);
		}
		if (ChuKuLeiXingID != -2) {
			if (tj.equals(""))
				tj = " YFMExbankA.ExbankTypeID = ?";
			else
				tj = tj + " and YFMExbankA.ExbankTypeID = ?";
			cs.add(ChuKuLeiXingID);
		}
		if (YaoFangID != -2) {
			if (tj.equals(""))
				tj = " YFMExbankA.PharmacyID = ?";
			else
				tj = tj + " and YFMExbankA.PharmacyID = ?";
			cs.add(YaoFangID);
		}

		// List<YfmexbankA> list = null;

		if (tj != null && !tj.equals("")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "   YFMExbankA.AformId,YFMExbankA.PersonToGetM,YFMExbankA.Opnum, YFMExbankA.OpDnID,YFMExbankA.atime,YFMExbankA.pharmacyId, CSConsumer.CSName, CSConsumer.IDCardNum,YFMExbankA.inAformId "
									+ "from "
									+ "   MZOpDn,CSConsumer,YFMExbankA "
									+ "where "
									+ "   mzopdn.CsID = CSConsumer.csid and "
									+ "   MZopDn.OpDnID = YFMExbankA.OpDnID and"
									+ tj);
			for (int i = 0; i < cs.size(); i++) {
				query.setParameter(i, cs.get(i));
			}
		} else {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "   YFMExbankA.AformId,YFMExbankA.PersonToGetM,YFMExbankA.Opnum, YFMExbankA.OpDnID,YFMExbankA.atime,YFMExbankA.pharmacyId, CSConsumer.CSName, CSConsumer.IDCardNum,YFMExbankA.inAformId "
									+ "from "
									+ "   MZOpDn,CSConsumer,YFMExbankA "
									+ "where "
									+ "   mzopdn.CsID = CSConsumer.csid and "
									+ "   MZopDn.OpDnID = YFMExbankA.OpDnID");
		}

		query.list();
		return listObject2StringString(query.list()); // ִ��SQL���(�����ؽ��query.list()ǿ��ת��ΪList<Object[]>����)
	}

	public boolean updateChuKuforruku(String AFormID, String rukuid) {
		Query query = null; // ����һ����ѯ����
		query = this.getSession().createSQLQuery(
				"update YfmexbankA set inAformId = ? where aformId = ?");
		query.setParameter(0, rukuid);
		query.setParameter(1, AFormID);
		query.executeUpdate();
		return true;
	}

	public List<YfmexbankA> getYfmexbankAlistByOPDnID(String OPDnID) {
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from YfmexbankA g where g.opDnId=?  order by g.opDnId desc");
			query.setParameter(0, OPDnID);
			if (query.list().size() > 0) {
				return (List<YfmexbankA>) query.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public int getCFCount(String opnum, String... status) {

		Object obj = getSession()
				.createSQLQuery(
						"select count(a.OPNum) from YfmexbankA a where a.OPNum=? and a.ExbankStatus in (:status)")
				.setParameter(0, opnum).setParameterList("status", status)
				.uniqueResult();
		return (Integer) obj;
	}

	public void updateYFmbankStatus(Set<String> storageApplicationFormIds,
			String status) {

		StringBuilder sb = new StringBuilder();
		sb.append("update YfmexbankA s set s.exbankStatus=? ");

		if (null != storageApplicationFormIds
				&& storageApplicationFormIds.size() > 0) {
			sb.append(" where s.aformId in (:itemId)");
		}
		Query query = getSession().createQuery(sb.toString());
		query.setParameter(0, status);
		if (null != storageApplicationFormIds
				&& storageApplicationFormIds.size() > 0) {
			query.setParameterList("itemId", storageApplicationFormIds);
		}
		query.executeUpdate();
	}

}
