package leo.rx.service.iface;

import leo.entity.CzmilkGlandIs;

public interface CzmilkGlandIsService {
	 
	public Boolean addCzmilkGlandIs(String reid,String id,String rename,String csId,String bdnDescribe,String bdnVerdict,String istime,String isdoctor,String isu,String alterId,String num,String ischeck);
	public String getMaxID();
	public String[]getRecordByItemID(String ItemID);
	 
}
