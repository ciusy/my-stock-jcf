package leo.sf.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import leo.bc.sercive.iface.CzGiveSfService;
import leo.cf.dao.iface.CfmedicalInstDao;
import leo.common.util.CommonUtil;
import leo.common.util.DateUtil;
import leo.cs.service.iface.CsGiveSfService;
import leo.cs.service.iface.CsconsumerService;
import leo.entity.CfmedicalInst;
import leo.entity.Csconsumer;
import leo.entity.CsmedicalCardDetail;
import leo.entity.Ghregister;
import leo.entity.MzopDn;
import leo.entity.Osstuff;
import leo.entity.Osuform;
import leo.entity.SfcgTable;
import leo.entity.SfcreditCard;
import leo.entity.SfcsByOtherMethod;
import leo.entity.SfmzinvoiceContent;
import leo.entity.SfmzinvoiceHead;
import leo.entity.Sfopcg;
import leo.entity.YfmexbankA;
import leo.gh.service.iface.GhGiveSFService;
import leo.mz.service.iface.MzGiveSfService;
import leo.os.service.iface.OsGiveSfService;
import leo.sf.dao.iface.SfCgTableDao;
import leo.sf.dao.iface.SfCreditCardDao;
import leo.sf.dao.iface.SfCsByOtherMethodDao;
import leo.sf.dao.iface.SfMzInvoiceContentDao;
import leo.sf.dao.iface.SfMzInvoiceHeadDao;
import leo.sf.dao.iface.SfReduceItemDao;
import leo.sf.dao.iface.SfopcgDao;
import leo.sf.dao.iface.SfreduceTableDao;
import leo.sf.service.iface.MZChargeService;
import leo.yf.service.iface.YfGiveSfService;

/**
 * 
 * @author xuxiangpan
 * 
 */
@SuppressWarnings("unchecked")
public class MZChargeServiceImpl implements MZChargeService {

	private MzGiveSfService mzGiveSfService;

	private CsconsumerService csconsumerService;

	private OsGiveSfService osGiveSfService;

	private GhGiveSFService gHGiveSFService;

	private SfopcgDao sfopcgDao;

	private YfGiveSfService yfGiveSfService;

	private CzGiveSfService czGiveSfService;
	private SfReduceItemDao sfReduceItemDao;
	private SfreduceTableDao sfreduceTableDao;
	private SfCsByOtherMethodDao sfCsByOtherMethodDao;

	private SfCgTableDao sfCgTableDao;
	private SfCreditCardDao sfCreditCardDao;
	private CsGiveSfService csGiveSfService;
	private SfMzInvoiceContentDao sfMzInvoiceContentDao;

	private SfMzInvoiceHeadDao sfMzInvoiceHeadDao;

	private CfmedicalInstDao cfmedicalInstDao;

	public void updateMZstatus(String oPDiagnoseID) {

		mzGiveSfService.updateMZOpDnStatus(oPDiagnoseID, "可处理");
	}

	public List<List<String>> getReturnInvoiceProjects(List<List<String>> list) {
		Set<Long> invoiceNOs = new HashSet<Long>();
		for (List<String> tempList : list) {
			invoiceNOs.add(Long.parseLong(tempList.get(5)));
		}
		if (invoiceNOs.size() < 1)
			return Collections.EMPTY_LIST;
		// 得到和没有注销的发票关联的出库单
		List<List<String>> prescriptions = sfMzInvoiceHeadDao.getPrescriptions(
				invoiceNOs, false);
		// 得到和没有注销的发票关联的处置
		List<List<String>> disposes = sfMzInvoiceHeadDao.getDisposes(
				invoiceNOs, false);
		List<List<String>> returnList = CommonUtil.addListToList(prescriptions,
				disposes);
		return returnList;
	}

	public List<List<String>> updateCharge(List<List<String>> list,
			Double realMoeny, String upperRealMoney) {

		Set<Long> invoiceNOs = new HashSet<Long>();
		Set<String> disposeApplicationFormIds = new HashSet<String>();
		Set<String> storageApplicationFormIds = new HashSet<String>();
		Long maxInvoiceNo = null;

		for (List<String> tempList : list) {
			invoiceNOs.add(Long.parseLong(tempList.get(5)));

			if (!tempList.get(6).equals("")) {// 处置
				disposeApplicationFormIds.add(tempList.get(4));
			} else// 处方
			{
				storageApplicationFormIds.add(tempList.get(4));
			}
		}

		// 得到除了退完的所有的处方和 一个没有退的处方（新发票要打印的处方 ）
		List<List<String>> prescriptions = sfMzInvoiceHeadDao.getPrescriptions(
				invoiceNOs, false);

		Iterator<List<String>> iterator = prescriptions.iterator();
		// for (List<String> tempList : list) {
		// while (iterator.hasNext()) {
		// List<String> next = iterator.next();
		// if (next.get(9).equals(tempList.get(4))) {// 处方要判断是否已经退完，能直接删除
		// iterator.remove();
		// }
		// }
		// }

		// 得到和没有注销的发票关联的处置
		List<List<String>> disposes = sfMzInvoiceHeadDao.getDisposes(
				invoiceNOs, false);
		iterator = disposes.iterator();
		for (List<String> tempList : list) {
			while (iterator.hasNext()) {
				List<String> next = iterator.next();
				if (next.get(9).equals(tempList.get(4))) {// 处置能直接删除
					iterator.remove();
				}
			}
		}
		List<List<String>> returnList = CommonUtil.addListToList(prescriptions,
				disposes);

		// 修改处置项目的状态
		if (disposeApplicationFormIds.size() > 0)
			czGiveSfService.updateCzDisposeStatus(disposeApplicationFormIds,
					"已退费");
		// 修改入库申请单狂态
		if (storageApplicationFormIds.size() > 0)
			yfGiveSfService.updateStorageApplicationFormStatus(
					storageApplicationFormIds, "已退费");
		// 修改发票的状态
		sfMzInvoiceHeadDao.updateStatus(invoiceNOs, true);
		maxInvoiceNo = Collections.max(invoiceNOs);

		SfmzinvoiceHead maxNOSfmzinvoiceHead = sfMzInvoiceHeadDao
				.getById(maxInvoiceNo);
		// 全部退完了
		if (null == returnList && returnList.size() < 1)
			return Collections.EMPTY_LIST;
		// 添加新的发票记录
		SfmzinvoiceHead sfmzinvoiceHead = new SfmzinvoiceHead();
		sfmzinvoiceHead.setCashierId(maxNOSfmzinvoiceHead.getCashierId());
		sfmzinvoiceHead.setConsumerId(maxNOSfmzinvoiceHead.getConsumerId());
		sfmzinvoiceHead.setInvoiceNo(maxInvoiceNo + 1);
		sfmzinvoiceHead.setMedOrgId(maxNOSfmzinvoiceHead.getMedOrgId());
		sfmzinvoiceHead.setOutpatientId(maxNOSfmzinvoiceHead.getOutpatientId());

		sfmzinvoiceHead.setOriginalInvoiceNo(maxInvoiceNo);

		sfmzinvoiceHead.setInvoiceTime(DateUtil.getNowTimeStamp());
		sfmzinvoiceHead.setIsCancel(false);
		sfmzinvoiceHead.setMoney(realMoeny);
		sfmzinvoiceHead.setUppcaseMoeny(upperRealMoney);
		sfMzInvoiceHeadDao.save(sfmzinvoiceHead);

		SfmzinvoiceContent sfmzinvoiceContent = null;
		List<SfmzinvoiceContent> sfmzinvoiceContents = new ArrayList<SfmzinvoiceContent>();
		for (List<String> tempList : returnList) {
			sfmzinvoiceContent = new SfmzinvoiceContent();
			sfmzinvoiceContent.setBillNo(tempList.get(9));
			sfmzinvoiceContent.setInvoiceNo(sfmzinvoiceHead.getInvoiceNo());
			sfmzinvoiceContent.setMedOrgId(maxNOSfmzinvoiceHead.getMedOrgId());
			sfmzinvoiceContent.setProjectDetailName(tempList.get(0));
			sfmzinvoiceContent.setProjectMoney(Double.valueOf(tempList.get(4)));
			sfmzinvoiceContent.setProjectName(tempList.get(10));
			sfmzinvoiceContent.setProjectReduceMoney(Double.valueOf(tempList
					.get(6)));
			sfmzinvoiceContent.setProjectType(tempList.get(8).toString()
					.equals("1") ? "门诊处方" : "门诊处置");
			sfmzinvoiceContents.add(sfmzinvoiceContent);
		}
		sfMzInvoiceContentDao.save(sfmzinvoiceContents);

		return returnList;

	}

