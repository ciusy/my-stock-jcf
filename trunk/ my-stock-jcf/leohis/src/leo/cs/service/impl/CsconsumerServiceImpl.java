package leo.cs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import leo.cs.dao.iface.CsconsumerDao;
import leo.cs.dao.iface.CsefileInfoDao;
import leo.cs.dao.iface.CsmarriageHistoryDao;
import leo.cs.dao.iface.CsmedicalCardDao;
import leo.cs.dao.iface.CsmedicalCardDetailDao;
import leo.cs.dao.iface.GhMrCGDao;
import leo.gh.dao.iface.GhregisterDao;
import leo.zy.dao.iface.ZyInpatientDao;
import leo.cf.dao.iface.CfcityDao;
import leo.cf.dao.iface.CfprefectureDao;
import leo.cf.dao.iface.CftownDao;
import leo.cf.dao.iface.CfvillageDao;

import leo.cs.service.iface.CsconsumerService;
import leo.entity.Cfcity;
import leo.entity.Cfprefecture;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.Csconsumer;
import leo.entity.CsefileInfo;
import leo.entity.CsmarriageHistory;
import leo.entity.CsmedicalCard;
import leo.entity.CsmedicalCardDetail;
import leo.entity.GhmrCg;

public class CsconsumerServiceImpl implements CsconsumerService {
	private CsconsumerDao csconsumerDao;
	private CsefileInfoDao csefileInfoDao;
	private CsmarriageHistoryDao csmarriageHistoryDao;
	private GhregisterDao ghregisterDao;
	private ZyInpatientDao zyInpatientDao;
	private CfcityDao cfcityDao;
	private CfprefectureDao cfprefectureDao;
	private CftownDao cftownDao;
	private CfvillageDao cfvillageDao;
	
	
	public void setCfvillageDao(CfvillageDao cfvillageDao) {
		this.cfvillageDao = cfvillageDao;
	}
	public void setCftownDao(CftownDao cftownDao) {
		this.cftownDao = cftownDao;
	}
	public void setCfprefectureDao(CfprefectureDao cfprefectureDao) {
		this.cfprefectureDao = cfprefectureDao;
	}
	public void setCfcityDao(CfcityDao cfcityDao) {
		this.cfcityDao = cfcityDao;
	}
	public void setZyInpatientDao(ZyInpatientDao zyInpatientDao) {
		this.zyInpatientDao = zyInpatientDao;
	}
	public void setGhregisterDao(GhregisterDao ghregisterDao) {
		this.ghregisterDao = ghregisterDao;
	}
	public void setCsmarriageHistoryDao(CsmarriageHistoryDao csmarriageHistoryDao){
	    this.csmarriageHistoryDao=csmarriageHistoryDao;	
	}
	public void setCsefileInfoDao(CsefileInfoDao csefileInfoDao){
		this.csefileInfoDao=csefileInfoDao;
	}
	
	public void setCsconsumerDao(CsconsumerDao csconsumerDao) {
		this.csconsumerDao = csconsumerDao;
	}

	public void setCsmedicalCardDao(CsmedicalCardDao csmedicalCardDao) {
		this.csmedicalCardDao = csmedicalCardDao;
	}

	public void setCsmedicalCardDetailDao(
			CsmedicalCardDetailDao csmedicalCardDetailDao) {
		this.csmedicalCardDetailDao = csmedicalCardDetailDao;
	}

	public void setGhmrcgDao(GhMrCGDao ghmrcgDao) {
		this.ghmrcgDao = ghmrcgDao;
	}

	private CsmedicalCardDao csmedicalCardDao;
	private CsmedicalCardDetailDao csmedicalCardDetailDao;
	private GhMrCGDao ghmrcgDao;


	public Csconsumer getCInfoById(Long id) {

		return csconsumerDao.getCInfoById(id);
	}

	public Boolean addCsconsumerInfo(Csconsumer csconsumer) {
		return this.csconsumerDao.addCsconsumerInfo(csconsumer);
	}

	public Boolean updateCsconsumerInfo(Csconsumer csconsumer) {
		return this.csconsumerDao.updateCsconsumerInfo(csconsumer);
	}

	/**
	 * add by xu 根据id集合返回服务对象
	 * 
	 * @param ids
	 * @return
	 */
	public List<Csconsumer> getByIds(List<Long> ids) {

		return csconsumerDao.getByIds(ids);
	}

//	public String[][] getCInfo(String csname, String nameForShort, String idcardNum, String prefecture, String town,
//			String village, String medicalCardNum) {
//		return csconsumerDao.getCInfo(csname, nameForShort, idcardNum, prefecture, town, village, medicalCardNum);
//	}

	public CsmedicalCard getCsmedicalCardByCsid(long csid) {
		return csmedicalCardDao.getCsmedicalCardByCsid(csid);
	}

	public Boolean addCsmedicalCard(CsmedicalCard csmedicalCard) {
		return csmedicalCardDao.addCsmedicalCard(csmedicalCard);
	}

	public Boolean updateCsmedicalCard(CsmedicalCard csmedicalCard) {

		return csmedicalCardDao.updateCsmedicalCard(csmedicalCard);
	}

	public CsmedicalCard getCsmedicalCardOnlyByCsid(long csid) {

		return csmedicalCardDao.getCsmedicalCardOnlyByCsid(csid);
	}

	public String[][] getCsmedicalCardDetailByDateandcsid(String stdate, String eddate, long csid) {

		return csmedicalCardDetailDao.getCsmedicalCardDetailByDateandcsid(stdate, eddate, csid);
	}

