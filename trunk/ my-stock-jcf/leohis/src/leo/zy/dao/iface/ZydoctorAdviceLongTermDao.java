package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.ZydoctorAdviceLongTerm;

public interface ZydoctorAdviceLongTermDao extends Dao<ZydoctorAdviceLongTerm>{
	/**
	 * 保存住院长期医嘱
	 * @param zydoctorAdviceLongTerm
	 * @return
	 */
	public boolean addZydoctorAdviceLongTerm(ZydoctorAdviceLongTerm zydoctorAdviceLongTerm);
	/**
	 * 判断一个项目是否存在
	 * @param ZhuYuanHao 住院号
	 * @param XiangMuLeiXing 项目类型(处方，处置)
	 * @param XiangMuID 项目ID
	 * @param ChangQiYiZhuID 长期医嘱ID -1:新增时使用   长期医嘱ID:修改时使用
	 * @return
	 */
	public boolean getXiangMuShiFouCunZai(String ZhuYuanHao, String XiangMuLeiXing, Integer XiangMuID, Long ChangQiYiZhuID);
	/**
	 * 提取长期医嘱
	 * @param ZhuYuanHao 住院号
	 * @param RiQi 当前日期
	 * @param LeiXing 类型(处置,处方)
	 * @param WeiTingZhu 是否只提取未停医嘱
	 * @return
	 */
	public List<ZydoctorAdviceLongTerm> getChangQiYiZhu(String ZhuYuanHao, String RiQi, String LeiXing, Boolean WeiTingZhu);
	/**
	 * 修改长期医嘱下次执行日期
	 * @param RiQi   0:长期医嘱ID  1:日期
	 * @return
	 */
	public boolean updateXiaCiZhiXingRiQi(String [][] RiQi);
	/**
	 * 修改长期医嘱执行标志
	 * @param ID 长期医嘱ID
	 * @param BiaoZhi 标志 true false
	 * @return
	 */
	public boolean updateZhiXingBiaoZhi(Long ID, Boolean BiaoZhi);
	/**
	 * 删除长期医嘱项目
	 * @param LTID 长期医嘱ID
	 * @return
	 */
	public boolean delChangQiYiZhu(Long LTID);
	/**
	 * 修改长期医嘱
	 * @param NeiRong 要修改的内容     0 项目ID  1 数量   2 用法    3 给药方式    4 单价   5 执行科室ID 6 执行时间    7 下次执行日期    8单位 
	 * @param LTID 长期医嘱ID
	 * @return
	 */
	public boolean updateChuangQiYiZhu(String[] NeiRong, Long LTID);
	/**
	 * 停止或重新开启长期医嘱
	 * @param TingZhuYiSheng 停嘱医生
	 * @param TingZhuShiJian 停嘱时间
	 * @param XiaCiZhiXingRiQi 下次执行日期
	 * @param ID 长期医嘱ID
	 * @return
	 */
	public boolean updateTingZhu(Long TingZhuYiSheng, String TingZhuShiJian, String XiaCiZhiXingRiQi, Long ID);
	/**
	 * 停止所有长未停的长期医嘱
	 * @param ZhuYuanHao 住院号
	 * @param TingZhuYiSheng 停嘱医生
	 * @param TingZhuShiJian 停嘱时间
	 * @return boolean
	 */
	public boolean updateAllTingZhu(String ZhuYuanHao, Long TingZhuYiSheng, String TingZhuShiJian);
}
