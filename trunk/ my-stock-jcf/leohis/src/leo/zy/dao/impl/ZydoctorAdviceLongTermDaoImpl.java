package leo.zy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.dao.DataAccessResourceFailureException;

import leo.common.dao.DaoSupport;
import leo.entity.ZydoctorAdviceLongTerm;
import leo.entity.Zymadministration;
import leo.zy.dao.iface.ZydoctorAdviceLongTermDao;

public class ZydoctorAdviceLongTermDaoImpl extends DaoSupport<ZydoctorAdviceLongTerm> implements ZydoctorAdviceLongTermDao {
	private ZydoctorAdviceLongTermDao zydoctorAdviceLongTermDao;
	
	public void setZydoctorAdviceLongTermDao(
			ZydoctorAdviceLongTermDao zydoctorAdviceLongTermDao) {
		this.zydoctorAdviceLongTermDao = zydoctorAdviceLongTermDao;
	}

	public boolean addZydoctorAdviceLongTerm(ZydoctorAdviceLongTerm zydoctorAdviceLongTerm) {
		this.getHibernateTemplate().save(zydoctorAdviceLongTerm);
		return true;
	}

	public boolean getXiangMuShiFouCunZai(String ZhuYuanHao, String XiangMuLeiXing, Integer XiangMuID, Long ChangQiYiZhuID){
		Query query = null; // 生明一个查询对象
		if (ChangQiYiZhuID == -1){
			query = this.getSession().createQuery("select ltid from ZydoctorAdviceLongTerm where ipid = ? and type = ? and itemId = ?");
			query.setParameter(0, ZhuYuanHao);
			query.setParameter(1, XiangMuLeiXing);
			query.setParameter(2, XiangMuID);
		}
		else{
			query = this.getSession().createQuery("select ltid from ZydoctorAdviceLongTerm where ipid = ? and type = ? and itemId = ? and LTID <> ?");
			query.setParameter(0, ZhuYuanHao);
			query.setParameter(1, XiangMuLeiXing);
			query.setParameter(2, XiangMuID);
			query.setParameter(3, ChangQiYiZhuID);
		}
		
		//query.setFirstResult(0);
		//query.setMaxResults(1);

		List<String> list = (List<String>) query.list();
		if (list.size() < 1)
			return false;
		else
			return true;
	}

	public List<ZydoctorAdviceLongTerm> getChangQiYiZhu(String ZhuYuanHao, String RiQi, String LeiXing, Boolean WeiTingZhu){
		String tj;
		Query query = null; // 生明一个查询对象
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (ZhuYuanHao != null && !ZhuYuanHao.equals("")){  //住院号
			tj = "ipid = ?";
			cs.add(ZhuYuanHao);
		}
		if (RiQi != null && !RiQi.equals("")){  //日期
			if (tj.equals("")) 
				tj = " nextExeDate = ?";
			else
				tj = tj + " and nextExeDate = ?"; 
			cs.add(RiQi);
		}
		if (LeiXing != null && !LeiXing.equals("")){  //类型
			if (tj.equals("")) 
				tj = " type = ?";
			else
				tj = tj + " and type = ?"; 
			cs.add(LeiXing);
		}
		if (WeiTingZhu){ //只提取未停医嘱
			if (tj.equals("")) 
				tj = " StopTime = '1900-01-01 00:00:00'";
			else
				tj = tj + " and StopTime = '1900-01-01 00:00:00'"; 
		}
		
		if (tj != null && !tj.equals("")){
    		query = this.getSession().createQuery("from ZydoctorAdviceLongTerm where " + tj);
			for(int i=0;i<cs.size();i++){
		    	query.setParameter(i, cs.get(i));
			}
		}
		else{
	   		query = this.getSession().createQuery("from ZydoctorAdviceLongTerm");
		}
		return query.list();
	}

