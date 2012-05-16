package leo.zy.service.iface;

import java.util.List;

import leo.entity.Zyinpatient;
import leo.entity.ZynurseGrade;

public interface ZyGiveDzService {
	public List<Zyinpatient> getZyinpatientByCsIDandDate(long csId,String st,String ed) throws Exception;
	public Zyinpatient getZyinpatientByIPID(String ipid);
	public List<ZynurseGrade> getZynurseGrade(Integer JiBieID,
			String JiBieMingCheng);
	public boolean addZYInpatient(Zyinpatient zyinpatient);
}
