/**
 * 
 */
package leo.ys.service.impl;

import java.util.List;

import leo.cs.service.iface.CsGiveYsService;
import leo.entity.Agreement;
import leo.entity.Csconsumer;
import leo.entity.CsconsumerInfo;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.DataSourceConfig;
import leo.entity.EugenicsModule;
import leo.entity.FamiliRecord;
import leo.entity.FamiliRecordBasicInfo;
import leo.entity.Notify;
import leo.entity.NotifyItems;
import leo.entity.NotifyModule;
import leo.entity.NotifyModuleTerm;
import leo.entity.OsmedicalInstInfo;
import leo.ys.dao.iface.YSFamiliRecordDao;
import leo.ys.service.iface.YSFamiliRecordService;

/**
 * @author Administrator
 *
 */
public class YSFamiliRecordServiceImpl implements YSFamiliRecordService {

	private YSFamiliRecordDao ysFamiliRecordDao;
	private CsGiveYsService csGYService;
	
	public void setCsGYService(CsGiveYsService csGYService) {
		this.csGYService = csGYService;
	}

	public void setYsFamiliRecordDao(YSFamiliRecordDao ysFamiliRecordDao) {
		this.ysFamiliRecordDao = ysFamiliRecordDao;
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#addAgreement(leo.entity.Agreement)
	 */
	public boolean addAgreement(Agreement agreement) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.addAgreement(agreement);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#addFamiliRecord(leo.entity.FamiliRecord)
	 */
	public boolean addFamiliRecord(FamiliRecord fr) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.addFamiliRecord(fr);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#addFamiliRecordBasicInfo(leo.entity.FamiliRecordBasicInfo)
	 */
	public boolean addFamiliRecordBasicInfo(FamiliRecordBasicInfo frbi) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.addFamiliRecordBasicInfo(frbi);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#delAgreement(java.lang.String)
	 */
	public boolean delAgreement(String strRecordID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.delAgreement(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#delFamiliRecord(java.lang.String)
	 */
	public boolean delFamiliRecord(String strRecordID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.delFamiliRecord(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#delFamiliRecordBasicInfo(java.lang.String)
	 */
	public boolean delFamiliRecordBasicInfo(String strRecordID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.delFamiliRecordBasicInfo(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#getAgreement(java.lang.String)
	 */
	public Agreement getAgreement(String strRecordID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getAgreement(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#getFamiliRecordBasicInfoByRecordID(java.lang.String)
	 */
	public FamiliRecordBasicInfo getFamiliRecordBasicInfoByRecordID(
			String strRecordID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getFamiliRecordBasicInfoByRecordID(strRecordID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#getFamiliRecordByRecordID(java.lang.String)
	 */
	public FamiliRecord getFamiliRecordByRecordID(String strRecordID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getFamiliRecordByRecordID(strRecordID);
	}

	/*
	 * �������ڡ�ҽ�ƻ���ID��ҽ������ѯһ��ʱ���ڵĵ���������Ϣ��
	 * ���ڱ�� ҽ�ƻ���ID��ҽ���ǿ�ѡ�����ɲ��
	 */
	public List<FamiliRecordBasicInfo> getFamiliRecordBasicInfoByDate(String strBeginDate,String strEndDate,String strMedicalInstID,String strDoctor)
	{
		return ysFamiliRecordDao.getFamiliRecordBasicInfoByDate(strBeginDate, strEndDate, strMedicalInstID, strDoctor);
	}
	
	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#getRecordIDByMCsID(java.lang.String)
	 */
	public String getRecordIDByMCsID(String strMCsID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getRecordIDByMCsID(strMCsID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#getRecordIDByMIDCardNum(java.lang.String)
	 */
	public String getRecordIDByMIDCardNum(String strMIDCardNum) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getRecordIDByMIDCardNum(strMIDCardNum);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#getRecordIDByMOpDnID(java.lang.String)
	 */
	public String getRecordIDByMOpDnID(String strMOpDnID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getRecordIDByMOpDnID(strMOpDnID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#getRecordIDByWCsID(java.lang.String)
	 */
	public String getRecordIDByWCsID(String strWCsID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getRecordIDByWCsID(strWCsID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#getRecordIDByWIDCardNum(java.lang.String)
	 */
	public String getRecordIDByWIDCardNum(String strWIDCardNum) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getRecordIDByWIDCardNum(strWIDCardNum);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#getRecordIDByWOpDnID(java.lang.String)
	 */
	public String getRecordIDByWOpDnID(String strWOpDnID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getRecordIDByWOpDnID(strWOpDnID);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#updateAgreement(leo.entity.Agreement)
	 */
	public boolean updateAgreement(Agreement agreement) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.updateAgreement(agreement);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#updateFamiliRecord(leo.entity.FamiliRecord)
	 */
	public boolean updateFamiliRecord(FamiliRecord fr) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.updateFamiliRecord(fr);
	}

	/* (non-Javadoc)
	 * @see leo.ys.service.iface.YSFamiliRecordService#updateFamiliRecordInfo(leo.entity.FamiliRecordBasicInfo)
	 */
	public boolean updateFamiliRecordInfo(FamiliRecordBasicInfo frbi) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.updateFamiliRecordInfo(frbi);
	}

	public String createFamiliRecordID() {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.createFamiliRecordID();
	}

	public boolean existFamiliRecordID(String strRecordID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.existFamiliRecordID(strRecordID);
	}

	/*
	 * �жϻ�����Ϣ���еĵ�������Ƿ����
	 */
	public boolean existFamiliBasicInfoRecordID(String strRecordID)
	{
		return ysFamiliRecordDao.existFamiliBasicInfoRecordID(strRecordID);
	}
	
	public OsmedicalInstInfo getOSMedicalInstInfo(String strMedicalInstID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getOSMedicalInstInfo(strMedicalInstID);
	}

	public Csconsumer getCSConsumerByCsID(String strCsID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getCSConsumerByCsID(strCsID);
	}
	
	/*
	 * ������ż��Ż�ȡ��ż��ʵ�����
	 */
	public Csconsumer getCSConsumerByMateID(String strMateID)
	{
		return ysFamiliRecordDao.getCSConsumerByMateID(strMateID);
	}

	public List<Csconsumer> getCSConsumerByIDCardNum(String strIDCardNum) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getCSConsumerByIDCardNum(strIDCardNum);
	}

	public CsconsumerInfo getCSConsumerInfo(String strCsID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getCSConsumerInfo(strCsID);
	}
	
	/*
	 * �����֤���жϷ�������Ƿ����
	 */
	public boolean existCSConsumerByIDCardNum(String strIDCardNum)
	{
		return ysFamiliRecordDao.existCSConsumerByIDCardNum(strIDCardNum);
	}

	/*
	 * �޸ķ�������ʵ�����
	 */
	public boolean updateCSConsumer(Csconsumer cscon)
	{
		return ysFamiliRecordDao.updateCSConsumer(cscon);
	}
	
	/*
	 * �޸ķ��񸽼���Ϣ��ʵ�����
	 */
	public boolean updateCSConsumerInfo(CsconsumerInfo csconinfo)
	{
		return ysFamiliRecordDao.updateCSConsumerInfo(csconinfo);
	}
	
	public String GetCityName(String strCity) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.GetCityName(strCity);
	}

	public String GetPrefectureName(String strPrefecture) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.GetPrefectureName(strPrefecture);
	}

	public String GetProvinceName(String strProvince) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.GetProvinceName(strProvince);
	}

	public String GetTownName(String strTown) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.GetTownName(strTown);
	}

	public String GetViliageName(String strViliage) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.GetViliageName(strViliage);
	}

	/*
	 * ����������ȡ������
	 */
	public String GetGroupName(String strGroup)
	{
		return ysFamiliRecordDao.GetGroupName(strGroup);
	}
	
	public boolean existAgreementRecordID(String strRecordID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.existAgreementRecordID(strRecordID);
	}

	public boolean addNotify(Notify ny) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.addNotify(ny);
	}

	public boolean deleteNotify(String strRecordID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.deleteNotify(strRecordID);
	}

	public boolean existNotify(String strRecordID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.existNotify(strRecordID);
	}

	public Notify getNotify(String strRecordID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getNotify(strRecordID);
	}

	public boolean updateNotify(Notify ny) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.updateNotify(ny);
	}

	public boolean addEugenicsModule(EugenicsModule em) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.addEugenicsModule(em);
	}

	public boolean deleteEugenicsModule(String strModuleID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.deleteEugenicsModule(strModuleID);
	}

	public boolean existEugenicsModule(String strModuleID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.existEugenicsModule(strModuleID);
	}

	public List<EugenicsModule> getEugenicModuleByRemarks(String strRemarks) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getEugenicModuleByRemarks(strRemarks);
	}

	public EugenicsModule getEugenicsModule(String strModuleID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getEugenicsModule(strModuleID);
	}

	public boolean updateEugenicsModule(EugenicsModule em) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.updateEugenicsModule(em);
	}

	public List<EugenicsModule> getEugenicModuleByRemarksAndTitle(
			String strRemarks, String strTitle) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getEugenicModuleByRemarksAndTitle(strRemarks, strTitle);
	}

	public boolean addDataSourceConfig(DataSourceConfig dsc) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.addDataSourceConfig(dsc);
	}

	public boolean deleteDataSourceConfig(String strID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.deleteDataSourceConfig(strID);
	}

	public boolean existDataSourceConfig(String strID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.existDataSourceConfig(strID);
	}

	/*
	 * ����ģ���ź��ܼ���(���ӻ��ɷ�)�ж�������Դ����ģ���Ƿ����
	 */
	public boolean existDataSourceConfigByItemIDAndTypeName(String strItemTypeID,String strTypeName)
	{
		return ysFamiliRecordDao.existDataSourceConfigByItemIDAndTypeName(strItemTypeID, strTypeName);
	}	
	
	public DataSourceConfig getDataSourceConfig(String strItemTypeID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getDataSourceConfig(strItemTypeID);
	}

	public List<DataSourceConfig> getDataSourceConfigByType(String strTypeName) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getDataSourceConfigByType(strTypeName);
	}

	public boolean updateDataSourceConfig(DataSourceConfig dsc) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.updateDataSourceConfig(dsc);
	}

	public List<CzdisposeItemDescribe> getCZDisposeItemDescribe(String strReport) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getCZDisposeItemDescribe(strReport);
	}

