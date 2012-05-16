package leo.yf.service.impl;

import java.util.List;

import leo.entity.SfaccountDetail;
import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.entity.YfexbankAitem;
import leo.entity.YfmexbankA;
import leo.entity.ZyippresExecute;
import leo.mz.dao.iface.MzopDnDao;
import leo.yf.dao.iface.YFApproveItemDao;
import leo.yf.dao.iface.YFApproveTableDao;
import leo.yf.dao.iface.YfExbankAItemDao;
import leo.yf.dao.iface.YfmexbankADao;
import leo.yf.dao.iface.YfminbankADao;
import leo.yf.dao.iface.YfmstockDao;
import leo.yf.service.iface.YfmexbankAService;
import leo.zy.dao.iface.ZydoctorAdviceDao;
import leo.zy.dao.iface.ZyippresExecuteDao;
import leo.zy.dao.iface.ZyInpatientDao;
import leo.sf.dao.iface.SfAccountDetailDao;

public class YfmexbankAServiceImpl implements YfmexbankAService {
	private YfmexbankADao yfmexbankADao;
	private YfExbankAItemDao yfexbankAitemDao;
	private YfmstockDao yfmstockDao;
	private YfminbankADao yfminbankADao;
	private MzopDnDao mzopDanDao;
	private YFApproveTableDao yFApproveTableDao;
	private YFApproveItemDao yFApproveItemDao;
	private ZydoctorAdviceDao zydoctorAdviceDao;
	private ZyippresExecuteDao zyippresExecuteDao;
	private ZyInpatientDao zyInpatientDao;
	private SfAccountDetailDao sfAccountDetailDao;

	public void setSfAccountDetailDao(SfAccountDetailDao sfAccountDetailDao) {
		this.sfAccountDetailDao = sfAccountDetailDao;
	}

	public void setZyInpatientDao(ZyInpatientDao zyInpatientDao) {
		this.zyInpatientDao = zyInpatientDao;
	}

	public void setZyippresExecuteDao(ZyippresExecuteDao zyippresExecuteDao) {
		this.zyippresExecuteDao = zyippresExecuteDao;
	}

	public void setZydoctorAdviceDao(ZydoctorAdviceDao zydoctorAdviceDao) {
		this.zydoctorAdviceDao = zydoctorAdviceDao;
	}

	public void setYfexbankAitemDao(YfExbankAItemDao yfexbankAitemDao) {
		this.yfexbankAitemDao = yfexbankAitemDao;
	}

	public void setYfmexbankADao(YfmexbankADao yfmexbankADao) {
		this.yfmexbankADao = yfmexbankADao;
	}

	public void setYfmstockDao(YfmstockDao yfmstockDao) {
		this.yfmstockDao = yfmstockDao;
	}

	public void setYfminbankADao(YfminbankADao yfminbankADao) {
		this.yfminbankADao = yfminbankADao;
	}

	public void setMzopDanDao(MzopDnDao mzopDanDao) {
		this.mzopDanDao = mzopDanDao;
	}
	
	public void setyFApproveTableDao(YFApproveTableDao yFApproveTableDao) {
		this.yFApproveTableDao = yFApproveTableDao;
	}

	public void setyFApproveItemDao(YFApproveItemDao yFApproveItemDao) {
		this.yFApproveItemDao = yFApproveItemDao;
	}

	public boolean addYfmexbankA(YfmexbankA yfmexbankA) {
		return yfmexbankADao.addYfmexbankA(yfmexbankA);
	}

	public boolean addcreatemexbank(YfmexbankA yfmexbankA, List<YfexbankAitem> yfexbankAitem) {// 事务建立出库单
		yfmexbankADao.addYfmexbankA(yfmexbankA);
		yfexbankAitemDao.addYfexbankAitem(yfexbankAitem);

		return true;
	}

	public String getMaxID() {
		return yfmexbankADao.getMaxID();
	}

	public List<YfmexbankA> getYaofangChuKu(String AFormID, Integer ExbankTypeID, String ATime_B, String ATime_e,
			Integer PharmacyID, String ExbankStatus, Integer AU, Long PersonToGetM) {
		return yfmexbankADao.getYaofangChuKu(AFormID, ExbankTypeID, ATime_B, ATime_e, PharmacyID, ExbankStatus, AU, PersonToGetM);
	}

