package leo.cf.dao.iface;

import leo.entity.Cfstuff;

public interface CfstuffDao {
	
	public String getPersonalConfiguration(String dname,long sid);//�����������ƺ�Ա��id�����Ҹ�Ա��Ĭ�����õĶ�Ӧ��ֵ
	public String[][] getinfobydisposename(String dname);
	public boolean addcfstuff(Cfstuff cfstuff);
	public boolean deletecfstuff(int id);
	public boolean updatecfstuff(int id,String value,int sid);
	public boolean changeValueByDisposeName(String disposeName ,String cfvalue);//��������������Ƹ��ĸ��������ֵ��
}
