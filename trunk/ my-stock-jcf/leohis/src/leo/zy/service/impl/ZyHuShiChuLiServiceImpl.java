package leo.zy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import leo.entity.Cfcity;
import leo.entity.Cfgroup;
import leo.entity.Cfprefecture;
import leo.entity.Cfprovince;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.Csconsumer;
import leo.entity.CsheadShow;
import leo.entity.Czacontent;
import leo.entity.Czdispose;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.SfipdepositRecord;
import leo.entity.YfexbankAitem;
import leo.entity.YfmexbankA;
import leo.entity.ZydoctorAdviceLongTerm;
import leo.entity.Zyinpatient;
import leo.zy.service.iface.ZyHuShiChuLiService;
import leo.zy.dao.iface.ZyInpatientDao;
import leo.cf.dao.iface.CfcityDao;
import leo.cf.dao.iface.CfprefectureDao;
import leo.cf.dao.iface.CftownDao;
import leo.cf.dao.iface.CfvillageDao;
import leo.cs.dao.iface.CsconsumerDao;
import leo.cf.dao.iface.CfprovinceDao;
import leo.cf.dao.iface.CfgroupDao;
import leo.cs.dao.iface.CsheadShowDao;
import leo.zy.dao.iface.ZybedDao;
import leo.mz.dao.iface.MzCzdisposeDao;
import leo.sf.dao.iface.SfipdepositRecordDao;
import leo.zy.dao.iface.ZydoctorAdviceDao;
import leo.yf.dao.iface.YfmexbankADao;
import leo.yf.dao.iface.YfExbankAItemDao;
import leo.mz.dao.iface.MzCzdisposeItemDescribeDao;
import leo.zy.dao.iface.ZyipteatmentDao;
import leo.mz.dao.iface.MzCZAContentDao;
import leo.yf.dao.iface.YfminbankADao;
import leo.zy.dao.iface.ZyipmedicineDao;
import leo.yf.dao.iface.YfinbankAitemDao;

public class ZyHuShiChuLiServiceImpl implements ZyHuShiChuLiService {
	private ZyInpatientDao zyInpatientDao; 
	private CfcityDao cfcityDao;
	private CfprefectureDao cfprefectureDao;
	private CftownDao cftownDao;
	private CfvillageDao cfvillageDao;
	private CsconsumerDao csconsumerDao;
	private CfprovinceDao cfprovinceDao;
	private CfgroupDao cfgroupDao;
	private CsheadShowDao csheadShowDao;
	private ZybedDao zybedDao;
	private MzCzdisposeDao mzCzdisposeDao;
	private SfipdepositRecordDao sfipdepositRecordDao;
	private ZydoctorAdviceDao zydoctorAdviceDao;
	private YfmexbankADao yfmexbankADao;
	private YfExbankAItemDao yfExbankAItemDao;
	private MzCzdisposeItemDescribeDao mzCzdisposeItemDescribeDao;
	private ZyipteatmentDao zyipteatmentDao;
	private MzCZAContentDao mzCZAContentDao;
	private YfminbankADao yfminbankADao;
	private ZyipmedicineDao zyipmedicineDao;
	private YfinbankAitemDao yfinbankAitemDao;
	

	
	public void setYfinbankAitemDao(YfinbankAitemDao yfinbankAitemDao) {
		this.yfinbankAitemDao = yfinbankAitemDao;
	}

	public void setZyipmedicineDao(ZyipmedicineDao zyipmedicineDao) {
		this.zyipmedicineDao = zyipmedicineDao;
	}

	public void setYfminbankADao(YfminbankADao yfminbankADao) {
		this.yfminbankADao = yfminbankADao;
	}

	public void setMzCZAContentDao(MzCZAContentDao mzCZAContentDao) {
		this.mzCZAContentDao = mzCZAContentDao;
	}

	public void setZyipteatmentDao(ZyipteatmentDao zyipteatmentDao) {
		this.zyipteatmentDao = zyipteatmentDao;
	}

	public void setMzCzdisposeItemDescribeDao(
			MzCzdisposeItemDescribeDao mzCzdisposeItemDescribeDao) {
		this.mzCzdisposeItemDescribeDao = mzCzdisposeItemDescribeDao;
	}

