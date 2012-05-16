package leo.ws.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import leo.bc.sercive.iface.CzGiveWsService;
import leo.cf.service.iface.CfwholeDisposeService;
import leo.common.util.DateUtil;
import leo.cs.service.iface.CsconsumerService;
import leo.entity.Csconsumer;
import leo.entity.MzopDn;
import leo.entity.Osstuff;
import leo.entity.Osuform;
import leo.entity.WsdocW;
import leo.entity.WsdocW1;
import leo.entity.WsidocW;
import leo.entity.WsvisitRemind;
import leo.entity.ZydoctorAdvice;
import leo.mz.service.iface.MzGiveSfService;
import leo.os.service.iface.OsGiveSfService;
import leo.ws.dao.WsDocW1Dao;
import leo.ws.dao.WsDocumentDao;
import leo.ws.dao.WsVisitRemindDao;
import leo.ws.dao.WsdocWDao;
import leo.ws.dao.WsidocWDao;
import leo.ws.service.iface.WsFillInService;
import leo.zy.service.iface.ZyGiveSfService;

/**
 * @author xuxiangpan
 * @version 创建时间：Aug 18, 2011 9:44:23 AM
 */
public class WsFillInServiceImpl implements WsFillInService {

	private CzGiveWsService czGiveWsService;

	private CsconsumerService csconsumerService;

	private OsGiveSfService osGiveSfService;

	private MzGiveSfService mzGiveSfService;
	private ZyGiveSfService zyGiveSfService;

	// private CsGiveSfService csGiveSfService;

	private CfwholeDisposeService cfwholeDisposeService;

	private WsVisitRemindDao wsVisitRemindDao;

	public void setWsVisitRemindDao(WsVisitRemindDao wsVisitRemindDao) {
		this.wsVisitRemindDao = wsVisitRemindDao;
	}

