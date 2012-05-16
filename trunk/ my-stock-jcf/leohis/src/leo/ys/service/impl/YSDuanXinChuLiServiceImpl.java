package leo.ys.service.impl;

import java.util.List;

import leo.cf.dao.iface.CfcityDao;
import leo.cf.dao.iface.CfprefectureDao;
import leo.cf.dao.iface.CfprovinceDao;
import leo.cf.dao.iface.CftownDao;
import leo.cf.dao.iface.CfvillageDao;
import leo.cs.dao.iface.CsconsumerDao;
import leo.entity.Cfcity;
import leo.entity.Cfprefecture;
import leo.entity.Cfprovince;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.Csconsumer;
import leo.entity.HealthyPregnantSms;
import leo.entity.OsmedicalInstInfo;
import leo.entity.SmsModule;
import leo.entity.SmsModuleTerm;
import leo.os.dao.iface.OsmedicalInstInfoDao;
import leo.ys.dao.iface.YSEarlyPregnancyVisitDao;
import leo.ys.dao.iface.YSFamiliRecordBasicInfoDao;
import leo.ys.dao.iface.YSHealthyPregnantSmsDao;
import leo.ys.dao.iface.YSNotifyDao;
import leo.ys.dao.iface.YSPregnancyResultDao;
import leo.ys.dao.iface.YSSmsModuleDao;
import leo.ys.dao.iface.YSSmsModuleTermDao;
import leo.ys.service.iface.YSDuanXinChuLiService;


public class YSDuanXinChuLiServiceImpl implements YSDuanXinChuLiService {
	private YSSmsModuleDao ySSmsModuleDao;
	private YSSmsModuleTermDao ySSmsModuleTermDao;
	private YSFamiliRecordBasicInfoDao ySFamiliRecordBasicInfoDao;
	private YSPregnancyResultDao ySPregnancyResultDao;
	private YSEarlyPregnancyVisitDao ySEarlyPregnancyVisitDao;
	private YSNotifyDao ySNotifyDao;
	private OsmedicalInstInfoDao osmedicalInstInfoDao;
	private CfcityDao cfcityDao;
	private CfprefectureDao cfprefectureDao;
	private CftownDao cftownDao;
	private CfvillageDao cfvillageDao;
	private CsconsumerDao csconsumerDao;
	private YSHealthyPregnantSmsDao ySHealthyPregnantSmsDao;
	private CfprovinceDao cfprovinceDao;
	
	
	public void setCfprovinceDao(CfprovinceDao cfprovinceDao) {
		this.cfprovinceDao = cfprovinceDao;
	}

	public void setySHealthyPregnantSmsDao(
			YSHealthyPregnantSmsDao ySHealthyPregnantSmsDao) {
		this.ySHealthyPregnantSmsDao = ySHealthyPregnantSmsDao;
	}

	public void setCsconsumerDao(CsconsumerDao csconsumerDao) {
		this.csconsumerDao = csconsumerDao;
	}

	public void setCfvillageDao(CfvillageDao cfvillageDao) {
		this.cfvillageDao = cfvillageDao;
	}

	public void setCftownDao(CftownDao cftownDao) {
		this.cftownDao = cftownDao;
	}

	public void setCfprefectureDao(CfprefectureDao cfprefectureDao) {
		this.cfprefectureDao = cfprefectureDao;
	}

	public List<Cfprovince> getShengJiLieBiao(Integer ShengID){
		return cfprovinceDao.getCfprovince(ShengID);
	}
	
	public void setCfcityDao(CfcityDao cfcityDao) {
		this.cfcityDao = cfcityDao;
	}

	public void setOsmedicalInstInfoDao(OsmedicalInstInfoDao osmedicalInstInfoDao) {
		this.osmedicalInstInfoDao = osmedicalInstInfoDao;
	}

	public void setySNotifyDao(YSNotifyDao ySNotifyDao) {
		this.ySNotifyDao = ySNotifyDao;
	}

	public void setySEarlyPregnancyVisitDao(
			YSEarlyPregnancyVisitDao ySEarlyPregnancyVisitDao) {
		this.ySEarlyPregnancyVisitDao = ySEarlyPregnancyVisitDao;
	}

