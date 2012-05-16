package leo.yf.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.YfinbankAitem;
import leo.yf.dao.iface.YfinbankAitemDao;

import org.hibernate.Query;

@SuppressWarnings("unchecked")
public class YfinbankAitemDaoImpl extends DaoSupport<YfinbankAitem> implements
		YfinbankAitemDao {

	public boolean addYfinbankAitem(List<YfinbankAitem> yfinbankAitem) {
		for (int i = 0; i < yfinbankAitem.size(); i++) {
			this.getHibernateTemplate().save(yfinbankAitem.get(i));
		}
		// this.getHibernateTemplate().save(yfinbankAitem);
		return true;
	}

	public boolean delYfinbankAitem(String ApproveFormID) {
		Query query = null;
		query = this.getSession().createSQLQuery(
				"delete from YfinbankAitem where approveFormId = ?");
		query.setParameter(0, ApproveFormID);
		query.executeUpdate();
		return true;
	}

	public List<YfinbankAitem> getYfinbankAitem(String approveFormId) {
		List<YfinbankAitem> list = this.getHibernateTemplate().find(
				"from YfinbankAitem where approveFormId = ?", approveFormId);
		return list;
	}

	public String[] getRuKuJiaGe(Integer YFID, Integer YPID) {
		List<String> list;
		Query query = null;
		if (YFID != -2) {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "YFInbankAItem.InbankP "
									+ "from "
									+ "YFInbankAItem,YFMInbankA "
									+ "where "
									+ "YFInbankAItem.ApproveFormID = YFMInbankA.AFormID and "
									+ "YFInbankAItem.MID = ? and "
									+ "YFMInbankA.PharmacyID = ? and "
									+ "YFInbankAItem.InbankP <> -1 "
									+ "order by YFInbankAItem.ItemID desc");

			query.setParameter(0, YPID);
			query.setParameter(1, YFID);
		} else {
			query = this
					.getSession()
					.createSQLQuery(
							"select "
									+ "YFInbankAItem.InbankP "
									+ "from "
									+ "YFInbankAItem,YFMInbankA "
									+ "where "
									+ "YFInbankAItem.ApproveFormID = YFMInbankA.AFormID and "
									+ "YFInbankAItem.MID = ? and "
									+ "YFInbankAItem.InbankP <> -1 "
									+ "order by YFInbankAItem.ItemID desc");
			query.setParameter(0, YPID);
		}
		list = query.list();
		String result[] = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = String.valueOf(list.get(0));
		}
		return result;
	}

	public List<List<String>> getReturnPrescription(String outPatientId,
			String status) {

		List<Object[]> list = getSession()
				.createSQLQuery(
						"select y1.MName ,y4.ExbankP,y2.Num,y4.ExbankP*y2.num-y2.reduceTotal as temp1,y3.AFormID,t2.invoiceNO "
								+ " from  YFMInfo y1 ,YFInbankAItem y2,YFMInbankA y3,YFPrice y4,YFExbankAItem t1,sfmzInvoiceContent t2 "
								+ "where y1.MInfoID=y4.MInfoID and y2.MID=y1.MInfoID and y2.ApproveFormID=y3.AFormID "
								+ " and t1.itemid=y2.ExbankItemID and t2.billNo= t1.ItemID "
								+ " and y4.MInfoID=y2.MID and y3.OPNum=? and y3.InbankStatus=? and y4.exbanktype='门诊领药'")
				.setParameter(0, outPatientId).setParameter(1, status).list();

		return listObject2ListString(list);
	}

	public String getChuKuDanID(String RuKuDanID, Integer YaoPinID) {
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery(
				"select " + "   ZYDoctorAdvice.AFormID " + "from "
						+ "   YFInbankAItem,ZYDoctorAdvice " + "where "
						+ "   YFInbankAItem.DAID = ZYDoctorAdvice.DAID and "
						+ "   YFInbankAItem.ApproveFormID = ? and "
						+ "   YFInbankAItem.MID = ?");
		query.setParameter(0, RuKuDanID);
		query.setParameter(1, YaoPinID);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "-1";
		else
			return list.get(0);
	}

	public String[][] getTuiYao(String DanHao, String LeiXing) {
		Query query = null;
		query = this
				.getSession()
				.createSQLQuery(
						"select "
								+ "   YFMInfo.MName, "
								+ // 0药品名称
								"   YFMInfo.MSpec, "
								+ // 1药品规格
								"   YFMInfo.Manufacturer, "
								+ // 2产地
								"   YFInbankAItem.Unit, "
								+ // 3单位
								"   YFInbankAItem.Num, "
								+ // 4数量
								"   YFPrice.ExbankP, "
								+ // 5单价
								"   YFInbankAItem.Num * YFPrice.ExbankP as xj, "
								+ // 6小计
								"   YFInbankAItem.MID "
								+ // 7药品ID
								"from "
								+ "   YFMInbankA,YFInbankAItem,YFPrice,YFMInfo "
								+ "where "
								+ "   YFMInfo.MInfoID = YFInbankAItem.MID and "
								+ "   YFMInbankA.AFormID = YFInbankAItem.ApproveFormID and "
								+ "   YFInbankAItem.MID = YFPrice.MInfoID and "
								+ "   YFPrice.ExbankType = ? and "
								+ "   YFMInbankA.aformid = ?");
		query.setParameter(0, LeiXing);
		query.setParameter(1, DanHao);
		query.list();
		return listObject2StringString(query.list());
	}
	
	public Double getZongJieE(String ApproveFormID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("select sum(num * InbankP - ReduceTotal) as zj from YFInbankAItem where approveformid = ?");
		query.setParameter(0, ApproveFormID);
		List<Double> list = query.list(); //(List<Double>) 
		if (list.size() < 1)
			return 0d;
		else
			return list.get(0);
	}

}
