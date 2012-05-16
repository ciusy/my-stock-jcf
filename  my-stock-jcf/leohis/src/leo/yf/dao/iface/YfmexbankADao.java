package leo.yf.dao.iface;

import java.util.List;
import java.util.Set;

import leo.common.dao.Dao;
import leo.entity.YfmexbankA;

public interface YfmexbankADao extends Dao<YfmexbankA> {
	/**
	 * add by xu<br>
	 * 收费的时候，根据所有的申领单的IDS修改状态
	 * 
	 * @param aFormIDs
	 * @param costTypeId
	 */
	public void updateStatus(Set<String> aFormIDs, String costTypeId);

	public boolean addYfmexbankA(YfmexbankA yfmexbankA); // 增加出库申请单

	public String getMaxID(); // 反回最大出库单号

	public boolean delYFMExbankA(String AFormID); // 按照 出库单ID删除出库单头

	/**
	 * 查询出库单
	 * 
	 * @param AFormID
	 *            出库单ID
	 * @param ExbankTypeID
	 *            出库单类型
	 * @param ATime_B
	 *            申请时间_开始
	 * @param ATime_e
	 *            申请时间_结束
	 * @param PharmacyID
	 *            药房ID
	 * @return ExbankStatus 入库状态
	 * @return AU 申请单位
	 * @return PersonToGetM 取药对象ID
	 */
	public List<YfmexbankA> getYaofangChuKu(String AFormID,
			Integer ExbankTypeID, String ATime_B, String ATime_e,
			Integer PharmacyID, String ExbankStatus, Integer AU,
			Long PersonToGetM);

	/**
	 * 批准出库(修改出库单表头)
	 * 
	 * @param AFormID
	 *            申请单号
	 * @param approveTime
	 *            审批时间
	 * @param ExbankStatus
	 *            状态
	 * @return ckryid 出库人员ID
	 */
	public boolean updatePiZun(String AFormID, String approveTime,
			String ExbankStatus, Long ckryid);

	/**
	 * 药品出库(修改出库单表头)
	 * 
	 * @param AFormID
	 *            出库单号
	 * @param ExbankTime
	 *            出库时间
	 * @param ExbankStatus
	 *            状态
	 * @return
	 */
	public boolean updateChuKu(String AFormID, String ExbankTime,
			String ExbankStatus);

	/**
	 * 药品入库时修改对应的出库单(修改表头)
	 * 
	 * @param RuKuDanhao
	 *            入库单号
	 * @param RuKuRenID
	 *            入库人员ID
	 * @param RuKuShiJian
	 *            入库时间
	 * @param ZhuangKuang
	 *            状态
	 * @return
	 */
	public boolean updateYaofangChuKu(String RuKuDanhao, Integer RuKuRenID,
			String RuKuShiJian, String ZhuangKuang);

	/**
	 * 出库时修改取药对象ID,出库时间,状态(科室出库和乡镇出库需要取药对象ID，其他不需要-2)
	 * 
	 * @param AFormID
	 *            申请单ID
	 * @param QYRID
	 *            取药人ID
	 * @param CKSJ
	 *            出库时间
	 * @param ZT
	 *            状态
	 * @return
	 */
	public boolean updateQuYaoRen(String AFormID, Long QYRID, String CKSJ,
			String ZT, Long FYRID);

	/**
	 * 按照条件查找门诊出库单
	 * 
	 * @param XingMing
	 *            姓名
	 * @param SuoXie
	 *            姓名缩写
	 * @param MenZhenHao
	 *            门诊号
	 * @param KaiShiShiJian
	 *            开始时间
	 * @param JieSuShiJian
	 *            结束时间
	 * @param ZhuangTai
	 *            状态
	 * @param ChuKuLeiXingID
	 *            出库类型ID
	 * @param YaoFangID
	 *            药房ID
	 * @return
	 */
	public String[][] getMenZhenChuKuDan(String XingMing, String SuoXie,
			String MenZhenHao, String KaiShiShiJian, String JieSuShiJian,
			String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID);

