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
		
		if (ShiJian_B != null && !ShiJian_B.equals("")){ //ʱ��
			tj = " SuccessfulSms.SendTime >= ? and SuccessfulSms.SendTime <= ?";
			cs.add(ShiJian_B);
			cs.add(ShiJian_E);
		}
		if (Status != null && !Status.equals("")){//״̬
			if (tj.equals("")) 
				tj = " SuccessfulSms.Status = ?";
			else
				tj = tj + " and SuccessfulSms.Status = ?"; 
			cs.add(Status);
		}
		if (MoKuai != null && !MoKuai.equals("")){//ģ����
			if (tj.equals("")) 
				tj = " SuccessfulSms.ModuleNum = ?";
			else
				tj = tj + " and SuccessfulSms.ModuleNum = ?"; 
			cs.add(MoKuai);
		}
		if (UnitID != -2){ //��λID
			if (tj.equals("")) 
				tj = " SuccessfulSms.UnitID = ?";
			else
				tj = tj + " and SuccessfulSms.UnitID = ?"; 
			cs.add(UnitID);
		}
		
		if (tj != null && !tj.equals("")){
			query = this.getSession().createSQLQuery("select " +
					                                 "  SuccessfulSms.SendTime, " + //0����ʱ��
					                                 "  SuccessfulSms.ModuleNum, " + //1����ģ����
					                                 "  CSConsumer.CSName, " + //2Ŀ������
					                                 "  SuccessfulSms.Telephone, " + //3�ֻ�
					                                 "  SuccessfulSms.Sender, " + //4����״̬
					                                 "  SuccessfulSms.MessageContend, " + //5��������
					                                 "  SuccessfulSms.CsId, " + //6CsID
					                                 "  SuccessfulSms.SendID, " + //7����ID
					                                 "  SuccessfulSms.Sender, " + //8������
					                                 "  SuccessfulSms.id, " + //9ID
					                                 "  SuccessfulSms.UnitID " +//10��λID
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
                    "  SuccessfulSms.SendTime, " + //0����ʱ��
                    "  SuccessfulSms.ModuleNum, " + //1����ģ����
                    "  CSConsumer.CSName, " + //2Ŀ������
                    "  SuccessfulSms.Telephone, " + //3�ֻ�
                    "  SuccessfulSms.Sender, " + //4����״̬
                    "  SuccessfulSms.MessageContend, " + //5��������
                    "  SuccessfulSms.CsId, " + //6CsID
                    "  SuccessfulSms.SendID " + //7����ID
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
