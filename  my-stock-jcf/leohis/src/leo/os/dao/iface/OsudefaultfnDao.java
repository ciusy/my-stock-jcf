package leo.os.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.OsfnBlocks;
import leo.entity.OsudefaultFn;

/**
 * 科室默认功能接口
 * @author Administrator
 *
 */
public interface OsudefaultfnDao extends Dao<OsudefaultFn>{
	/**
	 * 根据科室ID查询科室对应的功能
	 * @param uid
	 * @return
	 */
	public List<OsfnBlocks> getFnBlocksByUID(Integer uid);
	/**
	 * 保存科室默认功能
	 * @param osudefaultFn
	 * @return
	 */
	public boolean addOSUDefaultFn(OsudefaultFn osudefaultFn);
	/**
	 * 提取科室对应的功能
	 * @param uid
	 * @return
	 */
	public String[][] getOSUDefaultFn(Integer uid);
	/**
	 * 删除科室对应的功能
	 * @param uid 科室ID
	 * @param FcBlocksID 功能ID
	 * @return
	 */
	public boolean delOSUDefaultFn(Integer uid, Integer FcBlocksID);
	
	
}
