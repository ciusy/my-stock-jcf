package leo.cf.dao.iface;

import java.util.List;

import leo.entity.Cfgroup;

public interface CfgroupDao {
	public List<Cfgroup> getAllCfgroupsByVilleageId(long villeageId);//�������ڵĴ�id���������е���
	public Cfgroup getCfgroupByCfgroupId(long  groupId);
	/**
	 * ɾ����
	 * @param VillageID ��ID
	 */
	public boolean delCFGroup(long VillageID);
}
