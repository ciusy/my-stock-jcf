package leo.sf.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
import leo.entity.CsmedicalCard;
import leo.entity.CsmedicalCardDetail;
import leo.entity.GhcostType;
import leo.entity.Ghregister;
import leo.entity.Osuform;
import leo.entity.SfcgTable;
import leo.entity.SfcreditCard;
import leo.entity.SfipdepositRecord;
import leo.entity.SfleaveHospBalance;
import leo.entity.SfreduceItem;
import leo.entity.SfreduceTable;
import leo.entity.SfzyinvoiceContent;
import leo.entity.SfzyinvoiceHead;
import leo.entity.Zyinpatient;
import leo.gh.service.iface.GhGiveSFService;
import leo.mz.service.iface.MzGiveSfService;
import leo.os.service.iface.OsGiveSfService;
import leo.sf.dao.iface.SfCgTableDao;
import leo.sf.dao.iface.SfCreditCardDao;
import leo.sf.dao.iface.SfLeaveHospBalanceDao;
import leo.sf.dao.iface.SfReduceItemDao;
import leo.sf.dao.iface.SfZyInvoiceContentDao;
import leo.sf.dao.iface.SfZyInvoiceHeadDao;
import leo.sf.dao.iface.SfipdepositRecordDao;
import leo.sf.dao.iface.SfreduceTableDao;
import leo.sf.service.iface.ZyDepositService;
import leo.yf.service.iface.YfGiveSfService;
import leo.zy.dao.iface.ZyInpatientDao;
import leo.zy.service.iface.ZyGiveSfService;
import leo.zy.service.iface.ZyHuShiChuLiService;

/**
 * 住院押金界面使用的service
 * 
 * @author xuxiangpan
 * @version 创建时间：Aug 5, 2011 10:04:48 AM
 */
@SuppressWarnings("unchecked")
public class ZyDepositServiceImpl implements ZyDepositService {

	private CsconsumerService csconsumerService;
	private ZyGiveSfService zyGiveSfService;
	private GhGiveSFService ghGiveSFService;
	private CsGiveSfService csGiveSfService;
	private ZyInpatientDao zyInpatientDao;
	private SfCgTableDao sfCgTableDao;
	private SfipdepositRecordDao sfipdepositRecordDao;
	private OsGiveSfService osGiveSfService;
	private CzGiveSfService czGiveSfService;
	private YfGiveSfService yfGiveSfService;
	private SfCreditCardDao sfCreditCardDao;
	private SfLeaveHospBalanceDao sfLeaveHospBalanceDao;
	private SfReduceItemDao sfReduceItemDao;
	private MzGiveSfService mzGiveSfService;

	private SfreduceTableDao sfreduceTableDao;

	private SfZyInvoiceHeadDao sfZyInvoiceHeadDao;
	private SfZyInvoiceContentDao sfZyInvoiceContentDao;
	private ZyHuShiChuLiService zyHuShiChuLiService;

	private CfmedicalInstDao cfmedicalInstDao;

	public SfzyinvoiceHead getByMedOrgId(Integer medOrgId, Long invoiceNO) {
		return sfZyInvoiceHeadDao.getByMedOrgId(medOrgId, invoiceNO);

	}

	public Double getReduceMoneyByTemplate(String projectName,
			String projectType, String originalMoney, Integer costTypeId) {

		if (projectType.equals("1")) {
			SfreduceItem sfreduceItem = sfReduceItemDao.getBySingle(costTypeId,
					projectName);
			if (null != sfreduceItem) {
				return (Double.parseDouble(originalMoney) - sfreduceItem
						.getReduceAmount()) * sfreduceItem.getReducePercent();
			}
		} else {
			SfreduceTable sfreduceTable = sfreduceTableDao.getBySingle(
					costTypeId, projectName);
			if (null != sfreduceTable) {
				return (Double.parseDouble(originalMoney) - sfreduceTable
						.getReduceByNum()) * sfreduceTable.getReduceByPercent();
			}
		}

		return -1d;
	}

	public List<GhcostType> getGhcostTypeByOrgId(Integer medicalOrgnizal) {

		List<GhcostType> list = ghGiveSFService
				.getGhcostTypeByOrgId(medicalOrgnizal);
		return list;
	}

