package leo.cf.service.iface;

import java.util.List;

import leo.entity.CfmedicalInst;
import leo.entity.Cftown;

/**
 * add by xu
 * 
 * @author Administrator
 * 
 */
public interface CfGiveSfService {

	public void addCfmedicalInst(String outPatientStartNO,
			String inPatientStartNO, Integer medicalInstId);

	public CfmedicalInst getByOrgIdAndKey(Integer orgId, String key);

	public Long getNextInvoiceNO(Integer orgId, String key);

	public List<Cftown> getCfTownsByPrefectureId(Long prefectureId);

}
