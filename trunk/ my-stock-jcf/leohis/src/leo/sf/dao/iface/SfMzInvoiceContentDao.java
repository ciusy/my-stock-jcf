package leo.sf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SfmzinvoiceContent;

public interface SfMzInvoiceContentDao extends Dao<SfmzinvoiceContent> {

	List<List<String>> getOutPatientStatistics(String startTime,
			String endTime, String costType);

	List<List<String>> gettMedicineStatistics(String startTime, String endTime);

	List<List<String>> getStatistics();

	void deleteStatistics();

	void getOutPatientStatisticsByOffice(String startTime, String endTime,
			String costType);

	void getOutPatientStatisticsByDoctor(String startTime, String endTime,
			String costType);

}
