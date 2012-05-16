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
 * סԺѺ�����ʹ�õ�service
 * 
 * @author xuxiangpan
 * @version ����ʱ�䣺Aug 5, 2011 10:04:48 AM
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
	 * update 12.28 ȥ��List<List<String>> projectDetails ������û������
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
		zyGiveSfService.updateZyStauts(inpatientId, true, "�ѳ�Ժ");
		if (null == list || list.size() < 1)// û����Ŀֱ�ӳ�Ժ��
			return true;
		Zyinpatient zyinpatient = zyGiveSfService
				.getInpatinentById(inpatientId);
		Set<String> aFormIDs = new HashSet<String>();
		// ��������ĿId����
		List<Long> prescriptionItemIDList = new ArrayList<Long>();
		// ��������Ŀ��Ӧ �ļ�����
		List<Double> prescriptionItemReduce = new ArrayList<Double>();

		// ���õ���Ŀid����
		List<String> disposeItemIdList = new ArrayList<String>();

		// ���õ���Ŀ��Ӧ �ļ�����
		List<Double> disposeItemReduce = new ArrayList<Double>();

		Timestamp nowTimeStamp = DateUtil.getNowTimeStamp();
		// ��ӷ�Ʊ��¼
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
				// ����ǰ̨�����������������й���,ȷ�����úʹ��������뵥����Ϣ
				prescriptionItemIDList.add(Long.parseLong(tempOutList.get(6)));
				prescriptionItemReduce
						.add(tempOutList.get(2).equals("") ? (double) 0
								: Double.parseDouble(tempOutList.get(2)));
				aFormIDs.add(tempOutList.get(7));
				sfmzinvoiceContent.setProjectType("סԺ����");
			} else {
				disposeItemIdList.add(tempOutList.get(6));
				disposeItemReduce
						.add(tempOutList.get(2).equals("") ? (double) 0
								: Double.parseDouble(tempOutList.get(2)));
				sfmzinvoiceContent.setProjectType("סԺ����");
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
		// �޸ĳ������뵥���е�״̬ ����ϸ��Ŀ�ļ����� ����Ϣ
		yfGiveSfService.updateStatusAndReduce(aFormIDs, prescriptionItemIDList,
				prescriptionItemReduce, "");
		// �޸Ĵ��õ�״̬��ʵ�յ���Ϣ
		czGiveSfService.updateStatusAndReduce(disposeItemIdList,
				disposeItemReduce, "", officesNumber, "", null);
		SfcgTable sfcgTable = sfCgTableDao.saveSfCgTable(cashPay,
				personnelNumber, realMoeny, officesNumber, nowTimeStamp,
				inpatientId, "��Ժ����", "SFLeaveHospBalance");

		// ��Ժ�����
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
		// ũ����д���ϣ���ʱ��Ϊ��
		sfleaveHospBalance.setRuralCooper(0d);
		sfleaveHospBalance.setRuralCooperBalance(false);
		sfleaveHospBalance.setToRefund(returnAmount);

		SfcreditCard sfcreditCard = null;

		if (!medicalCardPay.trim().equals("")) {
			// ���ˢ���� ��SFCreditCard��
			sfcreditCard = new SfcreditCard();
			sfcreditCard.setCgId(sfcgTable.getCgId());
			sfcreditCard.setCreditCard(Double.parseDouble(medicalCardPay));
			sfcreditCard.setCreditCardType("ҽ�ƿ�");
			sfCreditCardDao.save(sfcreditCard);

			// ҽ�ƿ��굥��CSMedicalCardDetail������� ��ҽ�ƿ���CSMedicalCard�����������
			CsmedicalCardDetail csmedicalCardDetail = new CsmedicalCardDetail();
			csmedicalCardDetail.setAmount(Double.parseDouble(medicalCardPay));
			csmedicalCardDetail.setCgId(sfcgTable.getCgId());
			// ������һ����Ŀ��ҽ�ƿ�����������Ŀ��
			csmedicalCardDetail.setCgItem(list.get(list.size() - 1).get(0));

			csmedicalCardDetail.setCsId(Long.parseLong(consumerId));
			csmedicalCardDetail.setDate(nowTimeStamp);
			csmedicalCardDetail.setReceiver(Long.parseLong(personnelNumber));
			csGiveSfService.addCSMedicalCardDetail(csmedicalCardDetail,
					Long.parseLong(consumerId));
		}
		if (!medicalInsurancePay.trim().equals("")) {
			// ���ˢ���� ��SFCreditCard��
			sfcreditCard = new SfcreditCard();
			sfcreditCard.setCgId(sfcgTable.getCgId());
			sfcreditCard.setCreditCard(Double.parseDouble(medicalInsurancePay));
			sfcreditCard.setCreditCardType("ҽ����");
			sfCreditCardDao.save(sfcreditCard);

			sfleaveHospBalance.setMedicalInsurance(Double
					.parseDouble(medicalInsurancePay));
			sfleaveHospBalance.setMedicalInsuranceBalance(true);

		}
		if (!bankPay.trim().equals("")) {
			// ���ˢ���� ��SFCreditCard��
			sfcreditCard = new SfcreditCard();
			sfcreditCard.setCgId(sfcgTable.getCgId());
			sfcreditCard.setCreditCard(Double.parseDouble(bankPay));
			sfcreditCard.setCreditCardType("���п�");
			sfCreditCardDao.save(sfcreditCard);
		}
		sfLeaveHospBalanceDao.save(sfleaveHospBalance);

		CfmedicalInst cfmedicalInst = cfmedicalInstDao.getSingleData(
				"o.medicalInstId=? and o.disposeName=?", new Object[] { orgId,
						"סԺ��Ʊ��ʼ��" });
		cfmedicalInst.setCfvalue(cfmedicalInst.getCfvalue() + 1);

		return true;
	}

	public List<List<String>> getInvoiceProject(Boolean isderate,
			String inpatientId, String typeDispose, String typeRecipe) {

		List<String> paramList1 = new ArrayList<String>();
		List<String> paramList2 = new ArrayList<String>();
		setParam(typeDispose, paramList1, paramList2);

		List<List<String>> list0 = null;
		// �Һŵ���Ŀ
		if ("��������".equals(typeDispose)) {
			Ghregister ghregister = ghGiveSFService.getGhRegister(inpatientId
					.substring(inpatientId.indexOf(",") + 1,
							inpatientId.length()));
			if (null == ghregister.getIfCg()
					|| !ghregister.getIfCg().equals("���շ�")) {
				list0 = new ArrayList<List<String>>();
				List<String> tempList = new ArrayList<String>();
				tempList.add("�Һŷ�");
				tempList.add(ghregister.getRealPrice() + "");
				tempList.add(ghregister.getReceivablePrice()
						- ghregister.getRealPrice() + "");
				tempList.add("�Һŷ�");
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
		if ("��������".equals(typeDispose)) {
			paramList1.add("δ���ѿ�ִ��");
			paramList1.add("δ���Ѳ���ִ��");
			paramList1.add("δ������ִ��");

			// paramList2.add("����ҩδ����");
			paramList2.add("������");

		}
	}

	public List<List<String>> getInpatientPojectDetail(Boolean isderate,
			String inpatientId, String type, String projectName,
			String typeDispose, String typeRecipe) {

		List<List<String>> list = null;

		List<String> paramList1 = new ArrayList<String>();
		List<String> paramList2 = new ArrayList<String>();
		setParam(typeDispose, paramList1, paramList2);

		if (type.equals("1")) {// 1�Ǵ���

			list = yfGiveSfService.getInpatientProjectDetail(
					isderate,
					inpatientId.indexOf(",") > -1 ? inpatientId.substring(
							inpatientId.indexOf(",") + 1, inpatientId.length())
							: inpatientId, projectName, typeRecipe, paramList2);
		} else if (type.equals("0")) {// 0 ����
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
		// �Һŵ���Ŀ
		if ("��������".equals(typeDispose)) {
			Ghregister ghregister = ghGiveSFService.getGhRegister(inpatientId
					.substring(inpatientId.indexOf(",") + 1,
							inpatientId.length()));
			if (null == ghregister.getIfCg()
					|| !ghregister.getIfCg().equals("���շ�")) {
				list0 = new ArrayList<List<String>>();
				List<String> tempList = new ArrayList<String>();
				tempList.add("�Һŷ�");
				tempList.add(ghregister.getReceivablePrice() + "");
				tempList.add(ghregister.getReceivablePrice()
						- ghregister.getRealPrice() + "");
				tempList.add("�Һŷ�");
				tempList.add(ghregister.getReceivablePrice()
						- ghregister.getRealPrice() + "");
				tempList.add("-1");
				tempList.add(ghregister.getOpnum());
				tempList.add("");
				list0.add(tempList);
			}
		}

		List<List<String>> list = null;
		// "סԺ��ҩ" "סԺ����"
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
	 * �õ�סԺ�������ﲡ�˵ļ�����
	 * 
	 * @param isderate
	 * @param inpatientId
	 * @param typeDispose
	 * @param typeRecipe
	 * @return
	 */
	public Double getZyReduceMoney(Boolean isderate, String inpatientId,
			String typeDispose, String typeRecipe) {
		// ���õļ�����
		// "סԺ����""סԺ��ҩ"
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
		// �Һŵ���Ŀ
		if ("��������".equals(typeDispose)) {
			mzGiveSfService.updateMZOpDnStatus(
					inpatientId.substring(0, inpatientId.indexOf(",")), "���ɴ���");
			Ghregister ghregister = ghGiveSFService.getGhRegister(inpatientId
					.substring(inpatientId.indexOf(",") + 1,
							inpatientId.length()));
			if (null == ghregister.getIfCg()
					|| !ghregister.getIfCg().equals("���շ�")) {
				list0 = new ArrayList<List<String>>();
				List<String> tempList = new ArrayList<String>();
				tempList.add("�Һŷ�");
				tempList.add(ghregister.getRealPrice() + "");
				tempList.add("�Һ�");
				tempList.add(ghregister.getReceivablePrice() + "");
				list0.add(tempList);
			}
		}

		// ����
		List<Object[]> list1 = czGiveSfService.getZyInpatientProjectPrice(
				inpatientId.indexOf(",") > -1 ? inpatientId.substring(0,
						inpatientId.indexOf(",")) : inpatientId, typeDispose,
				paramList1);

		// ��ҩ
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
		if (inPatientDepId != -1) {// ��ѯָ����סԺ���ķ������
			inPatientDeptIds = new ArrayList<Integer>();
			inPatientDeptIds.add(inPatientDepId);
		} else {// ��ѯҽ�ƻ����µ����е�סԺ���ķ������
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
		// ����ҽ�ƻ���������е�סԺ��
		List<Osuform> osuformList = osGiveSfService.getInpatientDept(
				medicalOrgnizal, "סԺ");
		// ������е�סԺ��ids
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

		List<Long> ids = new ArrayList<Long>();// �������id����
		Set<Integer> costTypeIds = new HashSet<Integer>();// ��������IDs

		List<String> ipIDS = new ArrayList<String>();// סԺid����

		// �õ���ѯ��������з������ids
		for (Zyinpatient zyinpatient : list) {
			ipIDS.add(zyinpatient.getIpid());
			ids.add(zyinpatient.getCsId());
			costTypeIds.add(zyinpatient.getChargeType());
		}

		// ���ҷ���������
		List<Csconsumer> list2 = csconsumerService.getByIds(ids);
		// ���Ҷ�Ӧ ���շ����Ͷ���
		List<GhcostType> costTypeList = ghGiveSFService
				.getCostType(costTypeIds);
		// ���Ҷ�Ӧ��������ҽ�ƿ�
		List<CsmedicalCard> medicalCardList = csGiveSfService
				.getCsmedicalCard(ids);
		// ��������סԺѺ����ܶ�
		List<Object[]> sfipdepositRecordList = sfipdepositRecordDao
				.getTotalByIpIDS(ipIDS);
		// ���ҷ�������ۼ����ѵķ���
		List<Object[]> zyRedudancyConsumeList = zyGiveSfService
				.getZyredudancyConsume(ipIDS);

		String iPID = "";// סԺ��
		String bedNO = "";// ��λ��
		String consumerName = "";// �����������
		String sex = "";
		Integer age = 0;
		String costType = "";// ��������
		boolean flag = false;// �Ƿ���ܼ���
		String medicalCardNO = "";// ҽ�ƿ���
		String medicalInsureNO = "";// ҽ������
		String ipTime = ""; // ��Ժʱ��
		String advisedDeposit = "0";// ����Ѻ��
		String totalDeposit = "0";// סԺѺ���ܹ������˶���Ѻ��
		String totalCharge = "0";// �ۼƷ���
		String depositBalance = "0";// Ѻ�����

		List<List<String>> returnList = new ArrayList<List<String>>();

		List<String> tempList = new ArrayList<String>();
		// ���췵�ظ�ǰ̨��list
		for (Zyinpatient zyinpatient : list) {
			iPID = "";// סԺ��
			bedNO = "";// ��λ��
			consumerName = "";// �����������
			sex = "";
			age = 0;
			costType = "";// ��������
			flag = false;// �Ƿ���ܼ���
			medicalCardNO = "";// ҽ�ƿ���
			medicalInsureNO = "";// ҽ������
			ipTime = ""; // ��Ժʱ��
			advisedDeposit = "0";// ����Ѻ��
			totalDeposit = "0";// סԺѺ���ܹ������˶���Ѻ��
			totalCharge = "0";// �ۼƷ���
			depositBalance = "0";// Ѻ�����

			iPID = zyinpatient.getIpid();
			bedNO = String.valueOf(zyinpatient.getBed());
			// �õ�������������
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
			// ��������
			for (GhcostType ghcostType : costTypeList) {
				if (zyinpatient.getChargeType().longValue() == ghcostType
						.getId()) {
					costType = ghcostType.getCostType();
					flag = ghcostType.getDerate();
					break;
				}
			}
			// ҽ�ƿ�ID
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
			// Ѻ�����
			depositBalance = zyinpatient.getDepositBalance().toString();

			tempList = new ArrayList<String>();
			tempList.add(iPID);// סԺ��
			tempList.add(bedNO);// ��λ��
			tempList.add(consumerName);// �����������
			tempList.add(sex);
			tempList.add(String.valueOf(age));
			tempList.add(costType);// �������� ??
			tempList.add(medicalCardNO);// ҽ�ƿ���??
			tempList.add(medicalInsureNO);
			tempList.add(ipTime); // ��Ժʱ��
			tempList.add(advisedDeposit);// ����Ѻ��
			tempList.add(CommonUtil.keep2Decimal(totalDeposit));// סԺѺ���ܹ������˶���Ѻ��???
			tempList.add(CommonUtil.keep2Decimal(totalCharge));// �ۼƷ���
			tempList.add(CommonUtil.keep2Decimal(depositBalance));// Ѻ�����
			tempList.add(zyinpatient.getIpdeptId().toString());// delphi ������
																// סԺ��ID
			tempList.add(zyinpatient.getCsId().toString());// delphi ������ �������ID
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
	// List<Long> ids = new ArrayList<Long>();// �������id����
	// Set<Integer> costTypeIds = new HashSet<Integer>();// ��������IDs
	//
	// List<String> ipIDS = new ArrayList<String>();// סԺid����
	//
	// // �õ���ѯ��������з������ids
	// for (Zyinpatient zyinpatient : list) {
	// ipIDS.add(zyinpatient.getIpid());
	// ids.add(zyinpatient.getCsId());
	// costTypeIds.add(zyinpatient.getChargeType());
	// }
	//
	// // ���ҷ���������
	// List<Csconsumer> list2 = csconsumerService.getByIds(ids);
	//
	// // ���Ҷ�Ӧ ���շ����Ͷ���
	// List<GhcostType> costTypeList = ghGiveSFService.getCostType(costTypeIds);
	//
	// // ���Ҷ�Ӧ��������ҽ�ƿ�
	// List<CsmedicalCard> medicalCardList =
	// csGiveSfService.getCsmedicalCard(ids);
	// // ��������סԺѺ����ܶ�
	// List<Object[]> sfipdepositRecordList =
	// sfipdepositRecordDao.getTotalByIpIDS(ipIDS);
	// // ���ҷ�������ۼ����ѵķ���
	// List<Object[]> zyRedudancyConsumeList =
	// zyGiveSfService.getZyredudancyConsume(ipIDS);
	//
	// String iPID = "";// סԺ��
	// String bedNO = "";// ��λ��
	// String consumerName = "";// �����������
	// String sex = "";
	// Integer age = 0;
	// String costType = "";// ��������
	// String medicalCardNO = "";// ҽ�ƿ���
	// String ipTime = ""; // ��Ժʱ��
	// String advisedDeposit = "0";// ����Ѻ��
	// String totalDeposit = "0";// סԺѺ���ܹ������˶���Ѻ��
	// String totalCharge = "0";// �ۼƷ���
	// String depositBalance = "0";// Ѻ�����
	//
	// List<List<String>> returnList = new ArrayList<List<String>>();
	//
	// List<String> tempList = new ArrayList<String>();
	// // ���췵�ظ�ǰ̨��list
	// for (Zyinpatient zyinpatient : list) {
	//
	// iPID = zyinpatient.getIpid();
	// bedNO = String.valueOf(zyinpatient.getBed());
	// // �õ�������������
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
	// // ��������
	// for (GhcostType ghcostType : costTypeList) {
	// if (zyinpatient.getChargeType().longValue() == ghcostType.getId()) {
	// costType = ghcostType.getCostType();
	// break;
	// }
	// }
	// // ҽ�ƿ�ID
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
	// // Ѻ�����
	// depositBalance = zyinpatient.getDepositBalance().toString();
	//
	// tempList = new ArrayList<String>();
	// tempList.add(iPID);// סԺ��
	// tempList.add(bedNO);// ��λ��
	// tempList.add(consumerName);// �����������
	// tempList.add(sex);
	// tempList.add(String.valueOf(age));
	// tempList.add(costType);// �������� ??
	// tempList.add(medicalCardNO);// ҽ�ƿ���??
	// tempList.add(ipTime); // ��Ժʱ��
	// tempList.add(advisedDeposit);// ����Ѻ��
	// tempList.add(totalDeposit);// סԺѺ���ܹ������˶���Ѻ��???
	// tempList.add(totalCharge);// �ۼƷ���
	// tempList.add(depositBalance);// Ѻ�����
	// tempList.add(zyinpatient.getIpdeptId().toString());// delphi ������ סԺ��ID
	// tempList.add(zyinpatient.getCsId().toString());// delphi ������ �������ID
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
		// ���Ѻ��ļ�¼
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
		// �޸�סԺ�����
		Zyinpatient zyinpatient = zyInpatientDao.find(ipid);
		zyinpatient.setDepositBalance(zyinpatient.getDepositBalance()
				+ Double.parseDouble(depositAmout));
		zyInpatientDao.update(zyinpatient);
		// ����շѱ�
		sfCgTableDao
				.saveSfCgTable(depositAmout, chargeMan, depositAmout,
						chargeOfficeId, DateUtil.getNowTimeStamp(),
						sfipdepositRecord.getDepositId().toString(), "סԺѺ��",
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
