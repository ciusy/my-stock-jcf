package leo.ys.service.iface;

public interface YSZhanNeiService {
	/**
	 * ��ȡ�����Ŀ
	 * @param YiLiaoJiGou ҽ�ƻ���ID
	 * @param FuWuDuiXiangID �������ID
	 * @param XiangMuLeiXingID ��Ŀ����ID(һά����)
	 * @param YiShengID ҽ��ID
	 * @param KeShiID ����ID
	 * @param ShiJian ��ǰʱ��(yyyy-mm-dd hh:mm:ss)
	 * 
	 * @return ���ID
	 */
	public String addTiJiaoJianChaXiangMu(Integer YiLiaoJiGouID, Long FuWuDuiXiangID, Integer[] XiangMuLeiXingID, Long YiShengID, Integer KeShiID, String ShiJian);
	/**
	 * �������ID��ȡ��������
	 * @param ZhenDuanHao ���ID
	 * @param XiangMu ��Ŀ����(�գ�����һ����Ϻŵ����л�����Ŀ)
	 * @return 0�����Ŀ  1������������  2����Ӣ������  3������  4�ο���Χ  5��λ  6��ʾ
	 */
	public String[][] getJianChaShuJu(String ZhenDuanHao, String XiangMu);
}
