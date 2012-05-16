package leo.os.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.OsfnAuthorityForm;

public interface OsfnAuthorityFormDao extends Dao<OsfnAuthorityForm>{
	/**
	 * 提取人员对应的菜单
	 * @param sid
	 * @return
	 */
	public List<OsfnAuthorityForm> getOsfnAuthorityFormBySid(long sid);
	/**
	 * 获得最大菜单ID号
	 * @return
	 */
	public Integer getCaiDanMaxID();
	/**
	 * 加入菜单
	 * @param osfnAuthorityForm 菜单内容
	 * @return
	 */
	public boolean addOSFnAuthorityForm(OsfnAuthorityForm osfnAuthorityForm);
	/**
	 * 按人员ID删除对应的菜单
	 * @param SID 人员ID
	 * @return
	 */
	public boolean delOSFnAuthorityForm(Long SID);
	/**
	 * 提取登录人员的完整菜单树
	 * @param sid 人员ID
	 * @return
	 */
	public String[][] getCaiDanShu(long sid);
	/**
	 * 根据菜单ID修改菜单名称
	 * @param MenuID 菜单ID
	 * @param MenuName 菜单名称
	 * @return
	 */
	public boolean updateCaiDanMingCheng(Integer MenuID, String MenuName);
	/**
	 * 删除菜单
	 * @param LeiXing 类型(所有,模块,功能)
	 * @param MenuID 菜单ID
	 * @param YuanGongID 员工ID
	 * @return
	 */
	public boolean delCaiDan(String LeiXing, Integer MenuID, Long YuanGongID);
	/**
	 * 设置快捷按钮
	 * @param MenuID 菜单ID
	 * @param QuickName 名称
	 * @param QuickImageID 图标ID
	 * @param QuickClass 功能类
	 * @return
	 */
	public boolean updateKuaiJieAnNiu(Integer MenuID, String QuickName, String QuickImageID, String QuickClass);
	/**
	 * 提取对应员工的快捷按钮
	 * @param SID
	 * @return
	 */
	public String[][] getKuaiJieAnNiu(Long SID);
	/**
	 * 提取对应菜单的快捷按钮
	 * @param MenuID
	 * @return
	 */
	public String[][] getKuaiJieAnNiuByCaiDanID(Integer MenuID);
	/**
	 * 提取目录
	 * @param sid 人员ID 
	 * @param FatherMenuID 父菜单ID
	 * @return
	 */
	public String[][] getMuLu(Long sid, Integer FatherMenuID);
	/**
	 * 调入目录
	 * @param MenuID 菜单ID
	 * @param FatherMenuID 父菜单ID
	 * @return
	 */
	public boolean updateMuLu(Integer MenuID, Integer FatherMenuID);
	/**
	 * 判断一个功能是否在目录里
	 * @param Sid 人员ID
	 * @param FatherMenuID 父菜单ID
	 * @return
	 */
	public String[][] getZaiMuLuLi(Long Sid, Integer FatherMenuID);
}
