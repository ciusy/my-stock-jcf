package leo.zy.service.iface;

import java.util.List;

import leo.entity.ZydoctorAdvice;
import leo.entity.Zyinpatient;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 4, 2011 4:20:59 PM
 */
public interface ZyGiveSfService {

	/**
	 * 得到当天，状态是“已入院”的所有服务对象
	 * @param inPatientDeptIds 
	 * @param inPatientStatus 
	 * 
	 * @return
	 */
	public List<Zyinpatient> getCurrentDayInPatient(List<Integer> inPatientDeptIds, String inPatientStatus);

	/**
	 * 
	 * 查找服务对象累计消费的费用得到多个病人的消费总额
	 * @param ipIDS
	 * @return
	 */
	public List<Object[]> getZyredudancyConsume(List<String> ipIDS);

	/**
	 * add by xu
	 * @param inPatientDeptIds 
	 * 
	 * @param consumerIds
	 * 
	 * @param ipId
	 * @param startTime
	 * @param endTime
	 * @param inPatientStatus 
	 * @param bedNo 
	 * @return
	 */
	public List<Zyinpatient> getInpatent(List<Integer> inPatientDeptIds, List<Long> consumerIds, String ipId, String startTime, String endTime, String inPatientStatus, String bedNo);

	/**
	 * 根据多个住院医嘱ids查询所有的医嘱
	 * @param daIds
	 * @return
	 */
	public List<ZydoctorAdvice> getZydoctorAdviceByIds(List<String> daIds);

	public Zyinpatient getInpatinentById(String inpatientId);

	public Zyinpatient updateZyStauts(String inpatientId, boolean b, String string);

}
