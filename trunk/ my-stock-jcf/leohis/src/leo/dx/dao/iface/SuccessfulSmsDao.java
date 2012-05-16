package leo.dx.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SuccessfulSms;

public interface SuccessfulSmsDao extends Dao<SuccessfulSms>{
	/**
	 * ��ȡ���ͳɹ����ż�¼
	 * @param ShiJian_B ���Ϳ�ʼʱ��
	 * @param ShiJian_E ���ͽ���ʱ��
	 * @param Status ״̬
	 * @param MoKuai ģ��
	 * @param UnitID ��λ
	 * @return
	 */
	public String[][] getSuccessfulSms(String ShiJian_B, String ShiJian_E, String Status, String MoKuai, Integer UnitID);
	/**
	 * ���뷢�Ͷ��ż�¼
	 * @param JiLuNeiRong ��¼����
	 * @return
	 */
	public boolean addSuccessfulSms(SuccessfulSms JiLuNeiRong);
	/**
	 * ����ģ���š�����ID����λID�޸ķ���ʱ�䡢����״̬���������
	 * @param ModuleNum ģ����
	 * @param SendID ����ID
	 * @param UnitID ��λID
	 * @param SendTime ����ʱ��
	 * @param Status ����״̬
	 * @param ErrorCode �������
	 * @return
	 */
	public boolean updateSuccessfulSms(String ModuleNum, Long SendID, Integer UnitID, String SendTime, String Status, String ErrorCode);
}
