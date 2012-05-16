package leo.ws.dao;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.WsdocWorderFramework;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 12, 2011 2:47:58 PM
 */
public interface WsDocWOrderFrameworkDao extends Dao<WsdocWorderFramework> {

	List<List<String>> getWsDocOfTemplate(Long templateId);

	List<List<String>> getWsDocOfTemplateByItemTypeId(Long itemTypeId);

}
