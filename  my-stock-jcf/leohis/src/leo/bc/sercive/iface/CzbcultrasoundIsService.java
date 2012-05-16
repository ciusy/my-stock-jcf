package leo.bc.sercive.iface;

import leo.entity.CzbcultrasoundIs;

public interface CzbcultrasoundIsService {
	 
	public Boolean addCzbcultrasoundIs(String reid,String id,String rename,String csId,String bdnDescribe,String bdnVerdict,String istime,String isdoctor,String isu,String alterId, String ischeck,String bc);
	public String getMaxID();
	public String[]getRecordByItemID(String ItemID);
	 
}
