package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Zyipteatment;

public interface ZyipteatmentDao extends Dao<Zyipteatment> {
	/**
	 * 保存住院处置
	 * @param zyipteatment
	 * @return
	 */
	public boolean addZyipteatment(List<Zyipteatment> zyipteatment);
	/**
	 * 修改住院处置表的处置项ID
	 * @param IDS 0:DAItemID 1:ItemID
	 * @return
	 */
	public boolean updateZyipteatmentItemID(String[][] IDS);
	
	/**
	 * 判断一张医嘱单中是否有部份执行的处置项目
	 * @param YiZhuHao 医嘱单号
	 * @return
	 */
	public boolean getChuZhiBuFenZhiXing(String YiZhuHao);
	/**
	 * 修改住院处置表里的申请单内容
	 * @param ShenQingNeiRong 申请内容
	 * @param DAItemID 医嘱项ID
	 * @return
	 */
	public boolean updateZyipteatmentAContent(String ShenQingNeiRong, Long DAItemID);
	/**
	 * 修改住院处置的项目类型ID和执行科室
	 * @param ItemTypeID 项目类型ID
	 * @param ExecuteU 执行科室
	 * @param DAItemID 医嘱项ID
	 * @return
	 */
	public boolean updateZyipteatmentXiangMu(Integer ItemTypeID, Integer ExecuteU, Long DAItemID);
	/**
	 * 删除住院处置项目
	 * @param DAItemID 医嘱项ID
	 * @return
	 */
	public boolean delZYIPTeatment(Long DAItemID);
}
