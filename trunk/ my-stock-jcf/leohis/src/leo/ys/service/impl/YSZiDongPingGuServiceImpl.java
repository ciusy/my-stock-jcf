package leo.ys.service.impl;

import leo.ys.service.iface.YSZiDongPingGuService;
import leo.ys.dao.iface.YSZiDongPingGuDao;

public class YSZiDongPingGuServiceImpl implements YSZiDongPingGuService {
	private YSZiDongPingGuDao ySZiDongPingGuDao;

	
	public void setySZiDongPingGuDao(YSZiDongPingGuDao ySZiDongPingGuDao) {
		this.ySZiDongPingGuDao = ySZiDongPingGuDao;
	}

	public String[][] getQiZiYiBanQingKuangTo2(String RecordID){
		return ySZiDongPingGuDao.getQiZiYiBanQingKuangTo2(RecordID);
	}
	
	public String[][] getZhangFuYiBanQingKuangTo2(String RecordID){
		return ySZiDongPingGuDao.getZhangFuYiBanQingKuangTo2(RecordID);
	}

	public String[][] getMoBanBiaoTou(String LeiXing){
		return ySZiDongPingGuDao.getMoBanBiaoTou(LeiXing);
	}

	public String[][] getMoBanMinXi(Long ID){
		return ySZiDongPingGuDao.getMoBanMinXi(ID);
	}

	public String getQiZiTiGeTo2(String RecordID){
		return ySZiDongPingGuDao.getQiZiTiGeTo2(RecordID);
	}

	public String getQiZiFuKeTo2(String RecordID){
		return ySZiDongPingGuDao.getQiZiFuKeTo2(RecordID);
	}

	public String getZangFuTiGeTo2(String RecordID){
		return ySZiDongPingGuDao.getZangFuTiGeTo2(RecordID);
	}

	public String getZangFuNanKeTo2(String RecordID){
		return ySZiDongPingGuDao.getZangFuNanKeTo2(RecordID);
	}

	public String[][] getRenYuan(String KaiShiRiQi, String JieSuRiQi, String XingBie){
		return ySZiDongPingGuDao.getRenYuan(KaiShiRiQi, JieSuRiQi, XingBie);
	}

	public String getNiaoChangGui(String DangAnHao, String XingBie){
		return ySZiDongPingGuDao.getNiaoChangGui(DangAnHao, XingBie);
	}
	
	public String getBianHao(String RiQi){
		return ySZiDongPingGuDao.getBianHao(RiQi);
	}
	
}
