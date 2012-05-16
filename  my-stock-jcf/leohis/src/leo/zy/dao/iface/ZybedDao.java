package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Zybed;

public interface ZybedDao extends Dao<Zybed>{ 
	/**
	 * 提取床位
	 * @param ChuangWeiHao 床位号
	 * @param ZhuangTai 状态
	 * @param NanVu 男女
	 * @param ZhuYuanBu 住院部
	 * @return
	 */
	public String[][] getChuangWei(Integer ChuangWeiHao, String ZhuangTai, String NanVu, Integer ZhuYuanBu);
	/**
	 * 增加床位
	 * @param ChuangWei
	 * @return
	 */
	public boolean addChuangWei(List<Zybed> ChuangWei);
	/**
	 * 删除床位
	 * @param ID 床位号
	 * @return
	 */
	public boolean delChuagnWei(Integer ID);
	/**
	 * 修改床位状态
	 * @param ChuangWeiHao 床位号
	 * @param ZhuangTai 状态
	 * @param ZhuYuanBu 住院部ID
	 * @return
	 */
	public boolean updateChuangWeiZhuangTai(Integer ChuangWeiHao, String ZhuangTai, Integer ZhuYuanBu);
}
