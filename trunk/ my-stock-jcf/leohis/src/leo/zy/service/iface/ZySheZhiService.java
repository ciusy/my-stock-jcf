package leo.zy.service.iface;

import java.util.List;

import leo.entity.GhcostType;
import leo.entity.Zybed;
import leo.entity.ZynurseGrade;

public interface ZySheZhiService {
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
	 * 修改床位
	 * @param ChuangWeiHao 床位号
	 * @param ChuangWei 床位
	 * @return
	 */
	public boolean updateChuagnWei(Integer ChuangWeiHao, List<Zybed> ChuangWei);
	/**
	 * 删除床位
	 * @param ID ID号
	 * @return
	 */
	public boolean delChuangWei(Integer ID);
	/**
	 * 修改床位状态
	 * @param ChuangWeiHao 床位号
	 * @param ZhuangTai 状态
	 * @param ZhuYuanBu 住院部ID
	 * @return
	 */
	public boolean updateChuangWeiZhuangTai(Integer ChuangWeiHao, String ZhuangTai, Integer ZhuYuanBu);
	/**
	 * 提取费用类型
	 * @param ID 费用类型ID   -2:所有费用类型
	 * @param YiLiaoJiGou 医疗机构ID
	 * @return
	 */
	public List<GhcostType> getFeiYongLeiXing(Integer ID, Integer YiLiaoJiGou);
	/**
	 * 提取护理级别
	 * @param JiBieID 护理级别ID
	 * @param JiBieMingCheng 护理级别名称
	 * @return
	 */
	public List<ZynurseGrade> getZynurseGrade(Integer JiBieID, String JiBieMingCheng);
}
