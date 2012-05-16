package leo.yf.dao.iface;

import java.util.List;
import java.util.Set;

import leo.common.dao.Dao;
import leo.entity.YfminbankA;

public interface YfminbankADao extends Dao<YfminbankA> {
	public String getAFormID();

	public boolean addYfminbankA(YfminbankA yfminbankA);

	/*
	 * AFormID, 申请单ID InbankTypeID, 入库类型ID AObject, 申请对象 ATime_B, 申请时间(开始)
	 * ATime_E, 申请时间(结束) InbankStatus, 入库状态 InbankTime_B,入库时间(开始)
	 * InbankTime_E,入库时间(结束) PharmacyID药房ID BeiZhu备注
	 */
	public List<YfminbankA> getYfminbankA(String AFormID, Integer InbankTypeID,
			String AObject, String ATime_B, String ATime_E,
			String InbankStatus, String InbankTime_B, String InbankTime_E,
			Integer PharmacyID, String BeiZhu);

	public boolean delYfminbankA(String ID);

	public boolean updateYfminbankA(YfminbankA yfminbankA);

	public boolean updateStatus(String AFormID, String Status,
			String ApproveTime); // 修改入库申请单状态和审批时间

	public boolean updateInStatus(String AFormID, String Status,
			String InbankTime, Long RKRYID); // 修改入库申请单状态和完成时间

	/**
	 * 按条件查询入库申请单
	 * 
	 * @param aformId
	 *            申请单ID
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param inbankTypeId
	 *            申请类型ID
	 * @param inbankStatus
	 *            状态
	 * @param ValidityPeriod
	 *            有效期
	 * @return
	 */
	public YfminbankA getYfminbankAByAformId(String aformId, String startDate,
			String endDate, String inbankStatus, String validityPeriod);

	/**
	 * 根据主键查询入库申请单
	 * 
	 * @param aformId
	 * @return
	 */
	public YfminbankA getYfminbankAByAformId(String aformId);

	/**
	 * 入库统计
	 * 
	 * @param rkdlx
	 *            入库类型
	 * @param lxid
	 *            类型ID
	 * @param rkzt
	 *            入库状态
	 * @param k_date
	 *            入库开始日期
	 * @param j_date
	 *            入库结束日期
	 * @param xm
	 *            姓名
	 * @param xmsx
	 *            姓名缩写
	 * @param yfid
	 *            药房ID
	 * @param rkryid
	 *            入库人员ID
	 * @param rkdx
	 *            入库对象ID
	 * @return
	 */
	public String[][] getRuKuTongJi(String rkdlx, Integer lxid, String rkzt,
			String k_date, String j_date, String xm, String xmsx, Integer yfid,
			Long rkryid, String rkdx);

	/**
	 * 得到某一药品的入库价格
	 * 
	 * @param YaoPinID
	 *            药品信息ID
	 * @return
	 */
	public List<Double> getRuKuJiaGe(Integer YaoPinID);

	/**
	 * 提取入库单内容，用以护士退药
	 * 
	 * @param ZhuYuanHao
	 *            住院号
	 * @param ZhuangTai
	 *            状态
	 * @return
	 */
	public String[][] getYFMInbankATuiYao(String ZhuYuanHao, String ZhuangTai);

	/**
	 * 修改入库单状态和审批时间
	 * 
	 * @param AFormID
	 *            入库单号
	 * @param ZhuangTai
	 *            状态
	 * @param ApproveTime
	 *            审批时间
	 * @return
	 */
	public boolean updateZhuangTai(String AFormID, String ZhuangTai,
			String ApproveTime);

	/**
	 * 提取退药人员
	 * 
	 * @param XingMing
	 *            姓名
	 * @param XingMingSuoXie
	 *            姓名缩写
	 * @param MeiZhiZhuYuanHao
	 *            门诊或住院号
	 * @param ShenQingRiQi_B
	 *            申请开始日期
	 * @param ShenQingRiQi_E
	 *            申请结束日期
	 * @param YaoFangID
	 *            药房ID(必须)
	 * @param RuKuLeiXing
	 *            入库类型(必须)
	 * @return
	 */
	public String[][] getTuiYaoRuKu(String XingMing, String XingMingSuoXie,
			String MeiZhiZhuYuanHao, String ShenQingRiQi_B,
			String ShenQingRiQi_E, Integer YaoFangID, String RuKuLeiXing);

	/**
	 * add by xu
	 * 
	 * @param townId
	 * @param status
	 * @param applicationBillNO
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<List<String>> getTownAllocateApplicationBill(Integer townId,
			String status, String applicationBillNO, String startTime,
			String endTime);

	/**
	 * ADD BY XU
	 * 
	 * @param storageApplicationFormIds
	 * @param string
	 */
	public void updateStorageApplicationFormStatus(
			Set<String> storageApplicationFormIds, String string);

	public int getCFReturnCount(String opnum, String... status);
}
