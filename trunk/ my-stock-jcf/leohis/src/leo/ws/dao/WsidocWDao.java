package leo.ws.dao;

import leo.common.dao.Dao;
import leo.entity.WsidocW;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Sep 15, 2011 12:00:26 PM
 */
public interface WsidocWDao extends Dao<WsidocW> {

	WsidocW findByKindId(String kindId);

}
