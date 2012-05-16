package leo.yf.service.iface;

import java.util.List;

import leo.entity.Yfmalias;

public interface YfmaliasService {
	public List<Yfmalias> getYfmalias(int MInfoID, String AliasName, String SpellCode, int id);
	public boolean addYfmalias(Yfmalias yfmalias);
	public boolean updateYfmalias(Yfmalias yfmalias);
	public boolean delYfmalias(Long id, int MInfoID);
}
