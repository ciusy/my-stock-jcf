package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Zyipmedicine;

public interface ZyipmedicineDao extends Dao<Zyipmedicine>{
	/**
	 * 保存临时处方
	 * @param zyipmedicine
	 * @return
	 */
	public boolean addZyipmedicine(List<Zyipmedicine> zyipmedicine);
	/**
	 * 修改住院药品项目
	 * @param zyipmedicine
	 * @return
	 */
	public boolean updateZyipmedicine(Zyipmedicine zyipmedicine);
	/**
	 * 删除住院药品项目
	 * @param DAItemID 医嘱项ID
	 * @return
	 */
	public boolean deleteZyipmedicine(Long DAItemID);
	/**
	 * 修改住院药品数量
	 * @param DAItemID 医嘱项ID
	 * @param Num 数量
	 * @return
	 */
	public boolean updateZyipmedicineNum(Long DAItemID, Integer Num);
	/**
	 * 根据医嘱ID和药品ID得到医嘱项ID
	 * @param DAID 医嘱ID
	 * @param MInfoID 药品ID
	 * @return
	 */
	public String getYiZhuXiangID(String DAID, Integer MInfoID);

}