	public List<List<String>> getWsFillInProject(String value, Boolean isSpell, String startTime, String endTime, String officeId) {

		int expiryDay = Integer.parseInt(cfwholeDisposeService.getValueOfWholeDisposeByDisposeName("外置有效时间").getCfvalue());
		
		Date expiryEndDateTime = DateUtil.getCurrentDateTime();
		Date expiryStartDateTime = DateUtil.dateIncreaseByDay(DateUtil.getCurrentDateTime(), -expiryDay);

		if (!"".equals(startTime)
				&& DateUtil.dateAfterDate(DateUtil.stringToDateTime(startTime + " 00:00:00"), expiryStartDateTime)) {

		} else {
			startTime = DateUtil.dateToStringWithTime(expiryStartDateTime);
		}

		if (!"".equals(endTime) && DateUtil.dateAfterDate(expiryEndDateTime, DateUtil.stringToDateTime(endTime + " 23:59:59"))) {

		} else {
			endTime = DateUtil.dateToStringWithTime(expiryEndDateTime);
		}

		List<String> statusList = new ArrayList<String>();
		statusList.add("已交费可执行");
		statusList.add("未交费可执行");
		statusList.add("已申请");

		List<Object[]> list = czGiveWsService.getCzdisposeByStatusAndTime(statusList, startTime, endTime, officeId);

		if (list.size() < 1)
			return Collections.EMPTY_LIST;
		List<Long> consumerIds = new ArrayList<Long>();
		List<Long> osstuffIds = new ArrayList<Long>();
		List<String> opDnIds = new ArrayList<String>();
		List<String> daIds = new ArrayList<String>();
		List<Integer> osUFormIds = new ArrayList<Integer>();

		for (Object[] temp : list) {
			osUFormIds.add(Integer.parseInt(temp[0].toString()));
			consumerIds.add(Long.parseLong(temp[2].toString()));
			osstuffIds.add(Long.parseLong(temp[1].toString()));
			if (temp[5].toString().equals("门诊申请"))
				opDnIds.add(temp[6].toString());
			else
				daIds.add(temp[6].toString());
		}

		List<Osuform> osuforms = osGiveSfService.getOsuformsByIds(osUFormIds);
		List<Csconsumer> csconsumers = null;
		csconsumers = csconsumerService.getByIds(consumerIds);
		List<Osstuff> osstuffs = null;
		if (null != osstuffIds && osstuffIds.size() > 0)
			osstuffs = osGiveSfService.getByIds(osstuffIds);
		List<MzopDn> mzopdns = null;
		if (null != opDnIds && opDnIds.size() > 0)
			mzopdns = mzGiveSfService.getMzopDnByIDs(opDnIds);
		List<ZydoctorAdvice> zydoctorAdvices = null;
		if (null != daIds && daIds.size() > 0)
			zydoctorAdvices = zyGiveSfService.getZydoctorAdviceByIds(daIds);

		List<List<String>> returnList = new ArrayList<List<String>>();
		List<String> tempList = null;
		String applicationOffice = "";
		String applicationDoctor = "";
		String consumerName = "";
		String sex = "";
		int age = 0;
		String outPatientId = "";
		String inHospitalId = "";
		Long consumerId = 0l;

		// 拼音简码
		String spellName = "";
		Boolean isContinue = true;
		String address = "";
		String phone = "";
		for (Object[] tempObj : list) {
			for (Csconsumer csconsumer : csconsumers) {
				if (csconsumer.getCsId().longValue() == Long.parseLong(tempObj[2].toString())) {
					consumerId = csconsumer.getCsId().longValue();
					consumerName = csconsumer.getCsname();
					sex = csconsumer.getSex();
					age = DateUtil.getBetweenYears(DateUtil.getCurrentDateTime(), csconsumer.getBirthday());
					spellName = csconsumer.getNameForShort();
					address = csconsumer.getAddress();
					phone = csconsumer.getTelephone();
					break;
				}
			}

			if (null != value && !"".equals(value)) {
				if (isSpell) {
					if (spellName.toUpperCase().startsWith(value.toUpperCase()))
						isContinue = true;
					else
						isContinue = false;
				}

				if (!isSpell) {
					if (consumerName.startsWith(value))
						isContinue = true;
					else
						isContinue = false;
				}
			}

			if (!isContinue)
				continue;

			isContinue = true;

			tempList = new ArrayList<String>();

			for (Osuform osuform : osuforms) {
				if (osuform.getUid().intValue() == Integer.parseInt(tempObj[0].toString())) {
					applicationOffice = osuform.getUname();
					break;
				}
			}

			for (Osstuff osstuff : osstuffs) {
				if (osstuff.getSid().longValue() == Long.parseLong(tempObj[1].toString())) {
					applicationDoctor = osstuff.getSname();
					break;
				}
			}

			tempList.add(applicationOffice);
			tempList.add(applicationDoctor);
			tempList.add(consumerName);
			tempList.add(sex);
			tempList.add(String.valueOf(age));
			tempList.add(tempObj[3].toString());
			tempList.add(tempObj[4].toString());

			if (tempObj[5].toString().equals("门诊申请")) {
				for (MzopDn mzopDn : mzopdns) {
					if (mzopDn.getOpDnId().equals(tempObj[6].toString())) {
						outPatientId = mzopDn.getOpnum();
						inHospitalId = "";
						break;
					}
				}
			} else {
				for (ZydoctorAdvice zydoctorAdvice : zydoctorAdvices) {
					if (zydoctorAdvice.getDaid().equals(tempObj[6].toString())) {
						outPatientId = "";
						inHospitalId = zydoctorAdvice.getIpid();
						break;
					}
				}
			}
			tempList.add(outPatientId);
			tempList.add(inHospitalId);
			tempList.add(tempObj[7].toString());
			tempList.add(tempObj[8].toString());
			tempList.add(consumerId.toString());
			tempList.add(address);
			tempList.add(phone);

			returnList.add(tempList);

		}

		return returnList;

	}