	public boolean updateXiaCiZhiXingRiQi(String [][] RiQi){
		Query query = null;
		for (int i=0;i<RiQi.length;i++){
			query = this.getSession().createSQLQuery("update ZYDoctorAdviceLongTerm set NextExeDate = ? where LTID = ?");
			query.setParameter(0,RiQi[i][1]);
			query.setParameter(1,RiQi[i][0]);
			query.executeUpdate();
		}
		return true;
	}

	public boolean updateZhiXingBiaoZhi(Long ID, Boolean BiaoZhi){
		Query query = null;
		query = this.getSession().createSQLQuery("update ZYDoctorAdviceLongTerm set BeginExe = ? where LTID = ?");
		query.setParameter(0,BiaoZhi);
		query.setParameter(1,ID);
		query.executeUpdate();
		return true;
	}
	
	public boolean delChangQiYiZhu(Long LTID){
		Query query = null;
		query = this.getSession().createSQLQuery("delete from ZYDoctorAdviceLongTerm where LTID = ?");
		query.setParameter(0,LTID);
		query.executeUpdate();
		return true;
	}
	/**
	 * 修改长期医嘱
	 * @param NeiRong 要修改的内容     0 项目ID  1 数量   2 用法    3 给药方式    4 单价   5 执行科室ID 6 执行时间    7 下次执行日期
	 * @param LTID 长期医嘱ID
	 * @return
	 */
	public boolean updateChuangQiYiZhu(String[] NeiRong, Long LTID){
		Query query = null;
		query = this.getSession().createSQLQuery("update ZYDoctorAdviceLongTerm set ItemID = ?, Num = ?, Usage = ?, WayTo = ?, Cost = ?, UID = ?, ExeTime = ?, NextExeDate = ? where LTID = ?");
		query.setParameter(0,Integer.parseInt(NeiRong[0]));
		query.setParameter(1,Integer.parseInt(NeiRong[1]));
		query.setParameter(2,NeiRong[2]);
		query.setParameter(3,NeiRong[3]);
		query.setParameter(4,Double.parseDouble(NeiRong[4]));
		query.setParameter(5,Integer.parseInt(NeiRong[5]));
		query.setParameter(6,NeiRong[6]);
		query.setParameter(7,NeiRong[7]);
		query.setParameter(8,LTID);
		query.executeUpdate();
		return true;
	}

	public boolean updateTingZhu(Long TingZhuYiSheng, String TingZhuShiJian, String XiaCiZhiXingRiQi, Long ID){
		Query query = null;
		if (XiaCiZhiXingRiQi == null || XiaCiZhiXingRiQi.equals("")){
			query = this.getSession().createSQLQuery("update ZYDoctorAdviceLongTerm set StopDoctor = ?, StopTime = ? where LTID = ?");
			query.setParameter(0,TingZhuYiSheng);
			query.setParameter(1,TingZhuShiJian);
			query.setParameter(2,ID);
		}
		else{
			query = this.getSession().createSQLQuery("update ZYDoctorAdviceLongTerm set StopDoctor = ?, StopTime = ?, NextExeDate = ? where LTID = ?");
			query.setParameter(0,TingZhuYiSheng);
			query.setParameter(1,TingZhuShiJian);
			query.setParameter(2,XiaCiZhiXingRiQi);
			query.setParameter(3,ID);
		}
		query.executeUpdate();
		return true;
	}

	public boolean updateAllTingZhu(String ZhuYuanHao, Long TingZhuYiSheng, String TingZhuShiJian){
		Query query = null;
		query = this.getSession().createSQLQuery("update ZYDoctorAdviceLongTerm set StopDoctor = ?, StopTime = ? where IPID = ? and StopDoctor = -1 and StopTime = '1900-01-01 00:00:00'");
		query.setParameter(0,TingZhuYiSheng);
		query.setParameter(1,TingZhuShiJian);
		query.setParameter(2,ZhuYuanHao);
		query.executeUpdate();
		return true;
	}
	
}
