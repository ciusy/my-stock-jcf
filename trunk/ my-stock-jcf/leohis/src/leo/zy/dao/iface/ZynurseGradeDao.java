package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.ZynurseGrade;

public interface ZynurseGradeDao extends Dao<ZynurseGrade>{
	/**
	 * 提取护理级别
	 * @param JiBieID 护理级别ID
	 * @param JiBieMingCheng 护理级别名称
	 * @return
	 */
	public List<ZynurseGrade> getZynurseGrade(Integer JiBieID, String JiBieMingCheng);

}
