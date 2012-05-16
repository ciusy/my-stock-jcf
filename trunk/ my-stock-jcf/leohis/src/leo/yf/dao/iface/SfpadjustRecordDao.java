package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SfpadjustRecord;

public interface SfpadjustRecordDao extends Dao<SfpadjustRecord>{
	/**
	 * 保存调价记录
	 * @param sfpadjustRecordDao
	 * @return
	 */
	public boolean addSfpadjustRecordDao(SfpadjustRecord sfpadjustRecord);
	/**
	 * 按照价格ID修改调价记录
	 * @param PID 价格ID
	 * @param YuanJiaGe 原价
	 * @param XianJiaGe 现价
	 * @param TiaoJiaRenID 调价人
	 * @param TiaoJiaShiJian 调价时间
	 * @param TiaoJiaLeiXing 调价类型
	 * @param TiaoJiaShuE 调价数额
	 * @return
	 */
	public boolean updateJiLu(Long PID, Double YuanJiaGe, Double XianJiaGe, Long TiaoJiaRenID, String TiaoJiaShiJian, String TiaoJiaLeiXing, Double TiaoJiaShuE);
	/**
	 * 按照调价ID提取调价记录
	 * @param PID
	 * @return
	 */
	public List<SfpadjustRecord> getSfpadjustRecord(Long PID);
	
}
