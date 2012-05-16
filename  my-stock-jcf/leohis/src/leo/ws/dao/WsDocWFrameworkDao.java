package leo.ws.dao;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.WsdocWframework;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 31, 2011 9:44:52 AM
 */
public interface WsDocWFrameworkDao extends Dao<WsdocWframework> {

	List<WsdocWframework> getWsdocWframeworkByWsDocName(String wsDocName, String componentName);

	List<WsdocWframework> getWsdocWframeworkByWsDocId(Long wsDocId, String componentName);

}
