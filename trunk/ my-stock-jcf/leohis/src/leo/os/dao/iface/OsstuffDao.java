package leo.os.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Osstuff;

public interface OsstuffDao extends Dao<Osstuff> {
	/**
	 * 通过登录名和密码查找对应员工
	 * 
	 * @param loginname
	 *            登录名
	 * @param password
	 *            密码
	 * @return
	 */
	public Osstuff getStuffByNameAndPassword(String loginname, String password);
	/**
	 * 通过员工ID
	 * 
	 * @param sid
	 *           
	 * 
	 *           
	 * @return
	 */
	public Osstuff getStuffBySid(Long sid);

	/**
	 * 通过科室ID查找对应的专家医生
	 * 
	 * @param uid
	 *            科室ID
	 * @return
	 */
	public List<Osstuff> getExpertStuffByUid(int uid);

	/**
	 * add by xu 根据ids集合查找所有的医护人员
	 * 
	 * @param ids
	 * @return
	 */
	public List<Osstuff> getByIds(List<Long> ids);

	/**
	 * add by zhong 更改用户密码:传入参数为用户名，原密码，新密码，确认的新密码，返回是否修改成功的字符串。
	 * 
	 */
	public String changePassword(String loginname, String oldpassword, String newpassword1, String newpassword2);

	/**
	 * 查找是专家的医护人员
	 * 
	 * @return
	 */
	public List<Osstuff> getExpertSBasicInfo(int uid);

	public List<Osstuff> getOsstuff(Integer meiid); // 根据医疗结构返回工作人员

	/**
	 * 通过ID获得医疗人员姓名
	 * 
	 * @param uid
	 *            医疗人员ID
	 * @return
	 */
	public String getSNameBySid(long sid);

	/**
	 * add bu xu
	 * @param medicalOrgnizal 
	 */
	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal);

	/**
	 * add by xu
	 * @param medicalOrgnizal 
	 * 
	 * @param spellName
	 * @return
	 */
	public List<List<String>> getAllOsstuff(Integer medicalOrgnizal, String name, Boolean isSpell);
	
	/**
	 * 根据员工ID提取记账余额
	 * @param SID 员工ID
	 * @return
	 */
	public Double getYuE(Long SID);
	/**
	 * 根据科室ID提取人员名称和编号
	 * @param ksid //科室ID
	 * @param ZhiCheng //职称
	 * @return
	 */
	public String[][] getNameAndID(Integer ksid, String ZhiCheng);
	/**
	 * 提取员工
	 * @param sname 姓名
	 * @param spell 拼音缩写
	 * @param zige 资格名称
	 * @param zhiwu 行政职务
	 * @param bianzhi 编制类型
	 * @param uid 默认科室
	 * @param mid 所属医疗机构
	 * @return
	 */
	public List<Osstuff> getOsstuffBycondition(String sname,String spell,String zige,String zhiwu,String bianzhi,int uid,int mid);
	public boolean addOsstuff(Osstuff osstuff);
	public boolean updateOsstuff(Osstuff osstuff);
	public boolean deleteOsstuff(Osstuff osstuff);
	/**
	 * 按照医疗机构和登录名称查找是否存在
	 * @param lgname 登录名称
	 * @param mid 医疗机构ID
	 * @param SID 员工ID (-2：忽略此条件，用以修改判断)
	 * @return
	 */
	public boolean loginname(String lgname,int mid,Long SID);
	public Osstuff getOsstuffByLoginname(String lgname,int mid);
	/**
	 * 根据员工ID删除员工
	 * @param SID 员工ID
	 * @return
	 */
	public boolean delOsstuffById(Long SID);
	/**
	 * 修改员工用户名和密码
	 * @param SID 员工ID
	 * @param LoginName 用户名
	 * @param Password 密码
	 * @return
	 */
	public boolean updateYongHu(Long SID, String LoginName, String Password);
	/**
	 * 判断用户登录名称是否存在
	 * @param LoginName 登录名称
	 * @param SID 员工ID
	 * @return true 存在  false 不存在
	 */
	public boolean getYongHuCunZai(String LoginName, Long SID);
	 public String[][] getsnamesidbyuid(int uid);
}
