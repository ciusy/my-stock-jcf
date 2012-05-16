package leo.gh.dao.iface;

import java.util.List;
import java.util.Set;

import leo.common.dao.Dao;
import leo.entity.GhcostType;

public interface GhcostTypeDao extends Dao<GhcostType>{
	public List<GhcostType> getAllGhcostTypeByMid(int mid);
	public GhcostType getGhcostTypeByid(int id);
	public boolean addGhcostType(GhcostType ghcostType);
	public boolean updateGhcostType(GhcostType ghcostType);
	public boolean deleteGhcostType(GhcostType ghcostType);
	/**
	 * add by xu 
	 * @param nums
	 * @return
	 */
	public List<Object[]> getCostTypeGiveGH(List<String> nums);
	/**
	 * add by xu 
	 * @param consumerName
	 * @param idCard
	 * @param medicalCard
	 * @param flag 
	 * @return
	 */
	public List<Object[]> getConsumers(String consumerName, String idCard, String medicalCard, int flag);
	/**
	 * add by xu 
	 * @param costTypeIds
	 * @return
	 */
	public List<GhcostType> getCostType(Set<Integer> costTypeIds);
	/**
	 * ����ID��ȡ��������
	 * @param ID ��������ID  -2��������
	 * @param  YiLiaoJiGou ҽ�ƻ���
	 * @return
	 */
	public List<GhcostType> getCostTypeById(Integer ID, Integer YiLiaoJiGou);
	
}
