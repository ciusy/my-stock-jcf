package leo.zy.service.iface;

import java.util.List;

import leo.entity.Cfcity;
import leo.entity.Cfgroup;
import leo.entity.Cfprefecture;
import leo.entity.Cfprovince;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.Csconsumer;
import leo.entity.CsheadShow;
import leo.entity.Czacontent;
import leo.entity.Czdispose;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.SfipdepositRecord;
import leo.entity.YfexbankAitem;
import leo.entity.YfmexbankA;
import leo.entity.Zyinpatient;

public interface ZyHuShiChuLiService {
	/**
	 * 护士首页查询在院人员
	 * @param zyh 住院号
	 * @param cwh 床位号
	 * @param xm 姓名
	 * @param xmsx 姓名缩写
	 * @param zybID 住院部ID
	 * @param zrhs 责任护士
	 * @return
	 */
	public String[][] getHuShiShouYeZhuYuanRenYuan(String zyh, Integer cwh, String xm, String xmsx, Integer zybID, Long zrhs);
	
	/**
	 * 提取省
	 * @param ShengID 省ID  -2所有省份
	 * @return
	 */
	public List<Cfprovince> getShengJiLieBiao(Integer ShengID);
	/**
	 * 根据省ID返回市
	 * @param ShengId 省ID
	 * @return
	 */
	public List<Cfcity> getShiJiLieBiao(Integer ShengId);
	/**
	 * 根据市ID返回县
	 * @param ShiId 市ID
	 * @return
	 */
	public List<Cfprefecture> getXianJiLieBiao(long ShiId); 
	/**
	 * 根据县ID返回乡镇
	 * @param prefectureId
	 * @return
	 */
	public  List<Cftown> getXiangJiLieBiao(long  XianID);
	/**
	 * 根据乡ID返回村
	 * @param XiangId
	 * @return
	 */
	public List<Cfvillage> getCunJiLieBiao(long XiangId);
	/**
	 * 根据村ID反回组
	 * @param CunId
	 * @return
	 */
	public List<Cfgroup> getZhuJiLieBiao(long CunId); 
	/**
	 * 提取服务对象
	 * @param Shi 市
	 * @param Xian 县
	 * @param Xiang 乡
	 * @param Cun 村
	 * @param Zu 组
	 * @param ShengFenZheng 身份证
	 * @param XingMing 姓名
	 * @param XingMingSuoXie 姓名缩写
	 * @param FuWuDuiXiangID 服务对象ID
	 * @return
	 */
	public List<Csconsumer> getFuWuDuXiang(String Shi, String Xian, String Xiang, String Cun, String Zu, String ShengFenZheng, String XingMing , String XingMingSuoXie, Long FuWuDuiXiangID);
	/**
	 * 返回最大住院ID
	 * @return
	 */
	public String getMaxID();
	/**
	 * 保存住院表
	 * @param zyinpatient
	 * @return
	 */
	public boolean addZhuYuan(Zyinpatient zyinpatient);
	/**
	 * 查找住院表
	 * @param ZhuYuanHao 住院ID
	 * @param ChuangWeiHao 床位号
	 * @param XingMing 姓名
	 * @param XingMingSuoXie 姓名缩写
	 * @param ShengQingShiJian_B 申请入院开始时间
	 * @param ShengQingShiJian_E 申请入院结束时间
	 * @param RuYuanShiJian_B 入院开始时间
	 * @param RuYuanShiJian_E 入院结束时间
	 * @param ShengQingZhuangTai 申请状态
	 * @param YueE1 余额底限
	 * @param GuanXi 余额查询关系> < >= <=
	 * @param ShiFouChuYuan 是否出院
	 * @param ChuYuanShiJian_B 出院开始时间
	 * @param ChuYuanShiJian_E 出院结束时间
	 * @param FeiYongLeiXingID 费用类型
	 * @param ZhuYuanBuId 住院部ID
	 * @param ShengFeiZheng 身份证号
	 * @param FuWuDuiXiangID 服务对象ID
	 * @return
	 */
	public String[][] getZYInpatient(String ZhuYuanHao, Integer ChuangWeiHao, String XingMing, String XingMingSuoXie, String ShengQingShiJian_B, String ShengQingShiJian_E, String RuYuanShiJian_B, String RuYuanShiJian_E, String ShengQingZhuangTai, String YueE1, String GuanXi, Integer ShiFouChuYuan, String ChuYuanShiJian_B, String ChuYuanShiJian_E, Integer FeiYongLeiXingID, Integer ZhuYuanBuId, String ShengFeiZheng, Long FuWuDuiXiangID);
	/**
	 * 保存服务对象信息，返回新建服务对象ID号
	 * @param FuWuDuiXiang 服务对象信息
	 * @param ShenFenZheng 身份证号
	 * @param TouXiang 头像
	 * @return
	 */
	public Long addFuWuDuiXiang(Csconsumer FuWuDuiXiang, String ShenFenZheng, String TouXiang);
	/**
	 * 提取服务对象头像
	 * @param id 服务对象ID
	 * @return
	 */
	public String getTouXiang(long id);
	/**
	 * 批准入院
	 * @param zyinpatient 住院表内容
	 * @param ChuangWeiHao 床位号
	 * @param ZhuangTai 床位状态
	 * @return
	 */
	public boolean updatePiZhunRuYuan(Zyinpatient zyinpatient, Integer ChuangWeiHao, String ZhuangTai);
	/**
	 * 更换床位
	 * @param ZhuYuanHao 住院号
	 * @param OldChuangWeiHao 正在使用的床位号
	 * @param NewChuangWeiHao 要更换的床位号
	 * @param ZhuYuanBu 住院部ID
	 * @return
	 */
	public boolean updateGengHuanChuangWei(String ZhuYuanHao, Integer OldChuangWeiHao, Integer NewChuangWeiHao, Integer ZhuYuanBu);
	/**
	 * 按照住院号得至住院表
	 * @param ZhuYuanHao 住院号
	 * @return
	 */
	public List<Zyinpatient> getZyinpatientall(String ZhuYuanHao);
	/**
	 * 住院信息维护
	 * @param zyinpatient 住院信息
	 * @param csconsumer 服务对象信息
	 * @param csheadShow 头像信息
	 * @param TouXiang 有头像吗
	 * @return
	 */
	public boolean updateZhuYuanXinXiWeiHu(Zyinpatient zyinpatient, Csconsumer csconsumer, CsheadShow csheadShow, boolean TouXiang);
	/**
	 * 计算累计费用
	 * @param ZhuYuanHao 住院号
	 * @param ShenQiShiJian_B 申请开始时间
	 * @param ShenQiShiJian_E 申请结束时间
	 * @param ZhuangTai_CZ 处置状态
	 * @param ZhuangTai_Cf 处方状态
	 * @return
	 */
	public Double getLeiJiFeiYong(String ZhuYuanHao, String ShenQiShiJian_B, String ShenQiShiJian_E, String ZhuangTai_CZ, String ZhuangTai_Cf);
	/**
	 * 提取住院押金记录
	 * @param ZhuYuanHao //住院号
	 * @return
	 */
	public List<SfipdepositRecord> getZhuYuanYaJinJiLe(String ZhuYuanHao);
	/**
	 * 提取医嘱处方
	 * @param ZhuYuanHao 住院号
	 * @param ZhuangTai 医嘱状态  (前面要加运算符,例如:=已执行)
	 * @param ZhuYuanBuID 住院部ID
	 * @param RiQi_B 开出时间(开始)
	 * @param RiQi_E 开出时间(结束)
	 * @param ZhuangTaiTiaoJian 状态条件 (= <> ...)
	 * @return
	 */
	public String[][] getTiQuChuFang(String ZhuYuanHao, String ZhuangTai, Integer ZhuYuanBuID, String RiQi_B, String RiQi_E,String ZhuangTaiTiaoJian);
	/**
	 * 提取医嘱处置
	 * @param ZhuYuanHao 住院号
	 * @param ZhuangTai 医嘱状态
	 * @param ZhuYuanBuID 住院部ID
	 * @param ChuZhiZhuangTai 处置状态
	 * @param RiQi_B 开始日期
	 * @param RiQi_E 结束日期
	 * @return
	 */
	public String[][] getTiQuChuZhi(String ZhuYuanHao, String ZhuangTai, Integer ZhuYuanBuID, String ChuZhiZhuangTai, String RiQi_B, String RiQi_E);
	/**
	 * 审核医嘱
	 * @param YiZhuID_ChuKuDanID 医嘱 ID,出库单ID
	 * @param HuShi 护士
	 * @param ShenHeShiJian 审核时间
	 * @param ZhuangTai 状态
	 * @param ChuKuDanTou 出库单表头
	 * @param ChuKuNeirong 出库单内容
	 * @param ChuZhi 处置项目
	 * @param ChuZhiIDS 住院处置医嘱项ID 处置项ID  0:DAItemID 1:ItemID
	 * @param ShengQingDan 申请单内容
	 * @param GouYaJin 扣押金
	 * @param ZhuYuanHao 住院号
	 * @return
	 */
	public boolean updateShenHeYiZhu(String[][] YiZhuID_ChuKuDanID, Long HuShi, String ShenHeShiJian, String ZhuangTai, List<YfmexbankA> ChuKuDanTou, List<YfexbankAitem> ChuKuNeirong, List<Czdispose> ChuZhi, String[][] ChuZhiIDS, List<Czacontent> ShengQingDan, Double GouYaJin, String ZhuYuanHao);
	/**
	 * 得到住院人员费用清单
	 * @param ZhuYuanHao 住院号
	 * @param ZhuanTai_CZ 处置状态
	 * @param ZhuangTai_CFFaYao 处方发药状态
	 * @param ZhuangTai_CFTuiYao 处方退药状态
	 * @param ZhiXingShiJian_B 执行开始时间
	 * @param ZhiXingShiJian_E 执行结束时间
	 * @return
	 */
	public String[][] getFeiYongQingDan(String ZhuYuanHao, String ZhuanTai_CZ, String ZhuangTai_CFFaYao, String ZhuangTai_CFTuiYao, String ZhiXingShiJian_B, String ZhiXingShiJian_E);
	/**
	 * 提取最大处置ID
	 * @return
	 */
	public String getChuZhiMaxID();
	/**
	 * 提取处置项目描述
	 * @param id 项目类型ID
	 * @return
	 */
	public CzdisposeItemDescribe getChuZhiXiangMuMiaoShu(Integer id);
	/**
	 * 取消审核_处方
	 * @param YiZhu_ChuKuDan 医嘱ID与对应的出库单ID  0:医嘱ID  1:出库单ID
	 * @param YiZhuZhuangTai 状态
	 * @param HuShiID 护士ID
	 * @param ShiJian 时间
	 * @return
	 */
	public boolean updateQuXiaoShengHe_CF(String[][] YiZhu_ChuKuDan, String YiZhuZhuangTai, Long HuShiID, String ShiJian);
	/**
	 * 取消审核_处置
	 * @param YiZhu 医嘱ID
	 * @param YiZhuXiang_ChuZhi 医嘱项ID对应的处置项ID  0:医嘱项ID  1:处置项ID=""
	 * @param ChuZhi 处置项ID
	 * @param YiZhuZhuangTai 状态
	 * @param HuShiID 护士ID
	 * @param ShiJian 时间
	 * @return
	 */
	public boolean updateQuXiaoShengHe_CZ(String[] YiZhu, String[][] YiZhuXiang_ChuZhi, String[] ChuZhi, String YiZhuZhuangTai, Long HuShiID, String ShiJian);
	/**
	 * 判断一张医嘱单中是否有部份执行的处置项目
	 * @param YiZhuHao 医嘱单号
	 * @return
	 */
	public boolean getChuZhiBuFenZhiXing(String YiZhuHao);
	/**
	 * 提取退药审核
	 * @param ZhuYuanHao 住院号
	 * @param ZhuangTai 状态
	 * @return
	 */
	public String[][] getTuiYaoShengHe(String ZhuYuanHao, String ZhuangTai);
	/**
	 * 审核退药单
	 * @param DanJu单据信息  0:入库单号  1:状态  2:审核时间
	 * @return
	 */
    public boolean updateShengHeTuiYao(String[][] DanJu);
    /**
     * 取消退药单
     * @param ZhuYuanYaoPin 住院药品  0:药品项目ID  1:退量
     * @param XiuGaiChuKuDan 要修改的出库单信息  0:出库单号  1:药品ID 2:已退数量  3:已退价格
     * @param RuKuDanID 入库单号
     * @return
     */
    public boolean updateQuXiaoTuiYao(String[][] ZhuYuanYaoPin, String[][] XiuGaiChuKuDan, String[] RuKuDanID);
	/**
	 * 根据医嘱ID和药品ID得到医嘱项ID
	 * @param DAID 医嘱ID
	 * @param MInfoID 药品ID
	 * @return
	 */
	public String getYiZhuXiangID(String DAID, Integer MInfoID);
	/**
	 * 根据入库单ID和药品ID得到住院医嘱里的出库单ID
	 * @param RuKuDanID
	 * @param YaoPinID
	 * @return
	 */
	public String getChuKuDanID(String RuKuDanID, Integer YaoPinID);
	/**
	 * 得到住院人员总金额
	 * @param ZhuYuanHao 住院号
	 * @return
	 */
	public Double getZhuYuanZongJieE(String ZhuYuanHao);
	/**
	 * 人员出院
	 * @param ZhuYuanHao 住院号
	 * @param ChuYuanShiJian 出院时间
	 * @param ZhuangTai 申请状态
	 * @param ChuangWeiHao 床位号
	 * @param ZhuYuanBu 住院部ID
	 * @param ChuangWeiZhuangTai 床位状态
	 * @return
	 */
	public boolean updateBanLiChuYuan(String ZhuYuanHao, String ChuYuanShiJian, String ZhuangTai, Integer ChuangWeiHao, Integer ZhuYuanBu, String ChuangWeiZhuangTai);
	/**
	 * 修改农身体证号,农合号,手机
	 * @param FuWuDuiXiangID 服务对象ID
	 * @param ShengFenZhengHao 身份证
	 * @param NongHeHao 农合
	 * @param ShouJiHao 手机
	 * @return
	 */
	public boolean updateCSConsumerZhuYuan(Long FuWuDuiXiangID, String ShengFenZhengHao, String NongHeHao, String ShouJiHao);
	
}
