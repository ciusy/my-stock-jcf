package leo.ys.service.iface;

public interface YSZhanNeiService {
	/**
	 * 提取检查项目
	 * @param YiLiaoJiGou 医疗机构ID
	 * @param FuWuDuiXiangID 服务对象ID
	 * @param XiangMuLeiXingID 项目类型ID(一维数据)
	 * @param YiShengID 医生ID
	 * @param KeShiID 科室ID
	 * @param ShiJian 当前时间(yyyy-mm-dd hh:mm:ss)
	 * 
	 * @return 诊断ID
	 */
	public String addTiJiaoJianChaXiangMu(Integer YiLiaoJiGouID, Long FuWuDuiXiangID, Integer[] XiangMuLeiXingID, Long YiShengID, Integer KeShiID, String ShiJian);
	/**
	 * 根据诊断ID提取化验数据
	 * @param ZhenDuanHao 诊断ID
	 * @param XiangMu 项目名称(空：返回一个诊断号的所有化验项目)
	 * @return 0检查项目  1子项中文名称  2子项英文名称  3子项结果  4参考范围  5单位  6提示
	 */
	public String[][] getJianChaShuJu(String ZhenDuanHao, String XiangMu);
}
