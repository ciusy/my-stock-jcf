package leo.zy.service.impl;

import java.util.ArrayList;
import java.util.List;

import leo.entity.CfacontentFramework;
import leo.entity.CzbcultrasoundImage;
import leo.entity.CzbcultrasoundIs;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.CzmilkGlandImage;
import leo.entity.CzmilkGlandIs;
import leo.entity.YfinbankAitem;
import leo.entity.YfminbankA;
import leo.entity.Zydischarge;
import leo.entity.ZydoctorAdvice;
import leo.entity.ZydoctorAdviceLongTerm;
import leo.entity.Zyipmedicine;
import leo.entity.Zyipteatment;
import leo.entity.Zymadministration;
import leo.mz.dao.iface.MzCzdisposeItemDescribeDao;
import leo.zy.dao.iface.ZydoctorAdviceDao;
import leo.zy.dao.iface.ZyipmedicineDao;
import leo.zy.dao.iface.ZyipteatmentDao;
import leo.zy.dao.iface.ZymadministrationDao;
import leo.zy.service.iface.ZyYiShengChuLiService;
import leo.zy.dao.iface.ZydoctorAdviceLongTermDao;
import leo.cf.dao.iface.CfacontentFrameworkDao;
import leo.yf.dao.iface.YfExbankAItemDao;
import leo.yf.dao.iface.YfminbankADao;
import leo.yf.dao.iface.YfinbankAitemDao;
import leo.bc.dao.iface.CzbcultrasoundIsDao;
import leo.bc.dao.iface.CzbcultrasoundImageDao;
import leo.mz.dao.iface.MzCzdisposeDao;
import leo.mz.dao.iface.MzCZAContentDao;
import leo.yf.dao.iface.YfmexbankADao;
import leo.zy.dao.iface.ZyInpatientDao;
import leo.zy.dao.iface.ZydischargeDao;
import leo.rx.dao.iface.CzmilkGlandIsDao;
import leo.rx.dao.iface.CzmilkGlandImageDao;
import leo.bc.dao.iface.CzshbioIsreDao;

public class ZyYiShengChuLiServiceImpl implements ZyYiShengChuLiService {
	private ZymadministrationDao zymadministrationDao;
	private MzCzdisposeItemDescribeDao mzCzdisposeItemDescribeDao;
	private ZydoctorAdviceDao zydoctorAdviceDao;
	private ZyipmedicineDao zyipmedicineDao;
	private ZyipteatmentDao zyipteatmentDao;
	private ZydoctorAdviceLongTermDao zydoctorAdviceLongTermDao;
	private CfacontentFrameworkDao cfacontentFrameworkDao;
	private YfExbankAItemDao yfExbankAItemDao;
	private YfminbankADao yfminbankADao;
	private CzbcultrasoundIsDao czbcultrasoundIsDao;
	private CzbcultrasoundImageDao czbcultrasoundImageDao;
	private MzCzdisposeDao mzCzdisposeDao;
	private MzCZAContentDao mzCZAContentDao;
	private YfmexbankADao yfmexbankADao;
	private ZyInpatientDao zyInpatientDao;
	private ZydischargeDao zydischargeDao;
	private CzmilkGlandIsDao czmilkGlandIsDao;
	private CzmilkGlandImageDao czmilkGlandImageDao;
	private CzshbioIsreDao czshbioIsreDao;

	
	public void setCzshbioIsreDao(CzshbioIsreDao czshbioIsreDao) {
		this.czshbioIsreDao = czshbioIsreDao;
	}

	public void setCzmilkGlandImageDao(CzmilkGlandImageDao czmilkGlandImageDao) {
		this.czmilkGlandImageDao = czmilkGlandImageDao;
	}

	public void setCzmilkGlandIsDao(CzmilkGlandIsDao czmilkGlandIsDao) {
		this.czmilkGlandIsDao = czmilkGlandIsDao;
	}

	public void setZyInpatientDao(ZyInpatientDao zyInpatientDao) {
		this.zyInpatientDao = zyInpatientDao;
	}

	public void setZydischargeDao(ZydischargeDao zydischargeDao) {
		this.zydischargeDao = zydischargeDao;
	}

	public void setZydoctorAdviceLongTermDao(
			ZydoctorAdviceLongTermDao zydoctorAdviceLongTermDao) {
		this.zydoctorAdviceLongTermDao = zydoctorAdviceLongTermDao;
	}
	
	public void setYfmexbankADao(YfmexbankADao yfmexbankADao) {
		this.yfmexbankADao = yfmexbankADao;
	}

