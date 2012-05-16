package leo.yf.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import leo.common.dao.DaoSupport;
import leo.entity.YfexbankAitem;
import leo.yf.dao.iface.YfExbankAItemDao;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 23, 2011 11:35:13 AM
 */
@SuppressWarnings("unchecked")
public class YfExbankAItemDaoImpl extends DaoSupport<YfexbankAitem> implements
		YfExbankAItemDao {

	public List<Object[]> getCF(List<String> aformIDs) {
		/**
		 * 查询的列名<br>
		 * 项目名称'<br>
		 * '规格'<br>
		 * '单价'<br>
		 * '单位'<br>
		 * '剂量'<br>
		 * '给药方式'<br>
		 * '数量'<br>
		 * '总额'<br>
		 * 药品信息ID<br>
		 * (出库申请项表中)项Id<br>
		 * (出库申请单表中)申领单ID<br>
		 */
		String strSql = "select y3.MName,y3.MSpec,y4.ExbankP,y3.PharmacyUnit,y3.MDosage,"
				+ "y3.WayTo,y1.Num,y4.ExbankP*y1.num,y3.MInfoID,y1.ItemID,y1.AFormID"
				+ " from YFExbankAItem y1 ,YFMStock y2,YFMInfo y3,YFPrice y4 "
				+ "where y1.MID=y2.MID and y2.MInfoID=y3.MInfoID and y3.MInfoID=y4.MInfoID";
		if (null != aformIDs && aformIDs.size() > 1) {
			strSql += " and y1.AFormID in (:aFormIDs)";
		}
		Query query = getSession().createSQLQuery(strSql);

		if (null != aformIDs && aformIDs.size() > 1)
			query.setParameterList("aFormIDs", aformIDs);

		return query.list();
	}

	public void updateReduce(List<Long> itemIDList, List<Double> itemReduce) {
		YfexbankAitem yfexbankAitem = null;
		Long id = 0l;
		for (int i = 0; i < itemIDList.size(); i++) {
			id = itemIDList.get(i);
			yfexbankAitem = find(id);
			yfexbankAitem.setReduceMoney(itemReduce.get(i));
		}
	}

	public boolean addYfexbankAitem(List<YfexbankAitem> yfexbankAitem) {// 增加出库单项目
		// for (YfexbankAitem temp : yfexbankAitem)
		// this.getHibernateTemplate().save(temp);
		for (int i = 0; i < yfexbankAitem.size(); i++) {
			this.getHibernateTemplate().save(yfexbankAitem.get(i));
		}
		return true;
	}

	public boolean updateYfexbankAitem(YfexbankAitem yfexbankAitem) {
		this.getHibernateTemplate().update(yfexbankAitem);
		return true;
	}

	public boolean delYFExbankAItem(String AFormID) {
		Query query = null;
		query = this.getSession().createSQLQuery(
				"delete from YFExbankAItem where AFormID = ?");
		query.setParameter(0, AFormID);
		query.executeUpdate();
		return true;
	}

	public List<YfexbankAitem> getYfexbankAitem(String AFormID) {
		List<YfexbankAitem> list = this.getHibernateTemplate().find(
				"from YfexbankAitem where aformId = ?", AFormID);
		return list;
	}

	/**
	 * 根据主键查询出库申请项
	 */
	public YfexbankAitem getYfexbankAitemByitemId(Long itemId) {
		// TODO Auto-generated method stub
		try {
			return (YfexbankAitem) super.getHibernateTemplate().get(
					YfexbankAitem.class, itemId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<YfexbankAitem> getYfexbankAitemByAFormID(String aformID, int mid) {
		try {
			Query query = this.getSession().createQuery(
					"from YfexbankAitem  where aformId=?and mid=?");
			query.setParameter(0, aformID);
			query.setParameter(1, mid);
			List<YfexbankAitem> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Object[]> getInpatientProject(List<String> applicationIds) {
		return (List<Object[]>) getSession()
				.createSQLQuery(
						"select t2.MType, sum(t1.PReceivable-t1.PReturned) as temp1,1 as '1',sum(t1.PReceivable) as temp2 from "
								+ "YFExbankAItem t1 ,YFMInfo t2 where t2.MInfoID=t1.MID and t1.AFormID"
								+ " in (:ids) group by t2.MType")
				.setParameterList("ids", applicationIds).list();
	}

	public List<Object[]> getDerateInpatientProject(List<String> applicationIds) {

		return (List<Object[]>) getSession()
				.createSQLQuery(
						"select t2.MType,t1.num,t1.PReceivable,t1.ReduceMoney,t1.NumReturned from "
								+ "YFExbankAItem t1 ,YFMInfo t2 where t2.MInfoID=t1.MID and t1.AFormID in (:ids)")
				.setParameterList("ids", applicationIds).list();

	}

	public List<List<String>> getReducePojectDetail(String inpatientId,
			String typeStr, List<String> paramList2) {
		List<Object[]> list = null;
		List<List<String>> returnList = null;
		List<String> list2 = null;

		String sql = "select t1.MName,t1.PharmacyUnit,t4.price,t4.num,t4.PReceivable,"
				+ "t4.ReduceMoney,t4.NumReturned,t1.MType,t4.ItemID,t4.AFormID"
				+ " from YFMInfo t1 ,YFMExbankA t2,YFSetExbankType t3,YFExbankAItem t4"
				+ " where t3.ExbankID=t2.ExbankTypeID and t2.AFormID=t4.AFormID and t4.MID= t1.MInfoID "
				+ "  and t3.ETypeName=? and t2.OPNum=?";

		if (null != paramList2 && paramList2.size() > 0)
			sql += " and t2.ExbankStatus in (:status)";

		// 门诊，只查询当天的单子
		// if (typeStr.indexOf("门诊") > -1) {
		// sql += " and DATEDIFF(DAY,t2.atime,GETDATE())=0 ";
		// }
		Query query = getSession().createSQLQuery(sql);
		query.setParameter(0, typeStr).setParameter(1, inpatientId);
		if (null != paramList2 && paramList2.size() > 0)
			query.setParameterList("status", paramList2);
		list = query.list();
		returnList = new ArrayList<List<String>>();

		for (Object[] objects : list) {
			if (objects[3].toString().equals(objects[6].toString())) {// 要退就退完不显示
				continue;
			}
			list2 = new ArrayList<String>();
			list2.add(objects[0].toString());
			list2.add(objects[4].toString());
			list2.add(objects[5].toString());
			list2.add(objects[7].toString());
			// 重复记录医生在收费前输入的减免金额
			list2.add(objects[5].toString());
			list2.add("1");
			list2.add(objects[8].toString());
			list2.add(objects[9].toString());
			returnList.add(list2);

		}

		return returnList.size() > 0 ? returnList : Collections.EMPTY_LIST;
	}

	public List<List<String>> getInpatientProjectDetail(Boolean isderate,
			String inpatientId, String projectName, String type,
			List<String> paramList2) {
		List<Object[]> list = null;
		List<List<String>> returnList = null;
		List<String> list2 = null;
		if (!isderate) {

			StringBuilder sb = new StringBuilder();
			List<Object> paramList = new ArrayList<Object>();

			if (null != projectName && !"".equals(projectName)) {
				sb.append(" and t1.MType=?");
				paramList.add(projectName);
			}
			if (null != type && !"".equals(type)) {
				sb.append(" and t3.ETypeName=? ");
				paramList.add(type);
			}
			if (null != inpatientId && !"".equals(inpatientId)) {
				sb.append(" and t2.OPNum=?");
				paramList.add(inpatientId);
			}
			if (null != paramList2 && paramList2.size() > 0)
				sb.append(" and t2.ExbankStatus in (:status)");

			// 门诊，只查询当天的单子
			if (type.indexOf("门诊") > -1) {
				sb.append(" and DATEDIFF(DAY,t2.atime,GETDATE())=0 ");
			}

			Query query = getSession()
					.createSQLQuery(
							"select t1.MName,t1.PharmacyUnit,t4.price,t4.num-t4.NumReturned as temp1,t4.PReceivable-t4.PReturned as temp2"
									+ ",t1.MSpec,1 as '处方',t4.ItemID,t1.MType from YFMInfo t1 ,YFMExbankA t2,YFSetExbankType t3,YFExbankAItem t4"
									+ " where t3.ExbankID=t2.ExbankTypeID and t2.AFormID=t4.AFormID and t4.MID= t1.MInfoID "
									+ sb.toString());
			for (int i = 0; i < paramList.size(); i++)
				query.setParameter(i, paramList.get(i));

			if (null != paramList2 && paramList2.size() > 0)
				query.setParameterList("status", paramList2);
			list = query.list();

			returnList = new ArrayList<List<String>>();
			for (Object[] objects : list) {
				list2 = new ArrayList<String>();
				for (int i = 0; i < 5; i++) {
					Object object = objects[i];
					list2.add(object.toString());
				}
				list2.add("药房");
				list2.add("0");
				list2.add(objects[5].toString());
				list2.add(objects[6].toString());
				list2.add(objects[7].toString());
				list2.add(objects[8].toString());
				returnList.add(list2);
			}
		} else {
			StringBuilder sb = new StringBuilder();
			List<Object> paramList = new ArrayList<Object>();
			if (null != projectName && !"".equals(projectName)) {
				sb.append(" and t1.MType=?");
				paramList.add(projectName);
			}
			if (null != type && !"".equals(type)) {
				sb.append(" and t3.ETypeName=? ");
				paramList.add(type);
			}
			if (null != inpatientId && !"".equals(inpatientId)) {
				sb.append(" and t2.OPNum=?");
				paramList.add(inpatientId);
			}
			if (null != paramList2 && paramList2.size() > 0)
				sb.append(" and t2.ExbankStatus in (:status)");
			// 门诊，只查询当天的单子
			// if (type.indexOf("门诊") > -1) {
			// sb.append(" and DATEDIFF(DAY,t2.atime,GETDATE())=0 ");
			// }
			Query query = getSession()
					.createSQLQuery(//
							"select t1.MName,t1.PharmacyUnit,t4.price,t4.num,t4.PReceivable,"
									+ "t4.ReduceMoney,t4.NumReturned,t1.MSpec,t4.ItemID,t1.MType"
									+ " from YFMInfo t1 ,YFMExbankA t2,YFSetExbankType t3,YFExbankAItem t4"
									+ " where t3.ExbankID=t2.ExbankTypeID and t2.AFormID=t4.AFormID and t4.MID= t1.MInfoID "
									+ sb.toString());
			for (int i = 0; i < paramList.size(); i++)
				query.setParameter(i, paramList.get(i));
			if (null != paramList2 && paramList2.size() > 0)
				query.setParameterList("status", paramList2);
			list = query.list();

			returnList = new ArrayList<List<String>>();

			for (Object[] objects : list) {
				if (objects[3].toString().equals(objects[6].toString())) {// 要退就退完不显示
					continue;
				}
				list2 = new ArrayList<String>();
				String temp = String.valueOf(Double.parseDouble(objects[4]
						.toString())
						- Double.parseDouble(objects[5].toString()));
				for (int i = 0; i < 5; i++) {
					Object object = objects[i];
					if (i == 4) {// 4=objects.length - 2-1
						list2.add(temp);
					} else {
						list2.add(object.toString());
					}
				}
				list2.add("药房");
				list2.add(objects[5].toString());
				list2.add(objects[7].toString());
				list2.add("1");
				list2.add(objects[8].toString());
				list2.add(objects[9].toString());
				returnList.add(list2);

			}
		}
		return returnList.size() > 0 ? returnList : Collections.EMPTY_LIST;
	}

	public Double getReduceMoney(Boolean isderate, String inpatientId,
			String string) {
		List<Object[]> list = null;
		if (!isderate) {
			return 0d;
		} else {
			String sql = "select t4.price,t4.num,t4.PReceivable,t4.ReduceMoney,t4.NumReturned"
					+ " from YFMExbankA t2,YFSetExbankType t3,YFExbankAItem t4"
					+ " where t3.ExbankID=t2.ExbankTypeID and t2.AFormID=t4.AFormID "
					+ " and t3.ETypeName=? and t2.OPNum=?";
			// 门诊，只查询当天的单子
			// if (string.indexOf("门诊") > -1) {
			// sql += " and DATEDIFF(DAY,t2.atime,GETDATE())=0 ";
			// }
			list = getSession().createSQLQuery(sql).setParameter(0, string)
					.setParameter(1, inpatientId).list();
			Double sumReduce = 0d;
			for (Object[] objects : list) {
				if (objects[1].toString().equals(objects[4].toString())) {// 要退就退完不显示
					continue;
				}
				sumReduce += Double.parseDouble(objects[3].toString());
			}
			return sumReduce;
		}
	}

	public List<List<String>> getCF(String outPatientId, String status) {

		List<Object[]> list = getSession()
				.createSQLQuery(
						"select t1.MName,t4.price,t4.num,t4.PReceivable-t4.ReduceMoney,t3.invoiceNO,t2.AFormID,t4.itemid"
								+ " from YFMInfo t1 ,YFMExbankA t2,SFMZInvoiceContent t3,YFExbankAItem t4"
								+ " where t3.billNO=t4.ItemID and t2.AFormID=t4.AFormID and t4.MID= t1.MInfoID "
								+ "and  t2.OPNum=? and t2.ExbankStatus=?")
				.setParameter(0, outPatientId).setParameter(1, status).list();
		return listObject2ListString(list);

	}

	public boolean updateYFExbankAItemTuiYao(String AFormID, Integer MID,
			Integer NumReturned, Double PReturned) {
		Query query = null;
		query = this
				.getSession()
				.createSQLQuery(
						"update YFExbankAItem set NumReturned = NumReturned + ?, PReturned = PReturned + ? where AFormID = ? and  MID = ?");
		query.setParameter(0, NumReturned);
		query.setParameter(1, PReturned);
		query.setParameter(2, AFormID);
		query.setParameter(3, MID);
		query.executeUpdate();
		return true;
	}

	public List<List<String>> getYfexbankAitemDetail(String applicationFormId) {

		List<Object[]> list = null;

		Query query = getSession()
				.createSQLQuery(
						"select t1.MName,t1.PharmacyUnit,t4.price,t4.num-t4.NumReturned as temp1,"
								+ "t4.PReceivable-t4.PReturned as temp2,t1.MType ,t4.ItemID "
								+ " from YFMInfo t1 ,YFExbankAItem t4"
								+ " where t4.MID= t1.MInfoID "
								+ "  and t4.AFormID=?");
		list = query.setParameter(0, applicationFormId).list();

		return listObject2ListString(list);

	}

	public boolean delYFExbankAItemByAFormIDMID(String AFormID, Integer MID) {
		Query query = null;
		query = this.getSession().createSQLQuery(
				"delete YFExbankAItem where AFormID = ? and  MID = ?");
		query.setParameter(0, AFormID);
		query.setParameter(1, MID);
		query.executeUpdate();
		return true;
	}

	public List<Object[]> getInvoiceCF(Set<String> aFormIds) {
		Query query = getSession()
				.createSQLQuery(
						"select  t1.ApproveFormID ,t2.invoiceNO "
								+ " from YFExbankAItem t1,sfmzInvoiceContent t2"
								+ " where t2.billNo= t1.ItemID and t1.ApproveFormID in (:ApproveFormID)");
		query.setParameterList("ApproveFormID", aFormIds);

		return query.list();
	}

}
