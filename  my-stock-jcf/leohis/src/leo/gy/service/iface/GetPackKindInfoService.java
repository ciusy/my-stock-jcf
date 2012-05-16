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
	//У���޾��������Ƿ��ظ�������ظ�����������
	public boolean FindGysupplyDisinfectPackInfoByName(String name);
	//�����޾���ID�����޾�������
	public String GetGyDisinfectPackNameById(int id);
	//�����޾���ID�����޾�������
	public String GetGyDisinfectPackContentDiscById(int id);
	
	//�����޾���ID�����޾�����ע��Ϣ
	public String GetGyDisinfectPackNoteById(int id);
	
	public int GetDIDByDPN(String dpn);
}
