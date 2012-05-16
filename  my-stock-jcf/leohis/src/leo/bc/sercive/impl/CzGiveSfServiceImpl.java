package leo.bc.sercive.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import leo.bc.dao.iface.DisposeDao;
import leo.bc.sercive.iface.CzGiveSfService;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 22, 2011 4:03:23 PM
 */
public class CzGiveSfServiceImpl implements CzGiveSfService {
	private DisposeDao disposeDao;

	/**
	 * add by xu
	 */
	public List<Object[]> getCZ(String kindType, String kind) {
		return disposeDao.getCZ(kindType, kind);
	}

	public void setDisposeDao(DisposeDao disposeDao) {
		this.disposeDao = disposeDao;
	}

	public void updateStatusAndReduce(List<String> disposeItemIdList,
			List<Double> disposeItemReduce, String costTypeId,
			String main_officesNumber, String personnelNumber,
			Timestamp nowTimeStamp) {

		disposeDao.updateStatusAndReduce(disposeItemIdList, disposeItemReduce,
				costTypeId, main_officesNumber, personnelNumber, nowTimeStamp);
	}

	public List<Object[]> getZyInpatientProjectPrice(String inpatientId,
			String type, List<String> paramList1) {

		return disposeDao.getZyInpatientProjectPrice(inpatientId, type,
				paramList1);
	}

	public List<List<String>> getInpatientProjectDetail(String inpatientId,
			String projectName, String type, List<String> paramList1) {
		return disposeDao.getInpatientProjectDetail(inpatientId, projectName,
				type, paramList1);
	}

	public Double getZyReduceMoney(String inpatientId, String typeStr) {
		return disposeDao.getZyReduceMoney(inpatientId, typeStr);
	}

	public List<List<String>> getReducePojectDetail(String inpatientId,
			String typeStr, List<String> paramList1) {
		return disposeDao.getReducePojectDetail(inpatientId, typeStr,
				paramList1);
	}

	public List<List<String>> getInvoiceCZ(String kindType, String kindId,
			String status) {
		return disposeDao.getInvoiceCZ(kindType, kindId, status);
	}

	public void updateCzDisposeStatus(Set<String> disposeApplicationFormIds,
			String string) {
		disposeDao.updateCzDisposeStatus(disposeApplicationFormIds, string);
	}

	public Integer getCZCount(String kindTypeId, String kindId,
			String... status) {
		return disposeDao.getCZCount(kindTypeId, kindId, status);
	}

}
