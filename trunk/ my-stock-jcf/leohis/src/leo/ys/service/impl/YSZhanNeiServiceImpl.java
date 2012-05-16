package leo.ys.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import leo.common.util.CommonUtil;
import leo.common.util.DateUtil;
import leo.entity.Czdispose;
import leo.entity.Ghregister;
import leo.entity.MzopDn;
import leo.gh.dao.iface.GhregisterDao;
import leo.gh.dao.iface.GhregisterTypeDao;
import leo.mz.dao.iface.MzCzdisposeDao;
import leo.mz.dao.iface.MzopDnDao;
import leo.ys.service.iface.YSZhanNeiService;
import leo.mz.dao.iface.MzCzdisposeDao;
import leo.bc.dao.iface.CzshbioIsreDao;
import leo.mz.dao.iface.MzCzdisposeItemDescribeDao;

public class YSZhanNeiServiceImpl implements YSZhanNeiService {
	private GhregisterDao ghregisterDao;
	private GhregisterTypeDao ghregisterTypeDao;
	private MzopDnDao mzopDnDao;
	private MzCzdisposeDao mzCzdisposeDao;
	private CzshbioIsreDao czshbioIsreDao;
	private MzCzdisposeItemDescribeDao mzCzdisposeItemDescribeDao;

	
	public void setMzCzdisposeItemDescribeDao(
			MzCzdisposeItemDescribeDao mzCzdisposeItemDescribeDao) {
		this.mzCzdisposeItemDescribeDao = mzCzdisposeItemDescribeDao;
	}

	public void setCzshbioIsreDao(CzshbioIsreDao czshbioIsreDao) {
		this.czshbioIsreDao = czshbioIsreDao;
	}

	public void setMzopDnDao(MzopDnDao mzopDnDao) {
		this.mzopDnDao = mzopDnDao;
	}

	public void setGhregisterTypeDao(GhregisterTypeDao ghregisterTypeDao) {
		this.ghregisterTypeDao = ghregisterTypeDao;
	}

	public void setGhregisterDao(GhregisterDao ghregisterDao) {
		this.ghregisterDao = ghregisterDao;
	}

	public void setMzCzdisposeDao(MzCzdisposeDao mzCzdisposeDao) {
		this.mzCzdisposeDao = mzCzdisposeDao;
	}

