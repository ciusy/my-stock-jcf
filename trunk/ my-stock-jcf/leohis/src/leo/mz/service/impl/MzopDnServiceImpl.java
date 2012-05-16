package leo.mz.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import leo.cs.service.iface.CsconsumerService;
import leo.entity.Csconsumer;
import leo.entity.Czacontent;
import leo.entity.Czdispose;
import leo.entity.CzdisposeDivaricateU;
import leo.entity.CzdisposeItemDescribe;
import leo.entity.MzopDn;
import leo.mz.dao.iface.MzCZAContentDao;
import leo.mz.dao.iface.MzCzdisposeDao;
import leo.mz.dao.iface.MzCzdisposeDivaricateUDao;
import leo.mz.dao.iface.MzCzdisposeItemDescribeDao;
import leo.mz.dao.iface.MzopDnDao;
import leo.mz.service.iface.MzopDnService;

public class MzopDnServiceImpl implements MzopDnService {
	private MzopDnDao mzopDnDao;

	private MzCzdisposeDivaricateUDao mzcdivaricatedao;
	private MzCzdisposeItemDescribeDao mzczdescribedao;
	private MzCzdisposeDao mzCzdisposeDao;
	private MzCZAContentDao mzCZAContentDao;
	private CsconsumerService csconsumerService;

	public void setCsconsumerService(CsconsumerService csconsumerService) {
		this.csconsumerService = csconsumerService;
	}

	public void setMzCZAContentDao(MzCZAContentDao mzCZAContentDao) {
		this.mzCZAContentDao = mzCZAContentDao;
	}

	public void setMzCzdisposeDao(MzCzdisposeDao mzCzdisposeDao) {
		this.mzCzdisposeDao = mzCzdisposeDao;
	}

	public void setMzczdescribedao(MzCzdisposeItemDescribeDao mzczdescribedao) {
		this.mzczdescribedao = mzczdescribedao;
	}

	public void setMzcdivaricatedao(MzCzdisposeDivaricateUDao mzcdivaricatedao) {
		this.mzcdivaricatedao = mzcdivaricatedao;
	}

	public void setMzopDnDao(MzopDnDao mzopDnDao) {
		this.mzopDnDao = mzopDnDao;
	}

	public MzopDn getMzopDn(String opnum) {

		return mzopDnDao.getMzopDn(opnum);
	}

	/**
	 * 
	 * ������ĿID��ѯ�������Ҷ���
	 * 
	 * @param ID
	 * 
	 * @return CzdisposeDivaricateU
	 */
	public CzdisposeDivaricateU getCzdById(Long id) {
		return mzcdivaricatedao.getCzdById(id);
	}

	/**
	 * 
	 * ����ID��ѯ������Ŀ����
	 * 
	 * @param ID
	 * 
	 * @return CzdisposeDivaricateU
	 */
	public List<CzdisposeItemDescribe> getCzdItemById(Long id) {
		return mzczdescribedao.getCzdById(id);
	}

	/**
	 * 
	 * ɾ��
	 * 
	 * @param ID
	 * 
	 * @return
	 */
	public void deleCzdisposeDivaricateU(Long id) {
		mzcdivaricatedao.deleCzdisposeDivaricateU(id);

	}

	/**
	 * 
	 * ���
	 * 
	 * @param CzdisposeDivaricateU
	 *            ����
	 * 
	 * @return
	 */
	public void addCzdisposeDivaricateU(CzdisposeDivaricateU c) {
		mzcdivaricatedao.addCzdisposeDivaricateU(c);

	}

	/**
	 * 
	 * ����CzdisposeDivaricateU
	 * 
	 * @param CzdisposeDivaricateU
	 *            ����
	 * 
	 * @return
	 */
	public void updateCzdisposeDivaricateU(CzdisposeDivaricateU c) {
		mzcdivaricatedao.updateCzdisposeDivaricateU(c);
	}

	/**
	 * 
	 * ɾ��CzdisposeItemDescribe
	 * 
	 * @param ID
	 * 
	 * @return
	 */
	public void deleCzdisposeItemDescribe(Integer id) {
		mzczdescribedao.deleCzdisposeItemDescribe(id);

	}

	/**
	 * 
	 * ���CzdisposeItemDescribe
	 * 
	 * @param CzdisposeItemDescribe
	 *            ����
	 * 
	 * @return
	 */
	public void addCzdisposeItemDescribe(CzdisposeItemDescribe c) {
		mzczdescribedao.addCzdisposeItemDescribe(c);

	}

	/**
	 * 
	 * ����CzdisposeItemDescribe
	 * 
	 * @param CzdisposeItemDescribe
	 *            ����
	 * 
	 * @return
	 */
	public void updateCzdisposeItemDescribe(CzdisposeItemDescribe c) {
		mzczdescribedao.updateCzdisposeItemDescribe(c);
	}

	/**
	 * 
	 * ����ItemTypeID��ѯ
	 * 
	 * @param ItemTypeID
	 * 
	 * @return updateCzdisposeDivaricateU����
	 */
	public List<CzdisposeDivaricateU> getCzdisposeDivaricateUList(Integer id) {
		return mzcdivaricatedao.getCzdisposeDivaricateUList(id);
	}

	/**
	 * 
	 * ����ɾ��
	 * 
	 * @param ����ID
	 * 
	 * @return
	 */
	public void deleCzdisposeItemDescribebyItemTypeId(Integer id) {
		mzczdescribedao.deleCzdisposeItemDescribebyItemTypeId(id);
	}

