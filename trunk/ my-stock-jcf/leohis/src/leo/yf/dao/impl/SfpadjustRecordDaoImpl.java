package leo.yf.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.SfpadjustRecord;
import leo.entity.YfexbankAitem;
import leo.yf.dao.iface.SfpadjustRecordDao;

import org.hibernate.Query;

public class SfpadjustRecordDaoImpl extends DaoSupport<SfpadjustRecord> implements SfpadjustRecordDao {

	public boolean addSfpadjustRecordDao(SfpadjustRecord sfpadjustRecord) {
		this.getHibernateTemplate().save(sfpadjustRecord);
		return true;
	}

	public boolean updateJiLu(Long PID, Double YuanJiaGe, Double XianJiaGe, Long TiaoJiaRenID, String TiaoJiaShiJian, String TiaoJiaLeiXing, Double TiaoJiaShuE){
		Query query = null; // 生明一个查询对象
		query = this.getSession().createSQLQuery("update SFPAdjustRecord set FormerP=?,NowadayP=?,Adjuster=?,PAdjustTime=?,AType=?,Amount=? where PID=?");
		query.setParameter(0, YuanJiaGe);
		query.setParameter(1, XianJiaGe);
		query.setParameter(2, TiaoJiaRenID);
		query.setParameter(3, TiaoJiaShiJian);
		query.setParameter(4, TiaoJiaLeiXing);
		query.setParameter(5, TiaoJiaShuE);
		query.setParameter(6, PID);
		query.executeUpdate(); //执行修改
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<SfpadjustRecord> getSfpadjustRecord(Long PID){
		List<SfpadjustRecord> list = this.getHibernateTemplate().find("from SfpadjustRecord where pid = ?",PID);
		return list;
	}
}
