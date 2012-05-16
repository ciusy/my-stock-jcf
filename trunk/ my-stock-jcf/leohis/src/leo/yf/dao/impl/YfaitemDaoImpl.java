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
	       aformid ���뵥��
	       date_b, ���뿪ʼ����
	       date_e, �����������
	       pid, ҩ������id
	       InbankStatus ״̬
		 */
		List<Object> list = new ArrayList<Object>();
		String tj;
		tj = "";
		Query query = null; // ����һ����ѯ����
		
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
		return listObject2StringString(query.list()); // ִ��SQL���(�����ؽ��query.list()ǿ��ת��ΪList<Object[]>����)
	}
	/**
	 * �������뵥��Ų�ѯ������
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
