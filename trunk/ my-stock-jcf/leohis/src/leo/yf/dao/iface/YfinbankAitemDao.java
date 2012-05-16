package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfinbankAitem;

public interface YfinbankAitemDao extends Dao<YfinbankAitem>{
	public boolean addYfinbankAitem(List<YfinbankAitem> yfinbankAitem);
	public boolean delYfinbankAitem(String ApproveFormID);
	public List<YfinbankAitem> getYfinbankAitem(String approveFormId);
	/**
	 * ͨ��ҩ��ID��ҩƷID�õ����۸�
	 * @param YFID ҩ��ID
	 * @param YPID ҩƷID
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
	 * ������ⵥID��ҩƷID�õ�סԺҽ����ĳ��ⵥID
	 * @param RuKuDanID
	 * @param YaoPinID
	 * @return
	 */
	public String getChuKuDanID(String RuKuDanID, Integer YaoPinID);
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
