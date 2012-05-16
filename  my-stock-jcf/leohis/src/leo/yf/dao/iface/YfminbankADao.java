package leo.yf.dao.iface;

import java.util.List;
import java.util.Set;

import leo.common.dao.Dao;
import leo.entity.YfminbankA;

public interface YfminbankADao extends Dao<YfminbankA> {
	public String getAFormID();

	public boolean addYfminbankA(YfminbankA yfminbankA);

	/*
	 * AFormID, ���뵥ID InbankTypeID, �������ID AObject, ������� ATime_B, ����ʱ��(��ʼ)
	 * ATime_E, ����ʱ��(����) InbankStatus, ���״̬ InbankTime_B,���ʱ��(��ʼ)
	 * InbankTime_E,���ʱ��(����) PharmacyIDҩ��ID BeiZhu��ע
	 */
	public List<YfminbankA> getYfminbankA(String AFormID, Integer InbankTypeID,
			String AObject, String ATime_B, String ATime_E,
			String InbankStatus, String InbankTime_B, String InbankTime_E,
			Integer PharmacyID, String BeiZhu);

	public boolean delYfminbankA(String ID);

	public boolean updateYfminbankA(YfminbankA yfminbankA);

	public boolean updateStatus(String AFormID, String Status,
			String ApproveTime); // �޸�������뵥״̬������ʱ��

	public boolean updateInStatus(String AFormID, String Status,
			String InbankTime, Long RKRYID); // �޸�������뵥״̬�����ʱ��

	/**
	 * ��������ѯ������뵥
	 * 
	 * @param aformId
	 *            ���뵥ID
	 * @param startDate
	 *            ��ʼʱ��
	 * @param endDate
	 *            ����ʱ��
	 * @param inbankTypeId
	 *            ��������ID
	 * @param inbankStatus
	 *            ״̬
	 * @param ValidityPeriod
	 *            ��Ч��
	 * @return
	 */
	public YfminbankA getYfminbankAByAformId(String aformId, String startDate,
			String endDate, String inbankStatus, String validityPeriod);

	/**
	 * ����������ѯ������뵥
	 * 
	 * @param aformId
	 * @return
	 */
	public YfminbankA getYfminbankAByAformId(String aformId);

	/**
	 * ���ͳ��
	 * 
	 * @param rkdlx
	 *            �������
	 * @param lxid
	 *            ����ID
	 * @param rkzt
	 *            ���״̬
	 * @param k_date
	 *            ��⿪ʼ����
	 * @param j_date
	 *            ����������
	 * @param xm
	 *            ����
	 * @param xmsx
	 *            ������д
	 * @param yfid
	 *            ҩ��ID
	 * @param rkryid
	 *            �����ԱID
	 * @param rkdx
	 *            ������ID
	 * @return
	 */
	public String[][] getRuKuTongJi(String rkdlx, Integer lxid, String rkzt,
			String k_date, String j_date, String xm, String xmsx, Integer yfid,
			Long rkryid, String rkdx);

	/**
	 * �õ�ĳһҩƷ�����۸�
	 * 
	 * @param YaoPinID
	 *            ҩƷ��ϢID
	 * @return
	 */
	public List<Double> getRuKuJiaGe(Integer YaoPinID);

	/**
	 * ��ȡ��ⵥ���ݣ����Ի�ʿ��ҩ
	 * 
	 * @param ZhuYuanHao
	 *            סԺ��
	 * @param ZhuangTai
	 *            ״̬
	 * @return
	 */
	public String[][] getYFMInbankATuiYao(String ZhuYuanHao, String ZhuangTai);

	/**
	 * �޸���ⵥ״̬������ʱ��
	 * 
	 * @param AFormID
	 *            ��ⵥ��
	 * @param ZhuangTai
	 *            ״̬
	 * @param ApproveTime
	 *            ����ʱ��
	 * @return
	 */
	public boolean updateZhuangTai(String AFormID, String ZhuangTai,
			String ApproveTime);

	/**
	 * ��ȡ��ҩ��Ա
	 * 
	 * @param XingMing
	 *            ����
	 * @param XingMingSuoXie
	 *            ������д
	 * @param MeiZhiZhuYuanHao
	 *            �����סԺ��
	 * @param ShenQingRiQi_B
	 *            ���뿪ʼ����
	 * @param ShenQingRiQi_E
	 *            �����������
	 * @param YaoFangID
	 *            ҩ��ID(����)
	 * @param RuKuLeiXing
	 *            �������(����)
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
