package leo.gy.service.impl;

import java.util.List;

import leo.entity.GysupplyDisinfectPackInfo;

import leo.gy.dao.iface.GYSupplyDisinfectPackInfoDAO;
import leo.gy.service.iface.GetPackKindInfoService;

public class GetPackKindInfoServiceImpl implements GetPackKindInfoService{
	GYSupplyDisinfectPackInfoDAO pdao;

	public void setPdao(GYSupplyDisinfectPackInfoDAO pdao) {
		this.pdao = pdao;
	}
	public List<GysupplyDisinfectPackInfo> getAllPackKindInfo(int uid){
		
		return pdao.getAllPackKindInfo(uid);
	}
	public List<GysupplyDisinfectPackInfo> getAllPackKindInfo(){
		
		return pdao.getAllPackKindInfo();
	}
	public boolean addPackKindInfo(GysupplyDisinfectPackInfo disinfectPackInfo){
		return pdao.addPackKindInfo(disinfectPackInfo);
	}
	public boolean modifyPackKindInfo(GysupplyDisinfectPackInfo g){
		return pdao.modifyPackKindInfo(g);
	}
	public GysupplyDisinfectPackInfo FindGysupplyDisinfectPackInfoByID(int id){
		return pdao.FindGysupplyDisinfectPackInfoByID(id);
	}
	
	//校验无菌包名称是否重复，如果重复不可以新增
	public boolean FindGysupplyDisinfectPackInfoByName(String name){
		return pdao.FindGysupplyDisinfectPackInfoByName(name);
	}
	
	//根据无菌包ID返回无菌包名称
	public String GetGyDisinfectPackNameById(int id){
		return pdao.GetGyDisinfectPackNameById(id);
	}
	
	//根据无菌包ID返回无菌包名称
	public String GetGyDisinfectPackContentDiscById(int id){
		return pdao.GetGyDisinfectPackContentDiscById(id);
	}
	
	//根据无菌包ID返回无菌包备注信息
	public String GetGyDisinfectPackNoteById(int id){
		return pdao.GetGyDisinfectPackNoteById(id);
	}
	
	public int GetDIDByDPN(String dpn)
	{
		return pdao.GetDIDByDPN(dpn);
	}
}
