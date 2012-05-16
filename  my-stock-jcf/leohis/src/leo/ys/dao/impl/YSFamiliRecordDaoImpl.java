/**
 * 
 */
package leo.ys.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.entity.Agreement;
import leo.entity.Csconsumer;
import leo.entity.CsconsumerInfo;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.DataSourceConfig;
import leo.entity.EugenicsModule;
import leo.entity.FamiliRecord;
import leo.entity.FamiliRecordBasicInfo;
import leo.entity.Notify;
import leo.entity.NotifyItems;
import leo.entity.NotifyModule;
import leo.entity.NotifyModuleTerm;
import leo.entity.OsmedicalInstInfo;
import leo.ys.dao.iface.YSFamiliRecordDao;


/**
 * @author Administrator
 *
 */
public class YSFamiliRecordDaoImpl extends HibernateDaoSupport implements YSFamiliRecordDao {

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#AddAgreement(leo.entity.Agreement)
	 */
	public boolean addAgreement(Agreement agreement) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().save(agreement);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	/*
	 * 新增服务对象
	 */
	public boolean addCsconsumer(Csconsumer cscon)
	{
		try
		{
			super.getHibernateTemplate().save(cscon);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	/*
	 * 新增服务对象扩展信息
	 */
	public boolean addCsconsumerInfo(CsconsumerInfo csconinfo)
	{
		try
		{
			super.getHibernateTemplate().save(csconinfo);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#AddFamiliRecord(leo.entity.FamiliRecord)
	 */
	public boolean addFamiliRecord(FamiliRecord fr) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().save(fr);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#AddFamiliRecordBasicInfo(leo.entity.FamiliRecordBasicInfo)
	 */
	public boolean addFamiliRecordBasicInfo(FamiliRecordBasicInfo frbi) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().save(frbi);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#DelAgreement(java.lang.String)
	 */
	public boolean delAgreement(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM agreement WHERE RecordID ='" + strRecordID + "'";
		Session session = super.getSession();
		try
		{
			SQLQuery query=session.createSQLQuery(strTempSQL);
			int nTempCount = query.executeUpdate();
			if(nTempCount>0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#DelFamiliRecord(java.lang.String)
	 */
	public boolean delFamiliRecord(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM FamiliRecord WHERE RecordID ='" + strRecordID + "'";
		Session session = super.getSession();
		try
		{
			SQLQuery query=session.createSQLQuery(strTempSQL);
			int nTempCount = query.executeUpdate();
			if(nTempCount>0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#DelFamiliRecordBasicInfo(java.lang.String)
	 */
	public boolean delFamiliRecordBasicInfo(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM FamiliRecordBasicInfo WHERE RecordID ='" + strRecordID + "'";
		Session session = super.getSession();
		try
		{
			SQLQuery query=session.createSQLQuery(strTempSQL);
			int nTempCount = query.executeUpdate();
			if(nTempCount>0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return false;
	}

	public Agreement getAgreement(String strRecordID) {
		// TODO Auto-generated method stub
		Agreement agreement =null;
		try
		{
			agreement=(Agreement)super.getHibernateTemplate().get(Agreement.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return agreement;
	}
	
	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#GetFamiliRecordBasicInfoByRecordID(java.lang.String)
	 */
	public FamiliRecordBasicInfo getFamiliRecordBasicInfoByRecordID(
			String strRecordID) {
		// TODO Auto-generated method stub
		FamiliRecordBasicInfo frbi =null;
		try
		{
			frbi=(FamiliRecordBasicInfo)super.getHibernateTemplate().get(FamiliRecordBasicInfo.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return frbi;
	}

	/*
	 * 根据日期、医疗机构ID、医生，查询一段时间内的档案基础信息。
	 * 日期必填、 医疗机构ID和医生是可选项即可填可不填。
	 */
	public List<FamiliRecordBasicInfo> getFamiliRecordBasicInfoByDate(String strBeginDate,String strEndDate,String strMedicalInstID,String strDoctor)
	{
		String strTempSQL="";
		strTempSQL="from FamiliRecordBasicInfo where writtenDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		if("".equals(strMedicalInstID) || strMedicalInstID==null)
		{			
		}
		else
		{
			strTempSQL=strTempSQL+" and medicalInstId =" + strMedicalInstID;
		}
		if("".equals(strDoctor) || strDoctor==null)
		{			
		}
		else
		{
			strTempSQL=strTempSQL+" and doctor ='" + strDoctor +"'";
		}
		List<FamiliRecordBasicInfo> list = null;
		try
		{
			strTempSQL=strTempSQL+" order by writtenDate desc";
			Query query=super.getSession().createQuery(strTempSQL);
			list =query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}
	
	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#GetFamiliRecordByRecordID(java.lang.String)
	 */
	public FamiliRecord getFamiliRecordByRecordID(String strRecordID) {
		// TODO Auto-generated method stub
		FamiliRecord fr =null;
		try
		{
			fr=(FamiliRecord)super.getHibernateTemplate().get(FamiliRecord.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return fr;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#GetRecordIDByMCsID(java.lang.String)
	 */
	public String getRecordIDByMCsID(String strMCsID) {
		// TODO Auto-generated method stub
		String strRecordID ="";
		String strTempSQL ="SELECT RecordID FROM FamiliRecord WHERE MCsID =" + strMCsID;
		Session session = super.getSession();
		try
		{
			SQLQuery query = session.createSQLQuery(strTempSQL);
			List list = query.list();
			if(list.size()>0)
			{
				strRecordID = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return strRecordID;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#GetRecordIDByMIDCardNum(java.lang.String)
	 */
	public String getRecordIDByMIDCardNum(String strMIDCardNum) {
		// TODO Auto-generated method stub
		String strRecordID ="";
		String strTempSQL ="SELECT RecordID FROM FamiliRecord WHERE MIDCardNum ='" + strMIDCardNum + "'";
		Session session = super.getSession();
		try
		{
			SQLQuery query = session.createSQLQuery(strTempSQL);
			List list = query.list();
			if(list.size()>0)
			{
				strRecordID = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return strRecordID;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#GetRecordIDByMOpDnID(java.lang.String)
	 */
	public String getRecordIDByMOpDnID(String strMOpDnID) {
		// TODO Auto-generated method stub
		String strRecordID ="";
		String strTempSQL ="SELECT RecordID FROM FamiliRecord WHERE MOpDnID ='" + strMOpDnID + "'";
		Session session = super.getSession();
		try
		{
			SQLQuery query = session.createSQLQuery(strTempSQL);
			List list = query.list();
			if(list.size()>0)
			{
				strRecordID = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return strRecordID;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#GetRecordIDByWCsID(java.lang.String)
	 */
	public String getRecordIDByWCsID(String strWCsID) {
		// TODO Auto-generated method stub
		String strRecordID ="";
		String strTempSQL ="SELECT RecordID FROM FamiliRecord WHERE WCsID =" + strWCsID;
		Session session = super.getSession();
		try
		{
			SQLQuery query = session.createSQLQuery(strTempSQL);
			List list = query.list();
			if(list.size()>0)
			{
				strRecordID = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return strRecordID;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#GetRecordIDByWIDCardNum(java.lang.String)
	 */
	public String getRecordIDByWIDCardNum(String strWIDCardNum) {
		// TODO Auto-generated method stub
		String strRecordID ="";
		String strTempSQL ="SELECT RecordID FROM FamiliRecord WHERE WIDCardNum ='" + strWIDCardNum + "'";
		Session session = super.getSession();
		try
		{
			SQLQuery query = session.createSQLQuery(strTempSQL);
			List list = query.list();
			if(list.size()>0)
			{
				strRecordID = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return strRecordID;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#GetRecordIDByWOpDnID(java.lang.String)
	 */
	public String getRecordIDByWOpDnID(String strWOpDnID) {
		// TODO Auto-generated method stub
		String strRecordID ="";
		String strTempSQL ="SELECT RecordID FROM FamiliRecord WHERE WOpDnID ='" + strWOpDnID + "'";
		Session session = super.getSession();
		try
		{
			SQLQuery query = session.createSQLQuery(strTempSQL);
			List list = query.list();
			if(list.size()>0)
			{
				strRecordID = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return strRecordID;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#UpdateAgreement(leo.entity.Agreement)
	 */
	public boolean updateAgreement(Agreement agreement) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().update(agreement);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#UpdateFamiliRecord(leo.entity.FamiliRecord)
	 */
	public boolean updateFamiliRecord(FamiliRecord fr) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().update(fr);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSFamiliRecordDao#UpdateFamiliRecordInfo(leo.entity.FamiliRecordBasicInfo)
	 */
	public boolean updateFamiliRecordInfo(FamiliRecordBasicInfo frbi) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().update(frbi);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public OsmedicalInstInfo getOSMedicalInstInfo(String strMedicalInstID) {
		// TODO Auto-generated method stub
		OsmedicalInstInfo medicalInstInfo = null;
		try
		{
			medicalInstInfo = (OsmedicalInstInfo)super.getHibernateTemplate().get(OsmedicalInstInfo.class, Integer.parseInt(strMedicalInstID));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return medicalInstInfo;
	}

	public String createFamiliRecordID() {
		// TODO Auto-generated method stub
		String strRecordID ="";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = format.format(new Date());
		String strTempSQL ="select top 1 RecordID from FamiliRecordBasicInfo where WrittenDate >= '"+ strDate + " 00:00:00' and WrittenDate <= '" + strDate + " 23:59:59' order by RecordID desc";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		List list = query.list();
		if(list.size()>0)
		{
			String strTemp=list.get(0).toString().substring(0,8);
			int nMaxRecordID = (Integer.parseInt(list.get(0).toString().substring(8))+ 1);
			String strTemp1=String.valueOf(nMaxRecordID);
			if (strTemp1.length()==1)
			{
				strTemp1="0000"+strTemp1;
			}
			else if(strTemp1.length()==2)
			{
				strTemp1="000"+strTemp1;
			}
			else if(strTemp1.length()==3)
			{
				strTemp1="00"+strTemp1;
			}
			else if(strTemp1.length()==4)
			{
				strTemp1="0"+strTemp1;
			}
			strRecordID =strTemp+strTemp1;
		}
		else
		{
			format = new SimpleDateFormat("yyyyMMdd");
			strRecordID = format.format(new Date())+ "00001";
		}
		return strRecordID;
	}

	public boolean existFamiliRecordID(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from FamiliRecord where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/*
	 * 判断基础信息表中的档案编号是否存在
	 */
	public boolean existFamiliBasicInfoRecordID(String strRecordID)
	{
		String strTempSQL ="select RecordID from FamiliRecordBasicInfo where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}
	
	public Csconsumer getCSConsumerByCsID(String strCsID) {
		// TODO Auto-generated method stub
		Csconsumer csConsumer = null;
		try
		{
			csConsumer =(Csconsumer)super.getHibernateTemplate().get(Csconsumer.class, Long.parseLong(strCsID));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return csConsumer;
	}

	/*
	 * 根据配偶编号获取配偶的实体对象
	 */
	public Csconsumer getCSConsumerByMateID(String strMateID)
	{
		Csconsumer cscon=null;
		String strTempSQL="from Csconsumer where csId ='"+strMateID+"'";
		try
		{
			Query query =super.getSession().createQuery(strTempSQL);
			if(query.list().size()>0)
			{
				cscon=(Csconsumer)query.list().get(0);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return cscon;
	}
	
	public List<Csconsumer> getCSConsumerByIDCardNum(String strIDCardNum) {
		// TODO Auto-generated method stub
		List<Csconsumer> list = null;
		String strTempSQL ="from Csconsumer where idcardNum = '" + strIDCardNum + "'";
		try
		{
			Query query = super.getSession().createQuery(strTempSQL);
			list =query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}

	public CsconsumerInfo getCSConsumerInfo(String strCsID) {
		// TODO Auto-generated method stub
		CsconsumerInfo csConInfo =null;
		try
		{
			csConInfo = (CsconsumerInfo)super.getHibernateTemplate().get(CsconsumerInfo.class, Long.parseLong(strCsID));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return csConInfo;
	}

	/*
	 * 根身份证号判断服务对象是否存在
	 */
	public boolean existCSConsumerByIDCardNum(String strIDCardNum)
	{
		String strTempSQL ="select CsID from CSConsumer where IDCardNum= '"+ strIDCardNum + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}
	
	/*
	 * 修改服务对象的实体对象
	 */
	public boolean updateCSConsumer(Csconsumer cscon)
	{
		try
		{
			super.getHibernateTemplate().update(cscon);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	/*
	 * 修改服务附加信息的实体对象
	 */
	public boolean updateCSConsumerInfo(CsconsumerInfo csconinfo)
	{
		try
		{
			super.getHibernateTemplate().update(csconinfo);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}	
	
	public String GetCityName(String strCity) {
		// TODO Auto-generated method stub
		String strName ="";
		String strTempSQL ="SELECT CityName FROM CFCity where CityID=" + strCity;
		try
		{
			List list = super.getSession().createSQLQuery(strTempSQL).list();
			if(list.size()>0)
			{
				strName = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return strName;
	}

	public String GetPrefectureName(String strPrefecture) {
		// TODO Auto-generated method stub
		String strName ="";
		String strTempSQL ="SELECT PrefectureName FROM CFPrefecture where PrefectureID=" + strPrefecture;
		try
		{
			List list = super.getSession().createSQLQuery(strTempSQL).list();
			if(list.size()>0)
			{
				strName = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return strName;
	}

	public String GetProvinceName(String strProvince) {
		// TODO Auto-generated method stub
		String strName ="";
		String strTempSQL ="SELECT ProvName FROM CFProvince where ProvID=" + strProvince;
		try
		{
			List list = super.getSession().createSQLQuery(strTempSQL).list();
			if(list.size()>0)
			{
				strName = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return strName;
	}

	public String GetTownName(String strTown) {
		// TODO Auto-generated method stub
		String strName ="";
		String strTempSQL ="SELECT TownName FROM CFTown where TownID=" + strTown;
		try
		{
			List list = super.getSession().createSQLQuery(strTempSQL).list();
			if(list.size()>0)
			{
				strName = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return strName;
	}

	public String GetViliageName(String strViliage) {
		// TODO Auto-generated method stub
		String strName ="";
		String strTempSQL ="SELECT VillageName FROM CFVillage where VillageID=" + strViliage;
		try
		{
			List list = super.getSession().createSQLQuery(strTempSQL).list();
			if(list.size()>0)
			{
				strName = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return strName;
	}

	/*
	 * 根据组编码获取村名称
	 */
	public String GetGroupName(String strGroup)
	{
		String strName ="";
		String strTempSQL ="SELECT GroupName FROM CFGroup where GroupID=" + strGroup;
		try
		{
			List list = super.getSession().createSQLQuery(strTempSQL).list();
			if(list.size()>0)
			{
				strName = list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return strName;
	}
	
	public boolean existAgreementRecordID(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from Agreement where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	public boolean addNotify(Notify ny) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().save(ny);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public boolean deleteNotify(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM notify WHERE RecordID ='" + strRecordID + "'";
		Session session = super.getSession();
		try
		{
			SQLQuery query=session.createSQLQuery(strTempSQL);
			int nTempCount = query.executeUpdate();
			if(nTempCount>0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return false;
	}

	public boolean existNotify(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from notify where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	public Notify getNotify(String strRecordID) {
		// TODO Auto-generated method stub
		Notify ny =null;
		try
		{
			ny=(Notify)super.getHibernateTemplate().get(Notify.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ny;
	}

	public boolean updateNotify(Notify ny) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().update(ny);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public boolean addEugenicsModule(EugenicsModule em) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().save(em);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public boolean deleteEugenicsModule(String strModuleID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM EugenicsModule WHERE ModuleID =" + strModuleID ;
		Session session = super.getSession();
		try
		{
			SQLQuery query=session.createSQLQuery(strTempSQL);
			int nTempCount = query.executeUpdate();
			if(nTempCount>0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return false;
	}

	public boolean existEugenicsModule(String strModuleID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select ID from EugenicsModule where ModuleID= "+ strModuleID;
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	public boolean updateEugenicsModule(EugenicsModule em) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().update(em);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public List<EugenicsModule> getEugenicModuleByRemarks(String strRemarks) {
		// TODO Auto-generated method stub
		List<EugenicsModule> list =null;
		String strTemp="from EugenicsModule where remarks ='" + strRemarks + "'";
		
		try
		{
			Session session=super.getSession();
			Query query=session.createQuery(strTemp);
			list=query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}

	public EugenicsModule getEugenicsModule(String strModuleID) {
		// TODO Auto-generated method stub
		EugenicsModule em =null;
		try
		{
			em=(EugenicsModule)super.getHibernateTemplate().get(EugenicsModule.class, strModuleID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return em;
	}

	public List<EugenicsModule> getEugenicModuleByRemarksAndTitle(
			String strRemarks, String strTitle) {
		// TODO Auto-generated method stub
		List<EugenicsModule> list =null;
		String strTemp="from EugenicsModule where remarks ='" + strRemarks + "' and title like '%" + strTitle +"%'";
		
		try
		{
			Session session=super.getSession();
			Query query=session.createQuery(strTemp);
			list=query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}

	public boolean addDataSourceConfig(DataSourceConfig dsc) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().save(dsc);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public boolean deleteDataSourceConfig(String strID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM DataSourceConfig WHERE ID =" + strID ;
		Session session = super.getSession();
		try
		{
			SQLQuery query=session.createSQLQuery(strTempSQL);
			int nTempCount = query.executeUpdate();
			if(nTempCount>0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return false;
	}

	public boolean existDataSourceConfig(String strID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select ItemTypeID from DataSourceConfig where ID= "+ strID;
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/*
	 * 根据模板编号和受检人(妻子或丈夫)判断数据来源配置模板是否存在
	 */
	public boolean existDataSourceConfigByItemIDAndTypeName(String strItemTypeID,String strTypeName)
	{
		boolean bExist=false;
		boolean bExistInBCReport=false;
		String strTempSQL ="select ItemTypeID from DataSourceConfig where ItemTypeID= "+ strItemTypeID + " and TypeName = '" + strTypeName + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		int nSize=query.list().size();
		if(nSize>0)
		{
			bExist= true;
		}
		else
		{
			//防止添加多个属于B超报告单的项目，即只允许开一次妇科B超
			strTempSQL="select ItemTypeID from CzdisposeItemDescribe where report = 'B超检查报告单'";
			query=super.getSession().createSQLQuery(strTempSQL);
			for(int i=0;i<query.list().size();i++)
			{
				if(strItemTypeID.equals(query.list().get(i).toString()))
				{
					bExistInBCReport=true;
					break;
				}
			}
			if(bExistInBCReport)
			{
				for(int i=0;i<query.list().size();i++)
				{
					if(strTypeName.equals("丈夫"))//丈夫不能开B超项目
					{
						bExist=true;
						break;
					}
					strTempSQL ="select ItemTypeID from DataSourceConfig where ItemTypeID= "+ query.list().get(i).toString() + " and TypeName = '" + strTypeName + "'";
					SQLQuery queryTemp=super.getSession().createSQLQuery(strTempSQL);
					if(queryTemp.list().size()>0)
					{
						bExist=true;
						break;
					}
	//				if(strItemTypeID.equals(query.list().get(i).toString()))
	//				{
	//					return true;
	//				}
				}
			}
		}
		return bExist;
	}
	
	public List<DataSourceConfig> getDataSourceConfigByType(String strTypeName) {
		// TODO Auto-generated method stub
		List<DataSourceConfig> list = null;
		String strTempSQL ="from DataSourceConfig where typeName = '" + strTypeName + "'";
		if("".equals(strTypeName))
		{
			strTempSQL="from DataSourceConfig";
		}
		
		try
		{
			Query query = super.getSession().createQuery(strTempSQL);
			list = query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}

	public boolean updateDataSourceConfig(DataSourceConfig dsc) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().update(dsc);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public DataSourceConfig getDataSourceConfig(String strItemTypeID) {
		// TODO Auto-generated method stub
		DataSourceConfig dsc =null;
		try
		{
			dsc=(DataSourceConfig)super.getHibernateTemplate().get(DataSourceConfig.class, strItemTypeID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsc;
	}

	public List<CzdisposeItemDescribe> getCZDisposeItemDescribe(String strReport) {
		// TODO Auto-generated method stub
		List<CzdisposeItemDescribe> list = null;
		String strTempSQL ="from CzdisposeItemDescribe where report = '" + strReport + "'";
		if("".equals(strReport))
		{
			strTempSQL ="from CzdisposeItemDescribe where report = 'B超检查报告单' or report='检验报告单'";
		}
		
		try
		{
			Query query = super.getSession().createQuery(strTempSQL);
			list = query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}

	public boolean addNotifyItems(NotifyItems ni) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().save(ni);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public boolean addNotifyModule(NotifyModule nm) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().save(nm);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public boolean addNotifyModuleTerm(NotifyModuleTerm mnt) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().save(mnt);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public boolean deleteNotifyItems(String strNIID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM NotifyItems WHERE NIID =" + strNIID;
		Session session = super.getSession();
		try
		{
			SQLQuery query=session.createSQLQuery(strTempSQL);
			int nTempCount = query.executeUpdate();
			if(nTempCount>0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return false;
	}

	public boolean deleteNotifyModule(String strNMID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM NotifyModule WHERE NMID =" + strNMID;
		Session session = super.getSession();
		try
		{
			SQLQuery query=session.createSQLQuery(strTempSQL);
			int nTempCount = query.executeUpdate();
			if(nTempCount>0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return false;
	}

	/*
	 * 根据告知书评估项目表ID删除优生自动优生评估模板
	 */
	public boolean deleteNotifyModuleByNIID(String strNIID)
	{
		String strTempSQL = "delete FROM NotifyModule WHERE NIID =" + strNIID;
		Session session = super.getSession();
		try
		{
			SQLQuery query=session.createSQLQuery(strTempSQL);
			int nTempCount = query.executeUpdate();
			if(nTempCount>0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return false;
	}
	
	public boolean deleteNotifyModuleTerm(String strNMTID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM NotifyModuleTerm WHERE NMTID =" + strNMTID;
		Session session = super.getSession();
		try
		{
			SQLQuery query=session.createSQLQuery(strTempSQL);
			int nTempCount = query.executeUpdate();
			if(nTempCount>0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//session.close();
		}
		return false;
	}

	public boolean existNotifyItems(String strNIID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select NIID from NotifyItems where NIID="+ strNIID;
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	public boolean existNotifyModule(String strNMID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select NMID from NotifyModule where NMID="+ strNMID;
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	public boolean existNotifyModuleTerm(String strNMTID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select NMTID from NotifyModuleTerm where NMTID="+ strNMTID;
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	public NotifyItems getNotifyItems(String strNIID) {
		// TODO Auto-generated method stub
		NotifyItems dsc =null;
		try
		{
			dsc=(NotifyItems)super.getHibernateTemplate().get(NotifyItems.class, Long.valueOf(strNIID));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsc;
	}

	public List<NotifyItems> getNotifyItemsAll() {
		// TODO Auto-generated method stub
		List<NotifyItems> list =null;
		String strTemp="from NotifyItems";		
		try
		{
			Session session=super.getSession();
			Query query=session.createQuery(strTemp);
			list=query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}

	/*
	 * 根据条件标题获取自动评估模板目录
	 */
	public List<NotifyItems> getNotifyItemsByCondition(String strCondition)
	{
		List<NotifyItems> list =null;
		String strTemp="from NotifyItems where condition like '%" + strCondition + "%'";		
		try
		{
			Session session=super.getSession();
			Query query=session.createQuery(strTemp);
			list=query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 获取自动评估模板目录表中的最大的编号(即最后一次插入的记录编号)
	 */
	public long GetMaxIDFromNotifyItems()
	{
		long lgMaxID=-1;
		String strTemp="select max(niid) from NotifyItems";
		try
		{
			SQLQuery query=super.getSession().createSQLQuery(strTemp);
			if(query.list().size()>0)
			{
				lgMaxID=Long.parseLong(query.list().get(0).toString());
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return lgMaxID;
	}
	
	public NotifyModule getNotifyModule(String strNMID) {
		// TODO Auto-generated method stub
		NotifyModule dsc =null;
		try
		{
			dsc=(NotifyModule)super.getHibernateTemplate().get(NotifyModule.class, Long.valueOf(strNMID));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsc;
	}

	public List<NotifyModule> getNotifyModuleAll() {
		// TODO Auto-generated method stub
		List<NotifyModule> list =null;
		String strTemp="from NotifyModule";		
		try
		{
			Session session=super.getSession();
			Query query=session.createQuery(strTemp);
			list=query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}

	public NotifyModuleTerm getNotifyModuleTerm(String strNMTID) {
		// TODO Auto-generated method stub
		NotifyModuleTerm dsc =null;
		try
		{
			dsc=(NotifyModuleTerm)super.getHibernateTemplate().get(NotifyModuleTerm.class, Long.valueOf(strNMTID));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsc;
	}

	public List<NotifyModuleTerm> getNotifyModuleTermAll() {
		// TODO Auto-generated method stub
		List<NotifyModuleTerm> list =null;
		String strTemp="from NotifyModuleTerm";		
		try
		{
			Session session=super.getSession();
			Query query=session.createQuery(strTemp);
			list=query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}

	/*
	 * 根据条件名称获取自动评估模板具体项目
	 */
	public List<NotifyModuleTerm> getNotifyModuleTermByConditionName(String strConditionName)
	{
		List<NotifyModuleTerm> list =null;
		String strTemp="from NotifyModuleTerm where conditionName like '%" + strConditionName + "%'";		
		try
		{
			Session session=super.getSession();
			Query query=session.createQuery(strTemp);
			list=query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}
	
	public boolean updateNotifyItems(NotifyItems ni) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().update(ni);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public boolean updateNotifyModule(NotifyModule nm) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().update(nm);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public boolean updateNotifyModuleTerm(NotifyModuleTerm mnt) {
		// TODO Auto-generated method stub
		try
		{
			super.getHibernateTemplate().update(mnt);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	/*
	 * 根据模板ID获取自动评估模板进行维护
	 */
	public String[][] getNotifyModuleReuslt(String strNIID)
	{
		List list=null;
		String strTempSQL="select NotifyModule.Remarks,NotifyModule.Result,NotifyModule.ResulCoding,NotifyModuleTerm.ConditionName,NotifyModuleTerm.sex,NotifyModuleTerm.NMTID "+
                             "from NotifyModule,NotifyModuleTerm,NotifyItems where NotifyModule.NMTID = NotifyModuleTerm.NMTID and NotifyModule.NIID = NotifyItems.NIID and NotifyModule.NIID =" +  strNIID + " order by NotifyModuleTerm.NMTID";
		SQLQuery query=super.getSession().createSQLQuery(strTempSQL);
		list=query.list();
		//return list;
		int rows = list.size();
		if (rows > 0) {
			int columns = ((Object[]) list.get(0)).length;
			String[][] strings = new String[rows][columns];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++)
					strings[i][j] = String.valueOf(((Object[]) list.get(i))[j]);
			}
			return strings;
		}
		return new String[0][0];
	}
	
	/*
	 * 根据strTypeName(妻子或丈夫)获取(妻子或丈夫)所有检验项目的ID。
	 * 如果strTypeName为空，则获取所有设置好的所有检验项目ID。
	 */
	public int[] getItemTypeID(String strTypeName)
	{
		String strTempSQL="select ItemTypeID from DataSourceConfig where TypeName ='" + strTypeName + "'";
		if("".equals(strTypeName))
		{
			strTempSQL="select ItemTypeID from DataSourceConfig";
		}
		SQLQuery query= super.getSession().createSQLQuery(strTempSQL);
		List list=query.list();
		int nRowCount= list.size();
		int[] itemID;
		if(nRowCount>0)
		{
			itemID=new int[nRowCount];
			for(int i=0;i<nRowCount;i++)
			{
				itemID[i]= Integer.parseInt(list.get(i).toString());
			}
		}
		else
		{
			itemID=new int[1];
			itemID[0]=-1;
		}
		return itemID;
	}
	
	/*
	 * 获取国家优生项目技术服务工作月统计报表需要的数据 
	 */
	public String[][] getServerMonthReport(String strBeginDate,String strEndDate)
	{
		int nTotalCount,nTemp;
		String strYearBegin,strYearEnd;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt;
		try
		{
			 dt= sdf.parse(strBeginDate);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		//strYearBegin=String.valueOf(dt.getYear())+"-01-01";
		//strYearEnd=String.valueOf(dt.getYear())+"-12-31";
		Calendar calender = GregorianCalendar.getInstance();
		calender.setTime(dt);
		strYearBegin=String.valueOf(calender.get(calender.YEAR))+"-01-01";
		strYearEnd=String.valueOf(calender.get(calender.YEAR))+"-12-31";
		String[][] strItemCount= new String[9][55];
		String strTempSQL;
		//**************************************************************************************************************
		//镇级机构服务数量-农村夫妇
		//本年度计划怀孕夫妇人数(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo where PregnantTimeExpected between '" + strYearBegin + "' and '" + strYearEnd + "' and MDomicile='1' and MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1')";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo where PregnantTimeExpected between '" + strYearBegin + "' and '" + strYearEnd + "' and MDomicile='1' and stuffId in (select SID from OSStuff where town <>'-1')";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][0]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//检查人数-男性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MCsID>-1";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.stuffId in (select SID from OSStuff where town <>'-1') and B.MCsID>-1";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][2]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//检查人数-女性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.WCsID >-1";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.stuffId in (select SID from OSStuff where town <>'-1') and B.WCsID >-1";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][3]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//检查人数-合计(镇级农村夫妇)
		strItemCount[1][1]=String.valueOf(Integer.parseInt(strItemCount[1][2])+Integer.parseInt(strItemCount[1][3]));
		
		//优生健康检查人次(镇级农村夫妇)
		strItemCount[1][4]=strItemCount[1][1];
		
		//病史询问人次-男性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][6]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//病史询问人次-女性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][7]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//病史询问人次-合计(镇级农村夫妇)
		strItemCount[1][5]=String.valueOf(Integer.parseInt(strItemCount[1][6])+Integer.parseInt(strItemCount[1][7]));
		
		//体格检查-常规体格检查人数-正常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][9]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-正常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][9]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][9]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-异常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][10]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-异常(镇级农村夫妇)-丈夫 
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][10]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][10]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//体格检查-生殖系统检查人数-正常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][11]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-正常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][11]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][11]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-异常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][12]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-异常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][12]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][12]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-白带常规检查人数-正常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][13]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-白带常规检查人数-异常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][14]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-淋球菌检查人数-正常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Gonococcus='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Gonococcus='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][15]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-淋球菌规检查人数-异常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Gonococcus<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Gonococcus<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][16]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-沙眼衣原体检查人数-正常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.ChlamydiaT='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.ChlamydiaT='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][17]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-沙眼衣原体检查人数-异常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.ChlamydiaT<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.ChlamydiaT<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][18]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//血液常规检查人数-正常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][19]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血液常规检查人数-异常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][20]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//尿液常规检查人数-正常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][21]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-正常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][21]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][21]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-异常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][22]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-异常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][22]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][22]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//血型检查人数-正常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][23]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-正常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][23]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][23]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-特殊(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][24]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-特殊(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][24]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][24]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}

		//血清葡萄糖测定人数-正常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][25]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血清葡萄糖测定人数-异常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][26]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//肝功能检测人数-正常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][27]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-正常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][27]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][27]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-异常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][28]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-异常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][28]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][28]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//乙型肝炎血清学五项检测人数-正常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][29]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-正常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][29]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][29]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-异常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][30]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-异常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][30]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][30]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//肾功能检测人数-正常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][31]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-正常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][31]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][31]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-异常(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][32]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-异常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][32]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][32]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//甲状腺功能检测人数-正常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][33]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//甲状腺功能检测人数-异常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][34]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//梅毒螺旋体筛查人数-阴性(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][35]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阴性(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][35]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][35]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阳性(镇级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][36]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阳性(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][36]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[1][36]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//风疹病毒IgG抗体测定人数-阴性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.RuV='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.RuV='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][37]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//风疹病毒IgG抗体测定人数-阳性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.RuV<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.RuV<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][38]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//巨细胞病毒抗体测定-IgM抗体测定人数-阴性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.CMVIgM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][39]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//巨细胞病毒抗体测定-IgM抗体测定人数-阳性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.CMVIgM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][40]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//巨细胞病毒抗体测定-IgG抗体测定人数-阴性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.CMVIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][41]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//巨细胞病毒抗体测定-IgG抗体测定人数-阳性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.CMVIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][42]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//弓形体抗体测定-IgM抗体测定人数-阴性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgGM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.TOXIgGM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][43]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//弓形体抗体测定-IgM抗体测定人数-阳性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgGM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.TOXIgGM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][44]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//弓形体抗体测定-IgG抗体测定人数-阴性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.TOXIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][45]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//弓形体抗体测定-IgG抗体测定人数-阳性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.TOXIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][46]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//妇科超声常规检查人数-正常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.BC='正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.BC='正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][47]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//妇科超声常规检查人数-异常(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.BC<>'正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.BC<>'正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][48]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//孕前医学检查-合计(镇级农村夫妇)
		nTotalCount=0;
		for(int i=9;i<49;i++)
		{
			nTemp=Integer.parseInt(strItemCount[1][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[1][8]=String.valueOf(nTotalCount);
		
		//评估为高风险的人数-男性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Told<>'1' and C.MCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Told<>'1' and C.MCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][50]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//评估为高风险的人数-女性(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Told<>'1' and C.WCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Told<>'1' and C.WCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][51]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//评估为高风险的人数-合计(镇级农村夫妇)
		strItemCount[1][49]=String.valueOf(Integer.parseInt(strItemCount[1][50])+Integer.parseInt(strItemCount[1][51]));
		
		//咨询指导人次(包括一般人群和高风险的人群)(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][52]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//早孕随访人次(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN EarlyPregnancyVisit AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN EarlyPregnancyVisit AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][53]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//妊娠结局随访人次(镇级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][54]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		
		//**************************************************************************************************************
		//镇级机构服务数量-城镇夫妇
		//本年度计划怀孕夫妇人数(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo where PregnantTimeExpected between '" + strYearBegin + "' and '" + strYearEnd + "' and MDomicile='2' and MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1')";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo where PregnantTimeExpected between '" + strYearBegin + "' and '" + strYearEnd + "' and MDomicile='2' and stuffId in (select SID from OSStuff where town <>'-1')";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][0]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//检查人数-男性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MCsID>-1";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.stuffId in (select SID from OSStuff where town <>'-1') and B.MCsID>-1";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][2]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//检查人数-女性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.WCsID >-1";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.stuffId in (select SID from OSStuff where town <>'-1') and B.WCsID >-1";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][3]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//检查人数-合计(镇级城镇夫妇)
		strItemCount[0][1]=String.valueOf(Integer.parseInt(strItemCount[0][2])+Integer.parseInt(strItemCount[0][3]));
		
		//优生健康检查人次(镇级城镇夫妇)
		strItemCount[0][4]=strItemCount[0][1];
		
		//病史询问人次-男性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][6]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//病史询问人次-女性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][7]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//病史询问人次-合计(镇级城镇夫妇)
		strItemCount[0][5]=String.valueOf(Integer.parseInt(strItemCount[0][6])+Integer.parseInt(strItemCount[0][7]));
		
		//体格检查-常规体格检查人数-正常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][9]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-正常(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][9]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][9]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-异常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][10]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-异常(镇级城镇夫妇)-丈夫 
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][10]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][10]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//体格检查-生殖系统检查人数-正常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][11]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-正常(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][11]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][11]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-异常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][12]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-异常(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][12]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][12]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-白带常规检查人数-正常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][13]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-白带常规检查人数-异常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][14]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-淋球菌检查人数-正常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Gonococcus='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Gonococcus='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][15]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-淋球菌规检查人数-异常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Gonococcus<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Gonococcus<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][16]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-沙眼衣原体检查人数-正常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.ChlamydiaT='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.ChlamydiaT='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][17]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-沙眼衣原体检查人数-异常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.ChlamydiaT<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.ChlamydiaT<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][18]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//血液常规检查人数-正常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][19]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血液常规检查人数-异常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][20]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//尿液常规检查人数-正常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][21]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-正常(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][21]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][21]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-异常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][22]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-异常(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][22]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][22]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//血型检查人数-正常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][23]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-正常(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][23]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][23]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-特殊(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][24]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-特殊(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][24]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][24]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}

		//血清葡萄糖测定人数-正常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][25]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血清葡萄糖测定人数-异常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][26]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//肝功能检测人数-正常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][27]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-正常(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][27]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][27]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-异常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][28]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-异常(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][28]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][28]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//乙型肝炎血清学五项检测人数-正常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][29]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-正常(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][29]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][29]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-异常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][30]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-异常(镇级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][30]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][30]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//肾功能检测人数-正常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][31]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-正常(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][31]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][31]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-异常(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][32]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-异常(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][32]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][32]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//甲状腺功能检测人数-正常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][33]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//甲状腺功能检测人数-异常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][34]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//梅毒螺旋体筛查人数-阴性(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][35]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阴性(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][35]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][35]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阳性(镇级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][36]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阳性(镇级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][36]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][36]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//风疹病毒IgG抗体测定人数-阴性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.RuV='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.RuV='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][37]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//风疹病毒IgG抗体测定人数-阳性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.RuV<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.RuV<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][38]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//巨细胞病毒抗体测定-IgM抗体测定人数-阴性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.CMVIgM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][39]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//巨细胞病毒抗体测定-IgM抗体测定人数-阳性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.CMVIgM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][40]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//巨细胞病毒抗体测定-IgG抗体测定人数-阴性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.CMVIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][41]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//巨细胞病毒抗体测定-IgG抗体测定人数-阳性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.CMVIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][42]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//弓形体抗体测定-IgM抗体测定人数-阴性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgGM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.TOXIgGM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][43]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//弓形体抗体测定-IgM抗体测定人数-阳性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgGM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.TOXIgGM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][44]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//弓形体抗体测定-IgG抗体测定人数-阴性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.TOXIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][45]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//弓形体抗体测定-IgG抗体测定人数-阳性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.TOXIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][46]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//妇科超声常规检查人数-正常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and ='正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.BC='正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][47]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//妇科超声常规检查人数-异常(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.BC<>'正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.BC<>'正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][48]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//孕前医学检查-合计(镇级城镇夫妇)
		nTotalCount=0;
		for(int i=9;i<49;i++)
		{
			nTemp=Integer.parseInt(strItemCount[0][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[0][8]=String.valueOf(nTotalCount);
		
		//评估为高风险的人数-男性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Told<>'1' and C.MCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Told<>'1' and C.MCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][50]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//评估为高风险的人数-女性(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Told<>'1' and C.WCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Told<>'1' and C.WCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][51]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//评估为高风险的人数-合计(镇级城镇夫妇)
		strItemCount[0][49]=String.valueOf(Integer.parseInt(strItemCount[0][50])+Integer.parseInt(strItemCount[0][51]));
		
		//咨询指导人次(包括一般人群和高风险的人群)(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][52]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//早孕随访人次(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN EarlyPregnancyVisit AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN EarlyPregnancyVisit AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][53]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//妊娠结局随访人次(镇级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town <>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][54]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		
		//*************************************************************************************************
		//镇级机构服务数量-总计
		for(int i=0;i<55;i++)
		{
			strItemCount[2][i]=String.valueOf(Integer.parseInt(strItemCount[0][i])+Integer.parseInt(strItemCount[1][i]));
		}
		
		
		//**************************************************************************************************************
		//县级机构服务数量-农村夫妇
		//本年度计划怀孕夫妇人数(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo where PregnantTimeExpected between '" + strYearBegin + "' and '" + strYearEnd + "' and MDomicile='1' and MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1')";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo where PregnantTimeExpected between '" + strYearBegin + "' and '" + strYearEnd + "' and MDomicile='1' and stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1')";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][0]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//检查人数-男性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.MCsID>-1";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.MCsID>-1";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][2]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//检查人数-女性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.WCsID >-1";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.WCsID >-1";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][3]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//检查人数-合计(县级农村夫妇)
		strItemCount[4][1]=String.valueOf(Integer.parseInt(strItemCount[4][2])+Integer.parseInt(strItemCount[4][3]));
		
		//优生健康检查人次(县级农村夫妇)
		strItemCount[4][4]=strItemCount[4][1];
		
		//病史询问人次-男性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][6]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//病史询问人次-女性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][7]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//病史询问人次-合计(县级农村夫妇)
		strItemCount[4][5]=String.valueOf(Integer.parseInt(strItemCount[4][6])+Integer.parseInt(strItemCount[4][7]));
		
		//体格检查-常规体格检查人数-正常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][9]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-正常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][9]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][9]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-异常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][10]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-异常(县级农村夫妇)-丈夫 
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][10]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][10]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//体格检查-生殖系统检查人数-正常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][11]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-正常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][11]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][11]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-异常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][12]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-异常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][12]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][12]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-白带常规检查人数-正常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][13]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-白带常规检查人数-异常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][14]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-淋球菌检查人数-正常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Gonococcus='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Gonococcus='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][15]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-淋球菌规检查人数-异常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Gonococcus<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Gonococcus<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][16]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-沙眼衣原体检查人数-正常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.ChlamydiaT='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.ChlamydiaT='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][17]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-沙眼衣原体检查人数-异常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.ChlamydiaT<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.ChlamydiaT<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][18]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//血液常规检查人数-正常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][19]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血液常规检查人数-异常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][20]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//尿液常规检查人数-正常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][21]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-正常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][21]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][21]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-异常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][22]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-异常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][22]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][22]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//血型检查人数-正常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][23]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-正常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][23]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][23]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-特殊(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][24]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-特殊(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][24]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][24]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}

		//血清葡萄糖测定人数-正常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][25]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血清葡萄糖测定人数-异常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][26]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//肝功能检测人数-正常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][27]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-正常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][27]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][27]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-异常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][28]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-异常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][28]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][28]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//乙型肝炎血清学五项检测人数-正常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][29]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-正常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][29]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][29]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-异常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][30]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-异常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][30]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][30]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//肾功能检测人数-正常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][31]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-正常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][31]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][31]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-异常(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][32]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-异常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][32]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][32]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//甲状腺功能检测人数-正常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][33]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//甲状腺功能检测人数-异常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][34]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//梅毒螺旋体筛查人数-阴性(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][35]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阴性(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][35]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][35]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阳性(县级农村夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][36]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阳性(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][36]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[4][36]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//风疹病毒IgG抗体测定人数-阴性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.RuV='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.RuV='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][37]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//风疹病毒IgG抗体测定人数-阳性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.RuV<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.RuV<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][38]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//巨细胞病毒抗体测定-IgM抗体测定人数-阴性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.CMVIgM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.CMVIgM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][39]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//巨细胞病毒抗体测定-IgM抗体测定人数-阳性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.CMVIgM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.CMVIgM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][40]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//巨细胞病毒抗体测定-IgG抗体测定人数-阴性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.CMVIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.CMVIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][41]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//巨细胞病毒抗体测定-IgG抗体测定人数-阳性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.CMVIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.CMVIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][42]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//弓形体抗体测定-IgM抗体测定人数-阴性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.TOXIgGM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.TOXIgGM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][43]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//弓形体抗体测定-IgM抗体测定人数-阳性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.TOXIgGM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.TOXIgGM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][44]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//弓形体抗体测定-IgG抗体测定人数-阴性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.TOXIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.TOXIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][45]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//弓形体抗体测定-IgG抗体测定人数-阳性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.TOXIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.TOXIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][46]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//妇科超声常规检查人数-正常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.BC='正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.BC='正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][47]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//妇科超声常规检查人数-异常(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.BC<>'正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.BC<>'正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][48]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//孕前医学检查-合计(县级农村夫妇)
		nTotalCount=0;
		for(int i=9;i<49;i++)
		{
			nTemp=Integer.parseInt(strItemCount[4][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[4][8]=String.valueOf(nTotalCount);
		
		//评估为高风险的人数-男性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Told<>'1' and C.MCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Told<>'1' and C.MCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][50]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//评估为高风险的人数-女性(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Told<>'1' and C.WCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Told<>'1' and C.WCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][51]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//评估为高风险的人数-合计(县级农村夫妇)
		strItemCount[4][49]=String.valueOf(Integer.parseInt(strItemCount[4][50])+Integer.parseInt(strItemCount[4][51]));
		
		//咨询指导人次(包括一般人群和高风险的人群)(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][52]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//早孕随访人次(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN EarlyPregnancyVisit AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN EarlyPregnancyVisit AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][53]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//妊娠结局随访人次(县级农村夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][54]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		
		//**************************************************************************************************************
		//县级机构服务数量-城镇夫妇
		//本年度计划怀孕夫妇人数(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo where PregnantTimeExpected between '" + strYearBegin + "' and '" + strYearEnd + "' and MDomicile='2' and MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1')";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo where PregnantTimeExpected between '" + strYearBegin + "' and '" + strYearEnd + "' and MDomicile='2' and stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1')";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][0]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//检查人数-男性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.MCsID>-1";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.MCsID>-1";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][2]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//检查人数-女性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.WCsID >-1";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.WCsID >-1";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][3]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//检查人数-合计(县级城镇夫妇)
		strItemCount[3][1]=String.valueOf(Integer.parseInt(strItemCount[3][2])+Integer.parseInt(strItemCount[3][3]));
		
		//优生健康检查人次(县级城镇夫妇)
		strItemCount[3][4]=strItemCount[3][1];
		
		//病史询问人次-男性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][6]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//病史询问人次-女性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeGeneralDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.EnquireDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][7]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//病史询问人次-合计(县级城镇夫妇)
		strItemCount[3][5]=String.valueOf(Integer.parseInt(strItemCount[3][6])+Integer.parseInt(strItemCount[3][7]));
		
		//体格检查-常规体格检查人数-正常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][9]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-正常(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][9]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][9]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-异常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][10]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-常规体格检查人数-异常(县级城镇夫妇)-丈夫 
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyGeneral AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][10]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][10]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//体格检查-生殖系统检查人数-正常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][11]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-正常(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][11]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][11]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-异常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][12]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//体格检查-生殖系统检查人数-异常(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBodyDoc AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][12]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][12]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-白带常规检查人数-正常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][13]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-白带常规检查人数-异常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][14]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-淋球菌检查人数-正常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Gonococcus='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Gonococcus='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][15]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-淋球菌规检查人数-异常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Gonococcus<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Gonococcus<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][16]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//阴道分泌物检查-沙眼衣原体检查人数-正常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.ChlamydiaT='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.ChlamydiaT='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][17]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//阴道分泌物检查-沙眼衣原体检查人数-异常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.ChlamydiaT<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.ChlamydiaT<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][18]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//血液常规检查人数-正常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][19]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血液常规检查人数-异常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][20]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//尿液常规检查人数-正常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][21]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-正常(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][21]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][21]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-异常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][22]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-异常(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][22]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][22]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//血型检查人数-正常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][23]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-正常(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][23]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][23]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-特殊(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][24]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-特殊(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][24]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][24]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}

		//血清葡萄糖测定人数-正常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][25]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血清葡萄糖测定人数-异常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][26]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//肝功能检测人数-正常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][27]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-正常(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][27]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][27]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-异常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][28]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能检测人数-异常(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][28]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][28]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//乙型肝炎血清学五项检测人数-正常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][29]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-正常(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][29]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][29]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-异常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][30]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-异常(县级农村夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][30]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][30]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//肾功能检测人数-正常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][31]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-正常(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][31]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][31]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-异常(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][32]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-异常(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][32]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][32]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//甲状腺功能检测人数-正常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][33]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//甲状腺功能检测人数-异常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][34]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//梅毒螺旋体筛查人数-阴性(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][35]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阴性(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][35]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][35]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阳性(县级城镇夫妇)-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][36]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查人数-阳性(县级城镇夫妇)-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][36]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[3][36]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//风疹病毒IgG抗体测定人数-阴性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.RuV='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.RuV='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][37]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//风疹病毒IgG抗体测定人数-阳性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.RuV<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.RuV<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][38]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//巨细胞病毒抗体测定-IgM抗体测定人数-阴性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.CMVIgM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.CMVIgM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][39]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//巨细胞病毒抗体测定-IgM抗体测定人数-阳性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.CMVIgM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.CMVIgM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][40]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//巨细胞病毒抗体测定-IgG抗体测定人数-阴性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.CMVIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.CMVIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][41]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//巨细胞病毒抗体测定-IgG抗体测定人数-阳性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.CMVIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.CMVIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][42]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//弓形体抗体测定-IgM抗体测定人数-阴性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.TOXIgGM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.TOXIgGM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][43]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//弓形体抗体测定-IgM抗体测定人数-阳性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.TOXIgGM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.TOXIgGM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][44]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//弓形体抗体测定-IgG抗体测定人数-阴性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.TOXIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.TOXIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][45]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//弓形体抗体测定-IgG抗体测定人数-阳性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.TOXIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.TOXIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][46]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//妇科超声常规检查人数-正常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.BC='正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.BC='正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][47]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//妇科超声常规检查人数-异常(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.BC<>'正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WomanBC AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.BC<>'正常' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][48]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//孕前医学检查-合计(县级城镇夫妇)
		nTotalCount=0;
		for(int i=9;i<49;i++)
		{
			nTemp=Integer.parseInt(strItemCount[3][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[3][8]=String.valueOf(nTotalCount);
		
		//评估为高风险的人数-男性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Told<>'1' and C.MCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Told<>'1' and C.MCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][50]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//评估为高风险的人数-女性(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Told<>'1' and C.WCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID INNER JOIN FamiliRecord AS C ON B.RecordID=C.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Told<>'1' and C.WCsID>-1 and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][51]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//评估为高风险的人数-合计(县级城镇夫妇)
		strItemCount[3][49]=String.valueOf(Integer.parseInt(strItemCount[3][50])+Integer.parseInt(strItemCount[3][51]));
		
		//咨询指导人次(包括一般人群和高风险的人群)(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN Notify AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.DDate between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][52]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//早孕随访人次(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN EarlyPregnancyVisit AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN EarlyPregnancyVisit AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][53]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//妊娠结局随访人次(县级城镇夫妇)
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town ='-1' and Prefecture<>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.stuffId in (select SID from OSStuff where town ='-1' and Prefecture<>'-1') and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][54]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		
		//*************************************************************************************************
		//县级机构服务数量-总计
		for(int i=0;i<55;i++)
		{
			strItemCount[5][i]=String.valueOf(Integer.parseInt(strItemCount[3][i])+Integer.parseInt(strItemCount[4][i]));
		}
		
		
		//*********************************************************************************************************
		//总计
		for(int i=0;i<55;i++)
		{
			//总计-农村夫妇
			strItemCount[7][i]=String.valueOf(Integer.parseInt(strItemCount[1][i])+Integer.parseInt(strItemCount[4][i]));
			//总计-城镇夫妇
			strItemCount[6][i]=String.valueOf(Integer.parseInt(strItemCount[0][i])+Integer.parseInt(strItemCount[3][i]));
			//总计-合计
			strItemCount[8][i]=String.valueOf(Integer.parseInt(strItemCount[2][i])+Integer.parseInt(strItemCount[5][i]));
		}	
		
		return strItemCount;
	}
	
	/*
	 * 获取国家优生项目妊娠结局月统计报表
	 */
	public String[][] getPregnancyResultReport(String strBeginDate,String strEndDate)
	{
		int nTotalCount,nTemp;
		String[][] strItemCount= new String[6][17];
		String strTempSQL;
		
		//===============================================================================================================//
		//未接受免费孕前检查(农村妇女)-分娩及终止妊娠人数
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][0]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//未接受免费孕前检查(农村妇女)-正常活产儿人数-男
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 1, 1)='1' and SUBSTRING(B.FetalSex, 1, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][3]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(农村妇女)-正常活产儿人数-女
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 1, 1)='1' and SUBSTRING(B.FetalSex, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][4]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(农村妇女)-正常活产儿人数-合计
		strItemCount[1][2]=String.valueOf(Integer.parseInt(strItemCount[1][3])+Integer.parseInt(strItemCount[1][4]));
		
		//未接受免费孕前检查(农村妇女)-新生儿早产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][5]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//未接受免费孕前检查(农村妇女)-新生儿低出生体重
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 5, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][6]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//未接受免费孕前检查(农村妇女)-出生缺陷儿人数-男
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 7, 1)='1' and SUBSTRING(B.FetalSex, 1, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][8]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(农村妇女)-出生缺陷儿人数-女
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 7, 1)='1' and SUBSTRING(B.FetalSex, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][9]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(农村妇女)-出生缺陷儿人数-合计
		strItemCount[1][7]=String.valueOf(Integer.parseInt(strItemCount[1][8])+Integer.parseInt(strItemCount[1][9]));
		
		//未接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-自然流产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 9, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][11]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-医学性人工流产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 11, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][12]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-治疗性引产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 13, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][13]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-异位妊娠
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 15, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][14]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-死胎死产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 17, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][15]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-其它
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 19, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[1][16]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-合计
		nTotalCount=0;
		for(int i=11;i<17;i++)
		{
			nTemp=Integer.parseInt(strItemCount[1][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[1][10]=String.valueOf(nTotalCount);
		
		//未接受免费孕前检查(农村妇女)-妊娠结局随访-合计
		nTotalCount=0;
		for(int i=3;i<17;i++)
		{
			if(i==7 ||i==10)
			{
				continue;
			}
			nTemp=Integer.parseInt(strItemCount[1][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[1][1]=String.valueOf(nTotalCount);
		
		//===============================================================================================================//
		//未接受免费孕前检查(城镇妇女)-分娩及终止妊娠人数
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][0]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//未接受免费孕前检查(城镇妇女)-正常活产儿人数-男
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 1, 1)='1' and SUBSTRING(B.FetalSex, 1, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][3]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(城镇妇女)-正常活产儿人数-女
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 1, 1)='1' and SUBSTRING(B.FetalSex, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][4]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(城镇妇女)-正常活产儿人数-合计
		strItemCount[0][2]=String.valueOf(Integer.parseInt(strItemCount[0][3])+Integer.parseInt(strItemCount[0][4]));
		
		//未接受免费孕前检查(城镇妇女)-新生儿早产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][5]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//未接受免费孕前检查(城镇妇女)-新生儿低出生体重
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 5, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][6]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//未接受免费孕前检查(城镇妇女)-出生缺陷儿人数-男
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 7, 1)='1' and SUBSTRING(B.FetalSex, 1, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][8]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(城镇妇女)-出生缺陷儿人数-女
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 7, 1)='1' and SUBSTRING(B.FetalSex, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][9]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(城镇妇女)-出生缺陷儿人数-合计
		strItemCount[0][7]=String.valueOf(Integer.parseInt(strItemCount[0][8])+Integer.parseInt(strItemCount[0][9]));
		
		//未接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-自然流产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 9, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][11]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-医学性人工流产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 11, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][12]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-治疗性引产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 13, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][13]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-异位妊娠
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 15, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][14]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-死胎死产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 17, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][15]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-其它
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID not in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 19, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][16]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//未接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-合计
		nTotalCount=0;
		for(int i=11;i<17;i++)
		{
			nTemp=Integer.parseInt(strItemCount[0][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[0][10]=String.valueOf(nTotalCount);
		
		//未接受免费孕前检查(城镇妇女)-妊娠结局随访-合计
		nTotalCount=0;
		for(int i=3;i<17;i++)
		{
			if(i==7 ||i==10)
			{
				continue;
			}
			nTemp=Integer.parseInt(strItemCount[0][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[0][1]=String.valueOf(nTotalCount);
		
		//未接受免费孕前检查-总计
		nTotalCount=0;
		for(int i=0;i<17;i++)
		{
			nTotalCount=Integer.parseInt(strItemCount[0][i])+Integer.parseInt(strItemCount[1][i]);
			strItemCount[2][i]=String.valueOf(nTotalCount);
		}
		

		//===============================================================================================================//
		//接受免费孕前检查(农村妇女)-分娩及终止妊娠人数
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][0]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//接受免费孕前检查(农村妇女)-正常活产儿人数-男
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 1, 1)='1' and SUBSTRING(B.FetalSex, 1, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][3]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(农村妇女)-正常活产儿人数-女
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 1, 1)='1' and SUBSTRING(B.FetalSex, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][4]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(农村妇女)-正常活产儿人数-合计
		strItemCount[4][2]=String.valueOf(Integer.parseInt(strItemCount[4][3])+Integer.parseInt(strItemCount[4][4]));
		
		//接受免费孕前检查(农村妇女)-新生儿早产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][5]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//接受免费孕前检查(农村妇女)-新生儿低出生体重
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 5, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][6]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//接受免费孕前检查(农村妇女)-出生缺陷儿人数-男
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 7, 1)='1' and SUBSTRING(B.FetalSex, 1, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][8]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(农村妇女)-出生缺陷儿人数-女
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 7, 1)='1' and SUBSTRING(B.FetalSex, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][9]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(农村妇女)-出生缺陷儿人数-合计
		strItemCount[4][7]=String.valueOf(Integer.parseInt(strItemCount[4][8])+Integer.parseInt(strItemCount[4][9]));
		
		//接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-自然流产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 9, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][11]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-医学性人工流产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 11, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][12]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-治疗性引产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 13, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][13]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-异位妊娠
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 15, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][14]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-死胎死产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 17, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][15]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-其它
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 19, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[4][16]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(农村妇女)-其它不良妊娠结局数量-合计
		nTotalCount=0;
		for(int i=11;i<17;i++)
		{
			nTemp=Integer.parseInt(strItemCount[4][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[4][10]=String.valueOf(nTotalCount);
		
		//接受免费孕前检查(农村妇女)-妊娠结局随访-合计
		nTotalCount=0;
		for(int i=3;i<17;i++)
		{
			if(i==7 ||i==10)
			{
				continue;
			}
			nTemp=Integer.parseInt(strItemCount[4][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[4][1]=String.valueOf(nTotalCount);
		
		//===============================================================================================================//
		//接受免费孕前检查(城镇妇女)-分娩及终止妊娠人数
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][0]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//接受免费孕前检查(城镇妇女)-正常活产儿人数-男
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 1, 1)='1' and SUBSTRING(B.FetalSex, 1, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][3]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(城镇妇女)-正常活产儿人数-女
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 1, 1)='1' and SUBSTRING(B.FetalSex, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][4]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(城镇妇女)-正常活产儿人数-合计
		strItemCount[3][2]=String.valueOf(Integer.parseInt(strItemCount[3][3])+Integer.parseInt(strItemCount[3][4]));
		
		//接受免费孕前检查(城镇妇女)-新生儿早产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][5]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//接受免费孕前检查(城镇妇女)-新生儿低出生体重
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 5, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][6]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//接受免费孕前检查(城镇妇女)-出生缺陷儿人数-男
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 7, 1)='1' and SUBSTRING(B.FetalSex, 1, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][8]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(城镇妇女)-出生缺陷儿人数-女
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 7, 1)='1' and SUBSTRING(B.FetalSex, 3, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][9]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(城镇妇女)-出生缺陷儿人数-合计
		strItemCount[3][7]=String.valueOf(Integer.parseInt(strItemCount[3][8])+Integer.parseInt(strItemCount[3][9]));
		
		//接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-自然流产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 9, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][11]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-医学性人工流产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 11, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][12]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-治疗性引产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 13, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][13]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-异位妊娠
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 15, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][14]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-死胎死产
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 17, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][15]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-其它
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN PregnancyResult AS B ON A.RecordID = B.RecordID where A.MDomicile='2' and B.RecordID in (select RecordID from Notify) and SUBSTRING(B.Pregnancy, 19, 1)='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[3][16]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//接受免费孕前检查(城镇妇女)-其它不良妊娠结局数量-合计
		nTotalCount=0;
		for(int i=11;i<17;i++)
		{
			nTemp=Integer.parseInt(strItemCount[3][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[3][10]=String.valueOf(nTotalCount);
		
		//接受免费孕前检查(城镇妇女)-妊娠结局随访-合计
		nTotalCount=0;
		for(int i=3;i<17;i++)
		{
			if(i==7 ||i==10)
			{
				continue;
			}
			nTemp=Integer.parseInt(strItemCount[3][i]);
			nTotalCount+=nTemp;
		}
		strItemCount[3][1]=String.valueOf(nTotalCount);
		
		//接受免费孕前检查-总计
		nTotalCount=0;
		for(int i=0;i<17;i++)
		{
			nTotalCount=Integer.parseInt(strItemCount[3][i])+Integer.parseInt(strItemCount[4][i]);
			strItemCount[5][i]=String.valueOf(nTotalCount);
		}
		
		return strItemCount;
	}
	
	/*
	 * 根据身份证号获取网站或触摸屏填写的一般情况内容
	 */
	public String getGeneralByCardID(String strCardID)
	{
		String strGeneral="";
		String strTempSQL="select content from WifeGeneralSelfInfo where identityCardNo = '" + strCardID +"'";
		try
		{
			List list =null;
			SQLQuery query= super.getSession().createSQLQuery(strTempSQL).addScalar("content", Hibernate.STRING);
			list=query.list();
			if(list.size()>0)
			{
				strGeneral=list.get(0).toString();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return strGeneral;
	}
	
	/*
	 * 根据身份证号删除网站或触摸屏填写的一般情况内容
	 */
	public boolean delGeneralByCardID(String strCardID)
	{
		boolean bDel=false;
		String strTempSQL="delete from WifeGeneralSelfInfo where identityCardNo = '" + strCardID +"'";
		try
		{
			SQLQuery query=super.getSession().createSQLQuery(strTempSQL);
			int nCount = query.executeUpdate();
			if(nCount>0)
			{
				bDel=true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bDel;
	}
	
	/*
	 * 获取国家免费孕前优生健康检查统计报表
	 */
	public String[][] getCheckItemStatReport(String strBeginDate,String strEndDate)
	{
		int nTotalCount,nTemp;
		String[][] strItemCount= new String[1][38];
		String strTempSQL;		
		//**************************************************************************************************************
				
		//检查人数-男性
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and B.MCsID>-1";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][1]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//检查人数-女性
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and A.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.WCsID >-1";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN FamiliRecord AS B ON A.RecordID = B.RecordID where A.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "' and B.WCsID>-1";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][2]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//检查人数-合计
		strItemCount[0][0]=String.valueOf(Integer.parseInt(strItemCount[0][1])+Integer.parseInt(strItemCount[0][2]));
		
		//合格标本数
		strItemCount[0][3]="";
		
		//白带常规检查人数-正常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][4]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//白带常规检查人数-异常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][5]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//淋球菌检查人数-正常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Gonococcus='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where B.Gonococcus='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][6]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//淋球菌规检查人数-异常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Gonococcus<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where B.Gonococcus<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][7]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//沙眼衣原体(CT)检查人数-正常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.ChlamydiaT='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where B.ChlamydiaT='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][8]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//沙眼衣原体(CT)检查人数-异常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.ChlamydiaT<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN LeucorrheaTest AS B ON A.RecordID = B.RecordID where B.ChlamydiaT<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][9]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//血液常规检查人数-正常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][10]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血液常规检查人数-异常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN BloodCellTest AS B ON A.RecordID = B.RecordID where B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][11]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//尿液常规检查人数-正常-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][12]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-正常-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where B.Results='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][12]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][12]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-异常-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeRoutineUrine AS B ON A.RecordID = B.RecordID where B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][13]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//尿液常规检查人数-异常-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusRoutineUrine AS B ON A.RecordID = B.RecordID where B.Results<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][13]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][13]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//血型检查人数-正常-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][14]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-正常-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where B.Rh='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][14]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][14]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-特殊-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodGroup AS B ON A.RecordID = B.RecordID where B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][15]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血型检查人数-特殊-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusBloodGroup AS B ON A.RecordID = B.RecordID where B.Rh='1' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][15]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][15]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}

		//血清葡萄糖测定人数-正常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][16]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//血清葡萄糖测定人数-异常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeBloodSuger AS B ON A.RecordID = B.RecordID where B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][17]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//肝功能(ALT)检测人数-正常-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][18]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能(ALT)检测人数-正常-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where B.liverIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][18]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][18]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能(ALT)检测人数-异常-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][19]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肝功能(ALT)检测人数-异常-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where B.liverIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][19]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][19]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//乙型肝炎血清学五项检测人数-正常-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][20]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-正常-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][20]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][20]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-异常-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeHepatitisB AS B ON A.RecordID = B.RecordID where B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][21]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//乙型肝炎血清学五项检测人数-异常-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusHepatitisB AS B ON A.RecordID = B.RecordID where B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][21]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][21]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//肾功能检测人数-正常-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][22]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-正常-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where B.kidneyIsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][22]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][22]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-异常-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN WifeLiverAndKidney AS B ON A.RecordID = B.RecordID where B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][23]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//肾功能检测人数-异常-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusLiverAndKidney AS B ON A.RecordID = B.RecordID where B.kidneyIsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][23]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][23]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//甲状腺(TSH)功能检测人数-正常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where B.IsNormal =1 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][24]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//甲状腺(TSH)功能检测人数-异常
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN ThyroidGlandTest AS B ON A.RecordID = B.RecordID where B.IsNormal =0 and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][25]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//梅毒螺旋体筛查(TP)人数-阴性-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][26]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查(TP)人数-阴性-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where B.MDLXTSC='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][26]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][26]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查(TP)人数-阳性-妻子
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][27]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//梅毒螺旋体筛查(TP)人数-阳性-丈夫
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN HusSyphilis AS B ON A.RecordID = B.RecordID where B.MDLXTSC<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][27]=String.valueOf(Integer.parseInt(list.get(0).toString()) + Integer.parseInt(strItemCount[0][27]));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//风疹病毒IgG抗体(RVIgG)测定人数-阴性
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.RuV='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.RuV='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][28]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//风疹病毒IgG抗体(RVIgG)测定人数-阳性
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.RuV<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.RuV<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][29]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//巨细胞病毒抗体测定(CMV)-IgM抗体测定人数-阴性
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.CMVIgM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][30]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//巨细胞病毒抗体测定(CMV)-IgM抗体测定人数-阳性
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.CMVIgM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][31]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//巨细胞病毒抗体测定(CMV)-IgG抗体测定人数-阴性
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.CMVIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][32]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//巨细胞病毒抗体测定(CMV)-IgG抗体测定人数-阳性
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.CMVIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.CMVIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][33]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//弓形体抗体测定(TOXO)-IgM抗体测定人数-阴性
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgGM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.TOXIgGM='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][34]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//弓形体抗体测定(TOXO)-IgM抗体测定人数-阳性
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgGM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.TOXIgGM<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][35]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		//弓形体抗体测定(TOXO)-IgG抗体测定人数-阴性
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.TOXIgG='0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][36]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		//弓形体抗体测定(TOXO)-IgG抗体测定人数-阳性
		//strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where A.MDomicile='1' and B.MedicalInstID in (select MedicalInstID from OSMedicalInstInfo where town <>'-1') and B.TOXIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		strTempSQL="SELECT COUNT(*) FROM FamiliRecordBasicInfo AS A INNER JOIN TORCHAndSyphilis AS B ON A.RecordID = B.RecordID where B.TOXIgG<>'0' and B.Date between '" + strBeginDate + "' and '" + strEndDate + "'";
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list=query.list();
			strItemCount[0][37]=list.get(0).toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return strItemCount;
		}
		
		return strItemCount;
	}
	
	/*
	 * 获取乡镇人数统计报表
	 */
	public String[][] getTownPeopleCountReport(String strBeginDate,String strEndDate,String strPreviousCode)
	{
		int nTotalCount,nTemp;
		String[][] strItemCount= new String[0][0];
		String strTempSQL;
		strTempSQL = "SELECT 乡镇名称=A.TownName," +
			"检查人数=(SELECT COUNT(C.RecordID) FROM CSConsumer as B INNER JOIN FamiliRecord AS C ON B.CsID=C.WCSID INNER JOIN FamiliRecordBasicInfo AS D on C.RecordID=D.RecordID  where B.Prefecture =A.PrefectureID AND B.Town=A.TownID AND D.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "') + (SELECT COUNT(C.RecordID) FROM CSConsumer as B INNER JOIN FamiliRecord AS C ON B.CsID=C.MCSID INNER JOIN FamiliRecordBasicInfo AS D on C.RecordID=D.RecordID  where B.Prefecture =A.PrefectureID AND B.Town=A.TownID AND D.WrittenDate between '" + strBeginDate + "' and '" + strEndDate + "')," +
			"'' as 备注  from CFTown as A WHERE A.PrefectureID = " + strPreviousCode;
		try
		{
			SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
			List list = query.list();
			if(list.size()>0)
			{
				int nColCount = ((Object[])list.get(0)).length;
				strItemCount = new String[list.size()][nColCount];
				for(int i=0;i<list.size();i++)
				{
					for(int j=0;j<nColCount;j++)
					strItemCount[i][j]=String.valueOf(((Object[]) list.get(i))[j]);
				}
			}			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return strItemCount;
	}
	
}
