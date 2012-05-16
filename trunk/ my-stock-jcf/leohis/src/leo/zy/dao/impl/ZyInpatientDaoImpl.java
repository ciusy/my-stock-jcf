package leo.zy.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.common.util.DateUtil;
import leo.entity.Zyinpatient;
import leo.zy.dao.iface.ZyInpatientDao;

import org.hibernate.Query;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 4, 2011 4:23:33 PM
 */
public class ZyInpatientDaoImpl extends DaoSupport<Zyinpatient> implements
		ZyInpatientDao {

	@SuppressWarnings("unchecked")
	public List<Zyinpatient> getCurrentDayInPatient(
			List<Integer> inPatientDeptIds, String inPatientStatus) {

		return getSession()
				.createQuery(
						"from Zyinpatient z where z.iptime>=? and z.iptime<=? and astatus=? and ipdeptId in (:inPatientDeptIds)")
				.setParameter(0, DateUtil.getNowDay000000Start())
				.setParameter(1, DateUtil.getNowDay235959End())
				.setParameter(2, inPatientStatus)
				.setParameterList("inPatientDeptIds", inPatientDeptIds).list();
	}

	@SuppressWarnings("unchecked")
	public List<Zyinpatient> getInpatient(List<Integer> inPatientDeptIds,
			List<Long> consumerIds, String ipId, String startTime,
			String endTime, String inPatientStatus, String bedNo) {
		StringBuilder sb = new StringBuilder();
		sb.append("from Zyinpatient m where 1=1");

		List<Object> list = new ArrayList<Object>();
		if (null != ipId && !"".equals(ipId)) {
			sb.append(" and m.ipid=?");
			list.add(ipId);
		}
		if (null != startTime && !"".equals(startTime.trim())) {
			sb.append(" and m.iptime>=? ");
			list.add(DateUtil.get000000DateTime(startTime));
		}

		if (null != endTime && !"".equals(endTime.trim())) {
			sb.append(" and m.iptime <= ?");
			list.add(DateUtil.get235959DateTime(endTime));
		}

		if (null != inPatientStatus && !"".equals(inPatientStatus.trim())) {
			sb.append(" and m.astatus = ?");
			list.add(inPatientStatus);
		}

		if (null != bedNo && !"".equals(bedNo.trim())) {
			sb.append(" and m.bed = ?");
			list.add(bedNo);
		}
		if (null != consumerIds && consumerIds.size() > 0) {
			sb.append(" and m.csId in (:csIds)");
		}

		if (null != inPatientDeptIds && inPatientDeptIds.size() > 0) {
			sb.append(" and m.ipdeptId in (:inPatientDeptIds)");
		}
		Query query = getSession().createQuery(sb.toString());
		for (int i = 0; i < list.size(); i++) {
			query.setParameter(i, list.get(i));
		}

		if (null != consumerIds && consumerIds.size() > 0) {
			query.setParameterList("csIds", consumerIds);
		}

		if (null != inPatientDeptIds && inPatientDeptIds.size() > 0) {
			query.setParameterList("inPatientDeptIds", inPatientDeptIds);
		}
		return query.list();
	}

	public String[][] getHuShiShouYeZhuYuanRenYuan(String zyh, Integer cwh,
			String xm, String xmsx, Integer zybID, Long zrhs) {
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;

		if (zyh != null && !zyh.equals("")) {
			tj = "ZYInpatient.IPID = ?"; // סԺ��
			cs.add(zyh);
		}
		if (cwh != -2) { // ��λ��
			if (tj.equals(""))
				tj = " ZYInpatient.Bed = ?";
			else
				tj = tj + " and ZYInpatient.Bed = ?";
			cs.add(cwh);
		}
		if (xm != null && !xm.equals("")) { // ����
			if (tj.equals(""))
				tj = " CSConsumer.CSName like ?";
			else
				tj = tj + " and CSConsumer.CSName like ?";
			cs.add("%" + xm + "%");
		}
		if (xmsx != null && !xmsx.equals("")) { // ������д
			if (tj.equals(""))
				tj = " CSConsumer.NameForShort like ?";
			else
				tj = tj + " and CSConsumer.NameForShort like ?";
			cs.add("%" + xmsx + "%");
		}
		if (zybID != -2) { // סԺ��ID
			if (tj.equals(""))
				tj = " ZYInpatient.IPDeptID = ?";
			else
				tj = tj + " and ZYInpatient.IPDeptID = ?";
			cs.add(zybID);
		}
		if (zrhs != -2) { // ���λ�ʿ
			if (tj.equals(""))
				tj = " ZYBed.NurseInCharge = ?";
			else
				tj = tj + " and ZYBed.NurseInCharge = ?";
			cs.add(zrhs);
		}
		if (tj != null && !tj.equals("")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "   CSConsumer.CSName, "
									+ // ���� 0
									"   CSConsumer.Sex, "
									+ // �Ա� 1
									"   CSConsumer.Birthday, "
									+ // �������� 2
									"   ZYInpatient.IPID, "
									+ // סԺID 3
									"   ZYInpatient.Bed, "
									+ // ��λ�� 4
									"   (select CostType from GHCostType where id = ZYInpatient.ChargeType) as fylx,"
									+ // �������� 5
									"   ZYInpatient.ChargeType, "
									+ // ��������ID 6
									"   ZYInpatient.AStatus, "
									+ // ����״̬ 7
									"   ZYInpatient.DepositBalance, "
									+ // סԺѺ����� 8
									"   (select SName from OSStuff where SID = ZYBed.AttendingDoctor) as zzys, "
									+ // ����ҽʦ 9
									"   (select SName from OSStuff where SID = ZYBed.NurseInCharge) as zrhs, "
									+ // ���λ�ʿ 10
									"   ZYBed.AttendingDoctor, "
									+ // ����ҽʦID 11
									"   ZYBed.NurseInCharge, "
									+ // ���λ�ʿID 12
									"   ZYInpatient.IPTime, "
									+ // ��Ժʱ�� 13
									"   CSConsumer.CsID "
									+ // �������ID 14
									"from "
									+ "   CSConsumer, ZYInpatient, ZYBed "
									+ "where "
									+ "   CSConsumer.CsID = ZYInpatient.CsID and "
									+ "   ZYInpatient.bed = ZYBed.Bed and "
									+ "   ZYInpatient.IPDeptID = ZYBed.IPDeptID and "
									+ "   ZYInpatient.AStatus <> '�ѳ�Ժ' and "
									+ tj);
			for (int i = 0; i < cs.size(); i++) {
				query.setParameter(i, cs.get(i));
			}
		} else {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "   CSConsumer.CSName, "
									+ "   CSConsumer.Sex, "
									+ "   CSConsumer.Birthday, "
									+ "   ZYInpatient.IPID, "
									+ "   ZYInpatient.Bed, "
									+ "   (select CostType from GHCostType where id = ZYInpatient.ChargeType) as fylx,"
									+ // ��������
									"   ZYInpatient.ChargeType, "
									+ "   ZYInpatient.AStatus, "
									+ "   ZYInpatient.DepositBalance, "
									+ "   (select SName from OSStuff where SID = ZYBed.AttendingDoctor) as zzys, "
									+ "   (select SName from OSStuff where SID = ZYBed.NurseInCharge) as zrhs, "
									+ "   ZYBed.AttendingDoctor, "
									+ "   ZYBed.NurseInCharge "
									+ "from "
									+ "   CSConsumer, ZYInpatient, ZYBed "
									+ "where "
									+ "   CSConsumer.CsID = ZYInpatient.CsID and "
									+ "   ZYInpatient.bed = ZYBed.Bed and "
									+ "   ZYInpatient.IPDeptID = ZYBed.IPDeptID and "
									+ "   ZYInpatient.AStatus <> '�ѳ�Ժ'");
		}
		query.list();
		return listObject2StringString(query.list());
	}

	public String getMaxID() {
		Query query = null; // ����һ����ѯ����
		query = this.getSession().createQuery(
				"select a.ipid from Zyinpatient a order by a.ipid desc");
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "no";
		else
			return list.get(0);
	}

	public boolean addZYInpatient(Zyinpatient zyinpatient) {
		this.getHibernateTemplate().save(zyinpatient);
		return true;
	}

	/**
	 * ����סԺ��
	 * 
	 * @param ZhuYuanHao
	 *            סԺID
	 * @param ChuangWeiHao
	 *            ��λ��
	 * @param XingMing
	 *            ����
	 * @param XingMingSuoXie
	 *            ������д
	 * @param ShengQingShiJian_B
	 *            ������Ժ��ʼʱ��
	 * @param ShengQingShiJian_E
	 *            ������Ժ����ʱ��
	 * @param RuYuanShiJian_B
	 *            ��Ժ��ʼʱ��
	 * @param RuYuanShiJian_E
	 *            ��Ժ����ʱ��
	 * @param ShengQingZhuangTai
	 *            ����״̬
	 * @param YueE1
	 *            ������
	 * @param GuanXi
	 *            ����ѯ��ϵ> < >= <=
	 * @param ShiFouChuYuan
	 *            �Ƿ��Ժ
	 * @param ChuYuanShiJian_B
	 *            ��Ժ��ʼʱ��
	 * @param ChuYuanShiJian_E
	 *            ��Ժ����ʱ��
	 * @param FeiYongLeiXingID
	 *            ��������
	 * @param ZhuYuanBuId
	 *            סԺ��ID
	 * @param ShengFeiZheng
	 *            ���֤��
	 * @param FuWuDuiXiangID
	 *            �������ID
	 * @return
	 */
	public String[][] getZYInpatient(String ZhuYuanHao, Integer ChuangWeiHao,
			String XingMing, String XingMingSuoXie, String ShengQingShiJian_B,
			String ShengQingShiJian_E, String RuYuanShiJian_B,
			String RuYuanShiJian_E, String ShengQingZhuangTai, String YueE1,
			String GuanXi, Integer ShiFouChuYuan, String ChuYuanShiJian_B,
			String ChuYuanShiJian_E, Integer FeiYongLeiXingID,
			Integer ZhuYuanBuId, String ShengFeiZheng, Long FuWuDuiXiangID) {
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;

		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")) {
			tj = "ZYInpatient.IPID = ?"; // סԺ��
			cs.add(ZhuYuanHao);
		}
		if (ChuangWeiHao != -2) { // ��λ��
			if (tj.equals(""))
				tj = " ZYInpatient.Bed = ?";
			else
				tj = tj + " and ZYInpatient.Bed = ?";
			cs.add(ChuangWeiHao);
		}
		if (XingMing != null && !XingMing.equals("")) { // ����
			if (tj.equals(""))
				tj = " CSConsumer.CSName like ?";
			else
				tj = tj + " and CSConsumer.CSName like ?";
			cs.add("%" + XingMing + "%");
		}
		if (XingMingSuoXie != null && !XingMingSuoXie.equals("")) { // ������д
			if (tj.equals(""))
				tj = " CSConsumer.NameForShort like ?";
			else
				tj = tj + " and CSConsumer.NameForShort like ?";
			cs.add(XingMingSuoXie);
		}
		if (ShengQingShiJian_B != null && !ShengQingShiJian_B.equals("")) { // ����ʱ��
			if (tj.equals(""))
				tj = " ZYInpatient.ATime >= ? and ZYInpatient.ATime <= ?";
			else
				tj = tj
						+ " and ZYInpatient.ATime >= ? and ZYInpatient.ATime <= ?";
			cs.add(ShengQingShiJian_B);
			cs.add(ShengQingShiJian_E);
		}
		if (RuYuanShiJian_B != null && !RuYuanShiJian_B.equals("")) { // ��Ժʱ��
			if (tj.equals(""))
				tj = " ZYInpatient.IPTime >= ? and ZYInpatient.IPTime <= ?";
			else
				tj = tj
						+ " and ZYInpatient.IPTime >= ? and ZYInpatient.IPTime <= ?";
			cs.add(RuYuanShiJian_B);
			cs.add(RuYuanShiJian_E);
		}
		if (ShengQingZhuangTai != null && !ShengQingZhuangTai.equals("")) { // ����״̬
			if (tj.equals(""))
				tj = " ZYInpatient.AStatus = ?";
			else
				tj = tj + " and ZYInpatient.AStatus = ?";
			cs.add(ShengQingZhuangTai);
		}
		if (YueE1 != null && !YueE1.equals("")) { // Ѻ�����
			if (tj.equals(""))
				tj = " ZYInpatient.DepositBalance ? ?";
			else
				tj = tj + " and ZYInpatient.DepositBalance ? ?";
			cs.add(GuanXi);
			cs.add(YueE1);
		}
		if (ShiFouChuYuan != -2) { // �Ƿ��Ժ
			if (tj.equals(""))
				tj = " ZYInpatient.LeaveHospOrNot = ?";
			else
				tj = tj + " and ZYInpatient.LeaveHospOrNot = ?";
			cs.add(ShiFouChuYuan);
		}
		if (ChuYuanShiJian_B != null && !ChuYuanShiJian_B.equals("")) { // ��Ժʱ��
			if (tj.equals(""))
				tj = " ZYInpatient.LeaveTime >= ? and ZYInpatient.LeaveTime <= ?";
			else
				tj = tj
						+ " and ZYInpatient.LeaveTime >= ? and ZYInpatient.LeaveTime <= ?";
			cs.add(ChuYuanShiJian_B);
			cs.add(ChuYuanShiJian_E);
		}
		if (FeiYongLeiXingID != -2) { // ��������ID
			if (tj.equals(""))
				tj = " ZYInpatient.ChargeType = ?";
			else
				tj = tj + " and ZYInpatient.ChargeType = ?";
			cs.add(FeiYongLeiXingID);
		}
		if (ZhuYuanBuId != -2) { // סԺ��ID
			if (tj.equals(""))
				tj = " ZYInpatient.IPDeptID = ?";
			else
				tj = tj + " and ZYInpatient.IPDeptID = ?";
			cs.add(ZhuYuanBuId);
		}
		if (ShengFeiZheng != null && !ShengFeiZheng.equals("")) { // ���֤��
			if (tj.equals(""))
				tj = " CSConsumer.IDCardNum = ?";
			else
				tj = tj + " and CSConsumer.IDCardNum = ?";
			cs.add(ShengFeiZheng);
		}
		if (FuWuDuiXiangID != -2) {
			if (tj.equals(""))
				tj = " ZYInpatient.CsID = ?";
			else
				tj = tj + " and ZYInpatient.CsID = ?";
			cs.add(FuWuDuiXiangID);
		}
		if (tj != null && !tj.equals("")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "   ZYInpatient.IPID, "
									+ // סԺID 0
									"   ZYInpatient.NurseGradeID, "
									+ // ����ȼ�ID 1
									"   ZYInpatient.Bed,"
									+ // ��λ�� 2
									"   ZYInpatient.CsID, "
									+ // �������ID 3
									"   ZYInpatient.AMaker, "
									+ // ���뿪���� 4
									"   ZYInpatient.ATime, "
									+ // ����ʱ�� 5
									"   ZYInpatient.IPTime, "
									+ // ��Ժʱ�� 6
									"   ZYInpatient.IPReason, "
									+ // סԺԭ�� 7
									"   ZYInpatient.AStatus, "
									+ // ����״̬ 8
									"   ZYInpatient.DepositAdvised, "
									+ // ����Ѻ���� 9
									"   ZYInpatient.Note, "
									+ // ��ע 10
									"   ZYInpatient.FillIPItemDocID, "
									+ // סԺ��Ŀ������дID 11
									"   ZYInpatient.DepositBalance, "
									+ // סԺѺ����� 12
									"   ZYInpatient.LeaveHospOrNot, "
									+ // �Ƿ��Ѿ���Ժ 13
									"   ZYInpatient.LeaveTime, "
									+ // ��Ժʱ�� 14
									"   ZYInpatient.NurseType, "
									+ // �������� 15
									"   ZYInpatient.DietCircs, "
									+ // ��ʳ��� 16
									"   ZYInpatient.CsCircs, "
									+ // ���������� 17
									"   ZYInpatient.ChargeType, "
									+ // �������� 18
									"   ZYInpatient.IPDeptID, "
									+ // סԺ��ID 19
									"   CSConsumer.CSName, "
									+ // ���� 20
									"   CSConsumer.Sex, "
									+ // �Ա� 21
									"   CSConsumer.Birthday, "
									+ // �������� 22
									"   CSConsumer.IDCardNum "
									+ // ���֤�� 23
									"from "
									+ "   ZYInpatient,"
									+ "   CSConsumer "
									+ "where "
									+ "   ZYInpatient.CsID = CSConsumer.CsID and "
									+ tj);
			for (int i = 0; i < cs.size(); i++) {
				query.setParameter(i, cs.get(i));
			}
		} else {
			query = this.getSession().createSQLQuery(
					"select " + "   ZYInpatient.IPID, "
							+ "   ZYInpatient.NurseGradeID, "
							+ "   ZYInpatient.Bed, " + "   ZYInpatient.CsID, "
							+ "   ZYInpatient.AMaker, "
							+ "   ZYInpatient.ATime, "
							+ "   ZYInpatient.IPTime, "
							+ "   ZYInpatient.IPReason, "
							+ "   ZYInpatient.AStatus, "
							+ "   ZYInpatient.DepositAdvised, "
							+ "   ZYInpatient.Note, "
							+ "   ZYInpatient.FillIPItemDocID, "
							+ "   ZYInpatient.DepositBalance, "
							+ "   ZYInpatient.LeaveHospOrNot, "
							+ "   ZYInpatient.LeaveTime, "
							+ "   ZYInpatient.NurseType, "
							+ "   ZYInpatient.DietCircs, "
							+ "   ZYInpatient.CsCircs, "
							+ "   ZYInpatient.ChargeType, "
							+ "   ZYInpatient.IPDeptID, "
							+ "   CSConsumer.CSName, " + "   CSConsumer.Sex, "
							+ "   CSConsumer.Birthday, "
							+ "   CSConsumer.IDCardNum " + "from "
							+ "   ZYInpatient," + "   CSConsumer " + "where "
							+ "   ZYInpatient.CsID = CSConsumer.CsID");
		}
		query.list();
		return listObject2StringString(query.list());

	}

	/**
	 * �޸�סԺ��
	 * 
	 * @param zyinpatient
	 *            סԺ������
	 * @return
	 */
	public boolean updateZYInpatient(Zyinpatient zyinpatient) {
		this.update(zyinpatient);
		return true;
	}

	public boolean updateDangQianChuangWei(String ZhuYuanHao,
			Integer ChuangWeihao) {
		Query query = null;
		query = this.getSession().createSQLQuery(
				"update ZYInpatient set Bed = ? where IPID = ?");
		query.setParameter(0, ChuangWeihao);
		query.setParameter(1, ZhuYuanHao);
		query.executeUpdate();
		return true;
	}

	public List<Zyinpatient> getZyinpatientall(String ZhuYuanHao) {
		List<Zyinpatient> list = null;
		list = this.getHibernateTemplate().find(
				"from Zyinpatient where ipid = ?", ZhuYuanHao);
		return list;

	}

	public boolean updateDepositBalance(String IPID, Double FeiYong) {
		Query query = null;
		query = this
				.getSession()
				.createSQLQuery(
						"update ZYInpatient set DepositBalance = DepositBalance + ? where IPID = ?");
		query.setParameter(0, FeiYong);
		query.setParameter(1, IPID);
		query.executeUpdate();
		return true;
	}

	public Zyinpatient updateZyStauts(String inpatientId, boolean b,
			String string) {

		Zyinpatient zyinpatient = find(inpatientId);
		zyinpatient.setLeaveHospOrNot(true);
		zyinpatient.setLeaveTime(DateUtil.getNowTimeStamp());
		zyinpatient.setAstatus(string);
		return zyinpatient;
	}

	public List<Zyinpatient> getZyinpatientByCsIDandDate(long csId, String st,
			String ed) throws Exception {
		Query query = this
				.getSession()
				.createQuery(
						"from Zyinpatient where (iptime between ? and ?) and csId=?  order by iptime desc");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		query.setDate(0, format.parse(st));
		query.setDate(1, format.parse(ed));
		query.setLong(2, csId);
		if (query.list().size() > 0) {
			return query.list();
		} else
			return null;
	}

	public Zyinpatient getZyinpatientByIPID(String ipid) {
		// Query
		// query=this.getSession().createQuery("from Zyinpatient where ipid? order by iptime desc");
		// query.setParameter(0, ipid);
		// List <Zyinpatient> list= query.list();
		// if (query.list().size() > 0) {
		// return list.get(0);
		// } else
		// return null;
		try {
			return (Zyinpatient) this.getHibernateTemplate().get(
					Zyinpatient.class, ipid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateShengQingZhuangTai(String IPID, String AStatus) {
		Query query = null;
		query = this.getSession().createSQLQuery(
				"update ZYInpatient set AStatus = ? where IPID = ?");
		query.setParameter(0, AStatus);
		query.setParameter(1, IPID);
		query.executeUpdate();
		return true;
	}

	public boolean updateBanLiChuYuan(String IPID, String LeaveTime,
			String AStatus) {
		Query query = null;
		query = this
				.getSession()
				.createSQLQuery(
						"update ZYInpatient set LeaveTime = ?, AStatus = ? where IPID = ?");
		query.setParameter(0, LeaveTime);
		query.setParameter(1, AStatus);
		query.setParameter(2, IPID);
		query.executeUpdate();
		return true;
	}
	public String[][] getGhregisterDZ(String Date_B, String Date_e, String XingMing, String XingMingSuoXie, Integer ShiFouChuYuan, Integer YiLiaoJiGou){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;

		if (Date_B != null && !Date_B.equals("")) {
			tj = "ZYInpatient.IPTime >= ? and ZYInpatient.IPTime <= ?"; // ��Ժ����
			cs.add(Date_B);
			cs.add(Date_e);
		}
		if (XingMing != null && !XingMing.equals("")) { // ����
			if (tj.equals(""))
				tj = " CSConsumer.CSName like ?";
			else
				tj = tj + " and CSConsumer.CSName like ?";
			cs.add("%" + XingMing + "%");
		}
		if (XingMingSuoXie != null && !XingMingSuoXie.equals("")) { // ������д
			if (tj.equals(""))
				tj = " CSConsumer.NameForShort like ?";
			else
				tj = tj + " and CSConsumer.NameForShort like ?";
			cs.add("%" + XingMingSuoXie + "%");
		}
		if (ShiFouChuYuan != -2){ //�Ƿ��Ժ
			if (tj.equals(""))
				tj = " ZYInpatient.LeaveHospOrNot = ?";
			else
				tj = tj + " and ZYInpatient.LeaveHospOrNot = ?";
			cs.add(ShiFouChuYuan);
		}
		if (YiLiaoJiGou != -2) { // ҽ�ƻ���ID
			if (tj.equals(""))
				tj = " OSUForm.MEIID = ?";
			else
				tj = tj + " and OSUForm.MEIID = ?";
			cs.add(YiLiaoJiGou);
		}
		query = this
				.getSession()
				.createSQLQuery("select " +
						        "  CSConsumer.CSName, " + //0����
						        "  CSConsumer.Sex, " + //1�Ա�
						        "  CSConsumer.Birthday, " + //2��������
						        "  CSConsumer.Address, " + //3סַ
						        "  CSConsumer.IDCardNum, " + //4���֤��
						        "  CSConsumer.Cellphone, " + //5�ֻ�
						        "  CSConsumer.Telephone, " + //6�绰
						        "  CSConsumer.CsID " + //7�������ID
						        "from ZYInpatient,CSConsumer,OSUForm " +
						        "where " +
						        "  ZYInpatient.CsID=CSConsumer.CsID and " +
						        "  ZYInpatient.IPDeptID=OSUForm.UID and " +
						        "  ZYInpatient.AStatus <> '����' and " + tj);
			for (int i = 0; i < cs.size(); i++) {
				query.setParameter(i, cs.get(i));
			}	
		query.list();
		return listObject2StringString(query.list());
	}

	public boolean updateBengKeShiYaJin(String IPID, Double JinE){
		Query query = null;
		query = this
				.getSession()
				.createSQLQuery(
						"update ZYInpatient set DepositBalance = DepositBalance + ? where IPID = ?");
		query.setParameter(0, JinE);
		query.setParameter(1, IPID);
		query.executeUpdate();
		return true;
	}

}
