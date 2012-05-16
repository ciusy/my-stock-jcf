package leo.sf.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.Sfopcg;
import leo.sf.dao.iface.SfopcgDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 21, 2011 4:41:29 PM
 */
@SuppressWarnings("unchecked")
public class SfopcgDaoImpl extends DaoSupport<Sfopcg> implements SfopcgDao {

	public List<Sfopcg> getByOPDiagnoseID(String diagnoseID) {

		return (List<Sfopcg>) getHibernateTemplate().find(
				"from Sfopcg s where s.opdiagnoseId=?", diagnoseID);

		// return (List<Sfopcg>) getHibernateTemplate().get(Sfopcg.class,
		// diagnoseID);
	}
}