	/**
	 * 按照条件查找住院出库单
	 * 
	 * @param XingMing
	 *            姓名
	 * @param SuoXie
	 *            姓名缩写
	 * @param ZhuYuanHao
	 *            住院号
	 * @param KaiShiShiJian
	 *            开始时间
	 * @param JieSuShiJian
	 *            结束时间
	 * @param ZhuangTai
	 *            状态
	 * @param ChuKuLeiXingID
	 *            出库类型ID
	 * @param YaoFangID
	 *            药房ID
	 * @return
	 */
	public String[][] getZhuYuanChuKuDan(String XingMing, String SuoXie,
			String ZhuYuanHao, String KaiShiShiJian, String JieSuShiJian,
			String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID);

	/**
	 * 根据主键查询出库申请单
	 * 
	 * @param aformId
	 * @return
	 */
	public YfmexbankA getYfmexbankAByAformId(String aformId);

	/**
	 * 按条件查询出库申请单
	 * 
	 * @param aformId
	 *            出库单号
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param exbankStatus
	 *            出库状态
	 * @param validityPeriod
	 *            审批有效期
	 * @return
	 */
	public YfmexbankA getYfmexbankAByTiaojian(String aformId, String startDate,
			String endDate, String exbankStatus, String validityPeriod);

	/**
	 * 药品出库统计
	 * 
	 * @param lxid
	 *            出库类型ID
	 * @param ckzt
	 *            出库状态
	 * @param k_date
	 *            开始时间
	 * @param j_date
	 *            结束时间
	 * @param xm
	 *            姓名
	 * @param xmsx
	 *            姓名缩写
	 * @param yfid
	 *            药方ID
	 * @param qyid
	 *            取药人员ID
	 * @param qyks
	 *            取药科室ID
	 * @param ckdlx
	 *            出库单类型
	 * @return
	 */
	public String[][] getChuKuTongJi(String ckdlx, Integer lxid, String ckzt,
			String k_date, String j_date, String xm, String xmsx, Integer yfid,
			Long qyid, Integer qyks);

	/**
	 * 通过门诊号查询出库
	 * 
	 * @param opNum
	 * @return
	 */
	public YfmexbankA getYfmexbankAByOPNum(String opNum);

	/**
	 * 通过诊断ID查询出库
	 * 
	 * @param OPDnID
	 * @return
	 */
	public YfmexbankA getYfmexbankAByOPDnID(String OPDnID);

	/**
	 * add by xu
	 * 
	 * @param inpatientId
	 * @param paramList2 
	 * @return
	 */
	public List<String> getIds(String inpatientId, String type, List<String> paramList2);

	/**
	 * 提取住院药品发药清单
	 * 
	 * @param ZhuYuanHao
	 *            住院号
	 * @param ShenQingShiJian_B
	 *            申请开始时间
	 * @param ShenQingShiJian_E
	 *            申请结束时间
	 * @param ZhuangTai
	 *            状态
	 * @return
	 */
	public String[][] getZhuYuanYaoPingQingDan(String ZhuYuanHao,
			String ShenQingShiJian_B, String ShenQingShiJian_E, String ZhuangTai);


	/**
	 * add by xu 
	 * @param townId
	 * @param status
	 * @param applicationBillNO
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<List<String>> getTownAllocateApplicationBill(Integer townId, String status, String applicationBillNO, String startTime, String endTime);

	/**
	 * 得到住院人员处方项目总金额
	 * @param ZhuYuanHao 住院号
	 * @return
	 */
	public Double getChuFangZhuYuanZongJinE(String ZhuYuanHao);
	/**
	 * 获得出库单
	 * @param XingMing
	 * @param SuoXie
	 * @param Idcardnum
	 * @param MenZhenHao
	 * @param KaiShiShiJian
	 * @param JieSuShiJian
	 * @param ZhuangTai
	 * @param ChuKuLeiXingID
	 * @param YaoFangID
	 * @return
	 */
	public String[][] getYfmexbanka(String XingMing, String SuoXie,String Idcardnum,
			String MenZhenHao, String KaiShiShiJian, String JieSuShiJian,
			String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID);
	public boolean updateChuKuforruku(String AFormID, String rukuid);
	public List<YfmexbankA> getYfmexbankAlistByOPDnID(String OPDnID);
	
	/** 
	 * add by xu 
	 * @param opnum
	 * @param status
	 * @return
	 */
	public int getCFCount(String opnum, String... status);

	public void updateYFmbankStatus(Set<String> storageApplicationFormIds,
			String status);
}
