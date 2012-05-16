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
	 * add by xu �õ�������շѵ�������϶���
	 * 
	 * @param officeId
	 *            ��ǰ��¼�ߵĿ���ID
	 * @return
	 */
	public List<MzopDn> getNowDayMZop(Integer officeId);

	/**
	 * add by xu ���ݷ�������id �ļ��ϵõ����еĴ��շѵı����ҵ����е���϶���
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
	 * �޸�������ϵ�״̬Ϊstatusֵ
	 * 
	 * @param diagnoseID
	 * @param status
	 */
	public void updateMZOpDnStatus(String diagnoseID, String status);

	/**
	 * �����������ID���Ҷ�Ӧ�������Ϣ add by xu
	 * 
	 * @param ids
	 * @return
	 */
	public List<MzopDn> getMzopDnByIDs(List<String> ids);

}
