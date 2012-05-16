package leo.yf.service.iface;

import java.util.List;

import leo.entity.SfaccountDetail;
import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.entity.YfexbankAitem;
import leo.entity.YfmexbankA;
import leo.entity.ZyippresExecute;

public interface YfmexbankAService {
	public boolean addYfmexbankA(YfmexbankA yfmexbankA);
	/**
	 * 保存出库单头和出库单内容
	 * @param yfmexbankA //出库单头
	 * @param yfexbankAitem //出库单内容
	 * @return
	 */
	public boolean addcreatemexbank(YfmexbankA yfmexbankA,List<YfexbankAitem> yfexbankAitem); //事务建立出库单
	public String getMaxID();
	public List<YfmexbankA> getYaofangChuKu(String AFormID,Integer ExbankTypeID,String ATime_B, String ATime_e, Integer PharmacyID, String ExbankStatus, Integer AU, Long PersonToGetM);
	public boolean updatePiZun(String AFormID, String approveTime, String ExbankStatus, Long ckryid);
	/**
	 *药房出库单审
	 * @param rk_id 入库单ID 
	 * @param ck_id 出库单ID
	 * @param spsj  审批时间
	 * @param rk_zt 入库状态
	 * @param ck_zt 出库状态
	 * @param yp 药品ID和出库数量
	 * @param yfID 药房ID
	 * @return
	 */
	public boolean updateShenPi(String rk_id, String ck_id, String spsj, String rk_zt, String ck_zt,String[][] yp, Integer yfID, Long ckryid);
	public boolean updateChuKu(String AFormID, String ExbankTime, String ExbankStatus);
	public boolean updateYaofangChuKu(String RuKuDanhao, Integer RuKuRenID, String RuKuShiJian, String ZhuangKuang);
	/**
	 * 药房申请单，对应药房拒绝出库
	 * @param RuKuID 入库单ID
	 * @param ChuKuID 出库单ID
	 * @param ShengPiShiJian 审批时间
	 * @param RuKuDanZhuangTai 入库单状态
	 * @return
	 */
	public boolean updateJuJueShengQing(String RuKuID, String ChuKuID, String ShengPiShiJian, String RuKuDanZhuangTai);
	/**
	 * 修改出库单表头及内容（先删除以前的老出库单，再建立新出库单）
	 * @param yfmexbankA 出库单表头
	 * @param yfexbankAitem 出库单内容
	 * @return AFormID 申请单号
	 * @return yfapproveTable 审批表头
	 * @return yfapproveItem 审批内容
	 * @return ShenPiLuoJi 有审批逻辑吗
	 */
	public boolean updateChuKuDan(String AFormID,YfmexbankA yfmexbankA,List<YfexbankAitem> yfexbankAitem, YfapproveTable yfapproveTable, List<YfapproveItem> yfapproveItem, Integer ShenPiLuoJi);
	/**
	 * 删除出库单表头及内容
	 * @param AFormID
	 * @return
	 */
	public boolean delChuKuDan(String AFormID);
	/**
	 * 药房发药
	 * @param AFormID 出库单ID
	 * @param QYRID 取药对象ID
	 * @param CKSJ 出库时间
	 * @param ZT 状态
	 * @param yf 药房ID
	 * @param yp 药品ID+出库数量
	 * @param YiZhuID 医嘱ID,空：非住院,非空：住院
	 * @param ZhuYuanChuFangZhiXing 住院处方执行
	 * @param FYRID 发药人员ID
	 * @param YiZhuZhuangTai 医嘱状态
	 * @param ZhuYuanHao 住院号
	 * @param FeiYoung 费用
	 * @param XiangZhen 是否要加入乡镇记账表
	 * @param XiangZhengJiZhang 乡镇记录内容
	 * @return
	 * 
	 */
	public boolean updateFaYao(String AFormID, Long QYRID, String CKSJ, String ZT, Integer yf,
			                   String[][] yp, Long FYRID, String YiZhuID, ZyippresExecute ZhuYuanChuFangZhiXing,
			                   String YiZhuZhuangTai, String ZhuYuanHao, Double FeiYoung, Boolean XiangZhen, SfaccountDetail XiangZhengJiZhang);
	/**
	 * 按照条件查找门诊出库单
	 * @param XingMing 姓名
	 * @param SuoXie 姓名缩写
	 * @param MenZhenHao 门诊号
	 * @param KaiShiShiJian 开始时间
	 * @param JieSuShiJian 结束时间
	 * @param ZhuangTai 状态
	 * @param ChuKuLeiXingID 出库类型ID
	 * @param YaoFangID 药房ID
	 * @return
	 */
	public String[][] getMenZhenChuKuDan(String XingMing, String SuoXie, String MenZhenHao, String KaiShiShiJian, String JieSuShiJian, String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID);

