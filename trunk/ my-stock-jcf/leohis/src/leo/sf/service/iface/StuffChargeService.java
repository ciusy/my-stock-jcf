package leo.sf.service.iface;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 3, 2011 11:54:02 AM
 */
public interface StuffChargeService {

	/**
	 * 给员工充值的操作
	 * @param sid
	 * @param receiverID
	 * @param receiveRoomID
	 * @param cash
	 */
	public void addStuffCharge(String sid, String receiverID, String receiveRoomID, String cash);

}
