package leo.mz.dao.iface;

import java.util.List;

import leo.entity.CzdisposeDivaricateU;

public interface MzCzdisposeDivaricateUDao {
	/**
	 * 
	 * ������ĿID��ѯ�������Ҷ���
	 * 
	 * @param ID
	 *            
	 * @return CzdisposeDivaricateU
	 */
	public CzdisposeDivaricateU getCzdById(Long id);
	
	/**
	 * 
	 * ���
	 * 
	 * @param CzdisposeDivaricateU ����
	 *            
	 * @return 
	 */
	public void addCzdisposeDivaricateU(CzdisposeDivaricateU c);
	
	/**
	 * 
	 * ɾ��
	 * 
	 * @param ID
	 *            
	 * @return 
	 */
	public void deleCzdisposeDivaricateU(Long id);
	
	/**
	 * 
	 * ����CzdisposeDivaricateU
	 * 
	 * @param CzdisposeDivaricateU ����
	 *            
	 * @return 
	 */
	
	public void updateCzdisposeDivaricateU(CzdisposeDivaricateU c);
	
	/**
	 * 
	 * ����ItemTypeID��ѯ
	 * 
	 * @param ItemTypeID
	 *            
	 * @return updateCzdisposeDivaricateU����
	 */
	public List<CzdisposeDivaricateU> getCzdisposeDivaricateUList(Integer id);
	
	/**
	 * 
	 * ����IDɾ��updateCzdisposeDivaricateU����
	 * 
	 * @param itemTypeId
	 *            
	 * @return 
	 */
	public void deleCzdisposeDivaricateUByitemTypeId(Integer id);
}
