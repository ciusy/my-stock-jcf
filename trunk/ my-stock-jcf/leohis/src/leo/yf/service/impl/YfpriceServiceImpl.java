package leo.yf.service.impl;

import java.util.List;

import leo.common.util.DateUtil;
import leo.entity.SfpadjustRecord;
import leo.entity.Yfprice;
import leo.yf.dao.iface.SfpadjustRecordDao;
import leo.yf.dao.iface.YfpriceDao;
import leo.yf.service.iface.YfpriceService;

public class YfpriceServiceImpl implements YfpriceService {
	private YfpriceDao yfpriceDao;
	private SfpadjustRecordDao sfpadjustRecordDao;
	
	public void setYfpriceDao(YfpriceDao yfpriceDao) {
		this.yfpriceDao = yfpriceDao;
	}


	public void setSfpadjustRecordDao(SfpadjustRecordDao sfpadjustRecordDao) {
		this.sfpadjustRecordDao = sfpadjustRecordDao;
	}


	public List<Yfprice> getYfprice(String ExbankType, Integer MInfoID,
			Integer MedicalInstID) {
		return yfpriceDao.getYfprice(ExbankType, MInfoID, MedicalInstID);
	}
	
	public boolean addTiaoJia(String[][] JiaGe){
/*
  	JiaGe[][0] 出库类型
  	JiaGe[][1] 原价格
  	JiaGe[][2]现价格（出库价格）
  	JiaGe[][3]药品信息ID
  	JiaGe[][4]医疗机构ID
  	JiaGe[][5]调价人
  	JiaGe[][6]调价时间
  	JiaGe[][7]调价类型
  	JiaGe[][8]调价数额
 */
		Long cz;
		//保存价格表
		Yfprice yfprice;
		SfpadjustRecord tjjl;
		for (int i=0;i<JiaGe.length;i++){
			cz = yfpriceDao.getCuiZai(JiaGe[i][0], Integer.parseInt(JiaGe[i][3]), Integer.parseInt(JiaGe[i][4]));
			if (cz != -1){ //已经存在，则修改
				yfpriceDao.updateJiaGe(JiaGe[i][0], Integer.parseInt(JiaGe[i][3]), Integer.parseInt(JiaGe[i][4]), Double.parseDouble(JiaGe[i][2])); //修改价格表中出库价格
				sfpadjustRecordDao.updateJiLu(cz, Double.parseDouble(JiaGe[i][1]), Double.parseDouble(JiaGe[i][2]), Long.parseLong(JiaGe[i][5]), JiaGe[i][6], JiaGe[i][7], Double.parseDouble(JiaGe[i][8]));
			}
			else{ //不存在，则加入
				yfprice = new Yfprice();
				yfprice.setExbankType(JiaGe[i][0]); //出库类型
				yfprice.setExbankP(Double.parseDouble(JiaGe[i][2])); //出库价格
				yfprice.setMinfoId(Integer.parseInt(JiaGe[i][3])); //药品信息ID
				yfprice.setMedicalInstId(Integer.parseInt(JiaGe[i][4])); //医疗机构ID
				yfpriceDao.addYfprice(yfprice); //加入价格表

				Long maxid = yfpriceDao.getmaxID(); //提取价格表最大ID

				tjjl = new SfpadjustRecord();
				tjjl.setPid(maxid); //价格ID
				tjjl.setFormerP(Double.parseDouble(JiaGe[i][1])); //原价
				tjjl.setNowadayP(Double.parseDouble(JiaGe[i][2])); //现价格
				tjjl.setAdjuster(Long.parseLong(JiaGe[i][5])); //调价人
				tjjl.setPadjustTime(DateUtil.stringToTimeStamp(JiaGe[i][6])); //调价时间
				tjjl.setAtype(JiaGe[i][7]); //调价类型
				tjjl.setAmount(Double.parseDouble(JiaGe[i][8])); //调价数额
				sfpadjustRecordDao.addSfpadjustRecordDao(tjjl); //加入调价记录表
			}
		}
		return true;
	}
	public Long getCuiZai(String cklx, Integer ypID, Integer yljgID){
		return yfpriceDao.getCuiZai(cklx, ypID, yljgID);
	}
	
	public boolean addCaiGouRuKuTiaoJia(String[][] YaoPinID_JiaGe, String[][] ChuKuLeiXing, Integer YiLiaoJiGouID){
		Yfprice yfprice;
		Double ckje;
		
		for (int i=0;i<YaoPinID_JiaGe.length;i++){ //药品信息ID及入库价格
			for (int j=0;j<ChuKuLeiXing.length;j++){ //出库类型
				yfprice = new Yfprice();
				yfprice.setExbankType(ChuKuLeiXing[j][0]); //出库类型
				ckje = Double.parseDouble(YaoPinID_JiaGe[i][1]) * Double.parseDouble(ChuKuLeiXing[j][1]) / 100;
				yfprice.setExbankP(ckje); //出库价格
				yfprice.setMinfoId(Integer.parseInt(YaoPinID_JiaGe[i][0])); //药品信息ID
				yfprice.setMedicalInstId(YiLiaoJiGouID); //医疗机构ID
				
				yfpriceDao.addYfprice(yfprice); //加入价格表
			}
		}
		return true;
	}
}
