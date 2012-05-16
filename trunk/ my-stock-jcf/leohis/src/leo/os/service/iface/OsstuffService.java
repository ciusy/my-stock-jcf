package leo.os.service.iface;

import java.util.List;

import leo.entity.OsfnAuthorityForm;
import leo.entity.Osstuff;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 3, 2011 5:04:30 PM
 */
public interface OsstuffService {
	public List<Osstuff> getOsstuff(Integer meiid);
	public Osstuff getStuffBySid(Long sid);
	public String getSNameBySid(long sid);
	public Double getYuE(Long SID);
	public String[][] getNameAndID(Integer ksid, String ZhiCheng);
	/**
	 * 通过条件查询员工
	 * @param sname 姓名
	 * @param zige 资格
	 * @param zhiwu 职务
	 * @param bianzhi 编制
	 * @param uid 默认科室
	 * @param mid 所属医疗机构
	 * @return
	 */
	public List<Osstuff> getOsstuffBycondition(String sname,String spell,String zige,String zhiwu,String bianzhi,int uid,int mid);
	/**
	 * 添加人员
	 * @param osstuff 员工信息
	 * @param KeShiID 科室ID(如果选择默认科室,则自动分配到此科室,-2:不分配科室)
	 * @param CaiDan 菜单
	 * @param MoRenCaiDan 有默认菜单吗
	 * @return
	 */
	public boolean addOsstuff(Osstuff osstuff, Integer KeShiID);
	/**
	 * 修改人员
	 * @param osstuff 员工信息
	 * @param YongGongID 员工ID
	 * @param MoRenKeShi_Y 原默认科室
	 * @param MoRenKeShi_X 现默认科室
	 * @return
	 */
	public boolean updateOsstuff(Osstuff osstuff, Long YongGongID, Integer MoRenKeShi_Y, Integer MoRenKeShi_X);
	/**
	 * 删除人员
	 * @param osstuff
	 * @return
	 */
	public boolean deleteOsstuff(Osstuff osstuff);
	/**
	 * 按照医疗机构和登录名称查找是否存在
	 * @param lgname 登录名称
	 * @param mid 医疗机构ID
	 * @param SID 员工ID (-2：忽略此条件，用以修改判断)
	 * @return
	 */
	public boolean loginname(String lgname,int mid,Long SID);
	/**
	 * 查询科室人员
	 * @param lgname
	 * @param mid
	 * @return
	 */
	public Osstuff getOsstuffByLoginname(String lgname,int mid);
	/**
	 * 根据员工ID删除员工
	 * @param SID 员工ID
	 * @return
	 */
	public boolean delOsstuffById(Long SID);
	/**
	 * 查科室下人员
	 * @param uid
	 * @return
	 */
	 public String[][] getsnamesidbyuid(int uid);
}
