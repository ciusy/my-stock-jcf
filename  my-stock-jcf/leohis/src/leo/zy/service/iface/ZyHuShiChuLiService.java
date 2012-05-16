package leo.zy.service.iface;

import java.util.List;

import leo.entity.Cfcity;
import leo.entity.Cfgroup;
import leo.entity.Cfprefecture;
import leo.entity.Cfprovince;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.Csconsumer;
import leo.entity.CsheadShow;
import leo.entity.Czacontent;
import leo.entity.Czdispose;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.SfipdepositRecord;
import leo.entity.YfexbankAitem;
import leo.entity.YfmexbankA;
import leo.entity.Zyinpatient;

public interface ZyHuShiChuLiService {
	/**
	 * ��ʿ��ҳ��ѯ��Ժ��Ա
	 * @param zyh סԺ��
	 * @param cwh ��λ��
	 * @param xm ����
	 * @param xmsx ������д
	 * @param zybID סԺ��ID
	 * @param zrhs ���λ�ʿ
	 * @return
	 */
	public String[][] getHuShiShouYeZhuYuanRenYuan(String zyh, Integer cwh, String xm, String xmsx, Integer zybID, Long zrhs);
	
	/**
	 * ��ȡʡ
	 * @param ShengID ʡID  -2����ʡ��
	 * @return
	 */
	public List<Cfprovince> getShengJiLieBiao(Integer ShengID);
	/**
	 * ����ʡID������
	 * @param ShengId ʡID
	 * @return
	 */
	public List<Cfcity> getShiJiLieBiao(Integer ShengId);
	/**
	 * ������ID������
	 * @param ShiId ��ID
	 * @return
	 */
	public List<Cfprefecture> getXianJiLieBiao(long ShiId); 
	/**
	 * ������ID��������
	 * @param prefectureId
	 * @return
	 */
	public  List<Cftown> getXiangJiLieBiao(long  XianID);
	/**
	 * ������ID���ش�
	 * @param XiangId
	 * @return
	 */
	public List<Cfvillage> getCunJiLieBiao(long XiangId);
	/**
	 * ���ݴ�ID������
	 * @param CunId
	 * @return
	 */
	public List<Cfgroup> getZhuJiLieBiao(long CunId); 
	/**
	 * ��ȡ�������
	 * @param Shi ��
	 * @param Xian ��
	 * @param Xiang ��
	 * @param Cun ��
	 * @param Zu ��
	 * @param ShengFenZheng ���֤
	 * @param XingMing ����
	 * @param XingMingSuoXie ������д
	 * @param FuWuDuiXiangID �������ID
	 * @return
	 */
	public List<Csconsumer> getFuWuDuXiang(String Shi, String Xian, String Xiang, String Cun, String Zu, String ShengFenZheng, String XingMing , String XingMingSuoXie, Long FuWuDuiXiangID);
	/**
	 * �������סԺID
	 * @return
	 */
	public String getMaxID();
	/**
	 * ����סԺ��
	 * @param zyinpatient
	 * @return
	 */
	public boolean addZhuYuan(Zyinpatient zyinpatient);
	/**
	 * ����סԺ��
	 * @param ZhuYuanHao סԺID
	 * @param ChuangWeiHao ��λ��
	 * @param XingMing ����
	 * @param XingMingSuoXie ������д
	 * @param ShengQingShiJian_B ������Ժ��ʼʱ��
	 * @param ShengQingShiJian_E ������Ժ����ʱ��
	 * @param RuYuanShiJian_B ��Ժ��ʼʱ��
	 * @param RuYuanShiJian_E ��Ժ����ʱ��
	 * @param ShengQingZhuangTai ����״̬
	 * @param YueE1 ������
	 * @param GuanXi ����ѯ��ϵ> < >= <=
	 * @param ShiFouChuYuan �Ƿ��Ժ
	 * @param ChuYuanShiJian_B ��Ժ��ʼʱ��
	 * @param ChuYuanShiJian_E ��Ժ����ʱ��
	 * @param FeiYongLeiXingID ��������
	 * @param ZhuYuanBuId סԺ��ID
	 * @param ShengFeiZheng ���֤��
	 * @param FuWuDuiXiangID �������ID
	 * @return
	 */
	public String[][] getZYInpatient(String ZhuYuanHao, Integer ChuangWeiHao, String XingMing, String XingMingSuoXie, String ShengQingShiJian_B, String ShengQingShiJian_E, String RuYuanShiJian_B, String RuYuanShiJian_E, String ShengQingZhuangTai, String YueE1, String GuanXi, Integer ShiFouChuYuan, String ChuYuanShiJian_B, String ChuYuanShiJian_E, Integer FeiYongLeiXingID, Integer ZhuYuanBuId, String ShengFeiZheng, Long FuWuDuiXiangID);
	/**
	 * ������������Ϣ�������½��������ID��
	 * @param FuWuDuiXiang ���������Ϣ
	 * @param ShenFenZheng ���֤��
	 * @param TouXiang ͷ��
	 * @return
	 */
	public Long addFuWuDuiXiang(Csconsumer FuWuDuiXiang, String ShenFenZheng, String TouXiang);
	/**
	 * ��ȡ�������ͷ��
	 * @param id �������ID
	 * @return
	 */
	public String getTouXiang(long id);
	/**
	 * ��׼��Ժ
	 * @param zyinpatient סԺ������
	 * @param ChuangWeiHao ��λ��
	 * @param ZhuangTai ��λ״̬
	 * @return
	 */
	public boolean updatePiZhunRuYuan(Zyinpatient zyinpatient, Integer ChuangWeiHao, String ZhuangTai);
	/**
	 * ������λ
	 * @param ZhuYuanHao סԺ��
	 * @param OldChuangWeiHao ����ʹ�õĴ�λ��
	 * @param NewChuangWeiHao Ҫ�����Ĵ�λ��
	 * @param ZhuYuanBu סԺ��ID
	 * @return
	 */
	public boolean updateGengHuanChuangWei(String ZhuYuanHao, Integer OldChuangWeiHao, Integer NewChuangWeiHao, Integer ZhuYuanBu);
	/**
	 * ����סԺ�ŵ���סԺ��
	 * @param ZhuYuanHao סԺ��
	 * @return
	 */
	public List<Zyinpatient> getZyinpatientall(String ZhuYuanHao);
	/**
	 * סԺ��Ϣά��
	 * @param zyinpatient סԺ��Ϣ
	 * @param csconsumer ���������Ϣ
	 * @param csheadShow ͷ����Ϣ
	 * @param TouXiang ��ͷ����
	 * @return
	 */
	public boolean updateZhuYuanXinXiWeiHu(Zyinpatient zyinpatient, Csconsumer csconsumer, CsheadShow csheadShow, boolean TouXiang);
	/**
	 * �����ۼƷ���
	 * @param ZhuYuanHao סԺ��
	 * @param ShenQiShiJian_B ���뿪ʼʱ��
	 * @param ShenQiShiJian_E �������ʱ��
	 * @param ZhuangTai_CZ ����״̬
	 * @param ZhuangTai_Cf ����״̬
	 * @return
	 */
	public Double getLeiJiFeiYong(String ZhuYuanHao, String ShenQiShiJian_B, String ShenQiShiJian_E, String ZhuangTai_CZ, String ZhuangTai_Cf);
	/**
	 * ��ȡסԺѺ���¼
	 * @param ZhuYuanHao //סԺ��
	 * @return
	 */
	public List<SfipdepositRecord> getZhuYuanYaJinJiLe(String ZhuYuanHao);
	/**
	 * ��ȡҽ������
	 * @param ZhuYuanHao סԺ��
	 * @param ZhuangTai ҽ��״̬  (ǰ��Ҫ�������,����:=��ִ��)
	 * @param ZhuYuanBuID סԺ��ID
	 * @param RiQi_B ����ʱ��(��ʼ)
	 * @param RiQi_E ����ʱ��(����)
	 * @param ZhuangTaiTiaoJian ״̬���� (= <> ...)
	 * @return
	 */
	public String[][] getTiQuChuFang(String ZhuYuanHao, String ZhuangTai, Integer ZhuYuanBuID, String RiQi_B, String RiQi_E,String ZhuangTaiTiaoJian);
	/**
	 * ��ȡҽ������
	 * @param ZhuYuanHao סԺ��
	 * @param ZhuangTai ҽ��״̬
	 * @param ZhuYuanBuID סԺ��ID
	 * @param ChuZhiZhuangTai ����״̬
	 * @param RiQi_B ��ʼ����
	 * @param RiQi_E ��������
	 * @return
	 */
	public String[][] getTiQuChuZhi(String ZhuYuanHao, String ZhuangTai, Integer ZhuYuanBuID, String ChuZhiZhuangTai, String RiQi_B, String RiQi_E);
	/**
	 * ���ҽ��
	 * @param YiZhuID_ChuKuDanID ҽ�� ID,���ⵥID
	 * @param HuShi ��ʿ
	 * @param ShenHeShiJian ���ʱ��
	 * @param ZhuangTai ״̬
	 * @param ChuKuDanTou ���ⵥ��ͷ
	 * @param ChuKuNeirong ���ⵥ����
	 * @param ChuZhi ������Ŀ
	 * @param ChuZhiIDS סԺ����ҽ����ID ������ID  0:DAItemID 1:ItemID
	 * @param ShengQingDan ���뵥����
	 * @param GouYaJin ��Ѻ��
	 * @param ZhuYuanHao סԺ��
	 * @return
	 */
	public boolean updateShenHeYiZhu(String[][] YiZhuID_ChuKuDanID, Long HuShi, String ShenHeShiJian, String ZhuangTai, List<YfmexbankA> ChuKuDanTou, List<YfexbankAitem> ChuKuNeirong, List<Czdispose> ChuZhi, String[][] ChuZhiIDS, List<Czacontent> ShengQingDan, Double GouYaJin, String ZhuYuanHao);
	/**
	 * �õ�סԺ��Ա�����嵥
	 * @param ZhuYuanHao סԺ��
	 * @param ZhuanTai_CZ ����״̬
	 * @param ZhuangTai_CFFaYao ������ҩ״̬
	 * @param ZhuangTai_CFTuiYao ������ҩ״̬
	 * @param ZhiXingShiJian_B ִ�п�ʼʱ��
	 * @param ZhiXingShiJian_E ִ�н���ʱ��
	 * @return
	 */
	public String[][] getFeiYongQingDan(String ZhuYuanHao, String ZhuanTai_CZ, String ZhuangTai_CFFaYao, String ZhuangTai_CFTuiYao, String ZhiXingShiJian_B, String ZhiXingShiJian_E);
	/**
	 * ��ȡ�����ID
	 * @return
	 */
	public String getChuZhiMaxID();
	/**
	 * ��ȡ������Ŀ����
	 * @param id ��Ŀ����ID
	 * @return
	 */
	public CzdisposeItemDescribe getChuZhiXiangMuMiaoShu(Integer id);
	/**
	 * ȡ�����_����
	 * @param YiZhu_ChuKuDan ҽ��ID���Ӧ�ĳ��ⵥID  0:ҽ��ID  1:���ⵥID
	 * @param YiZhuZhuangTai ״̬
	 * @param HuShiID ��ʿID
	 * @param ShiJian ʱ��
	 * @return
	 */
	public boolean updateQuXiaoShengHe_CF(String[][] YiZhu_ChuKuDan, String YiZhuZhuangTai, Long HuShiID, String ShiJian);
	/**
	 * ȡ�����_����
	 * @param YiZhu ҽ��ID
	 * @param YiZhuXiang_ChuZhi ҽ����ID��Ӧ�Ĵ�����ID  0:ҽ����ID  1:������ID=""
	 * @param ChuZhi ������ID
	 * @param YiZhuZhuangTai ״̬
	 * @param HuShiID ��ʿID
	 * @param ShiJian ʱ��
	 * @return
	 */
	public boolean updateQuXiaoShengHe_CZ(String[] YiZhu, String[][] YiZhuXiang_ChuZhi, String[] ChuZhi, String YiZhuZhuangTai, Long HuShiID, String ShiJian);
	/**
	 * �ж�һ��ҽ�������Ƿ��в���ִ�еĴ�����Ŀ
	 * @param YiZhuHao ҽ������
	 * @return
	 */
	public boolean getChuZhiBuFenZhiXing(String YiZhuHao);
	/**
	 * ��ȡ��ҩ���
	 * @param ZhuYuanHao סԺ��
	 * @param ZhuangTai ״̬
	 * @return
	 */
	public String[][] getTuiYaoShengHe(String ZhuYuanHao, String ZhuangTai);
	/**
	 * �����ҩ��
	 * @param DanJu������Ϣ  0:��ⵥ��  1:״̬  2:���ʱ��
	 * @return
	 */
    public boolean updateShengHeTuiYao(String[][] DanJu);
    /**
     * ȡ����ҩ��
     * @param ZhuYuanYaoPin סԺҩƷ  0:ҩƷ��ĿID  1:����
     * @param XiuGaiChuKuDan Ҫ�޸ĵĳ��ⵥ��Ϣ  0:���ⵥ��  1:ҩƷID 2:��������  3:���˼۸�
     * @param RuKuDanID ��ⵥ��
     * @return
     */
    public boolean updateQuXiaoTuiYao(String[][] ZhuYuanYaoPin, String[][] XiuGaiChuKuDan, String[] RuKuDanID);
	/**
	 * ����ҽ��ID��ҩƷID�õ�ҽ����ID
	 * @param DAID ҽ��ID
	 * @param MInfoID ҩƷID
	 * @return
	 */
	public String getYiZhuXiangID(String DAID, Integer MInfoID);
	/**
	 * ������ⵥID��ҩƷID�õ�סԺҽ����ĳ��ⵥID
	 * @param RuKuDanID
	 * @param YaoPinID
	 * @return
	 */
	public String getChuKuDanID(String RuKuDanID, Integer YaoPinID);
	/**
	 * �õ�סԺ��Ա�ܽ��
	 * @param ZhuYuanHao סԺ��
	 * @return
	 */
	public Double getZhuYuanZongJieE(String ZhuYuanHao);
	/**
	 * ��Ա��Ժ
	 * @param ZhuYuanHao סԺ��
	 * @param ChuYuanShiJian ��Ժʱ��
	 * @param ZhuangTai ����״̬
	 * @param ChuangWeiHao ��λ��
	 * @param ZhuYuanBu סԺ��ID
	 * @param ChuangWeiZhuangTai ��λ״̬
	 * @return
	 */
	public boolean updateBanLiChuYuan(String ZhuYuanHao, String ChuYuanShiJian, String ZhuangTai, Integer ChuangWeiHao, Integer ZhuYuanBu, String ChuangWeiZhuangTai);
	/**
	 * �޸�ũ����֤��,ũ�Ϻ�,�ֻ�
	 * @param FuWuDuiXiangID �������ID
	 * @param ShengFenZhengHao ���֤
	 * @param NongHeHao ũ��
	 * @param ShouJiHao �ֻ�
	 * @return
	 */
	public boolean updateCSConsumerZhuYuan(Long FuWuDuiXiangID, String ShengFenZhengHao, String NongHeHao, String ShouJiHao);
	
}
