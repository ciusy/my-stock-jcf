package leo.ws.dao;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.WsdocW1;

/**
 * @author xuxiangpan
 * @version 创建时间：2011-9-21 下午03:46:16
 */
public interface WsDocW1Dao extends Dao<WsdocW1> {

	List<WsdocW1> getWsDocW1ByDocWid(Long docWid);



}
