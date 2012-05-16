package leo.dx.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.dx.dao.iface.SuccessfulSmsDao;
import leo.entity.SuccessfulSms;

public class SuccessfulSmsDaoImpl extends DaoSupport<SuccessfulSms> implements SuccessfulSmsDao {

	public  String[][] getSuccessfulSms(String ShiJian_B, String ShiJian_E, String Status, String MoKuai, Integer UnitID){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;
		
		if (ShiJian_B != null && !ShiJian_B.equals("")){ //时间
			tj = " SuccessfulSms.SendTime >= ? and SuccessfulSms.SendTime <= ?";
			cs.add(ShiJian_B);
			cs.add(ShiJian_E);
		}
		if (Status != null && !Status.equals("")){//状态
			if (tj.equals("")) 
				tj = " SuccessfulSms.Status = ?";
			else
				tj = tj + " and SuccessfulSms.Status = ?"; 
			cs.add(Status);
		}
		if (MoKuai != null && !MoKuai.equals("")){//模块编号
			if (tj.equals("")) 
				tj = " SuccessfulSms.ModuleNum = ?";
			else
				tj = tj + " and SuccessfulSms.ModuleNum = ?"; 
			cs.add(MoKuai);
		}
		if (UnitID != -2){ //单位ID
			if (tj.equals("")) 
				tj = " SuccessfulSms.UnitID = ?";
			else
				tj = tj + " and SuccessfulSms.UnitID = ?"; 
			cs.add(UnitID);
		}
		
		if (tj != null && !tj.equals("")){
			query = this.getSession().createSQLQuery("select " +
					                                 "  SuccessfulSms.SendTime, " + //0发送时间
					                                 "  SuccessfulSms.ModuleNum, " + //1调用模块编号
					                                 "  CSConsumer.CSName, " + //2目标姓名
					                                 "  SuccessfulSms.Telephone, " + //3手机
					                                 "  SuccessfulSms.Sender, " + //4发送状态
					                                 "  SuccessfulSms.MessageContend, " + //5短信内容
					                                 "  SuccessfulSms.CsId, " + //6CsID
					                                 "  SuccessfulSms.SendID, " + //7发送ID
					                                 "  SuccessfulSms.Sender, " + //8发送者
					                                 "  SuccessfulSms.id, " + //9ID
					                                 "  SuccessfulSms.UnitID " +//10单位ID
					                                 "from " +
					                                 "  SuccessfulSms,CSConsumer " +
					                                 "where " +
					                                 "  SuccessfulSms.CsId = CSConsumer.CsId and " + tj);
			for(int i=0;i<cs.size();i++){
		    	query.setParameter(i, cs.get(i));
			}	
		}
		else{	
			query = this.getSession().createSQLQuery("select " +
                    "  SuccessfulSms.SendTime, " + //0发送时间
                    "  SuccessfulSms.ModuleNum, " + //1调用模块编号
                    "  CSConsumer.CSName, " + //2目标姓名
                    "  SuccessfulSms.Telephone, " + //3手机
                    "  SuccessfulSms.Sender, " + //4发送状态
                    "  SuccessfulSms.MessageContend, " + //5短信内容
                    "  SuccessfulSms.CsId, " + //6CsID
                    "  SuccessfulSms.SendID " + //7发送ID
                    "from " +
                    "  SuccessfulSms,CSConsumer " +
                    "where " +
                    "  SuccessfulSms.CsId = CSConsumer.CsId");
		}
		query.list();
		return listObject2StringString(query.list());
	}
	
	public boolean addSuccessfulSms(SuccessfulSms JiLuNeiRong){
		this.getHibernateTemplate().save(JiLuNeiRong);
		return true;
	}

	public boolean updateSuccessfulSms(String ModuleNum, Long SendID, Integer UnitID, String SendTime, String Status, String ErrorCode){
		Query query = null;
		query = this.getSession().createSQLQuery(
				"update SuccessfulSms set SendTime = ?, Status = ?, ErrorCode = ? where ModuleNum = ? and SendID = ? and UnitID = ?");
		query.setParameter(0, SendTime);
		query.setParameter(1, Status);
		query.setParameter(2, ErrorCode);
		query.setParameter(3, ModuleNum);
		query.setParameter(4, SendID);
		query.setParameter(5, UnitID);
		query.executeUpdate();
		return true;
	}
	
}
