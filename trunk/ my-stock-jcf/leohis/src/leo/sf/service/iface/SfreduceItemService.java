package leo.sf.service.iface;

import leo.entity.SfreduceItem;
import leo.entity.SfreduceTable;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Jul 27, 2011 2:46:56 PM
 */
public interface SfreduceItemService {
	public 	SfreduceItem getSfreduceItemByItemTypeIDandcosttypeID(int itemtypeID ,int costtypeID);
	public SfreduceTable getSfreduceTableByMInfoID(int minfoId , int costtypeId);
}

