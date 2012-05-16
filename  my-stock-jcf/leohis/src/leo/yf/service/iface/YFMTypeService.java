package leo.yf.service.iface;

import java.util.List;

import leo.entity.Yfmtype;

public interface YFMTypeService {
	public List<Yfmtype> getYFMType();
	public Boolean addYFMType(Yfmtype yfmtype);
	public Boolean delTFMType(String mtype);	
}
