package leo.sf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Sfopcg;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 21, 2011 4:40:56 PM
 */
public interface SfopcgDao extends Dao<Sfopcg> {

	/**
	 * 根据诊断Id查找对应的门诊收费
	 * 
	 * @param oPDiagnoseID
	 * @return
	 */
	public List<Sfopcg> getByOPDiagnoseID(String oPDiagnoseID);

}
