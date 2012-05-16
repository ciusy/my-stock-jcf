package leo.sf.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.SftownAllocate;

public interface SftownAllocateDao extends Dao<SftownAllocate> {
	public List<SftownAllocate> getSftownAllocate(Integer TownID,Integer MedicalInstitution); //提取乡镇表
}
