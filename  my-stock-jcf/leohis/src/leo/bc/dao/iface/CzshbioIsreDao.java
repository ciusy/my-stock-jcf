package leo.bc.dao.iface;

import leo.common.dao.Dao;
import leo.entity.CzshbioIsre;

public interface CzshbioIsreDao extends Dao<CzshbioIsre>{
	public boolean  addCzshbioIsre(CzshbioIsre czshbioIsre);//��д�������鱨�棻
	/**
	 * �������ID��ȡ��������(����ʹ��)
	 * @param OpDnID ���ID
	 * @param ItemName ��Ŀ����(�գ�����һ����Ϻŵ����л�����Ŀ)
	 * @return 0�����Ŀ  1������������  2����Ӣ������  3������  4�ο���Χ  5��λ  6��ʾ
	 */
	public String[][] getCzshbioIsreByOpDnID(String OpDnID, String ItemName);
	/**
	 * ������ĿID����Ŀ������ȡ��������(վ��ʹ��)
	 * @param ItemID ��ĿID
	 * @param ItemName ��Ŀ����
	 * @return
	 */
	public String[][] getCzshbioIsreByItemID(String ItemID, String ItemName);

}
