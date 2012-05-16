package leo.sf.service.iface;

import java.util.List;

public interface SfStatisticsService {

	public List<List<String>> getStatistics(String startTime, String endTime,
			String statisticsType, String costType);

}
