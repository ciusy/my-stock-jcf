package leo.sf.service.impl;

import leo.entity.SfreduceItem;
import leo.entity.SfreduceTable;
import leo.sf.dao.iface.SfReduceItemDao;
import leo.sf.dao.iface.SfreduceTableDao;
import leo.sf.service.iface.SfreduceItemService;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 27, 2011 2:47:18 PM
 */
public class SfreduceItemServiceImpl implements SfreduceItemService {

	private SfReduceItemDao sfReduceItemDao;
    private SfreduceTableDao sfreduceTableDao;
	public void setSfReduceItemDao(SfReduceItemDao sfReduceItemDao) {
		this.sfReduceItemDao = sfReduceItemDao;
	}

	public void setSfreduceTableDao(SfreduceTableDao sfreduceTableDao){
		this.sfreduceTableDao=sfreduceTableDao;
	}
	
	public SfreduceItem getSfreduceItemByItemTypeIDandcosttypeID(
			int itemtypeID, int costtypeID) {
		
		return sfReduceItemDao.getSfreduceItemByItemTypeIDandcosttypeID(itemtypeID, costtypeID) ;
	}

	public SfreduceTable getSfreduceTableByMInfoID(int minfoId, int costtypeId) {
		// TODO Auto-generated method stub
		return sfreduceTableDao.getSfreduceTableByMInfoID(minfoId, costtypeId);
	}
	
	
}
