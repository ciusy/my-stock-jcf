package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Zydischarge;

public interface ZydischargeDao extends Dao<Zydischarge>{
	/**
	 * �����Ժ֪ͨ
	 * @param zydischarge ֪ͨ����
	 * @return
	 */
	public boolean addZydischarge(Zydischarge zydischarge);
	/**
	 * ��ȡ��Ժ֪ͨ
	 * @param IPID סԺ��
	 * @return
	 */
	public List<Zydischarge> getZydischarge(String IPID);
	/**
	 * ɾ����Ժ֪ͨ
	 * @param IPID סԺ��
	 * @return
	 */
	public boolean delZydischarge(String IPID);
	/**
	 * �޸ĳ�Ժ֪ͨ
	 * @param zydischarge ֪ͨ����
	 * @return
	 */
	public boolean updatezydischarge(Zydischarge zydischarge);
}
