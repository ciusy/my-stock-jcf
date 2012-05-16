package leo.ys.dao.impl;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.WifeGeneralSelf;
import leo.ys.dao.iface.YSZiDongPingGuDao;

public class YSZiDongPingGuDaoImpl extends DaoSupport<WifeGeneralSelf> implements YSZiDongPingGuDao {
	
	public String[][] getQiZiYiBanQingKuangTo2(String RecordID){
		Query query = null;
		query = this.getSession().createSQLQuery("select " +
				                                 "  CASE WifeGeneralSelf.Disease WHEN 1 THEN  " + //是否患有或曾经患过以下疾病 0
				                                 "    '0,'+SUBSTRING(WifeGeneralSelf.DiseasesNameS,1,1) + ',' + " +
				                                 "    SUBSTRING(WifeGeneralSelf.DiseasesNameS,2,1) + ',' + " +
				                                 "    SUBSTRING(WifeGeneralSelf.DiseasesNameS,3,1) + ',' + " +
				                                 "    SUBSTRING(WifeGeneralSelf.DiseasesNameS,4,1) + ',' + " +
				                                 "    SUBSTRING(WifeGeneralSelf.DiseasesNameS,5,1) + ',' + " +
				                                 "    SUBSTRING(WifeGeneralSelf.DiseasesNameS,6,1) + ',' + " +
				                                 "    SUBSTRING(WifeGeneralSelf.DiseasesNameS,7,1) + ',' + " +
				                                 "    SUBSTRING(WifeGeneralSelf.DiseasesNameS,8,1) + ',' + " +
				                                 "    SUBSTRING(WifeGeneralSelf.DiseasesNameS,9,1) + ',' +  " +
				                                 "    SUBSTRING(WifeGeneralSelf.DiseasesNameS,10,1) + ',' + " +
				                                 "    SUBSTRING(WifeGeneralSelf.DiseasesNameS,11,1) + ',' + " +
				                                 "    SUBSTRING(WifeGeneralSelf.DiseasesNameS,12,1) + ',' " +
				                                 "  ELSE " +
				                                 "    '1,0,0,0,0,0,0,0,0,0,0,0,0,' " +
				                                 "  end as jbs_1, " +
				                                 "  case WifeGeneralSelf.BirthDefect when 1 then " + //是否患有出生缺陷"1
				                                 "    '0,1,' " +
				                                 "  else " +
				                                 "    '1,0,' " +
				                                 "  end as jbs_2_xx, " +
				                                 "  case WifeGeneralSelf.WDisease when 1 then " + //是否有以下妇科疾病"2
				                                 "    '0,' + " +
				                                 "    case when charindex('子宫附件炎症',WifeGeneralSelf.WDiseaseOther) > 0 then '1,' else '0,' end + " +
				                                 "    case when charindex('不孕不育症',WifeGeneralSelf.WDiseaseOther) > 0 then '1,' else '0,' end + '0,' " +
				                                 "  else " +
				                                 "    '1,0,0,0,' " +
				                                 "  end as jbs_3_xx, " +
				                                 "  case WifeGeneralSelf.TakeMedicine when 1 then " + //目前是否服药 "3
				                                 "    '0,1,' " +
				                                 "  else " +
				                                 "   '1,0,' " +
				                                 "  end as yys_1_xx, " +
				                                 "  case WifeGeneralSelf.Vaccinate when 1 then " + //是否注射过疫苗  "4
				                                 "    '0,' + " +
				                                 "    case when charindex('风疹疫苗',WifeGeneralSelf.VaccinateOther) > 0 then '1,' else '0,' end + " +
				                                 "    case when charindex('乙肝疫苗',WifeGeneralSelf.VaccinateOther) > 0 then '1,' else '0,' end + '0,' " +
				                                 "  else " +
				                                 "    '1,0,0,0,' " +
				                                 "  end as yys_2_xx, " +
				                                 "  case when ((WifeGeneralSelf.Contraceptive is null) or (WifeGeneralSelf.Contraceptive = ''))  then " +
												 "	     '0,0,0,0,0,0,0,0,' " +
												 "	  else " + 
												 "	     SUBSTRING(WifeGeneralSelf.Contraceptive,1,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.Contraceptive,2,1) + ',' + " +
												 " 	     SUBSTRING(WifeGeneralSelf.Contraceptive,3,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.Contraceptive,4,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.Contraceptive,5,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.Contraceptive,6,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.Contraceptive,7,1) + ',0,' " +
												 "	  end as yys_3_xx, " + //现用避孕措施 5
												 "	  case WifeGeneralSelf.MenstrualCycle when 1 then " + //月经周期是否规律6
												 "	    '0,1,' " +
												 "	  else " +
												 "	    '1,0,' " +
												 "	  end as yy_fcyjsflv_xx, " +
												 "	  case WifeGeneralSelf.MPNum " + //月经量7
												 "	     when 0 then '1,0,0,' " +
												 "	     when 1 then '0,1,0,' " +
												 "	     when 2 then '0,0,1,' " +
												 "	  else " +
												 "	     '0,0,0,' " +
												 "	  end as yy_yjl, " +
												 "	  case WifeGeneralSelf.Dysmenorrhea " + //痛经8
												 "	     when '0' then '1,0,0,' " +
												 "	     when '1' then '0,1,0,' " +
												 "	     when '2' then '0,0,1,' " +
												 "	  else " +
												 "	     '0,0,0,' " +
												 "	  end as yy_tt, " +
												 "	  case WifeGeneralSelf.Fetation when 1 then '0,1,' else '1,0,' end as yy_sfcjhy_xx, " + //是否曾经怀孕9
												 "	  case WifeGeneralSelf.HAPO when 1 then '0,1,' else '1,0,' end as ys_bljj_xx, " + //-不良妊娠结局10
												 "	  case WifeGeneralSelf.LaborDefect when 1 then '0,1,' else '1,0,' end as yy_csqxe_xx, " + //是否分娩过出生缺陷儿11
												 "	  case  " +
												 "	     when WifeGeneralSelf.PhysicalCondition = '健康' then '1,0,' " +
												 "	     when WifeGeneralSelf.PhysicalCondition = '疾病' then '0,1,' " +
												 "	  else " +
												 "	     '0,0,' " +
												 "	  end as yy_znstzk_xx, " + //子女身体状况12
												 "	  case WifeGeneralSelf.Intermarriage when 1 then '0,1,' else '1,0,' end as jzs_1_xx, " + //-夫妻是否近新结婚13
												 "	  case WifeGeneralSelf.FamilyMarriage when 1 then '0,1,' else '1,0,' end as jzs_2_xx, " + //两代家族内近亲结婚史14
												 "	  case when ((WifeGeneralSelf.FamilyDiseasez is null) or (WifeGeneralSelf.FamilyDiseasez = ''))  then " +
												 "	     '1,0,0,0,0,0,0,0,0,0,0,0,0,' " +
												 "	  else  " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,1,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,2,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,3,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,4,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,5,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,6,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,7,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,8,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,9,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,10,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,11,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.FamilyDiseasez,12,1) + ',0,' " +
												 "	  end as jzs_3_xx, " + //家族成员是否有人患以下疾病15
												 "	  case WifeGeneralSelf.Raptatorial when 1 then '0,1,' else '0,0,' end as ysyy_1_xx, " + //是否进食肉、蛋类16
												 "	  case WifeGeneralSelf.Vegetables when 1 then '0,1,' else '0,0,' end as ysyy_2_xx, " + //是否厌食蔬菜17
												 "	  case WifeGeneralSelf.RawMeat when 1 then '0,1,' else '0,0,' end as ysyy_3_xx, " + //是否有食用生肉嗜好18
												 "	  case WifeGeneralSelf.Smoke when 1 then '0,1,' else '0,0,' end as ysyy_4_xx, " + //是否吸烟19
												 "	  case WifeGeneralSelf.PassiveSmoke when 0 then " +
												 "	     '1,0,0,' " +
												 "	  else " +
												 "	     '0,' + " +
												 "	     case WifeGeneralSelf.SmokeType when '偶尔' then '1,0,' else '0,1,' end " +
												 "	  end as ysyy_5_xx, " + //是否存在被动吸烟20
												 "	  case WifeGeneralSelf.Drink when 0 then " + 
												 "	     '1,0,0,' " +
												 "	  else " +
												 "	     '0,' + " +
												 "	     case WifeGeneralSelf.DrinkingType when '偶尔' then '1,0,' else '0,1,' end " +
												 "	  end as ysyy_6_xx, " + //是否饮酒21
												 "	  case WifeGeneralSelf.Drug when 1 then '0,1,' else '0,0,' end as ysyy_7_xx, " + //是否使用毒麻药品22
												 "	  case WifeGeneralSelf.Ozostomia when 1 then '0,1,' else '0,0,' end as ysyy_8_xx, " + //是否口臭23
												 "	  case WifeGeneralSelf.BleedingGums when 1 then '0,1,' else '0,0,' end as ysyy_9_xx, " + //是否牙龈出血24
												 "	  case WifeGeneralSelf.Contact when 0 then '1,0,0,0,0,0,0,0,0,0,' else " +
												 "	     '0,' + " +
												 "	     SUBSTRING(WifeGeneralSelf.ContactFactors,1,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.ContactFactors,2,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.ContactFactors,3,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.ContactFactors,4,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.ContactFactors,5,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.ContactFactors,6,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.ContactFactors,7,1) + ',' + " +
												 "	     SUBSTRING(WifeGeneralSelf.ContactFactors,8,1) + ',0,' " +
												 "	  end as ysyy_10_xx, " + //是否接触以下因素25
												 "	  SUBSTRING(WifeGeneralDoc.WorkPressure,1,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.WorkPressure,2,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.WorkPressure,3,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.WorkPressure,4,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.WorkPressure,5,1) + ',' as shxl_1_xx, " + //是否感到生活/工作压力26
												 "	  SUBSTRING(WifeGeneralDoc.FriendsNervous,1,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.FriendsNervous,2,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.FriendsNervous,3,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.FriendsNervous,4,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.FriendsNervous,5,1) + ',' as shxl_2_xx, " + //与亲友同事关系是否紧张27
												 "	  SUBSTRING(WifeGeneralDoc.EconomicPressures,1,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.EconomicPressures,2,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.EconomicPressures,3,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.EconomicPressures,4,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.EconomicPressures,5,1) + ',' as shxl_3_xx, " + //是否感到经济压力28
												 "	  case WifeGeneralDoc.PPregnancy when 1 then '0,1,' else '1,0,' end as shxl_4_xx " + //是否做好怀孕准备29
												 "from WifeGeneralSelf,WifeGeneralDoc " +
												 "where " +
												 "	  WifeGeneralSelf.RecordID=WifeGeneralDoc.RecordID and " +
												 "	  WifeGeneralSelf.RecordID=?");
		query.setParameter(0, RecordID);
		query.list();
		return listObject2StringString(query.list());
	}

	public String[][] getZhangFuYiBanQingKuangTo2(String RecordID){
		Query query = null;
		query = this.getSession().createSQLQuery("select "+
												 "	  CASE HusGeneralSelf.Disease WHEN 1 THEN "+ //是否患有或曾经患过以下疾病0
												 "	     '0,'+SUBSTRING(HusGeneralSelf.DiseasesNameS,1,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.DiseasesNameS,2,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.DiseasesNameS,3,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.DiseasesNameS,4,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.DiseasesNameS,5,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.DiseasesNameS,6,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.DiseasesNameS,7,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.DiseasesNameS,8,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.DiseasesNameS,9,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.DiseasesNameS,10,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.DiseasesNameS,11,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.DiseasesNameS,12,1) + ',' "+
												 "	  ELSE  "+
												 "	    '1,0,0,0,0,0,0,0,0,0,0,0,0,' "+
												 "	  end as jbs_1, "+
												 "	  case HusGeneralSelf.BirthDefect when 1 then "+ //是否患有出生缺陷1
												 "	    '0,1,' "+
												 "	  else "+
												 "	    '1,0,' "+
												 "	  end as jbs_2_xx, "+
												 "	  case HusGeneralSelf.MDisease when 1 then "+ //是否有以下男科疾病2
												 "	    '0,' + "+
												 "	    case when charindex('睾丸炎、附睾炎',HusGeneralSelf.MDiseaseOther) > 0 then '1,' else '0,' end + "+
												 "	    case when charindex('精索静脉曲张',HusGeneralSelf.MDiseaseOther) > 0 then '1,' else '0,' end + "+
												 "	    case when charindex('不育症',HusGeneralSelf.MDiseaseOther) > 0 then '1,' else '0,' end + "+
												 "	    case when charindex('腮腺炎',HusGeneralSelf.MDiseaseOther) > 0 then '1,' else '0,' end + '0,' "+
												 "	  else "+
												 "	    '1,0,0,0,0,0,' "+
												 "	  end as jbs_3_xx, "+
												 "	  case HusGeneralSelf.TakeMedicine when 1 then "+ //目前是否服药3
												 "	    '0,1,' "+
												 "	  else "+
												 "	    '1,0,' "+
												 "	  end as yys_1_xx, "+
												 "	  case HusGeneralSelf.Vaccinate when 1 then "+ //是否注射过疫苗4
												 "	    '0,' + "+
												 "	    case when charindex('乙肝疫苗',HusGeneralSelf.VaccinateOther) > 0 then '1,' else '0,' end + '0,' "+
												 "	  else "+
												 "	    '1,0,0,' "+
												 "	  end as yys_2_xx, "+
												 "	  case HusGeneralSelf.FamilyMarriage when 1 then '0,1,' else '1,0,' end as jzs_1_xx, "+ //两代家族内近亲结婚史5
												 "	  case when ((HusGeneralSelf.FamilyDiseasez is null) or (HusGeneralSelf.FamilyDiseasez = ''))  then "+
												 "	     '1,0,0,0,0,0,0,0,0,0,0,0,0,' "+
												 "	  else  "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,1,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,2,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,3,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,4,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,5,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,6,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,7,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,8,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,9,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,10,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,11,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.FamilyDiseasez,12,1) + ',0,' "+
												 "	  end as jzs_2_xx, "+ //家族成员是否有人患以下疾病6
												 "	  case HusGeneralSelf.Raptatorial when 1 then '0,1,' else '0,0,' end as ysyy_1_xx, "+ //是否进食肉、蛋类7
												 "	  case HusGeneralSelf.Vegetables when 1 then '0,1,' else '0,0,' end as ysyy_2_xx, "+ //是否厌食蔬菜8
												 "	  case HusGeneralSelf.RawMeat when 1 then '0,1,' else '0,0,' end as ysyy_3_xx, "+ //是否有食用生肉嗜好9
												 "	  case HusGeneralSelf.Smoke when 1 then '0,1,' else '0,0,' end as ysyy_4_xx, "+ //是否吸烟10
												 "	  case HusGeneralSelf.PassiveSmoke when 0 then "+ 
												 "	     '1,0,0,' "+
												 "	  else "+
												 "	     '0,' + "+
												 "	     case HusGeneralSelf.SmokeType when '偶尔' then '1,0,' else '0,1,' end "+
												 "	  end as ysyy_5_xx, "+ //是否存在被动吸烟11
												 "	  case HusGeneralSelf.Drink when 0 then "+ 
												 "	     '1,0,0,' "+
												 "	  else "+
												 "	     '0,' + "+
												 "	     case HusGeneralSelf.DrinkingType when '偶尔' then '1,0,' else '0,1,' end "+
												 "	  end as ysyy_6_xx, "+ //是否饮酒12
												 "	  case HusGeneralSelf.Drug when 1 then '0,1,' else '0,0,' end as ysyy_7_xx, "+ //是否使用毒麻药品13
												 "	  case HusGeneralSelf.Contact when 0 then '1,0,0,0,0,0,0,0,0,0,' else "+
												 "	     '0,' + "+
												 "	     SUBSTRING(HusGeneralSelf.ContactFactors,1,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.ContactFactors,2,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.ContactFactors,3,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.ContactFactors,4,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.ContactFactors,5,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.ContactFactors,6,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.ContactFactors,7,1) + ',' + "+
												 "	     SUBSTRING(HusGeneralSelf.ContactFactors,8,1) + ',0,' "+
												 "	  end as ysyy_8_xx, "+ //是否接触以下因素14
												 "	  SUBSTRING(HusGeneralDoc.WorkPressure,1,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.WorkPressure,2,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.WorkPressure,3,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.WorkPressure,4,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.WorkPressure,5,1) + ',' as shxl_1_xx, "+ //是否感到生活/工作压力15
												 "	  SUBSTRING(HusGeneralDoc.FriendsNervous,1,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.FriendsNervous,2,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.FriendsNervous,3,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.FriendsNervous,4,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.FriendsNervous,5,1) + ',' as shxl_2_xx, "+ //与亲友同事关系是否紧张16
												 "	  SUBSTRING(HusGeneralDoc.EconomicPressures,1,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.EconomicPressures,2,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.EconomicPressures,3,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.EconomicPressures,4,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.EconomicPressures,5,1) + ',' as shxl_3_xx, "+ //是否感到经济压力17
												 "	  case HusGeneralDoc.PPregnancy when 1 then '0,1,' else '1,0,' end as shxl_4_xx "+ //是否做好怀孕准备18
												 "from HusGeneralSelf,HusGeneralDoc "+
												 "where "+
												 "	  HusGeneralSelf.RecordID=HusGeneralDoc.RecordID and "+
												 "	  HusGeneralSelf.RecordID=?");
		query.setParameter(0, RecordID);
		query.list();
		return listObject2StringString(query.list());
	}

	public String[][] getMoBanBiaoTou(String LeiXing){
		Query query = null;
		if (LeiXing != null && !LeiXing.equals("")){
			query = this.getSession().createSQLQuery("select NIID,Content from NotifyItems where Type = ?");
			query.setParameter(0, LeiXing);
		}else{
			query = this.getSession().createSQLQuery("select NIID,Content from NotifyItems");
		}
		query.list();
		return listObject2StringString(query.list());
	}

	public String[][] getMoBanMinXi(Long ID){
		Query query = null;
		query = this.getSession().createSQLQuery("select "+ 
												 "	  NotifyModuleTerm.ConditionName, "+ //0条件名称
												 "	  NotifyModuleTerm.Sex, "+ //1性别
												 "	  NotifyModule.Remarks, "+ //2关系
												 "	  NotifyModule.Result, "+ //3结果
												 "	  NotifyModuleTerm.SR "+ //4可疑结果
												 "from NotifyModuleTerm,NotifyModule "+
												 "where "+
												 "	  NotifyModule.NMTID = NotifyModuleTerm.NMTID and "+
												 "	  NotifyModule.NIID = ?");
		query.setParameter(0, ID);
		query.list();
		return listObject2StringString(query.list());
	}

	public String getQiZiTiGeTo2(String RecordID){
		Query query = null;
		query = this.getSession().createSQLQuery("select "+
                                                 "   case when (MentalState = '正常')  then '0,' else '1,' end + "+ //精神状态
                                                 "   case when (Intelligence = '正常') then '0,' else '1,' end + "+ //智力
												 "   case when (Facial = '正常') then '0,' else '1,' end + "+ //五官
												 "      case when (SpecialPosture = '正常') then '0,' else '1,' end + "+ //特殊体态
												 "      case when (FaceSpecial = '正常') then '0,' else '1,' end + "+ //特殊面容
												 "      case when (Skin = '正常') then '0,' else '1,' end + "+ //皮肤毛发
												 "      case when (Thyroid = '正常') then '0,' else '1,' end + "+ //甲状腺
												 "      case when (Lung = '正常') then '0,' else '1,' end + "+ //肺部
												 "      case when (HeartRhythm = '是') then '0,' else '1,' end + "+ //心脏节律是否整齐
												 "      case when (HeartNoise = '无') then '0,' else '1,' end + "+ //心脏杂音
												 "      case when (Liver = '未触及') then '0,' else '1,' end + "+ //肝脾
												 "      case when (Limbs = '正常') then '0,' else '1,' end "+  //四肢脊柱
												 "      as qztg "+
												 "   from "+
												 "      WifeBodyGeneral "+
												 "   where "+
				 								 "      RecordID = ?");
		query.setParameter(0, RecordID);
		if (query.uniqueResult() == null)
			return "";
		else
			return query.uniqueResult().toString();
	}
	
	public String getQiZiFuKeTo2(String RecordID){
		Query query = null;
		query = this.getSession().createSQLQuery("select "+
												 "    case when (PubicHair = '正常')  then '0,' else '1,' end + "+//阴毛
												 "    case when (Breast = '正常')  then '0,' else '1,' end + "+//乳房
												 "    case when (Vulva = '未见异常')  then '0,' else '1,' end + "+//外阴
												 "    case when (Vagina = '未见异常')  then '0,' else '1,' end + "+//阴道
												 "    case when (Secretion = '正常')  then '0,' else '1,' end + "+//是否分泌物
												 "    case when (Cervix = '光滑')  then '0,' else '1,' end + "+//宫颈
												 "    case when (WombBigSmall = '正常')  then "+
												 "      '0,' "+
												 "    else "+
												 "       case when (WombBigSmall = '小')  then "+ 
												 "          '1,' "+
												 "       else "+
												 "          '2,' "+
												 "       end "+
												 "    end + "+//子宫大小
												 "    case when (WombExercise = '好')  then '0,' else '1,' end + "+//子宫活动
												 "    case when (WombEM = '无')  then '0,' else '1,' end + "+//子宫包块
												 "    case when (WombAccessory = '未见异常')  then '0,' else '1,' end "+//子宫双侧附件
												 "    as qzfk "+
												 "from  "+
												 "    WifeBodyDoc "+
												 "where RecordID =?");
		query.setParameter(0, RecordID);
		if (query.uniqueResult() == null)
			return "";
		else
			return query.uniqueResult().toString();
	}
	
	public String getZangFuTiGeTo2(String RecordID){
		Query query = null;
		query = this.getSession().createSQLQuery("select "+
												 "    case when (MentalState = '正常')  then '0,' else '1,' end + "+//精神状态
												 "    case when (Intelligence = '正常')  then '0,' else '1,' end + "+//智力
												 "    case when (Facial = '正常')  then '0,' else '1,' end + "+//五官
												 "    case when (SpecialPosture = '正常')  then '0,' else '1,' end + "+//特殊体态
												 "    case when (FaceSpecial = '正常')  then '0,' else '1,' end + "+//特殊面容
												 "    case when (Skin = '正常')  then '0,' else '1,' end + "+//皮肤毛发
												 "    case when (Thyroid = '正常')  then '0,' else '1,' end + "+//甲状腺
												 "    case when (Lung = '正常')  then '0,' else '1,' end + "+//肺部
												 "    case when (HeartRhythm = '是')  then '0,' else '1,' end + "+//心脏节律是否整齐
												 "    case when (HeartNoise = '无')  then '0,' else '1,' end + "+//心脏杂音
												 "    case when (Liver = '未触及')  then '0,' else '1,' end + "+//肝脾
												 "    case when (Limbs = '正常')  then '0,' else '1,' end "+//四肢脊柱
												 "    as zftg "+
												 "from "+
												 "    HusBodyGeneral "+
												 "where "+
												 "    RecordID = ?");
		query.setParameter(0, RecordID);
		if (query.uniqueResult() == null)
			return "";
		else
			return query.uniqueResult().toString();
	}

	public String getZangFuNanKeTo2(String RecordID){
		Query query = null;
		query = this.getSession().createSQLQuery("select "+
												 "    case when (PubicHair = '正常')  then '0,' else '1,' end + "+//阴毛
												 "    case when (LaryngealTuberculosis = '有')  then '0,' else '1,' end + "+//喉结
												 "    case when (Penis = '未见异常')  then '0,' else '1,' end + "+//阴茎
												 "    case when (Wrapping = '正常')  then "+ 
												 "       '0,' "+
												 "    else "+
												 "       case when (Wrapping = '过长') then "+
												 "          '1,' "+
												 "       else "+
												 "          '2,' "+
												 "       end "+
												 "    end + "+//包皮
												 "    case when (Testicular = '扪及')  then "+
												 "       '0,' "+
												 "    else "+
												 "       case when (Testicular = '左侧未扪及') then "+
												 "          '1,' "+
												 "       else "+
												 "          '2,' "+
												 "       end "+
												 "    end + "+//睾丸
												 "    case when (Epididymis = '正常')  then '0,' else '1,' end + "+//附睾
												 "    case when (Vasectomy = '未见异常')  then '0,' else '1,' end + "+//输精管
												 "    case when (Spermatic = '无')  then '0,' else '1,' end "+//精索静脉曲张
												 "    as zfnk "+
												 "from  "+
												 "    HusBodyDoc "+ 
												 "where  "+
												 "   RecordID = ?");
		query.setParameter(0, RecordID);
		if (query.uniqueResult() == null)
			return "";
		else
			return query.uniqueResult().toString();
		
	}
	
	public String[][] getRenYuan(String KaiShiRiQi, String JieSuRiQi, String XingBie){
		Query query = null;
		if (XingBie.equals("女"))
			query = this.getSession().createSQLQuery("select "+
													 "   FamiliRecordBasicInfo.WrittenDate as date, "+ //日期0
													 "   FamiliRecordBasicInfo.WTown, "+ //乡镇1
													 "   FamiliRecordBasicInfo.Wname, "+ //姓名2
													 "   '女' as sex, "+ //性别3
													 "   FamiliRecordBasicInfo.Wage, "+ //年龄4
													 "   FamiliRecord.WOpDnID, "+ //诊断号5
													 "   FamiliRecordBasicInfo.RecordID "+ //档案号6
													 "from "+
													 "   FamiliRecordBasicInfo,FamiliRecord "+
													 "where "+
													 "   FamiliRecordBasicInfo.RecordID = FamiliRecord.RecordID and "+
	 											 	 "   FamiliRecordBasicInfo.WrittenDate >= ? and FamiliRecordBasicInfo.WrittenDate <= ?");
		else
			query = this.getSession().createSQLQuery("select "+
					 								 "   FamiliRecordBasicInfo.WrittenDate as date, "+
					 								 "   FamiliRecordBasicInfo.MTown, "+
					 								 "   FamiliRecordBasicInfo.Mname, "+
					 								 "   '男' as sex, "+
					 								 "   FamiliRecordBasicInfo.Mage, "+
					 								 "   FamiliRecord.MOpDnID, "+
					 								 "   FamiliRecordBasicInfo.RecordID "+
					 								 "from "+
					 								 "   FamiliRecordBasicInfo,FamiliRecord "+
					 								 "where "+
					 								 "   FamiliRecordBasicInfo.RecordID = FamiliRecord.RecordID and "+
				 	 								 "   FamiliRecordBasicInfo.WrittenDate >= ? and FamiliRecordBasicInfo.WrittenDate <= ?");
			
		query.setParameter(0, KaiShiRiQi);
		query.setParameter(1, JieSuRiQi);
		//query.list();
		return listObject2StringString(query.list());
		
	}

	public String getNiaoChangGui(String DangAnHao, String XingBie){
		Query query = null;
		if (XingBie.equals("女"))
			query = this.getSession().createSQLQuery("select Results from WifeRoutineUrine where RecordID = ?");
		else
			query = this.getSession().createSQLQuery("select Results from HusRoutineUrine where RecordID = ?");
		query.setParameter(0, DangAnHao);
		query.list();
		if (query.uniqueResult() == null)
			return "";
		else
			return query.uniqueResult().toString();
		
	}

	public String getBianHao(String RiQi){
		Query query = null;
		query = this.getSession().createSQLQuery("select count(*) as QSS from FamiliRecordBasicInfo where WrittenDate < ?");
		query.setParameter(0, RiQi);
		query.list();
		if (query.uniqueResult() == null)
			return "0";
		else
			return query.uniqueResult().toString();
		
	}

}
