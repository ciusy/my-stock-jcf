package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Zyipteatment;

public interface ZyipteatmentDao extends Dao<Zyipteatment> {
	/**
	 * ����סԺ����
	 * @param zyipteatment
	 * @return
	 */
	public boolean addZyipteatment(List<Zyipteatment> zyipteatment);
	/**
	 * �޸�סԺ���ñ�Ĵ�����ID
	 * @param IDS 0:DAItemID 1:ItemID
	 * @return
	 */
	public boolean updateZyipteatmentItemID(String[][] IDS);
	
	/**
	 * �ж�һ��ҽ�������Ƿ��в���ִ�еĴ�����Ŀ
	 * @param YiZhuHao ҽ������
	 * @return
	 */
	public boolean getChuZhiBuFenZhiXing(String YiZhuHao);
	/**
	 * �޸�סԺ���ñ�������뵥����
	 * @param ShenQingNeiRong ��������
	 * @param DAItemID ҽ����ID
	 * @return
	 */
	public boolean updateZyipteatmentAContent(String ShenQingNeiRong, Long DAItemID);
	/**
	 * �޸�סԺ���õ���Ŀ����ID��ִ�п���
	 * @param ItemTypeID ��Ŀ����ID
	 * @param ExecuteU ִ�п���
	 * @param DAItemID ҽ����ID
	 * @return
	 */
	public boolean updateZyipteatmentXiangMu(Integer ItemTypeID, Integer ExecuteU, Long DAItemID);
	/**
	 * ɾ��סԺ������Ŀ
	 * @param DAItemID ҽ����ID
	 * @return
	 */
	public boolean delZYIPTeatment(Long DAItemID);
}
