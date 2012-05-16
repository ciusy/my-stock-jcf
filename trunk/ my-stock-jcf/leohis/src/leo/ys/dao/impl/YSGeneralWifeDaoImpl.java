/**
 * 
 */
package leo.ys.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.entity.BloodCellTest;
import leo.entity.LeucorrheaTest;
import leo.entity.ThyroidGlandTest;
import leo.entity.TorchandSyphilis;
import leo.entity.WifeBloodGroup;
import leo.entity.WifeBloodSuger;
import leo.entity.WifeBodyDoc;
import leo.entity.WifeBodyGeneral;
import leo.entity.WifeClinicalOthers;
import leo.entity.WifeGeneralDoc;
import leo.entity.WifeGeneralSelf;
import leo.entity.WifeHepatitisB;
import leo.entity.WifeLiverAndKidney;
import leo.entity.WifeOthersTest;
import leo.entity.WifeRoutineUrine;
import leo.entity.WomanBc;
import leo.ys.dao.iface.YSGeneralWifeDao;

/**
 * @author Administrator
 *
 */
public class YSGeneralWifeDaoImpl extends HibernateDaoSupport implements YSGeneralWifeDao {

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeBloodCellTest(leo.entity.BloodCellTest)
	 */
	public boolean addWifeBloodCellTest(BloodCellTest bct) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(bct);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeBloodGroup(leo.entity.WifeBloodGroup)
	 */
	public boolean addWifeBloodGroup(WifeBloodGroup wbg) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(wbg);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeBloodSuger(leo.entity.WifeBloodSuger)
	 */
	public boolean addWifeBloodSuger(WifeBloodSuger wbs) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(wbs);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeBodyDoc(leo.entity.WifeBodyDoc)
	 */
	public boolean addWifeBodyDoc(WifeBodyDoc wbd) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(wbd);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeBodyGerneral(leo.entity.WifeBodyGeneral)
	 */
	public boolean addWifeBodyGerneral(WifeBodyGeneral wbg) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(wbg);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeClinicalOthers(leo.entity.WifeClinicalOthers)
	 */
	public boolean addWifeClinicalOthers(WifeClinicalOthers wco) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(wco);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeGeneralDoc(leo.entity.WifeGeneralDoc)
	 */
	public boolean addWifeGeneralDoc(WifeGeneralDoc wgd) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(wgd);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeGeneralSelf(leo.entity.WifeGeneralSelf)
	 */
	public boolean addWifeGeneralSelf(WifeGeneralSelf wgs) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(wgs);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeHepatitisB(leo.entity.WifeHepatitisB)
	 */
	public boolean addWifeHepatitisB(WifeHepatitisB whb) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(whb);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeLeucorrheaTest(leo.entity.LeucorrheaTest)
	 */
	public boolean addWifeLeucorrheaTest(LeucorrheaTest lt) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(lt);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeLiverAndKidney(leo.entity.WifeLiverAndKidney)
	 */
	public boolean addWifeLiverAndKidney(WifeLiverAndKidney wlk) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(wlk);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeRoutineUrine(leo.entity.WifeRoutineUrine)
	 */
	public boolean addWifeRoutineUrine(WifeRoutineUrine wru) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(wru);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeThyroidGlandTest(leo.entity.ThyroidGlandTest)
	 */
	public boolean addWifeThyroidGlandTest(ThyroidGlandTest tgt) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(tgt);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeTorchandSyhilis(leo.entity.TorchandSyphilis)
	 */
	public boolean addWifeTorchandSyphilis(TorchandSyphilis ts) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(ts);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#addWifeWomanBC(leo.entity.WomanBc)
	 */
	public boolean addWifeWomanBC(WomanBc wbc) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(wbc);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeBloodCellTest(java.lang.String)
	 */
	public boolean deleteWifeBloodCellTest(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM BloodCellTest WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeBloodGroup(java.lang.String)
	 */
	public boolean deleteWifeBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WifeBloodGroup WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeBloodSuger(java.lang.String)
	 */
	public boolean deleteWifeBloodSuger(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WifeBloodSuger WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeBodyDoc(java.lang.String)
	 */
	public boolean deleteWifeBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WifeBodyDoc WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeBodyGerneral(java.lang.String)
	 */
	public boolean deleteWifeBodyGerneral(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WifeBodyGeneral WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeClinicalOthers(java.lang.String)
	 */
	public boolean deleteWifeClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WifeClinicalOthers WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeGeneralDoc(java.lang.String)
	 */
	public boolean deleteWifeGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WifeGeneralDoc WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeGeneralSelf(java.lang.String)
	 */
	public boolean deleteWifeGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WifeGeneralSelf WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeHepatitisB(java.lang.String)
	 */
	public boolean deleteWifeHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WifeHepatitisB WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeLeucorrheaTest(java.lang.String)
	 */
	public boolean deleteWifeLeucorrheaTest(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM LeucorrheaTest WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeLiverAndKidney(java.lang.String)
	 */
	public boolean deleteWifeLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WifeLiverAndKidney WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeRoutineUrine(java.lang.String)
	 */
	public boolean deleteWifeRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WifeRoutineUrine WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeThyroidGlandTest(java.lang.String)
	 */
	public boolean deleteWifeThyroidGlandTest(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM ThyroidGlandTest WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeTorchandSyhilis(java.lang.String)
	 */
	public boolean deleteWifeTorchandSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM TorchandSyphilis WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#deleteWifeWomanBC(java.lang.String)
	 */
	public boolean deleteWifeWomanBC(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WomanBC WHERE RecordID ='" + strRecordID + "'";
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
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeBloodCellTest(java.lang.String)
	 */
	public boolean existWifeBloodCellTest(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from BloodCellTest where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeBloodGroup(java.lang.String)
	 */
	public boolean existWifeBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WifeBloodGroup where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeBloodSuger(java.lang.String)
	 */
	public boolean existWifeBloodSuger(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WifeBloodSuger where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeBodyDoc(java.lang.String)
	 */
	public boolean existWifeBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WifeBodyDoc where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeBodyGerneral(java.lang.String)
	 */
	public boolean existWifeBodyGerneral(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WifeBodyGeneral where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeClinicalOthers(java.lang.String)
	 */
	public boolean existWifeClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WifeClinicalOthers where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeGeneralDoc(java.lang.String)
	 */
	public boolean existWifeGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WifeGeneralDoc where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeGeneralSelf(java.lang.String)
	 */
	public boolean existWifeGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WifeGeneralSelf where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeHepatitisB(java.lang.String)
	 */
	public boolean existWifeHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WifeHepatitisB where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeLeucorrheaTest(java.lang.String)
	 */
	public boolean existWifeLeucorrheaTest(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from LeucorrheaTest where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeLiverAndKidney(java.lang.String)
	 */
	public boolean existWifeLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WifeLiverAndKidney where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeRoutineUrine(java.lang.String)
	 */
	public boolean existWifeRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WifeRoutineUrine where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeThyroidGlandTest(java.lang.String)
	 */
	public boolean existWifeThyroidGlandTest(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from ThyroidGlandTest where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeTorchandSyhilis(java.lang.String)
	 */
	public boolean existWifeTorchandSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from TorchandSyphilis where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#existWifeWomanBC(java.lang.String)
	 */
	public boolean existWifeWomanBC(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WomanBC where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeBloodCellTest(java.lang.String)
	 */
	public BloodCellTest getWifeBloodCellTest(String strRecordID) {
		// TODO Auto-generated method stub
		BloodCellTest bct = null;
		try
		{
			bct=(BloodCellTest)super.getHibernateTemplate().get(BloodCellTest.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bct;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeBloodGroup(java.lang.String)
	 */
	public WifeBloodGroup getWifeBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		WifeBloodGroup wbg = null;
		try
		{
			wbg=(WifeBloodGroup)super.getHibernateTemplate().get(WifeBloodGroup.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeBloodSuger(java.lang.String)
	 */
	public WifeBloodSuger getWifeBloodSuger(String strRecordID) {
		// TODO Auto-generated method stub
		WifeBloodSuger wbs = null;
		try
		{
			wbs=(WifeBloodSuger)super.getHibernateTemplate().get(WifeBloodSuger.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbs;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeBodyDoc(java.lang.String)
	 */
	public WifeBodyDoc getWifeBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		WifeBodyDoc wbd = null;
		try
		{
			wbd=(WifeBodyDoc)super.getHibernateTemplate().get(WifeBodyDoc.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeBodyGerneral(java.lang.String)
	 */
	public WifeBodyGeneral getWifeBodyGerneral(String strRecordID) {
		// TODO Auto-generated method stub
		WifeBodyGeneral wbg = null;
		try
		{
			wbg=(WifeBodyGeneral)super.getHibernateTemplate().get(WifeBodyGeneral.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbg;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeClinicalOthers(java.lang.String)
	 */
	public WifeClinicalOthers getWifeClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		WifeClinicalOthers wco = null;
		try
		{
			wco=(WifeClinicalOthers)super.getHibernateTemplate().get(WifeClinicalOthers.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wco;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeGeneralDoc(java.lang.String)
	 */
	public WifeGeneralDoc getWifeGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		WifeGeneralDoc wgd = null;
		try
		{
			wgd=(WifeGeneralDoc)super.getHibernateTemplate().get(WifeGeneralDoc.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wgd;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeGeneralSelf(java.lang.String)
	 */
	public WifeGeneralSelf getWifeGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		WifeGeneralSelf wgs = null;
		try
		{
			wgs=(WifeGeneralSelf)super.getHibernateTemplate().get(WifeGeneralSelf.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wgs;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeHepatitisB(java.lang.String)
	 */
	public WifeHepatitisB getWifeHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		WifeHepatitisB whb = null;
		try
		{
			whb=(WifeHepatitisB)super.getHibernateTemplate().get(WifeHepatitisB.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return whb;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeLeucorrheaTest(java.lang.String)
	 */
	public LeucorrheaTest getWifeLeucorrheaTest(String strRecordID) {
		// TODO Auto-generated method stub
		LeucorrheaTest lt = null;
		try
		{
			lt=(LeucorrheaTest)super.getHibernateTemplate().get(LeucorrheaTest.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return lt;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeLiverAndKidney(java.lang.String)
	 */
	public WifeLiverAndKidney getWifeLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		WifeLiverAndKidney wlk = null;
		try
		{
			wlk=(WifeLiverAndKidney)super.getHibernateTemplate().get(WifeLiverAndKidney.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wlk;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeRoutineUrine(java.lang.String)
	 */
	public WifeRoutineUrine getWifeRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		WifeRoutineUrine wru = null;
		try
		{
			wru=(WifeRoutineUrine)super.getHibernateTemplate().get(WifeRoutineUrine.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wru;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeThyroidGlandTest(java.lang.String)
	 */
	public ThyroidGlandTest getWifeThyroidGlandTest(String strRecordID) {
		// TODO Auto-generated method stub
		ThyroidGlandTest tgt = null;
		try
		{
			tgt=(ThyroidGlandTest)super.getHibernateTemplate().get(ThyroidGlandTest.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return tgt;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeTorchandSyhilis(java.lang.String)
	 */
	public TorchandSyphilis getWifeTorchandSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		TorchandSyphilis ts = null;
		try
		{
			ts=(TorchandSyphilis)super.getHibernateTemplate().get(TorchandSyphilis.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ts;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#getWifeWomanBC(java.lang.String)
	 */
	public WomanBc getWifeWomanBC(String strRecordID) {
		// TODO Auto-generated method stub
		WomanBc wbc = null;
		try
		{
			wbc=(WomanBc)super.getHibernateTemplate().get(WomanBc.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wbc;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeBloodCellTest(leo.entity.BloodCellTest)
	 */
	public boolean updateWifeBloodCellTest(BloodCellTest bct) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(bct);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeBloodGroup(leo.entity.WifeBloodGroup)
	 */
	public boolean updateWifeBloodGroup(WifeBloodGroup wbg) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(wbg);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeBloodSuger(leo.entity.WifeBloodSuger)
	 */
	public boolean updateWifeBloodSuger(WifeBloodSuger wbs) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(wbs);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeBodyDoc(leo.entity.WifeBodyDoc)
	 */
	public boolean updateWifeBodyDoc(WifeBodyDoc wbd) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(wbd);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeBodyGerneral(leo.entity.WifeBodyGeneral)
	 */
	public boolean updateWifeBodyGerneral(WifeBodyGeneral wbg) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(wbg);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeClinicalOthers(leo.entity.WifeClinicalOthers)
	 */
	public boolean updateWifeClinicalOthers(WifeClinicalOthers wco) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(wco);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeGeneralDoc(leo.entity.WifeGeneralDoc)
	 */
	public boolean updateWifeGeneralDoc(WifeGeneralDoc wgd) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(wgd);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeGeneralSelf(leo.entity.WifeGeneralSelf)
	 */
	public boolean updateWifeGeneralSelf(WifeGeneralSelf wgs) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(wgs);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeHepatitisB(leo.entity.WifeHepatitisB)
	 */
	public boolean updateWifeHepatitisB(WifeHepatitisB whb) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(whb);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeLeucorrheaTest(leo.entity.LeucorrheaTest)
	 */
	public boolean updateWifeLeucorrheaTest(LeucorrheaTest lt) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(lt);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeLiverAndKidney(leo.entity.WifeLiverAndKidney)
	 */
	public boolean updateWifeLiverAndKidney(WifeLiverAndKidney wlk) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(wlk);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeRoutineUrine(leo.entity.WifeRoutineUrine)
	 */
	public boolean updateWifeRoutineUrine(WifeRoutineUrine wru) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(wru);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeThyroidGlandTest(leo.entity.ThyroidGlandTest)
	 */
	public boolean updateWifeThyroidGlandTest(ThyroidGlandTest tgt) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(tgt);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeTorchandSyhilis(leo.entity.TorchandSyphilis)
	 */
	public boolean updateWifeTorchandSyphilis(TorchandSyphilis ts) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(ts);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/* (non-Javadoc)
	 * @see leo.ys.dao.iface.YSGeneralWifeDao#updateWifeWomanBC(leo.entity.WomanBc)
	 */
	public boolean updateWifeWomanBC(WomanBc wbc) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(wbc);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	public boolean addWifeOthersTest(WifeOthersTest wot) {
		// TODO Auto-generated method stub
		boolean bAdd =false;
		try
		{
			super.getHibernateTemplate().save(wot);
			bAdd =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bAdd;
	}

	public boolean deleteWifeOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL = "delete FROM WifeOthersTest WHERE RecordID ='" + strRecordID + "'";
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

	public boolean existWifeOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		String strTempSQL ="select RecordID from WifeOthersTest where RecordID= '"+ strRecordID + "'";
		SQLQuery query = super.getSession().createSQLQuery(strTempSQL);
		if(query.list().size()>0)
		{
			return true;
		}
		return false;
	}

	public WifeOthersTest getWifeOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		WifeOthersTest wot = null;
		try
		{
			wot=(WifeOthersTest)super.getHibernateTemplate().get(WifeOthersTest.class, strRecordID);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wot;
	}

	public boolean updateWifeOthersTest(WifeOthersTest wot) {
		// TODO Auto-generated method stub
		boolean bUpdate =false;
		try
		{
			super.getHibernateTemplate().update(wot);
			bUpdate =true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bUpdate;
	}

	/*
	 * 根据诊断编号和B超报告单名称，获取处置表中的处置ID
	 */
	public String getCZDisposeItemID(String strOpDnID)
	{
		String strSQL="select A.ItemID from CZDispose as A INNER JOIN CZDisposeItemDescribe AS B ON A.ItemTypeID=B.ItemTypeID where B.report='B超检查报告单' and A.KindID='" + strOpDnID+"'";
		SQLQuery query =super.getSession().createSQLQuery(strSQL);
		if(query.list().size()>0)
		{
			return query.list().get(0).toString();
		}
		else
		{
			return "";
		}
	}
	
	/*
	 * 根据诊断编号、报告单名称、处置项目名称，获取对应的处置ID
	 */
	public String getCZDisposeItemID(String strOpDnID,String strReport,String strItemName)
	{
		String strSQL="select A.ItemID from CZDispose as A INNER JOIN CZDisposeItemDescribe AS B ON A.ItemTypeID=B.ItemTypeID where B.report='" + strReport + "' and B.ItemName='" + strItemName + "' and A.KindID='" + strOpDnID+"'";
		SQLQuery query =super.getSession().createSQLQuery(strSQL);
		if(query.list().size()>0)
		{
			return query.list().get(0).toString();
		}
		else
		{
			return "";
		}
	}
	
	/*
	 * 设置白带常规检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForLeucorrheaTest(boolean bNormal,String strRecordID)
	{
		boolean bSuccess=false;
		String strTempSQL="";
		if(bNormal)
		{
			strTempSQL="update ForLeucorrheaTest set IsNormal =1 where RecordID='" + strRecordID +"'";
		}
		else
		{
			strTempSQL="update ForLeucorrheaTest set IsNormal =0 where RecordID='" + strRecordID +"'";
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
	 * 设置血细胞常规检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForBloodCellTest(boolean bNormal,String strRecordID)
	{
		boolean bSuccess=false;
		String strTempSQL="";
		if(bNormal)
		{
			strTempSQL="update ForBloodCellTest set IsNormal =1 where RecordID='" + strRecordID +"'";
		}
		else
		{
			strTempSQL="update ForBloodCellTest set IsNormal =0 where RecordID='" + strRecordID +"'";
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
	 * 设置肝功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForWifeLiverAndKidneyLiver(boolean bNormal,String strRecordID)
	{
		boolean bSuccess=false;
		String strTempSQL="";
		if(bNormal)
		{
			strTempSQL="update WifeLiverAndKidney set liverIsNormal =1 where RecordID='" + strRecordID +"'";
		}
		else
		{
			strTempSQL="update WifeLiverAndKidney set liverIsNormal =0 where RecordID='" + strRecordID +"'";
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
	public boolean setNormalForWifeLiverAndKidneyKidney(boolean bNormal,String strRecordID)
	{
		boolean bSuccess=false;
		String strTempSQL="";
		if(bNormal)
		{
			strTempSQL="update WifeLiverAndKidney set kidneyIsNormal =1 where RecordID='" + strRecordID +"'";
		}
		else
		{
			strTempSQL="update WifeLiverAndKidney set kidneyIsNormal =0 where RecordID='" + strRecordID +"'";
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
	 * 设置甲状腺功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForThyroidGlandTest(boolean bNormal,String strRecordID)
	{
		boolean bSuccess=false;
		String strTempSQL="";
		if(bNormal)
		{
			strTempSQL="update ThyroidGlandTest set IsNormal =1 where RecordID='" + strRecordID +"'";
		}
		else
		{
			strTempSQL="update ThyroidGlandTest set IsNormal =0 where RecordID='" + strRecordID +"'";
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
	public boolean setNormalForWifeHepatitisB(boolean bNormal,String strRecordID)
	{
		boolean bSuccess=false;
		String strTempSQL="";
		if(bNormal)
		{
			strTempSQL="update WifeHepatitisB set IsNormal =1 where RecordID='" + strRecordID +"'";
		}
		else
		{
			strTempSQL="update WifeHepatitisB set IsNormal =0 where RecordID='" + strRecordID +"'";
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
	 * 设置血糖(血清葡萄糖)检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForWifeBloodSuger(boolean bNormal,String strRecordID)
	{
		boolean bSuccess=false;
		String strTempSQL="";
		if(bNormal)
		{
			strTempSQL="update WifeBloodSuger set IsNormal =1 where RecordID='" + strRecordID +"'";
		}
		else
		{
			strTempSQL="update WifeBloodSuger set IsNormal =0 where RecordID='" + strRecordID +"'";
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
	 * 根据身份证号判断孕前检查表(妻子)一般情况(自助检查)
	 */
	public boolean existWifeGeneralSelfByCardID(String strCardID)
	{
		boolean bExist=false;
		String strTempSQL="select B.RecordID from FamiliRecord as A INNER JOIN WifeGeneralSelf AS B on A.RecordID=B.RecordID WHERE A.WIDCardNum='"+strCardID+"'";
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
	 * 根据身份证号判断孕前检查表(妻子)一般情况(医生询问的社会心理因素)
	 */
	public boolean existWifeGeneralDocByCardID(String strCardID)
	{
		boolean bExist=false;
		String strTempSQL="select B.RecordID from FamiliRecord as A INNER JOIN WifeGeneralDoc AS B on A.RecordID=B.RecordID WHERE A.WIDCardNum='"+strCardID+"'";
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
