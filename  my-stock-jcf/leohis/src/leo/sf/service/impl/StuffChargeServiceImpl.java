package leo.sf.service.impl;

import leo.common.util.DateUtil;
import leo.os.service.iface.OsGiveSfService;
import leo.sf.dao.iface.SfCgTableDao;
import leo.sf.service.iface.StuffChargeService;

/**
 * 员工充值的service
 * 
 * @author xuxiangpan
 * @version 创建时间：Aug 3, 2011 11:54:20 AM
 */
public class StuffChargeServiceImpl implements StuffChargeService {
	private OsGiveSfService osGiveSfService;
	private SfCgTableDao sfCgTableDao;

	public void setSfCgTableDao(SfCgTableDao sfCgTableDao) {
		this.sfCgTableDao = sfCgTableDao;
	}

	public void setOsGiveSfService(OsGiveSfService osGiveSfService) {
		this.osGiveSfService = osGiveSfService;
	}

	public void addStuffCharge(String sid, String receiverID, String receiveRoomID, String cash) {

		// SfcgTable sfcgTable = new SfcgTable();
		// sfcgTable.setCash(Double.parseDouble(cash));
		// sfcgTable.setCashier(Long.parseLong(receiverID));
		// sfcgTable.setCgAmount(Double.parseDouble(cash));
		// sfcgTable.setCgRoomId(Integer.parseInt(receiveRoomID));
		// sfcgTable.setCgTime(DateUtil.getNowTimeStamp());
		// sfcgTable.setCgType("员工充值");
		// sfcgTable.setIdofTableLocateIn(sid);
		// String maxCSID = sfCgTableDao.getMaxCSID();
		// if (null == maxCSID) {
		// String now = DateUtil.getCurrentDateString();
		// now = now.replace("-", "");
		// sfcgTable.setCgId("CHA" + now + "00001");
		// } else
		// sfcgTable.setCgId(CommonUtil.GetNewFlowNum(maxCSID));
		//
		// sfcgTable.setTableLocateIn("OSStuff");
		// sfCgTableDao.save(sfcgTable);

		sfCgTableDao.saveSfCgTable(cash, receiverID, cash, receiveRoomID, DateUtil.getNowTimeStamp(), sid, "员工充值", "OSStuff");

		osGiveSfService.updateOsstuffCharageBalance(sid, cash);
	}

}
