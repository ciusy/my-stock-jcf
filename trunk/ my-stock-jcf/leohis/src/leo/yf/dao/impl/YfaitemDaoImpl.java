package leo.yf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.Yfaitem;
import leo.entity.Yfmtype;
import leo.yf.dao.iface.YfaitemDao;

import org.hibernate.Query;

public class YfaitemDaoImpl extends DaoSupport<Yfaitem> implements YfaitemDao {

	public boolean addYfaitem(Yfaitem yfaitem) {
		try{
			this.getHibernateTemplate().save(yfaitem);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public String[][] getCaiGouBiaoTao(String aformid, String date_b, String date_e,Integer pid,String InbankStatus){
		/*
	       aformid 申请单号
	       date_b, 申请开始日期
	       date_e, 申请结束日期
	       pid, 药房科室id
	       InbankStatus 状态
		 */
		List<Object> list = new ArrayList<Object>();
		String tj;
		tj = "";
		Query query = null; // 生明一个查询对象
		
		if (!aformid.equals("") && aformid != null){
			tj = " and YFMInbankA.aformid = ?";
			list.add(aformid);
		}
		if (!date_b.equals("") && date_b != null){
			if (tj.equals("")) 
				tj = " and YFMInbankA.ATime >= ? and YFMInbankA.ATime <= ?";
			else
				tj = tj + " and YFMInbankA.ATime >= ? and YFMInbankA.ATime <= ?";
			list.add(date_b);
			list.add(date_e);
		}
		if (pid != -2){
			if (tj.equals("")) 
				tj = " and YFMInbankA.PharmacyID = ?";
			else
				tj = tj + " and  YFMInbankA.PharmacyID = ?";
			list.add(pid);
		}

		if (InbankStatus != null && !InbankStatus.equals("")){
			if (tj.equals("")) 
				tj = " and YFMInbankA.InbankStatus = ?";
			else
				tj = tj + " and  YFMInbankA.InbankStatus = ?";
			list.add(InbankStatus);
		}
	    query = this.getSession().createSQLQuery("select YFMInbankA.AFormID,YFMInbankA.InbankTypeID,YFMInbankA.AObject," +
	    		                                         "YFMInbankA.ATime,YFMInbankA.ApproveTime,YFMInbankA.InbankStatus," +
	    		                                         "YFMInbankA.InbankTime,YFMInbankA.Note,YFMInbankA.PharmacyID " +
   		                                         "from YFMInbankA,YFAItem " +
   		                                         "where YFMInbankA.aformid = YFAItem.aformid" + tj + " group by YFMInbankA.AFormID,YFMInbankA.InbankTypeID,YFMInbankA.AObject,YFMInbankA.ATime,YFMInbankA.ApproveTime,YFMInbankA.InbankStatus,YFMInbankA.InbankTime,YFMInbankA.Note,YFMInbankA.PharmacyID");
		
	    for(int i=0;i<list.size();i++){
	    	query.setParameter(i, list.get(i));
	    }
	    query.list();
		return listObject2StringString(query.list()); // 执行SQL语句(将返回结果query.list()强制转换为List<Object[]>类型)
	}
	/**
	 * 根据申请单编号查询申请项
	 */
	public List<Yfaitem> getYfaitem(String AFormID){
		List<Yfaitem> list = this.getHibernateTemplate().find("from Yfaitem where aformId = ?",AFormID);
		return list;
	}
	
	public boolean delYfaitem(String AFormID){
		Query query = null;
        try {
		query = this.getSession().createSQLQuery("delete from YFAItem where AFormID = ?");
		query.setParameter(0, AFormID);
		query.executeUpdate();
		return true;
        } catch (Exception e){
        	e.printStackTrace();
        }
        return false;
		
	}
}
