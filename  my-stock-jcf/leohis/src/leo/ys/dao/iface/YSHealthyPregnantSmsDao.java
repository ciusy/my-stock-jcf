package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.HealthyPregnantSms;

public interface YSHealthyPregnantSmsDao extends Dao<HealthyPregnantSms>{
	/**
	 * 根据状态和单位提取短信内容(短信模块调用)
	 * @param SendState 状态
	 * @param UnitID 单位ID
	 * @return
	 */
	public List<HealthyPregnantSms> getHealthyPregnantSms(String SendState, Integer UnitID);
	/**
	 * 根据发送ID修改发送时间和状态(短信模块调用)
	 * @param SendID 发送ID
	 * @param SendTime 发送时间
	 * @param SendState 状态
	 * @return
	 */
	public boolean updateHealthyPregnantSms(Long SendID, String SendTime, String SendState);
	/**
	 * 保存优生要发送的短信内容
	 * @param healthyPregnantSms 短信内容
	 * @return
	 */
	public boolean addHealthyPregnantSms(HealthyPregnantSms healthyPregnantSms);

}
