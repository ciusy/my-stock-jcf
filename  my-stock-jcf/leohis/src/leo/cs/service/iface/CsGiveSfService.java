package leo.cs.service.iface;

import java.util.List;

import leo.entity.Csconsumer;
import leo.entity.CsmedicalCard;
import leo.entity.CsmedicalCardDetail;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Jul 28, 2011 3:36:32 PM
 */
public interface CsGiveSfService {
	/**
	 * ���ҷ������ǰ����ʹ�õ�ҽ�ƿ���Ϣ
	 * 
	 * @param csId
	 * @return
	 */

	public CsmedicalCard getCsmedicalCard(Long csId);

	/**
	 * ���ҽ�ƿ��굥����޸�ҽ�ƿ������
	 * 
	 * @param csmedicalCardDetail
	 * @param parseLong
	 */
	public void addCSMedicalCardDetail(CsmedicalCardDetail csmedicalCardDetail, long csid);

	/**
	 * ���ݶ���������ids���Ҷ�Ӧ��ҽ�ƿ�
	 * 
	 * @param ids
	 * @return
	 */
	public List<CsmedicalCard> getCsmedicalCard(List<Long> csIds);

	/**
	 * 
	 * @param value
	 * @param isSpell
	 * @return
	 */
	public List<Csconsumer> getByLikeValue(String value, boolean isSpell);

}
