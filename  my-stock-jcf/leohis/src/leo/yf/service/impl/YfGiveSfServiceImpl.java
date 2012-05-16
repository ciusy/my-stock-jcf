package leo.yf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import leo.entity.YfexbankAitem;
import leo.entity.YfmexbankA;
import leo.yf.dao.iface.YfExbankAItemDao;
import leo.yf.dao.iface.YfinbankAitemDao;
import leo.yf.dao.iface.YfmexbankADao;
import leo.yf.dao.iface.YfminbankADao;
import leo.yf.service.iface.YfGiveSfService;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 23, 2011 11:56:15 AM
 */
@SuppressWarnings("unchecked")
public class YfGiveSfServiceImpl implements YfGiveSfService {

	private YfExbankAItemDao yfExbankAItemDao;

	private YfmexbankADao yfmexbankADao;

	private YfinbankAitemDao yfinbankAitemDao;

	private YfminbankADao yfminbankADao;

	public List<Object[]> getInvoiceCF(Set<String> aFormIds) {
		return yfExbankAItemDao.getInvoiceCF(aFormIds);
	}

	public List<List<String>> getTownAllocateReturnApplicationBill(
			Integer townId, String status, String applicationBillNO,
			String startTime, String endTime) {
		return yfminbankADao.getTownAllocateApplicationBill(townId, status,
				applicationBillNO, startTime, endTime);

	}

	public List<List<String>> getYfexbankAitemDetail(String applicationFormId) {

		return yfExbankAItemDao.getYfexbankAitemDetail(applicationFormId);
	}

	public List<List<String>> getTownAllocateApplicationBill(Integer townId,
			String status, String applicationBillNO, String startTime,
			String endTime) {
		return yfmexbankADao.getTownAllocateApplicationBill(townId, status,
				applicationBillNO, startTime, endTime);

	}

	public List<List<String>> getReturnPrescription(String outPatientId,
			String status) {

		return yfinbankAitemDao.getReturnPrescription(outPatientId, status);
	}

	/**
	 * 根据一个或者多个出库申请单号查询对应的处方信息
	 * 
	 * @param aFormIDs
	 * @return
	 */
	public List<Object[]> getCF(List<String> aformIDs) {

		return yfExbankAItemDao.getCF(aformIDs);
	}

	public void updateStatusAndReduce(Set<String> formIDs,
			List<Long> itemIDList, List<Double> itemReduce, String costTypeId) {
		yfmexbankADao.updateStatus(formIDs, costTypeId);

		yfExbankAItemDao.updateReduce(itemIDList, itemReduce);

	}

	public YfmexbankA getYFMExbankA(String aformId) {
		return yfmexbankADao.find(aformId);
	}

	public List<Object[]> getInpatientProject(boolean flag, String inpatientId,
			String type, List<String> paramList2) {

		List<String> applicationIds = yfmexbankADao.getIds(inpatientId, type,
				paramList2);
		if (applicationIds.size() < 1) {
			return Collections.EMPTY_LIST;
		}

		List<Object[]> returnlist = null;
		// 不能使用减免
		if (!flag) {
			returnlist = yfExbankAItemDao.getInpatientProject(applicationIds);
		} else {// 是可以使用减免
			List<Object[]> list = null;
			list = yfExbankAItemDao.getDerateInpatientProject(applicationIds);
			Set<String> set = new HashSet<String>();
			for (Object[] objs : list) {
				set.add(objs[0].toString());
			}
			returnlist = new ArrayList<Object[]>();
			// 实收和
			double reduceAllCount = 0d;
			// 实收+减免的=应收的总和
			double reallyAllCount = 0d;
			for (String medicalType : set) {
				for (Object[] objs : list) {
					if (medicalType.equals(objs[0].toString())) {
						// 减免的项目，并且没有退
						if (!objs[1].toString().equals(objs[4].toString())) {
							reduceAllCount += Double.parseDouble(objs[2]
									.toString())
									- Double.parseDouble(objs[3].toString());
							reallyAllCount += Double.parseDouble(objs[2]
									.toString());
						}
					}
				}

				Object[] temps = new Object[4];
				temps[0] = medicalType;
				temps[1] = reduceAllCount;
				temps[2] = "1";
				temps[3] = reallyAllCount;
				returnlist.add(temps);
				reduceAllCount = 0;
			}
		}
		return returnlist.size() < 1 ? Collections.EMPTY_LIST : returnlist;
	}

	public List<List<String>> getInpatientProjectDetail(Boolean isderate,
			String inpatientId, String projectName, String type,
			List<String> paramList2) {
		return yfExbankAItemDao.getInpatientProjectDetail(isderate,
				inpatientId, projectName, type, paramList2);

	}

	public Double getReduceMoney(Boolean isderate, String inpatientId,
			String string) {
		return yfExbankAItemDao.getReduceMoney(isderate, inpatientId, string);
	}

	public List<List<String>> getReducePojectDetail(String inpatientId,
			String typeStr, List<String> paramList2) {
		return yfExbankAItemDao.getReducePojectDetail(inpatientId, typeStr,
				paramList2);
	}

	public void setYfinbankAitemDao(YfinbankAitemDao yfinbankAitemDao) {
		this.yfinbankAitemDao = yfinbankAitemDao;
	}

	public void setYfmexbankADao(YfmexbankADao yfmexbankADao) {
		this.yfmexbankADao = yfmexbankADao;
	}

	public void setYfExbankAItemDao(YfExbankAItemDao yfExbankAItemDao) {
		this.yfExbankAItemDao = yfExbankAItemDao;
	}

	public List<List<String>> getCF(String outPatientId, String status) {
		return yfExbankAItemDao.getCF(outPatientId, status);
	}

	public void setYfminbankADao(YfminbankADao yfminbankADao) {
		this.yfminbankADao = yfminbankADao;
	}

	public void updateStorageApplicationFormStatus(
			Set<String> storageApplicationFormIds, String string) {
		yfminbankADao.updateStorageApplicationFormStatus(
				storageApplicationFormIds, string);
	}

	public int getCFCount(String opnum, String... status) {

		return yfmexbankADao.getCFCount(opnum, status);
	}

	public int getCFReturnCount(String opnum, String... status) {
		return yfminbankADao.getCFReturnCount(opnum, status);
	}

	public void updateYFmbankStatus(Set<String> storageApplicationFormIds,
			String status) {
		yfmexbankADao.updateYFmbankStatus(storageApplicationFormIds, status);

	}

}
