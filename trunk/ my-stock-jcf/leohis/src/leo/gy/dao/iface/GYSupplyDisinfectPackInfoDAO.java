package leo.gy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.GysupplyDisinfectPackInfo;

;

public interface GYSupplyDisinfectPackInfoDAO extends Dao<GysupplyDisinfectPackInfo>{

	public List<GysupplyDisinfectPackInfo> getAllPackKindInfo(int gyuid);
	public List<GysupplyDisinfectPackInfo> getAllPackKindInfo();
	
	//向无菌包类型表里插入一条数据
	/*public void insertPackKindInfo(
			GysupplyDisinfectPackInfo gysupplyDisinfectPackInfo);*/
	public boolean addPackKindInfo(GysupplyDisinfectPackInfo disinfectPackInfo);
	public boolean modifyPackKindInfo(GysupplyDisinfectPackInfo g);
	
	//通过GY001获得的无菌包类型ID读取整条数据
	public GysupplyDisinfectPackInfo FindGysupplyDisinfectPackInfoByID(int id);	
	
	//校验无菌包名称是否重复，如果重复不可以新增
	public boolean FindGysupplyDisinfectPackInfoByName(String name);
	//根据无菌包ID返回无菌包名称
	public String GetGyDisinfectPackNameById(int id);
	
	//根据无菌包ID返回无菌包名称
	public String GetGyDisinfectPackContentDiscById(int id);

	
	//根据无菌包ID返回无菌包备注信息
	public String GetGyDisinfectPackNoteById(int id);
	
	/**
	 * 由无菌包名称返回无菌包ID added by sun
	 * @param Sting dpn :无菌包名称
	 */
	public int GetDIDByDPN(String dpn);
}
