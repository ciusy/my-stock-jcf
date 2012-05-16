package leo.common.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

public interface Dao<T> {
	/**
	 * 获取记录总数
	 * 
	 * @param entityClass
	 *            实体类
	 * @return
	 */
	public long getCount();

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体id
	 */
	public void save(Object entity);

	/**
	 * 批量保存实体
	 * 
	 * @param entityList
	 */
	public void save(List<T> entityList);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 *            实体id
	 */
	public void update(Object entity);

	/**
	 * 删除实体
	 * 
	 * @param entityClass
	 *            实体类
	 * @param entityids
	 *            实体id数组
	 */
	public void delete(Serializable... entityids);

	/**
	 * 获取实体
	 * 
	 * @param <T>
	 * @param entityClass
	 *            实体类
	 * @param entityId
	 *            实体id
	 * @return
	 */
	public T find(Serializable entityId);

	public List<T> getScrollData(LinkedHashMap<String, String> orderby);

	public List<T> getScrollData(String wherejpql, Object... queryParams);

	public T getSingleData(String wherejpql, Object... queryParams);

	public List<T> getScrollData();

	/**
	 * firstindex=-1 maxresult=-1 说明不需要分页
	 */
	public List<T> getScrollData(final String wherejpql,
			final Object[] queryParams,
			final LinkedHashMap<String, String> orderby);
}
