package leo.bc.sercive.impl;

import java.util.List;

import leo.bc.dao.iface.CzacontentDao;
import leo.bc.dao.iface.CzdisposeItemDescribeDao;
import leo.bc.dao.iface.DisposeDao;
import leo.bc.sercive.iface.CzGiveWsService;
import leo.entity.Czacontent;
import leo.entity.CzdisposeItemDescribe;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 12, 2011 3:33:58 PM
 */
public class CzGiveWsServiceImpl implements CzGiveWsService {

	private CzdisposeItemDescribeDao czdisposeItemDescribeDao;
	private DisposeDao disposeDao;
	private CzacontentDao czacontentDao;

	public void setCzacontentDao(CzacontentDao czacontentDao) {
		this.czacontentDao = czacontentDao;
	}

	public void setDisposeDao(DisposeDao disposeDao) {
		this.disposeDao = disposeDao;
	}

	public void setCzdisposeItemDescribeDao(CzdisposeItemDescribeDao czdisposeItemDescribeDao) {
		this.czdisposeItemDescribeDao = czdisposeItemDescribeDao;
	}

	public List<CzdisposeItemDescribe> getByIDs(List<Integer> ids) {
		return czdisposeItemDescribeDao.getByIDs(ids);
	}

	public List<CzdisposeItemDescribe> getAllCzdisposeItemDescribe() {
		return czdisposeItemDescribeDao.getScrollData();
	}

	public CzdisposeItemDescribe getCzdisposeItemDescribeById(int itemTypeId) {
		return czdisposeItemDescribeDao.find(itemTypeId);
	}

	public List<Object[]> getCzdisposeByStatusAndTime(List<String> statusList, String startTime, String endTime, String officeId) {

		return disposeDao.getCzdisposeByStatusAndTime(statusList, startTime, endTime, officeId);
	}

	public Czacontent getCzacontentById(String itemId) {
		return czacontentDao.getCzacontentByItemId(itemId);
	}

	public List<CzdisposeItemDescribe> getByMedicalOrgId(Integer medicalOrgaId) {
		return czdisposeItemDescribeDao.getByMedicalOrgId(medicalOrgaId);
	}

}
