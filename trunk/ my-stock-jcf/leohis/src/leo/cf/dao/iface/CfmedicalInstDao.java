package leo.cf.dao.iface;

import leo.common.dao.Dao;
import leo.entity.CfmedicalInst;

public interface CfmedicalInstDao extends Dao<CfmedicalInst> {
/**
 * �鿴һ��������Ŀ�Ƿ����
 * @param DisposeName ��������
 * @param MedicalInstID ҽ�ƻ���ID
 * @return
 */
public boolean getCFMedicalInstShiFouCiZi(String DisposeName, Integer MedicalInstID);
	
public String getValueBydisposeName(String disposeName,int medicalInstId);
public boolean changeValueBydisposeName(String disposeName,String cfvalue,int medicalInstId);
/**
 * ���ȫ��������Ϣ
 * @param DisposeName ��������
 * @param CFValue ֵ
 * @param MedicalInstID ҽ�ƻ���ID
 * @return
 */
public boolean addCfmedicalInstInfo(String DisposeName, String CFValue, int MedicalInstID);
/**
 * ����ȫ��IDɾ��һ��ȫ��������Ϣ
 * @param id
 * @return
 */
public boolean delCfmedicalInstInfo(Long dId);
public CfmedicalInst getCfmedicalInstBydisposeName(String disposeName,int medicalInstId);
}