	public void setMzCZAContentDao(MzCZAContentDao mzCZAContentDao) {
		this.mzCZAContentDao = mzCZAContentDao;
	}

	public void setMzCzdisposeDao(MzCzdisposeDao mzCzdisposeDao) {
		this.mzCzdisposeDao = mzCzdisposeDao;
	}

	public void setCzbcultrasoundImageDao(
			CzbcultrasoundImageDao czbcultrasoundImageDao) {
		this.czbcultrasoundImageDao = czbcultrasoundImageDao;
	}

	public void setCzbcultrasoundIsDao(CzbcultrasoundIsDao czbcultrasoundIsDao) {
		this.czbcultrasoundIsDao = czbcultrasoundIsDao;
	}

	public void setYfminbankADao(YfminbankADao yfminbankADao) {
		this.yfminbankADao = yfminbankADao;
	}

	public void setYfinbankAitemDao(YfinbankAitemDao yfinbankAitemDao) {
		this.yfinbankAitemDao = yfinbankAitemDao;
	}

	private YfinbankAitemDao yfinbankAitemDao;
	

	public void setYfExbankAItemDao(YfExbankAItemDao yfExbankAItemDao) {
		this.yfExbankAItemDao = yfExbankAItemDao;
	}

	public void setCfacontentFrameworkDao(
			CfacontentFrameworkDao cfacontentFrameworkDao) {
		this.cfacontentFrameworkDao = cfacontentFrameworkDao;
	}

	

	public void setZyipteatmentDao(ZyipteatmentDao zyipteatmentDao) {
		this.zyipteatmentDao = zyipteatmentDao;
	}

	public void setZydoctorAdviceDao(ZydoctorAdviceDao zydoctorAdviceDao) {
		this.zydoctorAdviceDao = zydoctorAdviceDao;
	}

	public void setZyipmedicineDao(ZyipmedicineDao zyipmedicineDao) {
		this.zyipmedicineDao = zyipmedicineDao;
	}

	public void setMzCzdisposeItemDescribeDao(
			MzCzdisposeItemDescribeDao mzCzdisposeItemDescribeDao) {
		this.mzCzdisposeItemDescribeDao = mzCzdisposeItemDescribeDao;
	}

	public void setZymadministrationDao(ZymadministrationDao zymadministrationDao) {
		this.zymadministrationDao = zymadministrationDao;
	}

	public List<Zymadministration> getYaoPingYongFa() {
		return zymadministrationDao.getZymadministration();
	}

	public List<CzdisposeItemDescribe> getChuZhi(String Name, String Spell){
		return mzCzdisposeItemDescribeDao.getCZDisposeItemDescribe(Name, Spell);
	}
	
	public boolean addLinShiYiZhu(List<ZydoctorAdvice> YiZhu_cf, List<ZydoctorAdvice> YiZhu_cz, List<Zyipmedicine> ChuFang, List<Zyipteatment> ChuZhi, boolean JiaRuChuFang, boolean JiaRuChuZhi, boolean JiaRuChuangQiYiZhu, List<ZydoctorAdviceLongTerm> ChuangQiYiZhu, boolean ChangQiYiZhuChuLi, String[][] RiQi,  Long[] ChangQiYiZhuID, Boolean BiaoZhi){
		if (JiaRuChuFang){ //���洦��
			for (int i=0;i<YiZhu_cf.size();i++){
				zydoctorAdviceDao.addZYDoctorAdvice(YiZhu_cf.get(i));
			}
			zyipmedicineDao.addZyipmedicine(ChuFang);
		}
		if (JiaRuChuZhi){ //���洦��
			for (int i=0;i<YiZhu_cz.size();i++){
				zydoctorAdviceDao.addZYDoctorAdvice(YiZhu_cz.get(i));
			}
			zyipteatmentDao.addZyipteatment(ChuZhi);
		}
		if (JiaRuChuangQiYiZhu){ //���泤��ҽ��
			for (int i=0; i<ChuangQiYiZhu.size(); i++){
				zydoctorAdviceLongTermDao.addZydoctorAdviceLongTerm(ChuangQiYiZhu.get(i));
			}
		}
		if (ChangQiYiZhuChuLi){ //��ʿ����ҽ�������޸��´�ִ������
			zydoctorAdviceLongTermDao.updateXiaCiZhiXingRiQi(RiQi);
			for (int i=0;i<ChangQiYiZhuID.length;i++){
				zydoctorAdviceLongTermDao.updateZhiXingBiaoZhi(ChangQiYiZhuID[i], BiaoZhi);
			}
		}
		return true;
	}
	
	public String getMaxID(){
		return zydoctorAdviceDao.getMaxID();
	}
	
