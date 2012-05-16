package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.ZydoctorAdvice;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 18, 2011 3:12:58 PM
 */
public interface ZydoctorAdviceDao extends Dao<ZydoctorAdvice> {

	List<ZydoctorAdvice> getZydoctorAdviceByIds(List<String> daIds);
	/**
	 * 保存医嘱
	 * @param zydoctorAdvice
	 * @return
	 */
	public boolean addZYDoctorAdvice(ZydoctorAdvice zydoctorAdvice);
	/**
	 * 返回最大医嘱 ID
	 * @return
	 */
	public String getMaxID();
	/**
	 * 提取医嘱处方
	 * @param IPID 住院号
	 * @param DAState 医嘱状态 
	 * @param IPDeptID 住院部ID
	 * @param RiQi_B 开出时间(开始)
	 * @param RiQi_E 开出时间(结束)
	 * @param ZhuangTaiTiaoJian 状态条件 (= <> ...)
	 * @return
	 */
	public String[][] getZydoctorAdvice(String IPID, String DAState, Integer IPDeptID, String RiQi_B, String RiQi_E, String ZhuangTaiTiaoJian);
	/**
	 * 提取医嘱处置
	 * @param IPID 住院号
	 * @param DAState 医嘱状态
	 * @param IPDeptID 住院部ID
	 * @param State 处置状态
	 * @param RiQi_B 开始日期
	 * @param RiQi_E 结束日期
	 * @return
	 */
	public String[][] getZydoctorAdvice_CZ(String IPID, String DAState, Integer IPDeptID, String State, String RiQi_B, String RiQi_E);
	/**
	 * 修改医嘱-用以护士审核
	 * @param DAID 医嘱ID
	 * @param ApproveNurse 审批护士
	 * @param ApproveTime 审批时间
	 * @param DAState 医嘱状态
	 * @param AFormID 药品申请单ID
	 * @return
	 */
	public boolean updateZydoctorAdviceShenHe(String DAID, Long ApproveNurse, String ApproveTime, String DAState, String AFormID);
	/**
	 * 修改医嘱状态
	 * @param DAID 医嘱ID
	 * @param DAState 状态
	 * @return
	 */
	public boolean updateZydoctorAdviceZhuangTai(String DAID, String DAState);
	/**
	 * 得到住院人员费用清单
	 * @param ZhuYuanHao 住院号
	 * @param ZhuanTai_CZ 处置状态
	 * @param ZhuangTai_CFFayao 处方发药状态
	 * @param ZhuangTai_CFTuiYao 处方退药状态
	 * @param ZhiXingShiJian_B 执行开始时间
	 * @param ZhiXingShiJian_E 执行结束时间
	 * @return
	 */
	public String[][] getFeiYongQingDan(String ZhuYuanHao, String ZhuanTai_CZ, String ZhuangTai_CFFaYao, String ZhuangTai_CFTuiYao, String ZhiXingShiJian_B, String ZhiXingShiJian_E);
	/**
	 * 删除医嘱
	 * @param DAID 医嘱ID
	 * @return
	 */
	public boolean delZYDoctorAdvice(String DAID);
	/**
	 * 按照医嘱ID提取医嘱内容
	 * @param DAID 医嘱ID
	 * @return
	 */
	public List<ZydoctorAdvice> getZydoctorAdvice(String DAID);
}
