package leo.ys.service.impl;

import java.util.List;

import leo.entity.BirthDefects;
import leo.ys.service.iface.YSChuShengQueXianService;
import leo.ys.dao.iface.YSBirthDefectsDao;

public class YSChuShengQueXianServiceImpl implements YSChuShengQueXianService {
	private YSBirthDefectsDao ySBirthDefectsDao;

	public void setySBirthDefectsDao(YSBirthDefectsDao ySBirthDefectsDao) {
		this.ySBirthDefectsDao = ySBirthDefectsDao;
	}

	public List<BirthDefects> getChuShengQueXian(String RecordID){
		return ySBirthDefectsDao.getBirthDefects(RecordID);
	}

	public boolean addChuShengQueXian(BirthDefects birthDefects){
		return ySBirthDefectsDao.addBirthDefects(birthDefects);
	}

	public boolean updateChuShengQueXian(BirthDefects birthDefects){
		return ySBirthDefectsDao.updateBirthDefects(birthDefects);
	}
	
}
