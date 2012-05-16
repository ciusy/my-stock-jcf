package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.HealthyPregnantSms;

public interface YSHealthyPregnantSmsDao extends Dao<HealthyPregnantSms>{
	/**
	 * ����״̬�͵�λ��ȡ��������(����ģ�����)
	 * @param SendState ״̬
	 * @param UnitID ��λID
	 * @return
	 */
	public List<HealthyPregnantSms> getHealthyPregnantSms(String SendState, Integer UnitID);
	/**
	 * ���ݷ���ID�޸ķ���ʱ���״̬(����ģ�����)
	 * @param SendID ����ID
	 * @param SendTime ����ʱ��
	 * @param SendState ״̬
	 * @return
	 */
	public boolean updateHealthyPregnantSms(Long SendID, String SendTime, String SendState);
	/**
	 * ��������Ҫ���͵Ķ�������
	 * @param healthyPregnantSms ��������
	 * @return
	 */
	public boolean addHealthyPregnantSms(HealthyPregnantSms healthyPregnantSms);

}