	public void setYfmexbankADao(YfmexbankADao yfmexbankADao) {
		this.yfmexbankADao = yfmexbankADao;
	}

	public void setYfExbankAItemDao(YfExbankAItemDao yfExbankAItemDao) {
		this.yfExbankAItemDao = yfExbankAItemDao;
	}

	public void setZydoctorAdviceDao(ZydoctorAdviceDao zydoctorAdviceDao) {
		this.zydoctorAdviceDao = zydoctorAdviceDao;
	}

	public void setSfipdepositRecordDao(SfipdepositRecordDao sfipdepositRecordDao) {
		this.sfipdepositRecordDao = sfipdepositRecordDao;
	}

	public void setMzCzdisposeDao(MzCzdisposeDao mzCzdisposeDao) {
		this.mzCzdisposeDao = mzCzdisposeDao;
	}

	public void setZybedDao(ZybedDao zybedDao) {
		this.zybedDao = zybedDao;
	}

	public void setCsheadShowDao(CsheadShowDao csheadShowDao) {
		this.csheadShowDao = csheadShowDao;
	}

	public void setCfgroupDao(CfgroupDao cfgroupDao) {
		this.cfgroupDao = cfgroupDao;
	}

	public void setCfprovinceDao(CfprovinceDao cfprovinceDao) {
		this.cfprovinceDao = cfprovinceDao;
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

	public void setCfcityDao(CfcityDao cfcityDao) {
		this.cfcityDao = cfcityDao;
	}

	public void setZyInpatientDao(ZyInpatientDao zyInpatientDao) {
		this.zyInpatientDao = zyInpatientDao;
	}

	public List<Cfprovince> getShengJiLieBiao(Integer ShengID){
		return cfprovinceDao.getCfprovince(ShengID);
	}
	
	public String[][] getHuShiShouYeZhuYuanRenYuan(String zyh, Integer cwh,
			String xm, String xmsx, Integer zybID, Long zrhs) {
		return zyInpatientDao.getHuShiShouYeZhuYuanRenYuan(zyh, cwh, xm, xmsx, zybID, zrhs);
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

	public List<Cfgroup> getZhuJiLieBiao(long CunId){
		return cfgroupDao.getAllCfgroupsByVilleageId(CunId);
	}
	
	public List<Csconsumer> getFuWuDuXiang(String Shi, String Xian, String Xiang, String Cun, String Zu, String ShengFenZheng, String XingMing , String XingMingSuoXie,Long FuWuDuiXiangID){
		return csconsumerDao.getDuiXiangByHuShi(Shi, Xian, Xiang, Cun, Zu, ShengFenZheng, XingMing, XingMingSuoXie, FuWuDuiXiangID);
	}
	
	public String getMaxID(){
		return zyInpatientDao.getMaxID();
	}
	
	public boolean addZhuYuan(Zyinpatient zyinpatient){
		return zyInpatientDao.addZYInpatient(zyinpatient);
	}
	
	public String[][] getZYInpatient(String ZhuYuanHao, Integer ChuangWeiHao, String XingMing, String XingMingSuoXie, String ShengQingShiJian_B, String ShengQingShiJian_E, String RuYuanShiJian_B, String RuYuanShiJian_E, String ShengQingZhuangTai, String YueE1, String GuanXi, Integer ShiFouChuYuan, String ChuYuanShiJian_B, String ChuYuanShiJian_E, Integer FeiYongLeiXingID, Integer ZhuYuanBuId, String ShengFeiZheng, Long FuWuDuiXiangID){
		return zyInpatientDao.getZYInpatient(ZhuYuanHao, ChuangWeiHao, XingMing, XingMingSuoXie, ShengQingShiJian_B, ShengQingShiJian_E, RuYuanShiJian_B, RuYuanShiJian_E, ShengQingZhuangTai, YueE1, GuanXi, ShiFouChuYuan, ChuYuanShiJian_B, ChuYuanShiJian_E, FeiYongLeiXingID, ZhuYuanBuId, ShengFeiZheng, FuWuDuiXiangID);
	}
	
	public Long addFuWuDuiXiang(Csconsumer FuWuDuiXiang, String ShenFenZheng, String TouXiang){
		Csconsumer csconsumer;
		
		csconsumerDao.addCsconsumerInfo(FuWuDuiXiang); //保存服务对象信息
		csconsumer = csconsumerDao.getCInfoByIDCardNum(ShenFenZheng); //返回该服务对象ID
		
		if (TouXiang != null && !TouXiang.equals("")){  //保存头像
			CsheadShow TaoXiangNeiRong = new CsheadShow();
			TaoXiangNeiRong.setCsId(csconsumer.getCsId());
			TouXiang = csconsumer.getCsId().toString() + ".jpg";
			TaoXiangNeiRong.setHeadShow(TouXiang);
			csheadShowDao.addCsheadShow(TaoXiangNeiRong);
		}
		return csconsumer.getCsId();
	}
	
	public String getTouXiang(long id){
		return csheadShowDao.getCsheadShowById(id);
	}
	
	public boolean updatePiZhunRuYuan(Zyinpatient zyinpatient, Integer ChuangWeiHao, String ZhuangTai){
		zyInpatientDao.updateZYInpatient(zyinpatient);
		zybedDao.updateChuangWeiZhuangTai(ChuangWeiHao, ZhuangTai, zyinpatient.getIpdeptId());
		return true;
	}
	
	public boolean updateGengHuanChuangWei(String ZhuYuanHao, Integer OldChuangWeiHao, Integer NewChuangWeiHao, Integer ZhuYuanBu){
		zybedDao.updateChuangWeiZhuangTai(OldChuangWeiHao, "空闲",ZhuYuanBu);
		zyInpatientDao.updateDangQianChuangWei(ZhuYuanHao,NewChuangWeiHao);
		zybedDao.updateChuangWeiZhuangTai(NewChuangWeiHao, "已占用",ZhuYuanBu);
		return true;
	}
	
	public List<Zyinpatient> getZyinpatientall(String ZhuYuanHao){
		return zyInpatientDao.getZyinpatientall(ZhuYuanHao);
	}
	
	public boolean updateZhuYuanXinXiWeiHu(Zyinpatient zyinpatient, Csconsumer csconsumer, CsheadShow csheadShow, boolean TouXiang){
		zyInpatientDao.updateZYInpatient(zyinpatient); //修改住院信息
		csconsumerDao.updateCsconsumerInfo(csconsumer);//修改服务对象信息
		csheadShowDao.delCsheadShow(csheadShow); //删除头象
		if (TouXiang){
			csheadShowDao.addCsheadShow(csheadShow); //插入头像			
		}
		return true;
	}

	public Double getLeiJiFeiYong(String ZhuYuanHao, String ShenQiShiJian_B, String ShenQiShiJian_E, String ZhuangTai_CZ, String ZhuangTai_Cf){
		Double ze;
		List<Czdispose> ChuZhiXiangMu;
		String[][] ChuFangXiangMu;
		
		ze = 0d;
		ChuZhiXiangMu = mzCzdisposeDao.getZhuYuan(ZhuYuanHao, ShenQiShiJian_B, ShenQiShiJian_E, ZhuangTai_CZ); //计算处置费用
		for (int i = 0; i < ChuZhiXiangMu.size(); i++){
			ze = ze + ChuZhiXiangMu.get(i).getRealP();
		}
		ChuFangXiangMu = yfmexbankADao.getZhuYuanYaoPingQingDan(ZhuYuanHao, ShenQiShiJian_B, ShenQiShiJian_E, ZhuangTai_Cf); //计算处方费用 
		for (int i = 0; i < ChuFangXiangMu.length; i++){
			ze = ze + Double.parseDouble(ChuFangXiangMu[i][10]);
		}
		return ze;
	}
	
	public List<SfipdepositRecord> getZhuYuanYaJinJiLe(String ZhuYuanHao){
		return sfipdepositRecordDao.getSfipdepositRecord(ZhuYuanHao);
	}

	public String[][] getTiQuChuFang(String ZhuYuanHao, String ZhuangTai, Integer ZhuYuanBuID, String RiQi_B, String RiQi_E, String ZhuangTaiTiaoJian){
		return zydoctorAdviceDao.getZydoctorAdvice(ZhuYuanHao, ZhuangTai, ZhuYuanBuID, RiQi_B, RiQi_E, ZhuangTaiTiaoJian);
	}
	public String[][] getTiQuChuZhi(String ZhuYuanHao, String ZhuangTai, Integer ZhuYuanBuID, String ChuZhiZhuangTai, String RiQi_B, String RiQi_E){
		return zydoctorAdviceDao.getZydoctorAdvice_CZ(ZhuYuanHao, ZhuangTai, ZhuYuanBuID, ChuZhiZhuangTai, RiQi_B, RiQi_E);
	}

	public boolean updateShenHeYiZhu(String[][] YiZhuID_ChuKuDanID, Long HuShi, String ShenHeShiJian, String ZhuangTai, List<YfmexbankA> ChuKuDanTou, List<YfexbankAitem> ChuKuNeirong, List<Czdispose> ChuZhi, String[][] ChuZhiIDS, List<Czacontent> ShengQingDan, Double GouYaJin, String ZhuYuanHao){
		for (int i=0;i<YiZhuID_ChuKuDanID.length; i++){ //修改医嘱表
			zydoctorAdviceDao.updateZydoctorAdviceShenHe(YiZhuID_ChuKuDanID[i][0], HuShi, ShenHeShiJian, ZhuangTai, YiZhuID_ChuKuDanID[i][1]);
		}
		for (int i=0;i<ChuKuDanTou.size();i++){ //保存出库单头
			yfmexbankADao.addYfmexbankA(ChuKuDanTou.get(i));
		}
		yfExbankAItemDao.addYfexbankAitem(ChuKuNeirong); //保存出库单内容
		
		for (int i=0;i<ChuZhi.size();i++){ //保存处置项目
			mzCzdisposeDao.addCzdispose(ChuZhi.get(i));
		}
		
		for (int i=0;i<ShengQingDan.size();i++){ //保存申请单
			mzCZAContentDao.addCZAContent(ShengQingDan.get(i));
		}
		zyipteatmentDao.updateZyipteatmentItemID(ChuZhiIDS); //修改住院处置里的处置项ID
		if (GouYaJin != 0)
			zyInpatientDao.updateBengKeShiYaJin(ZhuYuanHao,GouYaJin); //扣除本科室执行的押金
		
		
		return true;
	}
	
	public String[][] getFeiYongQingDan(String ZhuYuanHao, String ZhuanTai_CZ, String ZhuangTai_CFFaYao, String ZhuangTai_CFTuiYao, String ZhiXingShiJian_B, String ZhiXingShiJian_E){
		return zydoctorAdviceDao.getFeiYongQingDan(ZhuYuanHao, ZhuanTai_CZ, ZhuangTai_CFFaYao, ZhuangTai_CFTuiYao, ZhiXingShiJian_B, ZhiXingShiJian_E);
	}

	public String getChuZhiMaxID(){
		return mzCzdisposeDao.getMaxitemId();
	}
	
	public CzdisposeItemDescribe getChuZhiXiangMuMiaoShu(Integer id){
		return mzCzdisposeItemDescribeDao.getCzdisposeItemDescribeByitemTypeId(id);
	}
	
	public boolean updateQuXiaoShengHe_CF(String[][] YiZhu_ChuKuDan, String YiZhuZhuangTai, Long HuShiID, String ShiJian){
		for (int i=0; i<YiZhu_ChuKuDan.length; i++){
			zydoctorAdviceDao.updateZydoctorAdviceShenHe(YiZhu_ChuKuDan[i][0], HuShiID, ShiJian, YiZhuZhuangTai, ""); //修改医嘱
			yfmexbankADao.delYFMExbankA(YiZhu_ChuKuDan[i][1]); //删除出库单表头
			yfExbankAItemDao.delYFExbankAItem(YiZhu_ChuKuDan[i][1]); //删除出库单项目
		}
		return true;
	}

	public boolean updateQuXiaoShengHe_CZ(String[] YiZhu, String[][] YiZhuXiang_ChuZhi, String[] ChuZhi, String YiZhuZhuangTai, Long HuShiID, String ShiJian){
		for (int i=0; i<YiZhu.length; i++){
			zydoctorAdviceDao.updateZydoctorAdviceShenHe(YiZhu[i], HuShiID, ShiJian, YiZhuZhuangTai, ""); //修改医嘱
		}
		zyipteatmentDao.updateZyipteatmentItemID(YiZhuXiang_ChuZhi); //修改住院处置
		for (int i=0; i<ChuZhi.length; i++){
			mzCzdisposeDao.delCzdisposeZY(ChuZhi[i]); //删除处置项
			mzCZAContentDao.delCZAContentByItemID(ChuZhi[i]); //删除申请单
		}
		return true;
	}

	public boolean getChuZhiBuFenZhiXing(String YiZhuHao){
		return zyipteatmentDao.getChuZhiBuFenZhiXing(YiZhuHao);
	}

	public String[][] getTuiYaoShengHe(String ZhuYuanHao, String ZhuangTai){
		return yfminbankADao.getYFMInbankATuiYao(ZhuYuanHao, ZhuangTai);
	}
	
    public boolean updateShengHeTuiYao(String[][] DanJu){
    	for (int i=0;i<DanJu.length;i++)
    	{
    		//  0:入库单号  1:状态  2:审核时间
    		yfminbankADao.updateZhuangTai(DanJu[i][0], DanJu[i][1], DanJu[i][2]);
    	}
    	return true;
    }
    /**
     * 取消退药单
     * @param ZhuYuanYaoPin 住院药品  0:药品项目ID  1:退量
     * @param XiuGaiChuKuDan 要修改的出库单信息  0:出库单号  1:药品ID 2:已退数量  3:已退价格
     * @param RuKuDanID 入库单号
     * @return
     */
    public boolean updateQuXiaoTuiYao(String[][] ZhuYuanYaoPin, String[][] XiuGaiChuKuDan, String[] RuKuDanID){
		for (int i=0;i<ZhuYuanYaoPin.length;i++){
			zyipmedicineDao.updateZyipmedicineNum(Long.parseLong(ZhuYuanYaoPin[i][0]), Integer.parseInt(ZhuYuanYaoPin[i][1])); //修改住院药品数量
		}
		for (int i=0;i<XiuGaiChuKuDan.length;i++){ //修改对应的出库单项
			yfExbankAItemDao.updateYFExbankAItemTuiYao(XiuGaiChuKuDan[i][0], Integer.parseInt(XiuGaiChuKuDan[i][1]), Integer.parseInt(XiuGaiChuKuDan[i][2]), Double.parseDouble(XiuGaiChuKuDan[i][3]));
		}
    	for (int i=0;i<RuKuDanID.length;i++){
    		yfminbankADao.delYfminbankA(RuKuDanID[i]); //删除入库单头
    		yfinbankAitemDao.delYfinbankAitem(RuKuDanID[i]); //删除入库单内容
    	}
    	return true;
    }
	public String getYiZhuXiangID(String DAID, Integer MInfoID){
		return zyipmedicineDao.getYiZhuXiangID(DAID, MInfoID);
	}

	public String getChuKuDanID(String RuKuDanID, Integer YaoPinID){
		return yfinbankAitemDao.getChuKuDanID(RuKuDanID, YaoPinID);
	}

	public Double getZhuYuanZongJieE(String ZhuYuanHao){
		Double je;
		je = mzCzdisposeDao.getChuZhiZhuYuanZongJinE(ZhuYuanHao) + yfmexbankADao.getChuFangZhuYuanZongJinE(ZhuYuanHao);
		return je;
	}

	public boolean updateBanLiChuYuan(String ZhuYuanHao, String ChuYuanShiJian, String ZhuangTai, Integer ChuangWeiHao, Integer ZhuYuanBu, String ChuangWeiZhuangTai){
		zyInpatientDao.updateBanLiChuYuan(ZhuYuanHao, ChuYuanShiJian, ZhuangTai);
		zybedDao.updateChuangWeiZhuangTai(ChuangWeiHao, ChuangWeiZhuangTai, ZhuYuanBu);
		return true;
	}

	public boolean updateCSConsumerZhuYuan(Long FuWuDuiXiangID, String ShengFenZhengHao, String NongHeHao, String ShouJiHao){
		return csconsumerDao.updateCSConsumerZhuYuan(FuWuDuiXiangID, ShengFenZhengHao, NongHeHao, ShouJiHao);
	}
	
}