	public boolean updatePiZun(String AFormID, String approveTime, String ExbankStatus, Long ckryid) {
		return yfmexbankADao.updatePiZun(AFormID, approveTime, ExbankStatus, ckryid);
	}

	public boolean updateShenPi(String rk_id, String ck_id, String spsj, String rk_zt, String ck_zt, String[][] yp, Integer yfID,
			Long ckryid) {
		yfmexbankADao.updatePiZun(ck_id, spsj, ck_zt, ckryid); // 出库申请单
		yfminbankADao.updateStatus(rk_id, rk_zt, spsj); // 药品入库申请
		for (int i = 0; i < yp.length; i++)
			yfmstockDao.updateStock(Integer.parseInt(yp[i][0]), Integer.parseInt(yp[i][1]), yfID);
		return true;
	}

	public boolean updateChuKu(String AFormID, String ExbankTime, String ExbankStatus) {
		return yfmexbankADao.updateChuKu(AFormID, ExbankTime, ExbankStatus);
	}

	public boolean updateYaofangChuKu(String RuKuDanhao, Integer RuKuRenID, String RuKuShiJian, String ZhuangKuang) {
		return yfmexbankADao.updateYaofangChuKu(RuKuDanhao, RuKuRenID, RuKuShiJian, ZhuangKuang);
	}

	public boolean updateJuJueShengQing(String RuKuID, String ChuKuID, String ShengPiShiJian, String RuKuDanZhuangTai) {
		yfminbankADao.updateStatus(RuKuID, RuKuDanZhuangTai, ShengPiShiJian);
		yfmexbankADao.delYFMExbankA(ChuKuID);
		yfexbankAitemDao.delYFExbankAItem(ChuKuID);
		return true;
	}

	public boolean updateChuKuDan(String AFormID, YfmexbankA yfmexbankA, List<YfexbankAitem> yfexbankAitem, YfapproveTable yfapproveTable, List<YfapproveItem> yfapproveItem, Integer ShenPiLuoJi) {
		yfmexbankADao.delYFMExbankA(AFormID);
		yfexbankAitemDao.delYFExbankAItem(AFormID);
		yfmexbankADao.addYfmexbankA(yfmexbankA);
		yfexbankAitemDao.addYfexbankAitem(yfexbankAitem);
		if (ShenPiLuoJi != -2){
			yFApproveTableDao.addYFApproveTable(yfapproveTable);
			Long id = yfapproveTable.getApproveFormId();
			for (int i=0; i<yfapproveItem.size(); i++){
				yfapproveItem.get(i).setApproveFormId(id);
			}			
			yFApproveItemDao.addYfapproveItem(yfapproveItem);
		}
		return true;
	}

	public boolean delChuKuDan(String AFormID) {
		yfmexbankADao.delYFMExbankA(AFormID);
		yfexbankAitemDao.delYFExbankAItem(AFormID);
		return true;
	}

	public boolean updateFaYao(String AFormID, Long QYRID, String CKSJ, String ZT, Integer yf,
                               String[][] yp, Long FYRID, String YiZhuID, ZyippresExecute ZhuYuanChuFangZhiXing,
                               String YiZhuZhuangTai, String ZhuYuanHao, Double FeiYoung, Boolean XiangZhen, SfaccountDetail XiangZhengJiZhang){
		yfmexbankADao.updateQuYaoRen(AFormID, QYRID, CKSJ, ZT, FYRID);
		for (int i = 0; i < yp.length; i++) {
			yfmstockDao.updateStock(Integer.parseInt(yp[i][0]), Integer.parseInt(yp[i][1]), yf);
		}
		if (YiZhuID != null && !YiZhuID.equals("")){ 
			zyippresExecuteDao.addZyippresExecute(ZhuYuanChuFangZhiXing); //写入住院处方执行
			zydoctorAdviceDao.updateZydoctorAdviceZhuangTai(YiZhuID, YiZhuZhuangTai); //修改医嘱状态
			zyInpatientDao.updateDepositBalance(ZhuYuanHao, FeiYoung); //住院发药时,扣除住院余额
		}
		if (XiangZhen) //需要加入乡镇记账表
			  sfAccountDetailDao.addSfAccountDetail(XiangZhengJiZhang);

		return true;
	}

