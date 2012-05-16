package leo.sf.service.impl;

import java.util.List;

import leo.entity.SftownAllocate;
import leo.sf.dao.iface.SftownAllocateDao;
import leo.sf.service.iface.SftownAllocateService;


public class SftownAllocateServiceImpl implements SftownAllocateService {
	private SftownAllocateDao sftownAllocateDao;
	
	public List<SftownAllocate> getSftownAllocate(Integer TownID,
			Integer MedicalInstitution) {
		return sftownAllocateDao.getSftownAllocate(TownID, MedicalInstitution);
		
	}

	public void setSftownAllocateDao(SftownAllocateDao sftownAllocateDao) {
		this.sftownAllocateDao = sftownAllocateDao;
	}

}
