package leo.ws.dao;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.WsorderItem;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 16, 2011 9:52:49 AM
 */
public interface WsorderItemDao extends Dao<WsorderItem> {

	List<List<String>> getWsorderItemByTemplateId(Long templateId);

	void deleteByTemplateID(Long templateId);

}
