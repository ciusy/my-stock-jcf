package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SmsModuleTerm;

public interface YSSmsModuleTermDao extends Dao<SmsModuleTerm>{
	/**
	 * ���Ӷ���ģ����
	 * @param smsModuleTerm ����ģ��������
	 * @return
	 */
	public Long addSmsModuleTerm(SmsModuleTerm smsModuleTerm);
	/**
	 * ���ݶ���ģ��ID��ȡ����ģ����
	 * @param ModuleID ����ģ��ID
	 * @return
	 */
	public List<SmsModuleTerm> getsmsModuleTerm(Long ModuleID);
	/**
	 * �޸Ķ���ģ����
	 * @param smsModuleTerm ����ģ��������
	 * @return
	 */
	public boolean updateSmsModuleTerm(SmsModuleTerm smsModuleTerm);
	/**
	 * ����ģ����ID��ģ��IDɾ��ģ����
	 * @param STTID ģ����id
	 * @param ModuleID ģ��id
	 * @return
	 */
	public boolean delSmsModuleTerm(Long STTID, Long ModuleID);
	/**
	 * ��ȡģ��������
	 * @param ModuleID ģ��ID
	 * @return 0:ģ����ID  1:ǰ������  2:ģ������
	 */
	public String[][] getXiangNeiRong(Long ModuleID);
	/**
	 * ��ȡ����ģ��������
	 * @return
	 */
	public String[][] getAllXiangNeiRong();
}
