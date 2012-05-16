package leo.zy.service.impl;

import java.util.List;

import leo.entity.GhcostType;
import leo.entity.Zybed;
import leo.entity.ZynurseGrade;
import leo.gh.dao.iface.GhcostTypeDao;
import leo.zy.dao.iface.ZybedDao;
import leo.zy.dao.iface.ZynurseGradeDao;
import leo.zy.service.iface.ZySheZhiService;


public class ZySheZhiServiceImpl implements ZySheZhiService {
	private ZybedDao zybedDao;
	private GhcostTypeDao ghcostTypeDao;
	private ZynurseGradeDao zynurseGradeDao;
	
	
	public void setZynurseGradeDao(ZynurseGradeDao zynurseGradeDao) {
		this.zynurseGradeDao = zynurseGradeDao;
	}

	public void setGhcostTypeDao(GhcostTypeDao ghcostTypeDao) {
		this.ghcostTypeDao = ghcostTypeDao;
	}

	public void setZybedDao(ZybedDao zybedDao) {
		this.zybedDao = zybedDao;
	}

	public String[][] getChuangWei(Integer ChuangWeiHao, String ZhuangTai, String NanVu, Integer ZhuYuanBu){
		return zybedDao.getChuangWei(ChuangWeiHao, ZhuangTai, NanVu, ZhuYuanBu);
	}
	
	public boolean addChuangWei(List<Zybed> ChuangWei){
		return zybedDao.addChuangWei(ChuangWei);
	}
	
	public boolean updateChuagnWei(Integer ChuangWeiHao, List<Zybed> ChuangWei){
		zybedDao.delChuagnWei(ChuangWeiHao);
		zybedDao.addChuangWei(ChuangWei);
		return true;
	}
	public boolean delChuangWei(Integer ID){
		return zybedDao.delChuagnWei(ID);
	}
	public boolean updateChuangWeiZhuangTai(Integer ChuangWeiHao, String ZhuangTai, Integer ZhuYuanBu){
		return zybedDao.updateChuangWeiZhuangTai(ChuangWeiHao, ZhuangTai, ZhuYuanBu);
	}
	
	public List<GhcostType> getFeiYongLeiXing(Integer ID, Integer YiLiaoJiGou){
		return ghcostTypeDao.getCostTypeById(ID, YiLiaoJiGou);
	}
	
	public List<ZynurseGrade> getZynurseGrade(Integer JiBieID, String JiBieMingCheng){
		return zynurseGradeDao.getZynurseGrade(JiBieID, JiBieMingCheng);
	}


}
