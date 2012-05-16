package leo.gh.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import leo.common.dao.DaoSupport;
import leo.entity.GhcostType;
import leo.gh.dao.iface.GhcostTypeDao;

import org.hibernate.Query;
import org.hibernate.Session;

public class GhcostTypeDaoImpl extends DaoSupport<GhcostType> implements GhcostTypeDao {
	public List<GhcostType> getAllGhcostTypeByMid(int mid) {
		try {
			Query query = this.getSession().createQuery("from GhcostType gct where gct.medicalInstId=:mid");
			query.setInteger("mid", mid);
			List<GhcostType> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addGhcostType(GhcostType ghcostType) {
		try {
			this.getHibernateTemplate().save(ghcostType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateGhcostType(GhcostType ghcostType) {
		try {
			this.getHibernateTemplate().update(ghcostType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteGhcostType(GhcostType ghcostType) {
		try {
			this.getHibernateTemplate().delete(ghcostType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * add by xu
	 */
	public List<Object[]> getCostTypeGiveGH(List<String> nums) {

		Session session = getSession();

		Query query = session
				.createSQLQuery("select g1.OPNum,g2.CostType,g2.Derate,g2.id  from GHRegister g1 ,GHCostType g2 where g1.CostTypeID=g2.ID and g1.OPNum in(:nums)");
		query.setParameterList("nums", nums);

		return query.list();
	}

	public GhcostType getGhcostTypeByid(int id) {
		try {
			return (GhcostType) this.getHibernateTemplate().get(GhcostType.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Object[]> getConsumers(String consumerName, String idCard, String medicalCard, int flag) {

		StringBuilder sb = new StringBuilder();
		sb.append("select * from csconsumer c");
		if (null != medicalCard && !"".equals(medicalCard.trim())) {

			sb.append(" ,CSMedicalCard c1 where c1.csid=c.csid ");
		} else
			sb.append(" where 1=1 ");

		List<Object> paramsList = new ArrayList<Object>();
		if (null != consumerName && !"".equals(consumerName.trim())) {
			sb.append(flag == 0 ? " and c.NameForShort like ? " : " and c.csname like ?");
			paramsList.add(consumerName.trim() + "%");
		}
		if (null != idCard && !"".equals(idCard.trim())) {
			sb.append(" and c.idcardnum=?");
			paramsList.add(idCard.trim());
		}
		if (null != medicalCard && !"".equals(medicalCard.trim())) {
			sb.append(" and c1.MedicalCardNum=?");
			paramsList.add(medicalCard.trim());
		}

		Session session = getSession();
		Query query = session.createSQLQuery(sb.toString());

		for (int i = 0; i < paramsList.size(); i++) {
			query.setParameter(i, paramsList.get(i));
		}
		return query.list();
	}

	public List<GhcostType> getCostType(Set<Integer> costTypeIds) {

		return getSession().createQuery("from GhcostType g where g.id in (:costTypeIds)").setParameterList("costTypeIds",
				costTypeIds).list();

	}
	
	public List<GhcostType> getCostTypeById(Integer ID, Integer YiLiaoJiGou){
		List<GhcostType> list;
		if (ID == -2){
			list = this.getHibernateTemplate().find("from GhcostType where medicalInstId = ?",YiLiaoJiGou);
		}
		else{
			list = this.getHibernateTemplate().find("from GhcostType where id = ? and medicalInstId = ?",new Object[]{ID,YiLiaoJiGou});
		}
		return list;
		
	}
}
