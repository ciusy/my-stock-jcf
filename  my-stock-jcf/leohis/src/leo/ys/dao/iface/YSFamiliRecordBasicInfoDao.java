package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.FamiliRecordBasicInfo;

public interface YSFamiliRecordBasicInfoDao extends Dao<FamiliRecordBasicInfo>{
	/**
	 * 根据前后天数提取要发短信的人员
	 * @param TianShu 前后天数
	 * @return
	 */
	public String[][] getDuanXinRenYuan(Integer TianShu);
	/**
	 * 提取家庭档案基础信息
	 * @param RecordID 档案号
	 * @return
	 */
	public List<FamiliRecordBasicInfo> getFamiliRecordBasicInfo(String RecordID);
}
