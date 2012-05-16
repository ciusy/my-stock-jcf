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
	 * 根据男方身份证号获取家庭档案号
	 */
	public String getRecordIDByMIDCardNum(String strMIDCardNum);
	
	/*
	 * 根据女方身份证号获取家庭档案号
	 */
	public String getRecordIDByWIDCardNum(String strWIDCardNum);
	
	/*
	 * 根据男方服务对象ID获取家庭档案号
	 */
	public String getRecordIDByMCsID(String strMCsID);
	
	
	/*
	 * 根据女方服务对象ID获取家庭档案号
	 */
	public String getRecordIDByWCsID(String strWCsID);
	
	/*
	 * 根据男方诊断号获取家庭档案号
	 */
	public String getRecordIDByMOpDnID(String strMOpDnID);
	
	/*
	 * 根据女方诊断号获取家庭档案号
	 */
	public String getRecordIDByWOpDnID(String strWOpDnID); 
	
	/*
	 * 根据档案号获取家庭档案
	 */
	public FamiliRecord getFamiliRecordByRecordID(String strRecordID);
	
	/*
	 * 根据档案号获取档案基础信息
	 */
	public FamiliRecordBasicInfo getFamiliRecordBasicInfoByRecordID(String strRecordID);
	
	/*
	 * 根据日期、医疗机构ID、医生，查询一段时间内的档案基础信息。
	 * 日期必填、 医疗机构ID和医生是可选项即可填可不填。
	 */
	public List<FamiliRecordBasicInfo> getFamiliRecordBasicInfoByDate(String strBeginDate,String strEndDate,String strMedicalInstID,String strDoctor);
	
	/*
	 * 新增服务对象
	 */
	public boolean addCsconsumer(Csconsumer cscon);
	
	/*
	 * 新增服务对象扩展信息
	 */
	public boolean addCsconsumerInfo(CsconsumerInfo csconinfo);
	
	/*
	 * 新增家庭档案
	 */
	public boolean addFamiliRecord(FamiliRecord fr);
	
	/*
	 * 新增档案基础信息
	 */
	public boolean addFamiliRecordBasicInfo(FamiliRecordBasicInfo frbi);
	
	/*
	 * 修改家庭档案
	 */
	public boolean updateFamiliRecord(FamiliRecord fr);
	
	/*
	 * 修改档案基础信息
	 */
	public boolean updateFamiliRecordInfo(FamiliRecordBasicInfo frbi);
	
	/*
	 * 根据档案号获取知情同意书
	 */
	public Agreement getAgreement(String strRecordID);
	
	/*
	 * 新增知情同意书
	 */
	public boolean addAgreement(Agreement agreement);
	
	/*
	 * 修改知情同意书
	 */
	public boolean updateAgreement(Agreement agreement);
	
	/*
	 * 删除家庭档案
	 */
	public boolean delFamiliRecord(String strRecordID);
	
	/*
	 * 删除档案基础信息
	 */
	public boolean delFamiliRecordBasicInfo(String strRecordID);
	
	/*
	 * 删除知情同意书
	 */
	public boolean delAgreement(String strRecordID);
	
	/*
	 * 新建档案时获取医疗机构实体对象
	 */
	public OsmedicalInstInfo getOSMedicalInstInfo(String strMedicalInstID);
	
	/*
	 * 创建新的档案编号
	 */
	public String createFamiliRecordID();
	
	/*
	 * 判断档案编号是否存在
	 */
	public boolean existFamiliRecordID(String strRecordID);
	
	/*
	 * 判断基础信息表中的档案编号是否存在
	 */
	public boolean existFamiliBasicInfoRecordID(String strRecordID);
	
	/*
	 * 判断知情同意书档案编号是否存在
	 */
	public boolean existAgreementRecordID(String strRecordID);
	
	/*
	 * 新建档案时根据服务对象ID获取服务对象的实体对象
	 */
	public Csconsumer getCSConsumerByCsID(String strCsID);
	
	/*
	 * 根据配偶编号获取配偶的实体对象
	 */
	public Csconsumer getCSConsumerByMateID(String strMateID);
	
	/*
	 * 新建档案时根身份证号获取服务对象的实体对象
	 */
	public List<Csconsumer> getCSConsumerByIDCardNum(String strIDCardNum);
	
	/*
	 * 根身份证号判断服务对象是否存在
	 */
	public boolean existCSConsumerByIDCardNum(String strIDCardNum);
	
	
	/*
	 * 新建档案时根据服务对象ID获取服务对象附加信息的实体对象
	 */
	public CsconsumerInfo getCSConsumerInfo(String strCsID);	

	/*
	 * 修改服务对象的实体对象
	 */
	public boolean updateCSConsumer(Csconsumer cscon);
	
	/*
	 * 修改服务附加信息的实体对象
	 */
	public boolean updateCSConsumerInfo(CsconsumerInfo csconinfo);
	
	/*
	 * 根据省编码获取省名称
	 */
	public String GetProvinceName(String strProvince);
	
	/*
	 * 根据市编码获取市名称
	 */
	public String GetCityName(String strCity);
	
	/*
	 * 根据县编码获取县名称
	 */
	public String GetPrefectureName(String strPrefecture);
	
	/*
	 * 根据乡编码获取乡名称
	 */
	public String GetTownName(String strTown);
	
	/*
	 * 根据村编码获取村名称
	 */
	public String GetViliageName(String strViliage);
	
	/*
	 * 根据组编码获取村名称
	 */
	public String GetGroupName(String strGroup);
	
	/*
	 * 根据档案编号获取评估建议告知书
	 */
	public Notify getNotify(String strRecordID);
	
	/*
	 * 新增评估建议告知书
	 */
	public boolean addNotify(Notify ny);
	
	/*
	 * 修改评估建议告知书
	 */
	public boolean updateNotify(Notify ny);
	
	/*
	 * 根据档案编号判断估建议告知书是否存在
	 */
	public boolean existNotify(String strRecordID);
	
	/*
	 * 根据档案编号删除评估建议告知书
	 */
	public boolean deleteNotify(String strRecordID);
	
	/*
	 * 新增优生模板
	 */
	public boolean addEugenicsModule(EugenicsModule em);
	
	/*
	 * 修改优生模板
	 */
	public boolean updateEugenicsModule(EugenicsModule em);
	
	/*
	 * 根据模板编号判断优生模板是否存在
	 */
	public boolean existEugenicsModule(String strModuleID);
	
	/*
	 * 根据模板编号删除优生模板是否存在
	 */
	public boolean deleteEugenicsModule(String strModuleID);
	
	/*
	 * 根据模板编号获取单条优生模板
	 */
	public EugenicsModule getEugenicsModule(String strModuleID);
	
	/*
	 * 根据备注获取多条优生模板内容
	 */
	public List<EugenicsModule> getEugenicModuleByRemarks(String strRemarks);
	
	/*
	 * 根据备注和标题获取多条优生模板内容
	 */
	public List<EugenicsModule> getEugenicModuleByRemarksAndTitle(String strRemarks,String strTitle);
	
	/*
	 * 新增数据来源配置模板
	 */
	public boolean addDataSourceConfig(DataSourceConfig dsc);
	
	/*
	 * 修改数据来源配置模板
	 */
	public boolean updateDataSourceConfig(DataSourceConfig dsc);
	
	/*
	 * 根据编号判断数据来源配置模板是否存在
	 */
	public boolean existDataSourceConfig(String strID);
	
	/*
	 * 根据模板编号和受检人(妻子或丈夫)判断数据来源配置模板是否存在
	 */
	public boolean existDataSourceConfigByItemIDAndTypeName(String strItemTypeID,String strTypeName);
	
	/*
	 * 根据编号删除数据来源配置模板
	 */
	public boolean deleteDataSourceConfig(String strID);
	
	/*
	 * 根据模板编号获取单条数据来源配置模板
	 */
	public DataSourceConfig getDataSourceConfig(String strItemTypeID);
	
	/*
	 * 根据妻子或丈夫获取多条数据来源配置模板内容(新建档案时根据数据录入来源，获取需要自动开处置的项目名称)
	 * 如果strTypeName为空，则获取所有的临床检验模板项目
	 */
	public List<DataSourceConfig> getDataSourceConfigByType(String strTypeName);
	
	/*
	 * 根据所需的报告单获取处置项目
	 * 如果strReport为空，则只获取临床检验项目和B超项目
	 */
	public List<CzdisposeItemDescribe> getCZDisposeItemDescribe(String strReport);
	
	/*
	 * 新增自动优生评估模板目录
	 */
	public boolean addNotifyItems(NotifyItems ni);
	
	/*
	 * 修改自动优生评估模板目录
	 */
	public boolean updateNotifyItems(NotifyItems ni);
	
	/*
	 * 根据自动优生评估模板目录编号判断自动优生评估模板目录是否存在
	 */
	public boolean existNotifyItems(String strNIID);
	
	/*
	 * 根据自动优生评估模板目录编号删除优生自动优生评估模板目录是否存在
	 */
	public boolean deleteNotifyItems(String strNIID);
	
	/*
	 * 根据自动优生评估模板目录编号获取单条自动优生评估模板目录
	 */
	public NotifyItems getNotifyItems(String strNIID);
	
	/*
	 * 根据备注获取所有自动评估模板目录
	 */
	public List<NotifyItems> getNotifyItemsAll();
	
	/*
	 * 根据条件标题获取自动评估模板目录
	 */
	public List<NotifyItems> getNotifyItemsByCondition(String strCondition);
	
	/*
	 * 获取自动评估模板目录表中的最大的编号(即最后一次插入的记录编号)
	 */
	public long GetMaxIDFromNotifyItems();
	
	/*
	 * 新增自动优生评估模板编制条件
	 */
	public boolean addNotifyModule(NotifyModule nm);
	
	/*
	 * 修改自动优生评估模板编制条件
	 */
	public boolean updateNotifyModule(NotifyModule nm);
	
	/*
	 * 根据自动优生评估模板编制条件编号判断自动优生评估模板编制条件是否存在
	 */
	public boolean existNotifyModule(String strNMID);
	
	/*
	 * 根据自动优生评估模板编制条件编号删除优生自动优生评估模板编制条件是否存在
	 */
	public boolean deleteNotifyModule(String strNMID);
	
	/*
	 * 根据告知书评估项目表ID删除优生自动优生评估模板
	 */
	public boolean deleteNotifyModuleByNIID(String strNIID);
	
	/*
	 * 根据自动优生评估模板编制条件编号获取单条自动优生评估模板编制条件
	 */
	public NotifyModule getNotifyModule(String strNMID);
	
	/*
	 * 根据备注获取所有自动评估模板编制条件
	 */
	public List<NotifyModule> getNotifyModuleAll();
	
	/*
	 * 新增自动优生评估模板具体项目
	 */
	public boolean addNotifyModuleTerm(NotifyModuleTerm mnt);
	
	/*
	 * 修改自动优生评估模板具体项目
	 */
	public boolean updateNotifyModuleTerm(NotifyModuleTerm mnt);
	
	/*
	 * 根据自动优生评估模板具体项目编号判断自动优生评估模板具体项目是否存在
	 */
	public boolean existNotifyModuleTerm(String strNMTID);
	
	/*
	 * 根据自动优生评估模板具体项目编号删除优生自动优生评估模板具体项目是否存在
	 */
	public boolean deleteNotifyModuleTerm(String strNMTID);
	
	/*
	 * 根据自动优生评估模板具体项目编号获取单条自动优生评估模板具体项目
	 */
	public NotifyModuleTerm getNotifyModuleTerm(String strNMTID);
	
	/*
	 * 根据备注获取所有自动评估模板具体项目
	 */
	public List<NotifyModuleTerm> getNotifyModuleTermAll();
	/*
	 * 根据条件名称获取自动评估模板具体项目
	 */
	public List<NotifyModuleTerm> getNotifyModuleTermByConditionName(String strConditionName);
	
	/*
	 * 根据模板ID获取自动评估模板进行维护
	 */
	public String[][] getNotifyModuleReuslt(String strNIID);
	
	/*
	 * 根据strTypeName(妻子或丈夫)获取(妻子或丈夫)所有检验项目的ID。
	 * 如果strTypeName为空，则获取所有设置好的所有检验项目ID。
	 */
	public int[] getItemTypeID(String strTypeName);	
	
	/*
	 * 获取国家优生项目技术服务工作月统计报表需要的数据 
	 */
	public String[][] getServerMonthReport(String strBeginDate,String strEndDate);
	
	/*
	 * 获取国家优生项目妊娠结局月统计报表
	 */
	public String[][] getPregnancyResultReport(String strBeginDate,String strEndDate);
	
	/*
	 * 根据身份证号获取网站或触摸屏填写的一般情况内容
	 */
	public String getGeneralByCardID(String strCardID);
	
	/*
	 * 根据身份证号删除网站或触摸屏填写的一般情况内容
	 */
	public boolean delGeneralByCardID(String strCardID);
	
	/*
	 * 获取国家免费孕前优生健康检查统计报表
	 */
	public String[][] getCheckItemStatReport(String strBeginDate,String strEndDate);
	
	/*
	 * 获取乡镇人数统计报表
	 */
	public String[][] getTownPeopleCountReport(String strBeginDate,String strEndDate,String strPreviousCode);
	
}
