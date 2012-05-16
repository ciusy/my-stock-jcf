package leo.gy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.GydisinfectPackInstance;
import leo.entity.GysupplyDisinfectPackInfo;
import leo.gy.dao.iface.GYDisinfectPackInstanceDAO;
import leo.gy.dao.iface.GYSupplyDisinfectPackInfoDAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GYDisinfectPackInstanceImpl extends
	DaoSupport<GydisinfectPackInstance> implements
	GYDisinfectPackInstanceDAO {
	//private static final List<Object> ArrayList = null;
	public List<GydisinfectPackInstance> getAllPackKindInstance() {
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from GydisinfectPackInstance g where g.disinfectPackStatus <> ?");
			query.setParameter(0, "�ѱ���");
			List<GydisinfectPackInstance> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addPackInstance(GydisinfectPackInstance disinfectPackInstance) {
		try {

			this.getHibernateTemplate().save(disinfectPackInstance);
			return true;
		} catch (Exception e) {
			System.out.println('a');
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePackInstance(Integer DisinfectPackID) {
		try {
			// ��ͨ��id�ҵ�ɾ���Ķ���Ȼ��ɾ��
			GydisinfectPackInstance disfectPackInstance = (GydisinfectPackInstance) this
					.getHibernateTemplate().get(GydisinfectPackInstance.class,
							DisinfectPackID);
			this.getHibernateTemplate().delete(disfectPackInstance);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatePackInstance(
			GydisinfectPackInstance disinfectPackInstance) {
		try {
			this.getHibernateTemplate().update(disinfectPackInstance);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public GydisinfectPackInstance getPackInstance(Integer DisinfectPackID) {
		// TODO Auto-generated method stub
		Query query =this.getSession()
		.createQuery("from GydisinfectPackInstance gy where gy.disinfectPackId=?");
		query.setParameter(0, DisinfectPackID);
		List<GydisinfectPackInstance> list =query.list();
		if(list.size()>0)
			return list.get(0);
		return null;
	}

	public List<GydisinfectPackInstance> getPackInstanceByDPID(int DPID) {
		try {
			Query query = this
					.getSession()
					.createQuery(
							" from GydisinfectPackInstance gysl where gysl.DisinfectPackID=:DPIID");
			query.setInteger("DPIID", DPID);
			List<GydisinfectPackInstance> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<GydisinfectPackInstance> getPackInstanceByDIDandDPIandDPS(
			int DID, int DPI, String DPS) {
		StringBuilder sb = new StringBuilder();
		sb.append("from GydisinfectPackInstance gy where 1=1 ");
		Query query = null;
		List<Object> list = new ArrayList<Object>();
		if (-2 != DID) {
			sb.append(" and gy.disinfectId=? ");
			list.add(DID);
		}
		if (-2 != DPI) {
			sb.append(" and gy.udisinfectPackIn= ? ");
			list.add(DPI);
		}

		if (DPS != null && !DPS.equals("") && DPS !="ȫ��") {
			sb.append(" and gy.disinfectPackStatus=? ");
			list.add(DPS);
		}
		else
		{
			sb.append(" and gy.disinfectPackStatus <>?");
			list.add("�ѱ���");
		}

		 query=this.getSession().createQuery(sb.toString());
		 for(int i =0;i<list.size();i++){
		 query.setParameter(i, list.get(i));
		 }
				
		 return query.list();

//		return getHibernateTemplate().find(sb.toString(), list.toArray());

	}

	public boolean setDPSByDPID(int dpid) {

		GydisinfectPackInstance gydisinfectPackInstance = find(dpid);
		gydisinfectPackInstance.setDisinfectPackStatus("�ѱ���");
		update(gydisinfectPackInstance);
		return true;
	}
	public List<GydisinfectPackInstance> getPackInstanceByDpsdxd()
	{
		Query query=this.getSession()
		.createQuery("from GydisinfectPackInstance gy where gy.disinfectPackStatus=?");
		query.setParameter(0, "������");
		List<GydisinfectPackInstance> list=query.list();
		if(list.size()>0)
			return list;
		else return null;
		
	}
	public boolean setyxdByDPID(int dpid)
	{
		GydisinfectPackInstance gydisinfectPackInstance = find(dpid);
		gydisinfectPackInstance.setDisinfectPackStatus("������");
		update(gydisinfectPackInstance);
		return true;
	}
	public List<GydisinfectPackInstance> getPackInstanceByUid(int Uid)
	{
		Query query=this.getSession()
		.createQuery("from GydisinfectPackInstance gy where gy.udisinfectPackIn=? and gy.disinfectPackStatus<>?");
		query.setParameter(0, Uid);
		query.setParameter(1, "�ѱ���");
		List<GydisinfectPackInstance> list=query.list();
		if(list.size()!=0)
		return list;
		else return null;
	}
	public List<GydisinfectPackInstance> getPackInstanceByDid(int Did)
	{
		Query query =null;
		if(-2!=Did)
		{
			query=this.getSession()
			.createQuery("from GydisinfectPackInstance gy where gy.disinfectId=? and (gy.disinfectPackStatus=? or gy.disinfectPackStatus=?)  and gy.ubespeak=?");
			query.setParameter(0, Did);
			query.setParameter(1, "������");
			query.setParameter(2, "������");
			query.setParameter(3, -1);
		}
		else
		{
			query=this.getSession()
			.createQuery("from GydisinfectPackInstance gy where (gy.disinfectPackStatus=? or gy.disinfectPackStatus=?) and gy.ubespeak=? ");
			query.setParameter(0, "������");
			query.setParameter(1, "������");
			query.setParameter(2, -1);
		}		
		List<GydisinfectPackInstance> list=query.list();
		if(list.size()>0)
			return list;
		return null;
	}
	
	//mkj�޾�������--�������ÿ��Һ��޾������ͽ��ж�ȡ
	//Uid ���ÿ���ID    UBespeak
	//Did �޾�������ID  DisinfectID
	//UIid �������ҹ�Ӧ��   UDisinfectPackIn
	public List<GydisinfectPackInstance> ProvidePackInstance(String Uid,String Did,int UIid){
		int intDisinfectID;		//�޾�������ID
		int intUBespeak;		//ԤԼ����
		//UDisinfectPackIn      ��ǰ���ڿ���
		if(Uid == "" && Did == "")
		{
			intUBespeak = -1;
			try{
				Query query =this.getSession().createQuery(" from GydisinfectPackInstance gysl where gysl.ubespeak <>:PUIid " +
						"and gysl.udisinfectPackIn =:UUid");				
				query.setInteger("PUIid", intUBespeak);//UIid	
				query.setInteger("UUid", UIid);
				List<GydisinfectPackInstance> list=query.list();
				return list;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
		if(Uid == "" && Did != "")
		{
			intDisinfectID = Integer.parseInt(Did);
			intUBespeak = -1;
			try{
				Query query =this.getSession().createQuery(" from GydisinfectPackInstance gysl where gysl.ubespeak <>:PUIid " +
				" and gysl.disinfectId =:Deid and gysl.udisinfectPackIn =:UUid");
				query.setInteger("UUid", UIid);
				query.setInteger("Deid", intDisinfectID);
				query.setInteger("PUIid", intUBespeak);
				List<GydisinfectPackInstance> list=query.list();
				return list;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}		
		if(Uid != "" && Did == "")
		{
			intUBespeak = Integer.parseInt(Uid);
			try{
				Query query =this.getSession().createQuery(" from GydisinfectPackInstance gysl where gysl.ubespeak =:PUIid " +
				"and gysl.udisinfectPackIn =:UUid and gysl.udisinfectPackIn =:UUid");				
				query.setInteger("PUIid", intUBespeak);//UIid
				query.setInteger("UUid", UIid);
				List<GydisinfectPackInstance> list=query.list();
				return list;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
		if(Uid != "" && Did != "")
		{
			intUBespeak = Integer.parseInt(Uid);     //ԤԼ����
			intDisinfectID = Integer.parseInt(Did);  //�޾�������ID
			try{
				
				//Uid ���ÿ���ID    UBespeak
				//Did �޾�������ID  DisinfectID
				//UIid �������ҹ�Ӧ��   UDisinfectPackIn  int
				Query query =this.getSession().createQuery(" from GydisinfectPackInstance gysl where gysl.ubespeak =:PUIid " +
						"and gysl.udisinfectPackIn =:UUid and gysl.disinfectId =:Deid");
				query.setInteger("PUIid", intUBespeak);//UIid
				query.setInteger("UUid", UIid);
				query.setInteger("Deid", intDisinfectID);
				List<GydisinfectPackInstance> list=query.list();
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
	
	//mkj�޾�������--����IDȥ������ʵ����GYDisinfectPackInstance���ҵ��������ݸ������ڿ���UDisinfectPackIn��
	//������״̬DisinfectPackStatus��ԤԼ����UBespeakֵΪ��
	public boolean ModifyProvidePackInstanceById(int id,int intU){
		try{
			int intUBespeak = intU;		//ԤԼ����
			//Query query = this
			//.getSession()
			//.createQuery(
			//		"from GydisinfectPackInstance g where g.disinfectUid=:uid");
			//query.setInteger("uid", id);
			//List<GysupplyDisinfectPackInfo> list = query.list();

			GydisinfectPackInstance disfectPackInstance = (GydisinfectPackInstance) this
			.find(id);
			if(disfectPackInstance == null)	
				return false;
			disfectPackInstance.setUdisinfectPackIn(intUBespeak); //�����ý����ڿ��Ҹ�Ϊ��ԤԼ����
			disfectPackInstance.setDisinfectPackStatus("������");
			disfectPackInstance.setUbespeak(-1);
			this.getHibernateTemplate().update(disfectPackInstance);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	//mkj�޾����黹--�������ÿ��Һ��޾������ͽ��ж�ȡ����������״̬DisinfectPackStatus��������
	//��������ǰ���ڿ���UDisinfectPackIn�����ÿ���
	public List<GydisinfectPackInstance> GetPackInstanceBack(String Uid,String Did,int UIid){
		int intDisinfectID;		//�޾�������ID
		int intUBespeak;		//ԤԼ����
		String strDPS;			//������״̬
		if(Uid == "" && Did == "")
		{
			strDPS = "������";
			intUBespeak = -1;
			try{
				Query query =this.getSession().createQuery(" from GydisinfectPackInstance gysl where gysl.disinfectPackStatus =:GDPS " +
						"and gysl.ubespeak <>:PUIid and gysl.udisinfectPackIn =:UUid");				
				query.setInteger("PUIid", intUBespeak);//UIid	
				query.setInteger("UUid", UIid);
				query.setString("GDPS", strDPS);
				List<GydisinfectPackInstance> list=query.list();
				return list;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
		if(Uid == "" && Did != "")
		{
			intDisinfectID = Integer.parseInt(Did);
			intUBespeak = -1;
			strDPS = "������";
			try{
				Query query =this.getSession().createQuery(" from GydisinfectPackInstance gysl where gysl.disinfectPackStatus =:GDPS " +
						"and gysl.ubespeak <>:PUIid  and gysl.disinfectId =:Deid and gysl.udisinfectPackIn =:UUid");
				query.setInteger("UUid", UIid);
				query.setInteger("Deid", intDisinfectID);
				query.setInteger("PUIid", intUBespeak);
				query.setString("GDPS", strDPS);
				List<GydisinfectPackInstance> list=query.list();
				return list;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}		
		if(Uid != "" && Did == "")
		{
			strDPS = "������";
			intUBespeak = Integer.parseInt(Uid);
			try{
				Query query =this.getSession().createQuery(" from GydisinfectPackInstance gysl where gysl.disinfectPackStatus =:GDPS " +
						"and gysl.ubespeak =:PUIid and gysl.udisinfectPackIn =:UUid");				
				//query.setInteger("PUIid", intUBespeak);//UIid
				query.setInteger("UUid", UIid);
				query.setString("GDPS", strDPS);
				List<GydisinfectPackInstance> list=query.list();
				return list;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
		if(Uid != "" && Did != "")
		{
			intUBespeak = Integer.parseInt(Uid);     //ԤԼ����
			intDisinfectID = Integer.parseInt(Did);  //�޾�������ID
			strDPS = "������";
			try{
				
				//Uid ���ÿ���ID    UBespeak
				//Did �޾�������ID  DisinfectID
				//UIid �������ҹ�Ӧ��   UDisinfectPackIn  int
				Query query =this.getSession().createQuery(" from GydisinfectPackInstance gysl where gysl.disinfectPackStatus =:GDPS " +
				"and gysl.ubespeak =:PUIid  and gysl.disinfectId =:Deid and gysl.udisinfectPackIn =:UUid");
				query.setInteger("PUIid", intUBespeak);//UIid
				query.setInteger("UUid", UIid);
				query.setString("GDPS", strDPS);
				query.setInteger("Deid", intDisinfectID);
				List<GydisinfectPackInstance> list=query.list();
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
	
	//mkj�޾����黹--����IDȥ������ʵ����GYDisinfectPackInstance���ҵ��������ݸ������ڿ���UDisinfectPackInΪ��Ӧ�ң�
	//������״̬DisinfectPackStatusΪ��������
	public boolean BackProvidePackInstanceById(int id){
		try{
			GydisinfectPackInstance disfectPackInstance = (GydisinfectPackInstance) this
			.find(id);
			if(disfectPackInstance == null)	
				return false;
			disfectPackInstance.setDisinfectPackStatus("������");
			disfectPackInstance.setUdisinfectPackIn(disfectPackInstance.getDisinfectPackOfficeId());
			this.getHibernateTemplate().update(disfectPackInstance);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean setUBSpeakByDpidandUid(int dpid ,int uid)
	{
		GydisinfectPackInstance gydisinfectPackInstance = find(dpid);
		gydisinfectPackInstance.setUbespeak(uid);
		update(gydisinfectPackInstance);
		return true;
	}
	public List<GydisinfectPackInstance> getsqByUid(int Uid)
	{
		Query query=this.getSession()
		.createQuery("from GydisinfectPackInstance gy where gy.ubespeak=? and gy.disinfectPackStatus<>?");
		query.setParameter(0, Uid);
		query.setParameter(1, "������");
		List<GydisinfectPackInstance> list=query.list();
		if(list.size()>0)
			return list;
		return null;
	}
	public List<GydisinfectPackInstance> getlyByUidandDid(int Uid, int Did)
	{
		List<GydisinfectPackInstance>  list=null;
		if(Did!=-2)
		{
			Query query=this.getSession()
			.createQuery("from GydisinfectPackInstance gy where gy.ubespeak=? and gy.disinfectId =? and gy.disinfectPackStatus<>?");
			query.setParameter(0, Uid);
			query.setParameter(1, Did);
			query.setParameter(2, "������");
			list=query.list();
		}
		else
		{
			Query query=this.getSession()
			.createQuery("from GydisinfectPackInstance gy where gy.ubespeak=? and gy.disinfectPackStatus<>? ");
			query.setParameter(0, Uid);
			query.setParameter(1, "������");
			list =query.list();
		}
		
		if(list.size()>0)
			return list;
		return null;
	}
	public boolean setdpInByDpidandUid(int Dpid ,int Uid)
	{
		Query query =this.getSession()
		.createQuery("from GydisinfectPackInstance gy where gy.disinfectPackId=?");
		query.setParameter(0,Dpid);
		List<GydisinfectPackInstance> list=query.list();
		if(list.size()>0)
		{
			list.get(0).setUdisinfectPackIn(Uid);
			list.get(0).setDisinfectPackStatus("������");
			return true;
		}
		else
			return false;
	}
	public List<GydisinfectPackInstance> getghByUidandDid(int Uid, int Did)
	{
		Query query=null;
		List<GydisinfectPackInstance> list=null;
		if(Did==-2)
		{
			query=this.getSession()
			.createQuery("from GydisinfectPackInstance gy where gy.udisinfectPackIn=? and gy.disinfectPackStatus=?");
			query.setParameter(0, Uid);
			query.setParameter(1, "������");
			list =query.list();
		}
		else
		{
			query=this.getSession()
			.createQuery("from GydisinfectPackInstance gy where gy.udisinfectPackIn=? and gy.disinfectId=? and gy.disinfectPackStatus=? ");
			query.setParameter(0, Uid);
			query.setParameter(1, Did);
			query.setParameter(2, "������");
			list =query.list();
		}
		if(list.size()>0)
			return list;
		return null;
	}
	public boolean setghByDpid(int Dpid)
	{
		GydisinfectPackInstance gy=find(Dpid);
		gy.setUdisinfectPackIn(gy.getDisinfectPackOfficeId());
		gy.setUbespeak(-1);
		gy.setDisinfectPackStatus("������");
		return true;
	}
}
