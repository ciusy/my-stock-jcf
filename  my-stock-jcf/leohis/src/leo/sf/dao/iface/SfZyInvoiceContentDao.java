package leo.sf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SfzyinvoiceContent;

public interface SfZyInvoiceContentDao extends Dao<SfzyinvoiceContent> {

	List<List<String>> getStatistics(String startTime, String endTime,
			String costType);

	public void testTable() throws Exception;

	void getInpatientStatisticsByOffice(String startTime, String endTime,
			String costType);

	void getInpatientStatisticsByDoctor(String startTime, String endTime,
			String costType);
}
