package leo.bc.sercive.impl;

import leo.bc.dao.iface.CzacontentDao;
import leo.bc.sercive.iface.CzacontentService;
import leo.entity.Czacontent;

public class CzacontentServiceImpl implements CzacontentService {
	CzacontentDao czacontentDao;
	
	
	public void setCzacontentDao(CzacontentDao czacontentDao) {
		this.czacontentDao = czacontentDao;
	}


	public Czacontent getCzacontentByItemId(String itemid) {
		
		return czacontentDao.getCzacontentByItemId(itemid);
		
	}

}