	public void setySPregnancyResultDao(YSPregnancyResultDao ySPregnancyResultDao) {
		this.ySPregnancyResultDao = ySPregnancyResultDao;
	}

	public void setySFamiliRecordBasicInfoDao(
			YSFamiliRecordBasicInfoDao ySFamiliRecordBasicInfoDao) {
		this.ySFamiliRecordBasicInfoDao = ySFamiliRecordBasicInfoDao;
	}

	public void setySSmsModuleDao(YSSmsModuleDao ySSmsModuleDao) {
		this.ySSmsModuleDao = ySSmsModuleDao;
	}

	public void setySSmsModuleTermDao(YSSmsModuleTermDao ySSmsModuleTermDao) {
		this.ySSmsModuleTermDao = ySSmsModuleTermDao;
	}

	public Long addMoBanTou(SmsModule MoBanTou){
		return ySSmsModuleDao.addSmsModule(MoBanTou);
	}

	public List<SmsModule> getMobanTou(String LeiXing, Long DanWeiID){
		return ySSmsModuleDao.getSmsModule(LeiXing, DanWeiID);
	}

	public boolean updateMobanTou(SmsModule MoBanTou){
		return ySSmsModuleDao.updateSmsModule(MoBanTou);
	}

	public Long addMoBanXiang(SmsModuleTerm MoBanXiang){
		return ySSmsModuleTermDao.addSmsModuleTerm(MoBanXiang);
	}
	
	public List<SmsModuleTerm> getMoBanXiang(Long MoBanID){
		return ySSmsModuleTermDao.getsmsModuleTerm(MoBanID);
	}

	public boolean updateMoBanXiang(SmsModuleTerm MoBanXiang){
		return ySSmsModuleTermDao.updateSmsModuleTerm(MoBanXiang);
	}

	public boolean delMoBanXiang(Long MobanXiangID, Long MoBanID){
		return ySSmsModuleTermDao.delSmsModuleTerm(MobanXiangID, MoBanID);
	}

	public boolean delMoBan(Long MoBanID){
		ySSmsModuleDao.delSmsModule(MoBanID);
		ySSmsModuleTermDao.delSmsModuleTerm(-2l, MoBanID);
		return true;
	}

	public String[][] getMoBanMingCheng(Long DanWeiID){
		return ySSmsModuleDao.getMoBanMingCheng(DanWeiID);
	}

	public String[][] getXiangNeiRong(Long MoBanID){
		return ySSmsModuleTermDao.getXiangNeiRong(MoBanID);
	}

	public String[][] getDuanXinDaiFaNeiRong(Integer TianShu, String LeiXing){
		if (LeiXing.equals("预计怀孕服务")){
			return ySFamiliRecordBasicInfoDao.getDuanXinRenYuan(TianShu);
		}
		else if (LeiXing.equals("出生服务")){
			return ySPregnancyResultDao.getChuShengDuanXinRenYuan(TianShu);
		}
		else if (LeiXing.equals("实际怀孕服务")){
			return ySEarlyPregnancyVisitDao.getHuaiYunDuanXinRenYuan(TianShu);
		}
		else if (LeiXing.equals("评估服务")){
			return ySNotifyDao.getGaoZhiDuanXinRenYuan(TianShu);
		}
		else
			return null;
	}
	public String getGaoZhiNeiRong(String DangAnHao){
		return ySNotifyDao.getGaoZhiNeiRong(DangAnHao);
	}

	public OsmedicalInstInfo getYiLiaoJiGouById(int mid){
		return osmedicalInstInfoDao.getOsmedicalInstInfoById(mid);
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

	public List<Csconsumer> getFuWuDuXiang(String Shi, String Xian, String Xiang, String Cun, String Zu, String ShengFenZheng, String XingMing , String XingMingSuoXie,Long FuWuDuiXiangID){
		return csconsumerDao.getDuiXiangByHuShi(Shi, Xian, Xiang, Cun, Zu, ShengFenZheng, XingMing, XingMingSuoXie, FuWuDuiXiangID);
	}

	public boolean addDaiFaDuanXinNeiRong(List<HealthyPregnantSms> DuanXinNeiRong){
		for (int i=0;i<DuanXinNeiRong.size();i++){
			ySHealthyPregnantSmsDao.addHealthyPregnantSms(DuanXinNeiRong.get(i));
		}
		return true;
	}

}
