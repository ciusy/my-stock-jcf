package leo.cs.dao.iface;

import leo.entity.CsheadShow;

public interface CsheadShowDao {
	public String getCsheadShowById(long id);
	public boolean addCsheadShow(CsheadShow csheadShow);
	public boolean updateCsheadShow(CsheadShow csheadShow);
	public boolean delCsheadShow(CsheadShow csheadShow);
}
