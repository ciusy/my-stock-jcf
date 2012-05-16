package leo.mz.dao.iface;

import java.util.List;

import leo.entity.Czdispose;

/**
 * ���ﴦ����
 * @author abc
 *
 */
public interface MzCzdisposeDao {
	/**
	 * ������Ӵ�����
	 * @param czd
	 * @return
	 */
	public boolean addCzdispose(Czdispose czd);
	/**
	 * ����ɾ��������
	 * @param czd
	 * @return
	 */
	public boolean delCzdispose(Czdispose czd);
	/**
	 * ����������ѯ������
	 * @param itemId
	 * @return
	 */
	public Czdispose getCzdisposeByitemId(String itemId);
	/**
	 * ���itemID����
	 * @return
	 */
	public String getMaxitemId();
	/**
	 * ͨ������ID��ô�����Ŀ
	 * @param KindID
	 * @return
	 */
	public List<Czdispose> getCzdisposeByKindID(String kindId);
	/**
	 * ��ȡסԺ������Ŀ
	 * @param ZhuYuanHao סԺ��
	 * @param ShenQiShiJian_B ��ʼ����ʱ��
	 * @param ShenQiShiJian_E ��������ʱ��
	 * @param ZhuangTai ״̬
	 * @return
	 */
	public List<Czdispose> getZhuYuan(String ZhuYuanHao, String ShenQiShiJian_B, String ShenQiShiJian_E, String ZhuangTai);
	/**
	 * סԺɾ��������
	 * @param ItemID ����ID
	 * @return
	 */
	public boolean delCzdisposeZY(String ItemID);
	/**
	 * �õ�סԺ��Ա������Ŀ�ܽ��
	 * @param ZhuYuanHao סԺ��
	 * @return
	 */
	public Double getChuZhiZhuYuanZongJinE(String ZhuYuanHao);
}
