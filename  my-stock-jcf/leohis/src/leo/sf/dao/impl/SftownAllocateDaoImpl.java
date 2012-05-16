package leo.sf.dao.impl;

import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.SftownAllocate;
import leo.entity.YfinbankAitem;
import leo.sf.dao.iface.SftownAllocateDao;

public class SftownAllocateDaoImpl extends DaoSupport<SftownAllocate> implements SftownAllocateDao {

	public List<SftownAllocate> getSftownAllocate(Integer TownID,
			Integer MedicalInstitution) {
		List<SftownAllocate> list;
		list = null;
		
		if (TownID == -2 && MedicalInstitution == -2)
			list = this.getHibernateTemplate().find("from SftownAllocate");
		else
			if (TownID != -2)
				list = this.getHibernateTemplate().find("from SftownAllocate where townId = ?",TownID);
			else
				list = this.getHibernateTemplate().find("from SftownAllocate where medicalInstitution = ?",MedicalInstitution);
			return list;
	}
}
