package leo.ys.dao.iface;

import leo.common.dao.Dao;
import leo.entity.WifeGeneralSelf;

public interface YSZiDongPingGuDao extends Dao<WifeGeneralSelf>{
	/**
	 * ��ȡ����һ�������ת��Ϊ2���ʽ(�Զ�����ʹ��)
	 * @param RecordID ������
	 * @return
	 */
	public String[][] getQiZiYiBanQingKuangTo2(String RecordID);
	/**
	 * ��ȡ�ɷ�һ�������ת��Ϊ2���ʽ(�Զ�����ʹ��)
	 * @param RecordID
	 * @return
	 */
	public String[][] getZhangFuYiBanQingKuangTo2(String RecordID);
	/**
	 * ��ȡ�Զ�������ͷ����
	 * @param LeiXing ����:�������쳣
	 * @return 0:ID 1:����
	 */
	public String[][] getMoBanBiaoTou(String LeiXing);
	/**
	 * ��ȡ�Զ�������ϸ
	 * @param ID ģ��ͷID
	 * @return 0:���� 1:�Ա� 2:��ϵ 3:��� 4:���ý��
	 */
	public String[][] getMoBanMinXi(Long ID);
	/**
	 * ��ȡ��������鲢ת��Ϊ2���ʽ(�Զ�����ʹ��)
	 * @param RecordID ������
	 * @return
	 */
	public String getQiZiTiGeTo2(String RecordID);
	/**
	 * ��ȡ���Ӹ��Ƽ�鲢ת��Ϊ2���ʽ(�Զ�����ʹ��)
	 * @param RecordID ������
	 * @return
	 */
	public String getQiZiFuKeTo2(String RecordID);
	/**
	 * ��ȡ�ɷ�����鲢ת��Ϊ2���ʽ(�Զ�����ʹ��)
	 * @param RecordID ������
	 * @return
	 */
	public String getZangFuTiGeTo2(String RecordID);
	/**
	 * ��ȡ�ɷ�����鲢ת��Ϊ2���ʽ(�Զ�����ʹ��)
	 * @param RecordID ������
	 * @return
	 */
	public String getZangFuNanKeTo2(String RecordID);
	/**
	 * ��ȡ��Ա��Ϣ
	 * @param KaiShiRiQi ��ʼ����
	 * @param JieSuRiQi ��������
	 * @param XingBie �Ա�
	 * @return
	 */
	public String[][] getRenYuan(String KaiShiRiQi, String JieSuRiQi, String XingBie);
	/**
	 * ��ȡ�򳣹���
	 * @param DangAnHao ������
	 * @param XingBie �Ա�
	 * @return
	 */
	public String getNiaoChangGui(String DangAnHao, String XingBie);
	/**
	 * ����ܱ����ʼ��
	 * @param RiQi ����
	 * @return
	 */
	public String getBianHao(String RiQi);
	
}
