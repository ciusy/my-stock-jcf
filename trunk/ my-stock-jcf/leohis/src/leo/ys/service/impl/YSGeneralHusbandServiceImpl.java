/**
 * 
 */
package leo.ys.service.impl;

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
import leo.ys.dao.iface.YSGeneralHusbandDao;
import leo.ys.service.iface.YSGeneralHusbandService;

/**
 * @author Administrator
 *
 */
public class YSGeneralHusbandServiceImpl implements YSGeneralHusbandService {

	YSGeneralHusbandDao ysgeneralHusbandDao=null;
	
	public void setYsgeneralHusbandDao(YSGeneralHusbandDao ysgeneralHusbandDao) {
		this.ysgeneralHusbandDao = ysgeneralHusbandDao;
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#addHusBloodGroup(leo.entity.HusBloodGroup)
	 */
	public boolean addHusBloodGroup(HusBloodGroup hbg) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.addHusBloodGroup(hbg);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#addHusBodyGeneral(leo.entity.HusBodyGeneral)
	 */
	public boolean addHusBodyGeneral(HusBodyGeneral hbg) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.addHusBodyGeneral(hbg);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#addHusClinicalOthers(leo.entity.HusClinicalOthers)
	 */
	public boolean addHusClinicalOthers(HusClinicalOthers hco) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.addHusClinicalOthers(hco);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#addHusGeneralDoc(leo.entity.HusGeneralDoc)
	 */
	public boolean addHusGeneralDoc(HusGeneralDoc hgd) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.addHusGeneralDoc(hgd);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#addHusGeneralSelf(leo.entity.HusGeneralSelf)
	 */
	public boolean addHusGeneralSelf(HusGeneralSelf hgs) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.addHusGeneralSelf(hgs);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#addHusHepatitisB(leo.entity.HusHepatitisB)
	 */
	public boolean addHusHepatitisB(HusHepatitisB hhb) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.addHusHepatitisB(hhb);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#addHusHusBodyDoc(leo.entity.HusBodyDoc)
	 */
	public boolean addHusBodyDoc(HusBodyDoc hbd) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.addHusBodyDoc(hbd);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#addHusLiverAndKidney(leo.entity.HusLiverAndKidney)
	 */
	public boolean addHusLiverAndKidney(HusLiverAndKidney hlk) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.addHusLiverAndKidney(hlk);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#addHusOthersTest(leo.entity.HusOthersTest)
	 */
	public boolean addHusOthersTest(HusOthersTest hot) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.addHusOthersTest(hot);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#addHusRoutineUrine(leo.entity.HusRoutineUrine)
	 */
	public boolean addHusRoutineUrine(HusRoutineUrine hru) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.addHusRoutineUrine(hru);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#addHusSyphilis(leo.entity.HusSyphilis)
	 */
	public boolean addHusSyphilis(HusSyphilis hs) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.addHusSyphilis(hs);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#deleteHusBloodGroup(java.lang.String)
	 */
	public boolean deleteHusBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.deleteHusBloodGroup(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#deleteHusBodyGeneral(java.lang.String)
	 */
	public boolean deleteHusBodyGeneral(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.deleteHusBodyGeneral(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#deleteHusClinicalOthers(java.lang.String)
	 */
	public boolean deleteHusClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.deleteHusClinicalOthers(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#deleteHusGeneralDoc(java.lang.String)
	 */
	public boolean deleteHusGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.deleteHusGeneralDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#deleteHusGeneralSelf(java.lang.String)
	 */
	public boolean deleteHusGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.deleteHusGeneralSelf(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#deleteHusHepatitisB(java.lang.String)
	 */
	public boolean deleteHusHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.deleteHusHepatitisB(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#deleteHusHusBodyDoc(java.lang.String)
	 */
	public boolean deleteHusBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.deleteHusBodyDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#deleteHusLiverAndKidney(java.lang.String)
	 */
	public boolean deleteHusLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.deleteHusLiverAndKidney(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#deleteHusOthersTest(java.lang.String)
	 */
	public boolean deleteHusOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.deleteHusOthersTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#deleteHusRoutineUrine(java.lang.String)
	 */
	public boolean deleteHusRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.deleteHusRoutineUrine(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#deleteHusSyphilis(java.lang.String)
	 */
	public boolean deleteHusSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.deleteHusSyphilis(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#existHusBloodGroup(java.lang.String)
	 */
	public boolean existHusBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.existHusBloodGroup(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#existHusBodyGeneral(java.lang.String)
	 */
	public boolean existHusBodyGeneral(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.existHusBodyGeneral(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#existHusClinicalOthers(java.lang.String)
	 */
	public boolean existHusClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.existHusClinicalOthers(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#existHusGeneralDoc(java.lang.String)
	 */
	public boolean existHusGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.existHusGeneralDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#existHusGeneralSelf(java.lang.String)
	 */
	public boolean existHusGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.existHusGeneralSelf(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#existHusHepatitisB(java.lang.String)
	 */
	public boolean existHusHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.existHusHepatitisB(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#existHusHusBodyDoc(java.lang.String)
	 */
	public boolean existHusBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.existHusBodyDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#existHusLiverAndKidney(java.lang.String)
	 */
	public boolean existHusLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.existHusLiverAndKidney(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#existHusOthersTest(java.lang.String)
	 */
	public boolean existHusOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.existHusOthersTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#existHusRoutineUrine(java.lang.String)
	 */
	public boolean existHusRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.existHusRoutineUrine(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#existHusSyphilis(java.lang.String)
	 */
	public boolean existHusSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.existHusSyphilis(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#getHusBloodGroup(java.lang.String)
	 */
	public HusBloodGroup getHusBloodGroup(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.getHusBloodGroup(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#getHusBodyGeneral(java.lang.String)
	 */
	public HusBodyGeneral getHusBodyGeneral(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.getHusBodyGeneral(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#getHusClinicalOthers(java.lang.String)
	 */
	public HusClinicalOthers getHusClinicalOthers(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.getHusClinicalOthers(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#getHusGeneralDoc(java.lang.String)
	 */
	public HusGeneralDoc getHusGeneralDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.getHusGeneralDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#getHusGeneralSelf(java.lang.String)
	 */
	public HusGeneralSelf getHusGeneralSelf(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.getHusGeneralSelf(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#getHusHepatitisB(java.lang.String)
	 */
	public HusHepatitisB getHusHepatitisB(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.getHusHepatitisB(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#getHusHusBodyDoc(java.lang.String)
	 */
	public HusBodyDoc getHusBodyDoc(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.getHusBodyDoc(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#getHusLiverAndKidney(java.lang.String)
	 */
	public HusLiverAndKidney getHusLiverAndKidney(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.getHusLiverAndKidney(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#getHusOthersTest(java.lang.String)
	 */
	public HusOthersTest getHusOthersTest(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.getHusOthersTest(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#getHusRoutineUrine(java.lang.String)
	 */
	public HusRoutineUrine getHusRoutineUrine(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.getHusRoutineUrine(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#getHusSyphilis(java.lang.String)
	 */
	public HusSyphilis getHusSyphilis(String strRecordID) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.getHusSyphilis(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#updateHusBloodGroup(leo.entity.HusBloodGroup)
	 */
	public boolean updateHusBloodGroup(HusBloodGroup hbg) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.updateHusBloodGroup(hbg);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#updateHusBodyGeneral(leo.entity.HusBodyGeneral)
	 */
	public boolean updateHusBodyGeneral(HusBodyGeneral hbg) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.updateHusBodyGeneral(hbg);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#updateHusClinicalOthers(leo.entity.HusClinicalOthers)
	 */
	public boolean updateHusClinicalOthers(HusClinicalOthers hco) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.updateHusClinicalOthers(hco);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#updateHusGeneralDoc(leo.entity.HusGeneralDoc)
	 */
	public boolean updateHusGeneralDoc(HusGeneralDoc hgd) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.updateHusGeneralDoc(hgd);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#updateHusGeneralSelf(leo.entity.HusGeneralSelf)
	 */
	public boolean updateHusGeneralSelf(HusGeneralSelf hgs) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.updateHusGeneralSelf(hgs);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#updateHusHepatitisB(leo.entity.HusHepatitisB)
	 */
	public boolean updateHusHepatitisB(HusHepatitisB hhb) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.updateHusHepatitisB(hhb);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#updateHusHusBodyDoc(leo.entity.HusBodyDoc)
	 */
	public boolean updateHusBodyDoc(HusBodyDoc hbd) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.updateHusBodyDoc(hbd);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#updateHusLiverAndKidney(leo.entity.HusLiverAndKidney)
	 */
	public boolean updateHusLiverAndKidney(HusLiverAndKidney hlk) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.updateHusLiverAndKidney(hlk);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#updateHusOthersTest(leo.entity.HusOthersTest)
	 */
	public boolean updateHusOthersTest(HusOthersTest hot) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.updateHusOthersTest(hot);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#updateHusRoutineUrine(leo.entity.HusRoutineUrine)
	 */
	public boolean updateHusRoutineUrine(HusRoutineUrine hru) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.updateHusRoutineUrine(hru);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSGeneralHusbandService#updateHusSyphilis(leo.entity.HusSyphilis)
	 */
	public boolean updateHusSyphilis(HusSyphilis hs) {
		// TODO Auto-generated method stub
		return ysgeneralHusbandDao.updateHusSyphilis(hs);
	}

	/*
	 * 设置肝功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForHusLiverAndKidneyLiver(boolean bNormal,String strRecordID)
	{
		return ysgeneralHusbandDao.setNormalForHusLiverAndKidneyLiver(bNormal, strRecordID);
	}
	
	/*
	 * 设置肾功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForHusLiverAndKidneyKidney(boolean bNormal,String strRecordID)
	{
		return ysgeneralHusbandDao.setNormalForHusLiverAndKidneyKidney(bNormal, strRecordID);
	}
		
	/*
	 * 设置乙型肝炎血清学五项功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForHusHepatitisB(boolean bNormal,String strRecordID)
	{
		return ysgeneralHusbandDao.setNormalForHusHepatitisB(bNormal, strRecordID);
	}
	
	/*
	 * 根据身份证号判断孕前检查表(丈夫)一般情况(自助检查)
	 */
	public boolean existHusGeneralSelfByCardID(String strCardID)
	{
		return ysgeneralHusbandDao.existHusGeneralSelfByCardID(strCardID);
	}
	
	/*
	 * 根据身份证号判断孕前检查表(丈夫)一般情况(医生询问的社会心理因素)
	 */
	public boolean existHusGeneralDocByCardID(String strCardID)
	{
		return ysgeneralHusbandDao.existHusGeneralDocByCardID(strCardID);
	}
}