	public Boolean addCsmedicalCardDetail(CsmedicalCardDetail csmedicalCardDetail) {

		return csmedicalCardDetailDao.addCsmedicalCardDetail(csmedicalCardDetail);
	}

	public long getCsIDByMedicalCardNum(String medicalCardNum) {

		return csmedicalCardDao.getCsIDByMedicalCardNum(medicalCardNum);
	}

	public Csconsumer getCInfoByIDCardNum(String idCardNum) {
		// TODO Auto-generated method stub
		return csconsumerDao.getCInfoByIDCardNum(idCardNum);
	}

	public int getCountAge(String useryear, String sdate) {
		return csconsumerDao.getCountAge(useryear, sdate);

	}

	public List<Csconsumer> getByBirthTime(String startTime, String endTime) {
		return csconsumerDao.getByBirthTime(startTime, endTime);
	}

	public List<Csconsumer> getByCondition(List<Long> ids, String consumerName, String idCard, String medicalCard,int flag) {

		return csconsumerDao.getByCondition(ids, consumerName, idCard, medicalCard,flag);
	}

	public boolean addGhmrCg(GhmrCg ghmrCg){
		return ghmrcgDao.addGhmrCg(ghmrCg);
	}

	public CsefileInfo getCsefileInfoByCsID(long csID) {
		
		return csefileInfoDao.getCsefileInfoByCsID(csID);
	}

	public List<CsmarriageHistory> getCsmarriageHistoryByCsID(Long csID) {
		
		return csmarriageHistoryDao.getCsmarriageHistoryByCsID(csID);
	}
	public boolean addCsefileInfo(CsefileInfo csefileInfo) {
		// TODO Auto-generated method stub
		return csefileInfoDao.addCsefileInfo(csefileInfo);
	}
	public boolean deleteCsefileInfo(CsefileInfo csefileInfo) {
		// TODO Auto-generated method stub
		return csefileInfoDao.deleteCsefileInfo(csefileInfo);
	}
	public boolean updateCsefileInfo(CsefileInfo csefileInfo) {
		// TODO Auto-generated method stub
		return csefileInfoDao.updateCsefileInfo(csefileInfo);
	}
	public boolean addCsmarriageHistory(CsmarriageHistory csmarriageHistory) {
		// TODO Auto-generated method stub
		return csmarriageHistoryDao.addCsmarriageHistory(csmarriageHistory);
	}
	public boolean deleteCsmarriageHistory(CsmarriageHistory csmarriageHistory) {
		// TODO Auto-generated method stub
		return csmarriageHistoryDao.deleteCsmarriageHistory(csmarriageHistory);
	}
	public boolean updateCsmarriageHistory(CsmarriageHistory csmarriageHistory) {
		// TODO Auto-generated method stub
		return csmarriageHistoryDao.updateCsmarriageHistory(csmarriageHistory);
	}
	public CsmarriageHistory getCsmarriageHistoryByID(long id) {
		
		return csmarriageHistoryDao.getCsmarriageHistoryByID(id);
	}
	public List<Csconsumer> getCsconsumerlistByInfo(String csname,
			String spell, String IDcardnum) {
		// TODO Auto-generated method stub
		return csconsumerDao.getCsconsumerlistByInfo(csname, spell, IDcardnum);
	}
	public String[][] getCInfo(String csname, String spell, String idcardNum,
			String prefecture, String town, String village, String tgroup,
			String medicalCardNum) {
		
		return csconsumerDao.getCInfo(csname, spell, idcardNum, prefecture, town, village, tgroup, medicalCardNum);
	}
	public List<Csconsumer> getCsInfo(String csnameandspell, String idcardNum,
			String prefecture, String town, String village, String tgroup,
			String medicalCardNum) {
		// TODO Auto-generated method stub
		return csconsumerDao.getCsInfo(csnameandspell, idcardNum, prefecture, town, village, tgroup, medicalCardNum);
	}
	
	public String[][] getFuWuDuiXian(String Date_B, String Date_e, String XingMing, String XingMingSuoXie, Integer YiLiaoJiGou, Integer ShiFouChuYuan, String LeiXing){
		
		if (LeiXing.equals("门诊")){
			return ghregisterDao.getGhregisterDZ(Date_B, Date_e, XingMing, XingMingSuoXie, YiLiaoJiGou);
		}
		else
			return zyInpatientDao.getGhregisterDZ(Date_B, Date_e, XingMing, XingMingSuoXie, ShiFouChuYuan, YiLiaoJiGou);
	}
	public List<GhmrCg> getGhmrCgfortg(long sid, String stdate, String eddate)
			throws Exception {
		// TODO Auto-generated method stub
		return ghmrcgDao.getGhmrCgfortg(sid, stdate, eddate);
	}
	
	public String[][] getFuWuDuiXiangBiao(String Shi, String Xian, String Xiang, String Cun, String XingMing, String XingMingSuoXie){
		return csconsumerDao.getFuWuDuiXiangBiao(Shi, Xian, Xiang, Cun, XingMing, XingMingSuoXie);
	}
	
	public List<Cfcity> getShiJiLieBiao(Integer ShengId){
		return cfcityDao.getCfcityByProvNameID(ShengId);
	}

	public List<Cfprefecture> getXianJiLieBiao(long ShiId){
		return cfprefectureDao.getPrefectureByCityID(ShiId);
	}
	
	public  List<Cftown> getXiangJiLieBiao(long  XianID){
		return cftownDao.getAllTownByPrefectureId(XianID);
	}

	public List<Cfvillage> getCunJiLieBiao(long XiangId){
		return cfvillageDao.getAllVilleagesByTownId(XiangId);
	}
	
}
