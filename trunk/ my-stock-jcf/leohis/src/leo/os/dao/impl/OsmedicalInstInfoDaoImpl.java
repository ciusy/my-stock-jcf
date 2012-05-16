package leo.os.dao.impl;

import java.util.List;

import leo.entity.OsmedicalInstInfo;
import leo.os.dao.iface.OsmedicalInstInfoDao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OsmedicalInstInfoDaoImpl extends HibernateDaoSupport implements
		OsmedicalInstInfoDao {

	public String getOsmedicalInstInfoName(int mid) {
		try{
			OsmedicalInstInfo osmedicalInstInfo = (OsmedicalInstInfo)this.getHibernateTemplate().get(OsmedicalInstInfo.class, mid);
			return osmedicalInstInfo.getMedicalInstName();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}

	public OsmedicalInstInfo getOsmedicalInstInfoById(int mid) {
		try{
			return (OsmedicalInstInfo)super.getHibernateTemplate().get(OsmedicalInstInfo.class, mid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<OsmedicalInstInfo> getAllOsmedicalInstInfo(){
		try{
			List<OsmedicalInstInfo> list=this.getHibernateTemplate().find("from OsmedicalInstInfo");
			return list;
		}catch (Exception e){
			return null;
		}
	}
	
	public boolean addOSMedicalInstInfo(OsmedicalInstInfo osmedicalInstInfo){
		this.getHibernateTemplate().save(osmedicalInstInfo);
		return true;
	}

	public boolean updateOSMedicalInstInfo(OsmedicalInstInfo osmedicalInstInfo){
		this.getHibernateTemplate().update(osmedicalInstInfo);
		return true;
	}
	
}