	public boolean getXiangMuShiFouCunZai(String ZhuYuanHao, String XiangMuLeiXing, Integer XiangMuID, Long ChangQiYiZhuID){
		return zydoctorAdviceLongTermDao.getXiangMuShiFouCunZai(ZhuYuanHao, XiangMuLeiXing, XiangMuID, ChangQiYiZhuID);
	}

	public List<ZydoctorAdviceLongTerm> getChangQiYiZhu(String ZhuYuanHao, String RiQi, String LeiXing, Boolean WeiTingZhu){
		return zydoctorAdviceLongTermDao.getChangQiYiZhu(ZhuYuanHao, RiQi, LeiXing, WeiTingZhu);
	}

	public List<CfacontentFramework> getChuZhiMoBan(Integer DanWei, Integer XiangMuLeiXingID, Integer MoBanID){
		List<CfacontentFramework> MoBan; 
		MoBan = new ArrayList<CfacontentFramework>();
		if (MoBanID == -2)
			MoBan = cfacontentFrameworkDao.getCfacontentFrameworkByAffiliation(DanWei, XiangMuLeiXingID);
		else{
			MoBan.add(cfacontentFrameworkDao.getCfacontentFrameworkByID(MoBanID));
		}
		return MoBan;
	}

	public Boolean addChuZhiMoBan(CfacontentFramework MoBan, Integer MoBanID){
		if (MoBanID == -2)
			return cfacontentFrameworkDao.addCfacontentFramework(MoBan); //����
		else
			return cfacontentFrameworkDao.deleteCfacontentFramework(MoBanID); //ɾ��
	}

	public boolean updateLinShiChuFangXiang(Zyipmedicine Xiang){
		return zyipmedicineDao.updateZyipmedicine(Xiang);
	}
	
	public boolean delLinShiChufangXiang(String YiZhuID, Long Xiang, String LingYaoDanID, Integer YaoPingID, Boolean delChuKuDanTou)
	{
		zyipmedicineDao.deleteZyipmedicine(Xiang); //ɾ��סԺҩƷ
		if (YiZhuID != "" && !YiZhuID.equals("")){ //ɾ��ҽ��
			zydoctorAdviceDao.delZYDoctorAdvice(YiZhuID);
		}
		if (LingYaoDanID != "" && !LingYaoDanID.equals("")){
			yfExbankAItemDao.delYFExbankAItemByAFormIDMID(LingYaoDanID, YaoPingID); //ɾ������������Ŀ
			if (delChuKuDanTou){
				yfmexbankADao.delYFMExbankA(LingYaoDanID); //ɾ�����ⵥͷ
			}
		}
		return true;
	}
	/**
	 * ��ʱ������ҩ
	 * @param ZhuYuanYaoPin סԺҩƷ  0:ҩƷ��ĿID  1:�˵������
	 * @param XiuGaiChuKuDan Ҫ�޸ĵĳ��ⵥ��Ϣ  0:���ⵥ��  1:ҩƷID 2:��������  3:���˼۸�
	 * @param RuKuDanTou ��ⵥͷ
	 * @param RuKuDanNeiRong ��ⵥ����
	 * @return 
	 */
	public boolean updateLinShiChuFangTuiYao(String[][] ZhuYuanYaoPin, String[][] XiuGaiChuKuDan, List<YfminbankA> RuKuDanTou, List<YfinbankAitem> RuKuDanNeiRong){
		for (int i=0;i<ZhuYuanYaoPin.length;i++){
			zyipmedicineDao.updateZyipmedicineNum(Long.parseLong(ZhuYuanYaoPin[i][0]), Integer.parseInt(ZhuYuanYaoPin[i][1])); //�޸�סԺҩƷ����
		}
		for (int i=0;i<XiuGaiChuKuDan.length;i++){ //�޸Ķ�Ӧ�ĳ��ⵥ��
			yfExbankAItemDao.updateYFExbankAItemTuiYao(XiuGaiChuKuDan[i][0], Integer.parseInt(XiuGaiChuKuDan[i][1]), Integer.parseInt(XiuGaiChuKuDan[i][2]), Double.parseDouble(XiuGaiChuKuDan[i][3]));
		}
		for (int i=0;i<RuKuDanTou.size();i++){
			yfminbankADao.addYfminbankA(RuKuDanTou.get(i)); //������ⵥͷ
		}
		yfinbankAitemDao.addYfinbankAitem(RuKuDanNeiRong); //������ⵥ����
		return true;
	}
	