	public List<List<String>> updateIsCharedNotTakeDrugsCharge(
			List<List<String>> list, Double realMoeny, String upperRealMoney) {

		Set<Long> invoiceNOs = new HashSet<Long>();
		Set<String> storageApplicationFormIds = new HashSet<String>();
		Set<String> storageItemIds = new HashSet<String>();
		Long maxInvoiceNo = null;

		for (List<String> tempList : list) {
			invoiceNOs.add(Long.parseLong(tempList.get(5)));
			storageApplicationFormIds.add(tempList.get(4));
			storageItemIds.add(tempList.get(7));
		}

		// 得到除了退完的所有的处方和 一个没有退的处方（新发票要打印的处方 ）
		List<List<String>> prescriptions = sfMzInvoiceHeadDao
				.getPrescriptionsExcept(invoiceNOs, false,
						storageItemIds);

		Iterator<List<String>> iterator = prescriptions.iterator();
		// 得到和没有注销的发票关联的处置
		List<List<String>> disposes = sfMzInvoiceHeadDao.getDisposes(
				invoiceNOs, false);
		iterator = disposes.iterator();
		for (List<String> tempList : list) {
			while (iterator.hasNext()) {
				List<String> next = iterator.next();
				if (next.get(9).equals(tempList.get(4))) {// 处置能直接删除
					iterator.remove();
				}
			}
		}
		List<List<String>> returnList = CommonUtil.addListToList(prescriptions,
				disposes);
		// 修改入库申请单狂态
		if (storageApplicationFormIds.size() > 0)
			yfGiveSfService.updateYFmbankStatus(
					storageApplicationFormIds, "已申请");
		// 修改发票的状态
		sfMzInvoiceHeadDao.updateStatus(invoiceNOs, true);
		maxInvoiceNo = Collections.max(invoiceNOs);

		SfmzinvoiceHead maxNOSfmzinvoiceHead = sfMzInvoiceHeadDao
				.getById(maxInvoiceNo);
		// 全部退完了
		if (null == returnList && returnList.size() < 1)
			return Collections.EMPTY_LIST;

		// 添加新的发票记录
		SfmzinvoiceHead sfmzinvoiceHead = new SfmzinvoiceHead();
		sfmzinvoiceHead.setCashierId(maxNOSfmzinvoiceHead.getCashierId());
		sfmzinvoiceHead.setConsumerId(maxNOSfmzinvoiceHead.getConsumerId());
		sfmzinvoiceHead.setInvoiceNo(maxInvoiceNo + 1);
		sfmzinvoiceHead.setMedOrgId(maxNOSfmzinvoiceHead.getMedOrgId());
		sfmzinvoiceHead.setOutpatientId(maxNOSfmzinvoiceHead.getOutpatientId());

		sfmzinvoiceHead.setOriginalInvoiceNo(maxInvoiceNo);

		sfmzinvoiceHead.setInvoiceTime(DateUtil.getNowTimeStamp());
		sfmzinvoiceHead.setIsCancel(false);
		sfmzinvoiceHead.setMoney(realMoeny);
		sfmzinvoiceHead.setUppcaseMoeny(upperRealMoney);
		sfMzInvoiceHeadDao.save(sfmzinvoiceHead);

		SfmzinvoiceContent sfmzinvoiceContent = null;
		List<SfmzinvoiceContent> sfmzinvoiceContents = new ArrayList<SfmzinvoiceContent>();
		for (List<String> tempList : returnList) {
			sfmzinvoiceContent = new SfmzinvoiceContent();
			sfmzinvoiceContent.setBillNo(tempList.get(9));
			sfmzinvoiceContent.setInvoiceNo(sfmzinvoiceHead.getInvoiceNo());
			sfmzinvoiceContent.setMedOrgId(maxNOSfmzinvoiceHead.getMedOrgId());
			sfmzinvoiceContent.setProjectDetailName(tempList.get(0));
			sfmzinvoiceContent.setProjectMoney(Double.valueOf(tempList.get(4)));
			sfmzinvoiceContent.setProjectName(tempList.get(10));
			sfmzinvoiceContent.setProjectReduceMoney(Double.valueOf(tempList
					.get(6)));
			sfmzinvoiceContent.setProjectType(tempList.get(8).toString()
					.equals("1") ? "门诊处方" : "门诊处置");
			sfmzinvoiceContents.add(sfmzinvoiceContent);
		}
		sfMzInvoiceContentDao.save(sfmzinvoiceContents);

		return returnList;

	}

	public SfmzinvoiceHead getByMedOrgId(Integer medOrgId, Long invoiceNO) {
		return sfMzInvoiceHeadDao.getByMedOrgId(medOrgId, invoiceNO);

	}

