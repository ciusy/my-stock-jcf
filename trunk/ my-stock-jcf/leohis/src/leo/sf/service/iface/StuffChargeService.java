package leo.sf.service.iface;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 3, 2011 11:54:02 AM
 */
public interface StuffChargeService {

	/**
	 * ��Ա����ֵ�Ĳ���
	 * @param sid
	 * @param receiverID
	 * @param receiveRoomID
	 * @param cash
	 */
	public void addStuffCharge(String sid, String receiverID, String receiveRoomID, String cash);

}
