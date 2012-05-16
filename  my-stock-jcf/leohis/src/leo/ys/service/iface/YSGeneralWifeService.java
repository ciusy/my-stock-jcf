/**
 * 
 */
package leo.ys.service.iface;

import leo.entity.BloodCellTest;
import leo.entity.LeucorrheaTest;
import leo.entity.ThyroidGlandTest;
import leo.entity.TorchandSyphilis;
import leo.entity.WifeBloodGroup;
import leo.entity.WifeBloodSuger;
import leo.entity.WifeBodyDoc;
import leo.entity.WifeBodyGeneral;
import leo.entity.WifeClinicalOthers;
import leo.entity.WifeGeneralDoc;
import leo.entity.WifeGeneralSelf;
import leo.entity.WifeHepatitisB;
import leo.entity.WifeLiverAndKidney;
import leo.entity.WifeOthersTest;
import leo.entity.WifeRoutineUrine;
import leo.entity.WomanBc;

/**
 * @author Administrator
 *
 */
public interface YSGeneralWifeService {

	/*
	 * 新增孕前检查表(妻子)一般情况(自助检查)
	 */
	public boolean addWifeGeneralSelf(WifeGeneralSelf wgs);
	
	/*
	 * 新增孕前检查表(妻子)一般情况(医生询问的社会心理因素)
	 */
	public boolean addWifeGeneralDoc(WifeGeneralDoc wgd);
	
	/*
	 * 新增孕前检查表(妻子)一般情况(体格检查)
	 */
	public boolean addWifeBodyGerneral(WifeBodyGeneral wbg);
	
	/*
	 * 新增孕前检查表(妻子)一般情况(体格检查即需要医生检查)
	 */
	public boolean addWifeBodyDoc(WifeBodyDoc wbd);
	
	/*
	 * 新增孕前检查表(妻子)临床检验-白带检查
	 */
	public boolean addWifeLeucorrheaTest(LeucorrheaTest lt);
	
	/*
	 * 新增孕前检查表(妻子)临床检验-血细胞分析(血常规)
	 */
	public boolean addWifeBloodCellTest(BloodCellTest bct);
	
	/*
	 * 新增孕前检查表(妻子)临床检验-尿液常规检查
	 */
	public boolean addWifeRoutineUrine(WifeRoutineUrine wru);
	
	/*
	 * 新增孕前检查表(妻子)临床检验-血型
	 */
	public boolean addWifeBloodGroup(WifeBloodGroup wbg);
	
	/*
	 * 新增孕前检查表(妻子)临床检验-血糖（生化）
	 */
	public boolean addWifeBloodSuger(WifeBloodSuger wbs);
	
	/*
	 * 新增孕前检查表(妻子)临床检验-乙肝血清学检查(酶标)
	 */
	public boolean addWifeHepatitisB(WifeHepatitisB whb);
	
	/*
	 * 新增孕前检查表(妻子)临床检验-肝肾功能检测（生化）
	 */
	public boolean addWifeLiverAndKidney(WifeLiverAndKidney wlk);
	
	/*
	 * 新增孕前检查表(妻子)临床检验-甲状腺功能检测
	 */
	public boolean addWifeThyroidGlandTest(ThyroidGlandTest tgt);
	
	/*
	 * 新增孕前检查表(妻子)临床检验-TORCH梅毒能检测(化学发光)
	 */
	public boolean addWifeTorchandSyphilis(TorchandSyphilis ts);
	
	/*
	 * 新增孕前检查表(妻子)妇科B超检查
	 */
	public boolean addWifeWomanBC(WomanBc wbc);
	
	/*
	 * 新增孕前检查表(妻子)临床检验-其他检查
	 */
	public boolean addWifeClinicalOthers(WifeClinicalOthers wco);
	
	/*
	 * 新增妻子其他检查(各地自定检查内容)
	 */
	public boolean addWifeOthersTest(WifeOthersTest wot);
	
	/*
	 * 修改孕前检查表(妻子)一般情况(自助检查)
	 */
	public boolean updateWifeGeneralSelf(WifeGeneralSelf wgs);
	
	/*
	 * 新增孕前检查表(妻子)一般情况(医生询问的社会心理因素)
	 */
	public boolean updateWifeGeneralDoc(WifeGeneralDoc wgd);
	
	/*
	 * 修改孕前检查表(妻子)一般情况(体格检查)
	 */
	public boolean updateWifeBodyGerneral(WifeBodyGeneral wbg);
	
