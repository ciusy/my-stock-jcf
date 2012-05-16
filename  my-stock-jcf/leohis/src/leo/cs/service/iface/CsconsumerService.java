package leo.cs.service.iface;

import java.util.List;

import leo.entity.Cfcity;
import leo.entity.Cfprefecture;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.Csconsumer;
import leo.entity.CsefileInfo;
import leo.entity.CsmarriageHistory;
import leo.entity.CsmedicalCard;
import leo.entity.CsmedicalCardDetail;
import leo.entity.GhmrCg;

public interface CsconsumerService {
	public Csconsumer getCInfoById(Long id);

	public Boolean addCsconsumerInfo(Csconsumer csconsumer);// ��ӷ��������Ϣ

	public Boolean updateCsconsumerInfo(Csconsumer csconsumer);// ���·��������Ϣ

	/**
	 * add by xu
	 * ����id���Ϸ��ط������
	 * @param ids
	 * @return
	 */
	List<Csconsumer> getByIds(List<Long> ids);
	
	/*����������������ƴ����д�������֤�ţ���ҽ�ƿ��ţ����ַ���أ��򣬴壩�ҵ�������*/
	public String[][] getCInfo(String csname,String spell, String idcardNum, String prefecture, String town, String village, String tgroup,
			String medicalCardNum);
	//	public String[][] getCInfo(String csname,String nameForShort,String idcardNum,String prefecture,String town,String village,String medicalCardNum);
	public CsmedicalCard getCsmedicalCardByCsid(long csid);
	/**
	 * ���ҽ�ƿ�
	 * 
	 * @param csmedicalCard
	 * @return
	 */
	public Boolean addCsmedicalCard(CsmedicalCard csmedicalCard);
	/**
	 * �޸�ҽ�ƿ�
	 * 
	 * @param csmedicalCard
	 * @return
	 */
	public Boolean updateCsmedicalCard(CsmedicalCard csmedicalCard);
	/**
	 * ��ѯҽ�ƿ�
	 * 
	 * @param csid
	 * @return
	 */
	public CsmedicalCard getCsmedicalCardOnlyByCsid(long csid);
	/**
	 * ��ѯҽ�ƿ��굥
	 * 
	 * @param stdate eddate csid
	 * @return
	 */
	public String[][] getCsmedicalCardDetailByDateandcsid(
			String stdate, String eddate, long csid); 
	/**
	 * ���ҽ�ƿ��굥
	 * 
	 * @param csmedicalCardDetail
	 * @return
	 */
	public Boolean addCsmedicalCardDetail(CsmedicalCardDetail csmedicalCardDetail);
	/**
	 * ͨ��ҽ�ƿ���ѯ�������
	 * 
	 * @param medicalCardNum
	 * @return
	 */
	public long getCsIDByMedicalCardNum(String medicalCardNum);
	
	public Csconsumer getCInfoByIDCardNum(String idCardNum);
	
	/**
	 * �����û����� 
	 * @param  useryear,sdata
	 * @return number
	 */
	public int getCountAge(String useryear , String sdate);
	
	public List<Csconsumer> getByBirthTime(String startTime,String endTime);

	public List<Csconsumer> getByCondition(List<Long> ids, String consumerName, String idCard, String medicalCard, int flag);
	
	public boolean addGhmrCg(GhmrCg ghmrCg);
	/**
	 * ͨ��csID��õ��Ӳ���
	 * @param csID
	 * @return
	 */
	public CsefileInfo getCsefileInfoByCsID(long csID);
	/**
	 * ͨ��csID��ý��ʷ
	 * @param csID
	 * @return
	 */
	public List<CsmarriageHistory> getCsmarriageHistoryByCsID(Long csID);

	/**
	 * ��ӵ��Ӳ���
	 * @param csefileInfo
	 * @return
	 */
	public boolean addCsefileInfo(CsefileInfo csefileInfo);
	/**
	 * �޸ĵ��Ӳ���
	 * @param csefileInfo
	 * @return
	 */
	public boolean updateCsefileInfo(CsefileInfo csefileInfo);
	/**
	 * ɾ�����Ӳ���
	 * @param csefileInfo
	 * @return
	 */
	public boolean deleteCsefileInfo(CsefileInfo csefileInfo);
	/**
	 * ��ӻ�����ʷ
	 * @param csmarriageHistory
	 * @return
	 */
	public boolean addCsmarriageHistory(CsmarriageHistory csmarriageHistory);
    /**
     * ���Ļ�����ʷ
     * @param csmarriageHistory
     * @return
     */
	public boolean updateCsmarriageHistory(CsmarriageHistory csmarriageHistory);
    /**
     * ɾ��������ʷ
     * @param csmarriageHistory
     * @return
     */
	public boolean deleteCsmarriageHistory(CsmarriageHistory csmarriageHistory);
	/**
	 * ͨ��������û���ʷ
	 * @param id
	 * @return
	 */
	public CsmarriageHistory getCsmarriageHistoryByID(long id);
	/**
	 * ���� ƴ�� ���֤ ��ѯ
	 * @param csname
	 * @param spell
	 * @param IDcardnum
	 * @return
	 */
	public List<Csconsumer> getCsconsumerlistByInfo(String csname,String spell,String IDcardnum);
	public List<Csconsumer> getCsInfo(String csnameandspell, String idcardNum, String prefecture, String town, String village, String tgroup,
			String medicalCardNum);
	/**
	 * ��ȡ�������(���Ӳ���ʹ��)
	 * @param Date_B �Һſ�ʼ����
	 * @param Date_e �ҺŽ�������
	 * @param XingMing ����
	 * @param XingMingSuoXie ������д
	 * @param YiLiaoJiGou ҽ�ƻ���
	 * @param ShiFouChuYuan �Ƿ��Ժ
	 * @param LeiXing ����(����,��Ժ,��Ժ,�������)
	 * @return
	 */
	public String[][] getFuWuDuiXian(String Date_B, String Date_e, String XingMing, String XingMingSuoXie, Integer YiLiaoJiGou, Integer ShiFouChuYuan, String LeiXing);

	public List<GhmrCg> getGhmrCgfortg(long sid, String stdate,String eddate) throws Exception;

	/**
	 * ��ȡ��������(���Ӳ���ʹ��)
	 * @param Shi ��
	 * @param Xian ��
	 * @param Xiang ��
	 * @param Cun ��
	 * @param XingMing ����
	 * @param XingMingSuoXie ������д
	 * @return
	 */
	public String[][] getFuWuDuiXiangBiao(String Shi, String Xian, String Xiang, String Cun, String XingMing, String XingMingSuoXie);
	
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
	


}