	public List<List<String>> getWsFillInProject(String officeId) {

		int expiryDay = Integer.parseInt(cfwholeDisposeService.getValueOfWholeDisposeByDisposeName("外置有效时间").getCfvalue());
		String expiryEndDateTime = DateUtil.dateTimeToStringTime(DateUtil.getCurrentDateTime());
		String expiryStartDateTime = DateUtil.dateTimeToStringTime(DateUtil.dateIncreaseByDay(DateUtil.getCurrentDateTime(),
				-expiryDay));

		List<String> statusList = new ArrayList<String>();
		statusList.add("已交费可执行");
		statusList.add("未交费可执行");
		statusList.add("已申请");

		List<Object[]> list = czGiveWsService.getCzdisposeByStatusAndTime(statusList, expiryStartDateTime, expiryEndDateTime,
				officeId);

		if (list.size() < 1)
			return Collections.EMPTY_LIST;
		List<Long> consumerIds = new ArrayList<Long>();
		List<Long> osstuffIds = new ArrayList<Long>();
		List<String> opDnIds = new ArrayList<String>();
		List<String> daIds = new ArrayList<String>();
		List<Integer> osUFormIds = new ArrayList<Integer>();

		for (Object[] temp : list) {
			osUFormIds.add(Integer.parseInt(temp[0].toString()));
			consumerIds.add(Long.parseLong(temp[2].toString()));
			osstuffIds.add(Long.parseLong(temp[1].toString()));
			if (temp[5].toString().equals("门诊申请"))
				opDnIds.add(temp[6].toString());
			else
				daIds.add(temp[6].toString());
		}

		List<Osuform> osuforms = osGiveSfService.getOsuformsByIds(osUFormIds);
		List<Csconsumer> csconsumers = null;
		if (null != consumerIds && consumerIds.size() > 0)
			csconsumers = csconsumerService.getByIds(consumerIds);
		List<Osstuff> osstuffs = null;
		if (null != osstuffIds && osstuffIds.size() > 0)
			osstuffs = osGiveSfService.getByIds(osstuffIds);
		List<MzopDn> mzopdns = null;
		if (null != opDnIds && opDnIds.size() > 0)
			mzopdns = mzGiveSfService.getMzopDnByIDs(opDnIds);
		List<ZydoctorAdvice> zydoctorAdvices = null;
		if (null != daIds && daIds.size() > 0)
			zydoctorAdvices = zyGiveSfService.getZydoctorAdviceByIds(daIds);

		List<List<String>> returnList = new ArrayList<List<String>>();
		List<String> tempList = null;
		String applicationOffice = "";
		String applicationDoctor = "";
		String consumerName = "";
		String sex = "";
		int age = 0;
		String outPatientId = "";
		String inHospitalId = "";
		Long consumerId = 0l;
		String address = "";
		String phone = "";

		// 拼音简码
		// String spellName = "";
		for (Object[] tempObj : list) {
			tempList = new ArrayList<String>();

			for (Osuform osuform : osuforms) {
				if (osuform.getUid().intValue() == Integer.parseInt(tempObj[0].toString())) {
					applicationOffice = osuform.getUname();
					break;
				}
			}

			for (Osstuff osstuff : osstuffs) {
				if (osstuff.getSid().longValue() == Long.parseLong(tempObj[1].toString())) {
					applicationDoctor = osstuff.getSname();
					break;
				}
			}
			for (Csconsumer csconsumer : csconsumers) {
				if (csconsumer.getCsId().longValue() == Long.parseLong(tempObj[2].toString())) {
					consumerId = csconsumer.getCsId().longValue();
					consumerName = csconsumer.getCsname();
					sex = csconsumer.getSex();
					age = DateUtil.getBetweenYears(DateUtil.getCurrentDateTime(), csconsumer.getBirthday());
					// spellName = csconsumer.getNameForShort();
					address = csconsumer.getAddress();
					phone = csconsumer.getTelephone();
					break;
				}
			}

			tempList.add(applicationOffice);
			tempList.add(applicationDoctor);
			tempList.add(consumerName);
			tempList.add(sex);
			tempList.add(String.valueOf(age));
			tempList.add(tempObj[3].toString());
			tempList.add(tempObj[4].toString());

			if (tempObj[5].toString().equals("门诊申请")) {
				for (MzopDn mzopDn : mzopdns) {
					if (mzopDn.getOpDnId().equals(tempObj[6].toString())) {
						outPatientId = mzopDn.getOpnum();
						inHospitalId = "";
						break;
					}
				}
			} else {
				for (ZydoctorAdvice zydoctorAdvice : zydoctorAdvices) {
					if (zydoctorAdvice.getDaid().equals(tempObj[6].toString())) {
						outPatientId = "";
						inHospitalId = zydoctorAdvice.getIpid();
						break;
					}
				}
			}
			tempList.add(outPatientId);
			tempList.add(inHospitalId);
			tempList.add(tempObj[7].toString());
			tempList.add(tempObj[8].toString());
			tempList.add(consumerId.toString());
			tempList.add(address);
			tempList.add(phone);

			returnList.add(tempList);

		}

		return returnList;

	}