	/*
	 * 修改孕前检查表(妻子)一般情况(体格检查即需要医生检查)
	 */
	public boolean updateWifeBodyDoc(WifeBodyDoc wbd);
	
	/*
	 * 修改孕前检查表(妻子)临床检验-白带检查
	 */
	public boolean updateWifeLeucorrheaTest(LeucorrheaTest lt);
	
	/*
	 * 修改孕前检查表(妻子)临床检验-血细胞分析(血常规)
	 */
	public boolean updateWifeBloodCellTest(BloodCellTest bct);
	
	/*
	 * 修改孕前检查表(妻子)临床检验-尿液常规检查
	 */
	public boolean updateWifeRoutineUrine(WifeRoutineUrine wru);
	
	/*
	 * 修改孕前检查表(妻子)临床检验-血型
	 */
	public boolean updateWifeBloodGroup(WifeBloodGroup wbg);
	
	/*
	 * 修改孕前检查表(妻子)临床检验-血糖（生化）
	 */
	public boolean updateWifeBloodSuger(WifeBloodSuger wbs);
	
	/*
	 * 修改孕前检查表(妻子)临床检验-乙肝血清学检查(酶标)
	 */
	public boolean updateWifeHepatitisB(WifeHepatitisB whb);
	
	/*
	 * 修改孕前检查表(妻子)临床检验-肝肾功能检测（生化）
	 */
	public boolean updateWifeLiverAndKidney(WifeLiverAndKidney wlk);
	
	/*
	 * 修改孕前检查表(妻子)临床检验-甲状腺功能检测
	 */
	public boolean updateWifeThyroidGlandTest(ThyroidGlandTest tgt);
	
	/*
	 * 修改孕前检查表(妻子)临床检验-TORCH梅毒能检测(化学发光)
	 */
	public boolean updateWifeTorchandSyphilis(TorchandSyphilis ts);
	
	/*
	 * 修改孕前检查表(妻子)妇科B超检查
	 */
	public boolean updateWifeWomanBC(WomanBc wbc);
	
	/*
	 * 修改孕前检查表(妻子)临床检验-其他检查
	 */
	public boolean updateWifeClinicalOthers(WifeClinicalOthers wco);
	
