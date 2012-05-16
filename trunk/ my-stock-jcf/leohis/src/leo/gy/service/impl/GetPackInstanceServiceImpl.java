package leo.gy.service.impl;

import java.util.List;

import leo.entity.GydisinfectPackInstance;
import leo.gy.service.iface.GetPackInstanceService;
import leo.gy.dao.iface.GYDisinfectPackInstanceDAO;

public class GetPackInstanceServiceImpl implements GetPackInstanceService {
	public void setGyPackInstanceDAO(GYDisinfectPackInstanceDAO gyPackInstanceDAO) {
		this.gyPackInstanceDAO = gyPackInstanceDAO;
	}

	public GYDisinfectPackInstanceDAO getGyPackInstanceDAO() {
		return gyPackInstanceDAO;
	}

	private GYDisinfectPackInstanceDAO gyPackInstanceDAO;
	public boolean addPackInstance(GydisinfectPackInstance disinfectPackInstance) {
		// TODO Auto-generated method stub
//		return this.addPackInstance(disinfectPackInstance);
		return this.gyPackInstanceDAO.addPackInstance(disinfectPackInstance);
	}

	public boolean deletePackInstance(Integer DisinfectPackID) {
		// TODO Auto-generated method stub
		return this.gyPackInstanceDAO.deletePackInstance(DisinfectPackID);
	}

	public List<GydisinfectPackInstance> getAllPackKindInstance() {
		// TODO Auto-generated method stub
		return gyPackInstanceDAO.getAllPackKindInstance();
	}

	public GydisinfectPackInstance getPackInstance(Integer DisinfectPackID) {
		// TODO Auto-generated method stub
		return gyPackInstanceDAO.getPackInstance(DisinfectPackID);
	}

	public boolean updatePackInstance(
			GydisinfectPackInstance disinfectPackInstance) {
		// TODO Auto-generated method stub
		return this.gyPackInstanceDAO.updatePackInstance(disinfectPackInstance);
	}
	public List<GydisinfectPackInstance> getPackInstanceByDPID(int DPID)
	{
		return gyPackInstanceDAO.getPackInstanceByDPID(DPID);
	}
	
	//mkj无菌包领用--根据领用科室和无菌包类型进行读取
	public List<GydisinfectPackInstance> ProvidePackInstance(String Uid,String Did,int UIid){
		return gyPackInstanceDAO.ProvidePackInstance(Uid,Did,UIid);
	}
	//mkj无菌包领用--根据ID去消毒包实例表
	public boolean ModifyProvidePackInstanceById(int id,int intU){
		return gyPackInstanceDAO.ModifyProvidePackInstanceById(id, intU);
	}
	
	//mkj无菌包归还--根据领用科室和无菌包类型进行读取并且消毒包状态DisinfectPackStatus是已领用
	//消毒包当前所在科室UDisinfectPackIn是领用科室
	public List<GydisinfectPackInstance> GetPackInstanceBack(String Uid,String Did,int UIid){
		return gyPackInstanceDAO.GetPackInstanceBack(Uid, Did,UIid);
	}
	
	//mkj无菌包归还--根据ID去消毒包实例表GYDisinfectPackInstance里找到整条数据更改所在科室UDisinfectPackIn为供应室，
	//消毒包状态DisinfectPackStatus为待消毒。
	public boolean BackProvidePackInstanceById(int id){
		return gyPackInstanceDAO.BackProvidePackInstanceById(id);
	}
	public List<GydisinfectPackInstance> getPackInstanceByDIDandDPIandDPS(int DID,int DPI,String DPS )
	{
		return gyPackInstanceDAO.getPackInstanceByDIDandDPIandDPS(DID, DPI, DPS);
	}
	public boolean setDPSByDPID(int dpid)
	{
		return gyPackInstanceDAO.setDPSByDPID(dpid);
	}
	public List<GydisinfectPackInstance> getPackInstanceByDpsdxd()
	{
		return gyPackInstanceDAO.getPackInstanceByDpsdxd();
	}
	public boolean setyxdByDPID(int dpid)
	{
		return gyPackInstanceDAO.setyxdByDPID(dpid);
	}
	public List<GydisinfectPackInstance> getPackInstanceByUid(int Uid)
	{
		return gyPackInstanceDAO.getPackInstanceByUid(Uid);
	}
	public List<GydisinfectPackInstance> getPackInstanceByDid(int Did)
	{
		return gyPackInstanceDAO.getPackInstanceByDid(Did);
	}
	public boolean setUBSpeakByDpidandUid(int dpid ,int uid)
	{
		return gyPackInstanceDAO.setUBSpeakByDpidandUid(dpid,uid);
	}
	public List<GydisinfectPackInstance> getsqByUid(int Uid)
	{
		return gyPackInstanceDAO.getsqByUid(Uid);
	}
	public List<GydisinfectPackInstance> getlyByUidandDid(int Uid, int Did)
	{
		return gyPackInstanceDAO.getlyByUidandDid(Uid, Did); 
	}
	public boolean setdpInByDpidandUid(int Dpid ,int Uid)
	{
		return gyPackInstanceDAO.setdpInByDpidandUid(Dpid, Uid);
	}
	public List<GydisinfectPackInstance> getghByUidandDid(int Uid, int Did)
	{
		return gyPackInstanceDAO.getghByUidandDid(Uid, Did);
	}
	public boolean setghByDpid(int Dpid)
	{
		return gyPackInstanceDAO.setghByDpid(Dpid);
	}
}
