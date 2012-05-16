package leo.cf.service.impl;

import java.util.List;

import leo.cf.service.iface.CfXiTongSheZhiService;
import leo.cf.dao.iface.CfmedicalInstDao;
import leo.entity.Cfcity;
import leo.entity.Cfprefecture;
import leo.entity.Cfprovince;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.CzdisposalType;
import leo.entity.CzdisposeDivaricateU;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.GhregisterType;
import leo.entity.OsfnAuthorityForm;
import leo.entity.OsfnBlocks;
import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.OsudefaultFn;
import leo.entity.YfmdosageType;
import leo.entity.YfmdosageUnit;
import leo.entity.Yfmmanufacturer;
import leo.entity.Yfmtype;
import leo.entity.YfmwayTo;
import leo.os.dao.iface.OsunitHasSDao;
import leo.os.dao.iface.OsuformDao;
import leo.yf.dao.iface.YFMTypeDao;
import leo.yf.dao.iface.YfmdosageTypeDao;
import leo.yf.dao.iface.YfmwayToDao;
import leo.yf.dao.iface.YfmdosageUnitDao;
import leo.yf.dao.iface.YfmmanufacturerDao;
import leo.mz.dao.iface.CzdisposalTypeDao;
import leo.mz.dao.iface.MzCzdisposeItemDescribeDao;
import leo.mz.dao.iface.MzCzdisposeDivaricateUDao;
import leo.gh.dao.iface.GhregisterTypeDao;
import leo.cf.dao.iface.CfprovinceDao;
import leo.cf.dao.iface.CfcityDao;
import leo.cf.dao.iface.CfprefectureDao;
import leo.cf.dao.iface.CftownDao;
import leo.os.dao.iface.OsmedicalInstInfoDao;
import leo.os.dao.iface.OsfnBlocksDao;
import leo.os.dao.iface.OsudefaultfnDao;
import leo.os.dao.iface.OsfnAuthorityFormDao;
import leo.os.dao.iface.OsstuffDao;
import leo.cf.dao.iface.CfvillageDao;
import leo.cf.dao.iface.CfgroupDao;

public class CfXiTongSheZhiServiceImpl implements CfXiTongSheZhiService {

	private CfmedicalInstDao cfmedicalInstDao;
	private OsunitHasSDao osunitHasSDao;
	private OsuformDao osuformDao;
	private YFMTypeDao yFMTypeDao;
	private YfmdosageTypeDao yfmdosageTypeDao;
	private YfmwayToDao yfmwayToDao;
	private YfmdosageUnitDao yfmdosageUnitDao;
	private YfmmanufacturerDao yfmmanufacturerDao;
	private CzdisposalTypeDao czdisposalTypeDao;
	private MzCzdisposeItemDescribeDao mzCzdisposeItemDescribeDao;
	private MzCzdisposeDivaricateUDao mzCzdisposeDivaricateUDao;
	private GhregisterTypeDao ghregisterTypeDao;
	private CfprovinceDao cfprovinceDao;
	private CfcityDao cfcityDao;
	private CfprefectureDao cfprefectureDao;
	private CftownDao cftownDao;
	private OsmedicalInstInfoDao osmedicalInstInfoDao;
	private OsfnBlocksDao osfnBlocksDao;
	private OsudefaultfnDao osudefaultfnDao;
	private OsfnAuthorityFormDao osfnAuthorityFormDao;
	private OsstuffDao osstuffDao;
	private CfvillageDao cfvillageDao;
	private CfgroupDao cfgroupDao;
	

	public void setCfgroupDao(CfgroupDao cfgroupDao) {
		this.cfgroupDao = cfgroupDao;
	}

	public void setCfvillageDao(CfvillageDao cfvillageDao) {
		this.cfvillageDao = cfvillageDao;
	}

	public void setOsstuffDao(OsstuffDao osstuffDao) {
		this.osstuffDao = osstuffDao;
	}

	public void setOsfnAuthorityFormDao(OsfnAuthorityFormDao osfnAuthorityFormDao) {
		this.osfnAuthorityFormDao = osfnAuthorityFormDao;
	}

	public void setOsudefaultfnDao(OsudefaultfnDao osudefaultfnDao) {
		this.osudefaultfnDao = osudefaultfnDao;
	}

	public void setOsfnBlocksDao(OsfnBlocksDao osfnBlocksDao) {
		this.osfnBlocksDao = osfnBlocksDao;
	}

