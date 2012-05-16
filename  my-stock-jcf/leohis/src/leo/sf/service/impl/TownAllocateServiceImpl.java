package leo.sf.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import leo.common.util.DateUtil;
import leo.entity.SfaccountDetail;
import leo.entity.SfcgTable;
import leo.entity.SfmzinvoiceContent;
import leo.entity.SfmzinvoiceHead;
import leo.entity.SftownAllocate;
import leo.entity.YfmexbankA;
import leo.sf.dao.iface.SfAccountDetailDao;
import leo.sf.dao.iface.SfCgTableDao;
import leo.sf.dao.iface.SfMzInvoiceContentDao;
import leo.sf.dao.iface.SfMzInvoiceHeadDao;
import leo.sf.dao.iface.SftownAllocateDao;
import leo.sf.service.iface.TownAllocateService;
import leo.yf.dao.iface.YfmexbankADao;

/**
 * @author xuxiangpan
 * @version 创建时间：Sep 7, 2011 3:04:28 PM
 */
public class TownAllocateServiceImpl implements TownAllocateService {

	private SftownAllocateDao sftownAllocateDao;
	private SfAccountDetailDao sfAccountDetailDao;

	private YfmexbankADao yfmexbankADao;

	private SfCgTableDao sfCgTableDao;

	private SfMzInvoiceHeadDao sfMzInvoiceHeadDao;
	private SfMzInvoiceContentDao sfMzInvoiceContentDao;

	public void addCharge(String applicationFormId, Double realMoney,
			Integer cashOfficeNO, Long casher, boolean isCash,
			Integer medicalOrgId, Integer townId, Long invoiceNO,
			String upperRealMoney, List<List<String>> projectDetails) {

		YfmexbankA yfmexbankA = yfmexbankADao.find(applicationFormId);
		yfmexbankA.setExbankStatus("已付费");
		yfmexbankADao.update(yfmexbankA);

		Timestamp nowTimeStamp = DateUtil.getNowTimeStamp();
		SfaccountDetail sfaccountDetail = new SfaccountDetail();
		if (!isCash) {
			sfaccountDetail.setAccountId(applicationFormId);
			sfaccountDetail.setAmount(realMoney);
			sfaccountDetail.setCgType("领药记账");
			sfaccountDetail.setDate(nowTimeStamp);
			sfaccountDetail.setMedicalInstitutionId(medicalOrgId);
			sfaccountDetail.setPharmacyOrCgRoomId(cashOfficeNO);
			sfaccountDetail.setTownId(townId);
			sfAccountDetailDao.save(sfaccountDetail);
		}

		SfcgTable sfcgTable = sfCgTableDao.saveSfCgTable(realMoney + "", casher
				+ "", realMoney + "", cashOfficeNO + "", nowTimeStamp,
				sfaccountDetail.getAccountNameId() + "", "乡镇收费",
				"SFAccountDetail");

		// 添加发票记录
		SfmzinvoiceHead sfmzinvoiceHead = new SfmzinvoiceHead();
		sfmzinvoiceHead.setCashierId(casher);
		sfmzinvoiceHead.setConsumerId(Long.parseLong(townId + ""));
		sfmzinvoiceHead.setInvoiceNo(invoiceNO);
		sfmzinvoiceHead.setInvoiceTime(nowTimeStamp);
		sfmzinvoiceHead.setIsCancel(false);
		sfmzinvoiceHead.setMedOrgId(medicalOrgId);
		sfmzinvoiceHead.setMoney(realMoney);
		sfmzinvoiceHead.setOriginalInvoiceNo(-1l);
		sfmzinvoiceHead.setOutpatientId(applicationFormId);
		sfmzinvoiceHead.setUppcaseMoeny(upperRealMoney);
		sfmzinvoiceHead.setInvoiceType("乡镇领药交费发票");
		sfmzinvoiceHead.setUid(cashOfficeNO);
		sfMzInvoiceHeadDao.save(sfmzinvoiceHead);
		SfmzinvoiceContent sfmzinvoiceContent = null;

		List<SfmzinvoiceContent> sfmzinvoiceContents = new ArrayList<SfmzinvoiceContent>();

		for (List<String> tempList : projectDetails) {
			sfmzinvoiceContent = new SfmzinvoiceContent();
			sfmzinvoiceContent.setBillNo(tempList.get(6));
			sfmzinvoiceContent.setInvoiceNo(sfmzinvoiceHead.getInvoiceNo());
			sfmzinvoiceContent.setMedOrgId(medicalOrgId);
			sfmzinvoiceContent.setProjectDetailName(tempList.get(0));
			sfmzinvoiceContent.setProjectMoney(Double.valueOf(tempList.get(4)));
			sfmzinvoiceContent.setProjectName(tempList.get(5));
			sfmzinvoiceContent.setProjectReduceMoney(0d);
			sfmzinvoiceContent.setProjectType("乡镇调拨付费");
			sfmzinvoiceContents.add(sfmzinvoiceContent);
		}
		sfMzInvoiceContentDao.save(sfmzinvoiceContents);

	}

