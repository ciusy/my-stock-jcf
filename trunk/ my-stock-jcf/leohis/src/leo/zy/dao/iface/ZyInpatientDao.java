package leo.zy.dao.iface;

import java.util.List;

import org.hibernate.Query;

import leo.common.dao.Dao;
import leo.entity.YfminbankA;
import leo.entity.Zyinpatient;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 4, 2011 4:22:48 PM
 */
public interface ZyInpatientDao extends Dao<Zyinpatient> {

	/**
	 * 得到当天，状态是“已入院”的所有服务对象
	 * 
	 * @param inPatientDeptIds
	 * @param inPatientStatus
	 * 
	 * @return
	 */
	public List<Zyinpatient> getCurrentDayInPatient(List<Integer> inPatientDeptIds, String inPatientStatus);

	/**
	 * 
	 * @param inPatientDeptIds
	 * @param consumerIds
	 * @param ipId
	 * @param startTime
	 * @param endTime
	 * @param inPatientStatus
	 * @param bedNo
	 * @return
	 */
	public List<Zyinpatient> getInpatient(List<Integer> inPatientDeptIds, List<Long> consumerIds, String ipId, String startTime,
			String endTime, String inPatientStatus, String bedNo);

	/**
	 * 护士首页查询在院人员
	 * 
	 * @param zyh
	 *            住院号
	 * @param cwh
	 *            床位号
	 * @param xm
	 *            姓名
	 * @param xmsx
	 *            姓名缩写
	 * @param zybID
	 *            住院部ID
	 * @param zrhs
	 *            责任护士
	 * @return
	 */
	public String[][] getHuShiShouYeZhuYuanRenYuan(String zyh, Integer cwh, String xm, String xmsx, Integer zybID, Long zrhs);

	/**
	 * 返回最大住院ID
	 * 
	 * @return
	 */
	public String getMaxID();

	/**
	 * 保存住院表
	 * 
	 * @param zyinpatient
	 * @return
	 */
	public boolean addZYInpatient(Zyinpatient zyinpatient);

	/**
	 * 查找住院表
	 * 
	 * @param ZhuYuanHao
	 *            住院ID
	 * @param ChuangWeiHao
	 *            床位号
	 * @param XingMing
	 *            姓名
	 * @param XingMingSuoXie
	 *            姓名缩写
	 * @param ShengQingShiJian_B
	 *            申请入院开始时间
	 * @param ShengQingShiJian_E
	 *            申请入院结束时间
	 * @param RuYuanShiJian_B
	 *            入院开始时间
	 * @param RuYuanShiJian_E
	 *            入院结束时间
	 * @param ShengQingZhuangTai
	 *            申请状态
	 * @param YueE1
	 *            余额底限
	 * @param GuanXi
	 *            余额查找关系：> < >= <=
	 * @param ShiFouChuYuan
	 *            是否出院
	 * @param ChuYuanShiJian_B
	 *            出院开始时间
	 * @param ChuYuanShiJian_E
	 *            出院结束时间
	 * @param FeiYongLeiXingID
	 *            费用类型
	 * @param ZhuYuanBuId
	 *            住院部ID
	 * @param ShengFeiZheng
	 *            身份证号
	 * @param FuWuDuiXiangID
	 *            服务对象ID
	 * @return
	 */
	public String[][] getZYInpatient(String ZhuYuanHao, Integer ChuangWeiHao, String XingMing, String XingMingSuoXie,
			String ShengQingShiJian_B, String ShengQingShiJian_E, String RuYuanShiJian_B, String RuYuanShiJian_E,
			String ShengQingZhuangTai, String YueE1, String GuanXi, Integer ShiFouChuYuan, String ChuYuanShiJian_B,
			String ChuYuanShiJian_E, Integer FeiYongLeiXingID, Integer ZhuYuanBuId, String ShengFeiZheng, Long FuWuDuiXiangID);

	/**
	 * 修改住院表
	 * 
	 * @param zyinpatient
	 *            住院表内容
	 * @return
	 */
	public boolean updateZYInpatient(Zyinpatient zyinpatient);

	/**
	 * 修改人员床位
	 * 
	 * @param ZhuYuanHao
	 *            住院号
	 * @param ChuangWeihao
	 *            床位号
	 * @return
	 */
	public boolean updateDangQianChuangWei(String ZhuYuanHao, Integer ChuangWeihao);

	/**
	 * 按照住院号得至住院表
	 * 
	 * @param ZhuYuanHao
	 *            住院号
	 * @return
	 */
	public List<Zyinpatient> getZyinpatientall(String ZhuYuanHao);
	/**
	 * 修改押金余额
	 * @param IPID 住院号
	 * @param FeiYong 费用(+加余额,-扣余额)
	 * @return
	 */
	public boolean updateDepositBalance(String IPID, Double FeiYong);

	/**
	 * add by xu
	 * 
	 * @param inpatientId
	 * @param b
	 * @param string
	 */
	public Zyinpatient updateZyStauts(String inpatientId, boolean b, String string);
   /**
    * 通过csid 和入院时间查询
    * add by zhang
    * @param csId
    * @param st
    * @param ed
    * @return
    * @throws Exception
    */
	public List<Zyinpatient> getZyinpatientByCsIDandDate(long csId,String st,String ed) throws Exception;
	/**
	 * 通过ID查询住院
	 */
	public Zyinpatient getZyinpatientByIPID(String ipid);
	/**
	 * 修改申请状态
	 * @param IPID 住院号
	 * @param AStatus 申请状态
	 * @return
	 */
	public boolean updateShengQingZhuangTai(String IPID, String AStatus);
	/**
	 * 人员出院
	 * @param IPID 住院号
	 * @param LeaveTime 出院时间
	 * @param AStatus 申请状态
	 * @return
	 */
	public boolean updateBanLiChuYuan(String IPID, String LeaveTime, String AStatus);
	/**
	 * 提取服务对象(电子病历使用)
	 * @param Date_B 挂号开始日期
	 * @param Date_e 挂号结束日期
	 * @param XingMing 姓名
	 * @param XingMingSuoXie 姓名缩写
	 * @param ShiFouChuYuan 是否出院
	 * @param YiLiaoJiGou 医疗机构
	 * @return
	 */
	public String[][] getGhregisterDZ(String Date_B, String Date_e, String XingMing, String XingMingSuoXie, Integer ShiFouChuYuan, Integer YiLiaoJiGou);
	/**
	 * 加(或减)押金余额
	 * @param IPID 住院号
	 * @param JinE 金额
	 * @return
	 */
	public boolean updateBengKeShiYaJin(String IPID, Double JinE);
}
