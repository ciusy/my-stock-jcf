package leo.dx.service.impl;

import java.util.List;

import leo.common.util.DateUtil;
import leo.dx.service.iface.DuanXinChuLiService;
import leo.dx.dao.iface.SuccessfulSmsDao;
import leo.entity.HealthyPregnantSms;
import leo.entity.SuccessfulSms;
import leo.ys.dao.iface.YSHealthyPregnantSmsDao;
import leo.ys.dao.iface.YSSmsModuleTermDao;

public class DuanXinChuLiServiceImpl implements DuanXinChuLiService {
	private SuccessfulSmsDao successfulSmsDao;
	private YSHealthyPregnantSmsDao ySHealthyPregnantSmsDao;
	private YSSmsModuleTermDao ySSmsModuleTermDao;  


	public void setySSmsModuleTermDao(YSSmsModuleTermDao ySSmsModuleTermDao) {
		this.ySSmsModuleTermDao = ySSmsModuleTermDao;
	}

	public void setySHealthyPregnantSmsDao(
			YSHealthyPregnantSmsDao ySHealthyPregnantSmsDao) {
		this.ySHealthyPregnantSmsDao = ySHealthyPregnantSmsDao;
	}

	public void setSuccessfulSmsDao(SuccessfulSmsDao successfulSmsDao) {
		this.successfulSmsDao = successfulSmsDao;
	}

	public String[][] getYiFaXinXi(String ShiJian_B, String ShiJian_E,
			String ZhuangTai, String MoKuai, Integer UnitID) {
		return successfulSmsDao.getSuccessfulSms(ShiJian_B, ShiJian_E,
				ZhuangTai, MoKuai, UnitID);
	}

	public List<HealthyPregnantSms> getYouShengDuanXin(String ZhuangTai, Integer DanWeiID){
		return ySHealthyPregnantSmsDao.getHealthyPregnantSms(ZhuangTai, DanWeiID);
	}

	public boolean updateFaXinChuLi(List<SuccessfulSms> DuanXinJiLu, String LeiXing){
		if (LeiXing.equals("新发")){
			for (int i=0;i<DuanXinJiLu.size();i++) //加入到短信表
				successfulSmsDao.addSuccessfulSms(DuanXinJiLu.get(i));
		}
		else{ //重发
			for (int i=0;i<DuanXinJiLu.size();i++) //修改短信表
				successfulSmsDao.updateSuccessfulSms(DuanXinJiLu.get(i).getModuleNum(), //String
													 DuanXinJiLu.get(i).getSendId(), //Long
						                             DuanXinJiLu.get(i).getUnitId(), //Integer
						                             DuanXinJiLu.get(i).getSendTime().toString(), //String
						                             DuanXinJiLu.get(i).getStatus(), //String
						                             DuanXinJiLu.get(i).getErrorCode()); //String
		}
		for (int i=0;i<DuanXinJiLu.size();i++){
			if (DuanXinJiLu.get(i).getModuleNum().equals("ys")){ //修改优生模块
				ySHealthyPregnantSmsDao.updateHealthyPregnantSms(DuanXinJiLu.get(i).getSendId(),DuanXinJiLu.get(i).getSendTime().toString(),DuanXinJiLu.get(i).getStatus());
			}
		}
		
		return true;
	}

	public String[][] getAllXiangNeiRong(){
		return ySSmsModuleTermDao.getAllXiangNeiRong(); 
	}
	
}
