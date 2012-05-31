package org.istock.service.base;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.istock.bean.QueryResult;
import org.istock.utils.GenericsUtils;

@SuppressWarnings("unchecked")
public abstract class DaoSupport<T> implements Dao<T> {
	
	protected Log logger = LogFactory.getLog(this.getClass());
	
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this
			.getClass());
	@PersistenceContext
	protected EntityManager em;

	public void clear() {
		em.clear();
	}

	public void delete(Object... entityids) {
		for (Object id : entityids) {
			em.remove(em.getReference(this.entityClass, id));
		}
	}

	public T find(Object entityId) {
		if (entityId == null)
			throw new RuntimeException(this.entityClass.getName()
					+ ":传入的实体id不能为空");
		return em.find(this.entityClass, entityId);
	}

	public void save(Object entity) {
		em.persist(entity);
	}
	
	public void flushSave(Object entity) {
		em.persist(entity);
		em.flush();
	}

	 public void save(List<T> entityList) {
	
	 for (Object obj : entityList) {
	 em.persist(obj);
	 }
		}

	public long getCount() {
		return (Long) em.createQuery(
				"select count(" + getCountField(this.entityClass) + ") from "
						+ getEntityName(this.entityClass) + " o")
				.getSingleResult();
	}

	public void update(Object entity) {
		em.merge(entity);
	}

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			LinkedHashMap<String, String> orderby) {
		return getScrollData(firstindex, maxresult, null, null, orderby, false);
	}

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			LinkedHashMap<String, String> orderby, boolean goToLastPage) {
		return getScrollData(firstindex, maxresult, null, null, orderby,
				goToLastPage);
	}

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			String wherejpql, Object[] queryParams) {
		return getScrollData(firstindex, maxresult, wherejpql, queryParams,
				null, false);
	}

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			String wherejpql, Object[] queryParams, boolean goToLastPage) {
		return getScrollData(firstindex, maxresult, wherejpql, queryParams,
				null, goToLastPage);
	}

	public QueryResult<T> getScrollData(int firstindex, int maxresult) {
		return getScrollData(firstindex, maxresult, null, null, null, false);
	}

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			boolean goToLastPage) {
		return getScrollData(firstindex, maxresult, null, null, null,
				goToLastPage);
	}

	public QueryResult<T> getScrollData() {
		return getScrollData(-1, -1);
	}

	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			String wherejpql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		return getScrollData(firstindex, maxresult, wherejpql, queryParams,
				orderby, false);
	}
	
	/**
	 * 
	 *@author jcf
	 *使用pager-taglib.jar 分页扩展的getScrollData方法
	 *使用SystemContext获取LocalThread存储的offset和pagesize
	 */
	public QueryResult<T> getScrollData(String wherejpql,Object[] queryParams,LinkedHashMap<String, String> orderby, boolean goToLastPage){
		return getScrollData(PagerContext.getOffset(), PagerContext.getPagesize(),
				wherejpql,queryParams,
				orderby,goToLastPage);
	}
	
	public QueryResult<T> getScrollData(String wherejpql){
		return getScrollData(wherejpql,null,null,false);
	}
	
	public QueryResult<T> getScrollData(String wherejpql,Object[] queryParams){
		return getScrollData(wherejpql,queryParams,null,false);
	}
	
	public QueryResult<T> getScrollData(String wherejpql,Object queryParam){
		return getScrollData(wherejpql,new Object[]{queryParam},null,false);
	}
	
	public QueryResult<T> getScrollData(String wherejpql,Object[] queryParams,LinkedHashMap<String, String> orderby){
		return getScrollData(wherejpql,queryParams,orderby,false);
	}
	
	
	public QueryResult<T> getScrollData(String wherejpql,String queryParam,LinkedHashMap<String, String> orderby){
		return getScrollData(wherejpql,new Object[]{queryParam},orderby,false);
	}

	
	/**
	 * firstindex=-1 maxresult=-1 说明不需要分页
	 * firstindex(offset) maxresult(pagesize)
	 */
	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			String wherejpql, Object[] queryParams,
			LinkedHashMap<String, String> orderby, boolean goToLastPage) {
		
		logger.debug("firstindex:"+firstindex+"maxresult:"+maxresult);
		
		QueryResult qr = new QueryResult<T>();
		String entityname = getEntityName(this.entityClass);

		Query query = null;
		if (firstindex != -1 && maxresult != -1) {
			query = em.createQuery("select count("
					+ getCountField(this.entityClass)
					+ ") from "
					+ entityname
					+ " o "
					+ (wherejpql == null || "".equals(wherejpql.trim()) ? ""
							: "where " + wherejpql));
			setQueryParams(query, queryParams);
			qr.setTotalrecord((Long) query.getSingleResult());
		}

		query = em.createQuery("select o from "
				+ entityname
				+ " o "
				+ (wherejpql == null || "".equals(wherejpql.trim()) ? ""
						: "where " + wherejpql) + buildOrderby(orderby));
		setQueryParams(query, queryParams);
		if (firstindex != -1 && maxresult != -1) {

			// 用于分页，当删除的记录是当前页的最后一行(并且当前页只有一条记录)，要跳到上一页
			int totalPages = ((int) (qr.getTotalrecord()) + maxresult - 1)
					/ maxresult;
			if ((qr.getTotalrecord() > 0 && firstindex >= qr.getTotalrecord())
					|| goToLastPage) {
				firstindex = (totalPages - 1) * maxresult;
			}

			query.setFirstResult(firstindex).setMaxResults(maxresult);
		}

		qr.setResultlist(query.getResultList());

		return qr;
	}

	protected static void setQueryParams(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i + 1, queryParams[i]);
			}
		}
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
				orderbyql.append("o.").append(key).append(" ").append(
						orderby.get(key)).append(",");
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
		Entity entity = clazz.getAnnotation(Entity.class);
		if (entity.name() != null && !"".equals(entity.name())) {
			entityname = entity.name();
		}
		return entityname;
	}

	protected static <E> String getCountField(Class<E> clazz) {
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector
					.getBeanInfo(clazz).getPropertyDescriptors();
			for (PropertyDescriptor propertydesc : propertyDescriptors) {
				Method method = propertydesc.getReadMethod();
				if (method != null
						&& method.isAnnotationPresent(EmbeddedId.class)) {
					PropertyDescriptor[] ps = Introspector.getBeanInfo(
							propertydesc.getPropertyType())
							.getPropertyDescriptors();
					out = "o."
							+ propertydesc.getName()
							+ "."
							+ (!ps[1].getName().equals("class") ? ps[1]
									.getName() : ps[0].getName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("------------------:" + out);
		return out;
	}
}
