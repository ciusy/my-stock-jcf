package leo.sf.dao.iface;

import java.util.HashSet;
import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SfreduceItem;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Jul 27, 2011 11:42:43 AM
 */
public interface SfReduceItemDao extends Dao<SfreduceItem>{

	/**
	 * ����һ�����߶����Ŀ���͵�ids�õ�������Ŀ��
	 * 
	 * @param itemTypeIDList
	 * @return
	 */
	public List<SfreduceItem> getByItemTypeID(HashSet<Integer> itemTypeIDList);
	/**
	 * ������ĿID�ͷ�������IDȡ������Ŀ
	 * @param itemtypeID
	 * @param costtypeID
	 * @return
	 */
	public 	SfreduceItem getSfreduceItemByItemTypeIDandcosttypeID(int itemtypeID ,int costtypeID);
	/**
	 * add by xu 
	 * @param costTypeId
	 * @param projectName
	 * @return
	 */
	public SfreduceItem getBySingle(Integer costTypeId, String projectName);

}

