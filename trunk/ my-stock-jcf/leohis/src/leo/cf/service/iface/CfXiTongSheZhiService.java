package leo.cf.service.iface;

import java.util.List;

import leo.entity.Cfcity;
import leo.entity.Cfprefecture;
import leo.entity.Cfprovince;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.CzdisposalType;
import leo.entity.CzdisposeDivaricateU;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.GhregisterType;
import leo.entity.OsfnAuthorityForm;
import leo.entity.OsfnBlocks;
import leo.entity.OsmedicalInstInfo;
import leo.entity.Osstuff;
import leo.entity.OsudefaultFn;
import leo.entity.YfmdosageType;
import leo.entity.YfmdosageUnit;
import leo.entity.Yfmmanufacturer;
import leo.entity.Yfmtype;
import leo.entity.YfmwayTo;

public interface CfXiTongSheZhiService {
	/**
	 * 编辑医疗机构全局配置
	 * @param NeiRong 内容 0:配置名称   1:值   2:医疗机构ID
	 * @return
	 */
	public boolean updateBianJiYiLiaoJiGouPeiZhi(String[][] NeiRong);
	/**
	 * 提取配置项目值
	 * @param XiangMu 内容 0:项目名称   1:医疗机构ID
	 * @return 0:项目名称  1:值
	 */
	public String[][] getPeiZhiXiangMuZhi(String[][] XiangMu);
	/**
	 * 按照科室ID删除科室
	 * @param KeShiID 科室ID
	 * @return
	 */
	public boolean delKeShi(Integer KeShiID);
	/**
	 * 提取药品类别
	 * @return
	 */
	public List<Yfmtype> getYaoPinLeiBie();
	/**
	 * 提取药品剂型
	 * @return
	 */
	public List<YfmdosageType> getJiXing();
	/**
	 * 提取给药方式
	 * @return
	 */
	public List<YfmwayTo> getGeiYaoFangShi();
	/**
	 * 提取剂量单位
	 * @return
	 */
	public List<YfmdosageUnit> getJiLiangDanWei();
	/**
	 * 提取生产厂家
	 * @param name 名称
	 * @return
	 */
	public List<Yfmmanufacturer> getShengChanChangJia(String name);
	/**
	 * 保存药品参数设置
	 * @param LeiBie 药品类别
	 * @param JiXing 药品剂量
	 * @param GeiYaoFangShi 给药方式
	 * @param DanWei 剂量单位
	 * @param ChangJia 生产厂家
	 * @param FLeiBie 是否处理药品类型
	 * @param  FJiXing 是否处理药品剂量
	 * @param  FGeiYaoFangShi 是否处理给药方式
	 * @param FDanWei 是否处理剂量单位
	 * @param  FChangJia 是否处理生产厂家
	 * @return
	 */
	public boolean addYaoPingCanShu(List<Yfmtype> LeiBie, 
									List<YfmdosageType> JiXing, 
									List<YfmwayTo> GeiYaoFangShi, 
									List<YfmdosageUnit> DanWei, 
									List<Yfmmanufacturer> ChangJia,
									boolean FLeiBie,
									boolean FJiXing,
									boolean FGeiYaoFangShi,
									boolean FDanWei,
									boolean FChangJia);
	/**
	 * 提取处置类别
	 * @return
	 */
	public List<CzdisposalType> getChuZhiLeiBie();
	/**
	 * 保存处置类别
	 * @param LeiBie 类别
	 * @param FLeiBie 是否保存
	 * @return
	 */
	public boolean addChuZhiLeiBie(List<CzdisposalType> LeiBie, boolean FLeiBie);
	/**
	 * 根据名称、拼音、类别提取项目
	 * @param MingCheng 名称
	 * @param PingYin 拼音
	 * @param LeiBie 类别
	 * @param YiLiaoJiGou 医疗机构
	 * @return
	 */
	public List<CzdisposeItemDescribe> getChuZhiXiangMu(String MingCheng, String PingYin, String LeiBie, Integer YiLiaoJiGou);
	/**
	 * 根据项目ID查询开出科室对象
	 * @param czid 处置ID
	 * @return CzdisposeDivaricateU
	 */
	public List<CzdisposeDivaricateU> getChuZhiKaiChuKeShi(Integer czid);
	/**
	 * 根据医疗机构和项目名称判断是否存在
	 * @param MingCheng 项目名称
	 * @param YiLiaoJiGou 医疗机构
	 * @return
	 */
	public Integer getChuZhiXiangMuCunZi(String MingCheng, Integer YiLiaoJiGou);
	/**
	 * 根据医疗机构和挂号类别名称判断是否存在
	 * @param MingCheng 名称
	 * @param YiLiaoJiGou 医疗机构
	 * @return
	 */
	public Integer getGuaHaoLeiBieCunZai(String MingCheng, Integer YiLiaoJiGou);
	/**
	 * 根据名称或拼音查询挂号类别
	 * @param MingCheng 名称
	 * @param PingYin 拼音
	 * @param YiLiaoJiGou 医疗机构
	 * @return
	 */
	public List<GhregisterType> getGuaHaoXiangMu(String MingCheng, String PingYin, Integer YiLiaoJiGou);
	/**
	 * 保存处置项目
	 * @param XiangMu 处置项目
	 * @param KaiChuKeShi 开出科室
	 * @return
	 */
	public boolean addChuZhiXiangMu(CzdisposeItemDescribe XiangMu, List<CzdisposeDivaricateU> KaiChuKeShi);
	/**
	 * 删除处置项目
	 * @param XiangMuID 处置项目ID
	 * @return
	 */
	public boolean delChuZhiXiangMu(Integer XiangMuID);
	/**
	 * 修改处置项目
	 * @param XiangMu 处置项目
	 * @param KaiChuKeShi 开出科室
	 * @return
	 */
	public boolean updateChuZhiXiangMu(CzdisposeItemDescribe XiangMu, List<CzdisposeDivaricateU> KaiChuKeShi);
	/**
	 * 保存挂号类型
	 * @param GuaHaoLeiXing 挂号类型
	 * @return
	 */
	public boolean addGuaHaoLeiXing(GhregisterType GuaHaoLeiXing);
	/**
	 * 修改挂号类型
	 * @param GuaHaoLeiXing 挂号类型
	 * @return
	 */
	public boolean updateGuaHaoLeiXing(GhregisterType GuaHaoLeiXing);
	/**
	 * 按照挂号类型ID删除挂号类型
	 * @param LeiXingID 挂号类型ID
	 * @return
	 */
	public boolean delGuaHaoLeiXing(Integer LeiXingID);
	/**
	 * 提取省份
	 * @param ShengID 省ID
	 * @return
	 */
	public List<Cfprovince> getShengJiLieBiao(Integer ShengID);
	/**
	 * 提取市
	 * @param ShengId 省ID
	 * @return
	 */
	public List<Cfcity> getShiJiLieBiao(Integer ShengId);
	/**
	 * 提取县
	 * @param ShiId 市ID
	 * @return
	 */
	public List<Cfprefecture> getXianJiLieBiao(long ShiId);
	/**
	 * 提取乡
	 * @param XianID 县ID
	 * @return
	 */
	public  List<Cftown> getXiangJiLieBiao(long  XianID);
	/**
	 * 提取村
	 * @param XiangId 乡ID
	 * @return
	 */
	public List<Cfvillage> getCunJiLieBiao(long XiangId);
	/**
	 * 提取医疗机构
	 * @param mid 医疗机构ID
	 * @return
	 */
	public OsmedicalInstInfo getYiLiaoJiGou(int mid);
	/**
	 * 保存医疗机构
	 * @param YiLiaoJiGou 医疗机构
	 * @return
	 */
	public boolean addYiLiaoJiGou(OsmedicalInstInfo YiLiaoJiGou);
	/**
	 * 修改医疗机构
	 * @param YiLiaoJiGou 医疗机构
	 * @return
	 */
	public boolean updateYiLiaoJiGou(OsmedicalInstInfo YiLiaoJiGou);
	/**
	 * 提取父功能模块
	 * @return
	 */
	public List<OsfnBlocks> getFuGongNeng();
	/**
	 * 保存科室默认功能
	 * @param osudefaultFn
	 * @return
	 */
	public boolean addKeShiMoRenGongNeng(List<OsudefaultFn> osudefaultFn);
	/**
	 * 提取科室对应的功能
	 * @param uid
	 * @return
	 */
	public String[][] getKeShiMoRenGongNeng(Integer uid);
	/**
	 * 删除科室对应的功能
	 * @param uid 科室ID
	 * @param FcBlocksID 功能ID
	 * @return
	 */
	public boolean delKeShiMoRenGongNeng(Integer uid, Integer FcBlocksID);
	/**
	 * 增加配置科室
	 * @param sid 人员ID
	 * @param uidlist 科室ID表
	 * @param CaiDan 是否加入菜单
	 * @param MoRenCaiDan 菜单内容
	 * @return
	 */
	public boolean addPeiZhiKeShi(long sid, int[] uidlist, boolean CaiDan, List<OsfnAuthorityForm> MoRenCaiDan);
	/**
	 * 修改配置科室
	 * @param sid 人员ID
	 * @param uidlist 科室ID表
	 * @return
	 */
	public boolean updatePeiZhiKeShi(long sid, int[] uidlist, boolean CaiDan, List<OsfnAuthorityForm> MoRenCaiDan);
	/**
	 * 提取科室对应的功能
	 * @param uid 科室ID
	 * @return
	 */
	public String[][] getKeShiGongNeng(Integer uid);
	/**
	 * 获得最大菜单ID号
	 * @return
	 */
	public Integer getCaiDanMaxID();
	/**
	 * 提取子模块
	 * @param FatherFnBlocksID 父功能模块ID
	 * @return
	 */
	public List<OsfnBlocks> getZiMoKuai(Integer FuGongNengID);
	/**
	 * 提取登录人员的完整菜单树
	 * @param sid 人员ID
	 * @return
	 */
	public String[][] getCaiDanShu(long sid);
	/**
	 * 根据菜单ID修改菜单名称
	 * @param MenuID 菜单ID
	 * @param MenuName 菜单名称
	 * @return
	 */
	public boolean updateCaiDanMingCheng(Integer MenuID, String MenuName);
	/**
	 * 删除菜单
	 * @param LeiXing 类型(所有,模块,功能)
	 * @param MenuID 菜单ID
	 * @param YuanGongID 员工ID
	 * @return
	 */
	public boolean delCaiDan(String LeiXing, Integer MenuID, Long YuanGongID);
	/**
	 * 加入菜单
	 * @param osfnAuthorityForm 菜单内容
	 * @return
	 */
	public boolean addCaiDan(List<OsfnAuthorityForm> CaiDanNeiRong);
	/**
	 * 通过登录名和密码查找对应员工
	 * @param loginname 登录名
	 * @param password  密码
	 * @return
	 */
	public Osstuff getDengLuYuanGong(String loginname, String password);
	/**
	 * 修改员工用户名和密码
	 * @param SID 员工ID
	 * @param LoginName 用户名
	 * @param Password 密码
	 * @return
	 */
	public boolean updateYongHu(Long SID, String LoginName, String Password);
	/**
	 * 设置快捷按钮
	 * @param MenuID 菜单ID
	 * @param QuickName 名称
	 * @param QuickImageID 图标ID
	 * @param QuickClass 功能类
	 * @return
	 */
	public boolean updateKuaiJianAnNiu(Integer MenuID, String QuickName, String QuickImageID, String QuickClass);
	/**
	 * 提取对应员工的快捷按钮
	 * @param SID
	 * @return
	 */
	public String[][] getKuaiJieAnNiu(Long SID);
	/**
	 * 提取对应菜单的快捷按钮
	 * @param MenuID
	 * @return
	 */
	public String[][] getKuaiJieAnNiuByCaiDanID(Integer MenuID);
	/**
	 * 提取对应功能的类名称
	 * @param FnBlocksID
	 * @return
	 */
	public List<OsfnBlocks> GetGongNengLei(Integer FnBlocksID);
	/**
	 * 提取目录
	 * @param sid 人员ID 
	 * @param FatherMenuID 父菜单ID
	 * @return
	 */
	public String[][] getMuLu(Long sid, Integer FatherMenuID);
	/**
	 * 调入目录
	 * @param MenuID 菜单ID
	 * @param FatherMenuID 父菜单ID
	 * @return
	 */
	public boolean updateMuLu(Integer MenuID, Integer FatherMenuID);
	/**
	 * 判断一个功能是否在目录里
	 * @param Sid 人员ID
	 * @param FatherMenuID 父菜单ID
	 * @return
	 */
	public String[][] getZaiMuLuLi(Long Sid, Integer FatherMenuID);
	/**
	 * 判断用户登录名称是否存在
	 * @param LoginName 登录名称
	 * @param SID 员工ID
	 * @return true 存在  false 不存在
	 */
	public boolean getYongHuCunZai(String LoginName, Long SID);
	/**
	 * 根据省ID提取省名
	 * @param ShengID 省ID
	 * @return
	 */
	public String getShengName(Integer ShengID);
	/**
	 * 根据市ID提取市名
	 * @param ShiID 市ID
	 * @return
	 */
	public String getShiName(Integer ShiID);
	/**
	 * 根据县ID提取县名
	 * @param XianID 县ID
	 * @return
	 */
    public String getXianName(Long XianID);
    /**
     * 得到最大乡ID
     * @param XianID 县ID
     * @return
     */
	public String getMaxXiangID(long XianID);
	/**
	 * 加入乡
	 * @param TownID 乡ID
	 * @param PrefectureID 县ID
	 * @param TownName 乡名
	 * @return
	 */
	public boolean addXiang(long TownID, long PrefectureID, String TownName);
	/**
	 * 删除乡
	 * @param XiangID 乡ID
	 * @return
	 */
	public boolean delXiang(long XiangID);
	/**
	 * 得到最大村ID
	 * @param XiangID 乡ID
	 * @return
	 */
	public String getMaxCunID(long XiangID);
	/**
	 * 增加村
	 * @param VillageID 村ID
	 * @param TownID 乡ID
	 * @param VillageName 村名
	 * @return
	 */
	public boolean addCun(long VillageID, long TownID, String VillageName);
	/**
	 * 删除村
	 * @param VillageID 村ID
	 * @return
	 */
	public boolean delCun(long VillageID);
	/**
	 * 修改乡名称
	 * @param TownID 乡ID
	 * @param Name 乡名
	 * @return
	 */
	public boolean updateXiang(long TownID, String Name);
	/**
	 * 修改村名
	 * @param VillageID 村ID
	 * @param name 村名
	 * @return
	 */
	public boolean updateCun(long VillageID, String name);

}
