package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.ZyredudancyConsume;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 5, 2011 11:45:58 AM
 */
public interface ZyRedudancyConsumeDao extends Dao<ZyredudancyConsume> {

	List<Object[]> getZyredudancyConsume(List<String> ipIDS);

}
