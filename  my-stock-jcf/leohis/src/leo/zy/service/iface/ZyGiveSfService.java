package leo.zy.service.iface;

import java.util.List;

import leo.entity.ZydoctorAdvice;
import leo.entity.Zyinpatient;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 4, 2011 4:20:59 PM
 */
public interface ZyGiveSfService {

	/**
	 * �õ����죬״̬�ǡ�����Ժ�������з������
	 * @param inPatientDeptIds 
	 * @param inPatientStatus 
	 * 
	 * @return
	 */
	public List<Zyinpatient> getCurrentDayInPatient(List<Integer> inPatientDeptIds, String inPatientStatus);

	/**
	 * 
	 * ���ҷ�������ۼ����ѵķ��õõ�������˵������ܶ�
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
	 * ���ݶ��סԺҽ��ids��ѯ���е�ҽ��
	 * @param daIds
	 * @return
	 */
	public List<ZydoctorAdvice> getZydoctorAdviceByIds(List<String> daIds);

	public Zyinpatient getInpatinentById(String inpatientId);

	public Zyinpatient updateZyStauts(String inpatientId, boolean b, String string);

}
