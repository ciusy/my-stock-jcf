package leo.cf.service.iface;

import leo.entity.CfmedicalInst;

public interface CfmedicalInstService {
	public     String getValueBydisposeName(String disposeName,int medicalInstId);
	
	public boolean changeValueBydisposeName(String disposeName,String cfvalue,int medicalInstId);
	/**
	 * ����ȫ��IDɾ��һ��ȫ��������Ϣ
	 * @param id
	 * @return
	 */
	public boolean delCfmedicalInstInfo(Long dId);
	
	public CfmedicalInst getCfmedicalInstBydisposeName(String disposeName,
			int medicalInstId);
}
