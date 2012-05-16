package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfmwayTo;
import leo.entity.Yfprice;

public interface YfpriceDao extends Dao<Yfprice>{
	/**
	 * ��ȡ����۸�
	 * @param ExbankType ��������
	 * @param MInfoID ҩƷ��ϢID
	 * @param MedicalInstID ҽ�ƻ���ID
	 * @return
	 */
	public List<Yfprice> getYfprice(String ExbankType, Integer MInfoID, Integer MedicalInstID);
	/**
	 * �������۸�
	 * @param yfprice
	 * @return
	 */
	public boolean addYfprice(Yfprice yfprice);
	public Long getmaxID(); //�õ����۸��ID
	/**
	 * �ж�һ��ҩƷһ�ֳ��������Ƿ����
	 * @param cklx ��������
	 * @param ypID ҩƷ��ϢID
	 * @param yljgID ҽ�ƻ���ID
	 * @return
	 */
	public Long getCuiZai(String cklx, Integer ypID, Integer yljgID);
	/**
	 * �޸�ҩƷ����۸�
	 * @param cklx ��������
	 * @param ypID ҩƷ��ϢID
	 * @param yljgID ҽ�ƻ���ID
	 * @return je �۸�
	 */
	public boolean updateJiaGe(String cklx, Integer ypID, Integer yljgID, Double je);
	
}
