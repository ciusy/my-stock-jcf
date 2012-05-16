package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.ZydoctorAdvice;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 18, 2011 3:12:58 PM
 */
public interface ZydoctorAdviceDao extends Dao<ZydoctorAdvice> {

	List<ZydoctorAdvice> getZydoctorAdviceByIds(List<String> daIds);
	/**
	 * ����ҽ��
	 * @param zydoctorAdvice
	 * @return
	 */
	public boolean addZYDoctorAdvice(ZydoctorAdvice zydoctorAdvice);
	/**
	 * �������ҽ�� ID
	 * @return
	 */
	public String getMaxID();
	/**
	 * ��ȡҽ������
	 * @param IPID סԺ��
	 * @param DAState ҽ��״̬ 
	 * @param IPDeptID סԺ��ID
	 * @param RiQi_B ����ʱ��(��ʼ)
	 * @param RiQi_E ����ʱ��(����)
	 * @param ZhuangTaiTiaoJian ״̬���� (= <> ...)
	 * @return
	 */
	public String[][] getZydoctorAdvice(String IPID, String DAState, Integer IPDeptID, String RiQi_B, String RiQi_E, String ZhuangTaiTiaoJian);
	/**
	 * ��ȡҽ������
	 * @param IPID סԺ��
	 * @param DAState ҽ��״̬
	 * @param IPDeptID סԺ��ID
	 * @param State ����״̬
	 * @param RiQi_B ��ʼ����
	 * @param RiQi_E ��������
	 * @return
	 */
	public String[][] getZydoctorAdvice_CZ(String IPID, String DAState, Integer IPDeptID, String State, String RiQi_B, String RiQi_E);
	/**
	 * �޸�ҽ��-���Ի�ʿ���
	 * @param DAID ҽ��ID
	 * @param ApproveNurse ������ʿ
	 * @param ApproveTime ����ʱ��
	 * @param DAState ҽ��״̬
	 * @param AFormID ҩƷ���뵥ID
	 * @return
	 */
	public boolean updateZydoctorAdviceShenHe(String DAID, Long ApproveNurse, String ApproveTime, String DAState, String AFormID);
	/**
	 * �޸�ҽ��״̬
	 * @param DAID ҽ��ID
	 * @param DAState ״̬
	 * @return
	 */
	public boolean updateZydoctorAdviceZhuangTai(String DAID, String DAState);
	/**
	 * �õ�סԺ��Ա�����嵥
	 * @param ZhuYuanHao סԺ��
	 * @param ZhuanTai_CZ ����״̬
	 * @param ZhuangTai_CFFayao ������ҩ״̬
	 * @param ZhuangTai_CFTuiYao ������ҩ״̬
	 * @param ZhiXingShiJian_B ִ�п�ʼʱ��
	 * @param ZhiXingShiJian_E ִ�н���ʱ��
	 * @return
	 */
	public String[][] getFeiYongQingDan(String ZhuYuanHao, String ZhuanTai_CZ, String ZhuangTai_CFFaYao, String ZhuangTai_CFTuiYao, String ZhiXingShiJian_B, String ZhiXingShiJian_E);
	/**
	 * ɾ��ҽ��
	 * @param DAID ҽ��ID
	 * @return
	 */
	public boolean delZYDoctorAdvice(String DAID);
	/**
	 * ����ҽ��ID��ȡҽ������
	 * @param DAID ҽ��ID
	 * @return
	 */
	public List<ZydoctorAdvice> getZydoctorAdvice(String DAID);
}
