package leo.yf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.common.util.DateUtil;
import leo.entity.Yfminfo;
import leo.yf.dao.iface.YFMInfoDao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;

//extends HibernateDaoSupport �̳�HibernateDaoSupport��
public class YFMInfoDaoImpl extends DaoSupport<Yfminfo> implements YFMInfoDao {

	public String[][] getYFMInfo_Alias(String MName, String spell) {
		Query query = null; // ����һ����ѯ����

		if ((MName != null) && !MName.equals("")) {

			query = this
					.getSession()
					.createSQLQuery(
							"select * from YFMInfo where mname like ? "
									+ "union "
									+ "select * from YFMInFo where MInfoID in ("
									+ "select MInfoID from YFMAlias where aliasname like ?)");
			query.setParameter(0, "%" + MName + "%");
			query.setParameter(1, "%" + MName + "%");

		} else if (spell != null && !spell.equals("")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select * from YFMInfo where spell like ? "
									+ "union "
									+ "select * from YFMInFo where MInfoID in ("
									+ "select MInfoID from YFMAlias where SpellCode like ?)");
			query.setParameter(0, "%" + spell + "%");
			query.setParameter(1, "%" + spell + "%");
		} else {
			query = this.getSession().createSQLQuery("select * from YFMInfo");
		}
		/*
		 * List<Yfminfo> list = query.list(); Iterator iterator =
		 * list.iterator(); String result[][] = new String[list.size()][19]; int
		 * i = 0; Yfminfo yi; while (iterator.hasNext()) { yi = (Yfminfo)
		 * iterator.next(); result[i][0] = String.valueOf(yi.getMinfoId()); //
		 * ҩƷ��ϢID result[i][1] = String.valueOf(yi.getSupplierId()); // ��Ӧ��ID
		 * result[i][2] = yi.getMname(); // ҩƷ���� result[i][3] = yi.getMtype();
		 * // ҩƷ��� result[i][4] = yi.getMspec(); // ҩƷ��� result[i][5] =
		 * yi.getMdosageType(); // ҩƷ���� result[i][6] =
		 * String.valueOf(yi.getMdosage());// ҩƷ���� result[i][7] =
		 * yi.getDosageUnit();// ������λ result[i][8] = yi.getWayTo();// ��ҩ��ʽ
		 * result[i][9] = yi.getChinaDrugApprovalNum();// ��ҩ�ֺ� result[i][10] =
		 * yi.getSpell(); // ƴ������ result[i][11] = yi.getMbankUnit();// ҩ�ⵥλ
		 * result[i][12] = yi.getPharmacyUnit();// ҩ����λ result[i][13] =
		 * String.valueOf(yi.getBankToPharConvRate());// �ⷿת���� result[i][14] =
		 * yi.getRuralCooperType();// ũ������ result[i][15] =
		 * yi.getMedicalInsuranceType();// ҽ������ result[i][16] =
		 * String.valueOf(yi.getDeleteOrNot());// �Ƿ���ע�� result[i][17] =
		 * yi.getManufacturer();// �������� result[i][18] =
		 * String.valueOf(yi.getMedicalInstitutionId());// ҽ�ƻ���ID i++; }
		 */
		return listObject2StringString(query.list()); // ִ��SQL���(�����ؽ��query.list()ǿ��ת��ΪList<Object[]>����)

	}

	public List<Yfminfo> getYFMInfo(String mname, String spell,
			Integer MInfoID, Integer MedicalInstitutionID) {
		List<Yfminfo> list;
		list = null;
		if ((mname == null || mname.equals(""))
				&& (spell == null || spell.equals("")) && (MInfoID == -2))
			list = this.getHibernateTemplate().find(
					"from Yfminfo where MedicalInstitutionID = ?",
					MedicalInstitutionID); // ����һ����ѯ����
		else if ((mname != null) && !mname.equals("")) {
			list = this.getHibernateTemplate().find(
					"from Yfminfo where MName like ?", "%" + mname + "%"); // ����һ����ѯ����
		} else if (spell != null && !spell.equals("")) {
			list = this.getHibernateTemplate().find(
					"from Yfminfo where spell like ?", "%" + spell + "%"); // ����һ����ѯ����
		} else if (MInfoID != -2) {
			list = this.getHibernateTemplate().find(
					"from Yfminfo where MInfoID = ?", MInfoID); // ����һ����ѯ����
		}
		return list;
	}

	public boolean addYFInsertMInfoDao(Yfminfo yfminfo) {
		try {
			this.getHibernateTemplate().save(yfminfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delYFMInfo(Integer minfoid) {
		try {
			this.delete(minfoid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean updateYFMInfo(Yfminfo yfminfo) {
		try {
			this.update(yfminfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public Integer getYFMinfoID() {
		Query query = null; // ����һ����ѯ����
		query = this.getSession().createQuery(
				"select a.minfoId from Yfminfo a order by a.minfoId desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		// List<Integer> list =
		// this.getHibernateTemplate().find("select a.minfoId from YFMInfo a order by a.minfoId desc");
		List<Integer> list = (List<Integer>) query.list();
		if (list.size() < 1)
			return -1;
		else
			return list.get(0);
	}

	public String[][] getUnit(Integer minfoid) {
		List z;
		Query query = null; // ����һ����ѯ����
		query = this
				.getSession()
				.createSQLQuery(
						"select mbankUnit,pharmacyUnit,bankToPharConvRate from Yfminfo where minfoId = ?");
		query.setParameter(0, minfoid);
		z = query.list();
		return listObject2StringString(z); // ִ��SQL���(�����ؽ��query.list()ǿ��ת��ΪList<Object[]>����)
	}

	public String[][] getYFMInfo_Stock(String MName, String spell,
			Integer MedicalInstitutionID, Integer PharmacyID) {
		Query query = null; // ����һ����ѯ����

		if ((MName != null) && !MName.equals("")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select yfminfo.* from YFMStock,YFMInfo where yfmstock.MInfoID = yfminfo.MInfoID and yfminfo.MedicalInstitutionID = ? and yfmstock.PharmacyID = ? and yfminfo.mname like ?");
			query.setParameter(0, MedicalInstitutionID);
			query.setParameter(1, PharmacyID);
			query.setParameter(2, "%" + MName + "%");
		} else if (spell != null && !spell.equals("")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select yfminfo.* from YFMStock,YFMInfo where yfmstock.MInfoID = yfminfo.MInfoID and yfminfo.MedicalInstitutionID = ? and yfmstock.PharmacyID = ? and yfminfo.spell like ?");
			query.setParameter(0, MedicalInstitutionID);
			query.setParameter(1, PharmacyID);
			query.setParameter(2, "%" + spell + "%");
		} else {
			query = this
					.getSession()
					.createSQLQuery(
							"select yfminfo.* from YFMStock,YFMInfo where yfmstock.MInfoID = yfminfo.MInfoID and yfminfo.MedicalInstitutionID = ? and yfmstock.PharmacyID = ?");
			query.setParameter(0, MedicalInstitutionID);
			query.setParameter(1, PharmacyID);

		}
		return listObject2StringString(query.list()); // ִ��SQL���(�����ؽ��query.list()ǿ��ת��ΪList<Object[]>����)
	}

	public List<Yfminfo> getYFMInfoByStyle(String type) {
		List<Yfminfo> list;
		list = null;
		return this.getHibernateTemplate().find("from Yfminfo where mtype = ?",
				type);
	}

	/**
	 * ����ҩƷ��ϢId��ѯҩƷ
	 */
	public Yfminfo getYfminfoByminfoId(Integer minfoId) {
		// TODO Auto-generated method stub
		try {
			return (Yfminfo) super.getHibernateTemplate().get(Yfminfo.class,
					minfoId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����ƴ����дģ����ѯҩƷ��Ϣ
	 */
	public List<Yfminfo> getYfminfoBySpell(String spell) {
		try {
			Session session = super.getSession();
			Query query = session
					.createQuery("from Yfminfo where spell like ?");
			query.setString(0, "%" + spell + "%");
			return query.list();
		} catch (DataAccessResourceFailureException e) {
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

	public String[][] getYaoPinXinXibyLeiXingYaoFang(Integer YaoFanID,
			String LeiXing) {
		List<Object> cs = new ArrayList<Object>();
		Query query = null;
		if (LeiXing.equals("����")) {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "   YFMInfo.MInfoID,YFMInfo.MName,YFMInfo.MSpec,YFMInfo.Manufacturer,YFMInfo.PharmacyUnit,YFMInfo.DeleteOrNot "
									+ "from " + "   YFMStock,YFMInfo "
									+ "where "
									+ "   YFMStock.PharmacyID = ? and "
									+ "   YFMStock.MInfoID = YFMInfo.MInfoID");
			query.setParameter(0, YaoFanID);
		} else {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "   YFMInfo.MInfoID,YFMInfo.MName,YFMInfo.MSpec,YFMInfo.Manufacturer,YFMInfo.PharmacyUnit,YFMInfo.DeleteOrNot "
									+ "from "
									+ "   YFMStock,YFMInfo "
									+ "where "
									+ "   YFMStock.PharmacyID = ? and "
									+ "   YFMStock.MInfoID = YFMInfo.MInfoID and "
									+ "   YFMInfo.mtype = ?");
			query.setParameter(0, YaoFanID);
			query.setParameter(1, LeiXing);
		}
		query.list();
		return listObject2StringString(query.list()); // ִ��SQL���(�����ؽ��query.list()ǿ��ת��ΪList<Object[]>����)
	}

	/**
	 * ��ѯ����ҩƷ��Ϣ
	 */
	public List<Yfminfo> getYFMinfoAll() {
		// TODO Auto-generated method stub
		return super.getSession().createQuery(
				"from Yfminfo where deleteOrNot!=1").list();
	}

	public List<Yfminfo> getYFMInfoAlias(String MName, String spell) {
		// TODO Auto-generated method stub
		String hql = "from Yfminfo where deleteOrNot!=1";
		if (!MName.equals("")) {
			hql += " and mname='" + MName + "'";

		} else if (!spell.equals("")) {
			hql += " and spell like '%" + spell + "%'";
		}
		return this.getSession().createQuery(hql).list();
	}
}
