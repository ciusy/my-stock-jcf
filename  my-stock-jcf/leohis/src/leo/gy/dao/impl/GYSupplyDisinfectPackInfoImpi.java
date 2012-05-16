package leo.gy.dao.impl;

import java.util.List;

import leo.gy.dao.iface.GYSupplyDisinfectPackInfoDAO;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.common.dao.DaoSupport;
import leo.entity.GysupplyDisinfectPackInfo;
import java.lang.*;

public class GYSupplyDisinfectPackInfoImpi extends
		DaoSupport<GysupplyDisinfectPackInfo> implements
		GYSupplyDisinfectPackInfoDAO {

	public List<GysupplyDisinfectPackInfo> getAllPackKindInfo(int gyuid) {
		try {
			Query query = this
					.getSession()
					.createQuery(
							"from GysupplyDisinfectPackInfo g where g.disinfectUid=:uid");
			query.setInteger("uid", gyuid);
			List<GysupplyDisinfectPackInfo> list = query.list();
			GysupplyDisinfectPackInfo g = (GysupplyDisinfectPackInfo) this
					.getHibernateTemplate().get(
							GysupplyDisinfectPackInfo.class, gyuid);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	//�����޾���ID�����޾�������
	public String GetGyDisinfectPackNameById(int id){
		String strName = "";
		try{
			GysupplyDisinfectPackInfo g = (GysupplyDisinfectPackInfo) this
			.find(id);
			return g.getDisinfectPackName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strName;
	}
	
	//�����޾���ID�����޾�����ע��Ϣ
	public String GetGyDisinfectPackNoteById(int id){
		String strNote = "";
		try{
			GysupplyDisinfectPackInfo g = (GysupplyDisinfectPackInfo) this
			.find(id);
			return g.getNote();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strNote;
	}
	//�����޾���ID�����޾�������
	public String GetGyDisinfectPackContentDiscById(int id){
		String strContentDisc = "";
		try{
			GysupplyDisinfectPackInfo g = (GysupplyDisinfectPackInfo) this
			.find(id);
			return g.getContentDisc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strContentDisc;
	}
	public List<GysupplyDisinfectPackInfo> getAllPackKindInfo() {
		try {
			Query query = this.getSession().createQuery(
					"from GysupplyDisinfectPackInfo");
			// query.setInteger("uid", gyuid);
			List<GysupplyDisinfectPackInfo> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean addPackKindInfo(GysupplyDisinfectPackInfo disinfectPackInfo) {
		try {
			this.getHibernateTemplate().save(disinfectPackInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean modifyPackKindInfo(GysupplyDisinfectPackInfo g) {
		try {
			this.getHibernateTemplate().update(g);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	


	//У���޾��������Ƿ��ظ�������ظ�����������
	public boolean FindGysupplyDisinfectPackInfoByName(String name){
		try {
			Query query = this.getSession().createQuery(
			"from GysupplyDisinfectPackInfo g where g.disinfectPackName=:dname");
			query.setString("dname", name);
			List<GysupplyDisinfectPackInfo> list = query.list();
			if(list.size() > 0)
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	// ͨ��GY001��õ��޾�������ID��ȡ��������
	public GysupplyDisinfectPackInfo FindGysupplyDisinfectPackInfoByID(int id) {

		try {
			GysupplyDisinfectPackInfo g1 = (GysupplyDisinfectPackInfo) this
					.find(id);
			return g1;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		// try {
		// Query query = this
		// .getSession()
		// .createQuery(
		// "from GysupplyDisinfectPackInfo g where g.disinfectUid=:id");
		// query.setInteger("id", id);
		// GysupplyDisinfectPackInfo g1 =
		// (GysupplyDisinfectPackInfo)query.list().get(0);
		// return g1;
		//			
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// return null;
	}
	public int GetDIDByDPN(String dpn)
	{
		Query query=this.getSession()
		.createQuery("from GysupplyDisinfectPackInfo gy where gy.disinfectPackName=?");
		query.setParameter(0, dpn);
		List<GysupplyDisinfectPackInfo> list=query.list();
		if(list.size()>0)
			return  list.get(0).getDisinfectId();
		else return -1;
		
	}
	// ���޾������ͱ������һ������
	/*
	 * public void insertPackKindInfo( GysupplyDisinfectPackInfo
	 * gysupplyDisinfectPackInfo) {
	 * 
	 * getHibernateTemplate().save(gysupplyDisinfectPackInfo); }
	 */
	// public String insertPackKindInfo(
	// String strDisinfectPackName,String strContentDisc,
	// String strNote,float POnceUse,int isinfectUID ){
	// String msg = "";
	// GysupplyDisinfectPackInfo gysupplyDisinfectPackInfo
	// = new GysupplyDisinfectPackInfo();
	// //String strDisinfectID1 = strDisinfectID;���ݿ���Ϊ�Զ�������
	// gysupplyDisinfectPackInfo.setDisinfectPackName(strDisinfectPackName);
	// gysupplyDisinfectPackInfo.setContentDisc(strContentDisc);
	// gysupplyDisinfectPackInfo.setNote(strNote);
	// gysupplyDisinfectPackInfo.setPonceUse(POnceUse);
	// gysupplyDisinfectPackInfo.setDisinfectUid(isinfectUID);
	//		
	// return msg;
	//		
	// }
}
