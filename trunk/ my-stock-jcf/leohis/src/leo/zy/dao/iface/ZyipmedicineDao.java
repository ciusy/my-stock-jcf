package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Zyipmedicine;

public interface ZyipmedicineDao extends Dao<Zyipmedicine>{
	/**
	 * ������ʱ����
	 * @param zyipmedicine
	 * @return
	 */
	public boolean addZyipmedicine(List<Zyipmedicine> zyipmedicine);
	/**
	 * �޸�סԺҩƷ��Ŀ
	 * @param zyipmedicine
	 * @return
	 */
	public boolean updateZyipmedicine(Zyipmedicine zyipmedicine);
	/**
	 * ɾ��סԺҩƷ��Ŀ
	 * @param DAItemID ҽ����ID
	 * @return
	 */
	public boolean deleteZyipmedicine(Long DAItemID);
	/**
	 * �޸�סԺҩƷ����
	 * @param DAItemID ҽ����ID
	 * @param Num ����
	 * @return
	 */
	public boolean updateZyipmedicineNum(Long DAItemID, Integer Num);
	/**
	 * ����ҽ��ID��ҩƷID�õ�ҽ����ID
	 * @param DAID ҽ��ID
	 * @param MInfoID ҩƷID
	 * @return
	 */
	public String getYiZhuXiangID(String DAID, Integer MInfoID);

}
