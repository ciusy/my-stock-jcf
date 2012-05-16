package leo.zy.dao.iface;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.Dao;
import leo.entity.YfminbankA;
import leo.entity.Zyinpatient;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 4, 2011 4:22:48 PM
 */
public interface ZyInpatientDao extends Dao<Zyinpatient> {

	/**
	 * �õ����죬״̬�ǡ�����Ժ�������з������
	 * 
	 * @param inPatientDeptIds
	 * @param inPatientStatus
	 * 
	 * @return
	 */
	public List<Zyinpatient> getCurrentDayInPatient(List<Integer> inPatientDeptIds, String inPatientStatus);

	/**
	 * 
	 * @param inPatientDeptIds
	 * @param consumerIds
	 * @param ipId
	 * @param startTime
	 * @param endTime
	 * @param inPatientStatus
	 * @param bedNo
	 * @return
	 */
	public List<Zyinpatient> getInpatient(List<Integer> inPatientDeptIds, List<Long> consumerIds, String ipId, String startTime,
			String endTime, String inPatientStatus, String bedNo);

	/**
	 * ��ʿ��ҳ��ѯ��Ժ��Ա
	 * 
	 * @param zyh
	 *            סԺ��
	 * @param cwh
	 *            ��λ��
	 * @param xm
	 *            ����
	 * @param xmsx
	 *            ������д
	 * @param zybID
	 *            סԺ��ID
	 * @param zrhs
	 *            ���λ�ʿ
	 * @return
	 */
	public String[][] getHuShiShouYeZhuYuanRenYuan(String zyh, Integer cwh, String xm, String xmsx, Integer zybID, Long zrhs);

	/**
	 * �������סԺID
	 * 
	 * @return
	 */
	public String getMaxID();

	/**
	 * ����סԺ��
	 * 
	 * @param zyinpatient
	 * @return
	 */
	public boolean addZYInpatient(Zyinpatient zyinpatient);

	/**
	 * ����סԺ��
	 * 
	 * @param ZhuYuanHao
	 *            סԺID
	 * @param ChuangWeiHao
	 *            ��λ��
	 * @param XingMing
	 *            ����
	 * @param XingMingSuoXie
	 *            ������д
	 * @param ShengQingShiJian_B
	 *            ������Ժ��ʼʱ��
	 * @param ShengQingShiJian_E
	 *            ������Ժ����ʱ��
	 * @param RuYuanShiJian_B
	 *            ��Ժ��ʼʱ��
	 * @param RuYuanShiJian_E
	 *            ��Ժ����ʱ��
	 * @param ShengQingZhuangTai
	 *            ����״̬
	 * @param YueE1
	 *            ������
	 * @param GuanXi
	 *            �����ҹ�ϵ��> < >= <=
	 * @param ShiFouChuYuan
	 *            �Ƿ��Ժ
	 * @param ChuYuanShiJian_B
	 *            ��Ժ��ʼʱ��
	 * @param ChuYuanShiJian_E
	 *            ��Ժ����ʱ��
	 * @param FeiYongLeiXingID
	 *            ��������
	 * @param ZhuYuanBuId
	 *            סԺ��ID
	 * @param ShengFeiZheng
	 *            ���֤��
	 * @param FuWuDuiXiangID
	 *            �������ID
	 * @return
	 */
	public String[][] getZYInpatient(String ZhuYuanHao, Integer ChuangWeiHao, String XingMing, String XingMingSuoXie,
			String ShengQingShiJian_B, String ShengQingShiJian_E, String RuYuanShiJian_B, String RuYuanShiJian_E,
			String ShengQingZhuangTai, String YueE1, String GuanXi, Integer ShiFouChuYuan, String ChuYuanShiJian_B,
			String ChuYuanShiJian_E, Integer FeiYongLeiXingID, Integer ZhuYuanBuId, String ShengFeiZheng, Long FuWuDuiXiangID);

	/**
	 * �޸�סԺ��
	 * 
	 * @param zyinpatient
	 *            סԺ������
	 * @return
	 */
	public boolean updateZYInpatient(Zyinpatient zyinpatient);

	/**
	 * �޸���Ա��λ
	 * 
	 * @param ZhuYuanHao
	 *            סԺ��
	 * @param ChuangWeihao
	 *            ��λ��
	 * @return
	 */
	public boolean updateDangQianChuangWei(String ZhuYuanHao, Integer ChuangWeihao);

	/**
	 * ����סԺ�ŵ���סԺ��
	 * 
	 * @param ZhuYuanHao
	 *            סԺ��
	 * @return
	 */
	public List<Zyinpatient> getZyinpatientall(String ZhuYuanHao);
	/**
	 * �޸�Ѻ�����
	 * @param IPID סԺ��
	 * @param FeiYong ����(+�����,-�����)
	 * @return
	 */
	public boolean updateDepositBalance(String IPID, Double FeiYong);

	/**
	 * add by xu
	 * 
	 * @param inpatientId
	 * @param b
	 * @param string
	 */
	public Zyinpatient updateZyStauts(String inpatientId, boolean b, String string);
   /**
    * ͨ��csid ����Ժʱ���ѯ
    * add by zhang
    * @param csId
    * @param st
    * @param ed
    * @return
    * @throws Exception
    */
	public List<Zyinpatient> getZyinpatientByCsIDandDate(long csId,String st,String ed) throws Exception;
	/**
	 * ͨ��ID��ѯסԺ
	 */
	public Zyinpatient getZyinpatientByIPID(String ipid);
	/**
	 * �޸�����״̬
	 * @param IPID סԺ��
	 * @param AStatus ����״̬
	 * @return
	 */
	public boolean updateShengQingZhuangTai(String IPID, String AStatus);
	/**
	 * ��Ա��Ժ
	 * @param IPID סԺ��
	 * @param LeaveTime ��Ժʱ��
	 * @param AStatus ����״̬
	 * @return
	 */
	public boolean updateBanLiChuYuan(String IPID, String LeaveTime, String AStatus);
	/**
	 * ��ȡ�������(���Ӳ���ʹ��)
	 * @param Date_B �Һſ�ʼ����
	 * @param Date_e �ҺŽ�������
	 * @param XingMing ����
	 * @param XingMingSuoXie ������д
	 * @param ShiFouChuYuan �Ƿ��Ժ
	 * @param YiLiaoJiGou ҽ�ƻ���
	 * @return
	 */
	public String[][] getGhregisterDZ(String Date_B, String Date_e, String XingMing, String XingMingSuoXie, Integer ShiFouChuYuan, Integer YiLiaoJiGou);
	/**
	 * ��(���)Ѻ�����
	 * @param IPID סԺ��
	 * @param JinE ���
	 * @return
	 */
	public boolean updateBengKeShiYaJin(String IPID, Double JinE);
}
