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
 * @version ����ʱ�䣺Aug 18, 2011 3:13:37 PM
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
		Query query = null; // ����һ����ѯ����
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
		
		if (IPID != null && !IPID.equals("")){  //סԺ��
			tj = "ZYDoctorAdvice.IPID = ?";
			cs.add(IPID);
		}
		if (DAState != null && !DAState.equals("")){ //ҽ��״̬
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
		if (IPDeptID != -2){ //סԺ��ID
			if (tj.equals("")) 
				tj = " ZYDoctorAdvice.IPDeptID = ?";
			else
				tj = tj + " and ZYDoctorAdvice.IPDeptID = ?"; 
			cs.add(IPDeptID);
		}
		if (RiQi_B != null && !RiQi_B.equals("")){ //����ʱ��
			if (tj.equals("")) 
				tj = " ZYDoctorAdvice.CreateTime >= ? and ZYDoctorAdvice.CreateTime <= ?";
			else
				tj = tj + " and ZYDoctorAdvice.CreateTime >= ? and ZYDoctorAdvice.CreateTime <= ?"; 
			cs.add(RiQi_B);
			cs.add(RiQi_E);
		}
		
		if (tj != null && !tj.equals("")){
			query = this.getSession().createSQLQuery("select " +
					                                 "  ZYIPMedicine.PharmacyUID," + //0ȡҩ����ID
					                                 "  YFMInfo.MName, " + //1ҩƷ���� 
					                                 "  YFMInfo.MSpec, " + //2���
					                                 "  ZYIPMedicine.Cost, " + //3����
					                                 "  YFMInfo.PharmacyUnit, " + //4��λ
					                                 "  YFMInfo.MDosage, " + //5����
					                                 "  YFMInfo.WayTo, " + //6��ҩ��ʽ
					                                 "  ZYIPMedicine.Usage, " + //7�÷�
					                                 "  ZYIPMedicine.Num, " + //8����
					                                 "  ZYIPMedicine.MInfoID, " + //9ҩƷID
					                                 "  ZYIPMedicine.DAID, " + //10ҽ��ID
					                                 "  ZYDoctorAdvice.CreateDoctor, " + //11 ����ҽ��
					                                 "  ZYDoctorAdvice.DAState, " + //12״̬
					                                 "  ZYDoctorAdvice.AFormID, "+ //13���ⵥID
					                                 "  ZYIPMedicine.DAItemID " + //14ҽ����ID
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
                    								 "  ZYIPMedicine.PharmacyUID," + //0ȡҩ����ID
                    								 "  YFMInfo.MName, " + //1ҩƷ���� 
                    								 "  YFMInfo.MSpec, " + //2���
                    								 "  ZYIPMedicine.Cost, " + //3����
                    								 "  YFMInfo.PharmacyUnit, " + //4��λ
                    								 "  YFMInfo.MDosage, " + //5����
                    								 "  YFMInfo.WayTo, " + //6��ҩ��ʽ
                    								 "  ZYIPMedicine.Usage, " + //7�÷�
                    								 "  ZYIPMedicine.Num, " + //8����
                    								 "  ZYIPMedicine.MInfoID, " + //9ҩƷID
                    								 "  ZYIPMedicine.DAID, " + //10ҽ��ID
					                                 "  ZYDoctorAdvice.CreateDoctor " + //11 ����ҽ��
					                                 "  ZYDoctorAdvice.DAState, " + //12״̬
					                                 "  ZYDoctorAdvice.AFormID "+ //13���ⵥID
					                                 "  ZYIPMedicine.DAItemID " + //14ҽ����ID
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
		
		if (IPID != null && !IPID.equals("")){  //סԺ��
			tj = "ZYDoctorAdvice.IPID = ?";
			cs.add(IPID);
		}
		if (DAState != null && !DAState.equals("")){ //ҽ��״̬
			if (tj.equals("")) 
				tj = " ZYDoctorAdvice.DAState = ?";
			else
				tj = tj + " and ZYDoctorAdvice.DAState = ?"; 
			cs.add(DAState);
		}
		if (IPDeptID != -2){ //סԺ��ID
			if (tj.equals("")) 
				tj = " ZYDoctorAdvice.IPDeptID = ?";
			else
				tj = tj + " and ZYDoctorAdvice.IPDeptID = ?"; 
			cs.add(IPDeptID);
		}
		if (RiQi_E != null && !RiQi_E.equals("")){ //��������
			if (tj.equals("")) 
				tj = " ZYDoctorAdvice.CreateTime >= ? and ZYDoctorAdvice.CreateTime <= ?";
			else
				tj = tj + " and ZYDoctorAdvice.CreateTime >= ? and ZYDoctorAdvice.CreateTime <= ?"; 
			cs.add(RiQi_B);
			cs.add(RiQi_E);
		}
		if (State != null  && !State.equals("")){ //����״̬
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
			//selecttj = "   'δ���ѿ�ִ��' as Status, ";
			selecttj = "isnull((select Status from CZDispose where ItemID = ZYIPTeatment.ItemID),'δ���ѿ�ִ��') as Status, ";
		}
		
		if (tj != null && !tj.equals("")){
			query = this.getSession().createSQLQuery("select " +
					                                 "   CZDisposeItemDescribe.ItemName," + // 0����
					                                 "   CZDisposeItemDescribe.Cost," + // 1����
					                                 "   ZYIPTeatment.ExecuteU," + // 2ִ�п���ID
					                                 "   ZYIPTeatment.ItemTypeID," + // 3��Ŀ����ID
					                                 "   ZYIPTeatment.DAID," + // 4ҽ��ID
					                                 "   ZYDoctorAdvice.CreateDoctor, " + //5����ҽ��
					                                 "   ZYIPTeatment.DAItemID, " + //6ҽ����ID
					                                 "   ZYDoctorAdvice.DAID, " + //7ҽ��ID
					                                 selecttj + //8����״̬
					                                 "   ZYDoctorAdvice.DAState, " + //9ҽ��״̬
					                                 "   ZYIPTeatment.ItemID, " + //10������ID
					                                 "   ZYIPTeatment.AContent " + //11���뵥����
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
                                                     "   CZDisposeItemDescribe.ItemName," + // ����
                                                     "   CZDisposeItemDescribe.Cost," + //����
                                                     "   ZYIPTeatment.ExecuteU," + //ִ�п���ID
                                                     "   ZYIPTeatment.ItemTypeID," + //��Ŀ����ID
					                                 "  ZYIPTeatment.DAID," + // 4ҽ��ID
					                                 "  ZYDoctorAdvice.CreateDoctor, " + //5����ҽ��
					                                 "   ZYIPTeatment.DAItemID, " + //6ҽ����ID
					                                 "   ZYDoctorAdvice.DAID, " + //7ҽ��ID
					                                 selecttj + //8����״̬
					                                 "   ZYDoctorAdvice.DAState, " + //9ҽ��״̬
					                                 "   ZYIPTeatment.ItemID, " + //10������ID
					                                 "   ZYIPTeatment.AContent " + //11���뵥����
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
		
		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")){  //סԺ��
			tj = "CZDispose.kindid = ?";
			cs.add(ZhuYuanHao);
		}
		if (ZhuanTai_CZ != null && !ZhuanTai_CZ.equals("")){ //����״̬
			if (tj.equals("")) 
				tj = " CZDispose.Status = ?";
			else
				tj = tj + " and CZDispose.Status = ?"; 
			cs.add(ZhuanTai_CZ);
		}
		if (ZhiXingShiJian_B != null && !ZhiXingShiJian_B.equals("")){ //����ִ��ʱ��
			if (tj.equals("")) 
				tj = " CZDispose.EXecuteTime >= ? and CZDispose.EXecuteTime <= ?";
			else
				tj = tj + " and CZDispose.EXecuteTime >= ? and CZDispose.EXecuteTime <= ?"; 
			cs.add(ZhiXingShiJian_B);
			cs.add(ZhiXingShiJian_E);
		}
		
		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")){  //סԺ��
			tj1 = "YFMExbankA.OPNum = ?";
			cs.add(ZhuYuanHao);
		}
		if (ZhuangTai_CFFaYao != null && !ZhuangTai_CFFaYao.equals("")){ //����״̬
			if (tj1.equals("")) 
				tj1 = " YFMExbankA.ExbankStatus = ?";
			else
				tj1 = tj1 + " and YFMExbankA.ExbankStatus = ?"; 
			cs.add(ZhuangTai_CFFaYao);
		}
		if (ZhiXingShiJian_B != null && !ZhiXingShiJian_B.equals("")){ //����ִ��ʱ��
			if (tj1.equals("")) 
				tj1 = " YFMExbankA.ExbankTime >= ? and YFMExbankA.ExbankTime <= ?";
			else
				tj1 = tj1 + " and YFMExbankA.ExbankTime >= ? and YFMExbankA.ExbankTime <= ?"; 
			cs.add(ZhiXingShiJian_B);
			cs.add(ZhiXingShiJian_E);
		}
		
		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")){  //סԺ��
			tj2 = "YFMInbankA.OPNum = ?";
			cs.add(ZhuYuanHao);
		}
		if (ZhuangTai_CFTuiYao != null && !ZhuangTai_CFTuiYao.equals("")){ //����״̬
			if (tj2.equals("")) 
				tj2 = " YFMInbankA.InbankStatus = ?";
			else
				tj2 = tj2 + " and YFMInbankA.InbankStatus = ?"; 
			cs.add(ZhuangTai_CFTuiYao);
		}
		if (ZhiXingShiJian_B != null && !ZhiXingShiJian_B.equals("")){ //����ִ��ʱ��
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
					                                 "      CZDispose.EXecuteTime as sj, " + //0ִ��ʱ��
					                                 "      CZDisposeItemDescribe.ItemName as mc, " + //1��Ŀ����
					                                 "      1 as sl, " + //2����
					                                 "      CZDisposeItemDescribe.Cost as dj, " + //3����
					                                 "      CZDisposeItemDescribe.Cost as je, " + //4���
					                                 "      CZDispose.AU as kcks, " + //5��������
					                                 "      CZDispose.AProposer as kcys " + //6����ҽ��
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
					                                 "      YFPrice.ExbankType = 'סԺ��ҩ' and " + tj2 +					                                 
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
