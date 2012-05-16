package leo.os.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.OsfnBlocks;

public interface OsfnBlocksDao extends Dao<OsfnBlocks>{
	/**
	 * ���湦�ܿ��
	 * @param osfnBlocks ����
	 * @return
	 */
	public boolean addOsfnBlocks(OsfnBlocks osfnBlocks);
	/**
	 * �޸Ĺ��ܿ��
	 * @param osfnBlocks ����
	 * @return
	 */
	public boolean updateOsfnBlocks(OsfnBlocks osfnBlocks);
	/**
	 * ���ݹ��ܿ����Ƶõ�����ģ��ID
	 * @param FnBlocksName
	 * @return
	 */
	public Integer getOsfnBlocksID(String FnBlocksName);
	/**
	 * ��ȡ������ģ��
	 * @return
	 */
	public List<OsfnBlocks> getOsfnBlocks();
	/**
	 * ��ȡ��ģ��
	 * @param FatherFnBlocksID ������ģ��ID
	 * @return
	 */
	public List<OsfnBlocks> getZiMoKuai(Integer FatherFnBlocksID);
	/**
	 * ��ȡ��Ӧ���ܵ�������
	 * @param FnBlocksID
	 * @return
	 */
	public List<OsfnBlocks> GetGongNengLei(Integer FnBlocksID);
}
