package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Zybed;

public interface ZybedDao extends Dao<Zybed>{ 
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
	 * ɾ����λ
	 * @param ID ��λ��
	 * @return
	 */
	public boolean delChuagnWei(Integer ID);
	/**
	 * �޸Ĵ�λ״̬
	 * @param ChuangWeiHao ��λ��
	 * @param ZhuangTai ״̬
	 * @param ZhuYuanBu סԺ��ID
	 * @return
	 */
	public boolean updateChuangWeiZhuangTai(Integer ChuangWeiHao, String ZhuangTai, Integer ZhuYuanBu);
}
