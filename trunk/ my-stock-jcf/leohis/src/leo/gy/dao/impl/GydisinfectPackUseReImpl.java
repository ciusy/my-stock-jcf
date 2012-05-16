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
	/**ʹ����ϸ
	 * 
	 * @param StartDate ��ʼʱ��
	 * @param CutOffDate ��ֹʱ��
	 * @param strUnit	���ÿ���
	 * @param strDPN	�޾�������
	 * @return
	 */
	public List<GydisinfectPackUseRe> GetUseRe(String StartDate,String CutOffDate,String strUnit,String strDPN){
		Date ds;              //��ʼʱ��
		Date dco;			  //����ʱ��
		int intDisinfectID;		//�޾���ID
		int intUint;		//ԤԼ����		
		
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
					
					//Uid ���ÿ���ID    UBespeak
					//Did �޾�������ID  DisinfectID
					//UIid �������ҹ�Ӧ��   UDisinfectPackIn  int
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
					
					//Uid ���ÿ���ID    UBespeak
					//Did �޾�������ID  DisinfectID
					//UIid �������ҹ�Ӧ��   UDisinfectPackIn  int
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
					"from GydisinfectPackUseRe"); // ���ҹ黹ʱ��Ϊ�� ������ʱ�䲻Ϊ�ա�
			List<GydisinfectPackUseRe> list = query.list();
			//�жϹ黹ʱ��Ϊ�� ������ʱ�䲻Ϊ�ա�
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
					"from GydisinfectPackUseRe where UseU = Unit"); // ���ҹ黹ʱ��Ϊ�գ�����ʱ�䲻Ϊ�ա�
			List<GydisinfectPackUseRe> list = query.list();
			//�жϹ黹ʱ��Ϊ�� ������ʱ�䲻Ϊ�ա�
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
									+ "and g1.disinfectId = :DPN1"); // ���ҹ黹ʱ��Ϊ��
			// ������ʱ�䲻Ϊ�ա�
			List<GydisinfectPackUseRe> list = query.list();
			//�жϹ黹ʱ��Ϊ�� ������ʱ�䲻Ϊ�ա�
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
									+ "and g1.disinfectId = :DPN1 "); // ���ҹ黹ʱ��Ϊ��
			// ������ʱ�䲻Ϊ�ա�
			query.setInteger("Unit1", Unit);
			query.setString("DPN1", DPN);
			List<GydisinfectPackUseRe> list = (List<GydisinfectPackUseRe>) query
					.list();
			//�жϹ黹ʱ��Ϊ�� ������ʱ�䲻Ϊ�ա�
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
		// "and g1.disinfectId = :DPN1 "); //���ҹ黹ʱ��Ϊ�� ������ʱ�䲻Ϊ�ա�
		// query.setInteger("Unit1", Unit);
		// query.setString("DPN1", DPN);
		// return listObject2StringString(query.list());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}
	
	//�鿴�����������޾���
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(){
		try {
			//Query query = this.getSession().createQuery(
				//	"select g from GydisinfectPackUseRe g ,GydisinfectPackInstance g1 "
				//			+ "where g1.disinfectPackId = g.disinfectPackId "); // ���ҹ黹ʱ��Ϊ��
			Query query = this.getSession().createQuery(
					"from GydisinfectPackUseRe"); //�޾���״̬Ϊ// ���ҹ黹ʱ��Ϊ�� ������ʱ�䲻Ϊ�ա�
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
					//"from GydisinfectPackUseRe where UseU = Unit"); // ���ҹ黹ʱ��Ϊ��
			// ������ʱ�䲻Ϊ�ա�
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
									+ "and GYSupplyDisinfectPackInfo.DisinfectID = DPN"); // ���ҹ黹ʱ��Ϊ��
			// ������ʱ�䲻Ϊ�ա�
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
									+ "and g1.disinfectId = :DPN1 "); // ���ҹ黹ʱ��Ϊ��
			// ������ʱ�䲻Ϊ�ա�
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
	
	//�����޾���ID��ѯ����ʹ�ü�¼�����ѹ黹ʱ������
	public boolean ModifyGydisinfectPackBackTime(int id){
		try{
			long lid = (long)id;
			GydisinfectPackUseRe g = (GydisinfectPackUseRe) this
			.find(lid);
			g.setReturnOrNot(true);		//����״̬Ϊ�黹״̬ture
			g.setReturnTime(DateUtil.getNowTimeStamp());	//�黹ʱ��Ϊ��ǰʱ��
			this.getHibernateTemplate().update(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return true;
	}
	
	//��������ʹ�ü�¼�������һ������
	public boolean addGydisinfectPackUseReInfo(GydisinfectPackUseRe g){
		try {
			this.getHibernateTemplate().save(g);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//�޾����黹���������޾����黹ҳ�棬�����޾���Id������id��ʹ�ü�¼�����״̬Ϊû�黹�ģ�false����
	public boolean BackGydisinfectPack(int id,int u) {
		try {
			boolean b = false;   //������δ�黹returnOrNotΪfalse
			Query query = this.getSession().createQuery(
			"from GydisinfectPackUseRe g where g.disinfectPackId =:Did and g.useU =:Unit " +
			"and g.returnOrNot =:RON"); //  ���ҹ黹ʱ��Ϊ�� ������ʱ�䲻Ϊ�ա�
			query.setInteger("Did", id);
			query.setInteger("Unit", u);	
			query.setBoolean("RON", b);
			List<GydisinfectPackUseRe> list = query.list();
			//�жϹ黹ʱ��Ϊ�� ������ʱ�䲻Ϊ�ա�
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