	public List<List<String>> getWsFilledProject(String officeId) {

		String currentDateString = DateUtil.getCurrentDateString();
		List<Object[]> list = czGiveWsService.getCzdisposeByStatusAndTime(null, currentDateString, currentDateString, officeId);

		if (list.size() < 1)
			return Collections.EMPTY_LIST;
		List<Long> consumerIds = new ArrayList<Long>();
		List<Long> osstuffIds = new ArrayList<Long>();
		List<Integer> osUFormIds = new ArrayList<Integer>();

		for (Object[] temp : list) {
			osUFormIds.add(Integer.parseInt(temp[0].toString()));
			consumerIds.add(Long.parseLong(temp[2].toString()));
			osstuffIds.add(Long.parseLong(temp[1].toString()));
		}

		List<Osuform> osuforms = osGiveSfService.getOsuformsByIds(osUFormIds);
		List<Csconsumer> csconsumers = null;
		if (null != consumerIds && consumerIds.size() > 0)
			csconsumers = csconsumerService.getByIds(consumerIds);
		List<Osstuff> osstuffs = null;
		if (null != osstuffIds && osstuffIds.size() > 0)
			osstuffs = osGiveSfService.getByIds(osstuffIds);

		List<List<String>> returnList = new ArrayList<List<String>>();
		List<String> tempList = null;
		String applicationOffice = "";
		String applicationDoctor = "";
		String consumerName = "";
		String sex = "";
		int age = 0;
		String outPatientId = "";
		String inHospitalId = "";
		Long consumerId = 0l;
		String address = "";
		String phone = "";
		String atOffice = "";

		// 拼音简码
		// String spellName = "";
		WsidocW wsidocW = null;
		for (Object[] tempObj : list) {

			wsidocW = wsidocWDao.findByKindId(tempObj[7].toString());
			// 判断是否已经完成的文书
			if (null == wsidocW || null == wsidocW.getStatus() || !wsidocW.getStatus().equals("已完成")) {
				continue;
			}

			tempList = new ArrayList<String>();

			for (Osuform osuform : osuforms) {
				if (osuform.getUid().intValue() == Integer.parseInt(tempObj[0].toString())) {
					applicationOffice = osuform.getUname();
					break;
				}
			}

			Osuform osuform = osGiveSfService.getUFormById(wsidocW.getDneu());

			atOffice = osuform.getUname();

			for (Osstuff osstuff : osstuffs) {
				if (osstuff.getSid().longValue() == Long.parseLong(tempObj[1].toString())) {
					applicationDoctor = osstuff.getSname();
					break;
				}
			}
			for (Csconsumer csconsumer : csconsumers) {
				if (csconsumer.getCsId().longValue() == Long.parseLong(tempObj[2].toString())) {
					consumerId = csconsumer.getCsId().longValue();
					consumerName = csconsumer.getCsname();
					sex = csconsumer.getSex();
					age = DateUtil.getBetweenYears(DateUtil.getCurrentDateTime(), csconsumer.getBirthday());
					// spellName = csconsumer.getNameForShort();
					address = csconsumer.getAddress();
					phone = csconsumer.getTelephone();
					break;
				}
			}
			tempList.add(wsidocW.getDocNum());
			tempList.add(atOffice);
			tempList.add(wsidocW.getDocStorage());
			tempList.add(applicationOffice);
			tempList.add(applicationDoctor);
			tempList.add(consumerName);
			tempList.add(sex);
			tempList.add(String.valueOf(age));
			tempList.add(tempObj[3].toString());
			tempList.add(tempObj[4].toString());
			tempList.add(tempObj[7].toString());
			tempList.add(tempObj[8].toString());
			tempList.add(consumerId.toString());
			returnList.add(tempList);

		}

		return returnList;

	}

