package leo.bc.dao.iface;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import leo.common.dao.Dao;
import leo.entity.Czdispose;

public interface DisposeDao extends Dao<Czdispose> {
	// public List<Czdispose> getDisposeInfo(int executeU, int fnBlockID, int
	// day, String nowTime);
	public List<Czdispose> getDisposeInfo(int executeU, int day, String nowTime);

	public void setDisposeStatus(String itemid, Long executePerson,
			String executeTime);

	/**
	 * add by xu
	 * 
	 * @param kindId
	 * @param kindType
	 * @return
	 */
	public List<Object[]> getCZ(String kindType, String kind);

	/**
	 * add by xu ���ݴ�����Ŀid�����޸Ķ�Ӧ�ļ�����
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

	public List<Object[]> getCzdisposeByStatusAndTime(List<String> statusList,
			String startTime, String endTime, String officeId);

	/**
	 * ������B�����û�����ִ�У�
	 * 
	 * 
	 */
	// public List<Czdispose> getYet(int executeU, int fnBlockID, int day,
	// String nowTime);
	public List<Czdispose> getYetDisposeInfo(int executeU, String startTime,
			String endTime);

	/**
	 * add by xu
	 * 
	 * @param inpatientId
	 * @param paramList1
	 * @return
	 */
	
	public  String[][]  getStatisticInfo( int executeU,String QueryItem, String startTime,String endTime);
	
	
	public List<Object[]> getZyInpatientProjectPrice(String inpatientId,
			String type, List<String> paramList1);

	/**
	 * add by xu
	 * 
	 * @param inpatientId
	 * @param projectName
	 * @param paramList1
	 * @return
	 */
	public List<List<String>> getInpatientProjectDetail(String inpatientId,
			String projectName, String type, List<String> paramList1);

	/**
	 * add by xu
	 * 
	 * @param inpatientId
	 * @param typeStr
	 * @return
	 */
	public Double getZyReduceMoney(String inpatientId, String typeStr);

	/**
	 * add by xu
	 * 
	 * @param inpatientId
	 * @param paramList1
	 * @return
	 */
	public List<List<String>> getReducePojectDetail(String inpatientId,
			String typeStr, List<String> paramList1);

	/**
	 * add by xu
	 * 
	 * @param kindType
	 * @param kindId
	 * @param status
	 * @return
	 */
	public List<List<String>> getInvoiceCZ(String kindType, String kindId,
			String status);

	/**
	 * add by xu
	 * 
	 * @param disposeApplicationFormIds
	 * @param string
	 */
	public void updateCzDisposeStatus(Set<String> disposeApplicationFormIds,
			String string);

	public Integer getCZCount(String kindTypeId, String kindId, String... status);

}