	/**
	 * update 12.28 去掉List<List<String>> projectDetails 参数，没有用了
	 * 
	 */
	public Boolean addCharge(String inpatientId, String consumerId,
			String officesNumber, List<List<String>> list,
			String personnelNumber, String realMoeny,
			String consumerTotalMoney, String depositAmount, String cashPay,
			String medicalCardPay, String medicalInsurancePay, String bankPay,
			boolean printBillOrNot, double returnAmount, Integer orgId,
			Long invoiceNO, String upperRealMoney,
			List<List<String>> projectDetails) {
		zyGiveSfService.updateZyStauts(inpatientId, true, "已出院");
		if (null == list || list.size() < 1)// 没有项目直接出院的
			return true;
		Zyinpatient zyinpatient = zyGiveSfService
				.getInpatinentById(inpatientId);
		Set<String> aFormIDs = new HashSet<String>();
		// 处方的项目Id集合
		List<Long> prescriptionItemIDList = new ArrayList<Long>();
		// 处方的项目对应 的减免金额
		List<Double> prescriptionItemReduce = new ArrayList<Double>();

		// 处置的项目id集合
		List<String> disposeItemIdList = new ArrayList<String>();

		// 处置的项目对应 的减免金额
		List<Double> disposeItemReduce = new ArrayList<Double>();

		Timestamp nowTimeStamp = DateUtil.getNowTimeStamp();
		// 添加发票记录
		SfzyinvoiceHead sfmzinvoiceHead = new SfzyinvoiceHead();
		sfmzinvoiceHead.setCashierId(Long.parseLong(personnelNumber));
		sfmzinvoiceHead.setConsumerId(Long.parseLong(consumerId));
		sfmzinvoiceHead.setInvoiceNo(invoiceNO);
		sfmzinvoiceHead.setInvoiceTime(nowTimeStamp);
		sfmzinvoiceHead.setIsCancel(false);
		sfmzinvoiceHead.setMedOrgId(orgId);
		sfmzinvoiceHead.setMoney(Double.parseDouble(realMoeny));
		sfmzinvoiceHead.setOriginalInvoiceNo(-1l);
		sfmzinvoiceHead.setOutpatientId(inpatientId);
		sfmzinvoiceHead.setUppcaseMoeny(upperRealMoney);
		sfmzinvoiceHead.setCostType(zyinpatient.getChargeType());
		sfmzinvoiceHead.setUid(Integer.parseInt(officesNumber));
		sfZyInvoiceHeadDao.save(sfmzinvoiceHead);
		SfzyinvoiceContent sfmzinvoiceContent = null;

		List<SfzyinvoiceContent> sfmzinvoiceContents = new ArrayList<SfzyinvoiceContent>();

		for (List<String> tempOutList : list) {
			sfmzinvoiceContent = new SfzyinvoiceContent();
			if (!tempOutList.get(7).equals("")) {
				// 根据前台传过来的整个表格进行过滤,确定处置和处方的申请单等信息
				prescriptionItemIDList.add(Long.parseLong(tempOutList.get(6)));
				prescriptionItemReduce
						.add(tempOutList.get(2).equals("") ? (double) 0
								: Double.parseDouble(tempOutList.get(2)));
				aFormIDs.add(tempOutList.get(7));
				sfmzinvoiceContent.setProjectType("住院处方");
			} else {
				disposeItemIdList.add(tempOutList.get(6));
				disposeItemReduce
						.add(tempOutList.get(2).equals("") ? (double) 0
								: Double.parseDouble(tempOutList.get(2)));
				sfmzinvoiceContent.setProjectType("住院处置");
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

		sfZyInvoiceContentDao.save(sfmzinvoiceContents);
		// 修改出库申请单表中的状态 和详细项目的减免金额 等信息
		yfGiveSfService.updateStatusAndReduce(aFormIDs, prescriptionItemIDList,
				prescriptionItemReduce, "");
		// 修改处置的状态和实收等信息
		czGiveSfService.updateStatusAndReduce(disposeItemIdList,
				disposeItemReduce, "", officesNumber, "", null);
		SfcgTable sfcgTable = sfCgTableDao.saveSfCgTable(cashPay,
				personnelNumber, realMoeny, officesNumber, nowTimeStamp,
				inpatientId, "出院结算", "SFLeaveHospBalance");

		// 出院结算表
		SfleaveHospBalance sfleaveHospBalance = new SfleaveHospBalance();

		sfleaveHospBalance.setBalanceTime(nowTimeStamp);
		sfleaveHospBalance.setCasher(Long.parseLong(personnelNumber));
		sfleaveHospBalance.setCashierId(Integer.parseInt(officesNumber));
		sfleaveHospBalance.setConsumeAmount(Double
				.parseDouble(consumerTotalMoney));
		sfleaveHospBalance.setDepositAmount(Double.parseDouble(depositAmount));

		sfleaveHospBalance.setIpdeptId(zyinpatient.getIpdeptId());
		sfleaveHospBalance.setIpid(inpatientId);
		sfleaveHospBalance.setIptotalAmount(Double.parseDouble(realMoeny));

		sfleaveHospBalance.setMedicalInsurance(0d);
		sfleaveHospBalance.setMedicalInsuranceBalance(false);

		sfleaveHospBalance.setPrintBillOrNot(printBillOrNot);
		// 农合填写不上，暂时留为空
		sfleaveHospBalance.setRuralCooper(0d);
		sfleaveHospBalance.setRuralCooperBalance(false);
		sfleaveHospBalance.setToRefund(returnAmount);

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

			sfleaveHospBalance.setMedicalInsurance(Double
					.parseDouble(medicalInsurancePay));
			sfleaveHospBalance.setMedicalInsuranceBalance(true);

		}
		if (!bankPay.trim().equals("")) {
			// 添加刷卡表 （SFCreditCard）
			sfcreditCard = new SfcreditCard();
			sfcreditCard.setCgId(sfcgTable.getCgId());
			sfcreditCard.setCreditCard(Double.parseDouble(bankPay));
			sfcreditCard.setCreditCardType("银行卡");
			sfCreditCardDao.save(sfcreditCard);
		}
		sfLeaveHospBalanceDao.save(sfleaveHospBalance);

		CfmedicalInst cfmedicalInst = cfmedicalInstDao.getSingleData(
				"o.medicalInstId=? and o.disposeName=?", new Object[] { orgId,
						"住院发票起始号" });
		cfmedicalInst.setCfvalue(cfmedicalInst.getCfvalue() + 1);

		return true;
	}

	public List<List<String>> getInvoiceProject(Boolean isderate,
			String inpatientId, String typeDispose, String typeRecipe) {

		List<String> paramList1 = new ArrayList<String>();
		List<String> paramList2 = new ArrayList<String>();
		setParam(typeDispose, paramList1, paramList2);

		List<List<String>> list0 = null;
		// 挂号的项目
		if ("门诊申请".equals(typeDispose)) {
			Ghregister ghregister = ghGiveSFService.getGhRegister(inpatientId
					.substring(inpatientId.indexOf(",") + 1,
							inpatientId.length()));
			if (null == ghregister.getIfCg()
					|| !ghregister.getIfCg().equals("已收费")) {
				list0 = new ArrayList<List<String>>();
				List<String> tempList = new ArrayList<String>();
				tempList.add("挂号费");
				tempList.add(ghregister.getRealPrice() + "");
				tempList.add(ghregister.getReceivablePrice()
						- ghregister.getRealPrice() + "");
				tempList.add("挂号费");
				tempList.add(ghregister.getRealPrice() + "");
				tempList.add("-1");
				tempList.add("");
				tempList.add("");
				list0.add(tempList);
			}
		}

		List<List<String>> list = yfGiveSfService.getInpatientProjectDetail(
				isderate,
				inpatientId.indexOf(",") > -1 ? inpatientId.substring(
						inpatientId.indexOf(",") + 1, inpatientId.length())
						: inpatientId, null, typeRecipe, paramList2);
		List<List<String>> list1 = czGiveSfService.getInpatientProjectDetail(
				inpatientId.indexOf(",") > -1 ? inpatientId.substring(0,
						inpatientId.indexOf(",")) : inpatientId, null,
				typeDispose, paramList1);
		return CommonUtil.addListToList(list, list1);
	}

	private void setParam(String typeDispose, List<String> paramList1,
			List<String> paramList2) {
		if ("门诊申请".equals(typeDispose)) {
			paramList1.add("未交费可执行");
			paramList1.add("未交费不可执行");
			paramList1.add("未交费已执行");

			// paramList2.add("已领药未付费");
			paramList2.add("已申请");

		}
	}

	public List<List<String>> getInpatientPojectDetail(Boolean isderate,
			String inpatientId, String type, String projectName,
			String typeDispose, String typeRecipe) {

		List<List<String>> list = null;

		List<String> paramList1 = new ArrayList<String>();
		List<String> paramList2 = new ArrayList<String>();
		setParam(typeDispose, paramList1, paramList2);

		if (type.equals("1")) {// 1是处方

			list = yfGiveSfService.getInpatientProjectDetail(
					isderate,
					inpatientId.indexOf(",") > -1 ? inpatientId.substring(
							inpatientId.indexOf(",") + 1, inpatientId.length())
							: inpatientId, projectName, typeRecipe, paramList2);
		} else if (type.equals("0")) {// 0 处置
			list = czGiveSfService.getInpatientProjectDetail(
					inpatientId.indexOf(",") > -1 ? inpatientId.substring(0,
							inpatientId.indexOf(",")) : inpatientId,
					projectName, typeDispose, paramList1);
		}
		return null != list && list.size() > 0 ? list : Collections.EMPTY_LIST;
	}

	public List<List<String>> getReducePojectDetail(String inpatientId,
			String typeDispose, String typeRecipe) {
		List<String> paramList1 = new ArrayList<String>();
		List<String> paramList2 = new ArrayList<String>();
		setParam(typeDispose, paramList1, paramList2);

		List<List<String>> list0 = null;
		// 挂号的项目
		if ("门诊申请".equals(typeDispose)) {
			Ghregister ghregister = ghGiveSFService.getGhRegister(inpatientId
					.substring(inpatientId.indexOf(",") + 1,
							inpatientId.length()));
			if (null == ghregister.getIfCg()
					|| !ghregister.getIfCg().equals("已收费")) {
				list0 = new ArrayList<List<String>>();
				List<String> tempList = new ArrayList<String>();
				tempList.add("挂号费");
				tempList.add(ghregister.getReceivablePrice() + "");
				tempList.add(ghregister.getReceivablePrice()
						- ghregister.getRealPrice() + "");
				tempList.add("挂号费");
				tempList.add(ghregister.getReceivablePrice()
						- ghregister.getRealPrice() + "");
				tempList.add("-1");
				tempList.add(ghregister.getOpnum());
				tempList.add("");
				list0.add(tempList);
			}
		}

		List<List<String>> list = null;
		// "住院领药" "住院申请"
		list = yfGiveSfService.getReducePojectDetail(
				inpatientId.indexOf(",") > -1 ? inpatientId.substring(
						inpatientId.indexOf(",") + 1, inpatientId.length())
						: inpatientId, typeRecipe, paramList2);
		List<List<String>> list1 = czGiveSfService.getReducePojectDetail(
				inpatientId.indexOf(",") > -1 ? inpatientId.substring(0,
						inpatientId.indexOf(",")) : inpatientId, typeDispose,
				paramList1);
		return CommonUtil.addListToList(list0,
				CommonUtil.addListToList(list, list1));
	}

	/**
	 * 得到住院或者门诊病人的减免金额
	 * 
	 * @param isderate
	 * @param inpatientId
	 * @param typeDispose
	 * @param typeRecipe
	 * @return
	 */
	public Double getZyReduceMoney(Boolean isderate, String inpatientId,
			String typeDispose, String typeRecipe) {
		// 处置的减免金额
		// "住院申请""住院领药"
		Double dispositionReduceMoney = czGiveSfService.getZyReduceMoney(
				inpatientId.indexOf(",") > -1 ? inpatientId.substring(0,
						inpatientId.indexOf(",")) : inpatientId, typeDispose);
		dispositionReduceMoney = dispositionReduceMoney == null ? 0d
				: dispositionReduceMoney;
		Double recipeReduceMoney = yfGiveSfService.getReduceMoney(
				isderate,
				inpatientId.indexOf(",") > -1 ? inpatientId.substring(
						inpatientId.indexOf(",") + 1, inpatientId.length())
						: inpatientId, typeRecipe);

		return dispositionReduceMoney + recipeReduceMoney;
	}

	public List<List<String>> getInpatientPoject(Boolean isderate,
			String inpatientId, String typeDispose, String typeRecipe) {
		List<String> paramList1 = new ArrayList<String>();
		List<String> paramList2 = new ArrayList<String>();
		setParam(typeDispose, paramList1, paramList2);
		List<List<String>> list0 = null;
		// 挂号的项目
		if ("门诊申请".equals(typeDispose)) {
			mzGiveSfService.updateMZOpDnStatus(
					inpatientId.substring(0, inpatientId.indexOf(",")), "不可处理");
			Ghregister ghregister = ghGiveSFService.getGhRegister(inpatientId
					.substring(inpatientId.indexOf(",") + 1,
							inpatientId.length()));
			if (null == ghregister.getIfCg()
					|| !ghregister.getIfCg().equals("已收费")) {
				list0 = new ArrayList<List<String>>();
				List<String> tempList = new ArrayList<String>();
				tempList.add("挂号费");
				tempList.add(ghregister.getRealPrice() + "");
				tempList.add("挂号");
				tempList.add(ghregister.getReceivablePrice() + "");
				list0.add(tempList);
			}
		}

		// 申请
		List<Object[]> list1 = czGiveSfService.getZyInpatientProjectPrice(
				inpatientId.indexOf(",") > -1 ? inpatientId.substring(0,
						inpatientId.indexOf(",")) : inpatientId, typeDispose,
				paramList1);

		// 领药
		List<Object[]> list2 = yfGiveSfService.getInpatientProject(
				isderate,
				inpatientId.indexOf(",") > -1 ? inpatientId.substring(
						inpatientId.indexOf(",") + 1, inpatientId.length())
						: inpatientId, typeRecipe, paramList2);
		return CommonUtil.addListToList(
				CommonUtil.addListToList(list0,
						CommonUtil.listObject2ListString(list1)),
				CommonUtil.listObject2ListString(list2));
	}

	@SuppressWarnings("unused")
	private List<List<String>> listObject2ListString(List<Object[]> list,
			String type) {

		List<List<String>> returnList = new ArrayList<List<String>>();
		List<String> list2 = null;

		for (Object[] objects : list) {

			list2 = new ArrayList<String>();
			for (Object object : objects) {
				list2.add(object.toString());
			}
			list2.add(type);
			returnList.add(list2);

		}

		return null != returnList && returnList.size() > 0 ? returnList
				: Collections.EMPTY_LIST;
	}

	public List<List<String>> getInpatientCosumer(Integer medicalOrgnizal,
			String consumerName, String idCard, String startTime,
			String endTime, String ipId, Boolean flag, String inPatientStatus,
			Integer inPatientDepId, String bedNo) {

		List<Zyinpatient> list = null;
		List<Integer> inPatientDeptIds = null;
		if (inPatientDepId != -1) {// 查询指定的住院部的服务对象
			inPatientDeptIds = new ArrayList<Integer>();
			inPatientDeptIds.add(inPatientDepId);
		} else {// 查询医疗机构下的所有的住院部的服务对象
			inPatientDeptIds = getInPatientDeptIds(medicalOrgnizal);
		}
		list = zyGiveSfService.getInpatent(inPatientDeptIds, null, ipId,
				startTime, endTime, inPatientStatus, bedNo);
		return combination1(list);

	}

	public List<List<String>> getCurrentDayInPatient(Integer medicalOrgnizal,
			String inPatientStatus) {

		List<Integer> inPatientDeptIds = getInPatientDeptIds(medicalOrgnizal);

		List<Zyinpatient> list = zyGiveSfService.getCurrentDayInPatient(
				inPatientDeptIds, inPatientStatus);

		return combination1(list);
	}

	private List<Integer> getInPatientDeptIds(Integer medicalOrgnizal) {
		// 根据医疗机构获得所有的住院部
		List<Osuform> osuformList = osGiveSfService.getInpatientDept(
				medicalOrgnizal, "住院");
		// 获得所有的住院部ids
		List<Integer> inPatientDeptIds = new ArrayList<Integer>();
		for (Osuform osuform : osuformList) {
			inPatientDeptIds.add(osuform.getUid());
		}
		return inPatientDeptIds;
	}

	private List<List<String>> combination1(List<Zyinpatient> list) {
		if (list.size() < 1) {
			return Collections.EMPTY_LIST;
		}

		List<Long> ids = new ArrayList<Long>();// 服务对象id集合
		Set<Integer> costTypeIds = new HashSet<Integer>();// 费用类型IDs

		List<String> ipIDS = new ArrayList<String>();// 住院id集合

		// 得到查询结果中所有服务对象ids
		for (Zyinpatient zyinpatient : list) {
			ipIDS.add(zyinpatient.getIpid());
			ids.add(zyinpatient.getCsId());
			costTypeIds.add(zyinpatient.getChargeType());
		}

		// 查找服务器对象
		List<Csconsumer> list2 = csconsumerService.getByIds(ids);
		// 查找对应 的收费类型对象
		List<GhcostType> costTypeList = ghGiveSFService
				.getCostType(costTypeIds);
		// 查找对应服务对象的医疗卡
		List<CsmedicalCard> medicalCardList = csGiveSfService
				.getCsmedicalCard(ids);
		// 所交过的住院押金的总额
		List<Object[]> sfipdepositRecordList = sfipdepositRecordDao
				.getTotalByIpIDS(ipIDS);
		// 查找服务对象累计消费的费用
		List<Object[]> zyRedudancyConsumeList = zyGiveSfService
				.getZyredudancyConsume(ipIDS);

		String iPID = "";// 住院号
		String bedNO = "";// 床位号
		String consumerName = "";// 服务对象姓名
		String sex = "";
		Integer age = 0;
		String costType = "";// 费用类型
		boolean flag = false;// 是否可能减免
		String medicalCardNO = "";// 医疗卡号
		String medicalInsureNO = "";// 医保卡号
		String ipTime = ""; // 入院时间
		String advisedDeposit = "0";// 建议押金
		String totalDeposit = "0";// 住院押金（总共花费了多少押金）
		String totalCharge = "0";// 累计费用
		String depositBalance = "0";// 押金余额

		List<List<String>> returnList = new ArrayList<List<String>>();

		List<String> tempList = new ArrayList<String>();
		// 构造返回给前台的list
		for (Zyinpatient zyinpatient : list) {
			iPID = "";// 住院号
			bedNO = "";// 床位号
			consumerName = "";// 服务对象姓名
			sex = "";
			age = 0;
			costType = "";// 费用类型
			flag = false;// 是否可能减免
			medicalCardNO = "";// 医疗卡号
			medicalInsureNO = "";// 医保卡号
			ipTime = ""; // 入院时间
			advisedDeposit = "0";// 建议押金
			totalDeposit = "0";// 住院押金（总共花费了多少押金）
			totalCharge = "0";// 累计费用
			depositBalance = "0";// 押金余额

			iPID = zyinpatient.getIpid();
			bedNO = String.valueOf(zyinpatient.getBed());
			// 得到服务对象的属性
			for (Csconsumer csconsumer : list2) {
				if (csconsumer.getCsId().longValue() == zyinpatient.getCsId()
						.longValue()) {
					consumerName = csconsumer.getCsname();
					sex = csconsumer.getSex();
					age = DateUtil.getBetweenYears(
							DateUtil.getCurrentDateTime(),
							csconsumer.getBirthday());
					medicalInsureNO = csconsumer.getMedicalInsuranceCode();
					break;
				}
			}
			// 费用类型
			for (GhcostType ghcostType : costTypeList) {
				if (zyinpatient.getChargeType().longValue() == ghcostType
						.getId()) {
					costType = ghcostType.getCostType();
					flag = ghcostType.getDerate();
					break;
				}
			}
			// 医疗卡ID
			for (CsmedicalCard csmedicalCard : medicalCardList) {
				if (csmedicalCard.getCsId() == zyinpatient.getCsId()) {
					medicalCardNO = csmedicalCard.getMedicalCardNum();
					break;
				}
			}

			ipTime = DateUtil.dateToStringWithTime(zyinpatient.getIptime());
			advisedDeposit = String.valueOf(zyinpatient.getDepositAdvised());

			for (Object[] objects : sfipdepositRecordList) {

				if (objects[0].toString().equals(zyinpatient.getIpid())) {
					totalDeposit = objects[1].toString();
					break;
				}

			}
			totalCharge = zyHuShiChuLiService.getZhuYuanZongJieE(zyinpatient
					.getIpid()) + "";
			for (Object[] objects : zyRedudancyConsumeList) {

				if (objects[0].toString().equals(zyinpatient.getIpid())) {
					totalCharge = objects[1].toString();
					break;
				}

			}
			// 押金余额
			depositBalance = zyinpatient.getDepositBalance().toString();

			tempList = new ArrayList<String>();
			tempList.add(iPID);// 住院号
			tempList.add(bedNO);// 床位号
			tempList.add(consumerName);// 服务对象姓名
			tempList.add(sex);
			tempList.add(String.valueOf(age));
			tempList.add(costType);// 费用类型 ??
			tempList.add(medicalCardNO);// 医疗卡号??
			tempList.add(medicalInsureNO);
			tempList.add(ipTime); // 入院时间
			tempList.add(advisedDeposit);// 建议押金
			tempList.add(CommonUtil.keep2Decimal(totalDeposit));// 住院押金（总共花费了多少押金）???
			tempList.add(CommonUtil.keep2Decimal(totalCharge));// 累计费用
			tempList.add(CommonUtil.keep2Decimal(depositBalance));// 押金余额
			tempList.add(zyinpatient.getIpdeptId().toString());// delphi 隐藏列
																// 住院部ID
			tempList.add(zyinpatient.getCsId().toString());// delphi 隐藏列 服务对象ID
			tempList.add(String.valueOf(flag));
			returnList.add(tempList);
		}

		return null != returnList && returnList.size() > 0 ? returnList
				: Collections.EMPTY_LIST;
	}

	// private List<List<String>> combination(List<Zyinpatient> list) {
	// if (list.size() < 1) {
	// return Collections.EMPTY_LIST;
	// }
	//
	// List<Long> ids = new ArrayList<Long>();// 服务对象id集合
	// Set<Integer> costTypeIds = new HashSet<Integer>();// 费用类型IDs
	//
	// List<String> ipIDS = new ArrayList<String>();// 住院id集合
	//
	// // 得到查询结果中所有服务对象ids
	// for (Zyinpatient zyinpatient : list) {
	// ipIDS.add(zyinpatient.getIpid());
	// ids.add(zyinpatient.getCsId());
	// costTypeIds.add(zyinpatient.getChargeType());
	// }
	//
	// // 查找服务器对象
	// List<Csconsumer> list2 = csconsumerService.getByIds(ids);
	//
	// // 查找对应 的收费类型对象
	// List<GhcostType> costTypeList = ghGiveSFService.getCostType(costTypeIds);
	//
	// // 查找对应服务对象的医疗卡
	// List<CsmedicalCard> medicalCardList =
	// csGiveSfService.getCsmedicalCard(ids);
	// // 所交过的住院押金的总额
	// List<Object[]> sfipdepositRecordList =
	// sfipdepositRecordDao.getTotalByIpIDS(ipIDS);
	// // 查找服务对象累计消费的费用
	// List<Object[]> zyRedudancyConsumeList =
	// zyGiveSfService.getZyredudancyConsume(ipIDS);
	//
	// String iPID = "";// 住院号
	// String bedNO = "";// 床位号
	// String consumerName = "";// 服务对象姓名
	// String sex = "";
	// Integer age = 0;
	// String costType = "";// 费用类型
	// String medicalCardNO = "";// 医疗卡号
	// String ipTime = ""; // 入院时间
	// String advisedDeposit = "0";// 建议押金
	// String totalDeposit = "0";// 住院押金（总共花费了多少押金）
	// String totalCharge = "0";// 累计费用
	// String depositBalance = "0";// 押金余额
	//
	// List<List<String>> returnList = new ArrayList<List<String>>();
	//
	// List<String> tempList = new ArrayList<String>();
	// // 构造返回给前台的list
	// for (Zyinpatient zyinpatient : list) {
	//
	// iPID = zyinpatient.getIpid();
	// bedNO = String.valueOf(zyinpatient.getBed());
	// // 得到服务对象的属性
	// for (Csconsumer csconsumer : list2) {
	// if (csconsumer.getCsId().longValue() ==
	// zyinpatient.getCsId().longValue()) {
	// consumerName = csconsumer.getCsname();
	// sex = csconsumer.getSex();
	// age = DateUtil.getBetweenYears(DateUtil.getCurrentDateTime(),
	// csconsumer.getBirthday());
	// break;
	// }
	// }
	// // 费用类型
	// for (GhcostType ghcostType : costTypeList) {
	// if (zyinpatient.getChargeType().longValue() == ghcostType.getId()) {
	// costType = ghcostType.getCostType();
	// break;
	// }
	// }
	// // 医疗卡ID
	// for (CsmedicalCard csmedicalCard : medicalCardList) {
	// if (csmedicalCard.getCsId() == zyinpatient.getCsId()) {
	// medicalCardNO = csmedicalCard.getMedicalCardNum();
	// break;
	// }
	// }
	//
	// ipTime = DateUtil.dateToStringWithTime(zyinpatient.getIptime());
	// advisedDeposit = String.valueOf(zyinpatient.getDepositAdvised());
	//
	// for (Object[] objects : sfipdepositRecordList) {
	//
	// if (objects[0].toString().equals(zyinpatient.getIpid())) {
	// totalDeposit = objects[1].toString();
	// break;
	// }
	//
	// }
	// for (Object[] objects : zyRedudancyConsumeList) {
	//
	// if (objects[0].toString().equals(zyinpatient.getIpid())) {
	// totalCharge = objects[1].toString();
	// break;
	// }
	//
	// }
	// // 押金余额
	// depositBalance = zyinpatient.getDepositBalance().toString();
	//
	// tempList = new ArrayList<String>();
	// tempList.add(iPID);// 住院号
	// tempList.add(bedNO);// 床位号
	// tempList.add(consumerName);// 服务对象姓名
	// tempList.add(sex);
	// tempList.add(String.valueOf(age));
	// tempList.add(costType);// 费用类型 ??
	// tempList.add(medicalCardNO);// 医疗卡号??
	// tempList.add(ipTime); // 入院时间
	// tempList.add(advisedDeposit);// 建议押金
	// tempList.add(totalDeposit);// 住院押金（总共花费了多少押金）???
	// tempList.add(totalCharge);// 累计费用
	// tempList.add(depositBalance);// 押金余额
	// tempList.add(zyinpatient.getIpdeptId().toString());// delphi 隐藏列 住院部ID
	// tempList.add(zyinpatient.getCsId().toString());// delphi 隐藏列 服务对象ID
	// returnList.add(tempList);
	// }
	//
	// return returnList;
	// }

	public void setGhGiveSFService(GhGiveSFService ghGiveSFService) {
		this.ghGiveSFService = ghGiveSFService;
	}

	public void setCsGiveSfService(CsGiveSfService csGiveSfService) {
		this.csGiveSfService = csGiveSfService;
	}

	public void setSfipdepositRecordDao(
			SfipdepositRecordDao sfipdepositRecordDao) {
		this.sfipdepositRecordDao = sfipdepositRecordDao;
	}

	public void setZyGiveSfService(ZyGiveSfService zyGiveSfService) {
		this.zyGiveSfService = zyGiveSfService;
	}

	public void addDepositAmout(String ipid, String csID, String depositAmout,
			String chargeMan, String chargeOfficeId, String ipDeptId) {
		// 添加押金的记录
		SfipdepositRecord sfipdepositRecord = new SfipdepositRecord();
		sfipdepositRecord.setCasher(Long.parseLong(chargeMan));
		sfipdepositRecord.setChargeU(Integer.parseInt(chargeOfficeId));
		sfipdepositRecord
				.setDepositAmountPaid(Double.parseDouble(depositAmout));
		sfipdepositRecord.setIpdeptId(Integer.parseInt(ipDeptId));
		sfipdepositRecord.setIpid(ipid);
		sfipdepositRecord.setNote("");
		sfipdepositRecord.setSftime(DateUtil.getNowTimeStamp());
		sfipdepositRecord.setCsId(Long.valueOf(csID));
		sfipdepositRecordDao.save(sfipdepositRecord);
		// 修改住院的余额
		Zyinpatient zyinpatient = zyInpatientDao.find(ipid);
		zyinpatient.setDepositBalance(zyinpatient.getDepositBalance()
				+ Double.parseDouble(depositAmout));
		zyInpatientDao.update(zyinpatient);
		// 添加收费表
		sfCgTableDao
				.saveSfCgTable(depositAmout, chargeMan, depositAmout,
						chargeOfficeId, DateUtil.getNowTimeStamp(),
						sfipdepositRecord.getDepositId().toString(), "住院押金",
						"SFIPDepositRecord");

	}

	public void setZyInpatientDao(ZyInpatientDao zyInpatientDao) {
		this.zyInpatientDao = zyInpatientDao;
	}

	public void setSfCgTableDao(SfCgTableDao sfCgTableDao) {
		this.sfCgTableDao = sfCgTableDao;
	}

	public void setOsGiveSfService(OsGiveSfService osGiveSfService) {
		this.osGiveSfService = osGiveSfService;
	}

	public void setCsconsumerService(CsconsumerService csconsumerService) {
		this.csconsumerService = csconsumerService;
	}

	public CzGiveSfService getCzGiveSfService() {
		return czGiveSfService;
	}

	public void setCzGiveSfService(CzGiveSfService czGiveSfService) {
		this.czGiveSfService = czGiveSfService;
	}

	public void setYfGiveSfService(YfGiveSfService yfGiveSfService) {
		this.yfGiveSfService = yfGiveSfService;
	}

	public void setSfCreditCardDao(SfCreditCardDao sfCreditCardDao) {
		this.sfCreditCardDao = sfCreditCardDao;
	}

	public void setSfLeaveHospBalanceDao(
			SfLeaveHospBalanceDao sfLeaveHospBalanceDao) {
		this.sfLeaveHospBalanceDao = sfLeaveHospBalanceDao;
	}

	public void setSfReduceItemDao(SfReduceItemDao sfReduceItemDao) {
		this.sfReduceItemDao = sfReduceItemDao;
	}

	public void setSfreduceTableDao(SfreduceTableDao sfreduceTableDao) {
		this.sfreduceTableDao = sfreduceTableDao;
	}

	public void setSfZyInvoiceHeadDao(SfZyInvoiceHeadDao sfZyInvoiceHeadDao) {
		this.sfZyInvoiceHeadDao = sfZyInvoiceHeadDao;
	}

	public void setSfZyInvoiceContentDao(
			SfZyInvoiceContentDao sfZyInvoiceContentDao) {
		this.sfZyInvoiceContentDao = sfZyInvoiceContentDao;
	}

	public void setZyHuShiChuLiService(ZyHuShiChuLiService zyHuShiChuLiService) {
		this.zyHuShiChuLiService = zyHuShiChuLiService;
	}

	public void setCfmedicalInstDao(CfmedicalInstDao cfmedicalInstDao) {
		this.cfmedicalInstDao = cfmedicalInstDao;
	}

	public void setMzGiveSfService(MzGiveSfService mzGiveSfService) {
		this.mzGiveSfService = mzGiveSfService;
	}

}
