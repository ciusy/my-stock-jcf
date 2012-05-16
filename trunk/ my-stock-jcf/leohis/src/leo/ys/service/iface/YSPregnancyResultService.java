package leo.ys.service.iface;

import java.util.List;

import leo.entity.FamiliRecordBasicInfo;
import leo.entity.PregnancyResult;

public interface YSPregnancyResultService {
	/**
	 * 提取妊娠结局记录表的ID和医生
	 * @param RecordID
	 * @return
	 */
	public String[][] getIDandYS(String RecordID);
	/**
	 * 提取家庭档案基础信息
	 * @param RecordID 档案号
	 * @return
	 */
	public List<FamiliRecordBasicInfo> getDangAnJiChuInfo(String RecordID);
	/**
	 * 保存妊娠结局记录表
	 * @param pregnancyResult 妊娠结局记录内容
	 * @return
	 */
	public boolean addRenChengJieJu(PregnancyResult pregnancyResult);
	/**
	 * 修改妊娠结局记录表
	 * @param pregnancyResult妊娠结局记录表
	 * @return
	 */
	public boolean updateRenChengJieJu(PregnancyResult pregnancyResult);
	/**
	 * 提取妊娠结局记录表
	 * @param RecordID 档案号
	 * @param ID ID号
	 * @return
	 */
	public List<PregnancyResult> getRenChengJieJu(String RecordID, Integer ID);
}
