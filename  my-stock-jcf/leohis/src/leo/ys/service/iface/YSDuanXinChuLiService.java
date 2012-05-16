package leo.ys.service.iface;

import java.util.List;

import leo.entity.Cfcity;
import leo.entity.Cfprefecture;
import leo.entity.Cfprovince;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.Csconsumer;
import leo.entity.HealthyPregnantSms;
import leo.entity.OsmedicalInstInfo;
import leo.entity.SmsModule;
import leo.entity.SmsModuleTerm;

public interface YSDuanXinChuLiService {
	/**
	 * ���Ӷ���ģ��ͷ
	 * @param MoBanTou ģ��ͷ����
	 * @return
	 */
	public Long addMoBanTou(SmsModule MoBanTou);
	/**
	 * ����ģ�����ͺ�������λID����ģ��ͷ
	 * @param PointName ģ������
	 * @param AffiliationID ������λID
	 * @return
	 */
	public List<SmsModule> getMobanTou(String LeiXing, Long DanWeiID);
	/**
	 * �޸�ģ��ͷ
	 * @param smsModule ģ��ͷ����
	 * @return
	 */
	public boolean updateMobanTou(SmsModule MoBanTou);
	/**
	 * ���Ӷ���ģ����
	 * @param smsModuleTerm ģ��������
	 * @return
	 */
	public Long addMoBanXiang(SmsModuleTerm MoBanXiang);
	/**
	 * ���ݶ���ģ��ID��ȡ����ģ����
	 * @param ModuleID ����ģ��ID
	 * @return
	 */
	public List<SmsModuleTerm> getMoBanXiang(Long MoBanID);
	/**
	 * �޸Ķ���ģ����
	 * @param smsModuleTerm ����ģ��������
	 * @return
	 */
	public boolean updateMoBanXiang(SmsModuleTerm MoBanXiang);
	/**
	 * ����ģ����ID��ģ��IDɾ��ģ����
	 * @param MobanXiangID ģ����id
	 * @param MoBanID ģ��id
	 * @return
	 */
	public boolean delMoBanXiang(Long MobanXiangID, Long MoBanID);
	/**
	 * ɾ��ģ��
	 * @param MoBanID ģ��ID
	 * @return
	 */
	public boolean delMoBan(Long MoBanID);
	/**
	 * ���ݵ�λID��ȡģ������
	 * @param DanWeiID ��λID
	 * @return 0:ģ������  1:ģ��ID
	 */
	public String[][] getMoBanMingCheng(Long DanWeiID); 
	/**
	 * ��ȡģ��������
	 * @param ModuleID ģ��ID
	 * @return 0:ģ����ID  1:ǰ������  2:ģ������  3��������
	 */
	public String[][] getXiangNeiRong(Long MoBanID);
	/**
	 * ��ȡ�����͵�����
	 * @param TianShu ǰ������
	 * @param LeiXing ����
	 * @return
	 */
	public String[][] getDuanXinDaiFaNeiRong(Integer TianShu, String LeiXing);
	/**
	 * ���ݵ�������ȡ��֪����
	 * @param DangAnHao ������
	 * @return
	 */
	public String getGaoZhiNeiRong(String DangAnHao);
	/**
	 * ��ȡҽ�ƻ���
	 * @param mid ҽ�ƻ���ID
	 * @return
	 */
	public OsmedicalInstInfo getYiLiaoJiGouById(int mid);
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
	 * ��������Ҫ���͵Ķ�������
	 * @param healthyPregnantSms ��������
	 * @return
	 */
	public boolean addDaiFaDuanXinNeiRong(List<HealthyPregnantSms> DuanXinNeiRong);
	
}
