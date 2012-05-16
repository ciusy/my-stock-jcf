package leo.dx.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SuccessfulSms;

public interface SuccessfulSmsDao extends Dao<SuccessfulSms>{
	/**
	 * 提取发送成功短信记录
	 * @param ShiJian_B 发送开始时间
	 * @param ShiJian_E 发送结束时间
	 * @param Status 状态
	 * @param MoKuai 模块
	 * @param UnitID 单位
	 * @return
	 */
	public String[][] getSuccessfulSms(String ShiJian_B, String ShiJian_E, String Status, String MoKuai, Integer UnitID);
	/**
	 * 加入发送短信记录
	 * @param JiLuNeiRong 记录内容
	 * @return
	 */
	public boolean addSuccessfulSms(SuccessfulSms JiLuNeiRong);
	/**
	 * 根据模块编号、发送ID、单位ID修改发送时间、发送状态、错误代码
	 * @param ModuleNum 模块编号
	 * @param SendID 发送ID
	 * @param UnitID 单位ID
	 * @param SendTime 发送时间
	 * @param Status 发送状态
	 * @param ErrorCode 错误代码
	 * @return
	 */
	public boolean updateSuccessfulSms(String ModuleNum, Long SendID, Integer UnitID, String SendTime, String Status, String ErrorCode);
}
