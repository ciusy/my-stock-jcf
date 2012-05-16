package leo.cs.dao.iface;

import leo.entity.CsconsumerInfo;

/**
 * ������󸽼���ϢDao�ӿ�
 * @author abc
 *
 */
public interface CSConsumerInfoDao {
	/**
	 * ���ݷ������id��ѯ������󸽼���Ϣ
	 * @param csId
	 * @return
	 */
	public CsconsumerInfo getCsconsumerInfoBycsId(Long csId);
	/**
	 * ��ӷ�����󸽼���Ϣ
	 * @param csconsumerinfo
	 * @return
	 */
	public boolean addCsconsumerInfo(CsconsumerInfo csconsumerinfo);
	/**
	 * �޸ķ�����󸽼���Ϣ
	 * @param csconsumerinfo
	 * @return
	 */
	public boolean updateCsconsumerInfo(CsconsumerInfo csconsumerinfo);
	/**
	 * ɾ��������󸽼���Ϣ
	 * @param csId
	 * @return
	 */
	public boolean delCsconsumerInfo(Long csId);
}
