package leo.sf.service.iface;

import java.util.List;

import leo.entity.SftownAllocate;


public interface SftownAllocateService {
	public List<SftownAllocate> getSftownAllocate(Integer TownID,Integer MedicalInstitution);

}
