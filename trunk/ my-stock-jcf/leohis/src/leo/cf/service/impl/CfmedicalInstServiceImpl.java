package leo.cf.service.impl;

import leo.cf.dao.iface.CfmedicalInstDao;
import leo.cf.service.iface.CfmedicalInstService;
import leo.entity.CfmedicalInst;

public class CfmedicalInstServiceImpl implements CfmedicalInstService {
	CfmedicalInstDao cfmedicalInstDao;
	
	

	public void setCfmedicalInstDao(CfmedicalInstDao cfmedicalInstDao) {
		this.cfmedicalInstDao = cfmedicalInstDao;
	}

	public boolean changeValueBydisposeName(String disposeName, String cfvalue,
			int medicalInstId) {
		return cfmedicalInstDao.changeValueBydisposeName(disposeName, cfvalue, medicalInstId);
		
	}

	public String getValueBydisposeName(String disposeName,int medicalInstId) {
		
		return cfmedicalInstDao.getValueBydisposeName(disposeName,medicalInstId);
		
	}
	/**
	 * 删除一条全局配置
	 */
	public boolean delCfmedicalInstInfo(Long dId) {
		// TODO Auto-generated method stub
		return cfmedicalInstDao.delCfmedicalInstInfo(dId);
	}

	public CfmedicalInst getCfmedicalInstBydisposeName(String disposeName,
			int medicalInstId) {
		// TODO Auto-generated method stub
		return cfmedicalInstDao.getCfmedicalInstBydisposeName(disposeName, medicalInstId);
	}
}
