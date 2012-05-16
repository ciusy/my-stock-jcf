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

		if ("0".equals(statisticsType)) {// �����շ�Աͳ��
			// �����շ�
			List<List<String>> outPatientList = sfMzInvoiceContentDao
					.getOutPatientStatistics(startTime, endTime, costType);
			List<List<String>> townMedicineList = null;

			// סԺ��
			List<List<String>> inPatientList = sfZyInvoiceContentDao
					.getStatistics(startTime, endTime, costType);
			// ǰ̨���������� ȫ��0
			if ("0".equals(costType)) {
				// ������ҩ����
				townMedicineList = sfMzInvoiceContentDao
						.gettMedicineStatistics(startTime, endTime);

				// סԺѺ��
				sfipdepositRecordDao.getIpDesopitRescordStatistics(startTime,
						endTime);

				// Ա����ֵ
				sfCgTableDao.getStatistics(startTime, endTime, "Ա����ֵ");

			}
		}

		if ("1".equals(statisticsType)) {// ���տ�������ͳ��

			// �����շ�
			sfMzInvoiceContentDao.getOutPatientStatisticsByOffice(startTime,
					endTime, costType);
			// סԺ��
			sfZyInvoiceContentDao.getInpatientStatisticsByOffice(startTime,
					endTime, costType);

		}
		if ("2".equals(statisticsType)) {// ���տ���ҽ��ͳ��
			// �����շ�
			sfMzInvoiceContentDao.getOutPatientStatisticsByDoctor(startTime,
					endTime, costType);
			// סԺ��
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
