package leo.cs.service.impl;

import java.util.List;

import leo.cs.dao.iface.CsconsumerDao;
import leo.cs.dao.iface.CsmedicalCardDao;
import leo.cs.dao.iface.CsmedicalCardDetailDao;
import leo.cs.service.iface.CsGiveSfService;
import leo.entity.Csconsumer;
import leo.entity.CsmedicalCard;
import leo.entity.CsmedicalCardDetail;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 28, 2011 3:36:47 PM
 */
public class CsGiveSfServiceImpl implements CsGiveSfService {

	private CsmedicalCardDao csmedicalCardDao;

	private CsmedicalCardDetailDao csMedicalCardDetailDao;

	private CsconsumerDao csconsumerDao;

	public void setCsMedicalCardDetailDao(CsmedicalCardDetailDao csMedicalCardDetailDao) {
		this.csMedicalCardDetailDao = csMedicalCardDetailDao;
	}

	public void setCsmedicalCardDao(CsmedicalCardDao csmedicalCardDao) {
		this.csmedicalCardDao = csmedicalCardDao;
	}

	public CsmedicalCard getCsmedicalCard(Long csId) {

		return csmedicalCardDao.getCsmedicalCardByCsid(csId);
	}

	public void addCSMedicalCardDetail(CsmedicalCardDetail csmedicalCardDetail, long csid) {

		csMedicalCardDetailDao.save(csmedicalCardDetail);

		CsmedicalCard csmedicalCard = csmedicalCardDao.getCsmedicalCardByCsid(csid);

		csmedicalCard.setBalance(csmedicalCard.getBalance() - csmedicalCardDetail.getAmount());
		csmedicalCardDao.updateCsmedicalCard(csmedicalCard);
	}

	public List<CsmedicalCard> getCsmedicalCard(List<Long> csIds) {
		return csmedicalCardDao.getCsmedicalCardByCsids(csIds);
	}

	public List<Csconsumer> getByLikeValue(String value, boolean isSpell) {

		return csconsumerDao.getByLikeValue(value, isSpell);
	}

	public void setCsconsumerDao(CsconsumerDao csconsumerDao) {
		this.csconsumerDao = csconsumerDao;
	}

}
