package leo.cs.dao.iface;

import leo.entity.CsconsumerInfo;

/**
 * 服务对象附加信息Dao接口
 * @author abc
 *
 */
public interface CSConsumerInfoDao {
	/**
	 * 根据服务对象id查询服务对象附加信息
	 * @param csId
	 * @return
	 */
	public CsconsumerInfo getCsconsumerInfoBycsId(Long csId);
	/**
	 * 添加服务对象附加信息
	 * @param csconsumerinfo
	 * @return
	 */
	public boolean addCsconsumerInfo(CsconsumerInfo csconsumerinfo);
	/**
	 * 修改服务对象附加信息
	 * @param csconsumerinfo
	 * @return
	 */
	public boolean updateCsconsumerInfo(CsconsumerInfo csconsumerinfo);
	/**
	 * 删除服务对象附加信息
	 * @param csId
	 * @return
	 */
	public boolean delCsconsumerInfo(Long csId);
}
