package leo.ys.dao.iface;

import leo.common.dao.Dao;
import leo.entity.Notify;

public interface YSNotifyDao extends Dao<Notify>{
	/**
	 * ��ȡ��֪������Ա
	 * @param TianShu ǰ������
	 * @return
	 */
	public String[][] getGaoZhiDuanXinRenYuan(Integer TianShu);
	/**
	 * ���ݵ�������ȡ��֪����
	 * @param DangAnHao ������
	 * @return
	 */
	public String getGaoZhiNeiRong(String DangAnHao);

}
