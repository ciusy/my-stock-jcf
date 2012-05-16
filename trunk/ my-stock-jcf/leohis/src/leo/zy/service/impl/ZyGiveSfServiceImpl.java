package leo.zy.service.impl;

import java.util.List;

import leo.entity.ZydoctorAdvice;
import leo.entity.Zyinpatient;
import leo.zy.dao.iface.ZyInpatientDao;
import leo.zy.dao.iface.ZyRedudancyConsumeDao;
import leo.zy.dao.iface.ZydoctorAdviceDao;
import leo.zy.service.iface.ZyGiveSfService;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 4, 2011 4:21:56 PM
 */
public class ZyGiveSfServiceImpl implements ZyGiveSfService {

	private ZyRedudancyConsumeDao zyRedudancyConsumeDao;
	private ZyInpatientDao zyInpatientDao;

	private ZydoctorAdviceDao zydoctorAdviceDao;

	public void setZyInpatientDao(ZyInpatientDao zyInpatientDao) {
		this.zyInpatientDao = zyInpatientDao;
	}

	public List<Zyinpatient> getCurrentDayInPatient(
			List<Integer> inPatientDeptIds, String inPatientStatus) {

		return zyInpatientDao.getCurrentDayInPatient(inPatientDeptIds,
				inPatientStatus);
	}

	public void setZydoctorAdviceDao(ZydoctorAdviceDao zydoctorAdviceDao) {
		this.zydoctorAdviceDao = zydoctorAdviceDao;
	}

	public void setZyRedudancyConsumeDao(
			ZyRedudancyConsumeDao zyRedudancyConsumeDao) {
		this.zyRedudancyConsumeDao = zyRedudancyConsumeDao;
	}

	public List<Object[]> getZyredudancyConsume(List<String> ipIDS) {
		return zyRedudancyConsumeDao.getZyredudancyConsume(ipIDS);
	}

	public List<Zyinpatient> getInpatent(List<Integer> inPatientDeptIds,
			List<Long> consumerIds, String ipId, String startTime,
			String endTime, String inPatientStatus, String bedNo) {

		return zyInpatientDao.getInpatient(inPatientDeptIds, consumerIds, ipId,
				startTime, endTime, inPatientStatus, bedNo);

	}

	public List<ZydoctorAdvice> getZydoctorAdviceByIds(List<String> daIds) {

		return zydoctorAdviceDao.getZydoctorAdviceByIds(daIds);
	}

	public Zyinpatient getInpatinentById(String inpatientId) {
		return zyInpatientDao.find(inpatientId);
	}

	public Zyinpatient updateZyStauts(String inpatientId, boolean b,
			String string) {
		return zyInpatientDao.updateZyStauts(inpatientId, true, "已出院");
	}
}
