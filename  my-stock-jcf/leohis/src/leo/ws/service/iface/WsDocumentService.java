package leo.ws.service.iface;

import java.util.List;

import leo.entity.CzdisposeItemDescribe;
import leo.entity.WsdocWframework;
import leo.entity.Wsdocument;
import leo.entity.WsstorageLocation;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 11, 2011 3:22:00 PM
 */
public interface WsDocumentService {
	/**
	 * �������
	 * 
	 * @param wsdocument
	 * @return
	 */
	public Long addWsDocument(Wsdocument wsdocument);

	/**
	 * �õ���������
	 * 
	 * @return
	 */
	public List<Wsdocument> getAllWsdocument();

	/**
	 * ����id�õ�����
	 * 
	 * @param docId
	 * @return
	 */
	public Wsdocument getWsDocumentById(Long docId);

	/**
	 * �޸�����
	 * 
	 * @param wsdocument
	 */
	public void updateWsdocument(Wsdocument wsdocument);

	/**
	 * ɾ������
	 * 
	 * @param id
	 */
	public void deleteById(Long id);

	/**
	 * �õ���������˳��ģ��
	 * 
	 * @return
	 */
	public List<List<String>> getAllTemplate();

	/**
	 * �õ���Ӧ������˳��ģ���µ����飬����˳�������
	 * 
	 * @param templateId
	 * @return
	 */
	public List<List<String>> getWsDocOfTemplate(Long templateId);

	/**
	 * �õ���Ӧ������˳��ģ���µ����飬����˳�������
	 * 
	 * @param templateId
	 * @return
	 */

	public List<List<String>> getWsDocOfTemplateByItemTypeId(Long itemTypeId);

	/**
	 * �������еĴ�����Ŀ����
	 * 
	 * @return
	 */
	public List<CzdisposeItemDescribe> getAllCzdisposeItemDescribe();

	/**
	 * �½�����˳��ģ��
	 * 
	 * @param templateName
	 * @param itemTypeId
	 * @param note
	 * @param docIDs
	 */
	public void addWsDocOfTemplate(String templateName, String itemTypeId,
			String note, Long[] docIDs);

	/**
	 * �޸�����˳��ģ��
	 * 
	 * @param templateId
	 * @param templateName
	 * @param itemTypeId
	 * @param note
	 * @param docIDs
	 */
	public void updateWsDocOfTemplate(Long templateId, String templateName,
			String itemTypeId, String note, Long[] docIDs);

	/**
	 * ����idɾ������˳��ģ��
	 * 
	 * @param frameworkID
	 */
	public void deleteByFrameworkID(Long frameworkID);

	/**
	 * ��������˳��ģ��ID���Ҷ�Ӧ���е�������Ϣ
	 * 
	 * @param templateId
	 * @return
	 */
	public List<List<String>> getWsorderItemByTemplateId(Long templateId);

	/**
	 * ������������ƺͿؼ������ƣ����������µĶ�Ӧ��Ĭ��ֵ
	 * 
	 * @param wsDocName
	 * @return
	 */
	public List<WsdocWframework> getWsdocWframeworkByWsDocName(
			String wsDocName, String componentName);

	/**
	 * ���������id�Ϳؼ������ƣ����������µĶ�Ӧ�Ŀؼ���Ĭ��ֵ
	 * 
	 * @param wsDocId
	 * @param componentName
	 * @return
	 */
	public List<WsdocWframework> getWsdocWframeworkByWsDocId(Long wsDocId,
			String componentName);

	/**
	 * ���������дģ��ļ�¼
	 * 
	 * @param wsDocName
	 * @param componentName
	 * @param componentValue
	 */
	public void addWsdocWframework(String wsDocName, String componentName,
			String componentValue);

	/**
	 * �޸�������дģ��ļ�¼
	 * 
	 * @param id
	 * @param componentValue
	 */
	public void updateWsdocWframework(Long id, String componentValue);

	/**
	 * ɾ��������дģ��ļ�¼
	 * 
	 * @param id
	 * @param componentValue
	 */
	public void deleteWsdocWframework(Long id);

	/**
	 * �õ����е�����洢λ�ü�¼
	 * 
	 * @param medicalInstID
	 * @return
	 */
	public List<WsstorageLocation> getAllWsstorageLocations(
			Integer medicalInstID);

	/**
	 * �������洢λ�ü�¼
	 * 
	 * @param wsstorageLocation
	 * @return
	 */
	public Long addWsstorageLocation(WsstorageLocation wsstorageLocation);

	/**
	 * �޸�����洢λ�ü�¼
	 * 
	 * @param id
	 * @param value
	 * @param medicalOrgId
	 */
	public Integer updateWsstorageLocation(Long id, String value,
			Integer medicalOrgId);

	/**
	 * ɾ������洢λ�ü�¼
	 * 
	 * @param id
	 */
	public void deleteWsstorageLocation(Long id);

}
