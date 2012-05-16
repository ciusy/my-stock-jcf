package leo.cs.dao.iface;

import java.util.List;

import leo.entity.CsmedicalCard;

public interface CsmedicalCardDao {
	/**
	 * ͨ���������ID���ҽ�ƿ�����
	 * @param csid
	 * @return
	 */
	public CsmedicalCard getCsmedicalCardByCsid(long csid);
	public CsmedicalCard getCsmedicalCardOnlyByCsid(long csid);
	public Boolean addCsmedicalCard(CsmedicalCard csmedicalCard);
	public Boolean updateCsmedicalCard(CsmedicalCard csmedicalCard);
	public long getCsIDByMedicalCardNum(String medicalCardNum);
	/**
	 * add by xu 
	 * @param csIds
	 * @return
	 */
	public List<CsmedicalCard> getCsmedicalCardByCsids(List<Long> csIds);
}
