package leo.cf.service.iface;

import leo.entity.CfwholeDispose;

public interface CfwholeDisposeService {
	public CfwholeDispose getValueOfWholeDisposeByDisposeName(String disposeName);//����ȫ������������ƣ���ø����ֵ��
	public boolean changeValueByDisposeName(String disposeName ,String cfvalue);//��������������Ƹ��ĸ��������ֵ��
}
