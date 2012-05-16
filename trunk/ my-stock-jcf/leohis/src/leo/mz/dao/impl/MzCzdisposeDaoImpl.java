package leo.mz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import leo.common.util.DateUtil;
import leo.entity.Czdispose;
import leo.mz.dao.iface.MzCzdisposeDao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 门诊处置项实现
 * 
 * @author abc
 * 
 */
public class MzCzdisposeDaoImpl extends HibernateDaoSupport implements
		MzCzdisposeDao {
	/**
	 * 门诊添加处置项
	 */
	public boolean addCzdispose(Czdispose czd) {
		super.getHibernateTemplate().save(czd);
		return true;
	}

	/**
	 * 门诊删除处置项
	 */
	public boolean delCzdispose(Czdispose czd) {
		// TODO Auto-generated method stub
		try {
			super.getHibernateTemplate().delete(czd);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据主键查询处置项
	 */
	public Czdispose getCzdisposeByitemId(String itemId) {
		try {
			return (Czdispose) super.getHibernateTemplate().get(
					Czdispose.class, itemId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getMaxitemId() {
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery(
				"select a.itemId from Czdispose a order by a.itemId desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "no";
		else
			return list.get(0);

	}

	public List<Czdispose> getCzdisposeByKindID(String kindId) {

		Session session = super.getSession();
		Query query = session.createQuery("from Czdispose where kindId=?");
		query.setString(0, kindId);
		//System.out.println(query.list().size());
		if(query.list().size() > 0)			
			return query.list();
		else
			return null;

	}
	public List<Czdispose> getZhuYuan(String ZhuYuanHao, String ShenQiShiJian_B, String ShenQiShiJian_E, String ZhuangTai){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")){
			tj = tj + " kindId = ?"; //住院号
			cs.add(ZhuYuanHao);
		}
		if (ShenQiShiJian_B != null && !ShenQiShiJian_B.equals("")){ //申请时间
			if (tj.equals("")) 
				tj = " atime >= ? and atime <= ?";
			else
				tj = tj + " and atime >= ? and atime <= ?"; 
			cs.add(DateUtil.stringToDateTime(ShenQiShiJian_B));
			cs.add(DateUtil.stringToDateTime(ShenQiShiJian_E));
		}
		if (ZhuangTai != null && !ZhuangTai.equals("")){
			if (tj.equals("")) 
				tj = " status = ?";
			else
				tj = tj + " and status = ?"; 
			cs.add(ZhuangTai);
		}
		List<Czdispose> list = null;
		
		if (tj != null && !tj.equals("")){
			list = this.getHibernateTemplate().find("from Czdispose where" + tj,cs.toArray());
		}
		else{	
			list = this.getHibernateTemplate().find("from Czdispose");
		}
		return list;
	}

	public boolean delCzdisposeZY(String ItemID){
		Query query = null;
		query = this.getSession().createSQLQuery(
				"delete from Czdispose where ItemID = ?");
		query.setParameter(0, ItemID);
		query.executeUpdate();
		return true;
	}
	public Double getChuZhiZhuYuanZongJinE(String ZhuYuanHao){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("select " +
				                                 "  ISNULL(sum(RealP),0) as je " +
				                                 "from " +
				                                 "  CZDispose " +
				                                 "where " +
				                                 "  KindID = ? and " +
				                                 "  AKind = '住院申请' and " +
				                                 "  Status = '已执行'");
		query.setParameter(0, ZhuYuanHao);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Double> list = (List<Double>) query.list();
		if (list.size() < 1)
			return 0d;
		else
			return list.get(0);
	}

}
