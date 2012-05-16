package leo.mz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import leo.entity.CzdisposeDivaricateU;
import leo.entity.CzdisposeItemDescribe;
import leo.mz.dao.iface.MzCzdisposeItemDescribeDao;

import org.hibernate.Query;
import org.mortbay.log.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MzCzdisposeItemDescribeDaoImpl extends HibernateDaoSupport
		implements MzCzdisposeItemDescribeDao {

	/**
	 * 
	 * 根据ID查询处置项目对象
	 * 
	 * @param ID
	 *            
	 * @return CzdisposeDivaricateU
	 */
	public List<CzdisposeItemDescribe> getCzdById(Long id) {
		String hql="from CzdisposeItemDescribe where medicalInstId=?";
		Query query=super.getSession().createQuery(hql);
		query.setLong(0, id);
		List<CzdisposeItemDescribe> list=query.list();
		if(list!=null || list.size()>0){
			return list;
		}else{
			Log.info("查询值为空");
			return null;
		}
	}

	public void deleCzdisposeItemDescribe(Integer id) {
		CzdisposeItemDescribe c=(CzdisposeItemDescribe)super.getHibernateTemplate().get(CzdisposeItemDescribe.class, id);
		if(c!=null){
			super.getHibernateTemplate().delete(c);
		}
	}

	public void addCzdisposeItemDescribe(CzdisposeItemDescribe c) {
		super.getHibernateTemplate().save(c);
	}

	public void updateCzdisposeItemDescribe(CzdisposeItemDescribe c) {
		super.getHibernateTemplate().update(c);
		
		
	}
	/**
	 * 根据主键查询出一个处置项目描述
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(Integer id) {
		CzdisposeItemDescribe c=(CzdisposeItemDescribe)super.getHibernateTemplate().get(CzdisposeItemDescribe.class, id);
		if(c!=null){
			return c;
		}
		return null;
	}

	public void deleCzdisposeItemDescribebyItemTypeId(Integer id) {
		CzdisposeItemDescribe c=(CzdisposeItemDescribe)super.getHibernateTemplate().get(CzdisposeItemDescribe.class, id);
		if(c!=null){
			String hql="from CzdisposeDivaricateU where itemTypeId=?";
			Query query=super.getSession().createQuery(hql).setParameter(0, id);
			if(query.list().size()>0){
				List<CzdisposeDivaricateU>list=query.list();
				for (CzdisposeDivaricateU u : list) {
					super.getHibernateTemplate().delete(u);
				}
			}
			super.getHibernateTemplate().delete(c);
			
		}
		
	}

	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemName(String name) {
		String hql="from CzdisposeItemDescribe where itemName = ?";
		Query query=super.getSession().createQuery(hql).setParameter(0, name);
		if(query.list().size()>0)
		{
			return (CzdisposeItemDescribe)query.list().get(0);
		}else{
			Log.info("查询值为空");
			return null;
		}
	}

	public List<CzdisposeItemDescribe> getCzdisposeItemDescribeBySepll(String Spell,int Mid) {
		String hql="from CzdisposeItemDescribe where spell like? and medicalInstId=?";
		Query query=super.getSession().createQuery(hql).setParameter(0, "%"+Spell+ "%");
		query.setParameter(1, Mid);
		List<CzdisposeItemDescribe> list = query.list();
		if(list.size()>0)
		{
			return list;
		}else{
			Log.info("查询值为空");
			return null;
		}
	}
	
	public List<CzdisposeItemDescribe> getCZDisposeItemDescribe(String ItemName, String Spell){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (ItemName != null && !ItemName.equals("")) {
			tj = tj + " itemName like ?"; // 项目名称
			cs.add("%" + ItemName + "%");
		}
		if (Spell != null && !Spell.equals("")) {
			if (tj.equals(""))
				tj = " spell like ?";
			else
				tj = tj + " and spell like ?";
			cs.add("%" + Spell + "%");
		}
		List<CzdisposeItemDescribe> list = null;

		if (tj != null && !tj.equals("")) {
			list = this.getHibernateTemplate().find("from CzdisposeItemDescribe where" + tj, cs.toArray());
		} else {
			list = this.getHibernateTemplate().find("from CzdisposeItemDescribe");
		}
		return list;
	}
	
	public String getCZDisposeItemDescribeName(Integer ItemTypeID){
		Query query = null;
		query = this.getSession().createSQLQuery("select ItemName from CZDisposeItemDescribe where ItemTypeID = ?");
		query.setParameter(0, ItemTypeID);
		return query.list().get(0).toString();
	}
	
	public List<CzdisposeItemDescribe> getCZDisposeItemDescribeByNameAndType(String ItemName, String Spell, String DisposeItemType, Integer MedicalInstID){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (ItemName != null && !ItemName.equals("")) {
			tj = tj + " itemName like ?"; // 项目名称
			cs.add("%" + ItemName + "%");
		}
		if (Spell != null && !Spell.equals("")) {
			if (tj.equals(""))
				tj = " spell like ?";
			else
				tj = tj + " and spell like ?";
			cs.add("%" + Spell + "%");
		}
		if (DisposeItemType != null && !DisposeItemType.equals("")) {
			if (tj.equals(""))
				tj = " DisposeItemType = ?";
			else
				tj = tj + " and DisposeItemType = ?";
			cs.add(DisposeItemType);
		}
		if (MedicalInstID != -2) {
			if (tj.equals(""))
				tj = " MedicalInstID = ?";
			else
				tj = tj + " and MedicalInstID = ?";
			cs.add(MedicalInstID);
		}
		
		List<CzdisposeItemDescribe> list = null;

		if (tj != null && !tj.equals("")) {
			list = this.getHibernateTemplate().find("from CzdisposeItemDescribe where" + tj, cs.toArray());
		} else {
			list = this.getHibernateTemplate().find("from CzdisposeItemDescribe");
		}
		return list;
	}

	public Integer getCZDisposeItemDescribeCunZi(String ItemName, Integer MedicalInstID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery("select a.itemTypeId from CzdisposeItemDescribe a where a.itemName = ? and a.medicalInstId = ?");
		query.setParameter(0, ItemName);
		query.setParameter(1, MedicalInstID);
		
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Integer> list = (List<Integer>) query.list();
		if (list.size() < 1)
			return -1;
		else
			return list.get(0);
	}

	public String getReport(Integer ItemTypeID, Integer MedicalInstID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("select report from CZDisposeItemDescribe where ItemTypeID = ? and MedicalInstID = ?");
		query.setParameter(0, ItemTypeID);
		query.setParameter(1, MedicalInstID);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return "";
		else
			return list.get(0);
	}

	public Integer getZhiXingKeShi(Integer ItemTypeID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery(
				"select a.executeU from CzdisposeItemDescribe a where a.itemTypeId = ?");
		query.setParameter(0, ItemTypeID);
		
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Integer> list = (List<Integer>) query.list();
		if (list.size() < 1)
			return -1;
		else
			return list.get(0);
		
	}
	
}
