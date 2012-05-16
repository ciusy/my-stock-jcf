package leo.yf.dao.iface;

import java.util.List;
import java.util.Set;

import leo.common.dao.Dao;
import leo.entity.YfexbankAitem;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 23, 2011 11:34:32 AM
 */
public interface YfExbankAItemDao extends Dao<YfexbankAitem> {

	/**
	 * 根据一个或者多个出库申请单号查询对应的处方信息
	 * 
	 * @param aFormIDs
	 * @return
	 */
	public List<Object[]> getCF(List<String> aformIDs);

	/**
	 * 根据项目的ID集合修改对应 的减免金额
	 * 
	 * @param itemIDList
	 * @param itemReduce
	 */
	public void updateReduce(List<Long> itemIDList, List<Double> itemReduce);

	public boolean addYfexbankAitem(List<YfexbankAitem> yfexbankAitem); // 增加出库单项目

	public boolean delYFExbankAItem(String AFormID); // 按照申请单ID删除项目

	/**
	 * 按照申请单号提取申请内容
	 * 
	 * @param AFormID
	 * @return
	 */
	public List<YfexbankAitem> getYfexbankAitem(String AFormID);

	/**
	 * 根据主键查询出库申请项
	 * 
	 * @param itemId
	 * @return
	 */
	public YfexbankAitem getYfexbankAitemByitemId(Long itemId);

	public List<YfexbankAitem> getYfexbankAitemByAFormID(String aformID, int mid);

	public boolean updateYfexbankAitem(YfexbankAitem yfexbankAitem);

	/**
	 * add by xu
	 * 
	 * @param applicationIds
	 * @return
	 */
	public List<Object[]> getInpatientProject(List<String> applicationIds);

	/**
	 * add by xu
	 * 
	 * @param applicationIds
	 * @return
	 */
	public List<Object[]> getDerateInpatientProject(List<String> applicationIds);

	/**
	 * add by xu
	 * 
	 * @param isderate
	 * 
	 * @param inpatientId
	 * @param projectName
	 * @param paramList2
	 * @return
	 */
	public List<List<String>> getInpatientProjectDetail(Boolean isderate,
			String inpatientId, String projectName, String type,
			List<String> paramList2);

	/**
	 * add by xu
	 * 
	 * @param isderate
	 * @param inpatientId
	 * @param string
	 * @return
	 */
	public Double getReduceMoney(Boolean isderate, String inpatientId,
			String string);

	/**
	 * add by xu
	 * 
	 * @param inpatientId
	 * @param paramList2
	 * @return
	 */
	public List<List<String>> getReducePojectDetail(String inpatientId,
			String typeStr, List<String> paramList2);

	/**
	 * add by xu
	 * 
	 * @param oPDiagnoseID
	 * @param type
	 * @return
	 */
	public List<List<String>> getCF(String outPatientId, String status);

	/**
	 * 修改出库单的退药信息
	 * 
	 * @param AFormID
	 *            出库单号
	 * @param MID
	 *            药品ID
	 * @param NumReturned
	 *            已退数量
	 * @param PReturned
	 *            已退价格
	 * @return
	 */
	public boolean updateYFExbankAItemTuiYao(String AFormID, Integer MID,
			Integer NumReturned, Double PReturned);

	/**
	 * add by xu
	 * 
	 * @param applicationFormId
	 * @return
	 */
	public List<List<String>> getYfexbankAitemDetail(String applicationFormId);

	/**
	 * 根据出库单ID和药品ID删除一条记录
	 * 
	 * @param AFormID
	 *            出库单ID
	 * @param MID
	 *            药品ID
	 * @return
	 */
	public boolean delYFExbankAItemByAFormIDMID(String AFormID, Integer MID);

	/**
	 * add by xu
	 * 
	 * @param aFormIds
	 * @return
	 */
	public List<Object[]> getInvoiceCF(Set<String> aFormIds);

}