	public String addTiJiaoJianChaXiangMu(Integer YiLiaoJiGouID, Long FuWuDuiXiangID, Integer[] XiangMuLeiXingID, Long YiShengID, Integer KeShiID, String ShiJian){
		String date;
		String MZH = "";
		String ZDH = "";
		String YMH = "";
		Integer GuaHaoLeiXingID;
		Integer ZhiXingKeShi;
		Ghregister ghregister;
		Czdispose czd;
		MzopDn mzopDn;
		
		date = ShiJian.substring(0,4) + ShiJian.substring(5,7) + ShiJian.substring(8,10);
		MZH = ghregisterDao.getMaxopnumByDate(date);
		if (MZH == null || MZH.equals("")) {
			MZH = "01" + date + "000001";
		} else {
			MZH = CommonUtil.GetNewFlowNum(MZH); //门诊号
		}
		GuaHaoLeiXingID = ghregisterTypeDao.getGhregisterTypeCunZai("孕前优生", YiLiaoJiGouID); //挂号类型ID
		
		ghregister = new Ghregister(); //创建挂号对象
			ghregister.setOpnum(MZH); //门诊号
			ghregister.setRtid(GuaHaoLeiXingID); //挂号类型ID
			ghregister.setRpname("孕前优生"); //挂号项目名[冗余]
			ghregister.setExpertOrNot(false); //是否是专家号(冗余)
			ghregister.setSid(-1l); //员工ID
			ghregister.setCsId(FuWuDuiXiangID); //服务对象ID
			ghregister.setCostTypeId(-1); //费用类型ID
			ghregister.setRu(-1); //挂号科室(冗余)
			ghregister.setRegistrar(YiShengID); //挂号员
			ghregister.setRtime(DateUtil.stringToTimeStamp(ShiJian)); //挂号时间
			ghregister.setRstatus("已使用"); //挂号状态
			ghregister.setRealPrice(0d); //实收价格[冗余]
			ghregister.setReceivablePrice(0d); //应收价格(冗余)
			ghregister.setIfCg("已收费");  //是否已收费
		ghregisterDao.addGhregister(ghregister); //挂号
		
		
		ZDH = mzopDnDao.getMaxId();
		if (ZDH.equals("no"))
		{
			ZDH = "02" + date + "000001";
		}else{
			if (ZDH.substring(2,10).equals(date)){
				ZDH = CommonUtil.GetNewFlowNum(ZDH);
			}
			else{
				ZDH = "02" + date + "000001"; //诊断号
			}
		}
		mzopDn = new MzopDn(); //创建诊断对象
			mzopDn.setOpDnId(ZDH); //门诊诊断ID
			mzopDn.setOpnum(MZH); //门诊号
			mzopDn.setCsId(FuWuDuiXiangID); //服务对象ID
			mzopDn.setDoctorId(YiShengID); //医生ID
			mzopDn.setChief(""); //主诉
			mzopDn.setDn(""); //诊断
			mzopDn.setDnTime(DateUtil.stringToTimeStamp(ShiJian)); //诊断时间
			mzopDn.setAlterDntimeId(""); //修改后诊断ID
			mzopDn.setNote("孕前优生"); //备注
			mzopDn.setStatus("可处理"); //状态
			mzopDn.setCsu(-1); //收费科室（冗余）
		mzopDnDao.addMzopDn(mzopDn); //诊断
		
		YMH = mzCzdisposeDao.getMaxitemId();
		if (YMH.equals("no")){
			YMH = "13" + date + "000001";
		}else{
			if (!YMH.substring(2,10).equals(date)){
				YMH = "13" + date + "000001"; 
			}
		}
		
		for (int i= 0;i<XiangMuLeiXingID.length;i++){
			ZhiXingKeShi = mzCzdisposeItemDescribeDao.getZhiXingKeShi(XiangMuLeiXingID[i]);
			YMH = CommonUtil.GetNewFlowNum(YMH);
			czd = new Czdispose();
			czd.setItemId(YMH); //项目ID
			czd.setItemTypeId(XiangMuLeiXingID[i]); //项目类型ID
			czd.setAu(KeShiID); //申请科室
			czd.setAproposer(YiShengID); //申请人
			czd.setAtime(DateUtil.stringToTimeStamp(ShiJian)); //申请时间;
			czd.setCsId(FuWuDuiXiangID); //服务对象ID(冗余)
			czd.setAkind("门诊申请"); //申请种类
			czd.setKindId(ZDH); //该种类ID
			czd.setExplain(""); //说明
			czd.setStatus("已交费可执行"); //状态
			czd.setReceivableP(0d); //应收（冗余）
			czd.setRealP(0d); //实收
			czd.setFnBlockId(-1); //功能块ID(冗余)
			czd.setExecutePerson(-1l); //执行人(冗余)
			czd.setExecuteTime(DateUtil.stringToTimeStamp("1900-01-01 00:00:00")); //执行时间(冗余)
			czd.setExecuteU(ZhiXingKeShi); //执行科室(冗余)
			czd.setResultTable(""); //结果所在表格(冗余)
			czd.setNote(""); //备注
			czd.setCsu(-1); //收费科室（冗余）
			czd.setCostTypeId(-1); //费用类型(冗余)
			mzCzdisposeDao.addCzdispose(czd); //处置
		}
		return ZDH;
	}

	public String[][] getJianChaShuJu(String ZhenDuanHao, String XiangMu){
		return czshbioIsreDao.getCzshbioIsreByOpDnID(ZhenDuanHao, XiangMu);
	}
	
	
}
