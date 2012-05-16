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
			tj = "Bed = ?"; //床位号
			cs.add(ChuangWeiHao);
		}
		if (ZhuangTai != null && !ZhuangTai.equals("")){ //状态
			if (tj.equals("")) 
				tj = " CurrentStatus = ?";
			else
				tj = tj + " and CurrentStatus = ?"; 
			cs.add(ZhuangTai);
		}
		if (NanVu != null && !NanVu.equals("")){//男女床位
			if (tj.equals("")) 
				tj = " Sex = ?";
			else
				tj = tj + " and Sex = ?"; 
			cs.add(NanVu);
		}
		if (ZhuYuanBu != -2){ //住院部
			if (tj.equals("")) 
				tj = " IPDeptID = ?";
			else
				tj = tj + " and IPDeptID = ?"; 
			cs.add(ZhuYuanBu);
		}
		
		if (tj != null && !tj.equals("")){
			query = this.getSession().createSQLQuery("select " +
					 								 "   bed, " + //床位号 0
					 								 "   (select UName from OSUForm where UID = zybed.IPDeptID) as zyb, " + //住院部 1
					 								 "   CurrentStatus, " + //当前状态 2
					 								 "   BedCharge, " + //床位费 3
					 								 "   AttendingDoctor, " + //主治医师ID 4
					 								 "   NurseInCharge, " + //责任护士ID 5
					 								 "   SeniorDoctor, " + //主任医师ID 6
					 								 "   Sex, " + //男女床位 7
					 								 "   (select SName from OSStuff where SID = zybed.AttendingDoctor) as zzys, " + //主治医师姓名 8
					 								 "   (select SName from OSStuff where SID = zybed.NurseInCharge) as zrhs, " + //责任护士姓名 9
					 								 "   (select SName from OSStuff where SID = zybed.SeniorDoctor) as zrys, " + //主任医师姓名 10
					 								 "   IPDeptID as zybid, " + //住院部ID 11
					 								 "   id " +//床位ID 12
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
					 								 "   id " +//床位ID
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
