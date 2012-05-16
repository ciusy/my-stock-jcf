package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Zydischarge;

public interface ZydischargeDao extends Dao<Zydischarge>{
	/**
	 * 保存出院通知
	 * @param zydischarge 通知内容
	 * @return
	 */
	public boolean addZydischarge(Zydischarge zydischarge);
	/**
	 * 提取出院通知
	 * @param IPID 住院号
	 * @return
	 */
	public List<Zydischarge> getZydischarge(String IPID);
	/**
	 * 删除出院通知
	 * @param IPID 住院号
	 * @return
	 */
	public boolean delZydischarge(String IPID);
	/**
	 * 修改出院通知
	 * @param zydischarge 通知内容
	 * @return
	 */
	public boolean updatezydischarge(Zydischarge zydischarge);
}
