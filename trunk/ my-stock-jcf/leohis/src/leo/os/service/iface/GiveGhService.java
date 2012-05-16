package leo.os.service.iface;

import java.util.List;

import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.Osuform;

public interface GiveGhService {
	/**
	 * 获得所有科室
	 * @return
	 */
	public List<Osuform> getRegestUFormByMid(int mid);
	/**
	 * 通过费用类型获得科室ID和科室名称
	 * @param rtId 费用类型ID
	 * @return
	 */
	public String[] getUformByRidAndMid(int rtId,int mid);
	/**
	 * 通过科室ID查找对应的专家医生
	 * @param uid 科室ID
	 * @return
	 */
	public List<Osstuff> getExpertStuffByUid(int uid);
	/**
	 * 根据医疗机构id查询医疗机构对象
	 * @param mid
	 * @return
	 */
	public OsmedicalInstInfo getOsmedicalInstInfoById(int mid);
	/**
	 * 通过医疗机构ID获得开出科室
	 * @param mid 医疗机构id
	 * @return
	 */
	public List<Osuform> getRegisterDivaricateUByMid(int mid);
	/**
	 * 通过ID获得医疗人员姓名
	 * @param uid 医疗人员ID
	 * @return
	 */
	public String getSNameBySid(long sid);
	public int getUidByUName(int mid , String uname);
}
