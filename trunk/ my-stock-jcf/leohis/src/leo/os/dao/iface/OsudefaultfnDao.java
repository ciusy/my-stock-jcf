package leo.os.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.OsfnBlocks;
import leo.entity.OsudefaultFn;

/**
 * ����Ĭ�Ϲ��ܽӿ�
 * @author Administrator
 *
 */
public interface OsudefaultfnDao extends Dao<OsudefaultFn>{
	/**
	 * ���ݿ���ID��ѯ���Ҷ�Ӧ�Ĺ���
	 * @param uid
	 * @return
	 */
	public List<OsfnBlocks> getFnBlocksByUID(Integer uid);
	/**
	 * �������Ĭ�Ϲ���
	 * @param osudefaultFn
	 * @return
	 */
	public boolean addOSUDefaultFn(OsudefaultFn osudefaultFn);
	/**
	 * ��ȡ���Ҷ�Ӧ�Ĺ���
	 * @param uid
	 * @return
	 */
	public String[][] getOSUDefaultFn(Integer uid);
	/**
	 * ɾ�����Ҷ�Ӧ�Ĺ���
	 * @param uid ����ID
	 * @param FcBlocksID ����ID
	 * @return
	 */
	public boolean delOSUDefaultFn(Integer uid, Integer FcBlocksID);
	
	
}
