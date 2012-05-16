package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Yfmsupplier;
import leo.entity.Yfmtype;

public interface YFMTypeDao extends Dao<Yfmtype>{
	public List<Yfmtype> getYFMType();
	public Boolean addYFMType(Yfmtype yfmtype);
	public Boolean delTFMType(String mtype);


}
