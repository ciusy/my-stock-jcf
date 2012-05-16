package leo.ys.service.iface;

import java.util.List;

import leo.entity.Cfcity;
import leo.entity.Cfprefecture;
import leo.entity.Cfprovince;
import leo.entity.Cftown;
import leo.entity.Cfvillage;
import leo.entity.Csconsumer;
import leo.entity.HealthyPregnantSms;
import leo.entity.OsmedicalInstInfo;
import leo.entity.SmsModule;
import leo.entity.SmsModuleTerm;

public interface YSDuanXinChuLiService {
	/**
	 * 增加短信模板头
	 * @param MoBanTou 模板头内容
	 * @return
	 */
	public Long addMoBanTou(SmsModule MoBanTou);
	/**
	 * 根据模板类型和所属单位ID查找模板头
	 * @param PointName 模板类型
	 * @param AffiliationID 所属单位ID
	 * @return
	 */
	public List<SmsModule> getMobanTou(String LeiXing, Long DanWeiID);
	/**
	 * 修改模板头
	 * @param smsModule 模板头内容
	 * @return
	 */
	public boolean updateMobanTou(SmsModule MoBanTou);
	/**
	 * 增加短信模板项
	 * @param smsModuleTerm 模板项内容
	 * @return
	 */
	public Long addMoBanXiang(SmsModuleTerm MoBanXiang);
	/**
	 * 根据短信模板ID提取短信模板项
	 * @param ModuleID 短信模板ID
	 * @return
	 */
	public List<SmsModuleTerm> getMoBanXiang(Long MoBanID);
	/**
	 * 修改短信模板项
	 * @param smsModuleTerm 短信模板项内容
	 * @return
	 */
	public boolean updateMoBanXiang(SmsModuleTerm MoBanXiang);
	/**
	 * 根据模板项ID或模板ID删除模板项
	 * @param MobanXiangID 模板项id
	 * @param MoBanID 模板id
	 * @return
	 */
	public boolean delMoBanXiang(Long MobanXiangID, Long MoBanID);
	/**
	 * 删除模板
	 * @param MoBanID 模板ID
	 * @return
	 */
	public boolean delMoBan(Long MoBanID);
	/**
	 * 根据单位ID提取模板名称
	 * @param DanWeiID 单位ID
	 * @return 0:模板名称  1:模板ID
	 */
	public String[][] getMoBanMingCheng(Long DanWeiID); 
	/**
	 * 提取模板项内容
	 * @param ModuleID 模板ID
	 * @return 0:模板项ID  1:前后天数  2:模板类型  3短信内容
	 */
	public String[][] getXiangNeiRong(Long MoBanID);
	/**
	 * 提取待发送的内容
	 * @param TianShu 前后天数
	 * @param LeiXing 类型
	 * @return
	 */
	public String[][] getDuanXinDaiFaNeiRong(Integer TianShu, String LeiXing);
	/**
	 * 根据档案号提取告知内容
	 * @param DangAnHao 档案号
	 * @return
	 */
	public String getGaoZhiNeiRong(String DangAnHao);
	/**
	 * 提取医疗机构
	 * @param mid 医疗机构ID
	 * @return
	 */
	public OsmedicalInstInfo getYiLiaoJiGouById(int mid);
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
	 * 保存优生要发送的短信内容
	 * @param healthyPregnantSms 短信内容
	 * @return
	 */
	public boolean addDaiFaDuanXinNeiRong(List<HealthyPregnantSms> DuanXinNeiRong);
	
}
