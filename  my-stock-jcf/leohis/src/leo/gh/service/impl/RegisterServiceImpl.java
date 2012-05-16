package leo.gh.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import leo.cf.service.iface.CfmedicalInstService;
import leo.cf.service.iface.CfwholeDisposeService;
import leo.common.util.CommonUtil;
import leo.common.util.DateUtil;
import leo.entity.GhcostType;
import leo.entity.GhmrCg;
import leo.entity.Ghregister;
import leo.entity.GhregisterDivaricateU;
import leo.entity.GhregisterType;
import leo.entity.Osuform;
import leo.gh.dao.iface.GHRegisterDivaricateUDao;
import leo.gh.dao.iface.GhcostTypeDao;
import leo.gh.dao.iface.GhmrCgDao;
import leo.gh.dao.iface.GhregisterDao;
import leo.gh.dao.iface.GhregisterTypeDao;
import leo.gh.service.iface.RegisterService;

public class RegisterServiceImpl implements RegisterService {
	/**
	 * set方法，提供Spring注入
	 */
	private GhcostTypeDao ghcostTypeDao;
	private GhregisterTypeDao ghregisterTypeDao;
	private GHRegisterDivaricateUDao ghregisterDivaricateUDao;
	private GhregisterDao ghregisterDao;
	private CfwholeDisposeService cfwholeDisposeService;
	private GhmrCgDao ghmrCgDao;
	private CfmedicalInstService cs;

	public void setCs(CfmedicalInstService cs) {
		this.cs = cs;
	}

	public void setGhcostTypeDao(GhcostTypeDao ghcostTypeDao) {
		this.ghcostTypeDao = ghcostTypeDao;
	}

	public void setGhregisterTypeDao(GhregisterTypeDao ghregisterTypeDao) {
		this.ghregisterTypeDao = ghregisterTypeDao;
	}

	public void setGhregisterDivaricateUDao(
			GHRegisterDivaricateUDao ghregisterDivaricateUDao) {
		this.ghregisterDivaricateUDao = ghregisterDivaricateUDao;
	}

	public void setGhregisterDao(GhregisterDao ghregisterDao) {
		this.ghregisterDao = ghregisterDao;
	}

	public void setCfwholeDisposeService(
			CfwholeDisposeService cfwholeDisposeService) {
		this.cfwholeDisposeService = cfwholeDisposeService;
	}

	public void setGhmrCgDao(GhmrCgDao ghmrCgDao) {
		this.ghmrCgDao = ghmrCgDao;
	}

	public List<GhcostType> getAllGhcostTypeByMid(int mid) {
		return ghcostTypeDao.getAllGhcostTypeByMid(mid);
	}

	public List<GhregisterType> getAllGhregisterType(int uid) {
		return ghregisterTypeDao.getAllGhregisterType(uid);
	}

	public List<Osuform> getUFormByRegestTypeId(int id) {
		return null;
	}

	public boolean addGhcostType(GhcostType ghcostType) {
		return ghcostTypeDao.addGhcostType(ghcostType);
	}

	public boolean updateGhcostType(GhcostType ghcostType) {
		return ghcostTypeDao.updateGhcostType(ghcostType);
	}

	public boolean deleteGhcostType(GhcostType ghcostType) {
		return ghcostTypeDao.deleteGhcostType(ghcostType);
	}

	public GhregisterType getGhregisterTypeById(int id) {
		return ghregisterTypeDao.getGhregisterTypeById(id);
	}

	public List<GhregisterType> getGhregisterTypeByUid(int uId1, int uId2) {
		return ghregisterTypeDao.getGhregisterTypeByUid(uId1, uId2);
	}

	public GhcostType getGhcostTypeByid(int id) {
		return ghcostTypeDao.getGhcostTypeByid(id);
	}

	public List<GhregisterDivaricateU> getAllGhregisterDivaricateUByRTID(
			int rtid) {

		return ghregisterDivaricateUDao.getAllGhregisterDivaricateUByRTID(rtid);
	}

	public boolean addGhregisterDivaricateU(
			GhregisterDivaricateU ghregisterDivaricateU) {

		return ghregisterDivaricateUDao
				.addGhregisterDivaricateU(ghregisterDivaricateU);
	}

	public boolean addGhregisterType(GhregisterType ghregisterType) {

		return ghregisterTypeDao.addGhregisterType(ghregisterType);
	}

	public GhregisterType getGhregisterTypeByRPname(String rpname) {

		return ghregisterTypeDao.getGhregisterTypeByRPname(rpname);
	}

	public List<GhregisterType> getAllGhregisterTypeByMid(int mid) {

		return ghregisterTypeDao.getAllGhregisterTypeByMid(mid);
	}

