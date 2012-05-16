package leo.dx.service.iface;

import java.util.List;

import leo.entity.HealthyPregnantSms;
import leo.entity.SuccessfulSms;

public interface DuanXinChuLiService {
	/**
	 * ��ȡ�ѷ����ż�¼
	 * @param ShiJian_B ���Ϳ�ʼʱ��
	 * @param ShiJian_E ���ͽ���ʱ��
	 * @param ZhuangTai ״̬
	 * @param MoKuai ģ��
	 * @param UnitID ��λ
	 * @return
	 */
	public String[][] getYiFaXinXi(String ShiJian_B, String ShiJian_E, String ZhuangTai, String MoKuai, Integer UnitID);
	/**
	 * ����״̬�͵�λ��ȡ�����������ݣ��Ա㷢��
	 * @param ZhuangTai ״̬
	 * @param DanWeiID ��λID
	 * @return
	 */
	public List<HealthyPregnantSms> getYouShengDuanXin(String ZhuangTai, Integer DanWeiID);
	/**
	 * ���Ŵ���
	 * @param DuanXinJiLu ���ż�¼��
	 * @param LeiXing ���� ���·�   �ط�
	 * @return
	 */
	public boolean updateFaXinChuLi(List<SuccessfulSms> DuanXinJiLu, String LeiXing);
	/**
	 * ��ȡ����ģ��������
	 * @return
	 */
	public String[][] getAllXiangNeiRong();
	
}