	public List<List<String>> getReturnPrescription(String outPatientId,
			String status) {
		// "已入库"
		List<List<String>> list = yfGiveSfService.getReturnPrescription(
				outPatientId, status);

		// Set<String> aFormIds = new HashSet<String>();
		// for (List<String> tempList : list) {
		// aFormIds.add(tempList.get(4));
		// }
		// if (null != aFormIds && aFormIds.size() < 1)
		// return Collections.EMPTY_LIST;
		// List<Object[]> invoices = yfGiveSfService.getInvoiceCF(aFormIds);
		// for (List<String> tempList : list) {
		// for (Object[] objects : invoices) {
		// if (objects[0].toString().equals(tempList.get(4))) {
		// tempList.add(objects[1].toString());
		// break;
		// }
		// }
		// }
		return list;
	}

	public List<List<String>> getDisposeByStatus(String kindType,
			String kindId, String status) {
		List<List<String>> list = czGiveSfService.getInvoiceCZ(kindType,
				kindId, status);

		return list;
	}

	public List<String> getWillDeletedMethod(String OpDnID) {
		List<String> ids = new ArrayList<String>();
		ids.add(OpDnID);
		List<MzopDn> list = mzGiveSfService.getMzopDnByIDs(ids);

		Csconsumer csconsumer = csconsumerService.getCInfoById(list.get(0)
				.getCsId());

		List<String> returnList = new ArrayList<String>();
		returnList.add(list.get(0).getOpnum());
		// returnList.add(csconsumer.getCsname());
		// returnList.add(csconsumer.getSex());
		returnList.add(""
				+ DateUtil.getBetweenYears(DateUtil.getCurrentDateTime(),
						csconsumer.getBirthday()));

		Ghregister ghregister = gHGiveSFService.getGhRegister(list.get(0)
				.getOpnum());

		Osuform osuform = osGiveSfService.getUFormById(ghregister.getRu());
		returnList.add(osuform.getUname());
		returnList.add(csconsumer.getMedicalInsuranceCode());
		return returnList;
	}

	public List<List<String>> getCosumer(String consumerName, String idCard,
			String medicalCard, String startTime, String endTime, int flag,
			int officeId, boolean isCharge, Integer medOrgId) {

		int expiryDay = Integer.parseInt(cfmedicalInstDao
				.getValueBydisposeName("挂号有效期", medOrgId));
		Date currentDateTime = DateUtil.getCurrentDateTime();
		Date expiryEndDateTime = currentDateTime;
		Date expiryStartDateTime = DateUtil.dateIncreaseByDay(currentDateTime,
				-expiryDay);

		if (!"".equals(startTime)
				&& DateUtil.dateAfterDate(
						DateUtil.stringToDateTime(startTime + " 00:00:00"),
						expiryStartDateTime)) {

		} else {
			startTime = DateUtil.dateToStringWithTime(expiryStartDateTime);
		}

		if (!"".equals(endTime)
				&& DateUtil.dateAfterDate(expiryEndDateTime,
						DateUtil.stringToDateTime(endTime + " 23:59:59"))) {

		} else {
			endTime = DateUtil.dateToStringWithTime(expiryEndDateTime);
		}

		List<MzopDn> list1 = null;
		// 查找有服务对象
		list1 = mzGiveSfService.getMzopDn(null, startTime, endTime, officeId);

		if (list1.size() < 1) {
			return Collections.EMPTY_LIST;
		}

		List<Long> ids = new ArrayList<Long>();
		// 得到查询结果中所有服务对象ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getCsId());
		}

		List<Csconsumer> list2 = csconsumerService.getByCondition(ids,
				consumerName, idCard, medicalCard, flag);

