package leo.ws.dao;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Wsdocument;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 11, 2011 3:17:18 PM
 */
public interface WsDocumentDao extends Dao<Wsdocument> {

	Wsdocument getByWsDocName(String wsDocName);

	List<List<String>> getWsdocByDocWriteId(Long docWriteId);

}
