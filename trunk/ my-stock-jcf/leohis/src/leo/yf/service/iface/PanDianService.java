package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.entity.YfcheckRecord;
import leo.entity.YfcheckRecordItem;
import leo.entity.YfexbankAitem;
import leo.entity.YfinbankAitem;
import leo.entity.YfmexbankA;
import leo.entity.YfminbankA;

public interface PanDianService {
	/**
	 * 创建盘点单
	 * @param yfcheckRecord 盘点单表头
	 * @param yfcheckRecordItem 盘点单内容
	 * @return
	 */
	public boolean addPanDianDan(YfcheckRecord yfcheckRecord,List<YfcheckRecordItem> yfcheckRecordItem);
	/**
	 * 返回最大盘点单号
	 * @return
	 */
	public String getMaxID();
	/**
	 * 提取盘点单表头
	 * @param DanHao 盘点单号
	 * @param KaiShiRiQi 开始时间
	 * @param JieSuRiQi 结束时间
	 * @param ZhuangTai 状态
	 * @param YaoFang 药房ID
	 * @return
	 */
	public List<YfcheckRecord> getYfcheckRecord(String DanHao, String KaiShiRiQi, String JieSuRiQi, String ZhuangTai, Integer YaoFang);
	/**
	 * 提取盘点单内容
	 * @param DanHao 盘点点号
	 * @return
	 */
	public List<YfcheckRecordItem> getYfcheckRecordItem(String DanHao);
	/**
	 * 删除盘点单
	 * @param DanHao 盘点单号
	 * @return
	 */
	public boolean delPanDianDan(String DanHao);
	/**
	 * 修改盘点单状态
	 * @param DanHao 盘点单号
	 * @param ZhuangTai 状态
	 * @return
	 */
	public boolean updateZhuangTai(String DanHao, String ZhuangTai);
	/**
	 * 修改盘点单
	 * @param DanHao 盘点单号
	 * @param yfcheckRecord 盘点表头
	 * @param yfcheckRecordItem 盘点内容
	 * @return yfapproveTable 审批表头
	 * @return yfapproveItem 审批表内容
	 * @return ShenPiLuoJi 是否需要审批
	 */
	public boolean updatePanDianDan(String DanHao,YfcheckRecord yfcheckRecord,List<YfcheckRecordItem> yfcheckRecordItem, YfapproveTable yfapproveTable, List<YfapproveItem> yfapproveItem, Integer ShenPiLuoJi);
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
	 * 
	 * @return
	 */
	public boolean updateZiXingPanDian(YfmexbankA ChuKuDanTou,List<YfexbankAitem> ChuKuDanNeiRong,YfminbankA RuKuDanTou, List<YfinbankAitem> RuKuDanNeiRong, String[][] yp, Integer yfid, Integer IfChuKudan, Integer IfRuKudan, String PanDianDanHao, String PanDianZhuangTai);
	
	
}
