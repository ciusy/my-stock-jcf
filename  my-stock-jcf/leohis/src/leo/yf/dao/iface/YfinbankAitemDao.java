package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfinbankAitem;

public interface YfinbankAitemDao extends Dao<YfinbankAitem>{
	public boolean addYfinbankAitem(List<YfinbankAitem> yfinbankAitem);
	public boolean delYfinbankAitem(String ApproveFormID);
	public List<YfinbankAitem> getYfinbankAitem(String approveFormId);
	/**
	 * 通过药房ID和药品ID得到入库价格
	 * @param YFID 药房ID
	 * @param YPID 药品ID
	 * @return
	 */
	public String[] getRuKuJiaGe(Integer YFID, Integer YPID);
	/**
	 * add by xu 
	 * @param outPatientId
	 * @param status
	 * @return
	 */
	public List<List<String>> getReturnPrescription(String outPatientId,
			String status);
	/**
	 * 根据入库单ID和药品ID得到住院医嘱里的出库单ID
	 * @param RuKuDanID
	 * @param YaoPinID
	 * @return
	 */
	public String getChuKuDanID(String RuKuDanID, Integer YaoPinID);
	/**
	 * 得到退药信息
	 * @param DanHao 入库单号
	 * @param LeiXing 类型
	 * @return
	 */
	public String[][] getTuiYao(String DanHao, String LeiXing);
	/**
	 * 得到一个单子的总金额
	 * @param ApproveFormID 申请单号
	 * @return
	 */
	public Double getZongJieE(String ApproveFormID);
}
