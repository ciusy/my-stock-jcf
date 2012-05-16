/**
 * 
 */
package leo.ys.dao.iface;

import leo.entity.HusBloodGroup;
import leo.entity.HusBodyDoc;
import leo.entity.HusBodyGeneral;
import leo.entity.HusClinicalOthers;
import leo.entity.HusGeneralDoc;
import leo.entity.HusGeneralSelf;
import leo.entity.HusHepatitisB;
import leo.entity.HusLiverAndKidney;
import leo.entity.HusOthersTest;
import leo.entity.HusRoutineUrine;
import leo.entity.HusSyphilis;

/**
 * @author Administrator
 *
 */
public interface YSGeneralHusbandDao {

	/*
	 * 新增孕前检查表(丈夫)一般情况(自助检查)
	 */
	public boolean addHusGeneralSelf(HusGeneralSelf hgs);
	
	/*
	 * 新增孕前检查表(丈夫)一般情况(医生询问的社会心理因素)
	 */
	public boolean addHusGeneralDoc(HusGeneralDoc hgd);
	
	/*
	 * 新增孕前检查表(丈夫)一般情况(体格检查)
	 */
	public boolean addHusBodyGeneral(HusBodyGeneral hbg);
	
	/*
	 * 新增孕前检查表(丈夫)一般情况(体格检查即需要医生检查)
	 */
	public boolean addHusBodyDoc(HusBodyDoc hbd);
	
	/*
	 * 新增孕前检查表(丈夫)临床检验-血型
	 */
	public boolean addHusBloodGroup(HusBloodGroup hbg);
	
	/*
	 *新增孕前检查表(丈夫)临床检验-尿液常规检查 
	 */
	public boolean addHusRoutineUrine(HusRoutineUrine hru);
	
	/*
	 * 新增孕前检查表(丈夫)临床检验-梅毒螺旋体筛查(化学发光)
	 */
	public boolean addHusSyphilis(HusSyphilis hs);
	
	/*
	 * 新增孕前检查表(丈夫)临床检验-乙肝血清学检查(酶标)
	 */
	public boolean addHusHepatitisB(HusHepatitisB hhb);
	
	/*
	 * 新增孕前检查表(丈夫)临床检验-肝肾功能检测（生化）
	 */
	public boolean addHusLiverAndKidney(HusLiverAndKidney hlk);
	
	/*
	 * 新增孕前检查表(丈夫)临床检验-其他检查
	 */
	public boolean addHusClinicalOthers(HusClinicalOthers hco);
	
	/*
	 * 新增丈夫其他检查(各地自定检查内容)
	 */
	public boolean addHusOthersTest(HusOthersTest hot);
	
	/*
	 * 修改孕前检查表(丈夫)一般情况(自助检查)
	 */
	public boolean updateHusGeneralSelf(HusGeneralSelf hgs);
	
	/*
	 * 修改孕前检查表(丈夫)一般情况(医生询问的社会心理因素)
	 */
	public boolean updateHusGeneralDoc(HusGeneralDoc hgd);
	
	/*
	 * 修改孕前检查表(丈夫)一般情况(体格检查)
	 */
	public boolean updateHusBodyGeneral(HusBodyGeneral hbg);
	
	/*
	 * 修改孕前检查表(丈夫)一般情况(体格检查即需要医生检查)
	 */
	public boolean updateHusBodyDoc(HusBodyDoc hbd);
	
	/*
	 * 修改孕前检查表(丈夫)临床检验-血型
	 */
	public boolean updateHusBloodGroup(HusBloodGroup hbg);
	
	/*
	 *修改孕前检查表(丈夫)临床检验-尿液常规检查 
	 */
	public boolean updateHusRoutineUrine(HusRoutineUrine hru);
	
	/*
	 * 修改孕前检查表(丈夫)临床检验-梅毒螺旋体筛查(化学发光)
	 */
	public boolean updateHusSyphilis(HusSyphilis hs);
	
	/*
	 * 修改孕前检查表(丈夫)临床检验-乙肝血清学检查(酶标)
	 */
	public boolean updateHusHepatitisB(HusHepatitisB hhb);
	
	/*
	 * 修改孕前检查表(丈夫)临床检验-肝肾功能检测（生化）
	 */
	public boolean updateHusLiverAndKidney(HusLiverAndKidney hlk);
	
	/*
	 * 修改孕前检查表(丈夫)临床检验-其他检查
	 */
	public boolean updateHusClinicalOthers(HusClinicalOthers hco);
	
	/*
	 * 修改丈夫其他检查(各地自定检查内容)
	 */
	public boolean updateHusOthersTest(HusOthersTest hot);
	
