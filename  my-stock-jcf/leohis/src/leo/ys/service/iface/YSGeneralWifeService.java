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
	 * ������ǰ����(����)һ�����(�������)
	 */
	public boolean addWifeGeneralSelf(WifeGeneralSelf wgs);
	
	/*
	 * ������ǰ����(����)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public boolean addWifeGeneralDoc(WifeGeneralDoc wgd);
	
	/*
	 * ������ǰ����(����)һ�����(�����)
	 */
	public boolean addWifeBodyGerneral(WifeBodyGeneral wbg);
	
	/*
	 * ������ǰ����(����)һ�����(����鼴��Ҫҽ�����)
	 */
	public boolean addWifeBodyDoc(WifeBodyDoc wbd);
	
	/*
	 * ������ǰ����(����)�ٴ�����-�״����
	 */
	public boolean addWifeLeucorrheaTest(LeucorrheaTest lt);
	
	/*
	 * ������ǰ����(����)�ٴ�����-Ѫϸ������(Ѫ����)
	 */
	public boolean addWifeBloodCellTest(BloodCellTest bct);
	
	/*
	 * ������ǰ����(����)�ٴ�����-��Һ������
	 */
	public boolean addWifeRoutineUrine(WifeRoutineUrine wru);
	
	/*
	 * ������ǰ����(����)�ٴ�����-Ѫ��
	 */
	public boolean addWifeBloodGroup(WifeBloodGroup wbg);
	
	/*
	 * ������ǰ����(����)�ٴ�����-Ѫ�ǣ�������
	 */
	public boolean addWifeBloodSuger(WifeBloodSuger wbs);
	
	/*
	 * ������ǰ����(����)�ٴ�����-�Ҹ�Ѫ��ѧ���(ø��)
	 */
	public boolean addWifeHepatitisB(WifeHepatitisB whb);
	
	/*
	 * ������ǰ����(����)�ٴ�����-�������ܼ�⣨������
	 */
	public boolean addWifeLiverAndKidney(WifeLiverAndKidney wlk);
	
	/*
	 * ������ǰ����(����)�ٴ�����-��״�ٹ��ܼ��
	 */
	public boolean addWifeThyroidGlandTest(ThyroidGlandTest tgt);
	
	/*
	 * ������ǰ����(����)�ٴ�����-TORCH÷���ܼ��(��ѧ����)
	 */
	public boolean addWifeTorchandSyphilis(TorchandSyphilis ts);
	
	/*
	 * ������ǰ����(����)����B�����
	 */
	public boolean addWifeWomanBC(WomanBc wbc);
	
	/*
	 * ������ǰ����(����)�ٴ�����-�������
	 */
	public boolean addWifeClinicalOthers(WifeClinicalOthers wco);
	
	/*
	 * ���������������(�����Զ��������)
	 */
	public boolean addWifeOthersTest(WifeOthersTest wot);
	
	/*
	 * �޸���ǰ����(����)һ�����(�������)
	 */
	public boolean updateWifeGeneralSelf(WifeGeneralSelf wgs);
	
	/*
	 * ������ǰ����(����)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public boolean updateWifeGeneralDoc(WifeGeneralDoc wgd);
	
	/*
	 * �޸���ǰ����(����)һ�����(�����)
	 */
	public boolean updateWifeBodyGerneral(WifeBodyGeneral wbg);
	
	/*
	 * �޸���ǰ����(����)һ�����(����鼴��Ҫҽ�����)
	 */
	public boolean updateWifeBodyDoc(WifeBodyDoc wbd);
	
	/*
	 * �޸���ǰ����(����)�ٴ�����-�״����
	 */
	public boolean updateWifeLeucorrheaTest(LeucorrheaTest lt);
	
	/*
	 * �޸���ǰ����(����)�ٴ�����-Ѫϸ������(Ѫ����)
	 */
	public boolean updateWifeBloodCellTest(BloodCellTest bct);
	
	/*
	 * �޸���ǰ����(����)�ٴ�����-��Һ������
	 */
	public boolean updateWifeRoutineUrine(WifeRoutineUrine wru);
	
	/*
	 * �޸���ǰ����(����)�ٴ�����-Ѫ��
	 */
	public boolean updateWifeBloodGroup(WifeBloodGroup wbg);
	
	/*
	 * �޸���ǰ����(����)�ٴ�����-Ѫ�ǣ�������
	 */
	public boolean updateWifeBloodSuger(WifeBloodSuger wbs);
	
	/*
	 * �޸���ǰ����(����)�ٴ�����-�Ҹ�Ѫ��ѧ���(ø��)
	 */
	public boolean updateWifeHepatitisB(WifeHepatitisB whb);
	
	/*
	 * �޸���ǰ����(����)�ٴ�����-�������ܼ�⣨������
	 */
	public boolean updateWifeLiverAndKidney(WifeLiverAndKidney wlk);
	
	/*
	 * �޸���ǰ����(����)�ٴ�����-��״�ٹ��ܼ��
	 */
	public boolean updateWifeThyroidGlandTest(ThyroidGlandTest tgt);
	
	/*
	 * �޸���ǰ����(����)�ٴ�����-TORCH÷���ܼ��(��ѧ����)
	 */
	public boolean updateWifeTorchandSyphilis(TorchandSyphilis ts);
	
	/*
	 * �޸���ǰ����(����)����B�����
	 */
	public boolean updateWifeWomanBC(WomanBc wbc);
	
	/*
	 * �޸���ǰ����(����)�ٴ�����-�������
	 */
	public boolean updateWifeClinicalOthers(WifeClinicalOthers wco);
	
	/*
	 * �޸������������(�����Զ��������)
	 */
	public boolean updateWifeOthersTest(WifeOthersTest wot);
	
	/*
	 * ���ݵ������ж���ǰ����(����)һ�����(�������)
	 */
	public boolean existWifeGeneralSelf(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public boolean existWifeGeneralDoc(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)һ�����(�����)
	 */
	public boolean existWifeBodyGerneral(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)һ�����(����鼴��Ҫҽ�����)
	 */
	public boolean existWifeBodyDoc(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-�״����
	 */
	public boolean existWifeLeucorrheaTest(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-Ѫϸ������(Ѫ����)
	 */
	public boolean existWifeBloodCellTest(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-��Һ������
	 */
	public boolean existWifeRoutineUrine(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-Ѫ��
	 */
	public boolean existWifeBloodGroup(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-Ѫ�ǣ�������
	 */
	public boolean existWifeBloodSuger(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-�Ҹ�Ѫ��ѧ���(ø��)
	 */
	public boolean existWifeHepatitisB(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-�������ܼ�⣨������
	 */
	public boolean existWifeLiverAndKidney(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-��״�ٹ��ܼ��
	 */
	public boolean existWifeThyroidGlandTest(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-TORCH÷���ܼ��(��ѧ����)
	 */
	public boolean existWifeTorchandSyphilis(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)����B�����
	 */
	public boolean existWifeWomanBC(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-�������
	 */
	public boolean existWifeClinicalOthers(String strRecordID);

	/*
	 * ���ݵ������ж������������(�����Զ��������)
	 */
	public boolean existWifeOthersTest(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(����)һ�����(�������)
	 */
	public boolean deleteWifeGeneralSelf(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(����)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public boolean deleteWifeGeneralDoc(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(����)һ�����(�����)
	 */
	public boolean deleteWifeBodyGerneral(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(����)һ�����(����鼴��Ҫҽ�����)
	 */
	public boolean deleteWifeBodyDoc(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(����)�ٴ�����-�״����
	 */
	public boolean deleteWifeLeucorrheaTest(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(����)�ٴ�����-Ѫϸ������(Ѫ����)
	 */
	public boolean deleteWifeBloodCellTest(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(����)�ٴ�����-��Һ������
	 */
	public boolean deleteWifeRoutineUrine(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-Ѫ��
	 */
	public boolean deleteWifeBloodGroup(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-Ѫ�ǣ�������
	 */
	public boolean deleteWifeBloodSuger(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-�Ҹ�Ѫ��ѧ���(ø��)
	 */
	public boolean deleteWifeHepatitisB(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-�������ܼ�⣨������
	 */
	public boolean deleteWifeLiverAndKidney(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-��״�ٹ��ܼ��
	 */
	public boolean deleteWifeThyroidGlandTest(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(����)�ٴ�����-TORCH÷���ܼ��(��ѧ����)
	 */
	public boolean deleteWifeTorchandSyphilis(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(����)����B�����
	 */
	public boolean deleteWifeWomanBC(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(����)�ٴ�����-�������
	 */
	public boolean deleteWifeClinicalOthers(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ�������������(�����Զ��������)
	 */
	public boolean deleteWifeOthersTest(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)һ�����(�������)
	 */
	public WifeGeneralSelf getWifeGeneralSelf(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public WifeGeneralDoc getWifeGeneralDoc(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)һ�����(�����)
	 */
	public WifeBodyGeneral getWifeBodyGerneral(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)һ�����(����鼴��Ҫҽ�����)
	 */
	public WifeBodyDoc getWifeBodyDoc(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)�ٴ�����-�״����
	 */
	public LeucorrheaTest getWifeLeucorrheaTest(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)�ٴ�����-Ѫϸ������(Ѫ����)
	 */
	public BloodCellTest getWifeBloodCellTest(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)�ٴ�����-��Һ������
	 */
	public WifeRoutineUrine getWifeRoutineUrine(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)�ٴ�����-Ѫ��
	 */
	public WifeBloodGroup getWifeBloodGroup(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)�ٴ�����-Ѫ�ǣ�������
	 */
	public WifeBloodSuger getWifeBloodSuger(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)�ٴ�����-�Ҹ�Ѫ��ѧ���(ø��)
	 */
	public WifeHepatitisB getWifeHepatitisB(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)�ٴ�����-�������ܼ�⣨������
	 */
	public WifeLiverAndKidney getWifeLiverAndKidney(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)�ٴ�����-��״�ٹ��ܼ��
	 */
	public ThyroidGlandTest getWifeThyroidGlandTest(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)�ٴ�����-TORCH÷���ܼ��(��ѧ����)
	 */
	public TorchandSyphilis getWifeTorchandSyphilis(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)����B�����
	 */
	public WomanBc getWifeWomanBC(String strRecordID);
	
	/*
	 * ��ȡ��ǰ����(����)�ٴ�����-�������
	 */
	public WifeClinicalOthers getWifeClinicalOthers(String strRecordID);
	
	/*
	 * ��ȡ�����������(�����Զ��������)
	 */
	public WifeOthersTest getWifeOthersTest(String strRecordID);
	
	/*
	 * ������ϱ�ź�B�����浥���ƣ���ȡ���ñ��еĴ���ID
	 */
	public String getCZDisposeItemID(String strOpDnID);
	
	/*
	 * ������ϱ�š����浥���ơ�������Ŀ���ƣ���ȡ��Ӧ�Ĵ���ID
	 */
	public String getCZDisposeItemID(String strOpDnID,String strReport,String strItemName);
	
	/*
	 * ���ð״�������Ľ���Ƿ�����(true-����,false-�쳣)
	 */
	public boolean setNormalForLeucorrheaTest(boolean bNormal,String strRecordID);
	
	/*
	 * ����Ѫϸ��������Ľ���Ƿ�����(true-����,false-�쳣)
	 */
	public boolean setNormalForBloodCellTest(boolean bNormal,String strRecordID);
	
	/*
	 * ���øι��ܼ��Ľ���Ƿ�����(true-����,false-�쳣)
	 */
	public boolean setNormalForWifeLiverAndKidneyLiver(boolean bNormal,String strRecordID);
	
	/*
	 * ���������ܼ��Ľ���Ƿ�����(true-����,false-�쳣)
	 */
	public boolean setNormalForWifeLiverAndKidneyKidney(boolean bNormal,String strRecordID);
	
	/*
	 * ���ü�״�ٹ��ܼ��Ľ���Ƿ�����(true-����,false-�쳣)
	 */
	public boolean setNormalForThyroidGlandTest(boolean bNormal,String strRecordID);
	
	/*
	 * �������͸���Ѫ��ѧ����ܼ��Ľ���Ƿ�����(true-����,false-�쳣)
	 */
	public boolean setNormalForWifeHepatitisB(boolean bNormal,String strRecordID);
	
	/*
	 * ����Ѫ��(Ѫ��������)���Ľ���Ƿ�����(true-����,false-�쳣)
	 */
	public boolean setNormalForWifeBloodSuger(boolean bNormal,String strRecordID);
	
	/*
	 * �������֤���ж���ǰ����(����)һ�����(�������)
	 */
	public boolean existWifeGeneralSelfByCardID(String strCardID);
	
	/*
	 * �������֤���ж���ǰ����(����)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public boolean existWifeGeneralDocByCardID(String strCardID);
}