	/**
	 * ����������ѯ������Ŀ����
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(Integer id) {
		return mzczdescribedao.getCzdisposeItemDescribeByitemTypeId(id);
	}

	/**
	 * ������ˮ��
	 */
	public String getNewOpNum() {
		// TODO Auto-generated method stub
		List<MzopDn> list = mzopDnDao.getNewOpNum();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String date = format.format(new Date());
		if (list.size() != 0) {
			MzopDn md = (MzopDn) list.get(0);
			Long opnum = Long.parseLong(1 + md.getOpDnId()) + 1;

			String opnumStr = opnum.toString().substring(1,
					opnum.toString().length());
			String opnumDate = opnumStr.substring(2, 10);
			return opnumStr;
		}
		return "02" + date + "000001";
	}

	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemName(String name) {
		return mzczdescribedao.getCzdisposeItemDescribeByitemName(name);
	}

	public void deleCzdisposeDivaricateUByitemTypeId(Integer id) {
		mzcdivaricatedao.deleCzdisposeDivaricateUByitemTypeId(id);
	}

	public List<CzdisposeItemDescribe> getCzdisposeItemDescribeBySepll(
			String Sepll, int Mid) {

		return mzczdescribedao.getCzdisposeItemDescribeBySepll(Sepll, Mid);
	}

	public boolean addMzopDn(MzopDn mzopDn) {

		return mzopDnDao.addMzopDn(mzopDn);
	}

	public boolean updateMzopDn(MzopDn mzopDn) {

		return mzopDnDao.updateMzopDn(mzopDn);
	}

	public List<MzopDn> getMzopDnByOpnum(String opnum) {
		return mzopDnDao.getMzopDnByOpnum(opnum);
	}

	public List<MzopDn> getMzopDnByCondition(String idcardNum) {

		return mzopDnDao.getMzopDnByCondition(idcardNum);
	}

	public String[][] getMzopDnByConditions(String csname, String idcardNum,
			String stime, String etime, String status) {

		return mzopDnDao.getMzopDnByConditions(csname, idcardNum, stime, etime,
				status);
	}

	/**
	 * ������Ӵ�����
	 */
	public boolean addCzdispose(Czdispose czd, Czacontent cza) {
		// TODO Auto-generated method stub
		try {
			mzCzdisposeDao.addCzdispose(czd);
			mzCZAContentDao.addCZAContent(cza);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ����ɾ��������
	 */
	public boolean delCzdispose(String itemId) {
		Czdispose czd = mzCzdisposeDao.getCzdisposeByitemId(itemId);
		return mzCzdisposeDao.delCzdispose(czd);
	}

	/**
	 * ����������ѯ������
	 */
	public Czdispose getCzdisposeByitemId(String itemId) {
		// TODO Auto-generated method stub
		return mzCzdisposeDao.getCzdisposeByitemId(itemId);
	}

	/**
	 * ��ȡ�����ĿId
	 */
	public String getMaxitemId() {

		return mzCzdisposeDao.getMaxitemId();
	}

	public boolean addCzdispose(Czdispose czd) {

		return mzCzdisposeDao.addCzdispose(czd);
	}

	public Czacontent getCZAContentByItemId(String itemId) {
		return mzCZAContentDao.getCZAContentByItemId(itemId);
	}

	public boolean addCZAContent(Czacontent cza) {

		return mzCZAContentDao.addCZAContent(cza);
	}

	public List<Czdispose> getCzdisposeByKindID(String kindId) {
		List<Czdispose> list = mzCzdisposeDao.getCzdisposeByKindID(kindId);
		return mzCzdisposeDao.getCzdisposeByKindID(kindId);
	}

	public List<MzopDn> getMZOpDnByDate(long csId, String st, String ed)
			throws Exception {

		return mzopDnDao.getMZOpDnByDate(csId, st, ed);
	}

	public MzopDn getMzopDnByOpDnID(String opDnId) {

		return mzopDnDao.getMzopDnByOpDnID(opDnId);
	}

	public List<MzopDn> getMzopDnBySf(String csname, String spell,
			String IDcardnum, String stdate, String eddate) throws Exception  {
		List<Csconsumer> cslist = new ArrayList<Csconsumer>();
		List<MzopDn> mzlistsc = new ArrayList<MzopDn>();
		List<MzopDn> mzlistth = new ArrayList<MzopDn>();
		cslist = csconsumerService.getCsconsumerlistByInfo(csname, spell,
				IDcardnum);
		int i = cslist.size();
		if (i > 0) {
			List<MzopDn> mzlist = new ArrayList<MzopDn>();
			for (int j = 0; j < i; j++) {
				mzlist = mzopDnDao.getMZOpDnByDate(cslist.get(j).getCsId(),
						stdate, eddate);
				if (mzlist.size() > 0) {
					
					mzlistsc = mzopDnDao.getMzopDnForTY(mzlist);
					if (mzlistsc.size() > 0) {
						for(int k=0;k<mzlistsc.size();k++)
						{
						mzlistth.add(mzlistsc.get(k));
						}
						
					} else {
						return null;
					}
					
				}else{
					return null;
				}
			}

		} else {
			return null;
		}
		return mzlistth;
	}

	public boolean deleteByopId(String opId) {
		// TODO Auto-generated method stub
		return mzopDnDao.deleteByopId(opId);
	}

	public String[][] getMzopDnForchaxun(String csname, String spell,
			String idcardNum, String stime, String etime, String status) {
		// TODO Auto-generated method stub
		return mzopDnDao.getMzopDnForchaxun(csname, spell, idcardNum, stime, etime, status);
	}

	public boolean mzforSF(String opdnid) {
		// TODO Auto-generated method stub
		return mzopDnDao.mzforSF(opdnid);
	}

}
