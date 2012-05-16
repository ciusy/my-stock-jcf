package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SmsModule;

public interface YSSmsModuleDao extends Dao<SmsModule>{
	/**
	 * ���Ӷ���ģ��ͷ
	 * @param smsModule ģ��ͷ����
	 * @return
	 */
	public Long addSmsModule(SmsModule smsModule);
	/**
	 * ����ģ�����ͺ�������λID����ģ��ͷ
	 * @param PointName ģ������
	 * @param AffiliationID ������λID
	 * @return
	 */
	public List<SmsModule> getSmsModule(String PointName, Long AffiliationID);
	/**
	 * �޸�ģ��ͷ
	 * @param smsModule ģ��ͷ����
	 * @return
	 */
	public boolean updateSmsModule(SmsModule smsModule);
	/**
	 * ɾ��ģ��ͷ
	 * @param ModuleID ģ��ID
	 * @return
	 */
	public boolean delSmsModule(Long ModuleID);
	/**
	 * ���ݵ�λID��ȡģ������
	 * @param AffiliationID ��λID
	 * @return 0:ģ������  1:ģ��ID
	 */
	public String[][] getMoBanMingCheng(Long AffiliationID); 
}
