package leo.zy.service.iface;

import java.util.List;

import leo.entity.CfacontentFramework;
import leo.entity.CzbcultrasoundImage;
import leo.entity.CzbcultrasoundIs;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.CzmilkGlandImage;
import leo.entity.CzmilkGlandIs;
import leo.entity.YfinbankAitem;
import leo.entity.YfminbankA;
import leo.entity.Zydischarge;
import leo.entity.ZydoctorAdvice;
import leo.entity.Zyipmedicine;
import leo.entity.Zyipteatment;
import leo.entity.Zymadministration;
import leo.entity.ZydoctorAdviceLongTerm;

public interface ZyYiShengChuLiService {
	/**
	 * ��ȡҩƷ�÷�
	 * @return
	 */
	public List<Zymadministration> getYaoPingYongFa();
	/**
	 * �������ƻ�ƴ����д��ȡ������Ŀ
	 * @param Name ����
	 * @param Spell ƴ����д
	 * @return
	 */
	public List<CzdisposeItemDescribe> getChuZhi(String Name, String Spell);
	/**
	 * ������ʱҽ��
	 * @param YiZhu_cf ҽ������_����
	 * @param YiZhu_cz ҽ������_����
	 * @param ChuFang ��������
	 * @param ChuZhi ��������
	 * @param JiaRuChuFang �Ƿ������ʱ����
	 * @param JiaRuChuZhi �Ƿ������ʱ����
	 * @param JiaRuChuangQiYiZhu �Ƿ���볤��ҽ��
	 * @param ChuangQiYiZhu ����ҽ��
	 * @param ChangQiYiZhuChuLi �Ƿ����ڻ�ʿ����ҽ������
	 * @param RiQi 0:����ҽ��ID  1:�´�ִ��ʱ��
	 * @param ChangQiYiZhuID ����ҽ��ID
	 * @param BiaoZhi ����ҽ���Ƿ��Ѿ�ִ�б�־ true false
	 * @return
	 */
	public boolean addLinShiYiZhu(List<ZydoctorAdvice> YiZhu_cf, List<ZydoctorAdvice> YiZhu_cz, List<Zyipmedicine> ChuFang, List<Zyipteatment> ChuZhi, boolean JiaRuChuFang, boolean JiaRuChuZhi, boolean JiaRuChuangQiYiZhu, List<ZydoctorAdviceLongTerm> ChuangQiYiZhu, boolean ChangQiYiZhuChuLi, String[][] RiQi, Long[] ChangQiYiZhuID, Boolean BiaoZhi);
	/**
	 * �������ҽ��ID
	 * @return
	 */
	public String getMaxID();
	/**
	 * �ж�һ����Ŀ�Ƿ����
	 * @param ZhuYuanHao סԺ��
	 * @param XiangMuLeiXing ��Ŀ����(����������)
	 * @param XiangMuID ��ĿID
	 * @param ChangQiYiZhuID ����ҽ��ID -1:����ʱʹ��   ����ҽ��ID:�޸�ʱʹ��
	 * @return
	 */
	public boolean getXiangMuShiFouCunZai(String ZhuYuanHao, String XiangMuLeiXing, Integer XiangMuID, Long ChangQiYiZhuID);
	/**
	 * ��ȡ����ҽ��
	 * @param ZhuYuanHao סԺ��
	 * @param RiQi ��ǰ����
	 * @param LeiXing ����
	 * @param WeiTingZhu �Ƿ�ֻ��ȡδͣҽ��
	 * @return
	 */
	public List<ZydoctorAdviceLongTerm> getChangQiYiZhu(String ZhuYuanHao, String RiQi, String LeiXing, Boolean WeiTingZhu);
	/**
	 * ��ȡ��������ģ��
	 * @param DanWei ҽ�ƻ���ID
	 * @param XiangMuLeiXingID ��Ŀ����ID
	 * @param MoBanID ģ��ID
	 * @return
	 */
	public List<CfacontentFramework> getChuZhiMoBan(Integer DanWei, Integer XiangMuLeiXingID, Integer MoBanID);
	/**
	 * ά����������ģ��
	 * @param MoBan ģ������
	 * @param MoBanID ģ��ID  -2:����  ������ɾ�� 
	 * @return
	 */
	public Boolean addChuZhiMoBan(CfacontentFramework MoBan, Integer MoBanID);
	/**
	 * �޸���ʱ������Ŀ
	 * @param Xiang ҩƷ��Ŀ
	 * @return
	 */
	public boolean updateLinShiChuFangXiang(Zyipmedicine Xiang);
	/**
	 * ɾ����ʱ������Ŀ
	 * @param YiZhuID ҽ��ID
	 * @param Xiang ҩƷ����
	 * @param LingYaoDanID ��ҩ��ID
	 * @param YaoPingID ҩƷID
	 * @param delChuKuDanTou �Ƿ�ɾ�����ⵥͷ true:ɾ�� false:��ɾ��
	 * @return
	 */
	public boolean delLinShiChufangXiang(String YiZhuID, Long Xiang, String LingYaoDanID, Integer YaoPingID, Boolean delChuKuDanTou);
	/**
	 * ɾ����ʱ������Ŀ
	 * @param YiZhuId ҽ��ID
	 * @param YiZhuXiangID ҽ����ID
	 * XiangMuID ������ID(����ɾ�����������������ݱ��ж�Ӧ����Ŀ)
	 * @return
	 */
	public boolean delLinSheChuZhiXiang(String YiZhuId, Long YiZhuXiangID, String XiangMuID);
	/**
	 * ��ʱ������ҩ
	 * @param ZhuYuanYaoPin סԺҩƷ  0:ҩƷ��ĿID  1:�˵������
	 * @param XiuGaiChuKuDan Ҫ�޸ĵĳ��ⵥ��Ϣ  0:���ⵥ��  1:ҩƷID 2:��������  3:���˼۸�
	 * @param RuKuDanTou ��ⵥͷ
	 * @param RuKuDanNeiRong ��ⵥ����
	 * @return 
	 */
	public boolean updateLinShiChuFangTuiYao(String[][] ZhuYuanYaoPin, String[][] XiuGaiChuKuDan, List<YfminbankA> RuKuDanTou, List<YfinbankAitem> RuKuDanNeiRong);
	/**
	 * ��ȡB�����浥
	 * @param XiangMuID ��ĿID
	 * @return
	 */
	public List<CzbcultrasoundIs> getBCBaoDaoDan(String XiangMuID);
	/**
	 * ��ȡB��ͼƬ
	 * @param BaoGaoDanID ���浥ID
	 * @return
	 */
	public List<CzbcultrasoundImage> getBCTuPian(String BaoGaoDanID);
	/**
	 * ��ȡ���ٱ��浥
	 * @param XiangMuID ��ĿID
	 * @return
	 */
	public List<CzmilkGlandIs>getRXBaoGaoDan(String XiangMuID);
	/**
	 * ��ȡ����ͼƬ
	 * @param BaoGaoDanID ���浥ID
	 * @return
	 */
	public List<CzmilkGlandImage> getRXTuPian(String BaoGaoDanID); 
	/**
	 * ����ҽ��ID��ȡҽ������
	 * @param DAID ҽ��ID
	 * @return
	 */
	public List<ZydoctorAdvice> getZydoctorAdvice(String DAID);
	/**
	 * �޸�סԺ���ñ�������뵥����
	 * @param ShenQingNeiRong ��������
	 * @param DAItemID ҽ����ID
	 * @return
	 */
	public boolean updateShenQingDanNeiRong(String ShenQingNeiRong, Long DAItemID);
	/**
	 * �޸�סԺ���õ���Ŀ����ID��ִ�п���
	 * @param ItemTypeID ��Ŀ����ID
	 * @param ExecuteU ִ�п���
	 * @param DAItemID ҽ����ID
	 * @return
	 */
	public boolean updateChuZhiXiangMu(Integer ItemTypeID, Integer ExecuteU, Long DAItemID);
	/**
	 * ɾ������ҽ����Ŀ
	 * @param LTID ����ҽ��ID
	 * @return
	 */
	public boolean delChangQiYiZhu(Long LTID);
	/**
	 * �޸ĳ���ҽ��
	 * @param NeiRong Ҫ�޸ĵ�����     0 ��ĿID  1 ����   2 �÷�    3 ��ҩ��ʽ    4 ����   5 ִ�п���ID 6 ִ��ʱ��    7 �´�ִ������ 
	 * @param LTID ����ҽ��ID
	 * @return
	 */
	public boolean updateChuangQiYiZhu(String[] NeiRong, Long LTID);
	/**
	 * ֹͣ�����¿�������ҽ��
	 * @param TingZhuYiSheng ͣ��ҽ��
	 * @param TingZhuShiJian ͣ��ʱ��
	 * @param XiaCiZhiXingRiQi �´�ִ������
	 * @param ID ����ҽ��ID
	 * @return
	 */
	public boolean updateTingZhu(Long TingZhuYiSheng, String TingZhuShiJian, String XiaCiZhiXingRiQi, Long ID);
	/**
	 * ������Ŀ����ID������Ŀ����
	 * @param ItemTypeID ��Ŀ����ID
	 * @return
	 */
	public String getChuZhiMingCheng(Integer ItemTypeID);
	/**
	 * ֹͣ���г�δͣ�ĳ���ҽ��
	 * @param ZhuYuanHao סԺ��
	 * @param TingZhuYiSheng ͣ��ҽ��
	 * @param TingZhuShiJian ͣ��ʱ��
	 * @return
	 */
	public boolean updateAllTingZhu(String ZhuYuanHao, Long TingZhuYiSheng, String TingZhuShiJian);
	/**
	 * ����Ժ֪ͨ
	 * @param TongZhi ��Ժ֪ͨ
	 * @param ZhuYuanHao סԺ��
	 * @param ShengQingZhuangTai ����״̬
	 * @return
	 */
	public boolean updateChuYuanTongZhi(Zydischarge TongZhi, String ZhuYuanHao, String ShengQingZhuangTai);
	/**
	 * ��ȡ��Ժ֪ͨ
	 * @param ZhuYuanHao סԺ��
	 * @return
	 */
	public List<Zydischarge> getChuYuanTongZhi(String ZhuYuanHao);
	/**
	 * ȡ����Ժ
	 * @param ZhuYuanHao סԺ��
	 * @param ZhuangTai ״̬
	 * @return
	 */
	public boolean updateQuXiaoChuYuan(String ZhuYuanHao, String ZhuangTai);
	/**
	 * �޸ĳ�Ժ֪ͨ
	 * @param zydischarge ֪ͨ����
	 * @return
	 */
	public boolean updateXiuGaiTongZhi(Zydischarge zydischarge);
	/**
	 * ��ȡ���豨�浥
	 * @param LeiXingID ����ID
	 * @param JiGouID ҽ�ƻ���ID
	 * @return
	 */
	public String getBaoGaoDan(Integer LeiXingID, Integer JiGouID);
	/**
	 * ������ĿID����Ŀ������ȡ����
	 * @param ItemID ��ĿID
	 * @param ItemName ��Ŀ����
	 * @return
	 */
	public String[][] getHuaYianDan(String ItemID, String ItemName);

}
