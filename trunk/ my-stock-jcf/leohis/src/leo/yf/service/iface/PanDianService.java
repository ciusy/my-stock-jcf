package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfapproveItem;
import leo.entity.YfapproveTable;
import leo.entity.YfcheckRecord;
import leo.entity.YfcheckRecordItem;
import leo.entity.YfexbankAitem;
import leo.entity.YfinbankAitem;
import leo.entity.YfmexbankA;
import leo.entity.YfminbankA;

public interface PanDianService {
	/**
	 * �����̵㵥
	 * @param yfcheckRecord �̵㵥��ͷ
	 * @param yfcheckRecordItem �̵㵥����
	 * @return
	 */
	public boolean addPanDianDan(YfcheckRecord yfcheckRecord,List<YfcheckRecordItem> yfcheckRecordItem);
	/**
	 * ��������̵㵥��
	 * @return
	 */
	public String getMaxID();
	/**
	 * ��ȡ�̵㵥��ͷ
	 * @param DanHao �̵㵥��
	 * @param KaiShiRiQi ��ʼʱ��
	 * @param JieSuRiQi ����ʱ��
	 * @param ZhuangTai ״̬
	 * @param YaoFang ҩ��ID
	 * @return
	 */
	public List<YfcheckRecord> getYfcheckRecord(String DanHao, String KaiShiRiQi, String JieSuRiQi, String ZhuangTai, Integer YaoFang);
	/**
	 * ��ȡ�̵㵥����
	 * @param DanHao �̵���
	 * @return
	 */
	public List<YfcheckRecordItem> getYfcheckRecordItem(String DanHao);
	/**
	 * ɾ���̵㵥
	 * @param DanHao �̵㵥��
	 * @return
	 */
	public boolean delPanDianDan(String DanHao);
	/**
	 * �޸��̵㵥״̬
	 * @param DanHao �̵㵥��
	 * @param ZhuangTai ״̬
	 * @return
	 */
	public boolean updateZhuangTai(String DanHao, String ZhuangTai);
	/**
	 * �޸��̵㵥
	 * @param DanHao �̵㵥��
	 * @param yfcheckRecord �̵��ͷ
	 * @param yfcheckRecordItem �̵�����
	 * @return yfapproveTable ������ͷ
	 * @return yfapproveItem ����������
	 * @return ShenPiLuoJi �Ƿ���Ҫ����
	 */
	public boolean updatePanDianDan(String DanHao,YfcheckRecord yfcheckRecord,List<YfcheckRecordItem> yfcheckRecordItem, YfapproveTable yfapproveTable, List<YfapproveItem> yfapproveItem, Integer ShenPiLuoJi);
	/**
	 * ִ���̵㵥
	 * @param ChuKuDanTou //���ⵥ��ͷ
	 * @param ChuKuDanNeiRong //���ⵥ����
	 * @param RuKuDanTou //��ⵥ��ͷ
	 * @param RuKuDanNeiRong //��ⵥ����
	 * @param yp //ҩƷ��Ϣ
	 * @param yfid //ҩ��ID
	 * @param IfChuKudan //�Ƿ������ⵥ
	 * @param IfRuKudan //�Ƿ�����ⵥ
	 * @param PanDianDanHao //�̵㵥��
	 * @param PanDianZhuangTai //�̵�״̬
	 * 
	 * @return
	 */
	public boolean updateZiXingPanDian(YfmexbankA ChuKuDanTou,List<YfexbankAitem> ChuKuDanNeiRong,YfminbankA RuKuDanTou, List<YfinbankAitem> RuKuDanNeiRong, String[][] yp, Integer yfid, Integer IfChuKudan, Integer IfRuKudan, String PanDianDanHao, String PanDianZhuangTai);
	
	
}
