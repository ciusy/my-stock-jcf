package leo.yf.dao.iface;

import java.util.List;
import java.util.Set;

import leo.common.dao.Dao;
import leo.entity.YfmexbankA;

public interface YfmexbankADao extends Dao<YfmexbankA> {
	/**
	 * add by xu<br>
	 * �շѵ�ʱ�򣬸������е����쵥��IDS�޸�״̬
	 * 
	 * @param aFormIDs
	 * @param costTypeId
	 */
	public void updateStatus(Set<String> aFormIDs, String costTypeId);

	public boolean addYfmexbankA(YfmexbankA yfmexbankA); // ���ӳ������뵥

	public String getMaxID(); // ���������ⵥ��

	public boolean delYFMExbankA(String AFormID); // ���� ���ⵥIDɾ�����ⵥͷ

	/**
	 * ��ѯ���ⵥ
	 * 
	 * @param AFormID
	 *            ���ⵥID
	 * @param ExbankTypeID
	 *            ���ⵥ����
	 * @param ATime_B
	 *            ����ʱ��_��ʼ
	 * @param ATime_e
	 *            ����ʱ��_����
	 * @param PharmacyID
	 *            ҩ��ID
	 * @return ExbankStatus ���״̬
	 * @return AU ���뵥λ
	 * @return PersonToGetM ȡҩ����ID
	 */
	public List<YfmexbankA> getYaofangChuKu(String AFormID,
			Integer ExbankTypeID, String ATime_B, String ATime_e,
			Integer PharmacyID, String ExbankStatus, Integer AU,
			Long PersonToGetM);

	/**
	 * ��׼����(�޸ĳ��ⵥ��ͷ)
	 * 
	 * @param AFormID
	 *            ���뵥��
	 * @param approveTime
	 *            ����ʱ��
	 * @param ExbankStatus
	 *            ״̬
	 * @return ckryid ������ԱID
	 */
	public boolean updatePiZun(String AFormID, String approveTime,
			String ExbankStatus, Long ckryid);

	/**
	 * ҩƷ����(�޸ĳ��ⵥ��ͷ)
	 * 
	 * @param AFormID
	 *            ���ⵥ��
	 * @param ExbankTime
	 *            ����ʱ��
	 * @param ExbankStatus
	 *            ״̬
	 * @return
	 */
	public boolean updateChuKu(String AFormID, String ExbankTime,
			String ExbankStatus);

	/**
	 * ҩƷ���ʱ�޸Ķ�Ӧ�ĳ��ⵥ(�޸ı�ͷ)
	 * 
	 * @param RuKuDanhao
	 *            ��ⵥ��
	 * @param RuKuRenID
	 *            �����ԱID
	 * @param RuKuShiJian
	 *            ���ʱ��
	 * @param ZhuangKuang
	 *            ״̬
	 * @return
	 */
	public boolean updateYaofangChuKu(String RuKuDanhao, Integer RuKuRenID,
			String RuKuShiJian, String ZhuangKuang);

	/**
	 * ����ʱ�޸�ȡҩ����ID,����ʱ��,״̬(���ҳ�������������Ҫȡҩ����ID����������Ҫ-2)
	 * 
	 * @param AFormID
	 *            ���뵥ID
	 * @param QYRID
	 *            ȡҩ��ID
	 * @param CKSJ
	 *            ����ʱ��
	 * @param ZT
	 *            ״̬
	 * @return
	 */
	public boolean updateQuYaoRen(String AFormID, Long QYRID, String CKSJ,
			String ZT, Long FYRID);

	/**
	 * ������������������ⵥ
	 * 
	 * @param XingMing
	 *            ����
	 * @param SuoXie
	 *            ������д
	 * @param MenZhenHao
	 *            �����
	 * @param KaiShiShiJian
	 *            ��ʼʱ��
	 * @param JieSuShiJian
	 *            ����ʱ��
	 * @param ZhuangTai
	 *            ״̬
	 * @param ChuKuLeiXingID
	 *            ��������ID
	 * @param YaoFangID
	 *            ҩ��ID
	 * @return
	 */
	public String[][] getMenZhenChuKuDan(String XingMing, String SuoXie,
			String MenZhenHao, String KaiShiShiJian, String JieSuShiJian,
			String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID);

	/**
	 * ������������סԺ���ⵥ
	 * 
	 * @param XingMing
	 *            ����
	 * @param SuoXie
	 *            ������д
	 * @param ZhuYuanHao
	 *            סԺ��
	 * @param KaiShiShiJian
	 *            ��ʼʱ��
	 * @param JieSuShiJian
	 *            ����ʱ��
	 * @param ZhuangTai
	 *            ״̬
	 * @param ChuKuLeiXingID
	 *            ��������ID
	 * @param YaoFangID
	 *            ҩ��ID
	 * @return
	 */
	public String[][] getZhuYuanChuKuDan(String XingMing, String SuoXie,
			String ZhuYuanHao, String KaiShiShiJian, String JieSuShiJian,
			String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID);

	/**
	 * ����������ѯ�������뵥
	 * 
	 * @param aformId
	 * @return
	 */
	public YfmexbankA getYfmexbankAByAformId(String aformId);

	/**
	 * ��������ѯ�������뵥
	 * 
	 * @param aformId
	 *            ���ⵥ��
	 * @param startDate
	 *            ��ʼʱ��
	 * @param endDate
	 *            ����ʱ��
	 * @param exbankStatus
	 *            ����״̬
	 * @param validityPeriod
	 *            ������Ч��
	 * @return
	 */
	public YfmexbankA getYfmexbankAByTiaojian(String aformId, String startDate,
			String endDate, String exbankStatus, String validityPeriod);

	/**
	 * ҩƷ����ͳ��
	 * 
	 * @param lxid
	 *            ��������ID
	 * @param ckzt
	 *            ����״̬
	 * @param k_date
	 *            ��ʼʱ��
	 * @param j_date
	 *            ����ʱ��
	 * @param xm
	 *            ����
	 * @param xmsx
	 *            ������д
	 * @param yfid
	 *            ҩ��ID
	 * @param qyid
	 *            ȡҩ��ԱID
	 * @param qyks
	 *            ȡҩ����ID
	 * @param ckdlx
	 *            ���ⵥ����
	 * @return
	 */
	public String[][] getChuKuTongJi(String ckdlx, Integer lxid, String ckzt,
			String k_date, String j_date, String xm, String xmsx, Integer yfid,
			Long qyid, Integer qyks);

	/**
	 * ͨ������Ų�ѯ����
	 * 
	 * @param opNum
	 * @return
	 */
	public YfmexbankA getYfmexbankAByOPNum(String opNum);

	/**
	 * ͨ�����ID��ѯ����
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
	 * ��ȡסԺҩƷ��ҩ�嵥
	 * 
	 * @param ZhuYuanHao
	 *            סԺ��
	 * @param ShenQingShiJian_B
	 *            ���뿪ʼʱ��
	 * @param ShenQingShiJian_E
	 *            �������ʱ��
	 * @param ZhuangTai
	 *            ״̬
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
	 * �õ�סԺ��Ա������Ŀ�ܽ��
	 * @param ZhuYuanHao סԺ��
	 * @return
	 */
	public Double getChuFangZhuYuanZongJinE(String ZhuYuanHao);
	/**
	 * ��ó��ⵥ
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
