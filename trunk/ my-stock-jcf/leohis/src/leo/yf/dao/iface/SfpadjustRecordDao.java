package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SfpadjustRecord;

public interface SfpadjustRecordDao extends Dao<SfpadjustRecord>{
	/**
	 * ������ۼ�¼
	 * @param sfpadjustRecordDao
	 * @return
	 */
	public boolean addSfpadjustRecordDao(SfpadjustRecord sfpadjustRecord);
	/**
	 * ���ռ۸�ID�޸ĵ��ۼ�¼
	 * @param PID �۸�ID
	 * @param YuanJiaGe ԭ��
	 * @param XianJiaGe �ּ�
	 * @param TiaoJiaRenID ������
	 * @param TiaoJiaShiJian ����ʱ��
	 * @param TiaoJiaLeiXing ��������
	 * @param TiaoJiaShuE ��������
	 * @return
	 */
	public boolean updateJiLu(Long PID, Double YuanJiaGe, Double XianJiaGe, Long TiaoJiaRenID, String TiaoJiaShiJian, String TiaoJiaLeiXing, Double TiaoJiaShuE);
	/**
	 * ���յ���ID��ȡ���ۼ�¼
	 * @param PID
	 * @return
	 */
	public List<SfpadjustRecord> getSfpadjustRecord(Long PID);
	
}
