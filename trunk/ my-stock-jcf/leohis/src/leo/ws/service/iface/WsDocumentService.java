package leo.ws.service.iface;

import java.util.List;

import leo.entity.CzdisposeItemDescribe;
import leo.entity.WsdocWframework;
import leo.entity.Wsdocument;
import leo.entity.WsstorageLocation;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 11, 2011 3:22:00 PM
 */
public interface WsDocumentService {
	/**
	 * 添加文书
	 * 
	 * @param wsdocument
	 * @return
	 */
	public Long addWsDocument(Wsdocument wsdocument);

	/**
	 * 得到所有文书
	 * 
	 * @return
	 */
	public List<Wsdocument> getAllWsdocument();

	/**
	 * 根据id得到文书
	 * 
	 * @param docId
	 * @return
	 */
	public Wsdocument getWsDocumentById(Long docId);

	/**
	 * 修改文书
	 * 
	 * @param wsdocument
	 */
	public void updateWsdocument(Wsdocument wsdocument);

	/**
	 * 删除文书
	 * 
	 * @param id
	 */
	public void deleteById(Long id);

	/**
	 * 得到所有文书顺序模版
	 * 
	 * @return
	 */
	public List<List<String>> getAllTemplate();

	/**
	 * 得到对应的文书顺序模版下的文书，按照顺序号排序
	 * 
	 * @param templateId
	 * @return
	 */
	public List<List<String>> getWsDocOfTemplate(Long templateId);

	/**
	 * 得到对应的文书顺序模版下的文书，按照顺序号排序
	 * 
	 * @param templateId
	 * @return
	 */

	public List<List<String>> getWsDocOfTemplateByItemTypeId(Long itemTypeId);

	/**
	 * 查找所有的处置项目类型
	 * 
	 * @return
	 */
	public List<CzdisposeItemDescribe> getAllCzdisposeItemDescribe();

	/**
	 * 新建文书顺序模版
	 * 
	 * @param templateName
	 * @param itemTypeId
	 * @param note
	 * @param docIDs
	 */
	public void addWsDocOfTemplate(String templateName, String itemTypeId,
			String note, Long[] docIDs);

	/**
	 * 修改文书顺序模版
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
	 * 根据id删除文书顺序模版
	 * 
	 * @param frameworkID
	 */
	public void deleteByFrameworkID(Long frameworkID);

	/**
	 * 根据文书顺序模版ID查找对应所有的文书信息
	 * 
	 * @param templateId
	 * @return
	 */
	public List<List<String>> getWsorderItemByTemplateId(Long templateId);

	/**
	 * 根据文书的名称和控件的名称，查找文书下的对应的默认值
	 * 
	 * @param wsDocName
	 * @return
	 */
	public List<WsdocWframework> getWsdocWframeworkByWsDocName(
			String wsDocName, String componentName);

	/**
	 * 根据文书的id和控件的名称，查找文书下的对应的控件的默认值
	 * 
	 * @param wsDocId
	 * @param componentName
	 * @return
	 */
	public List<WsdocWframework> getWsdocWframeworkByWsDocId(Long wsDocId,
			String componentName);

	/**
	 * 添加文书填写模板的记录
	 * 
	 * @param wsDocName
	 * @param componentName
	 * @param componentValue
	 */
	public void addWsdocWframework(String wsDocName, String componentName,
			String componentValue);

	/**
	 * 修改文书填写模板的记录
	 * 
	 * @param id
	 * @param componentValue
	 */
	public void updateWsdocWframework(Long id, String componentValue);

	/**
	 * 删除文书填写模板的记录
	 * 
	 * @param id
	 * @param componentValue
	 */
	public void deleteWsdocWframework(Long id);

	/**
	 * 得到所有的文书存储位置记录
	 * 
	 * @param medicalInstID
	 * @return
	 */
	public List<WsstorageLocation> getAllWsstorageLocations(
			Integer medicalInstID);

	/**
	 * 添加文书存储位置记录
	 * 
	 * @param wsstorageLocation
	 * @return
	 */
	public Long addWsstorageLocation(WsstorageLocation wsstorageLocation);

	/**
	 * 修改文书存储位置记录
	 * 
	 * @param id
	 * @param value
	 * @param medicalOrgId
	 */
	public Integer updateWsstorageLocation(Long id, String value,
			Integer medicalOrgId);

	/**
	 * 删除文书存储位置记录
	 * 
	 * @param id
	 */
	public void deleteWsstorageLocation(Long id);

}
