package leo.os.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leo.common.dao.DaoSupport;
import leo.entity.OsfnBlocks;
import leo.entity.OsudefaultFn;
import leo.entity.YfinbankTypeSetting;
import leo.os.dao.iface.OsudefaultfnDao;

/**
 * 科室默认功能实现
 * 
 * @author Administrator
 * 
 */
public class OsudefaultfnDaoImpl extends DaoSupport<OsudefaultFn> implements
		OsudefaultfnDao {
	/**
	 * 根据科室id查询科室对应的功能
	 */
	public List<OsfnBlocks> getFnBlocksByUID(Integer uid) {
		// 通过科室ID查询功能ID
		try {
			Session session = super.getSession();
			Query query = session.createQuery("from OsudefaultFn where uid=?");
			query.setInteger(0, uid);
			List<OsudefaultFn> osfList = query.list();
			List<OsfnBlocks> osbList = new ArrayList<OsfnBlocks>();
			// 通过查询出的功能ID查询相应的功能
			if (osfList.size() > 0) {
				for (int i = 0; i < osfList.size(); i++) {
					OsudefaultFn osf = osfList.get(i);
					OsfnBlocks osb = (OsfnBlocks)super.getHibernateTemplate().get(OsfnBlocks.class, osf.getFcBlocksId());
					osbList.add(osb);
				}
			}
			return osbList;
		} catch (DataAccessResourceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean addOSUDefaultFn(OsudefaultFn osudefaultFn){
		this.getHibernateTemplate().save(osudefaultFn);
		return true;
	}

	public String[][] getOSUDefaultFn(Integer uid){
		Query query = null;
		query = this
		.getSession()
		.createSQLQuery("select " +
						"  OSFnBlocks.FnBlocksName, " + //0功能模块名称
						"  OSUDefaultFn.FcBlocksID " + //1功能模块ID
						"from " +
						"  OSUDefaultFn,OSFnBlocks " +
						"where " +
						"  OSUDefaultFn.FcBlocksID = OSFnBlocks.FnBlocksID and " +
						"  OSUDefaultFn.UID = ?");
		query.setParameter(0, uid);
		query.list();
		return listObject2StringString(query.list());

	}

	public boolean delOSUDefaultFn(Integer uid, Integer FcBlocksID){
		Query query = null;
		query = this
		.getSession()
		.createSQLQuery("delete from OsudefaultFn where uid = ? and fcBlocksId = ?");
		query.setParameter(0, uid);
		query.setParameter(1, FcBlocksID);
		query.executeUpdate();
		return true;
	}

}
