package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfsetExbankType;

public interface YfsetExbankTypeDao extends Dao<YfsetExbankType>{
	public boolean addYfsetExbankType(YfsetExbankType yfsetExbankType);
	/**
	 * ��ȡ��������
	 * @param ExbankID //��������ID
	 * @param PharmacyID //ҩ��ID
	 * @param ETypeName //������������
	 * @return
	 */
	public List<YfsetExbankType> getYfsetExbankType(Integer ExbankID, Integer PharmacyID, String ETypeName);
	/**
	 * ���ճ�������ID��ȡ������������
	 * @param ExbankID //��������ID
	 * @return
	 */
	public String getChuKuLeiXingName(Integer ExbankID);
	/**
	 * ����������ͺ�ҩ��ID�õ�����۸��
	 * @param LeiXing ��������(����)
	 * @param YaoFangID ҩ��ID
	 * @return
	 */
	public Double getRuChuJiaGeBi(String LeiXing, Integer YaoFangID);
	/**
	 * �޸ĳ�������
	 * @param yfsetExbankType
	 * @return
	 */
	public boolean updateYFSetExbankType(YfsetExbankType yfsetExbankType);
	
	/**
	 * ��ѯ���г�������
	 * @return
	 */
	public List<YfsetExbankType> getYfsetExbankTypeAll();
}
