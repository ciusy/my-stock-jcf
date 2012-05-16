package leo.sf.dao.iface;

import java.util.HashSet;
import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SfreduceItem;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 27, 2011 11:42:43 AM
 */
public interface SfReduceItemDao extends Dao<SfreduceItem>{

	/**
	 * 根据一个或者多个项目类型的ids得到减免项目表
	 * 
	 * @param itemTypeIDList
	 * @return
	 */
	public List<SfreduceItem> getByItemTypeID(HashSet<Integer> itemTypeIDList);
	/**
	 * 根据项目ID和费用类型ID取减免项目
	 * @param itemtypeID
	 * @param costtypeID
	 * @return
	 */
	public 	SfreduceItem getSfreduceItemByItemTypeIDandcosttypeID(int itemtypeID ,int costtypeID);
	/**
	 * add by xu 
	 * @param costTypeId
	 * @param projectName
	 * @return
	 */
	public SfreduceItem getBySingle(Integer costTypeId, String projectName);

}

