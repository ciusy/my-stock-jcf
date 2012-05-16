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

		mzGiveSfService.updateMZOpDnStatus(oPDiagnoseID, "�ɴ���");
	}

	public List<List<String>> getReturnInvoiceProjects(List<List<String>> list) {
		Set<Long> invoiceNOs = new HashSet<Long>();
		for (List<String> tempList : list) {
			invoiceNOs.add(Long.parseLong(tempList.get(5)));
		}
		if (invoiceNOs.size() < 1)
			return Collections.EMPTY_LIST;
		// �õ���û��ע���ķ�Ʊ�����ĳ��ⵥ
		List<List<String>> prescriptions = sfMzInvoiceHeadDao.getPrescriptions(
				invoiceNOs, false);
		// �õ���û��ע���ķ�Ʊ�����Ĵ���
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

			if (!tempList.get(6).equals("")) {// ����
				disposeApplicationFormIds.add(tempList.get(4));
			} else// ����
			{
				storageApplicationFormIds.add(tempList.get(4));
			}
		}

		// �õ�������������еĴ����� һ��û���˵Ĵ������·�ƱҪ��ӡ�Ĵ��� ��
		List<List<String>> prescriptions = sfMzInvoiceHeadDao.getPrescriptions(
				invoiceNOs, false);

		Iterator<List<String>> iterator = prescriptions.iterator();
		// for (List<String> tempList : list) {
		// while (iterator.hasNext()) {
		// List<String> next = iterator.next();
		// if (next.get(9).equals(tempList.get(4))) {// ����Ҫ�ж��Ƿ��Ѿ����꣬��ֱ��ɾ��
		// iterator.remove();
		// }
		// }
		// }

		// �õ���û��ע���ķ�Ʊ�����Ĵ���
		List<List<String>> disposes = sfMzInvoiceHeadDao.getDisposes(
				invoiceNOs, false);
		iterator = disposes.iterator();
		for (List<String> tempList : list) {
			while (iterator.hasNext()) {
				List<String> next = iterator.next();
				if (next.get(9).equals(tempList.get(4))) {// ������ֱ��ɾ��
					iterator.remove();
				}
			}
		}
		List<List<String>> returnList = CommonUtil.addListToList(prescriptions,
				disposes);

		// �޸Ĵ�����Ŀ��״̬
		if (disposeApplicationFormIds.size() > 0)
			czGiveSfService.updateCzDisposeStatus(disposeApplicationFormIds,
					"���˷�");
		// �޸�������뵥��̬
		if (storageApplicationFormIds.size() > 0)
			yfGiveSfService.updateStorageApplicationFormStatus(
					storageApplicationFormIds, "���˷�");
		// �޸ķ�Ʊ��״̬
		sfMzInvoiceHeadDao.updateStatus(invoiceNOs, true);
		maxInvoiceNo = Collections.max(invoiceNOs);

		SfmzinvoiceHead maxNOSfmzinvoiceHead = sfMzInvoiceHeadDao
				.getById(maxInvoiceNo);
		// ȫ��������
		if (null == returnList && returnList.size() < 1)
			return Collections.EMPTY_LIST;
		// ����µķ�Ʊ��¼
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
					.equals("1") ? "���ﴦ��" : "���ﴦ��");
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

		// �õ�������������еĴ����� һ��û���˵Ĵ������·�ƱҪ��ӡ�Ĵ��� ��
		List<List<String>> prescriptions = sfMzInvoiceHeadDao
				.getPrescriptionsExcept(invoiceNOs, false,
						storageItemIds);

		Iterator<List<String>> iterator = prescriptions.iterator();
		// �õ���û��ע���ķ�Ʊ�����Ĵ���
		List<List<String>> disposes = sfMzInvoiceHeadDao.getDisposes(
				invoiceNOs, false);
		iterator = disposes.iterator();
		for (List<String> tempList : list) {
			while (iterator.hasNext()) {
				List<String> next = iterator.next();
				if (next.get(9).equals(tempList.get(4))) {// ������ֱ��ɾ��
					iterator.remove();
				}
			}
		}
		List<List<String>> returnList = CommonUtil.addListToList(prescriptions,
				disposes);
		// �޸�������뵥��̬
		if (storageApplicationFormIds.size() > 0)
			yfGiveSfService.updateYFmbankStatus(
					storageApplicationFormIds, "������");
		// �޸ķ�Ʊ��״̬
		sfMzInvoiceHeadDao.updateStatus(invoiceNOs, true);
		maxInvoiceNo = Collections.max(invoiceNOs);

		SfmzinvoiceHead maxNOSfmzinvoiceHead = sfMzInvoiceHeadDao
				.getById(maxInvoiceNo);
		// ȫ��������
		if (null == returnList && returnList.size() < 1)
			return Collections.EMPTY_LIST;

		// ����µķ�Ʊ��¼
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
					.equals("1") ? "���ﴦ��" : "���ﴦ��");
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
		// "�����"
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
				.getValueBydisposeName("�Һ���Ч��", medOrgId));
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
		// �����з������
		list1 = mzGiveSfService.getMzopDn(null, startTime, endTime, officeId);

		if (list1.size() < 1) {
			return Collections.EMPTY_LIST;
		}

		List<Long> ids = new ArrayList<Long>();
		// �õ���ѯ��������з������ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getCsId());
		}

		List<Csconsumer> list2 = csconsumerService.getByCondition(ids,
				consumerName, idCard, medicalCard, flag);

		ids.clear();
		// �õ���ѯ���������ҽ����Ա����ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getDoctorId());
		}

		List<Osstuff> list3 = osGiveSfService.getByIds(ids);

		List<String> ids1 = new ArrayList<String>();
		// �õ���������
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
		String costType = "";// �������ͼ������͵�ID
		Integer age = 0;
		boolean isLoop = false;
		for (MzopDn mzopDn : list1) {

			isLoop = false;
			Ghregister ghregister = gHGiveSFService.getGhRegister(mzopDn
					.getOpnum());
			// ��Ϻ�
			opDnId = mzopDn.getOpDnId();
			if (isCharge) {
				if (!ghregister.getIfCg().equals("���շ�"))
					isLoop = true;

				if (czGiveSfService.getCZCount("��������", opDnId, new String[] {
						"δ���ѿ�ִ��", "δ���Ѳ���ִ��", "δ������ִ��" }) > 0)
					isLoop = true;

				if (yfGiveSfService.getCFCount(mzopDn.getOpnum(),
						new String[] { "������" }) > 0)
					isLoop = true;
			} else {
				if (czGiveSfService.getCZCount("��������", opDnId, "�ѽ��ѿ�ִ��") > 0)
					isLoop = true;
				if (yfGiveSfService.getCFReturnCount(mzopDn.getOpnum(), "�����") > 0)
					isLoop = true;

			}

			if (!isLoop)
				continue;

			for (Csconsumer csconsumer : list2) {
				if (csconsumer.getCsId().longValue() == mzopDn.getCsId()
						.longValue()) {
					// �����������
					csName = csconsumer.getCsname();
					// �����������֤
					csIdCard = csconsumer.getIdcardNum();
					// ��������Ա�
					csSex = csconsumer.getSex();
					age = DateUtil.getBetweenYears(currentDateTime,
							csconsumer.getBirthday());

					// ���ʱ��
					dnTime = DateUtil.dateToStringWithTime(mzopDn.getDnTime());

					for (Osstuff osstuff : list3) {
						if (osstuff.getSid().longValue() == mzopDn
								.getDoctorId()) {
							// ���ҽ������
							doctorName = osstuff.getSname();
							break;
						}
					}
					for (Object[] obj : list4) {
						if (mzopDn.getOpnum().equals(String.valueOf(obj[0]))) {
							// �Ƿ��Ǽ���
							isFree = (!Boolean.valueOf(obj[2].toString())) ? "��"
									: "��";

							// ��������
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
				.getValueBydisposeName("�Һ���Ч��", medOrgId));
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
		// �����з������
		list1 = mzGiveSfService.getMzopDn(null, startTime, endTime, officeId);

		if (list1.size() < 1) {
			return Collections.EMPTY_LIST;
		}

		List<Long> ids = new ArrayList<Long>();
		// �õ���ѯ��������з������ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getCsId());
		}
		List<Csconsumer> list2 = csconsumerService.getByCondition(ids,
				consumerName, idCard, medicalCard, flag);
		ids.clear();
		// �õ���ѯ���������ҽ����Ա����ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getDoctorId());
		}
		List<Osstuff> list3 = osGiveSfService.getByIds(ids);
		List<String> ids1 = new ArrayList<String>();
		// �õ���������
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
		String costType = "";// �������ͼ������͵�ID
		Integer age = 0;
		boolean isLoop = false;
		for (MzopDn mzopDn : list1) {
			isLoop = false;
			Ghregister ghregister = gHGiveSFService.getGhRegister(mzopDn
					.getOpnum());
			// ��Ϻ�
			opDnId = mzopDn.getOpDnId();
			// �Ȳ���ѯ����
			// if (czGiveSfService.getCZCount("��������", opDnId, "�ѽ��ѿ�ִ��") > 0)
			// isLoop = true;

			if (yfGiveSfService.getCFCount(mzopDn.getOpnum(),
					new String[] { "�Ѿܾ�" }) > 0)
				isLoop = true;

			if (!isLoop)
				continue;

			for (Csconsumer csconsumer : list2) {
				if (csconsumer.getCsId().longValue() == mzopDn.getCsId()
						.longValue()) {
					// �����������
					csName = csconsumer.getCsname();
					// �����������֤
					csIdCard = csconsumer.getIdcardNum();
					// ��������Ա�
					csSex = csconsumer.getSex();
					age = DateUtil.getBetweenYears(currentDateTime,
							csconsumer.getBirthday());

					// ���ʱ��
					dnTime = DateUtil.dateToStringWithTime(mzopDn.getDnTime());

					for (Osstuff osstuff : list3) {
						if (osstuff.getSid().longValue() == mzopDn
								.getDoctorId()) {
							// ���ҽ������
							doctorName = osstuff.getSname();
							break;
						}
					}
					for (Object[] obj : list4) {
						if (mzopDn.getOpnum().equals(String.valueOf(obj[0]))) {
							// �Ƿ��Ǽ���
							isFree = (!Boolean.valueOf(obj[2].toString())) ? "��"
									: "��";

							// ��������
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
	 * add by xu �õ�������շѵĲ��ˣ����ڵ�¼�˿��ҵ�
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
	 * ���ң�����Ͻ���Ҫ��ʾ�Ķ���
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
		// �õ���ѯ��������з������ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getCsId());
		}

		List<Csconsumer> list2 = csconsumerService.getByIds(ids);

		ids.clear();
		// �õ���ѯ���������ҽ����Ա����ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getDoctorId());
		}

		List<Osstuff> list3 = osGiveSfService.getByIds(ids);

		List<String> ids1 = new ArrayList<String>();
		// �õ���������
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
		String costType = "";// �������ͼ������͵�ID
		Integer age = 0;
		boolean isLoop = false;
		for (MzopDn mzopDn : list1) {
			isLoop = false;
			Ghregister ghregister = gHGiveSFService.getGhRegister(mzopDn
					.getOpnum());

			// ��Ϻ�
			opDnId = mzopDn.getOpDnId();

			if (isCharge) {

				if (!ghregister.getIfCg().equals("���շ�"))
					isLoop = true;

				if (czGiveSfService.getCZCount("��������", opDnId, new String[] {
						"δ���ѿ�ִ��", "δ���Ѳ���ִ��", "δ������ִ��" }) > 0)
					isLoop = true;

				if (yfGiveSfService.getCFCount(mzopDn.getOpnum(),
						new String[] { "������" }) > 0)
					isLoop = true;
			} else {

				if (czGiveSfService.getCZCount("��������", opDnId, "�ѽ��ѿ�ִ��") > 0)
					isLoop = true;

				if (yfGiveSfService.getCFReturnCount(mzopDn.getOpnum(), "�����") > 0)
					isLoop = true;

			}
			if (!isLoop)
				continue;

			// ���ʱ��
			dnTime = DateUtil.dateToStringWithTime(mzopDn.getDnTime());

			for (Csconsumer csconsumer : list2) {
				if (csconsumer.getCsId().longValue() == mzopDn.getCsId()
						.longValue()) {
					// �����������
					// tempList.add(csconsumer.getCsname());
					csName = csconsumer.getCsname();
					// �����������֤
					// tempList.add(csconsumer.getIdcardNum());
					csIdCard = csconsumer.getIdcardNum();
					// ��������Ա�
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
					// ���ҽ������
					// tempList.add(osstuff.getSname());
					doctorName = osstuff.getSname();
					break;
				}
			}
			for (Object[] obj : list4) {
				if (mzopDn.getOpnum().equals(String.valueOf(obj[0]))) {
					// �Ƿ��Ǽ���
					// tempList.add(!Boolean.valueOf(obj[2].toString()) ? "��" :
					// "��");
					isFree = (!Boolean.valueOf(obj[2].toString())) ? "��" : "��";
					// ��������
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
		// ������ϼ�¼
		// mzGiveSfService.updateMZOpDnStatus(oPDiagnoseID, "������");
		mzGiveSfService.updateMZOpDnStatus(oPDiagnoseID, "���ɴ���");
		// List<Object[]> list2 = yfGiveSfService.getCF(oPDiagnoseID, "������ҩ");
		//
		// List<Object[]> list3 = czGiveSfService.getCZ("�����շ�", oPDiagnoseID);
		// List<SfreduceTable> list6 = null;
		// List<SfreduceItem> list5 = null;
		// if (isReduce == 1) {// �Һ����Ͷ�Ӧ�ķ������ͱ��У��ǿ��Լ���ģ��Ų�ѯ���úʹ����ļ���ģ��
		// HashSet<Integer> itemTypeIDSet = new HashSet<Integer>();
		// // �õ�������Ӧ�����е�ҩƷ��ϢId
		// for (Object[] obje : list2) {
		// itemTypeIDSet.add(Integer.parseInt(obje[8].toString()));
		// }
		// // �õ�������Ӧ�ļ������Ϣ
		// list6 = sfreduceTableDao.getByMInfoID(itemTypeIDSet);
		//
		// itemTypeIDSet.clear();
		// // �õ����ö�Ӧ�����е���Ŀ����Id
		// for (Object[] obje : list3) {
		// itemTypeIDSet.add(Integer.parseInt(obje[2].toString()));
		// }
		// // �õ����ö�Ӧ�ļ�����Ŀ��Ϣ
		// list5 = sfReduceItemDao.getByItemTypeID(itemTypeIDSet);
		//
		// }
		//
		// // ��Ϸ��ظ�ǰ̨
		// List<List<String>> list4 = new ArrayList<List<String>>();
		// List<String> tempList = null;
		// boolean flag = false;
		// // ��������
		// for (Object[] str : list2) {
		// flag = false;
		// tempList = new ArrayList<String>();
		// // for (int i = 0; i < str.length - 1; i++) {// ��ȥ���һ�е�ҩƷ��ϢID
		// for (int i = 0; i < 8; i++) {// �����ǰ8��
		// tempList.add(str[i].toString());
		// }
		//
		// // ��ʼ��ӵ�9��
		// if (isReduce == 1) {// �Һ����Ͷ�Ӧ�ķ������ͱ��У��ǿ��Լ���ģ��Ų�ѯ���úʹ����ļ���ģ��
		//
		// for (SfreduceTable sfreduceTable : list6) {
		// // �����������м���ģ��
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
		// // ��ӵ�9�к����
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
		// if (isReduce == 1) {// �Һ����Ͷ�Ӧ�ķ������ͱ��У��ǿ��Լ���ģ��Ų�ѯ���úʹ����ļ���ģ��
		// // ������������û�м���ģ��
		// for (SfreduceItem sfreduceItem : list5) {
		// if (sfreduceItem.getCostTypeId().intValue() == Integer
		// .parseInt(str[2].toString())) {
		//
		// if (sfreduceItem.getReducePercent().intValue() == 100) {
		// // �������ڶ�Ϊֻ��һ��,����������Ϊ1
		// tempList.add(String.valueOf(sfreduceItem
		// .getReduceAmount() * 1));
		// } else
		// // �������ڶ�Ϊֻ��һ��,����������Ϊ1
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
		// �õ���ѯ��������з������ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getCsId());
		}

		List<Csconsumer> list2 = csconsumerService.getByIds(ids);

		ids.clear();
		// �õ���ѯ���������ҽ����Ա����ids
		for (MzopDn mzopDn : list1) {
			ids.add(mzopDn.getDoctorId());
		}

		List<Osstuff> list3 = osGiveSfService.getByIds(ids);

		List<String> ids1 = new ArrayList<String>();
		// �õ���������
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
		String costType = "";// �������ͼ������͵�ID
		Integer age = 0;
		boolean isLoop = false;
		for (MzopDn mzopDn : list1) {
			isLoop = false;
			Ghregister ghregister = gHGiveSFService.getGhRegister(mzopDn
					.getOpnum());

			// ��Ϻ�
			opDnId = mzopDn.getOpDnId();
			// Ŀ¼ û�� ������
			// if (czGiveSfService.getCZCount("��������", opDnId, "�ѽ��ѿ�ִ��") > 0)
			// isLoop = true;

			if (yfGiveSfService.getCFCount(mzopDn.getOpnum(),
					new String[] { "�Ѿܾ�" }) > 0)
				isLoop = true;

			if (!isLoop)
				continue;

			// ���ʱ��
			dnTime = DateUtil.dateToStringWithTime(mzopDn.getDnTime());

			for (Csconsumer csconsumer : list2) {
				if (csconsumer.getCsId().longValue() == mzopDn.getCsId()
						.longValue()) {
					// �����������
					// tempList.add(csconsumer.getCsname());
					csName = csconsumer.getCsname();
					// �����������֤
					// tempList.add(csconsumer.getIdcardNum());
					csIdCard = csconsumer.getIdcardNum();
					// ��������Ա�
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
					// ���ҽ������
					// tempList.add(osstuff.getSname());
					doctorName = osstuff.getSname();
					break;
				}
			}
			for (Object[] obj : list4) {
				if (mzopDn.getOpnum().equals(String.valueOf(obj[0]))) {
					// �Ƿ��Ǽ���
					// tempList.add(!Boolean.valueOf(obj[2].toString()) ? "��" :
					// "��");
					isFree = (!Boolean.valueOf(obj[2].toString())) ? "��" : "��";
					// ��������
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
		// ��������ĿId����
		List<Long> prescriptionItemIDList = new ArrayList<Long>();
		// ��������Ŀ��Ӧ �ļ�����
		List<Double> prescriptionItemReduce = new ArrayList<Double>();
		// ���õ���Ŀid����
		List<String> disposeItemIdList = new ArrayList<String>();

		// ���õ���Ŀ��Ӧ �ļ�����
		List<Double> disposeItemReduce = new ArrayList<Double>();

		double prescriptionCharge = 0l;// ҩ���շѽ��(����)
		double disposeCharge = 0l;// �����շѽ��(����)

		Timestamp nowTimeStamp = DateUtil.getNowTimeStamp();
		// ��ӷ�Ʊ��¼
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
		sfmzinvoiceHead.setInvoiceType("���ｻ�ѷ�Ʊ");
		sfmzinvoiceHead.setUid(Integer.parseInt(officesNumber));
		sfMzInvoiceHeadDao.save(sfmzinvoiceHead);
		SfmzinvoiceContent sfmzinvoiceContent = null;

		List<SfmzinvoiceContent> sfmzinvoiceContents = new ArrayList<SfmzinvoiceContent>();

		String opnum = "";
		String money = "";
		for (List<String> tempOutList : list) {
			sfmzinvoiceContent = new SfmzinvoiceContent();
			if (tempOutList.get(5).equals("1")) {// ����
				// ����ǰ̨�����������������й���,ȷ�����úʹ��������뵥����Ϣ
				prescriptionItemIDList.add(Long.parseLong(tempOutList.get(6)));
				prescriptionItemReduce
						.add(tempOutList.get(2).equals("") ? (double) 0
								: Double.parseDouble(tempOutList.get(2)));
				aFormIDs.add(tempOutList.get(7));
				prescriptionCharge = prescriptionCharge
						+ (Double.parseDouble(tempOutList.get(1)) - (tempOutList
								.get(2).equals("") ? (double) 0 : Double
								.parseDouble(tempOutList.get(2))));
				sfmzinvoiceContent.setProjectType("���ﴦ��");
			} else if (tempOutList.get(5).equals("0")) {// ����
				disposeItemIdList.add(tempOutList.get(6));
				disposeItemReduce
						.add(tempOutList.get(2).equals("") ? (double) 0
								: Double.parseDouble(tempOutList.get(2)));
				disposeCharge = disposeCharge
						+ (Double.parseDouble(tempOutList.get(1)) - (tempOutList
								.get(2).equals("") ? (double) 0 : Double
								.parseDouble(tempOutList.get(2))));
				sfmzinvoiceContent.setProjectType("���ﴦ��");
			} else if (tempOutList.get(5).equals("-1"))// �Һ�
			{
				sfmzinvoiceContent.setProjectType("�Һ�");
				opnum = tempOutList.get(6).toString();
				money = tempOutList.get(2).toString();
				Ghregister ghregister = gHGiveSFService.getGhRegister(opnum);
				if (!ghregister.getIfCg().equals("���շ�")) {
					ghregister.setRealPrice(ghregister.getRealPrice()
							- Double.parseDouble(money));
					ghregister.setIfCg("���շ�");
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

		// �޸ĳ������뵥���е�״̬ ����ϸ��Ŀ�ļ����� ����Ϣ
		yfGiveSfService.updateStatusAndReduce(aFormIDs, prescriptionItemIDList,
				prescriptionItemReduce, costTypeId);
		// �޸Ĵ��õ�״̬��ʵ�յ���Ϣ
		czGiveSfService.updateStatusAndReduce(disposeItemIdList,
				disposeItemReduce, costTypeId, officesNumber, personnelNumber,
				nowTimeStamp);
		// �õ����뵥��Ϣ
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
						"���﷢Ʊ��ʼ��" });
		cfmedicalInst.setCfvalue(cfmedicalInst.getCfvalue() + 1);

		// ��������շѱ����Ϣ
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
		// // ��û��ӷ�Ʊ���ͱ�ע
		// sfopcg.setPrintReceiptOrNot(true);
		// sfopcg.setReceiptCode(sfmzinvoiceHead.getInvoiceNo() + "");
		// sfopcgDao.save(sfopcg);
		//
		// // ��� ʹ��������ʽ���� ��(SFCsByOtherMethod)�ļ�¼
		// SfcsByOtherMethod sfcsByOtherMethod = new SfcsByOtherMethod();
		// sfcsByOtherMethod.setCgAmount(Double.parseDouble(reduceMoney));
		// sfcsByOtherMethod.setOpdiagnoseId(diagnoseID);
		// sfcsByOtherMethod.setPid(Integer.parseInt(costTypeId));
		// sfCsByOtherMethodDao.save(sfcsByOtherMethod);

		SfcgTable sfcgTable = sfCgTableDao.saveSfCgTable(cashPay,
				personnelNumber, realMoeny, officesNumber, nowTimeStamp,
				diagnoseID, "�����շ�", "MZOpDn");

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
		}
		if (!bankPay.trim().equals("")) {
			// ���ˢ���� ��SFCreditCard��
			sfcreditCard = new SfcreditCard();
			sfcreditCard.setCgId(sfcgTable.getCgId());
			sfcreditCard.setCreditCard(Double.parseDouble(bankPay));
			sfcreditCard.setCreditCardType("���п�");
			sfCreditCardDao.save(sfcreditCard);
		}
		mzGiveSfService.updateMZOpDnStatus(diagnoseID, "�ɴ���");
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
