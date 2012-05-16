package leo.gh.service.iface;

import java.util.List;
import java.util.Set;

import leo.entity.GhcostType;
import leo.entity.Ghregister;
import leo.entity.SfreduceItem;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Jul 19, 2011 3:18:36 PM
 */
public interface GhGiveSFService {

	/**
	 * ��������Ų�ѯ���˵ļ�����Ϣ
	 * 
	 * @param OPNums
	 * @return
	 */
	public List<Object[]> getCostType(List<String> OPNums);

	/**
	 * 
	 * @param consumerName
	 * @param idCard
	 * @param medicalCard
	 * @param flag 
	 * @return
	 */
	public List<Object[]> getCosumers(String consumerName, String idCard, String medicalCard, int flag);

	/**
	 * ���ݷ�������id�ļ��ϲ��ҷ��������ķ������Ͷ���
	 * @param costTypeIds
	 * @return
	 */
	public List<GhcostType> getCostType(Set<Integer> costTypeIds);

	public List<GhcostType> getGhcostTypeByOrgId(Integer medicalOrgnizal);

	public Ghregister getGhRegister(String opnum);

	public void updateGhRegister(Ghregister ghregister);


}
