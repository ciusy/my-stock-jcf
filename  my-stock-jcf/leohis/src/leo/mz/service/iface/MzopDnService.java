package leo.mz.service.iface;

import java.util.List;

import leo.entity.Czacontent;
import leo.entity.Czdispose;
import leo.entity.CzdisposeDivaricateU;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.MzopDn;

public interface MzopDnService {
	/**
	 * 
	 *ͨ������ŵõ����
	 * 
	 * @param opnum)
	 * @param 
	 */
	public MzopDn getMzopDn(String opnum);
	/**
	 * 
	 * ������ĿID��ѯ�������Ҷ���
	 * 
	 * @param ID
	 * 
	 * @return CzdisposeDivaricateU
	 */
	public CzdisposeDivaricateU getCzdById(Long id);
	
	/**
	 * 
	 * ����ID��ѯ������Ŀ����
	 * 
	 * @param ID
	 *            
	 * @return CzdisposeDivaricateU
	 */
	public List<CzdisposeItemDescribe> getCzdItemById(Long id);
	
	/**
	 * 
	 * ���
	 * 
	 * @param CzdisposeDivaricateU ����
	 *            
	 * @return 
	 */
	public void addCzdisposeDivaricateU(CzdisposeDivaricateU c);
	
	/**
	 * 
	 * ����CzdisposeDivaricateU
	 * 
	 * @param CzdisposeDivaricateU ����
	 *            
	 * @return 
	 */
	public void updateCzdisposeDivaricateU(CzdisposeDivaricateU c);
	
	/**
	 * 
	 * ɾ��
	 * 
	 * @param ID
	 *            
	 * @return 
	 */
	public void deleCzdisposeDivaricateU(Long id);
	
	/**
	 * 
	 * ����ItemTypeID��ѯ
	 * 
	 * @param ItemTypeID
	 *            
	 * @return updateCzdisposeDivaricateU����
	 */
	public List<CzdisposeDivaricateU> getCzdisposeDivaricateUList(Integer id);
	
	/**
	 * 
	 * ���CzdisposeItemDescribe
	 * 
	 * @param CzdisposeItemDescribe ����
	 *            
	 * @return
	 */
	public void addCzdisposeItemDescribe(CzdisposeItemDescribe c);
	
	/**
	 * 
	 * ɾ��CzdisposeItemDescribe
	 * 
	 * @param ID
	 *            
	 * @return
	 */
	public void deleCzdisposeItemDescribe(Integer id);
	
	/**
	 * 
	 * ����CzdisposeItemDescribe
	 * 
	 * @param CzdisposeItemDescribe ����
	 *            
	 * @return
	 */
	public void updateCzdisposeItemDescribe(CzdisposeItemDescribe c);
	
	/**
	 * ����������ѯ������Ŀ����
	 * @param id
	 * @return
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(Integer id);
	
	/**
	 * 
	 * ����ɾ��
	 * 
	 * @param ����ID
	 *            
	 * @return
	 */
	public void deleCzdisposeItemDescribebyItemTypeId(Integer id);
	/**
	 * ������ˮ��
	 * @return
	 */
	public String getNewOpNum();
	
	/**
	 * 
	 * ͨ�����Ʋ�ѯ
	 * 
	 * @param name ����
	 *            
	 * @return CzdisposeItemDescribe����
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemName(String name);
	
	/**
	 * 
	 * ����IDɾ��updateCzdisposeDivaricateU����
	 * 
	 * @param itemTypeId
	 *            
	 * @return 
	 */
	public void deleCzdisposeDivaricateUByitemTypeId(Integer id);
	/**
	 * 
	 *ģ����ѯ��������
	 * 
	 * @param spell
	 *            
	 * @return 
	 */
	public List<CzdisposeItemDescribe> getCzdisposeItemDescribeBySepll(String Sepll,int Mid);
	/**
	 * 
	 *�������
	 * 
	 * @param mzopDn
	 *            
	 * @return 
	 */
	public boolean addMzopDn(MzopDn mzopDn);
	/**
	 * 
	 *�޸�����
	 * 
	 * @param mzopDn
	 *            
	 * @return 
	 */
	public boolean updateMzopDn(MzopDn mzopDn);
	public List<MzopDn> getMzopDnByOpnum(String opnum);
	public List<MzopDn> getMzopDnByCondition(String idcardNum);
	
	/**
	 * 
	 *ͨ��������ѯ����
	 * 
	 * @param 
	 *            
	 * @return 
	 */
	public String[][] getMzopDnByConditions(String csname,String idcardNum,String stime,String etime,String status);
	/**
	 * ������Ӵ�����
	 * @param czd
	 * @return
	 */
	public boolean addCzdispose(Czdispose czd,Czacontent cza);
	/**
	 * ����ɾ��������
	 * @param czd
	 * @return
	 */
	public boolean delCzdispose(String itemId);
	/**
	 * ����������ѯ������
	 * @param itemId
	 * @return
	 */
	public Czdispose getCzdisposeByitemId(String itemId);
	/**
	 * ��ȡ�����ĿId
	 * @return
	 */
	public String getMaxitemId();
	/**
	 * ��Ӵ�����Ŀ
	 * @param czd
	 * @return
	 */
	public boolean addCzdispose(Czdispose czd);
	
	public boolean addCZAContent(Czacontent cza);
	
	public Czacontent getCZAContentByItemId(String itemId);
	
	public List<Czdispose> getCzdisposeByKindID(String kindId);
	public boolean deleteByopId(String opId);
	public List<MzopDn> getMZOpDnByDate(long csId,String st,String ed) throws Exception;
	public MzopDn getMzopDnByOpDnID(String opDnId);
	public List<MzopDn> getMzopDnBySf(String csname, String spell,String IDcardnum,String stdate,String eddate) throws Exception;
	public String[][] getMzopDnForchaxun(String csname,String spell, String idcardNum,
			String stime, String etime, String status);
	public boolean mzforSF(String opdnid);
}