		ids.clear();
		// 得到查询结果中所有医护人员对象ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getDoctorId());
		}

		List<Osstuff> list3 = osGiveSfService.getByIds(ids);

		List<String> ids1 = new ArrayList<String>();
		// 得到减免类型
		for (MzopDn mzopDn : list1) {
			ids1.add(mzopDn.getOpnum());
		}
		List<Object[]> list4 = gHGiveSFService.getCostType(ids1);

		List<List<String>> returnList = new ArrayList<List<String>>();

		List<String> tempList = null;

		String opDnId = "";
		String csName = "";
		String csSex = "";
		String csIdCard = "";
		String dnTime = "";
		String doctorName = "";
		String isFree = "";
		String freeTye = "";
		String costType = "";// 费用类型减免类型的ID
		Integer age = 0;
		boolean isLoop = false;
		for (MzopDn mzopDn : list1) {

			isLoop = false;
			Ghregister ghregister = gHGiveSFService.getGhRegister(mzopDn
					.getOpnum());
			// 诊断号
			opDnId = mzopDn.getOpDnId();
			if (isCharge) {
				if (!ghregister.getIfCg().equals("已收费"))
					isLoop = true;

				if (czGiveSfService.getCZCount("门诊申请", opDnId, new String[] {
						"未交费可执行", "未交费不可执行", "未交费已执行" }) > 0)
					isLoop = true;

				if (yfGiveSfService.getCFCount(mzopDn.getOpnum(),
						new String[] { "已申请" }) > 0)
					isLoop = true;
			} else {
				if (czGiveSfService.getCZCount("门诊申请", opDnId, "已交费可执行") > 0)
					isLoop = true;
				if (yfGiveSfService.getCFReturnCount(mzopDn.getOpnum(), "已入库") > 0)
					isLoop = true;

			}

			if (!isLoop)
				continue;

			for (Csconsumer csconsumer : list2) {
				if (csconsumer.getCsId().longValue() == mzopDn.getCsId()
						.longValue()) {
					// 服务对象名称
					csName = csconsumer.getCsname();
					// 服务对象的身份证
					csIdCard = csconsumer.getIdcardNum();
					// 服务对象性别
					csSex = csconsumer.getSex();
					age = DateUtil.getBetweenYears(currentDateTime,
							csconsumer.getBirthday());

					// 诊断时间
					dnTime = DateUtil.dateToStringWithTime(mzopDn.getDnTime());

					for (Osstuff osstuff : list3) {
						if (osstuff.getSid().longValue() == mzopDn
								.getDoctorId()) {
							// 诊断医生姓名
							doctorName = osstuff.getSname();
							break;
						}
					}
					for (Object[] obj : list4) {
						if (mzopDn.getOpnum().equals(String.valueOf(obj[0]))) {
							// 是否是减免
							isFree = (!Boolean.valueOf(obj[2].toString())) ? "否"
									: "是";

							// 减免类型
							freeTye = obj[1].toString();
							costType = obj[3].toString();
							break;
						}
					}
					tempList = new ArrayList<String>();
					tempList.add(opDnId);
					tempList.add(mzopDn.getOpnum());
					tempList.add(csName);
					tempList.add(csSex);
					tempList.add(age + "");
					tempList.add(csIdCard);
					tempList.add(dnTime);
					tempList.add(doctorName);
					tempList.add(isFree);
					tempList.add(freeTye);
					tempList.add(String.valueOf(mzopDn.getCsId()));
					tempList.add(costType);
					String officeName = "";

					if (null != ghregister) {
						Osuform osuform = osGiveSfService
								.getUFormById(ghregister.getRu());
						if (null != osuform)
							officeName = osuform.getUname();
					}
					tempList.add(officeName);
					returnList.add(tempList);
					break;
				}
			}
		}

		return returnList;
	}

	public List<List<String>> getIsCharedNotTakeDrugsCosumer(int officeId) {

		List<MzopDn> list1 = mzGiveSfService.getNowDayMZop(officeId);

		List<List<String>> returnList = combination(list1);
		return returnList;
	}

	public List<List<String>> getIsCharedNotTakeDrugsCosumer(
			String consumerName, String idCard, String medicalCard,
			String startTime, String endTime, int flag, int officeId,
			Integer medOrgId) {

		int expiryDay = Integer.parseInt(cfmedicalInstDao
				.getValueBydisposeName("挂号有效期", medOrgId));
		Date currentDateTime = DateUtil.getCurrentDateTime();
		Date expiryEndDateTime = currentDateTime;
		Date expiryStartDateTime = DateUtil.dateIncreaseByDay(currentDateTime,
				-expiryDay);

		if (!"".equals(startTime)
				&& DateUtil.dateAfterDate(
						DateUtil.stringToDateTime(startTime + " 00:00:00"),
						expiryStartDateTime)) {

		} else {
			startTime = DateUtil.dateToStringWithTime(expiryStartDateTime);
		}

		if (!"".equals(endTime)
				&& DateUtil.dateAfterDate(expiryEndDateTime,
						DateUtil.stringToDateTime(endTime + " 23:59:59"))) {

		} else {
			endTime = DateUtil.dateToStringWithTime(expiryEndDateTime);
		}

		List<MzopDn> list1 = null;
		// 查找有服务对象
		list1 = mzGiveSfService.getMzopDn(null, startTime, endTime, officeId);

		if (list1.size() < 1) {
			return Collections.EMPTY_LIST;
		}

		List<Long> ids = new ArrayList<Long>();
		// 得到查询结果中所有服务对象ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getCsId());
		}
		List<Csconsumer> list2 = csconsumerService.getByCondition(ids,
				consumerName, idCard, medicalCard, flag);
		ids.clear();
		// 得到查询结果中所有医护人员对象ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getDoctorId());
		}
		List<Osstuff> list3 = osGiveSfService.getByIds(ids);
		List<String> ids1 = new ArrayList<String>();
		// 得到减免类型
		for (MzopDn mzopDn : list1) {
			ids1.add(mzopDn.getOpnum());
		}
		List<Object[]> list4 = gHGiveSFService.getCostType(ids1);
		List<List<String>> returnList = new ArrayList<List<String>>();
		List<String> tempList = null;
		String opDnId = "";
		String csName = "";
		String csSex = "";
		String csIdCard = "";
		String dnTime = "";
		String doctorName = "";
		String isFree = "";
		String freeTye = "";
		String costType = "";// 费用类型减免类型的ID
		Integer age = 0;
		boolean isLoop = false;
		for (MzopDn mzopDn : list1) {
			isLoop = false;
			Ghregister ghregister = gHGiveSFService.getGhRegister(mzopDn
					.getOpnum());
			// 诊断号
			opDnId = mzopDn.getOpDnId();
			// 先不查询处置
			// if (czGiveSfService.getCZCount("门诊申请", opDnId, "已交费可执行") > 0)
			// isLoop = true;

			if (yfGiveSfService.getCFCount(mzopDn.getOpnum(),
					new String[] { "已拒绝" }) > 0)
				isLoop = true;

			if (!isLoop)
				continue;

			for (Csconsumer csconsumer : list2) {
				if (csconsumer.getCsId().longValue() == mzopDn.getCsId()
						.longValue()) {
					// 服务对象名称
					csName = csconsumer.getCsname();
					// 服务对象的身份证
					csIdCard = csconsumer.getIdcardNum();
					// 服务对象性别
					csSex = csconsumer.getSex();
					age = DateUtil.getBetweenYears(currentDateTime,
							csconsumer.getBirthday());

					// 诊断时间
					dnTime = DateUtil.dateToStringWithTime(mzopDn.getDnTime());

					for (Osstuff osstuff : list3) {
						if (osstuff.getSid().longValue() == mzopDn
								.getDoctorId()) {
							// 诊断医生姓名
							doctorName = osstuff.getSname();
							break;
						}
					}
					for (Object[] obj : list4) {
						if (mzopDn.getOpnum().equals(String.valueOf(obj[0]))) {
							// 是否是减免
							isFree = (!Boolean.valueOf(obj[2].toString())) ? "否"
									: "是";

							// 减免类型
							freeTye = obj[1].toString();
							costType = obj[3].toString();
							break;
						}
					}
					tempList = new ArrayList<String>();
					tempList.add(opDnId);
					tempList.add(mzopDn.getOpnum());
					tempList.add(csName);
					tempList.add(csSex);
					tempList.add(age + "");
					tempList.add(csIdCard);
					tempList.add(dnTime);
					tempList.add(doctorName);
					tempList.add(isFree);
					tempList.add(freeTye);
					tempList.add(String.valueOf(mzopDn.getCsId()));
					tempList.add(costType);
					String officeName = "";

					if (null != ghregister) {
						Osuform osuform = osGiveSfService
								.getUFormById(ghregister.getRu());
						if (null != osuform)
							officeName = osuform.getUname();
					}
					tempList.add(officeName);
					returnList.add(tempList);
					break;
				}
			}
		}

		return returnList;
	}

	/**
	 * add by xu 得到当天待收费的病人，属于登录人科室的
	 * 
	 * @param officeId
	 * @return
	 */
	public List<List<String>> getCosumer(int officeId, boolean isCharge) {

		List<MzopDn> list1 = mzGiveSfService.getNowDayMZop(officeId);

		List<List<String>> returnList = combination(list1, isCharge);
		return returnList;
	}

	/**
	 * 查找，并组合界面要显示的对象
	 * 
	 * @param list1
	 * @param isCharge
	 * @return
	 */
	private List<List<String>> combination(List<MzopDn> list1, boolean isCharge) {
		if (list1.size() < 1) {
			return Collections.EMPTY_LIST;
		}

		List<Long> ids = new ArrayList<Long>();
		// 得到查询结果中所有服务对象ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getCsId());
		}

		List<Csconsumer> list2 = csconsumerService.getByIds(ids);

		ids.clear();
		// 得到查询结果中所有医护人员对象ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getDoctorId());
		}

		List<Osstuff> list3 = osGiveSfService.getByIds(ids);

		List<String> ids1 = new ArrayList<String>();
		// 得到减免类型
		for (MzopDn mzopDn : list1) {
			ids1.add(mzopDn.getOpnum());
		}
		List<Object[]> list4 = gHGiveSFService.getCostType(ids1);

		List<List<String>> returnList = new ArrayList<List<String>>();

		List<String> tempList = null;

		String opDnId = "";
		String csName = "";
		String csSex = "";
		String csIdCard = "";
		String dnTime = "";
		String doctorName = "";
		String isFree = "";
		String freeTye = "";
		String costType = "";// 费用类型减免类型的ID
		Integer age = 0;
		boolean isLoop = false;
		for (MzopDn mzopDn : list1) {
			isLoop = false;
			Ghregister ghregister = gHGiveSFService.getGhRegister(mzopDn
					.getOpnum());

			// 诊断号
			opDnId = mzopDn.getOpDnId();

			if (isCharge) {

				if (!ghregister.getIfCg().equals("已收费"))
					isLoop = true;

				if (czGiveSfService.getCZCount("门诊申请", opDnId, new String[] {
						"未交费可执行", "未交费不可执行", "未交费已执行" }) > 0)
					isLoop = true;

				if (yfGiveSfService.getCFCount(mzopDn.getOpnum(),
						new String[] { "已申请" }) > 0)
					isLoop = true;
			} else {

				if (czGiveSfService.getCZCount("门诊申请", opDnId, "已交费可执行") > 0)
					isLoop = true;

				if (yfGiveSfService.getCFReturnCount(mzopDn.getOpnum(), "已入库") > 0)
					isLoop = true;

			}
			if (!isLoop)
				continue;

			// 诊断时间
			dnTime = DateUtil.dateToStringWithTime(mzopDn.getDnTime());

			for (Csconsumer csconsumer : list2) {
				if (csconsumer.getCsId().longValue() == mzopDn.getCsId()
						.longValue()) {
					// 服务对象名称
					// tempList.add(csconsumer.getCsname());
					csName = csconsumer.getCsname();
					// 服务对象的身份证
					// tempList.add(csconsumer.getIdcardNum());
					csIdCard = csconsumer.getIdcardNum();
					// 服务对象性别
					// tempList.add(csconsumer.getSex());
					csSex = csconsumer.getSex();
					age = DateUtil.getBetweenYears(
							DateUtil.getCurrentDateTime(),
							csconsumer.getBirthday());

					break;
				}
			}
			for (Osstuff osstuff : list3) {
				if (osstuff.getSid().longValue() == mzopDn.getDoctorId()) {
					// 诊断医生姓名
					// tempList.add(osstuff.getSname());
					doctorName = osstuff.getSname();
					break;
				}
			}
			for (Object[] obj : list4) {
				if (mzopDn.getOpnum().equals(String.valueOf(obj[0]))) {
					// 是否是减免
					// tempList.add(!Boolean.valueOf(obj[2].toString()) ? "是" :
					// "否");
					isFree = (!Boolean.valueOf(obj[2].toString())) ? "否" : "是";
					// 减免类型
					// tempList.add(obj[1].toString());
					freeTye = obj[1].toString();
					costType = obj[3].toString();
					break;
				}
			}
			tempList = new ArrayList<String>();
			tempList.add(opDnId);
			tempList.add(mzopDn.getOpnum());
			tempList.add(csName);
			tempList.add(csSex);
			tempList.add(age + "");
			tempList.add(csIdCard);
			tempList.add(dnTime);
			tempList.add(doctorName);
			tempList.add(isFree);
			tempList.add(freeTye);
			tempList.add(String.valueOf(mzopDn.getCsId()));
			tempList.add(costType);
			String officeName = "";

			if (null != ghregister) {
				Osuform osuform = osGiveSfService.getUFormById(ghregister
						.getRu());
				if (null != osuform)
					officeName = osuform.getUname();
			}
			tempList.add(officeName);
			returnList.add(tempList);
		}
		return returnList;
	}

	public List<List<String>> getProject(String oPDiagnoseID) {
		// 锁定诊断记录
		// mzGiveSfService.updateMZOpDnStatus(oPDiagnoseID, "已锁定");
		mzGiveSfService.updateMZOpDnStatus(oPDiagnoseID, "不可处理");
		// List<Object[]> list2 = yfGiveSfService.getCF(oPDiagnoseID, "门诊领药");
		//
		// List<Object[]> list3 = czGiveSfService.getCZ("门诊收费", oPDiagnoseID);
		// List<SfreduceTable> list6 = null;
		// List<SfreduceItem> list5 = null;
		// if (isReduce == 1) {// 挂号类型对应的费用类型表中，是可以减免的，才查询处置和处方的减免模版
		// HashSet<Integer> itemTypeIDSet = new HashSet<Integer>();
		// // 得到处方对应的所有的药品信息Id
		// for (Object[] obje : list2) {
		// itemTypeIDSet.add(Integer.parseInt(obje[8].toString()));
		// }
		// // 得到处方对应的减免表信息
		// list6 = sfreduceTableDao.getByMInfoID(itemTypeIDSet);
		//
		// itemTypeIDSet.clear();
		// // 得到处置对应的所有的项目类型Id
		// for (Object[] obje : list3) {
		// itemTypeIDSet.add(Integer.parseInt(obje[2].toString()));
		// }
		// // 得到处置对应的减免项目信息
		// list5 = sfReduceItemDao.getByItemTypeID(itemTypeIDSet);
		//
		// }
		//
		// // 组合返回给前台
		// List<List<String>> list4 = new ArrayList<List<String>>();
		// List<String> tempList = null;
		// boolean flag = false;
		// // 处方处理
		// for (Object[] str : list2) {
		// flag = false;
		// tempList = new ArrayList<String>();
		// // for (int i = 0; i < str.length - 1; i++) {// 除去最后一列的药品信息ID
		// for (int i = 0; i < 8; i++) {// 先添加前8列
		// tempList.add(str[i].toString());
		// }
		//
		// // 开始添加第9列
		// if (isReduce == 1) {// 挂号类型对应的费用类型表中，是可以减免的，才查询处置和处方的减免模版
		//
		// for (SfreduceTable sfreduceTable : list6) {
		// // 检查这个处方有减免模版
		// if (sfreduceTable.getMinfoId().intValue() == Integer
		// .parseInt(str[8].toString())) {
		// if (sfreduceTable.getReduceByPercent().intValue() == 100) {
		// tempList.add(String.valueOf((Double
		// .parseDouble(str[6].toString()) * sfreduceTable
		// .getReduceByNum())));
		// }
		// // if (sfreduceTable.getReduceByNum().intValue() == 0)
		// else
		// tempList.add(String.valueOf((Double
		// .parseDouble(str[6].toString())
		// * Double.parseDouble(str[2].toString())
		// * sfreduceTable.getReduceByPercent() / 100)));
		//
		// flag = true;
		// break;
		// }
		// }
		// }
		// if (!flag)
		// tempList.add("");
		// // 添加第9列后面的
		// for (int i = 9; i < str.length; i++) {
		// tempList.add(str[i].toString());
		// }
		//
		// list4.add(tempList);
		// }
		//
		// for (Object[] str : list3) {
		// flag = false;
		// tempList = new ArrayList<String>();
		// tempList.add(str[0].toString());
		// tempList.add("");
		// tempList.add(str[1].toString());
		// tempList.add("");
		// tempList.add("");
		// tempList.add("");
		// tempList.add("");
		// tempList.add("");
		// if (isReduce == 1) {// 挂号类型对应的费用类型表中，是可以减免的，才查询处置和处方的减免模版
		// // 检查这个处置有没有减免模版
		// for (SfreduceItem sfreduceItem : list5) {
		// if (sfreduceItem.getCostTypeId().intValue() == Integer
		// .parseInt(str[2].toString())) {
		//
		// if (sfreduceItem.getReducePercent().intValue() == 100) {
		// // 处置现在定为只开一个,所以数量定为1
		// tempList.add(String.valueOf(sfreduceItem
		// .getReduceAmount() * 1));
		// } else
		// // 处置现在定为只开一个,所以数量定为1
		// tempList.add(String.valueOf(Double
		// .parseDouble(str[1].toString())
		// * 1
		// * sfreduceItem.getReducePercent() / 100));
		// flag = true;
		// break;
		// }
		// }
		// }
		// if (!flag)
		// tempList.add("");
		// tempList.add("");
		// tempList.add(str[2].toString());
		// list4.add(tempList);
		// }
		// return list4.size() > 0 ? list4 : Collections.EMPTY_LIST;
		return null;
	}

	private List<List<String>> combination(List<MzopDn> list1) {
		if (list1.size() < 1) {
			return Collections.EMPTY_LIST;
		}

		List<Long> ids = new ArrayList<Long>();
		// 得到查询结果中所有服务对象ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getCsId());
		}

		List<Csconsumer> list2 = csconsumerService.getByIds(ids);

		ids.clear();
		// 得到查询结果中所有医护人员对象ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getDoctorId());
		}

		List<Osstuff> list3 = osGiveSfService.getByIds(ids);

		List<String> ids1 = new ArrayList<String>();
		// 得到减免类型
		for (MzopDn mzopDn : list1) {
			ids1.add(mzopDn.getOpnum());
		}
		List<Object[]> list4 = gHGiveSFService.getCostType(ids1);

		List<List<String>> returnList = new ArrayList<List<String>>();

		List<String> tempList = null;

		String opDnId = "";
		String csName = "";
		String csSex = "";
		String csIdCard = "";
		String dnTime = "";
		String doctorName = "";
		String isFree = "";
		String freeTye = "";
		String costType = "";// 费用类型减免类型的ID
		Integer age = 0;
		boolean isLoop = false;
		for (MzopDn mzopDn : list1) {
			isLoop = false;
			Ghregister ghregister = gHGiveSFService.getGhRegister(mzopDn
					.getOpnum());

			// 诊断号
			opDnId = mzopDn.getOpDnId();
			// 目录 没有 处理处置
			// if (czGiveSfService.getCZCount("门诊申请", opDnId, "已交费可执行") > 0)
			// isLoop = true;

			if (yfGiveSfService.getCFCount(mzopDn.getOpnum(),
					new String[] { "已拒绝" }) > 0)
				isLoop = true;

			if (!isLoop)
				continue;

			// 诊断时间
			dnTime = DateUtil.dateToStringWithTime(mzopDn.getDnTime());

			for (Csconsumer csconsumer : list2) {
				if (csconsumer.getCsId().longValue() == mzopDn.getCsId()
						.longValue()) {
					// 服务对象名称
					// tempList.add(csconsumer.getCsname());
					csName = csconsumer.getCsname();
					// 服务对象的身份证
					// tempList.add(csconsumer.getIdcardNum());
					csIdCard = csconsumer.getIdcardNum();
					// 服务对象性别
					// tempList.add(csconsumer.getSex());
					csSex = csconsumer.getSex();
					age = DateUtil.getBetweenYears(
							DateUtil.getCurrentDateTime(),
							csconsumer.getBirthday());

					break;
				}
			}
			for (Osstuff osstuff : list3) {
				if (osstuff.getSid().longValue() == mzopDn.getDoctorId()) {
					// 诊断医生姓名
					// tempList.add(osstuff.getSname());
					doctorName = osstuff.getSname();
					break;
				}
			}
			for (Object[] obj : list4) {
				if (mzopDn.getOpnum().equals(String.valueOf(obj[0]))) {
					// 是否是减免
					// tempList.add(!Boolean.valueOf(obj[2].toString()) ? "是" :
					// "否");
					isFree = (!Boolean.valueOf(obj[2].toString())) ? "否" : "是";
					// 减免类型
					// tempList.add(obj[1].toString());
					freeTye = obj[1].toString();
					costType = obj[3].toString();
					break;
				}
			}
			tempList = new ArrayList<String>();
			tempList.add(opDnId);
			tempList.add(mzopDn.getOpnum());
			tempList.add(csName);
			tempList.add(csSex);
			tempList.add(age + "");
			tempList.add(csIdCard);
			tempList.add(dnTime);
			tempList.add(doctorName);
			tempList.add(isFree);
			tempList.add(freeTye);
			tempList.add(String.valueOf(mzopDn.getCsId()));
			tempList.add(costType);
			String officeName = "";

			if (null != ghregister) {
				Osuform osuform = osGiveSfService.getUFormById(ghregister
						.getRu());
				if (null != osuform)
					officeName = osuform.getUname();
			}
			tempList.add(officeName);
			returnList.add(tempList);
		}
		return returnList;
	}

	public Boolean addCharge(String consumerId, String diagnoseID,
			String costTypeId, String officesNumber, List<List<String>> list,
			String personnelNumber, String realMoeny, String cashPay,
			String medicalCardPay, String medicalInsurancePay, String bankPay,
			String reduceMoney, Integer orgId, Long invoiceNO,
			String upperRealMoney, String outpatientId,
			List<List<String>> projectDetails) {
		Set<String> aFormIDs = new HashSet<String>();
		// 处方的项目Id集合
		List<Long> prescriptionItemIDList = new ArrayList<Long>();
		// 处方的项目对应 的减免金额
		List<Double> prescriptionItemReduce = new ArrayList<Double>();
		// 处置的项目id集合
		List<String> disposeItemIdList = new ArrayList<String>();

		// 处置的项目对应 的减免金额
		List<Double> disposeItemReduce = new ArrayList<Double>();

		double prescriptionCharge = 0l;// 药费收费金额(冗余)
		double disposeCharge = 0l;// 处置收费金额(冗余)

		Timestamp nowTimeStamp = DateUtil.getNowTimeStamp();
		// 添加发票记录
		SfmzinvoiceHead sfmzinvoiceHead = new SfmzinvoiceHead();
		sfmzinvoiceHead.setCashierId(Long.parseLong(personnelNumber));
		sfmzinvoiceHead.setConsumerId(Long.parseLong(consumerId));
		sfmzinvoiceHead.setInvoiceNo(invoiceNO);
		sfmzinvoiceHead.setInvoiceTime(nowTimeStamp);
		sfmzinvoiceHead.setIsCancel(false);
		sfmzinvoiceHead.setMedOrgId(orgId);
		sfmzinvoiceHead.setMoney(Double.parseDouble(realMoeny));
		sfmzinvoiceHead.setOriginalInvoiceNo(-1l);
		sfmzinvoiceHead.setOutpatientId(outpatientId);
		sfmzinvoiceHead.setUppcaseMoeny(upperRealMoney);
		sfmzinvoiceHead.setCostType(Integer.parseInt(costTypeId));
		sfmzinvoiceHead.setInvoiceType("门诊交费发票");
		sfmzinvoiceHead.setUid(Integer.parseInt(officesNumber));
		sfMzInvoiceHeadDao.save(sfmzinvoiceHead);
		SfmzinvoiceContent sfmzinvoiceContent = null;

		List<SfmzinvoiceContent> sfmzinvoiceContents = new ArrayList<SfmzinvoiceContent>();

		String opnum = "";
		String money = "";
		for (List<String> tempOutList : list) {
			sfmzinvoiceContent = new SfmzinvoiceContent();
			if (tempOutList.get(5).equals("1")) {// 处方
				// 根据前台传过来的整个表格进行过滤,确定处置和处方的申请单等信息
				prescriptionItemIDList.add(Long.parseLong(tempOutList.get(6)));
				prescriptionItemReduce
						.add(tempOutList.get(2).equals("") ? (double) 0
								: Double.parseDouble(tempOutList.get(2)));
				aFormIDs.add(tempOutList.get(7));
				prescriptionCharge = prescriptionCharge
						+ (Double.parseDouble(tempOutList.get(1)) - (tempOutList
								.get(2).equals("") ? (double) 0 : Double
								.parseDouble(tempOutList.get(2))));
				sfmzinvoiceContent.setProjectType("门诊处方");
			} else if (tempOutList.get(5).equals("0")) {// 处置
				disposeItemIdList.add(tempOutList.get(6));
				disposeItemReduce
						.add(tempOutList.get(2).equals("") ? (double) 0
								: Double.parseDouble(tempOutList.get(2)));
				disposeCharge = disposeCharge
						+ (Double.parseDouble(tempOutList.get(1)) - (tempOutList
								.get(2).equals("") ? (double) 0 : Double
								.parseDouble(tempOutList.get(2))));
				sfmzinvoiceContent.setProjectType("门诊处置");
			} else if (tempOutList.get(5).equals("-1"))// 挂号
			{
				sfmzinvoiceContent.setProjectType("挂号");
				opnum = tempOutList.get(6).toString();
				money = tempOutList.get(2).toString();
				Ghregister ghregister = gHGiveSFService.getGhRegister(opnum);
				if (!ghregister.getIfCg().equals("已收费")) {
					ghregister.setRealPrice(ghregister.getRealPrice()
							- Double.parseDouble(money));
					ghregister.setIfCg("已收费");
					gHGiveSFService.updateGhRegister(ghregister);
				}
			}

			sfmzinvoiceContent.setBillNo(tempOutList.get(6));
			sfmzinvoiceContent.setInvoiceNo(sfmzinvoiceHead.getInvoiceNo());
			sfmzinvoiceContent.setMedOrgId(orgId);
			sfmzinvoiceContent.setProjectDetailName(tempOutList.get(0));
			sfmzinvoiceContent.setProjectMoney(Double.valueOf(tempOutList
					.get(1)));
			sfmzinvoiceContent.setProjectName(tempOutList.get(3));
			sfmzinvoiceContent.setProjectReduceMoney(Double.valueOf(tempOutList
					.get(2)));

			sfmzinvoiceContents.add(sfmzinvoiceContent);

		}
		sfMzInvoiceContentDao.save(sfmzinvoiceContents);

		// 修改出库申请单表中的状态 和详细项目的减免金额 等信息
		yfGiveSfService.updateStatusAndReduce(aFormIDs, prescriptionItemIDList,
				prescriptionItemReduce, costTypeId);
		// 修改处置的状态和实收等信息
		czGiveSfService.updateStatusAndReduce(disposeItemIdList,
				disposeItemReduce, costTypeId, officesNumber, personnelNumber,
				nowTimeStamp);
		// 得到申请单信息
		YfmexbankA yfmexbankA = null;
		if (aFormIDs.size() > 0) {
			String aformId = null;
			for (String tempString : aFormIDs) {
				aformId = tempString;
				break;
			}
			yfmexbankA = yfGiveSfService.getYFMExbankA(aformId);
		}

		CfmedicalInst cfmedicalInst = cfmedicalInstDao.getSingleData(
				"o.medicalInstId=? and o.disposeName=?", new Object[] { orgId,
						"门诊发票起始号" });
		cfmedicalInst.setCfvalue(cfmedicalInst.getCfvalue() + 1);

		// 添加门诊收费表的信息
		// Sfopcg sfopcg = new Sfopcg();
		//
		// sfopcg.setOpdiagnoseId(diagnoseID);
		// sfopcg.setCsId(Long.parseLong(consumerId));
		// sfopcg.setPrintReceiptOrNot(true);
		// sfopcg.setAformId(null != yfmexbankA ? yfmexbankA.getAformId() : "");
		// sfopcg.setCashier(Long.parseLong(personnelNumber));
		//
		// sfopcg.setCgTime(nowTimeStamp);
		// sfopcg.setMcgBalance(prescriptionCharge);
		// sfopcg.setTreatmentCgBalance(disposeCharge);
		// sfopcg.setCgRoomId(Integer.parseInt(officesNumber));
		// sfopcg.setPharmacyId(null != yfmexbankA ? yfmexbankA.getPharmacyId()
		// : -1);
		// sfopcg.setCashAmount(cashPay.trim().equals("") ? (long) 0 : Double
		// .parseDouble(cashPay));
		// sfopcg.setMedicalCardAffordAmount(medicalCardPay.trim().equals("") ?
		// (long) 0
		// : Double.parseDouble(medicalCardPay));
		// // 还没添加发票，和备注
		// sfopcg.setPrintReceiptOrNot(true);
		// sfopcg.setReceiptCode(sfmzinvoiceHead.getInvoiceNo() + "");
		// sfopcgDao.save(sfopcg);
		//
		// // 添加 使用其他方式付费 表(SFCsByOtherMethod)的记录
		// SfcsByOtherMethod sfcsByOtherMethod = new SfcsByOtherMethod();
		// sfcsByOtherMethod.setCgAmount(Double.parseDouble(reduceMoney));
		// sfcsByOtherMethod.setOpdiagnoseId(diagnoseID);
		// sfcsByOtherMethod.setPid(Integer.parseInt(costTypeId));
		// sfCsByOtherMethodDao.save(sfcsByOtherMethod);

		SfcgTable sfcgTable = sfCgTableDao.saveSfCgTable(cashPay,
				personnelNumber, realMoeny, officesNumber, nowTimeStamp,
				diagnoseID, "门诊收费", "MZOpDn");

		SfcreditCard sfcreditCard = null;

		if (!medicalCardPay.trim().equals("")) {
			// 添加刷卡表 （SFCreditCard）
			sfcreditCard = new SfcreditCard();
			sfcreditCard.setCgId(sfcgTable.getCgId());
			sfcreditCard.setCreditCard(Double.parseDouble(medicalCardPay));
			sfcreditCard.setCreditCardType("医疗卡");
			sfCreditCardDao.save(sfcreditCard);

			// 医疗卡详单表（CSMedicalCardDetail）的添加 和医疗卡（CSMedicalCard）表的余额减少
			CsmedicalCardDetail csmedicalCardDetail = new CsmedicalCardDetail();
			csmedicalCardDetail.setAmount(Double.parseDouble(medicalCardPay));
			csmedicalCardDetail.setCgId(sfcgTable.getCgId());
			// 添加最后一个项目到医疗卡详情表里的项目里
			csmedicalCardDetail.setCgItem(list.get(list.size() - 1).get(0));

			csmedicalCardDetail.setCsId(Long.parseLong(consumerId));
			csmedicalCardDetail.setDate(nowTimeStamp);
			csmedicalCardDetail.setReceiver(Long.parseLong(personnelNumber));
			csGiveSfService.addCSMedicalCardDetail(csmedicalCardDetail,
					Long.parseLong(consumerId));
		}
		if (!medicalInsurancePay.trim().equals("")) {
			// 添加刷卡表 （SFCreditCard）
			sfcreditCard = new SfcreditCard();
			sfcreditCard.setCgId(sfcgTable.getCgId());
			sfcreditCard.setCreditCard(Double.parseDouble(medicalInsurancePay));
			sfcreditCard.setCreditCardType("医保卡");
			sfCreditCardDao.save(sfcreditCard);
		}
		if (!bankPay.trim().equals("")) {
			// 添加刷卡表 （SFCreditCard）
			sfcreditCard = new SfcreditCard();
			sfcreditCard.setCgId(sfcgTable.getCgId());
			sfcreditCard.setCreditCard(Double.parseDouble(bankPay));
			sfcreditCard.setCreditCardType("银行卡");
			sfCreditCardDao.save(sfcreditCard);
		}
		mzGiveSfService.updateMZOpDnStatus(diagnoseID, "可处理");
		return true;
	}

	public void setSfCreditCardDao(SfCreditCardDao sfCreditCardDao) {
		this.sfCreditCardDao = sfCreditCardDao;
	}

	public void setMzGiveSfService(MzGiveSfService mzGiveSfService) {
		this.mzGiveSfService = mzGiveSfService;
	}

	public void setOsGiveSfService(OsGiveSfService osGiveSfService) {
		this.osGiveSfService = osGiveSfService;
	}

	public void setCsGiveSfService(CsGiveSfService csGiveSfService) {
		this.csGiveSfService = csGiveSfService;
	}

	public void setSfCgTableDao(SfCgTableDao sfCgTableDao) {
		this.sfCgTableDao = sfCgTableDao;
	}

	public void setSfCsByOtherMethodDao(
			SfCsByOtherMethodDao sfCsByOtherMethodDao) {
		this.sfCsByOtherMethodDao = sfCsByOtherMethodDao;
	}

	public void setSfreduceTableDao(SfreduceTableDao sfreduceTableDao) {
		this.sfreduceTableDao = sfreduceTableDao;
	}

	public void setSfReduceItemDao(SfReduceItemDao sfReduceItemDao) {
		this.sfReduceItemDao = sfReduceItemDao;
	}

	public void setCzGiveSfService(CzGiveSfService czGiveSfService) {
		this.czGiveSfService = czGiveSfService;
	}

	public void setYfGiveSfService(YfGiveSfService yfGiveSfService) {
		this.yfGiveSfService = yfGiveSfService;
	}

	public void setCsconsumerService(CsconsumerService csconsumerService) {
		this.csconsumerService = csconsumerService;
	}

	public void setGHGiveSFService(GhGiveSFService giveSFService) {
		gHGiveSFService = giveSFService;
	}

	public void setSfopcgDao(SfopcgDao sfopcgDao) {
		this.sfopcgDao = sfopcgDao;
	}

	public void setSfMzInvoiceHeadDao(SfMzInvoiceHeadDao sfMzInvoiceHeadDao) {
		this.sfMzInvoiceHeadDao = sfMzInvoiceHeadDao;
	}

	public void setSfMzInvoiceContentDao(
			SfMzInvoiceContentDao sfMzInvoiceContentDao) {
		this.sfMzInvoiceContentDao = sfMzInvoiceContentDao;
	}

	public void setCfmedicalInstDao(CfmedicalInstDao cfmedicalInstDao) {
		this.cfmedicalInstDao = cfmedicalInstDao;
	}

}
