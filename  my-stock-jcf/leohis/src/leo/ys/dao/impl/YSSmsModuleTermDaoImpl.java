package leo.ys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import leo.common.dao.DaoSupport;
import leo.entity.SmsModule;
import leo.entity.SmsModuleTerm;
import leo.ys.dao.iface.YSSmsModuleTermDao;

public class YSSmsModuleTermDaoImpl extends DaoSupport<SmsModuleTerm> implements YSSmsModuleTermDao {

	public Long addSmsModuleTerm(SmsModuleTerm smsModuleTerm) {
		this.getHibernateTemplate().save(smsModuleTerm);
		return smsModuleTerm.getSttid();
	}

	public List<SmsModuleTerm> getsmsModuleTerm(Long ModuleID){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		List<SmsModuleTerm> list = null;
		list = this.getHibernateTemplate().find("from SmsModuleTerm where moduleId = ?",ModuleID);
		return list;
	}
	
	public boolean updateSmsModuleTerm(SmsModuleTerm smsModuleTerm){
		this.getHibernateTemplate().update(smsModuleTerm);		
		return true;
	}
	
	public boolean delSmsModuleTerm(Long STTID, Long ModuleID){
		Query query = null; // 生明一个查询对象
		if (STTID != -2){
			query = this.getSession().createSQLQuery("delete from SmsModuleTerm where STTID = ?");
			query.setParameter(0, STTID);
		}
		if (ModuleID != -2){
			query = this.getSession().createSQLQuery("delete from SmsModuleTerm where ModuleID = ?");
			query.setParameter(0, ModuleID);
		}
		query.executeUpdate();
		return true;
	}

	public String[][] getXiangNeiRong(Long ModuleID){
		Query query = null;
		query = this.getSession().createSQLQuery("select " +
				                                 "  SmsModuleTerm.sttid, " + //0模板项ID
				                                 "  SmsModuleTerm.pointtime, " + //1前后天数
				                                 "  SmsModule.PointName, " + //2模板类型
				                                 "  SmsModuleTerm.Content " + //3短信内容
				                                 "from " +
				                                 "  SmsModule,SmsModuleTerm " +
				                                 "where " +
				                                 "  SmsModule.moduleid = SmsModuleTerm.moduleid and " +
				                                 "  SmsModule.moduleid = ?");
		query.setParameter(0, ModuleID);
		query.list();
		return listObject2StringString(query.list());
	}

	public String[][] getAllXiangNeiRong(){
		Query query = null;
		query = this.getSession().createSQLQuery("select " +
				                                 "  SmsModuleTerm.sttid, " + //0模板项ID
				                                 "  SmsModuleTerm.pointtime, " + //1前后天数
				                                 "  SmsModule.PointName, " + //2模板类型
				                                 "  SmsModuleTerm.Content " + //3短信内容
				                                 "from " +
				                                 "  SmsModule,SmsModuleTerm " +
				                                 "where " +
				                                 "  SmsModule.moduleid = SmsModuleTerm.moduleid");
		query.list();
		return listObject2StringString(query.list());
	}
	
}
