package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Yfmalias;

public interface YfmaliasDao extends Dao<Yfmalias> {
	public List<Yfmalias> getYfmalias(int MInfoID, String AliasName, String SpellCode, int id);
	public boolean addYfmalias(Yfmalias yfmalias);
	public boolean updateYfmalias(Yfmalias yfmalias);
	public boolean delYfmalias(Long id, int MInfoID);
}
