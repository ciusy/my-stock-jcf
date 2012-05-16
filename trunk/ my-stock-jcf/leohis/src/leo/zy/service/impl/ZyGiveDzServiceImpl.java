package leo.zy.service.impl;

import java.util.List;

import leo.entity.Zyinpatient;
import leo.entity.ZynurseGrade;
import leo.zy.dao.iface.ZyInpatientDao;
import leo.zy.dao.iface.ZynurseGradeDao;
import leo.zy.service.iface.ZyGiveDzService;

public class ZyGiveDzServiceImpl implements ZyGiveDzService {
	private ZyInpatientDao zyInpatientDao;
	private ZynurseGradeDao zynurseGradeDao;
	public void setZynurseGradeDao(ZynurseGradeDao zynurseGradeDao){
		this.zynurseGradeDao=zynurseGradeDao;
	}
	public void setZyInpatientDao(ZyInpatientDao zyInpatientDao) {
		this.zyInpatientDao = zyInpatientDao;
	}
	public List<Zyinpatient> getZyinpatientByCsIDandDate(long csId, String st,
			String ed) throws Exception {
		
		return zyInpatientDao.getZyinpatientByCsIDandDate(csId, st, ed);
	}
	public Zyinpatient getZyinpatientByIPID(String ipid) {
		
		return zyInpatientDao.getZyinpatientByIPID(ipid);
	}
	public List<ZynurseGrade> getZynurseGrade(Integer JiBieID,
			String JiBieMingCheng) {
		// TODO Auto-generated method stub
		return zynurseGradeDao.getZynurseGrade(JiBieID, JiBieMingCheng);
	}
	public boolean addZYInpatient(Zyinpatient zyinpatient) {
		// TODO Auto-generated method stub
		return zyInpatientDao.addZYInpatient(zyinpatient);
	}
    
}