	public List<List<String>> getWsFilledProject(String value, Boolean isSpell, String startTime, String endTime,
			String archivesNO, String projectName, String atOfficeNO, String atOfficePostion, String officeId) {

		List<Object[]> list = czGiveWsService.getCzdisposeByStatusAndTime(null, startTime, endTime, officeId);

		if (list.size() < 1)
			return Collections.EMPTY_LIST;
		List<Long> consumerIds = new ArrayList<Long>();
		List<Long> osstuffIds = new ArrayList<Long>();
		List<Integer> osUFormIds = new ArrayList<Integer>();

		for (Object[] temp : list) {
			osUFormIds.add(Integer.parseInt(temp[0].toString()));
			consumerIds.add(Long.parseLong(temp[2].toString()));
			osstuffIds.add(Long.parseLong(temp[1].toString()));
		}

		List<Osuform> osuforms = osGiveSfService.getOsuformsByIds(osUFormIds);
		List<Csconsumer> csconsumers = null;
		if (null != consumerIds && consumerIds.size() > 0)
			csconsumers = csconsumerService.getByIds(consumerIds);
		List<Osstuff> osstuffs = null;
		if (null != osstuffIds && osstuffIds.size() > 0)
			osstuffs = osGiveSfService.getByIds(osstuffIds);

		List<List<String>> returnList = new ArrayList<List<String>>();
		List<String> tempList = null;
		String applicationOffice = "";
		String applicationDoctor = "";
		String consumerName = "";
		String sex = "";
		int age = 0;
		String outPatientId = "";
		String inHospitalId = "";
		Long consumerId = 0l;
		String address = "";
		String phone = "";
		String atOffice = "";

		// 拼音简码
		String spellName = "";
		boolean isContinue = true;
		WsidocW wsidocW = null;
		for (Object[] tempObj : list) {

			wsidocW = wsidocWDao.findByKindId(tempObj[7].toString());
			// 判断是否已经完成的文书
			if (null == wsidocW || null == wsidocW.getStatus() || !wsidocW.getStatus().equals("已完成")) {
				continue;
			}
			for (Csconsumer csconsumer : csconsumers) {
				if (csconsumer.getCsId().longValue() == Long.parseLong(tempObj[2].toString())) {
					consumerId = csconsumer.getCsId().longValue();
					consumerName = csconsumer.getCsname();
					sex = csconsumer.getSex();
					age = DateUtil.getBetweenYears(DateUtil.getCurrentDateTime(), csconsumer.getBirthday());
					spellName = csconsumer.getNameForShort();
					address = csconsumer.getAddress();
					phone = csconsumer.getTelephone();
					break;
				}
			}
			// 条件过滤服务对象的名称
			if (null != value && !"".equals(value)) {
				if (isSpell) {
					if (spellName.toUpperCase().startsWith(value.toUpperCase()))
						isContinue = true;
					else
						isContinue = false;
				}

				if (!isSpell) {
					if (consumerName.startsWith(value))
						isContinue = true;
					else
						isContinue = false;
				}
			}

			if (!isContinue)
				continue;

			isContinue = true;

			if (null != archivesNO && !"".equals(archivesNO.trim())) {
				if (!archivesNO.trim().toUpperCase().equals(wsidocW.getDocNum().toUpperCase())) {
					continue;
				}
			}

			if (!"所有项目".equals(projectName) && !projectName.equals(tempObj[4].toString())) {
				continue;
			}

			if (!"0".equals(atOfficeNO) && Integer.parseInt(atOfficeNO) != wsidocW.getDneu().intValue()) {
				continue;
			}

			if (!"所有位置".equals(atOfficePostion) && !atOfficePostion.equals(wsidocW.getDocStorage())) {
				continue;
			}

			Osuform osuform1 = osGiveSfService.getUFormById(wsidocW.getDneu());
			if (null != osuform1)
				atOffice = osuform1.getUname();
			tempList = new ArrayList<String>();

			for (Osuform osuform : osuforms) {
				if (osuform.getUid().intValue() == Integer.parseInt(tempObj[0].toString())) {
					applicationOffice = osuform.getUname();
					break;
				}
			}

			for (Osstuff osstuff : osstuffs) {
				if (osstuff.getSid().longValue() == Long.parseLong(tempObj[1].toString())) {
					applicationDoctor = osstuff.getSname();
					break;
				}
			}

			tempList.add(wsidocW.getDocNum());
			tempList.add(atOffice);
			tempList.add(wsidocW.getDocStorage());
			tempList.add(applicationOffice);
			tempList.add(applicationDoctor);
			tempList.add(consumerName);
			tempList.add(sex);
			tempList.add(String.valueOf(age));
			tempList.add(tempObj[3].toString());
			tempList.add(tempObj[4].toString());
			tempList.add(tempObj[7].toString());
			tempList.add(tempObj[8].toString());
			tempList.add(consumerId.toString());
			returnList.add(tempList);

		}

		return returnList;

	}

