package leo.sf.dao.iface;

import java.util.HashSet;
import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SfreduceTable;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 27, 2011 3:42:18 PM
 */
public interface SfreduceTableDao extends Dao<SfreduceTable> {

	/**
	 * 根据一个或者多个药品信息ids查询对应的减免表的信息
	 * 
	 * @param MInfoIDSet
	 * @return
	 */
	public List<SfreduceTable> getByMInfoID(HashSet<Integer> MInfoIDSet);
	/**
	 * 根据药品信息id和费用类型查询减免表
	 * @param minfoId
	 * @param costtypeId
	 * @return
	 */
	public SfreduceTable getSfreduceTableByMInfoID(int minfoId , int costtypeId);
	public SfreduceTable getBySingle(Integer costTypeId, String projectName);

}
