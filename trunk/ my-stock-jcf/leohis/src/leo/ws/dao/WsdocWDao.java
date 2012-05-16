package leo.ws.dao;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.WsdocW;

/**
 * @author xuxiangpan
 * @version 创建时间：Sep 15, 2011 2:39:34 PM
 */
public interface WsdocWDao extends Dao<WsdocW> {

	List<WsdocW> getWsdocWByDocWriteId(Long docWriteId);

	void deleteByItemDocWIdAndWsOrder(Long itemDocWID, Integer wsOrder,String wstatus);

	WsdocW getByWsdocIdAndItemDocWID(Long docId, Long itemDocWid);

	void deleteObject(WsdocW wsdoW);

	Integer getMaxOrderNO(Long itemDocWid);

}