	public void setCzGiveWsService(CzGiveWsService czGiveWsService) {
		this.czGiveWsService = czGiveWsService;
	}

	public void setCsconsumerService(CsconsumerService csconsumerService) {
		this.csconsumerService = csconsumerService;
	}

	public void setOsGiveSfService(OsGiveSfService osGiveSfService) {
		this.osGiveSfService = osGiveSfService;
	}

	public void setZyGiveSfService(ZyGiveSfService zyGiveSfService) {
		this.zyGiveSfService = zyGiveSfService;
	}

	public void setMzGiveSfService(MzGiveSfService mzGiveSfService) {
		this.mzGiveSfService = mzGiveSfService;
	}

	public void setCfwholeDisposeService(CfwholeDisposeService cfwholeDisposeService) {
		this.cfwholeDisposeService = cfwholeDisposeService;
	}

	private WsidocWDao wsidocWDao;

	public WsidocW getWsidocWByKindId(String projectId) {

		List<WsidocW> list = wsidocWDao.getScrollData("o.kindId=?", projectId);
		return list.size() > 0 ? list.get(0) : null;
	}

	public void setWsidocWDao(WsidocWDao wsidocWDao) {
		this.wsidocWDao = wsidocWDao;
	}

	private WsDocumentDao wsDocumentDao;
	private WsdocWDao wsdocWDao;

	public List<List<String>> getWsdocByDocWriteId(Long docWriteId) {
		return wsDocumentDao.getWsdocByDocWriteId(docWriteId);
	}

