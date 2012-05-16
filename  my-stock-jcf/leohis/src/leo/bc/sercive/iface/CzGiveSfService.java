package leo.bc.sercive.iface;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Jul 22, 2011 4:03:02 PM
 */
public interface CzGiveSfService {

	/**
	 * add by xu ���������������id��ѯ������Ŀ
	 * 
	 * @param kindId
	 * @param kindType
	 * @return
	 */
	public List<Object[]> getCZ(String kindType, String kind);

	/**
	 * ���ݴ�����Ŀid�����޸Ķ�Ӧ�ļ�����
	 * 
	 * @param disposeItemIdList
	 * @param disposeItemReduce
	 * @param main_officesNumber
	 * @param costTypeId
	 * @param nowTimeStamp 
	 * @param personnelNumber 
	 */
	public void updateStatusAndReduce(List<String> disposeItemIdList,
			List<Double> disposeItemReduce, String costTypeId,
			String main_officesNumber, String personnelNumber, Timestamp nowTimeStamp);

	public List<List<String>> getInpatientProjectDetail(String inpatientId,
			String projectName, String type, List<String> paramList1);

	public Double getZyReduceMoney(String inpatientId, String typeStr);

	public List<List<String>> getReducePojectDetail(String inpatientId,
			String typeStr, List<String> paramList1);

	public List<List<String>> getInvoiceCZ(String kindType, String kindId,
			String status);

	public List<Object[]> getZyInpatientProjectPrice(String inpatientId,
			String type, List<String> paramList1);

	public void updateCzDisposeStatus(Set<String> disposeApplicationFormIds,
			String string);

	public Integer getCZCount(String kindTypeId, String kindId,
			String... status);
}
