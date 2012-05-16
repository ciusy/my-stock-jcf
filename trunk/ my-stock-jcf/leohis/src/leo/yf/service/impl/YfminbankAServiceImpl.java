package leo.yf.service.impl;

import java.util.List;

import leo.entity.SfaccountDetail;
import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.entity.YfinbankAitem;
import leo.entity.YfminbankA;
import leo.sf.dao.iface.SfAccountDetailDao;
import leo.yf.dao.iface.YFApproveItemDao;
import leo.yf.dao.iface.YFApproveTableDao;
import leo.yf.dao.iface.YfinbankAitemDao;
import leo.yf.dao.iface.YfminbankADao;
import leo.yf.dao.iface.YfmstockDao;
import leo.yf.service.iface.YfminbankAService;
import leo.zy.dao.iface.ZyInpatientDao;

public class YfminbankAServiceImpl implements YfminbankAService {
	private YfminbankADao yfminbankADao;
	private YfinbankAitemDao yfinbankAitemDao;
	private YFApproveItemDao yFApproveItemDao;
	private YFApproveTableDao yFApproveTableDao;
	private YfmstockDao yfmstockDao;
	private ZyInpatientDao zyInpatientDao;
	private SfAccountDetailDao sfAccountDetailDao;
	
	
	public void setSfAccountDetailDao(SfAccountDetailDao sfAccountDetailDao) {
		this.sfAccountDetailDao = sfAccountDetailDao;
	}

	public void setZyInpatientDao(ZyInpatientDao zyInpatientDao) {
		this.zyInpatientDao = zyInpatientDao;
	}

	public void setYfmstockDao(YfmstockDao yfmstockDao) {
		this.yfmstockDao = yfmstockDao;
	}

	public String getAFormID() {
		return yfminbankADao.getAFormID();
	}

	public void setYfminbankADao(YfminbankADao yfminbankADao) {
		this.yfminbankADao = yfminbankADao;
	}

	public void setYfinbankAitemDao(YfinbankAitemDao yfinbankAitemDao) {
		this.yfinbankAitemDao = yfinbankAitemDao;
	}

	public void setyFApproveItemDao(YFApproveItemDao yFApproveItemDao) {
		this.yFApproveItemDao = yFApproveItemDao;
	}

	public void setyFApproveTableDao(YFApproveTableDao yFApproveTableDao) {
		this.yFApproveTableDao = yFApproveTableDao;
	}

	public boolean addYfminbankA(YfminbankA yfminbankA){
		return yfminbankADao.addYfminbankA(yfminbankA);
	}
	
	public List<YfminbankA> getYfminbankA(String AFormID,Integer InbankTypeID,String AObject,String ATime_B, String ATime_E, String InbankStatus,String InbankTime_B,String InbankTime_E,Integer PharmacyID, String BeiZhu){
		return yfminbankADao.getYfminbankA(AFormID, InbankTypeID, AObject, ATime_B, ATime_E, InbankStatus, InbankTime_B, InbankTime_E, PharmacyID, BeiZhu);
	}
	
	public boolean delYfminbankA(String ID){
		return yfminbankADao.delYfminbankA(ID);
	}
	public boolean updateYfminbankA(YfminbankA yfminbankA){
		return yfminbankADao.updateYfminbankA(yfminbankA);
	}
	public boolean updateStatus(String AFormID, String Status, String ApproveTime){
		return yfminbankADao.updateStatus(AFormID, Status, ApproveTime);
	}
	public boolean updateInStatus(String AFormID, String Status, String InbankTime, Long RKRYID, Boolean XiangZhen, SfaccountDetail XiangZhengJiZhang){
		yfminbankADao.updateInStatus(AFormID, Status, InbankTime, RKRYID);
		if (XiangZhen)
		  sfAccountDetailDao.addSfAccountDetail(XiangZhengJiZhang);
		return true;
	}
	
	public boolean addRuKuDan(YfminbankA yfminbankA, List<YfinbankAitem> yfinbankAitem){
		yfminbankADao.addYfminbankA(yfminbankA);
		yfinbankAitemDao.addYfinbankAitem(yfinbankAitem);
		return true;
	}
	public boolean updateRuKudan(String DanHao, YfminbankA yfminbankA, List<YfinbankAitem> yfinbankAitem, YfapproveTable yfapproveTable, List<YfapproveItem> yfapproveItem, Integer ShenPiLuoJi){
		yfminbankADao.delYfminbankA(DanHao);
		yfinbankAitemDao.delYfinbankAitem(DanHao);
		yfminbankADao.addYfminbankA(yfminbankA);
		yfinbankAitemDao.addYfinbankAitem(yfinbankAitem);
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
	/**
	 * 根据条件药品入库申请单
	 */
	public YfminbankA getYfminbankAByTiaojian(String aformId, String startDate,
			String endDate, String inbankStatus,
			String validityPeriod) {
		// TODO Auto-generated method stub
		return yfminbankADao.getYfminbankAByAformId(aformId, startDate, endDate, inbankStatus, validityPeriod);
	}

	public String[][] getRuKuTongJi(String rkdlx, Integer lxid, String rkzt, String k_date, String j_date, String xm, String xmsx, Integer yfid, Long rkryid, String rkdx){
		return yfminbankADao.getRuKuTongJi(rkdlx, lxid, rkzt, k_date, j_date, xm, xmsx, yfid, rkryid, rkdx);
	}
	
	public List<Double> getRuKuJiaGe(Integer YaoPinID){
		return yfminbankADao.getRuKuJiaGe(YaoPinID);
	}
	
	public String[][] getTuiYaoRuKu(String XingMing, String XingMingSuoXie, String MeiZhiZhuYuanHao, String ShenQingRiQi_B, String ShenQingRiQi_E, Integer YaoFangID, String RuKuLeiXing){
		return yfminbankADao.getTuiYaoRuKu(XingMing, XingMingSuoXie, MeiZhiZhuYuanHao, ShenQingRiQi_B, ShenQingRiQi_E, YaoFangID, RuKuLeiXing);
	}

	public boolean updateTuiYao(String RuKuDanID, String ZhuangTai, String RuKuShiJian, Long RuKuRenYuan, Integer YaofangID, Integer[][] YaoPin, String ZhuYuanHao, Double FeiYong){
		for (int i=0;i<YaoPin.length;i++){
			yfmstockDao.updateStock(YaoPin[i][0], YaoPin[i][1], YaofangID); //修改库存
		}
		yfminbankADao.updateInStatus(RuKuDanID, ZhuangTai, RuKuShiJian, RuKuRenYuan); //修改入库单状态
		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")){
			zyInpatientDao.updateDepositBalance(ZhuYuanHao, FeiYong); //加入住院余额
		}
		return true;
	}

	public YfminbankA getYfminbankAByAformId(String aformId) {
		// TODO Auto-generated method stub
		return yfminbankADao.getYfminbankAByAformId(aformId);
	}
	
}