	public boolean addGhregister(Ghregister ghregister, boolean card,boolean cord,
			int medicalInstId) {
		try {
			String date = DateUtil.getDateToString();
			String newNum = "";
			String maxOpnum = ghregisterDao.getMaxopnumByDate(date);
			if (maxOpnum == null || maxOpnum == "") {
				newNum = "01" + date + "000001";
			} else {
				newNum = CommonUtil.GetNewFlowNum(maxOpnum);
			}
			ghregister.setOpnum(newNum);
			ghregisterDao.addGhregister(ghregister);

			if ((card)||(cord)) {
				GhmrCg ghmrCg = new GhmrCg();
				double mprice = Float.valueOf(cs.getValueBydisposeName("医疗卡价格",
						medicalInstId));
				double cprice=Float.valueOf(cs.getValueBydisposeName("病历本价格",
						medicalInstId));
//				System.out.print(mprice);
//				System.out.print(cprice);
				
				ghmrCg.setCsId(ghregister.getCsId());
				ghmrCg.setSid(ghregister.getRegistrar());
				if(card){
				ghmrCg.setCgOfMedicalCard(mprice);
				}else
				{
					ghmrCg.setCgOfMedicalCard(0.0);
				}
				if(cord){
					ghmrCg.setCgOfClinicRecord(cprice);
				}else
				{
                    ghmrCg.setCgOfClinicRecord(0.0);
				}
				ghmrCg.setBuytime(new Timestamp(new Date().getTime()));
				ghmrCgDao.addGhmrCg(ghmrCg);
			}
           
			
			return true;
		} catch (Exception e) {
			throw new RuntimeException("挂号失败,请联系管理员!");
		}

	}

	public boolean deleteGhregister(Ghregister ghregister) {
		return ghregisterDao.deleteGhregister(ghregister);
	}

	public List<Ghregister> getAllGhregister() {
		return ghregisterDao.getAllGhregister();
	}

	public Ghregister getGhregisterByOpnum(String opnum) {
		return ghregisterDao.getGhregisterByOpnum(opnum);
	}

	public boolean updateGhregister(Ghregister ghregister, boolean card,int medicalInstId) {
		try {
			ghregisterDao.updateGhregister(ghregister);
			if (card) {
				GhmrCg ghmrCg = new GhmrCg();
				double mprice = Double.valueOf(cs.getValueBydisposeName("病历本价格",
						medicalInstId));
				ghmrCg.setCsId(ghregister.getCsId());
				ghmrCg.setSid(ghregister.getRegistrar());
				ghmrCg.setCgOfMedicalCard(0.0);
				ghmrCg.setCgOfClinicRecord(mprice);
				ghmrCg.setBuytime(new Timestamp(new Date().getTime()));
				ghmrCgDao.addGhmrCg(ghmrCg);
			}
			return true;
		} catch (Exception e) {
			throw new RuntimeException("更新挂号失败,请联系管理员!");
		}
	}

	public boolean deleteGhregisterType(GhregisterType ghregisterType) {

		return ghregisterTypeDao.deleteGhregisterType(ghregisterType);
	}

	public boolean updateGhregisterType(GhregisterType ghregisterType) {

		return ghregisterTypeDao.updateGhregisterType(ghregisterType);
	}

	public boolean deleteGhregisterDivaricateU(
			GhregisterDivaricateU ghregisterDivaricateU) {

		return ghregisterDivaricateUDao
				.deleteGhregisterDivaricateU(ghregisterDivaricateU);
	}

	public boolean updateGhregisterDivaricateU(
			GhregisterDivaricateU ghregisterDivaricateU) {

		return ghregisterDivaricateUDao
				.updateGhregisterDivaricateU(ghregisterDivaricateU);
	}

	public int getRtidByUName(int mid, String rpname) {
		return ghregisterTypeDao.getRtidByUName(mid, rpname);
	}

	public String[][] getGhregisterByCondition(String strDate, String endDate,
			String csName, String mcardNum, String opNum, String cscardNum ,int uid) {
		return ghregisterDao.getGhregisterByCondition(strDate, endDate, csName,
				mcardNum, opNum, cscardNum,uid);
	}

	public boolean deleteGhregisterByOpnum(String opnum) {
		return ghregisterDao.deleteGhregister(ghregisterDao
				.getGhregisterByOpnum(opnum));
	}

	public String[][] getGhregisterByDateandRstatus(String stdate,
			String eddate, String rstatus,int uid) {

		return ghregisterDao.getGhregisterByDateandRstatus(stdate, eddate,
				rstatus,uid);
	}

	public boolean updateGhregisteronly(Ghregister ghregister) {
		
		return ghregisterDao.updateGhregister(ghregister);
	}

	public String getMaxopnumByDate(String date) {
		
		return ghregisterDao.getMaxopnumByDate(date);
	}

	public List<Ghregister> getGhregisterfortg(long sid, String stdate,
			String eddate) throws Exception {

		return ghregisterDao.getGhregisterfortg(sid, stdate, eddate);
	}

	public List<GhregisterType> getGhregisterTypebyghuid(int uid) {
		return ghregisterTypeDao.getGhregisterTypebyghuid(uid);
	}

	public String[][] getrnameandrtidbyuid(int uid) {
		// TODO Auto-generated method stub
		return ghregisterTypeDao.getrnameandrtidbyuid(uid);
	}

}
