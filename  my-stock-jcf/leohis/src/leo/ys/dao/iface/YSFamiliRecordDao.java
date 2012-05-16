package leo.ys.dao.iface;

import java.util.List;

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

public interface YSFamiliRecordDao {
	
	/*
	 * �����з����֤�Ż�ȡ��ͥ������
	 */
	public String getRecordIDByMIDCardNum(String strMIDCardNum);
	
	/*
	 * ����Ů�����֤�Ż�ȡ��ͥ������
	 */
	public String getRecordIDByWIDCardNum(String strWIDCardNum);
	
	/*
	 * �����з��������ID��ȡ��ͥ������
	 */
	public String getRecordIDByMCsID(String strMCsID);
	
	
	/*
	 * ����Ů���������ID��ȡ��ͥ������
	 */
	public String getRecordIDByWCsID(String strWCsID);
	
	/*
	 * �����з���ϺŻ�ȡ��ͥ������
	 */
	public String getRecordIDByMOpDnID(String strMOpDnID);
	
	/*
	 * ����Ů����ϺŻ�ȡ��ͥ������
	 */
	public String getRecordIDByWOpDnID(String strWOpDnID); 
	
	/*
	 * ���ݵ����Ż�ȡ��ͥ����
	 */
	public FamiliRecord getFamiliRecordByRecordID(String strRecordID);
	
	/*
	 * ���ݵ����Ż�ȡ����������Ϣ
	 */
	public FamiliRecordBasicInfo getFamiliRecordBasicInfoByRecordID(String strRecordID);
	
	/*
	 * �������ڡ�ҽ�ƻ���ID��ҽ������ѯһ��ʱ���ڵĵ���������Ϣ��
	 * ���ڱ�� ҽ�ƻ���ID��ҽ���ǿ�ѡ�����ɲ��
	 */
	public List<FamiliRecordBasicInfo> getFamiliRecordBasicInfoByDate(String strBeginDate,String strEndDate,String strMedicalInstID,String strDoctor);
	
	/*
	 * �����������
	 */
	public boolean addCsconsumer(Csconsumer cscon);
	
	/*
	 * �������������չ��Ϣ
	 */
	public boolean addCsconsumerInfo(CsconsumerInfo csconinfo);
	
	/*
	 * ������ͥ����
	 */
	public boolean addFamiliRecord(FamiliRecord fr);
	
	/*
	 * ��������������Ϣ
	 */
	public boolean addFamiliRecordBasicInfo(FamiliRecordBasicInfo frbi);
	
	/*
	 * �޸ļ�ͥ����
	 */
	public boolean updateFamiliRecord(FamiliRecord fr);
	
	/*
	 * �޸ĵ���������Ϣ
	 */
	public boolean updateFamiliRecordInfo(FamiliRecordBasicInfo frbi);
	
	/*
	 * ���ݵ����Ż�ȡ֪��ͬ����
	 */
	public Agreement getAgreement(String strRecordID);
	
	/*
	 * ����֪��ͬ����
	 */
	public boolean addAgreement(Agreement agreement);
	
	/*
	 * �޸�֪��ͬ����
	 */
	public boolean updateAgreement(Agreement agreement);
	
	/*
	 * ɾ����ͥ����
	 */
	public boolean delFamiliRecord(String strRecordID);
	
	/*
	 * ɾ������������Ϣ
	 */
	public boolean delFamiliRecordBasicInfo(String strRecordID);
	
	/*
	 * ɾ��֪��ͬ����
	 */
	public boolean delAgreement(String strRecordID);
	
	/*
	 * �½�����ʱ��ȡҽ�ƻ���ʵ�����
	 */
	public OsmedicalInstInfo getOSMedicalInstInfo(String strMedicalInstID);
	
	/*
	 * �����µĵ������
	 */
	public String createFamiliRecordID();
	
	/*
	 * �жϵ�������Ƿ����
	 */
	public boolean existFamiliRecordID(String strRecordID);
	
	/*
	 * �жϻ�����Ϣ���еĵ�������Ƿ����
	 */
	public boolean existFamiliBasicInfoRecordID(String strRecordID);
	
	/*
	 * �ж�֪��ͬ���鵵������Ƿ����
	 */
	public boolean existAgreementRecordID(String strRecordID);
	
	/*
	 * �½�����ʱ���ݷ������ID��ȡ��������ʵ�����
	 */
	public Csconsumer getCSConsumerByCsID(String strCsID);
	
	/*
	 * ������ż��Ż�ȡ��ż��ʵ�����
	 */
	public Csconsumer getCSConsumerByMateID(String strMateID);
	
	/*
	 * �½�����ʱ�����֤�Ż�ȡ��������ʵ�����
	 */
	public List<Csconsumer> getCSConsumerByIDCardNum(String strIDCardNum);
	