	public List<SftownAllocate> getSftownAllocate(Integer TownID,
			Integer MedicalInstitution) {

		return sftownAllocateDao.getSftownAllocate(TownID, MedicalInstitution);
	}

	public SftownAllocate getById(Integer id) {
		return sftownAllocateDao.find(id);
	}

	public List<SftownAllocate> getAllSfTownAllocateByOrgId(Integer orgId) {
		return sftownAllocateDao.getScrollData("o.medicalInstitution=?",
				new Object[] { orgId });
	}

	public List<SfaccountDetail> getSfaccountDetailByTownId(Integer townId) {
		return sfAccountDetailDao.getScrollData("o.townId=?",
				new Object[] { townId });
	}

	public List<SfaccountDetail> getSfaccountDetailByTownIdAndTime(
			Integer townId, String startTime, String endTime, String type) {
		StringBuilder sb = new StringBuilder();
		sb.append("o.townId=?");
		List<Object> list = new ArrayList<Object>();
		list.add(townId);
		if (null != startTime && !"".equals(startTime.trim())) {
			if (list.size() > 0)
				sb.append(" and ");
			sb.append("o.date >= ?");
			list.add(DateUtil.get000000DateTime(startTime));
		}
		if (null != endTime && !"".equals(endTime.trim())) {
			if (list.size() > 0)
				sb.append(" and ");
			sb.append("o.date <= ?");
			list.add(DateUtil.get235959DateTime(endTime));
		}

		if (null != type && !"".equals(type) && !"全部".equals(type)) {

			if (list.size() > 0)
				sb.append(" and ");
			sb.append("o.cgType = ?");
			list.add(type);

		}

		return sfAccountDetailDao.getScrollData(sb.toString(), list.toArray());
	}

	public void addSfaccountDetail(SfaccountDetail sfaccountDetail) {
		sfAccountDetailDao.save(sfaccountDetail);

		SftownAllocate temp = sftownAllocateDao.find(sfaccountDetail
				.getTownId());
		temp.setBalance(temp.getBalance() + sfaccountDetail.getAmount());

	}

	public void setSfAccountDetailDao(SfAccountDetailDao sfAccountDetailDao) {
		this.sfAccountDetailDao = sfAccountDetailDao;
	}

	public void setSftownAllocateDao(SftownAllocateDao sftownAllocateDao) {
		this.sftownAllocateDao = sftownAllocateDao;
	}

	public void setYfmexbankADao(YfmexbankADao yfmexbankADao) {
		this.yfmexbankADao = yfmexbankADao;
	}

	public void setSfCgTableDao(SfCgTableDao sfCgTableDao) {
		this.sfCgTableDao = sfCgTableDao;
	}

	public void setSfMzInvoiceHeadDao(SfMzInvoiceHeadDao sfMzInvoiceHeadDao) {
		this.sfMzInvoiceHeadDao = sfMzInvoiceHeadDao;
	}

	public void setSfMzInvoiceContentDao(
			SfMzInvoiceContentDao sfMzInvoiceContentDao) {
		this.sfMzInvoiceContentDao = sfMzInvoiceContentDao;
	}

}
