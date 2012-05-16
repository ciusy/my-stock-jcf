package leo.cf.service.impl;

import java.util.List;

import leo.cf.dao.iface.CfdhpmodelDao;
import leo.cf.dao.iface.CfhandleItemDetailDao;
import leo.cf.dao.iface.CfmdetailDao;
import leo.cf.service.iface.CfdhpmodelService;
import leo.entity.Cfdhpmodel;
import leo.entity.CfhandleItemDetail;
import leo.entity.Cfmdetail;
import leo.entity.CzdisposeItemDescribe;

/**
 * ��ϡ����á�����ģ��Serviceʵ��
 * 
 * @author Administrator
 * 
 */
public class CfdhpmodelServiceImpl implements CfdhpmodelService {
	CfdhpmodelDao cfdDao = null; // ģ��Dao
	CfmdetailDao cfmDao = null; // ҩƷϸ��Dao
	CfhandleItemDetailDao cfhDao = null; // ����ϸ��Dao

	public void setCfdDao(CfdhpmodelDao cfdDao) {
		this.cfdDao = cfdDao;
	}

	public void setCfmDao(CfmdetailDao cfmDao) {
		this.cfmDao = cfmDao;
	}

	public void setCfhDao(CfhandleItemDetailDao cfhDao) {
		this.cfhDao = cfhDao;
	}

	/**
	 * ������ȡ �������ģ�壬ҩƷϸ�ںʹ���ϸ�ڡ�
	 * 
	 * @param cfd
	 * @param mid
	 * @param unit
	 * @param quantity
	 * @param handleItemID
	 */
	private void addDhpmodel(Cfdhpmodel cfd, List<Cfmdetail> cfmList,
			List<CfhandleItemDetail> cfhList) {
		// ���ģ��
		cfdDao.addCfdhpmodel(cfd);
		// ��ѯ�����ģ���ID
		Long modelId = cfdDao.getNewAddModelId();
		// ���ҩƷϸ��
		for (int i = 0; i < cfmList.size(); i++) {
			Cfmdetail cfm = cfmList.get(i);
			cfm.setModelId(Integer.parseInt(modelId.toString()));
			cfmDao.addCfmdetail(cfm);
		}
		// ��Ӵ���ϸ��
		for (int i = 0; i < cfhList.size(); i++) {
			CfhandleItemDetail cfh = cfhList.get(i);
			cfh.setModelId(Integer.parseInt(modelId.toString()));
			cfhDao.addCfhandleItemDetail(cfh);
		}
	}