	/*
	 * 根据档案号判断孕前检查表(丈夫)一般情况(自助检查)
	 */
	public boolean existHusGeneralSelf(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(丈夫)一般情况(医生询问的社会心理因素)
	 */
	public boolean existHusGeneralDoc(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(丈夫)一般情况(体格检查)
	 */
	public boolean existHusBodyGeneral(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(丈夫)一般情况(体格检查即需要医生检查)
	 */
	public boolean existHusBodyDoc(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(丈夫)临床检验-血型
	 */
	public boolean existHusBloodGroup(String strRecordID);
	
	/*
	 *根据档案号判断孕前检查表(丈夫)临床检验-尿液常规检查 
	 */
	public boolean existHusRoutineUrine(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(丈夫)临床检验-梅毒螺旋体筛查(化学发光)
	 */
	public boolean existHusSyphilis(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(丈夫)临床检验-乙肝血清学检查(酶标)
	 */
	public boolean existHusHepatitisB(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(丈夫)临床检验-肝肾功能检测（生化）
	 */
	public boolean existHusLiverAndKidney(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(丈夫)临床检验-其他检查
	 */
	public boolean existHusClinicalOthers(String strRecordID);
	
	/*
	 * 根据档案号判断丈夫其他检查(各地自定检查内容)
	 */
	public boolean existHusOthersTest(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(丈夫)一般情况(自助检查)
	 */
	public boolean deleteHusGeneralSelf(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(丈夫)一般情况(医生询问的社会心理因素)
	 */
	public boolean deleteHusGeneralDoc(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(丈夫)一般情况(体格检查)
	 */
	public boolean deleteHusBodyGeneral(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(丈夫)一般情况(体格检查即需要医生检查)
	 */
	public boolean deleteHusBodyDoc(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(丈夫)临床检验-血型
	 */
	public boolean deleteHusBloodGroup(String strRecordID);
	
	/*
	 *根据档案号删除孕前检查表(丈夫)临床检验-尿液常规检查 
	 */
	public boolean deleteHusRoutineUrine(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(丈夫)临床检验-梅毒螺旋体筛查(化学发光)
	 */
	public boolean deleteHusSyphilis(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(丈夫)临床检验-乙肝血清学检查(酶标)
	 */
	public boolean deleteHusHepatitisB(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(丈夫)临床检验-肝肾功能检测（生化）
	 */
	public boolean deleteHusLiverAndKidney(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(丈夫)临床检验-其他检查
	 */
	public boolean deleteHusClinicalOthers(String strRecordID);
	
	/*
	 * 根据档案号删除丈夫其他检查(各地自定检查内容)
	 */
	public boolean deleteHusOthersTest(String strRecordID);
	
	/*
	 * 根据档案号获取孕前检查表(丈夫)一般情况(自助检查)
	 */
	public HusGeneralSelf getHusGeneralSelf(String strRecordID);
	
	/*
	 * 根据档案号获取孕前检查表(丈夫)一般情况(医生询问的社会心理因素)
	 */
	public HusGeneralDoc getHusGeneralDoc(String strRecordID);
	
	/*
	 * 根据档案号获取孕前检查表(丈夫)一般情况(体格检查)
	 */
	public HusBodyGeneral getHusBodyGeneral(String strRecordID);
	
	/*
	 * 根据档案号获取孕前检查表(丈夫)一般情况(体格检查即需要医生检查)
	 */
	public HusBodyDoc getHusBodyDoc(String strRecordID);
	
	/*
	 * 根据档案号获取孕前检查表(丈夫)临床检验-血型
	 */
	public HusBloodGroup getHusBloodGroup(String strRecordID);
	
	/*
	 *根据档案号获取孕前检查表(丈夫)临床检验-尿液常规检查 
	 */
	public HusRoutineUrine getHusRoutineUrine(String strRecordID);
	
	/*
	 * 根据档案号获取孕前检查表(丈夫)临床检验-梅毒螺旋体筛查(化学发光)
	 */
	public HusSyphilis getHusSyphilis(String strRecordID);
	
	/*
	 * 根据档案号获取孕前检查表(丈夫)临床检验-乙肝血清学检查(酶标)
	 */
	public HusHepatitisB getHusHepatitisB(String strRecordID);
	
	/*
	 * 根据档案号获取孕前检查表(丈夫)临床检验-肝肾功能检测（生化）
	 */
	public HusLiverAndKidney getHusLiverAndKidney(String strRecordID);
	
	/*
	 * 根据档案号获取孕前检查表(丈夫)临床检验-其他检查
	 */
	public HusClinicalOthers getHusClinicalOthers(String strRecordID);	
	
	/*
	 * 根据档案号获取丈夫其他检查(各地自定检查内容)
	 */
	public HusOthersTest getHusOthersTest(String strRecordID);
	
	/*
	 * 设置肝功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForHusLiverAndKidneyLiver(boolean bNormal,String strRecordID);
	
	/*
	 * 设置肾功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForHusLiverAndKidneyKidney(boolean bNormal,String strRecordID);
		
	/*
	 * 设置乙型肝炎血清学五项功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForHusHepatitisB(boolean bNormal,String strRecordID);
	
	/*
	 * 根据身份证号判断孕前检查表(丈夫)一般情况(自助检查)
	 */
	public boolean existHusGeneralSelfByCardID(String strCardID);
	
	/*
	 * 根据身份证号判断孕前检查表(丈夫)一般情况(医生询问的社会心理因素)
	 */
	public boolean existHusGeneralDocByCardID(String strCardID);
}
