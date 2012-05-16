package leo.zy.dao.impl;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.ZyippresExecute;
import leo.zy.dao.iface.ZyippresExecuteDao;

public class ZyippresExecuteDaoImpl extends DaoSupport<ZyippresExecute> implements ZyippresExecuteDao {

	public boolean addZyippresExecute(ZyippresExecute zyippresExecute) {
		this.getHibernateTemplate().save(zyippresExecute);
		return true;
	}
	
	public String getMaxID(){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery("select a.executeId from ZyippresExecute a order by a.executeId desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "no";
		else
			return list.get(0);
	}

}
