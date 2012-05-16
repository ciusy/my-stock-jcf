package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfinbankAitem;

public interface YfinbankAitemService {
	public boolean addYfinbankAitem(List<YfinbankAitem> yfinbankAitem);
	public boolean delYfinbankAitem(String ApproveFormID);
	public List<YfinbankAitem> getYfinbankAitem(String approveFormId);
	public String[] getRuKuJiaGe(Integer YFID, Integer YPID);
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
