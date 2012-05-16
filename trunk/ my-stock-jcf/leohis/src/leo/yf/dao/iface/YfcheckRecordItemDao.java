package leo.yf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.YfcheckRecordItem;

public interface YfcheckRecordItemDao extends Dao<YfcheckRecordItem>{
	public boolean addYfcheckRecordItem(List<YfcheckRecordItem> yfcheckRecordItem);
	public List<YfcheckRecordItem> getYfcheckRecordItem(String DanHao);
	public boolean delYfcheckRecordItem(String DanHao);
	/**
	 * �����̵��¼Id��ѯ�̵��¼��
	 * @return
	 */
	public List<YfcheckRecordItem> getYfcheckRecordItemBycheckRecordId(String checkRecordId);
}
