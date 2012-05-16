package leo.cs.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cs.dao.iface.GhMrCGDao;
import leo.entity.GhmrCg;
import leo.gh.dao.iface.GhmrCgDao;

public class GhMrCGDaoImpl extends HibernateDaoSupport implements GhMrCGDao {

	public boolean addGhmrCg(GhmrCg ghmrCg) {
		try{
		this.getHibernateTemplate().save(ghmrCg);
		return true;
		}catch (Exception e) {
			e.printStackTrace();
		}return false;
	}
   public List<GhmrCg> getGhmrCgfortg(long sid, String stdate,String eddate) throws Exception{
	Query query = this
	.getSession()
	.createQuery(
			"from GhmrCg  where (buytime between ? and ?) and sid=? order by buytime desc");
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    query.setDate(0, format.parse(stdate));
    query.setDate(1, format.parse(eddate));
    query.setLong(2, sid);
    List<GhmrCg> list= query.list();
    if (list.size()>0){
    	return list;
    }
    return null;
   }
	public boolean delGhmrCg(GhmrCg ghmrCg) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateGhmrCg(GhmrCg ghmrCg) {
		// TODO Auto-generated method stub
		return false;
	}

}
