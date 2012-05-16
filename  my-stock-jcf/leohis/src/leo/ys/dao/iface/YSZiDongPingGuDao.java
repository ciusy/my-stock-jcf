package leo.ys.dao.iface;

import leo.common.dao.Dao;
import leo.entity.WifeGeneralSelf;

public interface YSZiDongPingGuDao extends Dao<WifeGeneralSelf>{
	/**
	 * 提取妻子一般情况并转换为2版格式(自动评估使用)
	 * @param RecordID 档案号
	 * @return
	 */
	public String[][] getQiZiYiBanQingKuangTo2(String RecordID);
	/**
	 * 提取丈夫一般情况并转换为2版格式(自动评估使用)
	 * @param RecordID
	 * @return
	 */
	public String[][] getZhangFuYiBanQingKuangTo2(String RecordID);
	/**
	 * 提取自动评估表头内容
	 * @param LeiXing 类型:正常，异常
	 * @return 0:ID 1:内容
	 */
	public String[][] getMoBanBiaoTou(String LeiXing);
	/**
	 * 提取自动评估明细
	 * @param ID 模板头ID
	 * @return 0:条件 1:性别 2:关系 3:结果 4:可用结果
	 */
	public String[][] getMoBanMinXi(Long ID);
	/**
	 * 提取妻子体格检查并转换为2版格式(自动评估使用)
	 * @param RecordID 档案号
	 * @return
	 */
	public String getQiZiTiGeTo2(String RecordID);
	/**
	 * 提取妻子妇科检查并转换为2版格式(自动评估使用)
	 * @param RecordID 档案号
	 * @return
	 */
	public String getQiZiFuKeTo2(String RecordID);
	/**
	 * 提取丈夫体格检查并转换为2版格式(自动评估使用)
	 * @param RecordID 档案号
	 * @return
	 */
	public String getZangFuTiGeTo2(String RecordID);
	/**
	 * 提取丈夫体格检查并转换为2版格式(自动评估使用)
	 * @param RecordID 档案号
	 * @return
	 */
	public String getZangFuNanKeTo2(String RecordID);
	/**
	 * 提取人员信息
	 * @param KaiShiRiQi 开始日期
	 * @param JieSuRiQi 结束日期
	 * @param XingBie 性别
	 * @return
	 */
	public String[][] getRenYuan(String KaiShiRiQi, String JieSuRiQi, String XingBie);
	/**
	 * 提取尿常规结果
	 * @param DangAnHao 档案号
	 * @param XingBie 性别
	 * @return
	 */
	public String getNiaoChangGui(String DangAnHao, String XingBie);
	/**
	 * 获得总编号起始数
	 * @param RiQi 日期
	 * @return
	 */
	public String getBianHao(String RiQi);
	
}