	public Long addDocWrite(WsidocW wsidocW, List<Long> documentIds) {
		wsidocW.setDneu(-1);
		wsidocW.setPeriodOfKeep(-1);
		wsidocWDao.save(wsidocW);
		WsdocW wsdocW = null;
		List<WsdocW> list = new ArrayList<WsdocW>();
		for (int i = 0; i < documentIds.size(); i++) {
			wsdocW = new WsdocW();
			wsdocW.setDocId(documentIds.get(i));
			wsdocW.setItemDocWid(wsidocW.getItemDocWid());
			wsdocW.setWsorder(i + 1);
			wsdocW.setWstatus("未填写");

			list.add(wsdocW);
		}
		wsdocWDao.save(list);
		return wsidocW.getItemDocWid();
	}

	public void setWsdocWDao(WsdocWDao wsdocWDao) {
		this.wsdocWDao = wsdocWDao;
	}

	public void setWsDocumentDao(WsDocumentDao wsDocumentDao) {
		this.wsDocumentDao = wsDocumentDao;
	}

	public void deleteAndAddWsDocW(Long itemDocWID, Integer wsOrder, List<Long> documentIds) {
		WsidocW wsidocW = wsidocWDao.find(itemDocWID);

		wsdocWDao.deleteByItemDocWIdAndWsOrder(itemDocWID, wsOrder, "未填写");
		// List<Long> ids = new ArrayList<Long>();
		// WsdocW wsdoW = null;
		// for (int i = 0; i < documentIds.size(); i++) {
		// wsdoW = wsdocWDao.getByWsdocIdAndItemDocWID(documentIds.get(i), itemDocWID);
		// if (null == wsdoW)
		// ids.add(documentIds.get(i));
		// else if("未填写".equals(wsdoW.getWstatus())){
		// ids.add(documentIds.get(i));
		// wsdocWDao.deleteObject(wsdoW);
		// }
		// }

		WsdocW wsdocW = null;
		List<WsdocW> list = new ArrayList<WsdocW>();
		for (int i = 0; i < documentIds.size(); i++) {
			wsdocW = new WsdocW();
			wsdocW.setDocId(documentIds.get(i));
			wsdocW.setItemDocWid(wsidocW.getItemDocWid());
			wsdocW.setWsorder(wsOrder++);
			wsdocW.setWstatus("未填写");
			list.add(wsdocW);
		}
		wsdocWDao.save(list);

		List<WsdocW> list1 = wsdocWDao.getScrollData("o.wstatus=? or o.wstatus=? and o.itemDocWid=?", new Object[] { "未填写", "暂存",
				itemDocWID });

		if (list1.size() < 0) {// 如果编辑完文书以后，如果不存在 未填写和暂存的文书，则修改 WSIDocW（项目文书填写*）的状态为已完成
			wsidocWDao.find(itemDocWID).setStatus("已完成");
		}

	}

	private WsDocW1Dao wsDocW1Dao;

	public void setWsDocW1Dao(WsDocW1Dao wsDocW1Dao) {
		this.wsDocW1Dao = wsDocW1Dao;
	}

	public void updateWSIDocW(WsidocW wsidocW) {
		wsidocWDao.update(wsidocW);
	}

	public void addWsDocW1(WsdocW1 wsdocW1, Long itemDocWid, String writeStatus) {

		// 先找到 由 文书ID和项目文书填写ID确定唯一的文书填写记录
		WsdocW wsdocW = wsdocWDao.getByWsdocIdAndItemDocWID(wsdocW1.getDocId(), itemDocWid);
		wsdocW1.setDocWID(wsdocW.getDocWid());
		List<WsdocW1> list = wsDocW1Dao.getWsDocW1ByDocWid(wsdocW1.getDocWID());
		// 说明没有文书填写*记录
		if (writeStatus.equals("暂存")) {
			if (list.size() < 1) {
				// 暂存时候 的添加操作
				wsDocW1Dao.save(wsdocW1);
			} else {// 大于第一次的暂存
				list.get(0).setWscontent(wsdocW1.getWscontent());
				wsDocW1Dao.update(list.get(0));
			}
		}

		if (writeStatus.equals("已完成")) {
			if (list.size() < 1) {// 直接提交，之前没有时行保存的操作
				wsDocW1Dao.save(wsdocW1);
			} else if (list.size() == 1 && wsdocW.getWstatus().equals("暂存")) {
				list.get(0).setWscontent(wsdocW1.getWscontent());
				wsDocW1Dao.update(list.get(0));
			} else {
				wsdocW1.setMdocId(list.get(list.size() - 1).getWid());
				wsDocW1Dao.save(wsdocW1);
			}

			Integer orderNO = wsdocWDao.getMaxOrderNO(itemDocWid);
			// 如果当前提交 的是最后一个文书 ，则修改 WSIDocW（项目文书填写*）的状态为已完成
			if (orderNO.intValue() == wsdocW.getWsorder().intValue()) {
				wsidocWDao.find(itemDocWid).setStatus("已完成");
			}
		}
		// 修改文书填写 的状态
		wsdocW.setWstatus(writeStatus);

	}

