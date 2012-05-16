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
 * 诊断、处置、处方模板Service实现
 * 
 * @author Administrator
 * 
 */
public class CfdhpmodelServiceImpl implements CfdhpmodelService {
	CfdhpmodelDao cfdDao = null; // 模板Dao
	CfmdetailDao cfmDao = null; // 药品细节Dao
	CfhandleItemDetailDao cfhDao = null; // 处置细节Dao

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
	 * 方法提取 负责添加模板，药品细节和处置细节。
	 * 
	 * @param cfd
	 * @param mid
	 * @param unit
	 * @param quantity
	 * @param handleItemID
	 */
	private void addDhpmodel(Cfdhpmodel cfd, List<Cfmdetail> cfmList,
			List<CfhandleItemDetail> cfhList) {
		// 添加模板
		cfdDao.addCfdhpmodel(cfd);
		// 查询新添加模板的ID
		Long modelId = cfdDao.getNewAddModelId();
		// 添加药品细节
		for (int i = 0; i < cfmList.size(); i++) {
			Cfmdetail cfm = cfmList.get(i);
			cfm.setModelId(Integer.parseInt(modelId.toString()));
			cfmDao.addCfmdetail(cfm);
		}
		// 添加处置细节
		for (int i = 0; i < cfhList.size(); i++) {
			CfhandleItemDetail cfh = cfhList.get(i);
			cfh.setModelId(Integer.parseInt(modelId.toString()));
			cfhDao.addCfhandleItemDetail(cfh);
		}
	}

	/**
	 * 添加诊断、处置、处方模板 功能详述： 此方法是先添加模板，然后查询新添加模板的ID。 用查处的模板ID分别添加药品细节和处置细节。
	 */
	public boolean addCfdhpmodel(Cfdhpmodel cfd, List<Cfmdetail> cfmList,
			List<CfhandleItemDetail> cfhList) {
		try {
			// 如果父节点ID没有值，则新创建模板时，父节点id等于模板id
			if (null == cfd.getFatherId()) {
				addDhpmodel(cfd, cfmList, cfhList); // 调用抽取出的方法添加模板、药品细节和处置细节
				Long modelId = cfdDao.getNewAddModelId(); // 找到刚添加模板的ID
				cfd = cfdDao.getCfdhpmodelByModelId(modelId); // 根据找到的ID查询出模板
				cfd.setFatherId(modelId); // 修改父节点ID等于模板ID
				cfdDao.updateFactherID(cfd); // 修改数据
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
	 * 公有模板设置 根据父节点ID查询所有模板
	 */
	public List<Cfdhpmodel> getCfdhpmodelByFactherId(Long factherId) {
		// TODO Auto-generated method stub
		return cfdDao.getCfdhpmodelByFactherId(factherId);
	}

	/**
	 * 私有模板设置 根据父节点ID查询所有模板
	 */
	public List<Cfdhpmodel> getCfdhpmodelByFactherId(Long factherId, Long ower) {
		// TODO Auto-generated method stub
		return cfdDao.getCfdhpmodelByFactherId(factherId, ower);
	}

	/**
	 * 查询父节点ID和模板ID一样的父节点
	 */
	public List<Long> getFactherModelIdEqFactherID() {
		// TODO Auto-generated method stub
		return cfdDao.getFactherModelIdEqFactherID();
	}

	/**
	 * 重载查询父节点ID和模板ID一样的父节点
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
	 * 根据模板Id删除模板
	 */
	public boolean delCfdhpmodelByModelId(Long modelId) {
		try {
			// 删除药品细节
			cfmDao.delCfmdetailByModelID(modelId);
			// 删除处置细节
			cfhDao.delCfhandleItemDetailByModelId(modelId);
			// 删除模板
			cfdDao.delCfdhpmodelByModelId(modelId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 以模板Id作为父节点Id查询模板记录数
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
	 * 根据模板ID查询处置细节
	 */
	public List<CfhandleItemDetail> getCfhandleItemDetailByModelId(Long modelId) {
		// TODO Auto-generated method stub
		return cfhDao.getCfhandleItemDetailByModelId(modelId);
	}

	/**
	 * 根据模板id查询药品细节
	 */
	public List<Cfmdetail> getCfmdetailByModelId(Long modelId) {
		// TODO Auto-generated method stub
		return cfmDao.getCfmdetailByModelId(modelId);
	}

	/**
	 * 根据模板ID查询模板
	 */
	public Cfdhpmodel getCfdhpmodelByModelId(Long modelId) {
		// TODO Auto-generated method stub
		return cfdDao.getCfdhpmodelByModelId(modelId);
	}

	/**
	 * 根据项目类型Id查询处置项目
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(
			Integer itemId) {
		return cfhDao.getCzdisposeItemDescribeByitemTypeId(itemId);
	}

	/**
	 * 添加处置细节
	 */
	public boolean addCfhandleItemDetail(CfhandleItemDetail cfh) {
		// TODO Auto-generated method stub
		return cfhDao.addCfhandleItemDetail(cfh);
	}

	/**
	 * 删除药品细节
	 */
	public boolean delCfhandleItemDetail(Long itemId) {
		// TODO Auto-generated method stub
		return cfhDao.delCfhandleItemDetailByItemId(itemId);
	}

	/**
	 * 添加药品细节
	 */
	public boolean addCfmdetail(Cfmdetail cfm) {
		// TODO Auto-generated method stub
		return cfmDao.addCfmdetail(cfm);
	}

	/**
	 * 删除药品细节
	 */
	public boolean delCfmdetail(Long iid) {
		// TODO Auto-generated method stub
		return cfmDao.delCfmdetailByiid(iid);
	}

	/**
	 * 获取药品细节最大id
	 */
	public Long getMaxIid() {
		// TODO Auto-generated method stub
		return cfmDao.getMaxIid();
	}

	/**
	 * 获取最大处置细节Id
	 */
	public Long getMaxItemId() {
		// TODO Auto-generated method stub
		return cfhDao.getMaxItemId();
	}

	/**
	 * 添加模板类型
	 */
	public boolean addCfdhpmodelType(Cfdhpmodel cfd) {
		try {
			// 增加模板类型
			cfdDao.addCfdhpmodel(cfd);
			// 获取新增模板的ID
			long factherID = cfdDao.getNewAddModelId();
			cfd = cfdDao.getCfdhpmodelByModelId(factherID);
			cfd.setFatherId(factherID);
			// 修改父节点ID为新增模板ID
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
	 * 删除模板类型
	 */
	public boolean delCfdhpmodelType(Long factherId) {
		// TODO Auto-generated method stub
		return cfdDao.delCfdhpmodelType(factherId);
	}

	/**
	 * 查询模板是否存在
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
