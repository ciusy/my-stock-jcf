package leo.zy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.Zybed;
import leo.zy.dao.iface.ZybedDao;

public class ZybedDaoImpl extends DaoSupport<Zybed> implements ZybedDao {

	public String[][] getChuangWei(Integer ChuangWeiHao, String ZhuangTai, String NanVu, Integer ZhuYuanBu){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;
		
		if (ChuangWeiHao != -2){
			tj = "Bed = ?"; //��λ��
			cs.add(ChuangWeiHao);
		}
		if (ZhuangTai != null && !ZhuangTai.equals("")){ //״̬
			if (tj.equals("")) 
				tj = " CurrentStatus = ?";
			else
				tj = tj + " and CurrentStatus = ?"; 
			cs.add(ZhuangTai);
		}
		if (NanVu != null && !NanVu.equals("")){//��Ů��λ
			if (tj.equals("")) 
				tj = " Sex = ?";
			else
				tj = tj + " and Sex = ?"; 
			cs.add(NanVu);
		}
		if (ZhuYuanBu != -2){ //סԺ��
			if (tj.equals("")) 
				tj = " IPDeptID = ?";
			else
				tj = tj + " and IPDeptID = ?"; 
			cs.add(ZhuYuanBu);
		}
		
		if (tj != null && !tj.equals("")){
			query = this.getSession().createSQLQuery("select " +
					 								 "   bed, " + //��λ�� 0
					 								 "   (select UName from OSUForm where UID = zybed.IPDeptID) as zyb, " + //סԺ�� 1
					 								 "   CurrentStatus, " + //��ǰ״̬ 2
					 								 "   BedCharge, " + //��λ�� 3
					 								 "   AttendingDoctor, " + //����ҽʦID 4
					 								 "   NurseInCharge, " + //���λ�ʿID 5
					 								 "   SeniorDoctor, " + //����ҽʦID 6
					 								 "   Sex, " + //��Ů��λ 7
					 								 "   (select SName from OSStuff where SID = zybed.AttendingDoctor) as zzys, " + //����ҽʦ���� 8
					 								 "   (select SName from OSStuff where SID = zybed.NurseInCharge) as zrhs, " + //���λ�ʿ���� 9
					 								 "   (select SName from OSStuff where SID = zybed.SeniorDoctor) as zrys, " + //����ҽʦ���� 10
					 								 "   IPDeptID as zybid, " + //סԺ��ID 11
					 								 "   id " +//��λID 12
													 "from ZYBed where " + tj + " order by IPDeptID, bed");
			for(int i=0;i<cs.size();i++){
		    	query.setParameter(i, cs.get(i));
			}	
		}
		else{	
			query = this.getSession().createSQLQuery("select " +
													 "   bed, " +
													 "   (select UName from OSUForm where UID = zybed.IPDeptID) as zyb, " +
													 "   CurrentStatus, " +
													 "   BedCharge, " +
													 "   AttendingDoctor, " +
													 "   NurseInCharge, " +
													 "   SeniorDoctor, " +
													 "   Sex, " +
													 "   (select SName from OSStuff where SID = zybed.AttendingDoctor) as zzys, " +
													 "   (select SName from OSStuff where SID = zybed.NurseInCharge) as zrhs, " +
													 "   (select SName from OSStuff where SID = zybed.SeniorDoctor) as zrys, " +
													 "   IPDeptID as zybid, " +
					 								 "   id " +//��λID
													 "from ZYBed  order by IPDeptID, bed");
		}
		query.list();
		return listObject2StringString(query.list());
	}
	
	public boolean addChuangWei(List<Zybed> ChuangWei){
		for (int i = 0; i < ChuangWei.size(); i++) {
			this.getHibernateTemplate().save(ChuangWei.get(i));
		}
		return true;
	}
	
	public boolean delChuagnWei(Integer ID){
		Query query = null;
		query = this.getSession().createSQLQuery(
				"delete from ZYBed where ID = ?");
		query.setParameter(0, ID);
		query.executeUpdate();
		return true;
	}
	
	public boolean updateChuangWeiZhuangTai(Integer ChuangWeiHao, String ZhuangTai, Integer ZhuYuanBu){
		Query query = null;
		query = this.getSession().createSQLQuery(
				"update ZYBed set CurrentStatus = ? where Bed = ? and IPDeptID = ?");
		query.setParameter(0, ZhuangTai);
		query.setParameter(1, ChuangWeiHao);
		query.setParameter(2, ZhuYuanBu);
		query.executeUpdate();
		return true;
	}
}
