package leo.os.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;

public interface OsuformDao extends Dao<Osuform> {
	/**
	 * 查找医疗人员所属的科室(LoginService)调用
	 * @param uid
	 * @return
	 */
	public Osuform getUformByUid(int uid);
	/**
	 * 查找可挂号的科室 （gh模块调用）
	 * @return
	 */
	public List<Osuform> getRegestUFormByMid(int mid);
	/**
	 * 通过医疗ID查找开出科室
	 * @param mid 医疗机构ID
	 * @return 
	 */
	public List<Osuform> getRegisterDivaricateUByMid(int mid);
	/**
	 * 通过费用类型ID查找科室
	 * @param rId 费用类型Id
	 * @return 
	 */
	
	public String[] getUformByRidAndMid(int rtId,int uid);
	/**
	 * added by Li Chenghai
	 * 通过ID获得科室名称
	 * @param uid 科室ID
	 * @return
	 */
	public String getUNameByUid(int uid);
	/**
	 * added by Li Chenghai
	 * 通过ID获得科室对象
	 * @param uid 科室ID
	 * @return
	 */
	public Osuform getOsuformByUid(int uid);
	/**
	 * added by Li Chenghai
	 * 通过科室类别和医疗机构ID获得科室ID和科室名称,科室类别可为空
	 * @param oType 科室类别 ，mid 医疗机构ID
	 * @return
	 */
	public String[][] getUformByOTypeAndMid(String oType , int mid);
	/**
	 * added by Li Chenghai
	 * 通过医疗机构ID和科室名称获得科室
	 * @param mid 医疗机构  uname 科室名称
	 * @return
	 */
	public int getUidByUName(int mid , String uname);
	/**
	 * added by Li Chenghai
	 * 通过员工ID和科室类别返回全部科室ID和名称，返回科室顺序可从oTypename中定义
	 * @param sid 员工ID
	 * @return
	 */
	public String[][] getUidBySidAndOType(int sid,String[] otypename);
	
	/**
	 * 根据医疗机构ID和科室类型查询科室
	 * @param meiId 医疗机构ID
	 * @param oType	科室类型
	 * @return	科室集合
	 */
	public List<Osuform> getOsuformByMEIIDandOType(int meiId, String oType);
	/** 
	 * add by xu 
	 * @param osUFormIds
	 * @return
	 */
	public List<Osuform> getOsuformsByIds(List<Integer> osUFormIds);
	/**
	 * 提取除此类型以外的科室名称和ID
	 * @param oType
	 * @param mid
	 * @return
	 */
	public String[][] getUformNotType(String oType , int mid);
	public List<Osuform> getUFormByMid(Integer mid);
	public boolean addUForm(Osuform osuform);
	/**
	 * 修改科室
	 * @param osuform
	 * @return
	 */
	public boolean updateUForm(Osuform osuform);
	public boolean deleteUForm(Osuform osuform);
	/**
	 * 按照科室ID删除科室
	 * @param ID科室ID
	 * @return
	 */
	public boolean delUformByID(Integer ID);
	
}
