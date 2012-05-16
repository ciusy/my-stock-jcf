package leo.gy.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.GydisinfectPackInstance;

public interface GYDisinfectPackInstanceDAO extends
		Dao<GydisinfectPackInstance> {
	// 读取所有无菌包状态为非“已报废”数据
	public List<GydisinfectPackInstance> getAllPackKindInstance();

	// 增加一条数据
	public boolean addPackInstance(GydisinfectPackInstance disinfectPackInstance);

	// 删除一条数据
	public boolean deletePackInstance(Integer DisinfectPackID);

	// 更新一条数据
	public boolean updatePackInstance(
			GydisinfectPackInstance disinfectPackInstance);


	/**
	 * 通过消毒包ID查找一条数据
	 * @param DisinfectPackID int 消毒包ID
	 * @return
	 */
	public GydisinfectPackInstance getPackInstance(Integer DisinfectPackID);
	
	//mkj无菌包领用--根据领用科室和无菌包类型进行读取
	public List<GydisinfectPackInstance> ProvidePackInstance(String Uid,String Did,int UIid);
	
	//mkj无菌包领用--根据ID去消毒包实例表GYDisinfectPackInstance里找到整条数据更改所在科室UDisinfectPackIn，
	//消毒包状态DisinfectPackStatus，预约科室UBespeak值为空
	public boolean ModifyProvidePackInstanceById(int id,int intU);
	
	//mkj无菌包归还--根据领用科室和无菌包类型进行读取并且消毒包状态DisinfectPackStatus是已领用
	//消毒包当前所在科室UDisinfectPackIn是领用科室
	//BUid归还科室，Did无菌包，UIid消毒室
	public List<GydisinfectPackInstance> GetPackInstanceBack(String BUid,String Did,int UIid);
	
	//mkj无菌包归还--根据ID去消毒包实例表GYDisinfectPackInstance里找到整条数据更改所在科室UDisinfectPackIn为供应室，
	//消毒包状态DisinfectPackStatus为待消毒。
	public boolean BackProvidePackInstanceById(int id);

	public List<GydisinfectPackInstance> getPackInstanceByDPID(int DPID);

	/**
	 * 通过无菌包种类ID、所在科室、消毒包状态获得整条数据 参数可以为空，
	 * 种类为空，科室为空则传-2， 如果全为空则返回所有数据
	 * 
	 * @param DID:无菌包种类ID，DPI：所在科室，DPS：消毒包状态
	 */
	public List<GydisinfectPackInstance> getPackInstanceByDIDandDPIandDPS(
			int DID, int DPI, String DPS);

	/**
	 * 通过无菌包ID修改无菌包的状态为”已报废“
	 * 
	 * @param int dpid 无菌包ID
	 */
	public boolean setDPSByDPID(int dpid);
	/**
	 * 读取有无菌包状态为“待消毒"的数据
	 */
	public List<GydisinfectPackInstance> getPackInstanceByDpsdxd(); 
	/**
	 * 通过无菌包ID修改无菌包状态为”已消毒“
	 * @param  int dpid
	 */
	public boolean setyxdByDPID(int dpid);
	/**
	 * 通过科室ID查询所在科室的所有不是“已报废”的无菌包
	 * @param 科室ID ：int Uid； 
	 */
	public List<GydisinfectPackInstance> getPackInstanceByUid(int Uid);
	/**
	 * 通过无菌包类型ID查询所有该类型的“已消毒”与“待消毒”无菌包,
	 * 且预约科室为-1，无预约，无菌包类型ID为-2时表示全部类型。
	 * @param 无菌包类型ID ：int Did;
	 */
	public List<GydisinfectPackInstance> getPackInstanceByDid(int Did);
	/**
	 * 通过消毒包ID和科室ID设置预约科室
	 * @param dpid  int 消毒包ID
	 * @param uid  int 科室ID
	 * @return
	 */
	public boolean setUBSpeakByDpidandUid(int dpid, int uid);
	/**
	 * 由预约科室ID查询对应的已申请的非“已领用”无菌包。
	 * @param Uid		int 预约科室ID
	 * @return
	 */
	public List<GydisinfectPackInstance> getsqByUid(int Uid);
	/**
	 * 通过科室ID和无菌包类型查询无菌包实例，Did为-2时为全部类型，且不是“已领用”
	 * @param Uid		int 预约科室ID
	 * @param Did		int 无菌包类型ID
	 * @return
	 */ 
	public List<GydisinfectPackInstance> getlyByUidandDid(int Uid, int Did);
	/**
	 * 通过无菌包ID更新无菌包当前所在科室为Uid,消毒包状态为”已领用“。
	 * @param Dpid			int 无菌包ID
	 * @param Uid			int 科室ID
	 * @return
	 */
	public boolean setdpInByDpidandUid(int Dpid ,int Uid);
	/**
	 * 通过科室ID和无菌包类型ID查询消毒包状态为“已领用”的数据
	 * @param Uid		int 科室ID
	 * @param Did		int 无菌包类型ID		-2时为全部类型
	 * @return
	 */
	public List<GydisinfectPackInstance> getghByUidandDid(int Uid, int Did);
	/**
	 * 通过消毒包ID更新无菌包所在科室为消毒室ID，预约科室为-1，消毒包状态为“待消毒”
	 * @param Dpid			int 消毒包ID
	 * @return
	 */
	public boolean setghByDpid(int Dpid);

}
