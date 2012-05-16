package leo.mz.service.iface;

import java.util.List;

import leo.entity.Czacontent;
import leo.entity.Czdispose;
import leo.entity.CzdisposeDivaricateU;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.MzopDn;

public interface MzopDnService {
	/**
	 * 
	 *通过门诊号得到门诊；
	 * 
	 * @param opnum)
	 * @param 
	 */
	public MzopDn getMzopDn(String opnum);
	/**
	 * 
	 * 根据项目ID查询开出科室对象
	 * 
	 * @param ID
	 * 
	 * @return CzdisposeDivaricateU
	 */
	public CzdisposeDivaricateU getCzdById(Long id);
	
	/**
	 * 
	 * 根据ID查询处置项目对象
	 * 
	 * @param ID
	 *            
	 * @return CzdisposeDivaricateU
	 */
	public List<CzdisposeItemDescribe> getCzdItemById(Long id);
	
	/**
	 * 
	 * 添加
	 * 
	 * @param CzdisposeDivaricateU 对象
	 *            
	 * @return 
	 */
	public void addCzdisposeDivaricateU(CzdisposeDivaricateU c);
	
	/**
	 * 
	 * 更新CzdisposeDivaricateU
	 * 
	 * @param CzdisposeDivaricateU 对象
	 *            
	 * @return 
	 */
	public void updateCzdisposeDivaricateU(CzdisposeDivaricateU c);
	
	/**
	 * 
	 * 删除
	 * 
	 * @param ID
	 *            
	 * @return 
	 */
	public void deleCzdisposeDivaricateU(Long id);
	
	/**
	 * 
	 * 根据ItemTypeID查询
	 * 
	 * @param ItemTypeID
	 *            
	 * @return updateCzdisposeDivaricateU集合
	 */
	public List<CzdisposeDivaricateU> getCzdisposeDivaricateUList(Integer id);
	
	/**
	 * 
	 * 添加CzdisposeItemDescribe
	 * 
	 * @param CzdisposeItemDescribe 对象
	 *            
	 * @return
	 */
	public void addCzdisposeItemDescribe(CzdisposeItemDescribe c);
	
	/**
	 * 
	 * 删除CzdisposeItemDescribe
	 * 
	 * @param ID
	 *            
	 * @return
	 */
	public void deleCzdisposeItemDescribe(Integer id);
	
	/**
	 * 
	 * 更新CzdisposeItemDescribe
	 * 
	 * @param CzdisposeItemDescribe 对象
	 *            
	 * @return
	 */
	public void updateCzdisposeItemDescribe(CzdisposeItemDescribe c);
	
	/**
	 * 根据主键查询处置项目描述
	 * @param id
	 * @return
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(Integer id);
	
	/**
	 * 
	 * 级联删除
	 * 
	 * @param 主见ID
	 *            
	 * @return
	 */
	public void deleCzdisposeItemDescribebyItemTypeId(Integer id);
	/**
	 * 返回流水号
	 * @return
	 */
	public String getNewOpNum();
	
	/**
	 * 
	 * 通过名称查询
	 * 
	 * @param name 名称
	 *            
	 * @return CzdisposeItemDescribe对象
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemName(String name);
	
	/**
	 * 
	 * 根据ID删除updateCzdisposeDivaricateU对象
	 * 
	 * @param itemTypeId
	 *            
	 * @return 
	 */
	public void deleCzdisposeDivaricateUByitemTypeId(Integer id);
	/**
	 * 
	 *模糊查询处置类型
	 * 
	 * @param spell
	 *            
	 * @return 
	 */
	public List<CzdisposeItemDescribe> getCzdisposeItemDescribeBySepll(String Sepll,int Mid);
	/**
	 * 
	 *添加门诊
	 * 
	 * @param mzopDn
	 *            
	 * @return 
	 */
	public boolean addMzopDn(MzopDn mzopDn);
	/**
	 * 
	 *修改门诊
	 * 
	 * @param mzopDn
	 *            
	 * @return 
	 */
	public boolean updateMzopDn(MzopDn mzopDn);
	public List<MzopDn> getMzopDnByOpnum(String opnum);
	public List<MzopDn> getMzopDnByCondition(String idcardNum);
	
	/**
	 * 
	 *通过条件查询门诊
	 * 
	 * @param 
	 *            
	 * @return 
	 */
	public String[][] getMzopDnByConditions(String csname,String idcardNum,String stime,String etime,String status);
	/**
	 * 门诊添加处置项
	 * @param czd
	 * @return
	 */
	public boolean addCzdispose(Czdispose czd,Czacontent cza);
	/**
	 * 门诊删除处置项
	 * @param czd
	 * @return
	 */
	public boolean delCzdispose(String itemId);
	/**
	 * 根据主键查询处置项
	 * @param itemId
	 * @return
	 */
	public Czdispose getCzdisposeByitemId(String itemId);
	/**
	 * 获取最大项目Id
	 * @return
	 */
	public String getMaxitemId();
	/**
	 * 添加处置项目
	 * @param czd
	 * @return
	 */
	public boolean addCzdispose(Czdispose czd);
	
	public boolean addCZAContent(Czacontent cza);
	
	public Czacontent getCZAContentByItemId(String itemId);
	
	public List<Czdispose> getCzdisposeByKindID(String kindId);
	public boolean deleteByopId(String opId);
	public List<MzopDn> getMZOpDnByDate(long csId,String st,String ed) throws Exception;
	public MzopDn getMzopDnByOpDnID(String opDnId);
	public List<MzopDn> getMzopDnBySf(String csname, String spell,String IDcardnum,String stdate,String eddate) throws Exception;
	public String[][] getMzopDnForchaxun(String csname,String spell, String idcardNum,
			String stime, String etime, String status);
	public boolean mzforSF(String opdnid);
}
