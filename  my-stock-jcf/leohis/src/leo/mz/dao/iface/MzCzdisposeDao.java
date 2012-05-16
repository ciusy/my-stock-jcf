package leo.mz.dao.iface;

import java.util.List;

import leo.entity.Czdispose;

/**
 * 门诊处置项
 * @author abc
 *
 */
public interface MzCzdisposeDao {
	/**
	 * 门诊添加处置项
	 * @param czd
	 * @return
	 */
	public boolean addCzdispose(Czdispose czd);
	/**
	 * 门诊删除处置项
	 * @param czd
	 * @return
	 */
	public boolean delCzdispose(Czdispose czd);
	/**
	 * 根据主键查询处置项
	 * @param itemId
	 * @return
	 */
	public Czdispose getCzdisposeByitemId(String itemId);
	/**
	 * 获得itemID最大号
	 * @return
	 */
	public String getMaxitemId();
	/**
	 * 通过种类ID获得处置项目
	 * @param KindID
	 * @return
	 */
	public List<Czdispose> getCzdisposeByKindID(String kindId);
	/**
	 * 提取住院处置项目
	 * @param ZhuYuanHao 住院号
	 * @param ShenQiShiJian_B 开始申请时间
	 * @param ShenQiShiJian_E 结束申请时间
	 * @param ZhuangTai 状态
	 * @return
	 */
	public List<Czdispose> getZhuYuan(String ZhuYuanHao, String ShenQiShiJian_B, String ShenQiShiJian_E, String ZhuangTai);
	/**
	 * 住院删除处置项
	 * @param ItemID 处置ID
	 * @return
	 */
	public boolean delCzdisposeZY(String ItemID);
	/**
	 * 得到住院人员处置项目总金额
	 * @param ZhuYuanHao 住院号
	 * @return
	 */
	public Double getChuZhiZhuYuanZongJinE(String ZhuYuanHao);
}
