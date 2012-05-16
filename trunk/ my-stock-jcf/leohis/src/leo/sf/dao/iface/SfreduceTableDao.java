package leo.sf.dao.iface;

import java.util.HashSet;
import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SfreduceTable;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Jul 27, 2011 3:42:18 PM
 */
public interface SfreduceTableDao extends Dao<SfreduceTable> {

	/**
	 * ����һ�����߶��ҩƷ��Ϣids��ѯ��Ӧ�ļ�������Ϣ
	 * 
	 * @param MInfoIDSet
	 * @return
	 */
	public List<SfreduceTable> getByMInfoID(HashSet<Integer> MInfoIDSet);
	/**
	 * ����ҩƷ��Ϣid�ͷ������Ͳ�ѯ�����
	 * @param minfoId
	 * @param costtypeId
	 * @return
	 */
	public SfreduceTable getSfreduceTableByMInfoID(int minfoId , int costtypeId);
	public SfreduceTable getBySingle(Integer costTypeId, String projectName);

}
