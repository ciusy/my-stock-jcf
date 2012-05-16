package leo.mz.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.common.util.DateUtil;
import leo.entity.Csconsumer;
import leo.entity.MzopDn;
import leo.entity.YfmexbankA;
import leo.mz.dao.iface.MzopDnDao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessResourceFailureException;

@SuppressWarnings("unchecked")
public class MzopDnDaoImpl extends DaoSupport<MzopDn> implements MzopDnDao {

	/**
	 * 
	 * add by xu 得到当天待收费的所有诊断对象
	 * 
	 * @param officeId
	 *            当前登录者的科室ID
	 * @return
	 */
	public List<MzopDn> getNowDayMZop(Integer officeId) {

		// return (ArrayList<MzopDn>) getHibernateTemplate()
		// .find("from MzopDn m where m.status=? and m.dnTime>=? and m.dnTime <= ? and m.csu=?",
		// new Object[] { "可收费", DateUtil.getNowDay000000Start(),
		// DateUtil.getNowDay235959End(), officeId });

		return (ArrayList<MzopDn>) getHibernateTemplate().find(
				"from MzopDn m where m.dnTime>=? and m.dnTime <= ? and m.csu=? "
						+ " and m.alterDntimeId='' order by m.dnTime desc",
				new Object[] { DateUtil.getNowDay000000Start(),
						DateUtil.getNowDay235959End(), officeId });
	}

	public List<MzopDn> getMzopDn(List<Long> consumerIds, String startTime,
			String endTime, int officeId) {

		StringBuilder sb = new StringBuilder();
		// sb.append("from MzopDn m where m.status=? and m.alterDntimeId is null");
		// sb.append("from MzopDn m where m.alterDntimeId is null");
		sb.append("from MzopDn m where m.alterDntimeId=''");
		List<Object> list = new ArrayList<Object>();
		if (null != startTime && !"".equals(startTime.trim())) {
			sb.append(" and m.dnTime>=? ");
			list.add(DateUtil.get000000DateTime(startTime));
		}

		if (null != endTime && !"".equals(endTime.trim())) {
			sb.append(" and m.dnTime <= ?");
			list.add(DateUtil.get235959DateTime(endTime));
		}
		if (officeId != 0) {
			sb.append(" and m.csu =?");
			list.add(officeId);
		}
		if (null != consumerIds && consumerIds.size() > 0) {
			sb.append(" and m.csId in (:csIds)");
		}
		sb.append("  order by m.dnTime desc");
		Query query = getSession().createQuery(sb.toString());
		// query.setParameter(0, "可收费");
		// query.setParameter(0, "可处理");

		for (int i = 0; i < list.size(); i++) {
			query.setParameter(i, list.get(i));
		}

		if (null != consumerIds && consumerIds.size() > 0) {
			query.setParameterList("csIds", consumerIds);
		}
		return query.list();

	}

