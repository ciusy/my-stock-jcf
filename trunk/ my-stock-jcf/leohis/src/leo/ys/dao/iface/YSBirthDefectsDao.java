package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.BirthDefects;

public interface YSBirthDefectsDao extends Dao<BirthDefects>{
	/**
	 * ��ȡ����ȱ�ݶ��ǼǱ�
	 * @param RecordID ������
	 * @return
	 */
	public List<BirthDefects> getBirthDefects(String RecordID);
	/**
	 * �������ȱ�ݶ��ǼǱ�
	 * @param birthDefects ����
	 * @return
	 */
	public boolean addBirthDefects(BirthDefects birthDefects);
	/**
	 * �޸ĳ���ȱ�ݶ��ǼǱ�
	 * @param birthDefects ����
	 * @return
	 */
	public boolean updateBirthDefects(BirthDefects birthDefects);
	
}
