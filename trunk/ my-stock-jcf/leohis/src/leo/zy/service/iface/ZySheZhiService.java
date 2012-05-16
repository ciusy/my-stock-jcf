package leo.zy.service.iface;

import java.util.List;

import leo.entity.GhcostType;
import leo.entity.Zybed;
import leo.entity.ZynurseGrade;

public interface ZySheZhiService {
	/**
	 * ��ȡ��λ
	 * @param ChuangWeiHao ��λ��
	 * @param ZhuangTai ״̬
	 * @param NanVu ��Ů
	 * @param ZhuYuanBu סԺ��
	 * @return
	 */
	public String[][] getChuangWei(Integer ChuangWeiHao, String ZhuangTai, String NanVu, Integer ZhuYuanBu);
	/**
	 * ���Ӵ�λ
	 * @param ChuangWei
	 * @return
	 */
	public boolean addChuangWei(List<Zybed> ChuangWei);
	/**
	 * �޸Ĵ�λ
	 * @param ChuangWeiHao ��λ��
	 * @param ChuangWei ��λ
	 * @return
	 */
	public boolean updateChuagnWei(Integer ChuangWeiHao, List<Zybed> ChuangWei);
	/**
	 * ɾ����λ
	 * @param ID ID��
	 * @return
	 */
	public boolean delChuangWei(Integer ID);
	/**
	 * �޸Ĵ�λ״̬
	 * @param ChuangWeiHao ��λ��
	 * @param ZhuangTai ״̬
	 * @param ZhuYuanBu סԺ��ID
	 * @return
	 */
	public boolean updateChuangWeiZhuangTai(Integer ChuangWeiHao, String ZhuangTai, Integer ZhuYuanBu);
	/**
	 * ��ȡ��������
	 * @param ID ��������ID   -2:���з�������
	 * @param YiLiaoJiGou ҽ�ƻ���ID
	 * @return
	 */
	public List<GhcostType> getFeiYongLeiXing(Integer ID, Integer YiLiaoJiGou);
	/**
	 * ��ȡ������
	 * @param JiBieID ������ID
	 * @param JiBieMingCheng ����������
	 * @return
	 */
	public List<ZynurseGrade> getZynurseGrade(Integer JiBieID, String JiBieMingCheng);
}
