package leo.yf.service.iface;

import java.util.List;
import leo.entity.Yfprice;
import leo.entity.SfpadjustRecord;

public interface YfpriceService {
	/**
	 * ��ѯҩƷ�۸�
	 * @param ExbankType ��������
	 * @param MInfoID ҩƷId
	 * @param MedicalInstID ҽ�ƻ���Id
	 * @return
	 */
	public List<Yfprice> getYfprice(String ExbankType, Integer MInfoID, Integer MedicalInstID);
	/**
	 * ȷ������
	 * @param JiaGe ��Ӧ�۸����ֶ�����
	 * @return
	 */
	public boolean addTiaoJia(String[][] JiaGe);
	public Long getCuiZai(String cklx, Integer ypID, Integer yljgID);
	/**
	 * �ɹ����ʱ������ҩƷ���ó���۸�
	 * @param YaoPinID_JiaGe ҩƷ��ϢID�����۸�
	 * @par4a;m ChuKuLeiXing �������ͼ��۸�
	 * @param YiLiaoJiaGouID ҽ�ƻ���ID
	 * @return
	 * 
	 */
	public boolean addCaiGouRuKuTiaoJia(String[][] YaoPinID_JiaGe, String[][] ChuKuLeiXing, Integer YiLiaoJiGouID);
}