	public String[][] getMenZhenChuKuDan(String XingMing, String SuoXie, String MenZhenHao, String KaiShiShiJian,
			String JieSuShiJian, String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID) {
		return yfmexbankADao.getMenZhenChuKuDan(XingMing, SuoXie, MenZhenHao, KaiShiShiJian, JieSuShiJian, ZhuangTai,
				ChuKuLeiXingID, YaoFangID);
	}

	public String[][] getZhuYuanChuKuDan(String XingMing, String SuoXie, String ZhuYuanHao, String KaiShiShiJian, String JieSuShiJian, String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID){
		return yfmexbankADao.getZhuYuanChuKuDan(XingMing, SuoXie, ZhuYuanHao, KaiShiShiJian, JieSuShiJian, ZhuangTai,
				ChuKuLeiXingID, YaoFangID);
	}
	
	
	public boolean updateMenZhengTuiHu(String ShenQingDanHao, String ShenPiShiJian, String ChuKuZhangTai, Long ChuKuRenYuanID,
			String ZhenDuanHao, String ZhenDuanZhuangTai) {
		yfmexbankADao.updatePiZun(ShenQingDanHao, ShenPiShiJian, ChuKuZhangTai, ChuKuRenYuanID);
		mzopDanDao.updateZhenDuanZhuangTai(ZhenDuanHao, ZhenDuanZhuangTai);

		return true;
	}

	public YfmexbankA getById(String aFromId) {
		return yfmexbankADao.find(aFromId);
	}
	/**
	 * 按条件查询出库申请单
	 */
	public YfmexbankA getYfmexbankAByTiaojian(String aformId, String startDate,
			String endDate, String exbankStatus, String validityPeriod) {
		// TODO Auto-generated method stub
		return yfmexbankADao.getYfmexbankAByTiaojian(aformId, startDate, endDate, exbankStatus, validityPeriod);
	}
	
	public String[][] getChuKuTongJi(String ckdlx, Integer lxid, String ckzt, String k_date, String j_date, String xm, String xmsx, Integer yfid, Long qyid, Integer qyks){
		return yfmexbankADao.getChuKuTongJi(ckdlx, lxid, ckzt, k_date, j_date, xm, xmsx, yfid, qyid, qyks);
	}

	public YfmexbankA getYfmexbankAByOPNum(String opNum) {
		
		return yfmexbankADao.getYfmexbankAByOPNum(opNum);
	}

	public YfmexbankA getYfmexbankAByOPDnID(String OPDnID) {
		return yfmexbankADao.getYfmexbankAByOPDnID(OPDnID);
	}
	
	public boolean updateZhuYuanTuiHu(String ShenQingDanHao, String YiZhuID, String ZhuangTqi){
		yfmexbankADao.delYFMExbankA(ShenQingDanHao); //删除申请单头
		yfexbankAitemDao.delYFExbankAItem(ShenQingDanHao); //删除申请单内容
		zydoctorAdviceDao.updateZydoctorAdviceShenHe(YiZhuID, -1l, "1900-01-01 00:00:00", ZhuangTqi, ""); //取消医嘱审核
		return true;
	}
	public String getZhuYuanChuFangZhiXingMaxID(){
		return zyippresExecuteDao.getMaxID();
	}

	public String[][] getYfmexbanka(String XingMing, String SuoXie,
			String Idcardnum, String MenZhenHao, String KaiShiShiJian,
			String JieSuShiJian, String ZhuangTai, Integer ChuKuLeiXingID,
			Integer YaoFangID) {
		// TODO Auto-generated method stub
		return yfmexbankADao.getYfmexbanka(XingMing, SuoXie, Idcardnum, MenZhenHao, KaiShiShiJian, JieSuShiJian, ZhuangTai, ChuKuLeiXingID, YaoFangID);
	}

	public boolean updateChuKuforruku(String AFormID, String rukuid) {
		// TODO Auto-generated method stub
		return yfmexbankADao.updateChuKuforruku(AFormID, rukuid);
	}

	public List<YfmexbankA> getYfmexbankAlistByOPDnID(String OPDnID) {
		// TODO Auto-generated method stub
		return yfmexbankADao.getYfmexbankAlistByOPDnID(OPDnID);
	}

}
