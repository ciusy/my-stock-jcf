package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.ZydoctorAdviceLongTerm;

public interface ZydoctorAdviceLongTermDao extends Dao<ZydoctorAdviceLongTerm>{
	/**
	 * ����סԺ����ҽ��
	 * @param zydoctorAdviceLongTerm
	 * @return
	 */
	public boolean addZydoctorAdviceLongTerm(ZydoctorAdviceLongTerm zydoctorAdviceLongTerm);
	/**
	 * �ж�һ����Ŀ�Ƿ����
	 * @param ZhuYuanHao סԺ��
	 * @param XiangMuLeiXing ��Ŀ����(����������)
	 * @param XiangMuID ��ĿID
	 * @param ChangQiYiZhuID ����ҽ��ID -1:����ʱʹ��   ����ҽ��ID:�޸�ʱʹ��
	 * @return
	 */
	public boolean getXiangMuShiFouCunZai(String ZhuYuanHao, String XiangMuLeiXing, Integer XiangMuID, Long ChangQiYiZhuID);
	/**
	 * ��ȡ����ҽ��
	 * @param ZhuYuanHao סԺ��
	 * @param RiQi ��ǰ����
	 * @param LeiXing ����(����,����)
	 * @param WeiTingZhu �Ƿ�ֻ��ȡδͣҽ��
	 * @return
	 */
	public List<ZydoctorAdviceLongTerm> getChangQiYiZhu(String ZhuYuanHao, String RiQi, String LeiXing, Boolean WeiTingZhu);
	/**
	 * �޸ĳ���ҽ���´�ִ������
	 * @param RiQi   0:����ҽ��ID  1:����
	 * @return
	 */
	public boolean updateXiaCiZhiXingRiQi(String [][] RiQi);
	/**
	 * �޸ĳ���ҽ��ִ�б�־
	 * @param ID ����ҽ��ID
	 * @param BiaoZhi ��־ true false
	 * @return
	 */
	public boolean updateZhiXingBiaoZhi(Long ID, Boolean BiaoZhi);
	/**
	 * ɾ������ҽ����Ŀ
	 * @param LTID ����ҽ��ID
	 * @return
	 */
	public boolean delChangQiYiZhu(Long LTID);
	/**
	 * �޸ĳ���ҽ��
	 * @param NeiRong Ҫ�޸ĵ�����     0 ��ĿID  1 ����   2 �÷�    3 ��ҩ��ʽ    4 ����   5 ִ�п���ID 6 ִ��ʱ��    7 �´�ִ������    8��λ 
	 * @param LTID ����ҽ��ID
	 * @return
	 */
	public boolean updateChuangQiYiZhu(String[] NeiRong, Long LTID);
	/**
	 * ֹͣ�����¿�������ҽ��
	 * @param TingZhuYiSheng ͣ��ҽ��
	 * @param TingZhuShiJian ͣ��ʱ��
	 * @param XiaCiZhiXingRiQi �´�ִ������
	 * @param ID ����ҽ��ID
	 * @return
	 */
	public boolean updateTingZhu(Long TingZhuYiSheng, String TingZhuShiJian, String XiaCiZhiXingRiQi, Long ID);
	/**
	 * ֹͣ���г�δͣ�ĳ���ҽ��
	 * @param ZhuYuanHao סԺ��
	 * @param TingZhuYiSheng ͣ��ҽ��
	 * @param TingZhuShiJian ͣ��ʱ��
	 * @return boolean
	 */
	public boolean updateAllTingZhu(String ZhuYuanHao, Long TingZhuYiSheng, String TingZhuShiJian);
}
