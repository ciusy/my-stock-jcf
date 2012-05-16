package leo.cf.dao.iface;

import java.util.List;

import leo.entity.CfacontentFramework;

public interface CfacontentFrameworkDao {
	/**
	 * 
	 * ����ID��ѯ��һ������
	 * 
	 * @param id����
	 *            
	 * @return CfacontentFramework����
	 */
	
	public CfacontentFramework getCfacontentFrameworkByID(Integer id);
	
	/**
	 * 
	 * �޸�һ������
	 * 
	 * @param id����
	 *            
	 * @return �ɹ���true��ʧ��(false)
	 */
	public Boolean updateCfacontentFrameworkById(CfacontentFramework c);
	
	/**
	 * 
	 * ɾ��һ������
	 * 
	 * @param id����
	 *            
	 * @return �ɹ���true��ʧ��(false)
	 */
	
	public Boolean deleteCfacontentFramework(Integer id);
	
	/**
	 * 
	 * ����һ������
	 * 
	 * @param 
	 *            
	 * @return �ɹ���true��ʧ��(false)
	 */
	public Boolean addCfacontentFramework(CfacontentFramework c);
	/**
	 * ����������λ����Ŀ����Id��ѯ����ģ�壨��λIDΪҽ�ƻ���ID��
	 * @param Affiliation
	 * @return
	 */
	public List<CfacontentFramework> getCfacontentFrameworkByAffiliation(Integer affiliation);
	/**
	 * ���ظ���������λ����Ŀ����Id��ѯ����ģ�壨��λIDΪҽ�ƻ���ID��
	 * @param Affiliation
	 * @return
	 */
	public List<CfacontentFramework> getCfacontentFrameworkByAffiliation(Integer affiliation,Integer itemTypeID);
}