	/**
	 * 按照条件查找住院出库单
	 * @param XingMing 姓名
	 * @param SuoXie 姓名缩写
	 * @param ZhuYuanHao 门诊号
	 * @param KaiShiShiJian 开始时间
	 * @param JieSuShiJian 结束时间
	 * @param ZhuangTai 状态
	 * @param ChuKuLeiXingID 出库类型ID
	 * @param YaoFangID 药房ID
	 * @return
	 */
	public String[][] getZhuYuanChuKuDan(String XingMing, String SuoXie, String ZhuYuanHao, String KaiShiShiJian, String JieSuShiJian, String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID);
	
	/**
	 * 退回门诊出库单
	 * @param ShenQingDanHao 申请单号
	 * @param ShenPiShiJian  申批时间
	 * @param ChuKuZhangTai  出库状态
	 * @param ChuKuRenYuanID 出库人员ID
	 * @param ZhenDuanHao 门诊诊判ID
	 * @param ZhenDuanZhuangTai 门诊诊断状态
	 * @return
	 */
	public boolean updateMenZhengTuiHu(String ShenQingDanHao, String ShenPiShiJian, String ChuKuZhangTai, Long ChuKuRenYuanID, String ZhenDuanHao, String ZhenDuanZhuangTai);
	/**
	 * 退回住院出库单
	 * @param ShenQingDanHao 申请单号
	 * @param YiZhuID 医嘱ID
	 * @param ZhuangTqi 状态
	 * @return
	 */
	public boolean updateZhuYuanTuiHu(String ShenQingDanHao, String YiZhuID, String ZhuangTqi);
	/**
	 * add by xu 
	 * 根据主键时行查找
	 * @param aFromId
	 * @return
	 */
	public YfmexbankA getById(String aFromId);
	/**
	 * 按条件查询出库申请单
	 * @param aformId 出库单号
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param exbankStatus 出库状态
	 * @param validityPeriod 审批有效期
	 * @return
	 */
	public YfmexbankA getYfmexbankAByTiaojian(String aformId, String startDate,
			String endDate, String exbankStatus,
			String validityPeriod);
	
	/**
	 * 药品出库统计
	 * @param lxid 出库类型ID
	 * @param ckzt 出库状态
	 * @param k_date 开始时间
	 * @param j_date 结束时间
	 * @param xm 姓名
	 * @param xmsx 姓名缩写
	 * @param yfid 药房ID
	 * @param qyid 取药人员ID
	 * @param qyks 取药科室ID
	 * @param ckdlx 出库单类型
	 * @return
	 */
	public String[][] getChuKuTongJi(String ckdlx, Integer lxid, String ckzt, String k_date, String j_date, String xm, String xmsx, Integer yfid, Long qyid, Integer qyks);
    /**
     * 
     * @param opNum
     * @return
     */
	public YfmexbankA getYfmexbankAByOPNum(String opNum);
	/**
	 * 
	 * @param OPDnID
	 * @return
	 */
	public YfmexbankA getYfmexbankAByOPDnID(String OPDnID);
	
	/**
	 * 提取最大住院处方执行单ID
	 * @return
	 */
	public String getZhuYuanChuFangZhiXingMaxID(); 
	public String[][] getYfmexbanka(String XingMing, String SuoXie,String Idcardnum,
			String MenZhenHao, String KaiShiShiJian, String JieSuShiJian,
			String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID);
	/**
	 * 更新出库单入口id
	 * @param AFormID
	 * @param rukuid
	 * @return
	 */
	public boolean updateChuKuforruku(String AFormID, String rukuid);
  /**
   * 通过诊断id查询list
   * @param OPDnID
   * @return
   */
	public List<YfmexbankA> getYfmexbankAlistByOPDnID(String OPDnID);
}


