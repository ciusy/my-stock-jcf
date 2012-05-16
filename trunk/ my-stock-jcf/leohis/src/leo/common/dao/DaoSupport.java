package leo.common.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import leo.common.util.GenericsUtils;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@SuppressWarnings("unchecked")
public abstract class DaoSupport<T> extends HibernateDaoSupport implements
		Dao<T> {
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this
			.getClass());

	public void delete(Serializable... entityids) {
		for (Object id : entityids) {
			getHibernateTemplate().delete(
					getHibernateTemplate().get(this.entityClass,
							(Serializable) id));
		}
	}

	public T find(Serializable entityId) {
		if (entityId == null)
			throw new RuntimeException(this.entityClass.getName()
					+ ":传入的实体id不能为空");
		return (T) getHibernateTemplate().get(this.entityClass, entityId);
	}

	public void save(Object entity) {
		getHibernateTemplate().save(entity);
	}

	public void save(List<T> entityList) {

		for (Object obj : entityList) {
			getHibernateTemplate().save(obj);
		}
	}

	public long getCount() {
		Object count = this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery("select count("
								+ getCountField(entityClass) + ") from "
								+ getEntityName(entityClass) + " o");

						return query.iterate().next();
					}
				});

		return (Long) count;

	}

	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * add by xu 把List<Object[]>转换成String[][]
	 * 
	 * @param list
	 * @return
	 */
	protected String[][] listObject2StringString(List<Object[]> list) {
		int rows = list.size();
		if (rows > 0) {
			int columns = ((Object[]) list.get(0)).length;
			String[][] strings = new String[rows][columns];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++)
					strings[i][j] = String.valueOf(((Object[]) list.get(i))[j]);
			}
			return strings;
		}
		return new String[0][0];

	}

	/**
	 * add by xu 把List<Object[]>转换成List<List<String>>
	 * 
	 * @param list
	 * @return
	 */
	protected List<List<String>> listObject2ListString(List<Object[]> list) {

		if (null == list && list.size() < 1)
			return Collections.EMPTY_LIST;
		List<List<String>> returnList = new ArrayList<List<String>>();
		List<String> list2 = null;

		for (Object[] objects : list) {

			list2 = new ArrayList<String>();
			for (Object object : objects) {
				list2.add(object.toString());
			}
			returnList.add(list2);

		}

		return returnList;
	}

	public List<T> getScrollData(LinkedHashMap<String, String> orderby) {
		return getScrollData(null, null, orderby);
	}

	public List<T> getScrollData(String wherejpql, Object... queryParams) {
		return getScrollData(wherejpql, queryParams, null);
	}

	public List<T> getScrollData() {
		return getScrollData(null, null, null);
	}

	/**
	 * firstindex=-1 maxresult=-1 说明不需要分页
	 */
	public List<T> getScrollData(final String wherejpql,
			final Object[] queryParams,
			final LinkedHashMap<String, String> orderby) {
		List qr = new ArrayList<T>();
		final String entityname = getEntityName(this.entityClass);

		qr = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select o from "
						+ entityname
						+ " o "
						+ (wherejpql == null || "".equals(wherejpql.trim()) ? ""
								: "where " + wherejpql) + buildOrderby(orderby));

				setQueryParams(query, queryParams);

				return (ArrayList<T>) query.list();
			}
		});

		return qr;
	}

	protected static void setQueryParams(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i, queryParams[i]);
			}
		}
	}

	public T getSingleData(String wherejpql, Object... queryParams) {

		final String entityname = getEntityName(this.entityClass);
		Query query = getSession()
				.createQuery(
						"select o from "
								+ entityname
								+ " o "
								+ (wherejpql == null
										|| "".equals(wherejpql.trim()) ? ""
										: "where " + wherejpql));
		setQueryParams(query, queryParams);
		return (T) query.uniqueResult();

	}

	/**
	 * 组装order by语句
	 * 
	 * @param orderby
	 * @return
	 */
	protected static String buildOrderby(LinkedHashMap<String, String> orderby) {
		StringBuffer orderbyql = new StringBuffer("");
		if (orderby != null && orderby.size() > 0) {
			orderbyql.append(" order by ");
			for (String key : orderby.keySet()) {
				orderbyql.append("o.").append(key).append(" ")
						.append(orderby.get(key)).append(",");
			}
			orderbyql.deleteCharAt(orderbyql.length() - 1);
		}
		return orderbyql.toString();
	}

	/**
	 * 获取实体的名称
	 * 
	 * @param <E>
	 * @param clazz
	 *            实体类
	 * @return
	 */
	protected static <E> String getEntityName(Class<E> clazz) {
		String entityname = clazz.getSimpleName();
		return entityname;
	}

	protected static <E> String getCountField(Class<E> clazz) {
		String out = "o";
		System.out.println("ssssssssssssssssss:" + out);
		return out;
	}
}
