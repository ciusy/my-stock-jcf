package leo.bc.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import leo.bc.dao.iface.DisposeDao;
import leo.common.dao.DaoSupport;
import leo.common.util.DateUtil;
import leo.entity.Czdispose;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

@SuppressWarnings("unchecked")
public class DisposeDaoImpl extends DaoSupport<Czdispose> implements DisposeDao {
	public List<Czdispose> getDisposeInfo(int executeU, int day, String nowTime) {
		/*
		 * Timestamp t = Timestamp.valueOf(nowTime); int d = t.getDate() - day;
		 * t.setDate(d); String str = t.toString();
		 */

		Timestamp time = Timestamp.valueOf(nowTime);

		Calendar t = Calendar.getInstance();
		t.setTime(time);
		int d = t.get(Calendar.DAY_OF_MONTH) - day;
		t.set(Calendar.DAY_OF_MONTH, d);
		System.out.println(t.getTime());

		// Date time=DateUtil.stringToDateTime(str);
		// Date time=DateUtil.getNowDay000000Start();
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from Czdispose dis where dis.status in('�ѽ��ѿ�ִ��','δ���ѿ�ִ��','������') and dis.executeU=:executeU and dis.atime>=:t order by dis.atime asc");
			query.setParameter("executeU", executeU);
			query.setParameter("t", t.getTime());

			// query.setInteger("fnBlockID", fnBlockID);
			// query.setTimestamp("t", t);

			List<Czdispose> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/* ��ȡ��Ҫ��B���ķ���������Ϣ */

	/* ����b��֮�󣬸��Ĵ�������״̬ */
	public void setDisposeStatus(String itemid, Long executePerson,
			String executeTime) {
		Timestamp te = null;
		try {
			SimpleDateFormat dfl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date datell = dfl.parse(executeTime);
			String time = dfl.format(datell);
			te = Timestamp.valueOf(time);

		} catch (Exception e) {

		}

		try {
			Query query = this
					.getSession()
					.createQuery(
							"update Czdispose dis set dis.status='�ѽ�����ִ��',dis.executePerson=:executePerson ,dis.executeTime=:executeTime where dis.status='�ѽ��ѿ�ִ��' and dis.akind='��������' and dis.itemId=:itemid)");
			query.setString("itemid", itemid);
			query.setParameter("executePerson", executePerson);
			query.setParameter("executeTime", te);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Query query = this
					.getSession()
					.createQuery(
							"update Czdispose dis set dis.status='δ������ִ��' ,dis.executePerson=:executePerson,dis.executeTime=:executeTime where dis.status='δ���ѿ�ִ��' and dis.akind='��������' and dis.itemId=:itemid)");
			query.setString("itemid", itemid);
			query.setParameter("executePerson", executePerson);
			query.setParameter("executeTime", te);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Query query = this
					.getSession()
					.createQuery(
							"update Czdispose dis set dis.status='��ִ��',dis.executePerson=:executePerson,dis.executeTime=:executeTime where dis.status='δ���ѿ�ִ��'and dis.akind='סԺ����' and dis.itemId=:itemid)");
			query.setString("itemid", itemid);
			query.setParameter("executePerson", executePerson);
			query.setParameter("executeTime", te);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * add by xu
	 * 
	 * @param kindId
	 * @param kindType
	 * @return
	 */
	public List<Object[]> getCZ(String kindType, String kind) {
		Session session = getSession();

		Query query = session
				.createSQLQuery("select c1.REName,c2.Cost,c.ItemID"
						+ " from CZDispose c,CZBCUltrasoundIS c1,CZDisposeItemDescribe c2"
						+ " where c1.ItemID=c.ItemID and c.ItemTypeID=c2.ItemTypeID and c.akind=? and c.kindid=?"
						+ " and c1.AlterID='-1'");
		query.setParameter(0, kindType);
		query.setParameter(1, kind);

		return query.list();
		// return listObject2StringString(query.list());

	}

	/**
	 * add by xu ���ݴ�����Ŀid�����޸Ķ�Ӧ�ļ�����
	 * 
	 * @param disposeItemIdList
	 * @param disposeItemReduce
	 * @param main_officesNumber
	 * @param costTypeId
	 */
	public void updateStatusAndReduce(List<String> disposeItemIdList,
			List<Double> disposeItemReduce, String costTypeId,
			String main_officesNumber, String personnelNumber,
			Timestamp nowTimeStamp) {

		Czdispose czdispose = null;
		String id = null;
		for (int i = 0; i < disposeItemIdList.size(); i++) {
			id = disposeItemIdList.get(i);
			czdispose = find(id);
			if (null != costTypeId && !"".equals(costTypeId.trim()))
				czdispose.setCostTypeId(Integer.parseInt(costTypeId));
			int officeNumber = Integer.parseInt(main_officesNumber);
			czdispose.setCsu(officeNumber);
			czdispose.setRealP(czdispose.getReceivableP()
					- disposeItemReduce.get(i));

			// ���� ����֮ǰ��״̬������ 1.δ���ѿ�ִ�� 2.δ���Ѳ���ִ�� 3. δ������ִ��
			// ����֮��1��2 �޸�Ϊ �ѽ��ѿ�ִ�� 3 �޸�Ϊ �ѽ�����ִ��
			if (czdispose.getStatus().equals("δ���ѿ�ִ��")
					|| czdispose.getStatus().equals("δ���Ѳ���ִ��")) {
				czdispose.setStatus("�ѽ��ѿ�ִ��");
			}

			if (czdispose.getStatus().equals("δ������ִ��")
					|| czdispose.getStatus().equals("��ִ��"))
				czdispose.setStatus("�ѽ�����ִ��");
			// �����շѵ�ʱ�� nowTimeStamp=null��ִ�п�����0���޸�Ϊ ���ѽ�����ִ�С� ��������һЩ�����Ϣ
			if (null != nowTimeStamp && 0 == czdispose.getExecuteU()) {

				czdispose.setStatus("�ѽ�����ִ��");
				czdispose.setExecuteU(officeNumber);
				czdispose.setExecutePerson(Long.parseLong(personnelNumber));
				czdispose.setExecuteTime(nowTimeStamp);

			}
		}
	}

	public List<Object[]> getCzdisposeByStatusAndTime(List<String> statusList,
			String startTime, String endTime, String officeId) {

		StringBuilder sb = new StringBuilder();
		List<Object> list = new ArrayList<Object>();
		sb.append("select c2.au,c2.aproposer,c2.csId,c2.atime,c1.itemName,c2.akind,c2.kindId,"
				+ "c2.itemId,c1.itemTypeId from CzdisposeItemDescribe c1,Czdispose c2 "
				+ "where c1.itemTypeId = c2.itemTypeId");

		if (null != startTime && !"".equals(startTime)) {
			sb.append(" and c2.atime >= ?");
			list.add(DateUtil.get000000DateTime(startTime));
		}
		if (null != endTime && !"".equals(endTime)) {
			sb.append(" and c2.atime <= ?");
			list.add(DateUtil.get235959DateTime(endTime));
		}
		if (null != officeId && !"".equals(officeId.trim())) {
			sb.append(" and c2.executeU = ?");
			list.add(Integer.parseInt(officeId));
		}

		if (null != statusList && statusList.size() > 0) {
			sb.append(" and c2.status in (:statusList)");
		}

		Query query = getSession().createQuery(sb.toString());

		if (null != statusList && statusList.size() > 0)
			query.setParameterList("statusList", statusList);

		for (int i = 0; i < list.size(); i++)
			query.setParameter(i, list.get(i));
		return query.list();
	}

	/*
	 * public List<Czdispose> getYet(int executeU, int fnBlockID,int day, String
	 * nowTime) {
	 * 
	 * Timestamp time = Timestamp.valueOf(nowTime);
	 * 
	 * Calendar t = Calendar.getInstance(); t.setTime(time); int d =
	 * t.get(Calendar.DAY_OF_MONTH) - day; t.set(Calendar.DAY_OF_MONTH, d);
	 * System.out.println(t.getTime());
	 * 
	 * // Date time=DateUtil.stringToDateTime(str); // Date
	 * time=DateUtil.getNowDay000000Start(); try { Query query = this
	 * .getSession() .createQuery(
	 * "from Czdispose dis where dis.status in('��ִ��') and dis.executeU=:executeU and dis.fnBlockId=:fnBlockID and dis.atime>=:t order by dis.atime asc"
	 * ); query.setParameter("executeU", executeU);
	 * query.setParameter("fnBlockID", fnBlockID); query.setParameter("t",
	 * t.getTime());
	 * 
	 * // query.setInteger("fnBlockID", fnBlockID); // query.setTimestamp("t",
	 * t);
	 * 
	 * List<Czdispose> list = query.list(); return list; } catch (Exception e) {
	 * e.printStackTrace(); } return null; } }
	 */
	/*
	 * public String[][] getYetDisposeInfo(String[][] csconsumer1,int uid
	 * ,List<Csconsumer> csconsumer2,String startTime,String endTime)
	 * 
	 * {//���ط������id,���ʱ�䣬��鲿λ��������� String sql=
	 * "select czb.ItemID,czb.CsID,czb.ISTime,cza.ISCheck,czd.AU from CZBCUltrasoundIS czb,CZAContent cza,CZDispose czd where czb.ItemID = cza.ItemID and czb.ItemID = czd.ItemID"
	 * ; List<Object> parameterlist = new ArrayList<Object>(); List<Long>
	 * csconsumerlist1=new ArrayList<Long>(); List<Long> csconsumerlist2=new
	 * ArrayList<Long>();
	 * 
	 * if (csconsumer1!=null) { for(int i=0;i<csconsumer1.length;i++) {
	 * csconsumerlist1.add(Long.parseLong(csconsumer1[i][0]));
	 * 
	 * } sql=sql+" and czb.CsID in (:csconsumerlist1)"; } if (csconsumer2!=null)
	 * { for(int i=0;i<csconsumer2.size();i++) {
	 * csconsumerlist2.add(csconsumer2.get(i).getCsId()); }
	 * 
	 * sql=sql+" and czb.CsID in (:csconsumerlist2)";
	 * 
	 * } if (uid!=-1) { sql=sql+" and czd.AU ='"+uid+"'";
	 * 
	 * } if(startTime!=""&&startTime!=null) { Timestamp time1 =
	 * Timestamp.valueOf(startTime);//��ʼʱ�� Calendar t1 = Calendar.getInstance();
	 * t1.setTime(time1);
	 * 
	 * sql=sql+" and czb.ISTime>=?"; parameterlist.add(t1.getTime()); }
	 * if(endTime!=""&&endTime!=null) { Timestamp time2 =
	 * Timestamp.valueOf(endTime);//����ʱ�� Calendar t2 = Calendar.getInstance();
	 * t2.setTime(time2);
	 * 
	 * sql=sql+" and czb.ISTime<=?"; parameterlist.add(t2.getTime()); }
	 * 
	 * try { Query query = this.getSession().createSQLQuery(sql); if
	 * (csconsumer1!=null) { query.setParameterList("csconsumerlist1",
	 * csconsumerlist1); } if(csconsumer2!=null) {
	 * query.setParameterList("csconsumerlist2", csconsumerlist2); } for(int
	 * i=0;i<parameterlist.size();i++) { query.setParameter(i,
	 * parameterlist.get(i));
	 * 
	 * }
	 * 
	 * List<Object[]> list = query.list(); int i = list.size(); String[][] str =
	 * new String[i][5]; for (int y = 0; y < i; y++) { str[y][0] =
	 * list.get(y)[0] == null ? "" : list.get(y)[0].toString(); str[y][1] =
	 * list.get(y)[1] == null ? "" : list.get(y)[1].toString(); str[y][2] =
	 * list.get(y)[2] == null ? "" : list.get(y)[2].toString(); str[y][3] =
	 * list.get(y)[3] == null ? "" : list.get(y)[3].toString(); str[y][4] =
	 * list.get(y)[4] == null ? "" : list.get(y)[4].toString();
	 * 
	 * } return str; } catch (Exception e) { e.printStackTrace(); } return null;
	 * 
	 * }
	 */

	public List<Czdispose> getYetDisposeInfo(int executeU, String startTime,
			String endTime) {
		/*
		 * Timestamp t = Timestamp.valueOf(nowTime); int d = t.getDate() - day;
		 * t.setDate(d); String str = t.toString();
		 */

		Timestamp start = null;
		Timestamp end = null;
		try {
			SimpleDateFormat dfl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date datell = dfl.parse(startTime);
			String time = dfl.format(datell);
			start = Timestamp.valueOf(time);

			datell = dfl.parse(endTime);
			time = dfl.format(datell);
			end = Timestamp.valueOf(time);

		} catch (Exception e) {

		}

		// Date time=DateUtil.stringToDateTime(str);
		// Date time=DateUtil.getNowDay000000Start();
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from Czdispose dis where dis.status in('�ѽ�����ִ��','δ������ִ��','��ִ��') and dis.executeU=:executeU  and dis.executeTime between :start and :end order by dis.atime asc");
			query.setParameter("executeU", executeU);
			query.setParameter("start", start);
			query.setParameter("end", end);

			// query.setInteger("fnBlockID", fnBlockID);
			// query.setTimestamp("t", t);

			List<Czdispose> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Object[]> getZyInpatientProjectPrice(String inpatientId,
			String type, List<String> paramList1) {

		String sql = "select c2.DisposeItemType, sum(c1.RealP),0 as '0', sum(c1.ReceivableP)"
				+ " from czdispose c1,"
				+ "CZDisposeItemDescribe c2 where c1.ItemTypeID= c2.ItemTypeID "
				+ "and c1.KindID=? and c1.AKind=? ";
		// ���ֻ��ѯ����ĵ���
//		if (type.indexOf("����") > -1) {
//			sql += " and DATEDIFF(DAY,c1.atime,GETDATE())=0 ";
//		}

		if (null != paramList1 && paramList1.size() > 0)
			sql += " and c1.Status in (:status)";
		sql += " group by c2.DisposeItemType";
		Query query = getSession().createSQLQuery(sql);

		query.setParameter(0, inpatientId).setParameter(1, type);
		if (null != paramList1 && paramList1.size() > 0)
			query.setParameterList("status", paramList1);
		return (List<Object[]>) query.list();

	}

	//
	public List<List<String>> getInpatientProjectDetail(String inpatientId,
			String projectName, String type, List<String> paramList1) {

		StringBuilder sb = new StringBuilder();
		List<Object> list = new ArrayList<Object>();

		if (null != inpatientId && !"".equals(inpatientId)) {
			sb.append(" and c1.KindID=?");
			list.add(inpatientId);
		}
		if (null != projectName && !"".equals(projectName)) {
			sb.append(" and c2.DisposeItemType=?");
			list.add(projectName);

		}
		if (null != type && !"".equals(type)) {

			sb.append(" and c1.AKind=?");
			list.add(type);
		}

		String sql = "select c2.ItemName,'��' as a ,c1.ReceivableP,'1' as b ,"
				+ "c1.realp,o.UName as c,c1.ReceivableP-c1.realp as temp1,'' as d,0 as '����', c1.ItemID,c2.DisposeItemType"
				+ " from czdispose c1,CZDisposeItemDescribe c2 ,OSUForm o where o.UID=c1.ExecuteU and  c1.ItemTypeID= c2.ItemTypeID "
				+ sb.toString();

		if (null != paramList1 && paramList1.size() > 0)
			sql += " and c1.Status in (:status)";

		// ���ֻ��ѯ����ĵ���
//		if (type.indexOf("����") > -1) {
//			sb.append(" and DATEDIFF(DAY,c1.atime,GETDATE())=0 ");
//		}
		Query query = getSession().createSQLQuery(sql);

		for (int i = 0; i < list.size(); i++)
			query.setParameter(i, list.get(i));
		if (null != paramList1 && paramList1.size() > 0)
			query.setParameterList("status", paramList1);
		List<Object[]> returnList = query.list();

		return listObject2ListString(returnList);
	}

	public Double getZyReduceMoney(String inpatientId, String typeStr) {
		String sql = "select sum(c1.ReceivableP-c1.RealP) as temp1 from czdispose c1 where c1.KindID=? and c1.AKind=?";
		// ���ֻ��ѯ����ĵ���
//		if (typeStr.indexOf("����") > -1) {
//			sql += " and DATEDIFF(DAY,c1.atime,GETDATE())=0 ";
//		}
		return (Double) getSession().createSQLQuery(sql)
				.setParameter(0, inpatientId).setParameter(1, typeStr)
				.uniqueResult();

	}

	public List<List<String>> getReducePojectDetail(String inpatientId,
			String typeStr, List<String> paramList1) {
		String sql = "select c2.ItemName,c1.ReceivableP, c1.ReceivableP-c1.RealP as temp2,"
				+ "c2.DisposeItemType, c1.ReceivableP-c1.RealP as temp1,'0' as projectType ,"
				+ "c1.ItemID,'' as nul from czdispose c1,"
				+ "CZDisposeItemDescribe c2 where c1.ItemTypeID= c2.ItemTypeID "
				+ "and c1.KindID=? and c1.AKind=? ";
		if (null != paramList1 && paramList1.size() > 0)
			sql += " and c1.Status in (:status)";

		// ���ֻ��ѯ����ĵ���
//		if (typeStr.indexOf("����") > -1) {
//			sql += " and DATEDIFF(DAY,c1.atime,GETDATE())=0 ";
//		}
		Query query = getSession().createSQLQuery(sql)
				.setParameter(0, inpatientId).setParameter(1, typeStr);
		if (null != paramList1 && paramList1.size() > 0)
			query.setParameterList("status", paramList1);
		List<Object[]> list = query.list();

		return listObject2ListString(list);
	}

	public List<List<String>> getInvoiceCZ(String kindType, String kindId,
			String status) {
		List<Object[]> list = getSession()
				.createSQLQuery(
						"select c2.ItemName,'��' as a ,'1' as b ,"
								+ "c1.ReceivableP,c1.ReceivableP-c1.RealP as temp1,s.invoiceNO,c1.ItemID "
								+ " from czdispose c1,SFMZInvoiceContent s ,CZDisposeItemDescribe c2,SFMZInvoiceHead s1"
								+ " where s.invoiceNO=s1.invoiceNO and c1.ItemID=s.billNO and  c1.ItemTypeID= c2.ItemTypeID "
								+ "and c1.KindID=? and c1.AKind=? and c1.Status=? and s1.isCancel=?")
				.setParameter(0, kindId).setParameter(1, kindType)
				.setParameter(2, status).setParameter(3, false).list();

		return listObject2ListString(list);
	}

	public void updateCzDisposeStatus(Set<String> disposeApplicationFormIds,
			String string) {
		StringBuilder sb = new StringBuilder();
		sb.append("update Czdispose s set status=? ");

		if (null != disposeApplicationFormIds
				&& disposeApplicationFormIds.size() > 0) {
			sb.append(" where s.itemId in (:itemId)");
		}
		Query query = getSession().createQuery(sb.toString());
		query.setParameter(0, string);
		if (null != disposeApplicationFormIds
				&& disposeApplicationFormIds.size() > 0) {
			query.setParameterList("itemId", disposeApplicationFormIds);
		}
		query.executeUpdate();
	}

	public Integer getCZCount(String kindTypeId, String kindId,
			String... status) {

		Object obj = getSession()
				.createSQLQuery(
						"select count(c.AKind) from Czdispose c where AKind=? and KindID=? and Status in (:status)")
				.setParameter(0, kindTypeId).setParameter(1, kindId)
				.setParameterList("status", status).uniqueResult();

		return (Integer) obj;
	}

	public String[][] getStatisticInfo(int executeU, String QueryItem,
			String startTime, String endTime) {
		// TODO Auto-generated method stub
		Timestamp start = null;
		Timestamp end = null;

		try {
			SimpleDateFormat dfl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date datell = dfl.parse(startTime);
			String time = dfl.format(datell);
			start = Timestamp.valueOf(time);

			datell = dfl.parse(endTime);
			time = dfl.format(datell);
			end = Timestamp.valueOf(time);

		} catch (Exception e) {

		}

		// Date time=DateUtil.stringToDateTime(str);
		// Date time=DateUtil.getNowDay000000Start();
		try {
			String sql="";
			Query query = null;
			if (QueryItem.equals("���ҽʦ") )
			{
				query = this.getSession().createSQLQuery("select SName ,count (ExecutePerson)" +
						"from CZDispose dis, OSStuff os where dis.ExecutePerson<> -1 and" +
						" dis.status in('�ѽ�����ִ��','δ������ִ��','��ִ��') and dis.executeTime between ? and ?"+ 
						" and dis.executeU= ? and os.sid=dis.ExecutePerson group by dis.ExecutePerson,os.SName" 
						);
				query.setParameter(0, start);			
				query.setParameter(1, end);
				query.setParameter(2, executeU);
				//query.list();
//				sql= "select SName ,count (ExecutePerson)" +
//						"from CZDispose dis, OSStuff os where dis.ExecutePerson<> -1 and" +
//						" dis.status in('�ѽ�����ִ��','δ������ִ��','��ִ��') and dis.executeTime between '"+ 
//						start +"' and '"+end+ "' and dis.executeU=" + executeU +
//						" and os.sid=dis.ExecutePerson group by dis.ExecutePerson,os.SName";
						
				
			}else if(QueryItem.equals("����ҽʦ"))
			{
				query = this.getSession().createSQLQuery("select SName ,count (AProposer)" +
						"from CZDispose dis, OSStuff os where " +
						" dis.status in('�ѽ�����ִ��','δ������ִ��','��ִ��') and dis.executeTime between ? and ?"+ 
						" and dis.executeU= ? and os.sid=dis.AProposer group by dis.AProposer,os.SName" 
						);
				query.setParameter(0, start);			
				query.setParameter(1, end);
				query.setParameter(2, executeU);
				
			}
			else if(QueryItem.equals("�������"))
			{
				query = this.getSession().createSQLQuery("select UName ,count (AU)" +
						"from CZDispose dis, OSUForm os where " +
						" dis.status in('�ѽ�����ִ��','δ������ִ��','��ִ��') and dis.executeTime between ? and ?"+ 
						" and dis.executeU= ? and os.UID=dis.AU group by dis.au,os.UName" 
						);
				query.setParameter(0, start);			
				query.setParameter(1, end);
				query.setParameter(2, executeU);
				
			}

	
//		if (sql!="")
//		{
//			Query query = this.getSession().createSQLQuery(sql);
//			query.list();
			return listObject2StringString(query.list());
			
//		}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
}