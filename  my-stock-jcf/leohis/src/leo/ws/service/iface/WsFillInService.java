package leo.ws.service.iface;

import java.util.List;

import leo.entity.WsdocW;
import leo.entity.WsdocW1;
import leo.entity.WsidocW;
import leo.entity.WsvisitRemind;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 18, 2011 9:44:00 AM
 */
public interface WsFillInService {

	/**
	 * �õ� ִ�п��� �ǵ�ǰ��¼���������� ��Ҫ��д������������Ŀ<br>
	 * Ŀǰ�ȶ�Ϊ B������
	 * 
	 * @return
	 */
	public List<List<String>> getWsFillInProject(String officeId);

	/**
	 * ���ݴ��������õ� ִ�п��� �ǵ�ǰ��¼���������� ��Ҫ��д������������Ŀ<br>
	 * 
	 * @param value
	 * @param isSpell
	 * @param startTime
	 * @param endTime
	 * @param officeId
	 * @return
	 */
	public List<List<String>> getWsFillInProject(String value, Boolean isSpell, String startTime, String endTime, String officeId);

	/**
	 * ��������id(��Ŀid(����id))����סԺID���Ҷ�Ӧ����Ŀ������д��¼
	 * 
	 * @param projectId
	 * @return
	 */
	public WsidocW getWsidocWByKindId(String projectId);

	/**
	 * ����������дid���Ҷ�Ӧ�����������¼
	 * 
	 * @param docWriteId
	 * @return
	 */
	public List<List<String>> getWsdocByDocWriteId(Long docWriteId);

	/**
	 * ��� һ�� ��Ŀ������д*��WSIDocW�� �Ͷ�� ������д��WSDocW��
	 * 
	 * @param wsidocW
	 * @param documentIds
	 * @return
	 */
	public Long addDocWrite(WsidocW wsidocW, List<Long> documentIds);

	/**
	 * ɾ��û����д���������飨����delphi��������˳����������жϣ���������µ�
	 * 
	 * @param itemDocWID
	 * @param wsOrder
	 * @param documentIds
	 */
	public void deleteAndAddWsDocW(Long itemDocWID, Integer wsOrder, List<Long> documentIds);

	/**
	 * �޸� ��Ŀ������д ��¼
	 * 
	 * @param wsidocW
	 */
	public void updateWSIDocW(WsidocW wsidocW);

	/**
	 * ���������д�ļ�¼���޸�������д��״̬
	 * 
	 * @param wsdocW1
	 * @param writeStatus
	 */
	public void addWsDocW1(WsdocW1 wsdocW1, Long itemDocWid, String writeStatus);

	/**
	 * ��������iD����Ŀ������д ID�������µ�������д*
	 * 
	 * @param lastDocId
	 * @param docId
	 * @param itemDocWid
	 * 
	 * @return
	 */
	public List<WsdocW1> getWsDocW1(Long lastDocId, Long docId, Long itemDocWid);

	/**
	 * �� ����ID����Ŀ������дIDȷ��Ψһ��������д��¼
	 * 
	 * @param docId
	 * @param itemDocWid
	 * @return
	 */
	public WsdocW getByWsdocIdAndItemDocWID(Long docId, Long itemDocWid);

	/**
	 * ��������˳��ID�����������Ҷ�Ӧ��������Ѽ�¼
	 * 
	 * @param id
	 * @return
	 */
	public WsvisitRemind getWsvisitRemindById(Long id);

	/**
	 * �½�������ѵļ�¼
	 * 
	 * @param wsvisitRemind
	 */
	public void addWsvisitRemind(WsvisitRemind wsvisitRemind);

	// public void updateWsvisitRemind(Long id,WsvisitRemind wsvisitRemind);
	public void updateWsvisitRemind(WsvisitRemind wsvisitRemind);

	/**
	 * 
	 * @param officeId
	 * @return
	 */
	public List<List<String>> getWsFilledProject(String officeId);

	public List<List<String>> getWsFilledProject(String value, Boolean isSpell, String startTime, String endTime,
			String archivesNO, String projectName, String atOfficeNO, String atOfficePostion, String officeId);
}
