package leo.ys.service.iface;

import java.util.List;

import leo.entity.BirthDefects;

public interface YSChuShengQueXianService {
	/**
	 * ��ȡ����ȱ�ݶ��ǼǱ�
	 * @param RecordID ������
	 * @return
	 */
	public List<BirthDefects> getChuShengQueXian(String RecordID);
	/**
	 * �������ȱ�ݶ��ǼǱ�
	 * @param birthDefects ����
	 * @return
	 */
	public boolean addChuShengQueXian(BirthDefects birthDefects);
	/**
	 * �޸ĳ���ȱ�ݶ��ǼǱ�
	 * @param birthDefects ����
	 * @return
	 */
	public boolean updateChuShengQueXian(BirthDefects birthDefects);
	
}
