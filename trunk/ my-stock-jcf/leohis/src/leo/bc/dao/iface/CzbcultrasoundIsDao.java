package leo.bc.dao.iface;

import java.util.List;

import leo.entity.CzbcultrasoundIs;

public interface CzbcultrasoundIsDao {
 public Boolean addCzbcultrasoundIs(CzbcultrasoundIs czbcultrasoundIs);
 public String getMaxID(); //反回最大ReportID 号码
 public List<CzbcultrasoundIs> getRecordByItemID(String ItemID);
 public CzbcultrasoundIs getCzbcultrasoundIs(String itemId);
}
