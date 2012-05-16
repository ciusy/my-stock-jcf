package leo.cf.service.impl;

import java.util.List;

import leo.cf.dao.iface.CfmedicalInstDao;
import leo.cf.dao.iface.CftownDao;
import leo.cf.service.iface.CfGiveSfService;
import leo.entity.CfmedicalInst;
import leo.entity.Cftown;

/**
 * add by xu
 * 
 * @author Administrator
 * 
 */
public class CfGiveSfServiceImpl implements CfGiveSfService {

	private CfmedicalInstDao cfmedicalInstDao;
	private CftownDao cftownDao;

	public List<Cftown> getCfTownsByPrefectureId(Long prefectureId) {

		return cftownDao.getScrollData("o.prefectureId=?",
				 prefectureId);
	}

	public void addCfmedicalInst(String outPatientStartNO,
			String inPatientStartNO, Integer medicalInstId) {

		CfmedicalInst cfmedicalInst1 = cfmedicalInstDao.getSingleData(
				"o.medicalInstId=? and o.disposeName=?", new Object[] {
						medicalInstId, "���﷢Ʊ��ʼ��" });
		if (null != cfmedicalInst1)
			cfmedicalInstDao.delete(cfmedicalInst1.getDid());

		CfmedicalInst cfmedicalInst2 = cfmedicalInstDao.getSingleData(
				"o.medicalInstId=? and o.disposeName=?", new Object[] {
						medicalInstId, "סԺ��Ʊ��ʼ��" });
		if (null != cfmedicalInst2)
			cfmedicalInstDao.delete(cfmedicalInst2.getDid());
		CfmedicalInst cfmedicalInst = new CfmedicalInst();
		cfmedicalInst.setDisposeName("���﷢Ʊ��ʼ��");
		cfmedicalInst.setCfvalue(outPatientStartNO);
		cfmedicalInst.setMedicalInstId(medicalInstId);
		cfmedicalInstDao.save(cfmedicalInst);
		// ��ʹ�����﷢Ʊ
		if (null != inPatientStartNO && !"".equals(inPatientStartNO)) {
			cfmedicalInst = new CfmedicalInst();
			cfmedicalInst.setDisposeName("סԺ��Ʊ��ʼ��");
			cfmedicalInst.setCfvalue(inPatientStartNO);
			cfmedicalInst.setMedicalInstId(medicalInstId);
			cfmedicalInstDao.save(cfmedicalInst);
		}

	}

	public CfmedicalInst getByOrgIdAndKey(Integer orgId, String key) {

		List<CfmedicalInst> list = cfmedicalInstDao.getScrollData(
				"o.medicalInstId=? and o.disposeName=?", new Object[] { orgId,
						key });

		return list.size() > 0 ? list.get(0) : null;
		
	}

	public Long getNextInvoiceNO(Integer orgId, String key) {
		CfmedicalInst cfmedicalInst = cfmedicalInstDao.getSingleData(
				"o.medicalInstId=? and o.disposeName=?", new Object[] { orgId,
						key });
		return Long.parseLong(cfmedicalInst.getCfvalue()) + 1l;
	}

	public void setCftownDao(CftownDao cftownDao) {
		this.cftownDao = cftownDao;
	}

	public void setCfmedicalInstDao(CfmedicalInstDao cfmedicalInstDao) {
		this.cfmedicalInstDao = cfmedicalInstDao;
	}
}
