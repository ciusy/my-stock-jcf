package leo.ydj.dao.iface;

import java.util.List;

import leo.entity.CzcolposcopeIs;

public interface CzcolposcopeIsDao {
 public Boolean addCzcolposcopeIs(CzcolposcopeIs czcolposcopeIs);
 public String getMaxID(); //�������ReportID ����
 public List<CzcolposcopeIs> getRecordByItemID(String ItemID);
 public CzcolposcopeIs getCzcolposcopeIs(String itemId);
}