	public List<WsdocW1> getWsDocW1(Long lastDocId, Long docId, Long itemDocWid) {

		// 先找到 由 文书ID和项目文书填写ID确定唯一的文书填写记录
		WsdocW wsdocW = wsdocWDao.getByWsdocIdAndItemDocWID(docId, itemDocWid);
		WsdocW lastWsdocW = null;
		if (-1l != lastDocId)
			lastWsdocW = wsdocWDao.getByWsdocIdAndItemDocWID(lastDocId, itemDocWid);

		WsdocW1 wsdocW1 = null;
		WsdocW1 lastWsdocW1 = null;
		List<WsdocW1> list = null;
		List<WsdocW1> returnList = new ArrayList<WsdocW1>();

		// 还没有填写任何文书
		if (null != wsdocW) {
			list = wsDocW1Dao.getWsDocW1ByDocWid(wsdocW.getDocWid());
			if (list.size() > 0) {
				// WsdocW1的备注字段 临时 当成 当前选择的文书的填写状态使用，方便传送到前台
				list.get(list.size() - 1).setNote(wsdocW.getWstatus());
				wsdocW1 = list.get(list.size() - 1);
			}
		}

		// 上一个文书的状态
		if (null != lastWsdocW) {
			list = wsDocW1Dao.getWsDocW1ByDocWid(lastWsdocW.getDocWid());
			if (list.size() > 0) {
				// WsdocW1的备注字段 临时 当成 当前选择的文书的填写状态使用，方便传送到前台
				list.get(list.size() - 1).setNote(lastWsdocW.getWstatus());
				lastWsdocW1 = list.get(list.size() - 1);
			}
		}
		returnList.add(wsdocW1);
		returnList.add(lastWsdocW1);
		return returnList;

	}

	// public void setCsGiveSfService(CsGiveSfService csGiveSfService) {
	// this.csGiveSfService = csGiveSfService;
	// }

	public WsdocW getByWsdocIdAndItemDocWID(Long docId, Long itemDocWid) {
		// 先找到 由 文书ID和项目文书填写ID确定唯一的文书填写记录
		return wsdocWDao.getByWsdocIdAndItemDocWID(docId, itemDocWid);

	}

	public WsvisitRemind getWsvisitRemindById(Long id) {
		return wsVisitRemindDao.find(id);
	}

	public void addWsvisitRemind(WsvisitRemind wsvisitRemind) {

		wsVisitRemindDao.save(wsvisitRemind);
	}

	// public void updateWsvisitRemind(Long id, WsvisitRemind wsvisitRemind) {
	// WsvisitRemind tempObj = wsVisitRemindDao.find(id);
	// BeanUtils.copyProperties(wsvisitRemind, tempObj, new String[] { "docWid" });
	// wsVisitRemindDao.update(tempObj);
	//
	// }
	public void updateWsvisitRemind(WsvisitRemind wsvisitRemind) {
		wsVisitRemindDao.update(wsvisitRemind);
	}

}
