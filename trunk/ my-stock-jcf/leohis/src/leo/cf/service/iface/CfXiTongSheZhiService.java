package leo.cf.service.iface;

import java.util.List;

import leo.entity.Cfcity;
import leo.entity.Cfprefecture;
import leo.entity.Cfprovince;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.CzdisposalType;
import leo.entity.CzdisposeDivaricateU;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.GhregisterType;
import leo.entity.OsfnAuthorityForm;
import leo.entity.OsfnBlocks;
import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.OsudefaultFn;
import leo.entity.YfmdosageType;
import leo.entity.YfmdosageUnit;
import leo.entity.Yfmmanufacturer;
import leo.entity.Yfmtype;
import leo.entity.YfmwayTo;

public interface CfXiTongSheZhiService {
	/**
	 * �༭ҽ�ƻ���ȫ������
	 * @param NeiRong ���� 0:��������   1:ֵ   2:ҽ�ƻ���ID
	 * @return
	 */
	public boolean updateBianJiYiLiaoJiGouPeiZhi(String[][] NeiRong);
	/**
	 * ��ȡ������Ŀֵ
	 * @param XiangMu ���� 0:��Ŀ����   1:ҽ�ƻ���ID
	 * @return 0:��Ŀ����  1:ֵ
	 */
	public String[][] getPeiZhiXiangMuZhi(String[][] XiangMu);
	/**
	 * ���տ���IDɾ������
	 * @param KeShiID ����ID
	 * @return
	 */
	public boolean delKeShi(Integer KeShiID);
	/**
	 * ��ȡҩƷ���
	 * @return
	 */
	public List<Yfmtype> getYaoPinLeiBie();
	/**
	 * ��ȡҩƷ����
	 * @return
	 */
	public List<YfmdosageType> getJiXing();
	/**
	 * ��ȡ��ҩ��ʽ
	 * @return
	 */
	public List<YfmwayTo> getGeiYaoFangShi();
	/**
	 * ��ȡ������λ
	 * @return
	 */
	public List<YfmdosageUnit> getJiLiangDanWei();
	/**
	 * ��ȡ��������
	 * @param name ����
	 * @return
	 */
	public List<Yfmmanufacturer> getShengChanChangJia(String name);
	/**
	 * ����ҩƷ��������
	 * @param LeiBie ҩƷ���
	 * @param JiXing ҩƷ����
	 * @param GeiYaoFangShi ��ҩ��ʽ
	 * @param DanWei ������λ
	 * @param ChangJia ��������
	 * @param FLeiBie �Ƿ���ҩƷ����
	 * @param  FJiXing �Ƿ���ҩƷ����
	 * @param  FGeiYaoFangShi �Ƿ����ҩ��ʽ
	 * @param FDanWei �Ƿ��������λ
	 * @param  FChangJia �Ƿ�����������
	 * @return
	 */
	public boolean addYaoPingCanShu(List<Yfmtype> LeiBie, 
									List<YfmdosageType> JiXing, 
									List<YfmwayTo> GeiYaoFangShi, 
									List<YfmdosageUnit> DanWei, 
									List<Yfmmanufacturer> ChangJia,
									boolean FLeiBie,
									boolean FJiXing,
									boolean FGeiYaoFangShi,
									boolean FDanWei,
									boolean FChangJia);
	/**
	 * ��ȡ�������
	 * @return
	 */
	public List<CzdisposalType> getChuZhiLeiBie();
	/**
	 * ���洦�����
	 * @param LeiBie ���
	 * @param FLeiBie �Ƿ񱣴�
	 * @return
	 */
	public boolean addChuZhiLeiBie(List<CzdisposalType> LeiBie, boolean FLeiBie);
	/**
	 * �������ơ�ƴ���������ȡ��Ŀ
	 * @param MingCheng ����
	 * @param PingYin ƴ��
	 * @param LeiBie ���
	 * @param YiLiaoJiGou ҽ�ƻ���
	 * @return
	 */
	public List<CzdisposeItemDescribe> getChuZhiXiangMu(String MingCheng, String PingYin, String LeiBie, Integer YiLiaoJiGou);
	/**
	 * ������ĿID��ѯ�������Ҷ���
	 * @param czid ����ID
	 * @return CzdisposeDivaricateU
	 */
	public List<CzdisposeDivaricateU> getChuZhiKaiChuKeShi(Integer czid);
	/**
	 * ����ҽ�ƻ�������Ŀ�����ж��Ƿ����
	 * @param MingCheng ��Ŀ����
	 * @param YiLiaoJiGou ҽ�ƻ���
	 * @return
	 */
	public Integer getChuZhiXiangMuCunZi(String MingCheng, Integer YiLiaoJiGou);
	/**
	 * ����ҽ�ƻ����͹Һ���������ж��Ƿ����
	 * @param MingCheng ����
	 * @param YiLiaoJiGou ҽ�ƻ���
	 * @return
	 */
	public Integer getGuaHaoLeiBieCunZai(String MingCheng, Integer YiLiaoJiGou);
	/**
	 * �������ƻ�ƴ����ѯ�Һ����
	 * @param MingCheng ����
	 * @param PingYin ƴ��
	 * @param YiLiaoJiGou ҽ�ƻ���
	 * @return
	 */
	public List<GhregisterType> getGuaHaoXiangMu(String MingCheng, String PingYin, Integer YiLiaoJiGou);
	/**
	 * ���洦����Ŀ
	 * @param XiangMu ������Ŀ
	 * @param KaiChuKeShi ��������
	 * @return
	 */
	public boolean addChuZhiXiangMu(CzdisposeItemDescribe XiangMu, List<CzdisposeDivaricateU> KaiChuKeShi);
	/**
	 * ɾ��������Ŀ
	 * @param XiangMuID ������ĿID
	 * @return
	 */
	public boolean delChuZhiXiangMu(Integer XiangMuID);
	/**
	 * �޸Ĵ�����Ŀ
	 * @param XiangMu ������Ŀ
	 * @param KaiChuKeShi ��������
	 * @return
	 */
	public boolean updateChuZhiXiangMu(CzdisposeItemDescribe XiangMu, List<CzdisposeDivaricateU> KaiChuKeShi);
	/**
	 * ����Һ�����
	 * @param GuaHaoLeiXing �Һ�����
	 * @return
	 */
	public boolean addGuaHaoLeiXing(GhregisterType GuaHaoLeiXing);
	/**
	 * �޸ĹҺ�����
	 * @param GuaHaoLeiXing �Һ�����
	 * @return
	 */
	public boolean updateGuaHaoLeiXing(GhregisterType GuaHaoLeiXing);
	/**
	 * ���չҺ�����IDɾ���Һ�����
	 * @param LeiXingID �Һ�����ID
	 * @return
	 */
	public boolean delGuaHaoLeiXing(Integer LeiXingID);
	/**
	 * ��ȡʡ��
	 * @param ShengID ʡID
	 * @return
	 */
	public List<Cfprovince> getShengJiLieBiao(Integer ShengID);
	/**
	 * ��ȡ��
	 * @param ShengId ʡID
	 * @return
	 */
	public List<Cfcity> getShiJiLieBiao(Integer ShengId);
	/**
	 * ��ȡ��
	 * @param ShiId ��ID
	 * @return
	 */
	public List<Cfprefecture> getXianJiLieBiao(long ShiId);
	/**
	 * ��ȡ��
	 * @param XianID ��ID
	 * @return
	 */
	public  List<Cftown> getXiangJiLieBiao(long  XianID);
	/**
	 * ��ȡ��
	 * @param XiangId ��ID
	 * @return
	 */
	public List<Cfvillage> getCunJiLieBiao(long XiangId);
	/**
	 * ��ȡҽ�ƻ���
	 * @param mid ҽ�ƻ���ID
	 * @return
	 */
	public OsmedicalInstInfo getYiLiaoJiGou(int mid);
	/**
	 * ����ҽ�ƻ���
	 * @param YiLiaoJiGou ҽ�ƻ���
	 * @return
	 */
	public boolean addYiLiaoJiGou(OsmedicalInstInfo YiLiaoJiGou);
	/**
	 * �޸�ҽ�ƻ���
	 * @param YiLiaoJiGou ҽ�ƻ���
	 * @return
	 */
	public boolean updateYiLiaoJiGou(OsmedicalInstInfo YiLiaoJiGou);
	/**
	 * ��ȡ������ģ��
	 * @return
	 */
	public List<OsfnBlocks> getFuGongNeng();
	/**
	 * �������Ĭ�Ϲ���
	 * @param osudefaultFn
	 * @return
	 */
	public boolean addKeShiMoRenGongNeng(List<OsudefaultFn> osudefaultFn);
	/**
	 * ��ȡ���Ҷ�Ӧ�Ĺ���
	 * @param uid
	 * @return
	 */
	public String[][] getKeShiMoRenGongNeng(Integer uid);
	/**
	 * ɾ�����Ҷ�Ӧ�Ĺ���
	 * @param uid ����ID
	 * @param FcBlocksID ����ID
	 * @return
	 */
	public boolean delKeShiMoRenGongNeng(Integer uid, Integer FcBlocksID);
	/**
	 * �������ÿ���
	 * @param sid ��ԱID
	 * @param uidlist ����ID��
	 * @param CaiDan �Ƿ����˵�
	 * @param MoRenCaiDan �˵�����
	 * @return
	 */
	public boolean addPeiZhiKeShi(long sid, int[] uidlist, boolean CaiDan, List<OsfnAuthorityForm> MoRenCaiDan);
	/**
	 * �޸����ÿ���
	 * @param sid ��ԱID
	 * @param uidlist ����ID��
	 * @return
	 */
	public boolean updatePeiZhiKeShi(long sid, int[] uidlist, boolean CaiDan, List<OsfnAuthorityForm> MoRenCaiDan);
	/**
	 * ��ȡ���Ҷ�Ӧ�Ĺ���
	 * @param uid ����ID
	 * @return
	 */
	public String[][] getKeShiGongNeng(Integer uid);
	/**
	 * ������˵�ID��
	 * @return
	 */
	public Integer getCaiDanMaxID();
	/**
	 * ��ȡ��ģ��
	 * @param FatherFnBlocksID ������ģ��ID
	 * @return
	 */
	public List<OsfnBlocks> getZiMoKuai(Integer FuGongNengID);
	/**
	 * ��ȡ��¼��Ա�������˵���
	 * @param sid ��ԱID
	 * @return
	 */
	public String[][] getCaiDanShu(long sid);
	/**
	 * ���ݲ˵�ID�޸Ĳ˵�����
	 * @param MenuID �˵�ID
	 * @param MenuName �˵�����
	 * @return
	 */
	public boolean updateCaiDanMingCheng(Integer MenuID, String MenuName);
	/**
	 * ɾ���˵�
	 * @param LeiXing ����(����,ģ��,����)
	 * @param MenuID �˵�ID
	 * @param YuanGongID Ա��ID
	 * @return
	 */
	public boolean delCaiDan(String LeiXing, Integer MenuID, Long YuanGongID);
	/**
	 * ����˵�
	 * @param osfnAuthorityForm �˵�����
	 * @return
	 */
	public boolean addCaiDan(List<OsfnAuthorityForm> CaiDanNeiRong);
	/**
	 * ͨ����¼����������Ҷ�ӦԱ��
	 * @param loginname ��¼��
	 * @param password  ����
	 * @return
	 */
	public Osstuff getDengLuYuanGong(String loginname, String password);
	/**
	 * �޸�Ա���û���������
	 * @param SID Ա��ID
	 * @param LoginName �û���
	 * @param Password ����
	 * @return
	 */
	public boolean updateYongHu(Long SID, String LoginName, String Password);
	/**
	 * ���ÿ�ݰ�ť
	 * @param MenuID �˵�ID
	 * @param QuickName ����
	 * @param QuickImageID ͼ��ID
	 * @param QuickClass ������
	 * @return
	 */
	public boolean updateKuaiJianAnNiu(Integer MenuID, String QuickName, String QuickImageID, String QuickClass);
	/**
	 * ��ȡ��ӦԱ���Ŀ�ݰ�ť
	 * @param SID
	 * @return
	 */
	public String[][] getKuaiJieAnNiu(Long SID);
	/**
	 * ��ȡ��Ӧ�˵��Ŀ�ݰ�ť
	 * @param MenuID
	 * @return
	 */
	public String[][] getKuaiJieAnNiuByCaiDanID(Integer MenuID);
	/**
	 * ��ȡ��Ӧ���ܵ�������
	 * @param FnBlocksID
	 * @return
	 */
	public List<OsfnBlocks> GetGongNengLei(Integer FnBlocksID);
	/**
	 * ��ȡĿ¼
	 * @param sid ��ԱID 
	 * @param FatherMenuID ���˵�ID
	 * @return
	 */
	public String[][] getMuLu(Long sid, Integer FatherMenuID);
	/**
	 * ����Ŀ¼
	 * @param MenuID �˵�ID
	 * @param FatherMenuID ���˵�ID
	 * @return
	 */
	public boolean updateMuLu(Integer MenuID, Integer FatherMenuID);
	/**
	 * �ж�һ�������Ƿ���Ŀ¼��
	 * @param Sid ��ԱID
	 * @param FatherMenuID ���˵�ID
	 * @return
	 */
	public String[][] getZaiMuLuLi(Long Sid, Integer FatherMenuID);
	/**
	 * �ж��û���¼�����Ƿ����
	 * @param LoginName ��¼����
	 * @param SID Ա��ID
	 * @return true ����  false ������
	 */
	public boolean getYongHuCunZai(String LoginName, Long SID);
	/**
	 * ����ʡID��ȡʡ��
	 * @param ShengID ʡID
	 * @return
	 */
	public String getShengName(Integer ShengID);
	/**
	 * ������ID��ȡ����
	 * @param ShiID ��ID
	 * @return
	 */
	public String getShiName(Integer ShiID);
	/**
	 * ������ID��ȡ����
	 * @param XianID ��ID
	 * @return
	 */
    public String getXianName(Long XianID);
    /**
     * �õ������ID
     * @param XianID ��ID
     * @return
     */
	public String getMaxXiangID(long XianID);
	/**
	 * ������
	 * @param TownID ��ID
	 * @param PrefectureID ��ID
	 * @param TownName ����
	 * @return
	 */
	public boolean addXiang(long TownID, long PrefectureID, String TownName);
	/**
	 * ɾ����
	 * @param XiangID ��ID
	 * @return
	 */
	public boolean delXiang(long XiangID);
	/**
	 * �õ�����ID
	 * @param XiangID ��ID
	 * @return
	 */
	public String getMaxCunID(long XiangID);
	/**
	 * ���Ӵ�
	 * @param VillageID ��ID
	 * @param TownID ��ID
	 * @param VillageName ����
	 * @return
	 */
	public boolean addCun(long VillageID, long TownID, String VillageName);
	/**
	 * ɾ����
	 * @param VillageID ��ID
	 * @return
	 */
	public boolean delCun(long VillageID);
	/**
	 * �޸�������
	 * @param TownID ��ID
	 * @param Name ����
	 * @return
	 */
	public boolean updateXiang(long TownID, String Name);
	/**
	 * �޸Ĵ���
	 * @param VillageID ��ID
	 * @param name ����
	 * @return
	 */
	public boolean updateCun(long VillageID, String name);

}