	/**
	 * �����ϡ����á�����ģ�� ���������� �˷����������ģ�壬Ȼ���ѯ�����ģ���ID�� �ò鴦��ģ��ID�ֱ����ҩƷϸ�ںʹ���ϸ�ڡ�
	 */
	public boolean addCfdhpmodel(Cfdhpmodel cfd, List<Cfmdetail> cfmList,
			List<CfhandleItemDetail> cfhList) {
		try {
			// ������ڵ�IDû��ֵ�����´���ģ��ʱ�����ڵ�id����ģ��id
			if (null == cfd.getFatherId()) {
				addDhpmodel(cfd, cfmList, cfhList); // ���ó�ȡ���ķ������ģ�塢ҩƷϸ�ںʹ���ϸ��
				Long modelId = cfdDao.getNewAddModelId(); // �ҵ������ģ���ID
				cfd = cfdDao.getCfdhpmodelByModelId(modelId); // �����ҵ���ID��ѯ��ģ��
				cfd.setFatherId(modelId); // �޸ĸ��ڵ�ID����ģ��ID
				cfdDao.updateFactherID(cfd); // �޸�����
			} else {
				addDhpmodel(cfd, cfmList, cfhList);
			}
			return true;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ����ģ������ ���ݸ��ڵ�ID��ѯ����ģ��
	 */
	public List<Cfdhpmodel> getCfdhpmodelByFactherId(Long factherId) {
		// TODO Auto-generated method stub
		return cfdDao.getCfdhpmodelByFactherId(factherId);
	}

	/**
	 * ˽��ģ������ ���ݸ��ڵ�ID��ѯ����ģ��
	 */
	public List<Cfdhpmodel> getCfdhpmodelByFactherId(Long factherId, Long ower) {
		// TODO Auto-generated method stub
		return cfdDao.getCfdhpmodelByFactherId(factherId, ower);
	}

	/**
	 * ��ѯ���ڵ�ID��ģ��IDһ���ĸ��ڵ�
	 */
	public List<Long> getFactherModelIdEqFactherID() {
		// TODO Auto-generated method stub
		return cfdDao.getFactherModelIdEqFactherID();
	}

	/**
	 * ���ز�ѯ���ڵ�ID��ģ��IDһ���ĸ��ڵ�
	 */
	public boolean getFactherModelIdEqFactherID(Integer factherId) {
		// TODO Auto-generated method stub
		try {
			List<Cfdhpmodel> list = cfdDao
					.getFactherModelIdEqFactherID(factherId);
			Cfdhpmodel cfd = list.get(0);
			if (Integer.parseInt(cfd.getModelId().toString()) == Integer
					.parseInt(cfd.getFatherId().toString())) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ����ģ��Idɾ��ģ��
	 */
	public boolean delCfdhpmodelByModelId(Long modelId) {
		try {
			// ɾ��ҩƷϸ��
			cfmDao.delCfmdetailByModelID(modelId);
			// ɾ������ϸ��
			cfhDao.delCfhandleItemDetailByModelId(modelId);
			// ɾ��ģ��
			cfdDao.delCfdhpmodelByModelId(modelId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ��ģ��Id��Ϊ���ڵ�Id��ѯģ���¼��
	 * 
	 * @param modelId
	 * @return
	 */
	public boolean getCountByModelId(Long modelId) {
		// TODO Auto-generated method stub
		int count = cfdDao.getCountByModelId(modelId);
		if (count > 1) {
			return true;
		}
		return false;
	}

	/**
	 * ����ģ��ID��ѯ����ϸ��
	 */
	public List<CfhandleItemDetail> getCfhandleItemDetailByModelId(Long modelId) {
		// TODO Auto-generated method stub
		return cfhDao.getCfhandleItemDetailByModelId(modelId);
	}

	/**
	 * ����ģ��id��ѯҩƷϸ��
	 */
	public List<Cfmdetail> getCfmdetailByModelId(Long modelId) {
		// TODO Auto-generated method stub
		return cfmDao.getCfmdetailByModelId(modelId);
	}

	/**
	 * ����ģ��ID��ѯģ��
	 */
	public Cfdhpmodel getCfdhpmodelByModelId(Long modelId) {
		// TODO Auto-generated method stub
		return cfdDao.getCfdhpmodelByModelId(modelId);
	}

	/**
	 * ������Ŀ����Id��ѯ������Ŀ
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(
			Integer itemId) {
		return cfhDao.getCzdisposeItemDescribeByitemTypeId(itemId);
	}

	/**
	 * ��Ӵ���ϸ��
	 */
	public boolean addCfhandleItemDetail(CfhandleItemDetail cfh) {
		// TODO Auto-generated method stub
		return cfhDao.addCfhandleItemDetail(cfh);
	}

	/**
	 * ɾ��ҩƷϸ��
	 */
	public boolean delCfhandleItemDetail(Long itemId) {
		// TODO Auto-generated method stub
		return cfhDao.delCfhandleItemDetailByItemId(itemId);
	}

	/**
	 * ���ҩƷϸ��
	 */
	public boolean addCfmdetail(Cfmdetail cfm) {
		// TODO Auto-generated method stub
		return cfmDao.addCfmdetail(cfm);
	}

	/**
	 * ɾ��ҩƷϸ��
	 */
	public boolean delCfmdetail(Long iid) {
		// TODO Auto-generated method stub
		return cfmDao.delCfmdetailByiid(iid);
	}

	/**
	 * ��ȡҩƷϸ�����id
	 */
	public Long getMaxIid() {
		// TODO Auto-generated method stub
		return cfmDao.getMaxIid();
	}

	/**
	 * ��ȡ�����ϸ��Id
	 */
	public Long getMaxItemId() {
		// TODO Auto-generated method stub
		return cfhDao.getMaxItemId();
	}

	/**
	 * ���ģ������
	 */
	public boolean addCfdhpmodelType(Cfdhpmodel cfd) {
		try {
			// ����ģ������
			cfdDao.addCfdhpmodel(cfd);
			// ��ȡ����ģ���ID
			long factherID = cfdDao.getNewAddModelId();
			cfd = cfdDao.getCfdhpmodelByModelId(factherID);
			cfd.setFatherId(factherID);
			// �޸ĸ��ڵ�IDΪ����ģ��ID
			cfdDao.updateFactherID(cfd);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

	public List<Cfdhpmodel> getCfdhpmodelType(String ower) {
		// TODO Auto-generated method stub
		return cfdDao.getCfdhpmodelType(ower);
	}

	/**
	 * ɾ��ģ������
	 */
	public boolean delCfdhpmodelType(Long factherId) {
		// TODO Auto-generated method stub
		return cfdDao.delCfdhpmodelType(factherId);
	}

	/**
	 * ��ѯģ���Ƿ����
	 */
	public boolean getCfdhpmodelByName(String modelName) {
		// TODO Auto-generated method stub
		return cfdDao.getCfdhpmodelByName(modelName);
	}

	public boolean getCfdhpmodelTypeByName(String modelName, String ower) {
		// TODO Auto-generated method stub
		return cfdDao.getCfdhpmodelTypeByName(modelName, ower);
	}
}
