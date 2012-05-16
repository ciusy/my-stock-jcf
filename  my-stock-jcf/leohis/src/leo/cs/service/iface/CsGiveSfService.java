package leo.cs.service.iface;

import java.util.List;

import leo.entity.Csconsumer;
import leo.entity.CsmedicalCard;
import leo.entity.CsmedicalCardDetail;

/**
 * @author xuxiangpan
 * @version 创建时间：Jul 28, 2011 3:36:32 PM
 */
public interface CsGiveSfService {
	/**
	 * 查找服务对象当前正在使用的医疗卡信息
	 * 
	 * @param csId
	 * @return
	 */

	public CsmedicalCard getCsmedicalCard(Long csId);

	/**
	 * 添加医疗卡详单表和修改医疗卡的余额
	 * 
	 * @param csmedicalCardDetail
	 * @param parseLong
	 */
	public void addCSMedicalCardDetail(CsmedicalCardDetail csmedicalCardDetail, long csid);

	/**
	 * 根据多个服务对象ids查找对应的医疗卡
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
