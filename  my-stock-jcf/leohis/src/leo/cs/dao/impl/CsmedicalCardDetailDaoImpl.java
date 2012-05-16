package leo.cs.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.cs.dao.iface.CsmedicalCardDetailDao;
import leo.entity.CsmedicalCardDetail;

import org.hibernate.Query;

public class CsmedicalCardDetailDaoImpl extends DaoSupport<CsmedicalCardDetail> implements CsmedicalCardDetailDao {

	public String[][] getCsmedicalCardDetailByDateandcsid(String stdate, String eddate, long csid) {

		try {
			String sql = "select cc.id,cc.csId,cc.cgItem,cc.amount,cc.date,cc.cgId,cc.receiver from CsmedicalCardDetail cc where cc.csId="+csid+" and cc.date between '"+ stdate + "' and '" + eddate + "' ";

			Query query = this.getSession().createSQLQuery(sql);

			List<Object[]> list = query.list();
			int i = list.size();
			String[][] str = new String[i][7];
			for (int y = 0; y < i; y++) {
				str[y][0] = list.get(y)[0] == null ? "" : list.get(y)[0].toString();//
				str[y][1] = list.get(y)[1] == null ? "" : list.get(y)[1].toString();//
				str[y][2] = list.get(y)[2] == null ? "" : list.get(y)[2].toString();//
				str[y][3] = list.get(y)[3] == null ? "" : list.get(y)[3].toString();//
				str[y][4] = list.get(y)[4] == null ? "" : list.get(y)[4].toString();//
				str[y][5] = list.get(y)[5] == null ? "" : list.get(y)[5].toString();//
				str[y][6] = list.get(y)[6] == null ? "" : list.get(y)[6].toString();//
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public Boolean addCsmedicalCardDetail(CsmedicalCardDetail csmedicalCardDetail) {
		try {
			this.getHibernateTemplate().save(csmedicalCardDetail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}