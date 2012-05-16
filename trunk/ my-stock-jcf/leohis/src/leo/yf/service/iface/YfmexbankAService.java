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
	 * ������ⵥͷ�ͳ��ⵥ����
	 * @param yfmexbankA //���ⵥͷ
	 * @param yfexbankAitem //���ⵥ����
	 * @return
	 */
	public boolean addcreatemexbank(YfmexbankA yfmexbankA,List<YfexbankAitem> yfexbankAitem); //���������ⵥ
	public String getMaxID();
	public List<YfmexbankA> getYaofangChuKu(String AFormID,Integer ExbankTypeID,String ATime_B, String ATime_e, Integer PharmacyID, String ExbankStatus, Integer AU, Long PersonToGetM);
	public boolean updatePiZun(String AFormID, String approveTime, String ExbankStatus, Long ckryid);
	/**
	 *ҩ�����ⵥ��
	 * @param rk_id ��ⵥID 
	 * @param ck_id ���ⵥID
	 * @param spsj  ����ʱ��
	 * @param rk_zt ���״̬
	 * @param ck_zt ����״̬
	 * @param yp ҩƷID�ͳ�������
	 * @param yfID ҩ��ID
	 * @return
	 */
	public boolean updateShenPi(String rk_id, String ck_id, String spsj, String rk_zt, String ck_zt,String[][] yp, Integer yfID, Long ckryid);
	public boolean updateChuKu(String AFormID, String ExbankTime, String ExbankStatus);
	public boolean updateYaofangChuKu(String RuKuDanhao, Integer RuKuRenID, String RuKuShiJian, String ZhuangKuang);
	/**
	 * ҩ�����뵥����Ӧҩ���ܾ�����
	 * @param RuKuID ��ⵥID
	 * @param ChuKuID ���ⵥID
	 * @param ShengPiShiJian ����ʱ��
	 * @param RuKuDanZhuangTai ��ⵥ״̬
	 * @return
	 */
	public boolean updateJuJueShengQing(String RuKuID, String ChuKuID, String ShengPiShiJian, String RuKuDanZhuangTai);
	/**
	 * �޸ĳ��ⵥ��ͷ�����ݣ���ɾ����ǰ���ϳ��ⵥ���ٽ����³��ⵥ��
	 * @param yfmexbankA ���ⵥ��ͷ
	 * @param yfexbankAitem ���ⵥ����
	 * @return AFormID ���뵥��
	 * @return yfapproveTable ������ͷ
	 * @return yfapproveItem ��������
	 * @return ShenPiLuoJi �������߼���
	 */
	public boolean updateChuKuDan(String AFormID,YfmexbankA yfmexbankA,List<YfexbankAitem> yfexbankAitem, YfapproveTable yfapproveTable, List<YfapproveItem> yfapproveItem, Integer ShenPiLuoJi);
	/**
	 * ɾ�����ⵥ��ͷ������
	 * @param AFormID
	 * @return
	 */
	public boolean delChuKuDan(String AFormID);
	/**
	 * ҩ����ҩ
	 * @param AFormID ���ⵥID
	 * @param QYRID ȡҩ����ID
	 * @param CKSJ ����ʱ��
	 * @param ZT ״̬
	 * @param yf ҩ��ID
	 * @param yp ҩƷID+��������
	 * @param YiZhuID ҽ��ID,�գ���סԺ,�ǿգ�סԺ
	 * @param ZhuYuanChuFangZhiXing סԺ����ִ��
	 * @param FYRID ��ҩ��ԱID
	 * @param YiZhuZhuangTai ҽ��״̬
	 * @param ZhuYuanHao סԺ��
	 * @param FeiYoung ����
	 * @param XiangZhen �Ƿ�Ҫ����������˱�
	 * @param XiangZhengJiZhang �����¼����
	 * @return
	 * 
	 */
	public boolean updateFaYao(String AFormID, Long QYRID, String CKSJ, String ZT, Integer yf,
			                   String[][] yp, Long FYRID, String YiZhuID, ZyippresExecute ZhuYuanChuFangZhiXing,
			                   String YiZhuZhuangTai, String ZhuYuanHao, Double FeiYoung, Boolean XiangZhen, SfaccountDetail XiangZhengJiZhang);
	/**
	 * ������������������ⵥ
	 * @param XingMing ����
	 * @param SuoXie ������д
	 * @param MenZhenHao �����
	 * @param KaiShiShiJian ��ʼʱ��
	 * @param JieSuShiJian ����ʱ��
	 * @param ZhuangTai ״̬
	 * @param ChuKuLeiXingID ��������ID
	 * @param YaoFangID ҩ��ID
	 * @return
	 */
	public String[][] getMenZhenChuKuDan(String XingMing, String SuoXie, String MenZhenHao, String KaiShiShiJian, String JieSuShiJian, String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID);

	/**
	 * ������������סԺ���ⵥ
	 * @param XingMing ����
	 * @param SuoXie ������д
	 * @param ZhuYuanHao �����
	 * @param KaiShiShiJian ��ʼʱ��
	 * @param JieSuShiJian ����ʱ��
	 * @param ZhuangTai ״̬
	 * @param ChuKuLeiXingID ��������ID
	 * @param YaoFangID ҩ��ID
	 * @return
	 */
	public String[][] getZhuYuanChuKuDan(String XingMing, String SuoXie, String ZhuYuanHao, String KaiShiShiJian, String JieSuShiJian, String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID);
	
	/**
	 * �˻�������ⵥ
	 * @param ShenQingDanHao ���뵥��
	 * @param ShenPiShiJian  ����ʱ��
	 * @param ChuKuZhangTai  ����״̬
	 * @param ChuKuRenYuanID ������ԱID
	 * @param ZhenDuanHao ��������ID
	 * @param ZhenDuanZhuangTai �������״̬
	 * @return
	 */
	public boolean updateMenZhengTuiHu(String ShenQingDanHao, String ShenPiShiJian, String ChuKuZhangTai, Long ChuKuRenYuanID, String ZhenDuanHao, String ZhenDuanZhuangTai);
	/**
	 * �˻�סԺ���ⵥ
	 * @param ShenQingDanHao ���뵥��
	 * @param YiZhuID ҽ��ID
	 * @param ZhuangTqi ״̬
	 * @return
	 */
	public boolean updateZhuYuanTuiHu(String ShenQingDanHao, String YiZhuID, String ZhuangTqi);
	/**
	 * add by xu 
	 * ��������ʱ�в���
	 * @param aFromId
	 * @return
	 */
	public YfmexbankA getById(String aFromId);
	/**
	 * ��������ѯ�������뵥
	 * @param aformId ���ⵥ��
	 * @param startDate ��ʼʱ��
	 * @param endDate ����ʱ��
	 * @param exbankStatus ����״̬
	 * @param validityPeriod ������Ч��
	 * @return
	 */
	public YfmexbankA getYfmexbankAByTiaojian(String aformId, String startDate,
			String endDate, String exbankStatus,
			String validityPeriod);
	
	/**
	 * ҩƷ����ͳ��
	 * @param lxid ��������ID
	 * @param ckzt ����״̬
	 * @param k_date ��ʼʱ��
	 * @param j_date ����ʱ��
	 * @param xm ����
	 * @param xmsx ������д
	 * @param yfid ҩ��ID
	 * @param qyid ȡҩ��ԱID
	 * @param qyks ȡҩ����ID
	 * @param ckdlx ���ⵥ����
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
	 * ��ȡ���סԺ����ִ�е�ID
	 * @return
	 */
	public String getZhuYuanChuFangZhiXingMaxID(); 
	public String[][] getYfmexbanka(String XingMing, String SuoXie,String Idcardnum,
			String MenZhenHao, String KaiShiShiJian, String JieSuShiJian,
			String ZhuangTai, Integer ChuKuLeiXingID, Integer YaoFangID);
	/**
	 * ���³��ⵥ���id
	 * @param AFormID
	 * @param rukuid
	 * @return
	 */
	public boolean updateChuKuforruku(String AFormID, String rukuid);
  /**
   * ͨ�����id��ѯlist
   * @param OPDnID
   * @return
   */
	public List<YfmexbankA> getYfmexbankAlistByOPDnID(String OPDnID);
}


