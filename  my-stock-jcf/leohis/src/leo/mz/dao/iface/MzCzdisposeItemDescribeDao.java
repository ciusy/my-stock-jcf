package leo.mz.dao.iface;


import java.util.List;

import leo.entity.CzdisposeItemDescribe;


public interface MzCzdisposeItemDescribeDao {
	
	/**
	 * 
	 * ����ID��ѯ������Ŀ����
	 * 
	 * @param ID
	 *            
	 * @return CzdisposeDivaricateU
	 */
	public List<CzdisposeItemDescribe> getCzdById(Long id);
	
	/**
	 * 
	 * ���CzdisposeItemDescribe
	 * 
	 * @param CzdisposeItemDescribe ����
	 *            
	 * @return
	 */
	public void addCzdisposeItemDescribe(CzdisposeItemDescribe c);
	
	/**
	 * 
	 * ɾ��CzdisposeItemDescribe
	 * 
	 * @param ID
	 *            
	 * @return
	 */
	public void deleCzdisposeItemDescribe(Integer id);
	
	/**
	 * 
	 * ����CzdisposeItemDescribe
	 * 
	 * @param CzdisposeItemDescribe ����
	 *            
	 * @return
	 */
	public void updateCzdisposeItemDescribe(CzdisposeItemDescribe c);
	
	/**
	 * ����������ѯ��һ��������Ŀ����
	 * @param id
	 * @return
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(Integer id);
	
	/**
	 * 
	 * ����ɾ��
	 * 
	 * @param ����ID
	 *            
	 * @return
	 */
	public void deleCzdisposeItemDescribebyItemTypeId(Integer id);
	
	/**
	 * 
	 * ͨ�����Ʋ�ѯ
	 * 
	 * @param name ����
	 *            
	 * @return CzdisposeItemDescribe����
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemName(String name);
	public List<CzdisposeItemDescribe> getCzdisposeItemDescribeBySepll(String Sepll,int Mid);
	/**
	 * �������ƻ�ƴ����д��ȡ������Ŀ
	 * @param ItemName ����
	 * @param Spell ƴ����д
	 * @return
	 */
	public List<CzdisposeItemDescribe> getCZDisposeItemDescribe(String ItemName, String Spell);
	/**
	 * ������Ŀ����ID������Ŀ����
	 * @param ItemTypeID ��Ŀ����ID
	 * @return
	 */
	public String getCZDisposeItemDescribeName(Integer ItemTypeID);
	/**
	 * �������ơ�ƴ���������ȡ��Ŀ
	 * @param ItemName ����
	 * @param Spell ƴ��
	 * @param DisposeItemType ���
	 * @param MedicalInstID ҽ�ƻ���
	 * @return
	 */
	public List<CzdisposeItemDescribe> getCZDisposeItemDescribeByNameAndType(String ItemName, String Spell, String DisposeItemType, Integer MedicalInstID);
	/**
	 * ����ҽ�ƻ�������Ŀ�����ж��Ƿ����
	 * @param ItemName ��Ŀ����
	 * @param MedicalInstID ҽ�ƻ���
	 * @return
	 */
	public Integer getCZDisposeItemDescribeCunZi(String ItemName, Integer MedicalInstID);
	/**
	 * ��ȡ���豨�浥
	 * @param ItemTypeID ����ID
	 * @param MedicalInstID ҽ�ƻ���ID
	 * @return
	 */
	public String getReport(Integer ItemTypeID, Integer MedicalInstID);
	/**
	 * ���ݴ�������ID��ȡִ�п���
	 * @param ItemTypeID ��������ID
	 * @return
	 */
	public Integer getZhiXingKeShi(Integer ItemTypeID);
}

