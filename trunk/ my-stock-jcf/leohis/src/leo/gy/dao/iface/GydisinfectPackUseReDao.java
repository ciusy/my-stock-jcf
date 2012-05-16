package leo.gy.dao.iface;

import java.util.List;

import leo.entity.GydisinfectPackInstance;
import leo.entity.GydisinfectPackUseRe;
import leo.entity.GysupplyDisinfectPackInfo;

public interface GydisinfectPackUseReDao {
	//查看本科室所有无菌包
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit();
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit);
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(String DPN);
	public List<GydisinfectPackUseRe> getAllGydisinfectPackInUnit(int Unit,String DPN);
	
	//查看本科室领用无菌包
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow();
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(int Unit);
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(String DPN);
	public List<GydisinfectPackUseRe> getAllGydisinfectPackBorrow(int Unit,String DPN);
	
	//根据无菌包ID查询出来使用记录，并把归还时间填上
	public boolean ModifyGydisinfectPackBackTime(int id);
	
	//向消毒包使用记录表里插入一条数据
	public boolean addGydisinfectPackUseReInfo(GydisinfectPackUseRe g);
	
	//无菌包归还方法用于无菌包归还页面，根据无菌包Id，科室id到使用记录表里查状态为没归还的（false），
	public boolean BackGydisinfectPack(int id,int u);
	
	/**使用明细
	 * 
	 * @param StartDate 开始时间
	 * @param CutOffDate 截止时间
	 * @param strUnit	领用科室
	 * @param strDPN	无菌包类型
	 * @return
	 */
	public List<GydisinfectPackUseRe> GetUseRe(String StartDate,String CutOffDate,String strUnit,String strDPN);
	/**
	 * 由消毒包ID获得使用科室为-1的使用ID UseID
	 * 科室为-1代表暂时没有科室使用，可以是已申请
	 * @param dpid   int 消毒包ID
	 * @return  UseID int 使用ID
	 * added by Sun
	 */
	public Long getUidByDpid(int dpid);
	/**
	 * 通过使用ID删除一条数据
	 * @param UseId   int 使用ID
	 * @return
	 * added by sun
	 */
	public boolean deleteUseInfo(Long UseId);
	/**
	 * 通过消毒包ID和领用时间为默认值来确定数据条，并把该数据条的领用时间字段更新为系统当前时间
	 * 
	 * @param Dpid		int 消毒包ID
	 * @param Uid      int 申请人所在科室ID
	 * @param amount   double 一次使用费用
	 * @return
	 * added by sun
	 */
	public boolean setDtByDpidandDt(int Dpid,int Uid,double amount);
	/**
	 * 通过消毒包ID和是否已还为false来确定查找数据，更新是否已还为true，归还时间为系统当前时间
	 * @param Dpid  	int 消毒包ID
	 * @return
	 * added by sun
	 */
	public boolean setghByDpidandRt(int Dpid);
	/**
	 * 供应室使用，根据领用时间、归还时间、科室、无菌包类型查询无菌包使用记录
	 * @param Dt		String  领用时间
	 * @param Rt		String  归还时间
	 * @param Uid		int     科室ID
	 * @param Did		int     无菌包种类ID
	 * @return
	 * added by sun
	 */
	public List<GydisinfectPackUseRe> getmxByDtandRtandUidandDid(String Dt,String Rt,int Uid,int Did);

}
