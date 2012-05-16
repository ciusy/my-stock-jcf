package leo.yf.service.iface;

import java.util.List;
import leo.entity.Yfprice;
import leo.entity.SfpadjustRecord;

public interface YfpriceService {
	/**
	 * 查询药品价格
	 * @param ExbankType 出库类型
	 * @param MInfoID 药品Id
	 * @param MedicalInstID 医疗机构Id
	 * @return
	 */
	public List<Yfprice> getYfprice(String ExbankType, Integer MInfoID, Integer MedicalInstID);
	/**
	 * 确定调价
	 * @param JiaGe 对应价格表各字段内容
	 * @return
	 */
	public boolean addTiaoJia(String[][] JiaGe);
	public Long getCuiZai(String cklx, Integer ypID, Integer yljgID);
	/**
	 * 采购入库时，对新药品设置出库价格
	 * @param YaoPinID_JiaGe 药品信息ID及入库价格
	 * @par4a;m ChuKuLeiXing 出库类型及价格
	 * @param YiLiaoJiaGouID 医疗机构ID
	 * @return
	 * 
	 */
	public boolean addCaiGouRuKuTiaoJia(String[][] YaoPinID_JiaGe, String[][] ChuKuLeiXing, Integer YiLiaoJiGouID);
}
