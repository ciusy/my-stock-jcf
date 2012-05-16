package leo.mz.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.MzopDn;

public interface MzopDnDao extends Dao<MzopDn> {

	/**
	 * 
	 * add by xu 得到当天待收费的所有诊断对象
	 * 
	 * @param officeId
	 *            当前登录者的科室ID
	 * @return
	 */
	List<MzopDn> getNowDayMZop(Integer officeId);

	/**
	 * * add by xu 根据服务对象的id 的集合得到所有的待收费的本科室的所有的诊断对象
	 * 
	 * @param consumerIds
	 * @param startTime
	 * @param endTime
	 * @param officeId 
	 * @return
	 */
	List<MzopDn> getMzopDn(List<Long> consumerIds, String startTime, String endTime, int officeId);
    public MzopDn getMzopDn(String opnum);
    
    /**
     * 查询流水号
     * 取前五个数据按降序排列
     * @return 
     */
    public List<MzopDn> getNewOpNum();

	List<MzopDn> getMzopDnByIDs(List<String> ids);
	/**
     * 添加新的门诊
     * 
     * @return 
     */
	public boolean addMzopDn(MzopDn mzopDn);
	/**
     * 
     * 修改门诊
     * @return 
     */
	public boolean updateMzopDn(MzopDn mzopDn);
	/**
     * 
     * 通过门诊号查询门诊
     * @return 
     */
	public List<MzopDn> getMzopDnByOpnum(String opnum);

	/**
	 * 修改门诊诊断
	 * @param ZhenDuanHao 诊断号
	 * @param ZhuangTai 状态
	 * @return
	 */
	public boolean updateZhenDuanZhuangTai(String ZhenDuanHao, String ZhuangTai);

	/**
     * 
     * 通过身份证查询门诊
     * @return 
     */
	public List<MzopDn> getMzopDnByCondition(String idcardNum);
	public String[][] getMzopDnByConditions(String csname,String idcardNum,String stime,String etime,String status);
	public List<MzopDn> getMZOpDnByDate(long csId,String st,String ed) throws Exception;
	public MzopDn getMzopDnByOpDnID(String opDnId);
	public List<MzopDn> getMzopDnForTY(List<MzopDn> mzlist);
	public boolean deleteByopId(String opId);
	public String[][] getMzopDnForchaxun(String csname,String spell, String idcardNum,
			String stime, String etime, String status);
	public boolean mzforSF(String opdnid);
	public String getMaxId();
}