	/*
	 * �����֤���жϷ�������Ƿ����
	 */
	public boolean existCSConsumerByIDCardNum(String strIDCardNum);
	
	
	/*
	 * �½�����ʱ���ݷ������ID��ȡ������󸽼���Ϣ��ʵ�����
	 */
	public CsconsumerInfo getCSConsumerInfo(String strCsID);	

	/*
	 * �޸ķ�������ʵ�����
	 */
	public boolean updateCSConsumer(Csconsumer cscon);
	
	/*
	 * �޸ķ��񸽼���Ϣ��ʵ�����
	 */
	public boolean updateCSConsumerInfo(CsconsumerInfo csconinfo);
	
	/*
	 * ����ʡ�����ȡʡ����
	 */
	public String GetProvinceName(String strProvince);
	
	/*
	 * �����б����ȡ������
	 */
	public String GetCityName(String strCity);
	
	/*
	 * �����ر����ȡ������
	 */
	public String GetPrefectureName(String strPrefecture);
	
	/*
	 * ����������ȡ������
	 */
	public String GetTownName(String strTown);
	
	/*
	 * ���ݴ�����ȡ������
	 */
	public String GetViliageName(String strViliage);
	
	/*
	 * ����������ȡ������
	 */
	public String GetGroupName(String strGroup);
	
	/*
	 * ���ݵ�����Ż�ȡ���������֪��
	 */
	public Notify getNotify(String strRecordID);
	
	/*
	 * �������������֪��
	 */
	public boolean addNotify(Notify ny);
	
	/*
	 * �޸����������֪��
	 */
	public boolean updateNotify(Notify ny);
	
	/*
	 * ���ݵ�������жϹ������֪���Ƿ����
	 */
	public boolean existNotify(String strRecordID);
	
	/*
	 * ���ݵ������ɾ�����������֪��
	 */
	public boolean deleteNotify(String strRecordID);
	
	/*
	 * ��������ģ��
	 */
	public boolean addEugenicsModule(EugenicsModule em);
	
	/*
	 * �޸�����ģ��
	 */
	public boolean updateEugenicsModule(EugenicsModule em);
	
	/*
	 * ����ģ�����ж�����ģ���Ƿ����
	 */
	public boolean existEugenicsModule(String strModuleID);
	
	/*
	 * ����ģ����ɾ������ģ���Ƿ����
	 */
	public boolean deleteEugenicsModule(String strModuleID);
	
	/*
	 * ����ģ���Ż�ȡ��������ģ��
	 */
	public EugenicsModule getEugenicsModule(String strModuleID);
	
	/*
	 * ���ݱ�ע��ȡ��������ģ������
	 */
	public List<EugenicsModule> getEugenicModuleByRemarks(String strRemarks);
	
	/*
	 * ���ݱ�ע�ͱ����ȡ��������ģ������
	 */
	public List<EugenicsModule> getEugenicModuleByRemarksAndTitle(String strRemarks,String strTitle);
	
	/*
	 * ����������Դ����ģ��
	 */
	public boolean addDataSourceConfig(DataSourceConfig dsc);
	
	/*
	 * �޸�������Դ����ģ��
	 */
	public boolean updateDataSourceConfig(DataSourceConfig dsc);
	
	/*
	 * ���ݱ���ж�������Դ����ģ���Ƿ����
	 */
	public boolean existDataSourceConfig(String strID);
	
	/*
	 * ����ģ���ź��ܼ���(���ӻ��ɷ�)�ж�������Դ����ģ���Ƿ����
	 */
	public boolean existDataSourceConfigByItemIDAndTypeName(String strItemTypeID,String strTypeName);
	
	/*
	 * ���ݱ��ɾ��������Դ����ģ��
	 */
	public boolean deleteDataSourceConfig(String strID);
	
	/*
	 * ����ģ���Ż�ȡ����������Դ����ģ��
	 */
	public DataSourceConfig getDataSourceConfig(String strItemTypeID);
	
	/*
	 * �������ӻ��ɷ��ȡ����������Դ����ģ������(�½�����ʱ��������¼����Դ����ȡ��Ҫ�Զ������õ���Ŀ����)
	 * ���strTypeNameΪ�գ����ȡ���е��ٴ�����ģ����Ŀ
	 */
	public List<DataSourceConfig> getDataSourceConfigByType(String strTypeName);
	
	/*
	 * ��������ı��浥��ȡ������Ŀ
	 * ���strReportΪ�գ���ֻ��ȡ�ٴ�������Ŀ��B����Ŀ
	 */
	public List<CzdisposeItemDescribe> getCZDisposeItemDescribe(String strReport);
	
	/*
	 * �����Զ���������ģ��Ŀ¼
	 */
	public boolean addNotifyItems(NotifyItems ni);
	
	/*
	 * �޸��Զ���������ģ��Ŀ¼
	 */
	public boolean updateNotifyItems(NotifyItems ni);
	
	/*
	 * �����Զ���������ģ��Ŀ¼����ж��Զ���������ģ��Ŀ¼�Ƿ����
	 */
	public boolean existNotifyItems(String strNIID);
	
