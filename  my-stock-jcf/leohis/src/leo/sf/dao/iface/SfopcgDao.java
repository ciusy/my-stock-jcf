package leo.sf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Sfopcg;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Jul 21, 2011 4:40:56 PM
 */
public interface SfopcgDao extends Dao<Sfopcg> {

	/**
	 * �������Id���Ҷ�Ӧ�������շ�
	 * 
	 * @param oPDiagnoseID
	 * @return
	 */
	public List<Sfopcg> getByOPDiagnoseID(String oPDiagnoseID);

}
