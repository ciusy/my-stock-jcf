package leo.gy.service.iface;
import java.util.List;

import leo.entity.GysupplyDisinfectPackInfo;
import leo.entity.OsfnAuthorityForm;

public interface GetPackKindInfoService {
	public List<GysupplyDisinfectPackInfo> getAllPackKindInfo(int uid);
	public List<GysupplyDisinfectPackInfo> getAllPackKindInfo();
	public boolean addPackKindInfo(GysupplyDisinfectPackInfo disinfectPackInfo);
	public boolean modifyPackKindInfo(GysupplyDisinfectPackInfo g);
	public GysupplyDisinfectPackInfo FindGysupplyDisinfectPackInfoByID(int id);
	//校验无菌包名称是否重复，如果重复不可以新增
	public boolean FindGysupplyDisinfectPackInfoByName(String name);
	//根据无菌包ID返回无菌包名称
	public String GetGyDisinfectPackNameById(int id);
	//根据无菌包ID返回无菌包描述
	public String GetGyDisinfectPackContentDiscById(int id);
	
	//根据无菌包ID返回无菌包备注信息
	public String GetGyDisinfectPackNoteById(int id);
	
	public int GetDIDByDPN(String dpn);
}
