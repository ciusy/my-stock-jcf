package leo.mz.service.iface;

import java.util.List;

import leo.entity.MzopDn;

/**
 * 
 * @author xuxiangpan
 * 
 */
public interface MzGiveSfService {

	/**
	 * 
	 * add by xu 得到当天待收费的所有诊断对象
	 * 
	 * @param officeId
	 *            当前登录者的科室ID
	 * @return
	 */
	public List<MzopDn> getNowDayMZop(Integer officeId);

	/**
	 * add by xu 根据服务对象的id 的集合得到所有的待收费的本科室的所有的诊断对象
	 * 
	 * @param consumerIds
	 * @param startTime
	 * @param endTime
	 * @param officeId 
	 * @return
	 */
	public List<MzopDn> getMzopDn(List<Long> consumerIds, String startTime, String endTime, int officeId);

	/**
	 * add by xu<br>
	 * 修改门诊诊断的状态为status值
	 * 
	 * @param diagnoseID
	 * @param status
	 */
	public void updateMZOpDnStatus(String diagnoseID, String status);

	/**
	 * 根据门诊诊断ID查找对应的诊断信息 add by xu
	 * 
	 * @param ids
	 * @return
	 */
	public List<MzopDn> getMzopDnByIDs(List<String> ids);

}
