package leo.ys.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.FamiliRecordBasicInfo;

public interface YSFamiliRecordBasicInfoDao extends Dao<FamiliRecordBasicInfo>{
	/**
	 * ����ǰ��������ȡҪ�����ŵ���Ա
	 * @param TianShu ǰ������
	 * @return
	 */
	public String[][] getDuanXinRenYuan(Integer TianShu);
	/**
	 * ��ȡ��ͥ����������Ϣ
	 * @param RecordID ������
	 * @return
	 */
	public List<FamiliRecordBasicInfo> getFamiliRecordBasicInfo(String RecordID);
}
