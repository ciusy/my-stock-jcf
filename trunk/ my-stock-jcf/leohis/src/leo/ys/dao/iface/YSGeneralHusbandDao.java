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
	 * ������ǰ����(�ɷ�)һ�����(�������)
	 */
	public boolean addHusGeneralSelf(HusGeneralSelf hgs);
	
	/*
	 * ������ǰ����(�ɷ�)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public boolean addHusGeneralDoc(HusGeneralDoc hgd);
	
	/*
	 * ������ǰ����(�ɷ�)һ�����(�����)
	 */
	public boolean addHusBodyGeneral(HusBodyGeneral hbg);
	
	/*
	 * ������ǰ����(�ɷ�)һ�����(����鼴��Ҫҽ�����)
	 */
	public boolean addHusBodyDoc(HusBodyDoc hbd);
	
	/*
	 * ������ǰ����(�ɷ�)�ٴ�����-Ѫ��
	 */
	public boolean addHusBloodGroup(HusBloodGroup hbg);
	
	/*
	 *������ǰ����(�ɷ�)�ٴ�����-��Һ������ 
	 */
	public boolean addHusRoutineUrine(HusRoutineUrine hru);
	
	/*
	 * ������ǰ����(�ɷ�)�ٴ�����-÷��������ɸ��(��ѧ����)
	 */
	public boolean addHusSyphilis(HusSyphilis hs);
	
	/*
	 * ������ǰ����(�ɷ�)�ٴ�����-�Ҹ�Ѫ��ѧ���(ø��)
	 */
	public boolean addHusHepatitisB(HusHepatitisB hhb);
	
	/*
	 * ������ǰ����(�ɷ�)�ٴ�����-�������ܼ�⣨������
	 */
	public boolean addHusLiverAndKidney(HusLiverAndKidney hlk);
	
	/*
	 * ������ǰ����(�ɷ�)�ٴ�����-�������
	 */
	public boolean addHusClinicalOthers(HusClinicalOthers hco);
	
	/*
	 * �����ɷ��������(�����Զ��������)
	 */
	public boolean addHusOthersTest(HusOthersTest hot);
	
	/*
	 * �޸���ǰ����(�ɷ�)һ�����(�������)
	 */
	public boolean updateHusGeneralSelf(HusGeneralSelf hgs);
	
	/*
	 * �޸���ǰ����(�ɷ�)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public boolean updateHusGeneralDoc(HusGeneralDoc hgd);
	
	/*
	 * �޸���ǰ����(�ɷ�)һ�����(�����)
	 */
	public boolean updateHusBodyGeneral(HusBodyGeneral hbg);
	
	/*
	 * �޸���ǰ����(�ɷ�)һ�����(����鼴��Ҫҽ�����)
	 */
	public boolean updateHusBodyDoc(HusBodyDoc hbd);
	
	/*
	 * �޸���ǰ����(�ɷ�)�ٴ�����-Ѫ��
	 */
	public boolean updateHusBloodGroup(HusBloodGroup hbg);
	
	/*
	 *�޸���ǰ����(�ɷ�)�ٴ�����-��Һ������ 
	 */
	public boolean updateHusRoutineUrine(HusRoutineUrine hru);
	
	/*
	 * �޸���ǰ����(�ɷ�)�ٴ�����-÷��������ɸ��(��ѧ����)
	 */
	public boolean updateHusSyphilis(HusSyphilis hs);
	
	/*
	 * �޸���ǰ����(�ɷ�)�ٴ�����-�Ҹ�Ѫ��ѧ���(ø��)
	 */
	public boolean updateHusHepatitisB(HusHepatitisB hhb);
	
	/*
	 * �޸���ǰ����(�ɷ�)�ٴ�����-�������ܼ�⣨������
	 */
	public boolean updateHusLiverAndKidney(HusLiverAndKidney hlk);
	
	/*
	 * �޸���ǰ����(�ɷ�)�ٴ�����-�������
	 */
	public boolean updateHusClinicalOthers(HusClinicalOthers hco);
	
	/*
	 * �޸��ɷ��������(�����Զ��������)
	 */
	public boolean updateHusOthersTest(HusOthersTest hot);
	
	/*
	 * ���ݵ������ж���ǰ����(�ɷ�)һ�����(�������)
	 */
	public boolean existHusGeneralSelf(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(�ɷ�)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public boolean existHusGeneralDoc(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(�ɷ�)һ�����(�����)
	 */
	public boolean existHusBodyGeneral(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(�ɷ�)һ�����(����鼴��Ҫҽ�����)
	 */
	public boolean existHusBodyDoc(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(�ɷ�)�ٴ�����-Ѫ��
	 */
	public boolean existHusBloodGroup(String strRecordID);
	
	/*
	 *���ݵ������ж���ǰ����(�ɷ�)�ٴ�����-��Һ������ 
	 */
	public boolean existHusRoutineUrine(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(�ɷ�)�ٴ�����-÷��������ɸ��(��ѧ����)
	 */
	public boolean existHusSyphilis(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(�ɷ�)�ٴ�����-�Ҹ�Ѫ��ѧ���(ø��)
	 */
	public boolean existHusHepatitisB(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(�ɷ�)�ٴ�����-�������ܼ�⣨������
	 */
	public boolean existHusLiverAndKidney(String strRecordID);
	
	/*
	 * ���ݵ������ж���ǰ����(�ɷ�)�ٴ�����-�������
	 */
	public boolean existHusClinicalOthers(String strRecordID);
	
	/*
	 * ���ݵ������ж��ɷ��������(�����Զ��������)
	 */
	public boolean existHusOthersTest(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(�ɷ�)һ�����(�������)
	 */
	public boolean deleteHusGeneralSelf(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(�ɷ�)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public boolean deleteHusGeneralDoc(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(�ɷ�)һ�����(�����)
	 */
	public boolean deleteHusBodyGeneral(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(�ɷ�)һ�����(����鼴��Ҫҽ�����)
	 */
	public boolean deleteHusBodyDoc(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(�ɷ�)�ٴ�����-Ѫ��
	 */
	public boolean deleteHusBloodGroup(String strRecordID);
	
	/*
	 *���ݵ�����ɾ����ǰ����(�ɷ�)�ٴ�����-��Һ������ 
	 */
	public boolean deleteHusRoutineUrine(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(�ɷ�)�ٴ�����-÷��������ɸ��(��ѧ����)
	 */
	public boolean deleteHusSyphilis(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(�ɷ�)�ٴ�����-�Ҹ�Ѫ��ѧ���(ø��)
	 */
	public boolean deleteHusHepatitisB(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(�ɷ�)�ٴ�����-�������ܼ�⣨������
	 */
	public boolean deleteHusLiverAndKidney(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ����ǰ����(�ɷ�)�ٴ�����-�������
	 */
	public boolean deleteHusClinicalOthers(String strRecordID);
	
	/*
	 * ���ݵ�����ɾ���ɷ��������(�����Զ��������)
	 */
	public boolean deleteHusOthersTest(String strRecordID);
	
	/*
	 * ���ݵ����Ż�ȡ��ǰ����(�ɷ�)һ�����(�������)
	 */
	public HusGeneralSelf getHusGeneralSelf(String strRecordID);
	
	/*
	 * ���ݵ����Ż�ȡ��ǰ����(�ɷ�)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public HusGeneralDoc getHusGeneralDoc(String strRecordID);
	
	/*
	 * ���ݵ����Ż�ȡ��ǰ����(�ɷ�)һ�����(�����)
	 */
	public HusBodyGeneral getHusBodyGeneral(String strRecordID);
	
	/*
	 * ���ݵ����Ż�ȡ��ǰ����(�ɷ�)һ�����(����鼴��Ҫҽ�����)
	 */
	public HusBodyDoc getHusBodyDoc(String strRecordID);
	
	/*
	 * ���ݵ����Ż�ȡ��ǰ����(�ɷ�)�ٴ�����-Ѫ��
	 */
	public HusBloodGroup getHusBloodGroup(String strRecordID);
	
	/*
	 *���ݵ����Ż�ȡ��ǰ����(�ɷ�)�ٴ�����-��Һ������ 
	 */
	public HusRoutineUrine getHusRoutineUrine(String strRecordID);
	
	/*
	 * ���ݵ����Ż�ȡ��ǰ����(�ɷ�)�ٴ�����-÷��������ɸ��(��ѧ����)
	 */
	public HusSyphilis getHusSyphilis(String strRecordID);
	
	/*
	 * ���ݵ����Ż�ȡ��ǰ����(�ɷ�)�ٴ�����-�Ҹ�Ѫ��ѧ���(ø��)
	 */
	public HusHepatitisB getHusHepatitisB(String strRecordID);
	
	/*
	 * ���ݵ����Ż�ȡ��ǰ����(�ɷ�)�ٴ�����-�������ܼ�⣨������
	 */
	public HusLiverAndKidney getHusLiverAndKidney(String strRecordID);
	
	/*
	 * ���ݵ����Ż�ȡ��ǰ����(�ɷ�)�ٴ�����-�������
	 */
	public HusClinicalOthers getHusClinicalOthers(String strRecordID);	
	
	/*
	 * ���ݵ����Ż�ȡ�ɷ��������(�����Զ��������)
	 */
	public HusOthersTest getHusOthersTest(String strRecordID);
	
	/*
	 * ���øι��ܼ��Ľ���Ƿ�����(true-����,false-�쳣)
	 */
	public boolean setNormalForHusLiverAndKidneyLiver(boolean bNormal,String strRecordID);
	
	/*
	 * ���������ܼ��Ľ���Ƿ�����(true-����,false-�쳣)
	 */
	public boolean setNormalForHusLiverAndKidneyKidney(boolean bNormal,String strRecordID);
		
	/*
	 * �������͸���Ѫ��ѧ����ܼ��Ľ���Ƿ�����(true-����,false-�쳣)
	 */
	public boolean setNormalForHusHepatitisB(boolean bNormal,String strRecordID);
	
	/*
	 * �������֤���ж���ǰ����(�ɷ�)һ�����(�������)
	 */
	public boolean existHusGeneralSelfByCardID(String strCardID);
	
	/*
	 * �������֤���ж���ǰ����(�ɷ�)һ�����(ҽ��ѯ�ʵ������������)
	 */
	public boolean existHusGeneralDocByCardID(String strCardID);
}
