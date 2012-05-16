package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.ZynurseGrade;

public interface ZynurseGradeDao extends Dao<ZynurseGrade>{
	/**
	 * ��ȡ������
	 * @param JiBieID ������ID
	 * @param JiBieMingCheng ����������
	 * @return
	 */
	public List<ZynurseGrade> getZynurseGrade(Integer JiBieID, String JiBieMingCheng);

}
