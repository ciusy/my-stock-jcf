package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Yfmstock;

public interface YfmstockDao extends Dao<Yfmstock>{
	public List<Yfmstock> getYfmstock(Integer MID,Integer MInfoID, Integer PharmacyID);
	public boolean addYfmstock(Yfmstock yfmstock);
	public Integer getMInfo(Integer MInfoID, Integer PharmacyID); //�ж�ĳһҩƷ��ϢID�Ƿ����,���ؿ����(-1��������)
	/**
	 * ����ҩƷ��ϢID��ҩ��ID�޸Ŀ��
	 * @param MInfoID
	 * @param Stock
	 * @param PharmacyID
	 * @return
	 */
	public boolean updateStock(Integer MInfoID, Integer Stock, Integer PharmacyID); //����ҩƷ��ϢID�޸Ķ�Ӧ����
	
	
}
