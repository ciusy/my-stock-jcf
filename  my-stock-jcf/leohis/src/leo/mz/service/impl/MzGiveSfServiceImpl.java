package leo.mz.service.impl;

import java.util.List;

import leo.entity.MzopDn;
import leo.mz.dao.iface.MzopDnDao;
import leo.mz.service.iface.MzGiveSfService;

/**
 * 
 * @author xuxiangpan
 * 
 */
public class MzGiveSfServiceImpl implements MzGiveSfService {

	private MzopDnDao mzopDnDao;

	public void setMzopDnDao(MzopDnDao mzopDnDao) {
		this.mzopDnDao = mzopDnDao;
	}

	/**
	 * 
	 * add by xu �õ�������շѵ�������϶���
	 * 
	 * @param officeId
	 *            ��ǰ��¼�ߵĿ���ID
	 * @return
	 */
	public List<MzopDn> getNowDayMZop(Integer officeId) {

		return mzopDnDao.getNowDayMZop(officeId);
	}

	/**
	 * add by xu ���ݷ�������id �ļ��ϵõ����еĴ��շѵı����ҵ����е���϶���
	 * 
	 * @param consumerIds
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<MzopDn> getMzopDn(List<Long> consumerIds, String startTime,
			String endTime, int officeId) {

		return mzopDnDao.getMzopDn(consumerIds, startTime, endTime, officeId);
	}

	public void updateMZOpDnStatus(String diagnoseID, String status) {
		MzopDn mzopDn = mzopDnDao.find(diagnoseID);
		mzopDn.setStatus(status);
		mzopDnDao.update(mzopDn);
	}

	public MzopDn getMzopDn(String opnum) {

		return mzopDnDao.getMzopDn(opnum);
	}

	public List<MzopDn> getMzopDnByIDs(List<String> ids) {

		return mzopDnDao.getMzopDnByIDs(ids);
	}

}
