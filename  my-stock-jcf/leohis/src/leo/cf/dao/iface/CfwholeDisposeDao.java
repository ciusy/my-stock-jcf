package leo.cf.dao.iface;

import leo.entity.CfwholeDispose;

public interface CfwholeDisposeDao {
	public CfwholeDispose getValueOfWholeDisposeByDisposeName(String disposeName);//����ȫ������������ƣ���ø����ֵ��
	public boolean changeValueByDisposeName(String disposeName ,String cfvalue);//��������������Ƹ��ĸ��������ֵ��

}
