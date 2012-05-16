package leo.cs.dao.iface;

import java.util.List;

import leo.entity.CsmarriageHistory;

public interface CsmarriageHistoryDao {
	public List<CsmarriageHistory> getCsmarriageHistoryByCsID(Long csID);
	public boolean addCsmarriageHistory(CsmarriageHistory csmarriageHistory);
    public boolean updateCsmarriageHistory(CsmarriageHistory csmarriageHistory);
    public boolean deleteCsmarriageHistory(CsmarriageHistory csmarriageHistory);
    public CsmarriageHistory getCsmarriageHistoryByID(long id);
}
