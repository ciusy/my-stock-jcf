package leo.zy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.Zymadministration;

public interface ZymadministrationDao extends Dao<Zymadministration>{
	public List<Zymadministration> getZymadministration();

}
