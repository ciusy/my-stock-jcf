package leo.zy.service.iface;

import java.util.List;

import leo.entity.CfacontentFramework;
import leo.entity.CzbcultrasoundImage;
import leo.entity.CzbcultrasoundIs;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.CzmilkGlandImage;
import leo.entity.CzmilkGlandIs;
import leo.entity.YfinbankAitem;
import leo.entity.YfminbankA;
import leo.entity.Zydischarge;
import leo.entity.ZydoctorAdvice;
import leo.entity.Zyipmedicine;
import leo.entity.Zyipteatment;
import leo.entity.Zymadministration;
import leo.entity.ZydoctorAdviceLongTerm;

public interface ZyYiShengChuLiService {
	/**
	 * 提取药品用法
	 * @return
	 */
	public List<Zymadministration> getYaoPingYongFa();
	/**
	 * 按照名称或拼音缩写提取处置项目
	 * @param Name 名称
	 * @param Spell 拼音缩写
	 * @return
	 */
	public List<CzdisposeItemDescribe> getChuZhi(String Name, String Spell);
	/**
	 * 保存临时医嘱
	 * @param YiZhu_cf 医嘱内容_处方
	 * @param YiZhu_cz 医嘱内容_处置
	 * @param ChuFang 处方内容
	 * @param ChuZhi 处置内容
	 * @param JiaRuChuFang 是否加入临时处方
	 * @param JiaRuChuZhi 是否加入临时处置
	 * @param JiaRuChuangQiYiZhu 是否加入长期医嘱
	 * @param ChuangQiYiZhu 长期医嘱
	 * @param ChangQiYiZhuChuLi 是否用于护士长期医嘱处理
	 * @param RiQi 0:长期医嘱ID  1:下次执行时间
	 * @param ChangQiYiZhuID 长期医嘱ID
	 * @param BiaoZhi 长期医嘱是否已经执行标志 true false
	 * @return
	 */
	public boolean addLinShiYiZhu(List<ZydoctorAdvice> YiZhu_cf, List<ZydoctorAdvice> YiZhu_cz, List<Zyipmedicine> ChuFang, List<Zyipteatment> ChuZhi, boolean JiaRuChuFang, boolean JiaRuChuZhi, boolean JiaRuChuangQiYiZhu, List<ZydoctorAdviceLongTerm> ChuangQiYiZhu, boolean ChangQiYiZhuChuLi, String[][] RiQi, Long[] ChangQiYiZhuID, Boolean BiaoZhi);
	/**
	 * 返回最大医嘱ID
	 * @return
	 */
	public String getMaxID();
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
	 * @param LeiXing 类型
	 * @param WeiTingZhu 是否只提取未停医嘱
	 * @return
	 */
	public List<ZydoctorAdviceLongTerm> getChangQiYiZhu(String ZhuYuanHao, String RiQi, String LeiXing, Boolean WeiTingZhu);
	/**
	 * 提取申请内容模板
	 * @param DanWei 医疗机构ID
	 * @param XiangMuLeiXingID 项目类型ID
	 * @param MoBanID 模块ID
	 * @return
	 */
	public List<CfacontentFramework> getChuZhiMoBan(Integer DanWei, Integer XiangMuLeiXingID, Integer MoBanID);
	/**
	 * 维护申请内容模板
	 * @param MoBan 模板内容
	 * @param MoBanID 模板ID  -2:保存  其它：删除 
	 * @return
	 */
	public Boolean addChuZhiMoBan(CfacontentFramework MoBan, Integer MoBanID);
	/**
	 * 修改临时处方项目
	 * @param Xiang 药品项目
	 * @return
	 */
	public boolean updateLinShiChuFangXiang(Zyipmedicine Xiang);
	/**
	 * 删除临时处方项目
	 * @param YiZhuID 医嘱ID
	 * @param Xiang 药品项日
	 * @param LingYaoDanID 领药单ID
	 * @param YaoPingID 药品ID
	 * @param delChuKuDanTou 是否删除出库单头 true:删除 false:不删除
	 * @return
	 */
	public boolean delLinShiChufangXiang(String YiZhuID, Long Xiang, String LingYaoDanID, Integer YaoPingID, Boolean delChuKuDanTou);
	/**
	 * 删除临时处置项目
	 * @param YiZhuId 医嘱ID
	 * @param YiZhuXiangID 医嘱项ID
	 * XiangMuID 处置项ID(用以删除处置项表和申请内容表中对应的项目)
	 * @return
	 */
	public boolean delLinSheChuZhiXiang(String YiZhuId, Long YiZhuXiangID, String XiangMuID);
	/**
	 * 临时处方退药
	 * @param ZhuYuanYaoPin 住院药品  0:药品项目ID  1:退掉后的数
	 * @param XiuGaiChuKuDan 要修改的出库单信息  0:出库单号  1:药品ID 2:已退数量  3:已退价格
	 * @param RuKuDanTou 入库单头
	 * @param RuKuDanNeiRong 入库单内容
	 * @return 
	 */
	public boolean updateLinShiChuFangTuiYao(String[][] ZhuYuanYaoPin, String[][] XiuGaiChuKuDan, List<YfminbankA> RuKuDanTou, List<YfinbankAitem> RuKuDanNeiRong);
	/**
	 * 提取B超报告单
	 * @param XiangMuID 项目ID
	 * @return
	 */
	public List<CzbcultrasoundIs> getBCBaoDaoDan(String XiangMuID);
	/**
	 * 提取B超图片
	 * @param BaoGaoDanID 报告单ID
	 * @return
	 */
	public List<CzbcultrasoundImage> getBCTuPian(String BaoGaoDanID);
	/**
	 * 提取乳腺报告单
	 * @param XiangMuID 项目ID
	 * @return
	 */
	public List<CzmilkGlandIs>getRXBaoGaoDan(String XiangMuID);
	/**
	 * 提取乳腺图片
	 * @param BaoGaoDanID 报告单ID
	 * @return
	 */
	public List<CzmilkGlandImage> getRXTuPian(String BaoGaoDanID); 
	/**
	 * 按照医嘱ID提取医嘱内容
	 * @param DAID 医嘱ID
	 * @return
	 */
	public List<ZydoctorAdvice> getZydoctorAdvice(String DAID);
	/**
	 * 修改住院处置表里的申请单内容
	 * @param ShenQingNeiRong 申请内容
	 * @param DAItemID 医嘱项ID
	 * @return
	 */
	public boolean updateShenQingDanNeiRong(String ShenQingNeiRong, Long DAItemID);
	/**
	 * 修改住院处置的项目类型ID和执行科室
	 * @param ItemTypeID 项目类型ID
	 * @param ExecuteU 执行科室
	 * @param DAItemID 医嘱项ID
	 * @return
	 */
	public boolean updateChuZhiXiangMu(Integer ItemTypeID, Integer ExecuteU, Long DAItemID);
	/**
	 * 删除长期医嘱项目
	 * @param LTID 长期医嘱ID
	 * @return
	 */
	public boolean delChangQiYiZhu(Long LTID);
	/**
	 * 修改长期医嘱
	 * @param NeiRong 要修改的内容     0 项目ID  1 数量   2 用法    3 给药方式    4 单价   5 执行科室ID 6 执行时间    7 下次执行日期 
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
	 * 根据项目类型ID查找项目名称
	 * @param ItemTypeID 项目类型ID
	 * @return
	 */
	public String getChuZhiMingCheng(Integer ItemTypeID);
	/**
	 * 停止所有长未停的长期医嘱
	 * @param ZhuYuanHao 住院号
	 * @param TingZhuYiSheng 停嘱医生
	 * @param TingZhuShiJian 停嘱时间
	 * @return
	 */
	public boolean updateAllTingZhu(String ZhuYuanHao, Long TingZhuYiSheng, String TingZhuShiJian);
	/**
	 * 开出院通知
	 * @param TongZhi 出院通知
	 * @param ZhuYuanHao 住院号
	 * @param ShengQingZhuangTai 申请状态
	 * @return
	 */
	public boolean updateChuYuanTongZhi(Zydischarge TongZhi, String ZhuYuanHao, String ShengQingZhuangTai);
	/**
	 * 提取出院通知
	 * @param ZhuYuanHao 住院号
	 * @return
	 */
	public List<Zydischarge> getChuYuanTongZhi(String ZhuYuanHao);
	/**
	 * 取消出院
	 * @param ZhuYuanHao 住院号
	 * @param ZhuangTai 状态
	 * @return
	 */
	public boolean updateQuXiaoChuYuan(String ZhuYuanHao, String ZhuangTai);
	/**
	 * 修改出院通知
	 * @param zydischarge 通知内容
	 * @return
	 */
	public boolean updateXiuGaiTongZhi(Zydischarge zydischarge);
	/**
	 * 提取所需报告单
	 * @param LeiXingID 类型ID
	 * @param JiGouID 医疗机构ID
	 * @return
	 */
	public String getBaoGaoDan(Integer LeiXingID, Integer JiGouID);
	/**
	 * 根据项目ID和项目名称提取化单
	 * @param ItemID 项目ID
	 * @param ItemName 项目名称
	 * @return
	 */
	public String[][] getHuaYianDan(String ItemID, String ItemName);

}
