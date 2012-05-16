package leo.cf.service.impl;

import leo.cf.dao.iface.CfwholeDisposeDao;
import leo.cf.service.iface.CfwholeDisposeService;
import leo.entity.CfwholeDispose;

public class CfwholeDisposeServiceImpl implements CfwholeDisposeService {
	CfwholeDisposeDao cfwholeDisposeDao;
	
	
	public void setCfwholeDisposeDao(CfwholeDisposeDao cfwholeDisposeDao) {
		this.cfwholeDisposeDao = cfwholeDisposeDao;
	}


	public CfwholeDispose getValueOfWholeDisposeByDisposeName(String disposeName) {
		 return cfwholeDisposeDao.getValueOfWholeDisposeByDisposeName(disposeName);
		 
	}
	public boolean changeValueByDisposeName(String disposeName ,String cfvalue){
		return cfwholeDisposeDao.changeValueByDisposeName(disposeName, cfvalue);
	}
}
