package leo.cf.dao.iface;

import leo.common.dao.Dao;
import leo.entity.CfmedicalInst;

public interface CfmedicalInstDao extends Dao<CfmedicalInst> {
/**
 * 查看一个设置项目是否存在
 * @param DisposeName 配置名称
 * @param MedicalInstID 医疗机构ID
 * @return
 */
public boolean getCFMedicalInstShiFouCiZi(String DisposeName, Integer MedicalInstID);
	
public String getValueBydisposeName(String disposeName,int medicalInstId);
public boolean changeValueBydisposeName(String disposeName,String cfvalue,int medicalInstId);
/**
 * 添加全局配置信息
 * @param DisposeName 配置名称
 * @param CFValue 值
 * @param MedicalInstID 医疗机构ID
 * @return
 */
public boolean addCfmedicalInstInfo(String DisposeName, String CFValue, int MedicalInstID);
/**
 * 根据全局ID删除一条全局配置信息
 * @param id
 * @return
 */
public boolean delCfmedicalInstInfo(Long dId);
public CfmedicalInst getCfmedicalInstBydisposeName(String disposeName,int medicalInstId);
}
