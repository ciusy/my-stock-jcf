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
	 * 提取挂员人员(电子病历使用)
	 * @param Date_B 挂号开始日期
	 * @param Date_e 挂号结束日期
	 * @param XingMing 姓名
	 * @param XingMingSuoXie 姓名缩写
	 * @param YiLiaoJiGou 医疗机构
	 * @return
	 */
	public String[][] getGhregisterDZ(String Date_B, String Date_e, String XingMing, String XingMingSuoXie, Integer YiLiaoJiGou);
}
