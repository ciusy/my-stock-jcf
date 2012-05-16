package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.PregnancyResult;

public interface YSPregnancyResultDao extends Dao<PregnancyResult>{
	/**
	 * 提取需要出生发送的短信人员
	 * @param TianShu 前后天数
	 * @return
	 */
	public String[][] getChuShengDuanXinRenYuan(Integer TianShu);
	/**
	 * 提取妊娠结局记录表的ID和医生
	 * @param RecordID
	 * @return
	 */
	public String[][] getIDandYS(String RecordID);
	/**
	 * 保存妊娠结局记录表
	 * @param pregnancyResult 妊娠结局记录内容
	 * @return
	 */
	public boolean addPregnancyResult(PregnancyResult pregnancyResult);
	/**
	 * 修改妊娠结局记录表
	 * @param pregnancyResult妊娠结局记录表
	 * @return
	 */
	public boolean updatePregnancyResult(PregnancyResult pregnancyResult);
	/**
	 * 提取妊娠结局记录表
	 * @param RecordID 档案号
	 * @param ID ID号
	 * @return
	 */
	public List<PregnancyResult> getPregnancyResult(String RecordID, Integer ID);

}
