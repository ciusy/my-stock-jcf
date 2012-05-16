package leo.os.dao.impl;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.OsunitHasS;
import leo.os.dao.iface.OsunitHasSDao;

public class OsunitHasSDaoImpl extends DaoSupport<OsunitHasS> implements OsunitHasSDao {
 public List<OsunitHasS> getOsunitHasSByUid(int uid){
	 Query qurey=this.getSession().createQuery("from OsunitHasS where unitId=?");
	 qurey.setParameter(0, uid);
	 if(qurey.list().size()>0){
		 return qurey.list();
		 
	 }else{
		 return null;
	 }
 }
 
 public List<OsunitHasS> getOsunitHasSBySid(long sid){
	 Query qurey=this.getSession().createQuery("from OsunitHasS where sid=?");
	 qurey.setParameter(0, sid);
	 if(qurey.list().size()>0){
		 return qurey.list();
		 
	 }else{
		 return null;
	 }
 }
 
 public boolean addOsunitHasS(OsunitHasS osunitHasS){
	 this.getHibernateTemplate().save(osunitHasS);
	 return true;
 }
 
 public boolean updateOsunitHasS(OsunitHasS osunitHasS){
	 try{
		 this.getHibernateTemplate().update(osunitHasS);
		 return true;
	 }catch (Exception e){
		 e.printStackTrace();
	 }return false;
	 
 }
 
 public boolean deleteOsunitHasS(OsunitHasS osunitHasS){
	 try{
		 this.getHibernateTemplate().delete(osunitHasS);
		 return true;
	 }catch (Exception e){
		 e.printStackTrace();
	 }return false;
	 
 }
 
 public boolean deleteOsunitHasSBySid(long sid){
	 /*
	 List<OsunitHasS> list=getOsunitHasSBySid(sid);
	 if(list.size()>0){
	 try{ 
		 int i;
		 for(i=0;i<list.size();i++){
			deleteOsunitHasS(list.get(i)); 
		 }
		 return true;
	 }catch (Exception e){
		 e.printStackTrace();
	 }return false;
	 }else {
		 return false;
	 }
	*/
	Query query = null;
	query = this.getSession().createSQLQuery("delete from OSUnitHasS where SID = ?");
	query.setParameter(0, sid);
	query.executeUpdate();
	return true; 
 }
	 
 public boolean addOsunitHasSBySidandUid(long sid, int[] uidlist){
	 int i;
	 i=uidlist.length;
	 if (i<=0){
		 return false;
	 }else{
		 for(int j=0;j<i;j++)
		 {
			 OsunitHasS osunitHasS=new OsunitHasS();
			 osunitHasS.setSid(sid);
			 osunitHasS.setUnitId(uidlist[j]);
			 addOsunitHasS(osunitHasS); 
		 }
		 return true;
	 }
 }
 
public boolean delOsunitHasSByUnitID(Integer UnitID){
	Query query = null;
	query = this.getSession().createSQLQuery("delete from OSUnitHasS where UnitID = ?");
	query.setParameter(0, UnitID);
	query.executeUpdate();
	return true;
}

public boolean addOsunitHasSSQL(Integer KeShiID, Long YuanGongID){
	Query query = null;
	query = this.getSession().createSQLQuery("insert into OSUnitHasS(UnitID,SID) values(?,?)");
	query.setParameter(0, KeShiID);
	query.setParameter(1, YuanGongID);
	query.executeUpdate();
	return true;
}

public boolean delOsunitHasSByUnitIDAndSID(Integer UnitID, Long SID){
	Query query = null;
	query = this.getSession().createSQLQuery("delete from OSUnitHasS where UnitID = ? and SID = ?");
	query.setParameter(0, UnitID);
	query.setParameter(1, SID);
	query.executeUpdate();
	return true;
}

}
