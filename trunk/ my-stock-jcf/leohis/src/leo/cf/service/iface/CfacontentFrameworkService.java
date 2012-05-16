package leo.cf.service.iface;

import java.util.List;

import leo.entity.CfacontentFramework;

public interface CfacontentFrameworkService {
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
	 * �����޸����ݷ���
	 * @param formworkId ����ģ��
	 * @param medicalRecords ����ժҪ
	 * @param clinicalPhenomenon �ٴ�����
	 * @param isobjectiveRequest ���Ŀ�ļ�Ҫ��
	 * @param elseState ����˵��
	 * @return
	 */
	public Boolean updateCfacontentFrameworkById(Integer formworkId,
			String medicalRecords, String clinicalPhenomenon,
			String isobjectiveRequest, String elseState);

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
	 * 
	 * @param Affiliation
	 * @return
	 */
	public List<CfacontentFramework> getCfacontentFrameworkByAffiliation(
			Integer affiliation,Integer ItemTypeID);
}