	public void setOsmedicalInstInfoDao(OsmedicalInstInfoDao osmedicalInstInfoDao) {
		this.osmedicalInstInfoDao = osmedicalInstInfoDao;
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

	public void setCfprovinceDao(CfprovinceDao cfprovinceDao) {
		this.cfprovinceDao = cfprovinceDao;
	}

	public void setGhregisterTypeDao(GhregisterTypeDao ghregisterTypeDao) {
		this.ghregisterTypeDao = ghregisterTypeDao;
	}

	public void setMzCzdisposeDivaricateUDao(
			MzCzdisposeDivaricateUDao mzCzdisposeDivaricateUDao) {
		this.mzCzdisposeDivaricateUDao = mzCzdisposeDivaricateUDao;
	}

	public void setMzCzdisposeItemDescribeDao(
			MzCzdisposeItemDescribeDao mzCzdisposeItemDescribeDao) {
		this.mzCzdisposeItemDescribeDao = mzCzdisposeItemDescribeDao;
	}

	public void setCzdisposalTypeDao(CzdisposalTypeDao czdisposalTypeDao) {
		this.czdisposalTypeDao = czdisposalTypeDao;
	}

	public void setYfmmanufacturerDao(YfmmanufacturerDao yfmmanufacturerDao) {
		this.yfmmanufacturerDao = yfmmanufacturerDao;
	}

	public void setYfmdosageUnitDao(YfmdosageUnitDao yfmdosageUnitDao) {
		this.yfmdosageUnitDao = yfmdosageUnitDao;
	}

	public void setYfmwayToDao(YfmwayToDao yfmwayToDao) {
		this.yfmwayToDao = yfmwayToDao;
	}

	public void setYfmdosageTypeDao(YfmdosageTypeDao yfmdosageTypeDao) {
		this.yfmdosageTypeDao = yfmdosageTypeDao;
	}

	public void setyFMTypeDao(YFMTypeDao yFMTypeDao) {
		this.yFMTypeDao = yFMTypeDao;
	}

	public void setOsunitHasSDao(OsunitHasSDao osunitHasSDao) {
		this.osunitHasSDao = osunitHasSDao;
	}

	public void setOsuformDao(OsuformDao osuformDao) {
		this.osuformDao = osuformDao;
	}

	public void setCfmedicalInstDao(CfmedicalInstDao cfmedicalInstDao) {
		this.cfmedicalInstDao = cfmedicalInstDao;
	}

	public boolean updateBianJiYiLiaoJiGouPeiZhi(String[][] NeiRong){ //NeiRong 内容 0:配置名称   1:值   2:医疗机构ID
		for (int i=0; i<NeiRong.length;i++){
			if (cfmedicalInstDao.getCFMedicalInstShiFouCiZi(NeiRong[i][0], Integer.parseInt(NeiRong[i][2]))){ //修改
				cfmedicalInstDao.changeValueBydisposeName(NeiRong[i][0], NeiRong[i][1], Integer.parseInt(NeiRong[i][2]));
			}
			else{ //增加
				cfmedicalInstDao.addCfmedicalInstInfo(NeiRong[i][0], NeiRong[i][1], Integer.parseInt(NeiRong[i][2]));
			}
		}
		return true;
	}

	public String[][] getPeiZhiXiangMuZhi(String[][] XiangMu){
		String Zhi;
		String[][] JieGuo = new String[XiangMu.length][2];
		
		for (int i=0;i<XiangMu.length;i++){
			Zhi = cfmedicalInstDao.getValueBydisposeName(XiangMu[i][0], Integer.parseInt(XiangMu[i][1]));
			JieGuo[i][0] = XiangMu[i][0];
			JieGuo[i][1] = Zhi;
		}
		return JieGuo;
	}

	public boolean delKeShi(Integer KeShiID){
		osunitHasSDao.delOsunitHasSByUnitID(KeShiID);
		osuformDao.delUformByID(KeShiID);
		return true;
	}
	
	public List<Yfmtype> getYaoPinLeiBie(){
		return yFMTypeDao.getYFMType();
	}
	
	public List<YfmdosageType> getJiXing(){
		return yfmdosageTypeDao.getYfmdosageType();
	}
	
	public List<YfmwayTo> getGeiYaoFangShi(){
		return yfmwayToDao.getYfmwayTo();
	}
	
	public List<YfmdosageUnit> getJiLiangDanWei(){
		return yfmdosageUnitDao.getYfmdosageUnit();
	}

	public List<Yfmmanufacturer> getShengChanChangJia(String name){
		return yfmmanufacturerDao.getYfmmanufacturer(name);
	}

	public boolean addYaoPingCanShu(List<Yfmtype> LeiBie, 
									List<YfmdosageType> JiXing, 
									List<YfmwayTo> GeiYaoFangShi, 
									List<YfmdosageUnit> DanWei, 
									List<Yfmmanufacturer> ChangJia,
									boolean FLeiBie,
									boolean FJiXing,
									boolean FGeiYaoFangShi,
									boolean FDanWei,
									boolean FChangJia){
		
		if (FLeiBie) {
			yFMTypeDao.delTFMType(""); //删除药品类别
			for (int i=0;i<LeiBie.size();i++)
				yFMTypeDao.addYFMType(LeiBie.get(i)); //保存药品类别
		}
		if (FJiXing){
			yfmdosageTypeDao.delYfmdosageType(""); //删除药品剂型
			for (int i=0;i<JiXing.size();i++)
				yfmdosageTypeDao.addYfmdosageType(JiXing.get(i)); //保存药品剂型
		}
		if (FGeiYaoFangShi){
			yfmwayToDao.delYfmwayTo(""); //删除给药方式
			for (int i=0;i<GeiYaoFangShi.size();i++)
				yfmwayToDao.addYfmwayTo(GeiYaoFangShi.get(i)); //保存给药方式
		}
		if (FDanWei){
			yfmdosageUnitDao.delYfmdosageUnit(""); //删除剂量单位
			for (int i=0;i<DanWei.size();i++)
				yfmdosageUnitDao.addYfmdosageUnit(DanWei.get(i)); //保存剂量单位
		}
		if (FChangJia){
			yfmmanufacturerDao.delYfmmanufacturer(""); //删除生产厂家
			for (int i=0;i<ChangJia.size();i++)
				yfmmanufacturerDao.addYfmmanufacturer(ChangJia.get(i)); //保存生产厂家
		}
		return true;
	}

	public List<CzdisposalType> getChuZhiLeiBie(){
		return czdisposalTypeDao.getCzdisposalType();
	}

	public boolean addChuZhiLeiBie(List<CzdisposalType> LeiBie, boolean FLeiBie){
		czdisposalTypeDao.delCzdisposalType(""); //删除处置类别
		if (FLeiBie){ //保存处置类别
			for (int i=0;i<LeiBie.size();i++)
				czdisposalTypeDao.addCzdisposalType(LeiBie.get(i));
		}
		return true;
	}

	public List<CzdisposeItemDescribe> getChuZhiXiangMu(String MingCheng, String PingYin, String LeiBie, Integer YiLiaoJiGou){
		return mzCzdisposeItemDescribeDao.getCZDisposeItemDescribeByNameAndType(MingCheng, PingYin, LeiBie, YiLiaoJiGou);
	}

	public List<CzdisposeDivaricateU> getChuZhiKaiChuKeShi(Integer czid){
		return mzCzdisposeDivaricateUDao.getCzdisposeDivaricateUList(czid);
	}
	
	public Integer getChuZhiXiangMuCunZi(String MingCheng, Integer YiLiaoJiGou){
		return mzCzdisposeItemDescribeDao.getCZDisposeItemDescribeCunZi(MingCheng, YiLiaoJiGou);
	}

	public Integer getGuaHaoLeiBieCunZai(String MingCheng, Integer YiLiaoJiGou){
		return ghregisterTypeDao.getGhregisterTypeCunZai(MingCheng, YiLiaoJiGou);
	}

	public List<GhregisterType> getGuaHaoXiangMu(String MingCheng, String PingYin, Integer YiLiaoJiGou){
		return ghregisterTypeDao.getgetGhregisterTypeByNameAndSpell(MingCheng, PingYin, YiLiaoJiGou);
	}

	public boolean addChuZhiXiangMu(CzdisposeItemDescribe XiangMu, List<CzdisposeDivaricateU> KaiChuKeShi){
		mzCzdisposeItemDescribeDao.addCzdisposeItemDescribe(XiangMu);
		for (int i=0;i<KaiChuKeShi.size();i++){
			KaiChuKeShi.get(i).setItemTypeId(XiangMu.getItemTypeId());
			mzCzdisposeDivaricateUDao.addCzdisposeDivaricateU(KaiChuKeShi.get(i));
		}
		return true;
	}

	public boolean delChuZhiXiangMu(Integer XiangMuID){
		mzCzdisposeDivaricateUDao.deleCzdisposeDivaricateUByitemTypeId(XiangMuID); //删除开出科室
		mzCzdisposeItemDescribeDao.deleCzdisposeItemDescribe(XiangMuID); //删除处置项目
		return true;
	}

	public boolean updateChuZhiXiangMu(CzdisposeItemDescribe XiangMu, List<CzdisposeDivaricateU> KaiChuKeShi){
		mzCzdisposeItemDescribeDao.updateCzdisposeItemDescribe(XiangMu); //修改处置项目
		mzCzdisposeDivaricateUDao.deleCzdisposeDivaricateUByitemTypeId(XiangMu.getItemTypeId()); //删除旧开出科室
		for (int i=0;i<KaiChuKeShi.size();i++)
			mzCzdisposeDivaricateUDao.addCzdisposeDivaricateU(KaiChuKeShi.get(i)); //保存新开出科室
		return true;
	}
	
	public boolean addGuaHaoLeiXing(GhregisterType GuaHaoLeiXing){
		return ghregisterTypeDao.addGhregisterType(GuaHaoLeiXing);
	}

	public boolean updateGuaHaoLeiXing(GhregisterType GuaHaoLeiXing){
		return ghregisterTypeDao.updateGhregisterType(GuaHaoLeiXing);
	}
	
	public boolean delGuaHaoLeiXing(Integer LeiXingID){
		return ghregisterTypeDao.delGhregisterTypeByID(LeiXingID);
	}

	public List<Cfprovince> getShengJiLieBiao(Integer ShengID){
		return cfprovinceDao.getCfprovince(ShengID);
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

	public OsmedicalInstInfo getYiLiaoJiGou(int mid){
		return osmedicalInstInfoDao.getOsmedicalInstInfoById(mid);
	}

	public boolean addYiLiaoJiGou(OsmedicalInstInfo YiLiaoJiGou){
		return osmedicalInstInfoDao.addOSMedicalInstInfo(YiLiaoJiGou);
	}

	public boolean updateYiLiaoJiGou(OsmedicalInstInfo YiLiaoJiGou){
		return osmedicalInstInfoDao.updateOSMedicalInstInfo(YiLiaoJiGou);
	}
	
	public List<OsfnBlocks> getFuGongNeng(){
		return osfnBlocksDao.getOsfnBlocks();
	}

	public boolean addKeShiMoRenGongNeng(List<OsudefaultFn> osudefaultFn){
		for (int i=0;i<osudefaultFn.size();i++)
			osudefaultfnDao.addOSUDefaultFn(osudefaultFn.get(i));
		return true;
	}

	public String[][] getKeShiMoRenGongNeng(Integer uid){
		return osudefaultfnDao.getOSUDefaultFn(uid);
	}
	
	public boolean delKeShiMoRenGongNeng(Integer uid, Integer FcBlocksID){
		return osudefaultfnDao.delOSUDefaultFn(uid, FcBlocksID);
	}

	public boolean addPeiZhiKeShi(long sid, int[] uidlist, boolean CaiDan, List<OsfnAuthorityForm> MoRenCaiDan){
		osunitHasSDao.addOsunitHasSBySidandUid(sid, uidlist);
		if (CaiDan){
			for (int i=0;i<MoRenCaiDan.size();i++)
				osfnAuthorityFormDao.addOSFnAuthorityForm(MoRenCaiDan.get(i));
		}
		return true;
	}

	public boolean updatePeiZhiKeShi(long sid, int[] uidlist, boolean CaiDan, List<OsfnAuthorityForm> MoRenCaiDan){
		osunitHasSDao.deleteOsunitHasSBySid(sid);
		osunitHasSDao.addOsunitHasSBySidandUid(sid, uidlist);
		osfnAuthorityFormDao.delOSFnAuthorityForm(sid);
		if (CaiDan){
			for (int i=0;i<MoRenCaiDan.size();i++)
				osfnAuthorityFormDao.addOSFnAuthorityForm(MoRenCaiDan.get(i));
		}
		return true;
	}

	public String[][] getKeShiGongNeng(Integer uid){
		return osudefaultfnDao.getOSUDefaultFn(uid);
	}

	public Integer getCaiDanMaxID(){
		return osfnAuthorityFormDao.getCaiDanMaxID();
	}

	public List<OsfnBlocks> getZiMoKuai(Integer FuGongNengID){
		return osfnBlocksDao.getZiMoKuai(FuGongNengID);
	}

	public String[][] getCaiDanShu(long sid){
		return osfnAuthorityFormDao.getCaiDanShu(sid);
	}
	
	public boolean updateCaiDanMingCheng(Integer MenuID, String MenuName){
		return osfnAuthorityFormDao.updateCaiDanMingCheng(MenuID, MenuName);
	}
	
	public boolean delCaiDan(String LeiXing, Integer MenuID, Long YuanGongID){
		return osfnAuthorityFormDao.delCaiDan(LeiXing, MenuID, YuanGongID);
	}

	public boolean addCaiDan(List<OsfnAuthorityForm> CaiDanNeiRong){
		for (int i=0;i<CaiDanNeiRong.size();i++)
			osfnAuthorityFormDao.addOSFnAuthorityForm(CaiDanNeiRong.get(i));
		return true;
	}

	public Osstuff getDengLuYuanGong(String loginname, String password){
		return osstuffDao.getStuffByNameAndPassword(loginname, password);
	}

	public boolean updateYongHu(Long SID, String LoginName, String Password){
		return osstuffDao.updateYongHu(SID, LoginName, Password);
	}

	public boolean updateKuaiJianAnNiu(Integer MenuID, String QuickName, String QuickImageID, String QuickClass){
		return osfnAuthorityFormDao.updateKuaiJieAnNiu(MenuID, QuickName, QuickImageID, QuickClass);
	}

	public String[][] getKuaiJieAnNiu(Long SID){
		return osfnAuthorityFormDao.getKuaiJieAnNiu(SID);
	}

	public String[][] getKuaiJieAnNiuByCaiDanID(Integer MenuID){
		return osfnAuthorityFormDao.getKuaiJieAnNiuByCaiDanID(MenuID);
	}
	
	public List<OsfnBlocks> GetGongNengLei(Integer FnBlocksID){
		return osfnBlocksDao.GetGongNengLei(FnBlocksID); 
	}

	public String[][] getMuLu(Long sid, Integer FatherMenuID){
		return osfnAuthorityFormDao.getMuLu(sid, FatherMenuID);
	}

	public boolean updateMuLu(Integer MenuID, Integer FatherMenuID){
		return osfnAuthorityFormDao.updateMuLu(MenuID, FatherMenuID);
	}

	public String[][] getZaiMuLuLi(Long Sid, Integer FatherMenuID){
		return osfnAuthorityFormDao.getZaiMuLuLi(Sid, FatherMenuID);
	}

	public boolean getYongHuCunZai(String LoginName, Long SID){
		return osstuffDao.getYongHuCunZai(LoginName,SID);
	}

	public String getShengName(Integer ShengID){
		return cfprovinceDao.getProvinceName(ShengID);
	}

	public String getShiName(Integer ShiID){
		return cfcityDao.getcityName(ShiID);
	}
	
    public String getXianName(Long XianID){
    	return cfprefectureDao.getPrefectureByprefectureId(XianID); 
    }

    public String getMaxXiangID(long XianID){
    	return cftownDao.getMaxTownID(XianID); 
    }

    public boolean addXiang(long TownID, long PrefectureID, String TownName){
    	return cftownDao.addTown(TownID, PrefectureID, TownName);
    }

	public boolean delXiang(long XiangID){
		List<Cfvillage> cfvillage;
		cfvillage = cfvillageDao.getAllVilleagesByTownId(XiangID); //得到乡里的村
		for (int i=0;i<cfvillage.size();i++){
			cfgroupDao.delCFGroup(cfvillage.get(i).getVillageId());
		}
		cfvillageDao.delVillage(XiangID); //删除乡里的村
		cftownDao.delTown(XiangID); //删除乡
		return true;
	}
	
	public String getMaxCunID(long XiangID){
		return cfvillageDao.getMaxID(XiangID); 
	}

	public boolean addCun(long VillageID, long TownID, String VillageName){
		return cfvillageDao.addVillage(VillageID, TownID, VillageName);
	}
	
	public boolean delCun(long VillageID){
		cfgroupDao.delCFGroup(VillageID); //删除村里的组
		cfvillageDao.delVillageByVillageID(VillageID); //删除村		
		return true;
	}

	public boolean updateXiang(long TownID, String Name){
		return cftownDao.updateTown(TownID, Name);
	}

	public boolean updateCun(long VillageID, String name){
		return cfvillageDao.updateVillage(VillageID, name);
	}
	
}
