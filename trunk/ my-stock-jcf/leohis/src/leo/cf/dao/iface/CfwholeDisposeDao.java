package leo.cf.dao.iface;

import leo.entity.CfwholeDispose;

public interface CfwholeDisposeDao {
	public CfwholeDispose getValueOfWholeDisposeByDisposeName(String disposeName);//根据全局配置项的名称，获得该项的值。
	public boolean changeValueByDisposeName(String disposeName ,String cfvalue);//根据配置项的名称更改该配置项的值。

}
