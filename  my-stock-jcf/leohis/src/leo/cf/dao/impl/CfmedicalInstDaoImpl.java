package leo.cf.dao.impl;

import java.util.List;

import leo.cf.dao.iface.CfmedicalInstDao;
import leo.common.dao.DaoSupport;
import leo.entity.CfmedicalInst;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;

public class CfmedicalInstDaoImpl extends DaoSupport<CfmedicalInst>  implements CfmedicalInstDao {

	public boolean getCFMedicalInstShiFouCiZi(String DisposeName, Integer MedicalInstID){
		Query query=this.getSession().createSQLQuery("select top 1 * from CfmedicalInst where DisposeName = ? and MedicalInstID = ?");
		query.setParameter(0, DisposeName);
		query.setParameter(1, MedicalInstID);
		List<CfmedicalInst> list = query.list();
		if (list == null || list.size() == 0)
			return false;
		else
			return true;
	}
	
	public boolean changeValueBydisposeName(String disposeName,String cfvalue,int medicalInstId) {
		Query query=this.getSession().createQuery("update CfmedicalInst c set c.cfvalue=? where c.disposeName=? and c.medicalInstId=?");
		query.setParameter(0, cfvalue);
		query.setParameter(1, disposeName);
		query.setParameter(2, medicalInstId);
		query.executeUpdate();
		return true;
	}

	public String getValueBydisposeName(String disposeName,int medicalInstId) {
		Query query=this.getSession().createQuery("from CfmedicalInst c where c.disposeName=? and c.medicalInstId=?");
		query.setParameter(0, disposeName);
		query.setParameter(1, medicalInstId);
		List<CfmedicalInst> list=query.list();
		return list.get(0).getCfvalue();
	}
	/**
	 * 添加全局配置信息
	 */
	public boolean addCfmedicalInstInfo(String DisposeName, String CFValue, int MedicalInstID) {
		Query query=this.getSession().createSQLQuery("insert into CFMedicalInst(DisposeName,CFValue,MedicalInstID) values(?,?,?)");
		query.setParameter(0, DisposeName);
		query.setParameter(1, CFValue);
		query.setParameter(2, MedicalInstID);
		query.executeUpdate();
		return true;
	}
	/**
	 * 根据全局ID删除全局配置信息
	 */
	public boolean delCfmedicalInstInfo(Long dId) {
		try {
			CfmedicalInst cfi = (CfmedicalInst)super.getHibernateTemplate().get(CfmedicalInst.class, dId);
			super.getHibernateTemplate().delete(cfi);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public CfmedicalInst getCfmedicalInstBydisposeName(String disposeName,
			int medicalInstId) {
		Query query=this.getSession().createQuery("from CfmedicalInst c where c.disposeName=? and c.medicalInstId=?");
		query.setParameter(0, disposeName);
		query.setParameter(1, medicalInstId);
		List<CfmedicalInst> list=query.list();
		if(list.size()>0)
		{
		return list.get(0);
		}else
		{
			return null;
		}
	}

}
