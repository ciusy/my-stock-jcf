package leo.cs.dao.iface;

import leo.entity.CsefileInfo;

public interface CsefileInfoDao {
	public CsefileInfo getCsefileInfoByCsID(long csID);
    public boolean addCsefileInfo(CsefileInfo csefileInfo);
    public boolean updateCsefileInfo(CsefileInfo csefileInfo);
    public boolean deleteCsefileInfo(CsefileInfo csefileInfo);
}
