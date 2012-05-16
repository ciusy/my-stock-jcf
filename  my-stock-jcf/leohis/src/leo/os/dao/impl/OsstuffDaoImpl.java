package leo.os.dao.impl;

import java.util.ArrayList;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.Osstuff;
import leo.os.dao.iface.OsstuffDao;

import org.hibernate.Query;
import org.hibernate.Session;

public class OsstuffDaoImpl extends DaoSupport<Osstuff> implements OsstuffDao {

	public Osstuff getStuffByNameAndPassword(String loginName, String password) {
		try {
			Query query = this.getSession().createQuery("from Osstuff s where s.loginName=:loginName and s.password=:password");
			query.setString("loginName", loginName);
			query.setString("password", password);
			List<Osstuff> list = query.list();
			// 如果查到记录，则返回。因为一个员工只对应一个登录名和密码。
			// 所以查到的肯定是一条记录，直接返回list.get(0)
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Osstuff getStuffBySid(Long sid) {
		try {
			return (Osstuff) getHibernateTemplate().get(Osstuff.class, sid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Osstuff> getExpertStuffByUid(int uid) {
		try {
			Query query = this.getSession().createQuery(
					"select os from Osstuff os,OsunitHasS ou where ou.unitId=:uid and os.sid=ou.sid and os.expertOrNot=true");
			query.setInteger("uid", uid);
			List<Osstuff> list = query.list();
			// Query query = this.getSession().createQuery("select
			// os.sid,os.sname from Osstuff os,OsunitHasS ou where
			// ou.unitId=:uid and os.sid=ou.sid and os.expertOrNot=true");
			// query.setInteger("uid", uid);
			// List<Object[]> list = query.list();
			// Iterator<Object[]> it=list.iterator();
			// String[][] str = new String[list.size()][2];
			// Object[] results = null;
			// int i=0;
			// while(it.hasNext()){
			// results=(Object[])it.next();
			// str[i][0]=results[0].toString();
			// str[i][1]=(String)results[1];
			// i++;
			// }
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Query query = this.getSession().createQuery("select os from Osstuff
		// os,OSUnitHasS ou where ou.unitId=:uid and
		// os.sid=ou.sid and os.expertOrNot=true");
		// query.setInteger("uid", uid);
		// List<Osstuff> list = query.list();
		// Iterator<Osstuff> it=list.iterator();
		// while(it.hasNext()){
		// results=(Object[])it.next();
		// str[0]=results[0].toString();
		// str[1]=(String)results[1];
		// }
		return null;
	}

	/**
	 * add by xu 根据ids集合查找所有的医护人员
	 * 
	 * @param ids
	 * @return
	 */
	public List<Osstuff> getByIds(List<Long> ids) {

		Session session = getSession();
		Query query = session.createQuery("from Osstuff o where o.sid in (:ids)");
		query.setParameterList("ids", ids);
		return (List<Osstuff>) query.list();

	}

	// 更改用户密码
	public String changePassword(String loginname, String oldpassword, String newpassword1, String newpassword2) {
		if (newpassword1.equals(newpassword2)) {
			try {
				Query query1 = this.getSession().createQuery("from Osstuff o  where o.loginName=:loginname");
				query1.setString("loginname", loginname);
				List<Osstuff> list = query1.list();
				if (list.get(0).getPassword().equals(oldpassword)) {
					Query query2 = this
							.getSession()
							.createQuery(
									"update Osstuff o set o.password=:newpassword1 where o.loginName=:loginname and o.password=:oldpassword");
					query2.setString("newpassword1", newpassword1);
					query2.setString("loginname", loginname);
					query2.setString("oldpassword", oldpassword);
					query2.executeUpdate();
					return "密码修改成功";
				} else
					return "原密码输入错误";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "修改失败";

		} else
			return "两次输入的密码不一致";

	}

	public List<Osstuff> getExpertSBasicInfo(int uid) {
		try {
			Query query = this.getSession().createQuery(
					"select o.* from Osstuff o,Osuform u where u.sid=o.sid and u.uid=:uid and o.expertOrNot=true");
			query.setLong("uid", uid);
			List<Osstuff> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Osstuff> getOsstuff(Integer meiid) {
		List<Osstuff> list = this.getHibernateTemplate().find("from Osstuff where meiid = ?", meiid);
		return list;

	}

	public String getSNameBySid(long sid) {
		try {
			Osstuff osstuff = (Osstuff) this.getHibernateTemplate().get(Osstuff.class, sid);
			if (osstuff != null)
				return osstuff.getSname();
			return "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal) {
		List<Object[]> list = getHibernateTemplate().find(
				"select o1.sid,o1.sname,o2.uname,o1.loginName,o1.idcardNum,o1.chargeBalance"
						+ " from Osstuff o1,Osuform o2 where o1.defaultU=o2.uid and o1.meiid=?", medicalOrgnizal);

		return listObject2ListString(list);
	}

	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal, String name, Boolean isSpell) {
		StringBuilder sb = new StringBuilder();
		sb.append("select o1.sid,o1.sname,o2.uname,o1.loginName,o1.idcardNum,o1.chargeBalance"
				+ " from Osstuff o1,Osuform o2 where o1.defaultU=o2.uid and o1.meiid=?");
		sb.append(isSpell ? " and o1.spellAbbreviation like ?" : " and o1.sname like ?");

		List<Object[]> list = getHibernateTemplate().find(sb.toString(), new Object[] { medicalOrgnizal, name + "%" });

		return listObject2ListString(list);
	}
	
	public Double getYuE(Long SID){
		Osstuff osstuff = (Osstuff) this.getHibernateTemplate().get(Osstuff.class, SID);
		if (osstuff != null)
			return osstuff.getChargeBalance();
		else
			return -1d;
	}
	
	public String[][] getNameAndID(Integer ksid, String ZhiCheng){
		List<Object> cs = new ArrayList<Object>();
		Query query = null;
		if (ZhiCheng == null || ZhiCheng.equals("")){
			query = this.getSession().createSQLQuery("select OSStuff.SName,OSStuff.SID from OSUnitHasS,OSStuff where OSUnitHasS.SID = OSStuff.SID and OSUnitHasS.UnitID = ?");
			query.setParameter(0,ksid);
		}
		else{
			query = this.getSession().createSQLQuery("select OSStuff.SName,OSStuff.SID from OSUnitHasS,OSStuff where OSUnitHasS.SID = OSStuff.SID and OSUnitHasS.UnitID = ? and OSStuff.QualificationName = ?");
			query.setParameter(0,ksid);
			query.setParameter(1,ZhiCheng);
		}
			
		query.list();
		return listObject2StringString(query.list());
	}
	
	public List<Osstuff> getOsstuffBycondition(String sname,String spell,String zige,String zhiwu,String bianzhi,int uid,int mid){
	String	hql="from Osstuff where meiid = ?";
	if (sname != null && sname != "") {
		hql = hql + "and sname like ?";
		
	}
	if (spell!= null && spell != "") {
		hql = hql + "and spellAbbreviation like?";
		
	}
	
	if (zige != null && zige != "") {
		hql = hql + "and qualificationName=?";
		
	}
	if (zhiwu != null && zhiwu != "") {
		hql = hql + "and title=?";
		
	}
	if (bianzhi != null && bianzhi != "") {
		hql = hql + "and staffingLevelType=?";
		
	}
	if (String.valueOf(uid) != null && uid !=-1) {
		hql = hql + "and defaultU=?";
		
	}
	Query query=this.getSession().createQuery(hql);
	query.setParameter(0, mid);
	if (sname != null && sname != "") {
		query.setParameter(1, "%" + sname + "%");
		
	}
	if (spell != null && spell != "") {
		query.setParameter(1, "%"+spell+"%");
		
	}
	if (zige != null && zige != "") {
		query.setParameter(1, zige);
		
	}
	if (zhiwu != null && zhiwu != "") {
		query.setParameter(1, zhiwu);
		
	}
	if (bianzhi != null && bianzhi != "") {
		query.setParameter(1, bianzhi);
		
	}
	if (String.valueOf(uid) != null && uid !=-1) {
		query.setParameter(1, uid);
		
	}
	if (query.list().size()>0){
		return query.list();
		
	}else{
		return null;
	}
	}
	 
    public boolean addOsstuff(Osstuff osstuff){
    	try{
    		this.getHibernateTemplate().save(osstuff);
    		return true;
    	}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public boolean updateOsstuff(Osstuff osstuff){
    	try{
    		this.getHibernateTemplate().update(osstuff);
    		return true;
    	}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public boolean deleteOsstuff(Osstuff osstuff){
    	try{
    		this.getHibernateTemplate().delete(osstuff);
    		return true;
    	}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public boolean loginname(String lgname,int mid,Long SID){
    	Query query=null;
    	if (SID == -2){
    		query=this.getSession().createQuery("from Osstuff where loginName = ? and meiid=?");
        	query.setParameter(0, lgname);
        	query.setParameter(1, mid);
    	}
    	else{
    		query=this.getSession().createQuery("from Osstuff where loginName = ? and meiid=? and SID <> ?");
        	query.setParameter(0, lgname);
        	query.setParameter(1, mid);
        	query.setParameter(2, SID);
    	}
    	if(query.list().size()>0){
    		return true;
    	}else{
    		return false;
    	}
    }
    public Osstuff getOsstuffByLoginname(String lgname,int mid){
    	Query query=this.getSession().createQuery("from Osstuff where loginName=? and meiid=?");
    	query.setParameter(0, lgname);
    	query.setParameter(1, mid);
    	List<Osstuff> list =query.list();
    	if(query.list().size()>0){
    		return list.get(0);
    		
    	}else{
    		return null;
    	}
    }

	public boolean delOsstuffById(Long SID){
		Query query = null;
		query = this.getSession().createSQLQuery("delete from OSStuff where SID = ?");
		query.setParameter(0, SID);
		query.executeUpdate();
		return true;
	}

	public boolean updateYongHu(Long SID, String LoginName, String Password){
    	Query query=this.getSession().createSQLQuery("update OSStuff set LoginName = ?, Password = ? where SID = ?");
    	query.setParameter(0, LoginName);
    	query.setParameter(1, Password);
    	query.setParameter(2, SID);
		query.executeUpdate();
		return true;
	}
	
	public boolean getYongHuCunZai(String LoginName, Long SID){
    	Query query=null;
   		query=this.getSession().createQuery("from Osstuff where loginName = ? and SID <> ?");
       	query.setParameter(0, LoginName);
       	query.setParameter(1, SID);
    	if(query.list().size()>0){
    		return true;
    	}else{
    		return false;
    	}
	}
   public String[][] getsnamesidbyuid(int uid){
	 try{
	   String sql="";
	   sql=sql+"select s.sname,s.sid from Osstuff s,OsunitHasS os where s.sid=os.sid and os.unitid='"+ uid +"'";
	   Query qurey=this.getSession().createSQLQuery(sql);
	   List<Object[]> list=qurey.list();
	   int i=list.size();
	  String[][] str=new String[i][2];
	  for(int y=0;y<i;y++)
	  {
		  str[y][0]=list.get(y)[0]==null ? "" :list.get(y)[0].toString();
		  str[y][1]=list.get(y)[1]==null ? "" :list.get(y)[1].toString();
	  }
	  return str;
   }
	 catch (Exception e) {
			e.printStackTrace();
		}
	return null;
   }
}
