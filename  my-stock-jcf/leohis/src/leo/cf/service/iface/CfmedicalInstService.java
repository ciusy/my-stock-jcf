package leo.cf.service.iface;

import leo.entity.CfmedicalInst;

public interface CfmedicalInstService {
	public     String getValueBydisposeName(String disposeName,int medicalInstId);
	
	public boolean changeValueBydisposeName(String disposeName,String cfvalue,int medicalInstId);
	/**
	 * 根据全局ID删除一条全局配置信息
	 * @param id
	 * @return
	 */
	public boolean delCfmedicalInstInfo(Long dId);
	
	public CfmedicalInst getCfmedicalInstBydisposeName(String disposeName,
			int medicalInstId);
}
