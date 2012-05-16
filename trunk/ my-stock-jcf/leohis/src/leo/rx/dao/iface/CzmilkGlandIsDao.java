package leo.rx.dao.iface;

import java.util.List;

import leo.entity.CzmilkGlandIs;

public interface CzmilkGlandIsDao {
 public Boolean addCzmilkGlandIs(CzmilkGlandIs czmilkGlandIs);
 public String getMaxID(); //反回最大ReportID 号码
 public List<CzmilkGlandIs> getRecordByItemID(String ItemID);
 public CzmilkGlandIs getCzmilkGlandIs(String itemId);
}
