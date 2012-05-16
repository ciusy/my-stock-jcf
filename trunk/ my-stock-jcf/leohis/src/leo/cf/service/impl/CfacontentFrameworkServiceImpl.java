package leo.cf.service.impl;

import java.util.List;

import leo.cf.dao.iface.CfacontentFrameworkDao;
import leo.cf.service.iface.CfacontentFrameworkService;
import leo.entity.CfacontentFramework;

public class CfacontentFrameworkServiceImpl implements
		CfacontentFrameworkService {
	
	private CfacontentFrameworkDao cfacontentFrameworkdao;
	public void setCfacontentFrameworkdao(
			CfacontentFrameworkDao cfacontentFrameworkdao) {
		this.cfacontentFrameworkdao = cfacontentFrameworkdao;
	}
	public CfacontentFramework getCfacontentFrameworkByID(Integer id) {
		return cfacontentFrameworkdao.getCfacontentFrameworkByID(id);
	}
	public Boolean deleteCfacontentFramework(Integer id) {
		return cfacontentFrameworkdao.deleteCfacontentFramework(id);
	}
	public Boolean updateCfacontentFrameworkById(CfacontentFramework c) {
		return cfacontentFrameworkdao.updateCfacontentFrameworkById(c);
	}
	public Boolean addCfacontentFramework(CfacontentFramework c) {
		return cfacontentFrameworkdao.addCfacontentFramework(c);
	}
	/**
	 * 根据所属单位和项目类型Id查询内容模板
	 */
	public List<CfacontentFramework> getCfacontentFrameworkByAffiliation(
			Integer affiliation) {
		// TODO Auto-generated method stub
		return cfacontentFrameworkdao.getCfacontentFrameworkByAffiliation(affiliation);
	}
	/**
	 * 重载根据所属单位和项目类型Id查询内容模板
	 */
	public List<CfacontentFramework> getCfacontentFrameworkByAffiliation(
			Integer affiliation,Integer itemTypeID) {
		// TODO Auto-generated method stub
		return cfacontentFrameworkdao.getCfacontentFrameworkByAffiliation(affiliation,itemTypeID);
	}
	/**
	 * 重载修改申请内容模板
	 */
	public Boolean updateCfacontentFrameworkById(Integer formworkId,
			String medicalRecords, String clinicalPhenomenon,
			String isobjectiveRequest, String elseState) {
		// TODO Auto-generated method stub
		CfacontentFramework cfa = cfacontentFrameworkdao.getCfacontentFrameworkByID(formworkId);
		cfa.setFormworkId(formworkId);
		cfa.setMedicalRecords(medicalRecords);
		cfa.setClinicalPhenomenon(clinicalPhenomenon);
		cfa.setIsobjectiveRequest(isobjectiveRequest);
		cfa.setElseState(elseState);		
		return cfacontentFrameworkdao.updateCfacontentFrameworkById(cfa);
	}
	
	

}
