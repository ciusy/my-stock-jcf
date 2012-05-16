package leo.yf.service.impl;

import java.util.List;

import leo.entity.Yfmalias;
import leo.yf.dao.iface.YfmaliasDao;
import leo.yf.service.iface.YfmaliasService;

public class YfmaliasServiceImpl implements YfmaliasService {
    private YfmaliasDao yfmaliasDao;
	public List<Yfmalias> getYfmalias(int MInfoID, String AliasName,
			String SpellCode, int id) {
		return yfmaliasDao.getYfmalias(MInfoID, AliasName, SpellCode, id);
	}
	public void setYfmaliasDao(YfmaliasDao yfmaliasDao) {
		this.yfmaliasDao = yfmaliasDao;
	}

	public boolean addYfmalias(Yfmalias yfmalias){
		return yfmaliasDao.addYfmalias(yfmalias);
	};
	
	public boolean updateYfmalias(Yfmalias yfmalias){
		return yfmaliasDao.updateYfmalias(yfmalias);
	};
	
	public boolean delYfmalias(Long id, int MInfoID){
		return yfmaliasDao.delYfmalias(id, MInfoID);
	};
	
}
