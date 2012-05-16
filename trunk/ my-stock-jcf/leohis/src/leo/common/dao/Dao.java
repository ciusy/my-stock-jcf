package leo.common.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

public interface Dao<T> {
	/**
	 * ��ȡ��¼����
	 * 
	 * @param entityClass
	 *            ʵ����
	 * @return
	 */
	public long getCount();

	/**
	 * ����ʵ��
	 * 
	 * @param entity
	 *            ʵ��id
	 */
	public void save(Object entity);

	/**
	 * ��������ʵ��
	 * 
	 * @param entityList
	 */
	public void save(List<T> entityList);

	/**
	 * ����ʵ��
	 * 
	 * @param entity
	 *            ʵ��id
	 */
	public void update(Object entity);

	/**
	 * ɾ��ʵ��
	 * 
	 * @param entityClass
	 *            ʵ����
	 * @param entityids
	 *            ʵ��id����
	 */
	public void delete(Serializable... entityids);

	/**
	 * ��ȡʵ��
	 * 
	 * @param <T>
	 * @param entityClass
	 *            ʵ����
	 * @param entityId
	 *            ʵ��id
	 * @return
	 */
	public T find(Serializable entityId);

	public List<T> getScrollData(LinkedHashMap<String, String> orderby);

	public List<T> getScrollData(String wherejpql, Object... queryParams);

	public T getSingleData(String wherejpql, Object... queryParams);

	public List<T> getScrollData();

	/**
	 * firstindex=-1 maxresult=-1 ˵������Ҫ��ҳ
	 */
	public List<T> getScrollData(final String wherejpql,
			final Object[] queryParams,
			final LinkedHashMap<String, String> orderby);
}