	public List<CzbcultrasoundIs> getBCBaoDaoDan(String XiangMuID){
		return czbcultrasoundIsDao.getRecordByItemID(XiangMuID);
	}

	public List<CzbcultrasoundImage> getBCTuPian(String BaoGaoDanID){
		return czbcultrasoundImageDao.GetPicturePathByReID(BaoGaoDanID);
	}

	public List<CzmilkGlandIs>getRXBaoGaoDan(String XiangMuID){
		return czmilkGlandIsDao.getRecordByItemID(XiangMuID);
	}

	public List<CzmilkGlandImage> getRXTuPian(String BaoGaoDanID){
		return czmilkGlandImageDao.GetPicturePathByReID(BaoGaoDanID);
	}
	
	public List<ZydoctorAdvice> getZydoctorAdvice(String DAID){
		return zydoctorAdviceDao.getZydoctorAdvice(DAID);
	}

	public boolean updateShenQingDanNeiRong(String ShenQingNeiRong, Long DAItemID){
		return zyipteatmentDao.updateZyipteatmentAContent(ShenQingNeiRong, DAItemID);
	}
	
	public boolean updateChuZhiXiangMu(Integer ItemTypeID, Integer ExecuteU, Long DAItemID){
		return zyipteatmentDao.updateZyipteatmentXiangMu(ItemTypeID, ExecuteU, DAItemID);
	}
	
	public boolean delLinSheChuZhiXiang(String YiZhuId, Long YiZhuXiangID, String XiangMuID){
		zyipteatmentDao.delZYIPTeatment(YiZhuXiangID); //ɾ��ס������Ŀ
		if (YiZhuId != "" && !YiZhuId.equals("")){ //ɾ��ҽ��
			zydoctorAdviceDao.delZYDoctorAdvice(YiZhuId);
		}
		if (XiangMuID != "" && !XiangMuID.equals("")){
			mzCzdisposeDao.delCzdisposeZY(XiangMuID); //ɾ��������
			mzCZAContentDao.delCZAContentByItemID(XiangMuID); //ɾ�����뵥
		}
		
		return true;
	}

	public boolean delChangQiYiZhu(Long LTID){
		return zydoctorAdviceLongTermDao.delChangQiYiZhu(LTID); 
	}

	public boolean updateChuangQiYiZhu(String[] NeiRong, Long LTID){
		return zydoctorAdviceLongTermDao.updateChuangQiYiZhu(NeiRong, LTID);
	}

	public boolean updateTingZhu(Long TingZhuYiSheng, String TingZhuShiJian, String XiaCiZhiXingRiQi, Long ID){
		return zydoctorAdviceLongTermDao.updateTingZhu(TingZhuYiSheng, TingZhuShiJian, XiaCiZhiXingRiQi, ID);
	}

	public String getChuZhiMingCheng(Integer ItemTypeID){
		return mzCzdisposeItemDescribeDao.getCZDisposeItemDescribeName(ItemTypeID);
	}

	public boolean updateAllTingZhu(String ZhuYuanHao, Long TingZhuYiSheng, String TingZhuShiJian){
		return zydoctorAdviceLongTermDao.updateAllTingZhu(ZhuYuanHao, TingZhuYiSheng, TingZhuShiJian);//.updateTingZhuAll(ZhuYuanHao, TingZhuYiSheng, TingZhuShiJian);
	}

	public boolean updateChuYuanTongZhi(Zydischarge TongZhi, String ZhuYuanHao, String ShengQingZhuangTai){
		zydischargeDao.addZydischarge(TongZhi);
		zyInpatientDao.updateShengQingZhuangTai(ZhuYuanHao,  ShengQingZhuangTai);
		return true;
	}
	
	public List<Zydischarge> getChuYuanTongZhi(String ZhuYuanHao){
		return zydischargeDao.getZydischarge(ZhuYuanHao);
	}

	public boolean updateQuXiaoChuYuan(String ZhuYuanHao, String ZhuangTai){
		zydischargeDao.delZydischarge(ZhuYuanHao);
		zyInpatientDao.updateShengQingZhuangTai(ZhuYuanHao, ZhuangTai);
		return true;
	}

	public boolean updateXiuGaiTongZhi(Zydischarge zydischarge){
		return zydischargeDao.updatezydischarge(zydischarge);
	}

	public String getBaoGaoDan(Integer LeiXingID, Integer JiGouID){
		return mzCzdisposeItemDescribeDao.getReport(LeiXingID, JiGouID);
	}

	public String[][] getHuaYianDan(String ItemID, String ItemName){
		return czshbioIsreDao.getCzshbioIsreByItemID(ItemID, ItemName); 
	}
	
}
