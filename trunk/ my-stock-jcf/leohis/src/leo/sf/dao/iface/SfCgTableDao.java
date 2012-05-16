package leo.sf.dao.iface;

import java.sql.Timestamp;

import leo.common.dao.Dao;
import leo.entity.SfcgTable;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 29, 2011 5:08:25 PM
 */
public interface SfCgTableDao extends Dao<SfcgTable> {

	/**
	 * 得到最大的ID 没有返回null
	 */
	public String getMaxCSID();

	/**
	 * 
	 * @param cashPay
	 * @param personnelNumber
	 * @param realMoeny
	 * @param officesNumber
	 * @param nowTimeStamp
	 * @param idofTableLocateIn
	 * @param tableLocateIn
	 * @param cgType
	 * @return
	 */
	public SfcgTable saveSfCgTable(String cashPay, String personnelNumber, String realMoeny, String officesNumber,
			Timestamp nowTimeStamp, String idofTableLocateIn, String cgType, String tableLocateIn);

	public void getStatistics(String startTime, String endTime,String type);

}
