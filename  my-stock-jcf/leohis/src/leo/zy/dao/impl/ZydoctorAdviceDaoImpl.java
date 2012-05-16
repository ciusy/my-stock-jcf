package leo.zy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.Yfaitem;
import leo.entity.ZydoctorAdvice;
import leo.zy.dao.iface.ZydoctorAdviceDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 18, 2011 3:13:37 PM
 */
public class ZydoctorAdviceDaoImpl extends DaoSupport<ZydoctorAdvice> implements ZydoctorAdviceDao {

	public List<ZydoctorAdvice> getZydoctorAdviceByIds(List<String> daIds) {
		return getSession().createQuery("from ZydoctorAdvice z where z.daid in (:daIds)").setParameterList("daIds", daIds).list();
	}
	
	public boolean addZYDoctorAdvice(ZydoctorAdvice zydoctorAdvice){
		this.getHibernateTemplate().save(zydoctorAdvice);
		return true;
	}
	
	public String getMaxID(){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery("select a.daid from ZydoctorAdvice a order by a.daid desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "no";
		else
			return list.get(0);
	}

	public String[][] getZydoctorAdvice(String IPID, String DAState, Integer IPDeptID, String RiQi_B, String RiQi_E, String ZhuangTaiTiaoJian){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;
		
		if (IPID != null && !IPID.equals("")){  //住院号
			tj = "ZYDoctorAdvice.IPID = ?";
			cs.add(IPID);
		}
		if (DAState != null && !DAState.equals("")){ //医嘱状态
			if (ZhuangTaiTiaoJian.equals("=")){
				if (tj.equals("")) 
					tj = " ZYDoctorAdvice.DAState = ?";
				else
					tj = tj + " and ZYDoctorAdvice.DAState = ?";
			}
			if (ZhuangTaiTiaoJian.equals("<>")){
				if (tj.equals("")) 
					tj = " ZYDoctorAdvice.DAState <> ?";
				else
					tj = tj + " and ZYDoctorAdvice.DAState <> ?";
			}
			cs.add(DAState);
		}
		if (IPDeptID != -2){ //住院部ID
			if (tj.equals("")) 
				tj = " ZYDoctorAdvice.IPDeptID = ?";
			else
				tj = tj + " and ZYDoctorAdvice.IPDeptID = ?"; 
			cs.add(IPDeptID);
		}
		if (RiQi_B != null && !RiQi_B.equals("")){ //开出时间
			if (tj.equals("")) 
				tj = " ZYDoctorAdvice.CreateTime >= ? and ZYDoctorAdvice.CreateTime <= ?";
			else
				tj = tj + " and ZYDoctorAdvice.CreateTime >= ? and ZYDoctorAdvice.CreateTime <= ?"; 
			cs.add(RiQi_B);
			cs.add(RiQi_E);
		}
		
		if (tj != null && !tj.equals("")){
			query = this.getSession().createSQLQuery("select " +
					                                 "  ZYIPMedicine.PharmacyUID," + //0取药科室ID
					                                 "  YFMInfo.MName, " + //1药品名称 
					                                 "  YFMInfo.MSpec, " + //2规格
					                                 "  ZYIPMedicine.Cost, " + //3单价
					                                 "  YFMInfo.PharmacyUnit, " + //4单位
					                                 "  YFMInfo.MDosage, " + //5剂量
					                                 "  YFMInfo.WayTo, " + //6给药方式
					                                 "  ZYIPMedicine.Usage, " + //7用法
					                                 "  ZYIPMedicine.Num, " + //8总量
					                                 "  ZYIPMedicine.MInfoID, " + //9药品ID
					                                 "  ZYIPMedicine.DAID, " + //10医嘱ID
					                                 "  ZYDoctorAdvice.CreateDoctor, " + //11 开单医生
					                                 "  ZYDoctorAdvice.DAState, " + //12状态
					                                 "  ZYDoctorAdvice.AFormID, "+ //13出库单ID
					                                 "  ZYIPMedicine.DAItemID " + //14医嘱项ID
					                                 "from " +
					                                 "  YFMInfo,ZYIPMedicine, ZYDoctorAdvice " +
					                                 "where " +
					                                 "  YFMInfo.MInfoID = ZYIPMedicine.MInfoID and " +
					                                 "  ZYDoctorAdvice.DAID = ZYIPMedicine.DAID and " + tj + " order by ZYIPMedicine.DAID");
			for(int i=0;i<cs.size();i++){
		    	query.setParameter(i, cs.get(i));
			}	
		}
		else{	
			query = this.getSession().createSQLQuery("select " +
                    								 "  ZYIPMedicine.PharmacyUID," + //0取药科室ID
                    								 "  YFMInfo.MName, " + //1药品名称 
                    								 "  YFMInfo.MSpec, " + //2规格
                    								 "  ZYIPMedicine.Cost, " + //3单价
                    								 "  YFMInfo.PharmacyUnit, " + //4单位
                    								 "  YFMInfo.MDosage, " + //5剂量
                    								 "  YFMInfo.WayTo, " + //6给药方式
                    								 "  ZYIPMedicine.Usage, " + //7用法
                    								 "  ZYIPMedicine.Num, " + //8总量
                    								 "  ZYIPMedicine.MInfoID, " + //9药品ID
                    								 "  ZYIPMedicine.DAID, " + //10医嘱ID
					                                 "  ZYDoctorAdvice.CreateDoctor " + //11 开单医生
					                                 "  ZYDoctorAdvice.DAState, " + //12状态
					                                 "  ZYDoctorAdvice.AFormID "+ //13出库单ID
					                                 "  ZYIPMedicine.DAItemID " + //14医嘱项ID
                    								 "from " +
                    								 "  YFMInfo,ZYIPMedicine, ZYDoctorAdvice " +
                    								 "where " +
                    								 "  YFMInfo.MInfoID = ZYIPMedicine.MInfoID and " +
                    								 "  ZYDoctorAdvice.DAID = ZYIPMedicine.DAID order by ZYIPMedicine.DAID");
		}
		query.list();
		return listObject2StringString(query.list());
	}

	public String[][] getZydoctorAdvice_CZ(String IPID, String DAState, Integer IPDeptID, String State, String RiQi_B, String RiQi_E){
		String tj, fromtj, wheretj, selecttj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		fromtj = "";
		wheretj = "";
		selecttj = "";
		
		Query query = null;
		
		if (IPID != null && !IPID.equals("")){  //住院号
			tj = "ZYDoctorAdvice.IPID = ?";
			cs.add(IPID);
		}
		if (DAState != null && !DAState.equals("")){ //医嘱状态
			if (tj.equals("")) 
				tj = " ZYDoctorAdvice.DAState = ?";
			else
				tj = tj + " and ZYDoctorAdvice.DAState = ?"; 
			cs.add(DAState);
		}
		if (IPDeptID != -2){ //住院部ID
			if (tj.equals("")) 
				tj = " ZYDoctorAdvice.IPDeptID = ?";
			else
				tj = tj + " and ZYDoctorAdvice.IPDeptID = ?"; 
			cs.add(IPDeptID);
		}
		if (RiQi_E != null && !RiQi_E.equals("")){ //开出日期
			if (tj.equals("")) 
				tj = " ZYDoctorAdvice.CreateTime >= ? and ZYDoctorAdvice.CreateTime <= ?";
			else
				tj = tj + " and ZYDoctorAdvice.CreateTime >= ? and ZYDoctorAdvice.CreateTime <= ?"; 
			cs.add(RiQi_B);
			cs.add(RiQi_E);
		}
		if (State != null  && !State.equals("")){ //处置状态
			if (tj.equals("")) 
				tj = " CZDispose.status = ?";
			else
				tj = tj + " and CZDispose.status = ?"; 
			cs.add(State);
			fromtj = "   ZYDoctorAdvice,CZDisposeItemDescribe,ZYIPTeatment,CZDispose ";
			wheretj = "   CZDispose.ItemID = ZYIPTeatment.ItemID and ";
			selecttj = "   CZDispose.Status, ";
		}
		else{
			fromtj = "   ZYDoctorAdvice,CZDisposeItemDescribe,ZYIPTeatment ";
			wheretj = "";
			//selecttj = "   '未交费可执行' as Status, ";
			selecttj = "isnull((select Status from CZDispose where ItemID = ZYIPTeatment.ItemID),'未交费可执行') as Status, ";
		}
		
		if (tj != null && !tj.equals("")){
			query = this.getSession().createSQLQuery("select " +
					                                 "   CZDisposeItemDescribe.ItemName," + // 0名称
					                                 "   CZDisposeItemDescribe.Cost," + // 1单价
					                                 "   ZYIPTeatment.ExecuteU," + // 2执行科室ID
					                                 "   ZYIPTeatment.ItemTypeID," + // 3项目类型ID
					                                 "   ZYIPTeatment.DAID," + // 4医嘱ID
					                                 "   ZYDoctorAdvice.CreateDoctor, " + //5开单医生
					                                 "   ZYIPTeatment.DAItemID, " + //6医嘱项ID
					                                 "   ZYDoctorAdvice.DAID, " + //7医嘱ID
					                                 selecttj + //8处置状态
					                                 "   ZYDoctorAdvice.DAState, " + //9医嘱状态
					                                 "   ZYIPTeatment.ItemID, " + //10处置项ID
					                                 "   ZYIPTeatment.AContent " + //11申请单内容
					                                 "from " +
					                                 fromtj +
					                                 "where " +
					                                 wheretj +
					                                 "   ZYDoctorAdvice.DAID = ZYIPTeatment.DAID and " +
					                                 "   ZYIPTeatment.ItemTypeID = CZDisposeItemDescribe.ItemTypeID and " + tj + " order by ZYIPTeatment.DAID");
			for(int i=0;i<cs.size();i++){
		    	query.setParameter(i, cs.get(i));
			}	
		}
		else{	
			query = this.getSession().createSQLQuery("select " +
                                                     "   CZDisposeItemDescribe.ItemName," + // 名称
                                                     "   CZDisposeItemDescribe.Cost," + //单价
                                                     "   ZYIPTeatment.ExecuteU," + //执行科室ID
                                                     "   ZYIPTeatment.ItemTypeID," + //项目类型ID
					                                 "  ZYIPTeatment.DAID," + // 4医嘱ID
					                                 "  ZYDoctorAdvice.CreateDoctor, " + //5开单医生
					                                 "   ZYIPTeatment.DAItemID, " + //6医嘱项ID
					                                 "   ZYDoctorAdvice.DAID, " + //7医嘱ID
					                                 selecttj + //8处置状态
					                                 "   ZYDoctorAdvice.DAState, " + //9医嘱状态
					                                 "   ZYIPTeatment.ItemID, " + //10处置项ID
					                                 "   ZYIPTeatment.AContent " + //11申请单内容
                                                     "from " +
                                                     fromtj +
                                                     "where " +
					                                 wheretj +
                                                     "   ZYDoctorAdvice.DAID = ZYIPTeatment.DAID and " +
                                                     "   ZYIPTeatment.ItemTypeID = CZDisposeItemDescribe.ItemTypeID order by ZYIPTeatment.DAID");
		}
		query.list();
		return listObject2StringString(query.list());
	}
	
	public boolean updateZydoctorAdviceShenHe(String DAID, Long ApproveNurse, String ApproveTime, String DAState, String AFormID){
		Query query = null;
		query = this.getSession().createSQLQuery("update ZYDoctorAdvice set ApproveNurse = ?, ApproveTime = ?, DAState = ?, AFormID = ? where DAID = ?");
		query.setParameter(0,ApproveNurse);
		query.setParameter(1,ApproveTime);
		query.setParameter(2,DAState);
		query.setParameter(3,AFormID);
		query.setParameter(4,DAID);
		query.executeUpdate();
		return true;
	}

	public boolean updateZydoctorAdviceZhuangTai(String DAID, String DAState){
		Query query = null;
		query = this.getSession().createSQLQuery("update ZYDoctorAdvice set DAState = ? where DAID = ?");
		query.setParameter(0,DAState);
		query.setParameter(1,DAID);
		query.executeUpdate();
		return true;
	}

	public String[][] getFeiYongQingDan(String ZhuYuanHao, String ZhuanTai_CZ, String ZhuangTai_CFFaYao, String ZhuangTai_CFTuiYao, String ZhiXingShiJian_B, String ZhiXingShiJian_E){
		String tj, tj1, tj2;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		tj1 = "";
		tj2 = "";
		Query query = null;
		
		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")){  //住院号
			tj = "CZDispose.kindid = ?";
			cs.add(ZhuYuanHao);
		}
		if (ZhuanTai_CZ != null && !ZhuanTai_CZ.equals("")){ //处置状态
			if (tj.equals("")) 
				tj = " CZDispose.Status = ?";
			else
				tj = tj + " and CZDispose.Status = ?"; 
			cs.add(ZhuanTai_CZ);
		}
		if (ZhiXingShiJian_B != null && !ZhiXingShiJian_B.equals("")){ //处置执行时间
			if (tj.equals("")) 
				tj = " CZDispose.EXecuteTime >= ? and CZDispose.EXecuteTime <= ?";
			else
				tj = tj + " and CZDispose.EXecuteTime >= ? and CZDispose.EXecuteTime <= ?"; 
			cs.add(ZhiXingShiJian_B);
			cs.add(ZhiXingShiJian_E);
		}
		
		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")){  //住院号
			tj1 = "YFMExbankA.OPNum = ?";
			cs.add(ZhuYuanHao);
		}
		if (ZhuangTai_CFFaYao != null && !ZhuangTai_CFFaYao.equals("")){ //处方状态
			if (tj1.equals("")) 
				tj1 = " YFMExbankA.ExbankStatus = ?";
			else
				tj1 = tj1 + " and YFMExbankA.ExbankStatus = ?"; 
			cs.add(ZhuangTai_CFFaYao);
		}
		if (ZhiXingShiJian_B != null && !ZhiXingShiJian_B.equals("")){ //处方执行时间
			if (tj1.equals("")) 
				tj1 = " YFMExbankA.ExbankTime >= ? and YFMExbankA.ExbankTime <= ?";
			else
				tj1 = tj1 + " and YFMExbankA.ExbankTime >= ? and YFMExbankA.ExbankTime <= ?"; 
			cs.add(ZhiXingShiJian_B);
			cs.add(ZhiXingShiJian_E);
		}
		
		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")){  //住院号
			tj2 = "YFMInbankA.OPNum = ?";
			cs.add(ZhuYuanHao);
		}
		if (ZhuangTai_CFTuiYao != null && !ZhuangTai_CFTuiYao.equals("")){ //处方状态
			if (tj2.equals("")) 
				tj2 = " YFMInbankA.InbankStatus = ?";
			else
				tj2 = tj2 + " and YFMInbankA.InbankStatus = ?"; 
			cs.add(ZhuangTai_CFTuiYao);
		}
		if (ZhiXingShiJian_B != null && !ZhiXingShiJian_B.equals("")){ //处方执行时间
			if (tj2.equals("")) 
				tj2 = " YFMInbankA.InbankTime >= ? and YFMInbankA.InbankTime <= ?";
			else
				tj2 = tj2 + " and YFMInbankA.InbankTime >= ? and YFMInbankA.InbankTime <= ?"; 
			cs.add(ZhiXingShiJian_B);
			cs.add(ZhiXingShiJian_E);
		}
		
		
		if (tj != null && !tj.equals("")){
			query = this.getSession().createSQLQuery("select * from (" +
					                                 "   select " +
					                                 "      CZDispose.EXecuteTime as sj, " + //0执行时间
					                                 "      CZDisposeItemDescribe.ItemName as mc, " + //1项目名称
					                                 "      1 as sl, " + //2数量
					                                 "      CZDisposeItemDescribe.Cost as dj, " + //3单价
					                                 "      CZDisposeItemDescribe.Cost as je, " + //4金额
					                                 "      CZDispose.AU as kcks, " + //5开出科室
					                                 "      CZDispose.AProposer as kcys " + //6开出医生
					                                 "   from " +
					                                 "      CZDispose, CZDisposeItemDescribe " +
					                                 "   where " +
					                                 "      CZDispose.ItemTypeID = CZDisposeItemDescribe.ItemTypeID and " + tj +
					                                 " union " +
					                                 "   select " +
					                                 "      YFMExbankA.ExbankTime as sj, " +
					                                 "      YFMInfo.MName as mc, YFExbankAItem.Num as sl, " +
					                                 "      YFExbankAItem.Price as dj, " +
					                                 "      (YFExbankAItem.PReceivable-YFExbankAItem.ReduceMoney) as je, " +
					                                 "      YFMExbankA.AU as kcks, " +
					                                 "      YFMExbankA.Establish as kcys " +
					                                 "   from " +
					                                 "      YFMExbankA,YFExbankAItem,YFMInfo " +
					                                 "   where " +
					                                 "      YFMExbankA.AFormID = YFExbankAItem.AFormID and " +
					                                 "      YFExbankAItem.MID = YFMInfo.MInfoID and " + tj1 +
					                                 " union " +
					                                 "   select " +
					                                 "      YFMInbankA.InbankTime as sj, " +
					                                 "      YFMInfo.MName as mc, " +
					                                 "      '-' + cast(YFInbankAItem.Num AS varchar(10)) as sl, " +
					                                 "      YFPrice.ExbankP as dj, " +
					                                 "      '-' + cast((YFInbankAItem.Num * YFPrice.ExbankP) as varchar(10)) as je, " +
					                                 "      YFMInbankA.Note as kcks, " +
					                                 "      YFMInbankA.Establish as kcys " +
					                                 "   from " +
					                                 "      YFMInbankA, YFInbankAItem, YFMInfo, YFPrice " +
					                                 "   where " +
					                                 "      YFMInbankA.AFormID = YFInbankAItem.ApproveFormID and " +
					                                 "      YFInbankAItem.MID = YFMInfo.MInfoID and " +
					                                 "      YFPrice.MInfoID = YFInbankAItem.MID and " +
					                                 "      YFPrice.ExbankType = '住院领药' and " + tj2 +					                                 
					                                 ") t order by sj");
			for(int i=0;i<cs.size();i++){
		    	query.setParameter(i, cs.get(i));
			}	
		}
		else{	
			query = this.getSession().createSQLQuery("");
		}
		query.list();
		return listObject2StringString(query.list());
	}

	public boolean delZYDoctorAdvice(String DAID){
		Query query = null;
		query = this.getSession().createSQLQuery(
				"delete from ZYDoctorAdvice where DAID = ?");
		query.setParameter(0, DAID);
		query.executeUpdate();
		return true;
	}

	public List<ZydoctorAdvice> getZydoctorAdvice(String DAID){
		List<ZydoctorAdvice> list = this.getHibernateTemplate().find("from ZydoctorAdvice where daid = ?",DAID);
		return list;
	}
	
}