	/*
	 * �����Զ���������ģ��Ŀ¼���ɾ�������Զ���������ģ��Ŀ¼�Ƿ����
	 */
	public boolean deleteNotifyItems(String strNIID);
	
	/*
	 * �����Զ���������ģ��Ŀ¼��Ż�ȡ�����Զ���������ģ��Ŀ¼
	 */
	public NotifyItems getNotifyItems(String strNIID);
	
	/*
	 * ���ݱ�ע��ȡ�����Զ�����ģ��Ŀ¼
	 */
	public List<NotifyItems> getNotifyItemsAll();
	
	/*
	 * �������������ȡ�Զ�����ģ��Ŀ¼
	 */
	public List<NotifyItems> getNotifyItemsByCondition(String strCondition);
	
	/*
	 * ��ȡ�Զ�����ģ��Ŀ¼���е����ı��(�����һ�β���ļ�¼���)
	 */
	public long GetMaxIDFromNotifyItems();
	
	/*
	 * �����Զ���������ģ���������
	 */
	public boolean addNotifyModule(NotifyModule nm);
	
	/*
	 * �޸��Զ���������ģ���������
	 */
	public boolean updateNotifyModule(NotifyModule nm);
	
	/*
	 * �����Զ���������ģ�������������ж��Զ���������ģ����������Ƿ����
	 */
	public boolean existNotifyModule(String strNMID);
	
	/*
	 * �����Զ���������ģ������������ɾ�������Զ���������ģ����������Ƿ����
	 */
	public boolean deleteNotifyModule(String strNMID);
	
	/*
	 * ���ݸ�֪��������Ŀ��IDɾ�������Զ���������ģ��
	 */
	public boolean deleteNotifyModuleByNIID(String strNIID);
	
	/*
	 * �����Զ���������ģ�����������Ż�ȡ�����Զ���������ģ���������
	 */
	public NotifyModule getNotifyModule(String strNMID);
	
	/*
	 * ���ݱ�ע��ȡ�����Զ�����ģ���������
	 */
	public List<NotifyModule> getNotifyModuleAll();
	
	/*
	 * �����Զ���������ģ�������Ŀ
	 */
	public boolean addNotifyModuleTerm(NotifyModuleTerm mnt);
	
	/*
	 * �޸��Զ���������ģ�������Ŀ
	 */
	public boolean updateNotifyModuleTerm(NotifyModuleTerm mnt);
	
	/*
	 * �����Զ���������ģ�������Ŀ����ж��Զ���������ģ�������Ŀ�Ƿ����
	 */
	public boolean existNotifyModuleTerm(String strNMTID);
	
	/*
	 * �����Զ���������ģ�������Ŀ���ɾ�������Զ���������ģ�������Ŀ�Ƿ����
	 */
	public boolean deleteNotifyModuleTerm(String strNMTID);
	
	/*
	 * �����Զ���������ģ�������Ŀ��Ż�ȡ�����Զ���������ģ�������Ŀ
	 */
	public NotifyModuleTerm getNotifyModuleTerm(String strNMTID);
	
	/*
	 * ���ݱ�ע��ȡ�����Զ�����ģ�������Ŀ
	 */
	public List<NotifyModuleTerm> getNotifyModuleTermAll();
	/*
	 * �����������ƻ�ȡ�Զ�����ģ�������Ŀ
	 */
	public List<NotifyModuleTerm> getNotifyModuleTermByConditionName(String strConditionName);
	
	/*
	 * ����ģ��ID��ȡ�Զ�����ģ�����ά��
	 */
	public String[][] getNotifyModuleReuslt(String strNIID);
	
	/*
	 * ����strTypeName(���ӻ��ɷ�)��ȡ(���ӻ��ɷ�)���м�����Ŀ��ID��
	 * ���strTypeNameΪ�գ����ȡ�������úõ����м�����ĿID��
	 */
	public int[] getItemTypeID(String strTypeName);	
	
	/*
	 * ��ȡ����������Ŀ������������ͳ�Ʊ�����Ҫ������ 
	 */
	public String[][] getServerMonthReport(String strBeginDate,String strEndDate);
	
	/*
	 * ��ȡ����������Ŀ��������ͳ�Ʊ���
	 */
	public String[][] getPregnancyResultReport(String strBeginDate,String strEndDate);
	
	/*
	 * �������֤�Ż�ȡ��վ��������д��һ���������
	 */
	public String getGeneralByCardID(String strCardID);
	
	/*
	 * �������֤��ɾ����վ��������д��һ���������
	 */
	public boolean delGeneralByCardID(String strCardID);
	
	/*
	 * ��ȡ���������ǰ�����������ͳ�Ʊ���
	 */
	public String[][] getCheckItemStatReport(String strBeginDate,String strEndDate);
	
	/*
	 * ��ȡ��������ͳ�Ʊ���
	 */
	public String[][] getTownPeopleCountReport(String strBeginDate,String strEndDate,String strPreviousCode);
	
}