	public boolean addNotifyItems(NotifyItems ni) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.addNotifyItems(ni);
	}

	public boolean addNotifyModule(NotifyModule nm) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.addNotifyModule(nm);
	}

	public boolean addNotifyModuleTerm(NotifyModuleTerm mnt) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.addNotifyModuleTerm(mnt);
	}

	public boolean deleteNotifyItems(String strNIID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.deleteNotifyItems(strNIID);
	}

	public boolean deleteNotifyModule(String strNMID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.deleteNotifyModule(strNMID);
	}

	/*
	 * ���ݸ�֪��������Ŀ��IDɾ�������Զ���������ģ��
	 */
	public boolean deleteNotifyModuleByNIID(String strNIID)
	{
		return ysFamiliRecordDao.deleteNotifyModuleByNIID(strNIID);
	}
	
	public boolean deleteNotifyModuleTerm(String strNMTID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.deleteNotifyModuleTerm(strNMTID);
	}

	public boolean existNotifyItems(String strNIID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.existNotifyItems(strNIID);
	}

	public boolean existNotifyModule(String strNMID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.existNotifyModule(strNMID);
	}

	public boolean existNotifyModuleTerm(String strNMTID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.existNotifyModuleTerm(strNMTID);
	}

	public NotifyItems getNotifyItems(String strNIID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getNotifyItems(strNIID);
	}

	/*
	 * �������������ȡ�Զ�����ģ��Ŀ¼
	 */
	public List<NotifyItems> getNotifyItemsByCondition(String strCondition)
	{
		return ysFamiliRecordDao.getNotifyItemsByCondition(strCondition);
	}
	
	public List<NotifyItems> getNotifyItemsAll() {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getNotifyItemsAll();
	}

	/*
	 * ��ȡ�Զ�����ģ��Ŀ¼���е����ı��(�����һ�β���ļ�¼���)
	 */
	public long GetMaxIDFromNotifyItems()
	{
		return ysFamiliRecordDao.GetMaxIDFromNotifyItems();
	}
	
	public NotifyModule getNotifyModule(String strNMID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getNotifyModule(strNMID);
	}

	public List<NotifyModule> getNotifyModuleAll() {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getNotifyModuleAll();
	}

	public NotifyModuleTerm getNotifyModuleTerm(String strNMTID) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getNotifyModuleTerm(strNMTID);
	}

	public List<NotifyModuleTerm> getNotifyModuleTermAll() {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.getNotifyModuleTermAll();
	}

	/*
	 * �����������ƻ�ȡ�Զ�����ģ�������Ŀ
	 */
	public List<NotifyModuleTerm> getNotifyModuleTermByConditionName(String strConditionName)
	{
		return ysFamiliRecordDao.getNotifyModuleTermByConditionName(strConditionName);
	}
	
	public boolean updateNotifyItems(NotifyItems ni) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.updateNotifyItems(ni);
	}

	public boolean updateNotifyModule(NotifyModule nm) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.updateNotifyModule(nm);
	}

	public boolean updateNotifyModuleTerm(NotifyModuleTerm mnt) {
		// TODO Auto-generated method stub
		return ysFamiliRecordDao.updateNotifyModuleTerm(mnt);
	}

	/*
	 * ����ģ��ID��ȡ�Զ�����ģ�����ά��
	 */
	public String[][] getNotifyModuleReuslt(String strNIID)
	{
		return ysFamiliRecordDao.getNotifyModuleReuslt(strNIID);
	}
	
	/*
	 * ����strTypeName(���ӻ��ɷ�)��ȡ(���ӻ��ɷ�)���м�����Ŀ��ID��
	 * ���strTypeNameΪ�գ����ȡ�������úõ����м�����ĿID��
	 */
	public int[] getItemTypeID(String strTypeName)
	{
		return ysFamiliRecordDao.getItemTypeID(strTypeName);
	}
	
	/*
	 * ��ȡ����������Ŀ������������ͳ�Ʊ�����Ҫ������ 
	 */
	public String[][] getServerMonthReport(String strBeginDate,String strEndDate)
	{
		return ysFamiliRecordDao.getServerMonthReport(strBeginDate, strEndDate);
	}
	
	/*
	 * ��ȡ����������Ŀ��������ͳ�Ʊ���
	 */
	public String[][] getPregnancyResultReport(String strBeginDate,String strEndDate)
	{
		return ysFamiliRecordDao.getPregnancyResultReport(strBeginDate, strEndDate);
	}
	
	/*
	 * �������֤�Ż�ȡ��վ��������д��һ���������
	 */
	public String getGeneralByCardID(String strCardID)
	{
		return ysFamiliRecordDao.getGeneralByCardID(strCardID);
	}
	
	/*
	 * �������֤��ɾ����վ��������д��һ���������
	 */
	public boolean delGeneralByCardID(String strCardID)
	{
		return ysFamiliRecordDao.delGeneralByCardID(strCardID);
	}
	/**
	 * �½��������
	 */
	public boolean addCsconsumerInfo(Csconsumer csconsumer,
			CsconsumerInfo csconsumerinfo) {
		return csGYService.addCsconsumerInfo(csconsumer, csconsumerinfo);
	}
	
	/*
	 * ��ȡ���������ǰ�����������ͳ�Ʊ���
	 */
	public String[][] getCheckItemStatReport(String strBeginDate,String strEndDate)
	{
		return ysFamiliRecordDao.getCheckItemStatReport(strBeginDate, strEndDate);
	}
	
	/*
	 * ��ȡ��������ͳ�Ʊ���
	 */
	public String[][] getTownPeopleCountReport(String strBeginDate,String strEndDate,String strPreviousCode)
	{
		return ysFamiliRecordDao.getTownPeopleCountReport(strBeginDate, strEndDate, strPreviousCode);
	}
	
}
