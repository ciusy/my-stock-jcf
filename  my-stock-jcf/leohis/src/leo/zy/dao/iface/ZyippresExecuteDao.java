package leo.zy.dao.iface;

import leo.common.dao.Dao;
import leo.entity.ZyippresExecute;

public interface ZyippresExecuteDao extends Dao<ZyippresExecute>{
	/**
	 *  加入住院处方执行
	 * @param zyippresExecute
	 * @return
	 */
	public boolean addZyippresExecute(ZyippresExecute zyippresExecute);
	/**
	 * 返回最大处方执行 ID
	 * @return
	 */
	public String getMaxID();
}
