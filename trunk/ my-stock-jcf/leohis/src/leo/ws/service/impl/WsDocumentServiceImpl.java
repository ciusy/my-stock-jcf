package leo.ws.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import leo.bc.sercive.iface.CzGiveWsService;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.WsdocWframework;
import leo.entity.WsdocWorderFramework;
import leo.entity.Wsdocument;
import leo.entity.WsorderItem;
import leo.entity.WsstorageLocation;
import leo.ws.dao.WsDocWFrameworkDao;
import leo.ws.dao.WsDocWOrderFrameworkDao;
import leo.ws.dao.WsDocumentDao;
import leo.ws.dao.WsorderItemDao;
import leo.ws.dao.WsstorageLocationDao;
import leo.ws.service.iface.WsDocumentService;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 11, 2011 3:22:36 PM
 */
public class WsDocumentServiceImpl implements WsDocumentService {
	private WsDocumentDao wsDocumentDao;
	private WsDocWOrderFrameworkDao wsDocWOrderFrameworkDao;

	private CzGiveWsService czGiveWsService;
	private WsorderItemDao wsorderItemDao;

	public Long addWsDocument(Wsdocument wsdocument) {
		wsDocumentDao.save(wsdocument);
		return wsdocument.getDocId();
	}

	public List<Wsdocument> getAllWsdocument() {
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("docName", "asc");
		return wsDocumentDao.getScrollData(orderby);
	}

	public void updateWsdocument(Wsdocument wsdocument) {
		wsDocumentDao.update(wsdocument);
	}

	public void deleteById(Long id) {
		wsDocumentDao.delete(id);
	}

	@SuppressWarnings("unchecked")
	public List<List<String>> getAllTemplate() {
		List<WsdocWorderFramework> list1 = wsDocWOrderFrameworkDao
				.getScrollData();
		if (null == list1 || list1.size() < 1) {
			return Collections.EMPTY_LIST;
		}
		List<Integer> ids = new ArrayList<Integer>();
		for (WsdocWorderFramework wsdocWorderFramework : list1) {
			ids.add(wsdocWorderFramework.getItemTypeId());
		}
		List<CzdisposeItemDescribe> list2 = czGiveWsService.getByIDs(ids);
		List<List<String>> returnList = new ArrayList<List<String>>();
		List<String> innerList = null;
		String itemName = null;
		for (WsdocWorderFramework wsdocWorderFramework : list1) {
			itemName = "";
			innerList = new ArrayList<String>();
			// 模板名称
			innerList.add(wsdocWorderFramework.getFrameworkName());
			for (CzdisposeItemDescribe czdisposeItemDescribe : list2) {
				if (czdisposeItemDescribe.getItemTypeId().intValue() == wsdocWorderFramework
						.getItemTypeId().intValue()) {
					// 项目类型名称
					itemName = czdisposeItemDescribe.getItemName();
					break;
				}
			}

			innerList.add(itemName);
			// 备注
			innerList.add(wsdocWorderFramework.getNote());
			innerList.add(wsdocWorderFramework.getFrameworkId().toString());
			innerList.add(wsdocWorderFramework.getExecuteU().toString());
			returnList.add(innerList);
		}
		return returnList.size() > 0 ? returnList : Collections.EMPTY_LIST;
	}

	public List<List<String>> getWsDocOfTemplate(Long templateId) {
		return wsDocWOrderFrameworkDao.getWsDocOfTemplate(templateId);
	}

	public List<List<String>> getWsDocOfTemplateByItemTypeId(Long itemTypeId) {
		return wsDocWOrderFrameworkDao
				.getWsDocOfTemplateByItemTypeId(itemTypeId);
	}

	public List<CzdisposeItemDescribe> getAllCzdisposeItemDescribe() {
		return czGiveWsService.getAllCzdisposeItemDescribe();
	}

	public void addWsDocOfTemplate(String templateName, String itemTypeId,
			String note, Long[] docIDs) {
		CzdisposeItemDescribe czdisposeItemDescribe = null;
		if (null != itemTypeId && !"".equals(itemTypeId))
			czdisposeItemDescribe = czGiveWsService
					.getCzdisposeItemDescribeById(Integer.parseInt(itemTypeId));

		WsdocWorderFramework framework = new WsdocWorderFramework();
		framework
				.setExecuteU(czdisposeItemDescribe != null ? czdisposeItemDescribe
						.getExecuteU() : -1);
		framework.setFrameworkName(templateName);
		framework
				.setItemTypeId(czdisposeItemDescribe != null ? czdisposeItemDescribe
						.getItemTypeId() : -1);
		framework.setNote(note);

		wsDocWOrderFrameworkDao.save(framework);
		WsorderItem wsorderItem = null;

		for (int i = 0; i < docIDs.length; i++) {
			Long docId = docIDs[i];
			wsorderItem = new WsorderItem();
			wsorderItem.setDocId(docId);
			wsorderItem.setFrameworkId(framework.getFrameworkId());
			wsorderItem.setStep(i + 1);
			wsorderItemDao.save(wsorderItem);
		}

	}

	public List<List<String>> getWsorderItemByTemplateId(Long templateId) {
		return wsorderItemDao.getWsorderItemByTemplateId(templateId);
	}

