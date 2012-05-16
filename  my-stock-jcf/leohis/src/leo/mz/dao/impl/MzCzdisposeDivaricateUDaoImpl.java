package leo.mz.dao.impl;

import java.util.List;

import leo.entity.CzdisposeDivaricateU;
import leo.mz.dao.iface.MzCzdisposeDivaricateUDao;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MzCzdisposeDivaricateUDaoImpl extends HibernateDaoSupport
		implements MzCzdisposeDivaricateUDao {

	/**
	 * 
	 * ������ĿID��ѯ�������Ҷ���
	 * 
	 * @param ID
	 * 
	 * @return CzdisposeDivaricateU
	 */
	public CzdisposeDivaricateU getCzdById(Long id) {
		CzdisposeDivaricateU czddivaru=(CzdisposeDivaricateU)this.getHibernateTemplate().get(CzdisposeDivaricateU.class, id);
		if(czddivaru!=null){
			return czddivaru;
		}else{
			return null;
		}

	}
	
	/**
	 * 
	 * ɾ��
	 * 
	 * @param ID
	 *            
	 * @return 
	 */
	public void deleCzdisposeDivaricateU(Long id) {
		CzdisposeDivaricateU c=(CzdisposeDivaricateU)super.getHibernateTemplate().get(CzdisposeDivaricateU.class, id);
		super.getHibernateTemplate().delete(c);
	}
	
	/**
	 * 
	 * ���
	 * 
	 * @param CzdisposeDivaricateU ����
	 *            
	 * @return 
	 */
	public void addCzdisposeDivaricateU(CzdisposeDivaricateU c) {
		super.getHibernateTemplate().save(c);
	}
	
	/**
	 * 
	 * ����CzdisposeDivaricateU
	 * 
	 * @param CzdisposeDivaricateU ����
	 *            
	 * @return 
	 */
	public void updateCzdisposeDivaricateU(CzdisposeDivaricateU c) {
		super.getHibernateTemplate().update(c);
		
	}

	public List<CzdisposeDivaricateU> getCzdisposeDivaricateUList(Integer id) {
		String hql="from CzdisposeDivaricateU where itemTypeId=?";
		Query query=super.getSession().createQuery(hql).setParameter(0, id);
		if(query.list().size()>0){
			List<CzdisposeDivaricateU>list= query.list();
			return list;
		}
		return null;
	}

	public void deleCzdisposeDivaricateUByitemTypeId(Integer id) {
		String hql="from CzdisposeDivaricateU where itemTypeId=?";
		Query query=super.getSession().createQuery(hql).setParameter(0, id);
		List<CzdisposeDivaricateU>list=query.list();
		for (CzdisposeDivaricateU u : list) {
			super.getHibernateTemplate().delete(u);
		}
	}
}