	public MzopDn getMzopDn(String opnum) {
		try {
			Query query = this.getSession().createQuery(
					"from MzopDn mz where mz.opnum=:opnum");
			query.setString("opnum", opnum);

			List<MzopDn> list = query.list();
			return list.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 按日期查询流水号
	 */
	public List<MzopDn> getNewOpNum() {
		// TODO Auto-generated method stub
		try {
			Session session = super.getSession();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String today = format.format(new Date());
			System.out.println(today);
			String hql = "from MzopDn where opDnId like ? order by opDnId desc";
			// String hql2 = "from MzopDn";
			Query query = session.createQuery(hql);
			query.setString(0, "%" + today + "%");
			query.setFirstResult(0).setMaxResults(5);
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

	public List<MzopDn> getMzopDnByIDs(List<String> ids) {
		return getSession()
				.createQuery("from MzopDn m where m.opDnId in (:ids)")
				.setParameterList("ids", ids).list();

	}

	public boolean addMzopDn(MzopDn mzopDn) {
		try {
			this.getHibernateTemplate().save(mzopDn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateMzopDn(MzopDn mzopDn) {
		try {
			this.getHibernateTemplate().update(mzopDn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<MzopDn> getMzopDnByOpnum(String opnum) {
		try {
			Query query = this.getSession().createQuery(
					"from MzopDn g where g.opnum=:opnum order by opDnId desc");
			query.setString("opnum", opnum);
			if (query.list().size() > 0) {
				return query.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MzopDn> getMzopDnByCondition(String idcardNum) {
		try {
			Session session = super.getSession();
			Query query = session
					.createQuery("from Csconsumer where idcardNum=?");
			query.setString(0, idcardNum);

			List<Csconsumer> csconsumerList = query.list();
			if (csconsumerList.size() > 0) {

				Csconsumer csconsumer = csconsumerList.get(0);
				Query querymz = super.getSession().createQuery(
						"from MzopDn where csId=? and status=? ");
				querymz.setLong(0, csconsumer.getCsId());
				querymz.setString(1, "可处理");
				return querymz.list();
			}

		} catch (Exception e) {

		}
		return null;

	}

	public String[][] getMzopDnByConditions(String csname, String idcardNum,
			String stime, String etime, String status) {

		try {

			String[][] str = null;
			String sql = "select cs.csname,cs.csId,cs.birthday,cs.sex,cs.idcardNum,"
					+ "mz.alterDntimeId,mz.chief,mz.csId,mz.csu,mz.dn,mz.dnTime,mz.doctorId,mz.note,mz.opDnId,mz.opnum,mz.status from MzopDn mz,Csconsumer cs"
					+ " where cs.csId=mz.csId and mz.dnTime between '"
					+ stime
					+ "' and '" + etime + "' and mz.status='" + status + "' ";
			if (csname != null && csname != "") {
				sql = sql + "and cs.csname='" + csname + "' ";
			}
			if (idcardNum != null && idcardNum != "") {
				sql = sql + "and cs.idcardNum='" + idcardNum + "' ";
			}
			Query query = this.getSession().createSQLQuery(sql);
			List<Object[]> list = query.list();
			int i = list.size();
			str = new String[i][16];
			for (int y = 0; y < i; y++) {
				str[y][0] = list.get(y)[0] == null ? "" : list.get(y)[0]
						.toString();// 服务对象名
				str[y][1] = list.get(y)[1] == null ? "" : list.get(y)[1]
						.toString();// 服务对象ID
				str[y][2] = list.get(y)[2] == null ? "" : list.get(y)[2]
						.toString();// 生日
				str[y][3] = list.get(y)[3] == null ? "" : list.get(y)[3]
						.toString();// 性别
				str[y][4] = list.get(y)[4] == null ? "" : list.get(y)[4]
						.toString();// 身份证
				str[y][5] = list.get(y)[5] == null ? "" : list.get(y)[5]
						.toString();// 诊断号
				str[y][6] = list.get(y)[6] == null ? "" : list.get(y)[6]
						.toString();//
				str[y][7] = list.get(y)[7] == null ? "" : list.get(y)[7]
						.toString();//
				str[y][8] = list.get(y)[8] == null ? "" : list.get(y)[8]
						.toString();//
				str[y][9] = list.get(y)[9] == null ? "" : list.get(y)[9]
						.toString();//
				str[y][10] = list.get(y)[10] == null ? "" : list.get(y)[10]
						.toString();//
				str[y][11] = list.get(y)[11] == null ? "" : list.get(y)[11]
						.toString();//
				str[y][12] = list.get(y)[12] == null ? "" : list.get(y)[12]
						.toString();//
				str[y][13] = list.get(y)[13] == null ? "" : list.get(y)[13]
						.toString();//
				str[y][14] = list.get(y)[14] == null ? "" : list.get(y)[14]
						.toString();//
				str[y][15] = list.get(y)[15] == null ? "" : list.get(y)[15]
						.toString();//

			}

			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateZhenDuanZhuangTai(String ZhenDuanHao, String ZhuangTai) {
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery(
				"update MZOpDn set status = ? where OpDnID = ?");
		query.setParameter(0, ZhuangTai);
		query.setParameter(1, ZhenDuanHao);
		query.executeUpdate();
		return true;
	}

	public List<MzopDn> getMZOpDnByDate(long csId, String st, String ed)
			throws Exception {

		Query query = this
				.getSession()
				.createQuery(
				// "from MzopDn as g where g.dnTime between ? and ? and g.csId=? order by opDnId desc");
						"from MzopDn  where (dnTime between ? and ?) and csId=? and alterDntimeId='' order by opDnId desc");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		query.setDate(0, format.parse(st));
		query.setDate(1, format.parse(ed));
		query.setLong(2, csId);
		// query.setParameter(0, csId);
		if (query.list().size() > 0) {
			return query.list();
		} else
			return null;
	}

	public MzopDn getMzopDnByOpDnID(String opDnId) {
		try {
			Query query = this.getSession().createQuery(
					"from MzopDn mz where mz.opDnId=:opDnId");
			query.setString("opDnId", opDnId);

			List<MzopDn> list = query.list();
			return list.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MzopDn> getMzopDnForTY(List<MzopDn> mzlist) {
		int i = mzlist.size();
		List<MzopDn> List = new ArrayList<MzopDn>();
		String status = "已付费已领药";
		for (int j = 0; j < i; j++) {
			Query query = this
					.getSession()
					.createQuery(
							"from YfmexbankA  where opnum=? and opDnId=? and exbankStatus=? order by opDnId desc");
			query.setParameter(0, mzlist.get(j).getOpnum());
			query.setParameter(1, mzlist.get(j).getOpDnId());
			query.setParameter(2, status);
			List<YfmexbankA> list = query.list();
			if (list.size() > 0) {

				List.add(mzlist.get(j));

			}
		}
		return List;

	}

	public boolean deleteByopId(String opId) {

		Query query = this.getSession().createQuery(
				"from Czdispose where kindId=? ");
		query.setParameter(0, opId);
		int i = query.list().size();
		if (i > 0) {
			for (int k = 0; k < i; k++) {
				this.getHibernateTemplate().delete(query.list().get(k));
			}

		}
		String chufang = " from YfmexbankA where opDnId=?";
		Query query2 = this.getSession().createQuery(chufang);
		query2.setParameter(0, opId);
		// query2.executeUpdate();
		int j = query2.list().size();
		List<YfmexbankA> list = query2.list();
		if (j > 0) {
			for (int l = 0; l < j; l++) {
				Query query3 = this.getSession().createQuery(
						"delete from YfexbankAitem where aformId=?");
				String aformID = list.get(l).getAformId();
				query3.setParameter(0, aformID);
				this.getHibernateTemplate().delete(list.get(l));
				query3.executeUpdate();
			}
		}

		return true;
	}

	public String[][] getMzopDnForchaxun(String csname, String spell,
			String idcardNum, String stime, String etime, String status) {

		try {

			String[][] str = null;
			String sql = "select cs.csname,cs.csId,cs.birthday,cs.sex,cs.idcardNum,"
					+ "mz.alterDntimeId,mz.chief,mz.csId,mz.csu,mz.dn,mz.dnTime,mz.doctorId,mz.note,mz.opDnId,mz.opnum,mz.status,gh.costTypeId from MzopDn mz,Csconsumer cs,Ghregister gh "
					+ " where cs.csId=mz.csId  and mz.opnum=gh.opnum and mz.dnTime between '"
					+ stime
					+ "' and '"
					+ etime
					+ "' and mz.status='"
					+ status
					+ "' ";
			if (csname != null && csname != "") {
				sql = sql + "and cs.csname like '"+"%" + csname + "%"+"' ";
			}
			if (spell != null && spell != "") {
				sql = sql + "and cs.nameForShort like '" +"%"+ spell +"%"+ "' ";
			}
			if (idcardNum != null && idcardNum != "") {
				sql = sql + "and cs.idcardNum='" + idcardNum + "' ";
			}
			Query query = this.getSession().createSQLQuery(sql);
			List<Object[]> list = query.list();
			int i = list.size();
			str = new String[i][17];
			for (int y = 0; y < i; y++) {
				str[y][0] = list.get(y)[0] == null ? "" : list.get(y)[0]
						.toString();// 服务对象名
				str[y][1] = list.get(y)[1] == null ? "" : list.get(y)[1]
						.toString();// 服务对象ID
				str[y][2] = list.get(y)[2] == null ? "" : list.get(y)[2]
						.toString();// 生日
				str[y][3] = list.get(y)[3] == null ? "" : list.get(y)[3]
						.toString();// 性别
				str[y][4] = list.get(y)[4] == null ? "" : list.get(y)[4]
						.toString();// 身份证
				str[y][5] = list.get(y)[5] == null ? "" : list.get(y)[5]
						.toString();// 诊断号
				str[y][6] = list.get(y)[6] == null ? "" : list.get(y)[6]
						.toString();//
				str[y][7] = list.get(y)[7] == null ? "" : list.get(y)[7]
						.toString();//
				str[y][8] = list.get(y)[8] == null ? "" : list.get(y)[8]
						.toString();//
				str[y][9] = list.get(y)[9] == null ? "" : list.get(y)[9]
						.toString();//
				str[y][10] = list.get(y)[10] == null ? "" : list.get(y)[10]
						.toString();//
				str[y][11] = list.get(y)[11] == null ? "" : list.get(y)[11]
						.toString();//
				str[y][12] = list.get(y)[12] == null ? "" : list.get(y)[12]
						.toString();//
				str[y][13] = list.get(y)[13] == null ? "" : list.get(y)[13]
						.toString();//
				str[y][14] = list.get(y)[14] == null ? "" : list.get(y)[14]
						.toString();//
				str[y][15] = list.get(y)[15] == null ? "" : list.get(y)[15]
						.toString();//
				str[y][16] = list.get(y)[16] == null ? "" : list.get(y)[16]
						.toString();// 费用类型id
			}

			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean mzforSF(String opdnid) {
		String chacz = "from Czdispose where status=? and kindId=?";
		String czstatus = "未交费不可执行";
		Query querycz = this.getSession().createQuery(chacz);
		querycz.setParameter(0, czstatus);
		querycz.setParameter(1, opdnid);
		if (querycz.list().size() > 0) {
			return false;

		}
		String chack = "from YfmexbankA where exbankStatus=? and opDnId=?";
		String ckstatus = "已申请";
		Query queryck = this.getSession().createQuery(chack);
		queryck.setParameter(0, ckstatus);
		queryck.setParameter(1, opdnid);
		if (queryck.list().size() > 0) {
			return false;

		}
		Query cz = this.getSession().createQuery(
				"from Czdispose where kindId=?");
		cz.setParameter(0, opdnid);
		Query ck = this.getSession().createQuery(
				"from YfmexbankA where opDnId=?");
		ck.setParameter(0, opdnid);
		if ((cz.list().size() <= 0) && (ck.list().size() <= 0)) {
			return true;
		}
		return true;
	}

	public String getMaxId(){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery(
				"select a.opDnId from MzopDn a order by a.opDnId desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "no";
		else
			return list.get(0);
	}

	
}
