package leo.yf.service.impl;

import java.util.List;

import leo.entity.YfmwayTo;
import leo.yf.service.iface.YfmwayToService;
import leo.yf.dao.iface.YfmwayToDao;


public class YfmwayToServiceImpl implements YfmwayToService {
    private YfmwayToDao yfmwayTodao;
    
	public List<YfmwayTo> getYfmwayTo() {
		return yfmwayTodao.getYfmwayTo();
	}

	public void setYfmwayTodao(YfmwayToDao yfmwayTodao) {
		this.yfmwayTodao = yfmwayTodao;
	}

    public Boolean addYfmwayTo(YfmwayTo yfmwayto){
    	return yfmwayTodao.addYfmwayTo(yfmwayto);
    }
    
	public Boolean delYfmwayTo(String yfmwayto){
		return yfmwayTodao.delYfmwayTo(yfmwayto);
	}
}
