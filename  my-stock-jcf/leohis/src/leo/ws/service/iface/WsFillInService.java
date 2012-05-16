package leo.ws.service.iface;

import java.util.List;

import leo.entity.WsdocW;
import leo.entity.WsdocW1;
import leo.entity.WsidocW;
import leo.entity.WsvisitRemind;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 18, 2011 9:44:00 AM
 */
public interface WsFillInService {

	/**
	 * 得到 执行科室 是当前登录者所属科室 的要填写的手术文书项目<br>
	 * 目前先定为 B超科室
	 * 
	 * @return
	 */
	public List<List<String>> getWsFillInProject(String officeId);

	/**
	 * 根据传入条件得到 执行科室 是当前登录者所属科室 的要填写的手术文书项目<br>
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
	 * 根据种类id(项目id(处置id))或者住院ID查找对应的项目文书填写记录
	 * 
	 * @param projectId
	 * @return
	 */
	public WsidocW getWsidocWByKindId(String projectId);

	/**
	 * 根据文书填写id查找对应的所有文书记录
	 * 
	 * @param docWriteId
	 * @return
	 */
	public List<List<String>> getWsdocByDocWriteId(Long docWriteId);

	/**
	 * 添加 一个 项目文书填写*（WSIDocW） 和多个 文书填写（WSDocW）
	 * 
	 * @param wsidocW
	 * @param documentIds
	 * @return
	 */
	public Long addDocWrite(WsidocW wsidocW, List<Long> documentIds);

	/**
	 * 删除没有填写的所有文书（根据delphi传过来的顺序号来进行判断），再添加新的
	 * 
	 * @param itemDocWID
	 * @param wsOrder
	 * @param documentIds
	 */
	public void deleteAndAddWsDocW(Long itemDocWID, Integer wsOrder, List<Long> documentIds);

	/**
	 * 修改 项目文书填写 记录
	 * 
	 * @param wsidocW
	 */
	public void updateWSIDocW(WsidocW wsidocW);

	/**
	 * 添加文书填写的记录和修改文书填写的状态
	 * 
	 * @param wsdocW1
	 * @param writeStatus
	 */
	public void addWsDocW1(WsdocW1 wsdocW1, Long itemDocWid, String writeStatus);

	/**
	 * 根据文书iD和项目文书填写 ID查找最新的文书填写*
	 * 
	 * @param lastDocId
	 * @param docId
	 * @param itemDocWid
	 * 
	 * @return
	 */
	public List<WsdocW1> getWsDocW1(Long lastDocId, Long docId, Long itemDocWid);

	/**
	 * 由 文书ID和项目文书填写ID确定唯一的文书填写记录
	 * 
	 * @param docId
	 * @param itemDocWid
	 * @return
	 */
	public WsdocW getByWsdocIdAndItemDocWID(Long docId, Long itemDocWid);

	/**
	 * 根据文书顺序ID（主键）查找对应的随访提醒记录
	 * 
	 * @param id
	 * @return
	 */
	public WsvisitRemind getWsvisitRemindById(Long id);

	/**
	 * 新建随访提醒的记录
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
