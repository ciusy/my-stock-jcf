package leo.gh.dao.iface;

import java.util.List;

import leo.entity.GhregisterDivaricateU;

public interface GHRegisterDivaricateUDao {
public List<GhregisterDivaricateU> getAllGhregisterDivaricateUByRTID(int rtid);
public boolean addGhregisterDivaricateU(GhregisterDivaricateU ghregisterDivaricateU);
public boolean updateGhregisterDivaricateU(GhregisterDivaricateU ghregisterDivaricateU);
public boolean deleteGhregisterDivaricateU(GhregisterDivaricateU ghregisterDivaricateU);
}
