package leo.cf.dao.iface;

import java.util.List;

import leo.entity.Cfgroup;

public interface CfgroupDao {
	public List<Cfgroup> getAllCfgroupsByVilleageId(long villeageId);//输入所在的村id，返回所有的组
	public Cfgroup getCfgroupByCfgroupId(long  groupId);
	/**
	 * 删除组
	 * @param VillageID 乡ID
	 */
	public boolean delCFGroup(long VillageID);
}
