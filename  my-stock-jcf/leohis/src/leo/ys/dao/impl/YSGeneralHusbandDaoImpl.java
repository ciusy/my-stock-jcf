/**
 * 
 */
package leo.ys.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.entity.HusBloodGroup;
import leo.entity.HusBodyDoc;
import leo.entity.HusBodyGeneral;
import leo.entity.HusClinicalOthers;
import leo.entity.HusGeneralDoc;
import leo.entity.HusGeneralSelf;
import leo.entity.HusHepatitisB;
import leo.entity.HusLiverAndKidney;
import leo.entity.HusOthersTest;
import leo.entity.HusRoutineUrine;
import leo.entity.HusSyphilis;
import leo.entity.WifeBloodGroup;
import leo.ys.dao.iface.YSGeneralHusbandDao;

/**
 * @author Administrator
 *
 */
public class YSGeneralHusbandDaoImpl extends HibernateDaoSupport implements YSGeneralHusbandDao {

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#addHusBloodGroup(leo.entity.HusBloodGroup)
	 */
	public boolean addHusBloodGroup(HusBloodGroup hbg) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(hbg);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#addHusBodyGeneral(leo.entity.HusBodyGeneral)
	 */
	public boolean addHusBodyGeneral(HusBodyGeneral hbg) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(hbg);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#addHusClinicalOthers(leo.entity.HusClinicalOthers)
	 */
	public boolean addHusClinicalOthers(HusClinicalOthers hco) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(hco);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#addHusGeneralDoc(leo.entity.HusGeneralDoc)
	 */
	public boolean addHusGeneralDoc(HusGeneralDoc hgd) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(hgd);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#addHusGeneralSelf(leo.entity.HusGeneralSelf)
	 */
	public boolean addHusGeneralSelf(HusGeneralSelf hgs) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(hgs);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#addHusHepatitisB(leo.entity.HusHepatitisB)
	 */
	public boolean addHusHepatitisB(HusHepatitisB hhb) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(hhb);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#addHusHusBodyDoc(leo.entity.HusBodyDoc)
	 */
	public boolean addHusBodyDoc(HusBodyDoc hbd) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(hbd);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#addHusLiverAndKidney(leo.entity.HusLiverAndKidney)
	 */
	public boolean addHusLiverAndKidney(HusLiverAndKidney hlk) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(hlk);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#addHusOthersTest(leo.entity.HusOthersTest)
	 */
	public boolean addHusOthersTest(HusOthersTest hot) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(hot);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#addHusRoutineUrine(leo.entity.HusRoutineUrine)
	 */
	public boolean addHusRoutineUrine(HusRoutineUrine hru) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(hru);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#addHusSyphilis(leo.entity.HusSyphilis)
	 */
	public boolean addHusSyphilis(HusSyphilis hs) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(hs);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#deleteHusBloodGroup(java.lang.String)
	 */
	public boolean deleteHusBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM HusBloodGroup WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#deleteHusBodyGeneral(java.lang.String)
	 */
	public boolean deleteHusBodyGeneral(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM HusBodyGeneral WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#deleteHusClinicalOthers(java.lang.String)
	 */
	public boolean deleteHusClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM HusClinicalOthers WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#deleteHusGeneralDoc(java.lang.String)
	 */
	public boolean deleteHusGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM HusGeneralDoc WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#deleteHusGeneralSelf(java.lang.String)
	 */
	public boolean deleteHusGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM HusGeneralSelf WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#deleteHusHepatitisB(java.lang.String)
	 */
	public boolean deleteHusHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM HusHepatitisB WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#deleteHusHusBodyDoc(java.lang.String)
	 */
	public boolean deleteHusBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM HusBodyDoc WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#deleteHusLiverAndKidney(java.lang.String)
	 */
	public boolean deleteHusLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM HusLiverAndKidney WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#deleteHusOthersTest(java.lang.String)
	 */
	public boolean deleteHusOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM HusOthersTest WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#deleteHusRoutineUrine(java.lang.String)
	 */
	public boolean deleteHusRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM HusRoutineUrine WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#deleteHusSyphilis(java.lang.String)
	 */
	public boolean deleteHusSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM HusSyphilis WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#existHusBloodGroup(java.lang.String)
	 */
	public boolean existHusBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from HusBloodGroup where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#existHusBodyGeneral(java.lang.String)
	 */
	public boolean existHusBodyGeneral(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from HusBodyGeneral where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#existHusClinicalOthers(java.lang.String)
	 */
	public boolean existHusClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from HusClinicalOthers where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#existHusGeneralDoc(java.lang.String)
	 */
	public boolean existHusGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from HusGeneralDoc where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#existHusGeneralSelf(java.lang.String)
	 */
	public boolean existHusGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from HusGeneralSelf where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#existHusHepatitisB(java.lang.String)
	 */
	public boolean existHusHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from HusHepatitisB where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#existHusHusBodyDoc(java.lang.String)
	 */
	public boolean existHusBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from HusBodyDoc where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#existHusLiverAndKidney(java.lang.String)
	 */
	public boolean existHusLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from HusLiverAndKidney where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#existHusOthersTest(java.lang.String)
	 */
	public boolean existHusOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from HusOthersTest where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#existHusRoutineUrine(java.lang.String)
	 */
	public boolean existHusRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from HusRoutineUrine where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#existHusSyphilis(java.lang.String)
	 */
	public boolean existHusSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from HusSyphilis where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#getHusBloodGroup(java.lang.String)
	 */
	public HusBloodGroup getHusBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		HusBloodGroup wbg = null;
		try
		{
			wbg=(HusBloodGroup)super.getHibernateTemplate().get(HusBloodGroup.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#getHusBodyGeneral(java.lang.String)
	 */
	public HusBodyGeneral getHusBodyGeneral(String strRecordID) {
		// TODO Auto-generated method stub
		HusBodyGeneral wbg = null;
		try
		{
			wbg=(HusBodyGeneral)super.getHibernateTemplate().get(HusBodyGeneral.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#getHusClinicalOthers(java.lang.String)
	 */
	public HusClinicalOthers getHusClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		HusClinicalOthers wbg = null;
		try
		{
			wbg=(HusClinicalOthers)super.getHibernateTemplate().get(HusClinicalOthers.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#getHusGeneralDoc(java.lang.String)
	 */
	public HusGeneralDoc getHusGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		HusGeneralDoc wbg = null;
		try
		{
			wbg=(HusGeneralDoc)super.getHibernateTemplate().get(HusGeneralDoc.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#getHusGeneralSelf(java.lang.String)
	 */
	public HusGeneralSelf getHusGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		HusGeneralSelf wbg = null;
		try
		{
			wbg=(HusGeneralSelf)super.getHibernateTemplate().get(HusGeneralSelf.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#getHusHepatitisB(java.lang.String)
	 */
	public HusHepatitisB getHusHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		HusHepatitisB wbg = null;
		try
		{
			wbg=(HusHepatitisB)super.getHibernateTemplate().get(HusHepatitisB.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#getHusHusBodyDoc(java.lang.String)
	 */
	public HusBodyDoc getHusBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		HusBodyDoc wbg = null;
		try
		{
			wbg=(HusBodyDoc)super.getHibernateTemplate().get(HusBodyDoc.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#getHusLiverAndKidney(java.lang.String)
	 */
	public HusLiverAndKidney getHusLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		HusLiverAndKidney wbg = null;
		try
		{
			wbg=(HusLiverAndKidney)super.getHibernateTemplate().get(HusLiverAndKidney.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#getHusOthersTest(java.lang.String)
	 */
	public HusOthersTest getHusOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		HusOthersTest wbg = null;
		try
		{
			wbg=(HusOthersTest)super.getHibernateTemplate().get(HusOthersTest.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#getHusRoutineUrine(java.lang.String)
	 */
	public HusRoutineUrine getHusRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		HusRoutineUrine wbg = null;
		try
		{
			wbg=(HusRoutineUrine)super.getHibernateTemplate().get(HusRoutineUrine.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#getHusSyphilis(java.lang.String)
	 */
	public HusSyphilis getHusSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		HusSyphilis wbg = null;
		try
		{
			wbg=(HusSyphilis)super.getHibernateTemplate().get(HusSyphilis.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#updateHusBloodGroup(leo.entity.HusBloodGroup)
	 */
	public boolean updateHusBloodGroup(HusBloodGroup hbg) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(hbg);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#updateHusBodyGeneral(leo.entity.HusBodyGeneral)
	 */
	public boolean updateHusBodyGeneral(HusBodyGeneral hbg) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(hbg);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#updateHusClinicalOthers(leo.entity.HusClinicalOthers)
	 */
	public boolean updateHusClinicalOthers(HusClinicalOthers hco) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(hco);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#updateHusGeneralDoc(leo.entity.HusGeneralDoc)
	 */
	public boolean updateHusGeneralDoc(HusGeneralDoc hgd) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(hgd);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#updateHusGeneralSelf(leo.entity.HusGeneralSelf)
	 */
	public boolean updateHusGeneralSelf(HusGeneralSelf hgs) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(hgs);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#updateHusHepatitisB(leo.entity.HusHepatitisB)
	 */
	public boolean updateHusHepatitisB(HusHepatitisB hhb) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(hhb);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#updateHusHusBodyDoc(leo.entity.HusBodyDoc)
	 */
	public boolean updateHusBodyDoc(HusBodyDoc hbd) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(hbd);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#updateHusLiverAndKidney(leo.entity.HusLiverAndKidney)
	 */
	public boolean updateHusLiverAndKidney(HusLiverAndKidney hlk) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(hlk);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#updateHusOthersTest(leo.entity.HusOthersTest)
	 */
	public boolean updateHusOthersTest(HusOthersTest hot) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(hot);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#updateHusRoutineUrine(leo.entity.HusRoutineUrine)
	 */
	public boolean updateHusRoutineUrine(HusRoutineUrine hru) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(hru);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralHusbandDao#updateHusSyphilis(leo.entity.HusSyphilis)
	 */
	public boolean updateHusSyphilis(HusSyphilis hs) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(hs);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/*
	 * 设置肝功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForHusLiverAndKidneyLiver(boolean bNormal,String strRecordID)
	{
		boolean bSuccess=false;
		String strTempSQL="";
		if(bNormal)
		{
			strTempSQL="update HusLiverAndKidney set liverIsNormal =1 where RecordID='" + strRecordID +"'";
		}
		else
		{
			strTempSQL="update HusLiverAndKidney set liverIsNormal =0 where RecordID='" + strRecordID +"'";
		}
		SQLQuery query=super.getSession().createSQLQuery(strTempSQL);
		int nCount =query.executeUpdate();
		if(nCount>0)
		{
			bSuccess=true;
		}
		return bSuccess;
	}
	
	/*
	 * 设置肾功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForHusLiverAndKidneyKidney(boolean bNormal,String strRecordID)
	{
		boolean bSuccess=false;
		String strTempSQL="";
		if(bNormal)
		{
			strTempSQL="update HusLiverAndKidney set kidneyIsNormal =1 where RecordID='" + strRecordID +"'";
		}
		else
		{
			strTempSQL="update HusLiverAndKidney set kidneyIsNormal =0 where RecordID='" + strRecordID +"'";
		}
		SQLQuery query=super.getSession().createSQLQuery(strTempSQL);
		int nCount =query.executeUpdate();
		if(nCount>0)
		{
			bSuccess=true;
		}
		return bSuccess;
	}
		
	/*
	 * 设置乙型肝炎血清学五项功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForHusHepatitisB(boolean bNormal,String strRecordID)
	{
		boolean bSuccess=false;
		String strTempSQL="";
		if(bNormal)
		{
			strTempSQL="update HusHepatitisB set IsNormal =1 where RecordID='" + strRecordID +"'";
		}
		else
		{
			strTempSQL="update HusHepatitisB set IsNormal =0 where RecordID='" + strRecordID +"'";
		}
		SQLQuery query=super.getSession().createSQLQuery(strTempSQL);
		int nCount =query.executeUpdate();
		if(nCount>0)
		{
			bSuccess=true;
		}
		return bSuccess;
	}
	
	/*
	 * 根据身份证号判断孕前检查表(丈夫)一般情况(自助检查)
	 */
	public boolean existHusGeneralSelfByCardID(String strCardID)
	{
		boolean bExist=false;
		String strTempSQL="select B.RecordID from FamiliRecord as A INNER JOIN HusGeneralSelf AS B on A.RecordID=B.RecordID WHERE A.MIDCardNum='"+strCardID+"'";
		try
		{
			List list=null;
			SQLQuery query=super.getSession().createSQLQuery(strTempSQL);
			list=query.list();
			if(list.size()>0)
			{
				bExist=true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bExist;
	}
	
	/*
	 * 根据身份证号判断孕前检查表(丈夫)一般情况(医生询问的社会心理因素)
	 */
	public boolean existHusGeneralDocByCardID(String strCardID)
	{
		boolean bExist=false;
		String strTempSQL="select B.RecordID from FamiliRecord as A INNER JOIN HusGeneralDoc AS B on A.RecordID=B.RecordID WHERE A.MIDCardNum='"+strCardID+"'";
		try
		{
			List list=null;
			SQLQuery query=super.getSession().createSQLQuery(strTempSQL);
			list=query.list();
			if(list.size()>0)
			{
				bExist=true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bExist;
	}
	
}
