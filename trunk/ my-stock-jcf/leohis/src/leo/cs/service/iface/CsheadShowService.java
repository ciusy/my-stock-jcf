package leo.cs.service.iface;

import leo.entity.CsheadShow;

public interface CsheadShowService {
	public boolean addCsheadShow(long id,byte[] bytes,String name);
	public boolean delCsheadShow(CsheadShow csheadShow);
	public boolean updateCsheadShow(long id,byte[] bytes,String name);
	public String getCsheadShowById(long id);
}
