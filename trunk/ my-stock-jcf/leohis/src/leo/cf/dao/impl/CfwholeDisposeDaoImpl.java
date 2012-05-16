package leo.cf.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cf.dao.iface.CfwholeDisposeDao;
import leo.entity.CfwholeDispose;

public class CfwholeDisposeDaoImpl extends HibernateDaoSupport implements CfwholeDisposeDao {

	public CfwholeDispose getValueOfWholeDisposeByDisposeName(String disposeName) {
		try {
			Query query=this.getSession().createQuery("from CfwholeDispose c where c.disposeName =:disposeName");
			query.setParameter("disposeName", disposeName);
			List<CfwholeDispose> list=query.list();
			return list.get(0);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean changeValueByDisposeName(String disposeName,String cfvalue){   //根据配置项的名称更改该配置项的值。
	try{
		Query query=this.getSession().createQuery("update CfwholeDispose c set c.cfvalue=? where c.disposeName=?  ");
	    query.setParameter(0, cfvalue);
		query.setParameter(1, disposeName);
		query.executeUpdate();
		return true;
	}catch (Exception e) {
		e.printStackTrace();
		
	}return false;
	}
}
