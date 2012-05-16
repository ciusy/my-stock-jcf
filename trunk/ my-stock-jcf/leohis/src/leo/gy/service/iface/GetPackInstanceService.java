package leo.gy.service.iface;

import java.util.List;
import leo.entity.GydisinfectPackInstance;



public interface GetPackInstanceService {
	public List<GydisinfectPackInstance> getAllPackKindInstance();
	public boolean addPackInstance(GydisinfectPackInstance disinfectPackInstance);
	public boolean deletePackInstance(Integer DisinfectPackID);
	public boolean updatePackInstance(GydisinfectPackInstance disinfectPackInstance);
	public GydisinfectPackInstance getPackInstance(Integer DisinfectPackID);
	
	public List<GydisinfectPackInstance> getPackInstanceByDPID(int DPID);
	
	//mkj无菌包领用--根据领用科室和无菌包类型进行读取
	public List<GydisinfectPackInstance> ProvidePackInstance(String Uid,String Did,int UIid);
	//mkj无菌包领用--根据ID去消毒包实例表
	public boolean ModifyProvidePackInstanceById(int id,int intU);
	
	//mkj无菌包归还--根据领用科室和无菌包类型进行读取并且消毒包状态DisinfectPackStatus是已领用
	//消毒包当前所在科室UDisinfectPackIn是领用科室
	public List<GydisinfectPackInstance> GetPackInstanceBack(String Uid,String Did,int UIid);
	
	//mkj无菌包归还--根据ID去消毒包实例表GYDisinfectPackInstance里找到整条数据更改所在科室UDisinfectPackIn为供应室，
	//消毒包状态DisinfectPackStatus为待消毒。
	public boolean BackProvidePackInstanceById(int id);
	public List<GydisinfectPackInstance> getPackInstanceByDIDandDPIandDPS(int DID,int DPI,String DPS );
	public boolean setDPSByDPID(int dpid);
	public List<GydisinfectPackInstance> getPackInstanceByDpsdxd();
	public boolean setyxdByDPID(int dpid);
	public List<GydisinfectPackInstance> getPackInstanceByUid(int Uid);
	public List<GydisinfectPackInstance> getPackInstanceByDid(int Did);
	public boolean setUBSpeakByDpidandUid(int dpid ,int uid);
	public List<GydisinfectPackInstance> getsqByUid(int Uid);
	public List<GydisinfectPackInstance> getlyByUidandDid(int Uid, int Did);
	public boolean setdpInByDpidandUid(int Dpid ,int Uid);
	public List<GydisinfectPackInstance> getghByUidandDid(int Uid, int Did);
	public boolean setghByDpid(int Dpid);
}
