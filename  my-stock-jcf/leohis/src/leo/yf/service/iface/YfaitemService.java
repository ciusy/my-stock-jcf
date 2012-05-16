package leo.yf.service.iface;

import java.util.List;

import leo.entity.Yfaitem;

public interface YfaitemService {
	public boolean addYfaitem(Yfaitem yfaitem);
	public String[][] getCaiGouBiaoTao(String aformid, String date_b, String date_e,Integer pid,String InbankStatus);
	public List<Yfaitem> getYfaitem(String AFormID);
	public boolean delYfaitem(String AFormID);
}
