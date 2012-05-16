/**
 * 
 */
package leo.ys.service.impl;

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
import leo.ys.service.iface.YSGeneralWifeService;

/**
 * @author Administrator
 *
 */
public class YSGeneralWifeServiceImpl implements YSGeneralWifeService {

	YSGeneralWifeDao ysgeneralWifeDao =null;
	
	public void setYsgeneralWifeDao(YSGeneralWifeDao ysgeneralWifeDao) {
		this.ysgeneralWifeDao = ysgeneralWifeDao;
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeBloodCellTest(leo.entity.BloodCellTest)
	 */
	public boolean addWifeBloodCellTest(BloodCellTest bct) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeBloodCellTest(bct);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeBloodGroup(leo.entity.WifeBloodGroup)
	 */
	public boolean addWifeBloodGroup(WifeBloodGroup wbg) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeBloodGroup(wbg);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeBloodSuger(leo.entity.WifeBloodSuger)
	 */
	public boolean addWifeBloodSuger(WifeBloodSuger wbs) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeBloodSuger(wbs);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeBodyDoc(leo.entity.WifeBodyDoc)
	 */
	public boolean addWifeBodyDoc(WifeBodyDoc wbd) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeBodyDoc(wbd);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeBodyGerneral(leo.entity.WifeBodyGeneral)
	 */
	public boolean addWifeBodyGerneral(WifeBodyGeneral wbg) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeBodyGerneral(wbg);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeClinicalOthers(leo.entity.WifeClinicalOthers)
	 */
	public boolean addWifeClinicalOthers(WifeClinicalOthers wco) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeClinicalOthers(wco);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeGeneralDoc(leo.entity.WifeGeneralDoc)
	 */
	public boolean addWifeGeneralDoc(WifeGeneralDoc wgd) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeGeneralDoc(wgd);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeGeneralSelf(leo.entity.WifeGeneralSelf)
	 */
	public boolean addWifeGeneralSelf(WifeGeneralSelf wgs) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeGeneralSelf(wgs);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeHepatitisB(leo.entity.WifeHepatitisB)
	 */
	public boolean addWifeHepatitisB(WifeHepatitisB whb) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeHepatitisB(whb);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeLeucorrheaTest(leo.entity.LeucorrheaTest)
	 */
	public boolean addWifeLeucorrheaTest(LeucorrheaTest lt) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeLeucorrheaTest(lt);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeLiverAndKidney(leo.entity.WifeLiverAndKidney)
	 */
	public boolean addWifeLiverAndKidney(WifeLiverAndKidney wlk) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeLiverAndKidney(wlk);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeRoutineUrine(leo.entity.WifeRoutineUrine)
	 */
	public boolean addWifeRoutineUrine(WifeRoutineUrine wru) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeRoutineUrine(wru);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeThyroidGlandTest(leo.entity.ThyroidGlandTest)
	 */
	public boolean addWifeThyroidGlandTest(ThyroidGlandTest tgt) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeThyroidGlandTest(tgt);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeTorchandSyphilis(leo.entity.TorchandSyphilis)
	 */
	public boolean addWifeTorchandSyphilis(TorchandSyphilis ts) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeTorchandSyphilis(ts);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#addWifeWomanBC(leo.entity.WomanBc)
	 */
	public boolean addWifeWomanBC(WomanBc wbc) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeWomanBC(wbc);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeBloodCellTest(java.lang.String)
	 */
	public boolean deleteWifeBloodCellTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeBloodCellTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeBloodGroup(java.lang.String)
	 */
	public boolean deleteWifeBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeBloodGroup(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeBloodSuger(java.lang.String)
	 */
	public boolean deleteWifeBloodSuger(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeBloodSuger(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeBodyDoc(java.lang.String)
	 */
	public boolean deleteWifeBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeBodyDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeBodyGerneral(java.lang.String)
	 */
	public boolean deleteWifeBodyGerneral(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeBodyGerneral(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeClinicalOthers(java.lang.String)
	 */
	public boolean deleteWifeClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeClinicalOthers(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeGeneralDoc(java.lang.String)
	 */
	public boolean deleteWifeGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeGeneralDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeGeneralSelf(java.lang.String)
	 */
	public boolean deleteWifeGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeGeneralSelf(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeHepatitisB(java.lang.String)
	 */
	public boolean deleteWifeHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeHepatitisB(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeLeucorrheaTest(java.lang.String)
	 */
	public boolean deleteWifeLeucorrheaTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeLeucorrheaTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeLiverAndKidney(java.lang.String)
	 */
	public boolean deleteWifeLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeLiverAndKidney(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeRoutineUrine(java.lang.String)
	 */
	public boolean deleteWifeRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeRoutineUrine(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeThyroidGlandTest(java.lang.String)
	 */
	public boolean deleteWifeThyroidGlandTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeThyroidGlandTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeTorchandSyphilis(java.lang.String)
	 */
	public boolean deleteWifeTorchandSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeTorchandSyphilis(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#deleteWifeWomanBC(java.lang.String)
	 */
	public boolean deleteWifeWomanBC(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeWomanBC(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeBloodCellTest(java.lang.String)
	 */
	public boolean existWifeBloodCellTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeBloodCellTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeBloodGroup(java.lang.String)
	 */
	public boolean existWifeBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeBloodGroup(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeBloodSuger(java.lang.String)
	 */
	public boolean existWifeBloodSuger(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeBloodSuger(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeBodyDoc(java.lang.String)
	 */
	public boolean existWifeBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeBodyDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeBodyGerneral(java.lang.String)
	 */
	public boolean existWifeBodyGerneral(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeBodyGerneral(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeClinicalOthers(java.lang.String)
	 */
	public boolean existWifeClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeClinicalOthers(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeGeneralDoc(java.lang.String)
	 */
	public boolean existWifeGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeGeneralDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeGeneralSelf(java.lang.String)
	 */
	public boolean existWifeGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeGeneralSelf(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeHepatitisB(java.lang.String)
	 */
	public boolean existWifeHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeHepatitisB(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeLeucorrheaTest(java.lang.String)
	 */
	public boolean existWifeLeucorrheaTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeLeucorrheaTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeLiverAndKidney(java.lang.String)
	 */
	public boolean existWifeLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeLiverAndKidney(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeRoutineUrine(java.lang.String)
	 */
	public boolean existWifeRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeRoutineUrine(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeThyroidGlandTest(java.lang.String)
	 */
	public boolean existWifeThyroidGlandTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeThyroidGlandTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeTorchandSyphilis(java.lang.String)
	 */
	public boolean existWifeTorchandSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeTorchandSyphilis(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#existWifeWomanBC(java.lang.String)
	 */
	public boolean existWifeWomanBC(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeWomanBC(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeBloodCellTest(java.lang.String)
	 */
	public BloodCellTest getWifeBloodCellTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeBloodCellTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeBloodGroup(java.lang.String)
	 */
	public WifeBloodGroup getWifeBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeBloodGroup(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeBloodSuger(java.lang.String)
	 */
	public WifeBloodSuger getWifeBloodSuger(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeBloodSuger(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeBodyDoc(java.lang.String)
	 */
	public WifeBodyDoc getWifeBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeBodyDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeBodyGerneral(java.lang.String)
	 */
	public WifeBodyGeneral getWifeBodyGerneral(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeBodyGerneral(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeClinicalOthers(java.lang.String)
	 */
	public WifeClinicalOthers getWifeClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeClinicalOthers(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeGeneralDoc(java.lang.String)
	 */
	public WifeGeneralDoc getWifeGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeGeneralDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeGeneralSelf(java.lang.String)
	 */
	public WifeGeneralSelf getWifeGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeGeneralSelf(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeHepatitisB(java.lang.String)
	 */
	public WifeHepatitisB getWifeHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeHepatitisB(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeLeucorrheaTest(java.lang.String)
	 */
	public LeucorrheaTest getWifeLeucorrheaTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeLeucorrheaTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeLiverAndKidney(java.lang.String)
	 */
	public WifeLiverAndKidney getWifeLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeLiverAndKidney(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeRoutineUrine(java.lang.String)
	 */
	public WifeRoutineUrine getWifeRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeRoutineUrine(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeThyroidGlandTest(java.lang.String)
	 */
	public ThyroidGlandTest getWifeThyroidGlandTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeThyroidGlandTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeTorchandSyphilis(java.lang.String)
	 */
	public TorchandSyphilis getWifeTorchandSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeTorchandSyphilis(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#getWifeWomanBC(java.lang.String)
	 */
	public WomanBc getWifeWomanBC(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeWomanBC(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeBloodCellTest(leo.entity.BloodCellTest)
	 */
	public boolean updateWifeBloodCellTest(BloodCellTest bct) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeBloodCellTest(bct);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeBloodGroup(leo.entity.WifeBloodGroup)
	 */
	public boolean updateWifeBloodGroup(WifeBloodGroup wbg) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeBloodGroup(wbg);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeBloodSuger(leo.entity.WifeBloodSuger)
	 */
	public boolean updateWifeBloodSuger(WifeBloodSuger wbs) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeBloodSuger(wbs);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeBodyDoc(leo.entity.WifeBodyDoc)
	 */
	public boolean updateWifeBodyDoc(WifeBodyDoc wbd) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeBodyDoc(wbd);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeBodyGerneral(leo.entity.WifeBodyGeneral)
	 */
	public boolean updateWifeBodyGerneral(WifeBodyGeneral wbg) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeBodyGerneral(wbg);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeClinicalOthers(leo.entity.WifeClinicalOthers)
	 */
	public boolean updateWifeClinicalOthers(WifeClinicalOthers wco) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeClinicalOthers(wco);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeGeneralDoc(leo.entity.WifeGeneralDoc)
	 */
	public boolean updateWifeGeneralDoc(WifeGeneralDoc wgd) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeGeneralDoc(wgd);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeGeneralSelf(leo.entity.WifeGeneralSelf)
	 */
	public boolean updateWifeGeneralSelf(WifeGeneralSelf wgs) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeGeneralSelf(wgs);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeHepatitisB(leo.entity.WifeHepatitisB)
	 */
	public boolean updateWifeHepatitisB(WifeHepatitisB whb) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeHepatitisB(whb);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeLeucorrheaTest(leo.entity.LeucorrheaTest)
	 */
	public boolean updateWifeLeucorrheaTest(LeucorrheaTest lt) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeLeucorrheaTest(lt);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeLiverAndKidney(leo.entity.WifeLiverAndKidney)
	 */
	public boolean updateWifeLiverAndKidney(WifeLiverAndKidney wlk) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeLiverAndKidney(wlk);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeRoutineUrine(leo.entity.WifeRoutineUrine)
	 */
	public boolean updateWifeRoutineUrine(WifeRoutineUrine wru) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeRoutineUrine(wru);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeThyroidGlandTest(leo.entity.ThyroidGlandTest)
	 */
	public boolean updateWifeThyroidGlandTest(ThyroidGlandTest tgt) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeThyroidGlandTest(tgt);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeTorchandSyphilis(leo.entity.TorchandSyphilis)
	 */
	public boolean updateWifeTorchandSyphilis(TorchandSyphilis ts) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeTorchandSyphilis(ts);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralWifeService#updateWifeWomanBC(leo.entity.WomanBc)
	 */
	public boolean updateWifeWomanBC(WomanBc wbc) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeWomanBC(wbc);
	}

	public boolean addWifeOthersTest(WifeOthersTest wot) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.addWifeOthersTest(wot);
	}

	public boolean deleteWifeOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.deleteWifeOthersTest(strRecordID);
	}

	public boolean existWifeOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.existWifeOthersTest(strRecordID);
	}

	public WifeOthersTest getWifeOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.getWifeOthersTest(strRecordID);
	}

	public boolean updateWifeOthersTest(WifeOthersTest wot) {
		// TODO Auto-generated method stub
		return ysgeneralWifeDao.updateWifeOthersTest(wot);
	}

	/*
	 * 根据诊断编号和B超报告单名称，获取处置表中的处置ID
	 */
	public String getCZDisposeItemID(String strOpDnID)
	{
		return ysgeneralWifeDao.getCZDisposeItemID(strOpDnID);
	}
	
	/*
	 * 根据诊断编号、报告单名称、处置项目名称，获取对应的处置ID
	 */
	public String getCZDisposeItemID(String strOpDnID,String strReport,String strItemName)
	{
		return ysgeneralWifeDao.getCZDisposeItemID(strOpDnID, strReport, strItemName);
	}
	
	/*
	 * 设置白带常规检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForLeucorrheaTest(boolean bNormal,String strRecordID)
	{
		return ysgeneralWifeDao.setNormalForLeucorrheaTest(bNormal, strRecordID);
	}
	
	/*
	 * 设置血细胞常规检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForBloodCellTest(boolean bNormal,String strRecordID)
	{
		return ysgeneralWifeDao.setNormalForBloodCellTest(bNormal, strRecordID);
	}
	
	/*
	 * 设置肝功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForWifeLiverAndKidneyLiver(boolean bNormal,String strRecordID)
	{
		return ysgeneralWifeDao.setNormalForWifeLiverAndKidneyLiver(bNormal, strRecordID);
	}
	
	/*
	 * 设置肾功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForWifeLiverAndKidneyKidney(boolean bNormal,String strRecordID)
	{
		return ysgeneralWifeDao.setNormalForWifeLiverAndKidneyKidney(bNormal, strRecordID);
	}
	
	/*
	 * 设置甲状腺功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForThyroidGlandTest(boolean bNormal,String strRecordID)
	{
		return ysgeneralWifeDao.setNormalForThyroidGlandTest(bNormal, strRecordID);
	}
	
	/*
	 * 设置乙型肝炎血清学五项功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForWifeHepatitisB(boolean bNormal,String strRecordID)
	{
		return ysgeneralWifeDao.setNormalForWifeHepatitisB(bNormal, strRecordID);
	}
	
	/*
	 * 设置血糖(血清葡萄糖)检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForWifeBloodSuger(boolean bNormal,String strRecordID)
	{
		return ysgeneralWifeDao.setNormalForWifeBloodSuger(bNormal, strRecordID);
	}
	
	/*
	 * 根据身份证号判断孕前检查表(妻子)一般情况(自助检查)
	 */
	public boolean existWifeGeneralSelfByCardID(String strCardID)
	{
		return ysgeneralWifeDao.existWifeGeneralSelfByCardID(strCardID);
	}
	
	/*
	 * 根据身份证号判断孕前检查表(妻子)一般情况(医生询问的社会心理因素)
	 */
	public boolean existWifeGeneralDocByCardID(String strCardID)
	{
		return ysgeneralWifeDao.existWifeGeneralDocByCardID(strCardID);
	}
	
}
