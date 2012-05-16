package leo.gh.service.impl;

import java.util.List;
import java.util.Set;

import leo.entity.GhcostType;
import leo.entity.Ghregister;
import leo.entity.SfreduceItem;
import leo.gh.dao.iface.GhcostTypeDao;
import leo.gh.dao.iface.GhregisterDao;
import leo.gh.service.iface.GhGiveSFService;
import leo.sf.dao.iface.SfReduceItemDao;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 19, 2011 3:18:51 PM
 */
public class GhGiveSFServiceImpl implements GhGiveSFService {

	private GhcostTypeDao ghcostTypeDao;
	private GhregisterDao ghregisterDao;

	/**
	 * 根据门诊号查询病人的减免信息
	 * 
	 * @param OPNums
	 * @return
	 */
	public List<Object[]> getCostType(List<String> OPNums) {
		return ghcostTypeDao.getCostTypeGiveGH(OPNums);
	}

	public void setGhcostTypeDao(GhcostTypeDao ghcostTypeDao) {
		this.ghcostTypeDao = ghcostTypeDao;
	}

	public List<Object[]> getCosumers(String consumerName, String idCard,
			String medicalCard, int flag) {

		return ghcostTypeDao.getConsumers(consumerName, idCard, medicalCard,
				flag);
	}

	public List<GhcostType> getCostType(Set<Integer> costTypeIds) {
		return ghcostTypeDao.getCostType(costTypeIds);
	}

	public List<GhcostType> getGhcostTypeByOrgId(Integer medicalOrgnizal) {
		return ghcostTypeDao
				.getScrollData("o.medicalInstId=?", medicalOrgnizal);
	}

	public Ghregister getGhRegister(String opnum) {
		return ghregisterDao.find(opnum);

	}

	public void setGhregisterDao(GhregisterDao ghregisterDao) {
		this.ghregisterDao = ghregisterDao;
	}

	public void updateGhRegister(Ghregister ghregister) {
		ghregisterDao.updateGhregister(ghregister);
	}

}
