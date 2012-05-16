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
					 "  CZSHBioISRE.REName, " + //0�����Ŀ
					 "  CZSHBioISTerm.TermName, " + //1������������
					 "  CZSHBioISTerm.EnglishName, " + //2����Ӣ������
					 "  CZSHBioISTerm.TermValue, " + //3������
					 "  CZSHBioISTerm.ReferenceValue, " + //4�ο���Χ
					 "  CZSHBioISTerm.Unit, " + //5��λ
					 "  CZSHBioISTerm.Prompt, " + //6��ʾ
					 "  CZSHBioISRE.ISDoctorName " + //7����ҽ��
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
					 "  CZSHBioISRE.REName, " + //0�����Ŀ
					 "  CZSHBioISTerm.TermName, " + //1������������
					 "  CZSHBioISTerm.EnglishName, " + //2����Ӣ������
					 "  CZSHBioISTerm.TermValue, " + //3������
					 "  CZSHBioISTerm.ReferenceValue, " + //4�ο���Χ
					 "  CZSHBioISTerm.Unit, " + //5��λ
					 "  CZSHBioISTerm.Prompt, " + //6��ʾ
					 "  CZSHBioISRE.ISDoctorName " + //7����ҽ��
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
				 "  CZSHBioISRE.REName, " + //0�����Ŀ
				 "  CZSHBioISTerm.TermName, " + //1������������
				 "  CZSHBioISTerm.EnglishName, " + //2����Ӣ������
				 "  CZSHBioISTerm.TermValue, " + //3������
				 "  CZSHBioISTerm.ReferenceValue, " + //4�ο���Χ
				 "  CZSHBioISTerm.Unit, " + //5��λ
				 "  CZSHBioISTerm.Prompt, " + //6��ʾ
			     "  OSUForm.UName, " + //7�Ʊ� 
			     "  CZSHBioISRE.ISTime, " + //8���ʱ��
			     "  CZSHBioISRE.BioNum, " + //9���鵥��
				 "  CZSHBioISRE.ISDoctorName " + //10����ҽ��
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
