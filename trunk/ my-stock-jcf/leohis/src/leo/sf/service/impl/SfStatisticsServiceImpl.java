package leo.sf.service.impl;

import java.util.List;

import leo.entity.SfipdepositRecord;
import leo.sf.dao.iface.SfAccountDetailDao;
import leo.sf.dao.iface.SfCgTableDao;
import leo.sf.dao.iface.SfMzInvoiceContentDao;
import leo.sf.dao.iface.SfZyInvoiceContentDao;
import leo.sf.dao.iface.SfipdepositRecordDao;
import leo.sf.dao.impl.SfAccountDetailDaoImpl;
import leo.sf.dao.impl.SfipdepositRecordDaoImpl;
import leo.sf.service.iface.SfStatisticsService;

public class SfStatisticsServiceImpl implements SfStatisticsService {

	private SfMzInvoiceContentDao sfMzInvoiceContentDao;

	private SfZyInvoiceContentDao sfZyInvoiceContentDao;

	private SfCgTableDao sfCgTableDao;

	private SfipdepositRecordDao sfipdepositRecordDao;

	public List<List<String>> getStatistics(String startTime, String endTime,
			String statisticsType, String costType) {

		sfMzInvoiceContentDao.deleteStatistics();

		if ("0".equals(statisticsType)) {// 按照收费员统计
			// 门诊收费
			List<List<String>> outPatientList = sfMzInvoiceContentDao
					.getOutPatientStatistics(startTime, endTime, costType);
			List<List<String>> townMedicineList = null;

			// 住院的
			List<List<String>> inPatientList = sfZyInvoiceContentDao
					.getStatistics(startTime, endTime, costType);
			// 前台费用类型是 全部0
			if ("0".equals(costType)) {
				// 乡镇领药交费
				townMedicineList = sfMzInvoiceContentDao
						.gettMedicineStatistics(startTime, endTime);

				// 住院押金
				sfipdepositRecordDao.getIpDesopitRescordStatistics(startTime,
						endTime);

				// 员工充值
				sfCgTableDao.getStatistics(startTime, endTime, "员工充值");

			}
		}

		if ("1".equals(statisticsType)) {// 按照开出科室统计

			// 门诊收费
			sfMzInvoiceContentDao.getOutPatientStatisticsByOffice(startTime,
					endTime, costType);
			// 住院的
			sfZyInvoiceContentDao.getInpatientStatisticsByOffice(startTime,
					endTime, costType);

		}
		if ("2".equals(statisticsType)) {// 按照开出医生统计
			// 门诊收费
			sfMzInvoiceContentDao.getOutPatientStatisticsByDoctor(startTime,
					endTime, costType);
			// 住院的
			sfZyInvoiceContentDao.getInpatientStatisticsByDoctor(startTime,
					endTime, costType);

		}

		return sfMzInvoiceContentDao.getStatistics();

	}

	public void setSfMzInvoiceContentDao(
			SfMzInvoiceContentDao sfMzInvoiceContentDao) {
		this.sfMzInvoiceContentDao = sfMzInvoiceContentDao;
	}

	public void setSfZyInvoiceContentDao(
			SfZyInvoiceContentDao sfZyInvoiceContentDao) {
		this.sfZyInvoiceContentDao = sfZyInvoiceContentDao;
	}

	public void setSfCgTableDao(SfCgTableDao sfCgTableDao) {
		this.sfCgTableDao = sfCgTableDao;
	}

	public void setSfipdepositRecordDao(
			SfipdepositRecordDao sfipdepositRecordDao) {
		this.sfipdepositRecordDao = sfipdepositRecordDao;
	}

}