	/*
	 * 修改妻子其他检查(各地自定检查内容)
	 */
	public boolean updateWifeOthersTest(WifeOthersTest wot);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)一般情况(自助检查)
	 */
	public boolean existWifeGeneralSelf(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)一般情况(医生询问的社会心理因素)
	 */
	public boolean existWifeGeneralDoc(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)一般情况(体格检查)
	 */
	public boolean existWifeBodyGerneral(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)一般情况(体格检查即需要医生检查)
	 */
	public boolean existWifeBodyDoc(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-白带检查
	 */
	public boolean existWifeLeucorrheaTest(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-血细胞分析(血常规)
	 */
	public boolean existWifeBloodCellTest(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-尿液常规检查
	 */
	public boolean existWifeRoutineUrine(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-血型
	 */
	public boolean existWifeBloodGroup(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-血糖（生化）
	 */
	public boolean existWifeBloodSuger(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-乙肝血清学检查(酶标)
	 */
	public boolean existWifeHepatitisB(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-肝肾功能检测（生化）
	 */
	public boolean existWifeLiverAndKidney(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-甲状腺功能检测
	 */
	public boolean existWifeThyroidGlandTest(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-TORCH梅毒能检测(化学发光)
	 */
	public boolean existWifeTorchandSyphilis(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)妇科B超检查
	 */
	public boolean existWifeWomanBC(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-其他检查
	 */
	public boolean existWifeClinicalOthers(String strRecordID);

	/*
	 * 根据档案号判断妻子其他检查(各地自定检查内容)
	 */
	public boolean existWifeOthersTest(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(妻子)一般情况(自助检查)
	 */
	public boolean deleteWifeGeneralSelf(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(妻子)一般情况(医生询问的社会心理因素)
	 */
	public boolean deleteWifeGeneralDoc(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(妻子)一般情况(体格检查)
	 */
	public boolean deleteWifeBodyGerneral(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(妻子)一般情况(体格检查即需要医生检查)
	 */
	public boolean deleteWifeBodyDoc(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(妻子)临床检验-白带检查
	 */
	public boolean deleteWifeLeucorrheaTest(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(妻子)临床检验-血细胞分析(血常规)
	 */
	public boolean deleteWifeBloodCellTest(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(妻子)临床检验-尿液常规检查
	 */
	public boolean deleteWifeRoutineUrine(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-血型
	 */
	public boolean deleteWifeBloodGroup(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-血糖（生化）
	 */
	public boolean deleteWifeBloodSuger(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-乙肝血清学检查(酶标)
	 */
	public boolean deleteWifeHepatitisB(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-肝肾功能检测（生化）
	 */
	public boolean deleteWifeLiverAndKidney(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-甲状腺功能检测
	 */
	public boolean deleteWifeThyroidGlandTest(String strRecordID);
	
	/*
	 * 根据档案号判断孕前检查表(妻子)临床检验-TORCH梅毒能检测(化学发光)
	 */
	public boolean deleteWifeTorchandSyphilis(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(妻子)妇科B超检查
	 */
	public boolean deleteWifeWomanBC(String strRecordID);
	
	/*
	 * 根据档案号删除孕前检查表(妻子)临床检验-其他检查
	 */
	public boolean deleteWifeClinicalOthers(String strRecordID);
	
	/*
	 * 根据档案号删除妻子其他检查(各地自定检查内容)
	 */
	public boolean deleteWifeOthersTest(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)一般情况(自助检查)
	 */
	public WifeGeneralSelf getWifeGeneralSelf(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)一般情况(医生询问的社会心理因素)
	 */
	public WifeGeneralDoc getWifeGeneralDoc(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)一般情况(体格检查)
	 */
	public WifeBodyGeneral getWifeBodyGerneral(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)一般情况(体格检查即需要医生检查)
	 */
	public WifeBodyDoc getWifeBodyDoc(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)临床检验-白带检查
	 */
	public LeucorrheaTest getWifeLeucorrheaTest(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)临床检验-血细胞分析(血常规)
	 */
	public BloodCellTest getWifeBloodCellTest(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)临床检验-尿液常规检查
	 */
	public WifeRoutineUrine getWifeRoutineUrine(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)临床检验-血型
	 */
	public WifeBloodGroup getWifeBloodGroup(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)临床检验-血糖（生化）
	 */
	public WifeBloodSuger getWifeBloodSuger(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)临床检验-乙肝血清学检查(酶标)
	 */
	public WifeHepatitisB getWifeHepatitisB(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)临床检验-肝肾功能检测（生化）
	 */
	public WifeLiverAndKidney getWifeLiverAndKidney(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)临床检验-甲状腺功能检测
	 */
	public ThyroidGlandTest getWifeThyroidGlandTest(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)临床检验-TORCH梅毒能检测(化学发光)
	 */
	public TorchandSyphilis getWifeTorchandSyphilis(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)妇科B超检查
	 */
	public WomanBc getWifeWomanBC(String strRecordID);
	
	/*
	 * 获取孕前检查表(妻子)临床检验-其他检查
	 */
	public WifeClinicalOthers getWifeClinicalOthers(String strRecordID);
	
	/*
	 * 获取妻子其他检查(各地自定检查内容)
	 */
	public WifeOthersTest getWifeOthersTest(String strRecordID);
	
	/*
	 * 根据诊断编号和B超报告单名称，获取处置表中的处置ID
	 */
	public String getCZDisposeItemID(String strOpDnID);
	
	/*
	 * 根据诊断编号、报告单名称、处置项目名称，获取对应的处置ID
	 */
	public String getCZDisposeItemID(String strOpDnID,String strReport,String strItemName);
	
	/*
	 * 设置白带常规检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForLeucorrheaTest(boolean bNormal,String strRecordID);
	
	/*
	 * 设置血细胞常规检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForBloodCellTest(boolean bNormal,String strRecordID);
	
	/*
	 * 设置肝功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForWifeLiverAndKidneyLiver(boolean bNormal,String strRecordID);
	
	/*
	 * 设置肾功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForWifeLiverAndKidneyKidney(boolean bNormal,String strRecordID);
	
	/*
	 * 设置甲状腺功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForThyroidGlandTest(boolean bNormal,String strRecordID);
	
	/*
	 * 设置乙型肝炎血清学五项功能检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForWifeHepatitisB(boolean bNormal,String strRecordID);
	
	/*
	 * 设置血糖(血清葡萄糖)检查的结果是否正常(true-正常,false-异常)
	 */
	public boolean setNormalForWifeBloodSuger(boolean bNormal,String strRecordID);
	
	/*
	 * 根据身份证号判断孕前检查表(妻子)一般情况(自助检查)
	 */
	public boolean existWifeGeneralSelfByCardID(String strCardID);
	
	/*
	 * 根据身份证号判断孕前检查表(妻子)一般情况(医生询问的社会心理因素)
	 */
	public boolean existWifeGeneralDocByCardID(String strCardID);
}
