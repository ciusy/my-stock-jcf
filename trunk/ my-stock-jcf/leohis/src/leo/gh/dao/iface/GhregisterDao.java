package leo.gh.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Ghregister;

public interface GhregisterDao extends Dao<Ghregister> {
	public boolean addGhregister(Ghregister ghregister);
	public List<Ghregister> getAllGhregister();
	public Ghregister getGhregisterByOpnum(String opnum);
	public boolean updateGhregister(Ghregister ghregister);
	public boolean deleteGhregister(Ghregister ghregister);
	public String getMaxopnumByDate(String date);
	public List<Ghregister> getGhregisterfortg(long sid,String stdate,String eddate) throws Exception;
	public String[][] getGhregisterByCondition(String strDate,String endDate,String csName,String mcardNum,String opNum,String cscardNum,int uid);
	public String[][] getGhregisterByDateandRstatus(String stdate,String eddate,String rstatus,int uid);
	/**
	 * ��ȡ��Ա��Ա(���Ӳ���ʹ��)
	 * @param Date_B �Һſ�ʼ����
	 * @param Date_e �ҺŽ�������
	 * @param XingMing ����
	 * @param XingMingSuoXie ������д
	 * @param YiLiaoJiGou ҽ�ƻ���
	 * @return
	 */
	public String[][] getGhregisterDZ(String Date_B, String Date_e, String XingMing, String XingMingSuoXie, Integer YiLiaoJiGou);
}
