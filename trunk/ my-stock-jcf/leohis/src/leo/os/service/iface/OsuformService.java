package leo.os.service.iface;

import java.util.List;

import leo.entity.OsfnBlocks;
import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;
import leo.entity.OsunitHasS;


public interface OsuformService {

	/**
	 * 通过ID获得科室名称
	 * @param uid 科室ID
	 * @return
	 */
	public String getUNameByUid(int uid);
	/**
	 * 通过ID获得科室对象
	 * @param uid 科室ID
	 * @return
	 */
	public Osuform getOsuformByUid(int uid);
	/**
	 * 通过科室类别和医疗机构ID获得科室ID和科室名称
	 * @param oType 科室类别 ，mid 医疗机构ID
	 * @return
	 */
	public String[][] getUformByOTypeAndMid(String oType , int mid);
	/**
	 * added by Li Chenghai
	 * 通过员工ID和科室类别返回全部科室ID和名称，返回科室顺序可从oTypename中定义
	 * @param sid 员工ID
	 * @return
	 */
	public String[][] getUidBySidAndOType(int sid,String[] otypename);
	
	/*
	 * added by sun
	 * 方法由LI写的，自己要调用，加了service里的接口
	 */
	
public String[][] getUidBySidAndOTypeForBchao(int sid,String otypename);
	
	/*
	 * added by sun
	 * 方法由LI写的，自己要调用，加了service里的接口
	 */
	
	public int getUidByUName(int mid , String uname);
	
	/**
	 * 根据医疗机构ID和科室类型查询科室
	 * @param meiId 医疗机构ID
	 * @param oType	科室类型
	 * @return	科室集合
	 */
	public List<Osuform> getOsuformByMEIIDandOType(int meiId, String oType);
	/**
	 * 根据科室ID查询科室对应的功能
	 * @param uid
	 * @return
	 */
	public List<OsfnBlocks> getFnBlocksByUID(Integer uid);
	/**
	 * 提取除此类型以外的科室名称和ID
	 * @param oType
	 * @param mid
	 * @return
	 */
	public String[][] getUformNotType(String oType , int mid);
	/**
	 * 通过医疗机构ID获得科室列表
	 * @param mid
	 * @return
	 */
	public List<Osuform> getUFormByMid(Integer mid);
	/**
	 * 添加科室
	 * @param osuform
	 * @return
	 */
	public boolean addUForm(Osuform osuform);
	/**
	 * 修改科室
	 * @param osuform
	 * @return
	 */
	public boolean updateUForm(Osuform osuform);
	/**
	 * 删除科室
	 * @param osuform
	 * @return
	 */
	public boolean deleteUForm(Osuform osuform);
	/**
	 * 通过科室ID查询科室人员
	 * @param uid
	 * @return
	 */
	public List<OsunitHasS> getOsunitHasSByUid(int uid);
	/**
	 * 查询全部医疗机构
	 * @return
	 */
	public List<OsmedicalInstInfo> getAllOsmedicalInstInfo();
	/**
	 * 添加科室人员
	 * @param osunitHasS
	 * @return
	 */
	public boolean addOsunitHasS(OsunitHasS osunitHasS);
	/**
	 * 修改科室人员
	 * @param osunitHasS
	 * @return
	 */
	public boolean updateOsunitHasS(OsunitHasS osunitHasS);
	/**
	 * 删除科室人员
	 * @param osunitHasS
	 * @return
	 */
	public boolean deleteOsunitHasS(OsunitHasS osunitHasS);
	/**
	 * 通过sid查科室人员
	 * @param sid
	 * @return
	 */
	public List<OsunitHasS> getOsunitHasSBySid(long sid);
	/**
	 * 删除sid下人员科室
	 * @param sid
	 * @return
	 */
	public boolean deleteOsunitHasSBySid(long sid);
	/**
	 * 通过sid uid添加人员科室
	 * @param sid
	 * @param uidlist
	 * @return
	 */
	public boolean addOsunitHasSBySidandUid(long sid, int[] uidlist);
}
