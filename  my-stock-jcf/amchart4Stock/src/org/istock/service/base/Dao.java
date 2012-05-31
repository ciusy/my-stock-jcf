package org.istock.service.base;

import java.util.LinkedHashMap;
import java.util.List;

import org.istock.bean.QueryResult;

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
	 * 清除一级缓存的数据
	 */
	public void clear();

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体id
	 */
	public void save(Object entity);
	
	/**
	 * flush save 脱离transaction的立即保存
	 */
	public void flushSave(Object object);

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
	public void delete(Object... entityids);

	/**
	 * 获取实体
	 * 
	 * @param <Test>
	 * @param entityClass
	 *            实体类
	 * @param entityId
	 *            实体id
	 * @return
	 */
	public T find(Object entityId);

	/**
	 * 获取分页数据
	 * 
	 * @param <Test>
	 * @param entityClass
	 *            实体类
	 * @param firstindex
	 *            开始索引
	 * @param maxresult
	 *            需要获取的记录数
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			String wherejpql, Object[] queryParams,
			LinkedHashMap<String, String> orderby, boolean goToLastPage);

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			String wherejpql, Object[] queryParams,
			LinkedHashMap<String, String> orderby);

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			String wherejpql, Object[] queryParams);

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			String wherejpql, Object[] queryParams, boolean goToLastPage);

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			LinkedHashMap<String, String> orderby);

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			LinkedHashMap<String, String> orderby, boolean goToLastPage);

	public QueryResult<T> getScrollData(int firstindex, int maxresult);

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			boolean goToLastPage);

	public QueryResult<T> getScrollData();
}
