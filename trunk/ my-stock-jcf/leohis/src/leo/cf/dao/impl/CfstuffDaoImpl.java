package leo.cf.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.cf.dao.iface.CfstuffDao;
import leo.entity.Cfstuff;
import leo.entity.Osstuff;

public class CfstuffDaoImpl extends HibernateDaoSupport implements CfstuffDao {

	public String getPersonalConfiguration(String dname, long sid) {
		
        try{
        	Query query = this.getSession().createQuery("from Cfstuff c where c.disposeName=:dname and c.sid=:sid");
      
            query.setString("dname",dname);
            query.setLong("sid",sid);
            
        	List<Cfstuff> list=query.list();
            if(list.size()!=0){
            	return list.get(0).getCfvalue();
            }
            return null;
            		
        }catch (Exception e){
        	e.printStackTrace();
        }
		return null;	
	}
	public boolean addcfstuff(Cfstuff cfstuff){
		this.getHibernateTemplate().save(cfstuff);
		return true;
		
	}
	public boolean deletecfstuff(int id){
		Query query=this.getSession().createSQLQuery("delete from Cfstuff where did='"+id+"'");
		query.executeUpdate();
		return true;
	}
	public boolean updatecfstuff(int id,String value,int sid){
		Query query=this.getSession().createSQLQuery("update cfstuff set cfvalue='"+value+"' , sid='"+sid+"' where did='"+id+"'");
		query.executeUpdate();
		return true;
	}
	public boolean changeValueByDisposeName(String disposeName ,String cfvalue){//根据配置项的名称更改该配置项的值。
    try{
    	Query query=this.getSession().createQuery("update Cfstuff c set c.cfvalue=? where c.disposeName=?");
    query.setParameter(0, cfvalue);
    query.setParameter(1, disposeName);
    query.executeUpdate();
    return true;
    
    }catch (Exception e) {
    	e.printStackTrace();
	}return false;
	
	
	}
	public String[][] getinfobydisposename(String dname){
		try{
		String sql="select st.sname,st.sid,rt.rpname,rt.rtid,ct.did from GhregisterType rt,osstuff st,cfstuff ct where rt.rtid=ct.cfvalue and st.sid=ct.sid" +
				" and ct.disposename='"+dname+"'";
		Query query=this.getSession().createSQLQuery(sql);
		List<Object[]> list=query.list();
		int i=list.size();
		String [][] str= new String[i][5];
	       for(int y=0;y<i;y++){
	     	str[y][0]=list.get(y)[0]==null ? "" :list.get(y)[0].toString();
	  		str[y][1]=list.get(y)[1]==null ? "" :list.get(y)[1].toString();
	  		str[y][2]=list.get(y)[2]==null ? "" :list.get(y)[2].toString();
	  		str[y][3]=list.get(y)[3]==null ? "" :list.get(y)[3].toString();
	  		str[y][4]=list.get(y)[4]==null ? "" :list.get(y)[4].toString();
	        }
	       return str; 
	     }catch (Exception e){
	     	e.printStackTrace();
	     }return null;
		
	}
	
}
