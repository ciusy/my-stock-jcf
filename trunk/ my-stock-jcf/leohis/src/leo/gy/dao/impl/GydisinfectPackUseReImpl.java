package leo.gy.dao.impl;

//import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.common.util.DateUtil;
import leo.entity.GydisinfectPackUseRe;
import leo.gy.dao.iface.GydisinfectPackUseReDao;


import org.hibernate.Query;
import java.util.Date;


public class GydisinfectPackUseReImpl extends DaoSupport<GydisinfectPackUseRe>
		implements GydisinfectPackUseReDao {
	
	private static final StringBuilder StringBuilder = null;
	/**使用明细
	 * 
	 * @param StartDate 开始时间
	 * @param CutOffDate 截止时间
	 * @param strUnit	领用科室
	 * @param strDPN	无菌包类型
	 * @return
	 */
	public List<GydisinfectPackUseRe> GetUseRe(String StartDate,String CutOffDate,String strUnit,String strDPN){
		Date ds;              //开始时间
		Date dco;			  //截至时间
		int intDisinfectID;		//无菌包ID
		int intUint;		//预约科室		
		
		ds = DateUtil.stringToDate(StartDate);
		dco = DateUtil.stringToDate(CutOffDate);
		if(StartDate != "")
		{
			if(strUnit == "" && strDPN == "")
			{
				try{
					Query query =this.getSession().createQuery(" from GydisinfectPackUseRe gysl where " +
							"gysl.drawTime =:DDS and gysl.returnTime =:DDCO");				
					query.setTimestamp("DDS", ds);//UIid	
					query.setTimestamp("DDCO", dco);
					List<GydisinfectPackUseRe> list=query.list();
					return list;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return null;
			}
			if(strUnit == "" && strDPN != "")
			{
				intDisinfectID = Integer.parseInt(strDPN);
				try{
					Query query =this.getSession().createQuery(" from GydisinfectPackUseRe gysl where " +
							"gysl.drawTime =:DDS and gysl.returnTime =:DDCO " +
							"and gysl.disinfectPackId =:Deid");
					query.setTimestamp("DDS", ds);//UIid	
					query.setTimestamp("DDCO", dco);
					query.setInteger("Deid", intDisinfectID);
					List<GydisinfectPackUseRe> list=query.list();
					return list;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return null;
			}		
			if(strUnit != "" && strDPN == "")
			{
				intUint = Integer.parseInt(strUnit);
				try{
					Query query =this.getSession().createQuery(" from GydisinfectPackUseRe gysl where " +
							"gysl.drawTime =:DDS and gysl.returnTime =:DDCO " +
					"and gysl.useU =:UUid");
					query.setTimestamp("DDS", ds);//UIid	
					query.setTimestamp("DDCO", dco);
					query.setInteger("UUid", intUint);
					List<GydisinfectPackUseRe> list=query.list();
					return list;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return null;
			}
			if(strUnit != "" && strDPN != "")
			{
				intUint = Integer.parseInt(strUnit);
				intDisinfectID = Integer.parseInt(strDPN);
				try{
					
					//Uid 领用科室ID    UBespeak
					//Did 无菌包类型ID  DisinfectID
					//UIid 所属科室供应室   UDisinfectPackIn  int
					Query query =this.getSession().createQuery(" from GydisinfectPackUseRe gysl where " +
							"gysl.drawTime =:DDS and gysl.returnTime =:DDCO " +
					"and gysl.useU =:UUid and gysl.disinfectPackId =:Deid");	
					query.setTimestamp("DDS", ds);//UIid	
					query.setTimestamp("DDCO", dco);
					query.setInteger("Deid", intDisinfectID);
					query.setInteger("UUid", intUint);
					List<GydisinfectPackUseRe> list=query.list();
					return list;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return null;
			}
			return null;
		}
		if(StartDate == "")
		{
			if(strUnit == "" && strDPN == "")
			{
				try{
					Query query =this.getSession().createQuery(" from GydisinfectPackUseRe gysl ");				
					List<GydisinfectPackUseRe> list=query.list();
					return list;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return null;
			}
			if(strUnit == "" && strDPN != "")
			{
				intDisinfectID = Integer.parseInt(strDPN);
				try{
					Query query =this.getSession().createQuery(" from GydisinfectPackUseRe gysl where " +
							"gysl.disinfectPackId =:Deid");
					query.setInteger("Deid", intDisinfectID);
					List<GydisinfectPackUseRe> list=query.list();
					return list;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return null;
			}		
			if(strUnit != "" && strDPN == "")
			{
				intUint = Integer.parseInt(strUnit);
				try{
					Query query =this.getSession().createQuery(" from GydisinfectPackUseRe gysl where " +
					"gysl.useU =:UUid");				
					query.setInteger("UUid", intUint);
					List<GydisinfectPackUseRe> list=query.list();
					return list;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return null;
			}
			if(strUnit != "" && strDPN != "")
			{
				intUint = Integer.parseInt(strUnit);
				intDisinfectID = Integer.parseInt(strDPN);
				try{
					
					//Uid 领用科室ID    UBespeak
					//Did 无菌包类型ID  DisinfectID
					//UIid 所属科室供应室   UDisinfectPackIn  int
					Query query =this.getSession().createQuery(" from GydisinfectPackUseRe gysl where " +
					"gysl.useU =:UUid and gysl.disinfectPackId =:Deid");				
					query.setInteger("Deid", intDisinfectID);
					query.setInteger("UUid", intUint);
					List<GydisinfectPackUseRe> list=query.list();
					return list;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return null;
			}
		}
		return null;
	}
	
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit() {
		try {
			Query query = this.getSession().createQuery(
					"from GydisinfectPackUseRe"); // 并且归还时间为空 ，领用时间不为空。
			List<GydisinfectPackUseRe> list = query.list();
			//判断归还时间为空 ，领用时间不为空。
			if(list.size() > 0)
			{
				for (int i = 0; i < list.size(); i++) {
					GydisinfectPackUseRe g = list.get(i);
					if(g.getDrawTime() != null && g.getReturnTime() != null){
						list.remove(i);
					}						
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit) {

		try {
			Query query = this.getSession().createQuery(
					"from GydisinfectPackUseRe where UseU = Unit"); // 并且归还时间为空，领用时间不为空。
			List<GydisinfectPackUseRe> list = query.list();
			//判断归还时间为空 ，领用时间不为空。
			if(list.size() > 0)
			{
				for (int i = 0; i < list.size(); i++) {
					GydisinfectPackUseRe g = list.get(i);
					if(g.getDrawTime() != null && g.getReturnTime() != null){
						list.remove(i);
					}						
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(String DPN) {
		try {
			Query query = this
					.getSession()
					.createQuery(
							"select g from GydisinfectPackUseRe g ,GysupplyDisinfectPackInfo g1  "
									+ "where g1.disinfectId = g.disinfectPackId "
									+ "and g1.disinfectId = :DPN1"); // 并且归还时间为空
			// ，领用时间不为空。
			List<GydisinfectPackUseRe> list = query.list();
			//判断归还时间为空 ，领用时间不为空。
			if(list.size() > 0)
			{
				for (int i = 0; i < list.size(); i++) {
					GydisinfectPackUseRe g = list.get(i);
					if(g.getDrawTime() != null && g.getReturnTime() != null){
						list.remove(i);
					}						
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit,
			String DPN) {
		// public String[][] getAllGydisinfectPackInfo(int Unit,String DPN){
		try {
			Query query = this
					.getSession()
					.createQuery(
							"select g from GydisinfectPackUseRe g ,GysupplyDisinfectPackInfo g1 "
									+ "where g.useU = :Unit1 and g1.disinfectId = g.disinfectPackId "
									+ "and g1.disinfectId = :DPN1 "); // 并且归还时间为空
			// ，领用时间不为空。
			query.setInteger("Unit1", Unit);
			query.setString("DPN1", DPN);
			List<GydisinfectPackUseRe> list = (List<GydisinfectPackUseRe>) query
					.list();
			//判断归还时间为空 ，领用时间不为空。
			if(list.size() > 0)
			{
				for (int i = 0; i < list.size(); i++) {
					GydisinfectPackUseRe g = list.get(i);
					if(g.getDrawTime() != null && g.getReturnTime() != null){
						list.remove(i);
					}						
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

		// try {
		// Query query = this.getSession().createSQLQuery(
		// "select g.* from GydisinfectPackUseRe g ,GysupplyDisinfectPackInfo g1 "
		// +
		// "where g.useU = :Unit1 and g1.disinfectId = g.disinfectPackId " +
		// "and g1.disinfectId = :DPN1 "); //并且归还时间为空 ，领用时间不为空。
		// query.setInteger("Unit1", Unit);
		// query.setString("DPN1", DPN);
		// return listObject2StringString(query.list());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}
	
	//查看本科室领用无菌包
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(){
		try {
			//Query query = this.getSession().createQuery(
				//	"select g from GydisinfectPackUseRe g ,GydisinfectPackInstance g1 "
				//			+ "where g1.disinfectPackId = g.disinfectPackId "); // 并且归还时间为空
			Query query = this.getSession().createQuery(
					"from GydisinfectPackUseRe"); //无菌包状态为// 并且归还时间为空 ，领用时间不为空。
			List<GydisinfectPackUseRe> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(int Unit){
		try {
			Query query = this.getSession().createQuery(
				"from GydisinfectPackUseRe where UseU = Unit");
					//"from GydisinfectPackUseRe where UseU = Unit"); // 并且归还时间为空
			// ，领用时间不为空。
			List<GydisinfectPackUseRe> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(String DPN){
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from GydisinfectPackUseRe ,GYSupplyDisinfectPackInfo "
									+ "where GYSupplyDisinfectPackInfo.DisinfectID = GydisinfectPackUseRe.DisinfectPackID "
									+ "and GYSupplyDisinfectPackInfo.DisinfectID = DPN"); // 并且归还时间为空
			// ，领用时间不为空。
			List<GydisinfectPackUseRe> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(int Unit,String DPN){
		try {
			Query query = this
					.getSession()
					.createQuery(
							"select g from GydisinfectPackUseRe g ,GysupplyDisinfectPackInfo g1 "
									+ "where g.useU = :Unit1 and g1.disinfectId = g.disinfectPackId "
									+ "and g1.disinfectId = :DPN1 "); // 并且归还时间为空
			// ，领用时间不为空。
			query.setInteger("Unit1", Unit);
			query.setString("DPN1", DPN);
			List<GydisinfectPackUseRe> list = (List<GydisinfectPackUseRe>) query
					.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//根据无菌包ID查询出来使用记录，并把归还时间填上
	public boolean ModifyGydisinfectPackBackTime(int id){
		try{
			long lid = (long)id;
			GydisinfectPackUseRe g = (GydisinfectPackUseRe) this
			.find(lid);
			g.setReturnOrNot(true);		//更正状态为归还状态ture
			g.setReturnTime(DateUtil.getNowTimeStamp());	//归还时间为当前时间
			this.getHibernateTemplate().update(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return true;
	}
	
	//向消毒包使用记录表里插入一条数据
	public boolean addGydisinfectPackUseReInfo(GydisinfectPackUseRe g){
		try {
			this.getHibernateTemplate().save(g);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//无菌包归还方法用于无菌包归还页面，根据无菌包Id，科室id到使用记录表里查状态为没归还的（false），
	public boolean BackGydisinfectPack(int id,int u) {
		try {
			boolean b = false;   //并且是未归还returnOrNot为false
			Query query = this.getSession().createQuery(
			"from GydisinfectPackUseRe g where g.disinfectPackId =:Did and g.useU =:Unit " +
			"and g.returnOrNot =:RON"); //  并且归还时间为空 ，领用时间不为空。
			query.setInteger("Did", id);
			query.setInteger("Unit", u);	
			query.setBoolean("RON", b);
			List<GydisinfectPackUseRe> list = query.list();
			//判断归还时间为空 ，领用时间不为空。
			if(list.size() > 0)
			{
				for (int i = 0; i < list.size(); i++) {
					GydisinfectPackUseRe g = list.get(i);
					if(g.getDrawTime() != null && g.getReturnTime() == null){
						return this.ModifyGydisinfectPackBackTime(g.getUseId().intValue());
					}						
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public Long getUidByDpid(int dpid)
	{
		Query query=this.getSession()
		.createQuery("from GydisinfectPackUseRe gy where gy.disinfectPackId =? and gy.useU=?");
		query.setParameter(0, dpid);
		query.setParameter(1, -1);
		List<GydisinfectPackUseRe> list=query.list();
		if(list.size()>0)
			return list.get(0).getUseId();
		return -1L;
	}
	public boolean deleteUseInfo(Long UseId)
	{
		GydisinfectPackUseRe gy =(GydisinfectPackUseRe)this.getHibernateTemplate().get(GydisinfectPackUseRe.class, UseId);
		this.getHibernateTemplate().delete(gy);
		return true;
	}
	public boolean setDtByDpidandDt(int Dpid,int Uid,double amount)
	{
		String st="1900-1-1 0:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp ts=Timestamp.valueOf(st);
		Query query=this.getSession()
		.createQuery("from GydisinfectPackUseRe  gy where gy.disinfectPackId=? and gy.drawTime=? ");
		query.setParameter(0, Dpid);
		query.setParameter(0, ts);
		List <GydisinfectPackUseRe>list =query.list();
		System.out.print(list.get(0));
		if(list.size()>0)
		{
			list.get(0).setDrawTime(DateUtil.getNowTimeStamp());
			list.get(0).setUseU(Uid);
			list.get(0).setReturnOrNot(false);
			list.get(0).setAmount(amount);
			return true;
		}
		return false;	
	}
	public boolean setghByDpidandRt(int Dpid)
	{
		Query query=this.getSession()
		.createQuery("from GydisinfectPackUseRe gy where gy.disinfectPackId=? and gy.returnOrNot=? ");
		query.setParameter(0, Dpid);
		query.setParameter(1, false);
		List<GydisinfectPackUseRe> list=query.list();
		if(list.size()>0)
		{
			list.get(0).setReturnOrNot(true);
			list.get(0).setReturnTime(DateUtil.getNowTimeStamp());
			return true;
		}
		return false;
	}
	public List<GydisinfectPackUseRe> getmxByDtandRtandUidandDid(String Dt,String Rt,int Uid,int Did)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		StringBuilder sb= new StringBuilder();
		sb.append("select gyu from GydisinfectPackUseRe gyu ,GydisinfectPackInstance gyi  where gyu.disinfectPackId=gyi.disinfectPackId ");
		List<Object> list= new ArrayList<Object>();
		Query query=null;
		if(!Dt.equals("") && null!=Dt)
		{
			sb.append(" and gyu.drawTime >=? ");
			Timestamp tsDt=Timestamp.valueOf(Dt);
			list.add(tsDt);
		}
		if(!Rt.equals("") && null !=Rt)
		{
			sb.append(" and gyu.returnTime <=? ");
			Timestamp tsRt=Timestamp.valueOf(Rt);
			list.add(tsRt);
		}
		if(-2!=Uid)
		{
			sb.append(" and gyu.useU = ? ");
			list.add(Uid);
		}
		if(-2 !=Did)
		{
			sb.append(" and gyi.disinfectId=? ");
			list.add(Did);
		}
		query=this.getSession().createQuery(sb.toString());
		for(int i=0;i<list.size();i++)
		{
			query.setParameter(i, list.get(i));
		}
		System.out.print(query.list().size());
		return query.list();
	}

}
