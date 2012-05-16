package leo.os.dao.impl;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.OsfnBlocks;
import leo.entity.Osuform;
import leo.os.dao.iface.OsfnBlocksDao;

public class OsfnBlocksDaoImpl extends DaoSupport<OsfnBlocks> implements OsfnBlocksDao {

	public boolean addOsfnBlocks(OsfnBlocks osfnBlocks) {
		this.getHibernateTemplate().save(osfnBlocks);
		return true;
	}

	public boolean updateOsfnBlocks(OsfnBlocks osfnBlocks){
		this.update(osfnBlocks);
		return true;
	}

	public Integer getOsfnBlocksID(String FnBlocksName){
		
		return -1;
	}
	
	public List<OsfnBlocks> getOsfnBlocks(){
		Query query = this.getSession().createQuery("from OsfnBlocks u where u.fnBlocksId <> ? and u.fatherFnBlocksId = ?");
		query.setParameter(0, 0);
		query.setParameter(1, 0);
		List<OsfnBlocks> list = query.list();
		return list;
	}

	public List<OsfnBlocks> getZiMoKuai(Integer FatherFnBlocksID){
		Query query = this.getSession().createQuery("from OsfnBlocks u where u.fatherFnBlocksId = ?");
		query.setParameter(0, FatherFnBlocksID);
		List<OsfnBlocks> list = query.list();
		return list;
	}
	
	public List<OsfnBlocks> GetGongNengLei(Integer FnBlocksID){
		Query query = this.getSession().createQuery("from OsfnBlocks u where u.fnBlocksId = ?");
		query.setParameter(0, FnBlocksID);
		List<OsfnBlocks> list = query.list();
		return list;
	}
	
}
