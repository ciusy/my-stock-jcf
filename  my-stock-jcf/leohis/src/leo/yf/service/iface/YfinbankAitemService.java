package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfinbankAitem;

public interface YfinbankAitemService {
	public boolean addYfinbankAitem(List<YfinbankAitem> yfinbankAitem);
	public boolean delYfinbankAitem(String ApproveFormID);
	public List<YfinbankAitem> getYfinbankAitem(String approveFormId);
	public String[] getRuKuJiaGe(Integer YFID, Integer YPID);
	/**
	 * �õ���ҩ��Ϣ
	 * @param DanHao ��ⵥ��
	 * @param LeiXing ����
	 * @return
	 */
	public String[][] getTuiYao(String DanHao, String LeiXing);
	/**
	 * �õ�һ�����ӵ��ܽ��
	 * @param ApproveFormID ���뵥��
	 * @return
	 */
	public Double getZongJieE(String ApproveFormID);
	
}
