package leo.ys.dao.impl;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.WifeGeneralSelf;
import leo.ys.dao.iface.YSZiDongPingGuDao;

public class YSZiDongPingGuDaoImpl extends DaoSupport<WifeGeneralSelf> implements YSZiDongPingGuDao {
	
	public String[][] getQiZiYiBanQingKuangTo2(String RecordID){
		Query query = null;
		query = this.getSession().createSQLQuery("select " +
				                                 "  CASE WifeGeneralSelf.Disease WHEN 1 THEN  " + //�Ƿ��л������������¼��� 0
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
				                                 "  case WifeGeneralSelf.BirthDefect when 1 then " + //�Ƿ��г���ȱ��"1
				                                 "    '0,1,' " +
				                                 "  else " +
				                                 "    '1,0,' " +
				                                 "  end as jbs_2_xx, " +
				                                 "  case WifeGeneralSelf.WDisease when 1 then " + //�Ƿ������¸��Ƽ���"2
				                                 "    '0,' + " +
				                                 "    case when charindex('�ӹ�������֢',WifeGeneralSelf.WDiseaseOther) > 0 then '1,' else '0,' end + " +
				                                 "    case when charindex('���в���֢',WifeGeneralSelf.WDiseaseOther) > 0 then '1,' else '0,' end + '0,' " +
				                                 "  else " +
				                                 "    '1,0,0,0,' " +
				                                 "  end as jbs_3_xx, " +
				                                 "  case WifeGeneralSelf.TakeMedicine when 1 then " + //Ŀǰ�Ƿ��ҩ "3
				                                 "    '0,1,' " +
				                                 "  else " +
				                                 "   '1,0,' " +
				                                 "  end as yys_1_xx, " +
				                                 "  case WifeGeneralSelf.Vaccinate when 1 then " + //�Ƿ�ע�������  "4
				                                 "    '0,' + " +
				                                 "    case when charindex('��������',WifeGeneralSelf.VaccinateOther) > 0 then '1,' else '0,' end + " +
				                                 "    case when charindex('�Ҹ�����',WifeGeneralSelf.VaccinateOther) > 0 then '1,' else '0,' end + '0,' " +
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
												 "	  end as yys_3_xx, " + //���ñ��д�ʩ 5
												 "	  case WifeGeneralSelf.MenstrualCycle when 1 then " + //�¾������Ƿ����6
												 "	    '0,1,' " +
												 "	  else " +
												 "	    '1,0,' " +
												 "	  end as yy_fcyjsflv_xx, " +
												 "	  case WifeGeneralSelf.MPNum " + //�¾���7
												 "	     when 0 then '1,0,0,' " +
												 "	     when 1 then '0,1,0,' " +
												 "	     when 2 then '0,0,1,' " +
												 "	  else " +
												 "	     '0,0,0,' " +
												 "	  end as yy_yjl, " +
												 "	  case WifeGeneralSelf.Dysmenorrhea " + //ʹ��8
												 "	     when '0' then '1,0,0,' " +
												 "	     when '1' then '0,1,0,' " +
												 "	     when '2' then '0,0,1,' " +
												 "	  else " +
												 "	     '0,0,0,' " +
												 "	  end as yy_tt, " +
												 "	  case WifeGeneralSelf.Fetation when 1 then '0,1,' else '1,0,' end as yy_sfcjhy_xx, " + //�Ƿ���������9
												 "	  case WifeGeneralSelf.HAPO when 1 then '0,1,' else '1,0,' end as ys_bljj_xx, " + //-����������10
												 "	  case WifeGeneralSelf.LaborDefect when 1 then '0,1,' else '1,0,' end as yy_csqxe_xx, " + //�Ƿ���������ȱ�ݶ�11
												 "	  case  " +
												 "	     when WifeGeneralSelf.PhysicalCondition = '����' then '1,0,' " +
												 "	     when WifeGeneralSelf.PhysicalCondition = '����' then '0,1,' " +
												 "	  else " +
												 "	     '0,0,' " +
												 "	  end as yy_znstzk_xx, " + //��Ů����״��12
												 "	  case WifeGeneralSelf.Intermarriage when 1 then '0,1,' else '1,0,' end as jzs_1_xx, " + //-�����Ƿ���½��13
												 "	  case WifeGeneralSelf.FamilyMarriage when 1 then '0,1,' else '1,0,' end as jzs_2_xx, " + //���������ڽ��׽��ʷ14
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
												 "	  end as jzs_3_xx, " + //�����Ա�Ƿ����˻����¼���15
												 "	  case WifeGeneralSelf.Raptatorial when 1 then '0,1,' else '0,0,' end as ysyy_1_xx, " + //�Ƿ��ʳ�⡢����16
												 "	  case WifeGeneralSelf.Vegetables when 1 then '0,1,' else '0,0,' end as ysyy_2_xx, " + //�Ƿ���ʳ�߲�17
												 "	  case WifeGeneralSelf.RawMeat when 1 then '0,1,' else '0,0,' end as ysyy_3_xx, " + //�Ƿ���ʳ�������Ⱥ�18
												 "	  case WifeGeneralSelf.Smoke when 1 then '0,1,' else '0,0,' end as ysyy_4_xx, " + //�Ƿ�����19
												 "	  case WifeGeneralSelf.PassiveSmoke when 0 then " +
												 "	     '1,0,0,' " +
												 "	  else " +
												 "	     '0,' + " +
												 "	     case WifeGeneralSelf.SmokeType when 'ż��' then '1,0,' else '0,1,' end " +
												 "	  end as ysyy_5_xx, " + //�Ƿ���ڱ�������20
												 "	  case WifeGeneralSelf.Drink when 0 then " + 
												 "	     '1,0,0,' " +
												 "	  else " +
												 "	     '0,' + " +
												 "	     case WifeGeneralSelf.DrinkingType when 'ż��' then '1,0,' else '0,1,' end " +
												 "	  end as ysyy_6_xx, " + //�Ƿ�����21
												 "	  case WifeGeneralSelf.Drug when 1 then '0,1,' else '0,0,' end as ysyy_7_xx, " + //�Ƿ�ʹ�ö���ҩƷ22
												 "	  case WifeGeneralSelf.Ozostomia when 1 then '0,1,' else '0,0,' end as ysyy_8_xx, " + //�Ƿ�ڳ�23
												 "	  case WifeGeneralSelf.BleedingGums when 1 then '0,1,' else '0,0,' end as ysyy_9_xx, " + //�Ƿ�������Ѫ24
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
												 "	  end as ysyy_10_xx, " + //�Ƿ�Ӵ���������25
												 "	  SUBSTRING(WifeGeneralDoc.WorkPressure,1,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.WorkPressure,2,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.WorkPressure,3,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.WorkPressure,4,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.WorkPressure,5,1) + ',' as shxl_1_xx, " + //�Ƿ�е�����/����ѹ��26
												 "	  SUBSTRING(WifeGeneralDoc.FriendsNervous,1,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.FriendsNervous,2,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.FriendsNervous,3,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.FriendsNervous,4,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.FriendsNervous,5,1) + ',' as shxl_2_xx, " + //������ͬ�¹�ϵ�Ƿ����27
												 "	  SUBSTRING(WifeGeneralDoc.EconomicPressures,1,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.EconomicPressures,2,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.EconomicPressures,3,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.EconomicPressures,4,1) + ',' + " +
												 "	  SUBSTRING(WifeGeneralDoc.EconomicPressures,5,1) + ',' as shxl_3_xx, " + //�Ƿ�е�����ѹ��28
												 "	  case WifeGeneralDoc.PPregnancy when 1 then '0,1,' else '1,0,' end as shxl_4_xx " + //�Ƿ����û���׼��29
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
												 "	  CASE HusGeneralSelf.Disease WHEN 1 THEN "+ //�Ƿ��л������������¼���0
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
												 "	  case HusGeneralSelf.BirthDefect when 1 then "+ //�Ƿ��г���ȱ��1
												 "	    '0,1,' "+
												 "	  else "+
												 "	    '1,0,' "+
												 "	  end as jbs_2_xx, "+
												 "	  case HusGeneralSelf.MDisease when 1 then "+ //�Ƿ��������пƼ���2
												 "	    '0,' + "+
												 "	    case when charindex('غ���ס���غ��',HusGeneralSelf.MDiseaseOther) > 0 then '1,' else '0,' end + "+
												 "	    case when charindex('������������',HusGeneralSelf.MDiseaseOther) > 0 then '1,' else '0,' end + "+
												 "	    case when charindex('����֢',HusGeneralSelf.MDiseaseOther) > 0 then '1,' else '0,' end + "+
												 "	    case when charindex('������',HusGeneralSelf.MDiseaseOther) > 0 then '1,' else '0,' end + '0,' "+
												 "	  else "+
												 "	    '1,0,0,0,0,0,' "+
												 "	  end as jbs_3_xx, "+
												 "	  case HusGeneralSelf.TakeMedicine when 1 then "+ //Ŀǰ�Ƿ��ҩ3
												 "	    '0,1,' "+
												 "	  else "+
												 "	    '1,0,' "+
												 "	  end as yys_1_xx, "+
												 "	  case HusGeneralSelf.Vaccinate when 1 then "+ //�Ƿ�ע�������4
												 "	    '0,' + "+
												 "	    case when charindex('�Ҹ�����',HusGeneralSelf.VaccinateOther) > 0 then '1,' else '0,' end + '0,' "+
												 "	  else "+
												 "	    '1,0,0,' "+
												 "	  end as yys_2_xx, "+
												 "	  case HusGeneralSelf.FamilyMarriage when 1 then '0,1,' else '1,0,' end as jzs_1_xx, "+ //���������ڽ��׽��ʷ5
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
												 "	  end as jzs_2_xx, "+ //�����Ա�Ƿ����˻����¼���6
												 "	  case HusGeneralSelf.Raptatorial when 1 then '0,1,' else '0,0,' end as ysyy_1_xx, "+ //�Ƿ��ʳ�⡢����7
												 "	  case HusGeneralSelf.Vegetables when 1 then '0,1,' else '0,0,' end as ysyy_2_xx, "+ //�Ƿ���ʳ�߲�8
												 "	  case HusGeneralSelf.RawMeat when 1 then '0,1,' else '0,0,' end as ysyy_3_xx, "+ //�Ƿ���ʳ�������Ⱥ�9
												 "	  case HusGeneralSelf.Smoke when 1 then '0,1,' else '0,0,' end as ysyy_4_xx, "+ //�Ƿ�����10
												 "	  case HusGeneralSelf.PassiveSmoke when 0 then "+ 
												 "	     '1,0,0,' "+
												 "	  else "+
												 "	     '0,' + "+
												 "	     case HusGeneralSelf.SmokeType when 'ż��' then '1,0,' else '0,1,' end "+
												 "	  end as ysyy_5_xx, "+ //�Ƿ���ڱ�������11
												 "	  case HusGeneralSelf.Drink when 0 then "+ 
												 "	     '1,0,0,' "+
												 "	  else "+
												 "	     '0,' + "+
												 "	     case HusGeneralSelf.DrinkingType when 'ż��' then '1,0,' else '0,1,' end "+
												 "	  end as ysyy_6_xx, "+ //�Ƿ�����12
												 "	  case HusGeneralSelf.Drug when 1 then '0,1,' else '0,0,' end as ysyy_7_xx, "+ //�Ƿ�ʹ�ö���ҩƷ13
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
												 "	  end as ysyy_8_xx, "+ //�Ƿ�Ӵ���������14
												 "	  SUBSTRING(HusGeneralDoc.WorkPressure,1,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.WorkPressure,2,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.WorkPressure,3,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.WorkPressure,4,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.WorkPressure,5,1) + ',' as shxl_1_xx, "+ //�Ƿ�е�����/����ѹ��15
												 "	  SUBSTRING(HusGeneralDoc.FriendsNervous,1,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.FriendsNervous,2,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.FriendsNervous,3,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.FriendsNervous,4,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.FriendsNervous,5,1) + ',' as shxl_2_xx, "+ //������ͬ�¹�ϵ�Ƿ����16
												 "	  SUBSTRING(HusGeneralDoc.EconomicPressures,1,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.EconomicPressures,2,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.EconomicPressures,3,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.EconomicPressures,4,1) + ',' + "+
												 "	  SUBSTRING(HusGeneralDoc.EconomicPressures,5,1) + ',' as shxl_3_xx, "+ //�Ƿ�е�����ѹ��17
												 "	  case HusGeneralDoc.PPregnancy when 1 then '0,1,' else '1,0,' end as shxl_4_xx "+ //�Ƿ����û���׼��18
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
												 "	  NotifyModuleTerm.ConditionName, "+ //0��������
												 "	  NotifyModuleTerm.Sex, "+ //1�Ա�
												 "	  NotifyModule.Remarks, "+ //2��ϵ
												 "	  NotifyModule.Result, "+ //3���
												 "	  NotifyModuleTerm.SR "+ //4���ɽ��
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
                                                 "   case when (MentalState = '����')  then '0,' else '1,' end + "+ //����״̬
                                                 "   case when (Intelligence = '����') then '0,' else '1,' end + "+ //����
												 "   case when (Facial = '����') then '0,' else '1,' end + "+ //���
												 "      case when (SpecialPosture = '����') then '0,' else '1,' end + "+ //������̬
												 "      case when (FaceSpecial = '����') then '0,' else '1,' end + "+ //��������
												 "      case when (Skin = '����') then '0,' else '1,' end + "+ //Ƥ��ë��
												 "      case when (Thyroid = '����') then '0,' else '1,' end + "+ //��״��
												 "      case when (Lung = '����') then '0,' else '1,' end + "+ //�β�
												 "      case when (HeartRhythm = '��') then '0,' else '1,' end + "+ //��������Ƿ�����
												 "      case when (HeartNoise = '��') then '0,' else '1,' end + "+ //��������
												 "      case when (Liver = 'δ����') then '0,' else '1,' end + "+ //��Ƣ
												 "      case when (Limbs = '����') then '0,' else '1,' end "+  //��֫����
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
												 "    case when (PubicHair = '����')  then '0,' else '1,' end + "+//��ë
												 "    case when (Breast = '����')  then '0,' else '1,' end + "+//�鷿
												 "    case when (Vulva = 'δ���쳣')  then '0,' else '1,' end + "+//����
												 "    case when (Vagina = 'δ���쳣')  then '0,' else '1,' end + "+//����
												 "    case when (Secretion = '����')  then '0,' else '1,' end + "+//�Ƿ������
												 "    case when (Cervix = '�⻬')  then '0,' else '1,' end + "+//����
												 "    case when (WombBigSmall = '����')  then "+
												 "      '0,' "+
												 "    else "+
												 "       case when (WombBigSmall = 'С')  then "+ 
												 "          '1,' "+
												 "       else "+
												 "          '2,' "+
												 "       end "+
												 "    end + "+//�ӹ���С
												 "    case when (WombExercise = '��')  then '0,' else '1,' end + "+//�ӹ��
												 "    case when (WombEM = '��')  then '0,' else '1,' end + "+//�ӹ�����
												 "    case when (WombAccessory = 'δ���쳣')  then '0,' else '1,' end "+//�ӹ�˫�฽��
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
												 "    case when (MentalState = '����')  then '0,' else '1,' end + "+//����״̬
												 "    case when (Intelligence = '����')  then '0,' else '1,' end + "+//����
												 "    case when (Facial = '����')  then '0,' else '1,' end + "+//���
												 "    case when (SpecialPosture = '����')  then '0,' else '1,' end + "+//������̬
												 "    case when (FaceSpecial = '����')  then '0,' else '1,' end + "+//��������
												 "    case when (Skin = '����')  then '0,' else '1,' end + "+//Ƥ��ë��
												 "    case when (Thyroid = '����')  then '0,' else '1,' end + "+//��״��
												 "    case when (Lung = '����')  then '0,' else '1,' end + "+//�β�
												 "    case when (HeartRhythm = '��')  then '0,' else '1,' end + "+//��������Ƿ�����
												 "    case when (HeartNoise = '��')  then '0,' else '1,' end + "+//��������
												 "    case when (Liver = 'δ����')  then '0,' else '1,' end + "+//��Ƣ
												 "    case when (Limbs = '����')  then '0,' else '1,' end "+//��֫����
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
												 "    case when (PubicHair = '����')  then '0,' else '1,' end + "+//��ë
												 "    case when (LaryngealTuberculosis = '��')  then '0,' else '1,' end + "+//���
												 "    case when (Penis = 'δ���쳣')  then '0,' else '1,' end + "+//����
												 "    case when (Wrapping = '����')  then "+ 
												 "       '0,' "+
												 "    else "+
												 "       case when (Wrapping = '����') then "+
												 "          '1,' "+
												 "       else "+
												 "          '2,' "+
												 "       end "+
												 "    end + "+//��Ƥ
												 "    case when (Testicular = '�Ѽ�')  then "+
												 "       '0,' "+
												 "    else "+
												 "       case when (Testicular = '���δ�Ѽ�') then "+
												 "          '1,' "+
												 "       else "+
												 "          '2,' "+
												 "       end "+
												 "    end + "+//غ��
												 "    case when (Epididymis = '����')  then '0,' else '1,' end + "+//��غ
												 "    case when (Vasectomy = 'δ���쳣')  then '0,' else '1,' end + "+//�侫��
												 "    case when (Spermatic = '��')  then '0,' else '1,' end "+//������������
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
		if (XingBie.equals("Ů"))
			query = this.getSession().createSQLQuery("select "+
													 "   FamiliRecordBasicInfo.WrittenDate as date, "+ //����0
													 "   FamiliRecordBasicInfo.WTown, "+ //����1
													 "   FamiliRecordBasicInfo.Wname, "+ //����2
													 "   'Ů' as sex, "+ //�Ա�3
													 "   FamiliRecordBasicInfo.Wage, "+ //����4
													 "   FamiliRecord.WOpDnID, "+ //��Ϻ�5
													 "   FamiliRecordBasicInfo.RecordID "+ //������6
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
					 								 "   '��' as sex, "+
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
		if (XingBie.equals("Ů"))
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
