package leo.cs.dao.iface;

import java.util.List;

import leo.entity.GhmrCg;

public interface GhMrCGDao {
	public boolean addGhmrCg(GhmrCg ghmrCg);
	public List<GhmrCg> getGhmrCgfortg(long sid, String stdate,String eddate) throws Exception;
}
