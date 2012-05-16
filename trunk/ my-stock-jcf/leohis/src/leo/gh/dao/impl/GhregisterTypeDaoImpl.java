package leo.gh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.GhregisterType;
import leo.gh.dao.iface.GhregisterTypeDao;

import org.hibernate.Query;

public class GhregisterTypeDaoImpl extends DaoSupport<GhregisterType> implements
		GhregisterTypeDao {

	public List<GhregisterType> getAllGhregisterType(int uid) {
		try{
			Query query = this.getSession().createQuery("select gt from GhregisterType gt,GhregisterDivaricateU gdu where gt.rtid=gdu.rtid and gdu.uid=:uid");
			query.setInteger("uid", uid);
			List<GhregisterType> list = query.list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteGhregisterType(GhregisterType ghregisterType) {
		try{
			this.getHibernateTemplate().delete(ghregisterType);
			return true ;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean addGhregisterType(GhregisterType ghregisterType) {
		this.getHibernateTemplate().save(ghregisterType);
		return true;
	}

	public boolean updateGhregisterType(GhregisterType ghregisterType) {
		try{
			this.getHibernateTemplate().update(ghregisterType);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public GhregisterType getGhregisterTypeById(int id) {
		try{
			return (GhregisterType)this.getHibernateTemplate().get(GhregisterType.class, id);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<GhregisterType> getGhregisterTypeByUid(int uId1,int uId2) {
		try{
			Query query = this.getSession().createQuery("select gt from GhregisterType gt,GhregisterDivaricateU gdu where gt.rtid=gdu.rtid and gt.uid=:uid1 and gdu.uid=:uid2");
			query.setInteger("uid1", uId1);
			query.setInteger("uid2", uId2);
			List<GhregisterType> list = query.list();
			return list;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public GhregisterType getGhregisterTypeByRPname(String rpname){
		try{
			Query query = this.getSession().createQuery("from GhregisterType u where u.rpname=:rpname");
			query.setString("rpname", rpname);
			List<GhregisterType> list = query.list();
			if(list != null && list.size()>0){
				return list.get(0);
			}
			return null;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<GhregisterType> getAllGhregisterTypeByMid(int mid) {
		try {
			Query query = this.getSession().createQuery("from GhregisterType gct where gct.medicalInstId=:mid");
			query.setInteger("mid", mid);
			List<GhregisterType> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getRtidByUName(int mid , String rpname) {
		try{
			Query query = this.getSession().createQuery("select GHRT.rtid from GhregisterType GHRT where GHRT.rpname=? and GHRT.medicalInstId =?");
			query.setParameter(0, rpname);
			query.setParameter(1, mid);
			List<Object[]> list = query.list();
			Object hel = list.get(0);
			return (Integer)hel;
			}catch (Exception e){
			e.printStackTrace();
		}		return -1;
	}
	
	public Integer getGhregisterTypeCunZai(String RPName, Integer MedicalInstID){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createQuery("select a.rtid from GhregisterType a where a.rpname = ? and a.medicalInstId = ?");
		query.setParameter(0, RPName);
		query.setParameter(1, MedicalInstID);
		
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Integer> list = (List<Integer>) query.list();
		if (list.size() < 1)
			return -1;
		else
			return list.get(0);
	}
	
	public List<GhregisterType> getgetGhregisterTypeByNameAndSpell(String RPName, String Spell, Integer MedicalInstID){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;
		if (RPName != null && !RPName.equals("")) {
			tj = "a.rpname like ?"; // 名称
			cs.add("%"+RPName+"%");
		}
		if (Spell != null && !Spell.equals("")) { // 拼音缩写
			if (tj.equals(""))
				tj = " a.spell = ?";
			else
				tj = tj + " and a.spell = ?";
			cs.add(Spell);
		}
		if (MedicalInstID != -2) { // 医疗机构
			if (tj.equals(""))
				tj = " a.medicalInstId = ?";
			else
				tj = tj + " and a.medicalInstId = ?";
			cs.add(MedicalInstID);
		}
		
		if (tj != null && !tj.equals("")){
			query = this.getSession().createQuery("from GhregisterType a where " + tj);
			for (int i = 0; i < cs.size(); i++)
				query.setParameter(i, cs.get(i));
		}else{
			query = this.getSession().createQuery("from GhregisterType a");
		}
		List<GhregisterType> list = query.list();
		return list;
	}
	
	public boolean delGhregisterTypeByID(Integer RTID){
		Query query = null;
		query = this.getSession().createSQLQuery("delete GhregisterType where RTID = ?");
		query.setParameter(0,RTID);
		query.executeUpdate();
		return true;
	}
    public List<GhregisterType> getGhregisterTypebyghuid(int uid){
    	Query query=this.getSession().createQuery("from GhregisterType where uid=?");
        query.setParameter(0, uid);
        List<GhregisterType> list= query.list();
        if (list.size()>0){
        	return list;
        }else
        	return null;
    }
    public String[][] getrnameandrtidbyuid(int uid){
    	try{
    	String sql="select gr.rpname,gr.rtid from GhregisterType gr,GhregisterDivaricateU gd where gr.rtid=gd.rtid and gd.uid='"+uid+"'";
       Query query=this.getSession().createSQLQuery(sql);
       List<Object[]> list=query.list();
       int i=list.size();
       String[][] str=new String[i][2];
       for(int y=0;y<i;y++){
    	  str[y][0]=list.get(y)[0]==null ? "" :list.get(y)[0].toString();
 		  str[y][1]=list.get(y)[1]==null ? "" :list.get(y)[1].toString();
       }
      return str; 
    }catch (Exception e){
    	e.printStackTrace();
    }return null;
    }

}
