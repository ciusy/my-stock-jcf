package leo.sf.dao.impl;

import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.SfreduceTable;
import leo.entity.Yfminfo;
import leo.sf.dao.iface.SfreduceTableDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 27, 2011 3:42:38 PM
 */
public class SfreduceTableDaoImpl extends DaoSupport<SfreduceTable> implements SfreduceTableDao {

	public List<SfreduceTable> getByMInfoID(HashSet<Integer> MInfoIDSet) {

		return getSession().createQuery("from SfreduceTable s where s.minfoId in (:MInfoIDSet)")
				.setParameterList("MInfoIDSet", MInfoIDSet).list();

	}

	public SfreduceTable getSfreduceTableByMInfoID(int minfoId, int costtypeId) {
		Query query = this.getSession().createQuery("from SfreduceTable where minfoId=? and ptype=?");
		query.setInteger(0, minfoId);
		query.setInteger(1, costtypeId);
		List<SfreduceTable> list = query.list();
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public SfreduceTable getBySingle(Integer costTypeId, String projectName) {

		return (SfreduceTable) getSession()
				.createQuery("from SfreduceTable s ,Yfminfo y where s.minfoId= y.minfoId and s.ptype=? and y.mtype=?")
				.setParameter(0, costTypeId).setParameter(1, projectName).uniqueResult();
	}

}
