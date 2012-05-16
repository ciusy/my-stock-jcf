package leo.yf.service.iface;

import java.util.List;

import leo.entity.SfaccountDetail;
import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.entity.YfinbankAitem;
import leo.entity.YfminbankA;

public interface YfminbankAService {
	public String getAFormID();
	public boolean addYfminbankA(YfminbankA yfminbankA);
	public List<YfminbankA> getYfminbankA(String AFormID,Integer InbankTypeID,String AObject,String ATime_B, String ATime_E, String InbankStatus,String InbankTime_B,String InbankTime_E,Integer PharmacyID, String BeiZhu);
	public boolean delYfminbankA(String ID);
	public boolean updateYfminbankA(YfminbankA yfminbankA);
	public boolean updateStatus(String AFormID, String Status, String ApproveTime);
	
	/**
	 * 修改入库单状态
	 * @param AFormID 入库单号
	 * @param Status 状态
	 * @param InbankTime 时间
	 * @param RKRYID 入库人ID
	 * @return
	 */
	public boolean updateInStatus(String AFormID, String Status, String InbankTime, Long RKRYID, Boolean XiangZhen, SfaccountDetail XiangZhengJiZhang);
	/**
	 * 保存入库单
	 * @param yfminbankA 入库单表头
	 * @param yfinbankAitem 入库单内容
	 * @return
	 */
	public boolean addRuKuDan(YfminbankA yfminbankA, List<YfinbankAitem> yfinbankAitem);
	/**
	 * 修改入库单
	 * @param DanHao 入库单号
	 * @param yfminbankA 入库单表头
	 * @param yfinbankAitem 入库单内容
	 * @param yfapproveTable 审批表头
	 * @param yfapproveItem 审批项
	 * @param ShenPiLuoJi 是否需要审批逻辑(-2不需要)
	 * @return
	 */
	public boolean updateRuKudan(String DanHao, YfminbankA yfminbankA, List<YfinbankAitem> yfinbankAitem, YfapproveTable yfapproveTable, List<YfapproveItem> yfapproveItem, Integer ShenPiLuoJi);
	/**
	 * 按条件查询入库申请单
	 * @param aformId 申请单ID
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param inbankTypeId 申请类型ID
	 * @param inbankStatus 状态
	 * @param ValidityPeriod 有效期
	 * @return
	 */
	public YfminbankA getYfminbankAByTiaojian(String aformId, String startDate,
			String endDate, String inbankStatus,
			String validityPeriod);
	/**
	 * 入库统计
	 * @param rkdlx 入库类型
	 * @param lxid 类型ID
	 * @param rkzt 入库状态
	 * @param k_date 入库开始日期
	 * @param j_date 入库结束日期
	 * @param xm 姓名
	 * @param xmsx 姓名缩写
	 * @param yfid 药房ID
	 * @param rkryid 入库人员ID
	 * @param rkdx 入库对象ID
	 * @return
	 */
	public String[][] getRuKuTongJi(String rkdlx, Integer lxid, String rkzt, String k_date, String j_date, String xm, String xmsx, Integer yfid, Long rkryid, String rkdx);
	
	/**
	 * 提取入库价格
	 * @param YaoPinID 药品信息ID
	 * @return
	 */
	public List<Double> getRuKuJiaGe(Integer YaoPinID);
	/**
	 * 提取退药人员
	 * @param XingMing 姓名
	 * @param XingMingSuoXie 姓名缩写
	 * @param MeiZhiZhuYuanHao 门诊或住院号
	 * @param ShenQingRiQi_B 申请开始日期
	 * @param ShenQingRiQi_E 申请结束日期
	 * @param YaoFangID 药房ID(必须)
	 * @param RuKuLeiXing 入库类型(必须)
	 * @return
	 */
	public String[][] getTuiYaoRuKu(String XingMing, String XingMingSuoXie, String MeiZhiZhuYuanHao, String ShenQingRiQi_B, String ShenQingRiQi_E, Integer YaoFangID, String RuKuLeiXing);
	/**
	 * 确定退药
	 * @param RuKuDanID 入库单ID 
	 * @param ZhuangTai 状态
	 * @param RuKuShiJian 入库时间
	 * @param RuKuRenYuan 入库人员ID
	 * @param YaofangID 药房ID
	 * @param YaoPin 药品信息  0:药品ID  1:入库数量
	 * @param ZhuYuanHao 住院号
	 * @param FeiYong 费用
	 * @return
	 */
	public boolean updateTuiYao(String RuKuDanID, String ZhuangTai, String RuKuShiJian, Long RuKuRenYuan, Integer YaofangID, Integer[][] YaoPin, String ZhuYuanHao, Double FeiYong);

	public YfminbankA getYfminbankAByAformId(String aformId);
}


