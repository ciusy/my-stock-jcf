package leo.mz.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.MzopDn;

public interface MzopDnDao extends Dao<MzopDn> {

	/**
	 * 
	 * add by xu �õ�������շѵ�������϶���
	 * 
	 * @param officeId
	 *            ��ǰ��¼�ߵĿ���ID
	 * @return
	 */
	List<MzopDn> getNowDayMZop(Integer officeId);

	/**
	 * * add by xu ���ݷ�������id �ļ��ϵõ����еĴ��շѵı����ҵ����е���϶���
	 * 
	 * @param consumerIds
	 * @param startTime
	 * @param endTime
	 * @param officeId 
	 * @return
	 */
	List<MzopDn> getMzopDn(List<Long> consumerIds, String startTime, String endTime, int officeId);
    public MzopDn getMzopDn(String opnum);
    
    /**
     * ��ѯ��ˮ��
     * ȡǰ������ݰ���������
     * @return 
     */
    public List<MzopDn> getNewOpNum();

	List<MzopDn> getMzopDnByIDs(List<String> ids);
	/**
     * ����µ�����
     * 
     * @return 
     */
	public boolean addMzopDn(MzopDn mzopDn);
	/**
     * 
     * �޸�����
     * @return 
     */
	public boolean updateMzopDn(MzopDn mzopDn);
	/**
     * 
     * ͨ������Ų�ѯ����
     * @return 
     */
	public List<MzopDn> getMzopDnByOpnum(String opnum);

	/**
	 * �޸��������
	 * @param ZhenDuanHao ��Ϻ�
	 * @param ZhuangTai ״̬
	 * @return
	 */
	public boolean updateZhenDuanZhuangTai(String ZhenDuanHao, String ZhuangTai);

	/**
     * 
     * ͨ�����֤��ѯ����
     * @return 
     */
	public List<MzopDn> getMzopDnByCondition(String idcardNum);
	public String[][] getMzopDnByConditions(String csname,String idcardNum,String stime,String etime,String status);
	public List<MzopDn> getMZOpDnByDate(long csId,String st,String ed) throws Exception;
	public MzopDn getMzopDnByOpDnID(String opDnId);
	public List<MzopDn> getMzopDnForTY(List<MzopDn> mzlist);
	public boolean deleteByopId(String opId);
	public String[][] getMzopDnForchaxun(String csname,String spell, String idcardNum,
			String stime, String etime, String status);
	public boolean mzforSF(String opdnid);
	public String getMaxId();
}