	public void updateWsDocOfTemplate(Long templateId, String templateName,
			String itemTypeId, String note, Long[] docIDs) {

		WsdocWorderFramework framework = wsDocWOrderFrameworkDao
				.find(templateId);

		CzdisposeItemDescribe czdisposeItemDescribe = null;
		if (null != itemTypeId && !"".equals(itemTypeId))
			czdisposeItemDescribe = czGiveWsService
					.getCzdisposeItemDescribeById(Integer.parseInt(itemTypeId));

		framework
				.setExecuteU(czdisposeItemDescribe != null ? czdisposeItemDescribe
						.getExecuteU() : -1);
		framework.setFrameworkName(templateName);
		framework
				.setItemTypeId(czdisposeItemDescribe != null ? czdisposeItemDescribe
						.getItemTypeId() : -1);
		framework.setNote(note);
		wsDocWOrderFrameworkDao.update(framework);

		// 删除所有再新添加
		wsorderItemDao.deleteByTemplateID(templateId);

		WsorderItem wsorderItem = null;

		for (int i = 0; i < docIDs.length; i++) {
			Long docId = docIDs[i];
			wsorderItem = new WsorderItem();
			wsorderItem.setDocId(docId);
			wsorderItem.setFrameworkId(framework.getFrameworkId());
			wsorderItem.setStep(i + 1);
			wsorderItemDao.save(wsorderItem);
		}

	}

	public void deleteByFrameworkID(Long frameworkID) {

		wsorderItemDao.deleteByTemplateID(frameworkID);
		wsDocWOrderFrameworkDao.delete(frameworkID);

	}

	private WsDocWFrameworkDao wsDocWFrameworkDao;

	public List<WsdocWframework> getWsdocWframeworkByWsDocName(
			String wsDocName, String componentName) {
		return wsDocWFrameworkDao.getWsdocWframeworkByWsDocName(wsDocName,
				componentName);
	}

	public void setWsDocWFrameworkDao(WsDocWFrameworkDao wsDocWFrameworkDao) {
		this.wsDocWFrameworkDao = wsDocWFrameworkDao;
	}

	public void setWsDocWOrderFrameworkDao(
			WsDocWOrderFrameworkDao wsDocWOrderFrameworkDao) {
		this.wsDocWOrderFrameworkDao = wsDocWOrderFrameworkDao;
	}

	public void setWsDocumentDao(WsDocumentDao wsDocumentDao) {
		this.wsDocumentDao = wsDocumentDao;
	}

	public void setCzGiveWsService(CzGiveWsService czGiveWsService) {
		this.czGiveWsService = czGiveWsService;
	}

	public void setWsorderItemDao(WsorderItemDao wsorderItemDao) {
		this.wsorderItemDao = wsorderItemDao;
	}

	public void addWsdocWframework(String wsDocName, String componentName,
			String componentValue) {

		Wsdocument wsdocument = wsDocumentDao.getByWsDocName(wsDocName);
		WsdocWframework wsdocWframework = new WsdocWframework();
		wsdocWframework.setDocId(wsdocument == null ? -1 : wsdocument
				.getDocId());
		wsdocWframework.setWitem(componentName);
		wsdocWframework.setWscontent(componentValue);
		wsDocWFrameworkDao.save(wsdocWframework);

	}

	public void deleteWsdocWframework(Long id) {

		wsDocWFrameworkDao.delete(id);
	}

	public void updateWsdocWframework(Long id, String componentValue) {
		WsdocWframework wsdocWframework = wsDocWFrameworkDao.find(id);
		wsdocWframework.setWscontent(componentValue);
	}

	private WsstorageLocationDao wsstorageLocationDao;

	public Long addWsstorageLocation(WsstorageLocation wsstorageLocation) {

		if (wsstorageLocationDao.getByCondition(
				wsstorageLocation.getLocationName(),
				wsstorageLocation.getMedicalInstId()) != null)
			return 0l;

		wsstorageLocationDao.save(wsstorageLocation);
		return wsstorageLocation.getSlid();
	}

	public void deleteWsstorageLocation(Long id) {

		wsstorageLocationDao.delete(id);
	}

	public List<WsstorageLocation> getAllWsstorageLocations(
			Integer medicalInstID) {
		return wsstorageLocationDao.getScrollData("o.medicalInstId=?",
				new Object[] { medicalInstID });
	}

	public Integer updateWsstorageLocation(Long id, String value,
			Integer medicalOrgId) {

		if (wsstorageLocationDao
				.getByConditionExceptId(id, value, medicalOrgId) != null)
			return 0;

		WsstorageLocation temp = wsstorageLocationDao.find(id);
		temp.setLocationName(value);
		return 1;

	}

	public void setWsstorageLocationDao(
			WsstorageLocationDao wsstorageLocationDao) {
		this.wsstorageLocationDao = wsstorageLocationDao;
	}

	public Wsdocument getWsDocumentById(Long docId) {

		return wsDocumentDao.find(docId);
	}

	public List<WsdocWframework> getWsdocWframeworkByWsDocId(Long wsDocId,
			String componentName) {
		return wsDocWFrameworkDao.getWsdocWframeworkByWsDocId(wsDocId,
				componentName);
	}
}
