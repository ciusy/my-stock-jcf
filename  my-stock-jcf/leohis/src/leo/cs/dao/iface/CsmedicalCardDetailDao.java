package leo.cs.dao.iface;

import leo.common.dao.Dao;
import leo.entity.CsmedicalCardDetail;

public interface CsmedicalCardDetailDao extends Dao<CsmedicalCardDetail>{
public String[][] getCsmedicalCardDetailByDateandcsid(String stdate,String eddate,long csid);
public Boolean addCsmedicalCardDetail(CsmedicalCardDetail csmedicalCardDetail);
}

