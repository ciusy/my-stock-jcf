package leo.zy.dao.iface;

import leo.common.dao.Dao;
import leo.entity.ZyippresExecute;

public interface ZyippresExecuteDao extends Dao<ZyippresExecute>{
	/**
	 *  ����סԺ����ִ��
	 * @param zyippresExecute
	 * @return
	 */
	public boolean addZyippresExecute(ZyippresExecute zyippresExecute);
	/**
	 * ������󴦷�ִ�� ID
	 * @return
	 */
	public String getMaxID();
}
