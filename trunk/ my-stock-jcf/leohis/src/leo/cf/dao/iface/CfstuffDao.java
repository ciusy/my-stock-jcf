package leo.cf.dao.iface;

import leo.entity.Cfstuff;

public interface CfstuffDao {
	
	public String getPersonalConfiguration(String dname,long sid);//根据配置名称和员工id，查找该员工默认配置的对应的值
	public String[][] getinfobydisposename(String dname);
	public boolean addcfstuff(Cfstuff cfstuff);
	public boolean deletecfstuff(int id);
	public boolean updatecfstuff(int id,String value,int sid);
	public boolean changeValueByDisposeName(String disposeName ,String cfvalue);//根据配置项的名称更改该配置项的值。
}
