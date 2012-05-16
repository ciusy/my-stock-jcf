package leo.mz.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.CzdisposalType;

public interface CzdisposalTypeDao extends Dao<CzdisposalType>{
	/**
	 * ���洦�����
	 * @param czdisposalType �������
	 * @return
	 */
	public boolean addCzdisposalType(CzdisposalType czdisposalType);
	/**
	 * ɾ���������
	 * @param disposeItemType �������
	 * @return
	 */
	public boolean delCzdisposalType(String disposeItemType);
	/**
	 * ��ȡ���
	 * @return
	 */
	public List<CzdisposalType> getCzdisposalType();

}
