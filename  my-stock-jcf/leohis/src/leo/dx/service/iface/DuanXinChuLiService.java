package leo.dx.service.iface;

import java.util.List;

import leo.entity.HealthyPregnantSms;
import leo.entity.SuccessfulSms;

public interface DuanXinChuLiService {
	/**
	 * 提取已发短信记录
	 * @param ShiJian_B 发送开始时间
	 * @param ShiJian_E 发送结束时间
	 * @param ZhuangTai 状态
	 * @param MoKuai 模块
	 * @param UnitID 单位
	 * @return
	 */
	public String[][] getYiFaXinXi(String ShiJian_B, String ShiJian_E, String ZhuangTai, String MoKuai, Integer UnitID);
	/**
	 * 根据状态和单位提取优生短信内容，以便发送
	 * @param ZhuangTai 状态
	 * @param DanWeiID 单位ID
	 * @return
	 */
	public List<HealthyPregnantSms> getYouShengDuanXin(String ZhuangTai, Integer DanWeiID);
	/**
	 * 发信处理
	 * @param DuanXinJiLu 短信记录表
	 * @param LeiXing 类型 ：新发   重发
	 * @return
	 */
	public boolean updateFaXinChuLi(List<SuccessfulSms> DuanXinJiLu, String LeiXing);
	/**
	 * 提取所有模板项内容
	 * @return
	 */
	public String[][] getAllXiangNeiRong();
	
}


