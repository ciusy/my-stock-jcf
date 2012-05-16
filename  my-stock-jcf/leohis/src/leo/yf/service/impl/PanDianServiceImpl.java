package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.entity.YfcheckRecord;
import leo.entity.YfcheckRecordItem;
import leo.entity.YfexbankAitem;
import leo.entity.YfinbankAitem;
import leo.entity.YfmexbankA;
import leo.entity.YfminbankA;
import leo.yf.dao.iface.YFApproveItemDao;
import leo.yf.dao.iface.YFApproveTableDao;
import leo.yf.dao.iface.YfExbankAItemDao;
import leo.yf.dao.iface.YfcheckRecordDao;
import leo.yf.dao.iface.YfcheckRecordItemDao;
import leo.yf.dao.iface.YfinbankAitemDao;
import leo.yf.dao.iface.YfmexbankADao;
import leo.yf.dao.iface.YfminbankADao;
import leo.yf.dao.iface.YfmstockDao;
import leo.yf.service.iface.PanDianService;

public class PanDianServiceImpl implements PanDianService {
	private YfcheckRecordDao yfcheckRecordDao;
	private YfcheckRecordItemDao yfcheckRecordItemDao;
	private YfmexbankADao yfmexbankADao;
	private YfExbankAItemDao yfExbankAItemDao;
	private YfminbankADao yfminbankADao;
	private YfinbankAitemDao yfinbankAitemDao;
	private YfmstockDao yfmstockDao;
	private YFApproveTableDao yFApproveTableDao;
	private YFApproveItemDao yFApproveItemDao;
	
	public void setYfcheckRecordDao(YfcheckRecordDao yfcheckRecordDao) {
		this.yfcheckRecordDao = yfcheckRecordDao;
	}

	public void setYfcheckRecordItemDao(YfcheckRecordItemDao yfcheckRecordItemDao) {
		this.yfcheckRecordItemDao = yfcheckRecordItemDao;
	}

	public void setYfmexbankADao(YfmexbankADao yfmexbankADao) {
		this.yfmexbankADao = yfmexbankADao;
	}

	public void setYfExbankAItemDao(YfExbankAItemDao yfExbankAItemDao) {
		this.yfExbankAItemDao = yfExbankAItemDao;
	}

	public void setYfminbankADao(YfminbankADao yfminbankADao) {
		this.yfminbankADao = yfminbankADao;
	}

	public void setYfinbankAitemDao(YfinbankAitemDao yfinbankAitemDao) {
		this.yfinbankAitemDao = yfinbankAitemDao;
	}

	public void setYfmstockDao(YfmstockDao yfmstockDao) {
		this.yfmstockDao = yfmstockDao;
	}
	
	public void setyFApproveTableDao(YFApproveTableDao yFApproveTableDao) {
		this.yFApproveTableDao = yFApproveTableDao;
	}

	public void setyFApproveItemDao(YFApproveItemDao yFApproveItemDao) {
		this.yFApproveItemDao = yFApproveItemDao;
	}

	public boolean addPanDianDan(YfcheckRecord yfcheckRecord,List<YfcheckRecordItem> yfcheckRecordItem){
		yfcheckRecordDao.addYfcheckRecord(yfcheckRecord);
	    yfcheckRecordItemDao.addYfcheckRecordItem(yfcheckRecordItem);
		return true;
	}
	
	public String getMaxID(){
		return yfcheckRecordDao.getMaxID();
	}
	
	public List<YfcheckRecord> getYfcheckRecord(String DanHao, String KaiShiRiQi, String JieSuRiQi, String ZhuangTai, Integer YaoFang){
		return yfcheckRecordDao.getYfcheckRecord(DanHao, KaiShiRiQi, JieSuRiQi, ZhuangTai, YaoFang);
	}
	
	public List<YfcheckRecordItem> getYfcheckRecordItem(String DanHao){
		return yfcheckRecordItemDao.getYfcheckRecordItem(DanHao);
	}
	
	public boolean delPanDianDan(String DanHao){
		yfcheckRecordDao.delYfcheckRecord(DanHao);
		yfcheckRecordItemDao.delYfcheckRecordItem(DanHao);
		return true;
	}
	
	public boolean updatePanDianDan(String DanHao,YfcheckRecord yfcheckRecord,List<YfcheckRecordItem> yfcheckRecordItem, YfapproveTable yfapproveTable, List<YfapproveItem> yfapproveItem, Integer ShenPiLuoJi){
		yfcheckRecordDao.delYfcheckRecord(DanHao);
		yfcheckRecordItemDao.delYfcheckRecordItem(DanHao);
		yfcheckRecordDao.addYfcheckRecord(yfcheckRecord);
	    yfcheckRecordItemDao.addYfcheckRecordItem(yfcheckRecordItem);
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
	
	public boolean updateZhuangTai(String DanHao, String ZhuangTai){
		return yfcheckRecordDao.updateZhuangTai(DanHao, ZhuangTai);
	}
	
	/**
	 * 执行盘点单
	 * @param ChuKuDanTou //出库单表头
	 * @param ChuKuDanNeiRong //出库单内容
	 * @param RuKuDanTou //入库单表头
	 * @param RuKuDanNeiRong //入库单内容
	 * @param yp //药品信息
	 * @param yfid //药房ID
	 * @param IfChuKudan //是否建立出库单
	 * @param IfRuKudan //是否建立入库单
	 * @param PanDianDanHao //盘点单号
	 * @param PanDianZhuangTai //盘点状态
	 * @return
	 */
	public boolean updateZiXingPanDian(YfmexbankA ChuKuDanTou,List<YfexbankAitem> ChuKuDanNeiRong,YfminbankA RuKuDanTou, List<YfinbankAitem> RuKuDanNeiRong, String[][] yp, Integer yfid, Integer IfChuKudan, Integer IfRuKudan, String PanDianDanHao, String PanDianZhuangTai){
		if (IfChuKudan != -2){ //建立出库单
			yfmexbankADao.addYfmexbankA(ChuKuDanTou);
			yfExbankAItemDao.addYfexbankAitem(ChuKuDanNeiRong);
		}
		if (IfRuKudan != -2){ //建立 入库单
			yfminbankADao.addYfminbankA(RuKuDanTou);
			yfinbankAitemDao.addYfinbankAitem(RuKuDanNeiRong);
		}
		for (int i=0;i<yp.length;i++){ //修改库存
			yfmstockDao.updateStock(Integer.parseInt(yp[i][0]), Integer.parseInt(yp[i][1]), yfid);
		}
		
		yfcheckRecordDao.updateZhuangTai(PanDianDanHao, PanDianZhuangTai);
		return true;
	}

}
