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
	 * �޸���ⵥ״̬
	 * @param AFormID ��ⵥ��
	 * @param Status ״̬
	 * @param InbankTime ʱ��
	 * @param RKRYID �����ID
	 * @return
	 */
	public boolean updateInStatus(String AFormID, String Status, String InbankTime, Long RKRYID, Boolean XiangZhen, SfaccountDetail XiangZhengJiZhang);
	/**
	 * ������ⵥ
	 * @param yfminbankA ��ⵥ��ͷ
	 * @param yfinbankAitem ��ⵥ����
	 * @return
	 */
	public boolean addRuKuDan(YfminbankA yfminbankA, List<YfinbankAitem> yfinbankAitem);
	/**
	 * �޸���ⵥ
	 * @param DanHao ��ⵥ��
	 * @param yfminbankA ��ⵥ��ͷ
	 * @param yfinbankAitem ��ⵥ����
	 * @param yfapproveTable ������ͷ
	 * @param yfapproveItem ������
	 * @param ShenPiLuoJi �Ƿ���Ҫ�����߼�(-2����Ҫ)
	 * @return
	 */
	public boolean updateRuKudan(String DanHao, YfminbankA yfminbankA, List<YfinbankAitem> yfinbankAitem, YfapproveTable yfapproveTable, List<YfapproveItem> yfapproveItem, Integer ShenPiLuoJi);
	/**
	 * ��������ѯ������뵥
	 * @param aformId ���뵥ID
	 * @param startDate ��ʼʱ��
	 * @param endDate ����ʱ��
	 * @param inbankTypeId ��������ID
	 * @param inbankStatus ״̬
	 * @param ValidityPeriod ��Ч��
	 * @return
	 */
	public YfminbankA getYfminbankAByTiaojian(String aformId, String startDate,
			String endDate, String inbankStatus,
			String validityPeriod);
	/**
	 * ���ͳ��
	 * @param rkdlx �������
	 * @param lxid ����ID
	 * @param rkzt ���״̬
	 * @param k_date ��⿪ʼ����
	 * @param j_date ����������
	 * @param xm ����
	 * @param xmsx ������д
	 * @param yfid ҩ��ID
	 * @param rkryid �����ԱID
	 * @param rkdx ������ID
	 * @return
	 */
	public String[][] getRuKuTongJi(String rkdlx, Integer lxid, String rkzt, String k_date, String j_date, String xm, String xmsx, Integer yfid, Long rkryid, String rkdx);
	
	/**
	 * ��ȡ���۸�
	 * @param YaoPinID ҩƷ��ϢID
	 * @return
	 */
	public List<Double> getRuKuJiaGe(Integer YaoPinID);
	/**
	 * ��ȡ��ҩ��Ա
	 * @param XingMing ����
	 * @param XingMingSuoXie ������д
	 * @param MeiZhiZhuYuanHao �����סԺ��
	 * @param ShenQingRiQi_B ���뿪ʼ����
	 * @param ShenQingRiQi_E �����������
	 * @param YaoFangID ҩ��ID(����)
	 * @param RuKuLeiXing �������(����)
	 * @return
	 */
	public String[][] getTuiYaoRuKu(String XingMing, String XingMingSuoXie, String MeiZhiZhuYuanHao, String ShenQingRiQi_B, String ShenQingRiQi_E, Integer YaoFangID, String RuKuLeiXing);
	/**
	 * ȷ����ҩ
	 * @param RuKuDanID ��ⵥID 
	 * @param ZhuangTai ״̬
	 * @param RuKuShiJian ���ʱ��
	 * @param RuKuRenYuan �����ԱID
	 * @param YaofangID ҩ��ID
	 * @param YaoPin ҩƷ��Ϣ  0:ҩƷID  1:�������
	 * @param ZhuYuanHao סԺ��
	 * @param FeiYong ����
	 * @return
	 */
	public boolean updateTuiYao(String RuKuDanID, String ZhuangTai, String RuKuShiJian, Long RuKuRenYuan, Integer YaofangID, Integer[][] YaoPin, String ZhuYuanHao, Double FeiYong);

	public YfminbankA getYfminbankAByAformId(String aformId);
}


