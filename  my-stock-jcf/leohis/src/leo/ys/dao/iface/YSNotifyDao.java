package leo.ys.dao.iface;

import leo.common.dao.Dao;
import leo.entity.Notify;

public interface YSNotifyDao extends Dao<Notify>{
	/**
	 * 提取告知短信人员
	 * @param TianShu 前后天数
	 * @return
	 */
	public String[][] getGaoZhiDuanXinRenYuan(Integer TianShu);
	/**
	 * 根据档案号提取告知内容
	 * @param DangAnHao 档案号
	 * @return
	 */
	public String getGaoZhiNeiRong(String DangAnHao);

}
