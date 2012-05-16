package leo.bc.sercive.impl;

import leo.bc.dao.iface.CzshbioIstermDao;
import leo.bc.sercive.iface.CzshbioIstermService;
import leo.entity.CzshbioIsterm;

public class CzshbioIstermServiceImpl implements CzshbioIstermService {
	
	CzshbioIstermDao czshbioIstermDao ;
	

	public void setCzshbioIstermDao(CzshbioIstermDao czshbioIstermDao) {
		this.czshbioIstermDao = czshbioIstermDao;
	}

	public boolean addCzshbioIsterm(CzshbioIsterm czshbioIsterm) {
		
		return czshbioIstermDao.addCzshbioIsterm(czshbioIsterm) ;
		
	}

	public boolean updateCzshbioIsterm(CzshbioIsterm czshbioIsterm) {
		
		return czshbioIstermDao.updateCzshbioIsterm(czshbioIsterm) ;
		
	}

}
