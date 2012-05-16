package leo.bc.dao.impl;

import leo.bc.dao.iface.CzshbioIsreDao;
import leo.common.dao.DaoSupport;
import leo.entity.CzshbioIsre;

import org.hibernate.Query;

public class CzshbioIsreDaoImpl extends DaoSupport<CzshbioIsre> implements CzshbioIsreDao {

	public boolean addCzshbioIsre(CzshbioIsre czshbioIsre) {
		try{
			this.getHibernateTemplate().save(czshbioIsre);
			return true ;
		}catch (Exception e) {
			e.printStackTrace();
		}return false;
	}

	public String[][] getCzshbioIsreByOpDnID(String OpDnID, String ItemName){
		Query query = null;
		if (ItemName.equals("") || ItemName==null){
			query = this.getSession().createSQLQuery("select " +
					 "  CZSHBioISRE.REName, " + //0检查项目
					 "  CZSHBioISTerm.TermName, " + //1子项中文名称
					 "  CZSHBioISTerm.EnglishName, " + //2子项英文名称
					 "  CZSHBioISTerm.TermValue, " + //3子项结果
					 "  CZSHBioISTerm.ReferenceValue, " + //4参考范围
					 "  CZSHBioISTerm.Unit, " + //5单位
					 "  CZSHBioISTerm.Prompt, " + //6提示
					 "  CZSHBioISRE.ISDoctorName " + //7检验医生
					 "from " +
					 "  CZSHBioISRE,CZDispose,CZSHBioISTerm " +
					 "where " +
					 "  CZSHBioISRE.ItemID = CZDispose.ItemID and " +
					 "  CZSHBioISTerm.ItemID = CZDispose.ItemID and " +
					 "  CZDispose.KindID = ? " +
					 "order by " +
					 "  CZSHBioISRE.REName");
			query.setParameter(0, OpDnID);			
		}else{
			query = this.getSession().createSQLQuery("select " +
					 "  CZSHBioISRE.REName, " + //0检查项目
					 "  CZSHBioISTerm.TermName, " + //1子项中文名称
					 "  CZSHBioISTerm.EnglishName, " + //2子项英文名称
					 "  CZSHBioISTerm.TermValue, " + //3子项结果
					 "  CZSHBioISTerm.ReferenceValue, " + //4参考范围
					 "  CZSHBioISTerm.Unit, " + //5单位
					 "  CZSHBioISTerm.Prompt, " + //6提示
					 "  CZSHBioISRE.ISDoctorName " + //7检验医生
					 "from " +
					 "  CZSHBioISRE,CZDispose,CZSHBioISTerm " +
					 "where " +
					 "  CZSHBioISRE.ItemID = CZDispose.ItemID and " +
					 "  CZSHBioISTerm.ItemID = CZDispose.ItemID and " +
					 "  CZDispose.KindID = ? and " +
					 "  CZSHBioISRE.REName = ? " +
					 "order by " +
					 "  CZSHBioISRE.REName");
			query.setParameter(0, OpDnID);			
			query.setParameter(1, ItemName);			
		}
		
		query.list();
		return listObject2StringString(query.list());
	}

	public String[][] getCzshbioIsreByItemID(String ItemID, String ItemName){
		Query query = null;
		query = this.getSession().createSQLQuery("select " +
				 "  CZSHBioISRE.REName, " + //0检查项目
				 "  CZSHBioISTerm.TermName, " + //1子项中文名称
				 "  CZSHBioISTerm.EnglishName, " + //2子项英文名称
				 "  CZSHBioISTerm.TermValue, " + //3子项结果
				 "  CZSHBioISTerm.ReferenceValue, " + //4参考范围
				 "  CZSHBioISTerm.Unit, " + //5单位
				 "  CZSHBioISTerm.Prompt, " + //6提示
			     "  OSUForm.UName, " + //7科别 
			     "  CZSHBioISRE.ISTime, " + //8检查时间
			     "  CZSHBioISRE.BioNum, " + //9检验单号
				 "  CZSHBioISRE.ISDoctorName " + //10检验医生
				 "from " +
				 "  CZSHBioISRE,CZDispose,CZSHBioISTerm,OSUForm " +
				 "where " +
				 "  OSUForm.UID = CZDispose.AU and "+
				 "  CZSHBioISRE.ItemID = CZDispose.ItemID and " +
				 "  CZSHBioISTerm.ItemID = CZDispose.ItemID and " +
				 "  CZDispose.ItemID = ? and " +
				 "  CZSHBioISRE.REName = ? " +
				 "order by " +
				 "  CZSHBioISRE.REName");
		query.setParameter(0, ItemID);			
		query.setParameter(1, ItemName);			
		query.list();
		return listObject2StringString(query.list());
	}
	
	
}
