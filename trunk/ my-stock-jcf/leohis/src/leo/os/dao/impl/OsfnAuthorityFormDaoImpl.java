package leo.os.dao.impl;

import java.util.ArrayList;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.OsfnAuthorityForm;
import leo.os.dao.iface.OsfnAuthorityFormDao;

import org.hibernate.Query;

public class OsfnAuthorityFormDaoImpl extends DaoSupport<OsfnAuthorityForm> implements
		OsfnAuthorityFormDao {

	public List<OsfnAuthorityForm> getOsfnAuthorityFormBySid(long sid) {
		try{
			//Query query = this.getSession().createQuery("from OsfnAuthorityForm a where a.sid=:sid order by (a.fatherMenuId,a.menuId) asc");
			//2012-03-06 �������޸ģ�ԭ�������SQL������쳣
			Query query = this.getSession().createQuery("from OsfnAuthorityForm a where a.sid=:sid order by a.fatherMenuId,a.menuId asc");
			query.setLong("sid", sid);
			List<OsfnAuthorityForm> list = query.list();
			return list;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getCaiDanMaxID(){
		Query query = null; // ����һ����ѯ����
		query = this.getSession().createQuery(
				"select a.menuId from OsfnAuthorityForm a order by a.menuId desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Integer> list = (List<Integer>) query.list();
		if (list.size() < 1)
			return 0;
		else
			return list.get(0);
		
	}

	public boolean addOSFnAuthorityForm(OsfnAuthorityForm osfnAuthorityForm){
		this.getHibernateTemplate().save(osfnAuthorityForm);
		return true;
	}

	public boolean delOSFnAuthorityForm(Long SID){
		Query query = null; // ����һ����ѯ����
		query = this.getSession().createSQLQuery("delete from OSFnAuthorityForm where SID = ?");
		query.setParameter(0, SID);
		query.executeUpdate();
		return true;
	}

	public String[][] getCaiDanShu(long sid){
		Query query = null;
		/*
		query = this.getSession().createSQLQuery("select " +
				                                 "  OSFnAuthorityForm.MenuName, " + //0�˵�����
				                                 "  OSFnAuthorityForm.MenuID, " + //1�˵�ID
				                                 "  OSFnAuthorityForm.FnBlocksID, " + //2���ܿ�ID
				                                 "  OSFnAuthorityForm.FatherMenuID, " + //3���˵�ID
				                                 "  OSFnBlocks.FnBlocksClass " + //4���ܿ���
				                                 "from " +
				                                 "  OSFnAuthorityForm,OSFnBlocks " +
				                                 "where " +
				                                 "  OSFnAuthorityForm.FnBlocksID = OSFnBlocks.FnBlocksID and " +
				                                 "  OSFnAuthorityForm.SID = ?");
		*/
		query = this.getSession().createSQLQuery("select " +
               									 "  OSFnAuthorityForm.MenuName, " + //0�˵�����
               									 "  OSFnAuthorityForm.MenuID, " + //1�˵�ID
               									 "  OSFnAuthorityForm.FnBlocksID, " + //2���ܿ�ID
               									 "  OSFnAuthorityForm.FatherMenuID " + //3���˵�ID
               									 "from " +
               									 "  OSFnAuthorityForm " +
               									 "where " +
												 "  OSFnAuthorityForm.SID = ?");
		
		query.setParameter(0, sid);
		query.list();
		return listObject2StringString(query.list());
	}

	public boolean updateCaiDanMingCheng(Integer MenuID, String MenuName){
		Query query = null;
		query = this.getSession().createSQLQuery("update OSFnAuthorityForm set MenuName = ? where MenuID = ?");
		query.setParameter(0, MenuName);
		query.setParameter(1, MenuID);
		query.executeUpdate();
		return true;
	}

	public boolean delCaiDan(String LeiXing, Integer MenuID, Long YuanGongID){
		Query query = null;
		if (LeiXing.equals("����")){
			query = this.getSession().createSQLQuery("delete from OSFnAuthorityForm where SID = ?");
			query.setParameter(0, YuanGongID);
		}
		if (LeiXing.equals("ģ��")){
			query = this.getSession().createSQLQuery("delete from OSFnAuthorityForm where MenuID = ? or FatherMenuID = ?");
			query.setParameter(0, MenuID);
			query.setParameter(1, MenuID);
		}
		if (LeiXing.equals("����")){
			query = this.getSession().createSQLQuery("delete from OSFnAuthorityForm where MenuID = ?");
			query.setParameter(0, MenuID);
		}
		if (LeiXing.equals("Ŀ¼")){
			query = this.getSession().createSQLQuery("delete from OSFnAuthorityForm where MenuID = ? or FatherMenuID = ?");
			query.setParameter(0, MenuID);
			query.setParameter(1, MenuID);
		}
		query.executeUpdate();
		return true;
	}

	public boolean updateKuaiJieAnNiu(Integer MenuID, String QuickName, String QuickImageID, String QuickClass){
		Query query = null;
		query = this.getSession().createSQLQuery("update OSFnAuthorityForm set QuickName = ?, QuickImageID = ?, QuickClass = ? where MenuID = ?");
		query.setParameter(0, QuickName);
		query.setParameter(1, QuickImageID);
		query.setParameter(2, QuickClass);
		query.setParameter(3, MenuID);
		query.executeUpdate();
		return true;
	}
	
	public String[][] getKuaiJieAnNiu(Long SID){
		Query query = null;
		query = this.getSession().createSQLQuery("select " +
				                                 "  QuickName, " + //0����
				                                 "  QuickImageID, " + //1ͼ��ID
				                                 "  QuickClass " + //2������
				                                 "from " +
				                                 "  OSFnAuthorityForm " +
				                                 "where " +
				                                 "  SID = ? and " +
				                                 "  (QuickClass is not null and QuickClass <> '')");
		query.setParameter(0, SID);
		query.list();
		return listObject2StringString(query.list());
	}

	public String[][] getKuaiJieAnNiuByCaiDanID(Integer MenuID){
		Query query = null;
		query = this.getSession().createSQLQuery("select " +
				                                 "  QuickName, " + //0����
				                                 "  QuickImageID, " + //1ͼ��ID
				                                 "  QuickClass " + //2������
				                                 "from " +
				                                 "  OSFnAuthorityForm " +
				                                 "where " +
				                                 "  MenuID = ? and " +
				                                 "  (QuickClass is not null and QuickClass <> '')");
		query.setParameter(0, MenuID);
		query.list();
		return listObject2StringString(query.list());
	}
	
	public String[][] getMuLu(Long sid, Integer FatherMenuID){
		Query query = null;
		query = this.getSession().createSQLQuery("select MenuName,MenuID " +
												 "from OSFnAuthorityForm " +
												 "where sid = ? and FnBlocksid = ? and FatherMenuID = ?");
		query.setParameter(0, sid);
		query.setParameter(1, -1);
		query.setParameter(2, FatherMenuID);
		query.list();
		return listObject2StringString(query.list());
	}
	
	public boolean updateMuLu(Integer MenuID, Integer FatherMenuID){
		Query query = null;
		query = this.getSession().createSQLQuery("update OSFnAuthorityForm set FatherMenuID = ? where MenuID = ?");
		query.setParameter(0, FatherMenuID);
		query.setParameter(1, MenuID);
		query.executeUpdate();
		return true;
	}

	public String[][] getZaiMuLuLi(Long Sid, Integer FatherMenuID){
		Query query = null;
		query = this.getSession().createSQLQuery("select FatherMenuID, FnBlocksID from OSFnAuthorityForm where sid = ? and MenuID = ?");
		query.setParameter(0, Sid);
		query.setParameter(1, FatherMenuID);
		return listObject2StringString(query.list());
	}
}
